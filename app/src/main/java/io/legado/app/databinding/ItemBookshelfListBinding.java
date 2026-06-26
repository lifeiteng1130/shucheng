package io.legado.app.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.anima.RotateLoading;
import io.legado.app.ui.widget.image.CoverImageView;
import io.legado.app.ui.widget.text.BadgeView;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemBookshelfListBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BadgeView f6761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CoverImageView f6762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RotateLoading f6763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f6764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f6765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f6766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f6767h;

    public ItemBookshelfListBinding(@NonNull ConstraintLayout constraintLayout, @NonNull BadgeView badgeView, @NonNull ConstraintLayout constraintLayout2, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull CoverImageView coverImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull RotateLoading rotateLoading, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull View view) {
        this.a = constraintLayout;
        this.f6761b = badgeView;
        this.f6762c = coverImageView;
        this.f6763d = rotateLoading;
        this.f6764e = textView;
        this.f6765f = textView2;
        this.f6766g = textView3;
        this.f6767h = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
