package e.a.a.g.h.g;

import f.c0.b.q;
import f.c0.c.s;
import f.v;
import g.b.a0;
import io.legado.app.ui.main.bookshelf.BookshelfViewModel;
import io.wenyuange.app.release.R;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookshelfViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.bookshelf.BookshelfViewModel$addBookByUrl$2", f = "BookshelfViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class h extends f.z.j.a.g implements q<a0, v, f.z.d<? super v>, Object> {
    public final /* synthetic */ s $successCount;
    public int label;
    public final /* synthetic */ BookshelfViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(s sVar, BookshelfViewModel bookshelfViewModel, f.z.d<? super h> dVar) {
        super(3, dVar);
        this.$successCount = sVar;
        this.this$0 = bookshelfViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull v vVar, @Nullable f.z.d<? super v> dVar) {
        return new h(this.$successCount, this.this$0, dVar).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        if (this.$successCount.element > 0) {
            this.this$0.c(R.string.success);
        } else {
            c.b.a.m.f.R5(this.this$0.b(), "ERROR");
        }
        return v.a;
    }
}
