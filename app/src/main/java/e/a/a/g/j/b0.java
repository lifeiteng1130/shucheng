package e.a.a.g.j;

import androidx.documentfile.provider.DocumentFile;
import io.legado.app.ui.replace.ReplaceRuleViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceRuleViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.replace.ReplaceRuleViewModel$exportSelection$5", f = "ReplaceRuleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class b0 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, f.v, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ DocumentFile $doc;
    public int label;
    public final /* synthetic */ ReplaceRuleViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(ReplaceRuleViewModel replaceRuleViewModel, DocumentFile documentFile, f.z.d<? super b0> dVar) {
        super(3, dVar);
        this.this$0 = replaceRuleViewModel;
        this.$doc = documentFile;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.v vVar, @Nullable f.z.d<? super f.v> dVar) {
        return new b0(this.this$0, this.$doc, dVar).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        c.b.a.m.f.R5(this.this$0.b(), f.c0.c.j.k("成功导出至\n", this.$doc.getUri().getPath()));
        return f.v.a;
    }
}
