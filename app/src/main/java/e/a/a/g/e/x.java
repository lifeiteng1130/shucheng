package e.a.a.g.e;

import android.content.Context;
import io.legado.app.ui.config.BackupConfigFragment;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BackupConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.config.BackupConfigFragment$restore$1", f = "BackupConfigFragment.kt", i = {}, l = {261}, m = "invokeSuspend", n = {}, s = {})
public final class x extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public int label;
    public final /* synthetic */ BackupConfigFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(BackupConfigFragment backupConfigFragment, f.z.d<? super x> dVar) {
        super(2, dVar);
        this.this$0 = backupConfigFragment;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new x(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((x) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            e.a.a.d.w.j jVar = e.a.a.d.w.j.a;
            Context contextRequireContext = this.this$0.requireContext();
            f.c0.c.j.d(contextRequireContext, "requireContext()");
            this.label = 1;
            if (jVar.i(contextRequireContext, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
        }
        return f.v.a;
    }
}
