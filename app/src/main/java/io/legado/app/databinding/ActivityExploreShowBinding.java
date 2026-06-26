package io.legado.app.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dynamiclayout.DynamicFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityExploreShowBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TitleBar f6511c;

    public ActivityExploreShowBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DynamicFrameLayout dynamicFrameLayout, @NonNull RecyclerView recyclerView, @NonNull TitleBar titleBar) {
        this.a = constraintLayout;
        this.f6510b = recyclerView;
        this.f6511c = titleBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
