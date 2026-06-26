package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.TagBundle;
import c.a.a.a.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_ImmutableImageInfo extends ImmutableImageInfo {
    private final int rotationDegrees;
    private final TagBundle tagBundle;
    private final long timestamp;

    public AutoValue_ImmutableImageInfo(TagBundle tagBundle, long j2, int i2) {
        Objects.requireNonNull(tagBundle, "Null tagBundle");
        this.tagBundle = tagBundle;
        this.timestamp = j2;
        this.rotationDegrees = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableImageInfo)) {
            return false;
        }
        ImmutableImageInfo immutableImageInfo = (ImmutableImageInfo) obj;
        return this.tagBundle.equals(immutableImageInfo.getTagBundle()) && this.timestamp == immutableImageInfo.getTimestamp() && this.rotationDegrees == immutableImageInfo.getRotationDegrees();
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    @NonNull
    public TagBundle getTagBundle() {
        return this.tagBundle;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iHashCode = (this.tagBundle.hashCode() ^ 1000003) * 1000003;
        long j2 = this.timestamp;
        return ((iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.rotationDegrees;
    }

    public String toString() {
        StringBuilder sbR = a.r("ImmutableImageInfo{tagBundle=");
        sbR.append(this.tagBundle);
        sbR.append(", timestamp=");
        sbR.append(this.timestamp);
        sbR.append(", rotationDegrees=");
        return a.o(sbR, this.rotationDegrees, "}");
    }
}
