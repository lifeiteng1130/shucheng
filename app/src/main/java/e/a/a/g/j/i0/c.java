package e.a.a.g.j.i0;

import android.content.Intent;
import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.ReplaceRule;
import io.legado.app.ui.replace.edit.ReplaceEditViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.replace.edit.ReplaceEditViewModel$initData$1", f = "ReplaceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class c extends g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Intent $intent;
    public int label;
    public final /* synthetic */ ReplaceEditViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Intent intent, ReplaceEditViewModel replaceEditViewModel, f.z.d<? super c> dVar) {
        super(2, dVar);
        this.$intent = intent;
        this.this$0 = replaceEditViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new c(this.$intent, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        long longExtra = this.$intent.getLongExtra("id", -1L);
        if (longExtra > 0) {
            this.this$0.replaceRule = AppDatabaseKt.getAppDb().getReplaceRuleDao().findById(longExtra);
        } else {
            String stringExtra = this.$intent.getStringExtra("pattern");
            if (stringExtra == null) {
                stringExtra = "";
            }
            String str = stringExtra;
            boolean booleanExtra = this.$intent.getBooleanExtra("isRegex", false);
            String stringExtra2 = this.$intent.getStringExtra("scope");
            this.this$0.replaceRule = new ReplaceRule(0L, str, null, str, null, stringExtra2, false, booleanExtra, 0, 341, null);
        }
        return v.a;
    }
}
