package io.legado.app.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import io.legado.app.ui.main.bookshelf.RootView;
import io.legado.app.ui.widget.TitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentBookshelfBinding implements ViewBinding {

    @NonNull
    public final RootView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TitleBar f6710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f6711c;

    public FragmentBookshelfBinding(@NonNull RootView rootView, @NonNull TitleBar titleBar, @NonNull ViewPager2 viewPager2) {
        this.a = rootView;
        this.f6710b = titleBar;
        this.f6711c = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
