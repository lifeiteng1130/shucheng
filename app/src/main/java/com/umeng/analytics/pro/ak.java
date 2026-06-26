package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.SdkVersion;

/* JADX INFO: compiled from: CacheDBHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class ak extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f4681b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ak f4682c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f4683d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f4684e = "DROP TABLE IF EXISTS stf";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f4685f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";
    private final Context a;

    private ak(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.a = context;
    }

    public static final int a() {
        return 1;
    }

    public static ak a(Context context) {
        ak akVar;
        synchronized (f4681b) {
            if (f4682c == null) {
                f4682c = new ak(context, am.f4691b, null, 1);
            }
            akVar = f4682c;
        }
        return akVar;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f4683d);
        } catch (SQLiteDatabaseCorruptException unused) {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            StringBuilder sbR = c.a.a.a.a.r("--->>> [有状态]创建二级缓存数据库失败: ");
            sbR.append(th.getMessage());
            UMRTLog.e(UMRTLog.RTLOG_TAG, sbR.toString());
        }
    }

    private void d() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.execSQL(f4685f);
            } catch (Throwable unused) {
            }
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public boolean c() {
        return !b(am.f4692c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    public void b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            writableDatabase.close();
        } catch (Throwable unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f4684e);
            sQLiteDatabase.execSQL(f4683d);
        } catch (SQLException unused) {
        }
    }

    public boolean b(String str) {
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery = null;
        try {
            writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (writableDatabase.isOpen()) {
                        cursorQuery = writableDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (writableDatabase == null) {
                        return false;
                    }
                }
            }
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.close();
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    return true;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (writableDatabase == null) {
                return false;
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
        writableDatabase.close();
        return false;
    }

    public void a(String str, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, String str2, String[] strArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public al a(String str) {
        Cursor cursorA;
        al alVar = null;
        try {
            cursorA = a(str, new String[]{am.f4698i, am.f4694e, am.f4695f, am.f4696g, am.f4699j, am.f4700k}, null, null, null, null, null, SdkVersion.MINI_VERSION);
            if (cursorA != null) {
                try {
                    if (cursorA.moveToFirst()) {
                        al alVar2 = new al();
                        try {
                            alVar2.a = cursorA.getString(0);
                            alVar2.f4686b = cursorA.getString(1);
                            String string = cursorA.getString(2);
                            String string2 = cursorA.getString(3);
                            alVar2.f4687c = h.a(this.a).d(string);
                            alVar2.f4688d = h.a(this.a).d(string2);
                            alVar2.f4689e = cursorA.getString(4);
                            alVar2.f4690f = cursorA.getString(5);
                            alVar = alVar2;
                        } catch (Throwable unused) {
                            alVar = alVar2;
                            try {
                                d();
                                if (cursorA != null) {
                                }
                                return alVar;
                            } finally {
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
            cursorA = null;
        }
        if (cursorA != null) {
            cursorA.close();
        }
        return alVar;
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return null;
            }
            return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } catch (Throwable unused) {
            return null;
        }
    }
}
