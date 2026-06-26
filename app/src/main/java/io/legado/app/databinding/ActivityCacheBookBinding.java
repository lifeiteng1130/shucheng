package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityCacheBookBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TitleBar f6506c;

    public ActivityCacheBookBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull TitleBar titleBar) {
        this.a = linearLayout;
        this.f6505b = recyclerView;
        this.f6506c = titleBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
