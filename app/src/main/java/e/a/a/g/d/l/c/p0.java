package e.a.a.g.d.l.c;

import androidx.documentfile.provider.DocumentFile;
import io.legado.app.ui.book.source.manage.BookSourceViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.manage.BookSourceViewModel$exportSelection$5", f = "BookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class p0 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, f.v, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ DocumentFile $doc;
    public int label;
    public final /* synthetic */ BookSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(BookSourceViewModel bookSourceViewModel, DocumentFile documentFile, f.z.d<? super p0> dVar) {
        super(3, dVar);
        this.this$0 = bookSourceViewModel;
        this.$doc = documentFile;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.v vVar, @Nullable f.z.d<? super f.v> dVar) {
        return new p0(this.this$0, this.$doc, dVar).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        c.b.a.m.f.S3(this.this$0.b(), f.c0.c.j.k("成功导出至\n", this.$doc.getUri().getPath()));
        return f.v.a;
    }
}
