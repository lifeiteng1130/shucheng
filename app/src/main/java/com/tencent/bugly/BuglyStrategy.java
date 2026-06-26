package com.tencent.bugly;

import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class BuglyStrategy {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f3948f;
    private a q;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3949g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3950h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3951i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3952j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Class<?> f3953k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3954l = true;
    private boolean m = true;
    private boolean n = true;
    private boolean o = true;
    private boolean p = false;
    public int r = 31;
    public boolean s = false;
    private boolean t = true;

    /* JADX INFO: compiled from: BUGLY */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 100000;

        public synchronized Map<String, String> onCrashHandleStart(int i2, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i2, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str;
        str = this.f3944b;
        if (str == null) {
            str = com.tencent.bugly.crashreport.common.info.a.m().I;
        }
        return str;
    }

    public synchronized String getAppPackageName() {
        String str;
        str = this.f3945c;
        if (str == null) {
            str = com.tencent.bugly.crashreport.common.info.a.m().f4098g;
        }
        return str;
    }

    public synchronized long getAppReportDelay() {
        return this.f3946d;
    }

    public synchronized String getAppVersion() {
        String str;
        str = this.a;
        if (str == null) {
            str = com.tencent.bugly.crashreport.common.info.a.m().E;
        }
        return str;
    }

    public synchronized int getCallBackType() {
        return this.r;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.s;
    }

    public synchronized a getCrashHandleCallback() {
        return this.q;
    }

    public synchronized String getDeviceID() {
        return this.f3948f;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f3947e;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f3953k;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f3954l;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f3950h;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f3951i;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f3949g;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f3952j;
    }

    public boolean isMerged() {
        return this.t;
    }

    public boolean isReplaceOldChannel() {
        return this.m;
    }

    public synchronized boolean isUploadProcess() {
        return this.n;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.o;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.p;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f3944b = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f3945c = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j2) {
        this.f3946d = j2;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.a = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.f3954l = z;
        return this;
    }

    public synchronized void setCallBackType(int i2) {
        this.r = i2;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.s = z;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.q = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f3948f = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f3950h = z;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z) {
        this.f3951i = z;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f3949g = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f3952j = z;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f3947e = str;
        return this;
    }

    public void setMerged(boolean z) {
        this.t = z;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.p = z;
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.m = z;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.n = z;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z) {
        this.o = z;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f3953k = cls;
        return this;
    }
}
