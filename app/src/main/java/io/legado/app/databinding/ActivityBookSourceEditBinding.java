package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.tabs.TabLayout;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityBookSourceEditBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final AppCompatSpinner f6503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TabLayout f6504f;

    public ActivityBookSourceEditBinding(@NonNull LinearLayout linearLayout, @NonNull ATECheckBox aTECheckBox, @NonNull ATECheckBox aTECheckBox2, @NonNull RecyclerView recyclerView, @NonNull AppCompatSpinner appCompatSpinner, @NonNull TabLayout tabLayout, @NonNull TitleBar titleBar) {
        this.a = linearLayout;
        this.f6500b = aTECheckBox;
        this.f6501c = aTECheckBox2;
        this.f6502d = recyclerView;
        this.f6503e = appCompatSpinner;
        this.f6504f = tabLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
