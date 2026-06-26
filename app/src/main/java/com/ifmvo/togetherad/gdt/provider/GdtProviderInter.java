package com.ifmvo.togetherad.gdt.provider;

import android.app.Activity;
import com.ifmvo.togetherad.core.listener.InterListener;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import com.ifmvo.togetherad.gdt.TogetherAdGdt;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GdtProviderInter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u000fJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProviderInter;", "Lcom/ifmvo/togetherad/gdt/provider/GdtProviderFullVideo;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "Lcom/ifmvo/togetherad/core/listener/InterListener;", "listener", "Lf/v;", "requestInterAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/InterListener;)V", "showInterAd", "(Landroid/app/Activity;)V", "destroyInterAd", "()V", "Lcom/qq/e/ads/interstitial2/UnifiedInterstitialAD;", "interAd", "Lcom/qq/e/ads/interstitial2/UnifiedInterstitialAD;", "<init>", "gdt_release"}, k = 1, mv = {1, 4, 0})
public abstract class GdtProviderInter extends GdtProviderFullVideo {
    private UnifiedInterstitialAD interAd;

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void destroyInterAd() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.interAd;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.close();
        }
        UnifiedInterstitialAD unifiedInterstitialAD2 = this.interAd;
        if (unifiedInterstitialAD2 != null) {
            unifiedInterstitialAD2.destroy();
        }
        this.interAd = null;
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void requestInterAd(@NotNull Activity activity, @NotNull final String adProviderType, @NotNull final String alias, @NotNull final InterListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        callbackInterStartRequest(adProviderType, alias, listener);
        destroyInterAd();
        UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD(activity, TogetherAdGdt.INSTANCE.getIdMapGDT().get(alias), new UnifiedInterstitialADListener() { // from class: com.ifmvo.togetherad.gdt.provider.GdtProviderInter.requestInterAd.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                GdtProviderInter.this.callbackInterClicked(adProviderType, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                GdtProviderInter.this.callbackInterClosed(adProviderType, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                GdtProviderInter.this.callbackInterExpose(adProviderType, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
                LogExtKt.logi("onADLeftApplication", GdtProviderInter.this.getTag());
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
                LogExtKt.logi("onADOpened", GdtProviderInter.this.getTag());
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                UnifiedInterstitialAD unifiedInterstitialAD2;
                DownloadConfirmListener downloadConfirmListener = TogetherAdGdt.INSTANCE.getDownloadConfirmListener();
                if (downloadConfirmListener != null && (unifiedInterstitialAD2 = GdtProviderInter.this.interAd) != null) {
                    unifiedInterstitialAD2.setDownloadConfirmListener(downloadConfirmListener);
                }
                GdtProviderInter.this.callbackInterLoaded(adProviderType, alias, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(@Nullable AdError adError) {
                GdtProviderInter.this.callbackInterFailed(adProviderType, alias, listener, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
                LogExtKt.logi("onVideoCached", GdtProviderInter.this.getTag());
            }
        });
        this.interAd = unifiedInterstitialAD;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.loadAD();
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void showInterAd(@NotNull Activity activity) {
        j.f(activity, "activity");
        UnifiedInterstitialAD unifiedInterstitialAD = this.interAd;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.show();
        }
    }
}
