package androidx.media2.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.IMediaSession;
import androidx.media2.session.IMediaSessionService;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SequencedFutureManager;
import c.e.b.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class MediaControllerImplBase implements MediaController.MediaControllerImpl {
    private static final boolean THROW_EXCEPTION_FOR_NULL_RESULT = true;

    @GuardedBy("mLock")
    private SessionCommandGroup mAllowedCommands;

    @GuardedBy("mLock")
    private long mBufferedPositionMs;

    @GuardedBy("mLock")
    private int mBufferingState;

    @GuardedBy("mLock")
    private SessionToken mConnectedToken;
    private final Context mContext;
    public final MediaControllerStub mControllerStub;

    @GuardedBy("mLock")
    private MediaItem mCurrentMediaItem;
    private final IBinder.DeathRecipient mDeathRecipient;

    @GuardedBy("mLock")
    private volatile IMediaSession mISession;
    public final MediaController mInstance;

    @GuardedBy("mLock")
    private boolean mIsReleased;

    @GuardedBy("mLock")
    private MediaController.PlaybackInfo mPlaybackInfo;

    @GuardedBy("mLock")
    private float mPlaybackSpeed;

    @GuardedBy("mLock")
    private int mPlayerState;

    @GuardedBy("mLock")
    private List<MediaItem> mPlaylist;

    @GuardedBy("mLock")
    private MediaMetadata mPlaylistMetadata;

    @GuardedBy("mLock")
    private long mPositionEventTimeMs;

    @GuardedBy("mLock")
    private long mPositionMs;

    @GuardedBy("mLock")
    private int mRepeatMode;
    public final SequencedFutureManager mSequencedFutureManager;

    @GuardedBy("mLock")
    private SessionServiceConnection mServiceConnection;

    @GuardedBy("mLock")
    private PendingIntent mSessionActivity;

    @GuardedBy("mLock")
    private int mShuffleMode;
    public final SessionToken mToken;
    private static final SessionResult RESULT_WHEN_CLOSED = new SessionResult(1);
    public static final String TAG = "MC2ImplBase";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private int mCurrentMediaItemIndex = -1;

    @GuardedBy("mLock")
    private int mPreviousMediaItemIndex = -1;

    @GuardedBy("mLock")
    private int mNextMediaItemIndex = -1;

    @GuardedBy("mLock")
    private VideoSize mVideoSize = new VideoSize(0, 0);

    @GuardedBy("mLock")
    private List<SessionPlayer.TrackInfo> mTracks = Collections.emptyList();

    @GuardedBy("mLock")
    private SparseArray<SessionPlayer.TrackInfo> mSelectedTracks = new SparseArray<>();

    @FunctionalInterface
    public interface RemoteSessionTask {
        void run(IMediaSession iMediaSession, int i2);
    }

    public class SessionServiceConnection implements ServiceConnection {
        private final Bundle mConnectionHints;

        public SessionServiceConnection(@Nullable Bundle bundle) {
            this.mConnectionHints = bundle;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            MediaControllerImplBase.this.mInstance.close();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (MediaControllerImplBase.DEBUG) {
                    String str = "onServiceConnected " + componentName + " " + this;
                }
                if (MediaControllerImplBase.this.mToken.getPackageName().equals(componentName.getPackageName())) {
                    IMediaSessionService iMediaSessionServiceAsInterface = IMediaSessionService.Stub.asInterface(iBinder);
                    if (iMediaSessionServiceAsInterface == null) {
                        Log.wtf(MediaControllerImplBase.TAG, "Service interface is missing.");
                        return;
                    } else {
                        iMediaSessionServiceAsInterface.connect(MediaControllerImplBase.this.mControllerStub, MediaParcelUtils.toParcelable(new ConnectionRequest(MediaControllerImplBase.this.getContext().getPackageName(), Process.myPid(), this.mConnectionHints)));
                        return;
                    }
                }
                Log.wtf(MediaControllerImplBase.TAG, "Expected connection to " + MediaControllerImplBase.this.mToken.getPackageName() + " but is connected to " + componentName);
            } catch (RemoteException unused) {
                String str2 = "Service " + componentName + " has died prematurely";
            } finally {
                MediaControllerImplBase.this.mInstance.close();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (MediaControllerImplBase.DEBUG) {
                String str = "Session service " + componentName + " is disconnected.";
            }
            MediaControllerImplBase.this.mInstance.close();
        }
    }

    public MediaControllerImplBase(Context context, MediaController mediaController, SessionToken sessionToken, @Nullable Bundle bundle) {
        boolean zRequestConnectToService;
        this.mInstance = mediaController;
        Objects.requireNonNull(context, "context shouldn't be null");
        Objects.requireNonNull(sessionToken, "token shouldn't be null");
        this.mContext = context;
        SequencedFutureManager sequencedFutureManager = new SequencedFutureManager();
        this.mSequencedFutureManager = sequencedFutureManager;
        this.mControllerStub = new MediaControllerStub(this, sequencedFutureManager);
        this.mToken = sessionToken;
        this.mDeathRecipient = new IBinder.DeathRecipient() { // from class: androidx.media2.session.MediaControllerImplBase.1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                MediaControllerImplBase.this.mInstance.close();
            }
        };
        if (sessionToken.getType() == 0) {
            this.mServiceConnection = null;
            zRequestConnectToService = requestConnectToSession(bundle);
        } else {
            this.mServiceConnection = new SessionServiceConnection(bundle);
            zRequestConnectToService = requestConnectToService();
        }
        if (zRequestConnectToService) {
            return;
        }
        mediaController.close();
    }

    private a<SessionResult> dispatchRemoteSessionTask(int i2, RemoteSessionTask remoteSessionTask) {
        return dispatchRemoteSessionTaskInternal(i2, null, remoteSessionTask);
    }

    private a<SessionResult> dispatchRemoteSessionTaskInternal(int i2, SessionCommand sessionCommand, RemoteSessionTask remoteSessionTask) {
        IMediaSession sessionInterfaceIfAble = sessionCommand != null ? getSessionInterfaceIfAble(sessionCommand) : getSessionInterfaceIfAble(i2);
        if (sessionInterfaceIfAble == null) {
            return SessionResult.createFutureWithResult(-4);
        }
        SequencedFutureManager.SequencedFuture sequencedFutureCreateSequencedFuture = this.mSequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
        try {
            remoteSessionTask.run(sessionInterfaceIfAble, sequencedFutureCreateSequencedFuture.getSequenceNumber());
        } catch (RemoteException unused) {
            sequencedFutureCreateSequencedFuture.set(new SessionResult(-100));
        }
        return sequencedFutureCreateSequencedFuture;
    }

    private boolean requestConnectToService() {
        Intent intent = new Intent(MediaSessionService.SERVICE_INTERFACE);
        intent.setClassName(this.mToken.getPackageName(), this.mToken.getServiceName());
        synchronized (this.mLock) {
            if (!this.mContext.bindService(intent, this.mServiceConnection, 4097)) {
                String str = "bind to " + this.mToken + " failed";
                return false;
            }
            if (!DEBUG) {
                return true;
            }
            StringBuilder sbR = c.a.a.a.a.r("bind to ");
            sbR.append(this.mToken);
            sbR.append(" succeeded");
            sbR.toString();
            return true;
        }
    }

    private boolean requestConnectToSession(@Nullable Bundle bundle) {
        try {
            IMediaSession.Stub.asInterface((IBinder) this.mToken.getBinder()).connect(this.mControllerStub, this.mSequencedFutureManager.obtainNextSequenceNumber(), MediaParcelUtils.toParcelable(new ConnectionRequest(this.mContext.getPackageName(), Process.myPid(), bundle)));
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> addPlaylistItem(final int i2, @NonNull final String str) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.20
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) {
                iMediaSession.addPlaylistItem(MediaControllerImplBase.this.mControllerStub, i3, i2, str);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> adjustVolume(final int i2, final int i3) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_VOLUME_ADJUST_VOLUME, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.12
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i4) {
                iMediaSession.adjustVolume(MediaControllerImplBase.this.mControllerStub, i4, i2, i3);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (DEBUG) {
            StringBuilder sbR = c.a.a.a.a.r("release from ");
            sbR.append(this.mToken);
            sbR.toString();
        }
        synchronized (this.mLock) {
            IMediaSession iMediaSession = this.mISession;
            if (this.mIsReleased) {
                return;
            }
            this.mIsReleased = true;
            SessionServiceConnection sessionServiceConnection = this.mServiceConnection;
            if (sessionServiceConnection != null) {
                this.mContext.unbindService(sessionServiceConnection);
                this.mServiceConnection = null;
            }
            this.mISession = null;
            this.mControllerStub.destroy();
            if (iMediaSession != null) {
                int iObtainNextSequenceNumber = this.mSequencedFutureManager.obtainNextSequenceNumber();
                try {
                    iMediaSession.asBinder().unlinkToDeath(this.mDeathRecipient, 0);
                    iMediaSession.release(this.mControllerStub, iObtainNextSequenceNumber);
                } catch (RemoteException unused) {
                }
            }
            this.mSequencedFutureManager.close();
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.2
                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    controllerCallback.onDisconnected(MediaControllerImplBase.this.mInstance);
                }
            });
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public a<SessionResult> deselectTrack(@NonNull final SessionPlayer.TrackInfo trackInfo) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_DESELECT_TRACK, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.30
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.deselectTrack(MediaControllerImplBase.this.mControllerStub, i2, MediaParcelUtils.toParcelable(trackInfo));
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> fastForward() {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.6
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.fastForward(MediaControllerImplBase.this.mControllerStub, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public SessionCommandGroup getAllowedCommands() {
        synchronized (this.mLock) {
            if (this.mISession == null) {
                new IllegalStateException();
                return null;
            }
            return this.mAllowedCommands;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaBrowserCompat getBrowserCompat() {
        return null;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getBufferedPosition() {
        synchronized (this.mLock) {
            if (this.mISession == null) {
                new IllegalStateException();
                return Long.MIN_VALUE;
            }
            return this.mBufferedPositionMs;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getBufferingState() {
        synchronized (this.mLock) {
            if (this.mISession == null) {
                new IllegalStateException();
                return 0;
            }
            return this.mBufferingState;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public SessionToken getConnectedToken() {
        SessionToken sessionToken;
        synchronized (this.mLock) {
            sessionToken = isConnected() ? this.mConnectedToken : null;
        }
        return sessionToken;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public MediaItem getCurrentMediaItem() {
        MediaItem mediaItem;
        synchronized (this.mLock) {
            mediaItem = this.mCurrentMediaItem;
        }
        return mediaItem;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getCurrentMediaItemIndex() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mCurrentMediaItemIndex;
        }
        return i2;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getCurrentPosition() {
        synchronized (this.mLock) {
            if (this.mISession == null) {
                new IllegalStateException();
                return Long.MIN_VALUE;
            }
            if (this.mPlayerState != 2 || this.mBufferingState == 2) {
                return this.mPositionMs;
            }
            return Math.max(0L, this.mPositionMs + ((long) (this.mPlaybackSpeed * (this.mInstance.mTimeDiff != null ? r1.longValue() : SystemClock.elapsedRealtime() - this.mPositionEventTimeMs))));
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getDuration() {
        synchronized (this.mLock) {
            MediaItem mediaItem = this.mCurrentMediaItem;
            MediaMetadata metadata = mediaItem == null ? null : mediaItem.getMetadata();
            if (metadata == null || !metadata.containsKey("android.media.metadata.DURATION")) {
                return Long.MIN_VALUE;
            }
            return metadata.getLong("android.media.metadata.DURATION");
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getNextMediaItemIndex() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mNextMediaItemIndex;
        }
        return i2;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public MediaController.PlaybackInfo getPlaybackInfo() {
        MediaController.PlaybackInfo playbackInfo;
        synchronized (this.mLock) {
            playbackInfo = this.mPlaybackInfo;
        }
        return playbackInfo;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public float getPlaybackSpeed() {
        synchronized (this.mLock) {
            if (this.mISession == null) {
                new IllegalStateException();
                return 0.0f;
            }
            return this.mPlaybackSpeed;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPlayerState() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mPlayerState;
        }
        return i2;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public List<MediaItem> getPlaylist() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = this.mPlaylist == null ? null : new ArrayList(this.mPlaylist);
        }
        return arrayList;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public MediaMetadata getPlaylistMetadata() {
        MediaMetadata mediaMetadata;
        synchronized (this.mLock) {
            mediaMetadata = this.mPlaylistMetadata;
        }
        return mediaMetadata;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPreviousMediaItemIndex() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mPreviousMediaItemIndex;
        }
        return i2;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getRepeatMode() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mRepeatMode;
        }
        return i2;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i2) {
        SessionPlayer.TrackInfo trackInfo;
        synchronized (this.mLock) {
            trackInfo = this.mSelectedTracks.get(i2);
        }
        return trackInfo;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public PendingIntent getSessionActivity() {
        PendingIntent pendingIntent;
        synchronized (this.mLock) {
            pendingIntent = this.mSessionActivity;
        }
        return pendingIntent;
    }

    public IMediaSession getSessionInterfaceIfAble(int i2) {
        synchronized (this.mLock) {
            if (!this.mAllowedCommands.hasCommand(i2)) {
                return null;
            }
            return this.mISession;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getShuffleMode() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mShuffleMode;
        }
        return i2;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        List<SessionPlayer.TrackInfo> list;
        synchronized (this.mLock) {
            list = this.mTracks;
        }
        return list;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public VideoSize getVideoSize() {
        VideoSize videoSize;
        synchronized (this.mLock) {
            videoSize = this.mVideoSize;
        }
        return videoSize;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mISession != null;
        }
        return z;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> movePlaylistItem(final int i2, final int i3) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_MOVE_PLAYLIST_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.23
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i4) {
                iMediaSession.movePlaylistItem(MediaControllerImplBase.this.mControllerStub, i4, i2, i3);
            }
        });
    }

    public void notifyBufferingStateChanged(final MediaItem mediaItem, final int i2, long j2, long j3, long j4) {
        synchronized (this.mLock) {
            this.mBufferingState = i2;
            this.mBufferedPositionMs = j2;
            this.mPositionEventTimeMs = j3;
            this.mPositionMs = j4;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.35
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onBufferingStateChanged(MediaControllerImplBase.this.mInstance, mediaItem, i2);
                }
            }
        });
    }

    public void notifyCurrentMediaItemChanged(final MediaItem mediaItem, int i2, int i3, int i4) {
        synchronized (this.mLock) {
            this.mCurrentMediaItem = mediaItem;
            this.mCurrentMediaItemIndex = i2;
            this.mPreviousMediaItemIndex = i3;
            this.mNextMediaItemIndex = i4;
            List<MediaItem> list = this.mPlaylist;
            if (list != null && i2 >= 0 && i2 < list.size()) {
                this.mPlaylist.set(i2, mediaItem);
            }
            this.mPositionEventTimeMs = SystemClock.elapsedRealtime();
            this.mPositionMs = 0L;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.32
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onCurrentMediaItemChanged(MediaControllerImplBase.this.mInstance, mediaItem);
                }
            }
        });
    }

    public void notifyPlaybackCompleted() {
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.41
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlaybackCompleted(MediaControllerImplBase.this.mInstance);
                }
            }
        });
    }

    public void notifyPlaybackInfoChanges(final MediaController.PlaybackInfo playbackInfo) {
        synchronized (this.mLock) {
            this.mPlaybackInfo = playbackInfo;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.38
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlaybackInfoChanged(MediaControllerImplBase.this.mInstance, playbackInfo);
                }
            }
        });
    }

    public void notifyPlaybackSpeedChanges(long j2, long j3, final float f2) {
        synchronized (this.mLock) {
            this.mPositionEventTimeMs = j2;
            this.mPositionMs = j3;
            this.mPlaybackSpeed = f2;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.34
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlaybackSpeedChanged(MediaControllerImplBase.this.mInstance, f2);
                }
            }
        });
    }

    public void notifyPlayerStateChanges(long j2, long j3, final int i2) {
        synchronized (this.mLock) {
            this.mPositionEventTimeMs = j2;
            this.mPositionMs = j3;
            this.mPlayerState = i2;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.33
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlayerStateChanged(MediaControllerImplBase.this.mInstance, i2);
                }
            }
        });
    }

    public void notifyPlaylistChanges(final List<MediaItem> list, final MediaMetadata mediaMetadata, int i2, int i3, int i4) {
        synchronized (this.mLock) {
            this.mPlaylist = list;
            this.mPlaylistMetadata = mediaMetadata;
            this.mCurrentMediaItemIndex = i2;
            this.mPreviousMediaItemIndex = i3;
            this.mNextMediaItemIndex = i4;
            if (i2 >= 0 && list != null && i2 < list.size()) {
                this.mCurrentMediaItem = list.get(i2);
            }
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.36
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlaylistChanged(MediaControllerImplBase.this.mInstance, list, mediaMetadata);
                }
            }
        });
    }

    public void notifyPlaylistMetadataChanges(final MediaMetadata mediaMetadata) {
        synchronized (this.mLock) {
            this.mPlaylistMetadata = mediaMetadata;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.37
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlaylistMetadataChanged(MediaControllerImplBase.this.mInstance, mediaMetadata);
                }
            }
        });
    }

    public void notifyRepeatModeChanges(final int i2, int i3, int i4, int i5) {
        synchronized (this.mLock) {
            this.mRepeatMode = i2;
            this.mCurrentMediaItemIndex = i3;
            this.mPreviousMediaItemIndex = i4;
            this.mNextMediaItemIndex = i5;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.39
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onRepeatModeChanged(MediaControllerImplBase.this.mInstance, i2);
                }
            }
        });
    }

    public void notifySeekCompleted(long j2, long j3, final long j4) {
        synchronized (this.mLock) {
            this.mPositionEventTimeMs = j2;
            this.mPositionMs = j3;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.42
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onSeekCompleted(MediaControllerImplBase.this.mInstance, j4);
                }
            }
        });
    }

    public void notifyShuffleModeChanges(final int i2, int i3, int i4, int i5) {
        synchronized (this.mLock) {
            this.mShuffleMode = i2;
            this.mCurrentMediaItemIndex = i3;
            this.mPreviousMediaItemIndex = i4;
            this.mNextMediaItemIndex = i5;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.40
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onShuffleModeChanged(MediaControllerImplBase.this.mInstance, i2);
                }
            }
        });
    }

    public void notifySubtitleData(final MediaItem mediaItem, final SessionPlayer.TrackInfo trackInfo, final SubtitleData subtitleData) {
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.47
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onSubtitleData(MediaControllerImplBase.this.mInstance, mediaItem, trackInfo, subtitleData);
                }
            }
        });
    }

    public void notifyTrackDeselected(int i2, final SessionPlayer.TrackInfo trackInfo) {
        synchronized (this.mLock) {
            this.mSelectedTracks.remove(trackInfo.getTrackType());
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.46
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onTrackDeselected(MediaControllerImplBase.this.mInstance, trackInfo);
                }
            }
        });
    }

    public void notifyTrackSelected(int i2, final SessionPlayer.TrackInfo trackInfo) {
        synchronized (this.mLock) {
            this.mSelectedTracks.put(trackInfo.getTrackType(), trackInfo);
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.45
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onTrackSelected(MediaControllerImplBase.this.mInstance, trackInfo);
                }
            }
        });
    }

    public void notifyTracksChanged(int i2, final List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) {
        synchronized (this.mLock) {
            this.mTracks = list;
            this.mSelectedTracks.put(1, trackInfo);
            this.mSelectedTracks.put(2, trackInfo2);
            this.mSelectedTracks.put(4, trackInfo3);
            this.mSelectedTracks.put(5, trackInfo4);
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.44
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onTracksChanged(MediaControllerImplBase.this.mInstance, list);
                }
            }
        });
    }

    public void notifyVideoSizeChanged(final VideoSize videoSize) {
        final MediaItem mediaItem;
        synchronized (this.mLock) {
            this.mVideoSize = videoSize;
            mediaItem = this.mCurrentMediaItem;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.43
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    MediaItem mediaItem2 = mediaItem;
                    if (mediaItem2 != null) {
                        controllerCallback.onVideoSizeChanged(MediaControllerImplBase.this.mInstance, mediaItem2, videoSize);
                    }
                    controllerCallback.onVideoSizeChanged(MediaControllerImplBase.this.mInstance, videoSize);
                }
            }
        });
    }

    public void onAllowedCommandsChanged(final SessionCommandGroup sessionCommandGroup) {
        synchronized (this.mLock) {
            this.mAllowedCommands = sessionCommandGroup;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.50
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                controllerCallback.onAllowedCommandsChanged(MediaControllerImplBase.this.mInstance, sessionCommandGroup);
            }
        });
    }

    public void onConnectedNotLocked(int i2, IMediaSession iMediaSession, final SessionCommandGroup sessionCommandGroup, int i3, MediaItem mediaItem, long j2, long j3, float f2, long j4, MediaController.PlaybackInfo playbackInfo, int i4, int i5, List<MediaItem> list, PendingIntent pendingIntent, int i6, int i7, int i8, Bundle bundle, VideoSize videoSize, List<SessionPlayer.TrackInfo> list2, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4, MediaMetadata mediaMetadata, int i9) {
        if (DEBUG) {
            String str = "onConnectedNotLocked sessionBinder=" + iMediaSession + ", allowedCommands=" + sessionCommandGroup;
        }
        if (iMediaSession == null || sessionCommandGroup == null) {
            this.mInstance.close();
            return;
        }
        try {
            synchronized (this.mLock) {
                try {
                    if (this.mIsReleased) {
                        return;
                    }
                    try {
                        if (this.mISession != null) {
                            this.mInstance.close();
                            return;
                        }
                        this.mAllowedCommands = sessionCommandGroup;
                        this.mPlayerState = i3;
                        this.mCurrentMediaItem = mediaItem;
                        this.mPositionEventTimeMs = j2;
                        this.mPositionMs = j3;
                        this.mPlaybackSpeed = f2;
                        this.mBufferedPositionMs = j4;
                        this.mPlaybackInfo = playbackInfo;
                        this.mRepeatMode = i4;
                        this.mShuffleMode = i5;
                        this.mPlaylist = list;
                        this.mSessionActivity = pendingIntent;
                        this.mISession = iMediaSession;
                        this.mCurrentMediaItemIndex = i6;
                        this.mPreviousMediaItemIndex = i7;
                        this.mNextMediaItemIndex = i8;
                        this.mVideoSize = videoSize;
                        this.mTracks = list2;
                        this.mSelectedTracks.put(1, trackInfo);
                        this.mSelectedTracks.put(2, trackInfo2);
                        this.mSelectedTracks.put(4, trackInfo3);
                        this.mSelectedTracks.put(5, trackInfo4);
                        this.mPlaylistMetadata = mediaMetadata;
                        this.mBufferingState = i9;
                        try {
                            this.mISession.asBinder().linkToDeath(this.mDeathRecipient, 0);
                            this.mConnectedToken = new SessionToken(new SessionTokenImplBase(this.mToken.getUid(), 0, this.mToken.getPackageName(), iMediaSession, bundle));
                            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.48
                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    controllerCallback.onConnected(MediaControllerImplBase.this.mInstance, sessionCommandGroup);
                                }
                            });
                        } catch (RemoteException unused) {
                            boolean z = DEBUG;
                            this.mInstance.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (0 != 0) {
                this.mInstance.close();
            }
            throw th3;
        }
    }

    public void onCustomCommand(final int i2, final SessionCommand sessionCommand, final Bundle bundle) {
        if (DEBUG) {
            sessionCommand.getCustomAction();
        }
        this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.49
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                SessionResult sessionResultOnCustomCommand = controllerCallback.onCustomCommand(MediaControllerImplBase.this.mInstance, sessionCommand, bundle);
                if (sessionResultOnCustomCommand != null) {
                    MediaControllerImplBase.this.sendControllerResult(i2, sessionResultOnCustomCommand);
                } else {
                    StringBuilder sbR = c.a.a.a.a.r("ControllerCallback#onCustomCommand() has returned null, command=");
                    sbR.append(sessionCommand.getCustomAction());
                    throw new RuntimeException(sbR.toString());
                }
            }
        });
    }

    public void onSetCustomLayout(final int i2, final List<MediaSession.CommandButton> list) {
        this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.51
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                MediaControllerImplBase.this.sendControllerResult(i2, new SessionResult(controllerCallback.onSetCustomLayout(MediaControllerImplBase.this.mInstance, list)));
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> pause() {
        return dispatchRemoteSessionTask(10001, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.4
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.pause(MediaControllerImplBase.this.mControllerStub, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> play() {
        return dispatchRemoteSessionTask(10000, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.3
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.play(MediaControllerImplBase.this.mControllerStub, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> prepare() {
        return dispatchRemoteSessionTask(10002, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.5
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.prepare(MediaControllerImplBase.this.mControllerStub, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> removePlaylistItem(final int i2) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_REMOVE_PLAYLIST_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.21
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) {
                iMediaSession.removePlaylistItem(MediaControllerImplBase.this.mControllerStub, i3, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> replacePlaylistItem(final int i2, @NonNull final String str) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_REPLACE_PLAYLIST_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.22
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) {
                iMediaSession.replacePlaylistItem(MediaControllerImplBase.this.mControllerStub, i3, i2, str);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> rewind() {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_REWIND, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.7
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.rewind(MediaControllerImplBase.this.mControllerStub, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> seekTo(final long j2) {
        if (j2 >= 0) {
            return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SEEK_TO, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.10
                @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
                public void run(IMediaSession iMediaSession, int i2) {
                    iMediaSession.seekTo(MediaControllerImplBase.this.mControllerStub, i2, j2);
                }
            });
        }
        throw new IllegalArgumentException("position shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public a<SessionResult> selectTrack(@NonNull final SessionPlayer.TrackInfo trackInfo) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SELECT_TRACK, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.29
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.selectTrack(MediaControllerImplBase.this.mControllerStub, i2, MediaParcelUtils.toParcelable(trackInfo));
            }
        });
    }

    public void sendControllerResult(int i2, @NonNull SessionResult sessionResult) {
        IMediaSession iMediaSession;
        synchronized (this.mLock) {
            iMediaSession = this.mISession;
        }
        if (iMediaSession == null) {
            return;
        }
        try {
            iMediaSession.onControllerResult(this.mControllerStub, i2, MediaParcelUtils.toParcelable(sessionResult));
        } catch (RemoteException unused) {
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> sendCustomCommand(@NonNull final SessionCommand sessionCommand, @Nullable final Bundle bundle) {
        return dispatchRemoteSessionTask(sessionCommand, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.15
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.onCustomCommand(MediaControllerImplBase.this.mControllerStub, i2, MediaParcelUtils.toParcelable(sessionCommand), bundle);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setMediaItem(@NonNull final String str) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_MEDIA_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.17
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.setMediaItem(MediaControllerImplBase.this.mControllerStub, i2, str);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setMediaUri(@NonNull final Uri uri, @Nullable final Bundle bundle) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.18
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.setMediaUri(MediaControllerImplBase.this.mControllerStub, i2, uri, bundle);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setPlaybackSpeed(final float f2) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_SPEED, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.13
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.setPlaybackSpeed(MediaControllerImplBase.this.mControllerStub, i2, f2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setPlaylist(@NonNull final List<String> list, @Nullable final MediaMetadata mediaMetadata) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_PLAYLIST, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.16
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.setPlaylist(MediaControllerImplBase.this.mControllerStub, i2, list, MediaParcelUtils.toParcelable(mediaMetadata));
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setRating(@NonNull final String str, @NonNull final Rating rating) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.14
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.setRating(MediaControllerImplBase.this.mControllerStub, i2, str, MediaParcelUtils.toParcelable(rating));
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setRepeatMode(final int i2) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_REPEAT_MODE, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.27
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) {
                iMediaSession.setRepeatMode(MediaControllerImplBase.this.mControllerStub, i3, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setShuffleMode(final int i2) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_SHUFFLE_MODE, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.28
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) {
                iMediaSession.setShuffleMode(MediaControllerImplBase.this.mControllerStub, i3, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setSurface(@Nullable final Surface surface) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_SURFACE, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.31
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.setSurface(MediaControllerImplBase.this.mControllerStub, i2, surface);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setVolumeTo(final int i2, final int i3) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_VOLUME_SET_VOLUME, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.11
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i4) {
                iMediaSession.setVolumeTo(MediaControllerImplBase.this.mControllerStub, i4, i2, i3);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> skipBackward() {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_SKIP_BACKWARD, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.9
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.skipBackward(MediaControllerImplBase.this.mControllerStub, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> skipForward() {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_SKIP_FORWARD, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.8
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.skipForward(MediaControllerImplBase.this.mControllerStub, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> skipToNextItem() {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_NEXT_PLAYLIST_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.25
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.skipToNextItem(MediaControllerImplBase.this.mControllerStub, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> skipToPlaylistItem(final int i2) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_PLAYLIST_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.26
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) {
                iMediaSession.skipToPlaylistItem(MediaControllerImplBase.this.mControllerStub, i3, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> skipToPreviousItem() {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_PREVIOUS_PLAYLIST_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.24
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.skipToPreviousItem(MediaControllerImplBase.this.mControllerStub, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> updatePlaylistMetadata(@Nullable final MediaMetadata mediaMetadata) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.19
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.updatePlaylistMetadata(MediaControllerImplBase.this.mControllerStub, i2, MediaParcelUtils.toParcelable(mediaMetadata));
            }
        });
    }

    private a<SessionResult> dispatchRemoteSessionTask(SessionCommand sessionCommand, RemoteSessionTask remoteSessionTask) {
        return dispatchRemoteSessionTaskInternal(0, sessionCommand, remoteSessionTask);
    }

    public IMediaSession getSessionInterfaceIfAble(SessionCommand sessionCommand) {
        synchronized (this.mLock) {
            if (!this.mAllowedCommands.hasCommand(sessionCommand)) {
                String str = "Controller isn't allowed to call command, command=" + sessionCommand;
                return null;
            }
            return this.mISession;
        }
    }
}
