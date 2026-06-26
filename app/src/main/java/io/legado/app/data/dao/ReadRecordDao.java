package io.legado.app.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.legado.app.data.entities.ReadRecord;
import io.legado.app.data.entities.ReadRecordShow;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadRecordDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\bJ#\u0010\r\u001a\u00020\f2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH'¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0010\u001a\u00020\f2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH'¢\u0006\u0004\b\u0010\u0010\u000eJ#\u0010\u0011\u001a\u00020\f2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH'¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\fH'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00048g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u00198g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c¨\u0006 "}, d2 = {"Lio/legado/app/data/dao/ReadRecordDao;", "", "", "bookName", "", "getReadTime", "(Ljava/lang/String;)Ljava/lang/Long;", "androidId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "", "Lio/legado/app/data/entities/ReadRecord;", "readRecord", "Lf/v;", "insert", "([Lio/legado/app/data/entities/ReadRecord;)V", "record", "update", "delete", "clear", "()V", "deleteByName", "(Ljava/lang/String;)V", "getAllTime", "()J", "allTime", "", "Lio/legado/app/data/entities/ReadRecordShow;", "getAllShow", "()Ljava/util/List;", "allShow", "getAll", "all", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface ReadRecordDao {
    @Query("delete from readRecord")
    void clear();

    @Delete
    void delete(@NotNull ReadRecord... record);

    @Query("delete from readRecord where bookName = :bookName")
    void deleteByName(@NotNull String bookName);

    @Query("select * from readRecord")
    @NotNull
    List<ReadRecord> getAll();

    @Query("select bookName, sum(readTime) as readTime from readRecord group by bookName order by bookName collate localized")
    @NotNull
    List<ReadRecordShow> getAllShow();

    @Query("select sum(readTime) from readRecord")
    long getAllTime();

    @Query("select sum(readTime) from readRecord where bookName = :bookName")
    @Nullable
    Long getReadTime(@NotNull String bookName);

    @Query("select readTime from readRecord where deviceId = :androidId and bookName = :bookName")
    @Nullable
    Long getReadTime(@NotNull String androidId, @NotNull String bookName);

    @Insert(onConflict = 1)
    void insert(@NotNull ReadRecord... readRecord);

    @Update
    void update(@NotNull ReadRecord... record);
}
