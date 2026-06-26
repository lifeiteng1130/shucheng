package com.qq.e.ads.hybrid;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HybridADListener f2674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CountDownLatch f2675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HybridADSetting f2676h;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.f2675g = new CountDownLatch(1);
        this.f2676h = hybridADSetting;
        this.f2674f = hybridADListener;
        a(context, "NO_POS_ID");
    }

    @Deprecated
    public HybridAD(Context context, String str, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this(context, hybridADSetting, hybridADListener);
        c();
    }

    public HADI a(POFactory pOFactory) {
        return pOFactory.getHybridAD(this.f2676h, this.f2674f);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ HADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(pOFactory);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(HADI hadi) {
        d();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        HybridADListener hybridADListener = this.f2674f;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i2));
        }
        this.f2675g.countDown();
    }

    public void d() {
        this.f2675g.countDown();
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(final String str) {
        if (a()) {
            if (!b()) {
                new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HybridAD.this.f2675g.await(30L, TimeUnit.SECONDS);
                            if (!HybridAD.this.b() || HybridAD.this.a == null) {
                                GDTLogger.e("初始化错误：广告实例未被初始化");
                                HybridAD.this.a(ErrorCode.INIT_ERROR);
                            } else {
                                ((HADI) HybridAD.this.a).loadUrl(str);
                            }
                        } catch (InterruptedException unused) {
                            GDTLogger.e("初始化错误：广告实例未被初始化");
                            HybridAD.this.a(ErrorCode.INIT_ERROR);
                        }
                    }
                }).start();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((HADI) t).loadUrl(str);
            } else {
                a("loadUrl");
            }
        }
    }
}
