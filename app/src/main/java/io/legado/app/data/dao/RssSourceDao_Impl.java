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
import io.legado.app.data.entities.RssSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class RssSourceDao_Impl implements RssSourceDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RssSource> __deletionAdapterOfRssSource;
    private final EntityInsertionAdapter<RssSource> __insertionAdapterOfRssSource;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final EntityDeletionOrUpdateAdapter<RssSource> __updateAdapterOfRssSource;

    public RssSourceDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRssSource = new EntityInsertionAdapter<RssSource>(roomDatabase) { // from class: io.legado.app.data.dao.RssSourceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `rssSources` (`sourceUrl`,`sourceName`,`sourceIcon`,`sourceGroup`,`sourceComment`,`enabled`,`sortUrl`,`singleUrl`,`articleStyle`,`ruleArticles`,`ruleNextPage`,`ruleTitle`,`rulePubDate`,`ruleDescription`,`ruleImage`,`ruleLink`,`ruleContent`,`style`,`header`,`enableJs`,`loadWithBaseUrl`,`customOrder`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RssSource rssSource) {
                if (rssSource.getSourceUrl() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, rssSource.getSourceUrl());
                }
                if (rssSource.getSourceName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, rssSource.getSourceName());
                }
                if (rssSource.getSourceIcon() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, rssSource.getSourceIcon());
                }
                if (rssSource.getSourceGroup() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, rssSource.getSourceGroup());
                }
                if (rssSource.getSourceComment() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, rssSource.getSourceComment());
                }
                supportSQLiteStatement.bindLong(6, rssSource.getEnabled() ? 1L : 0L);
                if (rssSource.getSortUrl() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, rssSource.getSortUrl());
                }
                supportSQLiteStatement.bindLong(8, rssSource.getSingleUrl() ? 1L : 0L);
                supportSQLiteStatement.bindLong(9, rssSource.getArticleStyle());
                if (rssSource.getRuleArticles() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, rssSource.getRuleArticles());
                }
                if (rssSource.getRuleNextPage() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, rssSource.getRuleNextPage());
                }
                if (rssSource.getRuleTitle() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, rssSource.getRuleTitle());
                }
                if (rssSource.getRulePubDate() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, rssSource.getRulePubDate());
                }
                if (rssSource.getRuleDescription() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, rssSource.getRuleDescription());
                }
                if (rssSource.getRuleImage() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, rssSource.getRuleImage());
                }
                if (rssSource.getRuleLink() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, rssSource.getRuleLink());
                }
                if (rssSource.getRuleContent() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, rssSource.getRuleContent());
                }
                if (rssSource.getStyle() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, rssSource.getStyle());
                }
                if (rssSource.getHeader() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, rssSource.getHeader());
                }
                supportSQLiteStatement.bindLong(20, rssSource.getEnableJs() ? 1L : 0L);
                supportSQLiteStatement.bindLong(21, rssSource.getLoadWithBaseUrl() ? 1L : 0L);
                supportSQLiteStatement.bindLong(22, rssSource.getCustomOrder());
            }
        };
        this.__deletionAdapterOfRssSource = new EntityDeletionOrUpdateAdapter<RssSource>(roomDatabase) { // from class: io.legado.app.data.dao.RssSourceDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `rssSources` WHERE `sourceUrl` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RssSource rssSource) {
                if (rssSource.getSourceUrl() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, rssSource.getSourceUrl());
                }
            }
        };
        this.__updateAdapterOfRssSource = new EntityDeletionOrUpdateAdapter<RssSource>(roomDatabase) { // from class: io.legado.app.data.dao.RssSourceDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `rssSources` SET `sourceUrl` = ?,`sourceName` = ?,`sourceIcon` = ?,`sourceGroup` = ?,`sourceComment` = ?,`enabled` = ?,`sortUrl` = ?,`singleUrl` = ?,`articleStyle` = ?,`ruleArticles` = ?,`ruleNextPage` = ?,`ruleTitle` = ?,`rulePubDate` = ?,`ruleDescription` = ?,`ruleImage` = ?,`ruleLink` = ?,`ruleContent` = ?,`style` = ?,`header` = ?,`enableJs` = ?,`loadWithBaseUrl` = ?,`customOrder` = ? WHERE `sourceUrl` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RssSource rssSource) {
                if (rssSource.getSourceUrl() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, rssSource.getSourceUrl());
                }
                if (rssSource.getSourceName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, rssSource.getSourceName());
                }
                if (rssSource.getSourceIcon() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, rssSource.getSourceIcon());
                }
                if (rssSource.getSourceGroup() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, rssSource.getSourceGroup());
                }
                if (rssSource.getSourceComment() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, rssSource.getSourceComment());
                }
                supportSQLiteStatement.bindLong(6, rssSource.getEnabled() ? 1L : 0L);
                if (rssSource.getSortUrl() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, rssSource.getSortUrl());
                }
                supportSQLiteStatement.bindLong(8, rssSource.getSingleUrl() ? 1L : 0L);
                supportSQLiteStatement.bindLong(9, rssSource.getArticleStyle());
                if (rssSource.getRuleArticles() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, rssSource.getRuleArticles());
                }
                if (rssSource.getRuleNextPage() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, rssSource.getRuleNextPage());
                }
                if (rssSource.getRuleTitle() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, rssSource.getRuleTitle());
                }
                if (rssSource.getRulePubDate() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, rssSource.getRulePubDate());
                }
                if (rssSource.getRuleDescription() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, rssSource.getRuleDescription());
                }
                if (rssSource.getRuleImage() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, rssSource.getRuleImage());
                }
                if (rssSource.getRuleLink() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, rssSource.getRuleLink());
                }
                if (rssSource.getRuleContent() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, rssSource.getRuleContent());
                }
                if (rssSource.getStyle() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, rssSource.getStyle());
                }
                if (rssSource.getHeader() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, rssSource.getHeader());
                }
                supportSQLiteStatement.bindLong(20, rssSource.getEnableJs() ? 1L : 0L);
                supportSQLiteStatement.bindLong(21, rssSource.getLoadWithBaseUrl() ? 1L : 0L);
                supportSQLiteStatement.bindLong(22, rssSource.getCustomOrder());
                if (rssSource.getSourceUrl() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, rssSource.getSourceUrl());
                }
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) { // from class: io.legado.app.data.dao.RssSourceDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from rssSources where sourceUrl = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public void delete(RssSource... rssSourceArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRssSource.handleMultiple(rssSourceArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public List<RssSource> getAll() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i2;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `rssSources`.`sourceUrl` AS `sourceUrl`, `rssSources`.`sourceName` AS `sourceName`, `rssSources`.`sourceIcon` AS `sourceIcon`, `rssSources`.`sourceGroup` AS `sourceGroup`, `rssSources`.`sourceComment` AS `sourceComment`, `rssSources`.`enabled` AS `enabled`, `rssSources`.`sortUrl` AS `sortUrl`, `rssSources`.`singleUrl` AS `singleUrl`, `rssSources`.`articleStyle` AS `articleStyle`, `rssSources`.`ruleArticles` AS `ruleArticles`, `rssSources`.`ruleNextPage` AS `ruleNextPage`, `rssSources`.`ruleTitle` AS `ruleTitle`, `rssSources`.`rulePubDate` AS `rulePubDate`, `rssSources`.`ruleDescription` AS `ruleDescription`, `rssSources`.`ruleImage` AS `ruleImage`, `rssSources`.`ruleLink` AS `ruleLink`, `rssSources`.`ruleContent` AS `ruleContent`, `rssSources`.`style` AS `style`, `rssSources`.`header` AS `header`, `rssSources`.`enableJs` AS `enableJs`, `rssSources`.`loadWithBaseUrl` AS `loadWithBaseUrl`, `rssSources`.`customOrder` AS `customOrder` FROM rssSources", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceIcon");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceGroup");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceComment");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sortUrl");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singleUrl");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "articleStyle");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleArticles");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleNextPage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleTitle");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rulePubDate");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleDescription");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleImage");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleLink");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enableJs");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loadWithBaseUrl");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                    String string7 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                    boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                    int i4 = cursorQuery.getInt(columnIndexOrThrow9);
                    String string8 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                    String string9 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                    String string10 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                    if (cursorQuery.isNull(columnIndexOrThrow13)) {
                        i2 = i3;
                        string = null;
                    } else {
                        string = cursorQuery.getString(columnIndexOrThrow13);
                        i2 = i3;
                    }
                    String string11 = cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2);
                    int i5 = columnIndexOrThrow15;
                    int i6 = columnIndexOrThrow;
                    String string12 = cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5);
                    int i7 = columnIndexOrThrow16;
                    String string13 = cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7);
                    int i8 = columnIndexOrThrow17;
                    String string14 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                    int i9 = columnIndexOrThrow18;
                    String string15 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                    int i10 = columnIndexOrThrow19;
                    String string16 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                    int i11 = columnIndexOrThrow20;
                    boolean z3 = cursorQuery.getInt(i11) != 0;
                    int i12 = columnIndexOrThrow21;
                    boolean z4 = cursorQuery.getInt(i12) != 0;
                    int i13 = columnIndexOrThrow22;
                    arrayList.add(new RssSource(string2, string3, string4, string5, string6, z, string7, z2, i4, string8, string9, string10, string, string11, string12, string13, string14, string15, string16, z3, z4, cursorQuery.getInt(i13)));
                    columnIndexOrThrow = i6;
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow16 = i7;
                    columnIndexOrThrow17 = i8;
                    columnIndexOrThrow18 = i9;
                    columnIndexOrThrow19 = i10;
                    columnIndexOrThrow20 = i11;
                    columnIndexOrThrow21 = i12;
                    columnIndexOrThrow22 = i13;
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

    @Override // io.legado.app.data.dao.RssSourceDao
    public List<String> getAllGroup() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select distinct sourceGroup from rssSources where trim(sourceGroup) <> ''", 0);
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

    @Override // io.legado.app.data.dao.RssSourceDao
    public List<RssSource> getByGroup(String str) throws Throwable {
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
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from rssSources where sourceGroup like '%' || ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceUrl");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceName");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceIcon");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceGroup");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceComment");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sortUrl");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singleUrl");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "articleStyle");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleArticles");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleNextPage");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleTitle");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rulePubDate");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleDescription");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleImage");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleLink");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enableJs");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loadWithBaseUrl");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int i3 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                String string7 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                int i4 = cursorQuery.getInt(columnIndexOrThrow9);
                String string8 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                String string9 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                String string10 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                if (cursorQuery.isNull(columnIndexOrThrow13)) {
                    i2 = i3;
                    string = null;
                } else {
                    string = cursorQuery.getString(columnIndexOrThrow13);
                    i2 = i3;
                }
                String string11 = cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2);
                int i5 = columnIndexOrThrow15;
                int i6 = columnIndexOrThrow;
                String string12 = cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5);
                int i7 = columnIndexOrThrow16;
                String string13 = cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7);
                int i8 = columnIndexOrThrow17;
                String string14 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                int i9 = columnIndexOrThrow18;
                String string15 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                int i10 = columnIndexOrThrow19;
                String string16 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                int i11 = columnIndexOrThrow20;
                boolean z3 = cursorQuery.getInt(i11) != 0;
                int i12 = columnIndexOrThrow21;
                boolean z4 = cursorQuery.getInt(i12) != 0;
                int i13 = columnIndexOrThrow22;
                arrayList.add(new RssSource(string2, string3, string4, string5, string6, z, string7, z2, i4, string8, string9, string10, string, string11, string12, string13, string14, string15, string16, z3, z4, cursorQuery.getInt(i13)));
                columnIndexOrThrow = i6;
                columnIndexOrThrow15 = i5;
                columnIndexOrThrow16 = i7;
                columnIndexOrThrow17 = i8;
                columnIndexOrThrow18 = i9;
                columnIndexOrThrow19 = i10;
                columnIndexOrThrow20 = i11;
                columnIndexOrThrow21 = i12;
                columnIndexOrThrow22 = i13;
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

    @Override // io.legado.app.data.dao.RssSourceDao
    public RssSource getByKey(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RssSource rssSource;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        int i4;
        String string4;
        int i5;
        String string5;
        int i6;
        String string6;
        int i7;
        int i8;
        boolean z;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from rssSources where sourceUrl = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceIcon");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceGroup");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceComment");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sortUrl");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singleUrl");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "articleStyle");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleArticles");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleNextPage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleTitle");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rulePubDate");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleDescription");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleImage");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleLink");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enableJs");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loadWithBaseUrl");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                if (cursorQuery.moveToFirst()) {
                    String string7 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    String string8 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    String string9 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string10 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    String string11 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                    boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                    String string12 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                    boolean z3 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                    int i9 = cursorQuery.getInt(columnIndexOrThrow9);
                    String string13 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                    String string14 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                    String string15 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                    String string16 = cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13);
                    if (cursorQuery.isNull(columnIndexOrThrow14)) {
                        i2 = columnIndexOrThrow15;
                        string = null;
                    } else {
                        string = cursorQuery.getString(columnIndexOrThrow14);
                        i2 = columnIndexOrThrow15;
                    }
                    if (cursorQuery.isNull(i2)) {
                        i3 = columnIndexOrThrow16;
                        string2 = null;
                    } else {
                        string2 = cursorQuery.getString(i2);
                        i3 = columnIndexOrThrow16;
                    }
                    if (cursorQuery.isNull(i3)) {
                        i4 = columnIndexOrThrow17;
                        string3 = null;
                    } else {
                        string3 = cursorQuery.getString(i3);
                        i4 = columnIndexOrThrow17;
                    }
                    if (cursorQuery.isNull(i4)) {
                        i5 = columnIndexOrThrow18;
                        string4 = null;
                    } else {
                        string4 = cursorQuery.getString(i4);
                        i5 = columnIndexOrThrow18;
                    }
                    if (cursorQuery.isNull(i5)) {
                        i6 = columnIndexOrThrow19;
                        string5 = null;
                    } else {
                        string5 = cursorQuery.getString(i5);
                        i6 = columnIndexOrThrow19;
                    }
                    if (cursorQuery.isNull(i6)) {
                        i7 = columnIndexOrThrow20;
                        string6 = null;
                    } else {
                        string6 = cursorQuery.getString(i6);
                        i7 = columnIndexOrThrow20;
                    }
                    if (cursorQuery.getInt(i7) != 0) {
                        i8 = columnIndexOrThrow21;
                        z = true;
                    } else {
                        i8 = columnIndexOrThrow21;
                        z = false;
                    }
                    rssSource = new RssSource(string7, string8, string9, string10, string11, z2, string12, z3, i9, string13, string14, string15, string16, string, string2, string3, string4, string5, string6, z, cursorQuery.getInt(i8) != 0, cursorQuery.getInt(columnIndexOrThrow22));
                } else {
                    rssSource = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return rssSource;
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

    @Override // io.legado.app.data.dao.RssSourceDao
    public int getMaxOrder() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select max(customOrder) from rssSources", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public int getMinOrder() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select min(customOrder) from rssSources", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public List<RssSource> getNoGroup() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i2;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select `rssSources`.`sourceUrl` AS `sourceUrl`, `rssSources`.`sourceName` AS `sourceName`, `rssSources`.`sourceIcon` AS `sourceIcon`, `rssSources`.`sourceGroup` AS `sourceGroup`, `rssSources`.`sourceComment` AS `sourceComment`, `rssSources`.`enabled` AS `enabled`, `rssSources`.`sortUrl` AS `sortUrl`, `rssSources`.`singleUrl` AS `singleUrl`, `rssSources`.`articleStyle` AS `articleStyle`, `rssSources`.`ruleArticles` AS `ruleArticles`, `rssSources`.`ruleNextPage` AS `ruleNextPage`, `rssSources`.`ruleTitle` AS `ruleTitle`, `rssSources`.`rulePubDate` AS `rulePubDate`, `rssSources`.`ruleDescription` AS `ruleDescription`, `rssSources`.`ruleImage` AS `ruleImage`, `rssSources`.`ruleLink` AS `ruleLink`, `rssSources`.`ruleContent` AS `ruleContent`, `rssSources`.`style` AS `style`, `rssSources`.`header` AS `header`, `rssSources`.`enableJs` AS `enableJs`, `rssSources`.`loadWithBaseUrl` AS `loadWithBaseUrl`, `rssSources`.`customOrder` AS `customOrder` from rssSources where sourceGroup is null or sourceGroup = ''", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceIcon");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceGroup");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceComment");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sortUrl");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singleUrl");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "articleStyle");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleArticles");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleNextPage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleTitle");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rulePubDate");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleDescription");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleImage");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleLink");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enableJs");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loadWithBaseUrl");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                    String string7 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                    boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                    int i4 = cursorQuery.getInt(columnIndexOrThrow9);
                    String string8 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                    String string9 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                    String string10 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                    if (cursorQuery.isNull(columnIndexOrThrow13)) {
                        i2 = i3;
                        string = null;
                    } else {
                        string = cursorQuery.getString(columnIndexOrThrow13);
                        i2 = i3;
                    }
                    String string11 = cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2);
                    int i5 = columnIndexOrThrow15;
                    int i6 = columnIndexOrThrow;
                    String string12 = cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5);
                    int i7 = columnIndexOrThrow16;
                    String string13 = cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7);
                    int i8 = columnIndexOrThrow17;
                    String string14 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                    int i9 = columnIndexOrThrow18;
                    String string15 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                    int i10 = columnIndexOrThrow19;
                    String string16 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                    int i11 = columnIndexOrThrow20;
                    boolean z3 = cursorQuery.getInt(i11) != 0;
                    int i12 = columnIndexOrThrow21;
                    boolean z4 = cursorQuery.getInt(i12) != 0;
                    int i13 = columnIndexOrThrow22;
                    arrayList.add(new RssSource(string2, string3, string4, string5, string6, z, string7, z2, i4, string8, string9, string10, string, string11, string12, string13, string14, string15, string16, z3, z4, cursorQuery.getInt(i13)));
                    columnIndexOrThrow = i6;
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow16 = i7;
                    columnIndexOrThrow17 = i8;
                    columnIndexOrThrow18 = i9;
                    columnIndexOrThrow19 = i10;
                    columnIndexOrThrow20 = i11;
                    columnIndexOrThrow21 = i12;
                    columnIndexOrThrow22 = i13;
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

    @Override // io.legado.app.data.dao.RssSourceDao
    public List<RssSource> getRssSources(String... strArr) throws Throwable {
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
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("select * from rssSources where sourceUrl in (");
        int length = strArr.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length + 0);
        int i3 = 1;
        for (String str : strArr) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i3);
            } else {
                roomSQLiteQueryAcquire.bindString(i3, str);
            }
            i3++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceUrl");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceName");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceIcon");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceGroup");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceComment");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sortUrl");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singleUrl");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "articleStyle");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleArticles");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleNextPage");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleTitle");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rulePubDate");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleDescription");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleImage");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleLink");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enableJs");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loadWithBaseUrl");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
            int i4 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                String string7 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                int i5 = cursorQuery.getInt(columnIndexOrThrow9);
                String string8 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                String string9 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                String string10 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                if (cursorQuery.isNull(columnIndexOrThrow13)) {
                    i2 = i4;
                    string = null;
                } else {
                    string = cursorQuery.getString(columnIndexOrThrow13);
                    i2 = i4;
                }
                String string11 = cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2);
                int i6 = columnIndexOrThrow15;
                int i7 = columnIndexOrThrow;
                String string12 = cursorQuery.isNull(i6) ? null : cursorQuery.getString(i6);
                int i8 = columnIndexOrThrow16;
                String string13 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                int i9 = columnIndexOrThrow17;
                String string14 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                int i10 = columnIndexOrThrow18;
                String string15 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                int i11 = columnIndexOrThrow19;
                String string16 = cursorQuery.isNull(i11) ? null : cursorQuery.getString(i11);
                int i12 = columnIndexOrThrow20;
                boolean z3 = cursorQuery.getInt(i12) != 0;
                int i13 = columnIndexOrThrow21;
                boolean z4 = cursorQuery.getInt(i13) != 0;
                int i14 = columnIndexOrThrow22;
                arrayList.add(new RssSource(string2, string3, string4, string5, string6, z, string7, z2, i5, string8, string9, string10, string, string11, string12, string13, string14, string15, string16, z3, z4, cursorQuery.getInt(i14)));
                columnIndexOrThrow = i7;
                columnIndexOrThrow15 = i6;
                columnIndexOrThrow16 = i8;
                columnIndexOrThrow17 = i9;
                columnIndexOrThrow18 = i10;
                columnIndexOrThrow19 = i11;
                columnIndexOrThrow20 = i12;
                columnIndexOrThrow21 = i13;
                columnIndexOrThrow22 = i14;
                i4 = i2;
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

    @Override // io.legado.app.data.dao.RssSourceDao
    public int getSize() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select count(sourceUrl) from rssSources", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public void insert(RssSource... rssSourceArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRssSource.insert(rssSourceArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public LiveData<List<RssSource>> liveAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `rssSources`.`sourceUrl` AS `sourceUrl`, `rssSources`.`sourceName` AS `sourceName`, `rssSources`.`sourceIcon` AS `sourceIcon`, `rssSources`.`sourceGroup` AS `sourceGroup`, `rssSources`.`sourceComment` AS `sourceComment`, `rssSources`.`enabled` AS `enabled`, `rssSources`.`sortUrl` AS `sortUrl`, `rssSources`.`singleUrl` AS `singleUrl`, `rssSources`.`articleStyle` AS `articleStyle`, `rssSources`.`ruleArticles` AS `ruleArticles`, `rssSources`.`ruleNextPage` AS `ruleNextPage`, `rssSources`.`ruleTitle` AS `ruleTitle`, `rssSources`.`rulePubDate` AS `rulePubDate`, `rssSources`.`ruleDescription` AS `ruleDescription`, `rssSources`.`ruleImage` AS `ruleImage`, `rssSources`.`ruleLink` AS `ruleLink`, `rssSources`.`ruleContent` AS `ruleContent`, `rssSources`.`style` AS `style`, `rssSources`.`header` AS `header`, `rssSources`.`enableJs` AS `enableJs`, `rssSources`.`loadWithBaseUrl` AS `loadWithBaseUrl`, `rssSources`.`customOrder` AS `customOrder` FROM rssSources order by customOrder", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"rssSources"}, false, new Callable<List<RssSource>>() { // from class: io.legado.app.data.dao.RssSourceDao_Impl.5
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RssSource> call() {
                String string;
                int i2;
                Cursor cursorQuery = DBUtil.query(RssSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceName");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceIcon");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceGroup");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceComment");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sortUrl");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singleUrl");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "articleStyle");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleArticles");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleNextPage");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleTitle");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rulePubDate");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleDescription");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleImage");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleLink");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enableJs");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loadWithBaseUrl");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int i3 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string7 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        int i4 = cursorQuery.getInt(columnIndexOrThrow9);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (cursorQuery.isNull(columnIndexOrThrow13)) {
                            i2 = i3;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow13);
                            i2 = i3;
                        }
                        String string11 = cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2);
                        int i5 = columnIndexOrThrow15;
                        int i6 = columnIndexOrThrow;
                        String string12 = cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5);
                        int i7 = columnIndexOrThrow16;
                        String string13 = cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7);
                        int i8 = columnIndexOrThrow17;
                        String string14 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                        int i9 = columnIndexOrThrow18;
                        String string15 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                        int i10 = columnIndexOrThrow19;
                        String string16 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                        int i11 = columnIndexOrThrow20;
                        boolean z3 = cursorQuery.getInt(i11) != 0;
                        int i12 = columnIndexOrThrow21;
                        boolean z4 = cursorQuery.getInt(i12) != 0;
                        int i13 = columnIndexOrThrow22;
                        arrayList.add(new RssSource(string2, string3, string4, string5, string6, z, string7, z2, i4, string8, string9, string10, string, string11, string12, string13, string14, string15, string16, z3, z4, cursorQuery.getInt(i13)));
                        columnIndexOrThrow = i6;
                        columnIndexOrThrow15 = i5;
                        columnIndexOrThrow16 = i7;
                        columnIndexOrThrow17 = i8;
                        columnIndexOrThrow18 = i9;
                        columnIndexOrThrow19 = i10;
                        columnIndexOrThrow20 = i11;
                        columnIndexOrThrow21 = i12;
                        columnIndexOrThrow22 = i13;
                        i3 = i2;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public LiveData<List<RssSource>> liveEnabled() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `rssSources`.`sourceUrl` AS `sourceUrl`, `rssSources`.`sourceName` AS `sourceName`, `rssSources`.`sourceIcon` AS `sourceIcon`, `rssSources`.`sourceGroup` AS `sourceGroup`, `rssSources`.`sourceComment` AS `sourceComment`, `rssSources`.`enabled` AS `enabled`, `rssSources`.`sortUrl` AS `sortUrl`, `rssSources`.`singleUrl` AS `singleUrl`, `rssSources`.`articleStyle` AS `articleStyle`, `rssSources`.`ruleArticles` AS `ruleArticles`, `rssSources`.`ruleNextPage` AS `ruleNextPage`, `rssSources`.`ruleTitle` AS `ruleTitle`, `rssSources`.`rulePubDate` AS `rulePubDate`, `rssSources`.`ruleDescription` AS `ruleDescription`, `rssSources`.`ruleImage` AS `ruleImage`, `rssSources`.`ruleLink` AS `ruleLink`, `rssSources`.`ruleContent` AS `ruleContent`, `rssSources`.`style` AS `style`, `rssSources`.`header` AS `header`, `rssSources`.`enableJs` AS `enableJs`, `rssSources`.`loadWithBaseUrl` AS `loadWithBaseUrl`, `rssSources`.`customOrder` AS `customOrder` FROM rssSources where enabled = 1 order by customOrder", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"rssSources"}, false, new Callable<List<RssSource>>() { // from class: io.legado.app.data.dao.RssSourceDao_Impl.8
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RssSource> call() {
                String string;
                int i2;
                Cursor cursorQuery = DBUtil.query(RssSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceName");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceIcon");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceGroup");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceComment");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sortUrl");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singleUrl");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "articleStyle");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleArticles");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleNextPage");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleTitle");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rulePubDate");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleDescription");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleImage");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleLink");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enableJs");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loadWithBaseUrl");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int i3 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string7 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        int i4 = cursorQuery.getInt(columnIndexOrThrow9);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (cursorQuery.isNull(columnIndexOrThrow13)) {
                            i2 = i3;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow13);
                            i2 = i3;
                        }
                        String string11 = cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2);
                        int i5 = columnIndexOrThrow15;
                        int i6 = columnIndexOrThrow;
                        String string12 = cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5);
                        int i7 = columnIndexOrThrow16;
                        String string13 = cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7);
                        int i8 = columnIndexOrThrow17;
                        String string14 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                        int i9 = columnIndexOrThrow18;
                        String string15 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                        int i10 = columnIndexOrThrow19;
                        String string16 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                        int i11 = columnIndexOrThrow20;
                        boolean z3 = cursorQuery.getInt(i11) != 0;
                        int i12 = columnIndexOrThrow21;
                        boolean z4 = cursorQuery.getInt(i12) != 0;
                        int i13 = columnIndexOrThrow22;
                        arrayList.add(new RssSource(string2, string3, string4, string5, string6, z, string7, z2, i4, string8, string9, string10, string, string11, string12, string13, string14, string15, string16, z3, z4, cursorQuery.getInt(i13)));
                        columnIndexOrThrow = i6;
                        columnIndexOrThrow15 = i5;
                        columnIndexOrThrow16 = i7;
                        columnIndexOrThrow17 = i8;
                        columnIndexOrThrow18 = i9;
                        columnIndexOrThrow19 = i10;
                        columnIndexOrThrow20 = i11;
                        columnIndexOrThrow21 = i12;
                        columnIndexOrThrow22 = i13;
                        i3 = i2;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public LiveData<List<RssSource>> liveEnabledByGroup(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM rssSources where enabled = 1 and sourceGroup like ? order by customOrder", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"rssSources"}, false, new Callable<List<RssSource>>() { // from class: io.legado.app.data.dao.RssSourceDao_Impl.10
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RssSource> call() {
                String string;
                int i2;
                Cursor cursorQuery = DBUtil.query(RssSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceName");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceIcon");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceGroup");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceComment");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sortUrl");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singleUrl");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "articleStyle");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleArticles");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleNextPage");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleTitle");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rulePubDate");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleDescription");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleImage");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleLink");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enableJs");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loadWithBaseUrl");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int i3 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string7 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        int i4 = cursorQuery.getInt(columnIndexOrThrow9);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (cursorQuery.isNull(columnIndexOrThrow13)) {
                            i2 = i3;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow13);
                            i2 = i3;
                        }
                        String string11 = cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2);
                        int i5 = columnIndexOrThrow15;
                        int i6 = columnIndexOrThrow;
                        String string12 = cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5);
                        int i7 = columnIndexOrThrow16;
                        String string13 = cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7);
                        int i8 = columnIndexOrThrow17;
                        String string14 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                        int i9 = columnIndexOrThrow18;
                        String string15 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                        int i10 = columnIndexOrThrow19;
                        String string16 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                        int i11 = columnIndexOrThrow20;
                        boolean z3 = cursorQuery.getInt(i11) != 0;
                        int i12 = columnIndexOrThrow21;
                        boolean z4 = cursorQuery.getInt(i12) != 0;
                        int i13 = columnIndexOrThrow22;
                        arrayList.add(new RssSource(string2, string3, string4, string5, string6, z, string7, z2, i4, string8, string9, string10, string, string11, string12, string13, string14, string15, string16, z3, z4, cursorQuery.getInt(i13)));
                        columnIndexOrThrow = i6;
                        columnIndexOrThrow15 = i5;
                        columnIndexOrThrow16 = i7;
                        columnIndexOrThrow17 = i8;
                        columnIndexOrThrow18 = i9;
                        columnIndexOrThrow19 = i10;
                        columnIndexOrThrow20 = i11;
                        columnIndexOrThrow21 = i12;
                        columnIndexOrThrow22 = i13;
                        i3 = i2;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public LiveData<List<String>> liveGroup() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select distinct sourceGroup from rssSources where trim(sourceGroup) <> ''", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"rssSources"}, false, new Callable<List<String>>() { // from class: io.legado.app.data.dao.RssSourceDao_Impl.11
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(RssSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
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

    @Override // io.legado.app.data.dao.RssSourceDao
    public LiveData<List<RssSource>> liveGroupSearch(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM rssSources where sourceGroup like ? order by customOrder", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"rssSources"}, false, new Callable<List<RssSource>>() { // from class: io.legado.app.data.dao.RssSourceDao_Impl.7
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RssSource> call() {
                String string;
                int i2;
                Cursor cursorQuery = DBUtil.query(RssSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceName");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceIcon");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceGroup");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceComment");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sortUrl");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singleUrl");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "articleStyle");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleArticles");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleNextPage");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleTitle");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rulePubDate");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleDescription");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleImage");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleLink");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enableJs");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loadWithBaseUrl");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int i3 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string7 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        int i4 = cursorQuery.getInt(columnIndexOrThrow9);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (cursorQuery.isNull(columnIndexOrThrow13)) {
                            i2 = i3;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow13);
                            i2 = i3;
                        }
                        String string11 = cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2);
                        int i5 = columnIndexOrThrow15;
                        int i6 = columnIndexOrThrow;
                        String string12 = cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5);
                        int i7 = columnIndexOrThrow16;
                        String string13 = cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7);
                        int i8 = columnIndexOrThrow17;
                        String string14 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                        int i9 = columnIndexOrThrow18;
                        String string15 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                        int i10 = columnIndexOrThrow19;
                        String string16 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                        int i11 = columnIndexOrThrow20;
                        boolean z3 = cursorQuery.getInt(i11) != 0;
                        int i12 = columnIndexOrThrow21;
                        boolean z4 = cursorQuery.getInt(i12) != 0;
                        int i13 = columnIndexOrThrow22;
                        arrayList.add(new RssSource(string2, string3, string4, string5, string6, z, string7, z2, i4, string8, string9, string10, string, string11, string12, string13, string14, string15, string16, z3, z4, cursorQuery.getInt(i13)));
                        columnIndexOrThrow = i6;
                        columnIndexOrThrow15 = i5;
                        columnIndexOrThrow16 = i7;
                        columnIndexOrThrow17 = i8;
                        columnIndexOrThrow18 = i9;
                        columnIndexOrThrow19 = i10;
                        columnIndexOrThrow20 = i11;
                        columnIndexOrThrow21 = i12;
                        columnIndexOrThrow22 = i13;
                        i3 = i2;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public LiveData<List<RssSource>> liveSearch(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM rssSources where sourceName like ? or sourceUrl like ? or sourceGroup like ? order by customOrder", 3);
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
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"rssSources"}, false, new Callable<List<RssSource>>() { // from class: io.legado.app.data.dao.RssSourceDao_Impl.6
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RssSource> call() {
                String string;
                int i2;
                Cursor cursorQuery = DBUtil.query(RssSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceName");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceIcon");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceGroup");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceComment");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sortUrl");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singleUrl");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "articleStyle");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleArticles");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleNextPage");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleTitle");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rulePubDate");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleDescription");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleImage");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleLink");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enableJs");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loadWithBaseUrl");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int i3 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string7 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        int i4 = cursorQuery.getInt(columnIndexOrThrow9);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (cursorQuery.isNull(columnIndexOrThrow13)) {
                            i2 = i3;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow13);
                            i2 = i3;
                        }
                        String string11 = cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2);
                        int i5 = columnIndexOrThrow15;
                        int i6 = columnIndexOrThrow;
                        String string12 = cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5);
                        int i7 = columnIndexOrThrow16;
                        String string13 = cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7);
                        int i8 = columnIndexOrThrow17;
                        String string14 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                        int i9 = columnIndexOrThrow18;
                        String string15 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                        int i10 = columnIndexOrThrow19;
                        String string16 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                        int i11 = columnIndexOrThrow20;
                        boolean z3 = cursorQuery.getInt(i11) != 0;
                        int i12 = columnIndexOrThrow21;
                        boolean z4 = cursorQuery.getInt(i12) != 0;
                        int i13 = columnIndexOrThrow22;
                        arrayList.add(new RssSource(string2, string3, string4, string5, string6, z, string7, z2, i4, string8, string9, string10, string, string11, string12, string13, string14, string15, string16, z3, z4, cursorQuery.getInt(i13)));
                        columnIndexOrThrow = i6;
                        columnIndexOrThrow15 = i5;
                        columnIndexOrThrow16 = i7;
                        columnIndexOrThrow17 = i8;
                        columnIndexOrThrow18 = i9;
                        columnIndexOrThrow19 = i10;
                        columnIndexOrThrow20 = i11;
                        columnIndexOrThrow21 = i12;
                        columnIndexOrThrow22 = i13;
                        i3 = i2;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public void update(RssSource... rssSourceArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRssSource.handleMultiple(rssSourceArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.legado.app.data.dao.RssSourceDao
    public LiveData<List<RssSource>> liveEnabled(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM rssSources where enabled = 1 and (sourceName like ? or sourceGroup like ? or sourceUrl like ?) order by customOrder", 3);
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
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"rssSources"}, false, new Callable<List<RssSource>>() { // from class: io.legado.app.data.dao.RssSourceDao_Impl.9
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RssSource> call() {
                String string;
                int i2;
                Cursor cursorQuery = DBUtil.query(RssSourceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceUrl");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceName");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceIcon");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceGroup");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceComment");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enabled");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sortUrl");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "singleUrl");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "articleStyle");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleArticles");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleNextPage");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleTitle");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rulePubDate");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleDescription");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleImage");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleLink");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ruleContent");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "header");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enableJs");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "loadWithBaseUrl");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "customOrder");
                    int i3 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string7 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow8) != 0;
                        int i4 = cursorQuery.getInt(columnIndexOrThrow9);
                        String string8 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        String string9 = cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11);
                        String string10 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (cursorQuery.isNull(columnIndexOrThrow13)) {
                            i2 = i3;
                            string = null;
                        } else {
                            string = cursorQuery.getString(columnIndexOrThrow13);
                            i2 = i3;
                        }
                        String string11 = cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2);
                        int i5 = columnIndexOrThrow15;
                        int i6 = columnIndexOrThrow;
                        String string12 = cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5);
                        int i7 = columnIndexOrThrow16;
                        String string13 = cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7);
                        int i8 = columnIndexOrThrow17;
                        String string14 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                        int i9 = columnIndexOrThrow18;
                        String string15 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                        int i10 = columnIndexOrThrow19;
                        String string16 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                        int i11 = columnIndexOrThrow20;
                        boolean z3 = cursorQuery.getInt(i11) != 0;
                        int i12 = columnIndexOrThrow21;
                        boolean z4 = cursorQuery.getInt(i12) != 0;
                        int i13 = columnIndexOrThrow22;
                        arrayList.add(new RssSource(string2, string3, string4, string5, string6, z, string7, z2, i4, string8, string9, string10, string, string11, string12, string13, string14, string15, string16, z3, z4, cursorQuery.getInt(i13)));
                        columnIndexOrThrow = i6;
                        columnIndexOrThrow15 = i5;
                        columnIndexOrThrow16 = i7;
                        columnIndexOrThrow17 = i8;
                        columnIndexOrThrow18 = i9;
                        columnIndexOrThrow19 = i10;
                        columnIndexOrThrow20 = i11;
                        columnIndexOrThrow21 = i12;
                        columnIndexOrThrow22 = i13;
                        i3 = i2;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // io.legado.app.data.dao.RssSourceDao
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
