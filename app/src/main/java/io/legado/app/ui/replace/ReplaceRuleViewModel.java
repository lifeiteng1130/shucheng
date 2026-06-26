package io.legado.app.ui.replace;

import android.app.Application;
import c.b.a.m.f;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.ReplaceRuleDao;
import io.legado.app.data.entities.ReplaceRule;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceRuleViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lio/legado/app/ui/replace/ReplaceRuleViewModel;", "Lio/legado/app/base/BaseViewModel;", "Ljava/util/LinkedHashSet;", "Lio/legado/app/data/entities/ReplaceRule;", "Lkotlin/collections/LinkedHashSet;", "rules", "Lf/v;", "e", "(Ljava/util/LinkedHashSet;)V", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReplaceRuleViewModel extends BaseViewModel {

    /* JADX INFO: compiled from: ReplaceRuleViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.replace.ReplaceRuleViewModel$delSelection$1", f = "ReplaceRuleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ LinkedHashSet<ReplaceRule> $rules;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LinkedHashSet<ReplaceRule> linkedHashSet, d<? super a> dVar) {
            super(2, dVar);
            this.$rules = linkedHashSet;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new a(this.$rules, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            ReplaceRuleDao replaceRuleDao = AppDatabaseKt.getAppDb().getReplaceRuleDao();
            Object[] array = this.$rules.toArray(new ReplaceRule[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            ReplaceRule[] replaceRuleArr = (ReplaceRule[]) array;
            replaceRuleDao.delete((ReplaceRule[]) Arrays.copyOf(replaceRuleArr, replaceRuleArr.length));
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplaceRuleViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }

    public final void e(@NotNull LinkedHashSet<ReplaceRule> rules) {
        j.e(rules, "rules");
        BaseViewModel.a(this, null, null, new a(rules, null), 3, null);
    }
}
