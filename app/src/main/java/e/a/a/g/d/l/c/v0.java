package e.a.a.g.d.l.c;

import io.legado.app.ui.book.source.manage.BookSourceViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.manage.BookSourceViewModel$shareSelection$3", f = "BookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class v0 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, Throwable, f.z.d<? super f.v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ BookSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(BookSourceViewModel bookSourceViewModel, f.z.d<? super v0> dVar) {
        super(3, dVar);
        this.this$0 = bookSourceViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super f.v> dVar) {
        v0 v0Var = new v0(this.this$0, dVar);
        v0Var.L$0 = th;
        return v0Var.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Throwable th = (Throwable) this.L$0;
        BookSourceViewModel bookSourceViewModel = this.this$0;
        c.b.a.m.f.R5(bookSourceViewModel.b(), c.b.a.m.f.C2(th));
        return f.v.a;
    }
}
