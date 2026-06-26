package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityChapterListBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TitleBar f6507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f6508c;

    public ActivityChapterListBinding(@NonNull LinearLayout linearLayout, @NonNull TitleBar titleBar, @NonNull ViewPager2 viewPager2) {
        this.a = linearLayout;
        this.f6507b = titleBar;
        this.f6508c = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
