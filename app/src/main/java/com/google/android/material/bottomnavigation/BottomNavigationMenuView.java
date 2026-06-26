package com.google.android.material.bottomnavigation;

import android.R;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionSet;
import com.google.android.material.R$dimen;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    public static final int[] a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f2059b = {-16842910};
    public BottomNavigationPresenter A;
    public MenuBuilder B;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TransitionSet f2060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2065h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final View.OnClickListener f2066i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Pools.Pool<BottomNavigationItemView> f2067j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final SparseArray<View.OnTouchListener> f2068k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2069l;
    public int m;

    @Nullable
    public BottomNavigationItemView[] n;
    public int o;
    public int p;
    public ColorStateList q;

    @Dimension
    public int r;
    public ColorStateList s;

    @Nullable
    public final ColorStateList t;

    @StyleRes
    public int u;

    @StyleRes
    public int v;
    public Drawable w;
    public int x;
    public int[] y;

    @NonNull
    public SparseArray<BadgeDrawable> z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
            BottomNavigationMenuView bottomNavigationMenuView = BottomNavigationMenuView.this;
            if (bottomNavigationMenuView.B.performItemAction(itemData, bottomNavigationMenuView.A, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView bottomNavigationItemViewAcquire = this.f2067j.acquire();
        return bottomNavigationItemViewAcquire == null ? new BottomNavigationItemView(getContext()) : bottomNavigationItemViewAcquire;
    }

    private void setBadgeIfNeeded(@NonNull BottomNavigationItemView bottomNavigationItemView) {
        BadgeDrawable badgeDrawable;
        int id = bottomNavigationItemView.getId();
        if ((id != -1) && (badgeDrawable = this.z.get(id)) != null) {
            bottomNavigationItemView.setBadge(badgeDrawable);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a() {
        removeAllViews();
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.n;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.f2067j.release(bottomNavigationItemView);
                    ImageView imageView = bottomNavigationItemView.f2054h;
                    if (bottomNavigationItemView.b()) {
                        if (imageView != null) {
                            bottomNavigationItemView.setClipChildren(true);
                            bottomNavigationItemView.setClipToPadding(true);
                            c.e.a.b.c.a.b(bottomNavigationItemView.q, imageView);
                        }
                        bottomNavigationItemView.q = null;
                    }
                }
            }
        }
        if (this.B.size() == 0) {
            this.o = 0;
            this.p = 0;
            this.n = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.B.size(); i2++) {
            hashSet.add(Integer.valueOf(this.B.getItem(i2).getItemId()));
        }
        for (int i3 = 0; i3 < this.z.size(); i3++) {
            int iKeyAt = this.z.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.z.delete(iKeyAt);
            }
        }
        this.n = new BottomNavigationItemView[this.B.size()];
        boolean zC = c(this.m, this.B.getVisibleItems().size());
        for (int i4 = 0; i4 < this.B.size(); i4++) {
            this.A.f2071c = true;
            this.B.getItem(i4).setCheckable(true);
            this.A.f2071c = false;
            BottomNavigationItemView newItem = getNewItem();
            this.n[i4] = newItem;
            newItem.setIconTintList(this.q);
            newItem.setIconSize(this.r);
            newItem.setTextColor(this.t);
            newItem.setTextAppearanceInactive(this.u);
            newItem.setTextAppearanceActive(this.v);
            newItem.setTextColor(this.s);
            Drawable drawable = this.w;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.x);
            }
            newItem.setShifting(zC);
            newItem.setLabelVisibilityMode(this.m);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.B.getItem(i4);
            newItem.initialize(menuItemImpl, 0);
            newItem.setItemPosition(i4);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener(this.f2068k.get(itemId));
            newItem.setOnClickListener(this.f2066i);
            int i5 = this.o;
            if (i5 != 0 && itemId == i5) {
                this.p = i4;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.B.size() - 1, this.p);
        this.p = iMin;
        this.B.getItem(iMin).setChecked(true);
    }

    @Nullable
    public ColorStateList b(int i2) {
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
        int[] iArr = f2059b;
        return new ColorStateList(new int[][]{iArr, a, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    public final boolean c(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.z;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.q;
    }

    @Nullable
    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.n;
        return (bottomNavigationItemViewArr == null || bottomNavigationItemViewArr.length <= 0) ? this.w : bottomNavigationItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.x;
    }

    @Dimension
    public int getItemIconSize() {
        return this.r;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.v;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.u;
    }

    public ColorStateList getItemTextColor() {
        return this.s;
    }

    public int getLabelVisibilityMode() {
        return this.m;
    }

    public int getSelectedItemId() {
        return this.o;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.B = menuBuilder;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.B.getVisibleItems().size(), false, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int measuredWidth = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i9 = i6 - measuredWidth;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i7);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i7);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.B.getVisibleItems().size();
        int childCount = getChildCount();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2065h, BasicMeasure.EXACTLY);
        if (c(this.m, size2) && this.f2069l) {
            View childAt = getChildAt(this.p);
            int iMax = this.f2064g;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f2063f, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i4 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.f2062e * i4), Math.min(iMax, this.f2063f));
            int i5 = size - iMin;
            int iMin2 = Math.min(i5 / (i4 == 0 ? 1 : i4), this.f2061d);
            int i6 = i5 - (i4 * iMin2);
            int i7 = 0;
            while (i7 < childCount) {
                if (getChildAt(i7).getVisibility() != 8) {
                    int[] iArr = this.y;
                    iArr[i7] = i7 == this.p ? iMin : iMin2;
                    if (i6 > 0) {
                        iArr[i7] = iArr[i7] + 1;
                        i6--;
                    }
                } else {
                    this.y[i7] = 0;
                }
                i7++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 == 0 ? 1 : size2), this.f2063f);
            int i8 = size - (size2 * iMin3);
            for (int i9 = 0; i9 < childCount; i9++) {
                if (getChildAt(i9).getVisibility() != 8) {
                    int[] iArr2 = this.y;
                    iArr2[i9] = iMin3;
                    if (i8 > 0) {
                        iArr2[i9] = iArr2[i9] + 1;
                        i8--;
                    }
                } else {
                    this.y[i9] = 0;
                }
            }
        }
        int measuredWidth = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt2 = getChildAt(i10);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.y[i10], BasicMeasure.EXACTLY), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth, View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY), 0), View.resolveSizeAndState(this.f2065h, iMakeMeasureSpec, 0));
    }

    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.z = sparseArray;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.n;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setBadge(sparseArray.get(bottomNavigationItemView.getId()));
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.q = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.n;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.w = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.n;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.x = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.n;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(i2);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.f2069l = z;
    }

    public void setItemIconSize(@Dimension int i2) {
        this.r = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.n;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconSize(i2);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.v = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.n;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.s;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.u = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.n;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.s;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.s = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.n;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.m = i2;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.A = bottomNavigationPresenter;
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2067j = new Pools.SynchronizedPool(5);
        this.f2068k = new SparseArray<>(5);
        this.o = 0;
        this.p = 0;
        this.z = new SparseArray<>(5);
        Resources resources = getResources();
        this.f2061d = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_max_width);
        this.f2062e = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_min_width);
        this.f2063f = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_max_width);
        this.f2064g = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_min_width);
        this.f2065h = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_height);
        this.t = b(R.attr.textColorSecondary);
        AutoTransition autoTransition = new AutoTransition();
        this.f2060c = autoTransition;
        autoTransition.setOrdering(0);
        autoTransition.setDuration(115L);
        autoTransition.setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator());
        autoTransition.addTransition(new TextScale());
        this.f2066i = new a();
        this.y = new int[5];
        ViewCompat.setImportantForAccessibility(this, 1);
    }
}
