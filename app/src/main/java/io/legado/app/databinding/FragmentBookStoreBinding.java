package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dynamiclayout.DynamicFrameLayout;
import io.legado.app.ui.widget.recycler.RecyclerViewAtPager2;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentBookStoreBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerViewAtPager2 f6703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerViewAtPager2 f6704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TitleBar f6705e;

    public FragmentBookStoreBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull DynamicFrameLayout dynamicFrameLayout, @NonNull RecyclerViewAtPager2 recyclerViewAtPager2, @NonNull RecyclerViewAtPager2 recyclerViewAtPager22, @NonNull TitleBar titleBar) {
        this.a = linearLayout;
        this.f6702b = recyclerView;
        this.f6703c = recyclerViewAtPager2;
        this.f6704d = recyclerViewAtPager22;
        this.f6705e = titleBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
