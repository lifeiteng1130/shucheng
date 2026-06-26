package e.a.a.g.e;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import e.a.a.e.c.k;
import io.legado.app.ui.config.BackupConfigFragment;
import io.wenyuange.app.release.R;
import java.util.Arrays;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BackupConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.config.BackupConfigFragment$restore$2", f = "BackupConfigFragment.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {})
public final class y extends f.z.j.a.g implements f.c0.b.q<g.b.a0, Throwable, f.z.d<? super f.v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ BackupConfigFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(BackupConfigFragment backupConfigFragment, f.z.d<? super y> dVar) {
        super(3, dVar);
        this.this$0 = backupConfigFragment;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super f.v> dVar) {
        y yVar = new y(this.this$0, dVar);
        yVar.L$0 = th;
        return yVar.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        Boolean boolValueOf;
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            Throwable th = (Throwable) this.L$0;
            BackupConfigFragment backupConfigFragment = this.this$0;
            StringBuilder sbR = c.a.a.a.a.r("WebDavError:");
            sbR.append((Object) th.getLocalizedMessage());
            sbR.append("\n将从本地备份恢复。");
            e.a.a.h.m.g(backupConfigFragment, sbR.toString());
            String strF = e.a.a.h.m.f(this.this$0, "backupUri", null, 2);
            if (strF == null) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(strF.length() > 0);
            }
            Boolean bool = Boolean.TRUE;
            if (!f.c0.c.j.a(boolValueOf, bool)) {
                this.this$0.restoreDir.launch(null);
            } else if (c.b.a.m.f.t3(strF)) {
                DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this.this$0.requireContext(), Uri.parse(strF));
                if (f.c0.c.j.a(documentFileFromTreeUri == null ? null : Boolean.valueOf(documentFileFromTreeUri.canWrite()), bool)) {
                    e.a.a.d.w.q qVar = e.a.a.d.w.q.a;
                    Context contextRequireContext = this.this$0.requireContext();
                    f.c0.c.j.d(contextRequireContext, "requireContext()");
                    this.label = 1;
                    if (qVar.c(contextRequireContext, strF, this) == aVar) {
                        return aVar;
                    }
                } else {
                    this.this$0.restoreDir.launch(null);
                }
            } else {
                BackupConfigFragment backupConfigFragment2 = this.this$0;
                int i3 = BackupConfigFragment.f7345b;
                Objects.requireNonNull(backupConfigFragment2);
                k.a aVar2 = new k.a(backupConfigFragment2);
                String[] strArr = e.a.a.e.c.j.a;
                aVar2.a((String[]) Arrays.copyOf(strArr, strArr.length));
                aVar2.c(R.string.tip_perm_request_storage);
                aVar2.b(new c0(strF));
                aVar2.d();
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
