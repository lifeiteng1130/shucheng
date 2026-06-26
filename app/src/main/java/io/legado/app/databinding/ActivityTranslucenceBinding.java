package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.anima.RotateLoading;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityTranslucenceBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RotateLoading f6569b;

    public ActivityTranslucenceBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RotateLoading rotateLoading) {
        this.a = constraintLayout;
        this.f6569b = rotateLoading;
    }

    @NonNull
    public static ActivityTranslucenceBinding a(@NonNull LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_translucence, (ViewGroup) null, false);
        RotateLoading rotateLoading = (RotateLoading) viewInflate.findViewById(R.id.rotate_loading);
        if (rotateLoading != null) {
            return new ActivityTranslucenceBinding((ConstraintLayout) viewInflate, rotateLoading);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.rotate_loading)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
