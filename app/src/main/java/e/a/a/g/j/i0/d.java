package e.a.a.g.j.i0;

import f.c0.b.l;
import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.ReplaceRule;
import io.legado.app.ui.replace.edit.ReplaceEditViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.replace.edit.ReplaceEditViewModel$initData$2", f = "ReplaceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d extends g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ l<ReplaceRule, v> $finally;
    public int label;
    public final /* synthetic */ ReplaceEditViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(ReplaceEditViewModel replaceEditViewModel, l<? super ReplaceRule, v> lVar, f.z.d<? super d> dVar) {
        super(2, dVar);
        this.this$0 = replaceEditViewModel;
        this.$finally = lVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new d(this.this$0, this.$finally, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ReplaceRule replaceRule = this.this$0.replaceRule;
        if (replaceRule != null) {
            this.$finally.invoke(replaceRule);
        }
        return v.a;
    }
}
