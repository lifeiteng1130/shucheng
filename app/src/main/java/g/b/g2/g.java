package g.b.g2;

import g.b.c2;
import g.b.f1;
import g.b.q0;
import g.b.w;
import g.b.y1;
import java.util.concurrent.CancellationException;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final q a = new q("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final q f6195b = new q("REUSABLE_CLAIMED");

    /* JADX WARN: Finally extract failed */
    @InternalCoroutinesApi
    public static final <T> void a(@NotNull f.z.d<? super T> dVar, @NotNull Object obj, @Nullable f.c0.b.l<? super Throwable, f.v> lVar) {
        boolean z;
        if (!(dVar instanceof f)) {
            dVar.resumeWith(obj);
            return;
        }
        f fVar = (f) dVar;
        Object objN5 = c.b.a.m.f.N5(obj, lVar);
        if (fVar.f6193g.isDispatchNeeded(fVar.getContext())) {
            fVar.f6191e = objN5;
            fVar.f6260c = 1;
            fVar.f6193g.dispatch(fVar.getContext(), fVar);
            return;
        }
        y1 y1Var = y1.f6304b;
        q0 q0VarA = y1.a();
        if (q0VarA.r()) {
            fVar.f6191e = objN5;
            fVar.f6260c = 1;
            q0VarA.p(fVar);
            return;
        }
        q0VarA.q(true);
        try {
            f1 f1Var = (f1) fVar.getContext().get(f1.N);
            if (f1Var == null || f1Var.isActive()) {
                z = false;
            } else {
                CancellationException cancellationExceptionD = f1Var.d();
                if (objN5 instanceof g.b.t) {
                    ((g.b.t) objN5).f6299b.invoke(cancellationExceptionD);
                }
                fVar.resumeWith(f.h.m11constructorimpl(c.b.a.m.f.m1(cancellationExceptionD)));
                z = true;
            }
            if (!z) {
                f.z.d<T> dVar2 = fVar.f6194h;
                Object obj2 = fVar.f6192f;
                f.z.f context = dVar2.getContext();
                Object objB = s.b(context, obj2);
                c2<?> c2VarB = objB != s.a ? w.b(dVar2, context, objB) : null;
                try {
                    fVar.f6194h.resumeWith(obj);
                    if (c2VarB == null || c2VarB.W()) {
                        s.a(context, objB);
                    }
                } catch (Throwable th) {
                    if (c2VarB == null || c2VarB.W()) {
                        s.a(context, objB);
                    }
                    throw th;
                }
            }
            while (q0VarA.t()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void b(f.z.d dVar, Object obj, f.c0.b.l lVar, int i2) {
        int i3 = i2 & 2;
        a(dVar, obj, null);
    }
}
