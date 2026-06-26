package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemRssArticleBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f6826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f6828d;

    public ItemRssArticleBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f6826b = imageView;
        this.f6827c = textView;
        this.f6828d = textView2;
    }

    @NonNull
    public static ItemRssArticleBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_rss_article, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        int i2 = R.id.image_view;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image_view);
        if (imageView != null) {
            i2 = R.id.tv_pub_date;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_pub_date);
            if (textView != null) {
                i2 = R.id.tv_title;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_title);
                if (textView2 != null) {
                    return new ItemRssArticleBinding((ConstraintLayout) viewInflate, imageView, textView, textView2);
                }
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
