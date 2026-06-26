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
import io.legado.app.data.entities.TxtTocRule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class TxtTocRuleDao_Impl implements TxtTocRuleDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<TxtTocRule> __deletionAdapterOfTxtTocRule;
    private final EntityInsertionAdapter<TxtTocRule> __insertionAdapterOfTxtTocRule;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDefault;
    private final EntityDeletionOrUpdateAdapter<TxtTocRule> __updateAdapterOfTxtTocRule;

    public TxtTocRuleDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfTxtTocRule = new EntityInsertionAdapter<TxtTocRule>(roomDatabase) { // from class: io.legado.app.data.dao.TxtTocRuleDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `txtTocRules` (`id`,`name`,`rule`,`serialNumber`,`enable`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TxtTocRule txtTocRule) {
                supportSQLiteStatement.bindLong(1, txtTocRule.getId());
                if (txtTocRule.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, txtTocRule.getName());
                }
                if (txtTocRule.getRule() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, txtTocRule.getRule());
                }
                supportSQLiteStatement.bindLong(4, txtTocRule.getSerialNumber());
                supportSQLiteStatement.bindLong(5, txtTocRule.getEnable() ? 1L : 0L);
            }
        };
        this.__deletionAdapterOfTxtTocRule = new EntityDeletionOrUpdateAdapter<TxtTocRule>(roomDatabase) { // from class: io.legado.app.data.dao.TxtTocRuleDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `txtTocRules` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TxtTocRule txtTocRule) {
                supportSQLiteStatement.bindLong(1, txtTocRule.getId());
            }
        };
        this.__updateAdapterOfTxtTocRule = new EntityDeletionOrUpdateAdapter<TxtTocRule>(roomDatabase) { // from class: io.legado.app.data.dao.TxtTocRuleDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR REPLACE `txtTocRules` SET `id` = ?,`name` = ?,`rule` = ?,`serialNumber` = ?,`enable` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TxtTocRule txtTocRule) {
                supportSQLiteStatement.bindLong(1, txtTocRule.getId());
                if (txtTocRule.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, txtTocRule.getName());
                }
                if (txtTocRule.getRule() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, txtTocRule.getRule());
                }
                supportSQLiteStatement.bindLong(4, txtTocRule.getSerialNumber());
                supportSQLiteStatement.bindLong(5, txtTocRule.getEnable() ? 1L : 0L);
                supportSQLiteStatement.bindLong(6, txtTocRule.getId());
            }
        };
        this.__preparedStmtOfDeleteDefault = new SharedSQLiteStatement(roomDatabase) { // from class: io.legado.app.data.dao.TxtTocRuleDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from txtTocRules where id < 0";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // io.legado.app.data.dao.TxtTocRuleDao
    public void delete(TxtTocRule... txtTocRuleArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfTxtTocRule.handleMultiple(txtTocRuleArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.TxtTocRuleDao
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

    @Override // io.legado.app.data.dao.TxtTocRuleDao
    public List<TxtTocRule> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `txtTocRules`.`id` AS `id`, `txtTocRules`.`name` AS `name`, `txtTocRules`.`rule` AS `rule`, `txtTocRules`.`serialNumber` AS `serialNumber`, `txtTocRules`.`enable` AS `enable` from txtTocRules order by serialNumber", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rule");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serialNumber");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enable");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new TxtTocRule(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5) != 0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.TxtTocRuleDao
    public List<TxtTocRule> getEnabled() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `txtTocRules`.`id` AS `id`, `txtTocRules`.`name` AS `name`, `txtTocRules`.`rule` AS `rule`, `txtTocRules`.`serialNumber` AS `serialNumber`, `txtTocRules`.`enable` AS `enable` from txtTocRules where enable = 1 order by serialNumber", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rule");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serialNumber");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enable");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new TxtTocRule(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5) != 0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.TxtTocRuleDao
    public int getLastOrderNum() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select ifNull(max(serialNumber), 0) from txtTocRules", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.TxtTocRuleDao
    public void insert(TxtTocRule... txtTocRuleArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfTxtTocRule.insert(txtTocRuleArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.TxtTocRuleDao
    public LiveData<List<TxtTocRule>> observeAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `txtTocRules`.`id` AS `id`, `txtTocRules`.`name` AS `name`, `txtTocRules`.`rule` AS `rule`, `txtTocRules`.`serialNumber` AS `serialNumber`, `txtTocRules`.`enable` AS `enable` from txtTocRules order by serialNumber", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"txtTocRules"}, false, new Callable<List<TxtTocRule>>() { // from class: io.legado.app.data.dao.TxtTocRuleDao_Impl.5
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<TxtTocRule> call() {
                Cursor cursorQuery = DBUtil.query(TxtTocRuleDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rule");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serialNumber");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enable");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new TxtTocRule(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5) != 0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.TxtTocRuleDao
    public void update(TxtTocRule... txtTocRuleArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfTxtTocRule.handleMultiple(txtTocRuleArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
