package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.view.LiveData;
import io.legado.app.data.entities.BookSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u000b\u0010\nJ\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\f\u0010\u0006J\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\r\u0010\u0006J\u001b\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u000e\u0010\u0006J#\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u0007H'¢\u0006\u0004\b\u000e\u0010\nJ#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u0007H'¢\u0006\u0004\b\u0010\u0010\nJ\u001b\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0002H'¢\u0006\u0004\b\u0011\u0010\u0006J\u001b\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0002H'¢\u0006\u0004\b\u0012\u0010\u0006J\u001b\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0002H'¢\u0006\u0004\b\u0013\u0010\u0006J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001a\u00020\u0007H'¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001a\u00020\u0007H'¢\u0006\u0004\b\u0017\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0007H'¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010 \u001a\u00020\u001f2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001d\"\u00020\u0004H'¢\u0006\u0004\b \u0010!J#\u0010\"\u001a\u00020\u001f2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001d\"\u00020\u0004H'¢\u0006\u0004\b\"\u0010!J#\u0010#\u001a\u00020\u001f2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001d\"\u00020\u0004H'¢\u0006\u0004\b#\u0010!J\u0017\u0010#\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u0007H'¢\u0006\u0004\b#\u0010$R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u001a8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001cR\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010&R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010&R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010&R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010&R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010&R\u0016\u00105\u001a\u00020\u001a8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u001c¨\u00066"}, d2 = {"Lio/legado/app/data/dao/BookSourceDao;", "", "Landroidx/lifecycle/LiveData;", "", "Lio/legado/app/data/entities/BookSource;", "liveDataAll", "()Landroidx/lifecycle/LiveData;", "", "searchKey", "liveDataSearch", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "liveDataGroupSearch", "liveDataEnabled", "liveDataDisabled", "liveExplore", "key", "liveGroupExplore", "liveGroup", "liveGroupEnabled", "liveExploreGroup", "group", "getByGroup", "(Ljava/lang/String;)Ljava/util/List;", "getEnabledByGroup", "getBookSource", "(Ljava/lang/String;)Lio/legado/app/data/entities/BookSource;", "", "allCount", "()I", "", "bookSource", "Lf/v;", "insert", "([Lio/legado/app/data/entities/BookSource;)V", "update", "delete", "(Ljava/lang/String;)V", "getAllTextEnabled", "()Ljava/util/List;", "allTextEnabled", "getMaxOrder", "maxOrder", "getAllEnabled", "allEnabled", "getAllGroup", "allGroup", "getHasBookUrlPattern", "hasBookUrlPattern", "getAll", "all", "getNoGroup", "noGroup", "getMinOrder", "minOrder", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface BookSourceDao {
    @Query("select count(*) from book_sources")
    int allCount();

    @Query("delete from book_sources where bookSourceUrl = :key")
    void delete(@NotNull String key);

    @Delete
    void delete(@NotNull BookSource... bookSource);

    @Query("select * from book_sources order by customOrder asc")
    @NotNull
    List<BookSource> getAll();

    @Query("select * from book_sources where enabled = 1 order by customOrder")
    @NotNull
    List<BookSource> getAllEnabled();

    @Query("select distinct bookSourceGroup from book_sources where trim(bookSourceGroup) <> ''")
    @NotNull
    List<String> getAllGroup();

    @Query("select * from book_sources where enabled = 1 and bookSourceType = 0 order by customOrder")
    @NotNull
    List<BookSource> getAllTextEnabled();

    @Query("select * from book_sources where bookSourceUrl = :key")
    @Nullable
    BookSource getBookSource(@NotNull String key);

    @Query("select * from book_sources where bookSourceGroup like '%' || :group || '%'")
    @NotNull
    List<BookSource> getByGroup(@NotNull String group);

    @Query("select * from book_sources where enabled = 1 and bookSourceGroup like '%' || :group || '%'")
    @NotNull
    List<BookSource> getEnabledByGroup(@NotNull String group);

    @Query("select * from book_sources where trim(bookUrlPattern) <> ''")
    @NotNull
    List<BookSource> getHasBookUrlPattern();

    @Query("select max(customOrder) from book_sources")
    int getMaxOrder();

    @Query("select min(customOrder) from book_sources")
    int getMinOrder();

    @Query("select * from book_sources where bookSourceGroup is null or bookSourceGroup = ''")
    @NotNull
    List<BookSource> getNoGroup();

    @Insert(onConflict = 1)
    void insert(@NotNull BookSource... bookSource);

    @Query("select * from book_sources order by customOrder asc")
    @NotNull
    LiveData<List<BookSource>> liveDataAll();

    @Query("select * from book_sources where enabled = 0 order by customOrder asc")
    @NotNull
    LiveData<List<BookSource>> liveDataDisabled();

    @Query("select * from book_sources where enabled = 1 order by customOrder asc")
    @NotNull
    LiveData<List<BookSource>> liveDataEnabled();

    @Query("select * from book_sources where bookSourceGroup like :searchKey order by customOrder asc")
    @NotNull
    LiveData<List<BookSource>> liveDataGroupSearch(@NotNull String searchKey);

    @Query("select * from book_sources where bookSourceName like :searchKey or bookSourceGroup like :searchKey or bookSourceUrl like :searchKey  or bookSourceComment like :searchKey order by customOrder asc")
    @NotNull
    LiveData<List<BookSource>> liveDataSearch(@NotNull String searchKey);

    @Query("select * from book_sources where enabledExplore = 1 and trim(exploreUrl) <> '' order by customOrder asc")
    @NotNull
    LiveData<List<BookSource>> liveExplore();

    @Query("select * from book_sources where enabledExplore = 1 and trim(exploreUrl) <> '' and (bookSourceGroup like :key or bookSourceName like :key) order by customOrder asc")
    @NotNull
    LiveData<List<BookSource>> liveExplore(@NotNull String key);

    @Query("select distinct bookSourceGroup from book_sources where enabledExplore = 1 and trim(exploreUrl) <> '' and trim(bookSourceGroup) <> ''")
    @NotNull
    LiveData<List<String>> liveExploreGroup();

    @Query("select distinct bookSourceGroup from book_sources where trim(bookSourceGroup) <> ''")
    @NotNull
    LiveData<List<String>> liveGroup();

    @Query("select distinct bookSourceGroup from book_sources where enabled = 1 and trim(bookSourceGroup) <> ''")
    @NotNull
    LiveData<List<String>> liveGroupEnabled();

    @Query("select * from book_sources where enabledExplore = 1 and trim(exploreUrl) <> '' and (bookSourceGroup like :key) order by customOrder asc")
    @NotNull
    LiveData<List<BookSource>> liveGroupExplore(@NotNull String key);

    @Update
    void update(@NotNull BookSource... bookSource);
}
