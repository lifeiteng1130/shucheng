package io.legado.app.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.recycler.RecyclerViewAtPager2;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentRssArticlesBinding implements ViewBinding {

    @NonNull
    public final SwipeRefreshLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerViewAtPager2 f6732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f6733c;

    public FragmentRssArticlesBinding(@NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull RecyclerViewAtPager2 recyclerViewAtPager2, @NonNull SwipeRefreshLayout swipeRefreshLayout2) {
        this.a = swipeRefreshLayout;
        this.f6732b = recyclerViewAtPager2;
        this.f6733c = swipeRefreshLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
