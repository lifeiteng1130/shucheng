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
public final class ItemChapterListBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f6772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f6774d;

    public ItemChapterListBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f6772b = imageView;
        this.f6773c = textView;
        this.f6774d = textView2;
    }

    @NonNull
    public static ItemChapterListBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_chapter_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        int i2 = R.id.iv_checked;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_checked);
        if (imageView != null) {
            i2 = R.id.tv_chapter_name;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_chapter_name);
            if (textView != null) {
                i2 = R.id.tv_tag;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_tag);
                if (textView2 != null) {
                    return new ItemChapterListBinding((ConstraintLayout) viewInflate, imageView, textView, textView2);
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
