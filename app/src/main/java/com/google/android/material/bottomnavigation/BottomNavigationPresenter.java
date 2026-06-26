package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.transition.TransitionManager;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationPresenter implements MenuPresenter {
    public MenuBuilder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BottomNavigationMenuView f2070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2071c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2072d;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public ParcelableSparseArray f2073b;

        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.f2073b, 0);
        }

        public SavedState(@NonNull Parcel parcel) {
            this.a = parcel.readInt();
            this.f2073b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
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
        return this.f2072d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        return this.f2070b;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.a = menuBuilder;
        this.f2070b.initialize(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            BottomNavigationMenuView bottomNavigationMenuView = this.f2070b;
            SavedState savedState = (SavedState) parcelable;
            int i2 = savedState.a;
            int size = bottomNavigationMenuView.B.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                MenuItem item = bottomNavigationMenuView.B.getItem(i3);
                if (i2 == item.getItemId()) {
                    bottomNavigationMenuView.o = i2;
                    bottomNavigationMenuView.p = i3;
                    item.setChecked(true);
                    break;
                }
                i3++;
            }
            Context context = this.f2070b.getContext();
            ParcelableSparseArray parcelableSparseArray = savedState.f2073b;
            SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
            for (int i4 = 0; i4 < parcelableSparseArray.size(); i4++) {
                int iKeyAt = parcelableSparseArray.keyAt(i4);
                BadgeDrawable.SavedState savedState2 = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i4);
                if (savedState2 == null) {
                    throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
                }
                BadgeDrawable badgeDrawable = new BadgeDrawable(context);
                badgeDrawable.j(savedState2.f2009e);
                int i5 = savedState2.f2008d;
                if (i5 != -1) {
                    badgeDrawable.k(i5);
                }
                badgeDrawable.g(savedState2.a);
                badgeDrawable.i(savedState2.f2006b);
                badgeDrawable.h(savedState2.f2013i);
                badgeDrawable.f2003j.f2015k = savedState2.f2015k;
                badgeDrawable.m();
                badgeDrawable.f2003j.f2016l = savedState2.f2016l;
                badgeDrawable.m();
                boolean z = savedState2.f2014j;
                badgeDrawable.setVisible(z, false);
                badgeDrawable.f2003j.f2014j = z;
                sparseArray.put(iKeyAt, badgeDrawable);
            }
            this.f2070b.setBadgeDrawables(sparseArray);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.a = this.f2070b.getSelectedItemId();
        SparseArray<BadgeDrawable> badgeDrawables = this.f2070b.getBadgeDrawables();
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i2 = 0; i2 < badgeDrawables.size(); i2++) {
            int iKeyAt = badgeDrawables.keyAt(i2);
            BadgeDrawable badgeDrawableValueAt = badgeDrawables.valueAt(i2);
            if (badgeDrawableValueAt == null) {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
            parcelableSparseArray.put(iKeyAt, badgeDrawableValueAt.f2003j);
        }
        savedState.f2073b = parcelableSparseArray;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        if (this.f2071c) {
            return;
        }
        if (z) {
            this.f2070b.a();
            return;
        }
        BottomNavigationMenuView bottomNavigationMenuView = this.f2070b;
        MenuBuilder menuBuilder = bottomNavigationMenuView.B;
        if (menuBuilder == null || bottomNavigationMenuView.n == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != bottomNavigationMenuView.n.length) {
            bottomNavigationMenuView.a();
            return;
        }
        int i2 = bottomNavigationMenuView.o;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = bottomNavigationMenuView.B.getItem(i3);
            if (item.isChecked()) {
                bottomNavigationMenuView.o = item.getItemId();
                bottomNavigationMenuView.p = i3;
            }
        }
        if (i2 != bottomNavigationMenuView.o) {
            TransitionManager.beginDelayedTransition(bottomNavigationMenuView, bottomNavigationMenuView.f2060c);
        }
        boolean zC = bottomNavigationMenuView.c(bottomNavigationMenuView.m, bottomNavigationMenuView.B.getVisibleItems().size());
        for (int i4 = 0; i4 < size; i4++) {
            bottomNavigationMenuView.A.f2071c = true;
            bottomNavigationMenuView.n[i4].setLabelVisibilityMode(bottomNavigationMenuView.m);
            bottomNavigationMenuView.n[i4].setShifting(zC);
            bottomNavigationMenuView.n[i4].initialize((MenuItemImpl) bottomNavigationMenuView.B.getItem(i4), 0);
            bottomNavigationMenuView.A.f2071c = false;
        }
    }
}
