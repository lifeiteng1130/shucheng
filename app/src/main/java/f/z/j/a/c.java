package f.z.j.a;

import f.c0.c.j;
import f.z.e;
import f.z.f;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
public abstract class c extends a {
    private final f.z.f _context;
    private transient f.z.d<Object> intercepted;

    public c(@Nullable f.z.d<Object> dVar, @Nullable f.z.f fVar) {
        super(dVar);
        this._context = fVar;
    }

    @Override // f.z.j.a.a, f.z.d
    @NotNull
    public f.z.f getContext() {
        f.z.f fVar = this._context;
        j.c(fVar);
        return fVar;
    }

    @NotNull
    public final f.z.d<Object> intercepted() {
        f.z.d<Object> dVarInterceptContinuation = this.intercepted;
        if (dVarInterceptContinuation == null) {
            f.z.f context = getContext();
            int i2 = f.z.e.L;
            f.z.e eVar = (f.z.e) context.get(e.a.a);
            if (eVar == null || (dVarInterceptContinuation = eVar.interceptContinuation(this)) == null) {
                dVarInterceptContinuation = this;
            }
            this.intercepted = dVarInterceptContinuation;
        }
        return dVarInterceptContinuation;
    }

    @Override // f.z.j.a.a
    public void releaseIntercepted() {
        f.z.d<?> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            f.z.f context = getContext();
            int i2 = f.z.e.L;
            f.a aVar = context.get(e.a.a);
            j.c(aVar);
            ((f.z.e) aVar).releaseInterceptedContinuation(dVar);
        }
        this.intercepted = b.a;
    }

    public c(@Nullable f.z.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
