package e.a.a.g.d.i.r1;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.TxtTocRule;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TocRegexDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.config.TocRegexDialog$TocRegexAdapter$registerListener$1$4$1$1", f = "TocRegexDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class w4 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ TxtTocRule $item;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w4(TxtTocRule txtTocRule, f.z.d<? super w4> dVar) {
        super(2, dVar);
        this.$item = txtTocRule;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new w4(this.$item, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((w4) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        AppDatabaseKt.getAppDb().getTxtTocRuleDao().delete(this.$item);
        return f.v.a;
    }
}
