package io.legado.app.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.text.AccentTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityWelcomeBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f6570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f6571c;

    public ActivityWelcomeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull AccentTextView accentTextView, @NonNull AccentTextView accentTextView2, @NonNull AccentTextView accentTextView3, @NonNull View view) {
        this.a = constraintLayout;
        this.f6570b = imageView;
        this.f6571c = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
