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
@DebugMetadata(c = "io.legado.app.service.CheckSourceService$check$5", f = "CheckSourceService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class q extends f.z.j.a.g implements f.c0.b.q<a0, v, f.z.d<? super v>, Object> {
    public final /* synthetic */ BookSource $source;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(BookSource bookSource, f.z.d<? super q> dVar) {
        super(3, dVar);
        this.$source = bookSource;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull v vVar, @Nullable f.z.d<? super v> dVar) {
        return new q(this.$source, dVar).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.$source.removeGroup("失效");
        AppDatabaseKt.getAppDb().getBookSourceDao().update(this.$source);
        return v.a;
    }
}
