package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class r {
    public static r a = new r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BetaGrayStrategy f4429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DownloadTask f4430c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.tencent.bugly.beta.global.d f4434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4435h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f4431d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DownloadListener f4432e = new com.tencent.bugly.beta.download.a(4, this, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.tencent.bugly.beta.upgrade.a f4433f = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f4436i = new Object();

    public void a(boolean z, boolean z2, int i2) {
        long j2;
        synchronized (this.f4436i) {
            BetaGrayStrategy betaGrayStrategy = (i2 != 3 || z) ? null : (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            com.tencent.bugly.beta.upgrade.a aVar = this.f4433f;
            if (aVar != null && !aVar.f4004d && this.f4435h == z) {
                synchronized (aVar) {
                    this.f4433f.f4003c[0] = Boolean.valueOf(z);
                    this.f4433f.f4003c[1] = Boolean.valueOf(z2);
                }
                this.f4434g.f3982b[0] = Boolean.FALSE;
            }
            this.f4435h = z;
            if (aVar != null) {
                aVar.f4004d = true;
            }
            com.tencent.bugly.beta.upgrade.a aVar2 = new com.tencent.bugly.beta.upgrade.a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
            this.f4433f = aVar2;
            this.f4434g = new com.tencent.bugly.beta.global.d(12, Boolean.FALSE, aVar2);
            String str = "";
            if (betaGrayStrategy != null) {
                try {
                    B b2 = betaGrayStrategy.a;
                    if (b2 != null) {
                        str = b2.r;
                        j2 = b2.t;
                    }
                    String str2 = str;
                    HashMap map = new HashMap();
                    map.put("G16", com.tencent.bugly.beta.global.e.f3983b.N);
                    com.tencent.bugly.beta.upgrade.b.a.a(804, i2, M.a((AbstractC0320m) new C(z ? 1 : 0, str2, j2, map)), this.f4433f, z, com.tencent.bugly.beta.global.e.f3983b.H.a.f4444h);
                } catch (Throwable th) {
                    if (!X.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            j2 = 0;
            String str22 = str;
            HashMap map2 = new HashMap();
            map2.put("G16", com.tencent.bugly.beta.global.e.f3983b.N);
            com.tencent.bugly.beta.upgrade.b.a.a(804, i2, M.a((AbstractC0320m) new C(z ? 1 : 0, str22, j2, map2)), this.f4433f, z, com.tencent.bugly.beta.global.e.f3983b.H.a.f4444h);
        }
    }

    public synchronized void a(int i2, B b2, boolean z) {
        C0330x c0330xA;
        File file;
        this.f4430c = null;
        BetaGrayStrategy betaGrayStrategyA = a(b2);
        this.f4429b = betaGrayStrategyA;
        if (i2 == 0 && betaGrayStrategyA != null) {
            B b3 = betaGrayStrategyA.a;
            if (b3 == null || b3.f4253k == null || (file = com.tencent.bugly.beta.global.e.f3983b.I) == null || !file.exists() || !com.tencent.bugly.beta.global.a.a(file, this.f4429b.a.f4253k.f4467b, "SHA")) {
                if (b2 != null) {
                    if (com.tencent.bugly.beta.global.e.f3983b.Y != null && (c0330xA = this.f4429b.a.a()) != null) {
                        this.f4431d.post(new RunnableC0324q(this, c0330xA));
                    }
                    com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f3983b;
                    if ((eVar.aa || z) && eVar.ba) {
                        a();
                    }
                }
                return;
            }
            X.c("patch has downloaded!", new Object[0]);
            com.tencent.bugly.beta.global.e eVar2 = com.tencent.bugly.beta.global.e.f3983b;
            if (!eVar2.P && eVar2.Q <= 3) {
                X.c("patch has downloaded but not patched execute patch!", new Object[0]);
                com.tencent.bugly.beta.global.e eVar3 = com.tencent.bugly.beta.global.e.f3983b;
                int i3 = eVar3.Q + 1;
                eVar3.Q = i3;
                com.tencent.bugly.beta.global.a.b("PATCH_MAX_TIMES", String.valueOf(i3));
                com.tencent.bugly.beta.global.a.a(file, com.tencent.bugly.beta.global.e.f3983b.J);
                TinkerManager.getInstance().onDownloadSuccess(com.tencent.bugly.beta.global.e.f3983b.J.getAbsolutePath(), com.tencent.bugly.beta.global.e.f3983b.X);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0198  */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.tencent.bugly.beta.upgrade.BetaGrayStrategy a(com.tencent.bugly.proguard.B r24) {
        /*
            Method dump skipped, instruction units count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.r.a(com.tencent.bugly.proguard.B):com.tencent.bugly.beta.upgrade.BetaGrayStrategy");
    }

    private void a() {
        BetaGrayStrategy betaGrayStrategy = this.f4429b;
        if (betaGrayStrategy == null) {
            return;
        }
        if (this.f4430c == null) {
            com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f3983b;
            DownloadTask downloadTaskA = eVar.s.a(betaGrayStrategy.a.f4253k.f4468c, eVar.K.getAbsolutePath(), null, this.f4429b.a.f4253k.f4467b);
            this.f4430c = downloadTaskA;
            downloadTaskA.setDownloadType(3);
        }
        DownloadTask downloadTask = this.f4430c;
        if (downloadTask == null) {
            return;
        }
        downloadTask.addListener(this.f4432e);
        this.f4430c.setNeededNotify(false);
        this.f4430c.download();
    }

    private void a(BetaGrayStrategy betaGrayStrategy) {
        B b2 = betaGrayStrategy.a;
        if (b2 == null || b2.u != 3) {
            return;
        }
        com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", betaGrayStrategy);
    }
}
