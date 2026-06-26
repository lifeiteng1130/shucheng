package j$.util.stream;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class O2 extends C2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double[] f8063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8064d;

    O2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.stream.A2.e, j$.util.stream.A2
    public void accept(double d2) {
        double[] dArr = this.f8063c;
        int i2 = this.f8064d;
        this.f8064d = i2 + 1;
        dArr[i2] = d2;
    }

    @Override // j$.util.stream.A2.a, j$.util.stream.A2
    public void l() {
        int i2 = 0;
        Arrays.sort(this.f8063c, 0, this.f8064d);
        this.a.m(this.f8064d);
        if (this.f8026b) {
            while (i2 < this.f8064d && !this.a.o()) {
                this.a.accept(this.f8063c[i2]);
                i2++;
            }
        } else {
            while (i2 < this.f8064d) {
                this.a.accept(this.f8063c[i2]);
                i2++;
            }
        }
        this.a.l();
        this.f8063c = null;
    }

    @Override // j$.util.stream.A2.a, j$.util.stream.A2
    public void m(long j2) {
        if (j2 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f8063c = new double[(int) j2];
    }
}
