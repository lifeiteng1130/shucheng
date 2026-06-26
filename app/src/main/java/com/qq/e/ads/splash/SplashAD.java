package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> {
    public static final int EVENT_TYPE_AD_CLICKED = 4;
    public static final int EVENT_TYPE_AD_DISMISSED = 1;
    public static final int EVENT_TYPE_AD_EXPOSURE = 6;
    public static final int EVENT_TYPE_AD_LOADED = 7;
    public static final int EVENT_TYPE_AD_PRESENT = 3;
    public static final int EVENT_TYPE_AD_TICK = 5;
    public static final int EVENT_TYPE_AD_ZOOM_OUT = 8;
    public static final int EVENT_TYPE_AD_ZOOM_OUT_PLAY_FINISH = 9;
    public static final int EVENT_TYPE_NO_AD = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile ViewGroup f2756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile SplashADListener f2757h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile LoadAdParams f2758i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f2759j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f2760k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f2761l;
    private volatile int m;
    private volatile byte[] n;
    private View o;
    private int p;
    private View q;

    public class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (SplashAD.this.f2757h == null) {
                GDTLogger.d("SplashADListener == null");
                return;
            }
            Object[] paras = aDEvent.getParas();
            switch (aDEvent.getType()) {
                case 1:
                    SplashAD.this.f2757h.onADDismissed();
                    break;
                case 2:
                    if (paras.length > 0 && (paras[0] instanceof Integer)) {
                        SplashAD.this.f2757h.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) paras[0]).intValue()));
                    } else {
                        AbstractAD.a(SplashAD.class, aDEvent);
                    }
                    break;
                case 3:
                    SplashAD.this.f2757h.onADPresent();
                    break;
                case 4:
                    SplashAD.this.f2757h.onADClicked();
                    break;
                case 5:
                    if (paras.length == 1 && (paras[0] instanceof Long)) {
                        SplashAD.this.f2757h.onADTick(((Long) paras[0]).longValue());
                    } else {
                        AbstractAD.a(SplashAD.class, aDEvent);
                    }
                    break;
                case 6:
                    SplashAD.this.f2757h.onADExposure();
                    break;
                case 7:
                    if (paras.length == 1 && (paras[0] instanceof Long)) {
                        SplashAD.this.f2757h.onADLoaded(((Long) paras[0]).longValue());
                    } else {
                        AbstractAD.a(SplashAD.class, aDEvent);
                    }
                    break;
                case 8:
                    if (SplashAD.this.f2757h instanceof SplashADZoomOutListener) {
                        ((SplashADZoomOutListener) SplashAD.this.f2757h).onZoomOut();
                    }
                    break;
                case 9:
                    if (SplashAD.this.f2757h instanceof SplashADZoomOutListener) {
                        ((SplashADZoomOutListener) SplashAD.this.f2757h).onZoomOutPlayFinish();
                    }
                    break;
            }
        }
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i2) {
        this(context, view, str, splashADListener, i2, (View) null);
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i2, View view2) {
        this(context, view, str, splashADListener, i2, (Map) null, view2);
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i2, Map map, View view2) {
        this.f2759j = false;
        this.f2757h = splashADListener;
        this.o = view;
        this.p = i2;
        this.q = view2;
        a(context, str);
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i2) {
        this(context, view, str, str2, splashADListener, i2, (View) null);
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i2, View view2) {
        this(context, view, str, str2, splashADListener, i2, null, view2);
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i2, Map map, View view2) {
        this(context, view, str2, splashADListener, i2, map, view2);
        c();
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2) {
        this(context, (View) null, str, splashADListener, i2);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2, View view) {
        this(context, (View) null, str, splashADListener, i2, (Map) null, view);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2, Map map, View view) {
        this(context, (View) null, str, splashADListener, i2, map, view);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2, Map map, View view, String str2) {
        this.f2759j = false;
        this.f2757h = splashADListener;
        this.p = i2;
        this.q = view;
        a(context, str, str2);
    }

    @Deprecated
    public SplashAD(Context context, String str, String str2, SplashADListener splashADListener) {
        this(context, str, str2, splashADListener, 0);
    }

    @Deprecated
    public SplashAD(Context context, String str, String str2, SplashADListener splashADListener, int i2) {
        this(context, (View) null, str, str2, splashADListener, i2);
    }

    private void a(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(ErrorCode.CONSTRUCTOR_PARAM_ERROR);
            return;
        }
        T t = this.a;
        if (t == 0) {
            this.f2761l = z;
            this.f2756g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    private void a(boolean z) {
        if (a()) {
            if (!b()) {
                this.f2761l = z;
                this.f2760k = true;
                return;
            }
            T t = this.a;
            if (t == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(ErrorCode.CONSTRUCTOR_PARAM_ERROR);
            return;
        }
        T t = this.a;
        if (t == 0) {
            this.f2756g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        if (this.f2757h != null) {
            this.f2757h.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public void fetchAdOnly() {
        a(false);
    }

    public void fetchAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, false);
    }

    public void fetchFullScreenAdOnly() {
        a(true);
    }

    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, true);
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((NSPVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public Map getExt() {
        T t = this.a;
        if (t != 0) {
            return NSPVI.ext;
        }
        a("getExt");
        return null;
    }

    public Bitmap getZoomOutBitmap() {
        T t = this.a;
        if (t != 0) {
            return ((NSPVI) t).getZoomOutBitmap();
        }
        a("getZoomOutBitmap");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.f2759j = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((NSPVI) t).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i2, int i3) {
    }

    public void setDeveloperLogo(int i2) {
        T t = this.a;
        if (t == 0) {
            this.m = i2;
        } else {
            ((NSPVI) t).setDeveloperLogo(i2);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t = this.a;
        if (t == 0) {
            this.n = bArr;
        } else {
            ((NSPVI) t).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t = this.a;
        if (t != 0) {
            ((NSPVI) t).setLoadAdParams(loadAdParams);
        } else {
            this.f2758i = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    public void showAd(ViewGroup viewGroup) {
        b(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        b(viewGroup, true);
    }

    public void zoomOutAnimationFinish() {
        T t = this.a;
        if (t != 0) {
            ((NSPVI) t).zoomOutAnimationFinish();
        } else {
            a("zoomOutAnimationFinish");
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.f2758i != null) {
            nspvi.setLoadAdParams(this.f2758i);
        }
        if (this.m != 0) {
            nspvi.setDeveloperLogo(this.m);
        }
        if (this.n != null) {
            nspvi.setDeveloperLogo(this.n);
        }
        nspvi.setFetchDelay(this.p);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setSkipView(this.o);
        nspvi.setFloatView(this.q);
        if ((this.f2757h instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.f2757h).isSupportZoomOut()) {
            nspvi.setSupportZoomOut(true);
        }
        if (this.f2756g != null) {
            if (this.f2761l) {
                fetchFullScreenAndShowIn(this.f2756g);
            } else {
                fetchAndShowIn(this.f2756g);
            }
        }
        if (this.f2759j) {
            nspvi.preload();
            this.f2759j = false;
        }
        if (this.f2760k) {
            if (this.f2761l) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.f2760k = false;
        }
    }
}
