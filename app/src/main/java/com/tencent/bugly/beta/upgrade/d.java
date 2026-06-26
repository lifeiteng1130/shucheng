package com.tencent.bugly.beta.upgrade;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.ui.UpgradeDialog;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.C0323p;
import com.tencent.bugly.proguard.C0330x;
import com.tencent.bugly.proguard.C0331y;
import com.tencent.bugly.proguard.C0332z;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.tencent.bugly.proguard.ra;
import com.tencent.bugly.proguard.sa;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static d a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BetaGrayStrategy f4006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DownloadTask f4007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DownloadListener f4008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UpgradeListener f4009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UpgradeStateListener f4010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4011g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.tencent.bugly.beta.global.d f4013i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.tencent.bugly.beta.global.d f4014j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4015k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f4016l = new Object();
    private final Object m = new Object();
    private DownloadListener n = new com.tencent.bugly.beta.download.a(3, this, 0);
    private a o = null;
    private com.tencent.bugly.beta.global.d p;
    private boolean q;
    private int r;

    private B b() {
        BetaGrayStrategy betaGrayStrategy = this.f4006b;
        if (betaGrayStrategy == null) {
            return null;
        }
        return betaGrayStrategy.a;
    }

    private DownloadTask c() {
        B b2 = b();
        if (b2 == null) {
            return null;
        }
        if (this.f4007c == null) {
            e eVar = e.f3983b;
            DownloadTask downloadTaskA = eVar.s.a(b2.f4253k.f4468c, eVar.w.getAbsolutePath(), null, this.f4006b.a.f4253k.f4467b);
            this.f4007c = downloadTaskA;
            downloadTaskA.setDownloadType(1);
        }
        return this.f4007c;
    }

    private void b(boolean z) {
        new Handler(Looper.getMainLooper()).post(new c(this, z));
    }

    public BetaGrayStrategy a(B b2) {
        BetaGrayStrategy betaGrayStrategy;
        BetaGrayStrategy betaGrayStrategy2;
        C0331y c0331y;
        int i2;
        e eVar;
        int i3;
        B b3;
        C0331y c0331y2;
        int i4;
        e eVar2;
        int i5;
        C0330x c0330x;
        B b4 = b2;
        synchronized (this.f4016l) {
            BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            betaGrayStrategy = null;
            if (betaGrayStrategy3 != null && betaGrayStrategy3.a == null) {
                com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                betaGrayStrategy3 = null;
            }
            if (betaGrayStrategy3 != null && (b3 = betaGrayStrategy3.a) != null && ((i4 = (c0331y2 = b3.f4252j).f4474d) < (i5 = (eVar2 = e.f3983b).z) || ((i4 == i5 && c0331y2.f4476f <= eVar2.r) || b3.s != 1 || ((c0330x = b3.f4253k) != null && TextUtils.equals(eVar2.y, c0330x.f4467b))))) {
                com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                this.f4007c = null;
                betaGrayStrategy3 = null;
            }
            if (b4 != null && ((i2 = (c0331y = b4.f4252j).f4474d) < (i3 = (eVar = e.f3983b).z) || (i2 == i3 && c0331y.f4476f <= eVar.r))) {
                X.c("versionCode is too small, discard remote strategy: [new: %d buildno: %d] [current: %d buildno: %d]", Integer.valueOf(i2), Integer.valueOf(b4.f4252j.f4476f), Integer.valueOf(e.f3983b.z), Integer.valueOf(e.f3983b.r));
                b4 = null;
            }
            if (b4 != null) {
                if (b4.s == 2 && betaGrayStrategy3 != null && betaGrayStrategy3.a != null && !TextUtils.isEmpty(b4.r) && !TextUtils.isEmpty(betaGrayStrategy3.a.r) && TextUtils.equals(b4.r, betaGrayStrategy3.a.r)) {
                    X.c("撤回 strategy: %s", b4.r);
                    betaGrayStrategy3 = null;
                }
                if (b4.s != 1) {
                    X.c("invalid strategy: %s", b4.r);
                    b4 = null;
                }
            }
            if (b4 != null) {
                if (betaGrayStrategy3 == null || betaGrayStrategy3.a == null || TextUtils.isEmpty(b4.r) || TextUtils.isEmpty(betaGrayStrategy3.a.r) || !TextUtils.equals(b4.r, betaGrayStrategy3.a.r)) {
                    betaGrayStrategy2 = new BetaGrayStrategy();
                } else {
                    betaGrayStrategy2 = new BetaGrayStrategy(ca.d(ca.a(betaGrayStrategy3)));
                    X.c("same strategyId:[new: %s] [current: %s] keep has popup times: %d, interval: %d", b4.r, betaGrayStrategy3.a.r, Integer.valueOf(betaGrayStrategy2.f3997b), Long.valueOf(b4.n));
                }
                betaGrayStrategy2.a = b4;
                betaGrayStrategy2.f4000e = System.currentTimeMillis();
                if (betaGrayStrategy3 != null && !betaGrayStrategy3.a.f4253k.f4468c.equals(b4.f4253k.f4468c)) {
                    DownloadTask downloadTask = this.f4007c;
                    if (downloadTask == null) {
                        e eVar3 = e.f3983b;
                        DownloadTask downloadTaskA = eVar3.s.a(betaGrayStrategy3.a.f4253k.f4468c, eVar3.w.getAbsolutePath(), null, null);
                        this.f4007c = downloadTaskA;
                        downloadTaskA.setDownloadType(1);
                        this.f4007c.delete(true);
                        for (File file : e.f3983b.w.listFiles()) {
                            if (!file.delete()) {
                                X.b("cannot deleteCache file:%s", file.getAbsolutePath());
                            }
                        }
                        this.f4007c = null;
                    } else {
                        BetaReceiver.netListeners.remove(downloadTask.getDownloadUrl());
                        this.f4007c.delete(true);
                        this.f4007c = null;
                    }
                }
                a(betaGrayStrategy2);
                X.c("onUpgradeReceived: %s [type: %d]", b4, Integer.valueOf(b4.f4254l));
                C0323p.a.a(new C0332z("rcv", System.currentTimeMillis(), (byte) 0, 0L, b4.f4252j, b4.r, b4.u, null));
                betaGrayStrategy = betaGrayStrategy2;
            }
        }
        return betaGrayStrategy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        if ((r5.a.m - r5.f3997b) <= 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01a4, code lost:
    
        if (r5.f4254l != 3) goto L93;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r16, boolean r17, int r18, com.tencent.bugly.proguard.B r19, java.lang.String r20) {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.d.a(boolean, boolean, int, com.tencent.bugly.proguard.B, java.lang.String):void");
    }

    private void a() {
        B b2 = b();
        if (b2 == null) {
            return;
        }
        if (this.f4007c == null) {
            this.f4007c = c();
        }
        if (this.f4007c == null) {
            return;
        }
        a(this.f4006b);
        BetaReceiver.addTask(this.f4007c);
        if (this.f4007c.getStatus() == 1 && !this.f4012h) {
            if (this.f4011g && com.tencent.bugly.beta.global.a.a(e.f3983b.v, this.f4007c.getSaveFile(), b2.f4253k.f4467b)) {
                C0323p.a.a(new C0332z("install", System.currentTimeMillis(), (byte) 0, 0L, b2.f4252j, b2.r, b2.u, null));
                return;
            } else {
                b(this.f4011g);
                return;
            }
        }
        this.f4007c.download();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        B b2 = b();
        if (b2 == null) {
            return;
        }
        if (System.currentTimeMillis() <= b2.b() - 86400000) {
            X.b(System.currentTimeMillis() + "ms", new Object[0]);
            return;
        }
        f.a.a(e.f3983b.s, b2.q);
        if (this.f4007c == null) {
            this.f4007c = c();
        }
        DownloadTask downloadTask = this.f4007c;
        if (downloadTask == null) {
            return;
        }
        if (!z && downloadTask.getStatus() == 2) {
            X.c("Task is downloading %s %s", b2.r, this.f4007c.getDownloadUrl());
            return;
        }
        this.f4007c.addListener(this.n);
        DownloadListener downloadListener = this.f4008d;
        if (downloadListener != null) {
            this.f4007c.addListener(downloadListener);
        }
        UpgradeDialog upgradeDialog = UpgradeDialog.instance;
        upgradeDialog.setUpgradeInfo(b2, this.f4007c);
        upgradeDialog.upgradeRunnable = new com.tencent.bugly.beta.global.d(3, this.f4006b, this.f4007c);
        upgradeDialog.cancelRunnable = new com.tencent.bugly.beta.global.d(4, this.f4006b, this.f4007c, Boolean.valueOf(z));
        this.f4006b.f3998c = System.currentTimeMillis();
        a(this.f4006b);
        if (z) {
            f.a.a(new com.tencent.bugly.beta.global.d(2, upgradeDialog, Boolean.valueOf(z)), 3000);
            return;
        }
        f fVar = f.a;
        Object[] objArr = new Object[2];
        objArr[0] = upgradeDialog;
        objArr[1] = Boolean.valueOf(z || b2.f4254l == 2);
        fVar.a(new com.tencent.bugly.beta.global.d(2, objArr));
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083 A[Catch: all -> 0x0175, TryCatch #1 {, blocks: (B:5:0x001a, B:9:0x002b, B:44:0x007e, B:46:0x0083, B:48:0x0087, B:50:0x008b, B:53:0x0090, B:56:0x00a6, B:92:0x0167, B:93:0x0173, B:88:0x015f, B:90:0x0163, B:60:0x00b2, B:61:0x00b3, B:63:0x00b9, B:64:0x00bb, B:82:0x0150, B:84:0x0156, B:13:0x0038, B:15:0x0042, B:17:0x004a, B:20:0x0050, B:22:0x0054, B:37:0x0072, B:39:0x0076, B:26:0x005f, B:30:0x0066, B:54:0x0091, B:55:0x00a5, B:67:0x00eb, B:69:0x00ef, B:71:0x00f9, B:73:0x0101, B:75:0x0108, B:77:0x0117, B:79:0x012e), top: B:100:0x001a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b9 A[Catch: all -> 0x0175, TryCatch #1 {, blocks: (B:5:0x001a, B:9:0x002b, B:44:0x007e, B:46:0x0083, B:48:0x0087, B:50:0x008b, B:53:0x0090, B:56:0x00a6, B:92:0x0167, B:93:0x0173, B:88:0x015f, B:90:0x0163, B:60:0x00b2, B:61:0x00b3, B:63:0x00b9, B:64:0x00bb, B:82:0x0150, B:84:0x0156, B:13:0x0038, B:15:0x0042, B:17:0x004a, B:20:0x0050, B:22:0x0054, B:37:0x0072, B:39:0x0076, B:26:0x005f, B:30:0x0066, B:54:0x0091, B:55:0x00a5, B:67:0x00eb, B:69:0x00ef, B:71:0x00f9, B:73:0x0101, B:75:0x0108, B:77:0x0117, B:79:0x012e), top: B:100:0x001a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r17, boolean r18, int r19) {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.d.a(boolean, boolean, int):void");
    }

    public void a(sa saVar) {
        e eVar = e.f3983b;
        if (eVar.H == null) {
            eVar.H = new BetaUploadStrategy();
        }
        if (saVar != null) {
            BetaUploadStrategy betaUploadStrategy = e.f3983b.H;
            long j2 = betaUploadStrategy.f4001b;
            long j3 = saVar.f4447k;
            if (j2 == j3) {
                return;
            }
            betaUploadStrategy.f4001b = j3;
            sa saVar2 = betaUploadStrategy.a;
            saVar2.f4441e = saVar.f4441e;
            saVar2.f4442f = saVar.f4442f;
            saVar2.f4447k = j3;
            if (ca.c(saVar.f4443g)) {
                e.f3983b.H.a.f4443g = saVar.f4443g;
            }
            if (ca.c(saVar.f4444h)) {
                e.f3983b.H.a.f4444h = saVar.f4444h;
            }
            ra raVar = saVar.f4445i;
            if (raVar != null && !TextUtils.isEmpty(raVar.a)) {
                e.f3983b.H.a.f4445i.a = saVar.f4445i.a;
            }
            Map<String, String> map = saVar.f4446j;
            if (map != null && map.size() > 0) {
                e.f3983b.H.a.f4446j = saVar.f4446j;
            }
            if (ca.c(saVar.f4448l)) {
                e.f3983b.H.a.f4448l = saVar.f4448l;
            }
            if (ca.c(saVar.m)) {
                e.f3983b.H.a.m = saVar.m;
            }
            com.tencent.bugly.beta.global.a.a("us.bch", e.f3983b.H);
        }
    }

    private void a(BetaGrayStrategy betaGrayStrategy) {
        B b2 = betaGrayStrategy.a;
        if (b2 == null || b2.u != 1) {
            return;
        }
        com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", betaGrayStrategy);
    }
}
