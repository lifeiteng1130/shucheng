package io.legado.app.model;

import c.b.a.m.f;
import f.c0.b.q;
import f.v;
import f.x.e;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.model.webBook.WebBook;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Debug.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lg/b/a0;", "", "Lio/legado/app/data/entities/BookChapter;", "it", "Lf/v;", "<anonymous>", "(Lg/b/a0;Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "io.legado.app.model.Debug$tocDebug$chapterList$1", f = "Debug.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class Debug$tocDebug$chapterList$1 extends g implements q<a0, List<? extends BookChapter>, d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ a0 $scope;
    public final /* synthetic */ WebBook $webBook;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Debug$tocDebug$chapterList$1(a0 a0Var, WebBook webBook, Book book, d<? super Debug$tocDebug$chapterList$1> dVar) {
        super(3, dVar);
        this.$scope = a0Var;
        this.$webBook = webBook;
        this.$book = book;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull a0 a0Var, @NotNull List<BookChapter> list, @Nullable d<? super v> dVar) {
        Debug$tocDebug$chapterList$1 debug$tocDebug$chapterList$1 = new Debug$tocDebug$chapterList$1(this.$scope, this.$webBook, this.$book, dVar);
        debug$tocDebug$chapterList$1.L$0 = list;
        return debug$tocDebug$chapterList$1.invokeSuspend(v.a);
    }

    @Override // f.c0.b.q
    public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, List<? extends BookChapter> list, d<? super v> dVar) {
        return invoke2(a0Var, (List<BookChapter>) list, dVar);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        f.E5(obj);
        List list = (List) this.L$0;
        if (!list.isEmpty()) {
            Debug debug = Debug.INSTANCE;
            Debug.log$default(debug, Debug.debugSource, "︽目录页解析完成", false, false, false, 0, 60, null);
            Debug.log$default(debug, Debug.debugSource, null, false, false, false, 0, 46, null);
            BookChapter bookChapter = (BookChapter) e.n(list, 1);
            debug.contentDebug(this.$scope, this.$webBook, this.$book, (BookChapter) list.get(0), bookChapter == null ? null : bookChapter.getUrl());
        } else {
            Debug.log$default(Debug.INSTANCE, Debug.debugSource, "︽目录列表为空", false, false, false, -1, 28, null);
        }
        return v.a;
    }
}
