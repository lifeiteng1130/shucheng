package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaInterface;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.SessionCommandGroup;
import androidx.versionedparcelable.VersionedParcelable;
import c.a.a.a.a;
import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class MediaSession implements Closeable {
    public static final String TAG = "MediaSession";
    private final MediaSessionImpl mImpl;
    private static final Object STATIC_LOCK = new Object();

    @GuardedBy("STATIC_LOCK")
    private static final HashMap<String, MediaSession> SESSION_ID_TO_SESSION_MAP = new HashMap<>();

    public static final class Builder extends BuilderBase<MediaSession, Builder, SessionCallback> {
        public Builder(@NonNull Context context, @NonNull SessionPlayer sessionPlayer) {
            super(context, sessionPlayer);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [C extends androidx.media2.session.MediaSession$SessionCallback, androidx.media2.session.MediaSession$Builder$1] */
        @Override // androidx.media2.session.MediaSession.BuilderBase
        @NonNull
        public MediaSession build() {
            if (this.mCallbackExecutor == null) {
                this.mCallbackExecutor = ContextCompat.getMainExecutor(this.mContext);
            }
            if (this.mCallback == 0) {
                this.mCallback = new SessionCallback() { // from class: androidx.media2.session.MediaSession.Builder.1
                };
            }
            return new MediaSession(this.mContext, this.mId, this.mPlayer, this.mSessionActivity, this.mCallbackExecutor, this.mCallback, this.mExtras);
        }

        @Override // androidx.media2.session.MediaSession.BuilderBase
        @NonNull
        public Builder setExtras(@NonNull Bundle bundle) {
            return (Builder) super.setExtras(bundle);
        }

        @Override // androidx.media2.session.MediaSession.BuilderBase
        @NonNull
        public Builder setId(@NonNull String str) {
            return (Builder) super.setId(str);
        }

        @Override // androidx.media2.session.MediaSession.BuilderBase
        @NonNull
        public Builder setSessionActivity(@Nullable PendingIntent pendingIntent) {
            return (Builder) super.setSessionActivity(pendingIntent);
        }

        @Override // androidx.media2.session.MediaSession.BuilderBase
        @NonNull
        public Builder setSessionCallback(@NonNull Executor executor, @NonNull SessionCallback sessionCallback) {
            return (Builder) super.setSessionCallback(executor, sessionCallback);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class BuilderBase<T extends MediaSession, U extends BuilderBase<T, U, C>, C extends SessionCallback> {
        public C mCallback;
        public Executor mCallbackExecutor;
        public final Context mContext;
        public Bundle mExtras;
        public String mId;
        public SessionPlayer mPlayer;
        public PendingIntent mSessionActivity;

        public BuilderBase(@NonNull Context context, @NonNull SessionPlayer sessionPlayer) {
            Objects.requireNonNull(context, "context shouldn't be null");
            Objects.requireNonNull(sessionPlayer, "player shouldn't be null");
            this.mContext = context;
            this.mPlayer = sessionPlayer;
            this.mId = "";
        }

        @NonNull
        public abstract T build();

        @NonNull
        public U setExtras(@NonNull Bundle bundle) {
            Objects.requireNonNull(bundle, "extras shouldn't be null");
            if (MediaUtils.doesBundleHaveCustomParcelable(bundle)) {
                throw new IllegalArgumentException("extras shouldn't contain any custom parcelables");
            }
            this.mExtras = new Bundle(bundle);
            return this;
        }

        @NonNull
        public U setId(@NonNull String str) {
            Objects.requireNonNull(str, "id shouldn't be null");
            this.mId = str;
            return this;
        }

        @NonNull
        public U setSessionActivity(@Nullable PendingIntent pendingIntent) {
            this.mSessionActivity = pendingIntent;
            return this;
        }

        @NonNull
        public U setSessionCallback(@NonNull Executor executor, @NonNull C c2) {
            Objects.requireNonNull(executor, "executor shouldn't be null");
            Objects.requireNonNull(c2, "callback shouldn't be null");
            this.mCallbackExecutor = executor;
            this.mCallback = c2;
            return this;
        }
    }

    public static final class CommandButton implements VersionedParcelable {
        public SessionCommand mCommand;
        public CharSequence mDisplayName;
        public boolean mEnabled;
        public Bundle mExtras;
        public int mIconResId;

        public static final class Builder {
            private SessionCommand mCommand;
            private CharSequence mDisplayName;
            private boolean mEnabled;
            private Bundle mExtras;
            private int mIconResId;

            @NonNull
            public CommandButton build() {
                return new CommandButton(this.mCommand, this.mIconResId, this.mDisplayName, this.mExtras, this.mEnabled);
            }

            @NonNull
            public Builder setCommand(@Nullable SessionCommand sessionCommand) {
                this.mCommand = sessionCommand;
                return this;
            }

            @NonNull
            public Builder setDisplayName(@Nullable CharSequence charSequence) {
                this.mDisplayName = charSequence;
                return this;
            }

            @NonNull
            public Builder setEnabled(boolean z) {
                this.mEnabled = z;
                return this;
            }

            @NonNull
            public Builder setExtras(@Nullable Bundle bundle) {
                this.mExtras = bundle;
                return this;
            }

            @NonNull
            public Builder setIconResId(int i2) {
                this.mIconResId = i2;
                return this;
            }
        }

        public CommandButton() {
        }

        @Nullable
        public SessionCommand getCommand() {
            return this.mCommand;
        }

        @Nullable
        public CharSequence getDisplayName() {
            return this.mDisplayName;
        }

        @Nullable
        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIconResId() {
            return this.mIconResId;
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public CommandButton(@Nullable SessionCommand sessionCommand, int i2, @Nullable CharSequence charSequence, Bundle bundle, boolean z) {
            this.mCommand = sessionCommand;
            this.mIconResId = i2;
            this.mDisplayName = charSequence;
            this.mExtras = bundle;
            this.mEnabled = z;
        }
    }

    public static abstract class ControllerCb {
        public abstract void onAllowedCommandsChanged(int i2, @NonNull SessionCommandGroup sessionCommandGroup);

        public abstract void onBufferingStateChanged(int i2, @NonNull MediaItem mediaItem, int i3, long j2, long j3, long j4);

        public abstract void onChildrenChanged(int i2, @NonNull String str, int i3, @Nullable MediaLibraryService.LibraryParams libraryParams);

        public abstract void onCurrentMediaItemChanged(int i2, @Nullable MediaItem mediaItem, int i3, int i4, int i5);

        public abstract void onDisconnected(int i2);

        public abstract void onLibraryResult(int i2, LibraryResult libraryResult);

        public abstract void onPlaybackCompleted(int i2);

        public abstract void onPlaybackInfoChanged(int i2, @NonNull MediaController.PlaybackInfo playbackInfo);

        public abstract void onPlaybackSpeedChanged(int i2, long j2, long j3, float f2);

        public abstract void onPlayerResult(int i2, SessionPlayer.PlayerResult playerResult);

        public abstract void onPlayerStateChanged(int i2, long j2, long j3, int i3);

        public abstract void onPlaylistChanged(int i2, @NonNull List<MediaItem> list, @Nullable MediaMetadata mediaMetadata, int i3, int i4, int i5);

        public abstract void onPlaylistMetadataChanged(int i2, @Nullable MediaMetadata mediaMetadata);

        public abstract void onRepeatModeChanged(int i2, int i3, int i4, int i5, int i6);

        public abstract void onSearchResultChanged(int i2, @NonNull String str, int i3, @Nullable MediaLibraryService.LibraryParams libraryParams);

        public abstract void onSeekCompleted(int i2, long j2, long j3, long j4);

        public abstract void onSessionResult(int i2, SessionResult sessionResult);

        public abstract void onShuffleModeChanged(int i2, int i3, int i4, int i5, int i6);

        public abstract void onSubtitleData(int i2, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData);

        public abstract void onTrackDeselected(int i2, SessionPlayer.TrackInfo trackInfo);

        public abstract void onTrackSelected(int i2, SessionPlayer.TrackInfo trackInfo);

        public abstract void onTracksChanged(int i2, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4);

        public abstract void onVideoSizeChanged(int i2, @NonNull VideoSize videoSize);

        public abstract void sendCustomCommand(int i2, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle);

        public abstract void setCustomLayout(int i2, @NonNull List<CommandButton> list);
    }

    public static final class ControllerInfo {
        private final Bundle mConnectionHints;
        private final ControllerCb mControllerCb;
        private final int mControllerVersion;
        private final boolean mIsTrusted;
        private final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;

        public ControllerInfo(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, int i2, boolean z, @Nullable ControllerCb controllerCb, @Nullable Bundle bundle) {
            this.mRemoteUserInfo = remoteUserInfo;
            this.mControllerVersion = i2;
            this.mIsTrusted = z;
            this.mControllerCb = controllerCb;
            if (bundle == null || MediaUtils.doesBundleHaveCustomParcelable(bundle)) {
                this.mConnectionHints = null;
            } else {
                this.mConnectionHints = bundle;
            }
        }

        @NonNull
        public static ControllerInfo createLegacyControllerInfo() {
            return new ControllerInfo(new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, -1, -1), -1, false, null, null);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ControllerInfo)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ControllerInfo controllerInfo = (ControllerInfo) obj;
            ControllerCb controllerCb = this.mControllerCb;
            return (controllerCb == null && controllerInfo.mControllerCb == null) ? this.mRemoteUserInfo.equals(controllerInfo.mRemoteUserInfo) : ObjectsCompat.equals(controllerCb, controllerInfo.mControllerCb);
        }

        @NonNull
        public Bundle getConnectionHints() {
            return this.mConnectionHints == null ? Bundle.EMPTY : new Bundle(this.mConnectionHints);
        }

        @Nullable
        public ControllerCb getControllerCb() {
            return this.mControllerCb;
        }

        @NonNull
        public String getPackageName() {
            return this.mRemoteUserInfo.getPackageName();
        }

        public MediaSessionManager.RemoteUserInfo getRemoteUserInfo() {
            return this.mRemoteUserInfo;
        }

        public int getUid() {
            return this.mRemoteUserInfo.getUid();
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mControllerCb, this.mRemoteUserInfo);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public boolean isTrusted() {
            return this.mIsTrusted;
        }

        public String toString() {
            StringBuilder sbR = a.r("ControllerInfo {pkg=");
            sbR.append(this.mRemoteUserInfo.getPackageName());
            sbR.append(", uid=");
            sbR.append(this.mRemoteUserInfo.getUid());
            sbR.append("})");
            return sbR.toString();
        }
    }

    public interface MediaSessionImpl extends MediaInterface.SessionPlayer, Closeable {
        void broadcastCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle);

        void connectFromService(IMediaController iMediaController, int i2, String str, int i3, int i4, @Nullable Bundle bundle);

        PlaybackStateCompat createPlaybackStateCompat();

        SessionCallback getCallback();

        Executor getCallbackExecutor();

        @NonNull
        List<ControllerInfo> getConnectedControllers();

        Context getContext();

        @NonNull
        String getId();

        MediaSession getInstance();

        IBinder getLegacyBrowserServiceBinder();

        MediaController.PlaybackInfo getPlaybackInfo();

        @NonNull
        SessionPlayer getPlayer();

        PendingIntent getSessionActivity();

        MediaSessionCompat getSessionCompat();

        @NonNull
        SessionToken getToken();

        @NonNull
        Uri getUri();

        boolean isClosed();

        boolean isConnected(@NonNull ControllerInfo controllerInfo);

        c.e.b.a.a.a<SessionResult> sendCustomCommand(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle);

        void setAllowedCommands(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommandGroup sessionCommandGroup);

        c.e.b.a.a.a<SessionResult> setCustomLayout(@NonNull ControllerInfo controllerInfo, @NonNull List<CommandButton> list);

        void setLegacyControllerConnectionTimeoutMs(long j2);

        void updatePlayer(@NonNull SessionPlayer sessionPlayer);

        void updatePlayer(@NonNull SessionPlayer sessionPlayer, @Nullable SessionPlayer sessionPlayer2);
    }

    public static abstract class SessionCallback {
        public ForegroundServiceEventCallback mForegroundServiceEventCallback;

        public static abstract class ForegroundServiceEventCallback {
            public void onNotificationUpdateNeeded(MediaSession mediaSession) {
            }

            public void onPlayerStateChanged(MediaSession mediaSession, int i2) {
            }

            public void onSessionClosed(MediaSession mediaSession) {
            }
        }

        public int onCommandRequest(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand) {
            return 0;
        }

        @Nullable
        public SessionCommandGroup onConnect(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            return new SessionCommandGroup.Builder().addAllPredefinedCommands(2).build();
        }

        @Nullable
        public MediaItem onCreateMediaItem(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull String str) {
            return null;
        }

        public final void onCurrentMediaItemChanged(MediaSession mediaSession) {
            ForegroundServiceEventCallback foregroundServiceEventCallback = this.mForegroundServiceEventCallback;
            if (foregroundServiceEventCallback != null) {
                foregroundServiceEventCallback.onNotificationUpdateNeeded(mediaSession);
            }
        }

        @NonNull
        public SessionResult onCustomCommand(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
            return new SessionResult(-6, null);
        }

        public void onDisconnected(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
        }

        public int onFastForward(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            return -6;
        }

        public final void onPlayerStateChanged(MediaSession mediaSession, int i2) {
            ForegroundServiceEventCallback foregroundServiceEventCallback = this.mForegroundServiceEventCallback;
            if (foregroundServiceEventCallback != null) {
                foregroundServiceEventCallback.onPlayerStateChanged(mediaSession, i2);
            }
        }

        public void onPostConnect(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
        }

        public int onRewind(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            return -6;
        }

        public final void onSessionClosed(MediaSession mediaSession) {
            ForegroundServiceEventCallback foregroundServiceEventCallback = this.mForegroundServiceEventCallback;
            if (foregroundServiceEventCallback != null) {
                foregroundServiceEventCallback.onSessionClosed(mediaSession);
            }
        }

        public int onSetMediaUri(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull Uri uri, @Nullable Bundle bundle) {
            return -6;
        }

        public int onSetRating(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull String str, @NonNull Rating rating) {
            return -6;
        }

        public int onSkipBackward(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            return -6;
        }

        public int onSkipForward(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            return -6;
        }

        public void setForegroundServiceEventCallback(ForegroundServiceEventCallback foregroundServiceEventCallback) {
            this.mForegroundServiceEventCallback = foregroundServiceEventCallback;
        }
    }

    public MediaSession(Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, SessionCallback sessionCallback, Bundle bundle) {
        synchronized (STATIC_LOCK) {
            HashMap<String, MediaSession> map = SESSION_ID_TO_SESSION_MAP;
            if (map.containsKey(str)) {
                throw new IllegalStateException("Session ID must be unique. ID=" + str);
            }
            map.put(str, this);
        }
        this.mImpl = createImpl(context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
    }

    public static MediaSession getSession(Uri uri) {
        synchronized (STATIC_LOCK) {
            for (MediaSession mediaSession : SESSION_ID_TO_SESSION_MAP.values()) {
                if (ObjectsCompat.equals(mediaSession.getUri(), uri)) {
                    return mediaSession;
                }
            }
            return null;
        }
    }

    @NonNull
    private Uri getUri() {
        return this.mImpl.getUri();
    }

    public void broadcastCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        Objects.requireNonNull(sessionCommand, "command shouldn't be null");
        if (sessionCommand.getCommandCode() != 0) {
            throw new IllegalArgumentException("command should be a custom command");
        }
        this.mImpl.broadcastCustomCommand(sessionCommand, bundle);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            synchronized (STATIC_LOCK) {
                SESSION_ID_TO_SESSION_MAP.remove(this.mImpl.getId());
            }
            this.mImpl.close();
        } catch (Exception unused) {
        }
    }

    public MediaSessionImpl createImpl(Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, SessionCallback sessionCallback, Bundle bundle) {
        return new MediaSessionImplBase(this, context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
    }

    @NonNull
    public SessionCallback getCallback() {
        return this.mImpl.getCallback();
    }

    @NonNull
    public Executor getCallbackExecutor() {
        return this.mImpl.getCallbackExecutor();
    }

    @NonNull
    public List<ControllerInfo> getConnectedControllers() {
        return this.mImpl.getConnectedControllers();
    }

    @NonNull
    public Context getContext() {
        return this.mImpl.getContext();
    }

    @NonNull
    public String getId() {
        return this.mImpl.getId();
    }

    public MediaSessionImpl getImpl() {
        return this.mImpl;
    }

    public IBinder getLegacyBrowerServiceBinder() {
        return this.mImpl.getLegacyBrowserServiceBinder();
    }

    @NonNull
    public SessionPlayer getPlayer() {
        return this.mImpl.getPlayer();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MediaSessionCompat getSessionCompat() {
        return this.mImpl.getSessionCompat();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionCompatToken() {
        return this.mImpl.getSessionCompat().getSessionToken();
    }

    @NonNull
    public SessionToken getToken() {
        return this.mImpl.getToken();
    }

    public void handleControllerConnectionFromService(IMediaController iMediaController, int i2, String str, int i3, int i4, @Nullable Bundle bundle) {
        this.mImpl.connectFromService(iMediaController, i2, str, i3, i4, bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isClosed() {
        return this.mImpl.isClosed();
    }

    @NonNull
    public c.e.b.a.a.a<SessionResult> sendCustomCommand(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        Objects.requireNonNull(controllerInfo, "controller shouldn't be null");
        Objects.requireNonNull(sessionCommand, "command shouldn't be null");
        if (sessionCommand.getCommandCode() == 0) {
            return this.mImpl.sendCustomCommand(controllerInfo, sessionCommand, bundle);
        }
        throw new IllegalArgumentException("command should be a custom command");
    }

    public void setAllowedCommands(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommandGroup sessionCommandGroup) {
        Objects.requireNonNull(controllerInfo, "controller shouldn't be null");
        Objects.requireNonNull(sessionCommandGroup, "commands shouldn't be null");
        this.mImpl.setAllowedCommands(controllerInfo, sessionCommandGroup);
    }

    @NonNull
    public c.e.b.a.a.a<SessionResult> setCustomLayout(@NonNull ControllerInfo controllerInfo, @NonNull List<CommandButton> list) {
        Objects.requireNonNull(controllerInfo, "controller shouldn't be null");
        Objects.requireNonNull(list, "layout shouldn't be null");
        return this.mImpl.setCustomLayout(controllerInfo, list);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setLegacyControllerConnectionTimeoutMs(long j2) {
        this.mImpl.setLegacyControllerConnectionTimeoutMs(j2);
    }

    public void updatePlayer(@NonNull SessionPlayer sessionPlayer) {
        Objects.requireNonNull(sessionPlayer, "player shouldn't be null");
        this.mImpl.updatePlayer(sessionPlayer);
    }
}
