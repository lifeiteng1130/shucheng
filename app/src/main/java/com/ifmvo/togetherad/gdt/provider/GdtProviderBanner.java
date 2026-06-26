package com.ifmvo.togetherad.gdt.provider;

import android.app.Activity;
import android.view.ViewGroup;
import com.ifmvo.togetherad.core.listener.BannerListener;
import com.ifmvo.togetherad.core.provider.BaseAdProvider;
import com.ifmvo.togetherad.gdt.TogetherAdGdt;
import com.ifmvo.togetherad.gdt.provider.GdtProvider;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GdtProviderBanner.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u000fJ7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProviderBanner;", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/listener/BannerListener;", "listener", "Lf/v;", "showBannerAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/BannerListener;)V", "destroyBannerAd", "()V", "Lcom/qq/e/ads/banner2/UnifiedBannerView;", "banner", "Lcom/qq/e/ads/banner2/UnifiedBannerView;", "<init>", "gdt_release"}, k = 1, mv = {1, 4, 0})
public abstract class GdtProviderBanner extends BaseAdProvider {
    private UnifiedBannerView banner;

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void destroyBannerAd() {
        UnifiedBannerView unifiedBannerView = this.banner;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
        this.banner = null;
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void showBannerAd(@NotNull Activity activity, @NotNull final String adProviderType, @NotNull final String alias, @NotNull ViewGroup container, @NotNull final BannerListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(container, "container");
        j.f(listener, "listener");
        callbackBannerStartRequest(adProviderType, alias, listener);
        destroyBannerAd();
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView(activity, TogetherAdGdt.INSTANCE.getIdMapGDT().get(alias), new UnifiedBannerADListener() { // from class: com.ifmvo.togetherad.gdt.provider.GdtProviderBanner.showBannerAd.1
            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClicked() {
                GdtProviderBanner.this.callbackBannerClicked(adProviderType, listener);
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADCloseOverlay() {
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClosed() {
                GdtProviderBanner.this.destroyBannerAd();
                GdtProviderBanner.this.callbackBannerClosed(adProviderType, listener);
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADExposure() {
                GdtProviderBanner.this.callbackBannerExpose(adProviderType, listener);
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADOpenOverlay() {
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADReceive() {
                UnifiedBannerView unifiedBannerView2;
                DownloadConfirmListener downloadConfirmListener = TogetherAdGdt.INSTANCE.getDownloadConfirmListener();
                if (downloadConfirmListener != null && (unifiedBannerView2 = GdtProviderBanner.this.banner) != null) {
                    unifiedBannerView2.setDownloadConfirmListener(downloadConfirmListener);
                }
                GdtProviderBanner.this.callbackBannerLoaded(adProviderType, alias, listener);
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onNoAD(@Nullable AdError adError) {
                GdtProviderBanner.this.destroyBannerAd();
                GdtProviderBanner.this.callbackBannerFailed(adProviderType, alias, listener, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
            }
        });
        this.banner = unifiedBannerView;
        container.addView(unifiedBannerView);
        UnifiedBannerView unifiedBannerView2 = this.banner;
        if (unifiedBannerView2 != null) {
            unifiedBannerView2.setRefresh(GdtProvider.Banner.INSTANCE.getSlideIntervalTime());
        }
        UnifiedBannerView unifiedBannerView3 = this.banner;
        if (unifiedBannerView3 != null) {
            unifiedBannerView3.loadAD();
        }
    }
}
