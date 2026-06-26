package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pair;
import androidx.media.AudioAttributesCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SessionToken;
import androidx.versionedparcelable.VersionedParcelable;
import c.e.b.a.a.a;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class MediaController implements Closeable {
    private static final String TAG = "MediaController";

    @GuardedBy("mLock")
    public boolean mClosed;

    @GuardedBy("mLock")
    private final List<Pair<ControllerCallback, Executor>> mExtraControllerCallbacks;

    @GuardedBy("mLock")
    public MediaControllerImpl mImpl;
    public final Object mLock;
    public final ControllerCallback mPrimaryCallback;
    public final Executor mPrimaryCallbackExecutor;
    public Long mTimeDiff;

    public static final class Builder extends BuilderBase<MediaController, Builder, ControllerCallback> {
        public Builder(@NonNull Context context) {
            super(context);
        }

        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public MediaController build() {
            SessionToken sessionToken = this.mToken;
            if (sessionToken == null && this.mCompatToken == null) {
                throw new IllegalArgumentException("token and compat token shouldn't be both null");
            }
            return sessionToken != null ? new MediaController(this.mContext, sessionToken, this.mConnectionHints, this.mCallbackExecutor, this.mCallback) : new MediaController(this.mContext, this.mCompatToken, this.mConnectionHints, this.mCallbackExecutor, this.mCallback);
        }

        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setConnectionHints(@NonNull Bundle bundle) {
            return (Builder) super.setConnectionHints(bundle);
        }

        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setControllerCallback(@NonNull Executor executor, @NonNull ControllerCallback controllerCallback) {
            return (Builder) super.setControllerCallback(executor, controllerCallback);
        }

        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setSessionCompatToken(@NonNull MediaSessionCompat.Token token) {
            return (Builder) super.setSessionCompatToken(token);
        }

        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setSessionToken(@NonNull SessionToken sessionToken) {
            return (Builder) super.setSessionToken(sessionToken);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class BuilderBase<T extends MediaController, U extends BuilderBase<T, U, C>, C extends ControllerCallback> {
        public ControllerCallback mCallback;
        public Executor mCallbackExecutor;
        public MediaSessionCompat.Token mCompatToken;
        public Bundle mConnectionHints;
        public final Context mContext;
        public SessionToken mToken;

        public BuilderBase(@NonNull Context context) {
            Objects.requireNonNull(context, "context shouldn't be null");
            this.mContext = context;
        }

        @NonNull
        public abstract T build();

        @NonNull
        public U setConnectionHints(@NonNull Bundle bundle) {
            Objects.requireNonNull(bundle, "connectionHints shouldn't be null");
            if (MediaUtils.doesBundleHaveCustomParcelable(bundle)) {
                throw new IllegalArgumentException("connectionHints shouldn't contain any custom parcelables");
            }
            this.mConnectionHints = new Bundle(bundle);
            return this;
        }

        @NonNull
        public U setControllerCallback(@NonNull Executor executor, @NonNull C c2) {
            Objects.requireNonNull(executor, "executor shouldn't be null");
            Objects.requireNonNull(c2, "callback shouldn't be null");
            this.mCallbackExecutor = executor;
            this.mCallback = c2;
            return this;
        }

        @NonNull
        public U setSessionCompatToken(@NonNull MediaSessionCompat.Token token) {
            Objects.requireNonNull(token, "compatToken shouldn't be null");
            this.mCompatToken = token;
            this.mToken = null;
            return this;
        }

        @NonNull
        public U setSessionToken(@NonNull SessionToken sessionToken) {
            Objects.requireNonNull(sessionToken, "token shouldn't be null");
            this.mToken = sessionToken;
            this.mCompatToken = null;
            return this;
        }
    }

    public static abstract class ControllerCallback {
        public void onAllowedCommandsChanged(@NonNull MediaController mediaController, @NonNull SessionCommandGroup sessionCommandGroup) {
        }

        public void onBufferingStateChanged(@NonNull MediaController mediaController, @NonNull MediaItem mediaItem, int i2) {
        }

        public void onConnected(@NonNull MediaController mediaController, @NonNull SessionCommandGroup sessionCommandGroup) {
        }

        public void onCurrentMediaItemChanged(@NonNull MediaController mediaController, @Nullable MediaItem mediaItem) {
        }

        @NonNull
        public SessionResult onCustomCommand(@NonNull MediaController mediaController, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
            return new SessionResult(-6);
        }

        public void onDisconnected(@NonNull MediaController mediaController) {
        }

        public void onPlaybackCompleted(@NonNull MediaController mediaController) {
        }

        public void onPlaybackInfoChanged(@NonNull MediaController mediaController, @NonNull PlaybackInfo playbackInfo) {
        }

        public void onPlaybackSpeedChanged(@NonNull MediaController mediaController, float f2) {
        }

        public void onPlayerStateChanged(@NonNull MediaController mediaController, int i2) {
        }

        public void onPlaylistChanged(@NonNull MediaController mediaController, @Nullable List<MediaItem> list, @Nullable MediaMetadata mediaMetadata) {
        }

        public void onPlaylistMetadataChanged(@NonNull MediaController mediaController, @Nullable MediaMetadata mediaMetadata) {
        }

        public void onRepeatModeChanged(@NonNull MediaController mediaController, int i2) {
        }

        public void onSeekCompleted(@NonNull MediaController mediaController, long j2) {
        }

        public int onSetCustomLayout(@NonNull MediaController mediaController, @NonNull List<MediaSession.CommandButton> list) {
            return -6;
        }

        public void onShuffleModeChanged(@NonNull MediaController mediaController, int i2) {
        }

        public void onSubtitleData(@NonNull MediaController mediaController, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
        }

        public void onTrackDeselected(@NonNull MediaController mediaController, @NonNull SessionPlayer.TrackInfo trackInfo) {
        }

        public void onTrackSelected(@NonNull MediaController mediaController, @NonNull SessionPlayer.TrackInfo trackInfo) {
        }

        public void onTracksChanged(@NonNull MediaController mediaController, @NonNull List<SessionPlayer.TrackInfo> list) {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Deprecated
        public void onVideoSizeChanged(@NonNull MediaController mediaController, @NonNull MediaItem mediaItem, @NonNull VideoSize videoSize) {
        }

        public void onVideoSizeChanged(@NonNull MediaController mediaController, @NonNull VideoSize videoSize) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public interface ControllerCallbackRunnable {
        void run(@NonNull ControllerCallback controllerCallback);
    }

    public interface MediaControllerImpl extends Closeable {
        a<SessionResult> addPlaylistItem(int i2, @NonNull String str);

        a<SessionResult> adjustVolume(int i2, int i3);

        a<SessionResult> deselectTrack(SessionPlayer.TrackInfo trackInfo);

        a<SessionResult> fastForward();

        @Nullable
        SessionCommandGroup getAllowedCommands();

        @Nullable
        MediaBrowserCompat getBrowserCompat();

        long getBufferedPosition();

        int getBufferingState();

        @Nullable
        SessionToken getConnectedToken();

        @NonNull
        Context getContext();

        MediaItem getCurrentMediaItem();

        int getCurrentMediaItemIndex();

        long getCurrentPosition();

        long getDuration();

        int getNextMediaItemIndex();

        @Nullable
        PlaybackInfo getPlaybackInfo();

        float getPlaybackSpeed();

        int getPlayerState();

        @Nullable
        List<MediaItem> getPlaylist();

        @Nullable
        MediaMetadata getPlaylistMetadata();

        int getPreviousMediaItemIndex();

        int getRepeatMode();

        @Nullable
        SessionPlayer.TrackInfo getSelectedTrack(int i2);

        @Nullable
        PendingIntent getSessionActivity();

        int getShuffleMode();

        @NonNull
        List<SessionPlayer.TrackInfo> getTracks();

        @NonNull
        VideoSize getVideoSize();

        boolean isConnected();

        a<SessionResult> movePlaylistItem(int i2, int i3);

        a<SessionResult> pause();

        a<SessionResult> play();

        a<SessionResult> prepare();

        a<SessionResult> removePlaylistItem(int i2);

        a<SessionResult> replacePlaylistItem(int i2, @NonNull String str);

        a<SessionResult> rewind();

        a<SessionResult> seekTo(long j2);

        a<SessionResult> selectTrack(SessionPlayer.TrackInfo trackInfo);

        a<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle);

        a<SessionResult> setMediaItem(@NonNull String str);

        a<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle);

        a<SessionResult> setPlaybackSpeed(float f2);

        a<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata);

        a<SessionResult> setRating(@NonNull String str, @NonNull Rating rating);

        a<SessionResult> setRepeatMode(int i2);

        a<SessionResult> setShuffleMode(int i2);

        a<SessionResult> setSurface(@Nullable Surface surface);

        a<SessionResult> setVolumeTo(int i2, int i3);

        a<SessionResult> skipBackward();

        a<SessionResult> skipForward();

        a<SessionResult> skipToNextItem();

        a<SessionResult> skipToPlaylistItem(int i2);

        a<SessionResult> skipToPreviousItem();

        a<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata);
    }

    public static final class PlaybackInfo implements VersionedParcelable {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        public AudioAttributesCompat mAudioAttrsCompat;
        public int mControlType;
        public int mCurrentVolume;
        public int mMaxVolume;
        public int mPlaybackType;

        public PlaybackInfo() {
        }

        public static PlaybackInfo createPlaybackInfo(int i2, AudioAttributesCompat audioAttributesCompat, int i3, int i4, int i5) {
            return new PlaybackInfo(i2, audioAttributesCompat, i3, i4, i5);
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof PlaybackInfo)) {
                return false;
            }
            PlaybackInfo playbackInfo = (PlaybackInfo) obj;
            return this.mPlaybackType == playbackInfo.mPlaybackType && this.mControlType == playbackInfo.mControlType && this.mMaxVolume == playbackInfo.mMaxVolume && this.mCurrentVolume == playbackInfo.mCurrentVolume && ObjectsCompat.equals(this.mAudioAttrsCompat, playbackInfo.mAudioAttrsCompat);
        }

        @Nullable
        public AudioAttributesCompat getAudioAttributes() {
            return this.mAudioAttrsCompat;
        }

        public int getControlType() {
            return this.mControlType;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.mPlaybackType), Integer.valueOf(this.mControlType), Integer.valueOf(this.mMaxVolume), Integer.valueOf(this.mCurrentVolume), this.mAudioAttrsCompat);
        }

        public PlaybackInfo(int i2, AudioAttributesCompat audioAttributesCompat, int i3, int i4, int i5) {
            this.mPlaybackType = i2;
            this.mAudioAttrsCompat = audioAttributesCompat;
            this.mControlType = i3;
            this.mMaxVolume = i4;
            this.mCurrentVolume = i5;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface VolumeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface VolumeFlags {
    }

    public MediaController(@NonNull Context context, @NonNull SessionToken sessionToken, @Nullable Bundle bundle, @Nullable Executor executor, @Nullable ControllerCallback controllerCallback) {
        Object obj = new Object();
        this.mLock = obj;
        this.mExtraControllerCallbacks = new ArrayList();
        Objects.requireNonNull(context, "context shouldn't be null");
        Objects.requireNonNull(sessionToken, "token shouldn't be null");
        this.mPrimaryCallback = controllerCallback;
        this.mPrimaryCallbackExecutor = executor;
        synchronized (obj) {
            this.mImpl = createImpl(context, sessionToken, bundle);
        }
    }

    private static a<SessionResult> createDisconnectedFuture() {
        return SessionResult.createFutureWithResult(-100);
    }

    @NonNull
    public a<SessionResult> addPlaylistItem(@IntRange(from = 0) int i2, @NonNull String str) {
        if (i2 < 0) {
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mediaId shouldn't be empty");
        }
        return isConnected() ? getImpl().addPlaylistItem(i2, str) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> adjustVolume(int i2, int i3) {
        return isConnected() ? getImpl().adjustVolume(i2, i3) : createDisconnectedFuture();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            synchronized (this.mLock) {
                if (this.mClosed) {
                    return;
                }
                this.mClosed = true;
                MediaControllerImpl mediaControllerImpl = this.mImpl;
                if (mediaControllerImpl != null) {
                    mediaControllerImpl.close();
                }
            }
        } catch (Exception unused) {
        }
    }

    public MediaControllerImpl createImpl(@NonNull Context context, @NonNull SessionToken sessionToken, @Nullable Bundle bundle) {
        return sessionToken.isLegacySession() ? new MediaControllerImplLegacy(context, this, sessionToken) : new MediaControllerImplBase(context, this, sessionToken, bundle);
    }

    @NonNull
    public a<SessionResult> deselectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        Objects.requireNonNull(trackInfo, "TrackInfo shouldn't be null");
        return isConnected() ? getImpl().deselectTrack(trackInfo) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> fastForward() {
        return isConnected() ? getImpl().fastForward() : createDisconnectedFuture();
    }

    @Nullable
    public SessionCommandGroup getAllowedCommands() {
        if (isConnected()) {
            return getImpl().getAllowedCommands();
        }
        return null;
    }

    public long getBufferedPosition() {
        if (isConnected()) {
            return getImpl().getBufferedPosition();
        }
        return Long.MIN_VALUE;
    }

    public int getBufferingState() {
        if (isConnected()) {
            return getImpl().getBufferingState();
        }
        return 0;
    }

    @Nullable
    public SessionToken getConnectedToken() {
        if (isConnected()) {
            return getImpl().getConnectedToken();
        }
        return null;
    }

    @Nullable
    public MediaItem getCurrentMediaItem() {
        if (isConnected()) {
            return getImpl().getCurrentMediaItem();
        }
        return null;
    }

    public int getCurrentMediaItemIndex() {
        if (isConnected()) {
            return getImpl().getCurrentMediaItemIndex();
        }
        return -1;
    }

    public long getCurrentPosition() {
        if (isConnected()) {
            return getImpl().getCurrentPosition();
        }
        return Long.MIN_VALUE;
    }

    public long getDuration() {
        if (isConnected()) {
            return getImpl().getDuration();
        }
        return Long.MIN_VALUE;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Pair<ControllerCallback, Executor>> getExtraControllerCallbacks() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mExtraControllerCallbacks);
        }
        return arrayList;
    }

    public MediaControllerImpl getImpl() {
        MediaControllerImpl mediaControllerImpl;
        synchronized (this.mLock) {
            mediaControllerImpl = this.mImpl;
        }
        return mediaControllerImpl;
    }

    public int getNextMediaItemIndex() {
        if (isConnected()) {
            return getImpl().getNextMediaItemIndex();
        }
        return -1;
    }

    @Nullable
    public PlaybackInfo getPlaybackInfo() {
        if (isConnected()) {
            return getImpl().getPlaybackInfo();
        }
        return null;
    }

    public float getPlaybackSpeed() {
        if (isConnected()) {
            return getImpl().getPlaybackSpeed();
        }
        return 0.0f;
    }

    public int getPlayerState() {
        if (isConnected()) {
            return getImpl().getPlayerState();
        }
        return 0;
    }

    @Nullable
    public List<MediaItem> getPlaylist() {
        if (isConnected()) {
            return getImpl().getPlaylist();
        }
        return null;
    }

    @Nullable
    public MediaMetadata getPlaylistMetadata() {
        if (isConnected()) {
            return getImpl().getPlaylistMetadata();
        }
        return null;
    }

    public int getPreviousMediaItemIndex() {
        if (isConnected()) {
            return getImpl().getPreviousMediaItemIndex();
        }
        return -1;
    }

    public int getRepeatMode() {
        if (isConnected()) {
            return getImpl().getRepeatMode();
        }
        return 0;
    }

    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i2) {
        if (isConnected()) {
            return getImpl().getSelectedTrack(i2);
        }
        return null;
    }

    @Nullable
    public PendingIntent getSessionActivity() {
        if (isConnected()) {
            return getImpl().getSessionActivity();
        }
        return null;
    }

    public int getShuffleMode() {
        if (isConnected()) {
            return getImpl().getShuffleMode();
        }
        return 0;
    }

    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        return isConnected() ? getImpl().getTracks() : Collections.emptyList();
    }

    @NonNull
    public VideoSize getVideoSize() {
        return isConnected() ? getImpl().getVideoSize() : new VideoSize(0, 0);
    }

    public boolean isConnected() {
        MediaControllerImpl impl = getImpl();
        return impl != null && impl.isConnected();
    }

    @NonNull
    public a<SessionResult> movePlaylistItem(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("indexes shouldn't be negative");
        }
        return isConnected() ? getImpl().movePlaylistItem(i2, i3) : createDisconnectedFuture();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void notifyAllControllerCallbacks(@NonNull final ControllerCallbackRunnable controllerCallbackRunnable) {
        notifyPrimaryControllerCallback(controllerCallbackRunnable);
        for (Pair<ControllerCallback, Executor> pair : getExtraControllerCallbacks()) {
            final ControllerCallback controllerCallback = pair.first;
            Executor executor = pair.second;
            if (controllerCallback != null && executor != null) {
                executor.execute(new Runnable() { // from class: androidx.media2.session.MediaController.2
                    @Override // java.lang.Runnable
                    public void run() {
                        controllerCallbackRunnable.run(controllerCallback);
                    }
                });
            }
        }
    }

    public void notifyPrimaryControllerCallback(@NonNull final ControllerCallbackRunnable controllerCallbackRunnable) {
        Executor executor;
        if (this.mPrimaryCallback == null || (executor = this.mPrimaryCallbackExecutor) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.media2.session.MediaController.1
            @Override // java.lang.Runnable
            public void run() {
                controllerCallbackRunnable.run(MediaController.this.mPrimaryCallback);
            }
        });
    }

    @NonNull
    public a<SessionResult> pause() {
        return isConnected() ? getImpl().pause() : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> play() {
        return isConnected() ? getImpl().play() : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> prepare() {
        return isConnected() ? getImpl().prepare() : createDisconnectedFuture();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void registerExtraCallback(@NonNull Executor executor, @NonNull ControllerCallback controllerCallback) {
        Objects.requireNonNull(executor, "executor shouldn't be null");
        Objects.requireNonNull(controllerCallback, "callback shouldn't be null");
        boolean z = false;
        synchronized (this.mLock) {
            Iterator<Pair<ControllerCallback, Executor>> it = this.mExtraControllerCallbacks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().first == controllerCallback) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.mExtraControllerCallbacks.add(new Pair<>(controllerCallback, executor));
            }
        }
    }

    @NonNull
    public a<SessionResult> removePlaylistItem(@IntRange(from = 0) int i2) {
        if (i2 >= 0) {
            return isConnected() ? getImpl().removePlaylistItem(i2) : createDisconnectedFuture();
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @NonNull
    public a<SessionResult> replacePlaylistItem(@IntRange(from = 0) int i2, @NonNull String str) {
        if (i2 < 0) {
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mediaId shouldn't be empty");
        }
        return isConnected() ? getImpl().replacePlaylistItem(i2, str) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> rewind() {
        return isConnected() ? getImpl().rewind() : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> seekTo(long j2) {
        return isConnected() ? getImpl().seekTo(j2) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> selectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        Objects.requireNonNull(trackInfo, "TrackInfo shouldn't be null");
        return isConnected() ? getImpl().selectTrack(trackInfo) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        Objects.requireNonNull(sessionCommand, "command shouldn't be null");
        if (sessionCommand.getCommandCode() == 0) {
            return isConnected() ? getImpl().sendCustomCommand(sessionCommand, bundle) : createDisconnectedFuture();
        }
        throw new IllegalArgumentException("command should be a custom command");
    }

    @NonNull
    public a<SessionResult> setMediaItem(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mediaId shouldn't be empty");
        }
        return isConnected() ? getImpl().setMediaItem(str) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle) {
        Objects.requireNonNull(uri, "mediaUri shouldn't be null");
        return isConnected() ? getImpl().setMediaUri(uri, bundle) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> setPlaybackSpeed(float f2) {
        if (f2 != 0.0f) {
            return isConnected() ? getImpl().setPlaybackSpeed(f2) : createDisconnectedFuture();
        }
        throw new IllegalArgumentException("speed must not be zero");
    }

    @NonNull
    public a<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata) {
        Objects.requireNonNull(list, "list shouldn't be null");
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.isEmpty(list.get(i2))) {
                throw new IllegalArgumentException(c.a.a.a.a.G("list shouldn't contain empty id, index=", i2));
            }
        }
        return isConnected() ? getImpl().setPlaylist(list, mediaMetadata) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> setRating(@NonNull String str, @NonNull Rating rating) {
        Objects.requireNonNull(str, "mediaId shouldn't be null");
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mediaId shouldn't be empty");
        }
        Objects.requireNonNull(rating, "rating shouldn't be null");
        return isConnected() ? getImpl().setRating(str, rating) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> setRepeatMode(int i2) {
        return isConnected() ? getImpl().setRepeatMode(i2) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> setShuffleMode(int i2) {
        return isConnected() ? getImpl().setShuffleMode(i2) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> setSurface(@Nullable Surface surface) {
        return isConnected() ? getImpl().setSurface(surface) : createDisconnectedFuture();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setTimeDiff(Long l2) {
        this.mTimeDiff = l2;
    }

    @NonNull
    public a<SessionResult> setVolumeTo(int i2, int i3) {
        return isConnected() ? getImpl().setVolumeTo(i2, i3) : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> skipBackward() {
        return isConnected() ? getImpl().skipBackward() : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> skipForward() {
        return isConnected() ? getImpl().skipForward() : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> skipToNextPlaylistItem() {
        return isConnected() ? getImpl().skipToNextItem() : createDisconnectedFuture();
    }

    @NonNull
    public a<SessionResult> skipToPlaylistItem(@IntRange(from = 0) int i2) {
        if (i2 >= 0) {
            return isConnected() ? getImpl().skipToPlaylistItem(i2) : createDisconnectedFuture();
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @NonNull
    public a<SessionResult> skipToPreviousPlaylistItem() {
        return isConnected() ? getImpl().skipToPreviousItem() : createDisconnectedFuture();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void unregisterExtraCallback(@NonNull ControllerCallback controllerCallback) {
        Objects.requireNonNull(controllerCallback, "callback shouldn't be null");
        synchronized (this.mLock) {
            int size = this.mExtraControllerCallbacks.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                if (this.mExtraControllerCallbacks.get(size).first == controllerCallback) {
                    this.mExtraControllerCallbacks.remove(size);
                    break;
                }
                size--;
            }
        }
    }

    @NonNull
    public a<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata) {
        return isConnected() ? getImpl().updatePlaylistMetadata(mediaMetadata) : createDisconnectedFuture();
    }

    public MediaController(@NonNull final Context context, @NonNull MediaSessionCompat.Token token, @Nullable final Bundle bundle, @Nullable Executor executor, @Nullable ControllerCallback controllerCallback) {
        this.mLock = new Object();
        this.mExtraControllerCallbacks = new ArrayList();
        Objects.requireNonNull(context, "context shouldn't be null");
        Objects.requireNonNull(token, "token shouldn't be null");
        this.mPrimaryCallback = controllerCallback;
        this.mPrimaryCallbackExecutor = executor;
        SessionToken.createSessionToken(context, token, new SessionToken.OnSessionTokenCreatedListener() { // from class: b.c.a.a
            @Override // androidx.media2.session.SessionToken.OnSessionTokenCreatedListener
            public final void onSessionTokenCreated(MediaSessionCompat.Token token2, SessionToken sessionToken) {
                boolean z;
                final MediaController mediaController = this.a;
                Context context2 = context;
                Bundle bundle2 = bundle;
                synchronized (mediaController.mLock) {
                    z = mediaController.mClosed;
                    if (!z) {
                        mediaController.mImpl = mediaController.createImpl(context2, sessionToken, bundle2);
                    }
                }
                if (z) {
                    mediaController.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: b.c.a.b
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public final void run(MediaController.ControllerCallback controllerCallback2) {
                            MediaController mediaController2 = mediaController;
                            Objects.requireNonNull(mediaController2);
                            controllerCallback2.onDisconnected(mediaController2);
                        }
                    });
                }
            }
        });
    }
}
