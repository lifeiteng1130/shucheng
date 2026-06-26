package io.legado.app.model;

import c.b.a.m.f;
import f.c0.b.q;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.model.webBook.WebBook;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Debug.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lg/b/a0;", "Lio/legado/app/data/entities/Book;", "it", "Lf/v;", "<anonymous>", "(Lg/b/a0;Lio/legado/app/data/entities/Book;)V"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "io.legado.app.model.Debug$infoDebug$info$1", f = "Debug.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class Debug$infoDebug$info$1 extends g implements q<a0, Book, d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ a0 $scope;
    public final /* synthetic */ WebBook $webBook;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Debug$infoDebug$info$1(a0 a0Var, WebBook webBook, Book book, d<? super Debug$infoDebug$info$1> dVar) {
        super(3, dVar);
        this.$scope = a0Var;
        this.$webBook = webBook;
        this.$book = book;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull Book book, @Nullable d<? super v> dVar) {
        return new Debug$infoDebug$info$1(this.$scope, this.$webBook, this.$book, dVar).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        f.E5(obj);
        Debug debug = Debug.INSTANCE;
        Debug.log$default(debug, Debug.debugSource, "︽详情页解析完成", false, false, false, 0, 60, null);
        Debug.log$default(debug, Debug.debugSource, null, false, false, false, 0, 46, null);
        debug.tocDebug(this.$scope, this.$webBook, this.$book);
        return v.a;
    }
}
