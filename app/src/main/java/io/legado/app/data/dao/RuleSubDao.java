package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.view.LiveData;
import io.legado.app.data.entities.RuleSub;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RuleSubDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\r2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000b\"\u00020\u0004H'¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0010\u001a\u00020\r2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000b\"\u00020\u0004H'¢\u0006\u0004\b\u0010\u0010\u000fJ#\u0010\u0011\u001a\u00020\r2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000b\"\u00020\u0004H'¢\u0006\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u00128g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lio/legado/app/data/dao/RuleSubDao;", "", "Landroidx/lifecycle/LiveData;", "", "Lio/legado/app/data/entities/RuleSub;", "observeAll", "()Landroidx/lifecycle/LiveData;", "", "url", "findByUrl", "(Ljava/lang/String;)Lio/legado/app/data/entities/RuleSub;", "", "ruleSub", "Lf/v;", "insert", "([Lio/legado/app/data/entities/RuleSub;)V", "delete", "update", "", "getMaxOrder", "()I", "maxOrder", "getAll", "()Ljava/util/List;", "all", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface RuleSubDao {
    @Delete
    void delete(@NotNull RuleSub... ruleSub);

    @Query("select * from ruleSubs where url = :url")
    @Nullable
    RuleSub findByUrl(@NotNull String url);

    @Query("select * from ruleSubs order by customOrder")
    @NotNull
    List<RuleSub> getAll();

    @Query("select customOrder from ruleSubs order by customOrder limit 0,1")
    int getMaxOrder();

    @Insert(onConflict = 1)
    void insert(@NotNull RuleSub... ruleSub);

    @Query("select * from ruleSubs order by customOrder")
    @NotNull
    LiveData<List<RuleSub>> observeAll();

    @Update
    void update(@NotNull RuleSub... ruleSub);
}
