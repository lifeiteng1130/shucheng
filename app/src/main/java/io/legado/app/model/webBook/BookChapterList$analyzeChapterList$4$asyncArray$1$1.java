package io.legado.app.model.webBook;

import c.b.a.m.f;
import e.a.a.d.v.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.u;
import f.v;
import f.z.d;
import f.z.i.a;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.rule.TocRule;
import io.legado.app.model.analyzeRule.AnalyzeUrl;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookChapterList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lg/b/a0;", "", "Lio/legado/app/data/entities/BookChapter;", "<anonymous>", "(Lg/b/a0;)Ljava/util/List;"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "io.legado.app.model.webBook.BookChapterList$analyzeChapterList$4$asyncArray$1$1", f = "BookChapterList.kt", i = {0, 0}, l = {89}, m = "invokeSuspend", n = {"$this$async", "urlStr"}, s = {"L$0", "L$1"})
public final class BookChapterList$analyzeChapterList$4$asyncArray$1$1 extends g implements p<a0, d<? super List<? extends BookChapter>>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ BookSource $bookSource;
    public final /* synthetic */ u<ChapterData<List<String>>> $chapterData;
    public final /* synthetic */ u<String> $listRule;
    public final /* synthetic */ int $tmp;
    public final /* synthetic */ TocRule $tocRule;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookChapterList$analyzeChapterList$4$asyncArray$1$1(u<ChapterData<List<String>>> uVar, int i2, Book book, BookSource bookSource, TocRule tocRule, u<String> uVar2, d<? super BookChapterList$analyzeChapterList$4$asyncArray$1$1> dVar) {
        super(2, dVar);
        this.$chapterData = uVar;
        this.$tmp = i2;
        this.$book = book;
        this.$bookSource = bookSource;
        this.$tocRule = tocRule;
        this.$listRule = uVar2;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
        BookChapterList$analyzeChapterList$4$asyncArray$1$1 bookChapterList$analyzeChapterList$4$asyncArray$1$1 = new BookChapterList$analyzeChapterList$4$asyncArray$1$1(this.$chapterData, this.$tmp, this.$book, this.$bookSource, this.$tocRule, this.$listRule, dVar);
        bookChapterList$analyzeChapterList$4$asyncArray$1$1.L$0 = obj;
        return bookChapterList$analyzeChapterList$4$asyncArray$1$1;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull a0 a0Var, @Nullable d<? super List<BookChapter>> dVar) {
        return ((BookChapterList$analyzeChapterList$4$asyncArray$1$1) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, d<? super List<? extends BookChapter>> dVar) {
        return invoke2(a0Var, (d<? super List<BookChapter>>) dVar);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        a0 a0Var;
        String str;
        Object strResponse$default;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            f.E5(obj);
            a0Var = (a0) this.L$0;
            String str2 = this.$chapterData.element.getNextUrl().get(this.$tmp);
            str = str2;
            AnalyzeUrl analyzeUrl = new AnalyzeUrl(str, null, null, null, null, null, false, this.$book, null, null, this.$bookSource.getHeaderMap(), 894, null);
            String bookSourceUrl = this.$bookSource.getBookSourceUrl();
            this.L$0 = a0Var;
            this.L$1 = str2;
            this.label = 1;
            strResponse$default = AnalyzeUrl.getStrResponse$default(analyzeUrl, bookSourceUrl, null, null, this, 6, null);
            if (strResponse$default == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str3 = (String) this.L$1;
            a0 a0Var2 = (a0) this.L$0;
            f.E5(obj);
            str = str3;
            a0Var = a0Var2;
            strResponse$default = obj;
        }
        l lVar = (l) strResponse$default;
        BookChapterList bookChapterList = BookChapterList.INSTANCE;
        Book book = this.$book;
        String strA = lVar.a();
        String str4 = lVar.f5588b;
        j.c(str4);
        return BookChapterList.analyzeChapterList$default(bookChapterList, a0Var, book, str, strA, str4, this.$tocRule, this.$listRule.element, this.$bookSource, false, false, 512, null).getChapterList();
    }
}
