package io.legado.app.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentBookmarkBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FastScrollRecyclerView f6706b;

    public FragmentBookmarkBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FastScrollRecyclerView fastScrollRecyclerView) {
        this.a = constraintLayout;
        this.f6706b = fastScrollRecyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
