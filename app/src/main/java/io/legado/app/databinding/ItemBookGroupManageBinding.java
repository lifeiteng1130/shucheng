package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATESwitch;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemBookGroupManageBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ATESwitch f6746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f6748d;

    public ItemBookGroupManageBinding(@NonNull LinearLayout linearLayout, @NonNull ATESwitch aTESwitch, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f6746b = aTESwitch;
        this.f6747c = textView;
        this.f6748d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
