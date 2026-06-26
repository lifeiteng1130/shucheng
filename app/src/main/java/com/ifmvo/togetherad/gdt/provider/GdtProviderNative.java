package com.ifmvo.togetherad.gdt.provider;

import android.app.Activity;
import com.ifmvo.togetherad.core.listener.NativeListener;
import com.ifmvo.togetherad.gdt.TogetherAdGdt;
import com.ifmvo.togetherad.gdt.provider.GdtProvider;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import f.c0.c.j;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GdtProviderNative.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProviderNative;", "Lcom/ifmvo/togetherad/gdt/provider/GdtProviderInter;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "", "maxCount", "Lcom/ifmvo/togetherad/core/listener/NativeListener;", "listener", "Lf/v;", "getNativeAdList", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;ILcom/ifmvo/togetherad/core/listener/NativeListener;)V", "", "adObject", "", "nativeAdIsBelongTheProvider", "(Ljava/lang/Object;)Z", "resumeNativeAd", "(Ljava/lang/Object;)V", "pauseNativeAd", "destroyNativeAd", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
public abstract class GdtProviderNative extends GdtProviderInter {
    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void destroyNativeAd(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        if (adObject instanceof NativeUnifiedADData) {
            ((NativeUnifiedADData) adObject).destroy();
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void getNativeAdList(@NotNull Activity activity, @NotNull final String adProviderType, @NotNull final String alias, int maxCount, @NotNull final NativeListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        callbackNativeStartRequest(adProviderType, alias, listener);
        NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(activity, TogetherAdGdt.INSTANCE.getIdMapGDT().get(alias), new NativeADUnifiedListener() { // from class: com.ifmvo.togetherad.gdt.provider.GdtProviderNative$getNativeAdList$nativeADUnifiedListener$1
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(@Nullable List<? extends NativeUnifiedADData> adList) {
                if (adList == null || adList.isEmpty()) {
                    this.this$0.callbackNativeFailed(adProviderType, alias, listener, null, "请求成功，但是返回的list为空");
                } else {
                    this.this$0.callbackNativeLoaded(adProviderType, alias, listener, adList);
                }
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(@Nullable AdError adError) {
                this.this$0.callbackNativeFailed(adProviderType, alias, listener, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
            }
        });
        GdtProvider.Native r2 = GdtProvider.Native.INSTANCE;
        nativeUnifiedAD.setBrowserType(r2.getBrowserType());
        nativeUnifiedAD.setDownAPPConfirmPolicy(r2.getDownAPPConfirmPolicy());
        List<String> categories = r2.getCategories();
        if (categories != null) {
            nativeUnifiedAD.setCategories(categories);
        }
        nativeUnifiedAD.setMaxVideoDuration(r2.getMaxVideoDuration());
        nativeUnifiedAD.setMinVideoDuration(r2.getMinVideoDuration());
        nativeUnifiedAD.setVideoPlayPolicy(r2.getVideoPlayPolicy());
        nativeUnifiedAD.setVideoADContainerRender(1);
        nativeUnifiedAD.loadData(maxCount);
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public boolean nativeAdIsBelongTheProvider(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        return adObject instanceof NativeUnifiedADData;
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void pauseNativeAd(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        if (adObject instanceof NativeUnifiedADData) {
            NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) adObject;
            if (nativeUnifiedADData.getAdPatternType() == 2) {
                nativeUnifiedADData.pauseVideo();
            }
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void resumeNativeAd(@NotNull Object adObject) {
        j.f(adObject, "adObject");
        if (adObject instanceof NativeUnifiedADData) {
            NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) adObject;
            nativeUnifiedADData.resume();
            if (nativeUnifiedADData.getAdPatternType() == 2) {
                nativeUnifiedADData.resumeVideo();
            }
        }
    }
}
