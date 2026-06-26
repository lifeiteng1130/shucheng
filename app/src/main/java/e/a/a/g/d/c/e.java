package e.a.a.g.d.c;

import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.SearchBookDao;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.ui.book.changecover.ChangeCoverViewModel;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChangeCoverViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.changecover.ChangeCoverViewModel$loadDbSearchBook$1", f = "ChangeCoverViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class e extends g implements p<a0, f.z.d<? super v>, Object> {
    public int label;
    public final /* synthetic */ ChangeCoverViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ChangeCoverViewModel changeCoverViewModel, f.z.d<? super e> dVar) {
        super(2, dVar);
        this.this$0 = changeCoverViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new e(this.this$0, dVar);
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
        SearchBookDao searchBookDao = AppDatabaseKt.getAppDb().getSearchBookDao();
        ChangeCoverViewModel changeCoverViewModel = this.this$0;
        List<SearchBook> enableHasCover = searchBookDao.getEnableHasCover(changeCoverViewModel.name, changeCoverViewModel.author);
        ChangeCoverViewModel changeCoverViewModel2 = this.this$0;
        changeCoverViewModel2.searchBooks.addAll(enableHasCover);
        changeCoverViewModel2.searchBooksLiveData.postValue(f.x.e.F(changeCoverViewModel2.searchBooks));
        if (enableHasCover.size() <= 1) {
            BaseViewModel.a(changeCoverViewModel2, null, null, new f(changeCoverViewModel2, null), 3, null);
        }
        return v.a;
    }
}
