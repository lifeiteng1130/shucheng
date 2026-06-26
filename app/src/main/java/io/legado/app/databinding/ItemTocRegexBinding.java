package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATERadioButton;
import io.legado.app.lib.theme.view.ATESwitch;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemTocRegexBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ATERadioButton f6858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final ATESwitch f6859e;

    public ItemTocRegexBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ATERadioButton aTERadioButton, @NonNull ATESwitch aTESwitch) {
        this.a = linearLayout;
        this.f6856b = appCompatImageView;
        this.f6857c = appCompatImageView2;
        this.f6858d = aTERadioButton;
        this.f6859e = aTESwitch;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
