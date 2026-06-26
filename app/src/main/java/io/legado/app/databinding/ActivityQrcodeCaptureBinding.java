package io.legado.app.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityQrcodeCaptureBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    public ActivityQrcodeCaptureBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull TitleBar titleBar) {
        this.a = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
