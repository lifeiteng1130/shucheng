package e.a.a.g.b;

import io.legado.app.ui.association.FileAssociationViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FileAssociationViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.association.FileAssociationViewModel$dispatchIndent$2", f = "FileAssociationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class r extends f.z.j.a.g implements f.c0.b.q<g.b.a0, Throwable, f.z.d<? super f.v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ FileAssociationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(FileAssociationViewModel fileAssociationViewModel, f.z.d<? super r> dVar) {
        super(3, dVar);
        this.this$0 = fileAssociationViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super f.v> dVar) {
        r rVar = new r(this.this$0, dVar);
        rVar.L$0 = th;
        return rVar.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Throwable th = (Throwable) this.L$0;
        th.printStackTrace();
        this.this$0.errorLiveData.postValue(th.getLocalizedMessage());
        return f.v.a;
    }
}
