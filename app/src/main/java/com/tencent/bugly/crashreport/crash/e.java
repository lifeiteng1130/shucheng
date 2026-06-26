package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.AbstractC0320m;
import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.L;
import com.tencent.bugly.proguard.M;
import com.tencent.bugly.proguard.T;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.tencent.bugly.proguard.ka;
import com.tencent.bugly.proguard.ma;
import com.tencent.bugly.proguard.na;
import com.tencent.bugly.proguard.oa;
import com.tencent.bugly.proguard.pa;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f4172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f4173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final J f4174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.tencent.bugly.crashreport.common.strategy.c f4175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m f4176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BuglyStrategy.a f4177g;

    public e(int i2, Context context, T t, J j2, com.tencent.bugly.crashreport.common.strategy.c cVar, BuglyStrategy.a aVar, m mVar) {
        a = i2;
        this.f4172b = context;
        this.f4173c = t;
        this.f4174d = j2;
        this.f4175e = cVar;
        this.f4177g = aVar;
        this.f4176f = mVar;
    }

    private boolean g(CrashDetailBean crashDetailBean) {
        try {
            X.a("save eup logs", new Object[0]);
            com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
            String strE = aVarM.e();
            String str = aVarM.E;
            String str2 = crashDetailBean.A;
            String str3 = String.format(Locale.US, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", strE, str, aVarM.f4103l, str2, ca.a(new Date(crashDetailBean.r)), crashDetailBean.n, crashDetailBean.o, crashDetailBean.q, crashDetailBean.f4131c);
            String absolutePath = null;
            if (h.f4192j != null) {
                File file = new File(h.f4192j);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                absolutePath = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath2);
                sb.append("/Tencent/");
                sb.append(this.f4172b.getPackageName());
                absolutePath = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(absolutePath);
            sb2.append("/euplog.txt");
            ca.a(this.f4172b, sb2.toString(), str3, h.f4193k);
            return true;
        } catch (Throwable th) {
            X.e("rqdp{  save error} %s", th.toString());
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public CrashDetailBean a(List<b> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> listA;
        String[] strArrSplit;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (b bVar : list) {
            if (bVar.f4169e) {
                arrayList.add(bVar);
            }
        }
        if (arrayList.size() > 0 && (listA = a(arrayList)) != null && listA.size() > 0) {
            Collections.sort(listA);
            for (int i2 = 0; i2 < listA.size(); i2++) {
                CrashDetailBean crashDetailBean3 = listA.get(i2);
                if (i2 == 0) {
                    crashDetailBean2 = crashDetailBean3;
                } else {
                    String str = crashDetailBean3.s;
                    if (str != null && (strArrSplit = str.split("\n")) != null) {
                        for (String str2 : strArrSplit) {
                            if (!crashDetailBean2.s.contains("" + str2)) {
                                crashDetailBean2.t++;
                                crashDetailBean2.s += str2 + "\n";
                            }
                        }
                    }
                }
            }
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f4138j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (b bVar2 : list) {
            if (!bVar2.f4169e && !bVar2.f4168d) {
                String str3 = crashDetailBean2.s;
                StringBuilder sbR = c.a.a.a.a.r("");
                sbR.append(bVar2.f4166b);
                if (!str3.contains(sbR.toString())) {
                    crashDetailBean2.t++;
                    crashDetailBean2.s += bVar2.f4166b + "\n";
                }
            }
        }
        if (crashDetailBean2.r != crashDetailBean.r) {
            String str4 = crashDetailBean2.s;
            StringBuilder sbR2 = c.a.a.a.a.r("");
            sbR2.append(crashDetailBean.r);
            if (!str4.contains(sbR2.toString())) {
                crashDetailBean2.t++;
                crashDetailBean2.s += crashDetailBean.r + "\n";
            }
        }
        return crashDetailBean2;
    }

    public List<b> b(List<b> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            if (bVar.f4168d && bVar.f4166b <= jCurrentTimeMillis - 86400000) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public boolean c(CrashDetailBean crashDetailBean) {
        return a(crashDetailBean, -123456789);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d3 A[PHI: r18 r19 r21
  0x00d3: PHI (r18v1 java.lang.String) = (r18v0 java.lang.String), (r18v5 java.lang.String) binds: [B:52:0x00bd, B:47:0x00a8] A[DONT_GENERATE, DONT_INLINE]
  0x00d3: PHI (r19v1 long) = (r19v0 long), (r19v4 long) binds: [B:52:0x00bd, B:47:0x00a8] A[DONT_GENERATE, DONT_INLINE]
  0x00d3: PHI (r21v1 java.lang.String) = (r21v0 java.lang.String), (r21v3 java.lang.String) binds: [B:52:0x00bd, B:47:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(com.tencent.bugly.crashreport.crash.CrashDetailBean r23) {
        /*
            Method dump skipped, instruction units count: 638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.e.d(com.tencent.bugly.crashreport.crash.CrashDetailBean):void");
    }

    public void e(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.f4130b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 3 && !h.g().j()) {
                    return;
                }
            } else if (!h.g().k()) {
                return;
            }
        } else if (!h.g().k()) {
            return;
        }
        if (this.f4176f != null) {
            X.a("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            this.f4176f.a(crashDetailBean.f4130b == 1);
        }
    }

    public void f(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues contentValuesB = b(crashDetailBean);
        if (contentValuesB != null) {
            long jA = J.a().a("t_cr", contentValuesB, (I) null, true);
            if (jA >= 0) {
                X.a("insert %s success!", "t_cr");
                crashDetailBean.a = jA;
            }
        }
        if (h.f4191i) {
            g(crashDetailBean);
        }
    }

    public void c(List<b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sbU = c.a.a.a.a.u("_id", " in ", "(");
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            sbU.append(it.next().a);
            sbU.append(",");
        }
        StringBuilder sb = new StringBuilder(sbU.substring(0, sbU.lastIndexOf(",")));
        sb.append(")");
        String string = sb.toString();
        sb.setLength(0);
        try {
            int iA = J.a().a("t_cr", string, (String[]) null, (I) null, true);
            Object[] objArr = new Object[2];
            objArr[0] = "t_cr";
            objArr[1] = Integer.valueOf(iA);
            X.a("deleted %s data %d", objArr);
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public List<CrashDetailBean> b() {
        StrategyBean strategyBeanC = com.tencent.bugly.crashreport.common.strategy.c.b().c();
        if (strategyBeanC == null) {
            X.e("have not synced remote!", new Object[0]);
            return null;
        }
        if (!strategyBeanC.f4112f) {
            X.e("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            X.d("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jB = ca.b();
        List<b> listA = a();
        X.a("Size of crash list loaded from DB: %s", Integer.valueOf(listA.size()));
        if (listA.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(b(listA));
        listA.removeAll(arrayList);
        Iterator<b> it = listA.iterator();
        while (it.hasNext()) {
            b next = it.next();
            long j2 = next.f4166b;
            if (j2 < jB - h.f4189g) {
                it.remove();
                arrayList.add(next);
            } else if (next.f4168d) {
                if (j2 >= jCurrentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f4169e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f4170f >= 3 && j2 < jCurrentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            c(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        List<CrashDetailBean> listA2 = a(listA);
        if (listA2 != null && listA2.size() > 0) {
            String str = com.tencent.bugly.crashreport.common.info.a.m().E;
            Iterator<CrashDetailBean> it2 = listA2.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f4134f)) {
                    it2.remove();
                    arrayList2.add(next2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            d(arrayList2);
        }
        return listA2;
    }

    public boolean a(CrashDetailBean crashDetailBean, int i2) {
        if (crashDetailBean == null) {
            return true;
        }
        String str = h.n;
        if (str != null && !str.isEmpty()) {
            X.a("Crash filter for crash stack is: %s", h.n);
            if (crashDetailBean.q.contains(h.n)) {
                X.e("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        String str2 = h.o;
        if (str2 != null && !str2.isEmpty()) {
            X.a("Crash regular filter for crash stack is: %s", h.o);
            if (Pattern.compile(h.o).matcher(crashDetailBean.q).find()) {
                X.e("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.f4130b != 2) {
            L l2 = new L();
            l2.f4294b = 1;
            l2.f4295c = crashDetailBean.A;
            l2.f4296d = crashDetailBean.B;
            l2.f4297e = crashDetailBean.r;
            this.f4174d.b(1);
            this.f4174d.c(l2);
            X.d("[crash] a crash occur, handling...", new Object[0]);
        } else {
            X.d("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<b> listA = a();
        ArrayList arrayList = null;
        if (listA != null && listA.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList<b> arrayList2 = new ArrayList(10);
            arrayList.addAll(b(listA));
            listA.removeAll(arrayList);
            if (listA.size() > 20) {
                a(5);
            }
            if (a(crashDetailBean)) {
                boolean z = false;
                for (b bVar : listA) {
                    if (crashDetailBean.u.equals(bVar.f4167c)) {
                        if (bVar.f4169e) {
                            z = true;
                        }
                        arrayList2.add(bVar);
                    }
                }
                if (z || arrayList2.size() >= h.f4185c) {
                    X.c("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean crashDetailBeanA = a(arrayList2, crashDetailBean);
                    for (b bVar2 : arrayList2) {
                        if (bVar2.a != crashDetailBeanA.a) {
                            arrayList.add(bVar2);
                        }
                    }
                    f(crashDetailBeanA);
                    c(arrayList);
                    X.d("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        f(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            c(arrayList);
        }
        X.d("[crash] save crash success", new Object[0]);
        return false;
    }

    public ContentValues b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = crashDetailBean.a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f4132d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.f4138j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f4140l));
            contentValues.put("_dt", ca.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public CrashDetailBean b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ca.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.a = j2;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public void d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or ");
                    sb.append("_id");
                    sb.append(" = ");
                    sb.append(crashDetailBean.a);
                }
                String string = sb.toString();
                if (string.length() > 0) {
                    string = string.substring(4);
                }
                String str = string;
                sb.setLength(0);
                int iA = J.a().a("t_cr", str, (String[]) null, (I) null, true);
                Object[] objArr = new Object[2];
                objArr[0] = "t_cr";
                objArr[1] = Integer.valueOf(iA);
                X.a("deleted %s data %d", objArr);
            } catch (Throwable th) {
                if (X.b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    public boolean a(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.f4130b;
        return !com.tencent.bugly.b.f3960c && (!((i2 == 3) || (i2 == 0 || i2 == 1)) || h.f4186d);
    }

    public void a(CrashDetailBean crashDetailBean, long j2, boolean z) {
        if (h.f4194l) {
            X.c("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, j2, z, crashDetailBean.f4130b == 7, z);
            return;
        }
        X.c("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    public void a(List<CrashDetailBean> list, long j2, boolean z, boolean z2, boolean z3) {
        if (!com.tencent.bugly.crashreport.common.info.a.a(this.f4172b).f4101j) {
            X.e("warn: not upload process", new Object[0]);
            return;
        }
        T t = this.f4173c;
        if (t == null) {
            X.e("warn: upload manager is null", new Object[0]);
            return;
        }
        if (!z3 && !t.a(h.a)) {
            X.e("warn: not crashHappen or not should upload", new Object[0]);
            return;
        }
        StrategyBean strategyBeanC = this.f4175e.c();
        if (!strategyBeanC.f4112f) {
            X.e("remote report is disable!", new Object[0]);
            X.d("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            return;
        }
        if (list != null && list.size() != 0) {
            try {
                String str = strategyBeanC.r;
                String str2 = StrategyBean.f4108b;
                oa oaVarA = a(this.f4172b, list, com.tencent.bugly.crashreport.common.info.a.m());
                if (oaVarA == null) {
                    X.e("create eupPkg fail!", new Object[0]);
                    return;
                }
                byte[] bArrA = M.a((AbstractC0320m) oaVarA);
                if (bArrA == null) {
                    X.e("send encode fail!", new Object[0]);
                    return;
                }
                pa paVarA = M.a(this.f4172b, 830, bArrA);
                if (paVarA == null) {
                    X.e("request package is null.", new Object[0]);
                    return;
                }
                d dVar = new d(this, list);
                if (z) {
                    this.f4173c.a(a, paVarA, str, str2, dVar, j2, z2);
                    return;
                } else {
                    this.f4173c.a(a, paVarA, str, str2, dVar, false);
                    return;
                }
            } catch (Throwable th) {
                X.b("req cr error %s", th.toString());
                if (X.a(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
        X.e("warn: crashList is null or crashList num is 0", new Object[0]);
    }

    public void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            X.a("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                X.a("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f4131c, Integer.valueOf(crashDetailBean.f4140l), Boolean.valueOf(crashDetailBean.f4132d), Boolean.valueOf(crashDetailBean.f4138j));
                int i2 = crashDetailBean.f4140l + 1;
                crashDetailBean.f4140l = i2;
                crashDetailBean.f4132d = z;
                X.a("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f4131c, Integer.valueOf(i2), Boolean.valueOf(crashDetailBean.f4132d), Boolean.valueOf(crashDetailBean.f4138j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                h.g().a(it.next());
            }
            X.a("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        X.d("[crash] upload fail.", new Object[0]);
    }

    public List<CrashDetailBean> a(List<b> list) {
        Cursor cursorA;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sbU = c.a.a.a.a.u("_id", " in ", "(");
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            sbU.append(it.next().a);
            sbU.append(",");
        }
        if (sbU.toString().contains(",")) {
            sbU = new StringBuilder(sbU.substring(0, sbU.lastIndexOf(",")));
        }
        sbU.append(")");
        String string = sbU.toString();
        sbU.setLength(0);
        try {
            cursorA = J.a().a("t_cr", null, string, null, null, true);
            if (cursorA == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sbU.append("_id");
                sbU.append(" in ");
                sbU.append("(");
                int i2 = 0;
                while (cursorA.moveToNext()) {
                    try {
                        CrashDetailBean crashDetailBeanB = b(cursorA);
                        if (crashDetailBeanB != null) {
                            arrayList.add(crashDetailBeanB);
                        } else {
                            try {
                                sbU.append(cursorA.getLong(cursorA.getColumnIndex("_id")));
                                sbU.append(",");
                                i2++;
                            } catch (Throwable unused) {
                                X.e("unknown id!", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
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
                }
                if (sbU.toString().contains(",")) {
                    sbU = new StringBuilder(sbU.substring(0, sbU.lastIndexOf(",")));
                }
                sbU.append(")");
                String string2 = sbU.toString();
                if (i2 > 0) {
                    int iA = J.a().a("t_cr", string2, (String[]) null, (I) null, true);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_cr";
                    objArr[1] = Integer.valueOf(iA);
                    X.e("deleted %s illegal data %d", objArr);
                }
                cursorA.close();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorA = null;
        }
    }

    public b a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            b bVar = new b();
            bVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            bVar.f4166b = cursor.getLong(cursor.getColumnIndex("_tm"));
            bVar.f4167c = cursor.getString(cursor.getColumnIndex("_s1"));
            bVar.f4168d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            bVar.f4169e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            bVar.f4170f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return bVar;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public List<b> a() {
        Cursor cursorA;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursorA = J.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
        } catch (Throwable th) {
            th = th;
        }
        if (cursorA == null) {
            if (cursorA != null) {
                cursorA.close();
            }
            return null;
        }
        try {
            if (cursorA.getCount() < 1) {
                cursorA.close();
                return arrayList;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_id");
            sb.append(" in ");
            sb.append("(");
            int i2 = 0;
            while (cursorA.moveToNext()) {
                try {
                    b bVarA = a(cursorA);
                    if (bVarA != null) {
                        arrayList.add(bVarA);
                    } else {
                        try {
                            sb.append(cursorA.getLong(cursorA.getColumnIndex("_id")));
                            sb.append(",");
                            i2++;
                        } catch (Throwable unused) {
                            X.e("unknown id!", new Object[0]);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (sb.toString().contains(",")) {
                sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
            }
            sb.append(")");
            String string = sb.toString();
            sb.setLength(0);
            if (i2 > 0) {
                int iA = J.a().a("t_cr", string, (String[]) null, (I) null, true);
                Object[] objArr = new Object[2];
                objArr[0] = "t_cr";
                objArr[1] = Integer.valueOf(iA);
                X.e("deleted %s illegal data %d", objArr);
            }
            cursorA.close();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
        }
        cursor = cursorA;
        try {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void a(int i2) {
        if (i2 <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id");
        sb.append(" in ");
        sb.append("(");
        sb.append("SELECT ");
        sb.append("_id");
        c.a.a.a.a.z(sb, " FROM ", "t_cr", " order by ", "_id");
        sb.append(" limit ");
        sb.append(i2);
        sb.append(")");
        String string = sb.toString();
        sb.setLength(0);
        try {
            X.a("deleted first record %s data %d", "t_cr", Integer.valueOf(J.a().a("t_cr", string, (String[]) null, (I) null, true)));
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static na a(Context context, CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        ma maVarA;
        ma maVarA2;
        ma maVar;
        if (context != null && crashDetailBean != null && aVar != null) {
            na naVar = new na();
            int i2 = crashDetailBean.f4130b;
            switch (i2) {
                case 0:
                    naVar.f4403i = crashDetailBean.f4138j ? "200" : "100";
                    break;
                case 1:
                    naVar.f4403i = crashDetailBean.f4138j ? "201" : "101";
                    break;
                case 2:
                    naVar.f4403i = crashDetailBean.f4138j ? "202" : "102";
                    break;
                case 3:
                    naVar.f4403i = crashDetailBean.f4138j ? "203" : "103";
                    break;
                case 4:
                    naVar.f4403i = crashDetailBean.f4138j ? "204" : "104";
                    break;
                case 5:
                    naVar.f4403i = crashDetailBean.f4138j ? "207" : "107";
                    break;
                case 6:
                    naVar.f4403i = crashDetailBean.f4138j ? "206" : "106";
                    break;
                case 7:
                    naVar.f4403i = crashDetailBean.f4138j ? "208" : "108";
                    break;
                default:
                    X.b("crash type error! %d", Integer.valueOf(i2));
                    break;
            }
            naVar.f4404j = crashDetailBean.r;
            naVar.f4405k = crashDetailBean.n;
            naVar.f4406l = crashDetailBean.o;
            naVar.m = crashDetailBean.p;
            naVar.o = crashDetailBean.q;
            naVar.p = crashDetailBean.z;
            naVar.q = crashDetailBean.f4131c;
            naVar.r = null;
            naVar.t = crashDetailBean.m;
            naVar.u = crashDetailBean.f4133e;
            naVar.n = crashDetailBean.B;
            naVar.v = null;
            X.a("libInfo %s", naVar.w);
            Map<String, PlugInBean> map = crashDetailBean.f4136h;
            if (map != null && map.size() > 0) {
                naVar.x = new ArrayList<>();
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f4136h.entrySet()) {
                    ka kaVar = new ka();
                    kaVar.a = entry.getValue().a;
                    kaVar.f4386c = entry.getValue().f4092c;
                    kaVar.f4388e = entry.getValue().f4091b;
                    naVar.x.add(kaVar);
                }
            }
            if (crashDetailBean.f4138j) {
                naVar.s = crashDetailBean.t;
                String str = crashDetailBean.s;
                if (str != null && str.length() > 0) {
                    if (naVar.y == null) {
                        naVar.y = new ArrayList<>();
                    }
                    try {
                        naVar.y.add(new ma((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                        naVar.y = null;
                    }
                }
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(naVar.s);
                ArrayList<ma> arrayList = naVar.y;
                objArr[1] = Integer.valueOf(arrayList != null ? arrayList.size() : 0);
                X.a("crashcount:%d sz:%d", objArr);
            }
            if (crashDetailBean.w != null) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                try {
                    naVar.y.add(new ma((byte) 1, "log.txt", crashDetailBean.w.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                    naVar.y = null;
                }
            }
            if (crashDetailBean.x != null) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                try {
                    naVar.y.add(new ma((byte) 1, "jniLog.txt", crashDetailBean.x.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                    naVar.y = null;
                }
            }
            if (!ca.b(crashDetailBean.W)) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                try {
                    maVar = new ma((byte) 1, "crashInfos.txt", crashDetailBean.W.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    maVar = null;
                }
                if (maVar != null) {
                    X.a("attach crash infos", new Object[0]);
                    naVar.y.add(maVar);
                }
            }
            if (crashDetailBean.X != null) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                ma maVarA3 = a("backupRecord.zip", context, crashDetailBean.X);
                if (maVarA3 != null) {
                    X.a("attach backup record", new Object[0]);
                    naVar.y.add(maVarA3);
                }
            }
            byte[] bArr = crashDetailBean.y;
            if (bArr != null && bArr.length > 0) {
                ma maVar2 = new ma((byte) 2, "buglylog.zip", bArr);
                X.a("attach user log", new Object[0]);
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                naVar.y.add(maVar2);
            }
            if (crashDetailBean.f4130b == 3) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                X.a("crashBean.anrMessages:%s", crashDetailBean.Q);
                Map<String, String> map2 = crashDetailBean.Q;
                if (map2 != null && map2.containsKey("BUGLY_CR_01")) {
                    try {
                        if (!TextUtils.isEmpty(crashDetailBean.Q.get("BUGLY_CR_01"))) {
                            naVar.y.add(new ma((byte) 1, "anrMessage.txt", crashDetailBean.Q.get("BUGLY_CR_01").getBytes("utf-8")));
                            X.a("attach anr message", new Object[0]);
                        }
                    } catch (UnsupportedEncodingException e6) {
                        e6.printStackTrace();
                        naVar.y = null;
                    }
                    crashDetailBean.Q.remove("BUGLY_CR_01");
                }
                if (crashDetailBean.v != null && NativeCrashHandler.getInstance().isEnableCatchAnrTrace() && (maVarA2 = a("trace.zip", context, crashDetailBean.v)) != null) {
                    X.a("attach traces", new Object[0]);
                    naVar.y.add(maVarA2);
                }
            }
            if (crashDetailBean.f4130b == 1) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                String str2 = crashDetailBean.v;
                if (str2 != null && (maVarA = a("tomb.zip", context, str2)) != null) {
                    X.a("attach tombs", new Object[0]);
                    naVar.y.add(maVarA);
                }
            }
            List<String> list = aVar.na;
            if (list != null && !list.isEmpty()) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = aVar.na.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                }
                try {
                    naVar.y.add(new ma((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                    X.a("attach pageTracingList", new Object[0]);
                } catch (UnsupportedEncodingException e7) {
                    e7.printStackTrace();
                }
            }
            byte[] bArr2 = crashDetailBean.V;
            if (bArr2 != null && bArr2.length > 0) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                naVar.y.add(new ma((byte) 1, "userExtraByteData", crashDetailBean.V));
                X.a("attach extraData", new Object[0]);
            }
            HashMap map3 = new HashMap();
            naVar.z = map3;
            StringBuilder sbR = c.a.a.a.a.r("");
            sbR.append(crashDetailBean.C);
            map3.put("A9", sbR.toString());
            Map<String, String> map4 = naVar.z;
            StringBuilder sbR2 = c.a.a.a.a.r("");
            sbR2.append(crashDetailBean.D);
            map4.put("A11", sbR2.toString());
            Map<String, String> map5 = naVar.z;
            StringBuilder sbR3 = c.a.a.a.a.r("");
            sbR3.append(crashDetailBean.E);
            map5.put("A10", sbR3.toString());
            Map<String, String> map6 = naVar.z;
            StringBuilder sbR4 = c.a.a.a.a.r("");
            sbR4.append(crashDetailBean.f4134f);
            map6.put("A23", sbR4.toString());
            Map<String, String> map7 = naVar.z;
            StringBuilder sbR5 = c.a.a.a.a.r("");
            sbR5.append(aVar.n);
            map7.put("A7", sbR5.toString());
            Map<String, String> map8 = naVar.z;
            StringBuilder sbR6 = c.a.a.a.a.r("");
            sbR6.append(aVar.j());
            map8.put("A6", sbR6.toString());
            Map<String, String> map9 = naVar.z;
            StringBuilder sbR7 = c.a.a.a.a.r("");
            sbR7.append(aVar.k());
            map9.put("A5", sbR7.toString());
            Map<String, String> map10 = naVar.z;
            StringBuilder sbR8 = c.a.a.a.a.r("");
            sbR8.append(aVar.l());
            map10.put("A22", sbR8.toString());
            Map<String, String> map11 = naVar.z;
            StringBuilder sbR9 = c.a.a.a.a.r("");
            sbR9.append(crashDetailBean.G);
            map11.put("A2", sbR9.toString());
            Map<String, String> map12 = naVar.z;
            StringBuilder sbR10 = c.a.a.a.a.r("");
            sbR10.append(crashDetailBean.F);
            map12.put("A1", sbR10.toString());
            Map<String, String> map13 = naVar.z;
            StringBuilder sbR11 = c.a.a.a.a.r("");
            sbR11.append(aVar.p);
            map13.put("A24", sbR11.toString());
            Map<String, String> map14 = naVar.z;
            StringBuilder sbR12 = c.a.a.a.a.r("");
            sbR12.append(crashDetailBean.H);
            map14.put("A17", sbR12.toString());
            Map<String, String> map15 = naVar.z;
            StringBuilder sbR13 = c.a.a.a.a.r("");
            sbR13.append(aVar.l());
            map15.put("A25", sbR13.toString());
            Map<String, String> map16 = naVar.z;
            StringBuilder sbR14 = c.a.a.a.a.r("");
            sbR14.append(aVar.i());
            map16.put("A15", sbR14.toString());
            Map<String, String> map17 = naVar.z;
            StringBuilder sbR15 = c.a.a.a.a.r("");
            sbR15.append(aVar.n());
            map17.put("A13", sbR15.toString());
            Map<String, String> map18 = naVar.z;
            StringBuilder sbR16 = c.a.a.a.a.r("");
            sbR16.append(crashDetailBean.A);
            map18.put("A34", sbR16.toString());
            if (aVar.ea != null) {
                Map<String, String> map19 = naVar.z;
                StringBuilder sbR17 = c.a.a.a.a.r("");
                sbR17.append(aVar.ea);
                map19.put("productIdentify", sbR17.toString());
            }
            try {
                naVar.z.put("A26", "" + URLEncoder.encode(crashDetailBean.I, "utf-8"));
            } catch (UnsupportedEncodingException e8) {
                e8.printStackTrace();
            }
            if (crashDetailBean.f4130b == 1) {
                Map<String, String> map20 = naVar.z;
                StringBuilder sbR18 = c.a.a.a.a.r("");
                sbR18.append(crashDetailBean.L);
                map20.put("A27", sbR18.toString());
                Map<String, String> map21 = naVar.z;
                StringBuilder sbR19 = c.a.a.a.a.r("");
                sbR19.append(crashDetailBean.K);
                map21.put("A28", sbR19.toString());
                Map<String, String> map22 = naVar.z;
                StringBuilder sbR20 = c.a.a.a.a.r("");
                sbR20.append(crashDetailBean.f4139k);
                map22.put("A29", sbR20.toString());
            }
            Map<String, String> map23 = naVar.z;
            StringBuilder sbR21 = c.a.a.a.a.r("");
            sbR21.append(crashDetailBean.M);
            map23.put("A30", sbR21.toString());
            Map<String, String> map24 = naVar.z;
            StringBuilder sbR22 = c.a.a.a.a.r("");
            sbR22.append(crashDetailBean.N);
            map24.put("A18", sbR22.toString());
            Map<String, String> map25 = naVar.z;
            StringBuilder sbR23 = c.a.a.a.a.r("");
            sbR23.append(!crashDetailBean.O);
            map25.put("A36", sbR23.toString());
            Map<String, String> map26 = naVar.z;
            StringBuilder sbR24 = c.a.a.a.a.r("");
            sbR24.append(aVar.X);
            map26.put("F02", sbR24.toString());
            Map<String, String> map27 = naVar.z;
            StringBuilder sbR25 = c.a.a.a.a.r("");
            sbR25.append(aVar.Y);
            map27.put("F03", sbR25.toString());
            Map<String, String> map28 = naVar.z;
            StringBuilder sbR26 = c.a.a.a.a.r("");
            sbR26.append(aVar.u());
            map28.put("F04", sbR26.toString());
            Map<String, String> map29 = naVar.z;
            StringBuilder sbR27 = c.a.a.a.a.r("");
            sbR27.append(aVar.Z);
            map29.put("F05", sbR27.toString());
            Map<String, String> map30 = naVar.z;
            StringBuilder sbR28 = c.a.a.a.a.r("");
            sbR28.append(aVar.W);
            map30.put("F06", sbR28.toString());
            Map<String, String> map31 = naVar.z;
            StringBuilder sbR29 = c.a.a.a.a.r("");
            sbR29.append(aVar.ca);
            map31.put("F08", sbR29.toString());
            Map<String, String> map32 = naVar.z;
            StringBuilder sbR30 = c.a.a.a.a.r("");
            sbR30.append(aVar.da);
            map32.put("F09", sbR30.toString());
            Map<String, String> map33 = naVar.z;
            StringBuilder sbR31 = c.a.a.a.a.r("");
            sbR31.append(aVar.aa);
            map33.put("F10", sbR31.toString());
            if (crashDetailBean.R >= 0) {
                Map<String, String> map34 = naVar.z;
                StringBuilder sbR32 = c.a.a.a.a.r("");
                sbR32.append(crashDetailBean.R);
                map34.put("C01", sbR32.toString());
            }
            if (crashDetailBean.S >= 0) {
                Map<String, String> map35 = naVar.z;
                StringBuilder sbR33 = c.a.a.a.a.r("");
                sbR33.append(crashDetailBean.S);
                map35.put("C02", sbR33.toString());
            }
            Map<String, String> map36 = crashDetailBean.T;
            if (map36 != null && map36.size() > 0) {
                for (Map.Entry<String, String> entry2 : crashDetailBean.T.entrySet()) {
                    Map<String, String> map37 = naVar.z;
                    StringBuilder sbR34 = c.a.a.a.a.r("C03_");
                    sbR34.append(entry2.getKey());
                    map37.put(sbR34.toString(), entry2.getValue());
                }
            }
            Map<String, String> map38 = crashDetailBean.U;
            if (map38 != null && map38.size() > 0) {
                for (Map.Entry<String, String> entry3 : crashDetailBean.U.entrySet()) {
                    Map<String, String> map39 = naVar.z;
                    StringBuilder sbR35 = c.a.a.a.a.r("C04_");
                    sbR35.append(entry3.getKey());
                    map39.put(sbR35.toString(), entry3.getValue());
                }
            }
            naVar.A = null;
            Map<String, String> map40 = crashDetailBean.P;
            if (map40 != null && map40.size() > 0) {
                Map<String, String> map41 = crashDetailBean.P;
                naVar.A = map41;
                X.c("setted message size %d", Integer.valueOf(map41.size()));
            }
            Object[] objArr2 = new Object[12];
            objArr2[0] = crashDetailBean.n;
            objArr2[1] = crashDetailBean.f4131c;
            objArr2[2] = aVar.u();
            objArr2[3] = Long.valueOf((crashDetailBean.r - crashDetailBean.N) / 1000);
            objArr2[4] = Boolean.valueOf(crashDetailBean.f4139k);
            objArr2[5] = Boolean.valueOf(crashDetailBean.O);
            objArr2[6] = Boolean.valueOf(crashDetailBean.f4138j);
            objArr2[7] = Boolean.valueOf(crashDetailBean.f4130b == 1);
            objArr2[8] = Integer.valueOf(crashDetailBean.t);
            objArr2[9] = crashDetailBean.s;
            objArr2[10] = Boolean.valueOf(crashDetailBean.f4132d);
            objArr2[11] = Integer.valueOf(naVar.z.size());
            X.a("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
            return naVar;
        }
        X.e("enExp args == null", new Object[0]);
        return null;
    }

    public static oa a(Context context, List<CrashDetailBean> list, com.tencent.bugly.crashreport.common.info.a aVar) {
        if (context != null && list != null && list.size() != 0 && aVar != null) {
            oa oaVar = new oa();
            oaVar.f4407b = new ArrayList<>();
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                oaVar.f4407b.add(a(context, it.next(), aVar));
            }
            return oaVar;
        }
        X.e("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    public static ma a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            X.a("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!ca.a(file, file2, 5000)) {
                X.e("zip fail!", new Object[0]);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                        byteArrayOutputStream.flush();
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    X.a("read bytes :%d", Integer.valueOf(byteArray.length));
                    ma maVar = new ma((byte) 2, file2.getName(), byteArray);
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        if (!X.b(e2)) {
                            e2.printStackTrace();
                        }
                    }
                    if (file2.exists()) {
                        X.a("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return maVar;
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                if (!X.b(e3)) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                        if (file2.exists()) {
                            X.a("del tmp", new Object[0]);
                            file2.delete();
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                if (!X.b(e4)) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        if (file2.exists()) {
                            X.a("del tmp", new Object[0]);
                            file2.delete();
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } else {
            X.e("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String string;
        com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
        if (aVarM == null) {
            return;
        }
        X.b("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        X.b("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        X.b("# PKG NAME: %s", aVarM.f4098g);
        X.b("# APP VER: %s", aVarM.E);
        X.b("# SDK VER: %s", aVarM.f4103l);
        X.b("# LAUNCH TIME: %s", ca.a(new Date(com.tencent.bugly.crashreport.common.info.a.m().f4095d)));
        X.b("# CRASH TYPE: %s", str);
        X.b("# CRASH TIME: %s", str2);
        X.b("# CRASH PROCESS: %s", str3);
        X.b("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            X.b("# REPORT ID: %s", crashDetailBean.f4131c);
            Object[] objArr = new Object[2];
            objArr[0] = aVarM.o;
            objArr[1] = aVarM.n().booleanValue() ? "ROOTED" : "UNROOT";
            X.b("# CRASH DEVICE: %s %s", objArr);
            X.b("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            X.b("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!ca.b(crashDetailBean.L)) {
                X.b("# EXCEPTION FIRED BY %s %s", crashDetailBean.L, crashDetailBean.K);
            } else if (crashDetailBean.f4130b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.Q == null) {
                    string = "null";
                } else {
                    StringBuilder sbR = c.a.a.a.a.r("");
                    sbR.append(crashDetailBean.Q.get("BUGLY_CR_01"));
                    string = sbR.toString();
                }
                objArr2[0] = string;
                X.b("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!ca.b(str5)) {
            X.b("# CRASH STACK: ", new Object[0]);
            X.b(str5, new Object[0]);
        }
        X.b("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }
}
