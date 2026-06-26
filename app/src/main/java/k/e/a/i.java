package k.e.a;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f8847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f8853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f8854i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f8855j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f8856k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f8857l;

    public i(f fVar, int i2, String str, String str2, String str3, Object obj) {
        this.a = null;
        if (fVar.G == null) {
            fVar.G = this;
        } else {
            fVar.H.a = this;
        }
        fVar.H = this;
        this.f8847b = fVar;
        this.f8848c = i2;
        this.f8849d = fVar.v(str);
        this.f8850e = fVar.v(str2);
        if (str3 != null) {
            this.f8851f = fVar.v(str3);
        }
        if (obj != null) {
            this.f8852g = fVar.k(obj).a;
        }
    }

    public a a(String str, boolean z) {
        c cVar = new c();
        cVar.i(this.f8847b.v(str));
        cVar.i(0);
        a aVar = new a(this.f8847b, true, cVar, cVar, 2);
        if (z) {
            aVar.f8814g = this.f8853h;
            this.f8853h = aVar;
        } else {
            aVar.f8814g = this.f8854i;
            this.f8854i = aVar;
        }
        return aVar;
    }

    public a b(int i2, s sVar, String str, boolean z) {
        c cVar = new c();
        a.b(i2, sVar, cVar);
        cVar.i(this.f8847b.v(str));
        cVar.i(0);
        a aVar = new a(this.f8847b, true, cVar, cVar, cVar.f8818b - 2);
        if (z) {
            aVar.f8814g = this.f8855j;
            this.f8855j = aVar;
        } else {
            aVar.f8814g = this.f8856k;
            this.f8856k = aVar;
        }
        return aVar;
    }
}
