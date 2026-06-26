package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.lib.theme.view.ATESwitch;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemRssSourceBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final ATESwitch f6834e;

    public ItemRssSourceBinding(@NonNull LinearLayout linearLayout, @NonNull ATECheckBox aTECheckBox, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ATESwitch aTESwitch) {
        this.a = linearLayout;
        this.f6831b = aTECheckBox;
        this.f6832c = appCompatImageView;
        this.f6833d = appCompatImageView2;
        this.f6834e = aTESwitch;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
