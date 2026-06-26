package androidx.media2.common;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes.dex */
public class MediaItem extends CustomVersionedParcelable {
    public static final long LONG_MAX = 576460752303423487L;
    public static final long POSITION_UNKNOWN = 576460752303423487L;
    private static final String TAG = "MediaItem";
    public long mEndPositionMs;

    @GuardedBy("mLock")
    private final List<Pair<OnMetadataChangedListener, Executor>> mListeners;
    private final Object mLock;

    @GuardedBy("mLock")
    public MediaMetadata mMetadata;
    public long mStartPositionMs;

    public static class Builder {
        public MediaMetadata mMetadata;
        public long mStartPositionMs = 0;
        public long mEndPositionMs = 576460752303423487L;

        @NonNull
        public MediaItem build() {
            return new MediaItem(this);
        }

        @NonNull
        public Builder setEndPosition(long j2) {
            if (j2 < 0) {
                j2 = 576460752303423487L;
            }
            this.mEndPositionMs = j2;
            return this;
        }

        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            this.mMetadata = mediaMetadata;
            return this;
        }

        @NonNull
        public Builder setStartPosition(long j2) {
            if (j2 < 0) {
                j2 = 0;
            }
            this.mStartPositionMs = j2;
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnMetadataChangedListener {
        void onMetadataChanged(@NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata);
    }

    public MediaItem() {
        this.mLock = new Object();
        this.mStartPositionMs = 0L;
        this.mEndPositionMs = 576460752303423487L;
        this.mListeners = new ArrayList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addOnMetadataChangedListener(Executor executor, OnMetadataChangedListener onMetadataChangedListener) {
        synchronized (this.mLock) {
            Iterator<Pair<OnMetadataChangedListener, Executor>> it = this.mListeners.iterator();
            while (it.hasNext()) {
                if (it.next().first == onMetadataChangedListener) {
                    return;
                }
            }
            this.mListeners.add(new Pair<>(onMetadataChangedListener, executor));
        }
    }

    public long getEndPosition() {
        return this.mEndPositionMs;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getMediaId() {
        String string;
        synchronized (this.mLock) {
            MediaMetadata mediaMetadata = this.mMetadata;
            string = mediaMetadata != null ? mediaMetadata.getString("android.media.metadata.MEDIA_ID") : null;
        }
        return string;
    }

    @Nullable
    public MediaMetadata getMetadata() {
        MediaMetadata mediaMetadata;
        synchronized (this.mLock) {
            mediaMetadata = this.mMetadata;
        }
        return mediaMetadata;
    }

    public long getStartPosition() {
        return this.mStartPositionMs;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPreParceling(boolean z) {
        if (getClass() != MediaItem.class) {
            throw new RuntimeException("MediaItem's subclasses shouldn't be parcelized.");
        }
        super.onPreParceling(z);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void removeOnMetadataChangedListener(OnMetadataChangedListener onMetadataChangedListener) {
        synchronized (this.mLock) {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                if (this.mListeners.get(size).first == onMetadataChangedListener) {
                    this.mListeners.remove(size);
                    return;
                }
            }
        }
    }

    public void setMetadata(@Nullable final MediaMetadata mediaMetadata) {
        ArrayList<Pair> arrayList = new ArrayList();
        synchronized (this.mLock) {
            MediaMetadata mediaMetadata2 = this.mMetadata;
            if (mediaMetadata2 == mediaMetadata) {
                return;
            }
            if (mediaMetadata2 == null || mediaMetadata == null || TextUtils.equals(getMediaId(), mediaMetadata.getMediaId())) {
                this.mMetadata = mediaMetadata;
                arrayList.addAll(this.mListeners);
                for (Pair pair : arrayList) {
                    final OnMetadataChangedListener onMetadataChangedListener = (OnMetadataChangedListener) pair.first;
                    ((Executor) pair.second).execute(new Runnable() { // from class: androidx.media2.common.MediaItem.1
                        @Override // java.lang.Runnable
                        public void run() {
                            onMetadataChangedListener.onMetadataChanged(MediaItem.this, mediaMetadata);
                        }
                    });
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        synchronized (this.mLock) {
            sb.append("{Media Id=");
            sb.append(getMediaId());
            sb.append(", mMetadata=");
            sb.append(this.mMetadata);
            sb.append(", mStartPositionMs=");
            sb.append(this.mStartPositionMs);
            sb.append(", mEndPositionMs=");
            sb.append(this.mEndPositionMs);
            sb.append(MessageFormatter.DELIM_STOP);
        }
        return sb.toString();
    }

    public MediaItem(Builder builder) {
        this(builder.mMetadata, builder.mStartPositionMs, builder.mEndPositionMs);
    }

    public MediaItem(MediaItem mediaItem) {
        this(mediaItem.mMetadata, mediaItem.mStartPositionMs, mediaItem.mEndPositionMs);
    }

    public MediaItem(@Nullable MediaMetadata mediaMetadata, long j2, long j3) {
        this.mLock = new Object();
        this.mStartPositionMs = 0L;
        this.mEndPositionMs = 576460752303423487L;
        this.mListeners = new ArrayList();
        if (j2 <= j3) {
            if (mediaMetadata != null && mediaMetadata.containsKey("android.media.metadata.DURATION")) {
                long j4 = mediaMetadata.getLong("android.media.metadata.DURATION");
                if (j4 != Long.MIN_VALUE && j3 != 576460752303423487L && j3 > j4) {
                    throw new IllegalStateException("endPositionMs shouldn't be greater than duration in the metdata, endPositionMs=" + j3 + ", durationMs=" + j4);
                }
            }
            this.mMetadata = mediaMetadata;
            this.mStartPositionMs = j2;
            this.mEndPositionMs = j3;
            return;
        }
        throw new IllegalStateException("Illegal start/end position: " + j2 + " : " + j3);
    }
}
