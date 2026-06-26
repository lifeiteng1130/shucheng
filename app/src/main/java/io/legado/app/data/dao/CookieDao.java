package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.legado.app.data.entities.Cookie;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CookieDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H'¢\u0006\u0004\b\b\u0010\tJ#\u0010\r\u001a\u00020\f2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\n\"\u00020\u0004H'¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u00020\f2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\n\"\u00020\u0004H'¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH'¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/legado/app/data/dao/CookieDao;", "", "", "url", "Lio/legado/app/data/entities/Cookie;", "get", "(Ljava/lang/String;)Lio/legado/app/data/entities/Cookie;", "", "getOkHttpCookies", "()Ljava/util/List;", "", "cookie", "Lf/v;", "insert", "([Lio/legado/app/data/entities/Cookie;)V", "update", "delete", "(Ljava/lang/String;)V", "deleteOkHttp", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface CookieDao {
    @Query("delete from cookies where url = :url")
    void delete(@NotNull String url);

    @Query("delete from cookies where url like '%|%'")
    void deleteOkHttp();

    @Query("SELECT * FROM cookies Where url = :url")
    @Nullable
    Cookie get(@NotNull String url);

    @Query("select * from cookies where url like '%|%'")
    @NotNull
    List<Cookie> getOkHttpCookies();

    @Insert(onConflict = 1)
    void insert(@NotNull Cookie... cookie);

    @Update
    void update(@NotNull Cookie... cookie);
}
