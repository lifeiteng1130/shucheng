package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.anima.RefreshProgressBar;
import io.legado.app.ui.widget.dynamiclayout.DynamicFrameLayout;
import io.legado.app.ui.widget.text.AccentBgTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityBookEndBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AccentBgTextView f6459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final FloatingActionButton f6461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RefreshProgressBar f6463f;

    public ActivityBookEndBinding(@NonNull LinearLayout linearLayout, @NonNull AccentBgTextView accentBgTextView, @NonNull TextView textView, @NonNull DynamicFrameLayout dynamicFrameLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull RecyclerView recyclerView, @NonNull RefreshProgressBar refreshProgressBar, @NonNull TitleBar titleBar) {
        this.a = linearLayout;
        this.f6459b = accentBgTextView;
        this.f6460c = textView;
        this.f6461d = floatingActionButton;
        this.f6462e = recyclerView;
        this.f6463f = refreshProgressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
