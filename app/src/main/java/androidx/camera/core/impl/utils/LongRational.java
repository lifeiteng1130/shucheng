package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import h.a.a.a.w;

/* JADX INFO: loaded from: classes.dex */
public final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    public LongRational(long j2, long j3) {
        this.mNumerator = j2;
        this.mDenominator = j3;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public double toDouble() {
        return this.mNumerator / this.mDenominator;
    }

    @NonNull
    public String toString() {
        return this.mNumerator + w.DEFAULT_PATH_SEPARATOR + this.mDenominator;
    }

    public LongRational(double d2) {
        this((long) (d2 * 10000.0d), 10000L);
    }
}
