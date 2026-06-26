package e.a.a.g.j;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.ReplaceRule;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceRuleViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.replace.ReplaceRuleViewModel$toBottom$1", f = "ReplaceRuleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ ReplaceRule $rule;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(ReplaceRule replaceRule, f.z.d<? super d0> dVar) {
        super(2, dVar);
        this.$rule = replaceRule;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new d0(this.$rule, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((d0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.$rule.setOrder(AppDatabaseKt.getAppDb().getReplaceRuleDao().getMaxOrder() + 1);
        AppDatabaseKt.getAppDb().getReplaceRuleDao().update(this.$rule);
        return f.v.a;
    }
}
