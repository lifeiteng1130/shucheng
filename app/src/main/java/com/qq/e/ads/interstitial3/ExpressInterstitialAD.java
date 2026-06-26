package com.qq.e.ads.interstitial3;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.interstitial2.ADRewardListener;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI2;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.CallbackUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ExpressInterstitialAD extends LiteAbstractAD<UIADI2> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private VideoOption2 f2695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AdListenerAdapter f2696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ExpressInterstitialAdListener f2697k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ServerSideVerificationOptions f2698l;

    public static class AdListenerAdapter implements ADListener {
        public ExpressInterstitialAdListener a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ADRewardListener f2699b;

        public AdListenerAdapter(ExpressInterstitialAdListener expressInterstitialAdListener) {
            this.a = expressInterstitialAdListener;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.a == null || aDEvent == null) {
                return;
            }
            switch (aDEvent.getType()) {
                case 100:
                    this.a.onAdLoaded();
                    break;
                case 101:
                    this.a.onVideoCached();
                    break;
                case 102:
                    this.a.onShow();
                    break;
                case 103:
                    this.a.onExpose();
                    break;
                case 104:
                    if (this.f2699b != null) {
                        Object obj = aDEvent.getParas()[0];
                        Map<String, Object> map = null;
                        if (obj instanceof String) {
                            HashMap map2 = new HashMap();
                            map2.put(ServerSideVerificationOptions.TRANS_ID, String.valueOf(aDEvent.getParas()[0]));
                            map = map2;
                        } else if (obj instanceof Map) {
                            map = (Map) obj;
                        }
                        ADRewardListener aDRewardListener = this.f2699b;
                        if (aDRewardListener != null && map != null) {
                            aDRewardListener.onReward(map);
                            break;
                        }
                    }
                    break;
                case 105:
                    this.a.onClick();
                    break;
                case 106:
                    this.a.onClose();
                    break;
                case 107:
                    if (aDEvent.getParas().length >= 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.a.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    } else {
                        AbstractAD.a(ExpressInterstitialAD.class, aDEvent);
                    }
                    break;
                case 108:
                    this.a.onVideoComplete();
                    break;
                case 109:
                    if (CallbackUtil.hasRenderSuccessCallback(this.a)) {
                        this.a.onRenderSuccess();
                    }
                    break;
                case 110:
                    if (CallbackUtil.hasRenderFailCallback(this.a)) {
                        this.a.onRenderFail();
                    }
                    break;
            }
        }

        public void setRewardListener(ADRewardListener aDRewardListener) {
            this.f2699b = aDRewardListener;
        }
    }

    public ExpressInterstitialAD(Context context, String str, ExpressInterstitialAdListener expressInterstitialAdListener) {
        GDTLogger.e("ExpressInterstitialAD 接口即将被移除，请使用 UnifiedInterstitialAD 接口");
        this.f2697k = expressInterstitialAdListener;
        a(context, str);
    }

    public ExpressInterstitialAD(Context context, String str, String str2, ExpressInterstitialAdListener expressInterstitialAdListener) {
        this(context, str2, expressInterstitialAdListener);
        c();
    }

    public UIADI2 a(Context context, POFactory pOFactory, String str, String str2) {
        AdListenerAdapter adListenerAdapter = new AdListenerAdapter(this.f2697k);
        this.f2696j = adListenerAdapter;
        return pOFactory.getExpressInterstitialADDelegate(context, str, str2, adListenerAdapter);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(context, pOFactory, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        d();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        ExpressInterstitialAdListener expressInterstitialAdListener = this.f2697k;
        if (expressInterstitialAdListener != null) {
            expressInterstitialAdListener.onError(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public VideoAdValidity checkValidity() {
        boolean zIsVideoCached;
        if (hasShown()) {
            return VideoAdValidity.SHOWED;
        }
        if (SystemClock.elapsedRealtime() > getExpireTimestamp()) {
            return VideoAdValidity.OVERDUE;
        }
        if (isVideoAd()) {
            T t = this.a;
            if (t != 0) {
                zIsVideoCached = ((UIADI2) t).isVideoCached();
            } else {
                a("isVideoCached");
                zIsVideoCached = false;
            }
            if (!zIsVideoCached) {
                return VideoAdValidity.NONE_CACHE;
            }
        }
        return VideoAdValidity.VALID;
    }

    public void closeHalfScreenAD() {
        T t = this.a;
        if (t != 0) {
            ((UIADI2) t).closeHalfScreenAD();
        } else {
            a("closeHalfScreenAD");
        }
    }

    public void d() {
        ((UIADI2) this.a).setVideoOption(this.f2695i);
        ((UIADI2) this.a).setServerSideVerificationOptions(this.f2698l);
        if (this.f2693g) {
            ((UIADI2) this.a).loadHalfScreenAD();
            this.f2693g = false;
        }
        if (this.f2694h) {
            ((UIADI2) this.a).loadFullScreenAD();
            this.f2694h = false;
        }
    }

    public void destroy() {
        T t = this.a;
        if (t != 0) {
            ((UIADI2) t).destroy();
        } else {
            a("destroy");
        }
    }

    public long getExpireTimestamp() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI2) t).getExpireTimestamp();
        }
        a("getExpireTimestamp");
        return 0L;
    }

    public int getVideoDuration() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI2) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI2) t).hasShown();
        }
        a("hasShown");
        return false;
    }

    public boolean isVideoAd() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI2) t).isVideoAd();
        }
        a("isVideoAd");
        return false;
    }

    public void loadFullScreenAD() {
        if (a()) {
            if (!b()) {
                this.f2694h = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI2) t).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void loadHalfScreenAD() {
        if (a()) {
            if (!b()) {
                this.f2693g = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI2) t).loadHalfScreenAD();
            } else {
                a("loadHalfScreenAD");
            }
        }
    }

    public void setRewardListener(ADRewardListener aDRewardListener) {
        AdListenerAdapter adListenerAdapter = this.f2696j;
        if (adListenerAdapter != null) {
            adListenerAdapter.setRewardListener(aDRewardListener);
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        T t = this.a;
        if (t != 0) {
            ((UIADI2) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        } else {
            this.f2698l = serverSideVerificationOptions;
        }
    }

    public void setVideoOption(VideoOption2 videoOption2) {
        T t = this.a;
        if (t != 0) {
            ((UIADI2) t).setVideoOption(videoOption2);
        } else {
            this.f2695i = videoOption2;
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((UIADI2) t).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }

    public void showHalfScreenAD(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((UIADI2) t).showHalfScreenAD(activity);
        } else {
            a("showHalfScreenAD");
        }
    }
}
