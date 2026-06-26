package k.c.c;

/* JADX INFO: compiled from: BlockQuoteParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends k.c.e.g.a {
    public final k.c.d.b a = new k.c.d.b();

    /* JADX INFO: compiled from: BlockQuoteParser.java */
    public static class a extends k.c.e.g.b {
        @Override // k.c.e.g.d
        public d a(k.c.e.g.f fVar, k.c.e.g.e eVar) {
            h hVar = (h) fVar;
            int i2 = hVar.f8663g;
            if (!c.i(fVar, i2)) {
                return null;
            }
            int i3 = hVar.f8661e + hVar.f8665i + 1;
            if (k.c.c.v.c.b(hVar.f8659c, i2 + 1)) {
                i3++;
            }
            d dVar = new d(new c());
            dVar.f8643c = i3;
            return dVar;
        }
    }

    public static boolean i(k.c.e.g.f fVar, int i2) {
        CharSequence charSequence = ((h) fVar).f8659c;
        return ((h) fVar).f8665i < 4 && i2 < charSequence.length() && charSequence.charAt(i2) == '>';
    }

    @Override // k.c.e.g.c
    public b c(k.c.e.g.f fVar) {
        int i2 = ((h) fVar).f8663g;
        if (!i(fVar, i2)) {
            return null;
        }
        h hVar = (h) fVar;
        int i3 = hVar.f8661e + hVar.f8665i + 1;
        if (k.c.c.v.c.b(hVar.f8659c, i2 + 1)) {
            i3++;
        }
        return b.a(i3);
    }

    @Override // k.c.e.g.c
    public k.c.d.a g() {
        return this.a;
    }
}
