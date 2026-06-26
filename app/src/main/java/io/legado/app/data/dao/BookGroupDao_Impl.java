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
import io.legado.app.data.entities.BookGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class BookGroupDao_Impl implements BookGroupDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<BookGroup> __deletionAdapterOfBookGroup;
    private final EntityInsertionAdapter<BookGroup> __insertionAdapterOfBookGroup;
    private final SharedSQLiteStatement __preparedStmtOfEnableGroup;
    private final EntityDeletionOrUpdateAdapter<BookGroup> __updateAdapterOfBookGroup;

    public BookGroupDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfBookGroup = new EntityInsertionAdapter<BookGroup>(roomDatabase) { // from class: io.legado.app.data.dao.BookGroupDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `book_groups` (`groupId`,`groupName`,`order`,`show`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, BookGroup bookGroup) {
                supportSQLiteStatement.bindLong(1, bookGroup.getGroupId());
                if (bookGroup.getGroupName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, bookGroup.getGroupName());
                }
                supportSQLiteStatement.bindLong(3, bookGroup.getOrder());
                supportSQLiteStatement.bindLong(4, bookGroup.getShow() ? 1L : 0L);
            }
        };
        this.__deletionAdapterOfBookGroup = new EntityDeletionOrUpdateAdapter<BookGroup>(roomDatabase) { // from class: io.legado.app.data.dao.BookGroupDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `book_groups` WHERE `groupId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, BookGroup bookGroup) {
                supportSQLiteStatement.bindLong(1, bookGroup.getGroupId());
            }
        };
        this.__updateAdapterOfBookGroup = new EntityDeletionOrUpdateAdapter<BookGroup>(roomDatabase) { // from class: io.legado.app.data.dao.BookGroupDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `book_groups` SET `groupId` = ?,`groupName` = ?,`order` = ?,`show` = ? WHERE `groupId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, BookGroup bookGroup) {
                supportSQLiteStatement.bindLong(1, bookGroup.getGroupId());
                if (bookGroup.getGroupName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, bookGroup.getGroupName());
                }
                supportSQLiteStatement.bindLong(3, bookGroup.getOrder());
                supportSQLiteStatement.bindLong(4, bookGroup.getShow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(5, bookGroup.getGroupId());
            }
        };
        this.__preparedStmtOfEnableGroup = new SharedSQLiteStatement(roomDatabase) { // from class: io.legado.app.data.dao.BookGroupDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "update book_groups set show = 1 where groupId = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public void delete(BookGroup... bookGroupArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfBookGroup.handleMultiple(bookGroupArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public void enableGroup(long j2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfEnableGroup.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j2);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfEnableGroup.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public List<BookGroup> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `book_groups`.`groupId` AS `groupId`, `book_groups`.`groupName` AS `groupName`, `book_groups`.`order` AS `order`, `book_groups`.`show` AS `show` FROM book_groups ORDER BY `order`", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new BookGroup(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public BookGroup getByID(long j2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from book_groups where groupId = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j2);
        this.__db.assertNotSuspendingTransaction();
        BookGroup bookGroup = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show");
            if (cursorQuery.moveToFirst()) {
                bookGroup = new BookGroup(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0);
            }
            return bookGroup;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public BookGroup getByName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from book_groups where groupName = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        BookGroup bookGroup = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show");
            if (cursorQuery.moveToFirst()) {
                bookGroup = new BookGroup(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0);
            }
            return bookGroup;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public List<String> getGroupNames(long j2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select groupName from book_groups where groupId > 0 and (groupId & ?) > 0", 1);
        roomSQLiteQueryAcquire.bindLong(1, j2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public long getIdsSum() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT sum(groupId) FROM book_groups where groupId >= 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getLong(0) : 0L;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public int getMaxOrder() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT MAX(`order`) FROM book_groups where groupId >= 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public void insert(BookGroup... bookGroupArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfBookGroup.insert(bookGroupArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public LiveData<List<BookGroup>> liveDataAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `book_groups`.`groupId` AS `groupId`, `book_groups`.`groupName` AS `groupName`, `book_groups`.`order` AS `order`, `book_groups`.`show` AS `show` FROM book_groups ORDER BY `order`", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_groups"}, false, new Callable<List<BookGroup>>() { // from class: io.legado.app.data.dao.BookGroupDao_Impl.5
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<BookGroup> call() {
                Cursor cursorQuery = DBUtil.query(BookGroupDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupName");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new BookGroup(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public LiveData<List<BookGroup>> liveDataSelect() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `book_groups`.`groupId` AS `groupId`, `book_groups`.`groupName` AS `groupName`, `book_groups`.`order` AS `order`, `book_groups`.`show` AS `show` FROM book_groups where groupId >= 0 ORDER BY `order`", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_groups"}, false, new Callable<List<BookGroup>>() { // from class: io.legado.app.data.dao.BookGroupDao_Impl.7
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<BookGroup> call() {
                Cursor cursorQuery = DBUtil.query(BookGroupDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupName");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new BookGroup(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public LiveData<List<BookGroup>> liveDataShow() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("\n        SELECT `book_groups`.`groupId` AS `groupId`, `book_groups`.`groupName` AS `groupName`, `book_groups`.`order` AS `order`, `book_groups`.`show` AS `show` FROM book_groups where (groupId >= 0 and show > 0)\n        or (groupId = -4 and show > 0 and (select count(bookUrl) from books where type != 1 and origin != 'loc_book' and ((SELECT sum(groupId) FROM book_groups where groupId > 0) & `group`) = 0) > 0)\n        or (groupId = -3 and show > 0 and (select count(bookUrl) from books where type = 1) > 0)\n        or (groupId = -2 and show > 0 and (select count(bookUrl) from books where origin = 'loc_book') > 0)\n        or (groupId = -1 and show > 0)\n        ORDER BY `order`\n    ", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_groups", "books"}, false, new Callable<List<BookGroup>>() { // from class: io.legado.app.data.dao.BookGroupDao_Impl.6
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<BookGroup> call() {
                Cursor cursorQuery = DBUtil.query(BookGroupDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupName");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new BookGroup(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.BookGroupDao
    public void update(BookGroup... bookGroupArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfBookGroup.handleMultiple(bookGroupArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
