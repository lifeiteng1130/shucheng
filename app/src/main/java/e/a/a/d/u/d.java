package e.a.a.d.u;

import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Coroutine.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.help.coroutine.Coroutine$dispatchVoidCallback$2", f = "Coroutine.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
public final class d extends g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ b<T>.c $callback;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b<T>.c cVar, f.z.d<? super d> dVar) {
        super(2, dVar);
        this.$callback = cVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        d dVar2 = new d(this.$callback, dVar);
        dVar2.L$0 = obj;
        return dVar2;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            a0 a0Var = (a0) this.L$0;
            p<a0, f.z.d<? super v>, Object> pVar = this.$callback.f5567b;
            this.label = 1;
            if (pVar.invoke(a0Var, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
        }
        return v.a;
    }
}
