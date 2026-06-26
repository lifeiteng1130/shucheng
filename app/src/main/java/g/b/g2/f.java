package g.b.g2;

import g.b.j0;
import g.b.q0;
import g.b.y;
import g.b.y1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f<T> extends j0<T> implements f.z.j.a.d, f.z.d<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6190d = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    @Nullable
    public Object f6191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Object f6192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public final y f6193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    @NotNull
    public final f.z.d<T> f6194h;

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull y yVar, @NotNull f.z.d<? super T> dVar) {
        super(-1);
        this.f6193g = yVar;
        this.f6194h = dVar;
        this.f6191e = g.a;
        Object objFold = getContext().fold(0, s.f6209b);
        f.c0.c.j.c(objFold);
        this.f6192f = objFold;
        this._reusableCancellableContinuation = null;
    }

    @Override // g.b.j0
    public void c(@Nullable Object obj, @NotNull Throwable th) {
        if (obj instanceof g.b.t) {
            ((g.b.t) obj).f6299b.invoke(th);
        }
    }

    @Override // g.b.j0
    @NotNull
    public f.z.d<T> d() {
        return this;
    }

    @Override // f.z.j.a.d
    @Nullable
    public f.z.j.a.d getCallerFrame() {
        f.z.d<T> dVar = this.f6194h;
        if (!(dVar instanceof f.z.j.a.d)) {
            dVar = null;
        }
        return (f.z.j.a.d) dVar;
    }

    @Override // f.z.d
    @NotNull
    public f.z.f getContext() {
        return this.f6194h.getContext();
    }

    @Override // g.b.j0
    @Nullable
    public Object j() {
        Object obj = this.f6191e;
        this.f6191e = g.a;
        return obj;
    }

    @Nullable
    public final Throwable k(@NotNull g.b.h<?> hVar) {
        q qVar;
        do {
            Object obj = this._reusableCancellableContinuation;
            qVar = g.f6195b;
            if (obj != qVar) {
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Throwable) {
                    if (f6190d.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!f6190d.compareAndSet(this, qVar, hVar));
        return null;
    }

    @Nullable
    public final g.b.i<?> l() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof g.b.i)) {
            obj = null;
        }
        return (g.b.i) obj;
    }

    public final boolean m(@NotNull g.b.i<?> iVar) {
        Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof g.b.i) || obj == iVar;
        }
        return false;
    }

    public final boolean n(@NotNull Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            q qVar = g.f6195b;
            if (f.c0.c.j.a(obj, qVar)) {
                if (f6190d.compareAndSet(this, qVar, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (f6190d.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    @Override // f.z.d
    public void resumeWith(@NotNull Object obj) {
        f.z.f context;
        Object objB;
        f.z.f context2 = this.f6194h.getContext();
        Object objN5 = c.b.a.m.f.N5(obj, null);
        if (this.f6193g.isDispatchNeeded(context2)) {
            this.f6191e = objN5;
            this.f6260c = 0;
            this.f6193g.dispatch(context2, this);
            return;
        }
        y1 y1Var = y1.f6304b;
        q0 q0VarA = y1.a();
        if (q0VarA.r()) {
            this.f6191e = objN5;
            this.f6260c = 0;
            q0VarA.p(this);
            return;
        }
        q0VarA.q(true);
        try {
            context = getContext();
            objB = s.b(context, this.f6192f);
        } finally {
            try {
            } finally {
            }
        }
        try {
            this.f6194h.resumeWith(obj);
            while (q0VarA.t()) {
            }
        } finally {
            s.a(context, objB);
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("DispatchedContinuation[");
        sbR.append(this.f6193g);
        sbR.append(", ");
        sbR.append(c.b.a.m.f.H5(this.f6194h));
        sbR.append(']');
        return sbR.toString();
    }
}
