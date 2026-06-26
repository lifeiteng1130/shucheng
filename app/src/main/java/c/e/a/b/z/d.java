package c.e.a.b.z;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TabLayoutMediator.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    @NonNull
    public final TabLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f1294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f1295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public RecyclerView.Adapter<?> f1296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public c f1298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public TabLayout.d f1299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public RecyclerView.AdapterDataObserver f1300h;

    /* JADX INFO: compiled from: TabLayoutMediator.java */
    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            d.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3) {
            d.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            d.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            d.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            d.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            d.this.b();
        }
    }

    /* JADX INFO: compiled from: TabLayoutMediator.java */
    public interface b {
        void a(@NonNull TabLayout.g gVar, int i2);
    }

    /* JADX INFO: compiled from: TabLayoutMediator.java */
    public static class c extends ViewPager2.OnPageChangeCallback {

        @NonNull
        public final WeakReference<TabLayout> a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1302c = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1301b = 0;

        public c(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            this.f1301b = this.f1302c;
            this.f1302c = i2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i4 = this.f1302c;
                tabLayout.m(i2, f2, i4 != 2 || this.f1301b == 1, (i4 == 2 && this.f1301b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f1302c;
            tabLayout.k(tabLayout.g(i2), i3 == 0 || (i3 == 2 && this.f1301b == 0));
        }
    }

    /* JADX INFO: renamed from: c.e.a.b.z.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TabLayoutMediator.java */
    public static class C0048d implements TabLayout.d {
        public final ViewPager2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1303b;

        public C0048d(ViewPager2 viewPager2, boolean z) {
            this.a = viewPager2;
            this.f1303b = z;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void K(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void m(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void x(@NonNull TabLayout.g gVar) {
            this.a.setCurrentItem(gVar.f2438d, this.f1303b);
        }
    }

    public d(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull b bVar) {
        this.a = tabLayout;
        this.f1294b = viewPager2;
        this.f1295c = bVar;
    }

    public void a() {
        if (this.f1297e) {
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
        RecyclerView.Adapter<?> adapter = this.f1294b.getAdapter();
        this.f1296d = adapter;
        if (adapter == null) {
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        this.f1297e = true;
        c cVar = new c(this.a);
        this.f1298f = cVar;
        this.f1294b.registerOnPageChangeCallback(cVar);
        C0048d c0048d = new C0048d(this.f1294b, true);
        this.f1299g = c0048d;
        this.a.addOnTabSelectedListener((TabLayout.d) c0048d);
        a aVar = new a();
        this.f1300h = aVar;
        this.f1296d.registerAdapterDataObserver(aVar);
        b();
        this.a.m(this.f1294b.getCurrentItem(), 0.0f, true, true);
    }

    public void b() {
        this.a.j();
        RecyclerView.Adapter<?> adapter = this.f1296d;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                TabLayout.g gVarH = this.a.h();
                this.f1295c.a(gVarH, i2);
                this.a.a(gVarH, false);
            }
            if (itemCount > 0) {
                int iMin = Math.min(this.f1294b.getCurrentItem(), this.a.getTabCount() - 1);
                if (iMin != this.a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.a;
                    tabLayout.k(tabLayout.g(iMin), true);
                }
            }
        }
    }
}
