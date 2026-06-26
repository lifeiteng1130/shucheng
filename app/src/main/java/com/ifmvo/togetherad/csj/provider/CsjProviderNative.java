package com.ifmvo.togetherad.csj.provider;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.ifmvo.togetherad.core.listener.NativeListener;
import com.ifmvo.togetherad.csj.TogetherAdCsj;
import com.ifmvo.togetherad.csj.provider.CsjProvider;
import f.c0.c.j;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CsjProviderNative.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ7\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProviderNative;", "Lcom/ifmvo/togetherad/csj/provider/CsjProviderInter;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "", "maxCount", "Lcom/ifmvo/togetherad/core/listener/NativeListener;", "listener", "Lf/v;", "getStreamAdList", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;ILcom/ifmvo/togetherad/core/listener/NativeListener;)V", "getNativeAdList", "", "adObject", "resumeNativeAd", "(Ljava/lang/Object;)V", "pauseNativeAd", "destroyNativeAd", "", "nativeAdIsBelongTheProvider", "(Ljava/lang/Object;)Z", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
public abstract class CsjProviderNative extends CsjProviderInter {
    private final void getStreamAdList(Activity activity, final String adProviderType, final String alias, int maxCount, final NativeListener listener) {
        callbackNativeStartRequest(adProviderType, alias, listener);
        AdSlot.Builder builder = new AdSlot.Builder();
        TogetherAdCsj togetherAdCsj = TogetherAdCsj.INSTANCE;
        AdSlot.Builder codeId = builder.setDownloadType(togetherAdCsj.getDownloadType()).setCodeId(togetherAdCsj.getIdMapCsj().get(alias));
        CsjProvider.Native r2 = CsjProvider.Native.INSTANCE;
        togetherAdCsj.getMTTAdManager().createAdNative(activity).loadStream(codeId.setImageAcceptedSize(r2.getImageAcceptedSizeWidth$csj_release(), r2.getImageAcceptedSizeHeight$csj_release()).setAdCount(maxCount).build(), new TTAdNative.FeedAdListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderNative.getStreamAdList.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int errorCode, @Nullable String errorMsg) {
                CsjProviderNative.this.callbackNativeFailed(adProviderType, alias, listener, Integer.valueOf(errorCode), errorMsg);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(@Nullable List<TTFeedAd> adList) {
                if (adList == null || adList.isEmpty()) {
                    CsjProviderNative.this.callbackNativeFailed(adProviderType, alias, listener, null, "请求成功，但是返回的list为空");
                } else {
                    CsjProviderNative.this.callbackNativeLoaded(adProviderType, alias, listener, adList);
                }
            }
        });
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void destroyNativeAd(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        if (adObject instanceof TTNativeAd) {
            ((TTNativeAd) adObject).destroy();
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void getNativeAdList(@NotNull Activity activity, @NotNull final String adProviderType, @NotNull final String alias, int maxCount, @NotNull final NativeListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        CsjProvider.Native r0 = CsjProvider.Native.INSTANCE;
        if (r0.getNativeAdType() == -1) {
            throw new IllegalArgumentException("\n    |-------------------------------------------------------------------------------------- \n    |  必须在每次请求穿山甲的原生广告之前设置类型。\n    |  设置方式：\n    |  CsjProvider.Native.nativeAdType = AdSlot.TYPE_XXX（类型和你的广告位ID一致）。\n    |  CsjProvider.Native.nativeAdType = AdSlot.TYPE_FEED\n    |  CsjProvider.Native.nativeAdType = AdSlot.TYPE_INTERACTION_AD\n    |  CsjProvider.Native.nativeAdType = AdSlot.TYPE_BANNER\n    |  CsjProvider.Native.nativeAdType = AdSlot.TYPE_CACHED_SPLASH\n    |  CsjProvider.Native.nativeAdType = AdSlot.TYPE_DRAW_FEED\n    |  CsjProvider.Native.nativeAdType = AdSlot.TYPE_FULL_SCREEN_VIDEO\n    |  CsjProvider.Native.nativeAdType = AdSlot.TYPE_REWARD_VIDEO\n    |  CsjProvider.Native.nativeAdType = AdSlot.TYPE_SPLASH\n    |  CsjProvider.Native.nativeAdType = AdSlot.TYPE_STREAM\n    |  任选其一\n    |--------------------------------------------------------------------------------------\n\n");
        }
        if (r0.getNativeAdType() == 6) {
            getStreamAdList(activity, adProviderType, alias, maxCount, listener);
            return;
        }
        callbackNativeStartRequest(adProviderType, alias, listener);
        AdSlot.Builder builder = new AdSlot.Builder();
        TogetherAdCsj togetherAdCsj = TogetherAdCsj.INSTANCE;
        togetherAdCsj.getMTTAdManager().createAdNative(activity).loadNativeAd(builder.setDownloadType(togetherAdCsj.getDownloadType()).setCodeId(togetherAdCsj.getIdMapCsj().get(alias)).setSupportDeepLink(r0.getSupportDeepLink()).setImageAcceptedSize(r0.getImageAcceptedSizeWidth$csj_release(), r0.getImageAcceptedSizeHeight$csj_release()).setNativeAdType(r0.getNativeAdType()).setAdCount(maxCount).build(), new TTAdNative.NativeAdListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderNative.getNativeAdList.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int errorCode, @Nullable String errorMsg) {
                CsjProviderNative.this.callbackNativeFailed(adProviderType, alias, listener, Integer.valueOf(errorCode), errorMsg);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
            public void onNativeAdLoad(@Nullable List<TTNativeAd> adList) {
                if (adList == null || adList.isEmpty()) {
                    CsjProviderNative.this.callbackNativeFailed(adProviderType, alias, listener, null, "请求成功，但是返回的list为空");
                } else {
                    CsjProviderNative.this.callbackNativeLoaded(adProviderType, alias, listener, adList);
                }
            }
        });
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public boolean nativeAdIsBelongTheProvider(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        return adObject instanceof TTNativeAd;
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void pauseNativeAd(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        boolean z = adObject instanceof TTNativeAd;
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void resumeNativeAd(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        boolean z = adObject instanceof TTNativeAd;
    }
}
