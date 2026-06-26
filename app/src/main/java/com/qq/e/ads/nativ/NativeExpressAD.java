package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> {
    public static final int EVENT_TYPE_AD_WILL_OPEN_OVERLAY = 20;
    public static final int EVENT_TYPE_ON_AD_CLICKED = 6;
    public static final int EVENT_TYPE_ON_AD_CLOSED = 7;
    public static final int EVENT_TYPE_ON_AD_CLOSE_OVERLAY = 10;
    public static final int EVENT_TYPE_ON_AD_EXPOSURE = 5;
    public static final int EVENT_TYPE_ON_AD_LEFT_APPLICATION = 8;
    public static final int EVENT_TYPE_ON_AD_LOADED = 2;
    public static final int EVENT_TYPE_ON_AD_OPEN = 22;
    public static final int EVENT_TYPE_ON_AD_OPEN_OVERLAY = 9;
    public static final int EVENT_TYPE_ON_NO_AD = 1;
    public static final int EVENT_TYPE_ON_RENDER_FAILED = 3;
    public static final int EVENT_TYPE_ON_RENDER_SUCCESS = 4;
    public static final int EVENT_TYPE_ON_VIDEO_CACHED = 21;
    public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 16;
    public static final int EVENT_TYPE_ON_VIDEO_ERROR = 17;
    public static final int EVENT_TYPE_ON_VIDEO_INIT = 11;
    public static final int EVENT_TYPE_ON_VIDEO_LOADING = 12;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_CLOSE = 19;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_OPEN = 18;
    public static final int EVENT_TYPE_ON_VIDEO_PAUSE = 15;
    public static final int EVENT_TYPE_ON_VIDEO_READY = 13;
    public static final int EVENT_TYPE_ON_VIDEO_START = 14;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile int f2701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile int f2702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<Integer> f2703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private VideoOption f2704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ADSize f2705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private NativeExpressADListener f2706l;
    private LoadAdParams m;

    public static class ADListenerAdapter implements ADListener {
        private NativeExpressADListener a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private NativeExpressMediaListener f2707b;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f2707b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 22:
                    NativeExpressAD.a(this.a, aDEvent);
                    break;
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 21:
                    NativeExpressAD.a(this.f2707b, aDEvent);
                    break;
            }
        }
    }

    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        @Deprecated
        void onADCloseOverlay(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        @Deprecated
        void onADOpenOverlay(NativeExpressADView nativeExpressADView);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        this.f2703i = Collections.synchronizedList(new ArrayList());
        this.f2706l = nativeExpressADListener;
        if (a(aDSize)) {
            return;
        }
        a(context, str);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        this.f2703i = Collections.synchronizedList(new ArrayList());
        this.f2706l = nativeExpressADListener;
        if (a(aDSize)) {
            return;
        }
        a(context, str, str2);
    }

    @Deprecated
    public NativeExpressAD(Context context, ADSize aDSize, String str, String str2, NativeExpressADListener nativeExpressADListener) {
        this(context, aDSize, str2, nativeExpressADListener);
        c();
    }

    public static void a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener == null) {
            return;
        }
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                }
                break;
            case 2:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    nativeExpressADListener.onADLoaded((List) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 3:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onRenderFail((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 4:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onRenderSuccess((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 5:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADExposure((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 6:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParas()[0];
                    nativeExpressADListener.onADClicked(nativeExpressADView);
                    if (aDEvent.getParas()[1] instanceof String) {
                        nativeExpressADView.ext.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, (String) aDEvent.getParas()[1]);
                        return;
                    }
                    return;
                }
                break;
            case 7:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADClosed((NativeExpressADView) aDEvent.getParas()[0]);
                    ((NativeExpressADView) aDEvent.getParas()[0]).negativeFeedback();
                    return;
                }
                break;
            case 8:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADLeftApplication((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 9:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADOpenOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 10:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADCloseOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            default:
                return;
        }
        AbstractAD.a(NativeExpressAD.class, aDEvent);
    }

    private boolean a(ADSize aDSize) {
        if (aDSize != null) {
            this.f2705k = aDSize;
            return false;
        }
        GDTLogger.e("初始化错误：参数adSize不能为空");
        a(ErrorCode.INIT_ERROR);
        return true;
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NEADI neadi) {
        super.a(neadi);
        neadi.setMinVideoDuration(this.f2701g);
        neadi.setMaxVideoDuration(this.f2702h);
        VideoOption videoOption = this.f2704j;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.f2703i) {
            Iterator<Integer> it = this.f2703i.iterator();
            while (it.hasNext()) {
                T t = this.a;
                if (t != 0) {
                    if (this.m != null) {
                        ((NEADI) t).loadAd(it.next().intValue(), this.m);
                    } else {
                        ((NEADI) t).loadAd(it.next().intValue());
                    }
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        NativeExpressADListener nativeExpressADListener = this.f2706l;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((NEADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i2) {
        loadAD(i2, null);
    }

    public void loadAD(int i2, LoadAdParams loadAdParams) {
        if (a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.f2703i) {
                    this.f2703i.add(Integer.valueOf(i2));
                }
                return;
            }
            T t = this.a;
            if (t == 0) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.m;
            NEADI neadi = (NEADI) t;
            if (loadAdParams2 != null) {
                neadi.loadAd(i2, loadAdParams2);
            } else {
                neadi.loadAd(i2);
            }
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.m = loadAdParams;
    }

    public void setMaxVideoDuration(int i2) {
        this.f2702h = i2;
        if (this.f2702h > 0 && this.f2701g > this.f2702h) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((NEADI) t).setMaxVideoDuration(this.f2702h);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.f2701g = i2;
        if (this.f2702h > 0 && this.f2701g > this.f2702h) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((NEADI) t).setMinVideoDuration(this.f2701g);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f2704j = videoOption;
        T t = this.a;
        if (t == 0 || videoOption == null) {
            return;
        }
        ((NEADI) t).setVideoOption(videoOption);
    }

    @Deprecated
    public void setVideoPlayPolicy(int i2) {
    }

    public static void a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        if (nativeExpressMediaListener == null) {
            return;
        }
        switch (aDEvent.getType()) {
            case 11:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoInit((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 12:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoLoading((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 13:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView) && (aDEvent.getParas()[1] instanceof Integer)) {
                    nativeExpressMediaListener.onVideoReady((NativeExpressADView) aDEvent.getParas()[0], ((Integer) aDEvent.getParas()[1]).intValue());
                    return;
                }
                break;
            case 14:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoStart((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 15:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPause((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 16:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoComplete((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 17:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView) && (aDEvent.getParas()[1] instanceof Integer)) {
                    nativeExpressMediaListener.onVideoError((NativeExpressADView) aDEvent.getParas()[0], AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[1]).intValue()));
                    return;
                }
                break;
            case 18:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPageOpen((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 19:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPageClose((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 20:
            default:
                return;
            case 21:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoCached((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
        }
        AbstractAD.a(NativeExpressAD.class, aDEvent);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.f2705k, str, str2, str3, new ADListenerAdapter(this.f2706l));
    }
}
