package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityRssArtivlesBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TabLayout f6538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TitleBar f6539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f6540d;

    public ActivityRssArtivlesBinding(@NonNull LinearLayout linearLayout, @NonNull TabLayout tabLayout, @NonNull TitleBar titleBar, @NonNull ViewPager2 viewPager2) {
        this.a = linearLayout;
        this.f6538b = tabLayout;
        this.f6539c = titleBar;
        this.f6540d = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
