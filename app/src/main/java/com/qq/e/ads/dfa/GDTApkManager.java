package com.qq.e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class GDTApkManager {
    private DFA a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2668b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2669c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicInteger f2670d = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f2671e;

    public GDTApkManager(Context context, IGDTApkListener iGDTApkListener) {
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), iGDTApkListener);
        }
    }

    private void a(Context context, String str, final IGDTApkListener iGDTApkListener) {
        if (TextUtils.isEmpty(str) || context == null) {
            GDTLogger.e("初始化错误：GDTApkManager 构造失败，Context和appID不能为空");
        } else {
            if (!a.a(context)) {
                GDTLogger.e("初始化错误：必需的 Activity/Service/Permission 没有在AndroidManifest.xml中声明");
                return;
            }
            this.f2668b = true;
            this.f2671e = context;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        GDTApkManager.this.a = GDTADManager.getInstance().getPM().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                        GDTApkManager.this.f2669c = true;
                                        while (GDTApkManager.this.f2670d.getAndDecrement() > 0) {
                                            GDTApkManager.this.loadGDTApk();
                                        }
                                    }
                                } finally {
                                    try {
                                    } finally {
                                    }
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("初始化错误：初始化时发生异常", th);
                    }
                }
            });
        }
    }

    public final void loadGDTApk() {
        if (this.f2668b) {
            if (!this.f2669c) {
                this.f2670d.incrementAndGet();
                return;
            }
            DFA dfa = this.a;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                GDTLogger.e("调用loadGDTApk失败，实例未被正常初始化");
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa = this.a;
        if (dfa != null) {
            dfa.startInstall(this.f2671e, gDTApk);
        }
    }
}
