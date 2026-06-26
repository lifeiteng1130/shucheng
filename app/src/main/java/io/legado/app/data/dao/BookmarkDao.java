package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.view.LiveData;
import io.legado.app.data.entities.Bookmark;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookmarkDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\nJ+\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000e\"\u00020\bH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\bH'¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00102\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000e\"\u00020\bH'¢\u0006\u0004\b\u0015\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H'¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lio/legado/app/data/dao/BookmarkDao;", "", "", "bookUrl", "bookName", "bookAuthor", "Landroidx/lifecycle/LiveData;", "", "Lio/legado/app/data/entities/Bookmark;", "observeByBook", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "key", "liveDataSearch", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "bookmark", "Lf/v;", "insert", "([Lio/legado/app/data/entities/Bookmark;)V", "update", "(Lio/legado/app/data/entities/Bookmark;)V", "delete", "chapterName", "delByBookmark", "(Ljava/lang/String;Ljava/lang/String;)V", "getAll", "()Ljava/util/List;", "all", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface BookmarkDao {
    @Query("delete from bookmarks where bookUrl = :bookUrl and chapterName like '%'||:chapterName||'%'")
    void delByBookmark(@NotNull String bookUrl, @NotNull String chapterName);

    @Delete
    void delete(@NotNull Bookmark... bookmark);

    @Query("select * from bookmarks")
    @NotNull
    List<Bookmark> getAll();

    @Insert(onConflict = 1)
    void insert(@NotNull Bookmark... bookmark);

    @Query("SELECT * FROM bookmarks where bookUrl = :bookUrl and chapterName like '%'||:key||'%' or content like '%'||:key||'%'")
    @NotNull
    LiveData<List<Bookmark>> liveDataSearch(@NotNull String bookUrl, @NotNull String key);

    @Query("select * from bookmarks where bookUrl = :bookUrl or (bookName = :bookName and bookAuthor = :bookAuthor)")
    @NotNull
    LiveData<List<Bookmark>> observeByBook(@NotNull String bookUrl, @NotNull String bookName, @NotNull String bookAuthor);

    @Update
    void update(@NotNull Bookmark bookmark);
}
