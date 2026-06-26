package g.b;

import f.z.e;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y extends f.z.a implements f.z.e {

    @NotNull
    public static final a Key = new a(null);

    /* JADX INFO: compiled from: CoroutineDispatcher.kt */
    @ExperimentalStdlibApi
    public static final class a extends f.z.b<f.z.e, y> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f.c0.c.f fVar) {
            super(e.a.a, x.INSTANCE);
            int i2 = f.z.e.L;
        }
    }

    public y() {
        super(e.a.a);
    }

    public abstract void dispatch(@NotNull f.z.f fVar, @NotNull Runnable runnable);

    @InternalCoroutinesApi
    public void dispatchYield(@NotNull f.z.f fVar, @NotNull Runnable runnable) {
        dispatch(fVar, runnable);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to g.b.y for r3v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // f.z.a, f.z.f.a, f.z.f
    @org.jetbrains.annotations.Nullable
    public <E extends f.z.f.a> E get(@org.jetbrains.annotations.NotNull f.z.f.b<E> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            f.c0.c.j.e(r4, r0)
            boolean r1 = r4 instanceof f.z.b
            r2 = 0
            if (r1 == 0) goto L33
            f.z.b r4 = (f.z.b) r4
            f.z.f$b r1 = r3.getKey()
            f.c0.c.j.e(r1, r0)
            if (r1 == r4) goto L1c
            f.z.f$b<?> r0 = r4.a
            if (r0 != r1) goto L1a
            goto L1c
        L1a:
            r0 = 0
            goto L1d
        L1c:
            r0 = 1
        L1d:
            if (r0 == 0) goto L38
            java.lang.String r0 = "element"
            f.c0.c.j.e(r3, r0)
            f.c0.b.l<f.z.f$a, E extends B> r4 = r4.f6165b
            java.lang.Object r4 = r4.invoke(r3)
            f.z.f$a r4 = (f.z.f.a) r4
            boolean r0 = r4 instanceof f.z.f.a
            if (r0 != 0) goto L31
            goto L38
        L31:
            r2 = r4
            goto L38
        L33:
            f.z.e$a r0 = f.z.e.a.a
            if (r0 != r4) goto L38
            r2 = r3
        L38:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.y.get(f.z.f$b):f.z.f$a");
    }

    @Override // f.z.e
    @NotNull
    public final <T> f.z.d<T> interceptContinuation(@NotNull f.z.d<? super T> dVar) {
        return new g.b.g2.f(this, dVar);
    }

    public boolean isDispatchNeeded(@NotNull f.z.f fVar) {
        return true;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to g.b.y for r2v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // f.z.a, f.z.f
    @org.jetbrains.annotations.NotNull
    public f.z.f minusKey(@org.jetbrains.annotations.NotNull f.z.f.b<?> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            f.c0.c.j.e(r3, r0)
            boolean r1 = r3 instanceof f.z.b
            if (r1 == 0) goto L32
            f.z.b r3 = (f.z.b) r3
            f.z.f$b r1 = r2.getKey()
            f.c0.c.j.e(r1, r0)
            if (r1 == r3) goto L1b
            f.z.f$b<?> r0 = r3.a
            if (r0 != r1) goto L19
            goto L1b
        L19:
            r0 = 0
            goto L1c
        L1b:
            r0 = 1
        L1c:
            if (r0 == 0) goto L30
            java.lang.String r0 = "element"
            f.c0.c.j.e(r2, r0)
            f.c0.b.l<f.z.f$a, E extends B> r3 = r3.f6165b
            java.lang.Object r3 = r3.invoke(r2)
            f.z.f$a r3 = (f.z.f.a) r3
            if (r3 == 0) goto L30
            f.z.h r3 = f.z.h.INSTANCE
            goto L38
        L30:
            r3 = r2
            goto L38
        L32:
            f.z.e$a r0 = f.z.e.a.a
            if (r0 != r3) goto L30
            f.z.h r3 = f.z.h.INSTANCE
        L38:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.y.minusKey(f.z.f$b):f.z.f");
    }

    @Deprecated(level = f.a.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @NotNull
    public final y plus(@NotNull y yVar) {
        return yVar;
    }

    @Override // f.z.e
    @InternalCoroutinesApi
    public void releaseInterceptedContinuation(@NotNull f.z.d<?> dVar) {
        Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        i<?> iVarL = ((g.b.g2.f) dVar).l();
        if (iVarL != null) {
            iVarL.n();
        }
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '@' + c.b.a.m.f.v2(this);
    }
}
