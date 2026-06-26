package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.SelectActionBar;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityReplaceRuleBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final SelectActionBar f6536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TitleBar f6537d;

    public ActivityReplaceRuleBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull SelectActionBar selectActionBar, @NonNull TitleBar titleBar) {
        this.a = linearLayout;
        this.f6535b = recyclerView;
        this.f6536c = selectActionBar;
        this.f6537d = titleBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
