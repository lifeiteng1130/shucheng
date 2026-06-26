package f.d0.e;

import f.c0.c.j;
import j$.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformThreadLocalRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f.d0.a {
    @Override // f.d0.a
    @NotNull
    public Random getImpl() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        j.d(threadLocalRandomCurrent, "ThreadLocalRandom.current()");
        return threadLocalRandomCurrent;
    }

    @Override // f.d0.c
    public double nextDouble(double d2) {
        return ThreadLocalRandom.current().nextDouble(d2);
    }

    @Override // f.d0.c
    public int nextInt(int i2, int i3) {
        return ThreadLocalRandom.current().nextInt(i2, i3);
    }

    @Override // f.d0.c
    public long nextLong(long j2) {
        return ThreadLocalRandom.current().nextLong(j2);
    }

    @Override // f.d0.c
    public long nextLong(long j2, long j3) {
        return ThreadLocalRandom.current().nextLong(j2, j3);
    }
}
