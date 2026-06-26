package io.legado.app.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.flexbox.FlexboxLayout;
import io.legado.app.ui.widget.anima.RotateLoading;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemFindBookBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FlexboxLayout f6785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f6786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final RotateLoading f6788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f6789f;

    public ItemFindBookBinding(@NonNull LinearLayout linearLayout, @NonNull FlexboxLayout flexboxLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull RotateLoading rotateLoading, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f6785b = flexboxLayout;
        this.f6786c = imageView;
        this.f6787d = linearLayout2;
        this.f6788e = rotateLoading;
        this.f6789f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
