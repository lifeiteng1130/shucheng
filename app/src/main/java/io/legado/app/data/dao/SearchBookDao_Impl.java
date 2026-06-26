package io.legado.app.data.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import io.legado.app.data.entities.SearchBook;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchBookDao_Impl implements SearchBookDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SearchBook> __insertionAdapterOfSearchBook;
    private final SharedSQLiteStatement __preparedStmtOfClear;
    private final SharedSQLiteStatement __preparedStmtOfClearExpired;

    public SearchBookDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSearchBook = new EntityInsertionAdapter<SearchBook>(roomDatabase) { // from class: io.legado.app.data.dao.SearchBookDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `searchBooks` (`bookUrl`,`origin`,`originName`,`type`,`name`,`author`,`kind`,`coverUrl`,`intro`,`wordCount`,`latestChapterTitle`,`tocUrl`,`time`,`variable`,`originOrder`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SearchBook searchBook) {
                if (searchBook.getBookUrl() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, searchBook.getBookUrl());
                }
                if (searchBook.getOrigin() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, searchBook.getOrigin());
                }
                if (searchBook.getOriginName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, searchBook.getOriginName());
                }
                supportSQLiteStatement.bindLong(4, searchBook.getType());
                if (searchBook.getName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, searchBook.getName());
                }
                if (searchBook.getAuthor() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, searchBook.getAuthor());
                }
                if (searchBook.getKind() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, searchBook.getKind());
                }
                if (searchBook.getCoverUrl() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, searchBook.getCoverUrl());
                }
                if (searchBook.getIntro() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, searchBook.getIntro());
                }
                if (searchBook.getWordCount() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, searchBook.getWordCount());
                }
                if (searchBook.getLatestChapterTitle() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, searchBook.getLatestChapterTitle());
                }
                if (searchBook.getTocUrl() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, searchBook.getTocUrl());
                }
                supportSQLiteStatement.bindLong(13, searchBook.getTime());
                if (searchBook.getVariable() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, searchBook.getVariable());
                }
                supportSQLiteStatement.bindLong(15, searchBook.getOriginOrder());
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(roomDatabase) { // from class: io.legado.app.data.dao.SearchBookDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from searchBooks where name = ? and author = ?";
            }
        };
        this.__preparedStmtOfClearExpired = new SharedSQLiteStatement(roomDatabase) { // from class: io.legado.app.data.dao.SearchBookDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from searchBooks where time < ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // io.legado.app.data.dao.SearchBookDao
    public void clear(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfClear.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClear.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.legado.app.data.dao.SearchBookDao
    public void clearExpired(long j2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfClearExpired.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j2);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClearExpired.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.legado.app.data.dao.SearchBookDao
    public List<SearchBook> getChangeSourceSearch(String str, String str2, String str3) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        String string;
        int i2;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("\n        select t1.name, t1.author, t1.origin, t1.originName, t1.coverUrl, t1.bookUrl, t1.type, t1.time, t1.intro, t1.kind, t1.latestChapterTitle, t1.tocUrl, t1.variable, t1.wordCount, t2.customOrder as originOrder\n        from searchBooks as t1 inner join book_sources as t2 \n        on t1.origin = t2.bookSourceUrl \n        where t1.name = ? and t1.author like '%'||?||'%' and t2.enabled = 1 and t2.bookSourceGroup like '%'||?||'%'\n        order by t2.customOrder\n        ", 3);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        if (str3 == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, str3);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
            int i3 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                String string7 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                int i4 = cursorQuery.getInt(columnIndexOrThrow7);
                long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                String string8 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                String string9 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                String string10 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                String string11 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                if (cursorQuery.isNull(columnIndexOrThrow13)) {
                    i2 = i3;
                    string = null;
                } else {
                    string = cursorQuery.getString(columnIndexOrThrow13);
                    i2 = i3;
                }
                int i5 = columnIndexOrThrow;
                int i6 = columnIndexOrThrow15;
                arrayList.add(new SearchBook(string7, string4, string5, i4, string2, string3, string9, string6, string8, cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2), string10, string11, j2, string, cursorQuery.getInt(i6)));
                columnIndexOrThrow = i5;
                columnIndexOrThrow15 = i6;
                i3 = i2;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // io.legado.app.data.dao.SearchBookDao
    public List<SearchBook> getEnableHasCover(String str, String str2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i2;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("\n        select t1.name, t1.author, t1.origin, t1.originName, t1.coverUrl, t1.bookUrl, t1.type, t1.time, t1.intro, t1.kind, t1.latestChapterTitle, t1.tocUrl, t1.variable, t1.wordCount, t2.customOrder as originOrder\n        from searchBooks as t1 inner join book_sources as t2 \n        on t1.origin = t2.bookSourceUrl \n        where t1.name = ? and t1.author = ? and t1.coverUrl is not null and t1.coverUrl <> '' and t2.enabled = 1\n        order by t2.customOrder\n        ", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                    String string7 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                    int i4 = cursorQuery.getInt(columnIndexOrThrow7);
                    long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                    String string8 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                    String string9 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                    String string10 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                    String string11 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                    if (cursorQuery.isNull(columnIndexOrThrow13)) {
                        i2 = i3;
                        string = null;
                    } else {
                        string = cursorQuery.getString(columnIndexOrThrow13);
                        i2 = i3;
                    }
                    int i5 = columnIndexOrThrow;
                    int i6 = columnIndexOrThrow15;
                    arrayList.add(new SearchBook(string7, string4, string5, i4, string2, string3, string9, string6, string8, cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2), string10, string11, j2, string, cursorQuery.getInt(i6)));
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow15 = i6;
                    i3 = i2;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // io.legado.app.data.dao.SearchBookDao
    public SearchBook getFirstByNameAuthor(String str, String str2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        SearchBook searchBook;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from searchBooks where name = ? and author = ? and origin in (select bookSourceUrl from book_sources) order by originOrder limit 1", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
            if (cursorQuery.moveToFirst()) {
                searchBook = new SearchBook(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), cursorQuery.getLong(columnIndexOrThrow13), cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14), cursorQuery.getInt(columnIndexOrThrow15));
            } else {
                searchBook = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return searchBook;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // io.legado.app.data.dao.SearchBookDao
    public SearchBook getSearchBook(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        SearchBook searchBook;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from searchBooks where bookUrl = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                if (cursorQuery.moveToFirst()) {
                    searchBook = new SearchBook(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), cursorQuery.getLong(columnIndexOrThrow13), cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14), cursorQuery.getInt(columnIndexOrThrow15));
                } else {
                    searchBook = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return searchBook;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // io.legado.app.data.dao.SearchBookDao
    public List<Long> insert(SearchBook... searchBookArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfSearchBook.insertAndReturnIdsList(searchBookArr);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.SearchBookDao
    public List<SearchBook> getChangeSourceSearch(String str, String str2, String str3, String str4) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i2;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("\n        select t1.name, t1.author, t1.origin, t1.originName, t1.coverUrl, t1.bookUrl, t1.type, t1.time, t1.intro, t1.kind, t1.latestChapterTitle, t1.tocUrl, t1.variable, t1.wordCount, t2.customOrder as originOrder\n        from searchBooks as t1 inner join book_sources as t2 \n        on t1.origin = t2.bookSourceUrl \n        where t1.name = ? and t1.author = ? and originName like '%'||?||'%' and t2.enabled = 1 and t2.bookSourceGroup like '%'||?||'%'\n        order by t2.customOrder\n        ", 4);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        if (str3 == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, str3);
        }
        if (str4 == null) {
            roomSQLiteQueryAcquire.bindNull(4);
        } else {
            roomSQLiteQueryAcquire.bindString(4, str4);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                    String string7 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                    int i4 = cursorQuery.getInt(columnIndexOrThrow7);
                    long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                    String string8 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                    String string9 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                    String string10 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                    String string11 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                    if (cursorQuery.isNull(columnIndexOrThrow13)) {
                        i2 = i3;
                        string = null;
                    } else {
                        string = cursorQuery.getString(columnIndexOrThrow13);
                        i2 = i3;
                    }
                    int i5 = columnIndexOrThrow;
                    int i6 = columnIndexOrThrow15;
                    arrayList.add(new SearchBook(string7, string4, string5, i4, string2, string3, string9, string6, string8, cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2), string10, string11, j2, string, cursorQuery.getInt(i6)));
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow15 = i6;
                    i3 = i2;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }
}
