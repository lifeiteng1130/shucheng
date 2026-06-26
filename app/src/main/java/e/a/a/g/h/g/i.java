package e.a.a.g.h.g;

import f.c0.b.q;
import f.v;
import g.b.a0;
import io.legado.app.ui.main.bookshelf.BookshelfViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookshelfViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.bookshelf.BookshelfViewModel$addBookByUrl$3", f = "BookshelfViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class i extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ BookshelfViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(BookshelfViewModel bookshelfViewModel, f.z.d<? super i> dVar) {
        super(3, dVar);
        this.this$0 = bookshelfViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
        i iVar = new i(this.this$0, dVar);
        iVar.L$0 = th;
        return iVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Throwable th = (Throwable) this.L$0;
        BookshelfViewModel bookshelfViewModel = this.this$0;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "ERROR";
        }
        c.b.a.m.f.R5(bookshelfViewModel.b(), localizedMessage);
        return v.a;
    }
}
