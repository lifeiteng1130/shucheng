package com.ifmvo.togetherad.gdt.provider;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewGroup;
import c.a.a.a.a;
import c.b.a.m.f;
import com.ifmvo.togetherad.core.listener.SplashListener;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import com.ifmvo.togetherad.gdt.TogetherAdGdt;
import com.ifmvo.togetherad.gdt.provider.GdtProvider;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GdtProviderSplash.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProviderSplash;", "Lcom/ifmvo/togetherad/gdt/provider/GdtProviderReward;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "Lcom/ifmvo/togetherad/core/listener/SplashListener;", "listener", "Lf/v;", "loadOnlySplashAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "Landroid/view/ViewGroup;", "container", "", "showSplashAd", "(Landroid/view/ViewGroup;)Z", "loadAndShowSplashAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "", "mExpireTimestamp", "J", "Lcom/qq/e/ads/splash/SplashAD;", "splashAd", "Lcom/qq/e/ads/splash/SplashAD;", "mContainer", "Landroid/view/ViewGroup;", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
public abstract class GdtProviderSplash extends GdtProviderReward {
    private ViewGroup mContainer;
    private long mExpireTimestamp;
    private SplashAD splashAd;

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void loadAndShowSplashAd(@NotNull Activity activity, @NotNull final String adProviderType, @NotNull final String alias, @NotNull ViewGroup container, @NotNull final SplashListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(container, "container");
        j.f(listener, "listener");
        callbackSplashStartRequest(adProviderType, alias, listener);
        SplashAD splashAD = new SplashAD(activity, TogetherAdGdt.INSTANCE.getIdMapGDT().get(alias), new SplashADListener() { // from class: com.ifmvo.togetherad.gdt.provider.GdtProviderSplash.loadAndShowSplashAd.1
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADClicked() {
                GdtProviderSplash.this.callbackSplashClicked(adProviderType, listener);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                GdtProviderSplash.this.splashAd = null;
                GdtProviderSplash.this.callbackSplashDismiss(adProviderType, listener);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADExposure() {
                GdtProviderSplash.this.callbackSplashExposure(adProviderType, listener);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADLoaded(long expireTimestamp) {
                SplashAD splashAD2;
                DownloadConfirmListener downloadConfirmListener = TogetherAdGdt.INSTANCE.getDownloadConfirmListener();
                if (downloadConfirmListener != null && (splashAD2 = GdtProviderSplash.this.splashAd) != null) {
                    splashAD2.setDownloadConfirmListener(downloadConfirmListener);
                }
                GdtProviderSplash.this.callbackSplashLoaded(adProviderType, alias, listener);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
                LogExtKt.logi(a.p(new StringBuilder(), adProviderType, ": 广告成功展示"), GdtProviderSplash.this.getTag());
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long millisUntilFinished) {
                LogExtKt.logv(adProviderType + ": 倒计时: " + f.S4(millisUntilFinished / 1000.0f), GdtProviderSplash.this.getTag());
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(@Nullable AdError adError) {
                GdtProviderSplash.this.splashAd = null;
                GdtProviderSplash.this.callbackSplashFailed(adProviderType, alias, listener, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
            }
        }, GdtProvider.Splash.INSTANCE.getMaxFetchDelay());
        this.splashAd = splashAD;
        if (splashAD != null) {
            splashAD.fetchAndShowIn(container);
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void loadOnlySplashAd(@NotNull Activity activity, @NotNull final String adProviderType, @NotNull final String alias, @NotNull final SplashListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        callbackSplashStartRequest(adProviderType, alias, listener);
        SplashAD splashAD = new SplashAD(activity, TogetherAdGdt.INSTANCE.getIdMapGDT().get(alias), new SplashADListener() { // from class: com.ifmvo.togetherad.gdt.provider.GdtProviderSplash.loadOnlySplashAd.1
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADClicked() {
                GdtProviderSplash.this.callbackSplashClicked(adProviderType, listener);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                GdtProviderSplash.this.mContainer = null;
                GdtProviderSplash.this.splashAd = null;
                GdtProviderSplash.this.callbackSplashDismiss(adProviderType, listener);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADExposure() {
                GdtProviderSplash.this.callbackSplashExposure(adProviderType, listener);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADLoaded(long expireTimestamp) {
                SplashAD splashAD2;
                GdtProviderSplash.this.mExpireTimestamp = expireTimestamp;
                DownloadConfirmListener downloadConfirmListener = TogetherAdGdt.INSTANCE.getDownloadConfirmListener();
                if (downloadConfirmListener != null && (splashAD2 = GdtProviderSplash.this.splashAd) != null) {
                    splashAD2.setDownloadConfirmListener(downloadConfirmListener);
                }
                GdtProviderSplash.this.callbackSplashLoaded(adProviderType, alias, listener);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
                LogExtKt.logi(a.p(new StringBuilder(), adProviderType, ": 广告成功展示"), GdtProviderSplash.this.getTag());
                SplashAD splashAD2 = GdtProviderSplash.this.splashAd;
                if (splashAD2 != null) {
                    splashAD2.preLoad();
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long millisUntilFinished) {
                LogExtKt.logv(adProviderType + ": 倒计时: " + f.S4(millisUntilFinished / 1000.0f), GdtProviderSplash.this.getTag());
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(@Nullable AdError adError) {
                GdtProviderSplash.this.mContainer = null;
                GdtProviderSplash.this.splashAd = null;
                GdtProviderSplash.this.callbackSplashFailed(adProviderType, alias, listener, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
            }
        }, GdtProvider.Splash.INSTANCE.getMaxFetchDelay());
        this.splashAd = splashAD;
        if (splashAD != null) {
            splashAD.fetchAdOnly();
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public boolean showSplashAd(@NotNull ViewGroup container) {
        j.f(container, "container");
        if (this.splashAd == null || SystemClock.elapsedRealtime() >= this.mExpireTimestamp) {
            return false;
        }
        this.mContainer = container;
        SplashAD splashAD = this.splashAd;
        if (splashAD == null) {
            return true;
        }
        splashAD.showAd(container);
        return true;
    }
}
