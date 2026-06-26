package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemSourceImportBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6851c;

    public ItemSourceImportBinding(@NonNull LinearLayout linearLayout, @NonNull ATECheckBox aTECheckBox, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f6850b = aTECheckBox;
        this.f6851c = textView;
    }

    @NonNull
    public static ItemSourceImportBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_source_import, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        int i2 = R.id.cb_source_name;
        ATECheckBox aTECheckBox = (ATECheckBox) viewInflate.findViewById(R.id.cb_source_name);
        if (aTECheckBox != null) {
            i2 = R.id.tv_source_state;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_source_state);
            if (textView != null) {
                return new ItemSourceImportBinding((LinearLayout) viewInflate, aTECheckBox, textView);
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
