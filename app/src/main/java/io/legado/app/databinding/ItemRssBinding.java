package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.image.FilletImageView;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemRssBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FilletImageView f6829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6830c;

    public ItemRssBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FilletImageView filletImageView, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f6829b = filletImageView;
        this.f6830c = textView;
    }

    @NonNull
    public static ItemRssBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_rss, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        int i2 = R.id.iv_icon;
        FilletImageView filletImageView = (FilletImageView) viewInflate.findViewById(R.id.iv_icon);
        if (filletImageView != null) {
            i2 = R.id.tv_name;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
            if (textView != null) {
                return new ItemRssBinding((ConstraintLayout) viewInflate, filletImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
