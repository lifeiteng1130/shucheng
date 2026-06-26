package e.a.a.g.l;

import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.ui.welcome.WelcomeActivity;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WelcomeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.welcome.WelcomeActivity$init$3", f = "WelcomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class m extends f.z.j.a.g implements p<a0, f.z.d<? super String>, Object> {
    public int label;
    public final /* synthetic */ WelcomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(WelcomeActivity welcomeActivity, f.z.d<? super m> dVar) {
        super(2, dVar);
        this.this$0 = welcomeActivity;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new m(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super String> dVar) {
        return ((m) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        AppDatabaseKt.getAppDb().getCacheDao().clearDeadline(System.currentTimeMillis());
        if (c.b.a.m.f.J2(this.this$0, "autoClearExpired", true)) {
            AppDatabaseKt.getAppDb().getSearchBookDao().clearExpired(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        }
        int iB = e.a.a.d.e.a.b();
        if (iB == 1) {
            return c.b.a.m.f.B5("初始化");
        }
        if (iB != 2) {
            return null;
        }
        return c.b.a.m.f.U4("初始化");
    }
}
