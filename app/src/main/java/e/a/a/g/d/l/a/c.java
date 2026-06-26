package e.a.a.g.d.l.a;

import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.ui.book.source.debug.BookSourceDebugModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceDebugModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.debug.BookSourceDebugModel$init$1$1", f = "BookSourceDebugModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class c extends g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $sourceUrl;
    public int label;
    public final /* synthetic */ BookSourceDebugModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, BookSourceDebugModel bookSourceDebugModel, f.z.d<? super c> dVar) {
        super(2, dVar);
        this.$sourceUrl = str;
        this.this$0 = bookSourceDebugModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new c(this.$sourceUrl, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(this.$sourceUrl);
        if (bookSource == null) {
            return null;
        }
        this.this$0.webBook = new WebBook(bookSource);
        return v.a;
    }
}
