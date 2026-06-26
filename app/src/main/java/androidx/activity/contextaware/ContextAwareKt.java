package androidx.activity.contextaware;

import android.content.Context;
import c.b.a.m.f;
import f.c0.b.l;
import f.c0.c.j;
import f.z.d;
import f.z.i.a;
import g.b.i;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"R", "Landroidx/activity/contextaware/ContextAware;", "Lkotlin/Function1;", "Landroid/content/Context;", "onContextAvailable", "withContextAvailable", "(Landroidx/activity/contextaware/ContextAware;Lf/c0/b/l;Lf/z/d;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class ContextAwareKt {
    @Nullable
    public static final <R> Object withContextAvailable(@NotNull ContextAware contextAware, @NotNull l<? super Context, ? extends R> lVar, @NotNull d<? super R> dVar) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return lVar.invoke(contextPeekAvailableContext);
        }
        i iVar = new i(f.j3(dVar), 1);
        iVar.w();
        ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 = new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(iVar, contextAware, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1);
        iVar.a(new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1, contextAware, lVar));
        Object objR = iVar.r();
        if (objR != a.COROUTINE_SUSPENDED) {
            return objR;
        }
        j.e(dVar, "frame");
        return objR;
    }

    @Nullable
    private static final Object withContextAvailable$$forInline(@NotNull ContextAware contextAware, @NotNull l lVar, @NotNull d dVar) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return lVar.invoke(contextPeekAvailableContext);
        }
        i iVar = new i(f.j3(dVar), 1);
        iVar.w();
        ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 = new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(iVar, contextAware, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1);
        iVar.a(new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1, contextAware, lVar));
        Object objR = iVar.r();
        if (objR != a.COROUTINE_SUSPENDED) {
            return objR;
        }
        j.e(dVar, "frame");
        return objR;
    }
}
