package e.a.a.g.d.i.r1;

import io.legado.app.ui.book.read.config.BgTextConfigDialog;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BgTextConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.config.BgTextConfigDialog$importConfig$5", f = "BgTextConfigDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d2 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, Throwable, f.z.d<? super f.v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ BgTextConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(BgTextConfigDialog bgTextConfigDialog, f.z.d<? super d2> dVar) {
        super(3, dVar);
        this.this$0 = bgTextConfigDialog;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super f.v> dVar) {
        d2 d2Var = new d2(this.this$0, dVar);
        d2Var.L$0 = th;
        return d2Var.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Throwable th = (Throwable) this.L$0;
        th.printStackTrace();
        e.a.a.h.m.g(this.this$0, f.c0.c.j.k("导入失败:", th.getLocalizedMessage()));
        return f.v.a;
    }
}
