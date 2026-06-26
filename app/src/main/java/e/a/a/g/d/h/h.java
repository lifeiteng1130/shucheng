package e.a.a.g.d.h;

import f.c0.b.p;
import f.v;
import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.local.ImportBookViewModel$addToBookshelf$2", f = "ImportBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class h extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ f.c0.b.a<v> $finally;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f.c0.b.a<v> aVar, f.z.d<? super h> dVar) {
        super(2, dVar);
        this.$finally = aVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new h(this.$finally, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((h) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.$finally.invoke();
        return v.a;
    }
}
