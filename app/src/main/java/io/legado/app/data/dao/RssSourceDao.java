package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.view.LiveData;
import io.legado.app.data.entities.RssSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002H'¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\fH'¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\f2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\f2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\u0010J\u001b\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\fH'¢\u0006\u0004\b\u0012\u0010\u000eJ#\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\f2\u0006\u0010\u0013\u001a\u00020\u0002H'¢\u0006\u0004\b\u0012\u0010\u0010J#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\f2\u0006\u0010\u0013\u001a\u00020\u0002H'¢\u0006\u0004\b\u0014\u0010\u0010J\u001b\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\fH'¢\u0006\u0004\b\u0015\u0010\u000eJ#\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007\"\u00020\u0004H'¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001a\u001a\u00020\u00172\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007\"\u00020\u0004H'¢\u0006\u0004\b\u001a\u0010\u0019J#\u0010\u001b\u001a\u00020\u00172\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007\"\u00020\u0004H'¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0002H'¢\u0006\u0004\b\u001b\u0010\u001dJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u001e\u001a\u00020\u0002H'¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\t8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\t8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\t8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\"R\u0016\u0010-\u001a\u00020$8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010&R\u0016\u0010/\u001a\u00020$8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010&¨\u00060"}, d2 = {"Lio/legado/app/data/dao/RssSourceDao;", "", "", "key", "Lio/legado/app/data/entities/RssSource;", "getByKey", "(Ljava/lang/String;)Lio/legado/app/data/entities/RssSource;", "", "sourceUrls", "", "getRssSources", "([Ljava/lang/String;)Ljava/util/List;", "Landroidx/lifecycle/LiveData;", "liveAll", "()Landroidx/lifecycle/LiveData;", "liveSearch", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "liveGroupSearch", "liveEnabled", "searchKey", "liveEnabledByGroup", "liveGroup", "rssSource", "Lf/v;", "insert", "([Lio/legado/app/data/entities/RssSource;)V", "update", "delete", "sourceUrl", "(Ljava/lang/String;)V", "group", "getByGroup", "(Ljava/lang/String;)Ljava/util/List;", "getAllGroup", "()Ljava/util/List;", "allGroup", "", "getMaxOrder", "()I", "maxOrder", "getNoGroup", "noGroup", "getAll", "all", "getMinOrder", "minOrder", "getSize", "size", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface RssSourceDao {
    @Query("delete from rssSources where sourceUrl = :sourceUrl")
    void delete(@NotNull String sourceUrl);

    @Delete
    void delete(@NotNull RssSource... rssSource);

    @Query("SELECT * FROM rssSources")
    @NotNull
    List<RssSource> getAll();

    @Query("select distinct sourceGroup from rssSources where trim(sourceGroup) <> ''")
    @NotNull
    List<String> getAllGroup();

    @Query("select * from rssSources where sourceGroup like '%' || :group || '%'")
    @NotNull
    List<RssSource> getByGroup(@NotNull String group);

    @Query("select * from rssSources where sourceUrl = :key")
    @Nullable
    RssSource getByKey(@NotNull String key);

    @Query("select max(customOrder) from rssSources")
    int getMaxOrder();

    @Query("select min(customOrder) from rssSources")
    int getMinOrder();

    @Query("select * from rssSources where sourceGroup is null or sourceGroup = ''")
    @NotNull
    List<RssSource> getNoGroup();

    @Query("select * from rssSources where sourceUrl in (:sourceUrls)")
    @NotNull
    List<RssSource> getRssSources(@NotNull String... sourceUrls);

    @Query("select count(sourceUrl) from rssSources")
    int getSize();

    @Insert(onConflict = 1)
    void insert(@NotNull RssSource... rssSource);

    @Query("SELECT * FROM rssSources order by customOrder")
    @NotNull
    LiveData<List<RssSource>> liveAll();

    @Query("SELECT * FROM rssSources where enabled = 1 order by customOrder")
    @NotNull
    LiveData<List<RssSource>> liveEnabled();

    @Query("SELECT * FROM rssSources where enabled = 1 and (sourceName like :searchKey or sourceGroup like :searchKey or sourceUrl like :searchKey) order by customOrder")
    @NotNull
    LiveData<List<RssSource>> liveEnabled(@NotNull String searchKey);

    @Query("SELECT * FROM rssSources where enabled = 1 and sourceGroup like :searchKey order by customOrder")
    @NotNull
    LiveData<List<RssSource>> liveEnabledByGroup(@NotNull String searchKey);

    @Query("select distinct sourceGroup from rssSources where trim(sourceGroup) <> ''")
    @NotNull
    LiveData<List<String>> liveGroup();

    @Query("SELECT * FROM rssSources where sourceGroup like :key order by customOrder")
    @NotNull
    LiveData<List<RssSource>> liveGroupSearch(@NotNull String key);

    @Query("SELECT * FROM rssSources where sourceName like :key or sourceUrl like :key or sourceGroup like :key order by customOrder")
    @NotNull
    LiveData<List<RssSource>> liveSearch(@NotNull String key);

    @Update
    void update(@NotNull RssSource... rssSource);
}
