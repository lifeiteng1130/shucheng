package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class C0323p {
    public static C0323p a = new C0323p();

    public synchronized int a(DownloadTask downloadTask) {
        return J.a().a("dl_1002", "_dUrl = ?", new String[]{downloadTask.getDownloadUrl()}, (I) null, true);
    }

    public synchronized boolean b(DownloadTask downloadTask) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("_dUrl", downloadTask.getDownloadUrl());
        contentValues.put("_sFile", downloadTask.getSaveFile().getAbsolutePath());
        contentValues.put("_sLen", Long.valueOf(downloadTask.getSavedLength()));
        contentValues.put("_tLen", Long.valueOf(downloadTask.getTotalLength()));
        contentValues.put("_MD5", downloadTask.getMD5());
        contentValues.put("_DLTIME", Long.valueOf(downloadTask.getCostTime()));
        return J.a().a("dl_1002", contentValues, (I) null, true) >= 0;
    }

    public synchronized ContentValues c(String str) {
        ContentValues contentValues = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor cursorA = J.a().a("dl_1002", null, "_dUrl=?", new String[]{str}, null, true);
        if (cursorA != null && cursorA.moveToFirst()) {
            contentValues = new ContentValues();
            contentValues.put("_dUrl", cursorA.getString(cursorA.getColumnIndex("_dUrl")));
            contentValues.put("_sFile", cursorA.getString(cursorA.getColumnIndex("_sFile")));
            contentValues.put("_sLen", Long.valueOf(cursorA.getLong(cursorA.getColumnIndex("_sLen"))));
            contentValues.put("_tLen", Long.valueOf(cursorA.getLong(cursorA.getColumnIndex("_tLen"))));
            contentValues.put("_MD5", cursorA.getString(cursorA.getColumnIndex("_MD5")));
            contentValues.put("_DLTIME", Long.valueOf(cursorA.getLong(cursorA.getColumnIndex("_DLTIME"))));
        }
        if (cursorA != null) {
            cursorA.close();
        }
        return contentValues;
    }

    public synchronized boolean a(C0332z c0332z) {
        if (c0332z == null) {
            return false;
        }
        byte[] bArrA = M.a((AbstractC0320m) c0332z);
        if (bArrA != null && bArrA.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_time", Long.valueOf(c0332z.f4486e));
            contentValues.put("_datas", bArrA);
            return J.a().a("ge_1002", contentValues, (I) null, true) >= 0;
        }
        return false;
    }

    public synchronized int a(long j2) {
        return J.a().a("ge_1002", "_time = ?", new String[]{String.valueOf(j2)}, (I) null, true);
    }

    public synchronized int a() {
        return J.a().a("ge_1002", (String) null, (String[]) null, (I) null, true);
    }

    public synchronized int b(String str) {
        return J.a().a("dl_1002", "_sFile = ?", new String[]{str}, (I) null, true);
    }

    public synchronized boolean a(int i2, String str, byte[] bArr) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(i2));
        contentValues.put("_tm", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(am.f4694e, str);
        contentValues.put("_dt", bArr);
        return J.a().a("st_1002", contentValues, (I) null, true) >= 0;
    }

    public synchronized List<C0332z> b() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorA = J.a().a("ge_1002", null, null, null, null, true);
        while (cursorA != null && cursorA.moveToNext()) {
            C0332z c0332z = (C0332z) M.a(cursorA.getBlob(cursorA.getColumnIndex("_datas")), C0332z.class);
            if (c0332z != null) {
                arrayList.add(c0332z);
            }
        }
        if (cursorA != null) {
            cursorA.close();
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return arrayList;
    }

    public synchronized Map<String, byte[]> c() {
        Throwable th;
        Cursor cursorA;
        try {
            cursorA = J.a().a("st_1002", null, "_id = 1002", null, null, true);
            if (cursorA == null) {
                return null;
            }
            try {
                HashMap map = new HashMap();
                while (cursorA.moveToNext()) {
                    map.put(cursorA.getString(cursorA.getColumnIndex(am.f4694e)), cursorA.getBlob(cursorA.getColumnIndex("_dt")));
                }
                cursorA.close();
                return map;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!X.b(th)) {
                        th.printStackTrace();
                    }
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    return null;
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursorA = null;
        }
    }

    public synchronized boolean a(String str) {
        return J.a().a("st_1002", "_id = ? and _tp = ? ", new String[]{"1002", str}, (I) null, true) > 0;
    }
}
