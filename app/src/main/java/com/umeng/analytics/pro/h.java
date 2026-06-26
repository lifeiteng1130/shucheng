package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMStoreManager.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public static final int a = 2049;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4869b = 2050;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4870c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f4871d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f4872e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f4873f = "umeng+";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f4874g = "ek__id";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f4875h = "ek_key";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f4876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<Integer> f4877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f4878k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<String> f4879l;

    /* JADX INFO: compiled from: UMStoreManager.java */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* JADX INFO: compiled from: UMStoreManager.java */
    public static class b {
        private static final h a = new h();

        private b() {
        }
    }

    public static h a(Context context) {
        h hVar = b.a;
        if (f4871d == null && context != null) {
            f4871d = context.getApplicationContext();
            hVar.k();
        }
        return hVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.f4876i.clear();
            this.f4879l.clear();
            this.f4877j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f4872e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f4871d, f4874g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(f4871d).getString(f4874g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f4871d, f4874g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String strSubstring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < strSubstring.length(); i2++) {
                        char cCharAt = strSubstring.charAt(i2);
                        if (!Character.isDigit(cCharAt)) {
                            sb.append(cCharAt);
                        } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                        }
                    }
                    f4872e = sb.toString();
                }
                if (TextUtils.isEmpty(f4872e)) {
                    return;
                }
                f4872e += new StringBuilder(f4872e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(f4871d, f4875h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(f4871d, f4875h, c(f4873f));
                } else {
                    if (f4873f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.f4879l.clear();
    }

    public boolean c() {
        return this.f4879l.isEmpty();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(3:35|3|(4:33|5|6|7)(5:8|9|(1:11)|38|12))|31|15|16|20|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            r7 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            com.umeng.analytics.pro.f r1 = com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            com.umeng.analytics.pro.t r1 = com.umeng.analytics.pro.t.a()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            if (r2 == 0) goto L29
            r0.endTransaction()     // Catch: java.lang.Throwable -> L1f
        L1f:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            return
        L29:
            r2 = 2
            java.lang.String r3 = ""
            java.lang.String r4 = "-1"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r4 = 0
        L33:
            if (r4 >= r2) goto L65
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.<init>()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = "update __et set __i=\""
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.append(r1)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = "\" where "
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = "__i"
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = "=\""
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r6 = r3[r4]     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = "\""
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r0.execSQL(r5)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            int r4 = r4 + 1
            goto L33
        L65:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            goto L6b
        L69:
            if (r0 == 0) goto L6e
        L6b:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6e
        L6e:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            goto L80
        L78:
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L81
            com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L6e
            goto L6b
        L80:
            return
        L81:
            r1 = move-exception
            if (r0 == 0) goto L87
            r0.endTransaction()     // Catch: java.lang.Throwable -> L87
        L87:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.d():void");
    }

    public boolean e() {
        return this.f4876i.isEmpty();
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007b A[EXC_TOP_SPLITTER, PHI: r2 r5
  0x007b: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:27:0x0079, B:34:0x0095] A[DONT_GENERATE, DONT_INLINE]
  0x007b: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:27:0x0079, B:34:0x0095] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject f() {
        /*
            r8 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r8.f4879l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            com.umeng.analytics.pro.f r2 = com.umeng.analytics.pro.f.a(r2)     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            java.util.List<java.lang.String> r4 = r8.f4879l     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            java.lang.String r6 = "select *  from __is where __ii=?"
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            r7[r5] = r4     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            android.database.Cursor r4 = r2.rawQuery(r6, r7)     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            if (r4 == 0) goto L53
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L6b
            if (r5 == 0) goto L53
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L6b
            r5.<init>()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L6b
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            r3 = r5
        L53:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L6b
            if (r4 == 0) goto L5b
            r4.close()
        L5b:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L5e
        L5e:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            goto L98
        L68:
            r5 = r3
        L69:
            r3 = r4
            goto L74
        L6b:
            r5 = r3
        L6c:
            r3 = r4
            goto L8b
        L6e:
            r5 = r3
            goto L74
        L70:
            r5 = r3
            goto L8b
        L72:
            r2 = r3
            r5 = r2
        L74:
            if (r3 == 0) goto L79
            r3.close()
        L79:
            if (r2 == 0) goto L7e
        L7b:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L7e
        L7e:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            r3 = r5
            goto L98
        L89:
            r2 = r3
            r5 = r2
        L8b:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L99
            com.umeng.analytics.pro.g.a(r0)     // Catch: java.lang.Throwable -> L99
            if (r3 == 0) goto L95
            r3.close()
        L95:
            if (r2 == 0) goto L7e
            goto L7b
        L98:
            return r3
        L99:
            r0 = move-exception
            if (r3 == 0) goto L9f
            r3.close()
        L9f:
            if (r2 == 0) goto La4
            r2.endTransaction()     // Catch: java.lang.Throwable -> La4
        La4:
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r1 = com.umeng.analytics.pro.f.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.f():org.json.JSONObject");
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007b A[EXC_TOP_SPLITTER, PHI: r2 r5
  0x007b: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:27:0x0079, B:34:0x0095] A[DONT_GENERATE, DONT_INLINE]
  0x007b: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:27:0x0079, B:34:0x0095] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject g() {
        /*
            r8 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r8.f4876i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            com.umeng.analytics.pro.f r2 = com.umeng.analytics.pro.f.a(r2)     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            java.util.List<java.lang.String> r4 = r8.f4876i     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            java.lang.String r6 = "select *  from __sd where __ii=?"
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            r7[r5] = r4     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            android.database.Cursor r4 = r2.rawQuery(r6, r7)     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L70
            if (r4 == 0) goto L53
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L6b
            if (r5 == 0) goto L53
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L6b
            r5.<init>()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L6b
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L6c
            r3 = r5
        L53:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L6b
            if (r4 == 0) goto L5b
            r4.close()
        L5b:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L5e
        L5e:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            goto L98
        L68:
            r5 = r3
        L69:
            r3 = r4
            goto L74
        L6b:
            r5 = r3
        L6c:
            r3 = r4
            goto L8b
        L6e:
            r5 = r3
            goto L74
        L70:
            r5 = r3
            goto L8b
        L72:
            r2 = r3
            r5 = r2
        L74:
            if (r3 == 0) goto L79
            r3.close()
        L79:
            if (r2 == 0) goto L7e
        L7b:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L7e
        L7e:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            r3 = r5
            goto L98
        L89:
            r2 = r3
            r5 = r2
        L8b:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L99
            com.umeng.analytics.pro.g.a(r0)     // Catch: java.lang.Throwable -> L99
            if (r3 == 0) goto L95
            r3.close()
        L95:
            if (r2 == 0) goto L7e
            goto L7b
        L98:
            return r3
        L99:
            r0 = move-exception
            if (r3 == 0) goto L9f
            r3.close()
        L9f:
            if (r2 == 0) goto La4
            r2.endTransaction()     // Catch: java.lang.Throwable -> La4
        La4:
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r1 = com.umeng.analytics.pro.f.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.g():org.json.JSONObject");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:29|3|(3:5|(2:8|6)|32)|9)|27|12|13|17|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            com.umeng.analytics.pro.f r1 = com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.util.List<java.lang.Integer> r1 = r4.f4877j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r1 <= 0) goto L3c
            r1 = 0
        L17:
            java.util.List<java.lang.Integer> r2 = r4.f4877j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r1 >= r2) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.<init>()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r3 = "delete from __et where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.util.List<java.lang.Integer> r3 = r4.f4877j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.append(r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r1 = r1 + 1
            goto L17
        L3c:
            java.util.List<java.lang.Integer> r1 = r4.f4877j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r1.clear()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            goto L47
        L45:
            if (r0 == 0) goto L4a
        L47:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4a
        L4a:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            goto L5c
        L54:
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L5d
            com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L4a
            goto L47
        L5c:
            return
        L5d:
            r1 = move-exception
            if (r0 == 0) goto L63
            r0.endTransaction()     // Catch: java.lang.Throwable -> L63
        L63:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.h():void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:23|3)|21|6|7|11|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i() {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            com.umeng.analytics.pro.f r1 = com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            java.lang.String r1 = "delete from __er"
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            goto L19
        L17:
            if (r0 == 0) goto L1c
        L19:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L1c
        L1c:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            goto L2e
        L26:
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L2f
            com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L1c
            goto L19
        L2e:
            return
        L2f:
            r1 = move-exception
            if (r0 == 0) goto L35
            r0.endTransaction()     // Catch: java.lang.Throwable -> L35
        L35:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.i():void");
    }

    public void j() {
        SQLiteDatabase sQLiteDatabaseA;
        if (!TextUtils.isEmpty(this.f4878k)) {
            try {
                sQLiteDatabaseA = f.a(f4871d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    sQLiteDatabaseA.execSQL("delete from __er where __i=\"" + this.f4878k + "\"");
                    sQLiteDatabaseA.execSQL("delete from __et where __i=\"" + this.f4878k + "\"");
                    sQLiteDatabaseA.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    try {
                        g.a(f4871d);
                        if (sQLiteDatabaseA != null) {
                        }
                        this.f4878k = null;
                    } finally {
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        f.a(f4871d).b();
                    }
                } catch (Throwable unused3) {
                    this.f4878k = null;
                }
            } catch (SQLiteDatabaseCorruptException unused4) {
                sQLiteDatabaseA = null;
            } catch (Throwable unused5) {
                sQLiteDatabaseA = null;
            }
        }
        this.f4878k = null;
    }

    private h() {
        this.f4876i = new ArrayList();
        this.f4877j = new ArrayList();
        this.f4878k = null;
        this.f4879l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(jLongValue));
            contentValues.put("__sp", strC2);
            contentValues.put("__pp", strC);
            contentValues.put("__av", UMGlobalContext.getInstance(f4871d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f4871d));
            sQLiteDatabase.insert(d.c.a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery;
        Cursor cursor = null;
        strD = null;
        strD = null;
        String strD = null;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(d.C0127d.a.f4846e);
            if (jSONObjectOptJSONObject != null) {
                cursorRawQuery = sQLiteDatabase.rawQuery("select __d from __sd where __ii=?", new String[]{str});
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            strD = d(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(d.C0127d.a.f4846e)));
                        } catch (Throwable unused) {
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                    }
                }
            } else {
                cursorRawQuery = null;
            }
            if (jSONObjectOptJSONObject != null) {
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(strD)) {
                    jSONArray = new JSONArray(strD);
                }
                jSONArray.put(jSONObjectOptJSONObject);
                String strC = c(jSONArray.toString());
                if (!TextUtils.isEmpty(strC)) {
                    sQLiteDatabase.execSQL("update  __sd set __d=\"" + strC + "\" where __ii=\"" + str + "\"");
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(d.C0127d.a.f4845d);
            if (jSONObjectOptJSONObject2 != null) {
                String strC2 = c(jSONObjectOptJSONObject2.toString());
                if (!TextUtils.isEmpty(strC2)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + strC2 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + String.valueOf(jSONObject.optLong(d.C0127d.a.f4848g)) + "\" where __ii=\"" + str + "\"");
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable unused2) {
        }
    }

    public void a() {
        this.f4876i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0098, code lost:
    
        if (r2 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:
    
        if (r2 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(org.json.JSONArray r11) {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            com.umeng.analytics.pro.f r3 = com.umeng.analytics.pro.f.a(r3)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r4 = 0
        L13:
            int r5 = r11.length()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            if (r4 >= r5) goto L8d
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.<init>()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = r5.optString(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L34
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            if (r8 == 0) goto L43
        L34:
            com.umeng.analytics.pro.t r7 = com.umeng.analytics.pro.t.a()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = r7.b()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            if (r8 == 0) goto L43
            r7 = r9
        L43:
            r6.put(r1, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            int r7 = r5.optInt(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r0, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r5.remove(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r5.remove(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r5 = r10.c(r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
        L8a:
            int r4 = r4 + 1
            goto L13
        L8d:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r3.endTransaction()     // Catch: java.lang.Throwable -> L9d
            goto L9d
        L94:
            r2 = r3
            goto L98
        L96:
            r2 = r3
            goto La7
        L98:
            if (r2 == 0) goto L9d
        L9a:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L9d
        L9d:
            android.content.Context r11 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r11 = com.umeng.analytics.pro.f.a(r11)
            r11.b()
            goto Laf
        La7:
            android.content.Context r11 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> Lb0
            com.umeng.analytics.pro.g.a(r11)     // Catch: java.lang.Throwable -> Lb0
            if (r2 == 0) goto L9d
            goto L9a
        Laf:
            return
        Lb0:
            r11 = move-exception
            if (r2 == 0) goto Lb6
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.a(org.json.JSONArray):void");
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(f4872e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f4872e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0084 A[PHI: r0 r1
  0x0084: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:26:0x0071, B:32:0x007f, B:33:0x0081] A[DONT_GENERATE, DONT_INLINE]
  0x0084: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:26:0x0071, B:32:0x007f, B:33:0x0081] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(org.json.JSONObject r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L74
            com.umeng.analytics.pro.f r1 = com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L74
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L74
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.lang.String r2 = "select *  from __er"
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r3 != 0) goto L23
            java.lang.String r2 = "select *  from __er where __i=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r4 = 0
            r3[r4] = r7     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            android.database.Cursor r7 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            goto L27
        L23:
            android.database.Cursor r7 = r1.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
        L27:
            r0 = r7
            if (r0 == 0) goto L5d
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r7.<init>()     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
        L2f:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r2 == 0) goto L52
            java.lang.String r2 = "__a"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r3 != 0) goto L2f
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.lang.String r2 = r5.d(r2)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r7.put(r3)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            goto L2f
        L52:
            int r2 = r7.length()     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r2 <= 0) goto L5d
            java.lang.String r2 = "error"
            r6.put(r2, r7)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
        L5d:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r0 == 0) goto L81
            r0.close()
            goto L81
        L66:
            r1 = r0
        L67:
            android.content.Context r6 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L8e
            com.umeng.analytics.pro.g.a(r6)     // Catch: java.lang.Throwable -> L8e
            if (r0 == 0) goto L71
            r0.close()
        L71:
            if (r1 == 0) goto L84
            goto L81
        L74:
            r1 = r0
        L75:
            android.content.Context r6 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L8e
            com.umeng.analytics.pro.g.a(r6)     // Catch: java.lang.Throwable -> L8e
            if (r0 == 0) goto L7f
            r0.close()
        L7f:
            if (r1 == 0) goto L84
        L81:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L84
        L84:
            android.content.Context r6 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r6 = com.umeng.analytics.pro.f.a(r6)
            r6.b()
            return
        L8e:
            r6 = move-exception
            if (r0 == 0) goto L94
            r0.close()
        L94:
            if (r1 == 0) goto L99
            r1.endTransaction()     // Catch: java.lang.Throwable -> L99
        L99:
            android.content.Context r7 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r7 = com.umeng.analytics.pro.f.a(r7)
            r7.b()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.b(org.json.JSONObject, java.lang.String):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f4872e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f4872e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0056, code lost:
    
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0058, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            com.umeng.analytics.pro.f r1 = com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.<init>()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = r4.c(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r6 != 0) goto L4b
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__av"
            android.content.Context r6 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__vc"
            android.content.Context r6 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
        L4b:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r1.endTransaction()     // Catch: java.lang.Throwable -> L5b
            goto L5b
        L52:
            r0 = r1
            goto L56
        L54:
            r0 = r1
            goto L65
        L56:
            if (r0 == 0) goto L5b
        L58:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L5b
        L5b:
            android.content.Context r5 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r5 = com.umeng.analytics.pro.f.a(r5)
            r5.b()
            goto L6d
        L65:
            android.content.Context r5 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L6f
            com.umeng.analytics.pro.g.a(r5)     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L5b
            goto L58
        L6d:
            r5 = 0
            return r5
        L6f:
            r5 = move-exception
            if (r0 == 0) goto L75
            r0.endTransaction()     // Catch: java.lang.Throwable -> L75
        L75:
            android.content.Context r6 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r6 = com.umeng.analytics.pro.f.a(r6)
            r6.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.a(java.lang.String, java.lang.String, int):boolean");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("duration") > 0) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dd A[EXC_TOP_SPLITTER, PHI: r1 r11
  0x00dd: PHI (r1v4 android.database.sqlite.SQLiteDatabase) = (r1v3 android.database.sqlite.SQLiteDatabase), (r1v6 android.database.sqlite.SQLiteDatabase) binds: [B:37:0x00cc, B:43:0x00db] A[DONT_GENERATE, DONT_INLINE]
  0x00dd: PHI (r11v5 ??) = (r11v4 ??), (r11v7 ??) binds: [B:37:0x00cc, B:43:0x00db] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b(org.json.JSONObject r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.b(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0085, code lost:
    
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
    
        if (r2 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.h.a r9) {
        /*
            r6 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r8 != 0) goto L6
            return r1
        L6:
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            com.umeng.analytics.pro.f r3 = com.umeng.analytics.pro.f.a(r3)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            com.umeng.analytics.pro.h$a r4 = com.umeng.analytics.pro.h.a.BEGIN     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r4) goto L4f
            java.lang.Object r8 = r8.opt(r0)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            long r8 = r8.longValue()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.<init>()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r5 = "__ii"
            r4.put(r5, r7)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r0, r7)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__sd"
            r3.insert(r7, r2, r4)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L4f:
            com.umeng.analytics.pro.h$a r0 = com.umeng.analytics.pro.h.a.INSTANTSESSIONBEGIN     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L57
            r6.b(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L57:
            com.umeng.analytics.pro.h$a r0 = com.umeng.analytics.pro.h.a.END     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L5f
            r6.a(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L5f:
            com.umeng.analytics.pro.h$a r0 = com.umeng.analytics.pro.h.a.PAGE     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L69
            java.lang.String r9 = "__a"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L69:
            com.umeng.analytics.pro.h$a r0 = com.umeng.analytics.pro.h.a.AUTOPAGE     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L73
            java.lang.String r9 = "__b"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L73:
            com.umeng.analytics.pro.h$a r0 = com.umeng.analytics.pro.h.a.NEWSESSION     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L7a
            r6.c(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
        L7a:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r3.endTransaction()     // Catch: java.lang.Throwable -> L8a
            goto L8a
        L81:
            r2 = r3
            goto L85
        L83:
            r2 = r3
            goto L94
        L85:
            if (r2 == 0) goto L8a
        L87:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8a
        L8a:
            android.content.Context r7 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r7 = com.umeng.analytics.pro.f.a(r7)
            r7.b()
            goto L9c
        L94:
            android.content.Context r7 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L9d
            com.umeng.analytics.pro.g.a(r7)     // Catch: java.lang.Throwable -> L9d
            if (r2 == 0) goto L8a
            goto L87
        L9c:
            return r1
        L9d:
            r7 = move-exception
            if (r2 == 0) goto La3
            r2.endTransaction()     // Catch: java.lang.Throwable -> La3
        La3:
            android.content.Context r8 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r8 = com.umeng.analytics.pro.f.a(r8)
            r8.b()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.h$a):boolean");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.opt(d.C0127d.a.f4848g)).longValue();
            long jLongValue2 = 0;
            Object objOpt = jSONObject.opt(d.C0127d.a.f4849h);
            if (objOpt != null && (objOpt instanceof Long)) {
                jLongValue2 = ((Long) objOpt).longValue();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + jLongValue + "\", " + d.C0127d.a.f4849h + "=\"" + jLongValue2 + "\", __sp=\"" + strC2 + "\", __pp=\"" + strC + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:33|3|(1:(1:6))(2:7|(3:9|(2:12|10)|36))|13)|29|16|17|21|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            com.umeng.analytics.pro.f r1 = com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r4 == 0) goto L18
            if (r3 == 0) goto L4d
            java.lang.String r3 = "delete from __sd"
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            goto L4d
        L18:
            java.util.List<java.lang.String> r3 = r2.f4876i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r3 <= 0) goto L4d
            r3 = 0
        L21:
            java.util.List<java.lang.String> r4 = r2.f4876i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r3 >= r4) goto L4d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r4.<init>()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = "delete from __sd where __ii=\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.util.List<java.lang.String> r1 = r2.f4876i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = "\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r3 = r3 + 1
            goto L21
        L4d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            goto L53
        L51:
            if (r0 == 0) goto L56
        L53:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L56
        L56:
            android.content.Context r3 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r3 = com.umeng.analytics.pro.f.a(r3)
            r3.b()
            goto L68
        L60:
            android.content.Context r3 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L69
            com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L56
            goto L53
        L68:
            return
        L69:
            r3 = move-exception
            if (r0 == 0) goto L6f
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6f
        L6f:
            android.content.Context r4 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r4 = com.umeng.analytics.pro.f.a(r4)
            r4.b()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.b(boolean, boolean):void");
    }

    public long a(String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorRawQuery = null;
        long j2 = 0;
        try {
            try {
                sQLiteDatabaseA = f.a(f4871d).a();
            } catch (Exception unused) {
            }
            try {
                sQLiteDatabaseA.beginTransaction();
                cursorRawQuery = sQLiteDatabaseA.rawQuery("select __f from __sd where __ii=?", new String[]{str});
                if (cursorRawQuery != null) {
                    cursorRawQuery.moveToFirst();
                    j2 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(d.C0127d.a.f4848g));
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception unused2) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (sQLiteDatabaseA != null) {
                }
                f.a(f4871d).b();
                return j2;
            } catch (Throwable th) {
                th = th;
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused3) {
                        f.a(f4871d).b();
                        throw th;
                    }
                }
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
                f.a(f4871d).b();
                throw th;
            }
        } catch (Exception unused4) {
            sQLiteDatabaseA = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabaseA = null;
        }
        sQLiteDatabaseA.endTransaction();
        f.a(f4871d).b();
        return j2;
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) {
        JSONArray jSONArrayOptJSONArray;
        Cursor cursor = null;
        strD = null;
        String strD = null;
        try {
            if ("__a".equals(str2)) {
                jSONArrayOptJSONArray = jSONObject.optJSONArray("__a");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    return;
                }
            } else if (d.C0127d.a.f4844c.equals(str2)) {
                jSONArrayOptJSONArray = jSONObject.optJSONArray(d.C0127d.a.f4844c);
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    return;
                }
            } else {
                jSONArrayOptJSONArray = null;
            }
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select " + str2 + " from " + d.C0127d.a + " where __ii=?", new String[]{str});
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    try {
                        strD = d(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str2)));
                    } catch (Throwable unused) {
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(strD)) {
                jSONArray = new JSONArray(strD);
            }
            if (jSONArray.length() > 1000) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return;
                }
                return;
            }
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        jSONArray.put(jSONObject2);
                    }
                } catch (JSONException unused2) {
                }
            }
            String strC = c(jSONArray.toString());
            if (!TextUtils.isEmpty(strC)) {
                sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + strC + "\" where __ii=\"" + str + "\"");
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:26|3|(1:5)|6)|22|9|10|14|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            com.umeng.analytics.pro.f r1 = com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            if (r1 != 0) goto L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r1.<init>()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r2 = "delete from __is where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r1.append(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r4 = "\""
            r1.append(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
        L2d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            goto L33
        L31:
            if (r0 == 0) goto L36
        L33:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L36
        L36:
            android.content.Context r4 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r4 = com.umeng.analytics.pro.f.a(r4)
            r4.b()
            goto L48
        L40:
            android.content.Context r4 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L49
            com.umeng.analytics.pro.g.a(r4)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L36
            goto L33
        L48:
            return
        L49:
            r4 = move-exception
            if (r0 == 0) goto L4f
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4f
        L4f:
            android.content.Context r0 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r0 = com.umeng.analytics.pro.f.a(r0)
            r0.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.b(java.lang.String):void");
    }

    public JSONObject a(boolean z) {
        a();
        this.f4877j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String strA = a(jSONObject, z);
            if (!TextUtils.isEmpty(strA)) {
                b(jSONObject, strA);
                a(jSONObject, strA);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:94|3)|(7:97|4|(1:6)(1:7)|8|(7:10|(6:13|(2:17|(2:107|19)(2:114|108))(1:106)|20|(3:105|22|(5:103|27|(1:29)(1:30)|31|112))(3:100|32|(5:104|34|(1:36)(1:37)|38|110)(1:109))|108|11)|99|39|(5:41|(4:44|(3:116|46|119)(1:118)|117|42)|115|47|(1:49))|50|(5:52|(4:55|(3:121|57|124)(1:123)|122|53)|120|58|(1:60)))|61|(1:63))|89|75|93|76|77|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0181 A[PHI: r0 r1
  0x0181: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:68:0x016e, B:74:0x017c, B:75:0x017e] A[DONT_GENERATE, DONT_INLINE]
  0x0181: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:68:0x016e, B:74:0x017c, B:75:0x017e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(org.json.JSONObject r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0230 A[EXC_TOP_SPLITTER, PHI: r0 r12 r16
  0x0230: PHI (r0v6 java.lang.String) = (r0v2 java.lang.String), (r0v3 java.lang.String), (r0v37 java.lang.String), (r0v37 java.lang.String) binds: [B:87:0x021e, B:93:0x022e, B:79:0x0203, B:80:0x0205] A[DONT_GENERATE, DONT_INLINE]
  0x0230: PHI (r12v6 android.database.sqlite.SQLiteDatabase) = 
  (r12v3 android.database.sqlite.SQLiteDatabase)
  (r12v4 android.database.sqlite.SQLiteDatabase)
  (r12v33 android.database.sqlite.SQLiteDatabase)
  (r12v33 android.database.sqlite.SQLiteDatabase)
 binds: [B:87:0x021e, B:93:0x022e, B:79:0x0203, B:80:0x0205] A[DONT_GENERATE, DONT_INLINE]
  0x0230: PHI (r16v6 android.database.Cursor) = 
  (r16v3 android.database.Cursor)
  (r16v4 android.database.Cursor)
  (r16v29 android.database.Cursor)
  (r16v29 android.database.Cursor)
 binds: [B:87:0x021e, B:93:0x022e, B:79:0x0203, B:80:0x0205] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0233 A[PHI: r0 r12 r16
  0x0233: PHI (r0v5 java.lang.String) = (r0v2 java.lang.String), (r0v3 java.lang.String), (r0v6 java.lang.String) binds: [B:87:0x021e, B:93:0x022e, B:94:0x0230] A[DONT_GENERATE, DONT_INLINE]
  0x0233: PHI (r12v5 android.database.sqlite.SQLiteDatabase) = 
  (r12v3 android.database.sqlite.SQLiteDatabase)
  (r12v4 android.database.sqlite.SQLiteDatabase)
  (r12v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:87:0x021e, B:93:0x022e, B:94:0x0230] A[DONT_GENERATE, DONT_INLINE]
  0x0233: PHI (r16v5 android.database.Cursor) = (r16v3 android.database.Cursor), (r16v4 android.database.Cursor), (r16v6 android.database.Cursor) binds: [B:87:0x021e, B:93:0x022e, B:94:0x0230] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x022b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(org.json.JSONObject r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.a(org.json.JSONObject, boolean):java.lang.String");
    }

    public void a(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                try {
                    sQLiteDatabaseA = f.a(f4871d).a();
                    sQLiteDatabaseA.beginTransaction();
                    if (!z2) {
                        int size = this.f4879l.size();
                        int i2 = 0;
                        if (size > 0) {
                            int i3 = 0;
                            while (i2 < size) {
                                String str = this.f4879l.get(i2);
                                if (str == null) {
                                    i3 = 1;
                                }
                                sQLiteDatabaseA.execSQL("delete from __is where __ii=\"" + str + "\"");
                                i2++;
                            }
                            i2 = i3;
                        }
                        if (i2 != 0) {
                            sQLiteDatabaseA.execSQL("delete from __is where __ii is null");
                        }
                    } else if (z) {
                        sQLiteDatabaseA.execSQL("delete from __is");
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                } catch (Throwable unused) {
                    g.a(f4871d);
                    if (sQLiteDatabaseA != null) {
                    }
                    f.a(f4871d).b();
                }
            } catch (SQLiteDatabaseCorruptException unused2) {
                g.a(f4871d);
                if (sQLiteDatabaseA != null) {
                }
                f.a(f4871d).b();
            }
            try {
                sQLiteDatabaseA.endTransaction();
            } catch (Throwable unused3) {
            }
            f.a(f4871d).b();
        } catch (Throwable th) {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            f.a(f4871d).b();
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:26|3|(1:5)|6)|24|9|10|14|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = "\""
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            com.umeng.analytics.pro.f r1 = com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            if (r1 != 0) goto L60
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __er where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __et where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.util.List<java.lang.Integer> r1 = r3.f4877j     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.clear()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __sd where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
        L60:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            goto L66
        L64:
            if (r0 == 0) goto L69
        L66:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L69
        L69:
            android.content.Context r4 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r4 = com.umeng.analytics.pro.f.a(r4)
            r4.b()
            goto L7b
        L73:
            android.content.Context r4 = com.umeng.analytics.pro.h.f4871d     // Catch: java.lang.Throwable -> L7c
            com.umeng.analytics.pro.g.a(r4)     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L69
            goto L66
        L7b:
            return
        L7c:
            r4 = move-exception
            if (r0 == 0) goto L82
            r0.endTransaction()     // Catch: java.lang.Throwable -> L82
        L82:
            android.content.Context r5 = com.umeng.analytics.pro.h.f4871d
            com.umeng.analytics.pro.f r5 = com.umeng.analytics.pro.f.a(r5)
            r5.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.a(boolean, java.lang.String):void");
    }
}
