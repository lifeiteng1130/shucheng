package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATECheckBox;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemGroupSelectBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6796c;

    public ItemGroupSelectBinding(@NonNull LinearLayout linearLayout, @NonNull ATECheckBox aTECheckBox, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f6795b = aTECheckBox;
        this.f6796c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
