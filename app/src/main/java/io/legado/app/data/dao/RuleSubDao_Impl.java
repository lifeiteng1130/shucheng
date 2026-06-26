package io.legado.app.data.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.view.LiveData;
import io.legado.app.data.entities.RuleSub;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class RuleSubDao_Impl implements RuleSubDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RuleSub> __deletionAdapterOfRuleSub;
    private final EntityInsertionAdapter<RuleSub> __insertionAdapterOfRuleSub;
    private final EntityDeletionOrUpdateAdapter<RuleSub> __updateAdapterOfRuleSub;

    public RuleSubDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRuleSub = new EntityInsertionAdapter<RuleSub>(roomDatabase) { // from class: io.legado.app.data.dao.RuleSubDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ruleSubs` (`id`,`name`,`url`,`type`,`customOrder`,`autoUpdate`,`update`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RuleSub ruleSub) {
                supportSQLiteStatement.bindLong(1, ruleSub.getId());
                if (ruleSub.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, ruleSub.getName());
                }
                if (ruleSub.getUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, ruleSub.getUrl());
                }
                supportSQLiteStatement.bindLong(4, ruleSub.getType());
                supportSQLiteStatement.bindLong(5, ruleSub.getCustomOrder());
                supportSQLiteStatement.bindLong(6, ruleSub.getAutoUpdate() ? 1L : 0L);
                supportSQLiteStatement.bindLong(7, ruleSub.getUpdate());
            }
        };
        this.__deletionAdapterOfRuleSub = new EntityDeletionOrUpdateAdapter<RuleSub>(roomDatabase) { // from class: io.legado.app.data.dao.RuleSubDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `ruleSubs` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RuleSub ruleSub) {
                supportSQLiteStatement.bindLong(1, ruleSub.getId());
            }
        };
        this.__updateAdapterOfRuleSub = new EntityDeletionOrUpdateAdapter<RuleSub>(roomDatabase) { // from class: io.legado.app.data.dao.RuleSubDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `ruleSubs` SET `id` = ?,`name` = ?,`url` = ?,`type` = ?,`customOrder` = ?,`autoUpdate` = ?,`update` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RuleSub ruleSub) {
                supportSQLiteStatement.bindLong(1, ruleSub.getId());
                if (ruleSub.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, ruleSub.getName());
                }
                if (ruleSub.getUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, ruleSub.getUrl());
                }
                supportSQLiteStatement.bindLong(4, ruleSub.getType());
                supportSQLiteStatement.bindLong(5, ruleSub.getCustomOrder());
                supportSQLiteStatement.bindLong(6, ruleSub.getAutoUpdate() ? 1L : 0L);
                supportSQLiteStatement.bindLong(7, ruleSub.getUpdate());
                supportSQLiteStatement.bindLong(8, ruleSub.getId());
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // io.legado.app.data.dao.RuleSubDao
    public void delete(RuleSub... ruleSubArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRuleSub.handleMultiple(ruleSubArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.RuleSubDao
    public RuleSub findByUrl(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from ruleSubs where url = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        RuleSub ruleSub = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoUpdate");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "update");
            if (cursorQuery.moveToFirst()) {
                ruleSub = new RuleSub(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6) != 0, cursorQuery.getLong(columnIndexOrThrow7));
            }
            return ruleSub;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.RuleSubDao
    public List<RuleSub> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `ruleSubs`.`id` AS `id`, `ruleSubs`.`name` AS `name`, `ruleSubs`.`url` AS `url`, `ruleSubs`.`type` AS `type`, `ruleSubs`.`customOrder` AS `customOrder`, `ruleSubs`.`autoUpdate` AS `autoUpdate`, `ruleSubs`.`update` AS `update` from ruleSubs order by customOrder", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoUpdate");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "update");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new RuleSub(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6) != 0, cursorQuery.getLong(columnIndexOrThrow7)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.RuleSubDao
    public int getMaxOrder() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select customOrder from ruleSubs order by customOrder limit 0,1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.RuleSubDao
    public void insert(RuleSub... ruleSubArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRuleSub.insert(ruleSubArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.RuleSubDao
    public LiveData<List<RuleSub>> observeAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `ruleSubs`.`id` AS `id`, `ruleSubs`.`name` AS `name`, `ruleSubs`.`url` AS `url`, `ruleSubs`.`type` AS `type`, `ruleSubs`.`customOrder` AS `customOrder`, `ruleSubs`.`autoUpdate` AS `autoUpdate`, `ruleSubs`.`update` AS `update` from ruleSubs order by customOrder", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ruleSubs"}, false, new Callable<List<RuleSub>>() { // from class: io.legado.app.data.dao.RuleSubDao_Impl.4
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RuleSub> call() {
                Cursor cursorQuery = DBUtil.query(RuleSubDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoUpdate");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "update");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new RuleSub(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6) != 0, cursorQuery.getLong(columnIndexOrThrow7)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.RuleSubDao
    public void update(RuleSub... ruleSubArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRuleSub.handleMultiple(ruleSubArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
