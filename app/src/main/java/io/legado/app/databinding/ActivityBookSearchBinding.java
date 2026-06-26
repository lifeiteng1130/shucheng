package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.anima.RefreshProgressBar;
import io.legado.app.ui.widget.dynamiclayout.DynamicFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityBookSearchBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FloatingActionButton f6488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final RefreshProgressBar f6491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TitleBar f6494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f6495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f6496j;

    public ActivityBookSearchBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DynamicFrameLayout dynamicFrameLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull RefreshProgressBar refreshProgressBar, @NonNull RecyclerView recyclerView2, @NonNull RecyclerView recyclerView3, @NonNull TitleBar titleBar, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = constraintLayout;
        this.f6488b = floatingActionButton;
        this.f6489c = linearLayout;
        this.f6490d = recyclerView;
        this.f6491e = refreshProgressBar;
        this.f6492f = recyclerView2;
        this.f6493g = recyclerView3;
        this.f6494h = titleBar;
        this.f6495i = textView;
        this.f6496j = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
