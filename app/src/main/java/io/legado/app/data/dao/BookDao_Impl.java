package io.legado.app.data.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.view.LiveData;
import io.legado.app.data.entities.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class BookDao_Impl implements BookDao {
    private final Book.Converters __converters = new Book.Converters();
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<Book> __deletionAdapterOfBook;
    private final EntityInsertionAdapter<Book> __insertionAdapterOfBook;
    private final SharedSQLiteStatement __preparedStmtOfUpGroup;
    private final SharedSQLiteStatement __preparedStmtOfUpProgress;
    private final EntityDeletionOrUpdateAdapter<Book> __updateAdapterOfBook;

    public BookDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfBook = new EntityInsertionAdapter<Book>(roomDatabase) { // from class: io.legado.app.data.dao.BookDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `books` (`bookUrl`,`tocUrl`,`origin`,`originName`,`name`,`author`,`kind`,`customTag`,`coverUrl`,`customCoverUrl`,`intro`,`customIntro`,`charset`,`type`,`group`,`latestChapterTitle`,`latestChapterTime`,`lastCheckTime`,`lastCheckCount`,`totalChapterNum`,`durChapterTitle`,`durChapterIndex`,`durChapterPos`,`durChapterTime`,`wordCount`,`canUpdate`,`order`,`originOrder`,`variable`,`readConfig`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Book book) {
                if (book.getBookUrl() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, book.getBookUrl());
                }
                if (book.getTocUrl() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, book.getTocUrl());
                }
                if (book.getOrigin() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, book.getOrigin());
                }
                if (book.getOriginName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, book.getOriginName());
                }
                if (book.getName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, book.getName());
                }
                if (book.getAuthor() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, book.getAuthor());
                }
                if (book.getKind() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, book.getKind());
                }
                if (book.getCustomTag() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, book.getCustomTag());
                }
                if (book.getCoverUrl() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, book.getCoverUrl());
                }
                if (book.getCustomCoverUrl() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, book.getCustomCoverUrl());
                }
                if (book.getIntro() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, book.getIntro());
                }
                if (book.getCustomIntro() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, book.getCustomIntro());
                }
                if (book.getCharset() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, book.getCharset());
                }
                supportSQLiteStatement.bindLong(14, book.getType());
                supportSQLiteStatement.bindLong(15, book.getGroup());
                if (book.getLatestChapterTitle() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, book.getLatestChapterTitle());
                }
                supportSQLiteStatement.bindLong(17, book.getLatestChapterTime());
                supportSQLiteStatement.bindLong(18, book.getLastCheckTime());
                supportSQLiteStatement.bindLong(19, book.getLastCheckCount());
                supportSQLiteStatement.bindLong(20, book.getTotalChapterNum());
                if (book.getDurChapterTitle() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, book.getDurChapterTitle());
                }
                supportSQLiteStatement.bindLong(22, book.getDurChapterIndex());
                supportSQLiteStatement.bindLong(23, book.getDurChapterPos());
                supportSQLiteStatement.bindLong(24, book.getDurChapterTime());
                if (book.getWordCount() == null) {
                    supportSQLiteStatement.bindNull(25);
                } else {
                    supportSQLiteStatement.bindString(25, book.getWordCount());
                }
                supportSQLiteStatement.bindLong(26, book.getCanUpdate() ? 1L : 0L);
                supportSQLiteStatement.bindLong(27, book.getOrder());
                supportSQLiteStatement.bindLong(28, book.getOriginOrder());
                if (book.getVariable() == null) {
                    supportSQLiteStatement.bindNull(29);
                } else {
                    supportSQLiteStatement.bindString(29, book.getVariable());
                }
                String configToString = BookDao_Impl.this.__converters.readConfigToString(book.getReadConfig());
                if (configToString == null) {
                    supportSQLiteStatement.bindNull(30);
                } else {
                    supportSQLiteStatement.bindString(30, configToString);
                }
            }
        };
        this.__deletionAdapterOfBook = new EntityDeletionOrUpdateAdapter<Book>(roomDatabase) { // from class: io.legado.app.data.dao.BookDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `books` WHERE `bookUrl` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Book book) {
                if (book.getBookUrl() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, book.getBookUrl());
                }
            }
        };
        this.__updateAdapterOfBook = new EntityDeletionOrUpdateAdapter<Book>(roomDatabase) { // from class: io.legado.app.data.dao.BookDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `books` SET `bookUrl` = ?,`tocUrl` = ?,`origin` = ?,`originName` = ?,`name` = ?,`author` = ?,`kind` = ?,`customTag` = ?,`coverUrl` = ?,`customCoverUrl` = ?,`intro` = ?,`customIntro` = ?,`charset` = ?,`type` = ?,`group` = ?,`latestChapterTitle` = ?,`latestChapterTime` = ?,`lastCheckTime` = ?,`lastCheckCount` = ?,`totalChapterNum` = ?,`durChapterTitle` = ?,`durChapterIndex` = ?,`durChapterPos` = ?,`durChapterTime` = ?,`wordCount` = ?,`canUpdate` = ?,`order` = ?,`originOrder` = ?,`variable` = ?,`readConfig` = ? WHERE `bookUrl` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Book book) {
                if (book.getBookUrl() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, book.getBookUrl());
                }
                if (book.getTocUrl() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, book.getTocUrl());
                }
                if (book.getOrigin() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, book.getOrigin());
                }
                if (book.getOriginName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, book.getOriginName());
                }
                if (book.getName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, book.getName());
                }
                if (book.getAuthor() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, book.getAuthor());
                }
                if (book.getKind() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, book.getKind());
                }
                if (book.getCustomTag() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, book.getCustomTag());
                }
                if (book.getCoverUrl() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, book.getCoverUrl());
                }
                if (book.getCustomCoverUrl() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, book.getCustomCoverUrl());
                }
                if (book.getIntro() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, book.getIntro());
                }
                if (book.getCustomIntro() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, book.getCustomIntro());
                }
                if (book.getCharset() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, book.getCharset());
                }
                supportSQLiteStatement.bindLong(14, book.getType());
                supportSQLiteStatement.bindLong(15, book.getGroup());
                if (book.getLatestChapterTitle() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, book.getLatestChapterTitle());
                }
                supportSQLiteStatement.bindLong(17, book.getLatestChapterTime());
                supportSQLiteStatement.bindLong(18, book.getLastCheckTime());
                supportSQLiteStatement.bindLong(19, book.getLastCheckCount());
                supportSQLiteStatement.bindLong(20, book.getTotalChapterNum());
                if (book.getDurChapterTitle() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, book.getDurChapterTitle());
                }
                supportSQLiteStatement.bindLong(22, book.getDurChapterIndex());
                supportSQLiteStatement.bindLong(23, book.getDurChapterPos());
                supportSQLiteStatement.bindLong(24, book.getDurChapterTime());
                if (book.getWordCount() == null) {
                    supportSQLiteStatement.bindNull(25);
                } else {
                    supportSQLiteStatement.bindString(25, book.getWordCount());
                }
                supportSQLiteStatement.bindLong(26, book.getCanUpdate() ? 1L : 0L);
                supportSQLiteStatement.bindLong(27, book.getOrder());
                supportSQLiteStatement.bindLong(28, book.getOriginOrder());
                if (book.getVariable() == null) {
                    supportSQLiteStatement.bindNull(29);
                } else {
                    supportSQLiteStatement.bindString(29, book.getVariable());
                }
                String configToString = BookDao_Impl.this.__converters.readConfigToString(book.getReadConfig());
                if (configToString == null) {
                    supportSQLiteStatement.bindNull(30);
                } else {
                    supportSQLiteStatement.bindString(30, configToString);
                }
                if (book.getBookUrl() == null) {
                    supportSQLiteStatement.bindNull(31);
                } else {
                    supportSQLiteStatement.bindString(31, book.getBookUrl());
                }
            }
        };
        this.__preparedStmtOfUpProgress = new SharedSQLiteStatement(roomDatabase) { // from class: io.legado.app.data.dao.BookDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "update books set durChapterPos = ? where bookUrl = ?";
            }
        };
        this.__preparedStmtOfUpGroup = new SharedSQLiteStatement(roomDatabase) { // from class: io.legado.app.data.dao.BookDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "update books set `group` = ? where `group` = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // io.legado.app.data.dao.BookDao
    public void delete(Book... bookArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfBook.handleMultiple(bookArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public List<Book> findByName(String... strArr) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        int i4;
        String string4;
        int i5;
        int i6;
        boolean z;
        String string5;
        int i7;
        int i8;
        int i9;
        String string6;
        int i10;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM books WHERE `name` in (");
        int length = strArr.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length + 0);
        int i11 = 1;
        for (String str : strArr) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i11);
            } else {
                roomSQLiteQueryAcquire.bindString(i11, str);
            }
            i11++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                    int i12 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        String string14 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string15 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string16 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string17 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string18 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (cursorQuery.isNull(columnIndexOrThrow13)) {
                            i2 = i12;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow13);
                            i2 = i12;
                        }
                        int i13 = cursorQuery.getInt(i2);
                        int i14 = columnIndexOrThrow;
                        int i15 = columnIndexOrThrow15;
                        long j2 = cursorQuery.getLong(i15);
                        columnIndexOrThrow15 = i15;
                        int i16 = columnIndexOrThrow16;
                        if (cursorQuery.isNull(i16)) {
                            columnIndexOrThrow16 = i16;
                            i3 = columnIndexOrThrow17;
                            string2 = null;
                        } else {
                            string2 = cursorQuery.getString(i16);
                            columnIndexOrThrow16 = i16;
                            i3 = columnIndexOrThrow17;
                        }
                        long j3 = cursorQuery.getLong(i3);
                        columnIndexOrThrow17 = i3;
                        int i17 = columnIndexOrThrow18;
                        long j4 = cursorQuery.getLong(i17);
                        columnIndexOrThrow18 = i17;
                        int i18 = columnIndexOrThrow19;
                        int i19 = cursorQuery.getInt(i18);
                        columnIndexOrThrow19 = i18;
                        int i20 = columnIndexOrThrow20;
                        int i21 = cursorQuery.getInt(i20);
                        columnIndexOrThrow20 = i20;
                        int i22 = columnIndexOrThrow21;
                        if (cursorQuery.isNull(i22)) {
                            columnIndexOrThrow21 = i22;
                            i4 = columnIndexOrThrow22;
                            string3 = null;
                        } else {
                            string3 = cursorQuery.getString(i22);
                            columnIndexOrThrow21 = i22;
                            i4 = columnIndexOrThrow22;
                        }
                        int i23 = cursorQuery.getInt(i4);
                        columnIndexOrThrow22 = i4;
                        int i24 = columnIndexOrThrow23;
                        int i25 = cursorQuery.getInt(i24);
                        columnIndexOrThrow23 = i24;
                        int i26 = columnIndexOrThrow24;
                        long j5 = cursorQuery.getLong(i26);
                        columnIndexOrThrow24 = i26;
                        int i27 = columnIndexOrThrow25;
                        if (cursorQuery.isNull(i27)) {
                            columnIndexOrThrow25 = i27;
                            i5 = columnIndexOrThrow26;
                            string4 = null;
                        } else {
                            string4 = cursorQuery.getString(i27);
                            columnIndexOrThrow25 = i27;
                            i5 = columnIndexOrThrow26;
                        }
                        if (cursorQuery.getInt(i5) != 0) {
                            columnIndexOrThrow26 = i5;
                            i6 = columnIndexOrThrow27;
                            z = true;
                        } else {
                            columnIndexOrThrow26 = i5;
                            i6 = columnIndexOrThrow27;
                            z = false;
                        }
                        int i28 = cursorQuery.getInt(i6);
                        columnIndexOrThrow27 = i6;
                        int i29 = columnIndexOrThrow28;
                        int i30 = cursorQuery.getInt(i29);
                        columnIndexOrThrow28 = i29;
                        int i31 = columnIndexOrThrow29;
                        if (cursorQuery.isNull(i31)) {
                            columnIndexOrThrow29 = i31;
                            i7 = columnIndexOrThrow30;
                            string5 = null;
                        } else {
                            string5 = cursorQuery.getString(i31);
                            columnIndexOrThrow29 = i31;
                            i7 = columnIndexOrThrow30;
                        }
                        if (cursorQuery.isNull(i7)) {
                            i8 = i7;
                            i10 = i2;
                            i9 = columnIndexOrThrow11;
                            string6 = null;
                        } else {
                            i8 = i7;
                            i9 = columnIndexOrThrow11;
                            string6 = cursorQuery.getString(i7);
                            i10 = i2;
                        }
                        try {
                            arrayList.add(new Book(string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string, i13, j2, string2, j3, j4, i19, i21, string3, i23, i25, j5, string4, z, i28, i30, string5, this.__converters.stringToReadConfig(string6)));
                            columnIndexOrThrow = i14;
                            columnIndexOrThrow11 = i9;
                            i12 = i10;
                            columnIndexOrThrow30 = i8;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public List<Book> getAll() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        int i4;
        String string4;
        int i5;
        int i6;
        boolean z;
        String string5;
        int i7;
        int i8;
        int i9;
        String string6;
        int i10;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `books`.`bookUrl` AS `bookUrl`, `books`.`tocUrl` AS `tocUrl`, `books`.`origin` AS `origin`, `books`.`originName` AS `originName`, `books`.`name` AS `name`, `books`.`author` AS `author`, `books`.`kind` AS `kind`, `books`.`customTag` AS `customTag`, `books`.`coverUrl` AS `coverUrl`, `books`.`customCoverUrl` AS `customCoverUrl`, `books`.`intro` AS `intro`, `books`.`customIntro` AS `customIntro`, `books`.`charset` AS `charset`, `books`.`type` AS `type`, `books`.`group` AS `group`, `books`.`latestChapterTitle` AS `latestChapterTitle`, `books`.`latestChapterTime` AS `latestChapterTime`, `books`.`lastCheckTime` AS `lastCheckTime`, `books`.`lastCheckCount` AS `lastCheckCount`, `books`.`totalChapterNum` AS `totalChapterNum`, `books`.`durChapterTitle` AS `durChapterTitle`, `books`.`durChapterIndex` AS `durChapterIndex`, `books`.`durChapterPos` AS `durChapterPos`, `books`.`durChapterTime` AS `durChapterTime`, `books`.`wordCount` AS `wordCount`, `books`.`canUpdate` AS `canUpdate`, `books`.`order` AS `order`, `books`.`originOrder` AS `originOrder`, `books`.`variable` AS `variable`, `books`.`readConfig` AS `readConfig` FROM books", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                    int i11 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        String string14 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string15 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string16 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string17 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string18 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (cursorQuery.isNull(columnIndexOrThrow13)) {
                            i2 = i11;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow13);
                            i2 = i11;
                        }
                        int i12 = cursorQuery.getInt(i2);
                        int i13 = columnIndexOrThrow;
                        int i14 = columnIndexOrThrow15;
                        long j2 = cursorQuery.getLong(i14);
                        columnIndexOrThrow15 = i14;
                        int i15 = columnIndexOrThrow16;
                        if (cursorQuery.isNull(i15)) {
                            columnIndexOrThrow16 = i15;
                            i3 = columnIndexOrThrow17;
                            string2 = null;
                        } else {
                            string2 = cursorQuery.getString(i15);
                            columnIndexOrThrow16 = i15;
                            i3 = columnIndexOrThrow17;
                        }
                        long j3 = cursorQuery.getLong(i3);
                        columnIndexOrThrow17 = i3;
                        int i16 = columnIndexOrThrow18;
                        long j4 = cursorQuery.getLong(i16);
                        columnIndexOrThrow18 = i16;
                        int i17 = columnIndexOrThrow19;
                        int i18 = cursorQuery.getInt(i17);
                        columnIndexOrThrow19 = i17;
                        int i19 = columnIndexOrThrow20;
                        int i20 = cursorQuery.getInt(i19);
                        columnIndexOrThrow20 = i19;
                        int i21 = columnIndexOrThrow21;
                        if (cursorQuery.isNull(i21)) {
                            columnIndexOrThrow21 = i21;
                            i4 = columnIndexOrThrow22;
                            string3 = null;
                        } else {
                            string3 = cursorQuery.getString(i21);
                            columnIndexOrThrow21 = i21;
                            i4 = columnIndexOrThrow22;
                        }
                        int i22 = cursorQuery.getInt(i4);
                        columnIndexOrThrow22 = i4;
                        int i23 = columnIndexOrThrow23;
                        int i24 = cursorQuery.getInt(i23);
                        columnIndexOrThrow23 = i23;
                        int i25 = columnIndexOrThrow24;
                        long j5 = cursorQuery.getLong(i25);
                        columnIndexOrThrow24 = i25;
                        int i26 = columnIndexOrThrow25;
                        if (cursorQuery.isNull(i26)) {
                            columnIndexOrThrow25 = i26;
                            i5 = columnIndexOrThrow26;
                            string4 = null;
                        } else {
                            string4 = cursorQuery.getString(i26);
                            columnIndexOrThrow25 = i26;
                            i5 = columnIndexOrThrow26;
                        }
                        if (cursorQuery.getInt(i5) != 0) {
                            columnIndexOrThrow26 = i5;
                            i6 = columnIndexOrThrow27;
                            z = true;
                        } else {
                            columnIndexOrThrow26 = i5;
                            i6 = columnIndexOrThrow27;
                            z = false;
                        }
                        int i27 = cursorQuery.getInt(i6);
                        columnIndexOrThrow27 = i6;
                        int i28 = columnIndexOrThrow28;
                        int i29 = cursorQuery.getInt(i28);
                        columnIndexOrThrow28 = i28;
                        int i30 = columnIndexOrThrow29;
                        if (cursorQuery.isNull(i30)) {
                            columnIndexOrThrow29 = i30;
                            i7 = columnIndexOrThrow30;
                            string5 = null;
                        } else {
                            string5 = cursorQuery.getString(i30);
                            columnIndexOrThrow29 = i30;
                            i7 = columnIndexOrThrow30;
                        }
                        if (cursorQuery.isNull(i7)) {
                            i8 = i7;
                            i10 = columnIndexOrThrow12;
                            i9 = i2;
                            string6 = null;
                        } else {
                            i8 = i7;
                            i9 = i2;
                            string6 = cursorQuery.getString(i7);
                            i10 = columnIndexOrThrow12;
                        }
                        try {
                            arrayList.add(new Book(string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string, i12, j2, string2, j3, j4, i18, i20, string3, i22, i24, j5, string4, z, i27, i29, string5, this.__converters.stringToReadConfig(string6)));
                            columnIndexOrThrow12 = i10;
                            columnIndexOrThrow = i13;
                            columnIndexOrThrow30 = i8;
                            i11 = i9;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public int getAllBookCount() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM books", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public List<String> getAllBookUrls() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT bookUrl FROM books", 0);
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

    @Override // io.legado.app.data.dao.BookDao
    public Book getBook(String str) throws Throwable {
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
        Book book;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        int i4;
        int i5;
        boolean z;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM books WHERE bookUrl = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
            if (cursorQuery.moveToFirst()) {
                String string4 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                String string5 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                String string6 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string7 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                String string8 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                String string9 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                String string10 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                String string11 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                String string12 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                String string13 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                String string14 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                String string15 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                String string16 = cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13);
                int i6 = cursorQuery.getInt(columnIndexOrThrow14);
                long j2 = cursorQuery.getLong(columnIndexOrThrow15);
                if (cursorQuery.isNull(columnIndexOrThrow16)) {
                    i2 = columnIndexOrThrow17;
                    string = null;
                } else {
                    string = cursorQuery.getString(columnIndexOrThrow16);
                    i2 = columnIndexOrThrow17;
                }
                long j3 = cursorQuery.getLong(i2);
                long j4 = cursorQuery.getLong(columnIndexOrThrow18);
                int i7 = cursorQuery.getInt(columnIndexOrThrow19);
                int i8 = cursorQuery.getInt(columnIndexOrThrow20);
                if (cursorQuery.isNull(columnIndexOrThrow21)) {
                    i3 = columnIndexOrThrow22;
                    string2 = null;
                } else {
                    string2 = cursorQuery.getString(columnIndexOrThrow21);
                    i3 = columnIndexOrThrow22;
                }
                int i9 = cursorQuery.getInt(i3);
                int i10 = cursorQuery.getInt(columnIndexOrThrow23);
                long j5 = cursorQuery.getLong(columnIndexOrThrow24);
                if (cursorQuery.isNull(columnIndexOrThrow25)) {
                    i4 = columnIndexOrThrow26;
                    string3 = null;
                } else {
                    string3 = cursorQuery.getString(columnIndexOrThrow25);
                    i4 = columnIndexOrThrow26;
                }
                if (cursorQuery.getInt(i4) != 0) {
                    i5 = columnIndexOrThrow27;
                    z = true;
                } else {
                    i5 = columnIndexOrThrow27;
                    z = false;
                }
                book = new Book(string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, i6, j2, string, j3, j4, i7, i8, string2, i9, i10, j5, string3, z, cursorQuery.getInt(i5), cursorQuery.getInt(columnIndexOrThrow28), cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29), this.__converters.stringToReadConfig(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30)));
            } else {
                book = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return book;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public List<Book> getBooksByGroup(long j2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        int i4;
        String string4;
        int i5;
        int i6;
        boolean z;
        String string5;
        int i7;
        int i8;
        int i9;
        String string6;
        int i10;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM books WHERE (`group` & ?) > 0", 1);
        roomSQLiteQueryAcquire.bindLong(1, j2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                    int i11 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        String string14 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string15 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string16 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string17 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string18 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (cursorQuery.isNull(columnIndexOrThrow13)) {
                            i2 = i11;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow13);
                            i2 = i11;
                        }
                        int i12 = cursorQuery.getInt(i2);
                        int i13 = columnIndexOrThrow;
                        int i14 = columnIndexOrThrow15;
                        long j3 = cursorQuery.getLong(i14);
                        columnIndexOrThrow15 = i14;
                        int i15 = columnIndexOrThrow16;
                        if (cursorQuery.isNull(i15)) {
                            columnIndexOrThrow16 = i15;
                            i3 = columnIndexOrThrow17;
                            string2 = null;
                        } else {
                            string2 = cursorQuery.getString(i15);
                            columnIndexOrThrow16 = i15;
                            i3 = columnIndexOrThrow17;
                        }
                        long j4 = cursorQuery.getLong(i3);
                        columnIndexOrThrow17 = i3;
                        int i16 = columnIndexOrThrow18;
                        long j5 = cursorQuery.getLong(i16);
                        columnIndexOrThrow18 = i16;
                        int i17 = columnIndexOrThrow19;
                        int i18 = cursorQuery.getInt(i17);
                        columnIndexOrThrow19 = i17;
                        int i19 = columnIndexOrThrow20;
                        int i20 = cursorQuery.getInt(i19);
                        columnIndexOrThrow20 = i19;
                        int i21 = columnIndexOrThrow21;
                        if (cursorQuery.isNull(i21)) {
                            columnIndexOrThrow21 = i21;
                            i4 = columnIndexOrThrow22;
                            string3 = null;
                        } else {
                            string3 = cursorQuery.getString(i21);
                            columnIndexOrThrow21 = i21;
                            i4 = columnIndexOrThrow22;
                        }
                        int i22 = cursorQuery.getInt(i4);
                        columnIndexOrThrow22 = i4;
                        int i23 = columnIndexOrThrow23;
                        int i24 = cursorQuery.getInt(i23);
                        columnIndexOrThrow23 = i23;
                        int i25 = columnIndexOrThrow24;
                        long j6 = cursorQuery.getLong(i25);
                        columnIndexOrThrow24 = i25;
                        int i26 = columnIndexOrThrow25;
                        if (cursorQuery.isNull(i26)) {
                            columnIndexOrThrow25 = i26;
                            i5 = columnIndexOrThrow26;
                            string4 = null;
                        } else {
                            string4 = cursorQuery.getString(i26);
                            columnIndexOrThrow25 = i26;
                            i5 = columnIndexOrThrow26;
                        }
                        if (cursorQuery.getInt(i5) != 0) {
                            columnIndexOrThrow26 = i5;
                            i6 = columnIndexOrThrow27;
                            z = true;
                        } else {
                            columnIndexOrThrow26 = i5;
                            i6 = columnIndexOrThrow27;
                            z = false;
                        }
                        int i27 = cursorQuery.getInt(i6);
                        columnIndexOrThrow27 = i6;
                        int i28 = columnIndexOrThrow28;
                        int i29 = cursorQuery.getInt(i28);
                        columnIndexOrThrow28 = i28;
                        int i30 = columnIndexOrThrow29;
                        if (cursorQuery.isNull(i30)) {
                            columnIndexOrThrow29 = i30;
                            i7 = columnIndexOrThrow30;
                            string5 = null;
                        } else {
                            string5 = cursorQuery.getString(i30);
                            columnIndexOrThrow29 = i30;
                            i7 = columnIndexOrThrow30;
                        }
                        if (cursorQuery.isNull(i7)) {
                            i8 = i7;
                            i10 = columnIndexOrThrow11;
                            i9 = i2;
                            string6 = null;
                        } else {
                            i8 = i7;
                            i9 = i2;
                            string6 = cursorQuery.getString(i7);
                            i10 = columnIndexOrThrow11;
                        }
                        try {
                            arrayList.add(new Book(string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string, i12, j3, string2, j4, j5, i18, i20, string3, i22, i24, j6, string4, z, i27, i29, string5, this.__converters.stringToReadConfig(string6)));
                            columnIndexOrThrow11 = i10;
                            columnIndexOrThrow = i13;
                            columnIndexOrThrow30 = i8;
                            i11 = i9;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public List<Book> getHasUpdateBooks() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        int i4;
        String string4;
        int i5;
        int i6;
        boolean z;
        String string5;
        int i7;
        int i8;
        int i9;
        String string6;
        int i10;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `books`.`bookUrl` AS `bookUrl`, `books`.`tocUrl` AS `tocUrl`, `books`.`origin` AS `origin`, `books`.`originName` AS `originName`, `books`.`name` AS `name`, `books`.`author` AS `author`, `books`.`kind` AS `kind`, `books`.`customTag` AS `customTag`, `books`.`coverUrl` AS `coverUrl`, `books`.`customCoverUrl` AS `customCoverUrl`, `books`.`intro` AS `intro`, `books`.`customIntro` AS `customIntro`, `books`.`charset` AS `charset`, `books`.`type` AS `type`, `books`.`group` AS `group`, `books`.`latestChapterTitle` AS `latestChapterTitle`, `books`.`latestChapterTime` AS `latestChapterTime`, `books`.`lastCheckTime` AS `lastCheckTime`, `books`.`lastCheckCount` AS `lastCheckCount`, `books`.`totalChapterNum` AS `totalChapterNum`, `books`.`durChapterTitle` AS `durChapterTitle`, `books`.`durChapterIndex` AS `durChapterIndex`, `books`.`durChapterPos` AS `durChapterPos`, `books`.`durChapterTime` AS `durChapterTime`, `books`.`wordCount` AS `wordCount`, `books`.`canUpdate` AS `canUpdate`, `books`.`order` AS `order`, `books`.`originOrder` AS `originOrder`, `books`.`variable` AS `variable`, `books`.`readConfig` AS `readConfig` FROM books where origin <> 'loc_book' and canUpdate = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                    int i11 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        String string14 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string15 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string16 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string17 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string18 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (cursorQuery.isNull(columnIndexOrThrow13)) {
                            i2 = i11;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow13);
                            i2 = i11;
                        }
                        int i12 = cursorQuery.getInt(i2);
                        int i13 = columnIndexOrThrow;
                        int i14 = columnIndexOrThrow15;
                        long j2 = cursorQuery.getLong(i14);
                        columnIndexOrThrow15 = i14;
                        int i15 = columnIndexOrThrow16;
                        if (cursorQuery.isNull(i15)) {
                            columnIndexOrThrow16 = i15;
                            i3 = columnIndexOrThrow17;
                            string2 = null;
                        } else {
                            string2 = cursorQuery.getString(i15);
                            columnIndexOrThrow16 = i15;
                            i3 = columnIndexOrThrow17;
                        }
                        long j3 = cursorQuery.getLong(i3);
                        columnIndexOrThrow17 = i3;
                        int i16 = columnIndexOrThrow18;
                        long j4 = cursorQuery.getLong(i16);
                        columnIndexOrThrow18 = i16;
                        int i17 = columnIndexOrThrow19;
                        int i18 = cursorQuery.getInt(i17);
                        columnIndexOrThrow19 = i17;
                        int i19 = columnIndexOrThrow20;
                        int i20 = cursorQuery.getInt(i19);
                        columnIndexOrThrow20 = i19;
                        int i21 = columnIndexOrThrow21;
                        if (cursorQuery.isNull(i21)) {
                            columnIndexOrThrow21 = i21;
                            i4 = columnIndexOrThrow22;
                            string3 = null;
                        } else {
                            string3 = cursorQuery.getString(i21);
                            columnIndexOrThrow21 = i21;
                            i4 = columnIndexOrThrow22;
                        }
                        int i22 = cursorQuery.getInt(i4);
                        columnIndexOrThrow22 = i4;
                        int i23 = columnIndexOrThrow23;
                        int i24 = cursorQuery.getInt(i23);
                        columnIndexOrThrow23 = i23;
                        int i25 = columnIndexOrThrow24;
                        long j5 = cursorQuery.getLong(i25);
                        columnIndexOrThrow24 = i25;
                        int i26 = columnIndexOrThrow25;
                        if (cursorQuery.isNull(i26)) {
                            columnIndexOrThrow25 = i26;
                            i5 = columnIndexOrThrow26;
                            string4 = null;
                        } else {
                            string4 = cursorQuery.getString(i26);
                            columnIndexOrThrow25 = i26;
                            i5 = columnIndexOrThrow26;
                        }
                        if (cursorQuery.getInt(i5) != 0) {
                            columnIndexOrThrow26 = i5;
                            i6 = columnIndexOrThrow27;
                            z = true;
                        } else {
                            columnIndexOrThrow26 = i5;
                            i6 = columnIndexOrThrow27;
                            z = false;
                        }
                        int i27 = cursorQuery.getInt(i6);
                        columnIndexOrThrow27 = i6;
                        int i28 = columnIndexOrThrow28;
                        int i29 = cursorQuery.getInt(i28);
                        columnIndexOrThrow28 = i28;
                        int i30 = columnIndexOrThrow29;
                        if (cursorQuery.isNull(i30)) {
                            columnIndexOrThrow29 = i30;
                            i7 = columnIndexOrThrow30;
                            string5 = null;
                        } else {
                            string5 = cursorQuery.getString(i30);
                            columnIndexOrThrow29 = i30;
                            i7 = columnIndexOrThrow30;
                        }
                        if (cursorQuery.isNull(i7)) {
                            i8 = i7;
                            i10 = columnIndexOrThrow12;
                            i9 = i2;
                            string6 = null;
                        } else {
                            i8 = i7;
                            i9 = i2;
                            string6 = cursorQuery.getString(i7);
                            i10 = columnIndexOrThrow12;
                        }
                        try {
                            arrayList.add(new Book(string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string, i12, j2, string2, j3, j4, i18, i20, string3, i22, i24, j5, string4, z, i27, i29, string5, this.__converters.stringToReadConfig(string6)));
                            columnIndexOrThrow12 = i10;
                            columnIndexOrThrow = i13;
                            columnIndexOrThrow30 = i8;
                            i11 = i9;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public Book getLastReadBook() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        Book book;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        int i4;
        int i5;
        boolean z;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `books`.`bookUrl` AS `bookUrl`, `books`.`tocUrl` AS `tocUrl`, `books`.`origin` AS `origin`, `books`.`originName` AS `originName`, `books`.`name` AS `name`, `books`.`author` AS `author`, `books`.`kind` AS `kind`, `books`.`customTag` AS `customTag`, `books`.`coverUrl` AS `coverUrl`, `books`.`customCoverUrl` AS `customCoverUrl`, `books`.`intro` AS `intro`, `books`.`customIntro` AS `customIntro`, `books`.`charset` AS `charset`, `books`.`type` AS `type`, `books`.`group` AS `group`, `books`.`latestChapterTitle` AS `latestChapterTitle`, `books`.`latestChapterTime` AS `latestChapterTime`, `books`.`lastCheckTime` AS `lastCheckTime`, `books`.`lastCheckCount` AS `lastCheckCount`, `books`.`totalChapterNum` AS `totalChapterNum`, `books`.`durChapterTitle` AS `durChapterTitle`, `books`.`durChapterIndex` AS `durChapterIndex`, `books`.`durChapterPos` AS `durChapterPos`, `books`.`durChapterTime` AS `durChapterTime`, `books`.`wordCount` AS `wordCount`, `books`.`canUpdate` AS `canUpdate`, `books`.`order` AS `order`, `books`.`originOrder` AS `originOrder`, `books`.`variable` AS `variable`, `books`.`readConfig` AS `readConfig` FROM books where type = 0 ORDER BY durChapterTime DESC limit 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                    if (cursorQuery.moveToFirst()) {
                        String string4 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string7 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        String string11 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string14 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string15 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        String string16 = cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13);
                        int i6 = cursorQuery.getInt(columnIndexOrThrow14);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow15);
                        if (cursorQuery.isNull(columnIndexOrThrow16)) {
                            i2 = columnIndexOrThrow17;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow16);
                            i2 = columnIndexOrThrow17;
                        }
                        long j3 = cursorQuery.getLong(i2);
                        long j4 = cursorQuery.getLong(columnIndexOrThrow18);
                        int i7 = cursorQuery.getInt(columnIndexOrThrow19);
                        int i8 = cursorQuery.getInt(columnIndexOrThrow20);
                        if (cursorQuery.isNull(columnIndexOrThrow21)) {
                            i3 = columnIndexOrThrow22;
                            string2 = null;
                        } else {
                            string2 = cursorQuery.getString(columnIndexOrThrow21);
                            i3 = columnIndexOrThrow22;
                        }
                        int i9 = cursorQuery.getInt(i3);
                        int i10 = cursorQuery.getInt(columnIndexOrThrow23);
                        long j5 = cursorQuery.getLong(columnIndexOrThrow24);
                        if (cursorQuery.isNull(columnIndexOrThrow25)) {
                            i4 = columnIndexOrThrow26;
                            string3 = null;
                        } else {
                            string3 = cursorQuery.getString(columnIndexOrThrow25);
                            i4 = columnIndexOrThrow26;
                        }
                        if (cursorQuery.getInt(i4) != 0) {
                            i5 = columnIndexOrThrow27;
                            z = true;
                        } else {
                            i5 = columnIndexOrThrow27;
                            z = false;
                        }
                        book = new Book(string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, i6, j2, string, j3, j4, i7, i8, string2, i9, i10, j5, string3, z, cursorQuery.getInt(i5), cursorQuery.getInt(columnIndexOrThrow28), cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29), this.__converters.stringToReadConfig(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30)));
                    } else {
                        book = null;
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return book;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public int getMaxOrder() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select max(`order`) from books", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public int getNoGroupSize() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select count(bookUrl) from books where (SELECT sum(groupId) FROM book_groups) & `group` = 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public List<Book> getWebBooks() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        int i4;
        String string4;
        int i5;
        int i6;
        boolean z;
        String string5;
        int i7;
        int i8;
        int i9;
        String string6;
        int i10;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `books`.`bookUrl` AS `bookUrl`, `books`.`tocUrl` AS `tocUrl`, `books`.`origin` AS `origin`, `books`.`originName` AS `originName`, `books`.`name` AS `name`, `books`.`author` AS `author`, `books`.`kind` AS `kind`, `books`.`customTag` AS `customTag`, `books`.`coverUrl` AS `coverUrl`, `books`.`customCoverUrl` AS `customCoverUrl`, `books`.`intro` AS `intro`, `books`.`customIntro` AS `customIntro`, `books`.`charset` AS `charset`, `books`.`type` AS `type`, `books`.`group` AS `group`, `books`.`latestChapterTitle` AS `latestChapterTitle`, `books`.`latestChapterTime` AS `latestChapterTime`, `books`.`lastCheckTime` AS `lastCheckTime`, `books`.`lastCheckCount` AS `lastCheckCount`, `books`.`totalChapterNum` AS `totalChapterNum`, `books`.`durChapterTitle` AS `durChapterTitle`, `books`.`durChapterIndex` AS `durChapterIndex`, `books`.`durChapterPos` AS `durChapterPos`, `books`.`durChapterTime` AS `durChapterTime`, `books`.`wordCount` AS `wordCount`, `books`.`canUpdate` AS `canUpdate`, `books`.`order` AS `order`, `books`.`originOrder` AS `originOrder`, `books`.`variable` AS `variable`, `books`.`readConfig` AS `readConfig` FROM books where origin <> 'loc_book' and type = 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                    int i11 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        String string14 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string15 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string16 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string17 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string18 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (cursorQuery.isNull(columnIndexOrThrow13)) {
                            i2 = i11;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow13);
                            i2 = i11;
                        }
                        int i12 = cursorQuery.getInt(i2);
                        int i13 = columnIndexOrThrow;
                        int i14 = columnIndexOrThrow15;
                        long j2 = cursorQuery.getLong(i14);
                        columnIndexOrThrow15 = i14;
                        int i15 = columnIndexOrThrow16;
                        if (cursorQuery.isNull(i15)) {
                            columnIndexOrThrow16 = i15;
                            i3 = columnIndexOrThrow17;
                            string2 = null;
                        } else {
                            string2 = cursorQuery.getString(i15);
                            columnIndexOrThrow16 = i15;
                            i3 = columnIndexOrThrow17;
                        }
                        long j3 = cursorQuery.getLong(i3);
                        columnIndexOrThrow17 = i3;
                        int i16 = columnIndexOrThrow18;
                        long j4 = cursorQuery.getLong(i16);
                        columnIndexOrThrow18 = i16;
                        int i17 = columnIndexOrThrow19;
                        int i18 = cursorQuery.getInt(i17);
                        columnIndexOrThrow19 = i17;
                        int i19 = columnIndexOrThrow20;
                        int i20 = cursorQuery.getInt(i19);
                        columnIndexOrThrow20 = i19;
                        int i21 = columnIndexOrThrow21;
                        if (cursorQuery.isNull(i21)) {
                            columnIndexOrThrow21 = i21;
                            i4 = columnIndexOrThrow22;
                            string3 = null;
                        } else {
                            string3 = cursorQuery.getString(i21);
                            columnIndexOrThrow21 = i21;
                            i4 = columnIndexOrThrow22;
                        }
                        int i22 = cursorQuery.getInt(i4);
                        columnIndexOrThrow22 = i4;
                        int i23 = columnIndexOrThrow23;
                        int i24 = cursorQuery.getInt(i23);
                        columnIndexOrThrow23 = i23;
                        int i25 = columnIndexOrThrow24;
                        long j5 = cursorQuery.getLong(i25);
                        columnIndexOrThrow24 = i25;
                        int i26 = columnIndexOrThrow25;
                        if (cursorQuery.isNull(i26)) {
                            columnIndexOrThrow25 = i26;
                            i5 = columnIndexOrThrow26;
                            string4 = null;
                        } else {
                            string4 = cursorQuery.getString(i26);
                            columnIndexOrThrow25 = i26;
                            i5 = columnIndexOrThrow26;
                        }
                        if (cursorQuery.getInt(i5) != 0) {
                            columnIndexOrThrow26 = i5;
                            i6 = columnIndexOrThrow27;
                            z = true;
                        } else {
                            columnIndexOrThrow26 = i5;
                            i6 = columnIndexOrThrow27;
                            z = false;
                        }
                        int i27 = cursorQuery.getInt(i6);
                        columnIndexOrThrow27 = i6;
                        int i28 = columnIndexOrThrow28;
                        int i29 = cursorQuery.getInt(i28);
                        columnIndexOrThrow28 = i28;
                        int i30 = columnIndexOrThrow29;
                        if (cursorQuery.isNull(i30)) {
                            columnIndexOrThrow29 = i30;
                            i7 = columnIndexOrThrow30;
                            string5 = null;
                        } else {
                            string5 = cursorQuery.getString(i30);
                            columnIndexOrThrow29 = i30;
                            i7 = columnIndexOrThrow30;
                        }
                        if (cursorQuery.isNull(i7)) {
                            i8 = i7;
                            i10 = columnIndexOrThrow12;
                            i9 = i2;
                            string6 = null;
                        } else {
                            i8 = i7;
                            i9 = i2;
                            string6 = cursorQuery.getString(i7);
                            i10 = columnIndexOrThrow12;
                        }
                        try {
                            arrayList.add(new Book(string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string, i12, j2, string2, j3, j4, i18, i20, string3, i22, i24, j5, string4, z, i27, i29, string5, this.__converters.stringToReadConfig(string6)));
                            columnIndexOrThrow12 = i10;
                            columnIndexOrThrow = i13;
                            columnIndexOrThrow30 = i8;
                            i11 = i9;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public void insert(Book... bookArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfBook.insert(bookArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public LiveData<List<Book>> liveDataSearch(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM books WHERE name like '%'||?||'%' or author like '%'||?||'%'", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"books"}, false, new Callable<List<Book>>() { // from class: io.legado.app.data.dao.BookDao_Impl.12
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<Book> call() throws Throwable {
                String string;
                int i2;
                String string2;
                int i3;
                String string3;
                int i4;
                String string4;
                int i5;
                int i6;
                boolean z;
                String string5;
                int i7;
                int i8;
                int i9;
                String string6;
                int i10;
                Cursor cursorQuery = DBUtil.query(BookDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                        int i11 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                            String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                            String string14 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string15 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string16 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string17 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            String string18 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                            if (cursorQuery.isNull(columnIndexOrThrow13)) {
                                i2 = i11;
                                string = null;
                            } else {
                                string = cursorQuery.getString(columnIndexOrThrow13);
                                i2 = i11;
                            }
                            int i12 = cursorQuery.getInt(i2);
                            int i13 = columnIndexOrThrow;
                            int i14 = columnIndexOrThrow15;
                            long j2 = cursorQuery.getLong(i14);
                            columnIndexOrThrow15 = i14;
                            int i15 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i15)) {
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i15);
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                            }
                            long j3 = cursorQuery.getLong(i3);
                            columnIndexOrThrow17 = i3;
                            int i16 = columnIndexOrThrow18;
                            long j4 = cursorQuery.getLong(i16);
                            columnIndexOrThrow18 = i16;
                            int i17 = columnIndexOrThrow19;
                            int i18 = cursorQuery.getInt(i17);
                            columnIndexOrThrow19 = i17;
                            int i19 = columnIndexOrThrow20;
                            int i20 = cursorQuery.getInt(i19);
                            columnIndexOrThrow20 = i19;
                            int i21 = columnIndexOrThrow21;
                            if (cursorQuery.isNull(i21)) {
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                                string3 = null;
                            } else {
                                string3 = cursorQuery.getString(i21);
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                            }
                            int i22 = cursorQuery.getInt(i4);
                            columnIndexOrThrow22 = i4;
                            int i23 = columnIndexOrThrow23;
                            int i24 = cursorQuery.getInt(i23);
                            columnIndexOrThrow23 = i23;
                            int i25 = columnIndexOrThrow24;
                            long j5 = cursorQuery.getLong(i25);
                            columnIndexOrThrow24 = i25;
                            int i26 = columnIndexOrThrow25;
                            if (cursorQuery.isNull(i26)) {
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i26);
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                            }
                            if (cursorQuery.getInt(i5) != 0) {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = true;
                            } else {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = false;
                            }
                            int i27 = cursorQuery.getInt(i6);
                            columnIndexOrThrow27 = i6;
                            int i28 = columnIndexOrThrow28;
                            int i29 = cursorQuery.getInt(i28);
                            columnIndexOrThrow28 = i28;
                            int i30 = columnIndexOrThrow29;
                            if (cursorQuery.isNull(i30)) {
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i30);
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                            }
                            if (cursorQuery.isNull(i7)) {
                                i8 = i7;
                                i10 = columnIndexOrThrow13;
                                i9 = i2;
                                string6 = null;
                            } else {
                                i8 = i7;
                                i9 = i2;
                                string6 = cursorQuery.getString(i7);
                                i10 = columnIndexOrThrow13;
                            }
                            try {
                                arrayList.add(new Book(string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string, i12, j2, string2, j3, j4, i18, i20, string3, i22, i24, j5, string4, z, i27, i29, string5, BookDao_Impl.this.__converters.stringToReadConfig(string6)));
                                columnIndexOrThrow13 = i10;
                                columnIndexOrThrow = i13;
                                columnIndexOrThrow30 = i8;
                                i11 = i9;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.BookDao
    public LiveData<List<Book>> observeAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `books`.`bookUrl` AS `bookUrl`, `books`.`tocUrl` AS `tocUrl`, `books`.`origin` AS `origin`, `books`.`originName` AS `originName`, `books`.`name` AS `name`, `books`.`author` AS `author`, `books`.`kind` AS `kind`, `books`.`customTag` AS `customTag`, `books`.`coverUrl` AS `coverUrl`, `books`.`customCoverUrl` AS `customCoverUrl`, `books`.`intro` AS `intro`, `books`.`customIntro` AS `customIntro`, `books`.`charset` AS `charset`, `books`.`type` AS `type`, `books`.`group` AS `group`, `books`.`latestChapterTitle` AS `latestChapterTitle`, `books`.`latestChapterTime` AS `latestChapterTime`, `books`.`lastCheckTime` AS `lastCheckTime`, `books`.`lastCheckCount` AS `lastCheckCount`, `books`.`totalChapterNum` AS `totalChapterNum`, `books`.`durChapterTitle` AS `durChapterTitle`, `books`.`durChapterIndex` AS `durChapterIndex`, `books`.`durChapterPos` AS `durChapterPos`, `books`.`durChapterTime` AS `durChapterTime`, `books`.`wordCount` AS `wordCount`, `books`.`canUpdate` AS `canUpdate`, `books`.`order` AS `order`, `books`.`originOrder` AS `originOrder`, `books`.`variable` AS `variable`, `books`.`readConfig` AS `readConfig` FROM books order by durChapterTime desc", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"books"}, false, new Callable<List<Book>>() { // from class: io.legado.app.data.dao.BookDao_Impl.6
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<Book> call() throws Throwable {
                String string;
                int i2;
                String string2;
                int i3;
                String string3;
                int i4;
                String string4;
                int i5;
                int i6;
                boolean z;
                String string5;
                int i7;
                int i8;
                int i9;
                String string6;
                int i10;
                Cursor cursorQuery = DBUtil.query(BookDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                        int i11 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                            String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                            String string14 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string15 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string16 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string17 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            String string18 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                            if (cursorQuery.isNull(columnIndexOrThrow13)) {
                                i2 = i11;
                                string = null;
                            } else {
                                string = cursorQuery.getString(columnIndexOrThrow13);
                                i2 = i11;
                            }
                            int i12 = cursorQuery.getInt(i2);
                            int i13 = columnIndexOrThrow;
                            int i14 = columnIndexOrThrow15;
                            long j2 = cursorQuery.getLong(i14);
                            columnIndexOrThrow15 = i14;
                            int i15 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i15)) {
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i15);
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                            }
                            long j3 = cursorQuery.getLong(i3);
                            columnIndexOrThrow17 = i3;
                            int i16 = columnIndexOrThrow18;
                            long j4 = cursorQuery.getLong(i16);
                            columnIndexOrThrow18 = i16;
                            int i17 = columnIndexOrThrow19;
                            int i18 = cursorQuery.getInt(i17);
                            columnIndexOrThrow19 = i17;
                            int i19 = columnIndexOrThrow20;
                            int i20 = cursorQuery.getInt(i19);
                            columnIndexOrThrow20 = i19;
                            int i21 = columnIndexOrThrow21;
                            if (cursorQuery.isNull(i21)) {
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                                string3 = null;
                            } else {
                                string3 = cursorQuery.getString(i21);
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                            }
                            int i22 = cursorQuery.getInt(i4);
                            columnIndexOrThrow22 = i4;
                            int i23 = columnIndexOrThrow23;
                            int i24 = cursorQuery.getInt(i23);
                            columnIndexOrThrow23 = i23;
                            int i25 = columnIndexOrThrow24;
                            long j5 = cursorQuery.getLong(i25);
                            columnIndexOrThrow24 = i25;
                            int i26 = columnIndexOrThrow25;
                            if (cursorQuery.isNull(i26)) {
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i26);
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                            }
                            if (cursorQuery.getInt(i5) != 0) {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = true;
                            } else {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = false;
                            }
                            int i27 = cursorQuery.getInt(i6);
                            columnIndexOrThrow27 = i6;
                            int i28 = columnIndexOrThrow28;
                            int i29 = cursorQuery.getInt(i28);
                            columnIndexOrThrow28 = i28;
                            int i30 = columnIndexOrThrow29;
                            if (cursorQuery.isNull(i30)) {
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i30);
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                            }
                            if (cursorQuery.isNull(i7)) {
                                i8 = i7;
                                i10 = columnIndexOrThrow13;
                                i9 = i2;
                                string6 = null;
                            } else {
                                i8 = i7;
                                i9 = i2;
                                string6 = cursorQuery.getString(i7);
                                i10 = columnIndexOrThrow13;
                            }
                            try {
                                arrayList.add(new Book(string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string, i12, j2, string2, j3, j4, i18, i20, string3, i22, i24, j5, string4, z, i27, i29, string5, BookDao_Impl.this.__converters.stringToReadConfig(string6)));
                                columnIndexOrThrow13 = i10;
                                columnIndexOrThrow = i13;
                                columnIndexOrThrow30 = i8;
                                i11 = i9;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.BookDao
    public LiveData<List<Book>> observeAudio() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `books`.`bookUrl` AS `bookUrl`, `books`.`tocUrl` AS `tocUrl`, `books`.`origin` AS `origin`, `books`.`originName` AS `originName`, `books`.`name` AS `name`, `books`.`author` AS `author`, `books`.`kind` AS `kind`, `books`.`customTag` AS `customTag`, `books`.`coverUrl` AS `coverUrl`, `books`.`customCoverUrl` AS `customCoverUrl`, `books`.`intro` AS `intro`, `books`.`customIntro` AS `customIntro`, `books`.`charset` AS `charset`, `books`.`type` AS `type`, `books`.`group` AS `group`, `books`.`latestChapterTitle` AS `latestChapterTitle`, `books`.`latestChapterTime` AS `latestChapterTime`, `books`.`lastCheckTime` AS `lastCheckTime`, `books`.`lastCheckCount` AS `lastCheckCount`, `books`.`totalChapterNum` AS `totalChapterNum`, `books`.`durChapterTitle` AS `durChapterTitle`, `books`.`durChapterIndex` AS `durChapterIndex`, `books`.`durChapterPos` AS `durChapterPos`, `books`.`durChapterTime` AS `durChapterTime`, `books`.`wordCount` AS `wordCount`, `books`.`canUpdate` AS `canUpdate`, `books`.`order` AS `order`, `books`.`originOrder` AS `originOrder`, `books`.`variable` AS `variable`, `books`.`readConfig` AS `readConfig` FROM books WHERE type = 1", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"books"}, false, new Callable<List<Book>>() { // from class: io.legado.app.data.dao.BookDao_Impl.7
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<Book> call() throws Throwable {
                String string;
                int i2;
                String string2;
                int i3;
                String string3;
                int i4;
                String string4;
                int i5;
                int i6;
                boolean z;
                String string5;
                int i7;
                int i8;
                int i9;
                String string6;
                int i10;
                Cursor cursorQuery = DBUtil.query(BookDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                        int i11 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                            String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                            String string14 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string15 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string16 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string17 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            String string18 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                            if (cursorQuery.isNull(columnIndexOrThrow13)) {
                                i2 = i11;
                                string = null;
                            } else {
                                string = cursorQuery.getString(columnIndexOrThrow13);
                                i2 = i11;
                            }
                            int i12 = cursorQuery.getInt(i2);
                            int i13 = columnIndexOrThrow;
                            int i14 = columnIndexOrThrow15;
                            long j2 = cursorQuery.getLong(i14);
                            columnIndexOrThrow15 = i14;
                            int i15 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i15)) {
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i15);
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                            }
                            long j3 = cursorQuery.getLong(i3);
                            columnIndexOrThrow17 = i3;
                            int i16 = columnIndexOrThrow18;
                            long j4 = cursorQuery.getLong(i16);
                            columnIndexOrThrow18 = i16;
                            int i17 = columnIndexOrThrow19;
                            int i18 = cursorQuery.getInt(i17);
                            columnIndexOrThrow19 = i17;
                            int i19 = columnIndexOrThrow20;
                            int i20 = cursorQuery.getInt(i19);
                            columnIndexOrThrow20 = i19;
                            int i21 = columnIndexOrThrow21;
                            if (cursorQuery.isNull(i21)) {
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                                string3 = null;
                            } else {
                                string3 = cursorQuery.getString(i21);
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                            }
                            int i22 = cursorQuery.getInt(i4);
                            columnIndexOrThrow22 = i4;
                            int i23 = columnIndexOrThrow23;
                            int i24 = cursorQuery.getInt(i23);
                            columnIndexOrThrow23 = i23;
                            int i25 = columnIndexOrThrow24;
                            long j5 = cursorQuery.getLong(i25);
                            columnIndexOrThrow24 = i25;
                            int i26 = columnIndexOrThrow25;
                            if (cursorQuery.isNull(i26)) {
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i26);
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                            }
                            if (cursorQuery.getInt(i5) != 0) {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = true;
                            } else {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = false;
                            }
                            int i27 = cursorQuery.getInt(i6);
                            columnIndexOrThrow27 = i6;
                            int i28 = columnIndexOrThrow28;
                            int i29 = cursorQuery.getInt(i28);
                            columnIndexOrThrow28 = i28;
                            int i30 = columnIndexOrThrow29;
                            if (cursorQuery.isNull(i30)) {
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i30);
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                            }
                            if (cursorQuery.isNull(i7)) {
                                i8 = i7;
                                i10 = columnIndexOrThrow13;
                                i9 = i2;
                                string6 = null;
                            } else {
                                i8 = i7;
                                i9 = i2;
                                string6 = cursorQuery.getString(i7);
                                i10 = columnIndexOrThrow13;
                            }
                            try {
                                arrayList.add(new Book(string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string, i12, j2, string2, j3, j4, i18, i20, string3, i22, i24, j5, string4, z, i27, i29, string5, BookDao_Impl.this.__converters.stringToReadConfig(string6)));
                                columnIndexOrThrow13 = i10;
                                columnIndexOrThrow = i13;
                                columnIndexOrThrow30 = i8;
                                i11 = i9;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.BookDao
    public LiveData<List<Book>> observeByGroup(long j2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM books WHERE (`group` & ?) > 0", 1);
        roomSQLiteQueryAcquire.bindLong(1, j2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"books"}, false, new Callable<List<Book>>() { // from class: io.legado.app.data.dao.BookDao_Impl.11
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<Book> call() throws Throwable {
                String string;
                int i2;
                String string2;
                int i3;
                String string3;
                int i4;
                String string4;
                int i5;
                int i6;
                boolean z;
                String string5;
                int i7;
                int i8;
                int i9;
                String string6;
                int i10;
                Cursor cursorQuery = DBUtil.query(BookDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                        int i11 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                            String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                            String string14 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string15 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string16 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string17 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            String string18 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                            if (cursorQuery.isNull(columnIndexOrThrow13)) {
                                i2 = i11;
                                string = null;
                            } else {
                                string = cursorQuery.getString(columnIndexOrThrow13);
                                i2 = i11;
                            }
                            int i12 = cursorQuery.getInt(i2);
                            int i13 = columnIndexOrThrow;
                            int i14 = columnIndexOrThrow15;
                            long j3 = cursorQuery.getLong(i14);
                            columnIndexOrThrow15 = i14;
                            int i15 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i15)) {
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i15);
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                            }
                            long j4 = cursorQuery.getLong(i3);
                            columnIndexOrThrow17 = i3;
                            int i16 = columnIndexOrThrow18;
                            long j5 = cursorQuery.getLong(i16);
                            columnIndexOrThrow18 = i16;
                            int i17 = columnIndexOrThrow19;
                            int i18 = cursorQuery.getInt(i17);
                            columnIndexOrThrow19 = i17;
                            int i19 = columnIndexOrThrow20;
                            int i20 = cursorQuery.getInt(i19);
                            columnIndexOrThrow20 = i19;
                            int i21 = columnIndexOrThrow21;
                            if (cursorQuery.isNull(i21)) {
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                                string3 = null;
                            } else {
                                string3 = cursorQuery.getString(i21);
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                            }
                            int i22 = cursorQuery.getInt(i4);
                            columnIndexOrThrow22 = i4;
                            int i23 = columnIndexOrThrow23;
                            int i24 = cursorQuery.getInt(i23);
                            columnIndexOrThrow23 = i23;
                            int i25 = columnIndexOrThrow24;
                            long j6 = cursorQuery.getLong(i25);
                            columnIndexOrThrow24 = i25;
                            int i26 = columnIndexOrThrow25;
                            if (cursorQuery.isNull(i26)) {
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i26);
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                            }
                            if (cursorQuery.getInt(i5) != 0) {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = true;
                            } else {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = false;
                            }
                            int i27 = cursorQuery.getInt(i6);
                            columnIndexOrThrow27 = i6;
                            int i28 = columnIndexOrThrow28;
                            int i29 = cursorQuery.getInt(i28);
                            columnIndexOrThrow28 = i28;
                            int i30 = columnIndexOrThrow29;
                            if (cursorQuery.isNull(i30)) {
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i30);
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                            }
                            if (cursorQuery.isNull(i7)) {
                                i8 = i7;
                                i10 = columnIndexOrThrow13;
                                i9 = i2;
                                string6 = null;
                            } else {
                                i8 = i7;
                                i9 = i2;
                                string6 = cursorQuery.getString(i7);
                                i10 = columnIndexOrThrow13;
                            }
                            try {
                                arrayList.add(new Book(string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string, i12, j3, string2, j4, j5, i18, i20, string3, i22, i24, j6, string4, z, i27, i29, string5, BookDao_Impl.this.__converters.stringToReadConfig(string6)));
                                columnIndexOrThrow13 = i10;
                                columnIndexOrThrow = i13;
                                columnIndexOrThrow30 = i8;
                                i11 = i9;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.BookDao
    public LiveData<List<Book>> observeLocal() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `books`.`bookUrl` AS `bookUrl`, `books`.`tocUrl` AS `tocUrl`, `books`.`origin` AS `origin`, `books`.`originName` AS `originName`, `books`.`name` AS `name`, `books`.`author` AS `author`, `books`.`kind` AS `kind`, `books`.`customTag` AS `customTag`, `books`.`coverUrl` AS `coverUrl`, `books`.`customCoverUrl` AS `customCoverUrl`, `books`.`intro` AS `intro`, `books`.`customIntro` AS `customIntro`, `books`.`charset` AS `charset`, `books`.`type` AS `type`, `books`.`group` AS `group`, `books`.`latestChapterTitle` AS `latestChapterTitle`, `books`.`latestChapterTime` AS `latestChapterTime`, `books`.`lastCheckTime` AS `lastCheckTime`, `books`.`lastCheckCount` AS `lastCheckCount`, `books`.`totalChapterNum` AS `totalChapterNum`, `books`.`durChapterTitle` AS `durChapterTitle`, `books`.`durChapterIndex` AS `durChapterIndex`, `books`.`durChapterPos` AS `durChapterPos`, `books`.`durChapterTime` AS `durChapterTime`, `books`.`wordCount` AS `wordCount`, `books`.`canUpdate` AS `canUpdate`, `books`.`order` AS `order`, `books`.`originOrder` AS `originOrder`, `books`.`variable` AS `variable`, `books`.`readConfig` AS `readConfig` FROM books WHERE origin = 'loc_book'", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"books"}, false, new Callable<List<Book>>() { // from class: io.legado.app.data.dao.BookDao_Impl.8
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<Book> call() throws Throwable {
                String string;
                int i2;
                String string2;
                int i3;
                String string3;
                int i4;
                String string4;
                int i5;
                int i6;
                boolean z;
                String string5;
                int i7;
                int i8;
                int i9;
                String string6;
                int i10;
                Cursor cursorQuery = DBUtil.query(BookDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                        int i11 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                            String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                            String string14 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string15 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string16 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string17 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            String string18 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                            if (cursorQuery.isNull(columnIndexOrThrow13)) {
                                i2 = i11;
                                string = null;
                            } else {
                                string = cursorQuery.getString(columnIndexOrThrow13);
                                i2 = i11;
                            }
                            int i12 = cursorQuery.getInt(i2);
                            int i13 = columnIndexOrThrow;
                            int i14 = columnIndexOrThrow15;
                            long j2 = cursorQuery.getLong(i14);
                            columnIndexOrThrow15 = i14;
                            int i15 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i15)) {
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i15);
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                            }
                            long j3 = cursorQuery.getLong(i3);
                            columnIndexOrThrow17 = i3;
                            int i16 = columnIndexOrThrow18;
                            long j4 = cursorQuery.getLong(i16);
                            columnIndexOrThrow18 = i16;
                            int i17 = columnIndexOrThrow19;
                            int i18 = cursorQuery.getInt(i17);
                            columnIndexOrThrow19 = i17;
                            int i19 = columnIndexOrThrow20;
                            int i20 = cursorQuery.getInt(i19);
                            columnIndexOrThrow20 = i19;
                            int i21 = columnIndexOrThrow21;
                            if (cursorQuery.isNull(i21)) {
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                                string3 = null;
                            } else {
                                string3 = cursorQuery.getString(i21);
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                            }
                            int i22 = cursorQuery.getInt(i4);
                            columnIndexOrThrow22 = i4;
                            int i23 = columnIndexOrThrow23;
                            int i24 = cursorQuery.getInt(i23);
                            columnIndexOrThrow23 = i23;
                            int i25 = columnIndexOrThrow24;
                            long j5 = cursorQuery.getLong(i25);
                            columnIndexOrThrow24 = i25;
                            int i26 = columnIndexOrThrow25;
                            if (cursorQuery.isNull(i26)) {
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i26);
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                            }
                            if (cursorQuery.getInt(i5) != 0) {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = true;
                            } else {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = false;
                            }
                            int i27 = cursorQuery.getInt(i6);
                            columnIndexOrThrow27 = i6;
                            int i28 = columnIndexOrThrow28;
                            int i29 = cursorQuery.getInt(i28);
                            columnIndexOrThrow28 = i28;
                            int i30 = columnIndexOrThrow29;
                            if (cursorQuery.isNull(i30)) {
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i30);
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                            }
                            if (cursorQuery.isNull(i7)) {
                                i8 = i7;
                                i10 = columnIndexOrThrow13;
                                i9 = i2;
                                string6 = null;
                            } else {
                                i8 = i7;
                                i9 = i2;
                                string6 = cursorQuery.getString(i7);
                                i10 = columnIndexOrThrow13;
                            }
                            try {
                                arrayList.add(new Book(string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string, i12, j2, string2, j3, j4, i18, i20, string3, i22, i24, j5, string4, z, i27, i29, string5, BookDao_Impl.this.__converters.stringToReadConfig(string6)));
                                columnIndexOrThrow13 = i10;
                                columnIndexOrThrow = i13;
                                columnIndexOrThrow30 = i8;
                                i11 = i9;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.BookDao
    public LiveData<List<String>> observeLocalUri() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT bookUrl FROM books WHERE origin = 'loc_book'", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"books"}, false, new Callable<List<String>>() { // from class: io.legado.app.data.dao.BookDao_Impl.10
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(BookDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.BookDao
    public LiveData<List<Book>> observeNoGroup() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `books`.`bookUrl` AS `bookUrl`, `books`.`tocUrl` AS `tocUrl`, `books`.`origin` AS `origin`, `books`.`originName` AS `originName`, `books`.`name` AS `name`, `books`.`author` AS `author`, `books`.`kind` AS `kind`, `books`.`customTag` AS `customTag`, `books`.`coverUrl` AS `coverUrl`, `books`.`customCoverUrl` AS `customCoverUrl`, `books`.`intro` AS `intro`, `books`.`customIntro` AS `customIntro`, `books`.`charset` AS `charset`, `books`.`type` AS `type`, `books`.`group` AS `group`, `books`.`latestChapterTitle` AS `latestChapterTitle`, `books`.`latestChapterTime` AS `latestChapterTime`, `books`.`lastCheckTime` AS `lastCheckTime`, `books`.`lastCheckCount` AS `lastCheckCount`, `books`.`totalChapterNum` AS `totalChapterNum`, `books`.`durChapterTitle` AS `durChapterTitle`, `books`.`durChapterIndex` AS `durChapterIndex`, `books`.`durChapterPos` AS `durChapterPos`, `books`.`durChapterTime` AS `durChapterTime`, `books`.`wordCount` AS `wordCount`, `books`.`canUpdate` AS `canUpdate`, `books`.`order` AS `order`, `books`.`originOrder` AS `originOrder`, `books`.`variable` AS `variable`, `books`.`readConfig` AS `readConfig` from books where type != 1 and origin != 'loc_book' and ((SELECT sum(groupId) FROM book_groups where groupId > 0) & `group`) = 0", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"books", "book_groups"}, false, new Callable<List<Book>>() { // from class: io.legado.app.data.dao.BookDao_Impl.9
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<Book> call() throws Throwable {
                String string;
                int i2;
                String string2;
                int i3;
                String string3;
                int i4;
                String string4;
                int i5;
                int i6;
                boolean z;
                String string5;
                int i7;
                int i8;
                int i9;
                String string6;
                int i10;
                Cursor cursorQuery = DBUtil.query(BookDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                        int i11 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                            String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                            String string14 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string15 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string16 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string17 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            String string18 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                            if (cursorQuery.isNull(columnIndexOrThrow13)) {
                                i2 = i11;
                                string = null;
                            } else {
                                string = cursorQuery.getString(columnIndexOrThrow13);
                                i2 = i11;
                            }
                            int i12 = cursorQuery.getInt(i2);
                            int i13 = columnIndexOrThrow;
                            int i14 = columnIndexOrThrow15;
                            long j2 = cursorQuery.getLong(i14);
                            columnIndexOrThrow15 = i14;
                            int i15 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i15)) {
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i15);
                                columnIndexOrThrow16 = i15;
                                i3 = columnIndexOrThrow17;
                            }
                            long j3 = cursorQuery.getLong(i3);
                            columnIndexOrThrow17 = i3;
                            int i16 = columnIndexOrThrow18;
                            long j4 = cursorQuery.getLong(i16);
                            columnIndexOrThrow18 = i16;
                            int i17 = columnIndexOrThrow19;
                            int i18 = cursorQuery.getInt(i17);
                            columnIndexOrThrow19 = i17;
                            int i19 = columnIndexOrThrow20;
                            int i20 = cursorQuery.getInt(i19);
                            columnIndexOrThrow20 = i19;
                            int i21 = columnIndexOrThrow21;
                            if (cursorQuery.isNull(i21)) {
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                                string3 = null;
                            } else {
                                string3 = cursorQuery.getString(i21);
                                columnIndexOrThrow21 = i21;
                                i4 = columnIndexOrThrow22;
                            }
                            int i22 = cursorQuery.getInt(i4);
                            columnIndexOrThrow22 = i4;
                            int i23 = columnIndexOrThrow23;
                            int i24 = cursorQuery.getInt(i23);
                            columnIndexOrThrow23 = i23;
                            int i25 = columnIndexOrThrow24;
                            long j5 = cursorQuery.getLong(i25);
                            columnIndexOrThrow24 = i25;
                            int i26 = columnIndexOrThrow25;
                            if (cursorQuery.isNull(i26)) {
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i26);
                                columnIndexOrThrow25 = i26;
                                i5 = columnIndexOrThrow26;
                            }
                            if (cursorQuery.getInt(i5) != 0) {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = true;
                            } else {
                                columnIndexOrThrow26 = i5;
                                i6 = columnIndexOrThrow27;
                                z = false;
                            }
                            int i27 = cursorQuery.getInt(i6);
                            columnIndexOrThrow27 = i6;
                            int i28 = columnIndexOrThrow28;
                            int i29 = cursorQuery.getInt(i28);
                            columnIndexOrThrow28 = i28;
                            int i30 = columnIndexOrThrow29;
                            if (cursorQuery.isNull(i30)) {
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i30);
                                columnIndexOrThrow29 = i30;
                                i7 = columnIndexOrThrow30;
                            }
                            if (cursorQuery.isNull(i7)) {
                                i8 = i7;
                                i10 = columnIndexOrThrow13;
                                i9 = i2;
                                string6 = null;
                            } else {
                                i8 = i7;
                                i9 = i2;
                                string6 = cursorQuery.getString(i7);
                                i10 = columnIndexOrThrow13;
                            }
                            try {
                                arrayList.add(new Book(string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string, i12, j2, string2, j3, j4, i18, i20, string3, i22, i24, j5, string4, z, i27, i29, string5, BookDao_Impl.this.__converters.stringToReadConfig(string6)));
                                columnIndexOrThrow13 = i10;
                                columnIndexOrThrow = i13;
                                columnIndexOrThrow30 = i8;
                                i11 = i9;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.BookDao
    public void upGroup(long j2, long j3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpGroup.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j3);
        supportSQLiteStatementAcquire.bindLong(2, j2);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpGroup.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public void upProgress(String str, int i2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpProgress.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpProgress.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public void update(Book... bookArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfBook.handleMultiple(bookArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.BookDao
    public Book getBook(String str, String str2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        Book book;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        int i4;
        int i5;
        boolean z;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM books WHERE name = ? and author = ?", 2);
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tocUrl");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "origin");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kind");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customTag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customCoverUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "intro");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customIntro");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charset");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTitle");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestChapterTime");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckTime");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastCheckCount");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalChapterNum");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTitle");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterIndex");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterPos");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "durChapterTime");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wordCount");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "canUpdate");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "order");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originOrder");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "variable");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "readConfig");
                    if (cursorQuery.moveToFirst()) {
                        String string4 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string7 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        String string11 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string14 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string15 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        String string16 = cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13);
                        int i6 = cursorQuery.getInt(columnIndexOrThrow14);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow15);
                        if (cursorQuery.isNull(columnIndexOrThrow16)) {
                            i2 = columnIndexOrThrow17;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow16);
                            i2 = columnIndexOrThrow17;
                        }
                        long j3 = cursorQuery.getLong(i2);
                        long j4 = cursorQuery.getLong(columnIndexOrThrow18);
                        int i7 = cursorQuery.getInt(columnIndexOrThrow19);
                        int i8 = cursorQuery.getInt(columnIndexOrThrow20);
                        if (cursorQuery.isNull(columnIndexOrThrow21)) {
                            i3 = columnIndexOrThrow22;
                            string2 = null;
                        } else {
                            string2 = cursorQuery.getString(columnIndexOrThrow21);
                            i3 = columnIndexOrThrow22;
                        }
                        int i9 = cursorQuery.getInt(i3);
                        int i10 = cursorQuery.getInt(columnIndexOrThrow23);
                        long j5 = cursorQuery.getLong(columnIndexOrThrow24);
                        if (cursorQuery.isNull(columnIndexOrThrow25)) {
                            i4 = columnIndexOrThrow26;
                            string3 = null;
                        } else {
                            string3 = cursorQuery.getString(columnIndexOrThrow25);
                            i4 = columnIndexOrThrow26;
                        }
                        if (cursorQuery.getInt(i4) != 0) {
                            i5 = columnIndexOrThrow27;
                            z = true;
                        } else {
                            i5 = columnIndexOrThrow27;
                            z = false;
                        }
                        book = new Book(string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, i6, j2, string, j3, j4, i7, i8, string2, i9, i10, j5, string3, z, cursorQuery.getInt(i5), cursorQuery.getInt(columnIndexOrThrow28), cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29), this.__converters.stringToReadConfig(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30)));
                    } else {
                        book = null;
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return book;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }
}
