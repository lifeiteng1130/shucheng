package com.tencent.bugly.beta.download;

import android.os.Build;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.ui.UpgradeDialog;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.C0323p;
import com.tencent.bugly.proguard.C0332z;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.r;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class a implements DownloadListener {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f3972b;

    public a(int i2, Object... objArr) {
        this.a = i2;
        this.f3972b = objArr;
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onCompleted(DownloadTask downloadTask) throws Throwable {
        try {
            int i2 = this.a;
            if (i2 == 1) {
                synchronized (this.f3972b[0]) {
                    Map map = (Map) this.f3972b[1];
                    if (map.size() == 0) {
                        return;
                    }
                    Iterator it = map.values().iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        if (((DownloadTask) it.next()).getStatus() == 1) {
                            i3++;
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(i3);
                    sb.append(" has completed");
                    X.a(sb.toString(), new Object[0]);
                    if (i3 < map.size()) {
                        return;
                    }
                    for (String str : map.keySet()) {
                        if (((DownloadTask) map.get(str)).getSaveFile() != null && ((DownloadTask) map.get(str)).getSaveFile().exists()) {
                            ResBean.a.a(str, ((DownloadTask) map.get(str)).getSaveFile().getAbsolutePath());
                        }
                    }
                    com.tencent.bugly.beta.global.a.a("rb.bch", ResBean.a);
                    f fVar = (f) this.f3972b[0];
                    fVar.a();
                    fVar.b();
                    return;
                }
            }
            if (i2 == 2) {
                ((UpgradeDialog) this.f3972b[0]).updateBtn(downloadTask);
                return;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                Object[] objArr = this.f3972b;
                r rVar = (r) objArr[0];
                Integer num = (Integer) objArr[1];
                BetaGrayStrategy betaGrayStrategy = rVar.f4429b;
                if (betaGrayStrategy == null || betaGrayStrategy.a == null) {
                    return;
                }
                X.c("patch download success !!!", new Object[0]);
                File saveFile = downloadTask.getSaveFile();
                if (!com.tencent.bugly.beta.global.a.a(saveFile, betaGrayStrategy.a.f4253k.f4467b, "SHA")) {
                    if (num.intValue() >= 2) {
                        this.f3972b[1] = 0;
                        onFailed(downloadTask, 2080, "file sha1 verify fail");
                        downloadTask.delete(true);
                        TinkerManager.getInstance().onDownloadFailure("retry download patch too many times.");
                        return;
                    }
                    this.f3972b[1] = Integer.valueOf(num.intValue() + 1);
                    downloadTask.delete(true);
                    e eVar = e.f3983b;
                    DownloadTask downloadTaskA = eVar.s.a(betaGrayStrategy.a.f4253k.f4468c, eVar.w.getAbsolutePath(), null, betaGrayStrategy.a.f4253k.f4468c);
                    rVar.f4430c = downloadTaskA;
                    downloadTaskA.setDownloadType(3);
                    rVar.f4430c.setNeededNotify(false);
                    rVar.f4430c.addListener(this);
                    BetaReceiver.addTask(rVar.f4430c);
                    rVar.f4430c.download();
                    return;
                }
                this.f3972b[1] = 0;
                if (!com.tencent.bugly.beta.global.a.a(saveFile, e.f3983b.J)) {
                    X.c("copy file failed", new Object[0]);
                    TinkerManager.getInstance().onDownloadFailure("copy file failure.");
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("copy ");
                sb2.append(saveFile.getAbsolutePath());
                sb2.append(" to ");
                sb2.append(e.f3983b.J.getAbsolutePath());
                sb2.append(" success!");
                X.a(sb2.toString(), new Object[0]);
                if (rVar.f4430c != null) {
                    X.a("delete temp file", new Object[0]);
                    rVar.f4430c.delete(true);
                }
                com.tencent.bugly.beta.global.a.b("UPLOAD_PATCH_RESULT", false);
                TinkerManager.getInstance().onDownloadSuccess(e.f3983b.J.getAbsolutePath(), e.f3983b.X);
                return;
            }
            com.tencent.bugly.beta.upgrade.d dVar = (com.tencent.bugly.beta.upgrade.d) this.f3972b[0];
            BetaGrayStrategy betaGrayStrategy2 = dVar.f4006b;
            if (betaGrayStrategy2 != null && betaGrayStrategy2.a != null) {
                UpgradeStateListener upgradeStateListener = dVar.f4010f;
                if (upgradeStateListener != null) {
                    com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(18, upgradeStateListener, 3, Boolean.valueOf(dVar.f4011g)));
                }
                X.c("apk download completed", new Object[0]);
                long jCurrentTimeMillis = System.currentTimeMillis();
                long costTime = downloadTask.getCostTime();
                B b2 = betaGrayStrategy2.a;
                C0332z c0332z = new C0332z("download", jCurrentTimeMillis, (byte) 0, costTime, b2.f4252j, b2.r, b2.u, null);
                if (C0323p.a.a(c0332z)) {
                    com.tencent.bugly.beta.upgrade.b.a.a(c0332z, true);
                }
                if (e.f3983b.fa) {
                    File saveFile2 = downloadTask.getSaveFile();
                    Integer num2 = (Integer) this.f3972b[1];
                    if (com.tencent.bugly.beta.global.a.a(e.f3983b.v, saveFile2, betaGrayStrategy2.a.f4253k.f4467b)) {
                        this.f3972b[1] = 0;
                        C0323p c0323p = C0323p.a;
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        B b3 = betaGrayStrategy2.a;
                        c0323p.a(new C0332z("install", jCurrentTimeMillis2, (byte) 0, 0L, b3.f4252j, b3.r, b3.u, null));
                        return;
                    }
                    if (num2.intValue() >= 2) {
                        this.f3972b[1] = 0;
                        onFailed(downloadTask, 2080, "file md5 verify fail");
                        downloadTask.delete(true);
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        this.f3972b[1] = 0;
                        onFailed(downloadTask, 2080, "安装失败，请检查您的App是否兼容7.0设备");
                        downloadTask.delete(true);
                        return;
                    }
                    this.f3972b[1] = Integer.valueOf(num2.intValue() + 1);
                    downloadTask.delete(true);
                    e eVar2 = e.f3983b;
                    DownloadTask downloadTaskA2 = eVar2.s.a(betaGrayStrategy2.a.f4253k.f4468c, eVar2.w.getAbsolutePath(), null, betaGrayStrategy2.a.f4253k.f4468c);
                    dVar.f4007c = downloadTaskA2;
                    downloadTaskA2.setDownloadType(1);
                    UpgradeDialog.instance.setUpgradeInfo(betaGrayStrategy2.a, dVar.f4007c);
                    dVar.f4007c.addListener(this);
                    BetaReceiver.addTask(dVar.f4007c);
                    dVar.f4007c.download();
                }
            }
        } catch (Exception e2) {
            if (X.a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onFailed(DownloadTask downloadTask, int i2, String str) {
        try {
            int i3 = this.a;
            if (i3 == 1) {
                synchronized (this.f3972b[0]) {
                    f fVar = (f) this.f3972b[0];
                    fVar.a();
                    fVar.b();
                }
                return;
            }
            if (i3 == 2) {
                ((UpgradeDialog) this.f3972b[0]).updateBtn(downloadTask);
                return;
            }
            if (i3 == 3) {
                com.tencent.bugly.beta.upgrade.d dVar = (com.tencent.bugly.beta.upgrade.d) this.f3972b[0];
                if (downloadTask != null) {
                    C0323p c0323p = C0323p.a;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long costTime = downloadTask.getCostTime();
                    B b2 = dVar.f4006b.a;
                    c0323p.a(new C0332z("download", jCurrentTimeMillis, (byte) 1, costTime, b2.f4252j, b2.r, b2.u, null));
                }
                X.b("upgrade failed：(%d)%s", Integer.valueOf(i2), str);
                return;
            }
            if (i3 != 4) {
                return;
            }
            r rVar = (r) this.f3972b[0];
            if (downloadTask != null) {
                C0323p c0323p2 = C0323p.a;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                long costTime2 = downloadTask.getCostTime();
                B b3 = rVar.f4429b.a;
                c0323p2.a(new C0332z("download", jCurrentTimeMillis2, (byte) 1, costTime2, b3.f4252j, b3.r, b3.u, null));
            }
            X.b("hotfix download failed：(%d)%s", Integer.valueOf(i2), str);
            TinkerManager.getInstance().onDownloadFailure(str);
        } catch (Exception e2) {
            if (X.a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onReceive(DownloadTask downloadTask) {
        if (this.a != 2) {
            return;
        }
        ((UpgradeDialog) this.f3972b[0]).updateBtn(downloadTask);
    }
}
