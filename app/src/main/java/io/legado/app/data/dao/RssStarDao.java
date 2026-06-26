package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.view.LiveData;
import io.legado.app.data.entities.RssStar;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssStarDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH'¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\f\"\u00020\u0005H'¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\f\"\u00020\u0005H'¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\u0012\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\t8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/legado/app/data/dao/RssStarDao;", "", "", "origin", "link", "Lio/legado/app/data/entities/RssStar;", "get", "(Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/RssStar;", "Landroidx/lifecycle/LiveData;", "", "liveAll", "()Landroidx/lifecycle/LiveData;", "", "rssStar", "Lf/v;", "insert", "([Lio/legado/app/data/entities/RssStar;)V", "update", "delete", "(Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getAll", "()Ljava/util/List;", "all", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface RssStarDao {
    @Query("delete from rssStars where origin = :origin")
    void delete(@NotNull String origin);

    @Query("delete from rssStars where origin = :origin and link = :link")
    void delete(@NotNull String origin, @NotNull String link);

    @Query("select * from rssStars where origin = :origin and link = :link")
    @Nullable
    RssStar get(@NotNull String origin, @NotNull String link);

    @Query("select * from rssStars order by starTime desc")
    @NotNull
    List<RssStar> getAll();

    @Insert(onConflict = 1)
    void insert(@NotNull RssStar... rssStar);

    @Query("select * from rssStars order by starTime desc")
    @NotNull
    LiveData<List<RssStar>> liveAll();

    @Update
    void update(@NotNull RssStar... rssStar);
}
