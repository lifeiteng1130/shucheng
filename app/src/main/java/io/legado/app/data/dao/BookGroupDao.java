package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.view.LiveData;
import io.legado.app.data.entities.BookGroup;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookGroupDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f0\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f0\u000bH'¢\u0006\u0004\b\u000f\u0010\u000eJ\u001b\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f0\u000bH'¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H'¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\u00020\u00122\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0017\"\u00020\u0004H'¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001b\u001a\u00020\u00122\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0017\"\u00020\u0004H'¢\u0006\u0004\b\u001b\u0010\u001aJ#\u0010\u001c\u001a\u00020\u00122\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0017\"\u00020\u0004H'¢\u0006\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00028g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\f8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lio/legado/app/data/dao/BookGroupDao;", "", "", "id", "Lio/legado/app/data/entities/BookGroup;", "getByID", "(J)Lio/legado/app/data/entities/BookGroup;", "", "groupName", "getByName", "(Ljava/lang/String;)Lio/legado/app/data/entities/BookGroup;", "Landroidx/lifecycle/LiveData;", "", "liveDataAll", "()Landroidx/lifecycle/LiveData;", "liveDataShow", "liveDataSelect", "groupId", "Lf/v;", "enableGroup", "(J)V", "getGroupNames", "(J)Ljava/util/List;", "", "bookGroup", "insert", "([Lio/legado/app/data/entities/BookGroup;)V", "update", "delete", "getIdsSum", "()J", "idsSum", "", "getMaxOrder", "()I", "maxOrder", "getAll", "()Ljava/util/List;", "all", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface BookGroupDao {
    @Delete
    void delete(@NotNull BookGroup... bookGroup);

    @Query("update book_groups set show = 1 where groupId = :groupId")
    void enableGroup(long groupId);

    @Query("SELECT * FROM book_groups ORDER BY `order`")
    @NotNull
    List<BookGroup> getAll();

    @Query("select * from book_groups where groupId = :id")
    @Nullable
    BookGroup getByID(long id);

    @Query("select * from book_groups where groupName = :groupName")
    @Nullable
    BookGroup getByName(@NotNull String groupName);

    @Query("select groupName from book_groups where groupId > 0 and (groupId & :id) > 0")
    @NotNull
    List<String> getGroupNames(long id);

    @Query("SELECT sum(groupId) FROM book_groups where groupId >= 0")
    long getIdsSum();

    @Query("SELECT MAX(`order`) FROM book_groups where groupId >= 0")
    int getMaxOrder();

    @Insert(onConflict = 1)
    void insert(@NotNull BookGroup... bookGroup);

    @Query("SELECT * FROM book_groups ORDER BY `order`")
    @NotNull
    LiveData<List<BookGroup>> liveDataAll();

    @Query("SELECT * FROM book_groups where groupId >= 0 ORDER BY `order`")
    @NotNull
    LiveData<List<BookGroup>> liveDataSelect();

    @Query("\n        SELECT * FROM book_groups where (groupId >= 0 and show > 0)\n        or (groupId = -4 and show > 0 and (select count(bookUrl) from books where type != 1 and origin != 'loc_book' and ((SELECT sum(groupId) FROM book_groups where groupId > 0) & `group`) = 0) > 0)\n        or (groupId = -3 and show > 0 and (select count(bookUrl) from books where type = 1) > 0)\n        or (groupId = -2 and show > 0 and (select count(bookUrl) from books where origin = 'loc_book') > 0)\n        or (groupId = -1 and show > 0)\n        ORDER BY `order`\n    ")
    @NotNull
    LiveData<List<BookGroup>> liveDataShow();

    @Update
    void update(@NotNull BookGroup... bookGroup);
}
