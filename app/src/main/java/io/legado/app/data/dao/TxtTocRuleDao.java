package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.view.LiveData;
import io.legado.app.data.entities.TxtTocRule;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TxtTocRuleDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007\"\u00020\u0004H'¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\u00020\t2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007\"\u00020\u0004H'¢\u0006\u0004\b\f\u0010\u000bJ#\u0010\r\u001a\u00020\t2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007\"\u00020\u0004H'¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH'¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0019"}, d2 = {"Lio/legado/app/data/dao/TxtTocRuleDao;", "", "Landroidx/lifecycle/LiveData;", "", "Lio/legado/app/data/entities/TxtTocRule;", "observeAll", "()Landroidx/lifecycle/LiveData;", "", "rule", "Lf/v;", "insert", "([Lio/legado/app/data/entities/TxtTocRule;)V", "update", "delete", "deleteDefault", "()V", "getEnabled", "()Ljava/util/List;", "enabled", "", "getLastOrderNum", "()I", "lastOrderNum", "getAll", "all", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface TxtTocRuleDao {
    @Delete
    void delete(@NotNull TxtTocRule... rule);

    @Query("delete from txtTocRules where id < 0")
    void deleteDefault();

    @Query("select * from txtTocRules order by serialNumber")
    @NotNull
    List<TxtTocRule> getAll();

    @Query("select * from txtTocRules where enable = 1 order by serialNumber")
    @NotNull
    List<TxtTocRule> getEnabled();

    @Query("select ifNull(max(serialNumber), 0) from txtTocRules")
    int getLastOrderNum();

    @Insert(onConflict = 1)
    void insert(@NotNull TxtTocRule... rule);

    @Query("select * from txtTocRules order by serialNumber")
    @NotNull
    LiveData<List<TxtTocRule>> observeAll();

    @Update(onConflict = 1)
    void update(@NotNull TxtTocRule... rule);
}
