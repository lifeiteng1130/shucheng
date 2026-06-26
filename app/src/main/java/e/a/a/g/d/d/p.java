package e.a.a.g.d.d;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.SearchBookDao;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.ui.book.changesource.ChangeSourceViewModel;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChangeSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.changesource.ChangeSourceViewModel$screen$1", f = "ChangeSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class p extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $key;
    public int label;
    public final /* synthetic */ ChangeSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(ChangeSourceViewModel changeSourceViewModel, String str, f.z.d<? super p> dVar) {
        super(2, dVar);
        this.this$0 = changeSourceViewModel;
        this.$key = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new p(this.this$0, this.$key, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((p) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ChangeSourceViewModel changeSourceViewModel = this.this$0;
        String str = this.$key;
        changeSourceViewModel.screenKey = str == null ? "" : str;
        if (str == null || str.length() == 0) {
            this.this$0.h();
        } else {
            SearchBookDao searchBookDao = AppDatabaseKt.getAppDb().getSearchBookDao();
            ChangeSourceViewModel changeSourceViewModel2 = this.this$0;
            List<SearchBook> changeSourceSearch = searchBookDao.getChangeSourceSearch(changeSourceViewModel2.name, changeSourceViewModel2.author, changeSourceViewModel2.screenKey, ChangeSourceViewModel.e(changeSourceViewModel2));
            this.this$0.searchBooks.clear();
            this.this$0.searchBooks.addAll(changeSourceSearch);
            this.this$0.j();
        }
        return v.a;
    }
}
