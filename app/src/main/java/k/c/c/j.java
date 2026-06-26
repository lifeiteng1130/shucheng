package k.c.c;

/* JADX INFO: compiled from: HeadingParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends k.c.e.g.a {
    public final k.c.d.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8671b;

    /* JADX INFO: compiled from: HeadingParser.java */
    public static class a extends k.c.e.g.b {
        /* JADX WARN: Removed duplicated region for block: B:29:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00ae  */
        @Override // k.c.e.g.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public k.c.c.d a(k.c.e.g.f r10, k.c.e.g.e r11) {
            /*
                Method dump skipped, instruction units count: 213
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: k.c.c.j.a.a(k.c.e.g.f, k.c.e.g.e):k.c.c.d");
        }
    }

    public j(int i2, String str) {
        k.c.d.j jVar = new k.c.d.j();
        this.a = jVar;
        jVar.f8720f = i2;
        this.f8671b = str;
    }

    public static boolean i(CharSequence charSequence, int i2, char c2) {
        return k.c.c.v.c.d(charSequence, k.c.c.v.c.c(c2, charSequence, i2, charSequence.length()), charSequence.length()) >= charSequence.length();
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public void a(k.c.e.a aVar) {
        ((n) aVar).f(this.f8671b, this.a);
    }

    @Override // k.c.e.g.c
    public b c(k.c.e.g.f fVar) {
        return null;
    }

    @Override // k.c.e.g.c
    public k.c.d.a g() {
        return this.a;
    }
}
