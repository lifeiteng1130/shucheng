package e.a.a.g.j;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.ReplaceRuleDao;
import io.legado.app.data.entities.ReplaceRule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceRuleViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.replace.ReplaceRuleViewModel$disableSelection$1", f = "ReplaceRuleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class v extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ LinkedHashSet<ReplaceRule> $rules;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(LinkedHashSet<ReplaceRule> linkedHashSet, f.z.d<? super v> dVar) {
        super(2, dVar);
        this.$rules = linkedHashSet;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new v(this.$rules, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((v) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ArrayList arrayList = new ArrayList();
        for (ReplaceRule replaceRule : this.$rules) {
            arrayList.add(replaceRule.copy((447 & 1) != 0 ? replaceRule.id : 0L, (447 & 2) != 0 ? replaceRule.name : null, (447 & 4) != 0 ? replaceRule.group : null, (447 & 8) != 0 ? replaceRule.pattern : null, (447 & 16) != 0 ? replaceRule.replacement : null, (447 & 32) != 0 ? replaceRule.scope : null, (447 & 64) != 0 ? replaceRule.isEnabled : false, (447 & 128) != 0 ? replaceRule.isRegex : false, (447 & 256) != 0 ? replaceRule.order : 0));
        }
        ReplaceRuleDao replaceRuleDao = AppDatabaseKt.getAppDb().getReplaceRuleDao();
        Object[] array = arrayList.toArray(new ReplaceRule[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ReplaceRule[] replaceRuleArr = (ReplaceRule[]) array;
        replaceRuleDao.update((ReplaceRule[]) Arrays.copyOf(replaceRuleArr, replaceRuleArr.length));
        return f.v.a;
    }
}
