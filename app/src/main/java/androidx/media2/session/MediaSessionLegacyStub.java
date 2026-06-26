package androidx.media2.session;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SessionCommandGroup;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionLegacyStub extends MediaSessionCompat.Callback {
    private static final int DEFAULT_CONNECTION_TIMEOUT_MS = 300000;
    public final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> mConnectedControllersManager;
    public final ConnectionTimeoutHandler mConnectionTimeoutHandler;
    public volatile long mConnectionTimeoutMs;
    public final Context mContext;
    public final MediaSession.ControllerCb mControllerLegacyCbForBroadcast;
    public final MediaSession.MediaSessionImpl mSessionImpl;
    public final androidx.media.MediaSessionManager mSessionManager;
    private static final String TAG = "MediaSessionLegacyStub";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);
    public static final SparseArray<SessionCommand> sCommandsForOnCommandRequest = new SparseArray<>();

    public class ConnectionTimeoutHandler extends Handler {
        private static final int MSG_CONNECTION_TIMED_OUT = 1001;

        public ConnectionTimeoutHandler(Looper looper) {
            super(looper);
        }

        public void disconnectControllerAfterTimeout(@NonNull MediaSession.ControllerInfo controllerInfo, long j2) {
            removeMessages(1001, controllerInfo);
            sendMessageDelayed(obtainMessage(1001, controllerInfo), j2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaSession.ControllerInfo controllerInfo = (MediaSession.ControllerInfo) message.obj;
            if (MediaSessionLegacyStub.this.mConnectedControllersManager.isConnected(controllerInfo)) {
                try {
                    controllerInfo.getControllerCb().onDisconnected(0);
                } catch (RemoteException unused) {
                }
                MediaSessionLegacyStub.this.mConnectedControllersManager.removeController(controllerInfo);
            }
        }
    }

    public final class ControllerLegacyCb extends MediaSession.ControllerCb {
        private final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;

        public ControllerLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.mRemoteUserInfo = remoteUserInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ControllerLegacyCb.class) {
                return false;
            }
            return ObjectsCompat.equals(this.mRemoteUserInfo, ((ControllerLegacyCb) obj).mRemoteUserInfo);
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mRemoteUserInfo);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onAllowedCommandsChanged(int i2, @NonNull SessionCommandGroup sessionCommandGroup) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onBufferingStateChanged(int i2, @NonNull MediaItem mediaItem, int i3, long j2, long j3, long j4) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i2, @NonNull String str, int i3, MediaLibraryService.LibraryParams libraryParams) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onCurrentMediaItemChanged(int i2, MediaItem mediaItem, int i3, int i4, int i5) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onDisconnected(int i2) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onLibraryResult(int i2, LibraryResult libraryResult) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackCompleted(int i2) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackInfoChanged(int i2, @NonNull MediaController.PlaybackInfo playbackInfo) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackSpeedChanged(int i2, long j2, long j3, float f2) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerResult(int i2, SessionPlayer.PlayerResult playerResult) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerStateChanged(int i2, long j2, long j3, int i3) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistChanged(int i2, @NonNull List<MediaItem> list, MediaMetadata mediaMetadata, int i3, int i4, int i5) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistMetadataChanged(int i2, MediaMetadata mediaMetadata) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onRepeatModeChanged(int i2, int i3, int i4, int i5, int i6) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i2, @NonNull String str, int i3, MediaLibraryService.LibraryParams libraryParams) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSeekCompleted(int i2, long j2, long j3, long j4) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSessionResult(int i2, SessionResult sessionResult) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onShuffleModeChanged(int i2, int i3, int i4, int i5, int i6) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSubtitleData(int i2, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackDeselected(int i2, SessionPlayer.TrackInfo trackInfo) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackSelected(int i2, SessionPlayer.TrackInfo trackInfo) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTracksChanged(int i2, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onVideoSizeChanged(int i2, @NonNull VideoSize videoSize) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i2, @NonNull SessionCommand sessionCommand, Bundle bundle) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void setCustomLayout(int i2, @NonNull List<MediaSession.CommandButton> list) {
        }
    }

    public final class ControllerLegacyCbForBroadcast extends MediaSession.ControllerCb {
        public ControllerLegacyCbForBroadcast() {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onAllowedCommandsChanged(int i2, @NonNull SessionCommandGroup sessionCommandGroup) {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onBufferingStateChanged(int i2, @NonNull MediaItem mediaItem, int i3, long j2, long j3, long j4) {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i2, @NonNull String str, int i3, MediaLibraryService.LibraryParams libraryParams) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onCurrentMediaItemChanged(int i2, MediaItem mediaItem, int i3, int i4, int i5) {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setMetadata(mediaItem == null ? null : MediaUtils.convertToMediaMetadataCompat(mediaItem.getMetadata()));
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onDisconnected(int i2) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onLibraryResult(int i2, LibraryResult libraryResult) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackCompleted(int i2) {
            PlaybackStateCompat playbackStateCompatCreatePlaybackStateCompat = MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat();
            if (playbackStateCompatCreatePlaybackStateCompat.getState() != 2) {
                playbackStateCompatCreatePlaybackStateCompat = new PlaybackStateCompat.Builder(playbackStateCompatCreatePlaybackStateCompat).setState(2, playbackStateCompatCreatePlaybackStateCompat.getPosition(), playbackStateCompatCreatePlaybackStateCompat.getPlaybackSpeed()).build();
            }
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(playbackStateCompatCreatePlaybackStateCompat);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackInfoChanged(int i2, @NonNull MediaController.PlaybackInfo playbackInfo) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackSpeedChanged(int i2, long j2, long j3, float f2) {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerResult(int i2, SessionPlayer.PlayerResult playerResult) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerStateChanged(int i2, long j2, long j3, int i3) {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistChanged(int i2, @NonNull List<MediaItem> list, MediaMetadata mediaMetadata, int i3, int i4, int i5) {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setQueue(MediaUtils.convertToQueueItemList(list));
            onPlaylistMetadataChanged(i2, mediaMetadata);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistMetadataChanged(int i2, MediaMetadata mediaMetadata) {
            CharSequence text;
            CharSequence queueTitle = MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().getController().getQueueTitle();
            if (mediaMetadata != null) {
                text = mediaMetadata.getText("android.media.metadata.DISPLAY_TITLE");
                if (text == null) {
                    text = mediaMetadata.getText("android.media.metadata.TITLE");
                }
            } else {
                text = null;
            }
            if (TextUtils.equals(queueTitle, text)) {
                return;
            }
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setQueueTitle(text);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onRepeatModeChanged(int i2, int i3, int i4, int i5, int i6) {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setRepeatMode(i3);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i2, @NonNull String str, int i3, MediaLibraryService.LibraryParams libraryParams) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSeekCompleted(int i2, long j2, long j3, long j4) {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSessionResult(int i2, SessionResult sessionResult) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onShuffleModeChanged(int i2, int i3, int i4, int i5, int i6) {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setShuffleMode(i3);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSubtitleData(int i2, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackDeselected(int i2, SessionPlayer.TrackInfo trackInfo) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackSelected(int i2, SessionPlayer.TrackInfo trackInfo) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTracksChanged(int i2, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onVideoSizeChanged(int i2, @NonNull VideoSize videoSize) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i2, @NonNull SessionCommand sessionCommand, Bundle bundle) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void setCustomLayout(int i2, @NonNull List<MediaSession.CommandButton> list) {
            throw new AssertionError("This shouldn't be called");
        }
    }

    @FunctionalInterface
    public interface SessionTask {
        void run(MediaSession.ControllerInfo controllerInfo);
    }

    static {
        for (SessionCommand sessionCommand : new SessionCommandGroup.Builder().addAllPlayerCommands(2).addAllVolumeCommands(2).build().getCommands()) {
            sCommandsForOnCommandRequest.append(sessionCommand.getCommandCode(), sessionCommand);
        }
    }

    public MediaSessionLegacyStub(MediaSession.MediaSessionImpl mediaSessionImpl, Handler handler) {
        this.mSessionImpl = mediaSessionImpl;
        Context context = mediaSessionImpl.getContext();
        this.mContext = context;
        this.mSessionManager = androidx.media.MediaSessionManager.getSessionManager(context);
        this.mControllerLegacyCbForBroadcast = new ControllerLegacyCbForBroadcast();
        this.mConnectionTimeoutHandler = new ConnectionTimeoutHandler(handler.getLooper());
        this.mConnectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
        this.mConnectionTimeoutMs = 300000L;
    }

    private void dispatchSessionTask(int i2, @NonNull SessionTask sessionTask) {
        dispatchSessionTaskInternal(null, i2, sessionTask);
    }

    private void dispatchSessionTaskInternal(@Nullable final SessionCommand sessionCommand, final int i2, @NonNull final SessionTask sessionTask) {
        if (this.mSessionImpl.isClosed()) {
            return;
        }
        final MediaSessionManager.RemoteUserInfo currentControllerInfo = this.mSessionImpl.getSessionCompat().getCurrentControllerInfo();
        if (currentControllerInfo != null) {
            this.mSessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaSessionLegacyStub.21
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaSessionLegacyStub.this.mSessionImpl.isClosed()) {
                        return;
                    }
                    MediaSession.ControllerInfo controller = MediaSessionLegacyStub.this.mConnectedControllersManager.getController(currentControllerInfo);
                    if (controller == null) {
                        MediaSessionManager.RemoteUserInfo remoteUserInfo = currentControllerInfo;
                        controller = new MediaSession.ControllerInfo(remoteUserInfo, -1, MediaSessionLegacyStub.this.mSessionManager.isTrustedForMediaControl(remoteUserInfo), MediaSessionLegacyStub.this.new ControllerLegacyCb(currentControllerInfo), null);
                        SessionCommandGroup sessionCommandGroupOnConnect = MediaSessionLegacyStub.this.mSessionImpl.getCallback().onConnect(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controller);
                        if (sessionCommandGroupOnConnect == null) {
                            try {
                                controller.getControllerCb().onDisconnected(0);
                                return;
                            } catch (RemoteException unused) {
                                return;
                            }
                        }
                        MediaSessionLegacyStub.this.mConnectedControllersManager.addController(controller.getRemoteUserInfo(), controller, sessionCommandGroupOnConnect);
                    }
                    MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                    mediaSessionLegacyStub.mConnectionTimeoutHandler.disconnectControllerAfterTimeout(controller, mediaSessionLegacyStub.mConnectionTimeoutMs);
                    MediaSessionLegacyStub.this.handleTaskOnExecutor(controller, sessionCommand, i2, sessionTask);
                }
            });
            return;
        }
        String str = "RemoteUserInfo is null, ignoring command=" + sessionCommand + ", commandCode=" + i2;
    }

    public ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> getConnectedControllersManager() {
        return this.mConnectedControllersManager;
    }

    public MediaSession.ControllerCb getControllerLegacyCbForBroadcast() {
        return this.mControllerLegacyCbForBroadcast;
    }

    public void handleTaskOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @Nullable SessionCommand sessionCommand, int i2, @NonNull SessionTask sessionTask) {
        SessionCommand sessionCommand2;
        if (sessionCommand != null) {
            if (!this.mConnectedControllersManager.isAllowedCommand(controllerInfo, sessionCommand)) {
                return;
            } else {
                sessionCommand2 = sCommandsForOnCommandRequest.get(sessionCommand.getCommandCode());
            }
        } else if (!this.mConnectedControllersManager.isAllowedCommand(controllerInfo, i2)) {
            return;
        } else {
            sessionCommand2 = sCommandsForOnCommandRequest.get(i2);
        }
        if (sessionCommand2 == null || this.mSessionImpl.getCallback().onCommandRequest(this.mSessionImpl.getInstance(), controllerInfo, sessionCommand2) == 0) {
            try {
                sessionTask.run(controllerInfo);
                return;
            } catch (RemoteException unused) {
                String str = "Exception in " + controllerInfo;
                return;
            }
        }
        if (DEBUG) {
            String str2 = "Command (" + sessionCommand2 + ") from " + controllerInfo + " was rejected by " + this.mSessionImpl;
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        onAddQueueItem(mediaDescriptionCompat, Integer.MAX_VALUE);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCommand(String str, final Bundle bundle, final ResultReceiver resultReceiver) {
        if (str == null) {
            return;
        }
        final SessionCommand sessionCommand = new SessionCommand(str, null);
        dispatchSessionTask(sessionCommand, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.1
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                SessionResult sessionResultOnCustomCommand = MediaSessionLegacyStub.this.mSessionImpl.getCallback().onCustomCommand(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, sessionCommand, bundle);
                ResultReceiver resultReceiver2 = resultReceiver;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(sessionResultOnCustomCommand.getResultCode(), sessionResultOnCustomCommand.getCustomCommandResult());
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCustomAction(@NonNull String str, @Nullable Bundle bundle) {
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onFastForward() {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.13
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.mSessionImpl.getCallback().onFastForward(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPause() {
        dispatchSessionTask(10001, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.6
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.mSessionImpl.pause();
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlay() {
        dispatchSessionTask(10000, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.4
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.mSessionImpl.play();
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromMediaId(String str, Bundle bundle) {
        onPlayFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PLAY_FROM_MEDIA_ID).appendQueryParameter("id", str).build(), bundle);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromSearch(String str, Bundle bundle) {
        onPlayFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PLAY_FROM_SEARCH).appendQueryParameter(MediaConstants.MEDIA_URI_QUERY_QUERY, str).build(), bundle);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromUri(final Uri uri, final Bundle bundle) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.5
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                if (MediaSessionLegacyStub.this.mSessionImpl.getCallback().onSetMediaUri(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, uri, bundle) == 0) {
                    MediaSessionLegacyStub.this.mSessionImpl.play();
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepare() {
        dispatchSessionTask(10002, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.2
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.mSessionImpl.prepare();
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromMediaId(String str, Bundle bundle) {
        onPrepareFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PREPARE_FROM_MEDIA_ID).appendQueryParameter("id", str).build(), bundle);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromSearch(String str, Bundle bundle) {
        onPrepareFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PREPARE_FROM_SEARCH).appendQueryParameter(MediaConstants.MEDIA_URI_QUERY_QUERY, str).build(), bundle);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromUri(final Uri uri, final Bundle bundle) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.3
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                if (MediaSessionLegacyStub.this.mSessionImpl.getCallback().onSetMediaUri(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, uri, bundle) == 0) {
                    MediaSessionLegacyStub.this.mSessionImpl.prepare();
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_REMOVE_PLAYLIST_ITEM, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.19
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                String mediaId = mediaDescriptionCompat.getMediaId();
                if (TextUtils.isEmpty(mediaId)) {
                    return;
                }
                List<MediaItem> playlist = MediaSessionLegacyStub.this.mSessionImpl.getPlaylist();
                for (int i2 = 0; i2 < playlist.size(); i2++) {
                    if (TextUtils.equals(playlist.get(i2).getMediaId(), mediaId)) {
                        MediaSessionLegacyStub.this.mSessionImpl.removePlaylistItem(i2);
                        return;
                    }
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItemAt(final int i2) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_REMOVE_PLAYLIST_ITEM, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.20
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                int i3 = i2;
                if (i3 < 0) {
                    return;
                }
                MediaSessionLegacyStub.this.mSessionImpl.removePlaylistItem(i3);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRewind() {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_REWIND, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.14
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.mSessionImpl.getCallback().onRewind(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSeekTo(final long j2) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SEEK_TO, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.8
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.mSessionImpl.seekTo(j2);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetCaptioningEnabled(boolean z) {
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetPlaybackSpeed(final float f2) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_SPEED, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.11
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.mSessionImpl.setPlaybackSpeed(f2);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat) {
        onSetRating(ratingCompat, null);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRepeatMode(final int i2) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_REPEAT_MODE, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.16
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.mSessionImpl.setRepeatMode(i2);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetShuffleMode(final int i2) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_SHUFFLE_MODE, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.17
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.mSessionImpl.setShuffleMode(i2);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToNext() {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_NEXT_PLAYLIST_ITEM, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.9
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.mSessionImpl.skipToNextItem();
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToPrevious() {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_PREVIOUS_PLAYLIST_ITEM, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.10
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.mSessionImpl.skipToPreviousItem();
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToQueueItem(final long j2) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_PLAYLIST_ITEM, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.12
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                if (MediaSessionLegacyStub.this.mSessionImpl.getPlayer().getPlaylist() == null) {
                    return;
                }
                MediaSessionLegacyStub.this.mSessionImpl.skipToPlaylistItem((int) j2);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onStop() {
        dispatchSessionTask(10001, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.7
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.handleTaskOnExecutor(controllerInfo, null, SessionCommand.COMMAND_CODE_PLAYER_SEEK_TO, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.7.1
                    @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                    public void run(MediaSession.ControllerInfo controllerInfo2) {
                        MediaSessionLegacyStub.this.mSessionImpl.pause();
                        MediaSessionLegacyStub.this.mSessionImpl.seekTo(0L);
                    }
                });
            }
        });
    }

    public void setLegacyControllerDisconnectTimeoutMs(long j2) {
        this.mConnectionTimeoutMs = j2;
    }

    private void dispatchSessionTask(@NonNull SessionCommand sessionCommand, @NonNull SessionTask sessionTask) {
        dispatchSessionTaskInternal(sessionCommand, 0, sessionTask);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int i2) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.18
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                String mediaId = mediaDescriptionCompat.getMediaId();
                if (TextUtils.isEmpty(mediaId)) {
                    return;
                }
                MediaSessionLegacyStub.this.mSessionImpl.addPlaylistItem(i2, MediaSessionLegacyStub.this.mSessionImpl.getCallback().onCreateMediaItem(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, mediaId));
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(final RatingCompat ratingCompat, Bundle bundle) {
        if (ratingCompat == null) {
            return;
        }
        dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.15
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) {
                MediaItem currentMediaItem = MediaSessionLegacyStub.this.mSessionImpl.getCurrentMediaItem();
                if (currentMediaItem == null) {
                    return;
                }
                MediaSessionLegacyStub.this.mSessionImpl.getCallback().onSetRating(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, currentMediaItem.getMediaId(), MediaUtils.convertToRating(ratingCompat));
            }
        });
    }
}
