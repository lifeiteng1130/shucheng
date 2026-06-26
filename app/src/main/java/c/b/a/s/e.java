package c.b.a.s;

import android.os.SystemClock;

/* JADX INFO: compiled from: LogTime.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final double a = 1.0d / Math.pow(10.0d, 6.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f675b = 0;

    public static double a(long j2) {
        return (SystemClock.elapsedRealtimeNanos() - j2) * a;
    }
}
