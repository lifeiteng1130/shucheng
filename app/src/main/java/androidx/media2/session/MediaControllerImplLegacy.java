package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ResultReceiver;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.ObjectsCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import c.e.b.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaControllerImplLegacy implements MediaController.MediaControllerImpl {
    private static final int ITEM_NONE = -1;
    private static final long POSITION_DIFF_TOLERANCE = 100;
    public static final String SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED = "android.media.session.command.ON_CAPTIONING_ENALBED_CHANGED";
    public static final String SESSION_COMMAND_ON_EXTRAS_CHANGED = "android.media.session.command.ON_EXTRAS_CHANGED";

    @GuardedBy("mLock")
    public SessionCommandGroup mAllowedCommands;

    @GuardedBy("mLock")
    public MediaBrowserCompat mBrowserCompat;

    @GuardedBy("mLock")
    public long mBufferedPosition;

    @GuardedBy("mLock")
    public int mBufferingState;

    @GuardedBy("mLock")
    public boolean mClosed;

    @GuardedBy("mLock")
    public boolean mConnected;
    public final Context mContext;

    @GuardedBy("mLock")
    public MediaControllerCompat mControllerCompat;

    @GuardedBy("mLock")
    public ControllerCompatCallback mControllerCompatCallback;

    @GuardedBy("mLock")
    public MediaItem mCurrentMediaItem;
    public int mCurrentMediaItemIndex;

    @GuardedBy("mLock")
    public List<MediaSession.CommandButton> mCustomLayout;
    public final Handler mHandler;
    public final HandlerThread mHandlerThread;
    public MediaController mInstance;
    public final Object mLock;

    @GuardedBy("mLock")
    public MediaMetadataCompat mMediaMetadataCompat;

    @GuardedBy("mLock")
    public MediaController.PlaybackInfo mPlaybackInfo;

    @GuardedBy("mLock")
    public PlaybackStateCompat mPlaybackStateCompat;

    @GuardedBy("mLock")
    public int mPlayerState;

    @GuardedBy("mLock")
    public List<MediaItem> mPlaylist;

    @GuardedBy("mLock")
    public MediaMetadata mPlaylistMetadata;
    public List<MediaSessionCompat.QueueItem> mQueue;

    @GuardedBy("mLock")
    public int mRepeatMode;

    @GuardedBy("mLock")
    public int mShuffleMode;

    @GuardedBy("mLock")
    public int mSkipToPlaylistIndex;
    public final SessionToken mToken;
    private static final String TAG = "MC2ImplLegacy";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);

    public class ConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        public ConnectionCallback() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat browserCompat = MediaControllerImplLegacy.this.getBrowserCompat();
            if (browserCompat != null) {
                MediaControllerImplLegacy.this.connectToSession(browserCompat.getSessionToken());
            } else if (MediaControllerImplLegacy.DEBUG) {
                new IllegalStateException();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            MediaControllerImplLegacy.this.close();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            MediaControllerImplLegacy.this.close();
        }
    }

    public final class ControllerCompatCallback extends MediaControllerCompat.Callback {
        public ControllerCompatCallback() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo playbackInfo) {
            final MediaController.PlaybackInfo playbackInfo2 = MediaUtils.toPlaybackInfo2(playbackInfo);
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mPlaybackInfo = playbackInfo2;
                    mediaControllerImplLegacy.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.14
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onPlaybackInfoChanged(MediaControllerImplLegacy.this.mInstance, playbackInfo2);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onCaptioningEnabledChanged(final boolean z) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.15
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean(MediaConstants.ARGUMENT_CAPTIONING_ENABLED, z);
                            controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(MediaControllerImplLegacy.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED, null), bundle);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onExtrasChanged(final Bundle bundle) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.13
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(MediaControllerImplLegacy.SESSION_COMMAND_ON_EXTRAS_CHANGED, null), bundle);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    MediaItem mediaItem = mediaControllerImplLegacy.mCurrentMediaItem;
                    mediaControllerImplLegacy.setCurrentMediaItemLocked(mediaMetadataCompat);
                    MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                    final MediaItem mediaItem2 = mediaControllerImplLegacy2.mCurrentMediaItem;
                    if (mediaItem != mediaItem2) {
                        mediaControllerImplLegacy2.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.10
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onCurrentMediaItemChanged(MediaControllerImplLegacy.this.mInstance, mediaItem2);
                            }
                        });
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onPlaybackStateChanged(final PlaybackStateCompat playbackStateCompat) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    MediaItem mediaItem = mediaControllerImplLegacy.mCurrentMediaItem;
                    PlaybackStateCompat playbackStateCompat2 = mediaControllerImplLegacy.mPlaybackStateCompat;
                    mediaControllerImplLegacy.mPlaybackStateCompat = playbackStateCompat;
                    mediaControllerImplLegacy.mPlayerState = MediaUtils.convertToPlayerState(playbackStateCompat);
                    MediaControllerImplLegacy.this.mBufferedPosition = playbackStateCompat == null ? Long.MIN_VALUE : playbackStateCompat.getBufferedPosition();
                    if (MediaControllerImplLegacy.this.mQueue != null && playbackStateCompat != null) {
                        for (int i2 = 0; i2 < MediaControllerImplLegacy.this.mQueue.size(); i2++) {
                            if (MediaControllerImplLegacy.this.mQueue.get(i2).getQueueId() == playbackStateCompat.getActiveQueueItemId()) {
                                MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                                mediaControllerImplLegacy2.mCurrentMediaItemIndex = i2;
                                mediaControllerImplLegacy2.mCurrentMediaItem = mediaControllerImplLegacy2.mPlaylist.get(i2);
                            }
                        }
                    }
                    MediaControllerImplLegacy mediaControllerImplLegacy3 = MediaControllerImplLegacy.this;
                    final MediaItem mediaItem2 = mediaControllerImplLegacy3.mCurrentMediaItem;
                    List<MediaSession.CommandButton> list = mediaControllerImplLegacy3.mCustomLayout;
                    mediaControllerImplLegacy3.mCustomLayout = MediaUtils.convertToCustomLayout(playbackStateCompat);
                    MediaControllerImplLegacy mediaControllerImplLegacy4 = MediaControllerImplLegacy.this;
                    final List<MediaSession.CommandButton> list2 = mediaControllerImplLegacy4.mCustomLayout;
                    SessionCommandGroup sessionCommandGroup = mediaControllerImplLegacy4.mAllowedCommands;
                    mediaControllerImplLegacy4.mAllowedCommands = MediaUtils.convertToSessionCommandGroup(mediaControllerImplLegacy4.mControllerCompat.getFlags(), MediaControllerImplLegacy.this.mPlaybackStateCompat);
                    MediaControllerImplLegacy mediaControllerImplLegacy5 = MediaControllerImplLegacy.this;
                    final SessionCommandGroup sessionCommandGroup2 = mediaControllerImplLegacy5.mAllowedCommands;
                    if (mediaItem != mediaItem2) {
                        mediaControllerImplLegacy5.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.2
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onCurrentMediaItemChanged(MediaControllerImplLegacy.this.mInstance, mediaItem2);
                            }
                        });
                    }
                    if (playbackStateCompat == null) {
                        if (playbackStateCompat2 != null) {
                            MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.3
                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    controllerCallback.onPlayerStateChanged(MediaControllerImplLegacy.this.mInstance, 0);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (playbackStateCompat2 == null || playbackStateCompat2.getState() != playbackStateCompat.getState()) {
                        MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.4
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onPlayerStateChanged(MediaControllerImplLegacy.this.mInstance, MediaUtils.convertToPlayerState(playbackStateCompat));
                            }
                        });
                    }
                    if (playbackStateCompat2 == null || playbackStateCompat2.getPlaybackSpeed() != playbackStateCompat.getPlaybackSpeed()) {
                        MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.5
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onPlaybackSpeedChanged(MediaControllerImplLegacy.this.mInstance, playbackStateCompat.getPlaybackSpeed());
                            }
                        });
                    }
                    if (playbackStateCompat2 != null) {
                        final long currentPosition = playbackStateCompat.getCurrentPosition(MediaControllerImplLegacy.this.mInstance.mTimeDiff);
                        if (Math.abs(currentPosition - playbackStateCompat2.getCurrentPosition(MediaControllerImplLegacy.this.mInstance.mTimeDiff)) > MediaControllerImplLegacy.POSITION_DIFF_TOLERANCE) {
                            MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.6
                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    controllerCallback.onSeekCompleted(MediaControllerImplLegacy.this.mInstance, currentPosition);
                                }
                            });
                        }
                    }
                    if (!sessionCommandGroup.equals(sessionCommandGroup2)) {
                        MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.7
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onAllowedCommandsChanged(MediaControllerImplLegacy.this.mInstance, sessionCommandGroup2);
                            }
                        });
                    }
                    boolean z = true;
                    if (list.size() == list2.size()) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= list2.size()) {
                                z = false;
                                break;
                            } else if (!ObjectsCompat.equals(list.get(i3).getCommand(), list2.get(i3).getCommand())) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    if (z) {
                        MediaControllerImplLegacy.this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.8
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onSetCustomLayout(MediaControllerImplLegacy.this.mInstance, list2);
                            }
                        });
                    }
                    if (mediaItem2 == null) {
                        return;
                    }
                    final int bufferingState = MediaUtils.toBufferingState(playbackStateCompat.getState());
                    if (bufferingState != (playbackStateCompat2 != null ? MediaUtils.toBufferingState(playbackStateCompat2.getState()) : 0)) {
                        MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.9
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onBufferingStateChanged(MediaControllerImplLegacy.this.mInstance, mediaItem2, bufferingState);
                            }
                        });
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mQueue = MediaUtils.removeNullElements(list);
                    List<MediaSessionCompat.QueueItem> list2 = MediaControllerImplLegacy.this.mQueue;
                    if (list2 == null || list2.size() == 0) {
                        MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                        mediaControllerImplLegacy2.mQueue = null;
                        mediaControllerImplLegacy2.mPlaylist = null;
                    } else {
                        MediaControllerImplLegacy mediaControllerImplLegacy3 = MediaControllerImplLegacy.this;
                        mediaControllerImplLegacy3.mPlaylist = MediaUtils.convertQueueItemListToMediaItemList(mediaControllerImplLegacy3.mQueue);
                    }
                    MediaControllerImplLegacy mediaControllerImplLegacy4 = MediaControllerImplLegacy.this;
                    final List<MediaItem> list3 = mediaControllerImplLegacy4.mPlaylist;
                    final MediaMetadata mediaMetadata = mediaControllerImplLegacy4.mPlaylistMetadata;
                    mediaControllerImplLegacy4.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.11
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onPlaylistChanged(MediaControllerImplLegacy.this.mInstance, list3, mediaMetadata);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mPlaylistMetadata = MediaUtils.convertToMediaMetadata(charSequence);
                    MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                    final MediaMetadata mediaMetadata = mediaControllerImplLegacy2.mPlaylistMetadata;
                    mediaControllerImplLegacy2.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.12
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onPlaylistMetadataChanged(MediaControllerImplLegacy.this.mInstance, mediaMetadata);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onRepeatModeChanged(final int i2) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mRepeatMode = i2;
                    mediaControllerImplLegacy.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.16
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onRepeatModeChanged(MediaControllerImplLegacy.this.mInstance, i2);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionDestroyed() {
            MediaControllerImplLegacy.this.close();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionEvent(final String str, final Bundle bundle) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.1
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(str, null), bundle);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionReady() {
            MediaControllerImplLegacy mediaControllerImplLegacy;
            boolean z;
            PlaybackStateCompat playbackState;
            int shuffleMode;
            int repeatMode;
            boolean zIsCaptioningEnabled;
            synchronized (MediaControllerImplLegacy.this.mLock) {
                mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                z = mediaControllerImplLegacy.mConnected;
            }
            if (!z) {
                mediaControllerImplLegacy.onConnectedNotLocked();
                return;
            }
            synchronized (mediaControllerImplLegacy.mLock) {
                playbackState = MediaControllerImplLegacy.this.mControllerCompat.getPlaybackState();
                shuffleMode = MediaControllerImplLegacy.this.mControllerCompat.getShuffleMode();
                repeatMode = MediaControllerImplLegacy.this.mControllerCompat.getRepeatMode();
                zIsCaptioningEnabled = MediaControllerImplLegacy.this.mControllerCompat.isCaptioningEnabled();
            }
            onPlaybackStateChanged(playbackState);
            onShuffleModeChanged(shuffleMode);
            onRepeatModeChanged(repeatMode);
            onCaptioningEnabledChanged(zIsCaptioningEnabled);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onShuffleModeChanged(final int i2) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mShuffleMode = i2;
                    mediaControllerImplLegacy.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.17
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onShuffleModeChanged(MediaControllerImplLegacy.this.mInstance, i2);
                        }
                    });
                }
            }
        }
    }

    public MediaControllerImplLegacy(@NonNull Context context, @NonNull MediaController mediaController, @NonNull SessionToken sessionToken) {
        Object obj = new Object();
        this.mLock = obj;
        this.mSkipToPlaylistIndex = -1;
        this.mContext = context;
        this.mInstance = mediaController;
        HandlerThread handlerThread = new HandlerThread("MediaController_Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mToken = sessionToken;
        if (sessionToken.getType() != 0) {
            connectToService();
            return;
        }
        synchronized (obj) {
            this.mBrowserCompat = null;
        }
        connectToSession((MediaSessionCompat.Token) sessionToken.getBinder());
    }

    private void connectToService() {
        this.mHandler.post(new Runnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (MediaControllerImplLegacy.this.mLock) {
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                    mediaControllerImplLegacy.mBrowserCompat = new MediaBrowserCompat(mediaControllerImplLegacy2.mContext, mediaControllerImplLegacy2.mToken.getComponentName(), MediaControllerImplLegacy.this.new ConnectionCallback(), null);
                    MediaControllerImplLegacy.this.mBrowserCompat.connect();
                }
            }
        });
    }

    private a<SessionResult> createFutureWithResult(int i2) {
        MediaItem mediaItem;
        synchronized (this.mLock) {
            mediaItem = this.mCurrentMediaItem;
        }
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        resolvableFutureCreate.set(new SessionResult(i2, null, mediaItem));
        return resolvableFutureCreate;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> addPlaylistItem(int i2, @NonNull String str) {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.addQueueItem(MediaUtils.createMediaDescriptionCompat(str), i2);
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> adjustVolume(int i2, int i3) {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.adjustVolume(i2, i3);
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (DEBUG) {
            StringBuilder sbR = c.a.a.a.a.r("close from ");
            sbR.append(this.mToken);
            sbR.toString();
        }
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandlerThread.quitSafely();
            this.mClosed = true;
            MediaBrowserCompat mediaBrowserCompat = this.mBrowserCompat;
            if (mediaBrowserCompat != null) {
                mediaBrowserCompat.disconnect();
                this.mBrowserCompat = null;
            }
            MediaControllerCompat mediaControllerCompat = this.mControllerCompat;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.unregisterCallback(this.mControllerCompatCallback);
                this.mControllerCompat = null;
            }
            this.mConnected = false;
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.1
                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    controllerCallback.onDisconnected(MediaControllerImplLegacy.this.mInstance);
                }
            });
        }
    }

    public void connectToSession(MediaSessionCompat.Token token) {
        boolean zIsSessionReady;
        MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.mContext, token);
        synchronized (this.mLock) {
            this.mControllerCompat = mediaControllerCompat;
            this.mControllerCompatCallback = new ControllerCompatCallback();
            zIsSessionReady = this.mControllerCompat.isSessionReady();
            this.mControllerCompat.registerCallback(this.mControllerCompatCallback, this.mHandler);
        }
        if (zIsSessionReady) {
            return;
        }
        onConnectedNotLocked();
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public a<SessionResult> deselectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> fastForward() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.getTransportControls().fastForward();
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public SessionCommandGroup getAllowedCommands() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                return this.mAllowedCommands;
            }
            new IllegalStateException();
            return null;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaBrowserCompat getBrowserCompat() {
        MediaBrowserCompat mediaBrowserCompat;
        synchronized (this.mLock) {
            mediaBrowserCompat = this.mBrowserCompat;
        }
        return mediaBrowserCompat;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getBufferedPosition() {
        synchronized (this.mLock) {
            long bufferedPosition = Long.MIN_VALUE;
            if (!this.mConnected) {
                new IllegalStateException();
                return Long.MIN_VALUE;
            }
            PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
            if (playbackStateCompat != null) {
                bufferedPosition = playbackStateCompat.getBufferedPosition();
            }
            return bufferedPosition;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getBufferingState() {
        synchronized (this.mLock) {
            int bufferingState = 0;
            if (!this.mConnected) {
                new IllegalStateException();
                return 0;
            }
            PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
            if (playbackStateCompat != null) {
                bufferingState = MediaUtils.toBufferingState(playbackStateCompat.getState());
            }
            return bufferingState;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionToken getConnectedToken() {
        SessionToken sessionToken;
        synchronized (this.mLock) {
            sessionToken = this.mConnected ? this.mToken : null;
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
        synchronized (this.mLock) {
            if (this.mConnected) {
                return this.mCurrentMediaItem;
            }
            new IllegalStateException();
            return null;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getCurrentMediaItemIndex() {
        return this.mCurrentMediaItemIndex;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getCurrentPosition() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                new IllegalStateException();
                return Long.MIN_VALUE;
            }
            PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
            if (playbackStateCompat == null) {
                return Long.MIN_VALUE;
            }
            return playbackStateCompat.getCurrentPosition(this.mInstance.mTimeDiff);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getDuration() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                new IllegalStateException();
                return Long.MIN_VALUE;
            }
            MediaMetadataCompat mediaMetadataCompat = this.mMediaMetadataCompat;
            if (mediaMetadataCompat == null || !mediaMetadataCompat.containsKey("android.media.metadata.DURATION")) {
                return Long.MIN_VALUE;
            }
            return this.mMediaMetadataCompat.getLong("android.media.metadata.DURATION");
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getNextMediaItemIndex() {
        return -1;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaController.PlaybackInfo getPlaybackInfo() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                return this.mPlaybackInfo;
            }
            new IllegalStateException();
            return null;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public float getPlaybackSpeed() {
        synchronized (this.mLock) {
            float playbackSpeed = 0.0f;
            if (!this.mConnected) {
                new IllegalStateException();
                return 0.0f;
            }
            PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
            if (playbackStateCompat != null) {
                playbackSpeed = playbackStateCompat.getPlaybackSpeed();
            }
            return playbackSpeed;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPlayerState() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                return this.mPlayerState;
            }
            new IllegalStateException();
            return 3;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public List<MediaItem> getPlaylist() {
        synchronized (this.mLock) {
            ArrayList arrayList = null;
            if (!this.mConnected) {
                new IllegalStateException();
                return null;
            }
            List<MediaItem> list = this.mPlaylist;
            if (list != null && list.size() != 0) {
                arrayList = new ArrayList(this.mPlaylist);
            }
            return arrayList;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaMetadata getPlaylistMetadata() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                return this.mPlaylistMetadata;
            }
            new IllegalStateException();
            return null;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPreviousMediaItemIndex() {
        return -1;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getRepeatMode() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                return this.mRepeatMode;
            }
            new IllegalStateException();
            return 0;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i2) {
        return null;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public PendingIntent getSessionActivity() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                return this.mControllerCompat.getSessionActivity();
            }
            new IllegalStateException();
            return null;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getShuffleMode() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                return this.mShuffleMode;
            }
            new IllegalStateException();
            return 0;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        return Collections.emptyList();
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public VideoSize getVideoSize() {
        return new VideoSize(0, 0);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mConnected;
        }
        return z;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> movePlaylistItem(int i2, int i3) {
        return createFutureWithResult(-6);
    }

    public void onConnectedNotLocked() {
        if (DEBUG) {
            StringBuilder sbR = c.a.a.a.a.r("onConnectedNotLocked token=");
            sbR.append(this.mToken);
            sbR.toString();
        }
        synchronized (this.mLock) {
            if (!this.mClosed && !this.mConnected) {
                this.mPlaybackStateCompat = this.mControllerCompat.getPlaybackState();
                this.mAllowedCommands = MediaUtils.convertToSessionCommandGroup(this.mControllerCompat.getFlags(), this.mPlaybackStateCompat);
                this.mPlayerState = MediaUtils.convertToPlayerState(this.mPlaybackStateCompat);
                PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
                this.mBufferedPosition = playbackStateCompat == null ? Long.MIN_VALUE : playbackStateCompat.getBufferedPosition();
                final List<MediaSession.CommandButton> listConvertToCustomLayout = MediaUtils.convertToCustomLayout(this.mPlaybackStateCompat);
                this.mCustomLayout = listConvertToCustomLayout;
                final SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
                this.mPlaybackInfo = MediaUtils.toPlaybackInfo2(this.mControllerCompat.getPlaybackInfo());
                this.mRepeatMode = this.mControllerCompat.getRepeatMode();
                this.mShuffleMode = this.mControllerCompat.getShuffleMode();
                List<MediaSessionCompat.QueueItem> listRemoveNullElements = MediaUtils.removeNullElements(this.mControllerCompat.getQueue());
                this.mQueue = listRemoveNullElements;
                if (listRemoveNullElements == null || listRemoveNullElements.size() == 0) {
                    this.mQueue = null;
                    this.mPlaylist = null;
                } else {
                    this.mPlaylist = MediaUtils.convertQueueItemListToMediaItemList(this.mQueue);
                }
                this.mPlaylistMetadata = MediaUtils.convertToMediaMetadata(this.mControllerCompat.getQueueTitle());
                setCurrentMediaItemLocked(this.mControllerCompat.getMetadata());
                this.mConnected = true;
                this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.3
                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                    public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                        controllerCallback.onConnected(MediaControllerImplLegacy.this.mInstance, sessionCommandGroup);
                    }
                });
                if (listConvertToCustomLayout.isEmpty()) {
                    return;
                }
                this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.4
                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                    public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                        controllerCallback.onSetCustomLayout(MediaControllerImplLegacy.this.mInstance, listConvertToCustomLayout);
                    }
                });
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> pause() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.getTransportControls().pause();
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> play() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.getTransportControls().play();
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> prepare() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.getTransportControls().prepare();
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> removePlaylistItem(int i2) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                new IllegalStateException();
                return createFutureWithResult(-100);
            }
            List<MediaSessionCompat.QueueItem> list = this.mQueue;
            if (list != null && i2 >= 0 && i2 < list.size()) {
                this.mControllerCompat.removeQueueItem(this.mQueue.get(i2).getDescription());
                return createFutureWithResult(0);
            }
            return createFutureWithResult(-3);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> replacePlaylistItem(int i2, @NonNull String str) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                new IllegalStateException();
                return createFutureWithResult(-100);
            }
            List<MediaSessionCompat.QueueItem> list = this.mQueue;
            if (list != null && i2 >= 0 && i2 < list.size()) {
                this.mControllerCompat.removeQueueItem(this.mQueue.get(i2).getDescription());
                this.mControllerCompat.addQueueItem(MediaUtils.createMediaDescriptionCompat(str), i2);
                return createFutureWithResult(0);
            }
            return createFutureWithResult(-3);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> rewind() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.getTransportControls().rewind();
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> seekTo(long j2) {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.getTransportControls().seekTo(j2);
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public a<SessionResult> selectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                new IllegalStateException();
                return createFutureWithResult(-100);
            }
            if (this.mAllowedCommands.hasCommand(sessionCommand)) {
                this.mControllerCompat.getTransportControls().sendCustomAction(sessionCommand.getCustomAction(), bundle);
                return createFutureWithResult(0);
            }
            final ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
            this.mControllerCompat.sendCommand(sessionCommand.getCustomAction(), bundle, new ResultReceiver(this.mHandler) { // from class: androidx.media2.session.MediaControllerImplLegacy.2
                @Override // android.os.ResultReceiver
                public void onReceiveResult(int i2, Bundle bundle2) {
                    resolvableFutureCreate.set(new SessionResult(i2, bundle2));
                }
            });
            return resolvableFutureCreate;
        }
    }

    public void setCurrentMediaItemLocked(MediaMetadataCompat mediaMetadataCompat) {
        this.mMediaMetadataCompat = mediaMetadataCompat;
        if (mediaMetadataCompat == null) {
            this.mCurrentMediaItemIndex = -1;
            this.mCurrentMediaItem = null;
            return;
        }
        if (this.mQueue == null) {
            this.mCurrentMediaItemIndex = -1;
            this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
            return;
        }
        PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
        if (playbackStateCompat != null) {
            long activeQueueItemId = playbackStateCompat.getActiveQueueItemId();
            for (int i2 = 0; i2 < this.mQueue.size(); i2++) {
                if (this.mQueue.get(i2).getQueueId() == activeQueueItemId) {
                    this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
                    this.mCurrentMediaItemIndex = i2;
                    return;
                }
            }
        }
        String string = mediaMetadataCompat.getString("android.media.metadata.MEDIA_ID");
        if (string == null) {
            this.mCurrentMediaItemIndex = -1;
            this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
            return;
        }
        int i3 = this.mSkipToPlaylistIndex;
        if (i3 >= 0 && i3 < this.mQueue.size() && TextUtils.equals(string, this.mQueue.get(this.mSkipToPlaylistIndex).getDescription().getMediaId())) {
            this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
            this.mCurrentMediaItemIndex = this.mSkipToPlaylistIndex;
            this.mSkipToPlaylistIndex = -1;
            return;
        }
        for (int i4 = 0; i4 < this.mQueue.size(); i4++) {
            if (TextUtils.equals(string, this.mQueue.get(i4).getDescription().getMediaId())) {
                this.mCurrentMediaItemIndex = i4;
                this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
                return;
            }
        }
        this.mCurrentMediaItemIndex = -1;
        this.mCurrentMediaItem = MediaUtils.convertToMediaItem(this.mMediaMetadataCompat);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setMediaItem(@NonNull String str) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setPlaybackSpeed(float f2) {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.getTransportControls().setPlaybackSpeed(f2);
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setRating(@NonNull String str, @NonNull Rating rating) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                new IllegalStateException();
                return createFutureWithResult(-100);
            }
            MediaItem mediaItem = this.mCurrentMediaItem;
            if (mediaItem != null && str.equals(mediaItem.getMediaId())) {
                this.mControllerCompat.getTransportControls().setRating(MediaUtils.convertToRatingCompat(rating));
            }
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setRepeatMode(int i2) {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.getTransportControls().setRepeatMode(i2);
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setShuffleMode(int i2) {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.getTransportControls().setShuffleMode(i2);
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setSurface(@Nullable Surface surface) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> setVolumeTo(int i2, int i3) {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.setVolumeTo(i2, i3);
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> skipBackward() {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> skipForward() {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> skipToNextItem() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.getTransportControls().skipToNext();
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> skipToPlaylistItem(int i2) {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mSkipToPlaylistIndex = i2;
                this.mControllerCompat.getTransportControls().skipToQueueItem(this.mQueue.get(i2).getQueueId());
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> skipToPreviousItem() {
        synchronized (this.mLock) {
            if (this.mConnected) {
                this.mControllerCompat.getTransportControls().skipToPrevious();
                return createFutureWithResult(0);
            }
            new IllegalStateException();
            return createFutureWithResult(-100);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public a<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata) {
        return createFutureWithResult(-6);
    }
}
