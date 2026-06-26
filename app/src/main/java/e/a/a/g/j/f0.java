package e.a.a.g.j;

import android.text.TextUtils;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.ReplaceRuleDao;
import io.legado.app.data.entities.ReplaceRule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceRuleViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.replace.ReplaceRuleViewModel$upGroup$1", f = "ReplaceRuleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ String $newGroup;
    public final /* synthetic */ String $oldGroup;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(String str, String str2, f.z.d<? super f0> dVar) {
        super(2, dVar);
        this.$oldGroup = str;
        this.$newGroup = str2;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new f0(this.$oldGroup, this.$newGroup, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((f0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        List<ReplaceRule> byGroup = AppDatabaseKt.getAppDb().getReplaceRuleDao().getByGroup(this.$oldGroup);
        String str = this.$oldGroup;
        String str2 = this.$newGroup;
        ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(byGroup, 10));
        Iterator<T> it = byGroup.iterator();
        while (true) {
            if (!it.hasNext()) {
                ReplaceRuleDao replaceRuleDao = AppDatabaseKt.getAppDb().getReplaceRuleDao();
                Object[] array = byGroup.toArray(new ReplaceRule[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                ReplaceRule[] replaceRuleArr = (ReplaceRule[]) array;
                replaceRuleDao.update((ReplaceRule[]) Arrays.copyOf(replaceRuleArr, replaceRuleArr.length));
                return f.v.a;
            }
            ReplaceRule replaceRule = (ReplaceRule) it.next();
            String group = replaceRule.getGroup();
            f.v vVar = null;
            String[] strArrN5 = group == null ? null : c.b.a.m.f.n5(group, ",");
            if (strArrN5 != null) {
                HashSet hashSetI5 = c.b.a.m.f.I5(strArrN5);
                hashSetI5.remove(str);
                if (!(str2 == null || str2.length() == 0)) {
                    hashSetI5.add(str2);
                }
                replaceRule.setGroup(TextUtils.join(",", hashSetI5));
                vVar = f.v.a;
            }
            arrayList.add(vVar);
        }
    }
}
