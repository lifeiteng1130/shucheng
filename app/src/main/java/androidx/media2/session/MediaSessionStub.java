package androidx.media2.session;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.IMediaSession;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SessionCommandGroup;
import androidx.versionedparcelable.ParcelImpl;
import c.e.b.a.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionStub extends IMediaSession.Stub {
    private static final boolean RETHROW_EXCEPTION = true;
    public final ConnectedControllersManager<IBinder> mConnectedControllersManager;
    public final Context mContext;
    public final Object mLock = new Object();
    public final MediaSession.MediaSessionImpl mSessionImpl;
    public final androidx.media.MediaSessionManager mSessionManager;
    private static final String TAG = "MediaSessionStub";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);
    public static final SparseArray<SessionCommand> sCommandsForOnCommandRequest = new SparseArray<>();

    public final class Controller2Cb extends MediaSession.ControllerCb {
        private final IMediaController mIControllerCallback;

        public Controller2Cb(@NonNull IMediaController iMediaController) {
            this.mIControllerCallback = iMediaController;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != Controller2Cb.class) {
                return false;
            }
            return ObjectsCompat.equals(getCallbackBinder(), ((Controller2Cb) obj).getCallbackBinder());
        }

        @NonNull
        public IBinder getCallbackBinder() {
            return this.mIControllerCallback.asBinder();
        }

        public int hashCode() {
            return ObjectsCompat.hash(getCallbackBinder());
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onAllowedCommandsChanged(int i2, @NonNull SessionCommandGroup sessionCommandGroup) {
            this.mIControllerCallback.onAllowedCommandsChanged(i2, MediaParcelUtils.toParcelable(sessionCommandGroup));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onBufferingStateChanged(int i2, @NonNull MediaItem mediaItem, int i3, long j2, long j3, long j4) {
            this.mIControllerCallback.onBufferingStateChanged(i2, MediaParcelUtils.toParcelable(mediaItem), i3, j2, j3, j4);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i2, @NonNull String str, int i3, MediaLibraryService.LibraryParams libraryParams) {
            this.mIControllerCallback.onChildrenChanged(i2, str, i3, MediaParcelUtils.toParcelable(libraryParams));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onCurrentMediaItemChanged(int i2, MediaItem mediaItem, int i3, int i4, int i5) {
            this.mIControllerCallback.onCurrentMediaItemChanged(i2, MediaParcelUtils.toParcelable(mediaItem), i3, i4, i5);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onDisconnected(int i2) {
            this.mIControllerCallback.onDisconnected(i2);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onLibraryResult(int i2, LibraryResult libraryResult) {
            if (libraryResult == null) {
                libraryResult = new LibraryResult(-1);
            }
            this.mIControllerCallback.onLibraryResult(i2, MediaParcelUtils.toParcelable(libraryResult));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackCompleted(int i2) {
            this.mIControllerCallback.onPlaybackCompleted(i2);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackInfoChanged(int i2, @NonNull MediaController.PlaybackInfo playbackInfo) {
            this.mIControllerCallback.onPlaybackInfoChanged(i2, MediaParcelUtils.toParcelable(playbackInfo));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackSpeedChanged(int i2, long j2, long j3, float f2) {
            this.mIControllerCallback.onPlaybackSpeedChanged(i2, j2, j3, f2);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerResult(int i2, @Nullable SessionPlayer.PlayerResult playerResult) {
            onSessionResult(i2, SessionResult.from(playerResult));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerStateChanged(int i2, long j2, long j3, int i3) {
            this.mIControllerCallback.onPlayerStateChanged(i2, j2, j3, i3);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistChanged(int i2, @NonNull List<MediaItem> list, MediaMetadata mediaMetadata, int i3, int i4, int i5) {
            MediaSession.ControllerInfo controller = MediaSessionStub.this.mConnectedControllersManager.getController(getCallbackBinder());
            if (MediaSessionStub.this.mConnectedControllersManager.isAllowedCommand(controller, SessionCommand.COMMAND_CODE_PLAYER_GET_PLAYLIST)) {
                this.mIControllerCallback.onPlaylistChanged(i2, MediaUtils.convertMediaItemListToParcelImplListSlice(list), MediaParcelUtils.toParcelable(mediaMetadata), i3, i4, i5);
            } else if (MediaSessionStub.this.mConnectedControllersManager.isAllowedCommand(controller, SessionCommand.COMMAND_CODE_PLAYER_GET_PLAYLIST_METADATA)) {
                this.mIControllerCallback.onPlaylistMetadataChanged(i2, MediaParcelUtils.toParcelable(mediaMetadata));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistMetadataChanged(int i2, MediaMetadata mediaMetadata) {
            if (MediaSessionStub.this.mConnectedControllersManager.isAllowedCommand(MediaSessionStub.this.mConnectedControllersManager.getController(getCallbackBinder()), SessionCommand.COMMAND_CODE_PLAYER_GET_PLAYLIST_METADATA)) {
                this.mIControllerCallback.onPlaylistMetadataChanged(i2, MediaParcelUtils.toParcelable(mediaMetadata));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onRepeatModeChanged(int i2, int i3, int i4, int i5, int i6) {
            this.mIControllerCallback.onRepeatModeChanged(i2, i3, i4, i5, i6);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i2, @NonNull String str, int i3, MediaLibraryService.LibraryParams libraryParams) {
            this.mIControllerCallback.onSearchResultChanged(i2, str, i3, MediaParcelUtils.toParcelable(libraryParams));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSeekCompleted(int i2, long j2, long j3, long j4) {
            this.mIControllerCallback.onSeekCompleted(i2, j2, j3, j4);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSessionResult(int i2, @Nullable SessionResult sessionResult) {
            if (sessionResult == null) {
                sessionResult = new SessionResult(-1, null);
            }
            this.mIControllerCallback.onSessionResult(i2, MediaParcelUtils.toParcelable(sessionResult));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onShuffleModeChanged(int i2, int i3, int i4, int i5, int i6) {
            this.mIControllerCallback.onShuffleModeChanged(i2, i3, i4, i5, i6);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSubtitleData(int i2, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
            this.mIControllerCallback.onSubtitleData(i2, MediaParcelUtils.toParcelable(mediaItem), MediaParcelUtils.toParcelable(trackInfo), MediaParcelUtils.toParcelable(subtitleData));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackDeselected(int i2, SessionPlayer.TrackInfo trackInfo) {
            this.mIControllerCallback.onTrackDeselected(i2, MediaParcelUtils.toParcelable(trackInfo));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackSelected(int i2, SessionPlayer.TrackInfo trackInfo) {
            this.mIControllerCallback.onTrackSelected(i2, MediaParcelUtils.toParcelable(trackInfo));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTracksChanged(int i2, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) {
            this.mIControllerCallback.onTrackInfoChanged(i2, MediaParcelUtils.toParcelableList(list), MediaParcelUtils.toParcelable(trackInfo), MediaParcelUtils.toParcelable(trackInfo2), MediaParcelUtils.toParcelable(trackInfo3), MediaParcelUtils.toParcelable(trackInfo4));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onVideoSizeChanged(int i2, @NonNull VideoSize videoSize) {
            this.mIControllerCallback.onVideoSizeChanged(i2, MediaParcelUtils.toParcelable(new MediaItem.Builder().build()), MediaParcelUtils.toParcelable(videoSize));
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i2, @NonNull SessionCommand sessionCommand, Bundle bundle) {
            this.mIControllerCallback.onCustomCommand(i2, MediaParcelUtils.toParcelable(sessionCommand), bundle);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void setCustomLayout(int i2, @NonNull List<MediaSession.CommandButton> list) {
            this.mIControllerCallback.onSetCustomLayout(i2, MediaUtils.convertCommandButtonListToParcelImplList(list));
        }
    }

    public interface LibrarySessionCallbackTask<T> extends SessionTask {
        T run(MediaSession.ControllerInfo controllerInfo);
    }

    public interface SessionCallbackTask<T> extends SessionTask {
        T run(MediaSession.ControllerInfo controllerInfo);
    }

    public interface SessionPlayerTask extends SessionTask {
        a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo);
    }

    public interface SessionTask {
    }

    static {
        for (SessionCommand sessionCommand : new SessionCommandGroup.Builder().addAllPlayerCommands(2).addAllVolumeCommands(2).build().getCommands()) {
            sCommandsForOnCommandRequest.append(sessionCommand.getCommandCode(), sessionCommand);
        }
    }

    public MediaSessionStub(MediaSession.MediaSessionImpl mediaSessionImpl) {
        this.mSessionImpl = mediaSessionImpl;
        Context context = mediaSessionImpl.getContext();
        this.mContext = context;
        this.mSessionManager = androidx.media.MediaSessionManager.getSessionManager(context);
        this.mConnectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
    }

    private void dispatchLibrarySessionTask(@NonNull IMediaController iMediaController, int i2, int i3, @NonNull LibrarySessionCallbackTask<?> librarySessionCallbackTask) {
        if (!(this.mSessionImpl instanceof MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl)) {
            throw new RuntimeException("MediaSession cannot handle MediaLibrarySession command");
        }
        dispatchSessionTaskInternal(iMediaController, i2, null, i3, librarySessionCallbackTask);
    }

    private void dispatchSessionTask(@NonNull IMediaController iMediaController, int i2, int i3, @NonNull SessionTask sessionTask) {
        dispatchSessionTaskInternal(iMediaController, i2, null, i3, sessionTask);
    }

    private void dispatchSessionTaskInternal(@NonNull IMediaController iMediaController, final int i2, @Nullable final SessionCommand sessionCommand, final int i3, @NonNull final SessionTask sessionTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final MediaSession.ControllerInfo controller = this.mConnectedControllersManager.getController(iMediaController.asBinder());
            if (!this.mSessionImpl.isClosed() && controller != null) {
                this.mSessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaSessionStub.1
                    @Override // java.lang.Runnable
                    public void run() throws Exception {
                        SessionCommand sessionCommand2;
                        if (MediaSessionStub.this.mConnectedControllersManager.isConnected(controller)) {
                            SessionCommand sessionCommand3 = sessionCommand;
                            if (sessionCommand3 != null) {
                                if (!MediaSessionStub.this.mConnectedControllersManager.isAllowedCommand(controller, sessionCommand3)) {
                                    if (MediaSessionStub.DEBUG) {
                                        StringBuilder sbR = c.a.a.a.a.r("Command (");
                                        sbR.append(sessionCommand);
                                        sbR.append(") from ");
                                        sbR.append(controller);
                                        sbR.append(" isn't allowed.");
                                        sbR.toString();
                                    }
                                    MediaSessionStub.sendSessionResult(controller, i2, -4);
                                    return;
                                }
                                sessionCommand2 = MediaSessionStub.sCommandsForOnCommandRequest.get(sessionCommand.getCommandCode());
                            } else {
                                if (!MediaSessionStub.this.mConnectedControllersManager.isAllowedCommand(controller, i3)) {
                                    if (MediaSessionStub.DEBUG) {
                                        StringBuilder sbR2 = c.a.a.a.a.r("Command (");
                                        sbR2.append(i3);
                                        sbR2.append(") from ");
                                        sbR2.append(controller);
                                        sbR2.append(" isn't allowed.");
                                        sbR2.toString();
                                    }
                                    MediaSessionStub.sendSessionResult(controller, i2, -4);
                                    return;
                                }
                                sessionCommand2 = MediaSessionStub.sCommandsForOnCommandRequest.get(i3);
                            }
                            if (sessionCommand2 != null) {
                                try {
                                    int iOnCommandRequest = MediaSessionStub.this.mSessionImpl.getCallback().onCommandRequest(MediaSessionStub.this.mSessionImpl.getInstance(), controller, sessionCommand2);
                                    if (iOnCommandRequest != 0) {
                                        if (MediaSessionStub.DEBUG) {
                                            String str = "Command (" + sessionCommand2 + ") from " + controller + " was rejected by " + MediaSessionStub.this.mSessionImpl + ", code=" + iOnCommandRequest;
                                        }
                                        MediaSessionStub.sendSessionResult(controller, i2, iOnCommandRequest);
                                        return;
                                    }
                                } catch (RemoteException unused) {
                                    controller.toString();
                                    return;
                                } catch (Exception e2) {
                                    throw e2;
                                }
                            }
                            SessionTask sessionTask2 = sessionTask;
                            if (sessionTask2 instanceof SessionPlayerTask) {
                                final a<SessionPlayer.PlayerResult> aVarRun = ((SessionPlayerTask) sessionTask2).run(controller);
                                if (aVarRun != null) {
                                    aVarRun.addListener(new Runnable() { // from class: androidx.media2.session.MediaSessionStub.1.1
                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                MediaSessionStub.sendPlayerResult(controller, i2, (SessionPlayer.PlayerResult) aVarRun.get(0L, TimeUnit.MILLISECONDS));
                                            } catch (Exception unused2) {
                                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                                MediaSessionStub.sendSessionResult(controller, i2, -2);
                                            }
                                        }
                                    }, MediaUtils.DIRECT_EXECUTOR);
                                    return;
                                }
                                throw new RuntimeException("SessionPlayer has returned null, commandCode=" + i3);
                            }
                            if (sessionTask2 instanceof SessionCallbackTask) {
                                Object objRun = ((SessionCallbackTask) sessionTask2).run(controller);
                                if (objRun == null) {
                                    throw new RuntimeException("SessionCallback has returned null, commandCode=" + i3);
                                }
                                if (objRun instanceof Integer) {
                                    MediaSessionStub.sendSessionResult(controller, i2, ((Integer) objRun).intValue());
                                    return;
                                }
                                if (objRun instanceof SessionResult) {
                                    MediaSessionStub.sendSessionResult(controller, i2, (SessionResult) objRun);
                                    return;
                                } else {
                                    if (MediaSessionStub.DEBUG) {
                                        throw new RuntimeException("Unexpected return type " + objRun + ". Fix bug");
                                    }
                                    return;
                                }
                            }
                            if (!(sessionTask2 instanceof LibrarySessionCallbackTask)) {
                                if (MediaSessionStub.DEBUG) {
                                    throw new RuntimeException("Unknown task " + sessionTask + ". Fix bug");
                                }
                                return;
                            }
                            Object objRun2 = ((LibrarySessionCallbackTask) sessionTask2).run(controller);
                            if (objRun2 == null) {
                                throw new RuntimeException("LibrarySessionCallback has returned null, commandCode=" + i3);
                            }
                            if (objRun2 instanceof Integer) {
                                MediaSessionStub.sendLibraryResult(controller, i2, ((Integer) objRun2).intValue());
                                return;
                            }
                            if (objRun2 instanceof LibraryResult) {
                                MediaSessionStub.sendLibraryResult(controller, i2, (LibraryResult) objRun2);
                            } else if (MediaSessionStub.DEBUG) {
                                throw new RuntimeException("Unexpected return type " + objRun2 + ". Fix bug");
                            }
                        }
                    }
                });
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    public static void sendLibraryResult(@NonNull MediaSession.ControllerInfo controllerInfo, int i2, int i3) {
        sendLibraryResult(controllerInfo, i2, new LibraryResult(i3));
    }

    public static void sendPlayerResult(@NonNull MediaSession.ControllerInfo controllerInfo, int i2, @NonNull SessionPlayer.PlayerResult playerResult) {
        try {
            controllerInfo.getControllerCb().onPlayerResult(i2, playerResult);
        } catch (RemoteException unused) {
            controllerInfo.toString();
        }
    }

    public static void sendSessionResult(@NonNull MediaSession.ControllerInfo controllerInfo, int i2, int i3) {
        sendSessionResult(controllerInfo, i2, new SessionResult(i3));
    }

    @Override // androidx.media2.session.IMediaSession
    public void addPlaylistItem(IMediaController iMediaController, int i2, final int i3, final String str) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.20
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                if (!TextUtils.isEmpty(str)) {
                    MediaItem mediaItemConvertMediaItemOnExecutor = MediaSessionStub.this.convertMediaItemOnExecutor(controllerInfo, str);
                    return mediaItemConvertMediaItemOnExecutor == null ? SessionPlayer.PlayerResult.createFuture(-3) : MediaSessionStub.this.mSessionImpl.addPlaylistItem(i3, mediaItemConvertMediaItemOnExecutor);
                }
                String str2 = "addPlaylistItem(): Ignoring empty mediaId from " + controllerInfo;
                return SessionPlayer.PlayerResult.createFuture(-3);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void adjustVolume(IMediaController iMediaController, int i2, final int i3, final int i4) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_VOLUME_ADJUST_VOLUME, new SessionCallbackTask<Integer>() { // from class: androidx.media2.session.MediaSessionStub.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionCompat sessionCompat = MediaSessionStub.this.mSessionImpl.getSessionCompat();
                if (sessionCompat != null) {
                    sessionCompat.getController().adjustVolume(i3, i4);
                }
                return 0;
            }
        });
    }

    public void connect(final IMediaController iMediaController, int i2, String str, int i3, int i4, @Nullable Bundle bundle) {
        MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(str, i3, i4);
        final MediaSession.ControllerInfo controllerInfo = new MediaSession.ControllerInfo(remoteUserInfo, i2, this.mSessionManager.isTrustedForMediaControl(remoteUserInfo), new Controller2Cb(iMediaController), bundle);
        this.mSessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaSessionStub.2
            @Override // java.lang.Runnable
            public void run() {
                SequencedFutureManager sequencedFutureManager;
                if (MediaSessionStub.this.mSessionImpl.isClosed()) {
                    return;
                }
                IBinder callbackBinder = ((Controller2Cb) controllerInfo.getControllerCb()).getCallbackBinder();
                SessionCommandGroup sessionCommandGroupOnConnect = MediaSessionStub.this.mSessionImpl.getCallback().onConnect(MediaSessionStub.this.mSessionImpl.getInstance(), controllerInfo);
                if (!(sessionCommandGroupOnConnect != null || controllerInfo.isTrusted())) {
                    if (MediaSessionStub.DEBUG) {
                        StringBuilder sbR = c.a.a.a.a.r("Rejecting connection, controllerInfo=");
                        sbR.append(controllerInfo);
                        sbR.toString();
                    }
                    try {
                        iMediaController.onDisconnected(0);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                if (MediaSessionStub.DEBUG) {
                    StringBuilder sbR2 = c.a.a.a.a.r("Accepting connection, controllerInfo=");
                    sbR2.append(controllerInfo);
                    sbR2.append(" allowedCommands=");
                    sbR2.append(sessionCommandGroupOnConnect);
                    sbR2.toString();
                }
                if (sessionCommandGroupOnConnect == null) {
                    sessionCommandGroupOnConnect = new SessionCommandGroup();
                }
                synchronized (MediaSessionStub.this.mLock) {
                    if (MediaSessionStub.this.mConnectedControllersManager.isConnected(controllerInfo)) {
                        String str2 = "Controller " + controllerInfo + " has sent connection request multiple times";
                    }
                    MediaSessionStub.this.mConnectedControllersManager.addController(callbackBinder, controllerInfo, sessionCommandGroupOnConnect);
                    sequencedFutureManager = MediaSessionStub.this.mConnectedControllersManager.getSequencedFutureManager(controllerInfo);
                }
                MediaSessionStub mediaSessionStub = MediaSessionStub.this;
                ConnectionResult connectionResult = new ConnectionResult(mediaSessionStub, mediaSessionStub.mSessionImpl, sessionCommandGroupOnConnect);
                if (MediaSessionStub.this.mSessionImpl.isClosed()) {
                    return;
                }
                try {
                    iMediaController.onConnected(sequencedFutureManager.obtainNextSequenceNumber(), MediaParcelUtils.toParcelable(connectionResult));
                } catch (RemoteException unused2) {
                }
                MediaSessionStub.this.mSessionImpl.getCallback().onPostConnect(MediaSessionStub.this.mSessionImpl.getInstance(), controllerInfo);
            }
        });
    }

    @Nullable
    public MediaItem convertMediaItemOnExecutor(MediaSession.ControllerInfo controllerInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MediaItem mediaItemOnCreateMediaItem = this.mSessionImpl.getCallback().onCreateMediaItem(this.mSessionImpl.getInstance(), controllerInfo, str);
        if (mediaItemOnCreateMediaItem != null && (mediaItemOnCreateMediaItem.getMetadata() == null || !TextUtils.equals(str, mediaItemOnCreateMediaItem.getMetadata().getString("android.media.metadata.MEDIA_ID")))) {
            throw new RuntimeException(c.a.a.a.a.k("onCreateMediaItem(mediaId=", str, "): media ID in the returned media item should match"));
        }
        return mediaItemOnCreateMediaItem;
    }

    @Override // androidx.media2.session.IMediaSession
    public void deselectTrack(IMediaController iMediaController, int i2, final ParcelImpl parcelImpl) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_DESELECT_TRACK, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.31
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl);
                return trackInfo == null ? SessionPlayer.PlayerResult.createFuture(-3) : MediaSessionStub.this.mSessionImpl.deselectTrack(trackInfo);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void fastForward(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, new SessionCallbackTask<Integer>() { // from class: androidx.media2.session.MediaSessionStub.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                return Integer.valueOf(MediaSessionStub.this.mSessionImpl.getCallback().onFastForward(MediaSessionStub.this.mSessionImpl.getInstance(), controllerInfo));
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void getChildren(IMediaController iMediaController, int i2, final String str, final int i3, final int i4, final ParcelImpl parcelImpl) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        dispatchLibrarySessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, new LibrarySessionCallbackTask<LibraryResult>() { // from class: androidx.media2.session.MediaSessionStub.34
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
            public LibraryResult run(MediaSession.ControllerInfo controllerInfo) {
                if (TextUtils.isEmpty(str)) {
                    String str2 = "getChildren(): Ignoring empty parentId from " + controllerInfo;
                    return new LibraryResult(-3);
                }
                if (i3 < 0) {
                    String str3 = "getChildren(): Ignoring negative page from " + controllerInfo;
                    return new LibraryResult(-3);
                }
                if (i4 >= 1) {
                    return MediaSessionStub.this.getLibrarySession().onGetChildrenOnExecutor(controllerInfo, str, i3, i4, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(parcelImpl));
                }
                String str4 = "getChildren(): Ignoring pageSize less than 1 from " + controllerInfo;
                return new LibraryResult(-3);
            }
        });
    }

    public ConnectedControllersManager<IBinder> getConnectedControllersManager() {
        return this.mConnectedControllersManager;
    }

    @Override // androidx.media2.session.IMediaSession
    public void getItem(IMediaController iMediaController, int i2, final String str) {
        dispatchLibrarySessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, new LibrarySessionCallbackTask<LibraryResult>() { // from class: androidx.media2.session.MediaSessionStub.33
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
            public LibraryResult run(MediaSession.ControllerInfo controllerInfo) {
                if (!TextUtils.isEmpty(str)) {
                    return MediaSessionStub.this.getLibrarySession().onGetItemOnExecutor(controllerInfo, str);
                }
                String str2 = "getItem(): Ignoring empty mediaId from " + controllerInfo;
                return new LibraryResult(-3);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void getLibraryRoot(IMediaController iMediaController, int i2, final ParcelImpl parcelImpl) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        dispatchLibrarySessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, new LibrarySessionCallbackTask<LibraryResult>() { // from class: androidx.media2.session.MediaSessionStub.32
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
            public LibraryResult run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.getLibrarySession().onGetLibraryRootOnExecutor(controllerInfo, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(parcelImpl));
            }
        });
    }

    public MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl getLibrarySession() {
        MediaSession.MediaSessionImpl mediaSessionImpl = this.mSessionImpl;
        if (mediaSessionImpl instanceof MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl) {
            return (MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl) mediaSessionImpl;
        }
        throw new RuntimeException("Session cannot be casted to library session");
    }

    @Override // androidx.media2.session.IMediaSession
    public void getSearchResult(IMediaController iMediaController, int i2, final String str, final int i3, final int i4, final ParcelImpl parcelImpl) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        dispatchLibrarySessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, new LibrarySessionCallbackTask<LibraryResult>() { // from class: androidx.media2.session.MediaSessionStub.36
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
            public LibraryResult run(MediaSession.ControllerInfo controllerInfo) {
                if (TextUtils.isEmpty(str)) {
                    String str2 = "getSearchResult(): Ignoring empty query from " + controllerInfo;
                    return new LibraryResult(-3);
                }
                if (i3 < 0) {
                    String str3 = "getSearchResult(): Ignoring negative page from " + controllerInfo;
                    return new LibraryResult(-3);
                }
                if (i4 >= 1) {
                    return MediaSessionStub.this.getLibrarySession().onGetSearchResultOnExecutor(controllerInfo, str, i3, i4, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(parcelImpl));
                }
                String str4 = "getSearchResult(): Ignoring pageSize less than 1 from " + controllerInfo;
                return new LibraryResult(-3);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void movePlaylistItem(IMediaController iMediaController, int i2, final int i3, final int i4) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_MOVE_PLAYLIST_ITEM, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.23
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.movePlaylistItem(i3, i4);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void onControllerResult(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            SequencedFutureManager sequencedFutureManager = this.mConnectedControllersManager.getSequencedFutureManager(iMediaController.asBinder());
            if (sequencedFutureManager == null) {
                return;
            }
            sequencedFutureManager.setFutureResult(i2, (SessionResult) MediaParcelUtils.fromParcelable(parcelImpl));
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void onCustomCommand(IMediaController iMediaController, int i2, ParcelImpl parcelImpl, final Bundle bundle) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        final SessionCommand sessionCommand = (SessionCommand) MediaParcelUtils.fromParcelable(parcelImpl);
        dispatchSessionTask(iMediaController, i2, sessionCommand, new SessionCallbackTask<SessionResult>() { // from class: androidx.media2.session.MediaSessionStub.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public SessionResult run(MediaSession.ControllerInfo controllerInfo) {
                SessionResult sessionResultOnCustomCommand = MediaSessionStub.this.mSessionImpl.getCallback().onCustomCommand(MediaSessionStub.this.mSessionImpl.getInstance(), controllerInfo, sessionCommand, bundle);
                if (sessionResultOnCustomCommand != null) {
                    return sessionResultOnCustomCommand;
                }
                StringBuilder sbR = c.a.a.a.a.r("SessionCallback#onCustomCommand has returned null, command=");
                sbR.append(sessionCommand);
                throw new RuntimeException(sbR.toString());
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void pause(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, 10001, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.6
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.pause();
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void play(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, 10000, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.5
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.play();
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void prepare(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, 10002, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.7
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.prepare();
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void release(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            this.mConnectedControllersManager.removeController(iMediaController.asBinder());
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void removePlaylistItem(IMediaController iMediaController, int i2, final int i3) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_REMOVE_PLAYLIST_ITEM, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.21
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.removePlaylistItem(i3);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void replacePlaylistItem(IMediaController iMediaController, int i2, final int i3, final String str) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_REPLACE_PLAYLIST_ITEM, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.22
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                if (!TextUtils.isEmpty(str)) {
                    MediaItem mediaItemConvertMediaItemOnExecutor = MediaSessionStub.this.convertMediaItemOnExecutor(controllerInfo, str);
                    return mediaItemConvertMediaItemOnExecutor == null ? SessionPlayer.PlayerResult.createFuture(-3) : MediaSessionStub.this.mSessionImpl.replacePlaylistItem(i3, mediaItemConvertMediaItemOnExecutor);
                }
                String str2 = "replacePlaylistItem(): Ignoring empty mediaId from " + controllerInfo;
                return SessionPlayer.PlayerResult.createFuture(-3);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void rewind(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_SESSION_REWIND, new SessionCallbackTask<Integer>() { // from class: androidx.media2.session.MediaSessionStub.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                return Integer.valueOf(MediaSessionStub.this.mSessionImpl.getCallback().onRewind(MediaSessionStub.this.mSessionImpl.getInstance(), controllerInfo));
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void search(IMediaController iMediaController, int i2, final String str, final ParcelImpl parcelImpl) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        dispatchLibrarySessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, new LibrarySessionCallbackTask<Integer>() { // from class: androidx.media2.session.MediaSessionStub.35
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                if (!TextUtils.isEmpty(str)) {
                    return Integer.valueOf(MediaSessionStub.this.getLibrarySession().onSearchOnExecutor(controllerInfo, str, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(parcelImpl)));
                }
                String str2 = "search(): Ignoring empty query from " + controllerInfo;
                return -3;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void seekTo(IMediaController iMediaController, int i2, final long j2) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_SEEK_TO, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.12
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.seekTo(j2);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void selectTrack(IMediaController iMediaController, int i2, final ParcelImpl parcelImpl) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_SELECT_TRACK, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.30
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl);
                return trackInfo == null ? SessionPlayer.PlayerResult.createFuture(-3) : MediaSessionStub.this.mSessionImpl.selectTrack(trackInfo);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setMediaItem(IMediaController iMediaController, int i2, final String str) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_SET_MEDIA_ITEM, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.17
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                if (!TextUtils.isEmpty(str)) {
                    MediaItem mediaItemConvertMediaItemOnExecutor = MediaSessionStub.this.convertMediaItemOnExecutor(controllerInfo, str);
                    return mediaItemConvertMediaItemOnExecutor == null ? SessionPlayer.PlayerResult.createFuture(-3) : MediaSessionStub.this.mSessionImpl.setMediaItem(mediaItemConvertMediaItemOnExecutor);
                }
                String str2 = "setMediaItem(): Ignoring empty mediaId from " + controllerInfo;
                return SessionPlayer.PlayerResult.createFuture(-3);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setMediaUri(IMediaController iMediaController, int i2, final Uri uri, final Bundle bundle) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, new SessionCallbackTask<Integer>() { // from class: androidx.media2.session.MediaSessionStub.18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                if (uri != null) {
                    return Integer.valueOf(MediaSessionStub.this.mSessionImpl.getCallback().onSetMediaUri(MediaSessionStub.this.mSessionImpl.getInstance(), controllerInfo, uri, bundle));
                }
                String str = "setMediaUri(): Ignoring null uri from " + controllerInfo;
                return -3;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setPlaybackSpeed(IMediaController iMediaController, int i2, final float f2) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_SET_SPEED, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.15
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.setPlaybackSpeed(f2);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setPlaylist(IMediaController iMediaController, int i2, final List<String> list, final ParcelImpl parcelImpl) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_SET_PLAYLIST, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.16
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                if (list == null) {
                    String str = "setPlaylist(): Ignoring null playlist from " + controllerInfo;
                    return SessionPlayer.PlayerResult.createFuture(-3);
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    MediaItem mediaItemConvertMediaItemOnExecutor = MediaSessionStub.this.convertMediaItemOnExecutor(controllerInfo, (String) list.get(i3));
                    if (mediaItemConvertMediaItemOnExecutor != null) {
                        arrayList.add(mediaItemConvertMediaItemOnExecutor);
                    }
                }
                return MediaSessionStub.this.mSessionImpl.setPlaylist(arrayList, (MediaMetadata) MediaParcelUtils.fromParcelable(parcelImpl));
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setRating(IMediaController iMediaController, int i2, final String str, ParcelImpl parcelImpl) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        final Rating rating = (Rating) MediaParcelUtils.fromParcelable(parcelImpl);
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new SessionCallbackTask<Integer>() { // from class: androidx.media2.session.MediaSessionStub.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                if (TextUtils.isEmpty(str)) {
                    String str2 = "setRating(): Ignoring empty mediaId from " + controllerInfo;
                    return -3;
                }
                if (rating != null) {
                    return Integer.valueOf(MediaSessionStub.this.mSessionImpl.getCallback().onSetRating(MediaSessionStub.this.mSessionImpl.getInstance(), controllerInfo, str, rating));
                }
                String str3 = "setRating(): Ignoring null rating from " + controllerInfo;
                return -3;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setRepeatMode(IMediaController iMediaController, int i2, final int i3) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_SET_REPEAT_MODE, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.27
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.setRepeatMode(i3);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setShuffleMode(IMediaController iMediaController, int i2, final int i3) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_SET_SHUFFLE_MODE, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.28
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.setShuffleMode(i3);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setSurface(IMediaController iMediaController, int i2, final Surface surface) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_SET_SURFACE, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.29
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.setSurface(surface);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setVolumeTo(IMediaController iMediaController, int i2, final int i3, final int i4) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_VOLUME_SET_VOLUME, new SessionCallbackTask<Integer>() { // from class: androidx.media2.session.MediaSessionStub.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionCompat sessionCompat = MediaSessionStub.this.mSessionImpl.getSessionCompat();
                if (sessionCompat != null) {
                    sessionCompat.getController().setVolumeTo(i3, i4);
                }
                return 0;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void skipBackward(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_SESSION_SKIP_BACKWARD, new SessionCallbackTask<Integer>() { // from class: androidx.media2.session.MediaSessionStub.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                return Integer.valueOf(MediaSessionStub.this.mSessionImpl.getCallback().onSkipBackward(MediaSessionStub.this.mSessionImpl.getInstance(), controllerInfo));
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void skipForward(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_SESSION_SKIP_FORWARD, new SessionCallbackTask<Integer>() { // from class: androidx.media2.session.MediaSessionStub.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                return Integer.valueOf(MediaSessionStub.this.mSessionImpl.getCallback().onSkipForward(MediaSessionStub.this.mSessionImpl.getInstance(), controllerInfo));
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void skipToNextItem(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_NEXT_PLAYLIST_ITEM, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.26
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.skipToNextItem();
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void skipToPlaylistItem(IMediaController iMediaController, int i2, final int i3) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_PLAYLIST_ITEM, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.24
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                int i4 = i3;
                if (i4 >= 0) {
                    return MediaSessionStub.this.mSessionImpl.skipToPlaylistItem(i4);
                }
                String str = "skipToPlaylistItem(): Ignoring negative index from " + controllerInfo;
                return SessionPlayer.PlayerResult.createFuture(-3);
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void skipToPreviousItem(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_PREVIOUS_PLAYLIST_ITEM, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.25
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.skipToPreviousItem();
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void subscribe(IMediaController iMediaController, int i2, final String str, final ParcelImpl parcelImpl) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        dispatchLibrarySessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE, new LibrarySessionCallbackTask<Integer>() { // from class: androidx.media2.session.MediaSessionStub.37
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                if (!TextUtils.isEmpty(str)) {
                    return Integer.valueOf(MediaSessionStub.this.getLibrarySession().onSubscribeOnExecutor(controllerInfo, str, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(parcelImpl)));
                }
                String str2 = "subscribe(): Ignoring empty parentId from " + controllerInfo;
                return -3;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void unsubscribe(IMediaController iMediaController, int i2, final String str) {
        if (iMediaController == null) {
            return;
        }
        dispatchLibrarySessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE, new LibrarySessionCallbackTask<Integer>() { // from class: androidx.media2.session.MediaSessionStub.38
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                if (!TextUtils.isEmpty(str)) {
                    return Integer.valueOf(MediaSessionStub.this.getLibrarySession().onUnsubscribeOnExecutor(controllerInfo, str));
                }
                String str2 = "unsubscribe(): Ignoring empty parentId from " + controllerInfo;
                return -3;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void updatePlaylistMetadata(IMediaController iMediaController, int i2, final ParcelImpl parcelImpl) {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i2, SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA, new SessionPlayerTask() { // from class: androidx.media2.session.MediaSessionStub.19
            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public a<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                return MediaSessionStub.this.mSessionImpl.updatePlaylistMetadata((MediaMetadata) MediaParcelUtils.fromParcelable(parcelImpl));
            }
        });
    }

    private void dispatchSessionTask(@NonNull IMediaController iMediaController, int i2, @NonNull SessionCommand sessionCommand, @NonNull SessionTask sessionTask) {
        dispatchSessionTaskInternal(iMediaController, i2, sessionCommand, 0, sessionTask);
    }

    public static void sendLibraryResult(@NonNull MediaSession.ControllerInfo controllerInfo, int i2, @NonNull LibraryResult libraryResult) {
        try {
            controllerInfo.getControllerCb().onLibraryResult(i2, libraryResult);
        } catch (RemoteException unused) {
            controllerInfo.toString();
        }
    }

    public static void sendSessionResult(@NonNull MediaSession.ControllerInfo controllerInfo, int i2, @NonNull SessionResult sessionResult) {
        try {
            controllerInfo.getControllerCb().onSessionResult(i2, sessionResult);
        } catch (RemoteException unused) {
            controllerInfo.toString();
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void connect(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
        if (iMediaController == null || parcelImpl == null) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        ConnectionRequest connectionRequest = (ConnectionRequest) MediaParcelUtils.fromParcelable(parcelImpl);
        if (callingPid == 0) {
            callingPid = connectionRequest.getPid();
        }
        try {
            connect(iMediaController, connectionRequest.getVersion(), connectionRequest.getPackageName(), callingPid, callingUid, connectionRequest.getConnectionHints());
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }
}
