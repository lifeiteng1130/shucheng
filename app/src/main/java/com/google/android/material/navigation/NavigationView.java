package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import c.b.a.m.f;
import c.e.a.b.q.g;
import c.e.a.b.w.l;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f2307f = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f2308g = {-16842910};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f2309h = R$style.Widget_Design_NavigationView;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final NavigationMenu f2310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NavigationMenuPresenter f2311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f2312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f2313l;
    public final int[] m;
    public MenuInflater n;
    public ViewTreeObserver.OnGlobalLayoutListener o;

    public class a implements MenuBuilder.Callback {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            b bVar = NavigationView.this.f2312k;
            return bVar != null && bVar.e(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    public interface b {
        boolean e(@NonNull MenuItem menuItem);
    }

    public NavigationView(@NonNull Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.n == null) {
            this.n = new SupportMenuInflater(getContext());
        }
        return this.n;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a(@NonNull WindowInsetsCompat windowInsetsCompat) {
        NavigationMenuPresenter navigationMenuPresenter = this.f2311j;
        Objects.requireNonNull(navigationMenuPresenter);
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (navigationMenuPresenter.s != systemWindowInsetTop) {
            navigationMenuPresenter.s = systemWindowInsetTop;
            navigationMenuPresenter.d();
        }
        NavigationMenuView navigationMenuView = navigationMenuPresenter.a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(navigationMenuPresenter.f2287b, windowInsetsCompat);
    }

    @Nullable
    public final ColorStateList b(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = f2308g;
        return new ColorStateList(new int[][]{iArr, f2307f, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.f2311j.f2291f.f2298b;
    }

    public int getHeaderCount() {
        return this.f2311j.f2287b.getChildCount();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f2311j.f2297l;
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.f2311j.m;
    }

    @Dimension
    public int getItemIconPadding() {
        return this.f2311j.n;
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f2311j.f2296k;
    }

    public int getItemMaxLines() {
        return this.f2311j.r;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f2311j.f2295j;
    }

    @NonNull
    public Menu getMenu() {
        return this.f2310i;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            f.e5(this, (MaterialShapeDrawable) background);
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.o);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.f2313l), BasicMeasure.EXACTLY);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f2313l, BasicMeasure.EXACTLY);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2310i.restorePresenterStates(savedState.a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.a = bundle;
        this.f2310i.savePresenterStates(bundle);
        return savedState;
    }

    public void setCheckedItem(@IdRes int i2) {
        MenuItem menuItemFindItem = this.f2310i.findItem(i2);
        if (menuItemFindItem != null) {
            this.f2311j.f2291f.e((MenuItemImpl) menuItemFindItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        f.d5(this, f2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        NavigationMenuPresenter navigationMenuPresenter = this.f2311j;
        navigationMenuPresenter.f2297l = drawable;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemHorizontalPadding(@Dimension int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f2311j;
        navigationMenuPresenter.m = i2;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i2) {
        this.f2311j.a(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconPadding(@Dimension int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f2311j;
        navigationMenuPresenter.n = i2;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemIconPaddingResource(int i2) {
        this.f2311j.b(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconSize(@Dimension int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f2311j;
        if (navigationMenuPresenter.o != i2) {
            navigationMenuPresenter.o = i2;
            navigationMenuPresenter.p = true;
            navigationMenuPresenter.updateMenuView(false);
        }
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        NavigationMenuPresenter navigationMenuPresenter = this.f2311j;
        navigationMenuPresenter.f2296k = colorStateList;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemMaxLines(int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f2311j;
        navigationMenuPresenter.r = i2;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemTextAppearance(@StyleRes int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f2311j;
        navigationMenuPresenter.f2293h = i2;
        navigationMenuPresenter.f2294i = true;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        NavigationMenuPresenter navigationMenuPresenter = this.f2311j;
        navigationMenuPresenter.f2295j = colorStateList;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setNavigationItemSelectedListener(@Nullable b bVar) {
        this.f2312k = bVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        super.setOverScrollMode(i2);
        NavigationMenuPresenter navigationMenuPresenter = this.f2311j;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.u = i2;
            NavigationMenuView navigationMenuView = navigationMenuPresenter.a;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i2);
            }
        }
    }

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

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        ColorStateList colorStateListB;
        int resourceId;
        boolean z;
        int i3 = f2309h;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        NavigationMenuPresenter navigationMenuPresenter = new NavigationMenuPresenter();
        this.f2311j = navigationMenuPresenter;
        this.m = new int[2];
        Context context2 = getContext();
        NavigationMenu navigationMenu = new NavigationMenu(context2);
        this.f2310i = navigationMenu;
        TintTypedArray tintTypedArrayE = g.e(context2, attributeSet, R$styleable.NavigationView, i2, i3, new int[0]);
        int i4 = R$styleable.NavigationView_android_background;
        if (tintTypedArrayE.hasValue(i4)) {
            ViewCompat.setBackground(this, tintTypedArrayE.getDrawable(i4));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            l lVarA = l.c(context2, attributeSet, i2, i3, new c.e.a.b.w.a(0)).a();
            Drawable background = getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(lVarA);
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.q(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.f2333c.f2343b = new c.e.a.b.n.a(context2);
            materialShapeDrawable.C();
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        if (tintTypedArrayE.hasValue(R$styleable.NavigationView_elevation)) {
            setElevation(tintTypedArrayE.getDimensionPixelSize(r2, 0));
        }
        setFitsSystemWindows(tintTypedArrayE.getBoolean(R$styleable.NavigationView_android_fitsSystemWindows, false));
        this.f2313l = tintTypedArrayE.getDimensionPixelSize(R$styleable.NavigationView_android_maxWidth, 0);
        int i5 = R$styleable.NavigationView_itemIconTint;
        if (tintTypedArrayE.hasValue(i5)) {
            colorStateListB = tintTypedArrayE.getColorStateList(i5);
        } else {
            colorStateListB = b(R.attr.textColorSecondary);
        }
        int i6 = R$styleable.NavigationView_itemTextAppearance;
        if (tintTypedArrayE.hasValue(i6)) {
            resourceId = tintTypedArrayE.getResourceId(i6, 0);
            z = true;
        } else {
            resourceId = 0;
            z = false;
        }
        int i7 = R$styleable.NavigationView_itemIconSize;
        if (tintTypedArrayE.hasValue(i7)) {
            setItemIconSize(tintTypedArrayE.getDimensionPixelSize(i7, 0));
        }
        int i8 = R$styleable.NavigationView_itemTextColor;
        ColorStateList colorStateList = tintTypedArrayE.hasValue(i8) ? tintTypedArrayE.getColorStateList(i8) : null;
        if (!z && colorStateList == null) {
            colorStateList = b(R.attr.textColorPrimary);
        }
        Drawable drawable = tintTypedArrayE.getDrawable(R$styleable.NavigationView_itemBackground);
        if (drawable == null) {
            int i9 = R$styleable.NavigationView_itemShapeAppearance;
            if (tintTypedArrayE.hasValue(i9) || tintTypedArrayE.hasValue(R$styleable.NavigationView_itemShapeAppearanceOverlay)) {
                MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(l.a(getContext(), tintTypedArrayE.getResourceId(i9, 0), tintTypedArrayE.getResourceId(R$styleable.NavigationView_itemShapeAppearanceOverlay, 0)).a());
                materialShapeDrawable2.q(f.b2(getContext(), tintTypedArrayE, R$styleable.NavigationView_itemShapeFillColor));
                drawable = new InsetDrawable((Drawable) materialShapeDrawable2, tintTypedArrayE.getDimensionPixelSize(R$styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArrayE.getDimensionPixelSize(R$styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArrayE.getDimensionPixelSize(R$styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArrayE.getDimensionPixelSize(R$styleable.NavigationView_itemShapeInsetBottom, 0));
            }
        }
        int i10 = R$styleable.NavigationView_itemHorizontalPadding;
        if (tintTypedArrayE.hasValue(i10)) {
            navigationMenuPresenter.a(tintTypedArrayE.getDimensionPixelSize(i10, 0));
        }
        int dimensionPixelSize = tintTypedArrayE.getDimensionPixelSize(R$styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(tintTypedArrayE.getInt(R$styleable.NavigationView_itemMaxLines, 1));
        navigationMenu.setCallback(new a());
        navigationMenuPresenter.f2290e = 1;
        navigationMenuPresenter.initForMenu(context2, navigationMenu);
        navigationMenuPresenter.f2296k = colorStateListB;
        navigationMenuPresenter.updateMenuView(false);
        int overScrollMode = getOverScrollMode();
        navigationMenuPresenter.u = overScrollMode;
        NavigationMenuView navigationMenuView = navigationMenuPresenter.a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(overScrollMode);
        }
        if (z) {
            navigationMenuPresenter.f2293h = resourceId;
            navigationMenuPresenter.f2294i = true;
            navigationMenuPresenter.updateMenuView(false);
        }
        navigationMenuPresenter.f2295j = colorStateList;
        navigationMenuPresenter.updateMenuView(false);
        navigationMenuPresenter.f2297l = drawable;
        navigationMenuPresenter.updateMenuView(false);
        navigationMenuPresenter.b(dimensionPixelSize);
        navigationMenu.addMenuPresenter(navigationMenuPresenter);
        addView((View) navigationMenuPresenter.getMenuView(this));
        int i11 = R$styleable.NavigationView_menu;
        if (tintTypedArrayE.hasValue(i11)) {
            int resourceId2 = tintTypedArrayE.getResourceId(i11, 0);
            navigationMenuPresenter.c(true);
            getMenuInflater().inflate(resourceId2, navigationMenu);
            navigationMenuPresenter.c(false);
            navigationMenuPresenter.updateMenuView(false);
        }
        int i12 = R$styleable.NavigationView_headerLayout;
        if (tintTypedArrayE.hasValue(i12)) {
            navigationMenuPresenter.f2287b.addView(navigationMenuPresenter.f2292g.inflate(tintTypedArrayE.getResourceId(i12, 0), (ViewGroup) navigationMenuPresenter.f2287b, false));
            NavigationMenuView navigationMenuView2 = navigationMenuPresenter.a;
            navigationMenuView2.setPadding(0, 0, 0, navigationMenuView2.getPaddingBottom());
        }
        tintTypedArrayE.recycle();
        this.o = new c.e.a.b.r.a(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.o);
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f2310i.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f2311j.f2291f.e((MenuItemImpl) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
