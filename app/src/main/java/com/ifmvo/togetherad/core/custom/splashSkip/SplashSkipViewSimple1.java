package com.ifmvo.togetherad.core.custom.splashSkip;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ifmvo.togetherad.core.R;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SplashSkipViewSimple1.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ifmvo/togetherad/core/custom/splashSkip/SplashSkipViewSimple1;", "Lcom/ifmvo/togetherad/core/custom/splashSkip/BaseSplashSkipView;", "Landroid/content/Context;", c.R, "Landroid/view/View;", "onCreateSkipView", "(Landroid/content/Context;)Landroid/view/View;", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public final class SplashSkipViewSimple1 extends BaseSplashSkipView {
    @Override // com.ifmvo.togetherad.core.custom.splashSkip.BaseSplashSkipView
    @NotNull
    public ViewGroup.LayoutParams getLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = 50;
        layoutParams.rightMargin = 30;
        return layoutParams;
    }

    @Override // com.ifmvo.togetherad.core.custom.splashSkip.BaseSplashSkipView
    @NotNull
    public View onCreateSkipView(@NotNull Context context) {
        j.f(context, c.R);
        View viewInflate = View.inflate(context, R.layout.layout_splash_skip_view_simple1, null);
        j.b(viewInflate, "View.inflate(context, R.…_skip_view_simple1, null)");
        return viewInflate;
    }
}
