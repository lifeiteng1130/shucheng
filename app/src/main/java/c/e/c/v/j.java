package c.e.c.v;

/* JADX INFO: compiled from: PerspectiveTransform.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f1396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f1397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f1398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f1399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f1400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f1401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f1402i;

    public j(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.a = f2;
        this.f1395b = f5;
        this.f1396c = f8;
        this.f1397d = f3;
        this.f1398e = f6;
        this.f1399f = f9;
        this.f1400g = f4;
        this.f1401h = f7;
        this.f1402i = f10;
    }

    public static j a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        j jVarB = b(f2, f3, f4, f5, f6, f7, f8, f9);
        float f18 = jVarB.f1398e;
        float f19 = jVarB.f1402i;
        float f20 = jVarB.f1399f;
        float f21 = jVarB.f1401h;
        float f22 = (f18 * f19) - (f20 * f21);
        float f23 = jVarB.f1400g;
        float f24 = jVarB.f1397d;
        float f25 = (f20 * f23) - (f24 * f19);
        float f26 = (f24 * f21) - (f18 * f23);
        float f27 = jVarB.f1396c;
        float f28 = jVarB.f1395b;
        float f29 = (f27 * f21) - (f28 * f19);
        float f30 = jVarB.a;
        float f31 = (f19 * f30) - (f27 * f23);
        float f32 = (f23 * f28) - (f21 * f30);
        float f33 = (f28 * f20) - (f27 * f18);
        float f34 = (f27 * f24) - (f20 * f30);
        float f35 = (f30 * f18) - (f28 * f24);
        j jVarB2 = b(f10, f11, f12, f13, f14, f15, f16, f17);
        float f36 = jVarB2.a;
        float f37 = jVarB2.f1397d;
        float f38 = jVarB2.f1400g;
        float f39 = (f37 * f29) + (f36 * f22) + (f38 * f33);
        float f40 = (f38 * f34) + (f37 * f31) + (f36 * f25);
        float f41 = f38 * f35;
        float f42 = f41 + (f37 * f32) + (f36 * f26);
        float f43 = jVarB2.f1395b;
        float f44 = jVarB2.f1398e;
        float f45 = jVarB2.f1401h;
        float f46 = (f45 * f33) + (f44 * f29) + (f43 * f22);
        float f47 = (f45 * f34) + (f44 * f31) + (f43 * f25);
        float f48 = (f44 * f32) + (f43 * f26) + (f45 * f35);
        float f49 = jVarB2.f1396c;
        float f50 = jVarB2.f1399f;
        float f51 = f29 * f50;
        float f52 = jVarB2.f1402i;
        return new j(f39, f40, f42, f46, f47, f48, (f33 * f52) + f51 + (f22 * f49), (f31 * f50) + (f25 * f49) + (f34 * f52), (f52 * f35) + (f50 * f32) + (f49 * f26));
    }

    public static j b(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == 0.0f && f11 == 0.0f) {
            return new j(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, 0.0f, 0.0f, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f12 * f11) - (f10 * f14)) / f16;
        return new j((f17 * f4) + (f4 - f2), (f18 * f8) + (f8 - f2), f2, (f17 * f5) + (f5 - f3), (f18 * f9) + (f9 - f3), f3, f17, f18, 1.0f);
    }
}
