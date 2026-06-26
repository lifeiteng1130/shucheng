package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.SelectActionBar;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityBookSourceBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FastScrollRecyclerView f6497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final SelectActionBar f6498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TitleBar f6499d;

    public ActivityBookSourceBinding(@NonNull LinearLayout linearLayout, @NonNull FastScrollRecyclerView fastScrollRecyclerView, @NonNull SelectActionBar selectActionBar, @NonNull TitleBar titleBar) {
        this.a = linearLayout;
        this.f6497b = fastScrollRecyclerView;
        this.f6498c = selectActionBar;
        this.f6499d = titleBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
