package io.legado.app.data.dao;

import android.database.Cursor;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.view.LiveData;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.rule.BookInfoRule;
import io.legado.app.data.entities.rule.ExploreRule;
import io.legado.app.data.entities.rule.SearchRule;
import io.legado.app.data.entities.rule.TocRule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class BookSourceDao_Impl implements BookSourceDao {
    private final BookSource.Converters __converters = new BookSource.Converters();
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<BookSource> __deletionAdapterOfBookSource;
    private final EntityInsertionAdapter<BookSource> __insertionAdapterOfBookSource;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final EntityDeletionOrUpdateAdapter<BookSource> __updateAdapterOfBookSource;

    public BookSourceDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfBookSource = new EntityInsertionAdapter<BookSource>(roomDatabase) { // from class: io.legado.app.data.dao.BookSourceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `book_sources` (`bookSourceName`,`bookSourceGroup`,`bookSourceUrl`,`bookSourceType`,`bookUrlPattern`,`customOrder`,`enabled`,`enabledExplore`,`header`,`loginUrl`,`bookSourceComment`,`lastUpdateTime`,`weight`,`exploreUrl`,`ruleExplore`,`searchUrl`,`ruleSearch`,`ruleBookInfo`,`ruleToc`,`ruleContent`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, BookSource bookSource) {
                if (bookSource.getBookSourceName() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, bookSource.getBookSourceName());
                }
                if (bookSource.getBookSourceGroup() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, bookSource.getBookSourceGroup());
                }
                if (bookSource.getBookSourceUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, bookSource.getBookSourceUrl());
                }
                supportSQLiteStatement.bindLong(4, bookSource.getBookSourceType());
                if (bookSource.getBookUrlPattern() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, bookSource.getBookUrlPattern());
                }
                supportSQLiteStatement.bindLong(6, bookSource.getCustomOrder());
                supportSQLiteStatement.bindLong(7, bookSource.getEnabled() ? 1L : 0L);
                supportSQLiteStatement.bindLong(8, bookSource.getEnabledExplore() ? 1L : 0L);
                if (bookSource.getHeader() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, bookSource.getHeader());
                }
                if (bookSource.getLoginUrl() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, bookSource.getLoginUrl());
                }
                if (bookSource.getBookSourceComment() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, bookSource.getBookSourceComment());
                }
                supportSQLiteStatement.bindLong(12, bookSource.getLastUpdateTime());
                supportSQLiteStatement.bindLong(13, bookSource.getWeight());
                if (bookSource.getExploreUrl() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, bookSource.getExploreUrl());
                }
                String strExploreRuleToString = BookSourceDao_Impl.this.__converters.exploreRuleToString(bookSource.getRuleExplore());
                if (strExploreRuleToString == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, strExploreRuleToString);
                }
                if (bookSource.getSearchUrl() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, bookSource.getSearchUrl());
                }
                String strSearchRuleToString = BookSourceDao_Impl.this.__converters.searchRuleToString(bookSource.getRuleSearch());
                if (strSearchRuleToString == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, strSearchRuleToString);
                }
                String strBookInfoRuleToString = BookSourceDao_Impl.this.__converters.bookInfoRuleToString(bookSource.getRuleBookInfo());
                if (strBookInfoRuleToString == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, strBookInfoRuleToString);
                }
                String str = BookSourceDao_Impl.this.__converters.tocRuleToString(bookSource.getRuleToc());
                if (str == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, str);
                }
                String strContentRuleToString = BookSourceDao_Impl.this.__converters.contentRuleToString(bookSource.getRuleContent());
                if (strContentRuleToString == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, strContentRuleToString);
                }
            }
        };
        this.__deletionAdapterOfBookSource = new EntityDeletionOrUpdateAdapter<BookSource>(roomDatabase) { // from class: io.legado.app.data.dao.BookSourceDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `book_sources` WHERE `bookSourceUrl` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, BookSource bookSource) {
                if (bookSource.getBookSourceUrl() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, bookSource.getBookSourceUrl());
                }
            }
        };
        this.__updateAdapterOfBookSource = new EntityDeletionOrUpdateAdapter<BookSource>(roomDatabase) { // from class: io.legado.app.data.dao.BookSourceDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `book_sources` SET `bookSourceName` = ?,`bookSourceGroup` = ?,`bookSourceUrl` = ?,`bookSourceType` = ?,`bookUrlPattern` = ?,`customOrder` = ?,`enabled` = ?,`enabledExplore` = ?,`header` = ?,`loginUrl` = ?,`bookSourceComment` = ?,`lastUpdateTime` = ?,`weight` = ?,`exploreUrl` = ?,`ruleExplore` = ?,`searchUrl` = ?,`ruleSearch` = ?,`ruleBookInfo` = ?,`ruleToc` = ?,`ruleContent` = ? WHERE `bookSourceUrl` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, BookSource bookSource) {
                if (bookSource.getBookSourceName() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, bookSource.getBookSourceName());
                }
                if (bookSource.getBookSourceGroup() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, bookSource.getBookSourceGroup());
                }
                if (bookSource.getBookSourceUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, bookSource.getBookSourceUrl());
                }
                supportSQLiteStatement.bindLong(4, bookSource.getBookSourceType());
                if (bookSource.getBookUrlPattern() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, bookSource.getBookUrlPattern());
                }
                supportSQLiteStatement.bindLong(6, bookSource.getCustomOrder());
                supportSQLiteStatement.bindLong(7, bookSource.getEnabled() ? 1L : 0L);
                supportSQLiteStatement.bindLong(8, bookSource.getEnabledExplore() ? 1L : 0L);
                if (bookSource.getHeader() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, bookSource.getHeader());
                }
                if (bookSource.getLoginUrl() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, bookSource.getLoginUrl());
                }
                if (bookSource.getBookSourceComment() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, bookSource.getBookSourceComment());
                }
                supportSQLiteStatement.bindLong(12, bookSource.getLastUpdateTime());
                supportSQLiteStatement.bindLong(13, bookSource.getWeight());
                if (bookSource.getExploreUrl() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, bookSource.getExploreUrl());
                }
                String strExploreRuleToString = BookSourceDao_Impl.this.__converters.exploreRuleToString(bookSource.getRuleExplore());
                if (strExploreRuleToString == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, strExploreRuleToString);
                }
                if (bookSource.getSearchUrl() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, bookSource.getSearchUrl());
                }
                String strSearchRuleToString = BookSourceDao_Impl.this.__converters.searchRuleToString(bookSource.getRuleSearch());
                if (strSearchRuleToString == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, strSearchRuleToString);
                }
                String strBookInfoRuleToString = BookSourceDao_Impl.this.__converters.bookInfoRuleToString(bookSource.getRuleBookInfo());
                if (strBookInfoRuleToString == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, strBookInfoRuleToString);
                }
                String str = BookSourceDao_Impl.this.__converters.tocRuleToString(bookSource.getRuleToc());
                if (str == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, str);
                }
                String strContentRuleToString = BookSourceDao_Impl.this.__converters.contentRuleToString(bookSource.getRuleContent());
                if (strContentRuleToString == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, strContentRuleToString);
                }
                if (bookSource.getBookSourceUrl() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, bookSource.getBookSourceUrl());
                }
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) { // from class: io.legado.app.data.dao.BookSourceDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from book_sources where bookSourceUrl = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // io.legado.app.data.dao.BookSourceDao
    public int allCount() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select count(*) from book_sources", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookSourceDao
    public void delete(BookSource... bookSourceArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfBookSource.handleMultiple(bookSourceArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.BookSourceDao
    public List<BookSource> getAll() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        int i3;
        String string;
        int i4;
        String string2;
        int i5;
        int i6;
        String string3;
        int i7;
        String string4;
        String string5;
        String string6;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `book_sources`.`bookSourceName` AS `bookSourceName`, `book_sources`.`bookSourceGroup` AS `bookSourceGroup`, `book_sources`.`bookSourceUrl` AS `bookSourceUrl`, `book_sources`.`bookSourceType` AS `bookSourceType`, `book_sources`.`bookUrlPattern` AS `bookUrlPattern`, `book_sources`.`customOrder` AS `customOrder`, `book_sources`.`enabled` AS `enabled`, `book_sources`.`enabledExplore` AS `enabledExplore`, `book_sources`.`header` AS `header`, `book_sources`.`loginUrl` AS `loginUrl`, `book_sources`.`bookSourceComment` AS `bookSourceComment`, `book_sources`.`lastUpdateTime` AS `lastUpdateTime`, `book_sources`.`weight` AS `weight`, `book_sources`.`exploreUrl` AS `exploreUrl`, `book_sources`.`ruleExplore` AS `ruleExplore`, `book_sources`.`searchUrl` AS `searchUrl`, `book_sources`.`ruleSearch` AS `ruleSearch`, `book_sources`.`ruleBookInfo` AS `ruleBookInfo`, `book_sources`.`ruleToc` AS `ruleToc`, `book_sources`.`ruleContent` AS `ruleContent` from book_sources order by customOrder asc", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                        int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                        int i12 = i8;
                        String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                        int i13 = columnIndexOrThrow15;
                        int i14 = columnIndexOrThrow;
                        if (cursorQuery.isNull(i13)) {
                            i2 = i13;
                            i4 = columnIndexOrThrow12;
                            i3 = i12;
                            string = null;
                        } else {
                            i2 = i13;
                            i3 = i12;
                            string = cursorQuery.getString(i13);
                            i4 = columnIndexOrThrow12;
                        }
                        try {
                            ExploreRule exploreRuleStringToExploreRule = this.__converters.stringToExploreRule(string);
                            int i15 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i15)) {
                                i5 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i15);
                                i5 = columnIndexOrThrow17;
                            }
                            if (cursorQuery.isNull(i5)) {
                                i6 = i15;
                                i7 = i5;
                                string3 = null;
                            } else {
                                i6 = i15;
                                string3 = cursorQuery.getString(i5);
                                i7 = i5;
                            }
                            SearchRule searchRuleStringToSearchRule = this.__converters.stringToSearchRule(string3);
                            int i16 = columnIndexOrThrow18;
                            if (cursorQuery.isNull(i16)) {
                                columnIndexOrThrow18 = i16;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i16);
                                columnIndexOrThrow18 = i16;
                            }
                            BookInfoRule bookInfoRuleStringToBookInfoRule = this.__converters.stringToBookInfoRule(string4);
                            int i17 = columnIndexOrThrow19;
                            if (cursorQuery.isNull(i17)) {
                                columnIndexOrThrow19 = i17;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i17);
                                columnIndexOrThrow19 = i17;
                            }
                            TocRule tocRuleStringToTocRule = this.__converters.stringToTocRule(string5);
                            int i18 = columnIndexOrThrow20;
                            if (cursorQuery.isNull(i18)) {
                                columnIndexOrThrow20 = i18;
                                string6 = null;
                            } else {
                                string6 = cursorQuery.getString(i18);
                                columnIndexOrThrow20 = i18;
                            }
                            arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, this.__converters.stringToContentRule(string6)));
                            columnIndexOrThrow = i14;
                            columnIndexOrThrow12 = i4;
                            columnIndexOrThrow15 = i2;
                            i8 = i3;
                            int i19 = i6;
                            columnIndexOrThrow17 = i7;
                            columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public List<BookSource> getAllEnabled() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        int i3;
        String string;
        int i4;
        String string2;
        int i5;
        int i6;
        String string3;
        int i7;
        String string4;
        String string5;
        String string6;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `book_sources`.`bookSourceName` AS `bookSourceName`, `book_sources`.`bookSourceGroup` AS `bookSourceGroup`, `book_sources`.`bookSourceUrl` AS `bookSourceUrl`, `book_sources`.`bookSourceType` AS `bookSourceType`, `book_sources`.`bookUrlPattern` AS `bookUrlPattern`, `book_sources`.`customOrder` AS `customOrder`, `book_sources`.`enabled` AS `enabled`, `book_sources`.`enabledExplore` AS `enabledExplore`, `book_sources`.`header` AS `header`, `book_sources`.`loginUrl` AS `loginUrl`, `book_sources`.`bookSourceComment` AS `bookSourceComment`, `book_sources`.`lastUpdateTime` AS `lastUpdateTime`, `book_sources`.`weight` AS `weight`, `book_sources`.`exploreUrl` AS `exploreUrl`, `book_sources`.`ruleExplore` AS `ruleExplore`, `book_sources`.`searchUrl` AS `searchUrl`, `book_sources`.`ruleSearch` AS `ruleSearch`, `book_sources`.`ruleBookInfo` AS `ruleBookInfo`, `book_sources`.`ruleToc` AS `ruleToc`, `book_sources`.`ruleContent` AS `ruleContent` from book_sources where enabled = 1 order by customOrder", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                        int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                        int i12 = i8;
                        String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                        int i13 = columnIndexOrThrow15;
                        int i14 = columnIndexOrThrow;
                        if (cursorQuery.isNull(i13)) {
                            i2 = i13;
                            i4 = columnIndexOrThrow12;
                            i3 = i12;
                            string = null;
                        } else {
                            i2 = i13;
                            i3 = i12;
                            string = cursorQuery.getString(i13);
                            i4 = columnIndexOrThrow12;
                        }
                        try {
                            ExploreRule exploreRuleStringToExploreRule = this.__converters.stringToExploreRule(string);
                            int i15 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i15)) {
                                i5 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i15);
                                i5 = columnIndexOrThrow17;
                            }
                            if (cursorQuery.isNull(i5)) {
                                i6 = i15;
                                i7 = i5;
                                string3 = null;
                            } else {
                                i6 = i15;
                                string3 = cursorQuery.getString(i5);
                                i7 = i5;
                            }
                            SearchRule searchRuleStringToSearchRule = this.__converters.stringToSearchRule(string3);
                            int i16 = columnIndexOrThrow18;
                            if (cursorQuery.isNull(i16)) {
                                columnIndexOrThrow18 = i16;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i16);
                                columnIndexOrThrow18 = i16;
                            }
                            BookInfoRule bookInfoRuleStringToBookInfoRule = this.__converters.stringToBookInfoRule(string4);
                            int i17 = columnIndexOrThrow19;
                            if (cursorQuery.isNull(i17)) {
                                columnIndexOrThrow19 = i17;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i17);
                                columnIndexOrThrow19 = i17;
                            }
                            TocRule tocRuleStringToTocRule = this.__converters.stringToTocRule(string5);
                            int i18 = columnIndexOrThrow20;
                            if (cursorQuery.isNull(i18)) {
                                columnIndexOrThrow20 = i18;
                                string6 = null;
                            } else {
                                string6 = cursorQuery.getString(i18);
                                columnIndexOrThrow20 = i18;
                            }
                            arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, this.__converters.stringToContentRule(string6)));
                            columnIndexOrThrow = i14;
                            columnIndexOrThrow12 = i4;
                            columnIndexOrThrow15 = i2;
                            i8 = i3;
                            int i19 = i6;
                            columnIndexOrThrow17 = i7;
                            columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public List<String> getAllGroup() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select distinct bookSourceGroup from book_sources where trim(bookSourceGroup) <> ''", 0);
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public List<BookSource> getAllTextEnabled() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        int i3;
        String string;
        int i4;
        String string2;
        int i5;
        int i6;
        String string3;
        int i7;
        String string4;
        String string5;
        String string6;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `book_sources`.`bookSourceName` AS `bookSourceName`, `book_sources`.`bookSourceGroup` AS `bookSourceGroup`, `book_sources`.`bookSourceUrl` AS `bookSourceUrl`, `book_sources`.`bookSourceType` AS `bookSourceType`, `book_sources`.`bookUrlPattern` AS `bookUrlPattern`, `book_sources`.`customOrder` AS `customOrder`, `book_sources`.`enabled` AS `enabled`, `book_sources`.`enabledExplore` AS `enabledExplore`, `book_sources`.`header` AS `header`, `book_sources`.`loginUrl` AS `loginUrl`, `book_sources`.`bookSourceComment` AS `bookSourceComment`, `book_sources`.`lastUpdateTime` AS `lastUpdateTime`, `book_sources`.`weight` AS `weight`, `book_sources`.`exploreUrl` AS `exploreUrl`, `book_sources`.`ruleExplore` AS `ruleExplore`, `book_sources`.`searchUrl` AS `searchUrl`, `book_sources`.`ruleSearch` AS `ruleSearch`, `book_sources`.`ruleBookInfo` AS `ruleBookInfo`, `book_sources`.`ruleToc` AS `ruleToc`, `book_sources`.`ruleContent` AS `ruleContent` from book_sources where enabled = 1 and bookSourceType = 0 order by customOrder", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                        int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                        int i12 = i8;
                        String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                        int i13 = columnIndexOrThrow15;
                        int i14 = columnIndexOrThrow;
                        if (cursorQuery.isNull(i13)) {
                            i2 = i13;
                            i4 = columnIndexOrThrow12;
                            i3 = i12;
                            string = null;
                        } else {
                            i2 = i13;
                            i3 = i12;
                            string = cursorQuery.getString(i13);
                            i4 = columnIndexOrThrow12;
                        }
                        try {
                            ExploreRule exploreRuleStringToExploreRule = this.__converters.stringToExploreRule(string);
                            int i15 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i15)) {
                                i5 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i15);
                                i5 = columnIndexOrThrow17;
                            }
                            if (cursorQuery.isNull(i5)) {
                                i6 = i15;
                                i7 = i5;
                                string3 = null;
                            } else {
                                i6 = i15;
                                string3 = cursorQuery.getString(i5);
                                i7 = i5;
                            }
                            SearchRule searchRuleStringToSearchRule = this.__converters.stringToSearchRule(string3);
                            int i16 = columnIndexOrThrow18;
                            if (cursorQuery.isNull(i16)) {
                                columnIndexOrThrow18 = i16;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i16);
                                columnIndexOrThrow18 = i16;
                            }
                            BookInfoRule bookInfoRuleStringToBookInfoRule = this.__converters.stringToBookInfoRule(string4);
                            int i17 = columnIndexOrThrow19;
                            if (cursorQuery.isNull(i17)) {
                                columnIndexOrThrow19 = i17;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i17);
                                columnIndexOrThrow19 = i17;
                            }
                            TocRule tocRuleStringToTocRule = this.__converters.stringToTocRule(string5);
                            int i18 = columnIndexOrThrow20;
                            if (cursorQuery.isNull(i18)) {
                                columnIndexOrThrow20 = i18;
                                string6 = null;
                            } else {
                                string6 = cursorQuery.getString(i18);
                                columnIndexOrThrow20 = i18;
                            }
                            arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, this.__converters.stringToContentRule(string6)));
                            columnIndexOrThrow = i14;
                            columnIndexOrThrow12 = i4;
                            columnIndexOrThrow15 = i2;
                            i8 = i3;
                            int i19 = i6;
                            columnIndexOrThrow17 = i7;
                            columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public BookSource getBookSource(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        BookSource bookSource;
        String string;
        int i2;
        String string2;
        int i3;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from book_sources where bookSourceUrl = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    if (cursorQuery.moveToFirst()) {
                        String string3 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        int i4 = cursorQuery.getInt(columnIndexOrThrow4);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        int i5 = cursorQuery.getInt(columnIndexOrThrow6);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        String string7 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                        int i6 = cursorQuery.getInt(columnIndexOrThrow13);
                        if (cursorQuery.isNull(columnIndexOrThrow14)) {
                            i2 = columnIndexOrThrow15;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow14);
                            i2 = columnIndexOrThrow15;
                        }
                        try {
                            ExploreRule exploreRuleStringToExploreRule = this.__converters.stringToExploreRule(cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2));
                            if (cursorQuery.isNull(columnIndexOrThrow16)) {
                                i3 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(columnIndexOrThrow16);
                                i3 = columnIndexOrThrow17;
                            }
                            bookSource = new BookSource(string3, string4, string5, i4, string6, i5, z, z2, string7, string8, string9, j2, i6, string, exploreRuleStringToExploreRule, string2, this.__converters.stringToSearchRule(cursorQuery.isNull(i3) ? null : cursorQuery.getString(i3)), this.__converters.stringToBookInfoRule(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18)), this.__converters.stringToTocRule(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19)), this.__converters.stringToContentRule(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20)));
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    } else {
                        bookSource = null;
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return bookSource;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public List<BookSource> getByGroup(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        int i3;
        String string;
        String string2;
        int i4;
        int i5;
        String string3;
        int i6;
        String string4;
        String string5;
        String string6;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from book_sources where bookSourceGroup like '%' || ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int i7 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        int i8 = cursorQuery.getInt(columnIndexOrThrow4);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        int i9 = cursorQuery.getInt(columnIndexOrThrow6);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                        int i10 = cursorQuery.getInt(columnIndexOrThrow13);
                        int i11 = i7;
                        String string14 = cursorQuery.isNull(i11) ? null : cursorQuery.getString(i11);
                        int i12 = columnIndexOrThrow15;
                        int i13 = columnIndexOrThrow;
                        if (cursorQuery.isNull(i12)) {
                            i2 = i12;
                            i7 = i11;
                            i3 = columnIndexOrThrow11;
                            string = null;
                        } else {
                            i2 = i12;
                            i3 = columnIndexOrThrow11;
                            string = cursorQuery.getString(i12);
                            i7 = i11;
                        }
                        try {
                            ExploreRule exploreRuleStringToExploreRule = this.__converters.stringToExploreRule(string);
                            int i14 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i14)) {
                                i4 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i14);
                                i4 = columnIndexOrThrow17;
                            }
                            if (cursorQuery.isNull(i4)) {
                                i5 = i14;
                                i6 = i4;
                                string3 = null;
                            } else {
                                i5 = i14;
                                string3 = cursorQuery.getString(i4);
                                i6 = i4;
                            }
                            SearchRule searchRuleStringToSearchRule = this.__converters.stringToSearchRule(string3);
                            int i15 = columnIndexOrThrow18;
                            if (cursorQuery.isNull(i15)) {
                                columnIndexOrThrow18 = i15;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i15);
                                columnIndexOrThrow18 = i15;
                            }
                            BookInfoRule bookInfoRuleStringToBookInfoRule = this.__converters.stringToBookInfoRule(string4);
                            int i16 = columnIndexOrThrow19;
                            if (cursorQuery.isNull(i16)) {
                                columnIndexOrThrow19 = i16;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i16);
                                columnIndexOrThrow19 = i16;
                            }
                            TocRule tocRuleStringToTocRule = this.__converters.stringToTocRule(string5);
                            int i17 = columnIndexOrThrow20;
                            if (cursorQuery.isNull(i17)) {
                                columnIndexOrThrow20 = i17;
                                string6 = null;
                            } else {
                                string6 = cursorQuery.getString(i17);
                                columnIndexOrThrow20 = i17;
                            }
                            arrayList.add(new BookSource(string7, string8, string9, i8, string10, i9, z, z2, string11, string12, string13, j2, i10, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, this.__converters.stringToContentRule(string6)));
                            columnIndexOrThrow = i13;
                            columnIndexOrThrow15 = i2;
                            columnIndexOrThrow11 = i3;
                            int i18 = i5;
                            columnIndexOrThrow17 = i6;
                            columnIndexOrThrow16 = i18;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public List<BookSource> getEnabledByGroup(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        int i3;
        String string;
        String string2;
        int i4;
        int i5;
        String string3;
        int i6;
        String string4;
        String string5;
        String string6;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from book_sources where enabled = 1 and bookSourceGroup like '%' || ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int i7 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        int i8 = cursorQuery.getInt(columnIndexOrThrow4);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        int i9 = cursorQuery.getInt(columnIndexOrThrow6);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                        int i10 = cursorQuery.getInt(columnIndexOrThrow13);
                        int i11 = i7;
                        String string14 = cursorQuery.isNull(i11) ? null : cursorQuery.getString(i11);
                        int i12 = columnIndexOrThrow15;
                        int i13 = columnIndexOrThrow;
                        if (cursorQuery.isNull(i12)) {
                            i2 = i12;
                            i7 = i11;
                            i3 = columnIndexOrThrow11;
                            string = null;
                        } else {
                            i2 = i12;
                            i3 = columnIndexOrThrow11;
                            string = cursorQuery.getString(i12);
                            i7 = i11;
                        }
                        try {
                            ExploreRule exploreRuleStringToExploreRule = this.__converters.stringToExploreRule(string);
                            int i14 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i14)) {
                                i4 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i14);
                                i4 = columnIndexOrThrow17;
                            }
                            if (cursorQuery.isNull(i4)) {
                                i5 = i14;
                                i6 = i4;
                                string3 = null;
                            } else {
                                i5 = i14;
                                string3 = cursorQuery.getString(i4);
                                i6 = i4;
                            }
                            SearchRule searchRuleStringToSearchRule = this.__converters.stringToSearchRule(string3);
                            int i15 = columnIndexOrThrow18;
                            if (cursorQuery.isNull(i15)) {
                                columnIndexOrThrow18 = i15;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i15);
                                columnIndexOrThrow18 = i15;
                            }
                            BookInfoRule bookInfoRuleStringToBookInfoRule = this.__converters.stringToBookInfoRule(string4);
                            int i16 = columnIndexOrThrow19;
                            if (cursorQuery.isNull(i16)) {
                                columnIndexOrThrow19 = i16;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i16);
                                columnIndexOrThrow19 = i16;
                            }
                            TocRule tocRuleStringToTocRule = this.__converters.stringToTocRule(string5);
                            int i17 = columnIndexOrThrow20;
                            if (cursorQuery.isNull(i17)) {
                                columnIndexOrThrow20 = i17;
                                string6 = null;
                            } else {
                                string6 = cursorQuery.getString(i17);
                                columnIndexOrThrow20 = i17;
                            }
                            arrayList.add(new BookSource(string7, string8, string9, i8, string10, i9, z, z2, string11, string12, string13, j2, i10, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, this.__converters.stringToContentRule(string6)));
                            columnIndexOrThrow = i13;
                            columnIndexOrThrow15 = i2;
                            columnIndexOrThrow11 = i3;
                            int i18 = i5;
                            columnIndexOrThrow17 = i6;
                            columnIndexOrThrow16 = i18;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public List<BookSource> getHasBookUrlPattern() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        int i3;
        String string;
        int i4;
        String string2;
        int i5;
        int i6;
        String string3;
        int i7;
        String string4;
        String string5;
        String string6;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `book_sources`.`bookSourceName` AS `bookSourceName`, `book_sources`.`bookSourceGroup` AS `bookSourceGroup`, `book_sources`.`bookSourceUrl` AS `bookSourceUrl`, `book_sources`.`bookSourceType` AS `bookSourceType`, `book_sources`.`bookUrlPattern` AS `bookUrlPattern`, `book_sources`.`customOrder` AS `customOrder`, `book_sources`.`enabled` AS `enabled`, `book_sources`.`enabledExplore` AS `enabledExplore`, `book_sources`.`header` AS `header`, `book_sources`.`loginUrl` AS `loginUrl`, `book_sources`.`bookSourceComment` AS `bookSourceComment`, `book_sources`.`lastUpdateTime` AS `lastUpdateTime`, `book_sources`.`weight` AS `weight`, `book_sources`.`exploreUrl` AS `exploreUrl`, `book_sources`.`ruleExplore` AS `ruleExplore`, `book_sources`.`searchUrl` AS `searchUrl`, `book_sources`.`ruleSearch` AS `ruleSearch`, `book_sources`.`ruleBookInfo` AS `ruleBookInfo`, `book_sources`.`ruleToc` AS `ruleToc`, `book_sources`.`ruleContent` AS `ruleContent` from book_sources where trim(bookUrlPattern) <> ''", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                        int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                        int i12 = i8;
                        String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                        int i13 = columnIndexOrThrow15;
                        int i14 = columnIndexOrThrow;
                        if (cursorQuery.isNull(i13)) {
                            i2 = i13;
                            i4 = columnIndexOrThrow12;
                            i3 = i12;
                            string = null;
                        } else {
                            i2 = i13;
                            i3 = i12;
                            string = cursorQuery.getString(i13);
                            i4 = columnIndexOrThrow12;
                        }
                        try {
                            ExploreRule exploreRuleStringToExploreRule = this.__converters.stringToExploreRule(string);
                            int i15 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i15)) {
                                i5 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i15);
                                i5 = columnIndexOrThrow17;
                            }
                            if (cursorQuery.isNull(i5)) {
                                i6 = i15;
                                i7 = i5;
                                string3 = null;
                            } else {
                                i6 = i15;
                                string3 = cursorQuery.getString(i5);
                                i7 = i5;
                            }
                            SearchRule searchRuleStringToSearchRule = this.__converters.stringToSearchRule(string3);
                            int i16 = columnIndexOrThrow18;
                            if (cursorQuery.isNull(i16)) {
                                columnIndexOrThrow18 = i16;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i16);
                                columnIndexOrThrow18 = i16;
                            }
                            BookInfoRule bookInfoRuleStringToBookInfoRule = this.__converters.stringToBookInfoRule(string4);
                            int i17 = columnIndexOrThrow19;
                            if (cursorQuery.isNull(i17)) {
                                columnIndexOrThrow19 = i17;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i17);
                                columnIndexOrThrow19 = i17;
                            }
                            TocRule tocRuleStringToTocRule = this.__converters.stringToTocRule(string5);
                            int i18 = columnIndexOrThrow20;
                            if (cursorQuery.isNull(i18)) {
                                columnIndexOrThrow20 = i18;
                                string6 = null;
                            } else {
                                string6 = cursorQuery.getString(i18);
                                columnIndexOrThrow20 = i18;
                            }
                            arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, this.__converters.stringToContentRule(string6)));
                            columnIndexOrThrow = i14;
                            columnIndexOrThrow12 = i4;
                            columnIndexOrThrow15 = i2;
                            i8 = i3;
                            int i19 = i6;
                            columnIndexOrThrow17 = i7;
                            columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public int getMaxOrder() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select max(customOrder) from book_sources", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookSourceDao
    public int getMinOrder() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select min(customOrder) from book_sources", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.BookSourceDao
    public List<BookSource> getNoGroup() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        int i3;
        String string;
        int i4;
        String string2;
        int i5;
        int i6;
        String string3;
        int i7;
        String string4;
        String string5;
        String string6;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `book_sources`.`bookSourceName` AS `bookSourceName`, `book_sources`.`bookSourceGroup` AS `bookSourceGroup`, `book_sources`.`bookSourceUrl` AS `bookSourceUrl`, `book_sources`.`bookSourceType` AS `bookSourceType`, `book_sources`.`bookUrlPattern` AS `bookUrlPattern`, `book_sources`.`customOrder` AS `customOrder`, `book_sources`.`enabled` AS `enabled`, `book_sources`.`enabledExplore` AS `enabledExplore`, `book_sources`.`header` AS `header`, `book_sources`.`loginUrl` AS `loginUrl`, `book_sources`.`bookSourceComment` AS `bookSourceComment`, `book_sources`.`lastUpdateTime` AS `lastUpdateTime`, `book_sources`.`weight` AS `weight`, `book_sources`.`exploreUrl` AS `exploreUrl`, `book_sources`.`ruleExplore` AS `ruleExplore`, `book_sources`.`searchUrl` AS `searchUrl`, `book_sources`.`ruleSearch` AS `ruleSearch`, `book_sources`.`ruleBookInfo` AS `ruleBookInfo`, `book_sources`.`ruleToc` AS `ruleToc`, `book_sources`.`ruleContent` AS `ruleContent` from book_sources where bookSourceGroup is null or bookSourceGroup = ''", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                        int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                        int i12 = i8;
                        String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                        int i13 = columnIndexOrThrow15;
                        int i14 = columnIndexOrThrow;
                        if (cursorQuery.isNull(i13)) {
                            i2 = i13;
                            i4 = columnIndexOrThrow12;
                            i3 = i12;
                            string = null;
                        } else {
                            i2 = i13;
                            i3 = i12;
                            string = cursorQuery.getString(i13);
                            i4 = columnIndexOrThrow12;
                        }
                        try {
                            ExploreRule exploreRuleStringToExploreRule = this.__converters.stringToExploreRule(string);
                            int i15 = columnIndexOrThrow16;
                            if (cursorQuery.isNull(i15)) {
                                i5 = columnIndexOrThrow17;
                                string2 = null;
                            } else {
                                string2 = cursorQuery.getString(i15);
                                i5 = columnIndexOrThrow17;
                            }
                            if (cursorQuery.isNull(i5)) {
                                i6 = i15;
                                i7 = i5;
                                string3 = null;
                            } else {
                                i6 = i15;
                                string3 = cursorQuery.getString(i5);
                                i7 = i5;
                            }
                            SearchRule searchRuleStringToSearchRule = this.__converters.stringToSearchRule(string3);
                            int i16 = columnIndexOrThrow18;
                            if (cursorQuery.isNull(i16)) {
                                columnIndexOrThrow18 = i16;
                                string4 = null;
                            } else {
                                string4 = cursorQuery.getString(i16);
                                columnIndexOrThrow18 = i16;
                            }
                            BookInfoRule bookInfoRuleStringToBookInfoRule = this.__converters.stringToBookInfoRule(string4);
                            int i17 = columnIndexOrThrow19;
                            if (cursorQuery.isNull(i17)) {
                                columnIndexOrThrow19 = i17;
                                string5 = null;
                            } else {
                                string5 = cursorQuery.getString(i17);
                                columnIndexOrThrow19 = i17;
                            }
                            TocRule tocRuleStringToTocRule = this.__converters.stringToTocRule(string5);
                            int i18 = columnIndexOrThrow20;
                            if (cursorQuery.isNull(i18)) {
                                columnIndexOrThrow20 = i18;
                                string6 = null;
                            } else {
                                string6 = cursorQuery.getString(i18);
                                columnIndexOrThrow20 = i18;
                            }
                            arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, this.__converters.stringToContentRule(string6)));
                            columnIndexOrThrow = i14;
                            columnIndexOrThrow12 = i4;
                            columnIndexOrThrow15 = i2;
                            i8 = i3;
                            int i19 = i6;
                            columnIndexOrThrow17 = i7;
                            columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public void insert(BookSource... bookSourceArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfBookSource.insert(bookSourceArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.BookSourceDao
    public LiveData<List<BookSource>> liveDataAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `book_sources`.`bookSourceName` AS `bookSourceName`, `book_sources`.`bookSourceGroup` AS `bookSourceGroup`, `book_sources`.`bookSourceUrl` AS `bookSourceUrl`, `book_sources`.`bookSourceType` AS `bookSourceType`, `book_sources`.`bookUrlPattern` AS `bookUrlPattern`, `book_sources`.`customOrder` AS `customOrder`, `book_sources`.`enabled` AS `enabled`, `book_sources`.`enabledExplore` AS `enabledExplore`, `book_sources`.`header` AS `header`, `book_sources`.`loginUrl` AS `loginUrl`, `book_sources`.`bookSourceComment` AS `bookSourceComment`, `book_sources`.`lastUpdateTime` AS `lastUpdateTime`, `book_sources`.`weight` AS `weight`, `book_sources`.`exploreUrl` AS `exploreUrl`, `book_sources`.`ruleExplore` AS `ruleExplore`, `book_sources`.`searchUrl` AS `searchUrl`, `book_sources`.`ruleSearch` AS `ruleSearch`, `book_sources`.`ruleBookInfo` AS `ruleBookInfo`, `book_sources`.`ruleToc` AS `ruleToc`, `book_sources`.`ruleContent` AS `ruleContent` from book_sources order by customOrder asc", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_sources"}, false, new Callable<List<BookSource>>() { // from class: io.legado.app.data.dao.BookSourceDao_Impl.5
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<BookSource> call() throws Throwable {
                int i2;
                int i3;
                String string;
                int i4;
                String string2;
                int i5;
                int i6;
                String string3;
                int i7;
                String string4;
                String string5;
                String string6;
                Cursor cursorQuery = DBUtil.query(BookSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                        int i8 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                            String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                            int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i12 = i8;
                            String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                            int i13 = columnIndexOrThrow15;
                            int i14 = columnIndexOrThrow;
                            if (cursorQuery.isNull(i13)) {
                                i2 = i13;
                                i4 = columnIndexOrThrow13;
                                i3 = i12;
                                string = null;
                            } else {
                                i2 = i13;
                                i3 = i12;
                                string = cursorQuery.getString(i13);
                                i4 = columnIndexOrThrow13;
                            }
                            try {
                                ExploreRule exploreRuleStringToExploreRule = BookSourceDao_Impl.this.__converters.stringToExploreRule(string);
                                int i15 = columnIndexOrThrow16;
                                if (cursorQuery.isNull(i15)) {
                                    i5 = columnIndexOrThrow17;
                                    string2 = null;
                                } else {
                                    string2 = cursorQuery.getString(i15);
                                    i5 = columnIndexOrThrow17;
                                }
                                if (cursorQuery.isNull(i5)) {
                                    i6 = i15;
                                    i7 = i5;
                                    string3 = null;
                                } else {
                                    i6 = i15;
                                    string3 = cursorQuery.getString(i5);
                                    i7 = i5;
                                }
                                SearchRule searchRuleStringToSearchRule = BookSourceDao_Impl.this.__converters.stringToSearchRule(string3);
                                int i16 = columnIndexOrThrow18;
                                if (cursorQuery.isNull(i16)) {
                                    columnIndexOrThrow18 = i16;
                                    string4 = null;
                                } else {
                                    string4 = cursorQuery.getString(i16);
                                    columnIndexOrThrow18 = i16;
                                }
                                BookInfoRule bookInfoRuleStringToBookInfoRule = BookSourceDao_Impl.this.__converters.stringToBookInfoRule(string4);
                                int i17 = columnIndexOrThrow19;
                                if (cursorQuery.isNull(i17)) {
                                    columnIndexOrThrow19 = i17;
                                    string5 = null;
                                } else {
                                    string5 = cursorQuery.getString(i17);
                                    columnIndexOrThrow19 = i17;
                                }
                                TocRule tocRuleStringToTocRule = BookSourceDao_Impl.this.__converters.stringToTocRule(string5);
                                int i18 = columnIndexOrThrow20;
                                if (cursorQuery.isNull(i18)) {
                                    columnIndexOrThrow20 = i18;
                                    string6 = null;
                                } else {
                                    string6 = cursorQuery.getString(i18);
                                    columnIndexOrThrow20 = i18;
                                }
                                arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, BookSourceDao_Impl.this.__converters.stringToContentRule(string6)));
                                columnIndexOrThrow = i14;
                                columnIndexOrThrow13 = i4;
                                columnIndexOrThrow15 = i2;
                                i8 = i3;
                                int i19 = i6;
                                columnIndexOrThrow17 = i7;
                                columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public LiveData<List<BookSource>> liveDataDisabled() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `book_sources`.`bookSourceName` AS `bookSourceName`, `book_sources`.`bookSourceGroup` AS `bookSourceGroup`, `book_sources`.`bookSourceUrl` AS `bookSourceUrl`, `book_sources`.`bookSourceType` AS `bookSourceType`, `book_sources`.`bookUrlPattern` AS `bookUrlPattern`, `book_sources`.`customOrder` AS `customOrder`, `book_sources`.`enabled` AS `enabled`, `book_sources`.`enabledExplore` AS `enabledExplore`, `book_sources`.`header` AS `header`, `book_sources`.`loginUrl` AS `loginUrl`, `book_sources`.`bookSourceComment` AS `bookSourceComment`, `book_sources`.`lastUpdateTime` AS `lastUpdateTime`, `book_sources`.`weight` AS `weight`, `book_sources`.`exploreUrl` AS `exploreUrl`, `book_sources`.`ruleExplore` AS `ruleExplore`, `book_sources`.`searchUrl` AS `searchUrl`, `book_sources`.`ruleSearch` AS `ruleSearch`, `book_sources`.`ruleBookInfo` AS `ruleBookInfo`, `book_sources`.`ruleToc` AS `ruleToc`, `book_sources`.`ruleContent` AS `ruleContent` from book_sources where enabled = 0 order by customOrder asc", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_sources"}, false, new Callable<List<BookSource>>() { // from class: io.legado.app.data.dao.BookSourceDao_Impl.9
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<BookSource> call() throws Throwable {
                int i2;
                int i3;
                String string;
                int i4;
                String string2;
                int i5;
                int i6;
                String string3;
                int i7;
                String string4;
                String string5;
                String string6;
                Cursor cursorQuery = DBUtil.query(BookSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                        int i8 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                            String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                            int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i12 = i8;
                            String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                            int i13 = columnIndexOrThrow15;
                            int i14 = columnIndexOrThrow;
                            if (cursorQuery.isNull(i13)) {
                                i2 = i13;
                                i4 = columnIndexOrThrow13;
                                i3 = i12;
                                string = null;
                            } else {
                                i2 = i13;
                                i3 = i12;
                                string = cursorQuery.getString(i13);
                                i4 = columnIndexOrThrow13;
                            }
                            try {
                                ExploreRule exploreRuleStringToExploreRule = BookSourceDao_Impl.this.__converters.stringToExploreRule(string);
                                int i15 = columnIndexOrThrow16;
                                if (cursorQuery.isNull(i15)) {
                                    i5 = columnIndexOrThrow17;
                                    string2 = null;
                                } else {
                                    string2 = cursorQuery.getString(i15);
                                    i5 = columnIndexOrThrow17;
                                }
                                if (cursorQuery.isNull(i5)) {
                                    i6 = i15;
                                    i7 = i5;
                                    string3 = null;
                                } else {
                                    i6 = i15;
                                    string3 = cursorQuery.getString(i5);
                                    i7 = i5;
                                }
                                SearchRule searchRuleStringToSearchRule = BookSourceDao_Impl.this.__converters.stringToSearchRule(string3);
                                int i16 = columnIndexOrThrow18;
                                if (cursorQuery.isNull(i16)) {
                                    columnIndexOrThrow18 = i16;
                                    string4 = null;
                                } else {
                                    string4 = cursorQuery.getString(i16);
                                    columnIndexOrThrow18 = i16;
                                }
                                BookInfoRule bookInfoRuleStringToBookInfoRule = BookSourceDao_Impl.this.__converters.stringToBookInfoRule(string4);
                                int i17 = columnIndexOrThrow19;
                                if (cursorQuery.isNull(i17)) {
                                    columnIndexOrThrow19 = i17;
                                    string5 = null;
                                } else {
                                    string5 = cursorQuery.getString(i17);
                                    columnIndexOrThrow19 = i17;
                                }
                                TocRule tocRuleStringToTocRule = BookSourceDao_Impl.this.__converters.stringToTocRule(string5);
                                int i18 = columnIndexOrThrow20;
                                if (cursorQuery.isNull(i18)) {
                                    columnIndexOrThrow20 = i18;
                                    string6 = null;
                                } else {
                                    string6 = cursorQuery.getString(i18);
                                    columnIndexOrThrow20 = i18;
                                }
                                arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, BookSourceDao_Impl.this.__converters.stringToContentRule(string6)));
                                columnIndexOrThrow = i14;
                                columnIndexOrThrow13 = i4;
                                columnIndexOrThrow15 = i2;
                                i8 = i3;
                                int i19 = i6;
                                columnIndexOrThrow17 = i7;
                                columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public LiveData<List<BookSource>> liveDataEnabled() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `book_sources`.`bookSourceName` AS `bookSourceName`, `book_sources`.`bookSourceGroup` AS `bookSourceGroup`, `book_sources`.`bookSourceUrl` AS `bookSourceUrl`, `book_sources`.`bookSourceType` AS `bookSourceType`, `book_sources`.`bookUrlPattern` AS `bookUrlPattern`, `book_sources`.`customOrder` AS `customOrder`, `book_sources`.`enabled` AS `enabled`, `book_sources`.`enabledExplore` AS `enabledExplore`, `book_sources`.`header` AS `header`, `book_sources`.`loginUrl` AS `loginUrl`, `book_sources`.`bookSourceComment` AS `bookSourceComment`, `book_sources`.`lastUpdateTime` AS `lastUpdateTime`, `book_sources`.`weight` AS `weight`, `book_sources`.`exploreUrl` AS `exploreUrl`, `book_sources`.`ruleExplore` AS `ruleExplore`, `book_sources`.`searchUrl` AS `searchUrl`, `book_sources`.`ruleSearch` AS `ruleSearch`, `book_sources`.`ruleBookInfo` AS `ruleBookInfo`, `book_sources`.`ruleToc` AS `ruleToc`, `book_sources`.`ruleContent` AS `ruleContent` from book_sources where enabled = 1 order by customOrder asc", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_sources"}, false, new Callable<List<BookSource>>() { // from class: io.legado.app.data.dao.BookSourceDao_Impl.8
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<BookSource> call() throws Throwable {
                int i2;
                int i3;
                String string;
                int i4;
                String string2;
                int i5;
                int i6;
                String string3;
                int i7;
                String string4;
                String string5;
                String string6;
                Cursor cursorQuery = DBUtil.query(BookSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                        int i8 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                            String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                            int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i12 = i8;
                            String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                            int i13 = columnIndexOrThrow15;
                            int i14 = columnIndexOrThrow;
                            if (cursorQuery.isNull(i13)) {
                                i2 = i13;
                                i4 = columnIndexOrThrow13;
                                i3 = i12;
                                string = null;
                            } else {
                                i2 = i13;
                                i3 = i12;
                                string = cursorQuery.getString(i13);
                                i4 = columnIndexOrThrow13;
                            }
                            try {
                                ExploreRule exploreRuleStringToExploreRule = BookSourceDao_Impl.this.__converters.stringToExploreRule(string);
                                int i15 = columnIndexOrThrow16;
                                if (cursorQuery.isNull(i15)) {
                                    i5 = columnIndexOrThrow17;
                                    string2 = null;
                                } else {
                                    string2 = cursorQuery.getString(i15);
                                    i5 = columnIndexOrThrow17;
                                }
                                if (cursorQuery.isNull(i5)) {
                                    i6 = i15;
                                    i7 = i5;
                                    string3 = null;
                                } else {
                                    i6 = i15;
                                    string3 = cursorQuery.getString(i5);
                                    i7 = i5;
                                }
                                SearchRule searchRuleStringToSearchRule = BookSourceDao_Impl.this.__converters.stringToSearchRule(string3);
                                int i16 = columnIndexOrThrow18;
                                if (cursorQuery.isNull(i16)) {
                                    columnIndexOrThrow18 = i16;
                                    string4 = null;
                                } else {
                                    string4 = cursorQuery.getString(i16);
                                    columnIndexOrThrow18 = i16;
                                }
                                BookInfoRule bookInfoRuleStringToBookInfoRule = BookSourceDao_Impl.this.__converters.stringToBookInfoRule(string4);
                                int i17 = columnIndexOrThrow19;
                                if (cursorQuery.isNull(i17)) {
                                    columnIndexOrThrow19 = i17;
                                    string5 = null;
                                } else {
                                    string5 = cursorQuery.getString(i17);
                                    columnIndexOrThrow19 = i17;
                                }
                                TocRule tocRuleStringToTocRule = BookSourceDao_Impl.this.__converters.stringToTocRule(string5);
                                int i18 = columnIndexOrThrow20;
                                if (cursorQuery.isNull(i18)) {
                                    columnIndexOrThrow20 = i18;
                                    string6 = null;
                                } else {
                                    string6 = cursorQuery.getString(i18);
                                    columnIndexOrThrow20 = i18;
                                }
                                arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, BookSourceDao_Impl.this.__converters.stringToContentRule(string6)));
                                columnIndexOrThrow = i14;
                                columnIndexOrThrow13 = i4;
                                columnIndexOrThrow15 = i2;
                                i8 = i3;
                                int i19 = i6;
                                columnIndexOrThrow17 = i7;
                                columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public LiveData<List<BookSource>> liveDataGroupSearch(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from book_sources where bookSourceGroup like ? order by customOrder asc", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_sources"}, false, new Callable<List<BookSource>>() { // from class: io.legado.app.data.dao.BookSourceDao_Impl.7
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<BookSource> call() throws Throwable {
                int i2;
                int i3;
                String string;
                int i4;
                String string2;
                int i5;
                int i6;
                String string3;
                int i7;
                String string4;
                String string5;
                String string6;
                Cursor cursorQuery = DBUtil.query(BookSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                        int i8 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                            String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                            int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i12 = i8;
                            String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                            int i13 = columnIndexOrThrow15;
                            int i14 = columnIndexOrThrow;
                            if (cursorQuery.isNull(i13)) {
                                i2 = i13;
                                i4 = columnIndexOrThrow13;
                                i3 = i12;
                                string = null;
                            } else {
                                i2 = i13;
                                i3 = i12;
                                string = cursorQuery.getString(i13);
                                i4 = columnIndexOrThrow13;
                            }
                            try {
                                ExploreRule exploreRuleStringToExploreRule = BookSourceDao_Impl.this.__converters.stringToExploreRule(string);
                                int i15 = columnIndexOrThrow16;
                                if (cursorQuery.isNull(i15)) {
                                    i5 = columnIndexOrThrow17;
                                    string2 = null;
                                } else {
                                    string2 = cursorQuery.getString(i15);
                                    i5 = columnIndexOrThrow17;
                                }
                                if (cursorQuery.isNull(i5)) {
                                    i6 = i15;
                                    i7 = i5;
                                    string3 = null;
                                } else {
                                    i6 = i15;
                                    string3 = cursorQuery.getString(i5);
                                    i7 = i5;
                                }
                                SearchRule searchRuleStringToSearchRule = BookSourceDao_Impl.this.__converters.stringToSearchRule(string3);
                                int i16 = columnIndexOrThrow18;
                                if (cursorQuery.isNull(i16)) {
                                    columnIndexOrThrow18 = i16;
                                    string4 = null;
                                } else {
                                    string4 = cursorQuery.getString(i16);
                                    columnIndexOrThrow18 = i16;
                                }
                                BookInfoRule bookInfoRuleStringToBookInfoRule = BookSourceDao_Impl.this.__converters.stringToBookInfoRule(string4);
                                int i17 = columnIndexOrThrow19;
                                if (cursorQuery.isNull(i17)) {
                                    columnIndexOrThrow19 = i17;
                                    string5 = null;
                                } else {
                                    string5 = cursorQuery.getString(i17);
                                    columnIndexOrThrow19 = i17;
                                }
                                TocRule tocRuleStringToTocRule = BookSourceDao_Impl.this.__converters.stringToTocRule(string5);
                                int i18 = columnIndexOrThrow20;
                                if (cursorQuery.isNull(i18)) {
                                    columnIndexOrThrow20 = i18;
                                    string6 = null;
                                } else {
                                    string6 = cursorQuery.getString(i18);
                                    columnIndexOrThrow20 = i18;
                                }
                                arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, BookSourceDao_Impl.this.__converters.stringToContentRule(string6)));
                                columnIndexOrThrow = i14;
                                columnIndexOrThrow13 = i4;
                                columnIndexOrThrow15 = i2;
                                i8 = i3;
                                int i19 = i6;
                                columnIndexOrThrow17 = i7;
                                columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public LiveData<List<BookSource>> liveDataSearch(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from book_sources where bookSourceName like ? or bookSourceGroup like ? or bookSourceUrl like ?  or bookSourceComment like ? order by customOrder asc", 4);
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
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, str);
        }
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(4);
        } else {
            roomSQLiteQueryAcquire.bindString(4, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_sources"}, false, new Callable<List<BookSource>>() { // from class: io.legado.app.data.dao.BookSourceDao_Impl.6
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<BookSource> call() throws Throwable {
                int i2;
                int i3;
                String string;
                int i4;
                String string2;
                int i5;
                int i6;
                String string3;
                int i7;
                String string4;
                String string5;
                String string6;
                Cursor cursorQuery = DBUtil.query(BookSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                        int i8 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                            String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                            int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i12 = i8;
                            String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                            int i13 = columnIndexOrThrow15;
                            int i14 = columnIndexOrThrow;
                            if (cursorQuery.isNull(i13)) {
                                i2 = i13;
                                i4 = columnIndexOrThrow13;
                                i3 = i12;
                                string = null;
                            } else {
                                i2 = i13;
                                i3 = i12;
                                string = cursorQuery.getString(i13);
                                i4 = columnIndexOrThrow13;
                            }
                            try {
                                ExploreRule exploreRuleStringToExploreRule = BookSourceDao_Impl.this.__converters.stringToExploreRule(string);
                                int i15 = columnIndexOrThrow16;
                                if (cursorQuery.isNull(i15)) {
                                    i5 = columnIndexOrThrow17;
                                    string2 = null;
                                } else {
                                    string2 = cursorQuery.getString(i15);
                                    i5 = columnIndexOrThrow17;
                                }
                                if (cursorQuery.isNull(i5)) {
                                    i6 = i15;
                                    i7 = i5;
                                    string3 = null;
                                } else {
                                    i6 = i15;
                                    string3 = cursorQuery.getString(i5);
                                    i7 = i5;
                                }
                                SearchRule searchRuleStringToSearchRule = BookSourceDao_Impl.this.__converters.stringToSearchRule(string3);
                                int i16 = columnIndexOrThrow18;
                                if (cursorQuery.isNull(i16)) {
                                    columnIndexOrThrow18 = i16;
                                    string4 = null;
                                } else {
                                    string4 = cursorQuery.getString(i16);
                                    columnIndexOrThrow18 = i16;
                                }
                                BookInfoRule bookInfoRuleStringToBookInfoRule = BookSourceDao_Impl.this.__converters.stringToBookInfoRule(string4);
                                int i17 = columnIndexOrThrow19;
                                if (cursorQuery.isNull(i17)) {
                                    columnIndexOrThrow19 = i17;
                                    string5 = null;
                                } else {
                                    string5 = cursorQuery.getString(i17);
                                    columnIndexOrThrow19 = i17;
                                }
                                TocRule tocRuleStringToTocRule = BookSourceDao_Impl.this.__converters.stringToTocRule(string5);
                                int i18 = columnIndexOrThrow20;
                                if (cursorQuery.isNull(i18)) {
                                    columnIndexOrThrow20 = i18;
                                    string6 = null;
                                } else {
                                    string6 = cursorQuery.getString(i18);
                                    columnIndexOrThrow20 = i18;
                                }
                                arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, BookSourceDao_Impl.this.__converters.stringToContentRule(string6)));
                                columnIndexOrThrow = i14;
                                columnIndexOrThrow13 = i4;
                                columnIndexOrThrow15 = i2;
                                i8 = i3;
                                int i19 = i6;
                                columnIndexOrThrow17 = i7;
                                columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public LiveData<List<BookSource>> liveExplore() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `book_sources`.`bookSourceName` AS `bookSourceName`, `book_sources`.`bookSourceGroup` AS `bookSourceGroup`, `book_sources`.`bookSourceUrl` AS `bookSourceUrl`, `book_sources`.`bookSourceType` AS `bookSourceType`, `book_sources`.`bookUrlPattern` AS `bookUrlPattern`, `book_sources`.`customOrder` AS `customOrder`, `book_sources`.`enabled` AS `enabled`, `book_sources`.`enabledExplore` AS `enabledExplore`, `book_sources`.`header` AS `header`, `book_sources`.`loginUrl` AS `loginUrl`, `book_sources`.`bookSourceComment` AS `bookSourceComment`, `book_sources`.`lastUpdateTime` AS `lastUpdateTime`, `book_sources`.`weight` AS `weight`, `book_sources`.`exploreUrl` AS `exploreUrl`, `book_sources`.`ruleExplore` AS `ruleExplore`, `book_sources`.`searchUrl` AS `searchUrl`, `book_sources`.`ruleSearch` AS `ruleSearch`, `book_sources`.`ruleBookInfo` AS `ruleBookInfo`, `book_sources`.`ruleToc` AS `ruleToc`, `book_sources`.`ruleContent` AS `ruleContent` from book_sources where enabledExplore = 1 and trim(exploreUrl) <> '' order by customOrder asc", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_sources"}, false, new Callable<List<BookSource>>() { // from class: io.legado.app.data.dao.BookSourceDao_Impl.10
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<BookSource> call() throws Throwable {
                int i2;
                int i3;
                String string;
                int i4;
                String string2;
                int i5;
                int i6;
                String string3;
                int i7;
                String string4;
                String string5;
                String string6;
                Cursor cursorQuery = DBUtil.query(BookSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                        int i8 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                            String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                            int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i12 = i8;
                            String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                            int i13 = columnIndexOrThrow15;
                            int i14 = columnIndexOrThrow;
                            if (cursorQuery.isNull(i13)) {
                                i2 = i13;
                                i4 = columnIndexOrThrow13;
                                i3 = i12;
                                string = null;
                            } else {
                                i2 = i13;
                                i3 = i12;
                                string = cursorQuery.getString(i13);
                                i4 = columnIndexOrThrow13;
                            }
                            try {
                                ExploreRule exploreRuleStringToExploreRule = BookSourceDao_Impl.this.__converters.stringToExploreRule(string);
                                int i15 = columnIndexOrThrow16;
                                if (cursorQuery.isNull(i15)) {
                                    i5 = columnIndexOrThrow17;
                                    string2 = null;
                                } else {
                                    string2 = cursorQuery.getString(i15);
                                    i5 = columnIndexOrThrow17;
                                }
                                if (cursorQuery.isNull(i5)) {
                                    i6 = i15;
                                    i7 = i5;
                                    string3 = null;
                                } else {
                                    i6 = i15;
                                    string3 = cursorQuery.getString(i5);
                                    i7 = i5;
                                }
                                SearchRule searchRuleStringToSearchRule = BookSourceDao_Impl.this.__converters.stringToSearchRule(string3);
                                int i16 = columnIndexOrThrow18;
                                if (cursorQuery.isNull(i16)) {
                                    columnIndexOrThrow18 = i16;
                                    string4 = null;
                                } else {
                                    string4 = cursorQuery.getString(i16);
                                    columnIndexOrThrow18 = i16;
                                }
                                BookInfoRule bookInfoRuleStringToBookInfoRule = BookSourceDao_Impl.this.__converters.stringToBookInfoRule(string4);
                                int i17 = columnIndexOrThrow19;
                                if (cursorQuery.isNull(i17)) {
                                    columnIndexOrThrow19 = i17;
                                    string5 = null;
                                } else {
                                    string5 = cursorQuery.getString(i17);
                                    columnIndexOrThrow19 = i17;
                                }
                                TocRule tocRuleStringToTocRule = BookSourceDao_Impl.this.__converters.stringToTocRule(string5);
                                int i18 = columnIndexOrThrow20;
                                if (cursorQuery.isNull(i18)) {
                                    columnIndexOrThrow20 = i18;
                                    string6 = null;
                                } else {
                                    string6 = cursorQuery.getString(i18);
                                    columnIndexOrThrow20 = i18;
                                }
                                arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, BookSourceDao_Impl.this.__converters.stringToContentRule(string6)));
                                columnIndexOrThrow = i14;
                                columnIndexOrThrow13 = i4;
                                columnIndexOrThrow15 = i2;
                                i8 = i3;
                                int i19 = i6;
                                columnIndexOrThrow17 = i7;
                                columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public LiveData<List<String>> liveExploreGroup() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select distinct bookSourceGroup from book_sources where enabledExplore = 1 and trim(exploreUrl) <> '' and trim(bookSourceGroup) <> ''", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_sources"}, false, new Callable<List<String>>() { // from class: io.legado.app.data.dao.BookSourceDao_Impl.15
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(BookSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public LiveData<List<String>> liveGroup() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select distinct bookSourceGroup from book_sources where trim(bookSourceGroup) <> ''", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_sources"}, false, new Callable<List<String>>() { // from class: io.legado.app.data.dao.BookSourceDao_Impl.13
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(BookSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public LiveData<List<String>> liveGroupEnabled() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select distinct bookSourceGroup from book_sources where enabled = 1 and trim(bookSourceGroup) <> ''", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_sources"}, false, new Callable<List<String>>() { // from class: io.legado.app.data.dao.BookSourceDao_Impl.14
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(BookSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public LiveData<List<BookSource>> liveGroupExplore(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from book_sources where enabledExplore = 1 and trim(exploreUrl) <> '' and (bookSourceGroup like ?) order by customOrder asc", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_sources"}, false, new Callable<List<BookSource>>() { // from class: io.legado.app.data.dao.BookSourceDao_Impl.12
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<BookSource> call() throws Throwable {
                int i2;
                int i3;
                String string;
                int i4;
                String string2;
                int i5;
                int i6;
                String string3;
                int i7;
                String string4;
                String string5;
                String string6;
                Cursor cursorQuery = DBUtil.query(BookSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                        int i8 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                            String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                            int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i12 = i8;
                            String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                            int i13 = columnIndexOrThrow15;
                            int i14 = columnIndexOrThrow;
                            if (cursorQuery.isNull(i13)) {
                                i2 = i13;
                                i4 = columnIndexOrThrow13;
                                i3 = i12;
                                string = null;
                            } else {
                                i2 = i13;
                                i3 = i12;
                                string = cursorQuery.getString(i13);
                                i4 = columnIndexOrThrow13;
                            }
                            try {
                                ExploreRule exploreRuleStringToExploreRule = BookSourceDao_Impl.this.__converters.stringToExploreRule(string);
                                int i15 = columnIndexOrThrow16;
                                if (cursorQuery.isNull(i15)) {
                                    i5 = columnIndexOrThrow17;
                                    string2 = null;
                                } else {
                                    string2 = cursorQuery.getString(i15);
                                    i5 = columnIndexOrThrow17;
                                }
                                if (cursorQuery.isNull(i5)) {
                                    i6 = i15;
                                    i7 = i5;
                                    string3 = null;
                                } else {
                                    i6 = i15;
                                    string3 = cursorQuery.getString(i5);
                                    i7 = i5;
                                }
                                SearchRule searchRuleStringToSearchRule = BookSourceDao_Impl.this.__converters.stringToSearchRule(string3);
                                int i16 = columnIndexOrThrow18;
                                if (cursorQuery.isNull(i16)) {
                                    columnIndexOrThrow18 = i16;
                                    string4 = null;
                                } else {
                                    string4 = cursorQuery.getString(i16);
                                    columnIndexOrThrow18 = i16;
                                }
                                BookInfoRule bookInfoRuleStringToBookInfoRule = BookSourceDao_Impl.this.__converters.stringToBookInfoRule(string4);
                                int i17 = columnIndexOrThrow19;
                                if (cursorQuery.isNull(i17)) {
                                    columnIndexOrThrow19 = i17;
                                    string5 = null;
                                } else {
                                    string5 = cursorQuery.getString(i17);
                                    columnIndexOrThrow19 = i17;
                                }
                                TocRule tocRuleStringToTocRule = BookSourceDao_Impl.this.__converters.stringToTocRule(string5);
                                int i18 = columnIndexOrThrow20;
                                if (cursorQuery.isNull(i18)) {
                                    columnIndexOrThrow20 = i18;
                                    string6 = null;
                                } else {
                                    string6 = cursorQuery.getString(i18);
                                    columnIndexOrThrow20 = i18;
                                }
                                arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, BookSourceDao_Impl.this.__converters.stringToContentRule(string6)));
                                columnIndexOrThrow = i14;
                                columnIndexOrThrow13 = i4;
                                columnIndexOrThrow15 = i2;
                                i8 = i3;
                                int i19 = i6;
                                columnIndexOrThrow17 = i7;
                                columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public void update(BookSource... bookSourceArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfBookSource.handleMultiple(bookSourceArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.BookSourceDao
    public LiveData<List<BookSource>> liveExplore(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from book_sources where enabledExplore = 1 and trim(exploreUrl) <> '' and (bookSourceGroup like ? or bookSourceName like ?) order by customOrder asc", 2);
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
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"book_sources"}, false, new Callable<List<BookSource>>() { // from class: io.legado.app.data.dao.BookSourceDao_Impl.11
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<BookSource> call() throws Throwable {
                int i2;
                int i3;
                String string;
                int i4;
                String string2;
                int i5;
                int i6;
                String string3;
                int i7;
                String string4;
                String string5;
                String string6;
                Cursor cursorQuery = DBUtil.query(BookSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceName");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceGroup");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceUrl");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceType");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookUrlPattern");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabledExplore");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loginUrl");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bookSourceComment");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ActivityChooserModel.ATTRIBUTE_WEIGHT);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "exploreUrl");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleExplore");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "searchUrl");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleSearch");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleBookInfo");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleToc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                        int i8 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                            String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                            int i9 = cursorQuery.getInt(columnIndexOrThrow4);
                            String string10 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            int i10 = cursorQuery.getInt(columnIndexOrThrow6);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                            String string11 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string12 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            String string13 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow12);
                            int i11 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i12 = i8;
                            String string14 = cursorQuery.isNull(i12) ? null : cursorQuery.getString(i12);
                            int i13 = columnIndexOrThrow15;
                            int i14 = columnIndexOrThrow;
                            if (cursorQuery.isNull(i13)) {
                                i2 = i13;
                                i4 = columnIndexOrThrow13;
                                i3 = i12;
                                string = null;
                            } else {
                                i2 = i13;
                                i3 = i12;
                                string = cursorQuery.getString(i13);
                                i4 = columnIndexOrThrow13;
                            }
                            try {
                                ExploreRule exploreRuleStringToExploreRule = BookSourceDao_Impl.this.__converters.stringToExploreRule(string);
                                int i15 = columnIndexOrThrow16;
                                if (cursorQuery.isNull(i15)) {
                                    i5 = columnIndexOrThrow17;
                                    string2 = null;
                                } else {
                                    string2 = cursorQuery.getString(i15);
                                    i5 = columnIndexOrThrow17;
                                }
                                if (cursorQuery.isNull(i5)) {
                                    i6 = i15;
                                    i7 = i5;
                                    string3 = null;
                                } else {
                                    i6 = i15;
                                    string3 = cursorQuery.getString(i5);
                                    i7 = i5;
                                }
                                SearchRule searchRuleStringToSearchRule = BookSourceDao_Impl.this.__converters.stringToSearchRule(string3);
                                int i16 = columnIndexOrThrow18;
                                if (cursorQuery.isNull(i16)) {
                                    columnIndexOrThrow18 = i16;
                                    string4 = null;
                                } else {
                                    string4 = cursorQuery.getString(i16);
                                    columnIndexOrThrow18 = i16;
                                }
                                BookInfoRule bookInfoRuleStringToBookInfoRule = BookSourceDao_Impl.this.__converters.stringToBookInfoRule(string4);
                                int i17 = columnIndexOrThrow19;
                                if (cursorQuery.isNull(i17)) {
                                    columnIndexOrThrow19 = i17;
                                    string5 = null;
                                } else {
                                    string5 = cursorQuery.getString(i17);
                                    columnIndexOrThrow19 = i17;
                                }
                                TocRule tocRuleStringToTocRule = BookSourceDao_Impl.this.__converters.stringToTocRule(string5);
                                int i18 = columnIndexOrThrow20;
                                if (cursorQuery.isNull(i18)) {
                                    columnIndexOrThrow20 = i18;
                                    string6 = null;
                                } else {
                                    string6 = cursorQuery.getString(i18);
                                    columnIndexOrThrow20 = i18;
                                }
                                arrayList.add(new BookSource(string7, string8, string9, i9, string10, i10, z, z2, string11, string12, string13, j2, i11, string14, exploreRuleStringToExploreRule, string2, searchRuleStringToSearchRule, bookInfoRuleStringToBookInfoRule, tocRuleStringToTocRule, BookSourceDao_Impl.this.__converters.stringToContentRule(string6)));
                                columnIndexOrThrow = i14;
                                columnIndexOrThrow13 = i4;
                                columnIndexOrThrow15 = i2;
                                i8 = i3;
                                int i19 = i6;
                                columnIndexOrThrow17 = i7;
                                columnIndexOrThrow16 = i19;
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

    @Override // io.legado.app.data.dao.BookSourceDao
    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
        }
    }
}
