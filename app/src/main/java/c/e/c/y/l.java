package c.e.c.y;

import java.util.Map;

/* JADX INFO: compiled from: UPCAReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class l extends p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f1464h = new e();

    public static c.e.c.p p(c.e.c.p pVar) throws c.e.c.g {
        String str = pVar.a;
        if (str.charAt(0) != '0') {
            throw c.e.c.g.getFormatInstance();
        }
        c.e.c.p pVar2 = new c.e.c.p(str.substring(1), null, pVar.f1356c, c.e.c.a.UPC_A);
        Map<c.e.c.q, Object> map = pVar.f1358e;
        if (map != null) {
            pVar2.a(map);
        }
        return pVar2;
    }

    @Override // c.e.c.y.k, c.e.c.n
    public c.e.c.p a(c.e.c.c cVar, Map<c.e.c.e, ?> map) {
        return p(this.f1464h.a(cVar, map));
    }

    @Override // c.e.c.y.p, c.e.c.y.k
    public c.e.c.p c(int i2, c.e.c.v.a aVar, Map<c.e.c.e, ?> map) {
        return p(this.f1464h.c(i2, aVar, map));
    }

    @Override // c.e.c.y.p
    public int k(c.e.c.v.a aVar, int[] iArr, StringBuilder sb) {
        return this.f1464h.k(aVar, iArr, sb);
    }

    @Override // c.e.c.y.p
    public c.e.c.p l(int i2, c.e.c.v.a aVar, int[] iArr, Map<c.e.c.e, ?> map) {
        return p(this.f1464h.l(i2, aVar, iArr, map));
    }

    @Override // c.e.c.y.p
    public c.e.c.a o() {
        return c.e.c.a.UPC_A;
    }
}
