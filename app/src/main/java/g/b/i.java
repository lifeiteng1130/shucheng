package g.b;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
public class i<T> extends j0<T> implements h<T>, f.z.j.a.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6253d = AtomicIntegerFieldUpdater.newUpdater(i.class, "_decision");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6254e = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final f.z.f f6255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final f.z.d<T> f6256g;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull f.z.d<? super T> dVar, int i2) {
        super(i2);
        this.f6256g = dVar;
        this.f6255f = dVar.getContext();
        this._decision = 0;
        this._state = b.a;
        this._parentHandle = null;
    }

    public static void v(i iVar, Object obj, int i2, f.c0.b.l lVar, int i3, Object obj2) {
        Object obj3;
        Object rVar;
        int i4 = i3 & 4;
        do {
            obj3 = iVar._state;
            if (!(obj3 instanceof r1)) {
                if (obj3 instanceof j) {
                    j jVar = (j) obj3;
                    Objects.requireNonNull(jVar);
                    if (j.f6259c.compareAndSet(jVar, 0, 1)) {
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
            r1 r1Var = (r1) obj3;
            if (!(obj instanceof s) && c.b.a.m.f.r3(i2) && (r1Var instanceof f)) {
                if (!(r1Var instanceof f)) {
                    r1Var = null;
                }
                rVar = new r(obj, (f) r1Var, null, null, null, 16);
            } else {
                rVar = obj;
            }
        } while (!f6254e.compareAndSet(iVar, obj3, rVar));
        iVar.o();
        iVar.p(i2);
    }

    @Override // g.b.h
    public void a(@NotNull f.c0.b.l<? super Throwable, f.v> lVar) {
        f c1Var = lVar instanceof f ? (f) lVar : new c1(lVar);
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof b)) {
                if (obj instanceof f) {
                    t(lVar, obj);
                    throw null;
                }
                boolean z = obj instanceof s;
                if (z) {
                    s sVar = (s) obj;
                    Objects.requireNonNull(sVar);
                    if (!s.a.compareAndSet(sVar, 0, 1)) {
                        t(lVar, obj);
                        throw null;
                    }
                    if (obj instanceof j) {
                        if (!z) {
                            obj = null;
                        }
                        s sVar2 = (s) obj;
                        k(lVar, sVar2 != null ? sVar2.f6298b : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (rVar.f6286b != null) {
                        t(lVar, obj);
                        throw null;
                    }
                    Throwable th = rVar.f6289e;
                    if (th != null) {
                        k(lVar, th);
                        return;
                    } else {
                        if (f6254e.compareAndSet(this, obj, r.a(rVar, null, c1Var, null, null, null, 29))) {
                            return;
                        }
                    }
                } else {
                    if (f6254e.compareAndSet(this, obj, new r(obj, c1Var, null, null, null, 28))) {
                        return;
                    }
                }
            } else if (f6254e.compareAndSet(this, obj, c1Var)) {
                return;
            }
        }
    }

    @Override // g.b.h
    public void b(@NotNull y yVar, T t) {
        f.z.d<T> dVar = this.f6256g;
        if (!(dVar instanceof g.b.g2.f)) {
            dVar = null;
        }
        g.b.g2.f fVar = (g.b.g2.f) dVar;
        v(this, t, (fVar != null ? fVar.f6193g : null) == yVar ? 4 : this.f6260c, null, 4, null);
    }

    @Override // g.b.j0
    public void c(@Nullable Object obj, @NotNull Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof r1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof s) {
                return;
            }
            if (obj2 instanceof r) {
                r rVar = (r) obj2;
                if (!(!(rVar.f6289e != null))) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (f6254e.compareAndSet(this, obj2, r.a(rVar, null, null, null, null, th, 15))) {
                    f fVar = rVar.f6286b;
                    if (fVar != null) {
                        l(fVar, th);
                    }
                    f.c0.b.l<Throwable, f.v> lVar = rVar.f6287c;
                    if (lVar != null) {
                        m(lVar, th);
                        return;
                    }
                    return;
                }
            } else if (f6254e.compareAndSet(this, obj2, new r(obj2, null, null, null, th, 14))) {
                return;
            }
        }
    }

    @Override // g.b.j0
    @NotNull
    public final f.z.d<T> d() {
        return this.f6256g;
    }

    @Override // g.b.j0
    @Nullable
    public Throwable e(@Nullable Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.b.j0
    public <T> T f(@Nullable Object obj) {
        return obj instanceof r ? (T) ((r) obj).a : obj;
    }

    @Override // g.b.h
    public boolean g(@Nullable Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof r1)) {
                return false;
            }
            z = obj instanceof f;
        } while (!f6254e.compareAndSet(this, obj, new j(this, th, z)));
        if (!z) {
            obj = null;
        }
        f fVar = (f) obj;
        if (fVar != null) {
            l(fVar, th);
        }
        o();
        p(this.f6260c);
        return true;
    }

    @Override // f.z.j.a.d
    @Nullable
    public f.z.j.a.d getCallerFrame() {
        f.z.d<T> dVar = this.f6256g;
        if (!(dVar instanceof f.z.j.a.d)) {
            dVar = null;
        }
        return (f.z.j.a.d) dVar;
    }

    @Override // f.z.d
    @NotNull
    public f.z.f getContext() {
        return this.f6255f;
    }

    @Override // g.b.h
    public boolean h() {
        return !(this._state instanceof r1);
    }

    @Override // g.b.j0
    @Nullable
    public Object j() {
        return this._state;
    }

    public final void k(f.c0.b.l<? super Throwable, f.v> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            c.b.a.m.f.f3(this.f6255f, new v("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void l(@NotNull f fVar, @Nullable Throwable th) {
        try {
            fVar.a(th);
        } catch (Throwable th2) {
            c.b.a.m.f.f3(this.f6255f, new v("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void m(@NotNull f.c0.b.l<? super Throwable, f.v> lVar, @NotNull Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            c.b.a.m.f.f3(this.f6255f, new v("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void n() {
        m0 m0Var = (m0) this._parentHandle;
        if (m0Var != null) {
            m0Var.e();
        }
        this._parentHandle = q1.a;
    }

    public final void o() {
        if (s()) {
            return;
        }
        m0 m0Var = (m0) this._parentHandle;
        if (m0Var != null) {
            m0Var.e();
        }
        this._parentHandle = q1.a;
    }

    /* JADX WARN: Finally extract failed */
    public final void p(int i2) {
        boolean z;
        while (true) {
            int i3 = this._decision;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("Already resumed".toString());
                }
                z = false;
            } else if (f6253d.compareAndSet(this, 0, 2)) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        f.z.d<T> dVarD = d();
        boolean z2 = i2 == 4;
        if (z2 || !(dVarD instanceof g.b.g2.f) || c.b.a.m.f.r3(i2) != c.b.a.m.f.r3(this.f6260c)) {
            c.b.a.m.f.O4(this, dVarD, z2);
            return;
        }
        y yVar = ((g.b.g2.f) dVarD).f6193g;
        f.z.f context = dVarD.getContext();
        if (yVar.isDispatchNeeded(context)) {
            yVar.dispatch(context, this);
            return;
        }
        y1 y1Var = y1.f6304b;
        q0 q0VarA = y1.a();
        if (q0VarA.r()) {
            q0VarA.p(this);
            return;
        }
        q0VarA.q(true);
        try {
            c.b.a.m.f.O4(this, d(), true);
            do {
            } while (q0VarA.t());
        } catch (Throwable th) {
            try {
                i(th, null);
            } finally {
                q0VarA.n(true);
            }
        }
    }

    @NotNull
    public Throwable q(@NotNull f1 f1Var) {
        return ((k1) f1Var).d();
    }

    @PublishedApi
    @Nullable
    public final Object r() {
        boolean z;
        f1 f1Var;
        w();
        while (true) {
            int i2 = this._decision;
            z = false;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new IllegalStateException("Already suspended".toString());
                }
            } else if (f6253d.compareAndSet(this, 0, 1)) {
                z = true;
                break;
            }
        }
        if (z) {
            return f.z.i.a.COROUTINE_SUSPENDED;
        }
        Object obj = this._state;
        if (obj instanceof s) {
            throw ((s) obj).f6298b;
        }
        if (!c.b.a.m.f.r3(this.f6260c) || (f1Var = (f1) this.f6255f.get(f1.N)) == null || f1Var.isActive()) {
            return f(obj);
        }
        CancellationException cancellationExceptionD = f1Var.d();
        c(obj, cancellationExceptionD);
        throw cancellationExceptionD;
    }

    @Override // f.z.d
    public void resumeWith(@NotNull Object obj) {
        Throwable thM14exceptionOrNullimpl = f.h.m14exceptionOrNullimpl(obj);
        if (thM14exceptionOrNullimpl != null) {
            obj = new s(thM14exceptionOrNullimpl, false, 2);
        }
        v(this, obj, this.f6260c, null, 4, null);
    }

    public final boolean s() {
        f.z.d<T> dVar = this.f6256g;
        return (dVar instanceof g.b.g2.f) && ((g.b.g2.f) dVar).m(this);
    }

    public final void t(f.c0.b.l<? super Throwable, f.v> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(u());
        sb.append('(');
        sb.append(c.b.a.m.f.H5(this.f6256g));
        sb.append("){");
        Object obj = this._state;
        sb.append(obj instanceof r1 ? "Active" : obj instanceof j ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(c.b.a.m.f.v2(this));
        return sb.toString();
    }

    @NotNull
    public String u() {
        return "CancellableContinuation";
    }

    public final void w() {
        f1 f1Var;
        Throwable thK;
        boolean zH = h();
        if (this.f6260c == 2) {
            f.z.d<T> dVar = this.f6256g;
            if (!(dVar instanceof g.b.g2.f)) {
                dVar = null;
            }
            g.b.g2.f fVar = (g.b.g2.f) dVar;
            if (fVar != null && (thK = fVar.k(this)) != null) {
                if (!zH) {
                    g(thK);
                }
                zH = true;
            }
        }
        if (zH || ((m0) this._parentHandle) != null || (f1Var = (f1) this.f6256g.getContext().get(f1.N)) == null) {
            return;
        }
        m0 m0VarM3 = c.b.a.m.f.m3(f1Var, true, false, new k(this), 2, null);
        this._parentHandle = m0VarM3;
        if (!h() || s()) {
            return;
        }
        m0VarM3.e();
        this._parentHandle = q1.a;
    }
}
