package g.b;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c2<T> extends g.b.g2.p<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f.z.f f6175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f6176f;

    /* JADX WARN: Illegal instructions before constructor call */
    public c2(@NotNull f.z.f fVar, @NotNull f.z.d<? super T> dVar) {
        d2 d2Var = d2.a;
        super(fVar.get(d2Var) == null ? fVar.plus(d2Var) : fVar, dVar);
    }

    @Override // g.b.g2.p, g.b.a
    public void T(@Nullable Object obj) {
        f.z.f fVar = this.f6175e;
        if (fVar != null) {
            g.b.g2.s.a(fVar, this.f6176f);
            this.f6175e = null;
            this.f6176f = null;
        }
        Object objF4 = c.b.a.m.f.F4(obj, this.f6208d);
        f.z.d<T> dVar = this.f6208d;
        f.z.f context = dVar.getContext();
        Object objB = g.b.g2.s.b(context, null);
        c2<?> c2VarB = objB != g.b.g2.s.a ? w.b(dVar, context, objB) : null;
        try {
            this.f6208d.resumeWith(objF4);
        } finally {
            if (c2VarB == null || c2VarB.W()) {
                g.b.g2.s.a(context, objB);
            }
        }
    }

    public final boolean W() {
        if (this.f6175e == null) {
            return false;
        }
        this.f6175e = null;
        this.f6176f = null;
        return true;
    }
}
