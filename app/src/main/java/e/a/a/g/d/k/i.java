package e.a.a.g.d.k;

import f.c0.b.q;
import f.v;
import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchContentViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.searchContent.SearchContentViewModel$initBook$2", f = "SearchContentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class i extends f.z.j.a.g implements q<a0, v, f.z.d<? super v>, Object> {
    public final /* synthetic */ f.c0.b.a<v> $success;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(f.c0.b.a<v> aVar, f.z.d<? super i> dVar) {
        super(3, dVar);
        this.$success = aVar;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable v vVar, @Nullable f.z.d<? super v> dVar) {
        return new i(this.$success, dVar).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.$success.invoke();
        return v.a;
    }
}
