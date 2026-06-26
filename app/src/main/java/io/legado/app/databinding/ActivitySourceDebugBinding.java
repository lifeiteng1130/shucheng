package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.anima.RotateLoading;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivitySourceDebugBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RotateLoading f6564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TitleBar f6565d;

    public ActivitySourceDebugBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull RecyclerView recyclerView, @NonNull RotateLoading rotateLoading, @NonNull TitleBar titleBar) {
        this.a = constraintLayout;
        this.f6563b = recyclerView;
        this.f6564c = rotateLoading;
        this.f6565d = titleBar;
    }

    @NonNull
    public static ActivitySourceDebugBinding a(@NonNull LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_source_debug, (ViewGroup) null, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
        int i2 = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
        if (recyclerView != null) {
            i2 = R.id.rotate_loading;
            RotateLoading rotateLoading = (RotateLoading) viewInflate.findViewById(R.id.rotate_loading);
            if (rotateLoading != null) {
                i2 = R.id.title_bar;
                TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    return new ActivitySourceDebugBinding((ConstraintLayout) viewInflate, constraintLayout, recyclerView, rotateLoading, titleBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
