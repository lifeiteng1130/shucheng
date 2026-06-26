package e.a.a.g.k.d.b;

import f.c0.b.q;
import f.v;
import g.b.a0;
import io.legado.app.ui.rss.source.edit.RssSourceEditViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.edit.RssSourceEditViewModel$pasteSource$2", f = "RssSourceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class l extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ RssSourceEditViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(RssSourceEditViewModel rssSourceEditViewModel, f.z.d<? super l> dVar) {
        super(3, dVar);
        this.this$0 = rssSourceEditViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
        l lVar = new l(this.this$0, dVar);
        lVar.L$0 = th;
        return lVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.this$0.d(((Throwable) this.L$0).getLocalizedMessage());
        return v.a;
    }
}
