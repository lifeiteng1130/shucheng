package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.legado.app.data.entities.Cache;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/legado/app/data/dao/CacheDao;", "", "", "key", "", "now", "get", "(Ljava/lang/String;J)Ljava/lang/String;", "", "Lio/legado/app/data/entities/Cache;", "cache", "Lf/v;", "insert", "([Lio/legado/app/data/entities/Cache;)V", "delete", "(Ljava/lang/String;)V", "clearDeadline", "(J)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface CacheDao {
    @Query("delete from caches where deadline > 0 and deadline < :now")
    void clearDeadline(long now);

    @Query("delete from caches where `key` = :key")
    void delete(@NotNull String key);

    @Query("select value from caches where `key` = :key and (deadline = 0 or deadline > :now)")
    @Nullable
    String get(@NotNull String key, long now);

    @Insert(onConflict = 1)
    void insert(@NotNull Cache... cache);
}
