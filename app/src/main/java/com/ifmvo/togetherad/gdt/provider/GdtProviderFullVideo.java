package com.ifmvo.togetherad.gdt.provider;

import android.app.Activity;
import com.ifmvo.togetherad.core.listener.FullVideoListener;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import com.ifmvo.togetherad.gdt.TogetherAdGdt;
import com.ifmvo.togetherad.gdt.provider.GdtProvider;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GdtProviderFullVideo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProviderFullVideo;", "Lcom/ifmvo/togetherad/gdt/provider/GdtProviderBanner;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "Lcom/ifmvo/togetherad/core/listener/FullVideoListener;", "listener", "Lf/v;", "requestFullVideoAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/FullVideoListener;)V", "", "showFullVideoAd", "(Landroid/app/Activity;)Z", "Lcom/qq/e/ads/interstitial2/UnifiedInterstitialAD;", "fullVideoAd", "Lcom/qq/e/ads/interstitial2/UnifiedInterstitialAD;", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
public abstract class GdtProviderFullVideo extends GdtProviderBanner {
    private UnifiedInterstitialAD fullVideoAd;

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void requestFullVideoAd(@NotNull Activity activity, @NotNull final String adProviderType, @NotNull final String alias, @NotNull final FullVideoListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        callbackFullVideoStartRequest(adProviderType, alias, listener);
        this.fullVideoAd = new UnifiedInterstitialAD(activity, TogetherAdGdt.INSTANCE.getIdMapGDT().get(alias), new UnifiedInterstitialADListener() { // from class: com.ifmvo.togetherad.gdt.provider.GdtProviderFullVideo.requestFullVideoAd.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                LogExtKt.logd("onADClicked", GdtProviderFullVideo.this.getTag());
                GdtProviderFullVideo.this.callbackFullVideoClicked(adProviderType, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                LogExtKt.logd("onADClosed", GdtProviderFullVideo.this.getTag());
                GdtProviderFullVideo.this.callbackFullVideoClosed(adProviderType, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                LogExtKt.logd("onADExposure", GdtProviderFullVideo.this.getTag());
                GdtProviderFullVideo.this.callbackFullVideoShow(adProviderType, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
                LogExtKt.logd("onADOpened", GdtProviderFullVideo.this.getTag());
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                UnifiedInterstitialAD unifiedInterstitialAD;
                LogExtKt.logd("onADReceive", GdtProviderFullVideo.this.getTag());
                DownloadConfirmListener downloadConfirmListener = TogetherAdGdt.INSTANCE.getDownloadConfirmListener();
                if (downloadConfirmListener != null && (unifiedInterstitialAD = GdtProviderFullVideo.this.fullVideoAd) != null) {
                    unifiedInterstitialAD.setDownloadConfirmListener(downloadConfirmListener);
                }
                GdtProviderFullVideo.this.callbackFullVideoLoaded(adProviderType, alias, listener);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(@Nullable AdError adError) {
                LogExtKt.logd("onNoAD", GdtProviderFullVideo.this.getTag());
                GdtProviderFullVideo.this.callbackFullVideoFailed(adProviderType, alias, listener, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
                LogExtKt.logd("onRenderFail", GdtProviderFullVideo.this.getTag());
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
                LogExtKt.logd("onRenderSuccess", GdtProviderFullVideo.this.getTag());
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
                LogExtKt.logd("onVideoCached", GdtProviderFullVideo.this.getTag());
                GdtProviderFullVideo.this.callbackFullVideoCached(adProviderType, listener);
            }
        });
        VideoOption.Builder builder = new VideoOption.Builder();
        GdtProvider.FullVideo fullVideo = GdtProvider.FullVideo.INSTANCE;
        VideoOption videoOptionBuild = builder.setAutoPlayMuted(fullVideo.getAutoPlayMuted()).setAutoPlayPolicy(fullVideo.getAutoPlayPolicy()).build();
        UnifiedInterstitialAD unifiedInterstitialAD = this.fullVideoAd;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setVideoOption(videoOptionBuild);
        }
        UnifiedInterstitialAD unifiedInterstitialAD2 = this.fullVideoAd;
        if (unifiedInterstitialAD2 != null) {
            unifiedInterstitialAD2.setVideoPlayPolicy(fullVideo.getVideoPlayPolicy());
        }
        UnifiedInterstitialAD unifiedInterstitialAD3 = this.fullVideoAd;
        if (unifiedInterstitialAD3 != null) {
            unifiedInterstitialAD3.setMaxVideoDuration(fullVideo.getMaxVideoDuration());
        }
        UnifiedInterstitialAD unifiedInterstitialAD4 = this.fullVideoAd;
        if (unifiedInterstitialAD4 != null) {
            unifiedInterstitialAD4.setMaxVideoDuration(fullVideo.getMinVideoDuration());
        }
        UnifiedInterstitialAD unifiedInterstitialAD5 = this.fullVideoAd;
        if (unifiedInterstitialAD5 != null) {
            unifiedInterstitialAD5.setMediaListener(new UnifiedInterstitialMediaListener() { // from class: com.ifmvo.togetherad.gdt.provider.GdtProviderFullVideo.requestFullVideoAd.2
                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoComplete() {
                    GdtProviderFullVideo.this.callbackFullVideoComplete(adProviderType, listener);
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoError(@Nullable AdError adError) {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoInit() {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoLoading() {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoPageClose() {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoPageOpen() {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoPause() {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoReady(long p0) {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoStart() {
                }
            });
        }
        UnifiedInterstitialAD unifiedInterstitialAD6 = this.fullVideoAd;
        if (unifiedInterstitialAD6 != null) {
            unifiedInterstitialAD6.loadFullScreenAD();
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public boolean showFullVideoAd(@NotNull Activity activity) {
        j.f(activity, "activity");
        UnifiedInterstitialAD unifiedInterstitialAD = this.fullVideoAd;
        if (unifiedInterstitialAD == null || !unifiedInterstitialAD.isValid()) {
            return false;
        }
        UnifiedInterstitialAD unifiedInterstitialAD2 = this.fullVideoAd;
        if (unifiedInterstitialAD2 != null) {
            unifiedInterstitialAD2.showFullScreenAD(activity);
        }
        return true;
    }
}
