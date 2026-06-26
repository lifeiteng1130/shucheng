package e.a.a.g.d.g;

import io.legado.app.ui.book.info.BookInfoViewModel;
import io.wenyuange.app.release.R;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$clearCache$2", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f0 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, f.v, f.z.d<? super f.v>, Object> {
    public int label;
    public final /* synthetic */ BookInfoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(BookInfoViewModel bookInfoViewModel, f.z.d<? super f0> dVar) {
        super(3, dVar);
        this.this$0 = bookInfoViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull f.v vVar, @Nullable f.z.d<? super f.v> dVar) {
        return new f0(this.this$0, dVar).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.this$0.c(R.string.clear_cache_success);
        return f.v.a;
    }
}
