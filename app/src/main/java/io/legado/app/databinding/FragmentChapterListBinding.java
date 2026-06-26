package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentChapterListBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final FastScrollRecyclerView f6715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f6716f;

    public FragmentChapterListBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull LinearLayout linearLayout, @NonNull FastScrollRecyclerView fastScrollRecyclerView, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f6712b = appCompatImageView;
        this.f6713c = appCompatImageView2;
        this.f6714d = linearLayout;
        this.f6715e = fastScrollRecyclerView;
        this.f6716f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
