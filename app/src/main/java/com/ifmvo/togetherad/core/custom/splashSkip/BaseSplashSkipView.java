package com.ifmvo.togetherad.core.custom.splashSkip;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.umeng.analytics.pro.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BaseSplashSkipView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/ifmvo/togetherad/core/custom/splashSkip/BaseSplashSkipView;", "", "Landroid/content/Context;", c.R, "Landroid/view/View;", "onCreateSkipView", "(Landroid/content/Context;)Landroid/view/View;", "", "second", "Lf/v;", "handleTime", "(I)V", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public abstract class BaseSplashSkipView {
    @NotNull
    public abstract ViewGroup.LayoutParams getLayoutParams();

    public void handleTime(int second) {
    }

    @NotNull
    public abstract View onCreateSkipView(@NotNull Context context);
}
