package com.ifmvo.togetherad.csj.native_.express;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.ifmvo.togetherad.core.custom.express.BaseNativeExpressView;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NativeExpressViewCsj.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/ifmvo/togetherad/csj/native_/express/NativeExpressViewCsj;", "Lcom/ifmvo/togetherad/core/custom/express/BaseNativeExpressView;", "", "adProviderType", "", "adObject", "Landroid/view/ViewGroup;", "container", "Lf/v;", "showNativeExpress", "(Ljava/lang/String;Ljava/lang/Object;Landroid/view/ViewGroup;)V", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
public final class NativeExpressViewCsj extends BaseNativeExpressView {
    @Override // com.ifmvo.togetherad.core.custom.express.BaseNativeExpressView
    public void showNativeExpress(@NotNull String adProviderType, @NotNull Object adObject, @NotNull ViewGroup container) {
        j.f(adProviderType, "adProviderType");
        j.f(adObject, "adObject");
        j.f(container, "container");
        if (adObject instanceof TTNativeExpressAd) {
            TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) adObject;
            tTNativeExpressAd.render();
            View expressAdView = tTNativeExpressAd.getExpressAdView();
            ViewParent parent = expressAdView != null ? expressAdView.getParent() : null;
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeAllViews();
            }
            container.addView(tTNativeExpressAd.getExpressAdView());
        }
    }
}
