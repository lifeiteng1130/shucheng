package g.b;

import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoroutineStart.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum b0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    @InternalCoroutinesApi
    public static /* synthetic */ void isLazy$annotations() {
    }

    @InternalCoroutinesApi
    public final <T> void invoke(@NotNull f.c0.b.l<? super f.z.d<? super T>, ? extends Object> lVar, @NotNull f.z.d<? super T> dVar) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            try {
                g.b.g2.g.b(c.b.a.m.f.j3(c.b.a.m.f.k1(lVar, dVar)), f.h.m11constructorimpl(f.v.a), null, 2);
                return;
            } catch (Throwable th) {
                dVar.resumeWith(f.h.m11constructorimpl(c.b.a.m.f.m1(th)));
                return;
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                f.c0.c.j.e(lVar, "$this$startCoroutine");
                f.c0.c.j.e(dVar, "completion");
                c.b.a.m.f.j3(c.b.a.m.f.k1(lVar, dVar)).resumeWith(f.h.m11constructorimpl(f.v.a));
                return;
            }
            if (iOrdinal != 3) {
                throw new f.f();
            }
            f.c0.c.j.e(dVar, "completion");
            try {
                f.z.f context = dVar.getContext();
                Object objB = g.b.g2.s.b(context, null);
                try {
                    if (lVar == null) {
                        throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    }
                    f.c0.c.y.d(lVar, 1);
                    Object objInvoke = lVar.invoke(dVar);
                    if (objInvoke != f.z.i.a.COROUTINE_SUSPENDED) {
                        dVar.resumeWith(f.h.m11constructorimpl(objInvoke));
                    }
                } finally {
                    g.b.g2.s.a(context, objB);
                }
            } catch (Throwable th2) {
                dVar.resumeWith(f.h.m11constructorimpl(c.b.a.m.f.m1(th2)));
            }
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InternalCoroutinesApi
    public final <R, T> void invoke(@NotNull f.c0.b.p<? super R, ? super f.z.d<? super T>, ? extends Object> pVar, R r, @NotNull f.z.d<? super T> dVar) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            c.b.a.m.f.r5(pVar, r, dVar, null, 4);
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                f.c0.c.j.e(pVar, "$this$startCoroutine");
                f.c0.c.j.e(dVar, "completion");
                c.b.a.m.f.j3(c.b.a.m.f.l1(pVar, r, dVar)).resumeWith(f.h.m11constructorimpl(f.v.a));
                return;
            }
            if (iOrdinal == 3) {
                f.c0.c.j.e(dVar, "completion");
                try {
                    f.z.f context = dVar.getContext();
                    Object objB = g.b.g2.s.b(context, null);
                    try {
                        if (pVar != null) {
                            f.c0.c.y.d(pVar, 2);
                            Object objInvoke = pVar.invoke(r, dVar);
                            if (objInvoke != f.z.i.a.COROUTINE_SUSPENDED) {
                                dVar.resumeWith(f.h.m11constructorimpl(objInvoke));
                                return;
                            }
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    } finally {
                        g.b.g2.s.a(context, objB);
                    }
                } catch (Throwable th) {
                    dVar.resumeWith(f.h.m11constructorimpl(c.b.a.m.f.m1(th)));
                    return;
                }
            }
            throw new f.f();
        }
    }
}
