package io.legado.app.databinding;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemIconPreferenceBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f6800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CheckedTextView f6801c;

    public ItemIconPreferenceBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull CheckedTextView checkedTextView) {
        this.a = relativeLayout;
        this.f6800b = imageView;
        this.f6801c = checkedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
