package com.ifmvo.togetherad.csj.native_.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.ifmvo.togetherad.core.custom.native_.BaseNativeView;
import com.ifmvo.togetherad.csj.R;
import com.umeng.analytics.pro.ai;
import f.c0.b.l;
import f.c0.c.f;
import f.c0.c.j;
import f.v;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseNativeViewCsjFeed.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B.\u0012%\b\u0002\u00107\u001a\u001f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b( \u0012\u0004\u0012\u00020&\u0018\u000102¢\u0006\u0004\b8\u00109J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ1\u0010'\u001a\u00020&2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u00101R3\u00105\u001a\u001f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b( \u0012\u0004\u0012\u00020&\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/ifmvo/togetherad/csj/native_/view/BaseNativeViewCsjFeed;", "Lcom/ifmvo/togetherad/core/custom/native_/BaseNativeView;", "", "getLayoutRes", "()I", "Landroid/widget/ImageView;", "getAdLogoImageView", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "getTitleTextView", "()Landroid/widget/TextView;", "getDescTextView", "getSourceTextView", "getIconImageView", "getMainImageView_1", "getMainImageView_2", "getMainImageView_3", "Landroid/view/ViewGroup;", "getVideoContainer", "()Landroid/view/ViewGroup;", "getImageContainer", "Landroid/widget/Button;", "getActionButton", "()Landroid/widget/Button;", "Landroid/view/View;", "getCloseButton", "()Landroid/view/View;", "", "getClickableViews", "()Ljava/util/List;", "getCreativeViews", "", "adProviderType", "", "adObject", "container", "Lcom/ifmvo/togetherad/core/listener/NativeViewListener;", "listener", "Lf/v;", "showNative", "(Ljava/lang/String;Ljava/lang/Object;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/NativeViewListener;)V", "Lcom/bytedance/sdk/openadsdk/TTNativeAd;", ai.au, "getActionBtnText", "(Lcom/bytedance/sdk/openadsdk/TTNativeAd;)Ljava/lang/String;", "rootView", "Landroid/view/View;", "getRootView", "setRootView", "(Landroid/view/View;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mOnClose", "Lf/c0/b/l;", "onClose", "<init>", "(Lf/c0/b/l;)V", "csj_release"}, k = 1, mv = {1, 4, 0})
public abstract class BaseNativeViewCsjFeed extends BaseNativeView {
    private l<? super String, v> mOnClose;

    @Nullable
    private View rootView;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseNativeViewCsjFeed() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BaseNativeViewCsjFeed(@Nullable l<? super String, v> lVar) {
        this.mOnClose = lVar;
    }

    @NotNull
    public String getActionBtnText(@NotNull TTNativeAd ad) {
        j.f(ad, ai.au);
        int interactionType = ad.getInteractionType();
        return (interactionType == 2 || interactionType == 3) ? "查看详情" : interactionType != 4 ? interactionType != 5 ? "查看详情" : "立即拨打" : "下载";
    }

    @Nullable
    public Button getActionButton() {
        View view = this.rootView;
        if (view != null) {
            return (Button) view.findViewById(R.id.csj_btn_action);
        }
        return null;
    }

    @Nullable
    public ImageView getAdLogoImageView() {
        View view = this.rootView;
        if (view != null) {
            return (ImageView) view.findViewById(R.id.csj_ad_logo);
        }
        return null;
    }

    @Nullable
    public List<View> getClickableViews() {
        ArrayList arrayList = new ArrayList();
        View view = this.rootView;
        if (view != null) {
            arrayList.add(view);
            return arrayList;
        }
        j.l();
        throw null;
    }

    @Nullable
    public View getCloseButton() {
        View view = this.rootView;
        if (view != null) {
            return view.findViewById(R.id.csj_btn_close);
        }
        return null;
    }

    @Nullable
    public List<View> getCreativeViews() {
        ArrayList arrayList = new ArrayList();
        Button actionButton = getActionButton();
        if (actionButton != null) {
            arrayList.add(actionButton);
        }
        return arrayList;
    }

    @Nullable
    public TextView getDescTextView() {
        View view = this.rootView;
        if (view != null) {
            return (TextView) view.findViewById(R.id.csj_tv_desc);
        }
        return null;
    }

    @Nullable
    public ImageView getIconImageView() {
        View view = this.rootView;
        if (view != null) {
            return (ImageView) view.findViewById(R.id.csj_img_logo);
        }
        return null;
    }

    @Nullable
    public ViewGroup getImageContainer() {
        View view = this.rootView;
        if (view != null) {
            return (ViewGroup) view.findViewById(R.id.csj_img_container);
        }
        return null;
    }

    public int getLayoutRes() {
        return R.layout.layout_native_view_csj;
    }

    @Nullable
    public ImageView getMainImageView_1() {
        View view = this.rootView;
        if (view != null) {
            return (ImageView) view.findViewById(R.id.csj_img_poster1);
        }
        return null;
    }

    @Nullable
    public ImageView getMainImageView_2() {
        View view = this.rootView;
        if (view != null) {
            return (ImageView) view.findViewById(R.id.csj_img_poster2);
        }
        return null;
    }

    @Nullable
    public ImageView getMainImageView_3() {
        View view = this.rootView;
        if (view != null) {
            return (ImageView) view.findViewById(R.id.csj_img_poster2);
        }
        return null;
    }

    @Nullable
    public final View getRootView() {
        return this.rootView;
    }

    @Nullable
    public TextView getSourceTextView() {
        View view = this.rootView;
        if (view != null) {
            return (TextView) view.findViewById(R.id.csj_tv_source);
        }
        return null;
    }

    @Nullable
    public TextView getTitleTextView() {
        View view = this.rootView;
        if (view != null) {
            return (TextView) view.findViewById(R.id.csj_tv_title);
        }
        return null;
    }

    @Nullable
    public ViewGroup getVideoContainer() {
        View view = this.rootView;
        if (view != null) {
            return (ViewGroup) view.findViewById(R.id.csj_video_container);
        }
        return null;
    }

    public final void setRootView(@Nullable View view) {
        this.rootView = view;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c6  */
    @Override // com.ifmvo.togetherad.core.custom.native_.BaseNativeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void showNative(@org.jetbrains.annotations.NotNull final java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.Object r10, @org.jetbrains.annotations.NotNull android.view.ViewGroup r11, @org.jetbrains.annotations.Nullable final com.ifmvo.togetherad.core.listener.NativeViewListener r12) {
        /*
            Method dump skipped, instruction units count: 741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ifmvo.togetherad.csj.native_.view.BaseNativeViewCsjFeed.showNative(java.lang.String, java.lang.Object, android.view.ViewGroup, com.ifmvo.togetherad.core.listener.NativeViewListener):void");
    }

    public /* synthetic */ BaseNativeViewCsjFeed(l lVar, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : lVar);
    }
}
