package e.a.a.g.j;

import io.legado.app.ui.replace.ReplaceRuleViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceRuleViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.replace.ReplaceRuleViewModel$exportSelection$3", f = "ReplaceRuleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class z extends f.z.j.a.g implements f.c0.b.q<g.b.a0, Throwable, f.z.d<? super f.v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ReplaceRuleViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(ReplaceRuleViewModel replaceRuleViewModel, f.z.d<? super z> dVar) {
        super(3, dVar);
        this.this$0 = replaceRuleViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super f.v> dVar) {
        z zVar = new z(this.this$0, dVar);
        zVar.L$0 = th;
        return zVar.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        c.a.a.a.a.A((Throwable) this.L$0, "导出失败\n", this.this$0.b());
        return f.v.a;
    }
}
