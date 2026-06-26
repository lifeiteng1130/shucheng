package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.widget.text.AccentBgTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemImportBookBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f6805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f6806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f6807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AccentBgTextView f6808h;

    public ItemImportBookBinding(@NonNull LinearLayout linearLayout, @NonNull ATECheckBox aTECheckBox, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull AccentBgTextView accentBgTextView) {
        this.a = linearLayout;
        this.f6802b = aTECheckBox;
        this.f6803c = appCompatImageView;
        this.f6804d = linearLayout2;
        this.f6805e = textView;
        this.f6806f = textView2;
        this.f6807g = textView3;
        this.f6808h = accentBgTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
