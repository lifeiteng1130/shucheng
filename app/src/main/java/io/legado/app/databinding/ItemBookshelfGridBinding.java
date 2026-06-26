package io.legado.app.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.anima.RotateLoading;
import io.legado.app.ui.widget.image.CoverImageView;
import io.legado.app.ui.widget.text.BadgeView;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemBookshelfGridBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BadgeView f6757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CoverImageView f6758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RotateLoading f6759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f6760e;

    public ItemBookshelfGridBinding(@NonNull ConstraintLayout constraintLayout, @NonNull BadgeView badgeView, @NonNull ConstraintLayout constraintLayout2, @NonNull CoverImageView coverImageView, @NonNull RotateLoading rotateLoading, @NonNull TextView textView, @NonNull View view) {
        this.a = constraintLayout;
        this.f6757b = badgeView;
        this.f6758c = coverImageView;
        this.f6759d = rotateLoading;
        this.f6760e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
