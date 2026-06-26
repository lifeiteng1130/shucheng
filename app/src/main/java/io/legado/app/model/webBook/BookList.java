package io.legado.app.model.webBook;

import c.b.a.m.f;
import e.a.a.d.g;
import e.a.a.h.b0;
import e.a.a.h.q;
import e.a.a.h.x;
import f.c0.c.j;
import f.h0.k;
import f.x.e;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.data.entities.rule.BookListRule;
import io.legado.app.model.Debug;
import io.legado.app.model.analyzeRule.AnalyzeRule;
import io.legado.app.model.analyzeRule.AnalyzeUrl;
import io.wenyuange.app.release.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* JADX INFO: compiled from: BookList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010'JC\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJÛ\u0001\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0013R\u00020\u00060\u00122\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0013R\u00020\u00060\u00122\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0013R\u00020\u00060\u00122\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0013R\u00020\u00060\u00122\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0013R\u00020\u00060\u00122\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0013R\u00020\u00060\u00122\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0013R\u00020\u00060\u00122\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0013R\u00020\u00060\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJY\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\f0\"j\b\u0012\u0004\u0012\u00020\f`#2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\u0010¢\u0006\u0004\b$\u0010%¨\u0006("}, d2 = {"Lio/legado/app/model/webBook/BookList;", "", "Lg/b/a0;", "scope", "", "body", "Lio/legado/app/model/analyzeRule/AnalyzeRule;", "analyzeRule", "Lio/legado/app/data/entities/BookSource;", "bookSource", "baseUrl", "variable", "Lio/legado/app/data/entities/SearchBook;", "getInfoItem", "(Lg/b/a0;Ljava/lang/String;Lio/legado/app/model/analyzeRule/AnalyzeRule;Lio/legado/app/data/entities/BookSource;Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/SearchBook;", "item", "", "log", "", "Lio/legado/app/model/analyzeRule/AnalyzeRule$SourceRule;", "ruleName", "ruleBookUrl", "ruleAuthor", "ruleKind", "ruleCoverUrl", "ruleWordCount", "ruleIntro", "ruleLastChapter", "getSearchItem", "(Lg/b/a0;Ljava/lang/Object;Lio/legado/app/model/analyzeRule/AnalyzeRule;Lio/legado/app/data/entities/BookSource;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lio/legado/app/data/entities/SearchBook;", "Lio/legado/app/model/analyzeRule/AnalyzeUrl;", "analyzeUrl", "variableBook", "isSearch", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "analyzeBookList", "(Lg/b/a0;Ljava/lang/String;Lio/legado/app/data/entities/BookSource;Lio/legado/app/model/analyzeRule/AnalyzeUrl;Ljava/lang/String;Lio/legado/app/data/entities/SearchBook;Z)Ljava/util/ArrayList;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookList {

    @NotNull
    public static final BookList INSTANCE = new BookList();

    private BookList() {
    }

    private final SearchBook getInfoItem(a0 scope, String body, AnalyzeRule analyzeRule, BookSource bookSource, String baseUrl, String variable) throws IOException {
        Book book = new Book(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0L, null, 0L, 0L, 0, 0, null, 0, 0, 0L, null, false, 0, 0, variable, null, 805306367, null);
        book.setBookUrl(baseUrl);
        book.setOrigin(bookSource.getBookSourceUrl());
        book.setOriginName(bookSource.getBookSourceName());
        book.setOriginOrder(bookSource.getCustomOrder());
        book.setType(bookSource.getBookSourceType());
        analyzeRule.setBook(book);
        BookInfo.INSTANCE.analyzeBookInfo(scope, book, body, analyzeRule, bookSource, baseUrl, baseUrl, false);
        if (!k.s(book.getName())) {
            return book.toSearchBook();
        }
        return null;
    }

    private final SearchBook getSearchItem(a0 scope, Object item, AnalyzeRule analyzeRule, BookSource bookSource, String baseUrl, String variable, boolean log, List<AnalyzeRule.SourceRule> ruleName, List<AnalyzeRule.SourceRule> ruleBookUrl, List<AnalyzeRule.SourceRule> ruleAuthor, List<AnalyzeRule.SourceRule> ruleKind, List<AnalyzeRule.SourceRule> ruleCoverUrl, List<AnalyzeRule.SourceRule> ruleWordCount, List<AnalyzeRule.SourceRule> ruleIntro, List<AnalyzeRule.SourceRule> ruleLastChapter) {
        SearchBook searchBook = new SearchBook(null, null, null, 0, null, null, null, null, null, null, null, null, 0L, variable, 0, 24575, null);
        searchBook.setOrigin(bookSource.getBookSourceUrl());
        searchBook.setOriginName(bookSource.getBookSourceName());
        searchBook.setType(bookSource.getBookSourceType());
        searchBook.setOriginOrder(bookSource.getCustomOrder());
        analyzeRule.setBook(searchBook);
        SearchBook searchBook2 = null;
        AnalyzeRule.setContent$default(analyzeRule, item, null, 2, null);
        f.B1(scope);
        Debug debug = Debug.INSTANCE;
        Debug.log$default(debug, bookSource.getBookSourceUrl(), "┌获取书名", log, false, false, 0, 56, null);
        g gVar = g.a;
        searchBook.setName(gVar.b(AnalyzeRule.getString$default(analyzeRule, (List) ruleName, false, (String) null, 6, (Object) null)));
        Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("└", searchBook.getName()), log, false, false, 0, 56, null);
        if (searchBook.getName().length() > 0) {
            f.B1(scope);
            Debug.log$default(debug, bookSource.getBookSourceUrl(), "┌获取作者", log, false, false, 0, 56, null);
            searchBook.setAuthor(gVar.a(AnalyzeRule.getString$default(analyzeRule, (List) ruleAuthor, false, (String) null, 6, (Object) null)));
            Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("└", searchBook.getAuthor()), log, false, false, 0, 56, null);
            f.B1(scope);
            Debug.log$default(debug, bookSource.getBookSourceUrl(), "┌获取分类", log, false, false, 0, 56, null);
            List stringList$default = AnalyzeRule.getStringList$default(analyzeRule, (List) ruleKind, false, 2, (Object) null);
            searchBook.setKind(stringList$default != null ? e.q(stringList$default, ",", null, null, 0, null, null, 62) : null);
            Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("└", searchBook.getKind()), log, false, false, 0, 56, null);
            f.B1(scope);
            Debug.log$default(debug, bookSource.getBookSourceUrl(), "┌获取字数", log, false, false, 0, 56, null);
            searchBook.setWordCount(b0.a.c(AnalyzeRule.getString$default(analyzeRule, (List) ruleWordCount, false, (String) null, 6, (Object) null)));
            Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("└", searchBook.getWordCount()), log, false, false, 0, 56, null);
            f.B1(scope);
            Debug.log$default(debug, bookSource.getBookSourceUrl(), "┌获取最新章节", log, false, false, 0, 56, null);
            searchBook.setLatestChapterTitle(AnalyzeRule.getString$default(analyzeRule, (List) ruleLastChapter, false, (String) null, 6, (Object) null));
            Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("└", searchBook.getLatestChapterTitle()), log, false, false, 0, 56, null);
            f.B1(scope);
            Debug.log$default(debug, bookSource.getBookSourceUrl(), "┌获取简介", log, false, false, 0, 56, null);
            q qVar = q.a;
            searchBook.setIntro(q.a(AnalyzeRule.getString$default(analyzeRule, (List) ruleIntro, false, (String) null, 6, (Object) null)));
            Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("└", searchBook.getIntro()), log, false, false, 0, 56, null);
            f.B1(scope);
            Debug.log$default(debug, bookSource.getBookSourceUrl(), "┌获取封面链接", log, false, false, 0, 56, null);
            searchBook2 = searchBook;
            String string$default = AnalyzeRule.getString$default(analyzeRule, (List) ruleCoverUrl, false, (String) null, 6, (Object) null);
            if (string$default.length() > 0) {
                x xVar = x.a;
                searchBook2.setCoverUrl(x.a(baseUrl, string$default));
            }
            Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("└", searchBook2.getCoverUrl()), log, false, false, 0, 56, null);
            f.B1(scope);
            Debug.log$default(debug, bookSource.getBookSourceUrl(), "┌获取详情页链接", log, false, false, 0, 56, null);
            searchBook2.setBookUrl(AnalyzeRule.getString$default(analyzeRule, (List) ruleBookUrl, true, (String) null, 4, (Object) null));
            if (searchBook2.getBookUrl().length() == 0) {
                searchBook2.setBookUrl(baseUrl);
            }
            Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("└", searchBook2.getBookUrl()), log, false, false, 0, 56, null);
        }
        return searchBook2;
    }

    @NotNull
    public final ArrayList<SearchBook> analyzeBookList(@NotNull a0 scope, @Nullable String body, @NotNull BookSource bookSource, @NotNull AnalyzeUrl analyzeUrl, @NotNull String baseUrl, @NotNull SearchBook variableBook, boolean isSearch) throws Exception {
        BookListRule searchRule;
        int i2;
        boolean z;
        String str = baseUrl;
        j.e(scope, "scope");
        j.e(bookSource, "bookSource");
        j.e(analyzeUrl, "analyzeUrl");
        j.e(str, "baseUrl");
        j.e(variableBook, "variableBook");
        ArrayList<SearchBook> arrayList = new ArrayList<>();
        if (body == null) {
            throw new Exception(h.g().getString(R.string.error_get_web_content, analyzeUrl.getRuleUrl()));
        }
        Debug debug = Debug.INSTANCE;
        Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("≡获取成功:", analyzeUrl.getRuleUrl()), false, false, false, 0, 60, null);
        Debug.log$default(debug, bookSource.getBookSourceUrl(), body, false, false, false, 10, 28, null);
        AnalyzeRule analyzeRule = new AnalyzeRule(variableBook);
        AnalyzeRule.setContent$default(analyzeRule, body, null, 2, null).setBaseUrl(str);
        analyzeRule.setRedirectUrl(str);
        String bookUrlPattern = bookSource.getBookUrlPattern();
        if (bookUrlPattern != null) {
            f.B1(scope);
            if (new f.h0.g(bookUrlPattern).matches(str)) {
                Debug.log$default(debug, bookSource.getBookSourceUrl(), "≡链接为详情页", false, false, false, 0, 60, null);
                SearchBook infoItem = INSTANCE.getInfoItem(scope, body, analyzeRule, bookSource, baseUrl, variableBook.getVariable());
                if (infoItem != null) {
                    infoItem.setInfoHtml(body);
                    arrayList.add(infoItem);
                }
                return arrayList;
            }
        }
        if (isSearch) {
            searchRule = bookSource.getSearchRule();
        } else {
            String bookList = bookSource.getExploreRule().getBookList();
            searchRule = bookList == null || k.s(bookList) ? bookSource.getSearchRule() : bookSource.getExploreRule();
        }
        String bookList2 = searchRule.getBookList();
        if (bookList2 == null) {
            bookList2 = "";
        }
        if (k.K(bookList2, "-", false, 2)) {
            i2 = 1;
            bookList2 = bookList2.substring(1);
            j.d(bookList2, "(this as java.lang.String).substring(startIndex)");
            z = true;
        } else {
            i2 = 1;
            z = false;
        }
        if (k.K(bookList2, Marker.ANY_NON_NULL_MARKER, false, 2)) {
            bookList2 = bookList2.substring(i2);
            j.d(bookList2, "(this as java.lang.String).substring(startIndex)");
        }
        Debug.log$default(debug, bookSource.getBookSourceUrl(), "┌获取书籍列表", false, false, false, 0, 60, null);
        List<Object> elements = analyzeRule.getElements(bookList2);
        f.B1(scope);
        if (elements.isEmpty()) {
            String bookUrlPattern2 = bookSource.getBookUrlPattern();
            if (bookUrlPattern2 == null || bookUrlPattern2.length() == 0) {
                Debug.log$default(debug, bookSource.getBookSourceUrl(), "└列表为空,按详情页解析", false, false, false, 0, 60, null);
                SearchBook infoItem2 = getInfoItem(scope, body, analyzeRule, bookSource, baseUrl, variableBook.getVariable());
                if (infoItem2 != null) {
                    infoItem2.setInfoHtml(body);
                    arrayList.add(infoItem2);
                }
                return arrayList;
            }
        }
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default = AnalyzeRule.splitSourceRule$default(analyzeRule, searchRule.getName(), null, 2, null);
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default2 = AnalyzeRule.splitSourceRule$default(analyzeRule, searchRule.getBookUrl(), null, 2, null);
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default3 = AnalyzeRule.splitSourceRule$default(analyzeRule, searchRule.getAuthor(), null, 2, null);
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default4 = AnalyzeRule.splitSourceRule$default(analyzeRule, searchRule.getCoverUrl(), null, 2, null);
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default5 = AnalyzeRule.splitSourceRule$default(analyzeRule, searchRule.getIntro(), null, 2, null);
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default6 = AnalyzeRule.splitSourceRule$default(analyzeRule, searchRule.getKind(), null, 2, null);
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default7 = AnalyzeRule.splitSourceRule$default(analyzeRule, searchRule.getLastChapter(), null, 2, null);
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default8 = AnalyzeRule.splitSourceRule$default(analyzeRule, searchRule.getWordCount(), null, 2, null);
        Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("└列表大小:", Integer.valueOf(elements.size())), false, false, false, 0, 60, null);
        int i3 = 0;
        for (Object obj : elements) {
            int i4 = i3 + 1;
            String variable = variableBook.getVariable();
            boolean z2 = i3 == 0;
            ArrayList<SearchBook> arrayList2 = arrayList;
            String str2 = str;
            SearchBook searchItem = getSearchItem(scope, obj, analyzeRule, bookSource, baseUrl, variable, z2, listSplitSourceRule$default, listSplitSourceRule$default2, listSplitSourceRule$default3, listSplitSourceRule$default6, listSplitSourceRule$default4, listSplitSourceRule$default8, listSplitSourceRule$default5, listSplitSourceRule$default7);
            if (searchItem != null) {
                if (j.a(str2, searchItem.getBookUrl())) {
                    searchItem.setInfoHtml(body);
                }
                arrayList2.add(searchItem);
            }
            arrayList = arrayList2;
            i3 = i4;
            str = str2;
        }
        ArrayList<SearchBook> arrayList3 = arrayList;
        if (!z) {
            return arrayList3;
        }
        f.P4(arrayList3);
        return arrayList3;
    }
}
