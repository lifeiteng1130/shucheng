package k.c.c;

/* JADX INFO: compiled from: ListBlockParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class p extends k.c.e.g.a {
    public final k.c.d.q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8700c;

    /* JADX INFO: compiled from: ListBlockParser.java */
    public static class a extends k.c.e.g.b {
        /* JADX WARN: Removed duplicated region for block: B:34:0x0090  */
        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        @Override // k.c.e.g.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public k.c.c.d a(k.c.e.g.f r17, k.c.e.g.e r18) {
            /*
                Method dump skipped, instruction units count: 378
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: k.c.c.p.a.a(k.c.e.g.f, k.c.e.g.e):k.c.c.d");
        }
    }

    /* JADX INFO: compiled from: ListBlockParser.java */
    public static class b {
        public final k.c.d.q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8701b;

        public b(k.c.d.q qVar, int i2) {
            this.a = qVar;
            this.f8701b = i2;
        }
    }

    /* JADX INFO: compiled from: ListBlockParser.java */
    public static class c {
        public final k.c.d.q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8702b;

        public c(k.c.d.q qVar, int i2) {
            this.a = qVar;
            this.f8702b = i2;
        }
    }

    public p(k.c.d.q qVar) {
        this.a = qVar;
    }

    public static boolean i(CharSequence charSequence, int i2) {
        char cCharAt;
        return i2 >= charSequence.length() || (cCharAt = charSequence.charAt(i2)) == '\t' || cCharAt == ' ';
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public boolean b() {
        return true;
    }

    @Override // k.c.e.g.c
    public k.c.c.b c(k.c.e.g.f fVar) {
        if (((h) fVar).f8666j) {
            this.f8699b = true;
            this.f8700c = 0;
        } else if (this.f8699b) {
            this.f8700c++;
        }
        return k.c.c.b.b(((h) fVar).f8660d);
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public boolean d(k.c.d.a aVar) {
        if (!(aVar instanceof k.c.d.r)) {
            return false;
        }
        if (this.f8699b && this.f8700c == 1) {
            this.a.f8731f = false;
            this.f8699b = false;
        }
        return true;
    }

    @Override // k.c.e.g.c
    public k.c.d.a g() {
        return this.a;
    }
}
