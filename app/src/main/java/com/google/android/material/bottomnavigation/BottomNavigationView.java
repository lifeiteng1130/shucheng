package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import c.b.a.m.f;
import c.e.a.b.q.g;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationView extends FrameLayout {
    public static final int a = R$style.Widget_Design_BottomNavigationView;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MenuBuilder f2074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    @VisibleForTesting
    public final BottomNavigationMenuView f2075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BottomNavigationPresenter f2076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public ColorStateList f2077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MenuInflater f2078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f2079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f2080h;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        @Nullable
        public Bundle a;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.a);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readBundle(classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    public class a implements MenuBuilder.Callback {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            if (BottomNavigationView.this.f2080h == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                c cVar = BottomNavigationView.this.f2079g;
                return (cVar == null || cVar.e(menuItem)) ? false : true;
            }
            BottomNavigationView.this.f2080h.t0(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    public interface b {
        void t0(@NonNull MenuItem menuItem);
    }

    public interface c {
        boolean e(@NonNull MenuItem menuItem);
    }

    public BottomNavigationView(@NonNull Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.f2078f == null) {
            this.f2078f = new SupportMenuInflater(getContext());
        }
        return this.f2078f;
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f2075c.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.f2075c.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.f2075c.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f2075c.getIconTintList();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f2077e;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.f2075c.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.f2075c.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f2075c.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f2075c.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    @NonNull
    public Menu getMenu() {
        return this.f2074b;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.f2075c.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            f.e5(this, (MaterialShapeDrawable) background);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2074b.restorePresenterStates(savedState.a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.a = bundle;
        this.f2074b.savePresenterStates(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        f.d5(this, f2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f2075c.setItemBackground(drawable);
        this.f2077e = null;
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        this.f2075c.setItemBackgroundRes(i2);
        this.f2077e = null;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        BottomNavigationMenuView bottomNavigationMenuView = this.f2075c;
        if (bottomNavigationMenuView.f2069l != z) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z);
            this.f2076d.updateMenuView(false);
        }
    }

    public void setItemIconSize(@Dimension int i2) {
        this.f2075c.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(@DimenRes int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f2075c.setIconTintList(colorStateList);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f2077e == colorStateList) {
            if (colorStateList != null || this.f2075c.getItemBackground() == null) {
                return;
            }
            this.f2075c.setItemBackground(null);
            return;
        }
        this.f2077e = colorStateList;
        if (colorStateList == null) {
            this.f2075c.setItemBackground(null);
        } else {
            this.f2075c.setItemBackground(new RippleDrawable(c.e.a.b.u.a.a(colorStateList), null, null));
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.f2075c.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.f2075c.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f2075c.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f2075c.getLabelVisibilityMode() != i2) {
            this.f2075c.setLabelVisibilityMode(i2);
            this.f2076d.updateMenuView(false);
        }
    }

    public void setOnNavigationItemReselectedListener(@Nullable b bVar) {
        this.f2080h = bVar;
    }

    public void setOnNavigationItemSelectedListener(@Nullable c cVar) {
        this.f2079g = cVar;
    }

    public void setSelectedItemId(@IdRes int i2) {
        MenuItem menuItemFindItem = this.f2074b.findItem(i2);
        if (menuItemFindItem == null || this.f2074b.performItemAction(menuItemFindItem, this.f2076d, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, a), attributeSet, i2);
        BottomNavigationPresenter bottomNavigationPresenter = new BottomNavigationPresenter();
        this.f2076d = bottomNavigationPresenter;
        Context context2 = getContext();
        BottomNavigationMenu bottomNavigationMenu = new BottomNavigationMenu(context2);
        this.f2074b = bottomNavigationMenu;
        BottomNavigationMenuView bottomNavigationMenuView = new BottomNavigationMenuView(context2);
        this.f2075c = bottomNavigationMenuView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        bottomNavigationMenuView.setLayoutParams(layoutParams);
        bottomNavigationPresenter.f2070b = bottomNavigationMenuView;
        bottomNavigationPresenter.f2072d = 1;
        bottomNavigationMenuView.setPresenter(bottomNavigationPresenter);
        bottomNavigationMenu.addMenuPresenter(bottomNavigationPresenter);
        bottomNavigationPresenter.initForMenu(getContext(), bottomNavigationMenu);
        int[] iArr = R$styleable.BottomNavigationView;
        int i3 = R$style.Widget_Design_BottomNavigationView;
        int i4 = R$styleable.BottomNavigationView_itemTextAppearanceInactive;
        int i5 = R$styleable.BottomNavigationView_itemTextAppearanceActive;
        TintTypedArray tintTypedArrayE = g.e(context2, attributeSet, iArr, i2, i3, i4, i5);
        int i6 = R$styleable.BottomNavigationView_itemIconTint;
        if (tintTypedArrayE.hasValue(i6)) {
            bottomNavigationMenuView.setIconTintList(tintTypedArrayE.getColorStateList(i6));
        } else {
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.b(R.attr.textColorSecondary));
        }
        setItemIconSize(tintTypedArrayE.getDimensionPixelSize(R$styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R$dimen.design_bottom_navigation_icon_size)));
        if (tintTypedArrayE.hasValue(i4)) {
            setItemTextAppearanceInactive(tintTypedArrayE.getResourceId(i4, 0));
        }
        if (tintTypedArrayE.hasValue(i5)) {
            setItemTextAppearanceActive(tintTypedArrayE.getResourceId(i5, 0));
        }
        int i7 = R$styleable.BottomNavigationView_itemTextColor;
        if (tintTypedArrayE.hasValue(i7)) {
            setItemTextColor(tintTypedArrayE.getColorStateList(i7));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.q(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.f2333c.f2343b = new c.e.a.b.n.a(context2);
            materialShapeDrawable.C();
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        if (tintTypedArrayE.hasValue(R$styleable.BottomNavigationView_elevation)) {
            setElevation(tintTypedArrayE.getDimensionPixelSize(r2, 0));
        }
        DrawableCompat.setTintList(getBackground().mutate(), f.b2(context2, tintTypedArrayE, R$styleable.BottomNavigationView_backgroundTint));
        setLabelVisibilityMode(tintTypedArrayE.getInteger(R$styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(tintTypedArrayE.getBoolean(R$styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int resourceId = tintTypedArrayE.getResourceId(R$styleable.BottomNavigationView_itemBackground, 0);
        if (resourceId != 0) {
            bottomNavigationMenuView.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(f.b2(context2, tintTypedArrayE, R$styleable.BottomNavigationView_itemRippleColor));
        }
        int i8 = R$styleable.BottomNavigationView_menu;
        if (tintTypedArrayE.hasValue(i8)) {
            int resourceId2 = tintTypedArrayE.getResourceId(i8, 0);
            bottomNavigationPresenter.f2071c = true;
            getMenuInflater().inflate(resourceId2, bottomNavigationMenu);
            bottomNavigationPresenter.f2071c = false;
            bottomNavigationPresenter.updateMenuView(true);
        }
        tintTypedArrayE.recycle();
        addView(bottomNavigationMenuView, layoutParams);
        bottomNavigationMenu.setCallback(new a());
        f.u1(this, new c.e.a.b.f.a(this));
    }
}
