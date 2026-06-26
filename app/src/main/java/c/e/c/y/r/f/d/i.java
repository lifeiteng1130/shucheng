package c.e.c.y.r.f.d;

/* JADX INFO: compiled from: AI01weightDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class i extends h {
    public i(c.e.c.v.a aVar) {
        super(aVar);
    }

    public abstract void d(StringBuilder sb, int i2);

    public abstract int e(int i2);

    public final void f(StringBuilder sb, int i2, int i3) {
        int iD = s.d(this.f1507b.a, i2, i3);
        d(sb, iD);
        int iE = e(iD);
        int i4 = 100000;
        for (int i5 = 0; i5 < 5; i5++) {
            if (iE / i4 == 0) {
                sb.append('0');
            }
            i4 /= 10;
        }
        sb.append(iE);
    }
}
