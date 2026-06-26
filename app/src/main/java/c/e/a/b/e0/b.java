package c.e.a.b.e0;

/* JADX INFO: compiled from: FadeModeEvaluators.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final c.e.a.b.e0.a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c.e.a.b.e0.a f951b = new C0042b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c.e.a.b.e0.a f952c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c.e.a.b.e0.a f953d = new d();

    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class a implements c.e.a.b.e0.a {
        @Override // c.e.a.b.e0.a
        public c.e.a.b.e0.c a(float f2, float f3, float f4) {
            return new c.e.a.b.e0.c(255, n.g(0, 255, f3, f4, f2), true);
        }
    }

    /* JADX INFO: renamed from: c.e.a.b.e0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class C0042b implements c.e.a.b.e0.a {
        @Override // c.e.a.b.e0.a
        public c.e.a.b.e0.c a(float f2, float f3, float f4) {
            return c.e.a.b.e0.c.a(n.g(255, 0, f3, f4, f2), 255);
        }
    }

    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class c implements c.e.a.b.e0.a {
        @Override // c.e.a.b.e0.a
        public c.e.a.b.e0.c a(float f2, float f3, float f4) {
            return c.e.a.b.e0.c.a(n.g(255, 0, f3, f4, f2), n.g(0, 255, f3, f4, f2));
        }
    }

    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class d implements c.e.a.b.e0.a {
        @Override // c.e.a.b.e0.a
        public c.e.a.b.e0.c a(float f2, float f3, float f4) {
            float fA = c.a.a.a.a.a(f4, f3, 0.35f, f3);
            return c.e.a.b.e0.c.a(n.g(255, 0, f3, fA, f2), n.g(0, 255, fA, f4, f2));
        }
    }
}
