package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {
    public static final int[] a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f2054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f2055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f2056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f2057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2058l;

    @Nullable
    public MenuItemImpl m;

    @Nullable
    public ColorStateList n;

    @Nullable
    public Drawable o;

    @Nullable
    public Drawable p;

    @Nullable
    public BadgeDrawable q;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (BottomNavigationItemView.this.f2054h.getVisibility() == 0) {
                BottomNavigationItemView bottomNavigationItemView = BottomNavigationItemView.this;
                ImageView imageView = bottomNavigationItemView.f2054h;
                if (bottomNavigationItemView.b()) {
                    c.e.a.b.c.a.c(bottomNavigationItemView.q, imageView, null);
                }
            }
        }
    }

    public BottomNavigationItemView(@NonNull Context context) {
        this(context, null);
    }

    public static void c(@NonNull View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    public static void d(@NonNull View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    public static void e(@NonNull View view, int i2) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i2);
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i2 = 0;
        for (int i3 = 0; i3 < iIndexOfChild; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof BottomNavigationItemView) && childAt.getVisibility() == 0) {
                i2++;
            }
        }
        return i2;
    }

    public final void a(float f2, float f3) {
        this.f2049c = f2 - f3;
        this.f2050d = (f3 * 1.0f) / f2;
        this.f2051e = (f2 * 1.0f) / f3;
    }

    public final boolean b() {
        return this.q != null;
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.q;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.m;
    }

    public int getItemPosition() {
        return this.f2058l;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i2) {
        this.m = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        TooltipCompat.setTooltipText(this, !TextUtils.isEmpty(menuItemImpl.getTooltipText()) ? menuItemImpl.getTooltipText() : menuItemImpl.getTitle());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.m;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.m.isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, a);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.q;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.m.getTitle();
            if (!TextUtils.isEmpty(this.m.getContentDescription())) {
                title = this.m.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.q.c()));
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            accessibilityNodeInfoCompatWrap.setClickable(false);
            accessibilityNodeInfoCompatWrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        accessibilityNodeInfoCompatWrap.setRoleDescription(getResources().getString(R$string.item_view_role_description));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        this.q = badgeDrawable;
        ImageView imageView = this.f2054h;
        if (imageView == null || !b() || imageView == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        c.e.a.b.c.a.a(this.q, imageView, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        this.f2057k.setPivotX(r0.getWidth() / 2);
        this.f2057k.setPivotY(r0.getBaseline());
        this.f2056j.setPivotX(r0.getWidth() / 2);
        this.f2056j.setPivotY(r0.getBaseline());
        int i2 = this.f2052f;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z) {
                    c(this.f2054h, this.f2048b, 49);
                    ViewGroup viewGroup = this.f2055i;
                    e(viewGroup, ((Integer) viewGroup.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue());
                    this.f2057k.setVisibility(0);
                } else {
                    c(this.f2054h, this.f2048b, 17);
                    e(this.f2055i, 0);
                    this.f2057k.setVisibility(4);
                }
                this.f2056j.setVisibility(4);
            } else if (i2 == 1) {
                ViewGroup viewGroup2 = this.f2055i;
                e(viewGroup2, ((Integer) viewGroup2.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue());
                if (z) {
                    c(this.f2054h, (int) (this.f2048b + this.f2049c), 49);
                    d(this.f2057k, 1.0f, 1.0f, 0);
                    TextView textView = this.f2056j;
                    float f2 = this.f2050d;
                    d(textView, f2, f2, 4);
                } else {
                    c(this.f2054h, this.f2048b, 49);
                    TextView textView2 = this.f2057k;
                    float f3 = this.f2051e;
                    d(textView2, f3, f3, 4);
                    d(this.f2056j, 1.0f, 1.0f, 0);
                }
            } else if (i2 == 2) {
                c(this.f2054h, this.f2048b, 17);
                this.f2057k.setVisibility(8);
                this.f2056j.setVisibility(8);
            }
        } else if (this.f2053g) {
            if (z) {
                c(this.f2054h, this.f2048b, 49);
                ViewGroup viewGroup3 = this.f2055i;
                e(viewGroup3, ((Integer) viewGroup3.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue());
                this.f2057k.setVisibility(0);
            } else {
                c(this.f2054h, this.f2048b, 17);
                e(this.f2055i, 0);
                this.f2057k.setVisibility(4);
            }
            this.f2056j.setVisibility(4);
        } else {
            ViewGroup viewGroup4 = this.f2055i;
            e(viewGroup4, ((Integer) viewGroup4.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue());
            if (z) {
                c(this.f2054h, (int) (this.f2048b + this.f2049c), 49);
                d(this.f2057k, 1.0f, 1.0f, 0);
                TextView textView3 = this.f2056j;
                float f4 = this.f2050d;
                d(textView3, f4, f4, 4);
            } else {
                c(this.f2054h, this.f2048b, 49);
                TextView textView4 = this.f2057k;
                float f5 = this.f2051e;
                d(textView4, f5, f5, 4);
                d(this.f2056j, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f2056j.setEnabled(z);
        this.f2057k.setEnabled(z);
        this.f2054h.setEnabled(z);
        if (z) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.o) {
            return;
        }
        this.o = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.p = drawable;
            ColorStateList colorStateList = this.n;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
        this.f2054h.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2054h.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f2054h.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.n = colorStateList;
        if (this.m == null || (drawable = this.p) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable, colorStateList);
        this.p.invalidateSelf();
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemPosition(int i2) {
        this.f2058l = i2;
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f2052f != i2) {
            this.f2052f = i2;
            MenuItemImpl menuItemImpl = this.m;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.f2053g != z) {
            this.f2053g = z;
            MenuItemImpl menuItemImpl = this.m;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c2) {
    }

    public void setTextAppearanceActive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.f2057k, i2);
        a(this.f2056j.getTextSize(), this.f2057k.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.f2056j, i2);
        a(this.f2056j.getTextSize(), this.f2057k.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f2056j.setTextColor(colorStateList);
            this.f2057k.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.f2056j.setText(charSequence);
        this.f2057k.setText(charSequence);
        MenuItemImpl menuItemImpl = this.m;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.m;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.m.getTooltipText();
        }
        TooltipCompat.setTooltipText(this, charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public BottomNavigationItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2058l = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(R$layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(R$drawable.design_bottom_navigation_item_background);
        this.f2048b = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_margin);
        this.f2054h = (ImageView) findViewById(R$id.icon);
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.labelGroup);
        this.f2055i = viewGroup;
        TextView textView = (TextView) findViewById(R$id.smallLabel);
        this.f2056j = textView;
        TextView textView2 = (TextView) findViewById(R$id.largeLabel);
        this.f2057k = textView2;
        viewGroup.setTag(R$id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        a(textView.getTextSize(), textView2.getTextSize());
        ImageView imageView = this.f2054h;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.setBackground(this, drawable);
    }
}
