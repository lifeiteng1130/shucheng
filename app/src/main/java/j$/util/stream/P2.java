package j$.util.stream;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class P2 extends D2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f8066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8067d;

    P2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
    public void accept(int i2) {
        int[] iArr = this.f8066c;
        int i3 = this.f8067d;
        this.f8067d = i3 + 1;
        iArr[i3] = i2;
    }

    @Override // j$.util.stream.A2.b, j$.util.stream.A2
    public void l() {
        int i2 = 0;
        Arrays.sort(this.f8066c, 0, this.f8067d);
        this.a.m(this.f8067d);
        if (this.f8037b) {
            while (i2 < this.f8067d && !this.a.o()) {
                this.a.accept(this.f8066c[i2]);
                i2++;
            }
        } else {
            while (i2 < this.f8067d) {
                this.a.accept(this.f8066c[i2]);
                i2++;
            }
        }
        this.a.l();
        this.f8066c = null;
    }

    @Override // j$.util.stream.A2.b, j$.util.stream.A2
    public void m(long j2) {
        if (j2 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f8066c = new int[(int) j2];
    }
}
