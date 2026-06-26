package e.a.a.g.k.c;

import f.v;
import g.b.a0;
import io.legado.app.ui.rss.read.ReadRssViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadRssViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.read.ReadRssViewModel$saveImage$2", f = "ReadRssViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class n extends f.z.j.a.g implements f.c0.b.q<a0, Throwable, f.z.d<? super v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ReadRssViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(ReadRssViewModel readRssViewModel, f.z.d<? super n> dVar) {
        super(3, dVar);
        this.this$0 = readRssViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
        n nVar = new n(this.this$0, dVar);
        nVar.L$0 = th;
        return nVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.this$0.d(f.c0.c.j.k("保存图片失败:", ((Throwable) this.L$0).getLocalizedMessage()));
        return v.a;
    }
}
