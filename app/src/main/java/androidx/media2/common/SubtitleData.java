package androidx.media2.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class SubtitleData implements VersionedParcelable {
    private static final String TAG = "SubtitleData";
    public byte[] mData;
    public long mDurationUs;
    public long mStartTimeUs;

    public SubtitleData() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SubtitleData.class != obj.getClass()) {
            return false;
        }
        SubtitleData subtitleData = (SubtitleData) obj;
        return this.mStartTimeUs == subtitleData.mStartTimeUs && this.mDurationUs == subtitleData.mDurationUs && Arrays.equals(this.mData, subtitleData.mData);
    }

    @NonNull
    public byte[] getData() {
        return this.mData;
    }

    public long getDurationUs() {
        return this.mDurationUs;
    }

    public long getStartTimeUs() {
        return this.mStartTimeUs;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Long.valueOf(this.mStartTimeUs), Long.valueOf(this.mDurationUs), Integer.valueOf(Arrays.hashCode(this.mData)));
    }

    public SubtitleData(long j2, long j3, @NonNull byte[] bArr) {
        this.mStartTimeUs = j2;
        this.mDurationUs = j3;
        this.mData = bArr;
    }
}
