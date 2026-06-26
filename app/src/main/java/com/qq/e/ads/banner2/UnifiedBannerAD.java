package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class UnifiedBannerAD extends LiteAbstractAD<UBVI> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private UnifiedBannerADListener f2644g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DownAPPConfirmPolicy f2645h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicInteger f2646i = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2647j = 30;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LoadAdParams f2648k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private UnifiedBannerView f2649l;

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this.f2644g = unifiedBannerADListener;
        this.f2649l = unifiedBannerView;
        a(activity, str);
    }

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this.f2644g = unifiedBannerADListener;
        this.f2649l = unifiedBannerView;
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.f2649l, (Activity) context, str, str2, str3, this.f2644g);
    }

    public void a(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        T t;
        this.f2645h = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy == null || (t = this.a) == 0) {
            return;
        }
        ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        d();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        UnifiedBannerADListener unifiedBannerADListener = this.f2644g;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public void c(int i2) {
        this.f2647j = i2;
        T t = this.a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i2);
        }
    }

    public void d() {
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f2645h;
        if (downAPPConfirmPolicy != null) {
            this.f2645h = downAPPConfirmPolicy;
            T t = this.a;
            if (t != 0) {
                ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
            }
        }
        int i2 = this.f2647j;
        this.f2647j = i2;
        T t2 = this.a;
        if (t2 != 0) {
            ((UBVI) t2).setRefresh(i2);
        }
        LoadAdParams loadAdParams = this.f2648k;
        this.f2648k = loadAdParams;
        T t3 = this.a;
        if (t3 != 0) {
            ((UBVI) t3).setLoadAdParams(loadAdParams);
        }
        while (this.f2646i.getAndDecrement() > 0) {
            loadAD();
        }
    }

    public void destroy() {
        T t = this.a;
        if (t != 0) {
            ((UBVI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((UBVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public Map getExt() {
        T t = this.a;
        if (t != 0) {
            return UBVI.ext;
        }
        a("getExt");
        return null;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f2646i.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UBVI) t).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        T t = this.a;
        if (t != 0) {
            ((UBVI) t).onWindowFocusChanged(z);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f2648k = loadAdParams;
        T t = this.a;
        if (t != 0) {
            ((UBVI) t).setLoadAdParams(loadAdParams);
        }
    }
}
