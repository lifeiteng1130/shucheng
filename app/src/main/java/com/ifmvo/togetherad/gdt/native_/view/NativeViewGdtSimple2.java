package com.ifmvo.togetherad.gdt.native_.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ifmvo.togetherad.core.listener.NativeViewListener;
import com.ifmvo.togetherad.core.utils.ScreenUtil;
import com.ifmvo.togetherad.gdt.R;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeViewGdtSimple2.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/ifmvo/togetherad/gdt/native_/view/NativeViewGdtSimple2;", "Lcom/ifmvo/togetherad/gdt/native_/view/BaseNativeViewGdt;", "", "getLayoutRes", "()I", "Lcom/qq/e/ads/nativ/widget/NativeAdContainer;", "getNativeAdContainer", "()Lcom/qq/e/ads/nativ/widget/NativeAdContainer;", "Landroid/widget/TextView;", "getTitleTextView", "()Landroid/widget/TextView;", "getDescTextView", "Lcom/qq/e/ads/nativ/MediaView;", "getMediaView", "()Lcom/qq/e/ads/nativ/MediaView;", "Landroid/widget/ImageView;", "getMainImageView", "()Landroid/widget/ImageView;", "", "adProviderType", "", "adObject", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/listener/NativeViewListener;", "listener", "Lf/v;", "showNative", "(Ljava/lang/String;Ljava/lang/Object;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/NativeViewListener;)V", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
public final class NativeViewGdtSimple2 extends BaseNativeViewGdt {
    public NativeViewGdtSimple2() {
        super(null, 1, null);
    }

    @Override // com.ifmvo.togetherad.gdt.native_.view.BaseNativeViewGdt
    @Nullable
    public TextView getDescTextView() {
        View rootView = getRootView();
        if (rootView != null) {
            return (TextView) rootView.findViewById(R.id.tv_desc);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.gdt.native_.view.BaseNativeViewGdt
    public int getLayoutRes() {
        return R.layout.layout_native_view_gdt_simple_2;
    }

    @Override // com.ifmvo.togetherad.gdt.native_.view.BaseNativeViewGdt
    @Nullable
    public ImageView getMainImageView() {
        View rootView = getRootView();
        if (rootView != null) {
            return (ImageView) rootView.findViewById(R.id.img_poster);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.gdt.native_.view.BaseNativeViewGdt
    @Nullable
    public MediaView getMediaView() {
        View rootView = getRootView();
        if (rootView != null) {
            return (MediaView) rootView.findViewById(R.id.gdt_media_view);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.gdt.native_.view.BaseNativeViewGdt
    @Nullable
    public NativeAdContainer getNativeAdContainer() {
        View rootView = getRootView();
        if (rootView != null) {
            return (NativeAdContainer) rootView.findViewById(R.id.native_ad_container);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.gdt.native_.view.BaseNativeViewGdt
    @Nullable
    public TextView getTitleTextView() {
        View rootView = getRootView();
        if (rootView != null) {
            return (TextView) rootView.findViewById(R.id.tv_title);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.gdt.native_.view.BaseNativeViewGdt, com.ifmvo.togetherad.core.custom.native_.BaseNativeView
    public void showNative(@NotNull String adProviderType, @NotNull Object adObject, @NotNull ViewGroup container, @Nullable NativeViewListener listener) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        j.f(adProviderType, "adProviderType");
        j.f(adObject, "adObject");
        j.f(container, "container");
        super.showNative(adProviderType, adObject, container, listener);
        ImageView mainImageView = getMainImageView();
        if (mainImageView != null && (layoutParams2 = mainImageView.getLayoutParams()) != null) {
            ScreenUtil screenUtil = ScreenUtil.INSTANCE;
            Context context = container.getContext();
            j.b(context, "container.context");
            layoutParams2.height = ((screenUtil.getDisplayMetricsWidth(context) / 3) * 9) / 16;
        }
        MediaView mediaView = getMediaView();
        if (mediaView == null || (layoutParams = mediaView.getLayoutParams()) == null) {
            return;
        }
        ScreenUtil screenUtil2 = ScreenUtil.INSTANCE;
        Context context2 = container.getContext();
        j.b(context2, "container.context");
        layoutParams.height = ((screenUtil2.getDisplayMetricsWidth(context2) / 3) * 9) / 16;
    }
}
