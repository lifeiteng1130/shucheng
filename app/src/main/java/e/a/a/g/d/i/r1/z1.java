package e.a.a.g.d.i.r1;

import android.content.Context;
import android.net.Uri;
import io.legado.app.ui.book.read.config.BgTextConfigDialog;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BgTextConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.config.BgTextConfigDialog$importConfig$1", f = "BgTextConfigDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class z1 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ BgTextConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z1(BgTextConfigDialog bgTextConfigDialog, Uri uri, f.z.d<? super z1> dVar) {
        super(2, dVar);
        this.this$0 = bgTextConfigDialog;
        this.$uri = uri;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new z1(this.this$0, this.$uri, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((z1) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        BgTextConfigDialog bgTextConfigDialog = this.this$0;
        Uri uri = this.$uri;
        Context contextRequireContext = bgTextConfigDialog.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        byte[] bArrV4 = c.b.a.m.f.v4(uri, contextRequireContext);
        f.c0.c.j.c(bArrV4);
        BgTextConfigDialog.Q(bgTextConfigDialog, bArrV4);
        return f.v.a;
    }
}
