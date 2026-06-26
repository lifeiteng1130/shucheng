package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.legado.app.data.entities.SearchBook;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchBookDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\nJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\u0010J%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0013\"\u00020\u0004H'¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H'¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/legado/app/data/dao/SearchBookDao;", "", "", "bookUrl", "Lio/legado/app/data/entities/SearchBook;", "getSearchBook", "(Ljava/lang/String;)Lio/legado/app/data/entities/SearchBook;", "name", "author", "getFirstByNameAuthor", "(Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/SearchBook;", "sourceGroup", "", "getChangeSourceSearch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "getEnableHasCover", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "", "searchBook", "", "insert", "([Lio/legado/app/data/entities/SearchBook;)Ljava/util/List;", "Lf/v;", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "time", "clearExpired", "(J)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface SearchBookDao {
    @Query("delete from searchBooks where name = :name and author = :author")
    void clear(@NotNull String name, @NotNull String author);

    @Query("delete from searchBooks where time < :time")
    void clearExpired(long time);

    @Query("\n        select t1.name, t1.author, t1.origin, t1.originName, t1.coverUrl, t1.bookUrl, t1.type, t1.time, t1.intro, t1.kind, t1.latestChapterTitle, t1.tocUrl, t1.variable, t1.wordCount, t2.customOrder as originOrder\n        from searchBooks as t1 inner join book_sources as t2 \n        on t1.origin = t2.bookSourceUrl \n        where t1.name = :name and t1.author like '%'||:author||'%' and t2.enabled = 1 and t2.bookSourceGroup like '%'||:sourceGroup||'%'\n        order by t2.customOrder\n        ")
    @NotNull
    List<SearchBook> getChangeSourceSearch(@NotNull String name, @NotNull String author, @NotNull String sourceGroup);

    @Query("\n        select t1.name, t1.author, t1.origin, t1.originName, t1.coverUrl, t1.bookUrl, t1.type, t1.time, t1.intro, t1.kind, t1.latestChapterTitle, t1.tocUrl, t1.variable, t1.wordCount, t2.customOrder as originOrder\n        from searchBooks as t1 inner join book_sources as t2 \n        on t1.origin = t2.bookSourceUrl \n        where t1.name = :name and t1.author = :author and originName like '%'||:key||'%' and t2.enabled = 1 and t2.bookSourceGroup like '%'||:sourceGroup||'%'\n        order by t2.customOrder\n        ")
    @NotNull
    List<SearchBook> getChangeSourceSearch(@NotNull String name, @NotNull String author, @NotNull String key, @NotNull String sourceGroup);

    @Query("\n        select t1.name, t1.author, t1.origin, t1.originName, t1.coverUrl, t1.bookUrl, t1.type, t1.time, t1.intro, t1.kind, t1.latestChapterTitle, t1.tocUrl, t1.variable, t1.wordCount, t2.customOrder as originOrder\n        from searchBooks as t1 inner join book_sources as t2 \n        on t1.origin = t2.bookSourceUrl \n        where t1.name = :name and t1.author = :author and t1.coverUrl is not null and t1.coverUrl <> '' and t2.enabled = 1\n        order by t2.customOrder\n        ")
    @NotNull
    List<SearchBook> getEnableHasCover(@NotNull String name, @NotNull String author);

    @Query("select * from searchBooks where name = :name and author = :author and origin in (select bookSourceUrl from book_sources) order by originOrder limit 1")
    @Nullable
    SearchBook getFirstByNameAuthor(@NotNull String name, @NotNull String author);

    @Query("select * from searchBooks where bookUrl = :bookUrl")
    @Nullable
    SearchBook getSearchBook(@NotNull String bookUrl);

    @Insert(onConflict = 1)
    @NotNull
    List<Long> insert(@NotNull SearchBook... searchBook);
}
