package e.a.a.g.d.l.b;

import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.data.entities.BookSource;
import io.legado.app.help.storage.OldRule;
import io.legado.app.ui.book.source.edit.BookSourceEditViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.edit.BookSourceEditViewModel$pasteSource$1", f = "BookSourceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class l extends f.z.j.a.g implements p<a0, f.z.d<? super BookSource>, Object> {
    public int label;
    public final /* synthetic */ BookSourceEditViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(BookSourceEditViewModel bookSourceEditViewModel, f.z.d<? super l> dVar) {
        super(2, dVar);
        this.this$0 = bookSourceEditViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new l(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super BookSource> dVar) {
        return ((l) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String strX1 = c.b.a.m.f.X1(this.this$0.b());
        if (strX1 == null) {
            return null;
        }
        return OldRule.a.a(strX1);
    }
}
