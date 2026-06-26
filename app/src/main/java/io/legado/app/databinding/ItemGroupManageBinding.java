package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemGroupManageBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f6792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f6794d;

    public ItemGroupManageBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f6792b = textView;
        this.f6793c = textView2;
        this.f6794d = textView3;
    }

    @NonNull
    public static ItemGroupManageBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_group_manage, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        int i2 = R.id.tv_del;
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_del);
        if (textView != null) {
            i2 = R.id.tv_edit;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_edit);
            if (textView2 != null) {
                i2 = R.id.tv_group;
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_group);
                if (textView3 != null) {
                    return new ItemGroupManageBinding((LinearLayout) viewInflate, textView, textView2, textView3);
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
