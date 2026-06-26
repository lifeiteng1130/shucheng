package com.ifmvo.togetherad.csj.native_.view;

import android.content.Context;
import android.view.ViewGroup;
import com.ifmvo.togetherad.core.listener.NativeViewListener;
import com.ifmvo.togetherad.core.utils.ScreenUtil;
import f.c0.b.l;
import f.c0.c.f;
import f.c0.c.j;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeViewCsjSimple5.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B.\u0012%\b\u0002\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ifmvo/togetherad/csj/native_/view/NativeViewCsjSimple5;", "Lcom/ifmvo/togetherad/csj/native_/view/BaseNativeViewCsj;", "", "adProviderType", "", "adObject", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/listener/NativeViewListener;", "listener", "Lf/v;", "showNative", "(Ljava/lang/String;Ljava/lang/Object;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/NativeViewListener;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onClose", "<init>", "(Lf/c0/b/l;)V", "csj_release"}, k = 1, mv = {1, 4, 0})
public final class NativeViewCsjSimple5 extends BaseNativeViewCsj {
    /* JADX WARN: Multi-variable type inference failed */
    public NativeViewCsjSimple5() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public NativeViewCsjSimple5(@Nullable l<? super String, v> lVar) {
        super(lVar);
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

    public /* synthetic */ NativeViewCsjSimple5(l lVar, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : lVar);
    }
}
