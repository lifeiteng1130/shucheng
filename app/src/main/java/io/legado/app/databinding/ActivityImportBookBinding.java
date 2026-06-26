package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.SelectActionBar;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.anima.RefreshProgressBar;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;
import io.legado.app.ui.widget.text.StrokeTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityImportBookBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FastScrollRecyclerView f6516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RefreshProgressBar f6517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final SelectActionBar f6518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f6519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final StrokeTextView f6520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f6521h;

    public ActivityImportBookBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull FastScrollRecyclerView fastScrollRecyclerView, @NonNull RefreshProgressBar refreshProgressBar, @NonNull SelectActionBar selectActionBar, @NonNull TitleBar titleBar, @NonNull TextView textView, @NonNull StrokeTextView strokeTextView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f6515b = linearLayout;
        this.f6516c = fastScrollRecyclerView;
        this.f6517d = refreshProgressBar;
        this.f6518e = selectActionBar;
        this.f6519f = textView;
        this.f6520g = strokeTextView;
        this.f6521h = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
