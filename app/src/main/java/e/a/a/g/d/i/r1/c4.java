package e.a.a.g.d.i.r1;

import android.net.Uri;
import io.legado.app.ui.book.read.config.SpeakEngineViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SpeakEngineViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.config.SpeakEngineViewModel$importLocal$1", f = "SpeakEngineViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class c4 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ SpeakEngineViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c4(Uri uri, SpeakEngineViewModel speakEngineViewModel, f.z.d<? super c4> dVar) {
        super(2, dVar);
        this.$uri = uri;
        this.this$0 = speakEngineViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new c4(this.$uri, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((c4) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Exception {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String strB4 = c.b.a.m.f.B4(this.$uri, this.this$0.b());
        if (strB4 == null) {
            return null;
        }
        this.this$0.e(strB4);
        return f.v.a;
    }
}
