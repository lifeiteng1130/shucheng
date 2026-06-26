package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.analytics.pro.am;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class J {
    private static J a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static K f4278b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f4279c = false;

    private J(Context context, List<com.tencent.bugly.a> list) {
        f4278b = new K(context, list);
    }

    private synchronized boolean d(L l2) {
        ContentValues contentValuesB;
        if (l2 == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f4278b.getWritableDatabase();
            if (writableDatabase == null || (contentValuesB = b(l2)) == null) {
                return false;
            }
            long jReplace = writableDatabase.replace("t_pf", "_id", contentValuesB);
            if (jReplace < 0) {
                if (f4279c) {
                    writableDatabase.close();
                }
                return false;
            }
            Object[] objArr = new Object[1];
            objArr[0] = "t_pf";
            X.a("[Database] insert %s success.", objArr);
            l2.a = jReplace;
            if (f4279c) {
                writableDatabase.close();
            }
            return true;
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                if (f4279c && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (f4279c && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public synchronized void b(int i2) {
        String string;
        SQLiteDatabase writableDatabase = f4278b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i2 >= 0) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("_tp = ");
                    sb.append(i2);
                    string = sb.toString();
                } catch (Throwable th) {
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        if (f4279c) {
                        }
                    } catch (Throwable th2) {
                        if (f4279c) {
                            writableDatabase.close();
                        }
                        throw th2;
                    }
                }
            } else {
                string = null;
            }
            int iDelete = writableDatabase.delete("t_lr", string, null);
            Object[] objArr = new Object[2];
            objArr[0] = "t_lr";
            objArr[1] = Integer.valueOf(iDelete);
            X.a("[Database] deleted %s data %d", objArr);
            if (f4279c) {
                writableDatabase.close();
            }
        }
    }

    public synchronized boolean c(L l2) {
        ContentValues contentValuesA;
        if (l2 == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f4278b.getWritableDatabase();
            if (writableDatabase == null || (contentValuesA = a(l2)) == null) {
                return false;
            }
            long jReplace = writableDatabase.replace("t_lr", "_id", contentValuesA);
            if (jReplace < 0) {
                if (f4279c) {
                    writableDatabase.close();
                }
                return false;
            }
            Object[] objArr = new Object[1];
            objArr[0] = "t_lr";
            X.a("[Database] insert %s success.", objArr);
            l2.a = jReplace;
            if (f4279c) {
                writableDatabase.close();
            }
            return true;
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                if (f4279c && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (f4279c && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    public class a extends Thread {
        private int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private I f4280b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f4281c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ContentValues f4282d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4283e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String[] f4284f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f4285g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String[] f4286h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f4287i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f4288j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f4289k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f4290l;
        private String m;
        private String[] n;
        private int o;
        private String p;
        private byte[] q;

        public a(int i2, I i3) {
            this.a = i2;
            this.f4280b = i3;
        }

        public void a(String str, ContentValues contentValues) {
            this.f4281c = str;
            this.f4282d = contentValues;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            switch (this.a) {
                case 1:
                    J.this.a(this.f4281c, this.f4282d, this.f4280b);
                    break;
                case 2:
                    J.this.a(this.f4281c, this.m, this.n, this.f4280b);
                    break;
                case 3:
                    Cursor cursorA = J.this.a(this.f4283e, this.f4281c, this.f4284f, this.f4285g, this.f4286h, this.f4287i, this.f4288j, this.f4289k, this.f4290l, this.f4280b);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    break;
                case 4:
                    J.this.a(this.o, this.p, this.q, this.f4280b);
                    break;
                case 5:
                    J.this.a(this.o, this.f4280b);
                    break;
                case 6:
                    J.this.a(this.o, this.p, this.f4280b);
                    break;
            }
        }

        public void a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f4283e = z;
            this.f4281c = str;
            this.f4284f = strArr;
            this.f4285g = str2;
            this.f4286h = strArr2;
            this.f4287i = str3;
            this.f4288j = str4;
            this.f4289k = str5;
            this.f4290l = str6;
        }

        public void a(String str, String str2, String[] strArr) {
            this.f4281c = str;
            this.m = str2;
            this.n = strArr;
        }

        public void a(int i2, String str, byte[] bArr) {
            this.o = i2;
            this.p = str;
            this.q = bArr;
        }

        public void a(int i2) {
            this.o = i2;
        }
    }

    public static synchronized J a(Context context, List<com.tencent.bugly.a> list) {
        if (a == null) {
            a = new J(context, list);
        }
        return a;
    }

    public static synchronized J a() {
        return a;
    }

    public long a(String str, ContentValues contentValues, I i2, boolean z) {
        if (!z) {
            a aVar = new a(1, i2);
            aVar.a(str, contentValues);
            W.c().a(aVar);
            return 0L;
        }
        return a(str, contentValues, i2);
    }

    public ContentValues b(L l2) {
        if (l2 != null && !ca.b(l2.f4298f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j2 = l2.a;
                if (j2 > 0) {
                    contentValues.put("_id", Long.valueOf(j2));
                }
                contentValues.put(am.f4694e, l2.f4298f);
                contentValues.put("_tm", Long.valueOf(l2.f4297e));
                byte[] bArr = l2.f4299g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, I i2, boolean z) {
        return a(false, str, strArr, str2, strArr2, (String) null, (String) null, (String) null, (String) null, i2, z);
    }

    public Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, I i2, boolean z2) {
        if (!z2) {
            a aVar = new a(3, i2);
            aVar.a(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            W.c().a(aVar);
            return null;
        }
        return a(z, str, strArr, str2, strArr2, str3, str4, str5, str6, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x00df A[Catch: all -> 0x00c6, DONT_GENERATE, PHI: r1
  0x00df: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:77:0x00dd, B:64:0x00c3] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {, blocks: (B:14:0x002c, B:15:0x002f, B:17:0x0033, B:53:0x00ae, B:55:0x00b5, B:74:0x00d6, B:75:0x00d9, B:78:0x00df, B:83:0x00e7, B:84:0x00ea, B:87:0x00f0, B:88:0x00f3, B:62:0x00bf, B:70:0x00cb, B:72:0x00d1), top: B:95:0x0002, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized java.util.List<com.tencent.bugly.proguard.L> c(int r12) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.c(int):java.util.List");
    }

    public int a(String str, String str2, String[] strArr, I i2, boolean z) {
        if (!z) {
            a aVar = new a(2, i2);
            aVar.a(str, str2, strArr);
            W.c().a(aVar);
            return 0;
        }
        return a(str, str2, strArr, i2);
    }

    public L b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            L l2 = new L();
            l2.a = cursor.getLong(cursor.getColumnIndex("_id"));
            l2.f4297e = cursor.getLong(cursor.getColumnIndex("_tm"));
            l2.f4298f = cursor.getString(cursor.getColumnIndex(am.f4694e));
            l2.f4299g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return l2;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized long a(String str, ContentValues contentValues, I i2) {
        long j2;
        j2 = 0;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = f4278b.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long jReplace = writableDatabase.replace(str, "_id", contentValues);
                if (jReplace >= 0) {
                    X.a("[Database] insert %s success.", str);
                } else {
                    X.e("[Database] replace %s error.", str);
                }
                j2 = jReplace;
            }
            if (i2 != null) {
                i2.a(Long.valueOf(j2));
            }
            if (f4279c && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
            } finally {
                if (i2 != null) {
                    i2.a(0L);
                }
                if (f4279c && 0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, I i2) {
        Cursor cursorQuery;
        try {
            SQLiteDatabase writableDatabase = f4278b.getWritableDatabase();
            cursorQuery = writableDatabase != null ? writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6) : null;
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                if (i2 != null) {
                    i2.a(null);
                }
            } finally {
                if (i2 != null) {
                    i2.a(null);
                }
            }
        }
        return cursorQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(String str, String str2, String[] strArr, I i2) {
        int iDelete;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f4278b.getWritableDatabase();
            iDelete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
            if (i2 != null) {
                i2.a(Integer.valueOf(iDelete));
            }
            if (f4279c && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
            } finally {
                if (i2 != null) {
                    i2.a(0);
                }
                if (f4279c && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
        return iDelete;
    }

    public boolean a(int i2, String str, byte[] bArr, I i3, boolean z) {
        if (!z) {
            a aVar = new a(4, i3);
            aVar.a(i2, str, bArr);
            W.c().a(aVar);
            return true;
        }
        return a(i2, str, bArr, i3);
    }

    public Map<String, byte[]> a(int i2, I i3, boolean z) {
        if (!z) {
            a aVar = new a(5, i3);
            aVar.a(i2);
            W.c().a(aVar);
            return null;
        }
        return a(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, String str, byte[] bArr, I i3) {
        Boolean bool = Boolean.FALSE;
        try {
            L l2 = new L();
            l2.a = i2;
            l2.f4298f = str;
            l2.f4297e = System.currentTimeMillis();
            l2.f4299g = bArr;
            boolean zD = d(l2);
            if (i3 == null) {
                return zD;
            }
            i3.a(Boolean.valueOf(zD));
            return zD;
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
                if (i3 != null) {
                    i3.a(bool);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, byte[]> a(int i2, I i3) {
        HashMap map = null;
        try {
            List<L> listC = c(i2);
            if (listC != null) {
                HashMap map2 = new HashMap();
                try {
                    for (L l2 : listC) {
                        byte[] bArr = l2.f4299g;
                        if (bArr != null) {
                            map2.put(l2.f4298f, bArr);
                        }
                    }
                    map = map2;
                } catch (Throwable th) {
                    th = th;
                    map = map2;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                    } finally {
                        if (i3 != null) {
                            i3.a(map);
                        }
                    }
                }
            }
            if (i3 != null) {
                i3.a(map);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00bd A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #2 {all -> 0x00cd, blocks: (B:61:0x00b7, B:63:0x00bd), top: B:85:0x00b7, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c2 A[Catch: all -> 0x00dd, TRY_ENTER, TryCatch #3 {, blocks: (B:3:0x0001, B:19:0x0033, B:20:0x0036, B:22:0x003a, B:53:0x00a7, B:55:0x00ae, B:65:0x00c2, B:66:0x00c5, B:68:0x00c9, B:71:0x00d0, B:72:0x00d3, B:74:0x00d7, B:75:0x00da, B:61:0x00b7, B:63:0x00bd), top: B:87:0x0001, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c9 A[Catch: all -> 0x00dd, TryCatch #3 {, blocks: (B:3:0x0001, B:19:0x0033, B:20:0x0036, B:22:0x003a, B:53:0x00a7, B:55:0x00ae, B:65:0x00c2, B:66:0x00c5, B:68:0x00c9, B:71:0x00d0, B:72:0x00d3, B:74:0x00d7, B:75:0x00da, B:61:0x00b7, B:63:0x00bd), top: B:87:0x0001, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.tencent.bugly.proguard.L> a(int r11) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.a(int):java.util.List");
    }

    /* JADX WARN: Finally extract failed */
    public synchronized void a(List<L> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f4278b.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (L l2 : list) {
                        sb.append(" or ");
                        sb.append("_id");
                        sb.append(" = ");
                        sb.append(l2.a);
                    }
                    String string = sb.toString();
                    if (string.length() > 0) {
                        string = string.substring(4);
                    }
                    sb.setLength(0);
                    try {
                        int iDelete = writableDatabase.delete("t_lr", string, null);
                        Object[] objArr = new Object[2];
                        objArr[0] = "t_lr";
                        objArr[1] = Integer.valueOf(iDelete);
                        X.a("[Database] deleted %s data %d", objArr);
                    } catch (Throwable th) {
                        try {
                            if (!X.b(th)) {
                                th.printStackTrace();
                            }
                            if (f4279c) {
                            }
                        } catch (Throwable th2) {
                            if (f4279c) {
                                writableDatabase.close();
                            }
                            throw th2;
                        }
                    }
                    if (f4279c) {
                        writableDatabase.close();
                    }
                }
            }
        }
    }

    public ContentValues a(L l2) {
        if (l2 == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = l2.a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put(am.f4694e, Integer.valueOf(l2.f4294b));
            contentValues.put("_pc", l2.f4295c);
            contentValues.put("_th", l2.f4296d);
            contentValues.put("_tm", Long.valueOf(l2.f4297e));
            byte[] bArr = l2.f4299g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public L a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            L l2 = new L();
            l2.a = cursor.getLong(cursor.getColumnIndex("_id"));
            l2.f4294b = cursor.getInt(cursor.getColumnIndex(am.f4694e));
            l2.f4295c = cursor.getString(cursor.getColumnIndex("_pc"));
            l2.f4296d = cursor.getString(cursor.getColumnIndex("_th"));
            l2.f4297e = cursor.getLong(cursor.getColumnIndex("_tm"));
            l2.f4299g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return l2;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i2, String str, I i3) {
        boolean z;
        SQLiteDatabase writableDatabase;
        String string;
        Boolean bool = Boolean.FALSE;
        SQLiteDatabase sQLiteDatabase = null;
        z = false;
        try {
            writableDatabase = f4278b.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (ca.b(str)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("_id = ");
                        sb.append(i2);
                        string = sb.toString();
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("_id = ");
                        sb2.append(i2);
                        sb2.append(" and ");
                        sb2.append(am.f4694e);
                        sb2.append(" = \"");
                        sb2.append(str);
                        sb2.append("\"");
                        string = sb2.toString();
                    }
                    int iDelete = writableDatabase.delete("t_pf", string, null);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_pf";
                    objArr[1] = Integer.valueOf(iDelete);
                    X.a("[Database] deleted %s data %d", objArr);
                    if (iDelete > 0) {
                        z = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = writableDatabase;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        if (i3 != null) {
                            i3.a(bool);
                        }
                        if (f4279c && sQLiteDatabase != null) {
                            writableDatabase = sQLiteDatabase;
                        }
                        return z;
                    } catch (Throwable th2) {
                        if (i3 != null) {
                            i3.a(bool);
                        }
                        if (f4279c && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th2;
                    }
                }
            }
            if (i3 != null) {
                i3.a(Boolean.valueOf(z));
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (f4279c && writableDatabase != null) {
            writableDatabase.close();
        }
        return z;
    }
}
