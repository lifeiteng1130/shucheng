package e.a.a.d.w;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.Predicate;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookDao;
import io.legado.app.data.dao.BookSourceDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookSource;
import io.legado.app.help.storage.OldRule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: ImportOldData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final int a(String str) {
        f.c0.c.j.e(str, "json");
        ArrayList arrayList = new ArrayList();
        Object obj = q.a.b().parse(str).read("$", new Predicate[0]);
        f.c0.c.j.d(obj, "Restore.jsonPath.parse(json).read(\"$\")");
        Set setK = f.x.e.K(AppDatabaseKt.getAppDb().getBookDao().getAllBookUrls());
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            DocumentContext documentContext = q.a.b().parse((Map) it.next());
            Book book = new Book(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0L, null, 0L, 0L, 0, 0, null, 0, 0, 0L, null, false, 0, 0, null, null, 1073741823, null);
            f.c0.c.j.d(documentContext, "jsonItem");
            String strA4 = c.b.a.m.f.A4(documentContext, "$.noteUrl");
            if (strA4 == null) {
                strA4 = "";
            }
            book.setBookUrl(strA4);
            if (!f.h0.k.s(book.getBookUrl())) {
                String strA42 = c.b.a.m.f.A4(documentContext, "$.bookInfoBean.name");
                if (strA42 == null) {
                    strA42 = "";
                }
                book.setName(strA42);
                if (setK.contains(book.getBookUrl())) {
                    f.c0.c.j.k("Found existing book: ", book.getName());
                } else {
                    String strA43 = c.b.a.m.f.A4(documentContext, "$.tag");
                    if (strA43 == null) {
                        strA43 = "";
                    }
                    book.setOrigin(strA43);
                    String strA44 = c.b.a.m.f.A4(documentContext, "$.bookInfoBean.origin");
                    if (strA44 == null) {
                        strA44 = "";
                    }
                    book.setOriginName(strA44);
                    String strA45 = c.b.a.m.f.A4(documentContext, "$.bookInfoBean.author");
                    book.setAuthor(strA45 != null ? strA45 : "");
                    book.setType(f.c0.c.j.a(c.b.a.m.f.A4(documentContext, "$.bookInfoBean.bookSourceType"), "AUDIO") ? 1 : 0);
                    String strA46 = c.b.a.m.f.A4(documentContext, "$.bookInfoBean.chapterUrl");
                    if (strA46 == null) {
                        strA46 = book.getBookUrl();
                    }
                    book.setTocUrl(strA46);
                    book.setCoverUrl(c.b.a.m.f.A4(documentContext, "$.bookInfoBean.coverUrl"));
                    book.setCustomCoverUrl(c.b.a.m.f.A4(documentContext, "$.customCoverPath"));
                    Long lZ4 = c.b.a.m.f.z4(documentContext, "$.bookInfoBean.finalRefreshData");
                    book.setLastCheckTime(lZ4 == null ? 0L : lZ4.longValue());
                    Boolean boolU4 = c.b.a.m.f.u4(documentContext, "$.allowUpdate");
                    Boolean bool = Boolean.TRUE;
                    book.setCanUpdate(f.c0.c.j.a(boolU4, bool));
                    Integer numY4 = c.b.a.m.f.y4(documentContext, "$.chapterListSize");
                    book.setTotalChapterNum(numY4 == null ? 0 : numY4.intValue());
                    Integer numY42 = c.b.a.m.f.y4(documentContext, "$.durChapter");
                    book.setDurChapterIndex(numY42 == null ? 0 : numY42.intValue());
                    book.setDurChapterTitle(c.b.a.m.f.A4(documentContext, "$.durChapterName"));
                    Integer numY43 = c.b.a.m.f.y4(documentContext, "$.durChapterPage");
                    book.setDurChapterPos(numY43 == null ? 0 : numY43.intValue());
                    Long lZ42 = c.b.a.m.f.z4(documentContext, "$.finalDate");
                    book.setDurChapterTime(lZ42 != null ? lZ42.longValue() : 0L);
                    book.setIntro(c.b.a.m.f.A4(documentContext, "$.bookInfoBean.introduce"));
                    book.setLatestChapterTitle(c.b.a.m.f.A4(documentContext, "$.lastChapterName"));
                    Integer numY44 = c.b.a.m.f.y4(documentContext, "$.newChapters");
                    book.setLastCheckCount(numY44 == null ? 0 : numY44.intValue());
                    Integer numY45 = c.b.a.m.f.y4(documentContext, "$.serialNumber");
                    book.setOrder(numY45 == null ? 0 : numY45.intValue());
                    book.setVariable(c.b.a.m.f.A4(documentContext, "$.variable"));
                    book.setUseReplaceRule(f.c0.c.j.a(c.b.a.m.f.u4(documentContext, "$.useReplaceRule"), bool));
                    arrayList.add(book);
                }
            }
        }
        BookDao bookDao = AppDatabaseKt.getAppDb().getBookDao();
        Object[] array = arrayList.toArray(new Book[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Book[] bookArr = (Book[]) array;
        bookDao.insert((Book[]) Arrays.copyOf(bookArr, bookArr.length));
        return arrayList.size();
    }

    public static final int b(String str) {
        ArrayList arrayList = new ArrayList();
        Object obj = q.a.b().parse(str).read("$", new Predicate[0]);
        f.c0.c.j.d(obj, "Restore.jsonPath.parse(json).read(\"$\")");
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            DocumentContext documentContext = q.a.b().parse((Map) it.next());
            OldRule oldRule = OldRule.a;
            String strJsonString = documentContext.jsonString();
            f.c0.c.j.d(strJsonString, "jsonItem.jsonString()");
            arrayList.add(oldRule.a(strJsonString));
        }
        BookSourceDao bookSourceDao = AppDatabaseKt.getAppDb().getBookSourceDao();
        Object[] array = arrayList.toArray(new BookSource[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        BookSource[] bookSourceArr = (BookSource[]) array;
        bookSourceDao.insert((BookSource[]) Arrays.copyOf(bookSourceArr, bookSourceArr.length));
        return arrayList.size();
    }
}
