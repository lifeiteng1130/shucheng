package com.ifmvo.togetherad.csj.provider;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.ifmvo.togetherad.core.listener.InterListener;
import com.ifmvo.togetherad.csj.TogetherAdCsj;
import com.ifmvo.togetherad.csj.provider.CsjProvider;
import com.ifmvo.togetherad.csj.provider.CsjProviderInter;
import f.c0.c.j;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CsjProviderInter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u000fJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProviderInter;", "Lcom/ifmvo/togetherad/csj/provider/CsjProviderFullVideo;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "Lcom/ifmvo/togetherad/core/listener/InterListener;", "listener", "Lf/v;", "requestInterAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/InterListener;)V", "showInterAd", "(Landroid/app/Activity;)V", "destroyInterAd", "()V", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "mTTNativeExpressInterAd", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "<init>", "csj_release"}, k = 1, mv = {1, 4, 0})
public abstract class CsjProviderInter extends CsjProviderFullVideo {
    private TTNativeExpressAd mTTNativeExpressInterAd;

    /* JADX INFO: renamed from: com.ifmvo.togetherad.csj.provider.CsjProviderInter$requestInterAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: CsjProviderInter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/ifmvo/togetherad/csj/provider/CsjProviderInter$requestInterAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$NativeExpressAdListener;", "", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "adList", "Lf/v;", "onNativeExpressAdLoad", "(Ljava/util/List;)V", "", "errorCode", "", "errorMsg", "onError", "(ILjava/lang/String;)V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 implements TTAdNative.NativeExpressAdListener {
        public final /* synthetic */ Activity $activity;
        public final /* synthetic */ String $adProviderType;
        public final /* synthetic */ String $alias;
        public final /* synthetic */ InterListener $listener;

        public AnonymousClass1(String str, String str2, InterListener interListener, Activity activity) {
            this.$adProviderType = str;
            this.$alias = str2;
            this.$listener = interListener;
            this.$activity = activity;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int errorCode, @Nullable String errorMsg) {
            CsjProviderInter.this.callbackInterFailed(this.$adProviderType, this.$alias, this.$listener, Integer.valueOf(errorCode), errorMsg);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(@Nullable List<TTNativeExpressAd> adList) {
            if (adList == null || adList.isEmpty()) {
                CsjProviderInter.this.callbackInterFailed(this.$adProviderType, this.$alias, this.$listener, null, "请求成功，但是返回的list为空");
                return;
            }
            CsjProviderInter.this.callbackInterLoaded(this.$adProviderType, this.$alias, this.$listener);
            CsjProviderInter.this.mTTNativeExpressInterAd = adList.get(0);
            TTNativeExpressAd tTNativeExpressAd = CsjProviderInter.this.mTTNativeExpressInterAd;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.AdInteractionListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderInter$requestInterAd$1$onNativeExpressAdLoad$1
                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(@Nullable View p0, int p1) {
                        CsjProviderInter.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderInter.this.callbackInterClicked(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
                    public void onAdDismiss() {
                        CsjProviderInter.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderInter.this.callbackInterClosed(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(@Nullable View view, int p1) {
                        CsjProviderInter.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderInter.this.callbackInterExpose(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(@Nullable View view, @Nullable String errorMsg, int errorCode) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(@Nullable View view, float p1, float p2) {
                        TTNativeExpressAd tTNativeExpressAd2 = CsjProviderInter.this.mTTNativeExpressInterAd;
                        if (tTNativeExpressAd2 != null) {
                            tTNativeExpressAd2.showInteractionExpressAd(this.this$0.$activity);
                        }
                    }
                });
            }
            TTNativeExpressAd tTNativeExpressAd2 = CsjProviderInter.this.mTTNativeExpressInterAd;
            if (tTNativeExpressAd2 != null) {
                tTNativeExpressAd2.setDislikeCallback(this.$activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderInter$requestInterAd$1$onNativeExpressAdLoad$2
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int p0, @Nullable String p1, boolean enforce) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                    }
                });
            }
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void destroyInterAd() {
        TTNativeExpressAd tTNativeExpressAd = this.mTTNativeExpressInterAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
        this.mTTNativeExpressInterAd = null;
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void requestInterAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull InterListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        destroyInterAd();
        callbackInterStartRequest(adProviderType, alias, listener);
        AdSlot.Builder builder = new AdSlot.Builder();
        TogetherAdCsj togetherAdCsj = TogetherAdCsj.INSTANCE;
        AdSlot.Builder codeId = builder.setDownloadType(togetherAdCsj.getDownloadType()).setCodeId(togetherAdCsj.getIdMapCsj().get(alias));
        CsjProvider.Inter inter = CsjProvider.Inter.INSTANCE;
        togetherAdCsj.getMTTAdManager().createAdNative(activity).loadInteractionExpressAd(codeId.setSupportDeepLink(inter.getSupportDeepLink()).setExpressViewAcceptedSize(inter.getExpressViewAcceptedSizeWidth$csj_release(), inter.getExpressViewAcceptedSizeHeight$csj_release()).setImageAcceptedSize(640, 320).setAdCount(1).build(), new AnonymousClass1(adProviderType, alias, listener, activity));
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void showInterAd(@NotNull Activity activity) {
        j.f(activity, "activity");
        TTNativeExpressAd tTNativeExpressAd = this.mTTNativeExpressInterAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.render();
        }
    }
}
