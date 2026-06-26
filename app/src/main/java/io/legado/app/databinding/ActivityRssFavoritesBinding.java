package io.legado.app.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityRssFavoritesBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6541b;

    public ActivityRssFavoritesBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull TitleBar titleBar) {
        this.a = constraintLayout;
        this.f6541b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
