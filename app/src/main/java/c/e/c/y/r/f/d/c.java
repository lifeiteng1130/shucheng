package c.e.c.y.r.f.d;

/* JADX INFO: compiled from: AI01392xDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends h {
    public c(c.e.c.v.a aVar) {
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
        sb.append("(392");
        sb.append(iC);
        sb.append(')');
        sb.append(this.f1507b.b(50, null).f1511b);
        return sb.toString();
    }
}
