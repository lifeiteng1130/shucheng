package e.a.a.g.j.i0;

import f.c0.b.q;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.replace.edit.ReplaceEditViewModel$save$2", f = "ReplaceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f extends g implements q<a0, List<? extends Long>, f.z.d<? super v>, Object> {
    public final /* synthetic */ f.c0.b.a<v> $success;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(f.c0.b.a<v> aVar, f.z.d<? super f> dVar) {
        super(3, dVar);
        this.$success = aVar;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull a0 a0Var, @NotNull List<Long> list, @Nullable f.z.d<? super v> dVar) {
        return new f(this.$success, dVar).invokeSuspend(v.a);
    }

    @Override // f.c0.b.q
    public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, List<? extends Long> list, f.z.d<? super v> dVar) {
        return invoke2(a0Var, (List<Long>) list, dVar);
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
