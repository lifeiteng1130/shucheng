package e.a.a.g.d.d;

import f.v;
import g.b.a0;
import g.b.x0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.SearchBookDao;
import io.legado.app.ui.book.changesource.ChangeSourceViewModel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChangeSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.changesource.ChangeSourceViewModel$startSearch$1", f = "ChangeSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class s extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public int label;
    public final /* synthetic */ ChangeSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(ChangeSourceViewModel changeSourceViewModel, f.z.d<? super s> dVar) {
        super(2, dVar);
        this.this$0 = changeSourceViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new s(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((s) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        SearchBookDao searchBookDao = AppDatabaseKt.getAppDb().getSearchBookDao();
        ChangeSourceViewModel changeSourceViewModel = this.this$0;
        searchBookDao.clear(changeSourceViewModel.name, changeSourceViewModel.author);
        this.this$0.searchBooks.clear();
        this.this$0.j();
        this.this$0.bookSourceList.clear();
        if (f.h0.k.s(ChangeSourceViewModel.e(this.this$0))) {
            this.this$0.bookSourceList.addAll(AppDatabaseKt.getAppDb().getBookSourceDao().getAllEnabled());
        } else {
            this.this$0.bookSourceList.addAll(AppDatabaseKt.getAppDb().getBookSourceDao().getEnabledByGroup(ChangeSourceViewModel.e(this.this$0)));
        }
        this.this$0.searchStateData.postValue(Boolean.TRUE);
        ChangeSourceViewModel changeSourceViewModel2 = this.this$0;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(changeSourceViewModel2.threadCount);
        f.c0.c.j.d(executorServiceNewFixedThreadPool, "newFixedThreadPool(threadCount)");
        changeSourceViewModel2.searchPool = new x0(executorServiceNewFixedThreadPool);
        changeSourceViewModel2.searchIndex = -1;
        int i2 = 0;
        int i3 = this.this$0.threadCount;
        if (i3 > 0) {
            do {
                i2++;
                ChangeSourceViewModel.f(this.this$0);
            } while (i2 < i3);
        }
        return v.a;
    }
}
