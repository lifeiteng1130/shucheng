package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.VideoAdValidity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RewardVideoADListener f2743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f2744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, String> f2746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LoadAdParams f2747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ServerSideVerificationOptions f2748l;
    private boolean m;

    public static class ADListenerAdapter implements ADListener {
        public static final int EVENT_TYPE_ON_AD_CLICK = 6;
        public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
        public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
        public static final int EVENT_TYPE_ON_AD_LOADED = 1;
        public static final int EVENT_TYPE_ON_AD_SHOW = 3;
        public static final int EVENT_TYPE_ON_ERROR = 9;
        public static final int EVENT_TYPE_ON_REWARD = 5;
        public static final int EVENT_TYPE_ON_VIDEO_CACHED = 2;
        public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 7;
        private CacheCallback a;
        public RewardVideoADListener adListener;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<RewardVideoAD> f2749b;

        public interface CacheCallback {
            void onCached();

            void onLoaded();
        }

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener, CacheCallback cacheCallback) {
            this.adListener = rewardVideoADListener;
            this.a = cacheCallback;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                    this.adListener.onADLoad();
                    CacheCallback cacheCallback = this.a;
                    if (cacheCallback != null) {
                        cacheCallback.onLoaded();
                    }
                    break;
                case 2:
                    CacheCallback cacheCallback2 = this.a;
                    if (cacheCallback2 != null) {
                        cacheCallback2.onCached();
                    }
                    this.adListener.onVideoCached();
                    break;
                case 3:
                    this.adListener.onADShow();
                    break;
                case 4:
                    this.adListener.onADExpose();
                    break;
                case 5:
                    if (aDEvent.getParas().length >= 1 && (aDEvent.getParas()[0] instanceof String)) {
                        HashMap map = new HashMap();
                        map.put(ServerSideVerificationOptions.TRANS_ID, aDEvent.getParas()[0]);
                        this.adListener.onReward(map);
                    } else {
                        AbstractAD.a(RewardVideoAD.class, aDEvent);
                    }
                    break;
                case 6:
                    if (this.f2749b != null && aDEvent.getParas().length == 1) {
                        Object obj = aDEvent.getParas()[0];
                        if ((obj instanceof String) && this.f2749b.get() != null) {
                            this.f2749b.get().setExt((String) obj);
                        }
                    }
                    this.adListener.onADClick();
                    break;
                case 7:
                    this.adListener.onVideoComplete();
                    break;
                case 8:
                    this.adListener.onADClose();
                    break;
                case 9:
                    if (aDEvent.getParas().length >= 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.adListener.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    } else {
                        AbstractAD.a(RewardVideoAD.class, aDEvent);
                    }
                    break;
            }
        }

        public void setBase(RewardVideoAD rewardVideoAD) {
            this.f2749b = new WeakReference<>(rewardVideoAD);
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z) {
        this.f2746j = new HashMap();
        this.f2747k = null;
        this.f2743g = rewardVideoADListener;
        this.m = z;
        a(context, str);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z, String str2) {
        this.f2746j = new HashMap();
        this.f2747k = null;
        this.f2743g = rewardVideoADListener;
        this.m = z;
        a(context, str, str2);
    }

    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener) {
        this(context, str, str2, rewardVideoADListener, true);
    }

    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener, boolean z) {
        this(context, str2, rewardVideoADListener, z);
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        ADListenerAdapter aDListenerAdapter = new ADListenerAdapter(this.f2743g, new ADListenerAdapter.CacheCallback() { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.1
            @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
            public void onCached() {
                RewardVideoAD.this.f2745i = true;
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
            public void onLoaded() {
                RewardVideoAD.this.f2745i = false;
            }
        });
        aDListenerAdapter.setBase(this);
        return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, aDListenerAdapter);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        RewardVideoADListener rewardVideoADListener = this.f2743g;
        if (rewardVideoADListener != null) {
            rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public VideoAdValidity checkValidity() {
        T t;
        return hasShown() ? VideoAdValidity.SHOWED : SystemClock.elapsedRealtime() > getExpireTimestamp() - 1000 ? VideoAdValidity.OVERDUE : (this.f2745i || (t = this.a) == 0 || ((RVADI) t).getRewardAdType() != 0) ? VideoAdValidity.VALID : VideoAdValidity.NONE_CACHE;
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public long getExpireTimestamp() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI) t).getExpireTimestamp();
        }
        a("getExpireTimestamp");
        return 0L;
    }

    public Map<String, String> getExts() {
        return this.f2746j;
    }

    public int getRewardAdType() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI) t).getRewardAdType();
        }
        a("getRewardAdType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI) t).hasShown();
        }
        a("hasShown");
        return false;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f2744h = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((RVADI) t).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setExt(String str) {
        this.f2746j.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, str);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f2747k = loadAdParams;
        T t = this.a;
        if (t != 0) {
            ((RVADI) t).setLoadAdParams(loadAdParams);
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f2748l = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((RVADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAD() {
        T t = this.a;
        if (t != 0) {
            ((RVADI) t).showAD();
        } else {
            a("showAD");
        }
    }

    public void showAD(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((RVADI) t).showAD(activity);
        } else {
            a("showAD");
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        RVADI rvadi = (RVADI) obj;
        rvadi.setVolumeOn(this.m);
        rvadi.setLoadAdParams(this.f2747k);
        rvadi.setServerSideVerificationOptions(this.f2748l);
        if (this.f2744h) {
            loadAD();
        }
    }
}
