package e.a.a.g.d.m;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.ui.book.toc.TocViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TocViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.toc.TocViewModel$initBook$1", f = "TocViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class r extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $bookUrl;
    public int label;
    public final /* synthetic */ TocViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(String str, TocViewModel tocViewModel, f.z.d<? super r> dVar) {
        super(2, dVar);
        this.$bookUrl = str;
        this.this$0 = tocViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new r(this.$bookUrl, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((r) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Book book = AppDatabaseKt.getAppDb().getBookDao().getBook(this.$bookUrl);
        if (book == null) {
            return null;
        }
        this.this$0.bookData.postValue(book);
        return v.a;
    }
}
