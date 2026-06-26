package e.a.a.g.k.d.b;

import android.content.Intent;
import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.RssSource;
import io.legado.app.ui.rss.source.edit.RssSourceEditViewModel;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.edit.RssSourceEditViewModel$initData$1", f = "RssSourceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class i extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Intent $intent;
    public int label;
    public final /* synthetic */ RssSourceEditViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Intent intent, RssSourceEditViewModel rssSourceEditViewModel, f.z.d<? super i> dVar) {
        super(2, dVar);
        this.$intent = intent;
        this.this$0 = rssSourceEditViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new i(this.$intent, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((i) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        RssSource byKey;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String stringExtra = this.$intent.getStringExtra("data");
        if (stringExtra != null && (byKey = AppDatabaseKt.getAppDb().getRssSourceDao().getByKey(stringExtra)) != null) {
            RssSourceEditViewModel rssSourceEditViewModel = this.this$0;
            Objects.requireNonNull(rssSourceEditViewModel);
            f.c0.c.j.e(byKey, "<set-?>");
            rssSourceEditViewModel.rssSource = byKey;
        }
        RssSourceEditViewModel rssSourceEditViewModel2 = this.this$0;
        rssSourceEditViewModel2.oldSourceUrl = rssSourceEditViewModel2.rssSource.getSourceUrl();
        return v.a;
    }
}
