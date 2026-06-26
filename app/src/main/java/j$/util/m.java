package j$.util;

import j$.util.function.C0395i;
import j$.util.function.y;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class m implements y {
    private long count;
    private long sum;
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    @Override // j$.util.function.y
    public void accept(int i2) {
        this.count++;
        this.sum += (long) i2;
        this.min = Math.min(this.min, i2);
        this.max = Math.max(this.max, i2);
    }

    public void b(m mVar) {
        this.count += mVar.count;
        this.sum += mVar.sum;
        this.min = Math.min(this.min, mVar.min);
        this.max = Math.max(this.max, mVar.max);
    }

    @Override // j$.util.function.y
    public y k(y yVar) {
        Objects.requireNonNull(yVar);
        return new C0395i(this, yVar);
    }

    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = m.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Long.valueOf(this.sum);
        objArr[3] = Integer.valueOf(this.min);
        long j2 = this.count;
        objArr[4] = Double.valueOf(j2 > 0 ? this.sum / j2 : 0.0d);
        objArr[5] = Integer.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
