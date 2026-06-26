package androidx.media2.session;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.media.app.NotificationCompat;
import androidx.media2.common.MediaMetadata;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionService;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaNotificationHandler extends MediaSession.SessionCallback.ForegroundServiceEventCallback {
    private static final String NOTIFICATION_CHANNEL_ID = "default_channel_id";
    private static final int NOTIFICATION_ID = 1001;
    private final String mNotificationChannelName;
    private final NotificationManager mNotificationManager;
    private final MediaSessionService mServiceInstance;
    private final Intent mStartSelfIntent;
    private final NotificationCompat.Action mPlayAction = createNotificationAction(R.drawable.media_session_service_notification_ic_play, R.string.play_button_content_description, 4);
    private final NotificationCompat.Action mPauseAction = createNotificationAction(R.drawable.media_session_service_notification_ic_pause, R.string.pause_button_content_description, 2);
    private final NotificationCompat.Action mSkipToPrevAction = createNotificationAction(R.drawable.media_session_service_notification_ic_skip_to_previous, R.string.skip_to_previous_item_button_content_description, 16);
    private final NotificationCompat.Action mSkipToNextAction = createNotificationAction(R.drawable.media_session_service_notification_ic_skip_to_next, R.string.skip_to_next_item_button_content_description, 32);

    public MediaNotificationHandler(MediaSessionService mediaSessionService) {
        this.mServiceInstance = mediaSessionService;
        this.mStartSelfIntent = new Intent(mediaSessionService, mediaSessionService.getClass());
        this.mNotificationManager = (NotificationManager) mediaSessionService.getSystemService("notification");
        this.mNotificationChannelName = mediaSessionService.getResources().getString(R.string.default_notification_channel_name);
    }

    private NotificationCompat.Action createNotificationAction(int i2, int i3, long j2) {
        return new NotificationCompat.Action(i2, this.mServiceInstance.getResources().getText(i3), createPendingIntent(j2));
    }

    private PendingIntent createPendingIntent(long j2) {
        int keyCode = PlaybackStateCompat.toKeyCode(j2);
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        MediaSessionService mediaSessionService = this.mServiceInstance;
        intent.setComponent(new ComponentName(mediaSessionService, mediaSessionService.getClass()));
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, keyCode));
        return (Build.VERSION.SDK_INT < 26 || j2 == 2) ? PendingIntent.getService(this.mServiceInstance, keyCode, intent, 0) : PendingIntent.getForegroundService(this.mServiceInstance, keyCode, intent, 0);
    }

    private void ensureNotificationChannel() {
        if (Build.VERSION.SDK_INT < 26 || this.mNotificationManager.getNotificationChannel(NOTIFICATION_CHANNEL_ID) != null) {
            return;
        }
        this.mNotificationManager.createNotificationChannel(new NotificationChannel(NOTIFICATION_CHANNEL_ID, this.mNotificationChannelName, 2));
    }

    private int getSmallIconResId() {
        int i2 = this.mServiceInstance.getApplicationInfo().icon;
        return i2 != 0 ? i2 : R.drawable.media_session_service_notification_ic_music_note;
    }

    public static boolean isPlaybackStopped(int i2) {
        return i2 == 1 || i2 == 0 || i2 == 3;
    }

    private void stopForegroundServiceIfNeeded() {
        List<MediaSession> sessions = this.mServiceInstance.getSessions();
        for (int i2 = 0; i2 < sessions.size(); i2++) {
            if (!isPlaybackStopped(sessions.get(i2).getPlayer().getPlayerState())) {
                return;
            }
        }
        this.mServiceInstance.stopForeground(false);
    }

    @Override // androidx.media2.session.MediaSession.SessionCallback.ForegroundServiceEventCallback
    public void onNotificationUpdateNeeded(MediaSession mediaSession) {
        MediaSessionService.MediaNotification mediaNotificationOnUpdateNotification = this.mServiceInstance.onUpdateNotification(mediaSession);
        if (mediaNotificationOnUpdateNotification == null) {
            return;
        }
        int notificationId = mediaNotificationOnUpdateNotification.getNotificationId();
        Notification notification = mediaNotificationOnUpdateNotification.getNotification();
        notification.extras.putParcelable(NotificationCompat.EXTRA_MEDIA_SESSION, (MediaSession.Token) mediaSession.getSessionCompat().getSessionToken().getToken());
        this.mNotificationManager.notify(notificationId, notification);
    }

    @Override // androidx.media2.session.MediaSession.SessionCallback.ForegroundServiceEventCallback
    public void onPlayerStateChanged(MediaSession mediaSession, int i2) {
        MediaSessionService.MediaNotification mediaNotificationOnUpdateNotification = this.mServiceInstance.onUpdateNotification(mediaSession);
        if (mediaNotificationOnUpdateNotification == null) {
            return;
        }
        int notificationId = mediaNotificationOnUpdateNotification.getNotificationId();
        Notification notification = mediaNotificationOnUpdateNotification.getNotification();
        notification.extras.putParcelable(NotificationCompat.EXTRA_MEDIA_SESSION, (MediaSession.Token) mediaSession.getSessionCompat().getSessionToken().getToken());
        if (isPlaybackStopped(i2)) {
            stopForegroundServiceIfNeeded();
            this.mNotificationManager.notify(notificationId, notification);
        } else {
            ContextCompat.startForegroundService(this.mServiceInstance, this.mStartSelfIntent);
            this.mServiceInstance.startForeground(notificationId, notification);
        }
    }

    @Override // androidx.media2.session.MediaSession.SessionCallback.ForegroundServiceEventCallback
    public void onSessionClosed(MediaSession mediaSession) {
        this.mServiceInstance.removeSession(mediaSession);
        stopForegroundServiceIfNeeded();
    }

    public MediaSessionService.MediaNotification onUpdateNotification(MediaSession mediaSession) {
        MediaMetadata metadata;
        ensureNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.mServiceInstance, NOTIFICATION_CHANNEL_ID);
        builder.addAction(this.mSkipToPrevAction);
        if (mediaSession.getPlayer().getPlayerState() == 2) {
            builder.addAction(this.mPauseAction);
        } else {
            builder.addAction(this.mPlayAction);
        }
        builder.addAction(this.mSkipToNextAction);
        if (mediaSession.getPlayer().getCurrentMediaItem() != null && (metadata = mediaSession.getPlayer().getCurrentMediaItem().getMetadata()) != null) {
            CharSequence text = metadata.getText("android.media.metadata.DISPLAY_TITLE");
            if (text == null) {
                text = metadata.getText("android.media.metadata.TITLE");
            }
            builder.setContentTitle(text).setContentText(metadata.getText("android.media.metadata.ARTIST")).setLargeIcon(metadata.getBitmap("android.media.metadata.ALBUM_ART"));
        }
        return new MediaSessionService.MediaNotification(1001, builder.setContentIntent(mediaSession.getImpl().getSessionActivity()).setDeleteIntent(createPendingIntent(1L)).setOnlyAlertOnce(true).setSmallIcon(getSmallIconResId()).setStyle(new NotificationCompat.MediaStyle().setCancelButtonIntent(createPendingIntent(1L)).setMediaSession(mediaSession.getSessionCompat().getSessionToken()).setShowActionsInCompactView(1)).setVisibility(1).setOngoing(false).build());
    }
}
