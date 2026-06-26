package e.a.a.g.d.l.b;

import f.c0.b.q;
import f.v;
import g.b.a0;
import io.legado.app.data.entities.BookSource;
import io.legado.app.ui.book.source.edit.BookSourceEditViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.edit.BookSourceEditViewModel$pasteSource$3", f = "BookSourceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class n extends f.z.j.a.g implements q<a0, BookSource, f.z.d<? super v>, Object> {
    public final /* synthetic */ f.c0.b.l<BookSource, v> $onSuccess;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ BookSourceEditViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public n(f.c0.b.l<? super BookSource, v> lVar, BookSourceEditViewModel bookSourceEditViewModel, f.z.d<? super n> dVar) {
        super(3, dVar);
        this.$onSuccess = lVar;
        this.this$0 = bookSourceEditViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable BookSource bookSource, @Nullable f.z.d<? super v> dVar) {
        n nVar = new n(this.$onSuccess, this.this$0, dVar);
        nVar.L$0 = bookSource;
        return nVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        BookSource bookSource = (BookSource) this.L$0;
        if (bookSource != null) {
            this.$onSuccess.invoke(bookSource);
        } else {
            c.b.a.m.f.R5(this.this$0.b(), "格式不对");
        }
        return v.a;
    }
}
