package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityRuleSubBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6555c;

    public ActivityRuleSubBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull TitleBar titleBar, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f6554b = recyclerView;
        this.f6555c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
