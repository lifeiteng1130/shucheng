package e.a.a.g.d.c;

import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import g.b.x0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.ui.book.changecover.ChangeCoverViewModel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChangeCoverViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.changecover.ChangeCoverViewModel$startSearch$1", f = "ChangeCoverViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f extends g implements p<a0, f.z.d<? super v>, Object> {
    public int label;
    public final /* synthetic */ ChangeCoverViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ChangeCoverViewModel changeCoverViewModel, f.z.d<? super f> dVar) {
        super(2, dVar);
        this.this$0 = changeCoverViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new f(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((f) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.this$0.bookSourceList.clear();
        this.this$0.bookSourceList.addAll(AppDatabaseKt.getAppDb().getBookSourceDao().getAllEnabled());
        this.this$0.searchStateData.postValue(Boolean.TRUE);
        ChangeCoverViewModel changeCoverViewModel = this.this$0;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(changeCoverViewModel.threadCount);
        j.d(executorServiceNewFixedThreadPool, "newFixedThreadPool(threadCount)");
        changeCoverViewModel.searchPool = new x0(executorServiceNewFixedThreadPool);
        changeCoverViewModel.searchIndex = -1;
        int i2 = 0;
        int i3 = this.this$0.threadCount;
        if (i3 > 0) {
            do {
                i2++;
                this.this$0.e();
            } while (i2 < i3);
        }
        return v.a;
    }
}
