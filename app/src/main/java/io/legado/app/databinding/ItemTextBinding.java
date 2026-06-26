package io.legado.app.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemTextBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f6852b;

    public ItemTextBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
        this.f6852b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
