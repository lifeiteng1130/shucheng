package g.b;

import f.z.f;
import g.b.g2.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(level = f.a.ERROR, message = "This is internal API and may be removed in the future releases")
public class k1 implements f1, n, s1 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(k1.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: compiled from: JobSupport.kt */
    public static final class a<T> extends i<T> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final k1 f6265h;

        public a(@NotNull f.z.d<? super T> dVar, @NotNull k1 k1Var) {
            super(dVar, 1);
            this.f6265h = k1Var;
        }

        @Override // g.b.i
        @NotNull
        public Throwable q(@NotNull f1 f1Var) {
            Throwable thD;
            Object objB = this.f6265h.B();
            return (!(objB instanceof c) || (thD = ((c) objB).d()) == null) ? objB instanceof s ? ((s) objB).f6298b : ((k1) f1Var).d() : thD;
        }

        @Override // g.b.i
        @NotNull
        public String u() {
            return "AwaitContinuation";
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    public static final class b extends j1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final k1 f6266e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c f6267f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final m f6268g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Object f6269h;

        public b(@NotNull k1 k1Var, @NotNull c cVar, @NotNull m mVar, @Nullable Object obj) {
            this.f6266e = k1Var;
            this.f6267f = cVar;
            this.f6268g = mVar;
            this.f6269h = obj;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(Throwable th) {
            k(th);
            return f.v.a;
        }

        @Override // g.b.u
        public void k(@Nullable Throwable th) {
            k1 k1Var = this.f6266e;
            c cVar = this.f6267f;
            m mVar = this.f6268g;
            Object obj = this.f6269h;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k1.a;
            m mVarJ = k1Var.J(mVar);
            if (mVarJ == null || !k1Var.S(cVar, mVarJ, obj)) {
                k1Var.o(k1Var.v(cVar, obj));
            }
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    public static final class c implements a1 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        @NotNull
        public final p1 a;

        public c(@NotNull p1 p1Var, boolean z, @Nullable Throwable th) {
            this.a = p1Var;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        @Override // g.b.a1
        @NotNull
        public p1 a() {
            return this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(@NotNull Throwable th) {
            Throwable th2 = (Throwable) this._rootCause;
            if (th2 == null) {
                this._rootCause = th;
                return;
            }
            if (th == th2) {
                return;
            }
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                this._exceptionsHolder = th;
                return;
            }
            if (obj instanceof Throwable) {
                if (th == obj) {
                    return;
                }
                ArrayList<Throwable> arrayListC = c();
                arrayListC.add(obj);
                arrayListC.add(th);
                this._exceptionsHolder = arrayListC;
                return;
            }
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + obj).toString());
        }

        public final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        @Nullable
        public final Throwable d() {
            return (Throwable) this._rootCause;
        }

        public final boolean e() {
            return ((Throwable) this._rootCause) != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean f() {
            return this._isCompleting;
        }

        public final boolean g() {
            return this._exceptionsHolder == l1.f6275e;
        }

        @NotNull
        public final List<Throwable> h(@Nullable Throwable th) {
            ArrayList arrayListC;
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                arrayListC = c();
            } else if (obj instanceof Throwable) {
                ArrayList arrayListC2 = c();
                arrayListC2.add(obj);
                arrayListC = arrayListC2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                arrayListC = (ArrayList) obj;
            }
            Throwable th2 = (Throwable) this._rootCause;
            if (th2 != null) {
                arrayListC.add(0, th2);
            }
            if (th != null && (!f.c0.c.j.a(th, th2))) {
                arrayListC.add(th);
            }
            this._exceptionsHolder = l1.f6275e;
            return arrayListC;
        }

        public final void i(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        @Override // g.b.a1
        public boolean isActive() {
            return ((Throwable) this._rootCause) == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
        @NotNull
        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("Finishing[cancelling=");
            sbR.append(e());
            sbR.append(", completing=");
            sbR.append((boolean) this._isCompleting);
            sbR.append(", rootCause=");
            sbR.append((Throwable) this._rootCause);
            sbR.append(", exceptions=");
            sbR.append(this._exceptionsHolder);
            sbR.append(", list=");
            sbR.append(this.a);
            sbR.append(']');
            return sbR.toString();
        }
    }

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class d extends j.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ k1 f6270d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f6271e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g.b.g2.j jVar, g.b.g2.j jVar2, k1 k1Var, Object obj) {
            super(jVar2);
            this.f6270d = k1Var;
            this.f6271e = obj;
        }

        @Override // g.b.g2.c
        public Object c(g.b.g2.j jVar) {
            if (this.f6270d.B() == this.f6271e) {
                return null;
            }
            return g.b.g2.i.a;
        }
    }

    public k1(boolean z) {
        this._state = z ? l1.f6277g : l1.f6276f;
        this._parentHandle = null;
    }

    @Nullable
    public final l A() {
        return (l) this._parentHandle;
    }

    @Nullable
    public final Object B() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof g.b.g2.n)) {
                return obj;
            }
            ((g.b.g2.n) obj).a(this);
        }
    }

    public boolean C(@NotNull Throwable th) {
        return false;
    }

    public void D(@NotNull Throwable th) throws Throwable {
        throw th;
    }

    public final void E(@Nullable f1 f1Var) {
        if (f1Var == null) {
            this._parentHandle = q1.a;
            return;
        }
        f1Var.start();
        l lVarM = f1Var.m(this);
        this._parentHandle = lVarM;
        if (!(B() instanceof a1)) {
            lVarM.e();
            this._parentHandle = q1.a;
        }
    }

    @NotNull
    public final m0 F(@NotNull f.c0.b.l<? super Throwable, f.v> lVar) {
        return c(false, true, lVar);
    }

    public boolean G() {
        return this instanceof g.b.c;
    }

    @Nullable
    public final Object H(@Nullable Object obj) throws Throwable {
        Object objR;
        do {
            objR = R(B(), obj);
            if (objR == l1.a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                if (!(obj instanceof s)) {
                    obj = null;
                }
                s sVar = (s) obj;
                throw new IllegalStateException(str, sVar != null ? sVar.f6298b : null);
            }
        } while (objR == l1.f6273c);
        return objR;
    }

    @NotNull
    public String I() {
        return getClass().getSimpleName();
    }

    public final m J(g.b.g2.j jVar) {
        while (jVar.i()) {
            jVar = jVar.h();
        }
        while (true) {
            jVar = jVar.g();
            if (!jVar.i()) {
                if (jVar instanceof m) {
                    return (m) jVar;
                }
                if (jVar instanceof p1) {
                    return null;
                }
            }
        }
    }

    public final void K(p1 p1Var, Throwable th) throws Throwable {
        v vVar = null;
        Object objF = p1Var.f();
        Objects.requireNonNull(objF, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        for (g.b.g2.j jVarG = (g.b.g2.j) objF; !f.c0.c.j.a(jVarG, p1Var); jVarG = jVarG.g()) {
            if (jVarG instanceof h1) {
                j1 j1Var = (j1) jVarG;
                try {
                    j1Var.k(th);
                } catch (Throwable th2) {
                    if (vVar != null) {
                        c.b.a.m.f.V(vVar, th2);
                    } else {
                        vVar = new v("Exception in completion handler " + j1Var + " for " + this, th2);
                    }
                }
            }
        }
        if (vVar != null) {
            D(vVar);
        }
        q(th);
    }

    public void L(@Nullable Object obj) {
    }

    public void M() {
    }

    public final void N(j1 j1Var) {
        p1 p1Var = new p1();
        g.b.g2.j.f6196b.lazySet(p1Var, j1Var);
        g.b.g2.j.a.lazySet(p1Var, j1Var);
        while (true) {
            if (j1Var.f() != j1Var) {
                break;
            } else if (g.b.g2.j.a.compareAndSet(j1Var, j1Var, p1Var)) {
                p1Var.d(j1Var);
                break;
            }
        }
        a.compareAndSet(this, j1Var, j1Var.g());
    }

    public final int O(Object obj) {
        if (obj instanceof p0) {
            if (((p0) obj).a) {
                return 0;
            }
            if (!a.compareAndSet(this, obj, l1.f6277g)) {
                return -1;
            }
            M();
            return 1;
        }
        if (!(obj instanceof z0)) {
            return 0;
        }
        if (!a.compareAndSet(this, obj, ((z0) obj).a)) {
            return -1;
        }
        M();
        return 1;
    }

    public final String P(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof a1 ? ((a1) obj).isActive() ? "Active" : "New" : obj instanceof s ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.e() ? "Cancelling" : cVar.f() ? "Completing" : "Active";
    }

    @NotNull
    public final CancellationException Q(@NotNull Throwable th, @Nullable String str) {
        CancellationException g1Var = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (g1Var == null) {
            if (str == null) {
                str = r();
            }
            g1Var = new g1(str, th, this);
        }
        return g1Var;
    }

    public final Object R(Object obj, Object obj2) throws Throwable {
        if (!(obj instanceof a1)) {
            return l1.a;
        }
        boolean z = true;
        if (((obj instanceof p0) || (obj instanceof j1)) && !(obj instanceof m) && !(obj2 instanceof s)) {
            a1 a1Var = (a1) obj;
            if (a.compareAndSet(this, a1Var, obj2 instanceof a1 ? new b1((a1) obj2) : obj2)) {
                L(obj2);
                t(a1Var, obj2);
            } else {
                z = false;
            }
            return z ? obj2 : l1.f6273c;
        }
        a1 a1Var2 = (a1) obj;
        p1 p1VarZ = z(a1Var2);
        if (p1VarZ == null) {
            return l1.f6273c;
        }
        m mVarJ = null;
        c cVar = (c) (!(a1Var2 instanceof c) ? null : a1Var2);
        if (cVar == null) {
            cVar = new c(p1VarZ, false, null);
        }
        synchronized (cVar) {
            if (cVar.f()) {
                return l1.a;
            }
            cVar.i(true);
            if (cVar != a1Var2 && !a.compareAndSet(this, a1Var2, cVar)) {
                return l1.f6273c;
            }
            boolean zE = cVar.e();
            s sVar = (s) (!(obj2 instanceof s) ? null : obj2);
            if (sVar != null) {
                cVar.b(sVar.f6298b);
            }
            Throwable thD = cVar.d();
            if (!(true ^ zE)) {
                thD = null;
            }
            if (thD != null) {
                K(p1VarZ, thD);
            }
            m mVar = (m) (!(a1Var2 instanceof m) ? null : a1Var2);
            if (mVar != null) {
                mVarJ = mVar;
            } else {
                p1 p1VarA = a1Var2.a();
                if (p1VarA != null) {
                    mVarJ = J(p1VarA);
                }
            }
            return (mVarJ == null || !S(cVar, mVarJ, obj2)) ? v(cVar, obj2) : l1.f6272b;
        }
    }

    public final boolean S(c cVar, m mVar, Object obj) {
        while (c.b.a.m.f.m3(mVar.f6278e, false, false, new b(this, cVar, mVar, obj), 1, null) == q1.a) {
            mVar = J(mVar);
            if (mVar == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00a2 A[SYNTHETIC] */
    @Override // g.b.f1
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final g.b.m0 c(boolean r8, boolean r9, @org.jetbrains.annotations.NotNull f.c0.b.l<? super java.lang.Throwable, f.v> r10) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L15
            boolean r1 = r10 instanceof g.b.h1
            if (r1 != 0) goto L9
            r1 = r0
            goto La
        L9:
            r1 = r10
        La:
            g.b.h1 r1 = (g.b.h1) r1
            if (r1 == 0) goto Lf
            goto L26
        Lf:
            g.b.d1 r1 = new g.b.d1
            r1.<init>(r10)
            goto L26
        L15:
            boolean r1 = r10 instanceof g.b.j1
            if (r1 != 0) goto L1b
            r1 = r0
            goto L1c
        L1b:
            r1 = r10
        L1c:
            g.b.j1 r1 = (g.b.j1) r1
            if (r1 == 0) goto L21
            goto L26
        L21:
            g.b.e1 r1 = new g.b.e1
            r1.<init>(r10)
        L26:
            r1.f6261d = r7
        L28:
            java.lang.Object r2 = r7.B()
            boolean r3 = r2 instanceof g.b.p0
            if (r3 == 0) goto L56
            r3 = r2
            g.b.p0 r3 = (g.b.p0) r3
            boolean r4 = r3.a
            if (r4 == 0) goto L40
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = g.b.k1.a
            boolean r2 = r3.compareAndSet(r7, r2, r1)
            if (r2 == 0) goto L28
            return r1
        L40:
            g.b.p1 r2 = new g.b.p1
            r2.<init>()
            boolean r4 = r3.a
            if (r4 == 0) goto L4a
            goto L50
        L4a:
            g.b.z0 r4 = new g.b.z0
            r4.<init>(r2)
            r2 = r4
        L50:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = g.b.k1.a
            r4.compareAndSet(r7, r3, r2)
            goto L28
        L56:
            boolean r3 = r2 instanceof g.b.a1
            if (r3 == 0) goto Laf
            r3 = r2
            g.b.a1 r3 = (g.b.a1) r3
            g.b.p1 r3 = r3.a()
            if (r3 != 0) goto L6e
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.JobNode"
            java.util.Objects.requireNonNull(r2, r3)
            g.b.j1 r2 = (g.b.j1) r2
            r7.N(r2)
            goto L28
        L6e:
            g.b.q1 r4 = g.b.q1.a
            if (r8 == 0) goto L9f
            boolean r5 = r2 instanceof g.b.k1.c
            if (r5 == 0) goto L9f
            monitor-enter(r2)
            r5 = r2
            g.b.k1$c r5 = (g.b.k1.c) r5     // Catch: java.lang.Throwable -> L9c
            java.lang.Throwable r5 = r5.d()     // Catch: java.lang.Throwable -> L9c
            if (r5 == 0) goto L8d
            boolean r6 = r10 instanceof g.b.m     // Catch: java.lang.Throwable -> L9c
            if (r6 == 0) goto L9a
            r6 = r2
            g.b.k1$c r6 = (g.b.k1.c) r6     // Catch: java.lang.Throwable -> L9c
            boolean r6 = r6.f()     // Catch: java.lang.Throwable -> L9c
            if (r6 != 0) goto L9a
        L8d:
            boolean r4 = r7.n(r2, r3, r1)     // Catch: java.lang.Throwable -> L9c
            if (r4 != 0) goto L95
            monitor-exit(r2)
            goto L28
        L95:
            if (r5 != 0) goto L99
            monitor-exit(r2)
            return r1
        L99:
            r4 = r1
        L9a:
            monitor-exit(r2)
            goto La0
        L9c:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L9f:
            r5 = r0
        La0:
            if (r5 == 0) goto La8
            if (r9 == 0) goto La7
            r10.invoke(r5)
        La7:
            return r4
        La8:
            boolean r2 = r7.n(r2, r3, r1)
            if (r2 == 0) goto L28
            return r1
        Laf:
            if (r9 == 0) goto Lbf
            boolean r8 = r2 instanceof g.b.s
            if (r8 != 0) goto Lb6
            r2 = r0
        Lb6:
            g.b.s r2 = (g.b.s) r2
            if (r2 == 0) goto Lbc
            java.lang.Throwable r0 = r2.f6298b
        Lbc:
            r10.invoke(r0)
        Lbf:
            g.b.q1 r8 = g.b.q1.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.k1.c(boolean, boolean, f.c0.b.l):g.b.m0");
    }

    @Override // g.b.f1
    @NotNull
    public final CancellationException d() {
        Object objB = B();
        if (objB instanceof c) {
            Throwable thD = ((c) objB).d();
            if (thD != null) {
                return Q(thD, getClass().getSimpleName() + " is cancelling");
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objB instanceof a1) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objB instanceof s) {
            return Q(((s) objB).f6298b, null);
        }
        return new g1(getClass().getSimpleName() + " has completed normally", null, this);
    }

    @Override // g.b.n
    public final void f(@NotNull s1 s1Var) throws Throwable {
        p(s1Var);
    }

    @Override // f.z.f
    public <R> R fold(R r, @NotNull f.c0.b.p<? super R, ? super f.a, ? extends R> pVar) {
        return (R) f.a.C0182a.a(this, r, pVar);
    }

    @Override // f.z.f.a, f.z.f
    @Nullable
    public <E extends f.a> E get(@NotNull f.b<E> bVar) {
        return (E) f.a.C0182a.b(this, bVar);
    }

    @Override // f.z.f.a
    @NotNull
    public final f.b<?> getKey() {
        return f1.N;
    }

    @Override // g.b.f1
    public boolean isActive() {
        Object objB = B();
        return (objB instanceof a1) && ((a1) objB).isActive();
    }

    @Override // g.b.s1
    @NotNull
    public CancellationException j() {
        Throwable thD;
        Object objB = B();
        if (objB instanceof c) {
            thD = ((c) objB).d();
        } else if (objB instanceof s) {
            thD = ((s) objB).f6298b;
        } else {
            if (objB instanceof a1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objB).toString());
            }
            thD = null;
        }
        CancellationException cancellationException = (CancellationException) (thD instanceof CancellationException ? thD : null);
        if (cancellationException != null) {
            return cancellationException;
        }
        StringBuilder sbR = c.a.a.a.a.r("Parent job is ");
        sbR.append(P(objB));
        return new g1(sbR.toString(), thD, this);
    }

    @Override // g.b.f1
    public void k(@Nullable CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new g1(r(), null, this);
        }
        p(cancellationException);
    }

    @Override // g.b.f1
    @NotNull
    public final l m(@NotNull n nVar) {
        m0 m0VarM3 = c.b.a.m.f.m3(this, true, false, new m(nVar), 2, null);
        Objects.requireNonNull(m0VarM3, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (l) m0VarM3;
    }

    @Override // f.z.f
    @NotNull
    public f.z.f minusKey(@NotNull f.b<?> bVar) {
        return f.a.C0182a.c(this, bVar);
    }

    public final boolean n(Object obj, p1 p1Var, j1 j1Var) {
        char c2;
        d dVar = new d(j1Var, j1Var, this, obj);
        do {
            g.b.g2.j jVarH = p1Var.h();
            g.b.g2.j.f6196b.lazySet(j1Var, jVarH);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g.b.g2.j.a;
            atomicReferenceFieldUpdater.lazySet(j1Var, p1Var);
            dVar.f6198b = p1Var;
            c2 = !atomicReferenceFieldUpdater.compareAndSet(jVarH, p1Var, dVar) ? (char) 0 : dVar.a(jVarH) == null ? (char) 1 : (char) 2;
            if (c2 == 1) {
                return true;
            }
        } while (c2 != 2);
        return false;
    }

    public void o(@Nullable Object obj) {
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(@org.jetbrains.annotations.Nullable java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.k1.p(java.lang.Object):boolean");
    }

    @Override // f.z.f
    @NotNull
    public f.z.f plus(@NotNull f.z.f fVar) {
        return f.a.C0182a.d(this, fVar);
    }

    public final boolean q(Throwable th) {
        if (G()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        l lVar = (l) this._parentHandle;
        return (lVar == null || lVar == q1.a) ? z : lVar.b(th) || z;
    }

    @NotNull
    public String r() {
        return "Job was cancelled";
    }

    public boolean s(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return p(th) && x();
    }

    @Override // g.b.f1
    public final boolean start() {
        int iO;
        do {
            iO = O(B());
            if (iO == 0) {
                return false;
            }
        } while (iO != 1);
        return true;
    }

    public final void t(a1 a1Var, Object obj) throws Throwable {
        l lVar = (l) this._parentHandle;
        if (lVar != null) {
            lVar.e();
            this._parentHandle = q1.a;
        }
        v vVar = null;
        if (!(obj instanceof s)) {
            obj = null;
        }
        s sVar = (s) obj;
        Throwable th = sVar != null ? sVar.f6298b : null;
        if (a1Var instanceof j1) {
            try {
                ((j1) a1Var).k(th);
                return;
            } catch (Throwable th2) {
                D(new v("Exception in completion handler " + a1Var + " for " + this, th2));
                return;
            }
        }
        p1 p1VarA = a1Var.a();
        if (p1VarA != null) {
            Object objF = p1VarA.f();
            Objects.requireNonNull(objF, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            for (g.b.g2.j jVarG = (g.b.g2.j) objF; !f.c0.c.j.a(jVarG, p1VarA); jVarG = jVarG.g()) {
                if (jVarG instanceof j1) {
                    j1 j1Var = (j1) jVarG;
                    try {
                        j1Var.k(th);
                    } catch (Throwable th3) {
                        if (vVar != null) {
                            c.b.a.m.f.V(vVar, th3);
                        } else {
                            vVar = new v("Exception in completion handler " + j1Var + " for " + this, th3);
                        }
                    }
                }
            }
            if (vVar != null) {
                D(vVar);
            }
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(I() + MessageFormatter.DELIM_START + P(B()) + MessageFormatter.DELIM_STOP);
        sb.append('@');
        sb.append(c.b.a.m.f.v2(this));
        return sb.toString();
    }

    public final Throwable u(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : new g1(r(), null, this);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((s1) obj).j();
    }

    public final Object v(c cVar, Object obj) throws Throwable {
        Throwable thW;
        s sVar = (s) (!(obj instanceof s) ? null : obj);
        Throwable th = sVar != null ? sVar.f6298b : null;
        synchronized (cVar) {
            cVar.e();
            List<Throwable> listH = cVar.h(th);
            thW = w(cVar, listH);
            if (thW != null && listH.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(listH.size()));
                for (Throwable th2 : listH) {
                    if (th2 != thW && th2 != thW && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        c.b.a.m.f.V(thW, th2);
                    }
                }
            }
        }
        if (thW != null && thW != th) {
            obj = new s(thW, false, 2);
        }
        if (thW != null) {
            if (q(thW) || C(thW)) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                s.a.compareAndSet((s) obj, 0, 1);
            }
        }
        L(obj);
        a.compareAndSet(this, cVar, obj instanceof a1 ? new b1((a1) obj) : obj);
        t(cVar, obj);
        return obj;
    }

    public final Throwable w(c cVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.e()) {
                return new g1(r(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof z1) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof z1)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean x() {
        return true;
    }

    public boolean y() {
        return false;
    }

    public final p1 z(a1 a1Var) {
        p1 p1VarA = a1Var.a();
        if (p1VarA != null) {
            return p1VarA;
        }
        if (a1Var instanceof p0) {
            return new p1();
        }
        if (a1Var instanceof j1) {
            N((j1) a1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + a1Var).toString());
    }
}
