package e.a.a.g.d.i.r1;

import io.legado.app.ui.book.read.config.BgTextConfigDialog;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BgTextConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.config.BgTextConfigDialog$importConfig$4", f = "BgTextConfigDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class c2 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, f.v, f.z.d<? super f.v>, Object> {
    public int label;
    public final /* synthetic */ BgTextConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c2(BgTextConfigDialog bgTextConfigDialog, f.z.d<? super c2> dVar) {
        super(3, dVar);
        this.this$0 = bgTextConfigDialog;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull f.v vVar, @Nullable f.z.d<? super f.v> dVar) {
        return new c2(this.this$0, dVar).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        e.a.a.h.m.m(this.this$0, "导入成功");
        return f.v.a;
    }
}
