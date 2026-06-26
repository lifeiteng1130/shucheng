package io.legado.app.model;

import c.b.a.m.f;
import f.c0.b.q;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Debug.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lg/b/a0;", "", "it", "Lf/v;", "<anonymous>", "(Lg/b/a0;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "io.legado.app.model.Debug$searchDebug$search$2", f = "Debug.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class Debug$searchDebug$search$2 extends g implements q<a0, Throwable, d<? super v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;

    public Debug$searchDebug$search$2(d<? super Debug$searchDebug$search$2> dVar) {
        super(3, dVar);
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable d<? super v> dVar) {
        Debug$searchDebug$search$2 debug$searchDebug$search$2 = new Debug$searchDebug$search$2(dVar);
        debug$searchDebug$search$2.L$0 = th;
        return debug$searchDebug$search$2.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        f.E5(obj);
        Debug.log$default(Debug.INSTANCE, Debug.debugSource, f.C2((Throwable) this.L$0), false, false, false, -1, 28, null);
        return v.a;
    }
}
