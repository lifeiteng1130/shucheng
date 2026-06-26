package io.legado.app.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes3.dex */
public final class PopupKeyboardToolBinding implements ViewBinding {

    @NonNull
    public final RecyclerView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6865b;

    public PopupKeyboardToolBinding(@NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.a = recyclerView;
        this.f6865b = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
