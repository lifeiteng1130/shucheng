package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class C0328v implements com.tencent.bugly.beta.download.c {
    public static C0328v a = new C0328v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<String, DownloadTask> f4463b = new ConcurrentHashMap<>(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f4464c;

    public C0328v() {
        this.f4464c = null;
        try {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactoryC0327u(this));
            this.f4464c = scheduledExecutorServiceNewScheduledThreadPool;
            if (scheduledExecutorServiceNewScheduledThreadPool.isShutdown()) {
                throw new IllegalArgumentException("ScheduledExecutorService is not available!");
            }
        } catch (Exception e2) {
            X.b(e2);
        }
    }

    @Override // com.tencent.bugly.beta.download.c
    public DownloadTask a(String str, String str2, String str3, String str4) {
        RunnableC0329w runnableC0329w = null;
        if (TextUtils.isEmpty(str)) {
            X.b("downloadUrl is null!", new Object[0]);
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            X.b("saveDir is null!", new Object[0]);
            return null;
        }
        if (this.f4463b.get(str) != null) {
            return (DownloadTask) this.f4463b.get(str);
        }
        ContentValues contentValuesC = C0323p.a.c(str);
        if (contentValuesC != null && contentValuesC.get("_dUrl") != null && contentValuesC.getAsString("_sFile") != null && contentValuesC.getAsLong("_sLen") != null && contentValuesC.getAsLong("_tLen") != null && contentValuesC.getAsString("_MD5") != null) {
            runnableC0329w = new RunnableC0329w((String) contentValuesC.get("_dUrl"), contentValuesC.getAsString("_sFile"), contentValuesC.getAsLong("_sLen").longValue(), contentValuesC.getAsLong("_tLen").longValue(), contentValuesC.getAsString("_MD5"));
            if (contentValuesC.getAsLong("_DLTIME") != null) {
                runnableC0329w.f4466l = contentValuesC.getAsLong("_DLTIME").longValue();
            }
        }
        return runnableC0329w == null ? new RunnableC0329w(str, str2, str3, str4) : runnableC0329w;
    }

    public synchronized boolean a(Runnable runnable) {
        ScheduledExecutorService scheduledExecutorService = this.f4464c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            if (runnable == null) {
                X.e("async task = null", new Object[0]);
                return false;
            }
            X.e("task start %s", runnable.getClass().getName());
            this.f4464c.execute(runnable);
            return true;
        }
        X.e("async handler was closed , should not post task!", new Object[0]);
        return false;
    }
}
