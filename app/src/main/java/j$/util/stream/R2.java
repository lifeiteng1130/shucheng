package j$.util.stream;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class R2<T> extends F2<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f8070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8071e;

    R2(A2 a2, Comparator comparator) {
        super(a2, comparator);
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        Object[] objArr = this.f8070d;
        int i2 = this.f8071e;
        this.f8071e = i2 + 1;
        objArr[i2] = obj;
    }

    @Override // j$.util.stream.A2.d, j$.util.stream.A2
    public void l() {
        int i2 = 0;
        Arrays.sort(this.f8070d, 0, this.f8071e, this.f8043b);
        this.a.m(this.f8071e);
        if (this.f8044c) {
            while (i2 < this.f8071e && !this.a.o()) {
                this.a.accept(this.f8070d[i2]);
                i2++;
            }
        } else {
            while (i2 < this.f8071e) {
                this.a.accept(this.f8070d[i2]);
                i2++;
            }
        }
        this.a.l();
        this.f8070d = null;
    }

    @Override // j$.util.stream.A2.d, j$.util.stream.A2
    public void m(long j2) {
        if (j2 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f8070d = new Object[(int) j2];
    }
}
