package e.a.a.g.d.l.a;

import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceDebugModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.debug.BookSourceDebugModel$startDebug$2", f = "BookSourceDebugModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class e extends g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ f.c0.b.a<v> $start;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f.c0.b.a<v> aVar, f.z.d<? super e> dVar) {
        super(2, dVar);
        this.$start = aVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new e(this.$start, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((e) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        f.c0.b.a<v> aVar = this.$start;
        if (aVar != null) {
            aVar.invoke();
        }
        return v.a;
    }
}
