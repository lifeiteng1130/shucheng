package j$.util.stream;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class Q2 extends E2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f8068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8069d;

    Q2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.stream.A2.g, j$.util.stream.A2
    public void accept(long j2) {
        long[] jArr = this.f8068c;
        int i2 = this.f8069d;
        this.f8069d = i2 + 1;
        jArr[i2] = j2;
    }

    @Override // j$.util.stream.A2.c, j$.util.stream.A2
    public void l() {
        int i2 = 0;
        Arrays.sort(this.f8068c, 0, this.f8069d);
        this.a.m(this.f8069d);
        if (this.f8040b) {
            while (i2 < this.f8069d && !this.a.o()) {
                this.a.accept(this.f8068c[i2]);
                i2++;
            }
        } else {
            while (i2 < this.f8069d) {
                this.a.accept(this.f8068c[i2]);
                i2++;
            }
        }
        this.a.l();
        this.f8068c = null;
    }

    @Override // j$.util.stream.A2.c, j$.util.stream.A2
    public void m(long j2) {
        if (j2 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f8068c = new long[(int) j2];
    }
}
