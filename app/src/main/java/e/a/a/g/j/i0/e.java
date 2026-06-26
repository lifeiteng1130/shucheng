package e.a.a.g.j.i0;

import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.ReplaceRule;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.replace.edit.ReplaceEditViewModel$save$1", f = "ReplaceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class e extends g implements p<a0, f.z.d<? super List<? extends Long>>, Object> {
    public final /* synthetic */ ReplaceRule $replaceRule;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ReplaceRule replaceRule, f.z.d<? super e> dVar) {
        super(2, dVar);
        this.$replaceRule = replaceRule;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new e(this.$replaceRule, dVar);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull a0 a0Var, @Nullable f.z.d<? super List<Long>> dVar) {
        return ((e) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, f.z.d<? super List<? extends Long>> dVar) {
        return invoke2(a0Var, (f.z.d<? super List<Long>>) dVar);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        if (this.$replaceRule.getOrder() == 0) {
            this.$replaceRule.setOrder(AppDatabaseKt.getAppDb().getReplaceRuleDao().getMaxOrder() + 1);
        }
        return AppDatabaseKt.getAppDb().getReplaceRuleDao().insert(this.$replaceRule);
    }
}
