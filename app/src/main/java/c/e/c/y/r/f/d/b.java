package c.e.c.y.r.f.d;

/* JADX INFO: compiled from: AI01320xDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f {
    public b(c.e.c.v.a aVar) {
        super(aVar);
    }

    @Override // c.e.c.y.r.f.d.i
    public void d(StringBuilder sb, int i2) {
        if (i2 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // c.e.c.y.r.f.d.i
    public int e(int i2) {
        return i2 < 10000 ? i2 : i2 - 10000;
    }
}
