package g.b.h2;

import g.b.g2.r;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    @JvmField
    public static final long a = c.b.a.m.f.A5("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final int f6245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public static final int f6246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public static final long f6247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public static h f6248e;

    static {
        c.b.a.m.f.z5("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        int i2 = r.a;
        int iZ5 = c.b.a.m.f.z5("kotlinx.coroutines.scheduler.core.pool.size", i2 < 2 ? 2 : i2, 1, 0, 8, null);
        f6245b = iZ5;
        f6246c = c.b.a.m.f.z5("kotlinx.coroutines.scheduler.max.pool.size", f.e0.e.b(i2 * 128, iZ5, 2097150), 0, 2097150, 4, null);
        f6247d = TimeUnit.SECONDS.toNanos(c.b.a.m.f.A5("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
        f6248e = f.a;
    }
}
