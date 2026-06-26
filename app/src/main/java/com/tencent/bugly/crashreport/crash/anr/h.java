package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.camera.core.FocusMeteringAction;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import com.tencent.bugly.proguard.da;
import com.tencent.bugly.proguard.ea;
import com.tencent.bugly.proguard.fa;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class h implements fa {
    private static h a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f4154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f4155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final W f4156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.c f4157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.crash.e f4159i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private FileObserver f4160j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ea f4162l;
    private int m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f4152b = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4153c = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f4161k = true;
    private ActivityManager.ProcessErrorStateInfo n = new ActivityManager.ProcessErrorStateInfo();

    private h(Context context, com.tencent.bugly.crashreport.common.strategy.c cVar, com.tencent.bugly.crashreport.common.info.a aVar, W w, J j2, com.tencent.bugly.crashreport.crash.e eVar, BuglyStrategy.a aVar2) {
        this.f4154d = ca.a(context);
        this.f4158h = context.getDir("bugly", 0).getAbsolutePath();
        this.f4155e = aVar;
        this.f4156f = w;
        this.f4157g = cVar;
        this.f4159i = eVar;
    }

    private boolean h() {
        ea eaVar = this.f4162l;
        if (eaVar != null && eaVar.isAlive()) {
            return false;
        }
        ea eaVar2 = new ea();
        this.f4162l = eaVar2;
        StringBuilder sbR = c.a.a.a.a.r("Bugly-ThreadMonitor");
        int i2 = this.m;
        this.m = i2 + 1;
        sbR.append(i2);
        eaVar2.setName(sbR.toString());
        this.f4162l.a();
        this.f4162l.a(this);
        boolean zC = this.f4162l.c();
        this.f4156f.a(new e(this));
        return zC;
    }

    private synchronized void i() {
        if (a()) {
            X.e("start when started!", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.f4158h)) {
            return;
        }
        h();
        f fVar = new f(this, this.f4158h, 256);
        this.f4160j = fVar;
        try {
            fVar.startWatching();
            X.c("startWatchingPrivateAnrDir! dumFilePath is %s", this.f4158h);
            this.f4156f.a(new g(this));
        } catch (Throwable th) {
            this.f4160j = null;
            X.e("startWatchingPrivateAnrDir failed!", new Object[0]);
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
    }

    private boolean j() {
        ea eaVar = this.f4162l;
        if (eaVar == null) {
            return false;
        }
        boolean zD = eaVar.d();
        this.f4162l.b();
        this.f4162l.b(this);
        this.f4162l = null;
        return zD;
    }

    private synchronized void k() {
        if (!a()) {
            X.e("close when closed!", new Object[0]);
            return;
        }
        j();
        X.c("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.f4160j.stopWatching();
            this.f4160j = null;
            X.e("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            X.e("stop anr monitor failed!", new Object[0]);
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
    }

    private File l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = new File(this.f4158h);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    return null;
                }
                int i2 = 24;
                int length = fileArrListFiles.length;
                int i3 = 0;
                while (i3 < length) {
                    File file2 = fileArrListFiles[i3];
                    String name = file2.getName();
                    if (name.startsWith("jni_mannual_bugly_trace_")) {
                        try {
                            int iIndexOf = name.indexOf(".txt");
                            if (iIndexOf > 0) {
                                long j2 = Long.parseLong(name.substring(i2, iIndexOf));
                                long j3 = (jCurrentTimeMillis - j2) / 1000;
                                X.a("current time %d trace time is %d s", Long.valueOf(jCurrentTimeMillis), Long.valueOf(j2));
                                X.a("current time minus trace time is %d s", Long.valueOf(j3));
                                if (j3 < 30) {
                                    return file2;
                                }
                            } else {
                                continue;
                            }
                        } catch (Throwable unused) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Trace file that has invalid format: ");
                            sb.append(name);
                            X.a(sb.toString(), new Object[0]);
                        }
                    }
                    i3++;
                    i2 = 24;
                }
            } catch (Throwable th) {
                X.b(th);
                return null;
            }
        }
        return null;
    }

    public synchronized boolean c() {
        return this.f4161k;
    }

    public void d() {
        boolean z;
        int iIndexOf;
        long jB = ca.b() - com.tencent.bugly.crashreport.crash.h.f4189g;
        File file = new File(this.f4158h);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    return;
                }
                int i2 = 0;
                int i3 = 0;
                for (File file2 : fileArrListFiles) {
                    String name = file2.getName();
                    if (name.startsWith("bugly_trace_") || name.startsWith("bugly_trace_")) {
                        i3 = 12;
                        z = true;
                    } else {
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Number Trace file : ");
                    sb.append(name);
                    X.a(sb.toString(), new Object[0]);
                    if (z) {
                        try {
                            iIndexOf = name.indexOf(".txt");
                        } catch (Throwable unused) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Trace file that has invalid format: ");
                            sb2.append(name);
                            X.a(sb2.toString(), new Object[0]);
                        }
                        if (iIndexOf <= 0 || Long.parseLong(name.substring(i3, iIndexOf)) < jB) {
                            if (file2.delete()) {
                                i2++;
                            }
                        }
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Number of overdue trace files that has deleted: ");
                sb3.append(i2);
                X.a(sb3.toString(), new Object[0]);
            } catch (Throwable th) {
                X.b(th);
            }
        }
    }

    public synchronized void e() {
        if (a()) {
            X.e("start when started!", new Object[0]);
            return;
        }
        c cVar = new c(this, "/data/anr/", 8);
        this.f4160j = cVar;
        try {
            cVar.startWatching();
            X.c("start anr monitor!", new Object[0]);
            this.f4156f.a(new d(this));
        } catch (Throwable th) {
            this.f4160j = null;
            X.e("start anr monitor failed!", new Object[0]);
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void f() {
        if (!a()) {
            X.e("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f4160j.stopWatching();
            this.f4160j = null;
            X.e("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            X.e("stop anr monitor failed!", new Object[0]);
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
    }

    public void g() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 30) {
                return;
            }
            try {
                X.c("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                ca.c(FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION);
                i2 = i3;
            } catch (Throwable th) {
                if (X.b(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
    }

    private synchronized void c(boolean z) {
        if (this.f4161k != z) {
            X.c("user change anr %b", Boolean.valueOf(z));
            this.f4161k = z;
        }
    }

    public boolean b() {
        return this.f4152b.get() != 0;
    }

    public static h a(Context context, com.tencent.bugly.crashreport.common.strategy.c cVar, com.tencent.bugly.crashreport.common.info.a aVar, W w, J j2, com.tencent.bugly.crashreport.crash.e eVar, BuglyStrategy.a aVar2) {
        if (a == null) {
            a = new h(context, cVar, aVar, w, j2, eVar, aVar2);
        }
        return a;
    }

    public void b(boolean z) {
        c(z);
        boolean zC = c();
        com.tencent.bugly.crashreport.common.strategy.c cVarB = com.tencent.bugly.crashreport.common.strategy.c.b();
        if (cVarB != null) {
            zC = zC && cVarB.c().f4112f;
        }
        if (zC != a()) {
            X.c("anr changed to %b", Boolean.valueOf(zC));
            a(zC);
        }
    }

    public ActivityManager.ProcessErrorStateInfo a(Context context, long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        try {
            X.a("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            long j3 = j2 / 500;
            int i2 = 0;
            while (true) {
                X.a("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            X.a("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                ca.c(500L);
                int i3 = i2 + 1;
                if (i2 >= j3) {
                    X.a("end!", new Object[0]);
                    return null;
                }
                i2 = i3;
            }
        } catch (Exception e2) {
            X.a(e2);
            return null;
        } catch (OutOfMemoryError e3) {
            this.n.pid = Process.myPid();
            ActivityManager.ProcessErrorStateInfo processErrorStateInfo2 = this.n;
            StringBuilder sbR = c.a.a.a.a.r("bugly sdk waitForAnrProcessStateChanged encount error:");
            sbR.append(e3.getMessage());
            processErrorStateInfo2.shortMsg = sbR.toString();
            return this.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        return str.startsWith("bugly_trace_");
    }

    public a a(Context context, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        a aVar = new a();
        aVar.f4146c = j2;
        aVar.a = processErrorStateInfo != null ? processErrorStateInfo.processName : AppInfo.a(context, Process.myPid());
        aVar.f4149f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.f4148e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.f4145b = map;
        Thread thread = Looper.getMainLooper().getThread();
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.startsWith(thread.getName())) {
                    aVar.f4150g = map.get(next);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(aVar.f4150g)) {
            aVar.f4150g = "main stack is null , some error may be encountered.";
        }
        Object[] objArr = new Object[7];
        objArr[0] = Long.valueOf(aVar.f4146c);
        objArr[1] = aVar.f4147d;
        objArr[2] = aVar.a;
        objArr[3] = aVar.f4150g;
        objArr[4] = aVar.f4149f;
        objArr[5] = aVar.f4148e;
        Map<String, String> map2 = aVar.f4145b;
        objArr[6] = Integer.valueOf(map2 != null ? map2.size() : 0);
        X.a("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        return aVar;
    }

    public CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.F = this.f4155e.v();
            crashDetailBean.G = this.f4155e.w();
            crashDetailBean.H = this.f4155e.x();
            if (!com.tencent.bugly.crashreport.common.info.b.i(this.f4154d)) {
                crashDetailBean.w = ca.a(this.f4154d, com.tencent.bugly.crashreport.crash.h.f4187e, com.tencent.bugly.crashreport.crash.h.f4190h);
            }
            crashDetailBean.f4130b = 3;
            crashDetailBean.f4133e = this.f4155e.l();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f4155e;
            crashDetailBean.f4134f = aVar2.E;
            crashDetailBean.f4135g = aVar2.i();
            crashDetailBean.m = this.f4155e.y();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f4149f;
            crashDetailBean.q = aVar.f4150g;
            HashMap map = new HashMap();
            crashDetailBean.Q = map;
            map.put("BUGLY_CR_01", aVar.f4148e);
            String str = crashDetailBean.q;
            int iIndexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.p = iIndexOf > 0 ? crashDetailBean.q.substring(0, iIndexOf) : "GET_FAIL";
            crashDetailBean.r = aVar.f4146c;
            String str2 = crashDetailBean.q;
            if (str2 != null) {
                crashDetailBean.u = ca.c(str2.getBytes());
            }
            crashDetailBean.z = aVar.f4145b;
            crashDetailBean.A = aVar.a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.f4155e.r();
            crashDetailBean.f4136h = this.f4155e.p();
            crashDetailBean.f4137i = this.f4155e.o();
            crashDetailBean.v = aVar.f4147d;
            com.tencent.bugly.crashreport.common.info.a aVar3 = this.f4155e;
            crashDetailBean.M = aVar3.M;
            crashDetailBean.N = aVar3.f4095d;
            crashDetailBean.O = aVar3.C();
            if (!com.tencent.bugly.crashreport.common.info.b.i(this.f4154d)) {
                this.f4159i.d(crashDetailBean);
            }
            crashDetailBean.R = this.f4155e.A();
            crashDetailBean.S = this.f4155e.t();
            crashDetailBean.T = this.f4155e.h();
            crashDetailBean.U = this.f4155e.g();
            crashDetailBean.y = ba.b();
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    public boolean a(String str, String str2, String str3) throws Throwable {
        Map<String, String[]> map;
        BufferedWriter bufferedWriter;
        TraceFileHelper.a targetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (targetDumpInfo != null && (map = targetDumpInfo.f4144d) != null && map.size() > 0) {
            File file = new File(str2);
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                if (file.exists() && file.canWrite()) {
                    BufferedWriter bufferedWriter2 = null;
                    try {
                        try {
                            bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        String[] strArr = targetDumpInfo.f4144d.get("main");
                        int i2 = 3;
                        if (strArr != null && strArr.length >= 3) {
                            String str4 = strArr[0];
                            String str5 = strArr[1];
                            String str6 = strArr[2];
                            StringBuilder sb = new StringBuilder();
                            sb.append("\"main\" tid=");
                            sb.append(str6);
                            sb.append(" :\n");
                            sb.append(str4);
                            sb.append("\n");
                            sb.append(str5);
                            sb.append("\n\n");
                            bufferedWriter.write(sb.toString());
                            bufferedWriter.flush();
                        }
                        for (Map.Entry<String, String[]> entry : targetDumpInfo.f4144d.entrySet()) {
                            if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= i2) {
                                String str7 = entry.getValue()[0];
                                String str8 = entry.getValue()[1];
                                String str9 = entry.getValue()[2];
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("\"");
                                sb2.append(entry.getKey());
                                sb2.append("\" tid=");
                                sb2.append(str9);
                                sb2.append(" :\n");
                                sb2.append(str7);
                                sb2.append("\n");
                                sb2.append(str8);
                                sb2.append("\n\n");
                                bufferedWriter.write(sb2.toString());
                                bufferedWriter.flush();
                                i2 = 3;
                            }
                        }
                        try {
                            bufferedWriter.close();
                        } catch (IOException e3) {
                            if (!X.b(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        return true;
                    } catch (IOException e4) {
                        e = e4;
                        bufferedWriter2 = bufferedWriter;
                        if (!X.b(e)) {
                            e.printStackTrace();
                        }
                        X.b("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e5) {
                                if (!X.b(e5)) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter2 = bufferedWriter;
                        BufferedWriter bufferedWriter3 = bufferedWriter2;
                        Throwable th3 = th;
                        if (bufferedWriter3 != null) {
                            try {
                                bufferedWriter3.close();
                                throw th3;
                            } catch (IOException e6) {
                                if (!X.b(e6)) {
                                    e6.printStackTrace();
                                    throw th3;
                                }
                                throw th3;
                            }
                        }
                        throw th3;
                    }
                }
                X.b("backup file create fail %s", str2);
                return false;
            } catch (Exception e7) {
                if (!X.b(e7)) {
                    e7.printStackTrace();
                }
                X.b("backup file create error! %s  %s", e7.getClass().getName() + ":" + e7.getMessage(), str2);
                return false;
            }
        }
        X.b("not found trace dump for %s", str3);
        return false;
    }

    public boolean a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        a aVarA = a(context, processErrorStateInfo, j2, map);
        X.c("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean crashDetailBeanA = a(aVarA);
        if (crashDetailBeanA == null) {
            X.b("pack anr fail!", new Object[0]);
            return false;
        }
        com.tencent.bugly.crashreport.crash.h.g().a(crashDetailBeanA);
        if (crashDetailBeanA.a >= 0) {
            X.c("backup anr record success!", new Object[0]);
        } else {
            X.e("backup anr record fail!", new Object[0]);
        }
        if (str != null && new File(str).exists()) {
            aVarA.f4147d = new File(this.f4158h, "bugly_trace_" + j2 + ".txt").getAbsolutePath();
            this.f4152b.set(3);
            if (a(str, aVarA.f4147d, aVarA.a)) {
                X.c("backup trace success", new Object[0]);
            }
        } else {
            File fileL = l();
            X.c("traceFile is %s", fileL);
            if (fileL != null) {
                crashDetailBeanA.v = fileL.getAbsolutePath();
            }
        }
        com.tencent.bugly.crashreport.crash.e.a("ANR", ca.a(), aVarA.a, "main", aVarA.f4150g, crashDetailBeanA);
        if (!this.f4159i.c(crashDetailBeanA)) {
            this.f4159i.a(crashDetailBeanA, 3000L, true);
        }
        this.f4159i.e(crashDetailBeanA);
        return true;
    }

    public final void a(String str) {
        synchronized (this) {
            if (this.f4152b.get() != 0) {
                X.a("trace started return ", new Object[0]);
                return;
            }
            this.f4152b.set(1);
            try {
                X.a("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.a firstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long jCurrentTimeMillis = firstDumpInfo != null ? firstDumpInfo.f4143c : -1L;
                if (jCurrentTimeMillis == -1) {
                    X.e("trace dump fail could not get time!", new Object[0]);
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
                long j2 = jCurrentTimeMillis;
                if (Math.abs(j2 - this.f4153c) < 10000) {
                    X.e("should not process ANR too Fre in %d", 10000);
                    return;
                }
                this.f4153c = j2;
                this.f4152b.set(1);
                try {
                    Map<String, String> mapA = ca.a(com.tencent.bugly.crashreport.crash.h.f4188f, false);
                    if (mapA != null && mapA.size() > 0) {
                        ActivityManager.ProcessErrorStateInfo processErrorStateInfoA = a(this.f4154d, 20000L);
                        this.n = processErrorStateInfoA;
                        if (processErrorStateInfoA == null) {
                            X.a("proc state is unvisiable!", new Object[0]);
                            return;
                        } else if (processErrorStateInfoA.pid != Process.myPid()) {
                            X.a("not mind proc!", this.n.processName);
                            return;
                        } else {
                            X.c("found visiable anr , start to process!", new Object[0]);
                            a(this.f4154d, str, this.n, j2, mapA);
                        }
                    }
                    X.e("can't get all thread skip this anr", new Object[0]);
                } catch (Throwable th) {
                    X.b(th);
                    X.b("get all thread stack fail!", new Object[0]);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public synchronized boolean a() {
        return this.f4160j != null;
    }

    public synchronized void a(boolean z) {
        if (z) {
            i();
        } else {
            k();
        }
    }

    public synchronized void a(StrategyBean strategyBean) {
        X.e("customer decides whether to open or close.", new Object[0]);
    }

    @Override // com.tencent.bugly.proguard.fa
    public boolean a(da daVar) {
        Map<String, String> mapA;
        HashMap map = new HashMap();
        if (daVar.b().equals(Looper.getMainLooper())) {
            try {
                mapA = ca.a(200000, false);
            } catch (Throwable th) {
                X.a(th);
                map.put("main", th.getMessage());
                mapA = map;
            }
            Map<String, String> map2 = mapA;
            X.a("onThreadBlock found visiable anr , start to process!", new Object[0]);
            String strD = com.tencent.bugly.crashreport.common.info.b.d(this.f4154d);
            if (!TextUtils.isEmpty(strD) && (strD.contains("XiaoMi") || strD.contains("samsung"))) {
                this.n = a(this.f4154d, 20000L);
            }
            a(this.f4154d, "", this.n, System.currentTimeMillis(), map2);
        } else {
            X.a("anr handler onThreadBlock only care main thread ,current thread is: %s", daVar.c());
        }
        return true;
    }
}
