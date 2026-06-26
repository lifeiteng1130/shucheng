package e.a.a.g.e;

import android.content.Context;
import android.net.Uri;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BackupConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.config.BackupConfigFragment$restoreDir$1$1", f = "BackupConfigFragment.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
public final class z extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ Uri $uri;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(Uri uri, f.z.d<? super z> dVar) {
        super(2, dVar);
        this.$uri = uri;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new z(this.$uri, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((z) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            e.a.a.d.w.q qVar = e.a.a.d.w.q.a;
            Context contextG = k.d.a.h.g();
            String string = this.$uri.toString();
            f.c0.c.j.d(string, "uri.toString()");
            this.label = 1;
            if (qVar.c(contextG, string, this) == aVar) {
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
