package io.legado.app.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.lib.theme.view.ATESwitch;
import io.legado.app.ui.widget.image.CircleImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemBookSourceBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final CircleImageView f6751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ATESwitch f6753f;

    public ItemBookSourceBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ATECheckBox aTECheckBox, @NonNull AppCompatImageView appCompatImageView, @NonNull CircleImageView circleImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ATESwitch aTESwitch) {
        this.a = constraintLayout;
        this.f6749b = aTECheckBox;
        this.f6750c = appCompatImageView;
        this.f6751d = circleImageView;
        this.f6752e = appCompatImageView2;
        this.f6753f = aTESwitch;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
