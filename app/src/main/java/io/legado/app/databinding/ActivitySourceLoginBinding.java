package io.legado.app.databinding;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivitySourceLoginBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TitleBar f6566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final WebView f6567c;

    public ActivitySourceLoginBinding(@NonNull LinearLayout linearLayout, @NonNull TitleBar titleBar, @NonNull WebView webView) {
        this.a = linearLayout;
        this.f6566b = titleBar;
        this.f6567c = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
