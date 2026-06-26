package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.anima.RefreshProgressBar;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivitySearchContentBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final FastScrollRecyclerView f6559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RefreshProgressBar f6560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TitleBar f6561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f6562h;

    public ActivitySearchContentBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull LinearLayout linearLayout, @NonNull FastScrollRecyclerView fastScrollRecyclerView, @NonNull RefreshProgressBar refreshProgressBar, @NonNull TitleBar titleBar, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f6556b = appCompatImageView;
        this.f6557c = appCompatImageView2;
        this.f6558d = linearLayout;
        this.f6559e = fastScrollRecyclerView;
        this.f6560f = refreshProgressBar;
        this.f6561g = titleBar;
        this.f6562h = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
