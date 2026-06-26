package e.a.a.g.d.g;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$loadGroup$2", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class j0 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, String, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ f.c0.b.l<String, f.v> $success;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public j0(f.c0.b.l<? super String, f.v> lVar, f.z.d<? super j0> dVar) {
        super(3, dVar);
        this.$success = lVar;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull String str, @Nullable f.z.d<? super f.v> dVar) {
        j0 j0Var = new j0(this.$success, dVar);
        j0Var.L$0 = str;
        return j0Var.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.$success.invoke((String) this.L$0);
        return f.v.a;
    }
}
