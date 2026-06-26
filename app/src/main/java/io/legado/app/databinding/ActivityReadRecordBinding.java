package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityReadRecordBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ItemReadRecordBinding f6524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6525c;

    public ActivityReadRecordBinding(@NonNull LinearLayout linearLayout, @NonNull ItemReadRecordBinding itemReadRecordBinding, @NonNull RecyclerView recyclerView, @NonNull TitleBar titleBar) {
        this.a = linearLayout;
        this.f6524b = itemReadRecordBinding;
        this.f6525c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
