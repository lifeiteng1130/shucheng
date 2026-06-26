package e.a.a.g.j;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.ReplaceRuleDao;
import io.legado.app.data.entities.ReplaceRule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceRuleViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.replace.ReplaceRuleViewModel$addGroup$1", f = "ReplaceRuleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class s extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ String $group;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(String str, f.z.d<? super s> dVar) {
        super(2, dVar);
        this.$group = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new s(this.$group, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((s) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        List<ReplaceRule> noGroup = AppDatabaseKt.getAppDb().getReplaceRuleDao().getNoGroup();
        String str = this.$group;
        ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(noGroup, 10));
        Iterator<T> it = noGroup.iterator();
        while (it.hasNext()) {
            ((ReplaceRule) it.next()).setGroup(str);
            arrayList.add(f.v.a);
        }
        ReplaceRuleDao replaceRuleDao = AppDatabaseKt.getAppDb().getReplaceRuleDao();
        Object[] array = noGroup.toArray(new ReplaceRule[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ReplaceRule[] replaceRuleArr = (ReplaceRule[]) array;
        replaceRuleDao.update((ReplaceRule[]) Arrays.copyOf(replaceRuleArr, replaceRuleArr.length));
        return f.v.a;
    }
}
