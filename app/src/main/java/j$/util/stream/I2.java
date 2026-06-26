package j$.util.stream;

import j$.util.stream.S2;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class I2 extends E2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private S2.d f8049c;

    I2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.stream.A2.g, j$.util.stream.A2
    public void accept(long j2) {
        this.f8049c.accept(j2);
    }

    @Override // j$.util.stream.A2.c, j$.util.stream.A2
    public void l() {
        long[] jArr = (long[]) this.f8049c.e();
        Arrays.sort(jArr);
        this.a.m(jArr.length);
        int i2 = 0;
        if (this.f8040b) {
            int length = jArr.length;
            while (i2 < length) {
                long j2 = jArr[i2];
                if (this.a.o()) {
                    break;
                }
                this.a.accept(j2);
                i2++;
            }
        } else {
            int length2 = jArr.length;
            while (i2 < length2) {
                this.a.accept(jArr[i2]);
                i2++;
            }
        }
        this.a.l();
    }

    @Override // j$.util.stream.A2.c, j$.util.stream.A2
    public void m(long j2) {
        if (j2 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f8049c = j2 > 0 ? new S2.d((int) j2) : new S2.d();
    }
}
