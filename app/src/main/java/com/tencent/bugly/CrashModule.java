package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.h;
import com.tencent.bugly.crashreport.crash.k;
import com.tencent.bugly.crashreport.crash.m;
import com.tencent.bugly.proguard.H;
import com.tencent.bugly.proguard.X;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class CrashModule extends a {
    public static final int MODULE_ID = 1004;
    private static int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CrashModule f3955b = new CrashModule();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BuglyStrategy.a f3957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3958e = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            com.tencent.bugly.crashreport.common.info.a.a(context).L = libBuglySOFilePath;
            X.c("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.f3957d = buglyStrategy.getCrashHandleCallback();
            X.c("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            long appReportDelay = buglyStrategy.getAppReportDelay();
            this.f3956c = appReportDelay;
            X.c("setted delay: %d", Long.valueOf(appReportDelay));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f3955b;
        crashModule.id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f3958e;
    }

    @Override // com.tencent.bugly.a
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        if (context != null) {
            if (!this.f3958e) {
                X.c("Initializing crash module.", new Object[0]);
                H hA = H.a();
                int i2 = a + 1;
                a = i2;
                hA.a(1004, i2);
                this.f3958e = true;
                CrashReport.setContext(context);
                a(context, buglyStrategy);
                h hVarA = h.a(1004, context, z, this.f3957d, (m) null, (String) null);
                hVarA.r();
                if (buglyStrategy != null) {
                    hVarA.a(buglyStrategy.getCallBackType());
                    hVarA.a(buglyStrategy.getCloseErrorCallback());
                    h.f4194l = buglyStrategy.isUploadSpotCrash();
                }
                if (buglyStrategy != null && buglyStrategy.isEnableCatchAnrTrace()) {
                    hVarA.q();
                }
                hVarA.a();
                if (buglyStrategy == null || buglyStrategy.isEnableNativeCrashMonitor()) {
                    hVarA.s();
                } else {
                    X.c("[crash] Closed native crash monitor!", new Object[0]);
                    hVarA.e();
                }
                if (buglyStrategy == null || buglyStrategy.isEnableANRCrashMonitor()) {
                    hVarA.p();
                } else {
                    X.c("[crash] Closed ANR monitor!", new Object[0]);
                    hVarA.c();
                }
                if (buglyStrategy != null) {
                    h.f4186d = buglyStrategy.isMerged();
                }
                hVarA.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                hVarA.u();
                k.a(context);
                BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
                buglyBroadcastReceiver.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                buglyBroadcastReceiver.register(context);
                H hA2 = H.a();
                int i3 = a - 1;
                a = i3;
                hA2.a(1004, i3);
            }
        }
    }

    @Override // com.tencent.bugly.a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        h hVarG;
        if (strategyBean == null || (hVarG = h.g()) == null) {
            return;
        }
        hVarG.a(strategyBean);
    }
}
