package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityRssSourceEditBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6553f;

    public ActivityRssSourceEditBinding(@NonNull LinearLayout linearLayout, @NonNull ATECheckBox aTECheckBox, @NonNull ATECheckBox aTECheckBox2, @NonNull ATECheckBox aTECheckBox3, @NonNull ATECheckBox aTECheckBox4, @NonNull RecyclerView recyclerView, @NonNull TitleBar titleBar) {
        this.a = linearLayout;
        this.f6549b = aTECheckBox;
        this.f6550c = aTECheckBox2;
        this.f6551d = aTECheckBox3;
        this.f6552e = aTECheckBox4;
        this.f6553f = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
