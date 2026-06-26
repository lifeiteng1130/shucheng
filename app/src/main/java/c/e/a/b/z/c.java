package c.e.a.b.z;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: TabLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements View.OnLayoutChangeListener {
    public final /* synthetic */ View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TabLayout.TabView f1293b;

    public c(TabLayout.TabView tabView, View view) {
        this.f1293b = tabView;
        this.a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.a.getVisibility() == 0) {
            TabLayout.TabView tabView = this.f1293b;
            View view2 = this.a;
            int i10 = TabLayout.TabView.a;
            tabView.e(view2);
        }
    }
}
