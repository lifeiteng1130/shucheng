package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.view.LiveData;
import io.legado.app.data.entities.SearchKeyword;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchKeywordDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004H'¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u00102\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004H'¢\u0006\u0004\b\u0013\u0010\u0012J#\u0010\u0014\u001a\u00020\u00102\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004H'¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0010H'¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lio/legado/app/data/dao/SearchKeywordDao;", "", "Landroidx/lifecycle/LiveData;", "", "Lio/legado/app/data/entities/SearchKeyword;", "liveDataByUsage", "()Landroidx/lifecycle/LiveData;", "liveDataByTime", "", "key", "liveDataSearch", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "get", "(Ljava/lang/String;)Lio/legado/app/data/entities/SearchKeyword;", "", "keywords", "Lf/v;", "insert", "([Lio/legado/app/data/entities/SearchKeyword;)V", "update", "delete", "deleteAll", "()V", "getAll", "()Ljava/util/List;", "all", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface SearchKeywordDao {
    @Delete
    void delete(@NotNull SearchKeyword... keywords);

    @Query("DELETE FROM search_keywords")
    void deleteAll();

    @Query("select * from search_keywords where word = :key")
    @Nullable
    SearchKeyword get(@NotNull String key);

    @Query("SELECT * FROM search_keywords")
    @NotNull
    List<SearchKeyword> getAll();

    @Insert(onConflict = 1)
    void insert(@NotNull SearchKeyword... keywords);

    @Query("SELECT * FROM search_keywords ORDER BY lastUseTime DESC")
    @NotNull
    LiveData<List<SearchKeyword>> liveDataByTime();

    @Query("SELECT * FROM search_keywords ORDER BY usage DESC")
    @NotNull
    LiveData<List<SearchKeyword>> liveDataByUsage();

    @Query("SELECT * FROM search_keywords where word like '%'||:key||'%' ORDER BY usage DESC")
    @NotNull
    LiveData<List<SearchKeyword>> liveDataSearch(@NotNull String key);

    @Update
    void update(@NotNull SearchKeyword... keywords);
}
