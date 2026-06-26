package e.a.a.g.d.i.r1;

import android.net.Uri;
import io.legado.app.ui.book.read.config.SpeakEngineViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SpeakEngineViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.config.SpeakEngineViewModel$export$1", f = "SpeakEngineViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class a4 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super Boolean>, Object> {
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ SpeakEngineViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a4(Uri uri, SpeakEngineViewModel speakEngineViewModel, f.z.d<? super a4> dVar) {
        super(2, dVar);
        this.$uri = uri;
        this.this$0 = speakEngineViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new a4(this.$uri, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super Boolean> dVar) {
        return ((a4) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa  */
    @Override // f.z.j.a.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g.d.i.r1.a4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
