package io.legado.app.data.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.view.LiveData;
import io.legado.app.data.entities.HttpTTS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpTTSDao_Impl implements HttpTTSDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<HttpTTS> __deletionAdapterOfHttpTTS;
    private final EntityInsertionAdapter<HttpTTS> __insertionAdapterOfHttpTTS;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDefault;
    private final EntityDeletionOrUpdateAdapter<HttpTTS> __updateAdapterOfHttpTTS;

    public HttpTTSDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfHttpTTS = new EntityInsertionAdapter<HttpTTS>(roomDatabase) { // from class: io.legado.app.data.dao.HttpTTSDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `httpTTS` (`id`,`name`,`url`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, HttpTTS httpTTS) {
                supportSQLiteStatement.bindLong(1, httpTTS.getId());
                if (httpTTS.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, httpTTS.getName());
                }
                if (httpTTS.getUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, httpTTS.getUrl());
                }
            }
        };
        this.__deletionAdapterOfHttpTTS = new EntityDeletionOrUpdateAdapter<HttpTTS>(roomDatabase) { // from class: io.legado.app.data.dao.HttpTTSDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `httpTTS` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, HttpTTS httpTTS) {
                supportSQLiteStatement.bindLong(1, httpTTS.getId());
            }
        };
        this.__updateAdapterOfHttpTTS = new EntityDeletionOrUpdateAdapter<HttpTTS>(roomDatabase) { // from class: io.legado.app.data.dao.HttpTTSDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `httpTTS` SET `id` = ?,`name` = ?,`url` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, HttpTTS httpTTS) {
                supportSQLiteStatement.bindLong(1, httpTTS.getId());
                if (httpTTS.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, httpTTS.getName());
                }
                if (httpTTS.getUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, httpTTS.getUrl());
                }
                supportSQLiteStatement.bindLong(4, httpTTS.getId());
            }
        };
        this.__preparedStmtOfDeleteDefault = new SharedSQLiteStatement(roomDatabase) { // from class: io.legado.app.data.dao.HttpTTSDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from httpTTS where id < 0";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // io.legado.app.data.dao.HttpTTSDao
    public void delete(HttpTTS... httpTTSArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfHttpTTS.handleMultiple(httpTTSArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.HttpTTSDao
    public void deleteDefault() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteDefault.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteDefault.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.legado.app.data.dao.HttpTTSDao
    public HttpTTS get(long j2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from httpTTS where id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j2);
        this.__db.assertNotSuspendingTransaction();
        HttpTTS httpTTS = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            if (cursorQuery.moveToFirst()) {
                long j3 = cursorQuery.getLong(columnIndexOrThrow);
                String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                if (!cursorQuery.isNull(columnIndexOrThrow3)) {
                    string = cursorQuery.getString(columnIndexOrThrow3);
                }
                httpTTS = new HttpTTS(j3, string2, string);
            }
            return httpTTS;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.HttpTTSDao
    public List<HttpTTS> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `httpTTS`.`id` AS `id`, `httpTTS`.`name` AS `name`, `httpTTS`.`url` AS `url` from httpTTS order by name", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new HttpTTS(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.HttpTTSDao
    public int getCount() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select count(*) from httpTTS", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.HttpTTSDao
    public void insert(HttpTTS... httpTTSArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfHttpTTS.insert(httpTTSArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.HttpTTSDao
    public LiveData<List<HttpTTS>> observeAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `httpTTS`.`id` AS `id`, `httpTTS`.`name` AS `name`, `httpTTS`.`url` AS `url` from httpTTS order by name", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"httpTTS"}, false, new Callable<List<HttpTTS>>() { // from class: io.legado.app.data.dao.HttpTTSDao_Impl.5
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<HttpTTS> call() {
                Cursor cursorQuery = DBUtil.query(HttpTTSDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new HttpTTS(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.HttpTTSDao
    public void update(HttpTTS... httpTTSArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfHttpTTS.handleMultiple(httpTTSArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
