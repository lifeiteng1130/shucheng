package e.a.a.g.e;

import io.legado.app.ui.config.BackupConfigFragment;
import io.wenyuange.app.release.R;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BackupConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.config.BackupConfigFragment$backup$2", f = "BackupConfigFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class r extends f.z.j.a.g implements f.c0.b.q<g.b.a0, f.v, f.z.d<? super f.v>, Object> {
    public int label;
    public final /* synthetic */ BackupConfigFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(BackupConfigFragment backupConfigFragment, f.z.d<? super r> dVar) {
        super(3, dVar);
        this.this$0 = backupConfigFragment;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull f.v vVar, @Nullable f.z.d<? super f.v> dVar) {
        return new r(this.this$0, dVar).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        e.a.a.h.m.l(this.this$0, R.string.backup_success);
        return f.v.a;
    }
}
