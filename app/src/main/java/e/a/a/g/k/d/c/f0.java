package e.a.a.g.k.d.c;

import android.content.Intent;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$shareSelection$2", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f0 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, Intent, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ f.c0.b.l<Intent, f.v> $success;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public f0(f.c0.b.l<? super Intent, f.v> lVar, f.z.d<? super f0> dVar) {
        super(3, dVar);
        this.$success = lVar;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull Intent intent, @Nullable f.z.d<? super f.v> dVar) {
        f0 f0Var = new f0(this.$success, dVar);
        f0Var.L$0 = intent;
        return f0Var.invokeSuspend(f.v.a);
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
