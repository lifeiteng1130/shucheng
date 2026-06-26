package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.anima.RefreshProgressBar;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogChangeCoverBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RefreshProgressBar f6597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Toolbar f6598d;

    public DialogChangeCoverBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull RefreshProgressBar refreshProgressBar, @NonNull Toolbar toolbar) {
        this.a = linearLayout;
        this.f6596b = recyclerView;
        this.f6597c = refreshProgressBar;
        this.f6598d = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
