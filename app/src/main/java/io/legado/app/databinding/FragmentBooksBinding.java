package io.legado.app.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentBooksBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f6707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f6709d;

    public FragmentBooksBinding(@NonNull FrameLayout frameLayout, @NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull RecyclerView recyclerView, @NonNull TextView textView) {
        this.a = frameLayout;
        this.f6707b = swipeRefreshLayout;
        this.f6708c = recyclerView;
        this.f6709d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
