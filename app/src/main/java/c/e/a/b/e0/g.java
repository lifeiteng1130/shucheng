package c.e.a.b.e0;

import android.graphics.RectF;

/* JADX INFO: compiled from: FitModeEvaluators.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static final f a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f966b = new b();

    /* JADX INFO: compiled from: FitModeEvaluators.java */
    public static class a implements f {
        @Override // c.e.a.b.e0.f
        public boolean a(h hVar) {
            return hVar.f969d > hVar.f971f;
        }

        @Override // c.e.a.b.e0.f
        public void b(RectF rectF, float f2, h hVar) {
            rectF.bottom -= Math.abs(hVar.f971f - hVar.f969d) * f2;
        }

        @Override // c.e.a.b.e0.f
        public h c(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            float f9 = n.f(f5, f7, f3, f4, f2, true);
            float f10 = f9 / f5;
            float f11 = f9 / f7;
            return new h(f10, f11, f9, f6 * f10, f9, f8 * f11);
        }
    }

    /* JADX INFO: compiled from: FitModeEvaluators.java */
    public static class b implements f {
        @Override // c.e.a.b.e0.f
        public boolean a(h hVar) {
            return hVar.f968c > hVar.f970e;
        }

        @Override // c.e.a.b.e0.f
        public void b(RectF rectF, float f2, h hVar) {
            float fAbs = (Math.abs(hVar.f970e - hVar.f968c) / 2.0f) * f2;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }

        @Override // c.e.a.b.e0.f
        public h c(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            float f9 = n.f(f6, f8, f3, f4, f2, true);
            float f10 = f9 / f6;
            float f11 = f9 / f8;
            return new h(f10, f11, f5 * f10, f9, f7 * f11, f9);
        }
    }
}
