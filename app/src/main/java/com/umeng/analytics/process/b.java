package com.umeng.analytics.process;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.g;
import java.io.File;

/* JADX INFO: compiled from: UMProcessDBCreater.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends SQLiteOpenHelper {
    public b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }

    public static b a(Context context, String str) {
        String strB = b(context, str);
        a.f4994h.equals(str);
        return new b(context, strB, null, 1);
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = a.f4994h;
        }
        String strB = g.b(context) + "subprocess/";
        if (a.f4994h.equals(str)) {
            strB = g.b(context);
        }
        File file = new File(strB);
        if (!file.exists()) {
            file.mkdirs();
        }
        return String.format(c.a.a.a.a.i(strB, a.f4991e), str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table if not exists __et_p(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __pn TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    public static String a(Context context) {
        return g.b(context) + "subprocess/";
    }
}
