package com.qq.e.ads.rewardvideo2;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI2;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ExpressRewardVideoAD extends LiteAbstractAD<RVADI2> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ServerSideVerificationOptions f2754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ExpressRewardVideoAdListener f2755j;

    public static class AdListenerAdapter implements ADListener {
        public ExpressRewardVideoAdListener a;

        public AdListenerAdapter(ExpressRewardVideoAdListener expressRewardVideoAdListener) {
            this.a = expressRewardVideoAdListener;
        }

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
                    if (aDEvent.getParas().length >= 1 && (aDEvent.getParas()[0] instanceof String)) {
                        HashMap map = new HashMap();
                        map.put(ServerSideVerificationOptions.TRANS_ID, aDEvent.getParas()[0]);
                        this.a.onReward(map);
                    } else {
                        AbstractAD.a(ExpressRewardVideoAD.class, aDEvent);
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
                        AbstractAD.a(ExpressRewardVideoAD.class, aDEvent);
                    }
                    break;
                case 108:
                    this.a.onVideoComplete();
                    break;
            }
        }
    }

    public ExpressRewardVideoAD(Context context, String str, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        this.f2753h = true;
        GDTLogger.e("ExpressRewardVideoAD 接口即将被移除，请使用 RewardVideoAD 接口");
        this.f2755j = expressRewardVideoAdListener;
        a(context, str);
    }

    @Deprecated
    public ExpressRewardVideoAD(Context context, String str, String str2, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        this(context, str2, expressRewardVideoAdListener);
        c();
    }

    public RVADI2 a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getExpressRewardVideoADDelegate(context, str, str2, new AdListenerAdapter(this.f2755j));
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(context, pOFactory, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        RVADI2 rvadi2 = (RVADI2) obj;
        rvadi2.setVolumeOn(this.f2753h);
        rvadi2.setServerSideVerificationOptions(this.f2754i);
        if (this.f2752g) {
            rvadi2.loadAD();
            this.f2752g = false;
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        ExpressRewardVideoAdListener expressRewardVideoAdListener = this.f2755j;
        if (expressRewardVideoAdListener != null) {
            expressRewardVideoAdListener.onError(AdErrorConvertor.formatErrorCode(i2));
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
        T t = this.a;
        if (t != 0) {
            zIsVideoCached = ((RVADI2) t).isVideoCached();
        } else {
            a("isVideoCached");
            zIsVideoCached = false;
        }
        return !zIsVideoCached ? VideoAdValidity.NONE_CACHE : VideoAdValidity.VALID;
    }

    public void destroy() {
        T t = this.a;
        if (t != 0) {
            ((RVADI2) t).destroy();
        }
    }

    public long getExpireTimestamp() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI2) t).getExpireTimestamp();
        }
        a("getExpireTimestamp");
        return 0L;
    }

    public int getVideoDuration() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI2) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI2) t).hasShown();
        }
        a("hasShown");
        return false;
    }

    public void loadAD() {
        if (!b()) {
            this.f2752g = true;
            return;
        }
        T t = this.a;
        if (t != 0) {
            ((RVADI2) t).loadAD();
        } else {
            a("loadAD");
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        T t = this.a;
        if (t != 0) {
            ((RVADI2) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        } else {
            this.f2754i = serverSideVerificationOptions;
        }
    }

    public void setVolumeOn(boolean z) {
        T t = this.a;
        if (t != 0) {
            ((RVADI2) t).setVolumeOn(z);
        } else {
            this.f2753h = z;
        }
    }

    public void showAD(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((RVADI2) t).showAD(activity);
        } else {
            a("showAD");
        }
    }
}
