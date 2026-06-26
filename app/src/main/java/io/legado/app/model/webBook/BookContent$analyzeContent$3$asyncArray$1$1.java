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
import io.legado.app.data.entities.rule.ContentRule;
import io.legado.app.model.analyzeRule.AnalyzeUrl;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookContent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "", "<anonymous>", "(Lg/b/a0;)Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "io.legado.app.model.webBook.BookContent$analyzeContent$3$asyncArray$1$1", f = "BookContent.kt", i = {0}, l = {92}, m = "invokeSuspend", n = {"urlStr"}, s = {"L$0"})
public final class BookContent$analyzeContent$3$asyncArray$1$1 extends g implements p<a0, d<? super String>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ BookChapter $bookChapter;
    public final /* synthetic */ BookSource $bookSource;
    public final /* synthetic */ u<ContentData<List<String>>> $contentData;
    public final /* synthetic */ ContentRule $contentRule;
    public final /* synthetic */ String $mNextChapterUrl;
    public final /* synthetic */ int $tmp;
    public Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookContent$analyzeContent$3$asyncArray$1$1(u<ContentData<List<String>>> uVar, int i2, Book book, BookSource bookSource, ContentRule contentRule, BookChapter bookChapter, String str, d<? super BookContent$analyzeContent$3$asyncArray$1$1> dVar) {
        super(2, dVar);
        this.$contentData = uVar;
        this.$tmp = i2;
        this.$book = book;
        this.$bookSource = bookSource;
        this.$contentRule = contentRule;
        this.$bookChapter = bookChapter;
        this.$mNextChapterUrl = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new BookContent$analyzeContent$3$asyncArray$1$1(this.$contentData, this.$tmp, this.$book, this.$bookSource, this.$contentRule, this.$bookChapter, this.$mNextChapterUrl, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super String> dVar) {
        return ((BookContent$analyzeContent$3$asyncArray$1$1) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        String str;
        Object strResponse$default;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            f.E5(obj);
            String str2 = this.$contentData.element.getNextUrl().get(this.$tmp);
            str = str2;
            AnalyzeUrl analyzeUrl = new AnalyzeUrl(str, null, null, null, null, null, false, this.$book, null, null, this.$bookSource.getHeaderMap(), 894, null);
            String bookSourceUrl = this.$bookSource.getBookSourceUrl();
            this.L$0 = str2;
            this.label = 1;
            strResponse$default = AnalyzeUrl.getStrResponse$default(analyzeUrl, bookSourceUrl, null, null, this, 6, null);
            if (strResponse$default == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str3 = (String) this.L$0;
            f.E5(obj);
            str = str3;
            strResponse$default = obj;
        }
        l lVar = (l) strResponse$default;
        BookContent bookContent = BookContent.INSTANCE;
        Book book = this.$book;
        String strA = lVar.a();
        String str4 = lVar.f5588b;
        j.c(str4);
        return bookContent.analyzeContent(book, str, strA, str4, this.$contentRule, this.$bookChapter, this.$bookSource, this.$mNextChapterUrl, false).getContent();
    }
}
