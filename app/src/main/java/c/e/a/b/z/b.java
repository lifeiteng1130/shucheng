package c.e.a.b.z;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.f;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: TabIndicatorInterpolator.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static RectF a(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.D || !(view instanceof TabLayout.TabView)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        TabLayout.TabView tabView = (TabLayout.TabView) view;
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int iW1 = (int) f.w1(tabView.getContext(), 24);
        if (contentWidth < iW1) {
            contentWidth = iW1;
        }
        int right = (tabView.getRight() + tabView.getLeft()) / 2;
        int bottom = (tabView.getBottom() + tabView.getTop()) / 2;
        int i2 = contentWidth / 2;
        return new RectF(right - i2, bottom - (contentHeight / 2), i2 + right, (right / 2) + bottom);
    }

    public void b(TabLayout tabLayout, View view, View view2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @NonNull Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        RectF rectFA2 = a(tabLayout, view2);
        drawable.setBounds(c.e.a.b.a.a.b((int) rectFA.left, (int) rectFA2.left, f2), drawable.getBounds().top, c.e.a.b.a.a.b((int) rectFA.right, (int) rectFA2.right, f2), drawable.getBounds().bottom);
    }
}
