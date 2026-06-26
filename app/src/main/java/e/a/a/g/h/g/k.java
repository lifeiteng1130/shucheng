package e.a.a.g.h.g;

import f.c0.b.q;
import f.v;
import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookshelfViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.bookshelf.BookshelfViewModel$exportBookshelf$2", f = "BookshelfViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class k extends f.z.j.a.g implements q<a0, String, f.z.d<? super v>, Object> {
    public final /* synthetic */ f.c0.b.l<String, v> $success;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k(f.c0.b.l<? super String, v> lVar, f.z.d<? super k> dVar) {
        super(3, dVar);
        this.$success = lVar;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, String str, @Nullable f.z.d<? super v> dVar) {
        k kVar = new k(this.$success, dVar);
        kVar.L$0 = str;
        return kVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String str = (String) this.L$0;
        f.c0.b.l<String, v> lVar = this.$success;
        f.c0.c.j.d(str, "it");
        lVar.invoke(str);
        return v.a;
    }
}
