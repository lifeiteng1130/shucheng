package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.view.LiveData;
import io.legado.app.data.entities.ReplaceRule;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceRuleDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\u0010\u0011\u001a\u00020\u0010\"\u00020\fH'¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H'¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0002H'¢\u0006\u0004\b\u0018\u0010\u0006J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u0007H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001f\u0010 J)\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040!\"\u00020\u0004H'¢\u0006\u0004\b#\u0010$J#\u0010&\u001a\u00020\u001e2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040!\"\u00020\u0004H'¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u00020\u001e2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040!\"\u00020\u0004H'¢\u0006\u0004\b(\u0010'R\u0016\u0010,\u001a\u00020)8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00101\u001a\u00020)8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010+R\u0016\u00103\u001a\u00020)8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010+R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010.R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010.¨\u00068"}, d2 = {"Lio/legado/app/data/dao/ReplaceRuleDao;", "", "Landroidx/lifecycle/LiveData;", "", "Lio/legado/app/data/entities/ReplaceRule;", "liveDataAll", "()Landroidx/lifecycle/LiveData;", "", "key", "liveDataSearch", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "liveDataGroupSearch", "", "id", "findById", "(J)Lio/legado/app/data/entities/ReplaceRule;", "", "ids", "findByIds", "([J)Ljava/util/List;", "name", "origin", "findEnabledByScope", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "liveGroup", "group", "getByGroup", "(Ljava/lang/String;)Ljava/util/List;", "", "enable", "Lf/v;", "enableAll", "(Z)V", "", "replaceRule", "insert", "([Lio/legado/app/data/entities/ReplaceRule;)Ljava/util/List;", "replaceRules", "update", "([Lio/legado/app/data/entities/ReplaceRule;)V", "delete", "", "getMaxOrder", "()I", "maxOrder", "getNoGroup", "()Ljava/util/List;", "noGroup", "getSummary", "summary", "getMinOrder", "minOrder", "getAll", "all", "getAllEnabled", "allEnabled", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface ReplaceRuleDao {
    @Delete
    void delete(@NotNull ReplaceRule... replaceRules);

    @Query("UPDATE replace_rules SET isEnabled = :enable")
    void enableAll(boolean enable);

    @Query("SELECT * FROM replace_rules WHERE id = :id")
    @Nullable
    ReplaceRule findById(long id);

    @Query("SELECT * FROM replace_rules WHERE id in (:ids)")
    @NotNull
    List<ReplaceRule> findByIds(@NotNull long... ids);

    @Query("\n        SELECT * FROM replace_rules WHERE isEnabled = 1 \n        AND (scope LIKE '%' || :name || '%' or scope LIKE '%' || :origin || '%' or scope is null or scope = '')\n        order by sortOrder\n        ")
    @NotNull
    List<ReplaceRule> findEnabledByScope(@NotNull String name, @NotNull String origin);

    @Query("SELECT * FROM replace_rules ORDER BY sortOrder ASC")
    @NotNull
    List<ReplaceRule> getAll();

    @Query("SELECT * FROM replace_rules WHERE isEnabled = 1 ORDER BY sortOrder ASC")
    @NotNull
    List<ReplaceRule> getAllEnabled();

    @Query("select * from replace_rules where `group` like '%' || :group || '%'")
    @NotNull
    List<ReplaceRule> getByGroup(@NotNull String group);

    @Query("SELECT MAX(sortOrder) FROM replace_rules")
    int getMaxOrder();

    @Query("SELECT MIN(sortOrder) FROM replace_rules")
    int getMinOrder();

    @Query("select * from replace_rules where `group` is null or `group` = ''")
    @NotNull
    List<ReplaceRule> getNoGroup();

    @Query("SELECT COUNT(*) - SUM(isEnabled) FROM replace_rules")
    int getSummary();

    @Insert(onConflict = 1)
    @NotNull
    List<Long> insert(@NotNull ReplaceRule... replaceRule);

    @Query("SELECT * FROM replace_rules ORDER BY sortOrder ASC")
    @NotNull
    LiveData<List<ReplaceRule>> liveDataAll();

    @Query("SELECT * FROM replace_rules where `group` like :key ORDER BY sortOrder ASC")
    @NotNull
    LiveData<List<ReplaceRule>> liveDataGroupSearch(@NotNull String key);

    @Query("SELECT * FROM replace_rules where `group` like :key or name like :key ORDER BY sortOrder ASC")
    @NotNull
    LiveData<List<ReplaceRule>> liveDataSearch(@NotNull String key);

    @Query("select `group` from replace_rules where `group` is not null and `group` <> ''")
    @NotNull
    LiveData<List<String>> liveGroup();

    @Update
    void update(@NotNull ReplaceRule... replaceRules);
}
