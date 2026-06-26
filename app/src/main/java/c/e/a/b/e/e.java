package c.e.a.b.e;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import c.e.a.b.w.f;
import c.e.a.b.w.o;

/* JADX INFO: compiled from: BottomAppBarTopEdgeTreatment.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends f implements Cloneable {
    public float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f950e;

    public e(float f2, float f3, float f4) {
        this.f947b = f2;
        this.a = f3;
        c(f4);
        this.f950e = 0.0f;
    }

    @Override // c.e.a.b.w.f
    public void b(float f2, float f3, float f4, @NonNull o oVar) {
        float f5 = this.f948c;
        if (f5 == 0.0f) {
            oVar.d(f2, 0.0f);
            return;
        }
        float f6 = ((this.f947b * 2.0f) + f5) / 2.0f;
        float f7 = f4 * this.a;
        float f8 = f3 + this.f950e;
        float fA = c.a.a.a.a.a(1.0f, f4, f6, this.f949d * f4);
        if (fA / f6 >= 1.0f) {
            oVar.d(f2, 0.0f);
            return;
        }
        float f9 = f6 + f7;
        float f10 = fA + f7;
        float fSqrt = (float) Math.sqrt((f9 * f9) - (f10 * f10));
        float f11 = f8 - fSqrt;
        float f12 = f8 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f10));
        float f13 = 90.0f - degrees;
        oVar.d(f11, 0.0f);
        float f14 = f7 * 2.0f;
        oVar.a(f11 - f7, 0.0f, f11 + f7, f14, 270.0f, degrees);
        oVar.a(f8 - f6, (-f6) - fA, f8 + f6, f6 - fA, 180.0f - f13, (f13 * 2.0f) - 180.0f);
        oVar.a(f12 - f7, 0.0f, f12 + f7, f14, 270.0f - degrees, degrees);
        oVar.d(f2, 0.0f);
    }

    public void c(@FloatRange(from = 0.0d) float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f949d = f2;
    }
}
