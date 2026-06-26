package androidx.media2.common;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.versionedparcelable.VersionedParcelable;

/* JADX INFO: loaded from: classes.dex */
public class VideoSize implements VersionedParcelable {
    public int mHeight;
    public int mWidth;

    public VideoSize() {
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        return this.mWidth == videoSize.mWidth && this.mHeight == videoSize.mHeight;
    }

    @IntRange(from = 0)
    public int getHeight() {
        return this.mHeight;
    }

    @IntRange(from = 0)
    public int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int i2 = this.mHeight;
        int i3 = this.mWidth;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    @NonNull
    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }

    public VideoSize(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("width can not be negative");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("height can not be negative");
        }
        this.mWidth = i2;
        this.mHeight = i3;
    }
}
