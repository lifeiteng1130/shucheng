package e.a.a.b;

import c.b.a.m.f;
import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: BaseDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.base.BaseDialogFragment$execute$1", f = "BaseDialogFragment.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class b<T> extends g implements p<a0, f.z.d<? super T>, Object> {
    public final /* synthetic */ p<a0, f.z.d<? super T>, Object> $block;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(p<? super a0, ? super f.z.d<? super T>, ? extends Object> pVar, f.z.d<? super b> dVar) {
        super(2, dVar);
        this.$block = pVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        b bVar = new b(this.$block, dVar);
        bVar.L$0 = obj;
        return bVar;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super T> dVar) {
        return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            f.E5(obj);
            a0 a0Var = (a0) this.L$0;
            p<a0, f.z.d<? super T>, Object> pVar = this.$block;
            this.label = 1;
            obj = pVar.invoke(a0Var, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
        }
        return obj;
    }
}
