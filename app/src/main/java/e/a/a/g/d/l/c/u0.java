package e.a.a.g.d.l.c;

import android.content.Intent;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.manage.BookSourceViewModel$shareSelection$2", f = "BookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class u0 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, Intent, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ f.c0.b.l<Intent, f.v> $success;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public u0(f.c0.b.l<? super Intent, f.v> lVar, f.z.d<? super u0> dVar) {
        super(3, dVar);
        this.$success = lVar;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull Intent intent, @Nullable f.z.d<? super f.v> dVar) {
        u0 u0Var = new u0(this.$success, dVar);
        u0Var.L$0 = intent;
        return u0Var.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.$success.invoke((Intent) this.L$0);
        return f.v.a;
    }
}
