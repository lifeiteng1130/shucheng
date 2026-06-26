package c.e.c.y.r.f.d;

/* JADX INFO: compiled from: AI01393xDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends h {
    public d(c.e.c.v.a aVar) {
        super(aVar);
    }

    @Override // c.e.c.y.r.f.d.j
    public String a() throws c.e.c.k {
        if (this.a.f1375b < 48) {
            throw c.e.c.k.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 8);
        int iC = this.f1507b.c(48, 2);
        sb.append("(393");
        sb.append(iC);
        sb.append(')');
        int iC2 = this.f1507b.c(50, 10);
        if (iC2 / 100 == 0) {
            sb.append('0');
        }
        if (iC2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iC2);
        sb.append(this.f1507b.b(60, null).f1511b);
        return sb.toString();
    }
}
