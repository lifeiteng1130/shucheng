package io.legado.app.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.recycler.RecyclerViewAtPager2;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentRssBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerViewAtPager2 f6734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TitleBar f6735c;

    public FragmentRssBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerViewAtPager2 recyclerViewAtPager2, @NonNull TitleBar titleBar, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f6734b = recyclerViewAtPager2;
        this.f6735c = titleBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
