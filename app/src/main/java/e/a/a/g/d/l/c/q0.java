package e.a.a.g.d.l.c;

import io.legado.app.ui.book.source.manage.BookSourceViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.manage.BookSourceViewModel$exportSelection$6", f = "BookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class q0 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, Throwable, f.z.d<? super f.v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ BookSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(BookSourceViewModel bookSourceViewModel, f.z.d<? super q0> dVar) {
        super(3, dVar);
        this.this$0 = bookSourceViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super f.v> dVar) {
        q0 q0Var = new q0(this.this$0, dVar);
        q0Var.L$0 = th;
        return q0Var.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        c.b.a.m.f.S3(this.this$0.b(), f.c0.c.j.k("导出失败\n", ((Throwable) this.L$0).getLocalizedMessage()));
        return f.v.a;
    }
}
