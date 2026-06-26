package e.a.a.g.d.g.l0;

import f.c0.b.q;
import f.v;
import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.info.edit.BookInfoEditViewModel$saveBook$2", f = "BookInfoEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class j extends f.z.j.a.g implements q<a0, v, f.z.d<? super v>, Object> {
    public final /* synthetic */ f.c0.b.a<v> $success;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(f.c0.b.a<v> aVar, f.z.d<? super j> dVar) {
        super(3, dVar);
        this.$success = aVar;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull v vVar, @Nullable f.z.d<? super v> dVar) {
        return new j(this.$success, dVar).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        f.c0.b.a<v> aVar = this.$success;
        if (aVar != null) {
            aVar.invoke();
        }
        return v.a;
    }
}
