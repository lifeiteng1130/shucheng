package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogFontSelectBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Toolbar f6619c;

    public DialogFontSelectBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull Toolbar toolbar) {
        this.a = linearLayout;
        this.f6618b = recyclerView;
        this.f6619c = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
