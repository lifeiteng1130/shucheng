package c.e.a.b.w;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: MarkerEdgeTreatment.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends f {
    public final float a;

    public g(float f2) {
        this.a = f2 - 0.001f;
    }

    @Override // c.e.a.b.w.f
    public void b(float f2, float f3, float f4, @NonNull o oVar) {
        float fSqrt = (float) ((Math.sqrt(2.0d) * ((double) this.a)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.a, 2.0d) - Math.pow(fSqrt, 2.0d));
        oVar.e(f3 - fSqrt, ((float) (-((Math.sqrt(2.0d) * ((double) this.a)) - ((double) this.a)))) + fSqrt2);
        oVar.d(f3, (float) (-((Math.sqrt(2.0d) * ((double) this.a)) - ((double) this.a))));
        oVar.d(f3 + fSqrt, ((float) (-((Math.sqrt(2.0d) * ((double) this.a)) - ((double) this.a)))) + fSqrt2);
    }
}
