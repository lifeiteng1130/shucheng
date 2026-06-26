package f.d0;

import java.io.Serializable;

/* JADX INFO: compiled from: XorWowRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends c implements Serializable {

    @Deprecated
    private static final long serialVersionUID = 0;
    private int addend;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public d(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.w = i5;
        this.v = i6;
        this.addend = i7;
        int i8 = i2 | i3 | i4 | i5 | i6;
        if (!(i8 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i9 = 0; i9 < 64; i9++) {
            nextInt();
        }
    }

    @Override // f.d0.c
    public int nextBits(int i2) {
        return ((-i2) >> 31) & (nextInt() >>> (32 - i2));
    }

    @Override // f.d0.c
    public int nextInt() {
        int i2 = this.x;
        int i3 = i2 ^ (i2 >>> 2);
        this.x = this.y;
        this.y = this.z;
        this.z = this.w;
        int i4 = this.v;
        this.w = i4;
        int i5 = ((i3 ^ (i3 << 1)) ^ i4) ^ (i4 << 4);
        this.v = i5;
        int i6 = this.addend + 362437;
        this.addend = i6;
        return i5 + i6;
    }

    public d(int i2, int i3) {
        this(i2, i3, 0, 0, ~i2, (i2 << 10) ^ (i3 >>> 4));
    }
}
