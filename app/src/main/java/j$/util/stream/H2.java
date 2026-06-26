package j$.util.stream;

import j$.util.stream.S2;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class H2 extends D2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private S2.c f8046c;

    H2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
    public void accept(int i2) {
        this.f8046c.accept(i2);
    }

    @Override // j$.util.stream.A2.b, j$.util.stream.A2
    public void l() {
        int[] iArr = (int[]) this.f8046c.e();
        Arrays.sort(iArr);
        this.a.m(iArr.length);
        int i2 = 0;
        if (this.f8037b) {
            int length = iArr.length;
            while (i2 < length) {
                int i3 = iArr[i2];
                if (this.a.o()) {
                    break;
                }
                this.a.accept(i3);
                i2++;
            }
        } else {
            int length2 = iArr.length;
            while (i2 < length2) {
                this.a.accept(iArr[i2]);
                i2++;
            }
        }
        this.a.l();
    }

    @Override // j$.util.stream.A2.b, j$.util.stream.A2
    public void m(long j2) {
        if (j2 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f8046c = j2 > 0 ? new S2.c((int) j2) : new S2.c();
    }
}
