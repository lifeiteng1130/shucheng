package c.b.a.m.r.c;

/* JADX INFO: compiled from: DownsampleStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static final l a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f518b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c.b.a.m.k<l> f522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f523g;

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    public static class a extends l {
        @Override // c.b.a.m.r.c.l
        public e a(int i2, int i3, int i4, int i5) {
            return b(i2, i3, i4, i5) == 1.0f ? e.QUALITY : l.f523g ? e.QUALITY : e.MEMORY;
        }

        @Override // c.b.a.m.r.c.l
        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, l.a.b(i2, i3, i4, i5));
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    public static class b extends l {
        @Override // c.b.a.m.r.c.l
        public e a(int i2, int i3, int i4, int i5) {
            return e.QUALITY;
        }

        @Override // c.b.a.m.r.c.l
        public float b(int i2, int i3, int i4, int i5) {
            return Math.max(i4 / i2, i5 / i3);
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    public static class c extends l {
        @Override // c.b.a.m.r.c.l
        public e a(int i2, int i3, int i4, int i5) {
            return l.f523g ? e.QUALITY : e.MEMORY;
        }

        @Override // c.b.a.m.r.c.l
        public float b(int i2, int i3, int i4, int i5) {
            if (l.f523g) {
                return Math.min(i4 / i2, i5 / i3);
            }
            if (Math.max(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    public static class d extends l {
        @Override // c.b.a.m.r.c.l
        public e a(int i2, int i3, int i4, int i5) {
            return e.QUALITY;
        }

        @Override // c.b.a.m.r.c.l
        public float b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    public enum e {
        MEMORY,
        QUALITY
    }

    static {
        b bVar = new b();
        f519c = bVar;
        f520d = new d();
        f521e = bVar;
        f522f = c.b.a.m.k.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", bVar);
        f523g = true;
    }

    public abstract e a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
