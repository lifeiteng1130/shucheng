package androidx.media2.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.ObjectsCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.VolumeProviderCompat;
import androidx.media2.common.BaseResult;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import androidx.media2.session.RemoteSessionPlayer;
import androidx.media2.session.SequencedFutureManager;
import c.e.b.a.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionImplBase implements MediaSession.MediaSessionImpl {
    private static final String DEFAULT_MEDIA_SESSION_TAG_DELIM = ".";
    private static final String DEFAULT_MEDIA_SESSION_TAG_PREFIX = "androidx.media2.session.id";

    @GuardedBy("STATIC_LOCK")
    private static boolean sComponentNamesInitialized = false;

    @GuardedBy("STATIC_LOCK")
    private static ComponentName sServiceComponentName;
    private final AudioManager mAudioManager;
    private final BroadcastReceiver mBroadcastReceiver;

    @GuardedBy("mLock")
    private MediaBrowserServiceCompat mBrowserServiceLegacyStub;
    public final MediaSession.SessionCallback mCallback;
    public final Executor mCallbackExecutor;

    @GuardedBy("mLock")
    private boolean mClosed;
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final MediaSession mInstance;
    public final Object mLock = new Object();
    private final PendingIntent mMediaButtonIntent;

    @GuardedBy("mLock")
    public MediaController.PlaybackInfo mPlaybackInfo;

    @GuardedBy("mLock")
    public SessionPlayer mPlayer;
    private final SessionPlayerCallback mPlayerCallback;
    private final PendingIntent mSessionActivity;
    private final MediaSessionCompat mSessionCompat;
    private final String mSessionId;
    private final MediaSessionLegacyStub mSessionLegacyStub;
    private final MediaSessionStub mSessionStub;
    private final SessionToken mSessionToken;
    public final Uri mSessionUri;

    @Nullable
    @GuardedBy("mLock")
    public VolumeProviderCompat mVolumeProviderCompat;
    private static final Object STATIC_LOCK = new Object();
    public static final String TAG = "MSImplBase";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final SessionResult RESULT_WHEN_CLOSED = new SessionResult(1);

    public static final class CombinedCommandResultFuture<T extends BaseResult> extends AbstractResolvableFuture<T> {
        public final a<T>[] mFutures;
        public AtomicInteger mSuccessCount = new AtomicInteger(0);

        private CombinedCommandResultFuture(Executor executor, a<T>[] aVarArr) {
            final int i2 = 0;
            this.mFutures = aVarArr;
            while (true) {
                a<T>[] aVarArr2 = this.mFutures;
                if (i2 >= aVarArr2.length) {
                    return;
                }
                aVarArr2[i2].addListener(new Runnable() { // from class: androidx.media2.session.MediaSessionImplBase.CombinedCommandResultFuture.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i3 = 0;
                        try {
                            T t = CombinedCommandResultFuture.this.mFutures[i2].get();
                            int resultCode = t.getResultCode();
                            if (resultCode == 0 || resultCode == 1) {
                                int iIncrementAndGet = CombinedCommandResultFuture.this.mSuccessCount.incrementAndGet();
                                CombinedCommandResultFuture combinedCommandResultFuture = CombinedCommandResultFuture.this;
                                if (iIncrementAndGet == combinedCommandResultFuture.mFutures.length) {
                                    combinedCommandResultFuture.set(t);
                                    return;
                                }
                                return;
                            }
                            int i4 = 0;
                            while (true) {
                                CombinedCommandResultFuture combinedCommandResultFuture2 = CombinedCommandResultFuture.this;
                                a<T>[] aVarArr3 = combinedCommandResultFuture2.mFutures;
                                if (i4 >= aVarArr3.length) {
                                    combinedCommandResultFuture2.set(t);
                                    return;
                                }
                                if (!aVarArr3[i4].isCancelled() && !CombinedCommandResultFuture.this.mFutures[i4].isDone() && i2 != i4) {
                                    CombinedCommandResultFuture.this.mFutures[i4].cancel(true);
                                }
                                i4++;
                            }
                        } catch (Exception e2) {
                            while (true) {
                                CombinedCommandResultFuture combinedCommandResultFuture3 = CombinedCommandResultFuture.this;
                                a<T>[] aVarArr4 = combinedCommandResultFuture3.mFutures;
                                if (i3 >= aVarArr4.length) {
                                    combinedCommandResultFuture3.setException(e2);
                                    return;
                                }
                                if (!aVarArr4[i3].isCancelled() && !CombinedCommandResultFuture.this.mFutures[i3].isDone() && i2 != i3) {
                                    CombinedCommandResultFuture.this.mFutures[i3].cancel(true);
                                }
                                i3++;
                            }
                        }
                    }
                }, executor);
                i2++;
            }
        }

        @SafeVarargs
        public static <U extends BaseResult> CombinedCommandResultFuture<U> create(Executor executor, a<U>... aVarArr) {
            return new CombinedCommandResultFuture<>(executor, aVarArr);
        }
    }

    public final class MediaButtonReceiver extends BroadcastReceiver {
        public MediaButtonReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) && ObjectsCompat.equals(intent.getData(), MediaSessionImplBase.this.mSessionUri) && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
                MediaSessionImplBase.this.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
            }
        }
    }

    @FunctionalInterface
    public interface PlayerTask<T> {
        T run(@NonNull SessionPlayer sessionPlayer);
    }

    public static class PlaylistItemListener implements MediaItem.OnMetadataChangedListener {
        private final WeakReference<MediaSessionImplBase> mSession;

        public PlaylistItemListener(MediaSessionImplBase mediaSessionImplBase) {
            this.mSession = new WeakReference<>(mediaSessionImplBase);
        }

        @Override // androidx.media2.common.MediaItem.OnMetadataChangedListener
        public void onMetadataChanged(@NonNull MediaItem mediaItem, MediaMetadata mediaMetadata) {
            final List<MediaItem> playlist;
            final MediaSessionImplBase mediaSessionImplBase = this.mSession.get();
            if (mediaSessionImplBase == null || mediaItem == null || (playlist = mediaSessionImplBase.getPlaylist()) == null) {
                return;
            }
            for (int i2 = 0; i2 < playlist.size(); i2++) {
                if (mediaItem.equals(playlist.get(i2))) {
                    mediaSessionImplBase.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.PlaylistItemListener.1
                        @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                        public void run(MediaSession.ControllerCb controllerCb, int i3) {
                            controllerCb.onPlaylistChanged(i3, playlist, mediaSessionImplBase.getPlaylistMetadata(), mediaSessionImplBase.getCurrentMediaItemIndex(), mediaSessionImplBase.getPreviousMediaItemIndex(), mediaSessionImplBase.getNextMediaItemIndex());
                        }
                    });
                    return;
                }
            }
        }
    }

    @FunctionalInterface
    public interface RemoteControllerTask {
        void run(MediaSession.ControllerCb controllerCb, int i2);
    }

    public MediaSessionImplBase(MediaSession mediaSession, Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, MediaSession.SessionCallback sessionCallback, Bundle bundle) {
        ComponentName componentName;
        this.mContext = context;
        this.mInstance = mediaSession;
        HandlerThread handlerThread = new HandlerThread("MediaSession_Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mHandler = handler;
        MediaSessionStub mediaSessionStub = new MediaSessionStub(this);
        this.mSessionStub = mediaSessionStub;
        this.mSessionActivity = pendingIntent;
        this.mCallback = sessionCallback;
        this.mCallbackExecutor = executor;
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mPlayerCallback = new SessionPlayerCallback(this);
        this.mSessionId = str;
        Uri uriBuild = new Uri.Builder().scheme(MediaSessionImplBase.class.getName()).appendPath(str).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.mSessionUri = uriBuild;
        SessionToken sessionToken = new SessionToken(new SessionTokenImplBase(Process.myUid(), 0, context.getPackageName(), mediaSessionStub, bundle));
        this.mSessionToken = sessionToken;
        String strJoin = TextUtils.join(DEFAULT_MEDIA_SESSION_TAG_DELIM, new String[]{DEFAULT_MEDIA_SESSION_TAG_PREFIX, str});
        synchronized (STATIC_LOCK) {
            if (!sComponentNamesInitialized) {
                ComponentName serviceComponentByAction = getServiceComponentByAction(MediaLibraryService.SERVICE_INTERFACE);
                sServiceComponentName = serviceComponentByAction;
                if (serviceComponentByAction == null) {
                    sServiceComponentName = getServiceComponentByAction(MediaSessionService.SERVICE_INTERFACE);
                }
                sComponentNamesInitialized = true;
            }
            componentName = sServiceComponentName;
        }
        if (componentName == null) {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", uriBuild);
            intent.setPackage(context.getPackageName());
            this.mMediaButtonIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            ComponentName componentName2 = new ComponentName(context, context.getClass());
            MediaButtonReceiver mediaButtonReceiver = new MediaButtonReceiver();
            this.mBroadcastReceiver = mediaButtonReceiver;
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
            intentFilter.addDataScheme(uriBuild.getScheme());
            context.registerReceiver(mediaButtonReceiver, intentFilter);
            componentName = componentName2;
        } else {
            Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON", uriBuild);
            intent2.setComponent(componentName);
            if (Build.VERSION.SDK_INT >= 26) {
                this.mMediaButtonIntent = PendingIntent.getForegroundService(context, 0, intent2, 0);
            } else {
                this.mMediaButtonIntent = PendingIntent.getService(context, 0, intent2, 0);
            }
            this.mBroadcastReceiver = null;
        }
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context, strJoin, componentName, this.mMediaButtonIntent, sessionToken.getExtras(), sessionToken);
        this.mSessionCompat = mediaSessionCompat;
        MediaSessionLegacyStub mediaSessionLegacyStub = new MediaSessionLegacyStub(this, handler);
        this.mSessionLegacyStub = mediaSessionLegacyStub;
        mediaSessionCompat.setSessionActivity(pendingIntent);
        mediaSessionCompat.setFlags(4);
        updatePlayer(sessionPlayer);
        mediaSessionCompat.setCallback(mediaSessionLegacyStub, handler);
        mediaSessionCompat.setActive(true);
    }

    private static VolumeProviderCompat createVolumeProviderCompat(@NonNull final RemoteSessionPlayer remoteSessionPlayer) {
        return new VolumeProviderCompat(remoteSessionPlayer.getVolumeControlType(), remoteSessionPlayer.getMaxVolume(), remoteSessionPlayer.getVolume()) { // from class: androidx.media2.session.MediaSessionImplBase.53
            @Override // androidx.media.VolumeProviderCompat
            public void onAdjustVolume(int i2) {
                remoteSessionPlayer.adjustVolume(i2);
            }

            @Override // androidx.media.VolumeProviderCompat
            public void onSetVolumeTo(int i2) {
                remoteSessionPlayer.setVolume(i2);
            }
        };
    }

    private a<SessionPlayer.PlayerResult> dispatchPlayerTask(@NonNull PlayerTask<a<SessionPlayer.PlayerResult>> playerTask) {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        resolvableFutureCreate.set(new SessionPlayer.PlayerResult(-2, null));
        return (a) dispatchPlayerTask(playerTask, resolvableFutureCreate);
    }

    private a<SessionResult> dispatchRemoteControllerTask(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull RemoteControllerTask remoteControllerTask) {
        a<SessionResult> aVarCreateFutureWithResult;
        try {
            SequencedFutureManager sequencedFutureManager = this.mSessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            int sequenceNumber = 0;
            if (sequencedFutureManager != null) {
                SequencedFutureManager.SequencedFuture sequencedFutureCreateSequencedFuture = sequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
                sequenceNumber = sequencedFutureCreateSequencedFuture.getSequenceNumber();
                aVarCreateFutureWithResult = sequencedFutureCreateSequencedFuture;
            } else {
                if (!isConnected(controllerInfo)) {
                    return SessionResult.createFutureWithResult(-100);
                }
                aVarCreateFutureWithResult = SessionResult.createFutureWithResult(0);
            }
            remoteControllerTask.run(controllerInfo.getControllerCb(), sequenceNumber);
            return aVarCreateFutureWithResult;
        } catch (DeadObjectException e2) {
            onDeadObjectException(controllerInfo, e2);
            return SessionResult.createFutureWithResult(-100);
        } catch (RemoteException unused) {
            controllerInfo.toString();
            return SessionResult.createFutureWithResult(-1);
        }
    }

    @Nullable
    private MediaItem getCurrentMediaItemOrNull() {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        if (sessionPlayer != null) {
            return sessionPlayer.getCurrentMediaItem();
        }
        return null;
    }

    public static int getLegacyStreamType(@Nullable AudioAttributesCompat audioAttributesCompat) {
        int legacyStreamType;
        if (audioAttributesCompat == null || (legacyStreamType = audioAttributesCompat.getLegacyStreamType()) == Integer.MIN_VALUE) {
            return 3;
        }
        return legacyStreamType;
    }

    @Nullable
    private List<MediaItem> getPlaylistOrNull() {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        if (sessionPlayer != null) {
            return sessionPlayer.getPlaylist();
        }
        return null;
    }

    @Nullable
    private ComponentName getServiceComponentByAction(@NonNull String str) {
        PackageManager packageManager = this.mContext.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(this.mContext.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            return null;
        }
        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
        return new ComponentName(serviceInfo.packageName, serviceInfo.name);
    }

    @SuppressLint({"WrongConstant"})
    private void notifyPlayerUpdatedNotLocked(SessionPlayer sessionPlayer) {
        List<MediaItem> playlist = sessionPlayer.getPlaylist();
        final List<MediaItem> playlistOrNull = getPlaylistOrNull();
        if (ObjectsCompat.equals(playlist, playlistOrNull)) {
            MediaMetadata playlistMetadata = sessionPlayer.getPlaylistMetadata();
            final MediaMetadata playlistMetadata2 = getPlaylistMetadata();
            if (!ObjectsCompat.equals(playlistMetadata, playlistMetadata2)) {
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.45
                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i2) {
                        controllerCb.onPlaylistMetadataChanged(i2, playlistMetadata2);
                    }
                });
            }
        } else {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.44
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onPlaylistChanged(i2, playlistOrNull, MediaSessionImplBase.this.getPlaylistMetadata(), MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        MediaItem currentMediaItem = sessionPlayer.getCurrentMediaItem();
        final MediaItem currentMediaItemOrNull = getCurrentMediaItemOrNull();
        if (!ObjectsCompat.equals(currentMediaItem, currentMediaItemOrNull)) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.46
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onCurrentMediaItemChanged(i2, currentMediaItemOrNull, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        final int repeatMode = getRepeatMode();
        if (sessionPlayer.getRepeatMode() != repeatMode) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.47
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onRepeatModeChanged(i2, repeatMode, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        final int shuffleMode = getShuffleMode();
        if (sessionPlayer.getShuffleMode() != shuffleMode) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.48
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onShuffleModeChanged(i2, shuffleMode, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final long currentPosition = getCurrentPosition();
        final int playerState = getPlayerState();
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.49
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i2) {
                controllerCb.onPlayerStateChanged(i2, jElapsedRealtime, currentPosition, playerState);
            }
        });
        final MediaItem currentMediaItemOrNull2 = getCurrentMediaItemOrNull();
        if (currentMediaItemOrNull2 != null) {
            final int bufferingState = getBufferingState();
            final long bufferedPosition = getBufferedPosition();
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.50
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onBufferingStateChanged(i2, currentMediaItemOrNull2, bufferingState, bufferedPosition, SystemClock.elapsedRealtime(), MediaSessionImplBase.this.getCurrentPosition());
                }
            });
        }
        final float playbackSpeed = getPlaybackSpeed();
        if (playbackSpeed != sessionPlayer.getPlaybackSpeed()) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.51
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onPlaybackSpeedChanged(i2, jElapsedRealtime, currentPosition, playbackSpeed);
                }
            });
        }
    }

    private void onDeadObjectException(MediaSession.ControllerInfo controllerInfo, DeadObjectException deadObjectException) {
        if (DEBUG) {
            controllerInfo.toString();
        }
        this.mSessionStub.getConnectedControllersManager().removeController(controllerInfo);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> addPlaylistItem(final int i2, @NonNull final MediaItem mediaItem) {
        if (i2 < 0) {
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        Objects.requireNonNull(mediaItem, "item shouldn't be null");
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.25
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.addPlaylistItem(i2, mediaItem);
            }
        });
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void broadcastCustomCommand(@NonNull final SessionCommand sessionCommand, @Nullable final Bundle bundle) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.5
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i2) {
                controllerCb.sendCustomCommand(i2, sessionCommand, bundle);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mClosed = true;
            if (DEBUG) {
                String str = "Closing session, id=" + getId() + ", token=" + getToken();
            }
            this.mPlayer.unregisterPlayerCallback(this.mPlayerCallback);
            this.mSessionCompat.release();
            this.mMediaButtonIntent.cancel();
            BroadcastReceiver broadcastReceiver = this.mBroadcastReceiver;
            if (broadcastReceiver != null) {
                this.mContext.unregisterReceiver(broadcastReceiver);
            }
            this.mCallback.onSessionClosed(this.mInstance);
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.2
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onDisconnected(i2);
                }
            });
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.mHandlerThread.isAlive()) {
                this.mHandlerThread.quitSafely();
            }
        }
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void connectFromService(IMediaController iMediaController, int i2, String str, int i3, int i4, @Nullable Bundle bundle) {
        this.mSessionStub.connect(iMediaController, i2, str, i3, i4, bundle);
    }

    public MediaBrowserServiceCompat createLegacyBrowserServiceLocked(Context context, SessionToken sessionToken, MediaSessionCompat.Token token) {
        return new MediaSessionServiceLegacyStub(context, this, token);
    }

    @NonNull
    public MediaController.PlaybackInfo createPlaybackInfo(@NonNull SessionPlayer sessionPlayer, AudioAttributesCompat audioAttributesCompat) {
        if (audioAttributesCompat == null) {
            audioAttributesCompat = sessionPlayer.getAudioAttributes();
        }
        if (sessionPlayer instanceof RemoteSessionPlayer) {
            RemoteSessionPlayer remoteSessionPlayer = (RemoteSessionPlayer) sessionPlayer;
            return MediaController.PlaybackInfo.createPlaybackInfo(2, audioAttributesCompat, remoteSessionPlayer.getVolumeControlType(), remoteSessionPlayer.getMaxVolume(), remoteSessionPlayer.getVolume());
        }
        int legacyStreamType = getLegacyStreamType(audioAttributesCompat);
        return MediaController.PlaybackInfo.createPlaybackInfo(1, audioAttributesCompat, this.mAudioManager.isVolumeFixed() ? 0 : 2, this.mAudioManager.getStreamMaxVolume(legacyStreamType), this.mAudioManager.getStreamVolume(legacyStreamType));
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public PlaybackStateCompat createPlaybackStateCompat() {
        int iConvertToPlaybackStateCompatState = MediaUtils.convertToPlaybackStateCompatState(getPlayerState(), getBufferingState());
        return new PlaybackStateCompat.Builder().setState(iConvertToPlaybackStateCompatState, getCurrentPosition(), getPlaybackSpeed(), SystemClock.elapsedRealtime()).setActions(3670015L).setActiveQueueItemId(MediaUtils.convertToQueueItemId(getCurrentMediaItemIndex())).setBufferedPosition(getBufferedPosition()).build();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public a<SessionPlayer.PlayerResult> deselectTrack(final SessionPlayer.TrackInfo trackInfo) {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.42
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.deselectTrack(trackInfo);
            }
        });
    }

    public void dispatchRemoteControllerTaskWithoutReturn(@NonNull RemoteControllerTask remoteControllerTask) {
        List<MediaSession.ControllerInfo> connectedControllers = this.mSessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i2 = 0; i2 < connectedControllers.size(); i2++) {
            dispatchRemoteControllerTaskWithoutReturn(connectedControllers.get(i2), remoteControllerTask);
        }
        try {
            remoteControllerTask.run(this.mSessionLegacyStub.getControllerLegacyCbForBroadcast(), 0);
        } catch (RemoteException unused) {
        }
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getBufferedPosition() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() { // from class: androidx.media2.session.MediaSessionImplBase.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Long run(@NonNull SessionPlayer sessionPlayer) {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getBufferedPosition());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public int getBufferingState() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) {
                return Integer.valueOf(sessionPlayer.getBufferingState());
            }
        }, 0)).intValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaSession.SessionCallback getCallback() {
        return this.mCallback;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public Executor getCallbackExecutor() {
        return this.mCallbackExecutor;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mSessionStub.getConnectedControllersManager().getConnectedControllers());
        arrayList.addAll(this.mSessionLegacyStub.getConnectedControllersManager().getConnectedControllers());
        return arrayList;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public Context getContext() {
        return this.mContext;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public MediaItem getCurrentMediaItem() {
        return (MediaItem) dispatchPlayerTask(new PlayerTask<MediaItem>() { // from class: androidx.media2.session.MediaSessionImplBase.29
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public MediaItem run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.getCurrentMediaItem();
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getCurrentMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.30
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) {
                return Integer.valueOf(sessionPlayer.getCurrentMediaItemIndex());
            }
        }, -1)).intValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getCurrentPosition() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() { // from class: androidx.media2.session.MediaSessionImplBase.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Long run(@NonNull SessionPlayer sessionPlayer) {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getCurrentPosition());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getDuration() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() { // from class: androidx.media2.session.MediaSessionImplBase.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Long run(@NonNull SessionPlayer sessionPlayer) {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getDuration());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public String getId() {
        return this.mSessionId;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public MediaSession getInstance() {
        return this.mInstance;
    }

    public MediaBrowserServiceCompat getLegacyBrowserService() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat;
        synchronized (this.mLock) {
            mediaBrowserServiceCompat = this.mBrowserServiceLegacyStub;
        }
        return mediaBrowserServiceCompat;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public IBinder getLegacyBrowserServiceBinder() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat;
        synchronized (this.mLock) {
            if (this.mBrowserServiceLegacyStub == null) {
                this.mBrowserServiceLegacyStub = createLegacyBrowserServiceLocked(this.mContext, this.mSessionToken, this.mSessionCompat.getSessionToken());
            }
            mediaBrowserServiceCompat = this.mBrowserServiceLegacyStub;
        }
        return mediaBrowserServiceCompat.onBind(new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE));
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getNextMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.32
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) {
                return Integer.valueOf(sessionPlayer.getNextMediaItemIndex());
            }
        }, -1)).intValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaController.PlaybackInfo getPlaybackInfo() {
        MediaController.PlaybackInfo playbackInfo;
        synchronized (this.mLock) {
            playbackInfo = this.mPlaybackInfo;
        }
        return playbackInfo;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public float getPlaybackSpeed() {
        return ((Float) dispatchPlayerTask(new PlayerTask<Float>() { // from class: androidx.media2.session.MediaSessionImplBase.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Float run(@NonNull SessionPlayer sessionPlayer) {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Float.valueOf(sessionPlayer.getPlaybackSpeed());
                }
                return null;
            }
        }, Float.valueOf(1.0f))).floatValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public SessionPlayer getPlayer() {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        return sessionPlayer;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public int getPlayerState() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) {
                return Integer.valueOf(sessionPlayer.getPlayerState());
            }
        }, 3)).intValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public List<MediaItem> getPlaylist() {
        return (List) dispatchPlayerTask(new PlayerTask<List<MediaItem>>() { // from class: androidx.media2.session.MediaSessionImplBase.18
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public List<MediaItem> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.getPlaylist();
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public MediaMetadata getPlaylistMetadata() {
        return (MediaMetadata) dispatchPlayerTask(new PlayerTask<MediaMetadata>() { // from class: androidx.media2.session.MediaSessionImplBase.24
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public MediaMetadata run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.getPlaylistMetadata();
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getPreviousMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.31
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) {
                return Integer.valueOf(sessionPlayer.getPreviousMediaItemIndex());
            }
        }, -1)).intValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getRepeatMode() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.34
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) {
                return Integer.valueOf(sessionPlayer.getRepeatMode());
            }
        }, 0)).intValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public SessionPlayer.TrackInfo getSelectedTrack(final int i2) {
        return (SessionPlayer.TrackInfo) dispatchPlayerTask(new PlayerTask<SessionPlayer.TrackInfo>() { // from class: androidx.media2.session.MediaSessionImplBase.43
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public SessionPlayer.TrackInfo run(@NonNull SessionPlayer sessionPlayer) {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getSelectedTrack(i2));
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public PendingIntent getSessionActivity() {
        return this.mSessionActivity;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaSessionCompat getSessionCompat() {
        return this.mSessionCompat;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getShuffleMode() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.36
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) {
                return Integer.valueOf(sessionPlayer.getShuffleMode());
            }
        }, 0)).intValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public SessionToken getToken() {
        return this.mSessionToken;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public List<SessionPlayer.TrackInfo> getTracks() {
        return (List) dispatchPlayerTask(new PlayerTask<List<SessionPlayer.TrackInfo>>() { // from class: androidx.media2.session.MediaSessionImplBase.40
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public List<SessionPlayer.TrackInfo> run(@NonNull SessionPlayer sessionPlayer) {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getTracks());
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public Uri getUri() {
        return this.mSessionUri;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public VideoSize getVideoSize() {
        return (VideoSize) dispatchPlayerTask(new PlayerTask<VideoSize>() { // from class: androidx.media2.session.MediaSessionImplBase.38
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public VideoSize run(@NonNull SessionPlayer sessionPlayer) {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getVideoSize());
            }
        }, new VideoSize(0, 0));
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public boolean isClosed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mClosed;
        }
        return z;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public boolean isConnected(@NonNull MediaSession.ControllerInfo controllerInfo) {
        if (controllerInfo == null) {
            return false;
        }
        return this.mSessionStub.getConnectedControllersManager().isConnected(controllerInfo) || this.mSessionLegacyStub.getConnectedControllersManager().isConnected(controllerInfo);
    }

    public boolean isInPlaybackState(@NonNull SessionPlayer sessionPlayer) {
        return (isClosed() || sessionPlayer.getPlayerState() == 0 || sessionPlayer.getPlayerState() == 3) ? false : true;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> movePlaylistItem(final int i2, final int i3) {
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("indices shouldn't be negative");
        }
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.28
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.movePlaylistItem(i2, i3);
            }
        });
    }

    public void notifyPlaybackInfoChangedNotLocked(final MediaController.PlaybackInfo playbackInfo) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.52
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i2) {
                controllerCb.onPlaybackInfoChanged(i2, playbackInfo);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public a<SessionPlayer.PlayerResult> pause() {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.pause();
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public a<SessionPlayer.PlayerResult> play() {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                if (sessionPlayer.getPlayerState() != 0) {
                    return sessionPlayer.play();
                }
                a<SessionPlayer.PlayerResult> aVarPrepare = sessionPlayer.prepare();
                a<SessionPlayer.PlayerResult> aVarPlay = sessionPlayer.play();
                if (aVarPrepare == null || aVarPlay == null) {
                    return null;
                }
                return CombinedCommandResultFuture.create(MediaUtils.DIRECT_EXECUTOR, aVarPrepare, aVarPlay);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public a<SessionPlayer.PlayerResult> prepare() {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.prepare();
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> removePlaylistItem(final int i2) {
        if (i2 >= 0) {
            return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.26
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                    return i2 >= sessionPlayer.getPlaylist().size() ? SessionPlayer.PlayerResult.createFuture(-3) : sessionPlayer.removePlaylistItem(i2);
                }
            });
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> replacePlaylistItem(final int i2, @NonNull final MediaItem mediaItem) {
        if (i2 < 0) {
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        Objects.requireNonNull(mediaItem, "item shouldn't be null");
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.27
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.replacePlaylistItem(i2, mediaItem);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public a<SessionPlayer.PlayerResult> seekTo(final long j2) {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.seekTo(j2);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public a<SessionPlayer.PlayerResult> selectTrack(final SessionPlayer.TrackInfo trackInfo) {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.41
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.selectTrack(trackInfo);
            }
        });
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public a<SessionResult> sendCustomCommand(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final SessionCommand sessionCommand, @Nullable final Bundle bundle) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.6
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i2) {
                controllerCb.sendCustomCommand(i2, sessionCommand, bundle);
            }
        });
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void setAllowedCommands(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final SessionCommandGroup sessionCommandGroup) {
        if (!this.mSessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            this.mSessionLegacyStub.getConnectedControllersManager().updateAllowedCommands(controllerInfo, sessionCommandGroup);
        } else {
            this.mSessionStub.getConnectedControllersManager().updateAllowedCommands(controllerInfo, sessionCommandGroup);
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.4
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onAllowedCommandsChanged(i2, sessionCommandGroup);
                }
            });
        }
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public a<SessionResult> setCustomLayout(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final List<MediaSession.CommandButton> list) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.3
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i2) {
                controllerCb.setCustomLayout(i2, list);
            }
        });
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void setLegacyControllerConnectionTimeoutMs(long j2) {
        this.mSessionLegacyStub.setLegacyControllerDisconnectTimeoutMs(j2);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> setMediaItem(@NonNull final MediaItem mediaItem) {
        Objects.requireNonNull(mediaItem, "item shouldn't be null");
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.setMediaItem(mediaItem);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public a<SessionPlayer.PlayerResult> setPlaybackSpeed(final float f2) {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.setPlaybackSpeed(f2);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> setPlaylist(@NonNull final List<MediaItem> list, @Nullable final MediaMetadata mediaMetadata) {
        Objects.requireNonNull(list, "list shouldn't be null");
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.setPlaylist(list, mediaMetadata);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> setRepeatMode(final int i2) {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.35
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.setRepeatMode(i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> setShuffleMode(final int i2) {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.37
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.setShuffleMode(i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public a<SessionPlayer.PlayerResult> setSurface(final Surface surface) {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.39
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.setSurface(surface);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> skipToNextItem() {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.skipToNextPlaylistItem();
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> skipToPlaylistItem(final int i2) {
        if (i2 >= 0) {
            return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.21
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                    return i2 >= sessionPlayer.getPlaylist().size() ? SessionPlayer.PlayerResult.createFuture(-3) : sessionPlayer.skipToPlaylistItem(i2);
                }
            });
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> skipToPreviousItem() {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.22
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.skipToPreviousPlaylistItem();
            }
        });
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @SuppressLint({"WrongConstant"})
    public void updatePlayer(@NonNull SessionPlayer sessionPlayer) {
        boolean z;
        SessionPlayer sessionPlayer2;
        MediaController.PlaybackInfo playbackInfoCreatePlaybackInfo = createPlaybackInfo(sessionPlayer, null);
        boolean z2 = sessionPlayer instanceof RemoteSessionPlayer;
        VolumeProviderCompat volumeProviderCompatCreateVolumeProviderCompat = z2 ? createVolumeProviderCompat((RemoteSessionPlayer) sessionPlayer) : null;
        synchronized (this.mLock) {
            z = !playbackInfoCreatePlaybackInfo.equals(this.mPlaybackInfo);
            sessionPlayer2 = this.mPlayer;
            this.mPlayer = sessionPlayer;
            this.mPlaybackInfo = playbackInfoCreatePlaybackInfo;
            this.mVolumeProviderCompat = volumeProviderCompatCreateVolumeProviderCompat;
        }
        if (sessionPlayer2 != sessionPlayer) {
            if (sessionPlayer2 != null) {
                sessionPlayer2.unregisterPlayerCallback(this.mPlayerCallback);
            }
            sessionPlayer.registerPlayerCallback(this.mCallbackExecutor, this.mPlayerCallback);
        }
        if (sessionPlayer2 == null) {
            this.mSessionCompat.setPlaybackState(createPlaybackStateCompat());
        } else {
            if (sessionPlayer != sessionPlayer2) {
                final int playerState = getPlayerState();
                this.mCallbackExecutor.execute(new Runnable() { // from class: androidx.media2.session.MediaSessionImplBase.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                        mediaSessionImplBase.mCallback.onPlayerStateChanged(mediaSessionImplBase.getInstance(), playerState);
                    }
                });
                notifyPlayerUpdatedNotLocked(sessionPlayer2);
            }
            if (z) {
                notifyPlaybackInfoChangedNotLocked(playbackInfoCreatePlaybackInfo);
            }
        }
        if (z2) {
            this.mSessionCompat.setPlaybackToRemote(volumeProviderCompatCreateVolumeProviderCompat);
        } else {
            this.mSessionCompat.setPlaybackToLocal(getLegacyStreamType(sessionPlayer.getAudioAttributes()));
        }
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void updatePlayer(@NonNull SessionPlayer sessionPlayer, @Nullable SessionPlayer sessionPlayer2) {
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public a<SessionPlayer.PlayerResult> updatePlaylistMetadata(@Nullable final MediaMetadata mediaMetadata) {
        return dispatchPlayerTask(new PlayerTask<a<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.33
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public a<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.updatePlaylistMetadata(mediaMetadata);
            }
        });
    }

    public static class SessionPlayerCallback extends RemoteSessionPlayer.Callback implements MediaItem.OnMetadataChangedListener {
        private MediaItem mMediaItem;
        private List<MediaItem> mPlaylist;
        private final PlaylistItemListener mPlaylistItemChangedListener;
        private final WeakReference<MediaSessionImplBase> mSession;

        public SessionPlayerCallback(MediaSessionImplBase mediaSessionImplBase) {
            this.mSession = new WeakReference<>(mediaSessionImplBase);
            this.mPlaylistItemChangedListener = new PlaylistItemListener(mediaSessionImplBase);
        }

        private void dispatchRemoteControllerTask(@NonNull SessionPlayer sessionPlayer, @NonNull RemoteControllerTask remoteControllerTask) {
            MediaSessionImplBase session = getSession();
            if (session == null || sessionPlayer == null || session.getPlayer() != sessionPlayer) {
                return;
            }
            session.dispatchRemoteControllerTaskWithoutReturn(remoteControllerTask);
        }

        private MediaSessionImplBase getSession() {
            MediaSessionImplBase mediaSessionImplBase = this.mSession.get();
            if (mediaSessionImplBase == null && MediaSessionImplBase.DEBUG) {
                new IllegalStateException();
            }
            return mediaSessionImplBase;
        }

        private void notifyCurrentMediaItemChanged(@Nullable final MediaItem mediaItem) {
            final MediaSessionImplBase session = getSession();
            if (session == null) {
                return;
            }
            dispatchRemoteControllerTask(session.getPlayer(), new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.15
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onCurrentMediaItemChanged(i2, mediaItem, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        private boolean updateCurrentMediaItemMetadataWithDuration(@NonNull SessionPlayer sessionPlayer) {
            MediaItem currentMediaItem = sessionPlayer.getCurrentMediaItem();
            if (currentMediaItem == null) {
                return false;
            }
            return updateCurrentMediaItemMetadataWithDuration(sessionPlayer, currentMediaItem, currentMediaItem.getMetadata());
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onAudioAttributesChanged(@NonNull SessionPlayer sessionPlayer, AudioAttributesCompat audioAttributesCompat) {
            MediaController.PlaybackInfo playbackInfo;
            MediaSessionImplBase session = getSession();
            if (session == null || sessionPlayer == null || session.getPlayer() != sessionPlayer) {
                return;
            }
            MediaController.PlaybackInfo playbackInfoCreatePlaybackInfo = session.createPlaybackInfo(sessionPlayer, audioAttributesCompat);
            synchronized (session.mLock) {
                playbackInfo = session.mPlaybackInfo;
                session.mPlaybackInfo = playbackInfoCreatePlaybackInfo;
            }
            if (ObjectsCompat.equals(playbackInfoCreatePlaybackInfo, playbackInfo)) {
                return;
            }
            session.notifyPlaybackInfoChangedNotLocked(playbackInfoCreatePlaybackInfo);
            if (sessionPlayer instanceof RemoteSessionPlayer) {
                return;
            }
            int legacyStreamType = MediaSessionImplBase.getLegacyStreamType(playbackInfo == null ? null : playbackInfo.getAudioAttributes());
            int legacyStreamType2 = MediaSessionImplBase.getLegacyStreamType(playbackInfoCreatePlaybackInfo.getAudioAttributes());
            if (legacyStreamType != legacyStreamType2) {
                session.getSessionCompat().setPlaybackToLocal(legacyStreamType2);
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onBufferingStateChanged(@NonNull final SessionPlayer sessionPlayer, final MediaItem mediaItem, final int i2) {
            updateCurrentMediaItemMetadataWithDuration(sessionPlayer);
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.2
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i3) {
                    controllerCb.onBufferingStateChanged(i3, mediaItem, i2, sessionPlayer.getBufferedPosition(), SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition());
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onCurrentMediaItemChanged(@NonNull SessionPlayer sessionPlayer, @NonNull MediaItem mediaItem) {
            MediaSessionImplBase session = getSession();
            if (session == null || sessionPlayer == null || session.getPlayer() != sessionPlayer) {
                return;
            }
            MediaItem mediaItem2 = this.mMediaItem;
            if (mediaItem2 != null) {
                mediaItem2.removeOnMetadataChangedListener(this);
            }
            if (mediaItem != null) {
                mediaItem.addOnMetadataChangedListener(session.mCallbackExecutor, this);
            }
            this.mMediaItem = mediaItem;
            session.getCallback().onCurrentMediaItemChanged(session.getInstance());
            if (mediaItem != null ? updateCurrentMediaItemMetadataWithDuration(sessionPlayer, mediaItem, mediaItem.getMetadata()) : false) {
                return;
            }
            notifyCurrentMediaItemChanged(mediaItem);
        }

        @Override // androidx.media2.common.MediaItem.OnMetadataChangedListener
        public void onMetadataChanged(@NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata) {
            MediaSessionImplBase session = getSession();
            if (session == null || updateCurrentMediaItemMetadataWithDuration(session.getPlayer(), mediaItem, mediaMetadata)) {
                return;
            }
            notifyCurrentMediaItemChanged(mediaItem);
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaybackCompleted(@NonNull SessionPlayer sessionPlayer) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.9
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onPlaybackCompleted(i2);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaybackSpeedChanged(@NonNull final SessionPlayer sessionPlayer, final float f2) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.3
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onPlaybackSpeedChanged(i2, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), f2);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlayerStateChanged(@NonNull final SessionPlayer sessionPlayer, final int i2) {
            MediaSessionImplBase session = getSession();
            if (session == null || sessionPlayer == null || session.getPlayer() != sessionPlayer) {
                return;
            }
            session.getCallback().onPlayerStateChanged(session.getInstance(), i2);
            updateCurrentMediaItemMetadataWithDuration(sessionPlayer);
            session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.1
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i3) {
                    controllerCb.onPlayerStateChanged(i3, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), i2);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaylistChanged(@NonNull SessionPlayer sessionPlayer, final List<MediaItem> list, final MediaMetadata mediaMetadata) {
            final MediaSessionImplBase session = getSession();
            if (session == null || sessionPlayer == null || session.getPlayer() != sessionPlayer) {
                return;
            }
            if (this.mPlaylist != null) {
                for (int i2 = 0; i2 < this.mPlaylist.size(); i2++) {
                    this.mPlaylist.get(i2).removeOnMetadataChangedListener(this.mPlaylistItemChangedListener);
                }
            }
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    list.get(i3).addOnMetadataChangedListener(session.mCallbackExecutor, this.mPlaylistItemChangedListener);
                }
            }
            this.mPlaylist = list;
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.5
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i4) {
                    controllerCb.onPlaylistChanged(i4, list, mediaMetadata, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaylistMetadataChanged(@NonNull SessionPlayer sessionPlayer, final MediaMetadata mediaMetadata) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.6
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onPlaylistMetadataChanged(i2, mediaMetadata);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onRepeatModeChanged(@NonNull SessionPlayer sessionPlayer, final int i2) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.7
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i3) {
                    controllerCb.onRepeatModeChanged(i3, i2, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onSeekCompleted(@NonNull final SessionPlayer sessionPlayer, final long j2) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.4
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onSeekCompleted(i2, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), j2);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onShuffleModeChanged(@NonNull SessionPlayer sessionPlayer, final int i2) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.8
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i3) {
                    controllerCb.onShuffleModeChanged(i3, i2, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onSubtitleData(@NonNull SessionPlayer sessionPlayer, @NonNull final MediaItem mediaItem, @NonNull final SessionPlayer.TrackInfo trackInfo, @NonNull final SubtitleData subtitleData) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.14
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onSubtitleData(i2, mediaItem, trackInfo, subtitleData);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTrackDeselected(@NonNull SessionPlayer sessionPlayer, @NonNull final SessionPlayer.TrackInfo trackInfo) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.13
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onTrackDeselected(i2, MediaUtils.upcastForPreparceling(trackInfo));
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTrackSelected(@NonNull SessionPlayer sessionPlayer, @NonNull final SessionPlayer.TrackInfo trackInfo) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.12
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onTrackSelected(i2, MediaUtils.upcastForPreparceling(trackInfo));
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTracksChanged(@NonNull SessionPlayer sessionPlayer, @NonNull final List<SessionPlayer.TrackInfo> list) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.11
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onTracksChanged(i2, MediaUtils.upcastForPreparceling((List<SessionPlayer.TrackInfo>) list), MediaUtils.upcastForPreparceling(session.getSelectedTrack(1)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(2)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(4)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(5)));
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onVideoSizeChanged(@NonNull SessionPlayer sessionPlayer, @NonNull final VideoSize videoSize) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.10
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) {
                    controllerCb.onVideoSizeChanged(i2, MediaUtils.upcastForPreparceling(videoSize));
                }
            });
        }

        @Override // androidx.media2.session.RemoteSessionPlayer.Callback
        public void onVolumeChanged(@NonNull RemoteSessionPlayer remoteSessionPlayer, int i2) {
            MediaSessionImplBase session = getSession();
            if (session == null) {
                return;
            }
            MediaController.PlaybackInfo playbackInfoCreatePlaybackInfo = session.createPlaybackInfo(remoteSessionPlayer, null);
            synchronized (session.mLock) {
                if (session.mPlayer != remoteSessionPlayer) {
                    return;
                }
                MediaController.PlaybackInfo playbackInfo = session.mPlaybackInfo;
                session.mPlaybackInfo = playbackInfoCreatePlaybackInfo;
                VolumeProviderCompat volumeProviderCompat = session.mVolumeProviderCompat;
                if (!ObjectsCompat.equals(playbackInfoCreatePlaybackInfo, playbackInfo)) {
                    session.notifyPlaybackInfoChangedNotLocked(playbackInfoCreatePlaybackInfo);
                }
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.setCurrentVolume(i2);
                }
            }
        }

        private boolean updateCurrentMediaItemMetadataWithDuration(@NonNull SessionPlayer sessionPlayer, @NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata) {
            long duration = sessionPlayer.getDuration();
            if (mediaItem != sessionPlayer.getCurrentMediaItem() || sessionPlayer.getPlayerState() == 0 || duration <= 0 || duration == Long.MIN_VALUE) {
                return false;
            }
            MediaMetadata mediaMetadataBuild = null;
            if (mediaMetadata != null) {
                if (!mediaMetadata.containsKey("android.media.metadata.DURATION")) {
                    mediaMetadataBuild = new MediaMetadata.Builder(mediaMetadata).putLong("android.media.metadata.DURATION", duration).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1L).build();
                } else {
                    int i2 = (duration > mediaMetadata.getLong("android.media.metadata.DURATION") ? 1 : (duration == mediaMetadata.getLong("android.media.metadata.DURATION") ? 0 : -1));
                }
            } else {
                mediaMetadataBuild = new MediaMetadata.Builder().putLong("android.media.metadata.DURATION", duration).putString("android.media.metadata.MEDIA_ID", mediaItem.getMediaId()).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1L).build();
            }
            if (mediaMetadataBuild == null) {
                return false;
            }
            mediaItem.setMetadata(mediaMetadataBuild);
            return true;
        }
    }

    private <T> T dispatchPlayerTask(@NonNull PlayerTask<T> playerTask, T t) {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        try {
            if (!isClosed()) {
                T tRun = playerTask.run(sessionPlayer);
                if (tRun != null) {
                    return tRun;
                }
            } else if (DEBUG) {
                new IllegalStateException();
            }
        } catch (Exception unused) {
        }
        return t;
    }

    public void dispatchRemoteControllerTaskWithoutReturn(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull RemoteControllerTask remoteControllerTask) {
        int iObtainNextSequenceNumber;
        try {
            SequencedFutureManager sequencedFutureManager = this.mSessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            if (sequencedFutureManager != null) {
                iObtainNextSequenceNumber = sequencedFutureManager.obtainNextSequenceNumber();
            } else {
                if (!isConnected(controllerInfo)) {
                    if (DEBUG) {
                        String str = "Skipping dispatching task to disconnected controller, controller=" + controllerInfo;
                        return;
                    }
                    return;
                }
                iObtainNextSequenceNumber = 0;
            }
            remoteControllerTask.run(controllerInfo.getControllerCb(), iObtainNextSequenceNumber);
        } catch (DeadObjectException e2) {
            onDeadObjectException(controllerInfo, e2);
        } catch (RemoteException unused) {
            controllerInfo.toString();
        }
    }
}
