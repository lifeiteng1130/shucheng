package c.e.a.b.w;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: CutCornerTreatment.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends d {
    @Override // c.e.a.b.w.d
    public void a(@NonNull o oVar, float f2, float f3, float f4) {
        oVar.f(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double d2 = f4;
        double d3 = f3;
        oVar.d((float) (Math.sin(Math.toRadians(f2)) * d2 * d3), (float) (Math.sin(Math.toRadians(90.0f - f2)) * d2 * d3));
    }
}
