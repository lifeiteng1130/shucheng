package com.umeng.cconfig.a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public final class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f5015b;
    private String a;

    /* JADX INFO: renamed from: com.umeng.cconfig.a.a$a, reason: collision with other inner class name */
    public static class C0129a {
        private static final a a = new a(a.f5015b, 0);
    }

    private a(Context context) {
        super(context, "cc.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.a = null;
    }

    public /* synthetic */ a(Context context, byte b2) {
        this(context);
    }

    public static a a(Context context) {
        if (f5015b == null) {
            f5015b = context.getApplicationContext();
        }
        return C0129a.a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __cc(id INTEGER primary key autoincrement, __ts TEXT, __c TEXT, __a TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __cc(id INTEGER primary key autoincrement, __ts TEXT, __c TEXT, __a TEXT)");
        } catch (SQLException unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
