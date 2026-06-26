package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.camera.core.FocusMeteringAction;
import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4073d;

    /* JADX INFO: compiled from: BUGLY */
    public class a implements Runnable {
        private boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private UserInfoBean f4074b;

        public a(UserInfoBean userInfoBean, boolean z) {
            this.f4074b = userInfoBean;
            this.a = z;
        }

        private void a(UserInfoBean userInfoBean) {
            com.tencent.bugly.crashreport.common.info.a aVarM;
            if (userInfoBean == null || (aVarM = com.tencent.bugly.crashreport.common.info.a.m()) == null) {
                return;
            }
            userInfoBean.f4067j = aVarM.u();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                UserInfoBean userInfoBean = this.f4074b;
                if (userInfoBean != null) {
                    a(userInfoBean);
                    X.a("[UserInfo] Record user info.", new Object[0]);
                    c.this.a(this.f4074b, false);
                }
                if (this.a) {
                    c.this.b();
                }
            } catch (Throwable th) {
                if (X.b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis < c.this.f4071b) {
                W.c().a(c.this.new b(), (c.this.f4071b - jCurrentTimeMillis) + FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION);
            } else {
                c.this.a(3, false, 0L);
                c.this.a();
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.biz.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BUGLY */
    public class RunnableC0122c implements Runnable {
        private long a;

        public RunnableC0122c(long j2) {
            this.a = 21600000L;
            this.a = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b();
            c.this.b(this.a);
        }
    }

    public c(Context context, boolean z) {
        this.f4073d = true;
        this.a = context;
        this.f4073d = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ee A[Catch: all -> 0x016f, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fa, B:72:0x0112, B:74:0x0118, B:77:0x0121, B:79:0x0127, B:82:0x0130, B:84:0x013a, B:87:0x0143, B:91:0x0161, B:94:0x0166, B:59:0x00e2), top: B:100:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0118 A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fa, B:72:0x0112, B:74:0x0118, B:77:0x0121, B:79:0x0127, B:82:0x0130, B:84:0x013a, B:87:0x0143, B:91:0x0161, B:94:0x0166, B:59:0x00e2), top: B:100:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0121 A[Catch: all -> 0x016f, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fa, B:72:0x0112, B:74:0x0118, B:77:0x0121, B:79:0x0127, B:82:0x0130, B:84:0x013a, B:87:0x0143, B:91:0x0161, B:94:0x0166, B:59:0x00e2), top: B:100:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void c() {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.c.c():void");
    }

    public void b(long j2) {
        W.c().a(new RunnableC0122c(j2), j2);
    }

    private static UserInfoBean a(Context context, int i2) {
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f4059b = i2;
        userInfoBean.f4060c = aVarA.f4099h;
        userInfoBean.f4061d = aVarA.y();
        userInfoBean.f4062e = System.currentTimeMillis();
        userInfoBean.f4063f = -1L;
        userInfoBean.n = aVarA.E;
        userInfoBean.o = i2 != 1 ? 0 : 1;
        userInfoBean.f4069l = aVarA.C();
        userInfoBean.m = aVarA.W;
        userInfoBean.f4064g = aVarA.X;
        userInfoBean.f4065h = aVarA.Y;
        userInfoBean.f4066i = aVarA.Z;
        userInfoBean.f4068k = aVarA.aa;
        userInfoBean.r = aVarA.h();
        userInfoBean.s = aVarA.g();
        userInfoBean.p = aVarA.A();
        userInfoBean.q = aVarA.t();
        return userInfoBean;
    }

    public void b() {
        W wC = W.c();
        if (wC != null) {
            wC.a(new com.tencent.bugly.crashreport.biz.b(this));
        }
    }

    public void a(int i2, boolean z, long j2) {
        com.tencent.bugly.crashreport.common.strategy.c cVarB = com.tencent.bugly.crashreport.common.strategy.c.b();
        if (cVarB != null && !cVarB.c().f4113g && i2 != 1 && i2 != 3) {
            X.b("UserInfo is disable", new Object[0]);
            return;
        }
        if (i2 == 1 || i2 == 3) {
            this.f4072c++;
        }
        W.c().a(new a(a(this.a, i2), z), j2);
    }

    public void a(long j2) {
        W.c().a(new a(null, true), j2);
    }

    public void a() {
        this.f4071b = ca.b() + 86400000;
        W.c().a(new b(), (this.f4071b - System.currentTimeMillis()) + FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> listA;
        if (userInfoBean == null) {
            return;
        }
        if (!z && userInfoBean.f4059b != 1 && (listA = a(com.tencent.bugly.crashreport.common.info.a.a(this.a).f4099h)) != null && listA.size() >= 20) {
            X.c("[UserInfo] There are too many user info in local: %d", Integer.valueOf(listA.size()));
            return;
        }
        long jA = J.a().a("t_ui", a(userInfoBean), (I) null, true);
        if (jA >= 0) {
            X.a("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(jA));
            userInfoBean.a = jA;
        }
    }

    public List<UserInfoBean> a(String str) {
        Throwable th;
        Cursor cursorA;
        String string;
        try {
            if (ca.b(str)) {
                string = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("_pc = '");
                sb.append(str);
                sb.append("'");
                string = sb.toString();
            }
            cursorA = J.a().a("t_ui", null, string, null, null, true);
            if (cursorA == null) {
                return null;
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursorA.moveToNext()) {
                    UserInfoBean userInfoBeanA = a(cursorA);
                    if (userInfoBeanA != null) {
                        arrayList.add(userInfoBeanA);
                    } else {
                        try {
                            long j2 = cursorA.getLong(cursorA.getColumnIndex("_id"));
                            sb2.append(" or ");
                            sb2.append("_id");
                            sb2.append(" = ");
                            sb2.append(j2);
                        } catch (Throwable unused) {
                            X.e("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String string2 = sb2.toString();
                if (string2.length() > 0) {
                    int iA = J.a().a("t_ui", string2.substring(4), (String[]) null, (I) null, true);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_ui";
                    objArr[1] = Integer.valueOf(iA);
                    X.e("[Database] deleted %s error data %d", objArr);
                }
                cursorA.close();
                return arrayList;
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

    public void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size() && i2 < 50; i2++) {
            UserInfoBean userInfoBean = list.get(i2);
            sb.append(" or ");
            sb.append("_id");
            sb.append(" = ");
            sb.append(userInfoBean.a);
        }
        String string = sb.toString();
        if (string.length() > 0) {
            string = string.substring(4);
        }
        String str = string;
        sb.setLength(0);
        try {
            int iA = J.a().a("t_ui", str, (String[]) null, (I) null, true);
            Object[] objArr = new Object[2];
            objArr[0] = "t_ui";
            objArr[1] = Integer.valueOf(iA);
            X.a("[Database] deleted %s data %d", objArr);
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = userInfoBean.a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f4062e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f4063f));
            contentValues.put(am.f4694e, Integer.valueOf(userInfoBean.f4059b));
            contentValues.put("_pc", userInfoBean.f4060c);
            contentValues.put("_dt", ca.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ca.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.a = j2;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
