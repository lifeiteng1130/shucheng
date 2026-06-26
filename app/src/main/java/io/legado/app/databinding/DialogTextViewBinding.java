package io.legado.app.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.text.BadgeView;
import io.legado.app.ui.widget.text.InertiaScrollTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogTextViewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BadgeView f6679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final InertiaScrollTextView f6680c;

    public DialogTextViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull BadgeView badgeView, @NonNull InertiaScrollTextView inertiaScrollTextView) {
        this.a = constraintLayout;
        this.f6679b = badgeView;
        this.f6680c = inertiaScrollTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
