package com.ifmvo.togetherad.gdt.native_.view;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ifmvo.togetherad.core.custom.native_.BaseNativeView;
import com.ifmvo.togetherad.gdt.R;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
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
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BaseNativeViewGdt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u00002\u00020\u0001B.\u0012%\b\u0002\u0010Z\u001a\u001f\u0012\u0013\u0012\u00110#¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b($\u0012\u0004\u0012\u00020+\u0018\u00010G¢\u0006\u0004\b[\u0010\\J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0018\u0010\nJ\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\rJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\rJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\rJ\u0017\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001fH\u0016¢\u0006\u0004\b\"\u0010!J1\u0010,\u001a\u00020+2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020#2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u0011\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010@R\"\u0010A\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u00107\u001a\u0004\bB\u00109\"\u0004\bC\u0010;R\"\u0010D\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u00107\u001a\u0004\bE\u00109\"\u0004\bF\u0010;R3\u0010J\u001a\u001f\u0012\u0013\u0012\u00110#¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b($\u0012\u0004\u0012\u00020+\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010L\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u00107\u001a\u0004\bM\u00109\"\u0004\bN\u0010;R\"\u0010O\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u00107\u001a\u0004\bP\u00109\"\u0004\bQ\u0010;R\"\u0010R\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u00107\u001a\u0004\bS\u00109\"\u0004\bT\u0010;R\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010\u0004\"\u0004\bX\u0010Y¨\u0006]"}, d2 = {"Lcom/ifmvo/togetherad/gdt/native_/view/BaseNativeViewGdt;", "Lcom/ifmvo/togetherad/core/custom/native_/BaseNativeView;", "", "getLayoutRes", "()I", "Lcom/qq/e/ads/nativ/widget/NativeAdContainer;", "getNativeAdContainer", "()Lcom/qq/e/ads/nativ/widget/NativeAdContainer;", "Landroid/widget/ImageView;", "getIconImageView", "()Landroid/widget/ImageView;", "Landroid/widget/Button;", "getActionButton", "()Landroid/widget/Button;", "Landroid/view/View;", "getCloseButton", "()Landroid/view/View;", "Landroid/widget/TextView;", "getTitleTextView", "()Landroid/widget/TextView;", "getDescTextView", "Lcom/qq/e/ads/nativ/MediaView;", "getMediaView", "()Lcom/qq/e/ads/nativ/MediaView;", "getMainImageView", "Landroid/widget/CheckBox;", "getMuteCheckBox", "()Landroid/widget/CheckBox;", "getPlayButton", "getPauseButton", "getStopButton", "", "getClickableViews", "()Ljava/util/List;", "getCustomClickableViews", "", "adProviderType", "", "adObject", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/listener/NativeViewListener;", "listener", "Lf/v;", "showNative", "(Ljava/lang/String;Ljava/lang/Object;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/NativeViewListener;)V", "Lcom/qq/e/ads/nativ/NativeUnifiedADData;", ai.au, "getActionBtnText", "(Lcom/qq/e/ads/nativ/NativeUnifiedADData;)Ljava/lang/String;", "Landroid/widget/FrameLayout$LayoutParams;", "getLogoLayoutParams", "()Landroid/widget/FrameLayout$LayoutParams;", "", "enableDetailPage", "Z", "getEnableDetailPage", "()Z", "setEnableDetailPage", "(Z)V", "rootView", "Landroid/view/View;", "getRootView", "setRootView", "(Landroid/view/View;)V", "enableUserControl", "getEnableUserControl", "setEnableUserControl", "needProgressBar", "getNeedProgressBar", "setNeedProgressBar", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mOnClose", "Lf/c0/b/l;", "autoPlayMuted", "getAutoPlayMuted", "setAutoPlayMuted", "needCoverImage", "getNeedCoverImage", "setNeedCoverImage", "detailPageMuted", "getDetailPageMuted", "setDetailPageMuted", "autoPlayPolicy", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getAutoPlayPolicy", "setAutoPlayPolicy", "(I)V", "onClose", "<init>", "(Lf/c0/b/l;)V", "gdt_release"}, k = 1, mv = {1, 4, 0})
public abstract class BaseNativeViewGdt extends BaseNativeView {
    private boolean autoPlayMuted;
    private int autoPlayPolicy;
    private boolean detailPageMuted;
    private boolean enableDetailPage;
    private boolean enableUserControl;
    private l<? super String, v> mOnClose;
    private boolean needCoverImage;
    private boolean needProgressBar;

    @Nullable
    private View rootView;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseNativeViewGdt() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BaseNativeViewGdt(@Nullable l<? super String, v> lVar) {
        this.autoPlayMuted = true;
        this.autoPlayPolicy = 1;
        this.needCoverImage = true;
        this.needProgressBar = true;
        this.enableDetailPage = true;
        this.mOnClose = lVar;
    }

    @NotNull
    public String getActionBtnText(@NotNull NativeUnifiedADData ad) {
        j.f(ad, ai.au);
        if (!ad.isAppAd()) {
            return "浏览";
        }
        int appStatus = ad.getAppStatus();
        if (appStatus == 0) {
            return "下载";
        }
        if (appStatus == 1) {
            return "启动";
        }
        if (appStatus == 2) {
            return "更新";
        }
        if (appStatus != 4) {
            return appStatus != 8 ? appStatus != 16 ? "浏览" : "下载失败，重新下载" : "安装";
        }
        return String.valueOf(ad.getProgress()) + "%";
    }

    @Nullable
    public Button getActionButton() {
        View view = this.rootView;
        if (view != null) {
            return (Button) view.findViewById(R.id.btn_download);
        }
        return null;
    }

    public final boolean getAutoPlayMuted() {
        return this.autoPlayMuted;
    }

    public final int getAutoPlayPolicy() {
        return this.autoPlayPolicy;
    }

    @Nullable
    public List<View> getClickableViews() {
        ArrayList arrayList = new ArrayList();
        ImageView mainImageView = getMainImageView();
        if (mainImageView != null) {
            arrayList.add(mainImageView);
        }
        ImageView iconImageView = getIconImageView();
        if (iconImageView != null) {
            arrayList.add(iconImageView);
        }
        return arrayList;
    }

    @Nullable
    public View getCloseButton() {
        View view = this.rootView;
        if (view != null) {
            return view.findViewById(R.id.btn_close);
        }
        return null;
    }

    @Nullable
    public List<View> getCustomClickableViews() {
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
            return (TextView) view.findViewById(R.id.text_desc);
        }
        return null;
    }

    public final boolean getDetailPageMuted() {
        return this.detailPageMuted;
    }

    public final boolean getEnableDetailPage() {
        return this.enableDetailPage;
    }

    public final boolean getEnableUserControl() {
        return this.enableUserControl;
    }

    @Nullable
    public ImageView getIconImageView() {
        View view = this.rootView;
        if (view != null) {
            return (ImageView) view.findViewById(R.id.img_logo);
        }
        return null;
    }

    public int getLayoutRes() {
        return R.layout.layout_native_view_gdt;
    }

    @Nullable
    public FrameLayout.LayoutParams getLogoLayoutParams() {
        return null;
    }

    @Nullable
    public ImageView getMainImageView() {
        View view = this.rootView;
        if (view != null) {
            return (ImageView) view.findViewById(R.id.img_poster);
        }
        return null;
    }

    @Nullable
    public MediaView getMediaView() {
        View view = this.rootView;
        if (view != null) {
            return (MediaView) view.findViewById(R.id.gdt_media_view);
        }
        return null;
    }

    @Nullable
    public CheckBox getMuteCheckBox() {
        View view = this.rootView;
        if (view != null) {
            return (CheckBox) view.findViewById(R.id.btn_mute);
        }
        return null;
    }

    @Nullable
    public NativeAdContainer getNativeAdContainer() {
        View view = this.rootView;
        if (view != null) {
            return (NativeAdContainer) view.findViewById(R.id.native_ad_container);
        }
        return null;
    }

    public final boolean getNeedCoverImage() {
        return this.needCoverImage;
    }

    public final boolean getNeedProgressBar() {
        return this.needProgressBar;
    }

    @Nullable
    public Button getPauseButton() {
        View view = this.rootView;
        if (view != null) {
            return (Button) view.findViewById(R.id.btn_pause);
        }
        return null;
    }

    @Nullable
    public Button getPlayButton() {
        View view = this.rootView;
        if (view != null) {
            return (Button) view.findViewById(R.id.btn_play);
        }
        return null;
    }

    @Nullable
    public final View getRootView() {
        return this.rootView;
    }

    @Nullable
    public Button getStopButton() {
        View view = this.rootView;
        if (view != null) {
            return (Button) view.findViewById(R.id.btn_stop);
        }
        return null;
    }

    @Nullable
    public TextView getTitleTextView() {
        View view = this.rootView;
        if (view != null) {
            return (TextView) view.findViewById(R.id.text_title);
        }
        return null;
    }

    public final void setAutoPlayMuted(boolean z) {
        this.autoPlayMuted = z;
    }

    public final void setAutoPlayPolicy(int i2) {
        this.autoPlayPolicy = i2;
    }

    public final void setDetailPageMuted(boolean z) {
        this.detailPageMuted = z;
    }

    public final void setEnableDetailPage(boolean z) {
        this.enableDetailPage = z;
    }

    public final void setEnableUserControl(boolean z) {
        this.enableUserControl = z;
    }

    public final void setNeedCoverImage(boolean z) {
        this.needCoverImage = z;
    }

    public final void setNeedProgressBar(boolean z) {
        this.needProgressBar = z;
    }

    public final void setRootView(@Nullable View view) {
        this.rootView = view;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    @Override // com.ifmvo.togetherad.core.custom.native_.BaseNativeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void showNative(@org.jetbrains.annotations.NotNull final java.lang.String r17, @org.jetbrains.annotations.NotNull final java.lang.Object r18, @org.jetbrains.annotations.NotNull android.view.ViewGroup r19, @org.jetbrains.annotations.Nullable final com.ifmvo.togetherad.core.listener.NativeViewListener r20) {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ifmvo.togetherad.gdt.native_.view.BaseNativeViewGdt.showNative(java.lang.String, java.lang.Object, android.view.ViewGroup, com.ifmvo.togetherad.core.listener.NativeViewListener):void");
    }

    public /* synthetic */ BaseNativeViewGdt(l lVar, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : lVar);
    }
}
