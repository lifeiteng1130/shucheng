package e.a.a.f;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CheckSourceService.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.CheckSourceService$check$4", f = "CheckSourceService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class p extends f.z.j.a.g implements f.c0.b.q<a0, Throwable, f.z.d<? super v>, Object> {
    public final /* synthetic */ BookSource $source;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(BookSource bookSource, f.z.d<? super p> dVar) {
        super(3, dVar);
        this.$source = bookSource;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
        p pVar = new p(this.$source, dVar);
        pVar.L$0 = th;
        return pVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Throwable th = (Throwable) this.L$0;
        this.$source.addGroup("失效");
        BookSource bookSource = this.$source;
        StringBuilder sbR = c.a.a.a.a.r("error:");
        sbR.append((Object) th.getLocalizedMessage());
        sbR.append('\n');
        sbR.append((Object) this.$source.getBookSourceComment());
        bookSource.setBookSourceComment(sbR.toString());
        AppDatabaseKt.getAppDb().getBookSourceDao().update(this.$source);
        return v.a;
    }
}
