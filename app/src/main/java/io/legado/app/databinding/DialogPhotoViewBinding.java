package io.legado.app.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.image.PhotoView;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogPhotoViewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final PhotoView f6626b;

    public DialogPhotoViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull PhotoView photoView) {
        this.a = constraintLayout;
        this.f6626b = photoView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
