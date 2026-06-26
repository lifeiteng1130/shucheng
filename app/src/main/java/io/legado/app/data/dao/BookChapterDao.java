package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.view.LiveData;
import io.legado.app.data.entities.BookChapter;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookChapterDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\rJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH'¢\u0006\u0004\b\f\u0010\u0011J!\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH'¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H'¢\u0006\u0004\b\u0013\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0019\"\u00020\u0006H'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/legado/app/data/dao/BookChapterDao;", "", "", "bookUrl", "Landroidx/lifecycle/LiveData;", "", "Lio/legado/app/data/entities/BookChapter;", "observeByBook", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "key", "liveDataSearch", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "getChapterList", "(Ljava/lang/String;)Ljava/util/List;", "", "start", "end", "(Ljava/lang/String;II)Ljava/util/List;", "index", "getChapter", "(Ljava/lang/String;I)Lio/legado/app/data/entities/BookChapter;", "title", "(Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/BookChapter;", "getChapterCount", "(Ljava/lang/String;)I", "", "bookChapter", "Lf/v;", "insert", "([Lio/legado/app/data/entities/BookChapter;)V", "delByBook", "(Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface BookChapterDao {
    @Query("delete from chapters where bookUrl = :bookUrl")
    void delByBook(@NotNull String bookUrl);

    @Query("select * from chapters where bookUrl = :bookUrl and `index` = :index")
    @Nullable
    BookChapter getChapter(@NotNull String bookUrl, int index);

    @Query("select * from chapters where bookUrl = :bookUrl and `title` = :title")
    @Nullable
    BookChapter getChapter(@NotNull String bookUrl, @NotNull String title);

    @Query("select count(url) from chapters where bookUrl = :bookUrl")
    int getChapterCount(@NotNull String bookUrl);

    @Query("select * from chapters where bookUrl = :bookUrl order by `index`")
    @NotNull
    List<BookChapter> getChapterList(@NotNull String bookUrl);

    @Query("select * from chapters where bookUrl = :bookUrl and `index` >= :start and `index` <= :end order by `index`")
    @NotNull
    List<BookChapter> getChapterList(@NotNull String bookUrl, int start, int end);

    @Insert(onConflict = 1)
    void insert(@NotNull BookChapter... bookChapter);

    @Query("SELECT * FROM chapters where bookUrl = :bookUrl and title like '%'||:key||'%' order by `index`")
    @NotNull
    LiveData<List<BookChapter>> liveDataSearch(@NotNull String bookUrl, @NotNull String key);

    @Query("select * from chapters where bookUrl = :bookUrl order by `index`")
    @NotNull
    LiveData<List<BookChapter>> observeByBook(@NotNull String bookUrl);
}
