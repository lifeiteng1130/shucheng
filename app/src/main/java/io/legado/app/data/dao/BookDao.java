package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.view.LiveData;
import io.legado.app.data.entities.Book;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001b\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0007\u0010\u0006J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\b\u0010\u0006J\u001b\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\t\u0010\u0006J\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u0002H'¢\u0006\u0004\b\u000b\u0010\u0006J#\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0010\u001a\u00020\nH'¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0015\"\u00020\nH'¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\nH'¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH'¢\u0006\u0004\b\u001a\u0010\u001eJ#\u0010!\u001a\u00020 2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0015\"\u00020\u0004H'¢\u0006\u0004\b!\u0010\"J#\u0010#\u001a\u00020 2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0015\"\u00020\u0004H'¢\u0006\u0004\b#\u0010\"J#\u0010$\u001a\u00020 2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0015\"\u00020\u0004H'¢\u0006\u0004\b$\u0010\"J\u001f\u0010'\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H'¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020 2\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\fH'¢\u0006\u0004\b+\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00102\u001a\u00020%8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00104\u001a\u00020%8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00101R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010.R\u0018\u00109\u001a\u0004\u0018\u00010\u00048g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0016\u0010;\u001a\u00020%8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u00101R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010.R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010.¨\u0006@"}, d2 = {"Lio/legado/app/data/dao/BookDao;", "", "Landroidx/lifecycle/LiveData;", "", "Lio/legado/app/data/entities/Book;", "observeAll", "()Landroidx/lifecycle/LiveData;", "observeAudio", "observeLocal", "observeNoGroup", "", "observeLocalUri", "", "group", "observeByGroup", "(J)Landroidx/lifecycle/LiveData;", "key", "liveDataSearch", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "getBooksByGroup", "(J)Ljava/util/List;", "", "names", "findByName", "([Ljava/lang/String;)Ljava/util/List;", "bookUrl", "getBook", "(Ljava/lang/String;)Lio/legado/app/data/entities/Book;", "name", "author", "(Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/Book;", "book", "Lf/v;", "insert", "([Lio/legado/app/data/entities/Book;)V", "update", "delete", "", "pos", "upProgress", "(Ljava/lang/String;I)V", "oldGroupId", "newGroupId", "upGroup", "(JJ)V", "getAllBookUrls", "()Ljava/util/List;", "allBookUrls", "getMaxOrder", "()I", "maxOrder", "getNoGroupSize", "noGroupSize", "getHasUpdateBooks", "hasUpdateBooks", "getLastReadBook", "()Lio/legado/app/data/entities/Book;", "lastReadBook", "getAllBookCount", "allBookCount", "getWebBooks", "webBooks", "getAll", "all", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface BookDao {
    @Delete
    void delete(@NotNull Book... book);

    @Query("SELECT * FROM books WHERE `name` in (:names)")
    @NotNull
    List<Book> findByName(@NotNull String... names);

    @Query("SELECT * FROM books")
    @NotNull
    List<Book> getAll();

    @Query("SELECT COUNT(*) FROM books")
    int getAllBookCount();

    @Query("SELECT bookUrl FROM books")
    @NotNull
    List<String> getAllBookUrls();

    @Query("SELECT * FROM books WHERE bookUrl = :bookUrl")
    @Nullable
    Book getBook(@NotNull String bookUrl);

    @Query("SELECT * FROM books WHERE name = :name and author = :author")
    @Nullable
    Book getBook(@NotNull String name, @NotNull String author);

    @Query("SELECT * FROM books WHERE (`group` & :group) > 0")
    @NotNull
    List<Book> getBooksByGroup(long group);

    @Query("SELECT * FROM books where origin <> 'loc_book' and canUpdate = 1")
    @NotNull
    List<Book> getHasUpdateBooks();

    @Query("SELECT * FROM books where type = 0 ORDER BY durChapterTime DESC limit 1")
    @Nullable
    Book getLastReadBook();

    @Query("select max(`order`) from books")
    int getMaxOrder();

    @Query("select count(bookUrl) from books where (SELECT sum(groupId) FROM book_groups) & `group` = 0")
    int getNoGroupSize();

    @Query("SELECT * FROM books where origin <> 'loc_book' and type = 0")
    @NotNull
    List<Book> getWebBooks();

    @Insert(onConflict = 1)
    void insert(@NotNull Book... book);

    @Query("SELECT * FROM books WHERE name like '%'||:key||'%' or author like '%'||:key||'%'")
    @NotNull
    LiveData<List<Book>> liveDataSearch(@NotNull String key);

    @Query("SELECT * FROM books order by durChapterTime desc")
    @NotNull
    LiveData<List<Book>> observeAll();

    @Query("SELECT * FROM books WHERE type = 1")
    @NotNull
    LiveData<List<Book>> observeAudio();

    @Query("SELECT * FROM books WHERE (`group` & :group) > 0")
    @NotNull
    LiveData<List<Book>> observeByGroup(long group);

    @Query("SELECT * FROM books WHERE origin = 'loc_book'")
    @NotNull
    LiveData<List<Book>> observeLocal();

    @Query("SELECT bookUrl FROM books WHERE origin = 'loc_book'")
    @NotNull
    LiveData<List<String>> observeLocalUri();

    @Query("select * from books where type != 1 and origin != 'loc_book' and ((SELECT sum(groupId) FROM book_groups where groupId > 0) & `group`) = 0")
    @NotNull
    LiveData<List<Book>> observeNoGroup();

    @Query("update books set `group` = :newGroupId where `group` = :oldGroupId")
    void upGroup(long oldGroupId, long newGroupId);

    @Query("update books set durChapterPos = :pos where bookUrl = :bookUrl")
    void upProgress(@NotNull String bookUrl, int pos);

    @Update
    void update(@NotNull Book... book);
}
