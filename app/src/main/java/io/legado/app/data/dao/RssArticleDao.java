package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.view.LiveData;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssReadRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssArticleDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\r\"\u00020\u0005H'¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u000f2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\r\"\u00020\u0005H'¢\u0006\u0004\b\u0016\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u00020\u000f2\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\r\"\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lio/legado/app/data/dao/RssArticleDao;", "", "", "origin", "link", "Lio/legado/app/data/entities/RssArticle;", "get", "(Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/RssArticle;", "sort", "Landroidx/lifecycle/LiveData;", "", "liveByOriginSort", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "rssArticle", "Lf/v;", "insert", "([Lio/legado/app/data/entities/RssArticle;)V", "", "order", "clearOld", "(Ljava/lang/String;Ljava/lang/String;J)V", "update", "delete", "(Ljava/lang/String;)V", "Lio/legado/app/data/entities/RssReadRecord;", "rssReadRecord", "insertRecord", "([Lio/legado/app/data/entities/RssReadRecord;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface RssArticleDao {
    @Query("delete from rssArticles where origin = :origin and sort = :sort and `order` < :order")
    void clearOld(@NotNull String origin, @NotNull String sort, long order);

    @Query("delete from rssArticles where origin = :origin")
    void delete(@NotNull String origin);

    @Query("select * from rssArticles where origin = :origin and link = :link")
    @Nullable
    RssArticle get(@NotNull String origin, @NotNull String link);

    @Insert(onConflict = 1)
    void insert(@NotNull RssArticle... rssArticle);

    @Insert(onConflict = 5)
    void insertRecord(@NotNull RssReadRecord... rssReadRecord);

    @Query("select t1.link, t1.sort, t1.origin, t1.`order`, t1.title, t1.content, t1.description, t1.image, t1.pubDate, t1.variable, ifNull(t2.read, 0) as read\n        from rssArticles as t1 left join rssReadRecords as t2\n        on t1.link = t2.record  where origin = :origin and sort = :sort\n        order by `order` desc")
    @NotNull
    LiveData<List<RssArticle>> liveByOriginSort(@NotNull String origin, @NotNull String sort);

    @Update
    void update(@NotNull RssArticle... rssArticle);
}
