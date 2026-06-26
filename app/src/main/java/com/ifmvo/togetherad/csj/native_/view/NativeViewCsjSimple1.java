package com.ifmvo.togetherad.csj.native_.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ifmvo.togetherad.core.listener.NativeViewListener;
import com.ifmvo.togetherad.core.utils.ScreenUtil;
import com.ifmvo.togetherad.csj.R;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeViewCsjSimple1.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J1\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/ifmvo/togetherad/csj/native_/view/NativeViewCsjSimple1;", "Lcom/ifmvo/togetherad/csj/native_/view/BaseNativeViewCsj;", "", "getLayoutRes", "()I", "Landroid/view/ViewGroup;", "getImageContainer", "()Landroid/view/ViewGroup;", "Landroid/widget/ImageView;", "getMainImageView_1", "()Landroid/widget/ImageView;", "getMainImageView_2", "getMainImageView_3", "getVideoContainer", "Landroid/widget/TextView;", "getTitleTextView", "()Landroid/widget/TextView;", "getDescTextView", "", "adProviderType", "", "adObject", "container", "Lcom/ifmvo/togetherad/core/listener/NativeViewListener;", "listener", "Lf/v;", "showNative", "(Ljava/lang/String;Ljava/lang/Object;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/NativeViewListener;)V", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
public final class NativeViewCsjSimple1 extends BaseNativeViewCsj {
    public NativeViewCsjSimple1() {
        super(null, 1, null);
    }

    @Override // com.ifmvo.togetherad.csj.native_.view.BaseNativeViewCsjFeed
    @Nullable
    public TextView getDescTextView() {
        View rootView = getRootView();
        if (rootView != null) {
            return (TextView) rootView.findViewById(R.id.tv_desc);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.csj.native_.view.BaseNativeViewCsjFeed
    @Nullable
    public ViewGroup getImageContainer() {
        View rootView = getRootView();
        if (rootView != null) {
            return (ViewGroup) rootView.findViewById(R.id.ll_ad_container);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.csj.native_.view.BaseNativeViewCsjFeed
    public int getLayoutRes() {
        return R.layout.layout_native_view_csj_simple_1;
    }

    @Override // com.ifmvo.togetherad.csj.native_.view.BaseNativeViewCsjFeed
    @Nullable
    public ImageView getMainImageView_1() {
        View rootView = getRootView();
        if (rootView != null) {
            return (ImageView) rootView.findViewById(R.id.img_poster1);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.csj.native_.view.BaseNativeViewCsjFeed
    @Nullable
    public ImageView getMainImageView_2() {
        View rootView = getRootView();
        if (rootView != null) {
            return (ImageView) rootView.findViewById(R.id.img_poster2);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.csj.native_.view.BaseNativeViewCsjFeed
    @Nullable
    public ImageView getMainImageView_3() {
        View rootView = getRootView();
        if (rootView != null) {
            return (ImageView) rootView.findViewById(R.id.img_poster3);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.csj.native_.view.BaseNativeViewCsjFeed
    @Nullable
    public TextView getTitleTextView() {
        View rootView = getRootView();
        if (rootView != null) {
            return (TextView) rootView.findViewById(R.id.tv_title);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.csj.native_.view.BaseNativeViewCsjFeed
    @Nullable
    public ViewGroup getVideoContainer() {
        View rootView = getRootView();
        if (rootView != null) {
            return (ViewGroup) rootView.findViewById(R.id.fl_ad_container);
        }
        return null;
    }

    @Override // com.ifmvo.togetherad.csj.native_.view.BaseNativeViewCsj, com.ifmvo.togetherad.csj.native_.view.BaseNativeViewCsjFeed, com.ifmvo.togetherad.core.custom.native_.BaseNativeView
    public void showNative(@NotNull String adProviderType, @NotNull Object adObject, @NotNull ViewGroup container, @Nullable NativeViewListener listener) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        j.f(adProviderType, "adProviderType");
        j.f(adObject, "adObject");
        j.f(container, "container");
        super.showNative(adProviderType, adObject, container, listener);
        ViewGroup imageContainer = getImageContainer();
        if (imageContainer != null && (layoutParams2 = imageContainer.getLayoutParams()) != null) {
            ScreenUtil screenUtil = ScreenUtil.INSTANCE;
            Context context = container.getContext();
            j.b(context, "container.context");
            layoutParams2.height = (screenUtil.getDisplayMetricsWidth(context) * 9) / 16;
        }
        ViewGroup videoContainer = getVideoContainer();
        if (videoContainer == null || (layoutParams = videoContainer.getLayoutParams()) == null) {
            return;
        }
        ScreenUtil screenUtil2 = ScreenUtil.INSTANCE;
        Context context2 = container.getContext();
        j.b(context2, "container.context");
        layoutParams.height = (screenUtil2.getDisplayMetricsWidth(context2) * 9) / 16;
    }
}
