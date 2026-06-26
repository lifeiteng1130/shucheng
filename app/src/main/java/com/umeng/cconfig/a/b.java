package com.umeng.cconfig.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SQLiteOpenHelper f5016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f5017d;
    public SQLiteDatabase a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f5018b;

    public static class a {
        private static final b a = new b(0);
    }

    private b() {
        this.f5018b = new AtomicInteger();
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static b a(Context context) {
        if (f5017d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            f5017d = applicationContext;
            f5016c = com.umeng.cconfig.a.a.a(applicationContext);
        }
        return a.a;
    }

    public final synchronized SQLiteDatabase a() {
        if (this.f5018b.incrementAndGet() == 1) {
            this.a = f5016c.getWritableDatabase();
        }
        return this.a;
    }

    public final boolean a(String str) {
        SQLiteDatabase sQLiteDatabase;
        try {
            try {
                a();
                this.a.beginTransaction();
                String str2 = "update  __cc set __a=\"1\" where __ts=\"" + str + "\"";
                ULog.i("jessie", "[DbManager] updateCloudConfigByTimestamp：".concat(String.valueOf(str2)));
                this.a.execSQL(str2);
                this.a.setTransactionSuccessful();
                sQLiteDatabase = this.a;
            } catch (Throwable unused) {
            }
        } catch (SQLiteDatabaseCorruptException e2) {
            try {
                e2.printStackTrace();
                try {
                    SQLiteDatabase sQLiteDatabase2 = this.a;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    }
                } catch (Throwable unused2) {
                }
                b();
                return false;
            } catch (Throwable th) {
                try {
                    if (this.a != null) {
                        this.a.endTransaction();
                    }
                } catch (Throwable unused3) {
                }
                b();
                throw th;
            }
        } catch (Throwable unused4) {
            sQLiteDatabase = this.a;
            if (sQLiteDatabase != null) {
            }
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.endTransaction();
        }
        b();
        return true;
    }

    public final synchronized void b() {
        try {
            if (this.f5018b.decrementAndGet() == 0) {
                this.a.close();
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean b(String str) {
        SQLiteDatabase sQLiteDatabase;
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                a();
                this.a.beginTransaction();
                Cursor cursorRawQuery = this.a.rawQuery("select *  from __cc where __a=\"1\" group by __ts", null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts"));
                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(d.C0127d.a.f4845d));
                        String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
                        String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, string4));
                        sb2.append("\n");
                        com.umeng.cconfig.b.d dVar = new com.umeng.cconfig.b.d();
                        dVar.a = string;
                        dVar.f5044b = string2;
                        dVar.f5045c = string3;
                        if (!TextUtils.isEmpty(string) && !str.equals(string)) {
                            arrayList.add(dVar);
                        }
                    }
                }
                int size = arrayList.size();
                String string5 = "";
                for (int i2 = 0; i2 < size; i2++) {
                    com.umeng.cconfig.b.d dVar2 = (com.umeng.cconfig.b.d) arrayList.get(i2);
                    if (i2 != size - 1) {
                        sb = new StringBuilder();
                        sb.append(string5);
                        sb.append("__ts=\"");
                        sb.append(dVar2.a);
                        sb.append("\" or ");
                    } else {
                        sb = new StringBuilder();
                        sb.append(string5);
                        sb.append("__ts=\"");
                        sb.append(dVar2.a);
                        sb.append("\"");
                    }
                    string5 = sb.toString();
                    String str2 = "update  __cc set __a=\"0\" where " + string5;
                    ULog.i("jessie", "[DbManager] updateOtherCloudConfigInfo : ".concat(String.valueOf(str2)));
                    this.a.execSQL(str2);
                    this.a.setTransactionSuccessful();
                }
                sQLiteDatabase = this.a;
            } catch (Throwable unused) {
            }
        } catch (SQLiteDatabaseCorruptException e2) {
            try {
                e2.printStackTrace();
                try {
                    SQLiteDatabase sQLiteDatabase2 = this.a;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    }
                } catch (Throwable unused2) {
                }
                b();
                return false;
            } catch (Throwable th) {
                try {
                    if (this.a != null) {
                        this.a.endTransaction();
                    }
                } catch (Throwable unused3) {
                }
                b();
                throw th;
            }
        } catch (Throwable unused4) {
            sQLiteDatabase = this.a;
            if (sQLiteDatabase != null) {
            }
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.endTransaction();
        }
        b();
        return true;
    }

    public final com.umeng.cconfig.b.d c() {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursorRawQuery;
        com.umeng.cconfig.b.d dVar = new com.umeng.cconfig.b.d();
        try {
            try {
                a();
                this.a.beginTransaction();
                cursorRawQuery = this.a.rawQuery("select *  from __cc where __a=\"1\" group by __ts", null);
            } catch (SQLiteDatabaseCorruptException e2) {
                try {
                    e2.printStackTrace();
                    sQLiteDatabase = this.a;
                    if (sQLiteDatabase != null) {
                    }
                } catch (Throwable th) {
                    try {
                        if (this.a != null) {
                            this.a.endTransaction();
                        }
                    } catch (Throwable unused) {
                    }
                    b();
                    throw th;
                }
            } catch (Throwable unused2) {
                sQLiteDatabase = this.a;
                if (sQLiteDatabase != null) {
                }
            }
        } catch (Throwable unused3) {
        }
        if (cursorRawQuery == null || !cursorRawQuery.moveToNext()) {
            this.a.setTransactionSuccessful();
            sQLiteDatabase = this.a;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            b();
            return dVar;
        }
        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts"));
        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(d.C0127d.a.f4845d));
        String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
        ULog.i("jessie", "[DbManager] selectRecentActiveOne".concat(String.valueOf(String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"))) + "\n")));
        com.umeng.cconfig.b.d dVar2 = new com.umeng.cconfig.b.d();
        dVar2.a = string;
        dVar2.f5044b = string2;
        dVar2.f5045c = string3;
        try {
            SQLiteDatabase sQLiteDatabase2 = this.a;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
        } catch (Throwable unused4) {
        }
        b();
        return dVar2;
    }

    public final boolean d() {
        SQLiteDatabase sQLiteDatabase;
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                a();
                this.a.beginTransaction();
                Cursor cursorRawQuery = this.a.rawQuery("select *  from __cc where __a=\"0\" order by __ts asc", null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        arrayList.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts")));
                    }
                }
                int size = arrayList.size() - 5;
                String string = "";
                if (size > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (i2 != size - 1) {
                            sb = new StringBuilder();
                            sb.append(string);
                            sb.append("__ts=\"");
                            sb.append((String) arrayList.get(i2));
                            sb.append("\" or ");
                        } else {
                            sb = new StringBuilder();
                            sb.append(string);
                            sb.append("__ts=\"");
                            sb.append((String) arrayList.get(i2));
                            sb.append("\"");
                        }
                        string = sb.toString();
                    }
                    String str = "delete from __cc where " + string;
                    ULog.i("jessie", "[DbManager] deleteExtraCloudConfigInfo: ".concat(String.valueOf(str)));
                    this.a.execSQL(str);
                    this.a.setTransactionSuccessful();
                }
                sQLiteDatabase = this.a;
            } catch (SQLiteDatabaseCorruptException e2) {
                try {
                    e2.printStackTrace();
                    sQLiteDatabase = this.a;
                    if (sQLiteDatabase != null) {
                    }
                } catch (Throwable th) {
                    try {
                        if (this.a != null) {
                            this.a.endTransaction();
                        }
                    } catch (Throwable unused) {
                    }
                    b();
                    throw th;
                }
            } catch (Throwable unused2) {
                sQLiteDatabase = this.a;
                if (sQLiteDatabase != null) {
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable unused3) {
        }
        b();
        return false;
    }

    public final com.umeng.cconfig.b.d e() {
        SQLiteDatabase sQLiteDatabase;
        com.umeng.cconfig.b.d dVar = new com.umeng.cconfig.b.d();
        try {
            try {
                try {
                    a();
                    this.a.beginTransaction();
                    Cursor cursorRawQuery = this.a.rawQuery("select *  from __cc order by __ts desc", null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts"));
                            String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(d.C0127d.a.f4845d));
                            String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
                            ULog.i("jessie", "[DbManager] getLastestConfigInfo".concat(String.valueOf(String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"))) + "\n")));
                            dVar.a = string;
                            dVar.f5044b = string2;
                            dVar.f5045c = string3;
                            if (string != null) {
                                try {
                                    SQLiteDatabase sQLiteDatabase2 = this.a;
                                    if (sQLiteDatabase2 != null) {
                                        sQLiteDatabase2.endTransaction();
                                    }
                                } catch (Throwable unused) {
                                }
                                b();
                                return dVar;
                            }
                        }
                    }
                    this.a.setTransactionSuccessful();
                    sQLiteDatabase = this.a;
                } catch (Throwable unused2) {
                    sQLiteDatabase = this.a;
                    if (sQLiteDatabase != null) {
                    }
                }
            } catch (SQLiteDatabaseCorruptException e2) {
                try {
                    e2.printStackTrace();
                    sQLiteDatabase = this.a;
                    if (sQLiteDatabase != null) {
                    }
                } catch (Throwable th) {
                    try {
                        if (this.a != null) {
                            this.a.endTransaction();
                        }
                    } catch (Throwable unused3) {
                    }
                    b();
                    throw th;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable unused4) {
        }
        b();
        return dVar;
    }
}
