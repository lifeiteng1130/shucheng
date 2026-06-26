package com.tencent.bugly.beta.download;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public abstract class DownloadTask {
    public static final int COMPLETE = 1;
    public static final int DELETED = 4;
    public static final int DOWNLOADING = 2;
    public static final int FAILED = 5;
    public static final int INIT = 0;
    public static final int PAUSED = 3;
    public static final int TYPE_HOTFIX = 2;
    public static final int TYPE_UPGRADE = 1;
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3964c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f3966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3967f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3969h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<DownloadListener> f3965d = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3968g = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3970i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3971j = 1;

    public DownloadTask(String str, String str2, String str3, String str4) {
        this.f3969h = "";
        this.a = str;
        this.f3963b = str2;
        this.f3964c = str3;
        this.f3969h = str4;
    }

    public void addListener(DownloadListener downloadListener) {
        if (downloadListener == null || this.f3965d.contains(downloadListener)) {
            return;
        }
        this.f3965d.add(downloadListener);
    }

    public abstract void delete(boolean z);

    public abstract void download();

    public abstract long getCostTime();

    public int getDownloadType() {
        return this.f3971j;
    }

    public String getDownloadUrl() {
        return this.a;
    }

    public String getMD5() {
        return this.f3969h;
    }

    public abstract File getSaveFile();

    public long getSavedLength() {
        return this.f3966e;
    }

    public abstract int getStatus();

    public long getTotalLength() {
        return this.f3967f;
    }

    public boolean isNeededNotify() {
        return this.f3968g;
    }

    public boolean removeListener(DownloadListener downloadListener) {
        return downloadListener != null && this.f3965d.remove(downloadListener);
    }

    public void setDownloadType(int i2) {
        this.f3971j = i2;
    }

    public void setNeededNotify(boolean z) {
        this.f3968g = z;
    }

    public void setSavedLength(long j2) {
        this.f3966e = j2;
    }

    public void setTotalLength(long j2) {
        this.f3967f = j2;
    }

    public abstract void stop();
}
