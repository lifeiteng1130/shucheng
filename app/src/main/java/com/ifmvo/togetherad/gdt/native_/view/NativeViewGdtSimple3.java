package com.ifmvo.togetherad.gdt.native_.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.core.FocusMeteringAction;
import c.b.a.m.f;
import com.ifmvo.togetherad.core.custom.splashSkip.SplashSkipViewSimple2;
import com.ifmvo.togetherad.core.listener.NativeViewListener;
import com.ifmvo.togetherad.gdt.R;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeViewGdtSimple3.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B.\u0012%\b\u0002\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001d¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR3\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/ifmvo/togetherad/gdt/native_/view/NativeViewGdtSimple3;", "Lcom/ifmvo/togetherad/gdt/native_/view/BaseNativeViewGdt;", "", "getLayoutRes", "()I", "Lcom/qq/e/ads/nativ/widget/NativeAdContainer;", "getNativeAdContainer", "()Lcom/qq/e/ads/nativ/widget/NativeAdContainer;", "Landroid/widget/TextView;", "getTitleTextView", "()Landroid/widget/TextView;", "getDescTextView", "Lcom/qq/e/ads/nativ/MediaView;", "getMediaView", "()Lcom/qq/e/ads/nativ/MediaView;", "Landroid/widget/ImageView;", "getMainImageView", "()Landroid/widget/ImageView;", "", "adProviderType", "", "adObject", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/listener/NativeViewListener;", "listener", "Lf/v;", "showNative", "(Ljava/lang/String;Ljava/lang/Object;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/NativeViewListener;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mOnClose", "Lf/c0/b/l;", "Landroid/os/CountDownTimer;", "mTimer", "Landroid/os/CountDownTimer;", "onClose", "<init>", "(Lf/c0/b/l;)V", "gdt_release"}, k = 1, mv = {1, 4, 0})
public final class NativeViewGdtSimple3 extends BaseNativeViewGdt {
    private l<? super String, v> mOnClose;
    private CountDownTimer mTimer;

    /* JADX WARN: Multi-variable type inference failed */
    public NativeViewGdtSimple3() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public NativeViewGdtSimple3(@Nullable l<? super String, v> lVar) {
        super(null, 1, null);
        this.mOnClose = lVar;
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
        return R.layout.layout_native_view_gdt_simple_3;
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
    public void showNative(@NotNull final String adProviderType, @NotNull Object adObject, @NotNull final ViewGroup container, @Nullable NativeViewListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(adObject, "adObject");
        j.f(container, "container");
        super.showNative(adProviderType, adObject, container, listener);
        final SplashSkipViewSimple2 splashSkipViewSimple2 = new SplashSkipViewSimple2();
        Context context = container.getContext();
        j.b(context, "container.context");
        View viewOnCreateSkipView = splashSkipViewSimple2.onCreateSkipView(context);
        container.addView(viewOnCreateSkipView, splashSkipViewSimple2.getLayoutParams());
        viewOnCreateSkipView.setOnClickListener(new View.OnClickListener() { // from class: com.ifmvo.togetherad.gdt.native_.view.NativeViewGdtSimple3$showNative$$inlined$run$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CountDownTimer countDownTimer = this.this$0.mTimer;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                container.removeAllViews();
                l lVar = this.this$0.mOnClose;
                if (lVar != null) {
                }
            }
        });
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION, 1000L) { // from class: com.ifmvo.togetherad.gdt.native_.view.NativeViewGdtSimple3.showNative.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                container.removeAllViews();
                l lVar = NativeViewGdtSimple3.this.mOnClose;
                if (lVar != null) {
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                splashSkipViewSimple2.handleTime(f.S4(millisUntilFinished / 1000.0f));
            }
        };
        this.mTimer = countDownTimer2;
        if (countDownTimer2 != null) {
            countDownTimer2.start();
        }
    }

    public /* synthetic */ NativeViewGdtSimple3(l lVar, int i2, f.c0.c.f fVar) {
        this((i2 & 1) != 0 ? null : lVar);
    }
}
