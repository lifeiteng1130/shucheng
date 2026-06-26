package e.a.a.g.h;

import e.a.a.d.m;
import e.a.a.d.q;
import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.MainViewModel$upVersion$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f extends g implements p<a0, f.z.d<? super v>, Object> {
    public int label;

    public f(f.z.d<? super f> dVar) {
        super(2, dVar);
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new f(dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((f) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        q qVar = q.a;
        if (!qVar.b(3, "httpTtsVersion", null)) {
            m mVar = m.a;
            m.b();
        }
        if (!qVar.b(1, "txtTocRuleVersion", null)) {
            m mVar2 = m.a;
            m.d();
        }
        if (!qVar.b(3, "rssSourceVersion", null)) {
            m mVar3 = m.a;
            m.c();
        }
        return v.a;
    }
}
