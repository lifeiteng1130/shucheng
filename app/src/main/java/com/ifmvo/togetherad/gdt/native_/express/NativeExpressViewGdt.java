package com.ifmvo.togetherad.gdt.native_.express;

import android.view.View;
import android.view.ViewGroup;
import com.ifmvo.togetherad.core.custom.express.BaseNativeExpressView;
import com.ifmvo.togetherad.gdt.TogetherAdGdt;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeExpressViewGdt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/ifmvo/togetherad/gdt/native_/express/NativeExpressViewGdt;", "Lcom/ifmvo/togetherad/core/custom/express/BaseNativeExpressView;", "", "adProviderType", "", "adObject", "Landroid/view/ViewGroup;", "container", "Lf/v;", "showNativeExpress", "(Ljava/lang/String;Ljava/lang/Object;Landroid/view/ViewGroup;)V", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
public final class NativeExpressViewGdt extends BaseNativeExpressView {
    @Override // com.ifmvo.togetherad.core.custom.express.BaseNativeExpressView
    public void showNativeExpress(@NotNull String adProviderType, @NotNull Object adObject, @NotNull ViewGroup container) {
        j.f(adProviderType, "adProviderType");
        j.f(adObject, "adObject");
        j.f(container, "container");
        if (adObject instanceof NativeExpressADView) {
            DownloadConfirmListener downloadConfirmListener = TogetherAdGdt.INSTANCE.getDownloadConfirmListener();
            if (downloadConfirmListener != null) {
                ((NativeExpressADView) adObject).setDownloadConfirmListener(downloadConfirmListener);
            }
            NativeExpressADView nativeExpressADView = (NativeExpressADView) adObject;
            AdData boundData = nativeExpressADView.getBoundData();
            j.b(boundData, "adObject.boundData");
            if (boundData.getAdPatternType() == 2) {
                nativeExpressADView.setMediaListener(new NativeExpressMediaListener() { // from class: com.ifmvo.togetherad.gdt.native_.express.NativeExpressViewGdt.showNativeExpress.2
                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoCached(@Nullable NativeExpressADView adView) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoComplete(@Nullable NativeExpressADView adView) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoError(@Nullable NativeExpressADView adView, @Nullable AdError adError) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoInit(@Nullable NativeExpressADView adView) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoLoading(@Nullable NativeExpressADView adView) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoPageClose(@Nullable NativeExpressADView adView) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoPageOpen(@Nullable NativeExpressADView adView) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoPause(@Nullable NativeExpressADView adView) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoReady(@Nullable NativeExpressADView adView, long time) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoStart(@Nullable NativeExpressADView adView) {
                    }
                });
            }
            nativeExpressADView.render();
            if (container.getChildCount() > 0) {
                container.removeAllViews();
            }
            container.addView((View) adObject);
        }
    }
}
