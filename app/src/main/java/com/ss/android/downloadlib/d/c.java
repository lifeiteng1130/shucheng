package com.ss.android.downloadlib.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.j;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClickEventHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f3213b;
    private SQLiteDatabase a;

    private c() {
        try {
            this.a = new b(j.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.e.c.a().a(th, "ClickEventHelper");
        }
    }

    public static c a() {
        if (f3213b == null) {
            synchronized (c.class) {
                if (f3213b == null) {
                    f3213b = new c();
                }
            }
        }
        return f3213b;
    }

    public boolean b() {
        return com.ss.android.socialbase.downloader.g.a.c().a("click_event_switch", 0) == 1;
    }

    public boolean c() {
        return com.ss.android.socialbase.downloader.g.a.c().a("click_event_switch", 0) == 2;
    }

    private void c(long j2, String str) {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.a.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j2), strOptString});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean b(long j2, String str) {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                String strOptString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                cursorQuery = this.a.query("click_event", b.a, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j2), strOptString}, null, null, null, null);
                boolean z = cursorQuery.getCount() > 0;
                cursorQuery.close();
                return z;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public void a(long j2, String str) {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("ad_id", Long.valueOf(j2));
            contentValues.put("req_id", strOptString);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            this.a.insert("click_event", null, contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c(j2, str);
    }
}
