package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.image.CircleImageView;
import io.wenyuange.app.release.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemReadStyleBinding implements ViewBinding {

    @NonNull
    public final CircleImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CircleImageView f6815b;

    public ItemReadStyleBinding(@NonNull CircleImageView circleImageView, @NonNull CircleImageView circleImageView2) {
        this.a = circleImageView;
        this.f6815b = circleImageView2;
    }

    @NonNull
    public static ItemReadStyleBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_read_style, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        Objects.requireNonNull(viewInflate, "rootView");
        CircleImageView circleImageView = (CircleImageView) viewInflate;
        return new ItemReadStyleBinding(circleImageView, circleImageView);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
