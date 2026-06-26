package com.qq.e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicInteger f2687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicInteger f2688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile UnifiedInterstitialMediaListener f2689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile VideoOption f2690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile int f2691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile int f2692l;
    private volatile LoadAdParams m;
    private UnifiedInterstitialADListener n;
    private volatile ADRewardListener o;
    private ServerSideVerificationOptions p;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, (Map) null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f2687g = new AtomicInteger(0);
        this.f2688h = new AtomicInteger(0);
        this.n = unifiedInterstitialADListener;
        a(activity, str);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.f2687g = new AtomicInteger(0);
        this.f2688h = new AtomicInteger(0);
        this.n = unifiedInterstitialADListener;
        a(activity, str, str2);
    }

    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, str2, unifiedInterstitialADListener, (Map) null);
    }

    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this(activity, str2, unifiedInterstitialADListener, map);
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.n);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        d();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.n;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public void close() {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).close();
        }
    }

    public void d() {
        setVideoOption(this.f2690j);
        setMediaListener(this.f2689i);
        setMinVideoDuration(this.f2691k);
        setMaxVideoDuration(this.f2692l);
        setRewardListener(this.o);
        setLoadAdParams(this.m);
        setServerSideVerificationOptions(this.p);
        while (this.f2687g.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.f2688h.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    public void destroy() {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).destory();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI) t).getAdPatternType();
        }
        a("getAdPatternType");
        return 0;
    }

    public Map getExt() {
        T t = this.a;
        if (t != 0) {
            return UIADI.ext;
        }
        a("getExt");
        return null;
    }

    public int getVideoDuration() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean isValid() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI) t).isValid();
        }
        a("isValid");
        return false;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f2687g.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        if (a()) {
            if (!b()) {
                this.f2688h.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.m = loadAdParams;
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setLoadAdParams(this.m);
        }
    }

    public void setMaxVideoDuration(int i2) {
        this.f2692l = i2;
        if (this.f2692l > 0 && this.f2691k > this.f2692l) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setMaxVideoDuration(i2);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f2689i = unifiedInterstitialMediaListener;
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setMediaListener(unifiedInterstitialMediaListener);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.f2691k = i2;
        if (this.f2692l > 0 && this.f2691k > this.f2692l) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setMinVideoDuration(i2);
        }
    }

    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.o = aDRewardListener;
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setRewardListener(aDRewardListener);
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.p = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f2690j = videoOption;
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setVideoOption(videoOption);
        }
    }

    @Deprecated
    public void setVideoPlayPolicy(int i2) {
    }

    public void show() {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).show();
        } else {
            a("show");
        }
    }

    public void show(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).show(activity);
        } else {
            a("show");
        }
    }

    public void showAsPopupWindow() {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).showAsPopupWindow();
        } else {
            a("showAsPopupWindow");
        }
    }

    public void showAsPopupWindow(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).showAsPopupWindow(activity);
        } else {
            a("showAsPopupWindow");
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }
}
