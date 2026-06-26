package e.a.a.g.d.g;

import android.content.Intent;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.ui.book.info.BookInfoViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$initData$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class h0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ Intent $intent;
    public int label;
    public final /* synthetic */ BookInfoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(Intent intent, BookInfoViewModel bookInfoViewModel, f.z.d<? super h0> dVar) {
        super(2, dVar);
        this.$intent = intent;
        this.this$0 = bookInfoViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new h0(this.$intent, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((h0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.v vVar;
        Book book;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String stringExtra = this.$intent.getStringExtra("name");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = this.$intent.getStringExtra("author");
        String str = stringExtra2 != null ? stringExtra2 : "";
        Book book2 = AppDatabaseKt.getAppDb().getBookDao().getBook(stringExtra, str);
        if (book2 == null) {
            vVar = null;
        } else {
            BookInfoViewModel bookInfoViewModel = this.this$0;
            bookInfoViewModel.inBookshelf = true;
            BookInfoViewModel.e(bookInfoViewModel, book2);
            vVar = f.v.a;
        }
        if (vVar != null) {
            return vVar;
        }
        SearchBook firstByNameAuthor = AppDatabaseKt.getAppDb().getSearchBookDao().getFirstByNameAuthor(stringExtra, str);
        if (firstByNameAuthor == null || (book = firstByNameAuthor.toBook()) == null) {
            return null;
        }
        BookInfoViewModel.e(this.this$0, book);
        return f.v.a;
    }
}
