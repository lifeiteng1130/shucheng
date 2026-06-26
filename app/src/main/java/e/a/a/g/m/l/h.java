package e.a.a.g.m.l;

import f.c0.b.q;
import f.v;
import g.b.a0;
import io.legado.app.ui.widget.font.FontAdapter;
import io.legado.app.ui.widget.font.FontSelectDialog;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FontSelectDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.widget.font.FontSelectDialog$loadFontFiles$5", f = "FontSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class h extends f.z.j.a.g implements q<a0, List<? extends e.a.a.h.i>, f.z.d<? super v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ FontSelectDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FontSelectDialog fontSelectDialog, f.z.d<? super h> dVar) {
        super(3, dVar);
        this.this$0 = fontSelectDialog;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull a0 a0Var, @NotNull List<e.a.a.h.i> list, @Nullable f.z.d<? super v> dVar) {
        h hVar = new h(this.this$0, dVar);
        hVar.L$0 = list;
        return hVar.invokeSuspend(v.a);
    }

    @Override // f.c0.b.q
    public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, List<? extends e.a.a.h.i> list, f.z.d<? super v> dVar) {
        return invoke2(a0Var, (List<e.a.a.h.i>) list, dVar);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        List list = (List) this.L$0;
        FontAdapter fontAdapter = this.this$0.adapter;
        if (fontAdapter != null) {
            fontAdapter.x(list);
        }
        return v.a;
    }
}
