package e.a.a.g.h.g;

import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.ui.main.bookshelf.BookshelfViewModel;
import io.wenyuange.app.release.R;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookshelfViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.bookshelf.BookshelfViewModel$importBookshelfByJson$2", f = "BookshelfViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class m extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public int label;
    public final /* synthetic */ BookshelfViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(BookshelfViewModel bookshelfViewModel, f.z.d<? super m> dVar) {
        super(2, dVar);
        this.this$0 = bookshelfViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new m(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((m) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.this$0.c(R.string.success);
        return v.a;
    }
}
