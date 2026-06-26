package e.a.a.g.k.d.b;

import f.c0.b.q;
import f.v;
import g.b.a0;
import io.legado.app.data.entities.RssSource;
import io.legado.app.ui.rss.source.edit.RssSourceEditViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.edit.RssSourceEditViewModel$pasteSource$3", f = "RssSourceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class m extends f.z.j.a.g implements q<a0, RssSource, f.z.d<? super v>, Object> {
    public final /* synthetic */ f.c0.b.l<RssSource, v> $onSuccess;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ RssSourceEditViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public m(f.c0.b.l<? super RssSource, v> lVar, RssSourceEditViewModel rssSourceEditViewModel, f.z.d<? super m> dVar) {
        super(3, dVar);
        this.$onSuccess = lVar;
        this.this$0 = rssSourceEditViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable RssSource rssSource, @Nullable f.z.d<? super v> dVar) {
        m mVar = new m(this.$onSuccess, this.this$0, dVar);
        mVar.L$0 = rssSource;
        return mVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        RssSource rssSource = (RssSource) this.L$0;
        if (rssSource != null) {
            this.$onSuccess.invoke(rssSource);
        } else {
            c.b.a.m.f.R5(this.this$0.b(), "格式不对");
        }
        return v.a;
    }
}
