package androidx.media2.session;

import android.view.Surface;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import c.e.b.a.a.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaInterface {

    public interface SessionPlaybackControl {
        long getBufferedPosition();

        int getBufferingState();

        long getCurrentPosition();

        long getDuration();

        float getPlaybackSpeed();

        int getPlayerState();

        a<SessionPlayer.PlayerResult> pause();

        a<SessionPlayer.PlayerResult> play();

        a<SessionPlayer.PlayerResult> prepare();

        a<SessionPlayer.PlayerResult> seekTo(long j2);

        a<SessionPlayer.PlayerResult> setPlaybackSpeed(float f2);
    }

    public interface SessionPlayer extends SessionPlaybackControl, SessionPlaylistControl {
        a<SessionPlayer.PlayerResult> deselectTrack(SessionPlayer.TrackInfo trackInfo);

        SessionPlayer.TrackInfo getSelectedTrack(int i2);

        List<SessionPlayer.TrackInfo> getTracks();

        VideoSize getVideoSize();

        a<SessionPlayer.PlayerResult> selectTrack(SessionPlayer.TrackInfo trackInfo);

        a<SessionPlayer.PlayerResult> setSurface(Surface surface);
    }

    public interface SessionPlaylistControl {
        a<SessionPlayer.PlayerResult> addPlaylistItem(int i2, MediaItem mediaItem);

        MediaItem getCurrentMediaItem();

        int getCurrentMediaItemIndex();

        int getNextMediaItemIndex();

        List<MediaItem> getPlaylist();

        MediaMetadata getPlaylistMetadata();

        int getPreviousMediaItemIndex();

        int getRepeatMode();

        int getShuffleMode();

        a<SessionPlayer.PlayerResult> movePlaylistItem(int i2, int i3);

        a<SessionPlayer.PlayerResult> removePlaylistItem(int i2);

        a<SessionPlayer.PlayerResult> replacePlaylistItem(int i2, MediaItem mediaItem);

        a<SessionPlayer.PlayerResult> setMediaItem(MediaItem mediaItem);

        a<SessionPlayer.PlayerResult> setPlaylist(List<MediaItem> list, MediaMetadata mediaMetadata);

        a<SessionPlayer.PlayerResult> setRepeatMode(int i2);

        a<SessionPlayer.PlayerResult> setShuffleMode(int i2);

        a<SessionPlayer.PlayerResult> skipToNextItem();

        a<SessionPlayer.PlayerResult> skipToPlaylistItem(int i2);

        a<SessionPlayer.PlayerResult> skipToPreviousItem();

        a<SessionPlayer.PlayerResult> updatePlaylistMetadata(MediaMetadata mediaMetadata);
    }

    private MediaInterface() {
    }
}
