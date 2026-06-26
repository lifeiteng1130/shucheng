package io.legado.app.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.rss.read.VisibleWebView;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityRssReadBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f6542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TitleBar f6544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final VisibleWebView f6545e;

    public ActivityRssReadBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull LinearLayout linearLayout, @NonNull TitleBar titleBar, @NonNull VisibleWebView visibleWebView) {
        this.a = frameLayout;
        this.f6542b = frameLayout2;
        this.f6543c = linearLayout;
        this.f6544d = titleBar;
        this.f6545e = visibleWebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
