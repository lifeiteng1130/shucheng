package e.a.a.g.d.i.r1;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TocRegexViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.config.TocRegexViewModel$importOnLine$3", f = "TocRegexViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class b5 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, Throwable, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ f.c0.b.l<String, f.v> $finally;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b5(f.c0.b.l<? super String, f.v> lVar, f.z.d<? super b5> dVar) {
        super(3, dVar);
        this.$finally = lVar;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super f.v> dVar) {
        return new b5(this.$finally, dVar).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.$finally.invoke("导入失败");
        return f.v.a;
    }
}
