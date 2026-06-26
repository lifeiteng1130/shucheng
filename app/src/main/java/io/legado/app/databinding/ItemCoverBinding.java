package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.image.CoverImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemCoverBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CoverImageView f6775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6776c;

    public ItemCoverBinding(@NonNull LinearLayout linearLayout, @NonNull CoverImageView coverImageView, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f6775b = coverImageView;
        this.f6776c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
