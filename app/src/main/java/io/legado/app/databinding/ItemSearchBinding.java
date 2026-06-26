package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.LabelsBar;
import io.legado.app.ui.widget.image.CoverImageView;
import io.legado.app.ui.widget.text.BadgeView;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemSearchBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BadgeView f6840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CoverImageView f6841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LabelsBar f6842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f6843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f6844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f6845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f6846h;

    public ItemSearchBinding(@NonNull ConstraintLayout constraintLayout, @NonNull BadgeView badgeView, @NonNull CoverImageView coverImageView, @NonNull LabelsBar labelsBar, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.a = constraintLayout;
        this.f6840b = badgeView;
        this.f6841c = coverImageView;
        this.f6842d = labelsBar;
        this.f6843e = textView;
        this.f6844f = textView2;
        this.f6845g = textView3;
        this.f6846h = textView4;
    }

    @NonNull
    public static ItemSearchBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_search, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        int i2 = R.id.bv_originCount;
        BadgeView badgeView = (BadgeView) viewInflate.findViewById(R.id.bv_originCount);
        if (badgeView != null) {
            i2 = R.id.iv_cover;
            CoverImageView coverImageView = (CoverImageView) viewInflate.findViewById(R.id.iv_cover);
            if (coverImageView != null) {
                i2 = R.id.ll_kind;
                LabelsBar labelsBar = (LabelsBar) viewInflate.findViewById(R.id.ll_kind);
                if (labelsBar != null) {
                    i2 = R.id.tv_author;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.tv_author);
                    if (textView != null) {
                        i2 = R.id.tv_introduce;
                        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_introduce);
                        if (textView2 != null) {
                            i2 = R.id.tv_lasted;
                            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_lasted);
                            if (textView3 != null) {
                                i2 = R.id.tv_name;
                                TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_name);
                                if (textView4 != null) {
                                    return new ItemSearchBinding((ConstraintLayout) viewInflate, badgeView, coverImageView, labelsBar, textView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
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
