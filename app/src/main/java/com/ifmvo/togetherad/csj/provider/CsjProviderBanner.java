package com.ifmvo.togetherad.csj.provider;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.ifmvo.togetherad.core.listener.BannerListener;
import com.ifmvo.togetherad.core.provider.BaseAdProvider;
import com.ifmvo.togetherad.csj.TogetherAdCsj;
import com.ifmvo.togetherad.csj.provider.CsjProvider;
import com.ifmvo.togetherad.csj.provider.CsjProviderBanner;
import f.c0.c.j;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: CsjProviderBanner.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u000fJ7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProviderBanner;", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/listener/BannerListener;", "listener", "Lf/v;", "showBannerAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/BannerListener;)V", "destroyBannerAd", "()V", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "mTTNativeExpressBannerAd", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "<init>", "csj_release"}, k = 1, mv = {1, 4, 0})
public abstract class CsjProviderBanner extends BaseAdProvider {
    private TTNativeExpressAd mTTNativeExpressBannerAd;

    /* JADX INFO: renamed from: com.ifmvo.togetherad.csj.provider.CsjProviderBanner$showBannerAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: CsjProviderBanner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/ifmvo/togetherad/csj/provider/CsjProviderBanner$showBannerAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$NativeExpressAdListener;", "", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "adList", "Lf/v;", "onNativeExpressAdLoad", "(Ljava/util/List;)V", "", "errorCode", "", "errorMsg", "onError", "(ILjava/lang/String;)V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 implements TTAdNative.NativeExpressAdListener {
        public final /* synthetic */ Activity $activity;
        public final /* synthetic */ String $adProviderType;
        public final /* synthetic */ String $alias;
        public final /* synthetic */ ViewGroup $container;
        public final /* synthetic */ BannerListener $listener;

        public AnonymousClass1(String str, String str2, BannerListener bannerListener, ViewGroup viewGroup, Activity activity) {
            this.$adProviderType = str;
            this.$alias = str2;
            this.$listener = bannerListener;
            this.$container = viewGroup;
            this.$activity = activity;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int errorCode, @Nullable String errorMsg) {
            CsjProviderBanner.this.destroyBannerAd();
            CsjProviderBanner.this.callbackBannerFailed(this.$adProviderType, this.$alias, this.$listener, Integer.valueOf(errorCode), errorMsg);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(@Nullable List<TTNativeExpressAd> adList) {
            if (adList == null || adList.isEmpty()) {
                CsjProviderBanner.this.callbackBannerFailed(this.$adProviderType, this.$alias, this.$listener, null, "请求成功，但是返回的list为空");
                return;
            }
            CsjProviderBanner.this.mTTNativeExpressBannerAd = adList.get(0);
            TTNativeExpressAd tTNativeExpressAd = CsjProviderBanner.this.mTTNativeExpressBannerAd;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setSlideIntervalTime(CsjProvider.Banner.INSTANCE.getSlideIntervalTime());
            }
            TTNativeExpressAd tTNativeExpressAd2 = CsjProviderBanner.this.mTTNativeExpressBannerAd;
            if (tTNativeExpressAd2 != null) {
                tTNativeExpressAd2.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderBanner$showBannerAd$1$onNativeExpressAdLoad$1
                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(@Nullable View p0, int p1) {
                        CsjProviderBanner.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderBanner.this.callbackBannerClicked(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(@Nullable View view, int p1) {
                        CsjProviderBanner.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderBanner.this.callbackBannerExpose(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(@Nullable View view, @Nullable String errorMsg, int errorCode) {
                        CsjProviderBanner.this.destroyBannerAd();
                        CsjProviderBanner.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderBanner.this.callbackBannerFailed(anonymousClass1.$adProviderType, anonymousClass1.$alias, anonymousClass1.$listener, Integer.valueOf(errorCode), errorMsg);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(@Nullable View view, float p1, float p2) {
                        CsjProviderBanner.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderBanner.this.callbackBannerLoaded(anonymousClass1.$adProviderType, anonymousClass1.$alias, anonymousClass1.$listener);
                        this.this$0.$container.addView(view);
                    }
                });
            }
            TTNativeExpressAd tTNativeExpressAd3 = CsjProviderBanner.this.mTTNativeExpressBannerAd;
            if (tTNativeExpressAd3 != null) {
                tTNativeExpressAd3.setDislikeCallback(this.$activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderBanner$showBannerAd$1$onNativeExpressAdLoad$2
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int position, @NotNull String value, boolean enforce) {
                        j.f(value, ES6Iterator.VALUE_PROPERTY);
                        this.this$0.$container.removeAllViews();
                        CsjProviderBanner.this.destroyBannerAd();
                        CsjProviderBanner.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderBanner.this.callbackBannerClosed(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                    }
                });
            }
            TTNativeExpressAd tTNativeExpressAd4 = CsjProviderBanner.this.mTTNativeExpressBannerAd;
            if (tTNativeExpressAd4 != null) {
                tTNativeExpressAd4.render();
            }
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void destroyBannerAd() {
        TTNativeExpressAd tTNativeExpressAd = this.mTTNativeExpressBannerAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
        this.mTTNativeExpressBannerAd = null;
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void showBannerAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull ViewGroup container, @NotNull BannerListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(container, "container");
        j.f(listener, "listener");
        destroyBannerAd();
        callbackBannerStartRequest(adProviderType, alias, listener);
        AdSlot.Builder builder = new AdSlot.Builder();
        TogetherAdCsj togetherAdCsj = TogetherAdCsj.INSTANCE;
        AdSlot.Builder codeId = builder.setDownloadType(togetherAdCsj.getDownloadType()).setCodeId(togetherAdCsj.getIdMapCsj().get(alias));
        CsjProvider.Banner banner = CsjProvider.Banner.INSTANCE;
        togetherAdCsj.getMTTAdManager().createAdNative(activity).loadBannerExpressAd(codeId.setSupportDeepLink(banner.getSupportDeepLink()).setAdCount(1).setExpressViewAcceptedSize(banner.getExpressViewAcceptedSizeWidth$csj_release(), banner.getExpressViewAcceptedSizeHeight$csj_release()).setImageAcceptedSize(640, 320).build(), new AnonymousClass1(adProviderType, alias, listener, container, activity));
    }
}
