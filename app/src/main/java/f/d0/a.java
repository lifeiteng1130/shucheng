package f.d0;

import f.c0.c.j;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends c {
    @NotNull
    public abstract Random getImpl();

    @Override // f.d0.c
    public int nextBits(int i2) {
        return ((-i2) >> 31) & (getImpl().nextInt() >>> (32 - i2));
    }

    @Override // f.d0.c
    public boolean nextBoolean() {
        return getImpl().nextBoolean();
    }

    @Override // f.d0.c
    @NotNull
    public byte[] nextBytes(@NotNull byte[] bArr) {
        j.e(bArr, "array");
        getImpl().nextBytes(bArr);
        return bArr;
    }

    @Override // f.d0.c
    public double nextDouble() {
        return getImpl().nextDouble();
    }

    @Override // f.d0.c
    public float nextFloat() {
        return getImpl().nextFloat();
    }

    @Override // f.d0.c
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // f.d0.c
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override // f.d0.c
    public int nextInt(int i2) {
        return getImpl().nextInt(i2);
    }
}
