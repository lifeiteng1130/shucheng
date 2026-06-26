package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATERadioButton;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemHttpTtsBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ATERadioButton f6797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6799d;

    public ItemHttpTtsBinding(@NonNull LinearLayout linearLayout, @NonNull ATERadioButton aTERadioButton, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2) {
        this.a = linearLayout;
        this.f6797b = aTERadioButton;
        this.f6798c = appCompatImageView;
        this.f6799d = appCompatImageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
