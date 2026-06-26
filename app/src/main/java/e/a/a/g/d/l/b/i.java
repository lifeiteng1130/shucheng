package e.a.a.g.d.l.b;

import f.c0.b.q;
import f.v;
import g.b.a0;
import io.legado.app.ui.book.source.edit.BookSourceEditViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.edit.BookSourceEditViewModel$importSource$2", f = "BookSourceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class i extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ BookSourceEditViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(BookSourceEditViewModel bookSourceEditViewModel, f.z.d<? super i> dVar) {
        super(3, dVar);
        this.this$0 = bookSourceEditViewModel;
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
        BookSourceEditViewModel bookSourceEditViewModel = this.this$0;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "Error";
        }
        c.b.a.m.f.R5(bookSourceEditViewModel.b(), localizedMessage);
        return v.a;
    }
}
