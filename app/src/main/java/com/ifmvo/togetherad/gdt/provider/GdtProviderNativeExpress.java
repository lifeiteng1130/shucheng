package com.ifmvo.togetherad.gdt.provider;

import android.app.Activity;
import com.ifmvo.togetherad.core.listener.NativeExpressListener;
import com.ifmvo.togetherad.gdt.TogetherAdGdt;
import com.ifmvo.togetherad.gdt.provider.GdtProvider;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import f.c0.c.j;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GdtProviderNativeExpress.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProviderNativeExpress;", "Lcom/ifmvo/togetherad/gdt/provider/GdtProviderNative;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "", "adCount", "Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;", "listener", "Lf/v;", "getNativeExpressAdList", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;ILcom/ifmvo/togetherad/core/listener/NativeExpressListener;)V", "", "adObject", "destroyNativeExpressAd", "(Ljava/lang/Object;)V", "", "nativeExpressAdIsBelongTheProvider", "(Ljava/lang/Object;)Z", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
public abstract class GdtProviderNativeExpress extends GdtProviderNative {
    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void destroyNativeExpressAd(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        if (adObject instanceof NativeExpressADView) {
            ((NativeExpressADView) adObject).destroy();
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void getNativeExpressAdList(@NotNull Activity activity, @NotNull final String adProviderType, @NotNull final String alias, int adCount, @NotNull final NativeExpressListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        callbackNativeExpressStartRequest(adProviderType, alias, listener);
        NativeExpressAD.NativeExpressADListener nativeExpressADListener = new NativeExpressAD.NativeExpressADListener() { // from class: com.ifmvo.togetherad.gdt.provider.GdtProviderNativeExpress$getNativeExpressAdList$nativeExpressADListener$1
            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClicked(@Nullable NativeExpressADView adView) {
                this.this$0.callbackNativeExpressClicked(adProviderType, adView, listener);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADCloseOverlay(@Nullable NativeExpressADView adView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClosed(@Nullable NativeExpressADView adView) {
                this.this$0.callbackNativeExpressClosed(adProviderType, adView, listener);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADExposure(@Nullable NativeExpressADView adView) {
                this.this$0.callbackNativeExpressShow(adProviderType, adView, listener);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLeftApplication(@Nullable NativeExpressADView adView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLoaded(@Nullable List<NativeExpressADView> ads) {
                if (ads == null || ads.isEmpty()) {
                    this.this$0.callbackNativeExpressFailed(adProviderType, alias, listener, null, "请求成功，但是返回的list为空");
                } else {
                    this.this$0.callbackNativeExpressLoaded(adProviderType, alias, listener, ads);
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADOpenOverlay(@Nullable NativeExpressADView adView) {
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(@Nullable AdError adError) {
                this.this$0.callbackNativeExpressFailed(adProviderType, alias, listener, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderFail(@Nullable NativeExpressADView adView) {
                this.this$0.callbackNativeExpressRenderFail(adProviderType, adView, listener);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderSuccess(@Nullable NativeExpressADView adView) {
                this.this$0.callbackNativeExpressRenderSuccess(adProviderType, adView, listener);
            }
        };
        GdtProvider.NativeExpress nativeExpress = GdtProvider.NativeExpress.INSTANCE;
        NativeExpressAD nativeExpressAD = new NativeExpressAD(activity, new ADSize(nativeExpress.getAdWidth$gdt_release(), nativeExpress.getAdHeight$gdt_release()), TogetherAdGdt.INSTANCE.getIdMapGDT().get(alias), nativeExpressADListener);
        nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(nativeExpress.getAutoPlayPolicy()).setAutoPlayMuted(nativeExpress.getAutoPlayMuted()).build());
        nativeExpressAD.setVideoPlayPolicy(nativeExpress.getVideoPlayPolicy());
        nativeExpressAD.setMinVideoDuration(nativeExpress.getMinVideoDuration());
        nativeExpressAD.setMaxVideoDuration(nativeExpress.getMaxVideoDuration());
        nativeExpressAD.loadAD(adCount);
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public boolean nativeExpressAdIsBelongTheProvider(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        return adObject instanceof NativeExpressADView;
    }
}
