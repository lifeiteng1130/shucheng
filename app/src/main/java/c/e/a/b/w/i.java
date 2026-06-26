package c.e.a.b.w;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: OffsetEdgeTreatment.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends f {
    public final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1226b;

    public i(@NonNull f fVar, float f2) {
        this.a = fVar;
        this.f1226b = f2;
    }

    @Override // c.e.a.b.w.f
    public boolean a() {
        return this.a.a();
    }

    @Override // c.e.a.b.w.f
    public void b(float f2, float f3, float f4, @NonNull o oVar) {
        this.a.b(f2, f3 - this.f1226b, f4, oVar);
    }
}
