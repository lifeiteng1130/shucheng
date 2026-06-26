package e.a.a.g.b;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportRssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.association.ImportRssSourceViewModel$importSelect$2", f = "ImportRssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ f.c0.b.a<f.v> $finally;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(f.c0.b.a<f.v> aVar, f.z.d<? super f0> dVar) {
        super(2, dVar);
        this.$finally = aVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new f0(this.$finally, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((f0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.$finally.invoke();
        return f.v.a;
    }
}
