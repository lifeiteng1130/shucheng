package e.a.a.f.s;

import f.v;
import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.help.ReadBook$loadContent$2$2", f = "ReadBook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class p extends f.z.j.a.g implements f.c0.b.q<a0, Throwable, f.z.d<? super v>, Object> {
    public final /* synthetic */ int $index;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(int i2, f.z.d<? super p> dVar) {
        super(3, dVar);
        this.$index = i2;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
        return new p(this.$index, dVar).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        k.a.p(this.$index);
        return v.a;
    }
}
