package com.ifmvo.togetherad.core.custom.splashSkip;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ifmvo.togetherad.core.R;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SplashSkipViewSimple2.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/ifmvo/togetherad/core/custom/splashSkip/SplashSkipViewSimple2;", "Lcom/ifmvo/togetherad/core/custom/splashSkip/BaseSplashSkipView;", "Landroid/content/Context;", c.R, "Landroid/view/View;", "onCreateSkipView", "(Landroid/content/Context;)Landroid/view/View;", "", "second", "Lf/v;", "handleTime", "(I)V", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "Landroid/widget/TextView;", "tvTime", "Landroid/widget/TextView;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public final class SplashSkipViewSimple2 extends BaseSplashSkipView {
    private TextView tvTime;

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
    public void handleTime(int second) {
        TextView textView = this.tvTime;
        if (textView != null) {
            textView.setText(String.valueOf(second));
        } else {
            j.m("tvTime");
            throw null;
        }
    }

    @Override // com.ifmvo.togetherad.core.custom.splashSkip.BaseSplashSkipView
    @NotNull
    public View onCreateSkipView(@NotNull Context context) {
        j.f(context, c.R);
        View viewInflate = View.inflate(context, R.layout.layout_splash_skip_view_simple2, null);
        View viewFindViewById = viewInflate.findViewById(R.id.time);
        j.b(viewFindViewById, "skipView.findViewById(R.id.time)");
        this.tvTime = (TextView) viewFindViewById;
        j.b(viewInflate, "skipView");
        return viewInflate;
    }
}
