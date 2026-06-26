package e.a.a.g.l;

import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.ui.welcome.WelcomeActivity;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WelcomeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.welcome.WelcomeActivity$init$1", f = "WelcomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class k extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public int label;
    public final /* synthetic */ WelcomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(WelcomeActivity welcomeActivity, f.z.d<? super k> dVar) {
        super(2, dVar);
        this.this$0 = welcomeActivity;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new k(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((k) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f9  */
    @Override // f.z.j.a.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1107
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g.l.k.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
