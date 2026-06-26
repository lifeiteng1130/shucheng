package androidx.media2.session;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.IMediaController;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.versionedparcelable.ParcelImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaControllerStub extends IMediaController.Stub {
    private static final boolean DEBUG = true;
    private static final String TAG = "MediaControllerStub";
    private final WeakReference<MediaControllerImplBase> mController;
    public final SequencedFutureManager mSequencedFutureManager;

    @FunctionalInterface
    public interface BrowserTask {
        void run(MediaBrowserImplBase mediaBrowserImplBase);
    }

    @FunctionalInterface
    public interface ControllerTask {
        void run(MediaControllerImplBase mediaControllerImplBase);
    }

    public MediaControllerStub(MediaControllerImplBase mediaControllerImplBase, SequencedFutureManager sequencedFutureManager) {
        this.mController = new WeakReference<>(mediaControllerImplBase);
        this.mSequencedFutureManager = sequencedFutureManager;
    }

    private void dispatchBrowserTask(BrowserTask browserTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.mController.get();
            if ((mediaControllerImplBase instanceof MediaBrowserImplBase) && mediaControllerImplBase.isConnected()) {
                browserTask.run((MediaBrowserImplBase) mediaControllerImplBase);
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    private void dispatchControllerTask(ControllerTask controllerTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.mController.get();
            if (mediaControllerImplBase != null && mediaControllerImplBase.isConnected()) {
                controllerTask.run(mediaControllerImplBase);
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    public void destroy() {
        this.mController.clear();
    }

    @Override // androidx.media2.session.IMediaController
    public void onAllowedCommandsChanged(int i2, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.17
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionCommandGroup sessionCommandGroup = (SessionCommandGroup) MediaParcelUtils.fromParcelable(parcelImpl);
                if (sessionCommandGroup == null) {
                    return;
                }
                mediaControllerImplBase.onAllowedCommandsChanged(sessionCommandGroup);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onBufferingStateChanged(int i2, final ParcelImpl parcelImpl, final int i3, final long j2, final long j3, final long j4) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.6
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                MediaItem mediaItem = (MediaItem) MediaParcelUtils.fromParcelable(parcelImpl);
                if (mediaItem == null) {
                    return;
                }
                mediaControllerImplBase.notifyBufferingStateChanged(mediaItem, i3, j2, j3, j4);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onChildrenChanged(int i2, final String str, final int i3, final ParcelImpl parcelImpl) {
        if (parcelImpl == null || TextUtils.isEmpty(str) || i3 < 0) {
            return;
        }
        dispatchBrowserTask(new BrowserTask() { // from class: androidx.media2.session.MediaControllerStub.23
            @Override // androidx.media2.session.MediaControllerStub.BrowserTask
            public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                mediaBrowserImplBase.notifyChildrenChanged(str, i3, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(parcelImpl));
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onConnected(int i2, ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            onDisconnected(i2);
            return;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.mController.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            ConnectionResult connectionResult = (ConnectionResult) MediaParcelUtils.fromParcelable(parcelImpl);
            mediaControllerImplBase.onConnectedNotLocked(connectionResult.getVersion(), connectionResult.getSessionStub(), connectionResult.getAllowedCommands(), connectionResult.getPlayerState(), connectionResult.getCurrentMediaItem(), connectionResult.getPositionEventTimeMs(), connectionResult.getPositionMs(), connectionResult.getPlaybackSpeed(), connectionResult.getBufferedPositionMs(), connectionResult.getPlaybackInfo(), connectionResult.getRepeatMode(), connectionResult.getShuffleMode(), MediaUtils.convertParcelImplListSliceToMediaItemList(connectionResult.getPlaylistSlice()), connectionResult.getSessionActivity(), connectionResult.getCurrentMediaItemIndex(), connectionResult.getPreviousMediaItemIndex(), connectionResult.getNextMediaItemIndex(), connectionResult.getTokenExtras(), connectionResult.getVideoSize(), connectionResult.getTracks(), connectionResult.getSelectedVideoTrack(), connectionResult.getSelectedAudioTrack(), connectionResult.getSelectedSubtitleTrack(), connectionResult.getSelectedMetadataTrack(), connectionResult.getPlaylistMetadata(), connectionResult.getBufferingState());
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onCurrentMediaItemChanged(int i2, final ParcelImpl parcelImpl, final int i3, final int i4, final int i5) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.3
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyCurrentMediaItemChanged((MediaItem) MediaParcelUtils.fromParcelable(parcelImpl), i3, i4, i5);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onCustomCommand(final int i2, final ParcelImpl parcelImpl, final Bundle bundle) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.18
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionCommand sessionCommand = (SessionCommand) MediaParcelUtils.fromParcelable(parcelImpl);
                if (sessionCommand == null) {
                    return;
                }
                mediaControllerImplBase.onCustomCommand(i2, sessionCommand, bundle);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onDisconnected(int i2) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.mController.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            mediaControllerImplBase.mInstance.close();
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onLibraryResult(final int i2, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchBrowserTask(new BrowserTask() { // from class: androidx.media2.session.MediaControllerStub.2
            @Override // androidx.media2.session.MediaControllerStub.BrowserTask
            public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                LibraryResult libraryResult = (LibraryResult) MediaParcelUtils.fromParcelable(parcelImpl);
                if (libraryResult == null) {
                    return;
                }
                MediaControllerStub.this.mSequencedFutureManager.setFutureResult(i2, libraryResult);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaybackCompleted(int i2) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.11
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlaybackCompleted();
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaybackInfoChanged(int i2, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.12
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                MediaController.PlaybackInfo playbackInfo = (MediaController.PlaybackInfo) MediaParcelUtils.fromParcelable(parcelImpl);
                if (playbackInfo == null) {
                    return;
                }
                mediaControllerImplBase.notifyPlaybackInfoChanges(playbackInfo);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaybackSpeedChanged(int i2, final long j2, final long j3, final float f2) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.5
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlaybackSpeedChanges(j2, j3, f2);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlayerStateChanged(int i2, final long j2, final long j3, final int i3) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.4
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlayerStateChanges(j2, j3, i3);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaylistChanged(int i2, final ParcelImplListSlice parcelImplListSlice, final ParcelImpl parcelImpl, final int i3, final int i4, final int i5) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.7
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlaylistChanges(MediaUtils.convertParcelImplListSliceToMediaItemList(parcelImplListSlice), (MediaMetadata) MediaParcelUtils.fromParcelable(parcelImpl), i3, i4, i5);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaylistMetadataChanged(int i2, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.8
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlaylistMetadataChanges((MediaMetadata) MediaParcelUtils.fromParcelable(parcelImpl));
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onRepeatModeChanged(int i2, final int i3, final int i4, final int i5, final int i6) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.9
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyRepeatModeChanges(i3, i4, i5, i6);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSearchResultChanged(int i2, final String str, final int i3, final ParcelImpl parcelImpl) {
        if (parcelImpl == null || TextUtils.isEmpty(str) || i3 < 0) {
            return;
        }
        dispatchBrowserTask(new BrowserTask() { // from class: androidx.media2.session.MediaControllerStub.22
            @Override // androidx.media2.session.MediaControllerStub.BrowserTask
            public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                mediaBrowserImplBase.notifySearchResultChanged(str, i3, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(parcelImpl));
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSeekCompleted(int i2, final long j2, final long j3, final long j4) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.13
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifySeekCompleted(j2, j3, j4);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSessionResult(final int i2, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.1
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionResult sessionResult = (SessionResult) MediaParcelUtils.fromParcelable(parcelImpl);
                if (sessionResult == null) {
                    return;
                }
                MediaControllerStub.this.mSequencedFutureManager.setFutureResult(i2, sessionResult);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSetCustomLayout(final int i2, final List<ParcelImpl> list) {
        if (list == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.16
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    MediaSession.CommandButton commandButton = (MediaSession.CommandButton) MediaParcelUtils.fromParcelable((ParcelImpl) list.get(i3));
                    if (commandButton != null) {
                        arrayList.add(commandButton);
                    }
                }
                mediaControllerImplBase.onSetCustomLayout(i2, arrayList);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onShuffleModeChanged(int i2, final int i3, final int i4, final int i5, final int i6) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.10
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyShuffleModeChanges(i3, i4, i5, i6);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSubtitleData(int i2, final ParcelImpl parcelImpl, final ParcelImpl parcelImpl2, final ParcelImpl parcelImpl3) {
        if (parcelImpl == null || parcelImpl2 == null || parcelImpl3 == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.15
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionPlayer.TrackInfo trackInfo;
                SubtitleData subtitleData;
                MediaItem mediaItem = (MediaItem) MediaParcelUtils.fromParcelable(parcelImpl);
                if (mediaItem == null || (trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl2)) == null || (subtitleData = (SubtitleData) MediaParcelUtils.fromParcelable(parcelImpl3)) == null) {
                    return;
                }
                mediaControllerImplBase.notifySubtitleData(mediaItem, trackInfo, subtitleData);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onTrackDeselected(final int i2, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.21
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl);
                if (trackInfo == null) {
                    return;
                }
                mediaControllerImplBase.notifyTrackDeselected(i2, trackInfo);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onTrackInfoChanged(final int i2, final List<ParcelImpl> list, final ParcelImpl parcelImpl, final ParcelImpl parcelImpl2, final ParcelImpl parcelImpl3, final ParcelImpl parcelImpl4) {
        if (list == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.19
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyTracksChanged(i2, MediaParcelUtils.fromParcelableList(list), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl2), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl3), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl4));
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onTrackSelected(final int i2, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.20
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl);
                if (trackInfo == null) {
                    return;
                }
                mediaControllerImplBase.notifyTrackSelected(i2, trackInfo);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onVideoSizeChanged(int i2, ParcelImpl parcelImpl, final ParcelImpl parcelImpl2) {
        if (parcelImpl2 == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.14
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                VideoSize videoSize = (VideoSize) MediaParcelUtils.fromParcelable(parcelImpl2);
                if (videoSize == null) {
                    return;
                }
                mediaControllerImplBase.notifyVideoSizeChanged(videoSize);
            }
        });
    }
}
