package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter implements MenuPresenter {
    public NavigationMenuView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f2287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MenuPresenter.Callback f2288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MenuBuilder f2289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f2291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LayoutInflater f2292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f2295j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f2296k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f2297l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public int r;
    public int s;
    public int t;
    public boolean q = true;
    public int u = -1;
    public final View.OnClickListener v = new a();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            NavigationMenuPresenter.this.c(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean zPerformItemAction = navigationMenuPresenter.f2289d.performItemAction(itemData, navigationMenuPresenter, 0);
            if (itemData != null && itemData.isCheckable() && zPerformItemAction) {
                NavigationMenuPresenter.this.f2291f.e(itemData);
            } else {
                z = false;
            }
            NavigationMenuPresenter.this.c(false);
            if (z) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    }

    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    public class c extends RecyclerView.Adapter<l> {
        public final ArrayList<e> a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MenuItemImpl f2298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2299c;

        public c() {
            d();
        }

        public final void d() {
            if (this.f2299c) {
                return;
            }
            this.f2299c = true;
            this.a.clear();
            this.a.add(new d());
            int i2 = -1;
            int size = NavigationMenuPresenter.this.f2289d.getVisibleItems().size();
            boolean z = false;
            int i3 = 0;
            boolean z2 = false;
            int size2 = 0;
            while (i3 < size) {
                MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.f2289d.getVisibleItems().get(i3);
                if (menuItemImpl.isChecked()) {
                    e(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(z);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i3 != 0) {
                            this.a.add(new f(NavigationMenuPresenter.this.t, z ? 1 : 0));
                        }
                        this.a.add(new g(menuItemImpl));
                        int size3 = subMenu.size();
                        int i4 = 0;
                        boolean z3 = false;
                        while (i4 < size3) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i4);
                            if (menuItemImpl2.isVisible()) {
                                if (!z3 && menuItemImpl2.getIcon() != null) {
                                    z3 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(z);
                                }
                                if (menuItemImpl.isChecked()) {
                                    e(menuItemImpl);
                                }
                                this.a.add(new g(menuItemImpl2));
                            }
                            i4++;
                            z = false;
                        }
                        if (z3) {
                            int size4 = this.a.size();
                            for (int size5 = this.a.size(); size5 < size4; size5++) {
                                ((g) this.a.get(size5)).f2302b = true;
                            }
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i2) {
                        size2 = this.a.size();
                        z2 = menuItemImpl.getIcon() != null;
                        if (i3 != 0) {
                            size2++;
                            ArrayList<e> arrayList = this.a;
                            int i5 = NavigationMenuPresenter.this.t;
                            arrayList.add(new f(i5, i5));
                        }
                    } else if (!z2 && menuItemImpl.getIcon() != null) {
                        int size6 = this.a.size();
                        for (int i6 = size2; i6 < size6; i6++) {
                            ((g) this.a.get(i6)).f2302b = true;
                        }
                        z2 = true;
                    }
                    g gVar = new g(menuItemImpl);
                    gVar.f2302b = z2;
                    this.a.add(gVar);
                    i2 = groupId;
                }
                i3++;
                z = false;
            }
            this.f2299c = false;
        }

        public void e(@NonNull MenuItemImpl menuItemImpl) {
            if (this.f2298b == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.f2298b;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.f2298b = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            e eVar = this.a.get(i2);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a.hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
            l lVar = (l) viewHolder;
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((TextView) lVar.itemView).setText(((g) this.a.get(i2)).a.getTitle());
                    return;
                } else {
                    if (itemViewType != 2) {
                        return;
                    }
                    f fVar = (f) this.a.get(i2);
                    lVar.itemView.setPadding(0, fVar.a, 0, fVar.f2301b);
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
            navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.f2296k);
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            if (navigationMenuPresenter.f2294i) {
                navigationMenuItemView.setTextAppearance(navigationMenuPresenter.f2293h);
            }
            ColorStateList colorStateList = NavigationMenuPresenter.this.f2295j;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = NavigationMenuPresenter.this.f2297l;
            ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            g gVar = (g) this.a.get(i2);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f2302b);
            navigationMenuItemView.setHorizontalPadding(NavigationMenuPresenter.this.m);
            navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.n);
            NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
            if (navigationMenuPresenter2.p) {
                navigationMenuItemView.setIconSize(navigationMenuPresenter2.o);
            }
            navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.r);
            navigationMenuItemView.initialize(gVar.a, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            RecyclerView.ViewHolder iVar;
            if (i2 == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                iVar = new i(navigationMenuPresenter.f2292g, viewGroup, navigationMenuPresenter.v);
            } else if (i2 == 1) {
                iVar = new k(NavigationMenuPresenter.this.f2292g, viewGroup);
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return new b(NavigationMenuPresenter.this.f2287b);
                }
                iVar = new j(NavigationMenuPresenter.this.f2292g, viewGroup);
            }
            return iVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            l lVar = (l) viewHolder;
            if (lVar instanceof i) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
                FrameLayout frameLayout = navigationMenuItemView.f2286l;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                navigationMenuItemView.f2285k.setCompoundDrawables(null, null, null, null);
            }
        }
    }

    public static class d implements e {
    }

    public interface e {
    }

    public static class f implements e {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2301b;

        public f(int i2, int i3) {
            this.a = i2;
            this.f2301b = i3;
        }
    }

    public static class g implements e {
        public final MenuItemImpl a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2302b;

        public g(MenuItemImpl menuItemImpl) {
            this.a = menuItemImpl;
        }
    }

    public class h extends RecyclerViewAccessibilityDelegate {
        public h(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            c cVar = NavigationMenuPresenter.this.f2291f;
            int i2 = NavigationMenuPresenter.this.f2287b.getChildCount() == 0 ? 0 : 1;
            for (int i3 = 0; i3 < NavigationMenuPresenter.this.f2291f.getItemCount(); i3++) {
                if (NavigationMenuPresenter.this.f2291f.getItemViewType(i3) == 0) {
                    i2++;
                }
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i2, 0, false));
        }
    }

    public static class i extends l {
        public i(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    public static class j extends l {
        public j(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    public static class k extends l {
        public k(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    public static abstract class l extends RecyclerView.ViewHolder {
        public l(View view) {
            super(view);
        }
    }

    public void a(int i2) {
        this.m = i2;
        updateMenuView(false);
    }

    public void b(int i2) {
        this.n = i2;
        updateMenuView(false);
    }

    public void c(boolean z) {
        c cVar = this.f2291f;
        if (cVar != null) {
            cVar.f2299c = z;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public final void d() {
        int i2 = (this.f2287b.getChildCount() == 0 && this.q) ? this.s : 0;
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f2290e;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f2292g.inflate(R$layout.design_navigation_menu, viewGroup, false);
            this.a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.a));
            if (this.f2291f == null) {
                this.f2291f = new c();
            }
            int i2 = this.u;
            if (i2 != -1) {
                this.a.setOverScrollMode(i2);
            }
            this.f2287b = (LinearLayout) this.f2292g.inflate(R$layout.design_navigation_item_header, (ViewGroup) this.a, false);
            this.a.setAdapter(this.f2291f);
        }
        return this.a;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.f2292g = LayoutInflater.from(context);
        this.f2289d = menuBuilder;
        this.t = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.f2288c;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItemImpl menuItemImpl;
        View actionView;
        ParcelableSparseArray parcelableSparseArray;
        MenuItemImpl menuItemImpl2;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(ListMenuPresenter.VIEWS_TAG);
            if (sparseParcelableArray != null) {
                this.a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                c cVar = this.f2291f;
                Objects.requireNonNull(cVar);
                int i2 = bundle2.getInt("android:menu:checked", 0);
                if (i2 != 0) {
                    cVar.f2299c = true;
                    int size = cVar.a.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        e eVar = cVar.a.get(i3);
                        if ((eVar instanceof g) && (menuItemImpl2 = ((g) eVar).a) != null && menuItemImpl2.getItemId() == i2) {
                            cVar.e(menuItemImpl2);
                            break;
                        }
                        i3++;
                    }
                    cVar.f2299c = false;
                    cVar.d();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = cVar.a.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        e eVar2 = cVar.a.get(i4);
                        if ((eVar2 instanceof g) && (menuItemImpl = ((g) eVar2).a) != null && (actionView = menuItemImpl.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(menuItemImpl.getItemId())) != null) {
                            actionView.restoreHierarchyState(parcelableSparseArray);
                        }
                    }
                }
            }
            SparseArray sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.f2287b.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray(ListMenuPresenter.VIEWS_TAG, sparseArray);
        }
        c cVar = this.f2291f;
        if (cVar != null) {
            Objects.requireNonNull(cVar);
            Bundle bundle2 = new Bundle();
            MenuItemImpl menuItemImpl = cVar.f2298b;
            if (menuItemImpl != null) {
                bundle2.putInt("android:menu:checked", menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            int size = cVar.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = cVar.a.get(i2);
                if (eVar instanceof g) {
                    MenuItemImpl menuItemImpl2 = ((g) eVar).a;
                    View actionView = menuItemImpl2 != null ? menuItemImpl2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray2.put(menuItemImpl2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.f2287b != null) {
            SparseArray<? extends Parcelable> sparseArray3 = new SparseArray<>();
            this.f2287b.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.f2288c = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        c cVar = this.f2291f;
        if (cVar != null) {
            cVar.d();
            cVar.notifyDataSetChanged();
        }
    }
}
