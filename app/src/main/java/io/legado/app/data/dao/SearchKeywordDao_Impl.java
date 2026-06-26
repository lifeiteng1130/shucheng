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
import io.legado.app.data.entities.SearchKeyword;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchKeywordDao_Impl implements SearchKeywordDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SearchKeyword> __deletionAdapterOfSearchKeyword;
    private final EntityInsertionAdapter<SearchKeyword> __insertionAdapterOfSearchKeyword;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final EntityDeletionOrUpdateAdapter<SearchKeyword> __updateAdapterOfSearchKeyword;

    public SearchKeywordDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSearchKeyword = new EntityInsertionAdapter<SearchKeyword>(roomDatabase) { // from class: io.legado.app.data.dao.SearchKeywordDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `search_keywords` (`word`,`usage`,`lastUseTime`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SearchKeyword searchKeyword) {
                if (searchKeyword.getWord() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, searchKeyword.getWord());
                }
                supportSQLiteStatement.bindLong(2, searchKeyword.getUsage());
                supportSQLiteStatement.bindLong(3, searchKeyword.getLastUseTime());
            }
        };
        this.__deletionAdapterOfSearchKeyword = new EntityDeletionOrUpdateAdapter<SearchKeyword>(roomDatabase) { // from class: io.legado.app.data.dao.SearchKeywordDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `search_keywords` WHERE `word` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SearchKeyword searchKeyword) {
                if (searchKeyword.getWord() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, searchKeyword.getWord());
                }
            }
        };
        this.__updateAdapterOfSearchKeyword = new EntityDeletionOrUpdateAdapter<SearchKeyword>(roomDatabase) { // from class: io.legado.app.data.dao.SearchKeywordDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `search_keywords` SET `word` = ?,`usage` = ?,`lastUseTime` = ? WHERE `word` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SearchKeyword searchKeyword) {
                if (searchKeyword.getWord() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, searchKeyword.getWord());
                }
                supportSQLiteStatement.bindLong(2, searchKeyword.getUsage());
                supportSQLiteStatement.bindLong(3, searchKeyword.getLastUseTime());
                if (searchKeyword.getWord() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, searchKeyword.getWord());
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: io.legado.app.data.dao.SearchKeywordDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM search_keywords";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // io.legado.app.data.dao.SearchKeywordDao
    public void delete(SearchKeyword... searchKeywordArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfSearchKeyword.handleMultiple(searchKeywordArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.SearchKeywordDao
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.legado.app.data.dao.SearchKeywordDao
    public SearchKeyword get(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from search_keywords where word = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        SearchKeyword searchKeyword = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "word");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "usage");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUseTime");
            if (cursorQuery.moveToFirst()) {
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                searchKeyword = new SearchKeyword(string, cursorQuery.getInt(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3));
            }
            return searchKeyword;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.SearchKeywordDao
    public List<SearchKeyword> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `search_keywords`.`word` AS `word`, `search_keywords`.`usage` AS `usage`, `search_keywords`.`lastUseTime` AS `lastUseTime` FROM search_keywords", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "word");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "usage");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUseTime");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new SearchKeyword(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.SearchKeywordDao
    public void insert(SearchKeyword... searchKeywordArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSearchKeyword.insert(searchKeywordArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.SearchKeywordDao
    public LiveData<List<SearchKeyword>> liveDataByTime() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `search_keywords`.`word` AS `word`, `search_keywords`.`usage` AS `usage`, `search_keywords`.`lastUseTime` AS `lastUseTime` FROM search_keywords ORDER BY lastUseTime DESC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"search_keywords"}, false, new Callable<List<SearchKeyword>>() { // from class: io.legado.app.data.dao.SearchKeywordDao_Impl.6
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<SearchKeyword> call() {
                Cursor cursorQuery = DBUtil.query(SearchKeywordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "word");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "usage");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUseTime");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new SearchKeyword(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.SearchKeywordDao
    public LiveData<List<SearchKeyword>> liveDataByUsage() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `search_keywords`.`word` AS `word`, `search_keywords`.`usage` AS `usage`, `search_keywords`.`lastUseTime` AS `lastUseTime` FROM search_keywords ORDER BY usage DESC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"search_keywords"}, false, new Callable<List<SearchKeyword>>() { // from class: io.legado.app.data.dao.SearchKeywordDao_Impl.5
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<SearchKeyword> call() {
                Cursor cursorQuery = DBUtil.query(SearchKeywordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "word");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "usage");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUseTime");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new SearchKeyword(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.SearchKeywordDao
    public LiveData<List<SearchKeyword>> liveDataSearch(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM search_keywords where word like '%'||?||'%' ORDER BY usage DESC", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"search_keywords"}, false, new Callable<List<SearchKeyword>>() { // from class: io.legado.app.data.dao.SearchKeywordDao_Impl.7
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<SearchKeyword> call() {
                Cursor cursorQuery = DBUtil.query(SearchKeywordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "word");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "usage");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUseTime");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new SearchKeyword(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.SearchKeywordDao
    public void update(SearchKeyword... searchKeywordArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfSearchKeyword.handleMultiple(searchKeywordArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
