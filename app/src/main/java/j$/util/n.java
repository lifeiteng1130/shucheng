package j$.util;

import androidx.recyclerview.widget.RecyclerView;
import j$.util.function.C0395i;
import j$.util.function.C0396j;
import j$.util.function.E;
import j$.util.function.y;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class n implements E, y {
    private long count;
    private long sum;
    private long min = RecyclerView.FOREVER_NS;
    private long max = Long.MIN_VALUE;

    @Override // j$.util.function.y
    public void accept(int i2) {
        accept(i2);
    }

    @Override // j$.util.function.E
    public void accept(long j2) {
        this.count++;
        this.sum += j2;
        this.min = Math.min(this.min, j2);
        this.max = Math.max(this.max, j2);
    }

    public void b(n nVar) {
        this.count += nVar.count;
        this.sum += nVar.sum;
        this.min = Math.min(this.min, nVar.min);
        this.max = Math.max(this.max, nVar.max);
    }

    @Override // j$.util.function.E
    public E f(E e2) {
        Objects.requireNonNull(e2);
        return new C0396j(this, e2);
    }

    @Override // j$.util.function.y
    public y k(y yVar) {
        Objects.requireNonNull(yVar);
        return new C0395i(this, yVar);
    }

    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = n.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Long.valueOf(this.sum);
        objArr[3] = Long.valueOf(this.min);
        long j2 = this.count;
        objArr[4] = Double.valueOf(j2 > 0 ? this.sum / j2 : 0.0d);
        objArr[5] = Long.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
