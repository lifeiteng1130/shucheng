package com.ifmvo.togetherad.csj.provider;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.ifmvo.togetherad.core.listener.NativeExpressListener;
import com.ifmvo.togetherad.csj.TogetherAdCsj;
import com.ifmvo.togetherad.csj.provider.CsjProvider;
import com.ifmvo.togetherad.csj.provider.CsjProviderNativeExpress;
import f.c0.c.j;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CsjProviderNativeExpress.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProviderNativeExpress;", "Lcom/ifmvo/togetherad/csj/provider/CsjProviderNative;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "", "adCount", "Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;", "listener", "Lf/v;", "getNativeExpressAdList", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;ILcom/ifmvo/togetherad/core/listener/NativeExpressListener;)V", "", "adObject", "destroyNativeExpressAd", "(Ljava/lang/Object;)V", "", "nativeExpressAdIsBelongTheProvider", "(Ljava/lang/Object;)Z", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
public abstract class CsjProviderNativeExpress extends CsjProviderNative {

    /* JADX INFO: renamed from: com.ifmvo.togetherad.csj.provider.CsjProviderNativeExpress$getNativeExpressAdList$1, reason: invalid class name */
    /* JADX INFO: compiled from: CsjProviderNativeExpress.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/ifmvo/togetherad/csj/provider/CsjProviderNativeExpress$getNativeExpressAdList$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$NativeExpressAdListener;", "", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "ads", "Lf/v;", "onNativeExpressAdLoad", "(Ljava/util/List;)V", "", "errorCode", "", "errorMsg", "onError", "(ILjava/lang/String;)V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 implements TTAdNative.NativeExpressAdListener {
        public final /* synthetic */ Activity $activity;
        public final /* synthetic */ String $adProviderType;
        public final /* synthetic */ String $alias;
        public final /* synthetic */ NativeExpressListener $listener;

        public AnonymousClass1(String str, String str2, NativeExpressListener nativeExpressListener, Activity activity) {
            this.$adProviderType = str;
            this.$alias = str2;
            this.$listener = nativeExpressListener;
            this.$activity = activity;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int errorCode, @Nullable String errorMsg) {
            CsjProviderNativeExpress.this.callbackNativeExpressFailed(this.$adProviderType, this.$alias, this.$listener, Integer.valueOf(errorCode), errorMsg);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(@Nullable List<TTNativeExpressAd> ads) {
            if (ads == null || ads.isEmpty()) {
                CsjProviderNativeExpress.this.callbackNativeExpressFailed(this.$adProviderType, this.$alias, this.$listener, null, "请求成功，但是返回的list为空");
                return;
            }
            for (final TTNativeExpressAd tTNativeExpressAd : ads) {
                tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderNativeExpress$getNativeExpressAdList$1$onNativeExpressAdLoad$$inlined$forEach$lambda$1
                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(@Nullable View view, int type) {
                        CsjProviderNativeExpress.AnonymousClass1 anonymousClass1 = this;
                        anonymousClass1.$listener.onAdClicked(anonymousClass1.$adProviderType, tTNativeExpressAd);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(@Nullable View view, int type) {
                        CsjProviderNativeExpress.AnonymousClass1 anonymousClass1 = this;
                        anonymousClass1.$listener.onAdShow(anonymousClass1.$adProviderType, tTNativeExpressAd);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(@Nullable View view, @Nullable String str, int i2) {
                        CsjProviderNativeExpress.AnonymousClass1 anonymousClass1 = this;
                        anonymousClass1.$listener.onAdRenderFail(anonymousClass1.$adProviderType, tTNativeExpressAd);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(@Nullable View view, float f2, float f3) {
                        CsjProviderNativeExpress.AnonymousClass1 anonymousClass1 = this;
                        anonymousClass1.$listener.onAdRenderSuccess(anonymousClass1.$adProviderType, tTNativeExpressAd);
                    }
                });
                tTNativeExpressAd.setDislikeCallback(this.$activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderNativeExpress$getNativeExpressAdList$1$onNativeExpressAdLoad$$inlined$forEach$lambda$2
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i2, @Nullable String str, boolean z) {
                        CsjProviderNativeExpress.AnonymousClass1 anonymousClass1 = this;
                        anonymousClass1.$listener.onAdClosed(anonymousClass1.$adProviderType, tTNativeExpressAd);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                    }
                });
            }
            CsjProviderNativeExpress.this.callbackNativeExpressLoaded(this.$adProviderType, this.$alias, this.$listener, ads);
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void destroyNativeExpressAd(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        if (adObject instanceof TTNativeExpressAd) {
            ((TTNativeExpressAd) adObject).destroy();
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void getNativeExpressAdList(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, int adCount, @NotNull NativeExpressListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        callbackNativeExpressStartRequest(adProviderType, alias, listener);
        AdSlot.Builder builder = new AdSlot.Builder();
        TogetherAdCsj togetherAdCsj = TogetherAdCsj.INSTANCE;
        AdSlot.Builder codeId = builder.setDownloadType(togetherAdCsj.getDownloadType()).setCodeId(togetherAdCsj.getIdMapCsj().get(alias));
        CsjProvider.NativeExpress nativeExpress = CsjProvider.NativeExpress.INSTANCE;
        togetherAdCsj.getMTTAdManager().createAdNative(activity).loadNativeExpressAd(codeId.setSupportDeepLink(nativeExpress.getSupportDeepLink()).setAdCount(adCount).setExpressViewAcceptedSize(nativeExpress.getExpressViewAcceptedSizeWidth$csj_release(), nativeExpress.getExpressViewAcceptedSizeHeight$csj_release()).build(), new AnonymousClass1(adProviderType, alias, listener, activity));
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public boolean nativeExpressAdIsBelongTheProvider(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        return adObject instanceof TTNativeExpressAd;
    }
}
