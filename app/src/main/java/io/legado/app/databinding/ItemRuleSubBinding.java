package io.legado.app.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.text.AccentBgTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemRuleSubBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f6837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final AccentBgTextView f6838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f6839f;

    public ItemRuleSubBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull TextView textView, @NonNull AccentBgTextView accentBgTextView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f6835b = appCompatImageView;
        this.f6836c = appCompatImageView2;
        this.f6837d = textView;
        this.f6838e = accentBgTextView;
        this.f6839f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
