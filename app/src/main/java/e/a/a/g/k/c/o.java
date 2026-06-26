package e.a.a.g.k.c;

import f.v;
import g.b.a0;
import io.legado.app.ui.rss.read.ReadRssViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadRssViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.read.ReadRssViewModel$saveImage$3", f = "ReadRssViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class o extends f.z.j.a.g implements f.c0.b.q<a0, v, f.z.d<? super v>, Object> {
    public int label;
    public final /* synthetic */ ReadRssViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(ReadRssViewModel readRssViewModel, f.z.d<? super o> dVar) {
        super(3, dVar);
        this.this$0 = readRssViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull v vVar, @Nullable f.z.d<? super v> dVar) {
        return new o(this.this$0, dVar).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        c.b.a.m.f.R5(this.this$0.b(), "保存成功");
        return v.a;
    }
}
