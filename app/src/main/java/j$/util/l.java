package j$.util;

import j$.util.function.C0392f;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class l implements j$.util.function.s {
    private double a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f7997b;
    private long count;
    private double sum;
    private double min = Double.POSITIVE_INFINITY;
    private double max = Double.NEGATIVE_INFINITY;

    private void d(double d2) {
        double d3 = d2 - this.a;
        double d4 = this.sum;
        double d5 = d4 + d3;
        this.a = (d5 - d4) - d3;
        this.sum = d5;
    }

    @Override // j$.util.function.s
    public void accept(double d2) {
        this.count++;
        this.f7997b += d2;
        d(d2);
        this.min = Math.min(this.min, d2);
        this.max = Math.max(this.max, d2);
    }

    public void b(l lVar) {
        this.count += lVar.count;
        this.f7997b += lVar.f7997b;
        d(lVar.sum);
        d(lVar.a);
        this.min = Math.min(this.min, lVar.min);
        this.max = Math.max(this.max, lVar.max);
    }

    public final double c() {
        double d2 = this.sum + this.a;
        return (Double.isNaN(d2) && Double.isInfinite(this.f7997b)) ? this.f7997b : d2;
    }

    @Override // j$.util.function.s
    public j$.util.function.s j(j$.util.function.s sVar) {
        Objects.requireNonNull(sVar);
        return new C0392f(this, sVar);
    }

    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = l.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Double.valueOf(c());
        objArr[3] = Double.valueOf(this.min);
        objArr[4] = Double.valueOf(this.count > 0 ? c() / this.count : 0.0d);
        objArr[5] = Double.valueOf(this.max);
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", objArr);
    }
}
