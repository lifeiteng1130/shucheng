package e.a.a.g.d.d;

import f.v;
import g.b.a0;
import io.legado.app.ui.book.changesource.ChangeSourceViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChangeSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.changesource.ChangeSourceViewModel$search$task$2", f = "ChangeSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class r extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChangeSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(ChangeSourceViewModel changeSourceViewModel, f.z.d<? super r> dVar) {
        super(2, dVar);
        this.this$0 = changeSourceViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        r rVar = new r(this.this$0, dVar);
        rVar.L$0 = obj;
        return rVar;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((r) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        v vVar;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        a0 a0Var = (a0) this.L$0;
        ChangeSourceViewModel changeSourceViewModel = this.this$0;
        synchronized (a0Var) {
            if (changeSourceViewModel.searchIndex < f.x.e.m(changeSourceViewModel.bookSourceList)) {
                ChangeSourceViewModel.f(changeSourceViewModel);
            } else {
                changeSourceViewModel.searchIndex++;
            }
            if (changeSourceViewModel.searchIndex >= f.x.e.m(changeSourceViewModel.bookSourceList) + changeSourceViewModel.bookSourceList.size() || changeSourceViewModel.searchIndex >= f.x.e.m(changeSourceViewModel.bookSourceList) + changeSourceViewModel.threadCount) {
                changeSourceViewModel.searchStateData.postValue(Boolean.FALSE);
            }
            vVar = v.a;
        }
        return vVar;
    }
}
