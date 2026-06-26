package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import c.b.a.m.f;
import c.e.a.b.a.g;
import c.e.a.b.t.d;
import c.e.a.b.w.l;
import c.e.a.b.w.p;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.a, p {
    public static final int a = R$style.Widget_MaterialComponents_Chip_Action;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Rect f2143b = new Rect();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f2144c = {R.attr.state_selected};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f2145d = {R.attr.state_checkable};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public ChipDrawable f2146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public InsetDrawable f2147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public RippleDrawable f2148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public View.OnClickListener f2149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public CompoundButton.OnCheckedChangeListener f2150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2152k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2153l;
    public boolean m;
    public boolean n;
    public int o;

    @Dimension(unit = 1)
    public int p;

    @NonNull
    public final b q;
    public final Rect r;
    public final RectF s;
    public final d t;

    public class a extends d {
        public a() {
        }

        @Override // c.e.a.b.t.d
        public void a(int i2) {
        }

        @Override // c.e.a.b.t.d
        public void b(@NonNull Typeface typeface, boolean z) {
            Chip chip = Chip.this;
            ChipDrawable chipDrawable = chip.f2146e;
            chip.setText(chipDrawable.J0 ? chipDrawable.H : chip.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public class b extends ExploreByTouchHelper {
        public b(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f2, float f3) {
            Chip chip = Chip.this;
            int i2 = Chip.a;
            return (chip.e() && Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 1 : 0;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(@NonNull List<Integer> list) {
            boolean z = false;
            list.add(0);
            Chip chip = Chip.this;
            int i2 = Chip.a;
            if (chip.e()) {
                Chip chip2 = Chip.this;
                ChipDrawable chipDrawable = chip2.f2146e;
                if (chipDrawable != null && chipDrawable.Q) {
                    z = true;
                }
                if (!z || chip2.f2149h == null) {
                    return;
                }
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
            boolean z = false;
            if (i3 == 16) {
                if (i2 == 0) {
                    return Chip.this.performClick();
                }
                if (i2 == 1) {
                    Chip chip = Chip.this;
                    chip.playSoundEffect(0);
                    View.OnClickListener onClickListener = chip.f2149h;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip);
                        z = true;
                    }
                    chip.q.sendEventForVirtualView(1, 1);
                }
            }
            return z;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCheckable(Chip.this.f());
            accessibilityNodeInfoCompat.setClickable(Chip.this.isClickable());
            if (Chip.this.f() || Chip.this.isClickable()) {
                accessibilityNodeInfoCompat.setClassName(Chip.this.f() ? "android.widget.CompoundButton" : "android.widget.Button");
            } else {
                accessibilityNodeInfoCompat.setClassName("android.view.View");
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.setText(text);
            } else {
                accessibilityNodeInfoCompat.setContentDescription(text);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (i2 != 1) {
                accessibilityNodeInfoCompat.setContentDescription("");
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.f2143b);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i3 = R$string.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                accessibilityNodeInfoCompat.setContentDescription(context.getString(i3, objArr).trim());
            }
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onVirtualViewKeyboardFocusChanged(int i2, boolean z) {
            if (i2 == 1) {
                Chip chip = Chip.this;
                chip.m = z;
                chip.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.s.setEmpty();
        if (e() && this.f2149h != null) {
            ChipDrawable chipDrawable = this.f2146e;
            chipDrawable.H(chipDrawable.getBounds(), this.s);
        }
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.r.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.r;
    }

    @Nullable
    private c.e.a.b.t.b getTextAppearance() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.q0.f1124f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.f2153l != z) {
            this.f2153l = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.f2152k != z) {
            this.f2152k = z;
            refreshDrawableState();
        }
    }

    @Override // com.google.android.material.chip.ChipDrawable.a
    public void a() {
        d(this.p);
        requestLayout();
        invalidateOutline();
    }

    public boolean d(@Dimension int i2) {
        this.p = i2;
        if (!this.n) {
            if (this.f2147f != null) {
                g();
            } else {
                int[] iArr = c.e.a.b.u.a.a;
                i();
            }
            return false;
        }
        int iMax = Math.max(0, i2 - this.f2146e.getIntrinsicHeight());
        int iMax2 = Math.max(0, i2 - this.f2146e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f2147f != null) {
                g();
            } else {
                int[] iArr2 = c.e.a.b.u.a.a;
                i();
            }
            return false;
        }
        int i3 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i4 = iMax > 0 ? iMax / 2 : 0;
        if (this.f2147f != null) {
            Rect rect = new Rect();
            this.f2147f.getPadding(rect);
            if (rect.top == i4 && rect.bottom == i4 && rect.left == i3 && rect.right == i3) {
                int[] iArr3 = c.e.a.b.u.a.a;
                i();
                return true;
            }
        }
        if (getMinHeight() != i2) {
            setMinHeight(i2);
        }
        if (getMinWidth() != i2) {
            setMinWidth(i2);
        }
        this.f2147f = new InsetDrawable((Drawable) this.f2146e, i3, i4, i3, i4);
        int[] iArr4 = c.e.a.b.u.a.a;
        i();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0043  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchHoverEvent(@androidx.annotation.NonNull android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.lang.Class<androidx.customview.widget.ExploreByTouchHelper> r0 = androidx.customview.widget.ExploreByTouchHelper.class
            int r1 = r8.getAction()
            r2 = 10
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L43
            java.lang.String r1 = "mHoveredVirtualViewId"
            java.lang.reflect.Field r1 = r0.getDeclaredField(r1)     // Catch: java.lang.Throwable -> L43
            r1.setAccessible(r3)     // Catch: java.lang.Throwable -> L43
            com.google.android.material.chip.Chip$b r2 = r7.q     // Catch: java.lang.Throwable -> L43
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L43
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L43
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L43
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r2) goto L43
            java.lang.String r1 = "updateHoveredVirtualView"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L43
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L43
            r5[r4] = r6     // Catch: java.lang.Throwable -> L43
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r5)     // Catch: java.lang.Throwable -> L43
            r0.setAccessible(r3)     // Catch: java.lang.Throwable -> L43
            com.google.android.material.chip.Chip$b r1 = r7.q     // Catch: java.lang.Throwable -> L43
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L43
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L43
            r5[r4] = r2     // Catch: java.lang.Throwable -> L43
            r0.invoke(r1, r5)     // Catch: java.lang.Throwable -> L43
            r0 = 1
            goto L44
        L43:
            r0 = 0
        L44:
            if (r0 != 0) goto L56
            com.google.android.material.chip.Chip$b r0 = r7.q
            boolean r0 = r0.dispatchHoverEvent(r8)
            if (r0 != 0) goto L56
            boolean r8 = super.dispatchHoverEvent(r8)
            if (r8 == 0) goto L55
            goto L56
        L55:
            r3 = 0
        L56:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.q.dispatchKeyEvent(keyEvent) || this.q.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.f2146e;
        boolean zJ0 = false;
        int i2 = 0;
        zJ0 = false;
        if (chipDrawable != null && ChipDrawable.N(chipDrawable.R)) {
            ChipDrawable chipDrawable2 = this.f2146e;
            ?? IsEnabled = isEnabled();
            int i3 = IsEnabled;
            if (this.m) {
                i3 = IsEnabled + 1;
            }
            int i4 = i3;
            if (this.f2153l) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (this.f2152k) {
                i5 = i4 + 1;
            }
            int i6 = i5;
            if (isChecked()) {
                i6 = i5 + 1;
            }
            int[] iArr = new int[i6];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i2 = 1;
            }
            if (this.m) {
                iArr[i2] = 16842908;
                i2++;
            }
            if (this.f2153l) {
                iArr[i2] = 16843623;
                i2++;
            }
            if (this.f2152k) {
                iArr[i2] = 16842919;
                i2++;
            }
            if (isChecked()) {
                iArr[i2] = 16842913;
            }
            zJ0 = chipDrawable2.j0(iArr);
        }
        if (zJ0) {
            invalidate();
        }
    }

    public final boolean e() {
        ChipDrawable chipDrawable = this.f2146e;
        return (chipDrawable == null || chipDrawable.K() == null) ? false : true;
    }

    public boolean f() {
        ChipDrawable chipDrawable = this.f2146e;
        return chipDrawable != null && chipDrawable.W;
    }

    public final void g() {
        if (this.f2147f != null) {
            this.f2147f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            int[] iArr = c.e.a.b.u.a.a;
            i();
        }
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f2147f;
        return insetDrawable == null ? this.f2146e : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.Y;
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.Z;
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.B;
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return Math.max(0.0f, chipDrawable.J());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f2146e;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.j0;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable;
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable == null || (drawable = chipDrawable.J) == null) {
            return null;
        }
        return DrawableCompat.unwrap(drawable);
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.O;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.K;
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.C;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.c0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.E;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.F;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.K();
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.V;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.i0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.U;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.h0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.T;
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.I0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        if (this.q.getKeyboardFocusedVirtualViewId() == 1 || this.q.getAccessibilityFocusedVirtualViewId() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    @Nullable
    public g getHideMotionSpec() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.b0;
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.e0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.d0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.G;
        }
        return null;
    }

    @Override // c.e.a.b.w.p
    @NonNull
    public l getShapeAppearanceModel() {
        return this.f2146e.f2333c.a;
    }

    @Nullable
    public g getShowMotionSpec() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.a0;
        }
        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.g0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            return chipDrawable.f0;
        }
        return 0.0f;
    }

    public final void h() {
        if (e()) {
            ChipDrawable chipDrawable = this.f2146e;
            if ((chipDrawable != null && chipDrawable.Q) && this.f2149h != null) {
                ViewCompat.setAccessibilityDelegate(this, this.q);
                return;
            }
        }
        ViewCompat.setAccessibilityDelegate(this, null);
    }

    public final void i() {
        this.f2148g = new RippleDrawable(c.e.a.b.u.a.c(this.f2146e.G), getBackgroundDrawable(), null);
        this.f2146e.s0(false);
        ViewCompat.setBackground(this, this.f2148g);
        j();
    }

    public final void j() {
        ChipDrawable chipDrawable;
        if (TextUtils.isEmpty(getText()) || (chipDrawable = this.f2146e) == null) {
            return;
        }
        int I = (int) (chipDrawable.I() + chipDrawable.j0 + chipDrawable.g0);
        ChipDrawable chipDrawable2 = this.f2146e;
        int iF = (int) (chipDrawable2.F() + chipDrawable2.c0 + chipDrawable2.f0);
        if (this.f2147f != null) {
            Rect rect = new Rect();
            this.f2147f.getPadding(rect);
            iF += rect.left;
            I += rect.right;
        }
        ViewCompat.setPaddingRelative(this, iF, getPaddingTop(), I, getPaddingBottom());
    }

    public final void k() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            paint.drawableState = chipDrawable.getState();
        }
        c.e.a.b.t.b textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.c(getContext(), paint, this.t);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f.e5(this, this.f2146e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, f2144c);
        }
        if (f()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, f2145d);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        this.q.onFocusChanged(z, i2, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (f() || isClickable()) {
            accessibilityNodeInfo.setClassName(f() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfo.setClassName("android.view.View");
        }
        accessibilityNodeInfo.setCheckable(f());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            if (chipGroup.f2274c) {
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 >= chipGroup.getChildCount()) {
                        i4 = -1;
                        break;
                    }
                    if (chipGroup.getChildAt(i3) instanceof Chip) {
                        if (((Chip) chipGroup.getChildAt(i3)) == this) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    i3++;
                }
                i2 = i4;
            } else {
                i2 = -1;
            }
            Object tag = getTag(R$id.row_index_key);
            accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(!(tag instanceof Integer) ? -1 : ((Integer) tag).intValue(), 1, i2, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i2) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.o != i2) {
            this.o = i2;
            j();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L25;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L45
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L40
            goto L4c
        L21:
            boolean r0 = r5.f2152k
            if (r0 == 0) goto L4c
            if (r1 != 0) goto L4a
            r5.setCloseIconPressed(r2)
            goto L4a
        L2b:
            boolean r0 = r5.f2152k
            if (r0 == 0) goto L40
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.f2149h
            if (r0 == 0) goto L39
            r0.onClick(r5)
        L39:
            com.google.android.material.chip.Chip$b r0 = r5.q
            r0.sendEventForVirtualView(r3, r3)
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            r5.setCloseIconPressed(r2)
            goto L4d
        L45:
            if (r1 == 0) goto L4c
            r5.setCloseIconPressed(r3)
        L4a:
            r0 = 1
            goto L4d
        L4c:
            r0 = 0
        L4d:
            if (r0 != 0) goto L55
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L56
        L55:
            r2 = 1
        L56:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2148g) {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2148g) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i2) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
    }

    public void setCheckable(boolean z) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.Q(z);
        }
    }

    public void setCheckableResource(@BoolRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.Q(chipDrawable.k0.getResources().getBoolean(i2));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable == null) {
            this.f2151j = z;
            return;
        }
        if (chipDrawable.W) {
            boolean zIsChecked = isChecked();
            super.setChecked(z);
            if (zIsChecked == z || (onCheckedChangeListener = this.f2150i) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.R(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.R(AppCompatResources.getDrawable(chipDrawable.k0, i2));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.S(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.S(AppCompatResources.getColorStateList(chipDrawable.k0, i2));
        }
    }

    public void setCheckedIconVisible(@BoolRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.T(chipDrawable.k0.getResources().getBoolean(i2));
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable == null || chipDrawable.B == colorStateList) {
            return;
        }
        chipDrawable.B = colorStateList;
        chipDrawable.onStateChange(chipDrawable.getState());
    }

    public void setChipBackgroundColorResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.U(AppCompatResources.getColorStateList(chipDrawable.k0, i2));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.V(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.V(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    public void setChipDrawable(@NonNull ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2 = this.f2146e;
        if (chipDrawable2 != chipDrawable) {
            if (chipDrawable2 != null) {
                chipDrawable2.H0 = new WeakReference<>(null);
            }
            this.f2146e = chipDrawable;
            chipDrawable.J0 = false;
            Objects.requireNonNull(chipDrawable);
            chipDrawable.H0 = new WeakReference<>(this);
            d(this.p);
        }
    }

    public void setChipEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable == null || chipDrawable.j0 == f2) {
            return;
        }
        chipDrawable.j0 = f2;
        chipDrawable.invalidateSelf();
        chipDrawable.O();
    }

    public void setChipEndPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.W(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.X(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(@DrawableRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.X(AppCompatResources.getDrawable(chipDrawable.k0, i2));
        }
    }

    public void setChipIconSize(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.Y(f2);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.Y(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.Z(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.Z(AppCompatResources.getColorStateList(chipDrawable.k0, i2));
        }
    }

    public void setChipIconVisible(@BoolRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.a0(chipDrawable.k0.getResources().getBoolean(i2));
        }
    }

    public void setChipMinHeight(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable == null || chipDrawable.C == f2) {
            return;
        }
        chipDrawable.C = f2;
        chipDrawable.invalidateSelf();
        chipDrawable.O();
    }

    public void setChipMinHeightResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.b0(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    public void setChipStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable == null || chipDrawable.c0 == f2) {
            return;
        }
        chipDrawable.c0 = f2;
        chipDrawable.invalidateSelf();
        chipDrawable.O();
    }

    public void setChipStartPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.c0(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.d0(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.d0(AppCompatResources.getColorStateList(chipDrawable.k0, i2));
        }
    }

    public void setChipStrokeWidth(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.e0(f2);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.e0(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.f0(drawable);
        }
        h();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable == null || chipDrawable.V == charSequence) {
            return;
        }
        chipDrawable.V = BidiFormatter.getInstance().unicodeWrap(charSequence);
        chipDrawable.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.g0(f2);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.g0(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconResource(@DrawableRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.f0(AppCompatResources.getDrawable(chipDrawable.k0, i2));
        }
        h();
    }

    public void setCloseIconSize(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.h0(f2);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.h0(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.i0(f2);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.i0(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.k0(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.k0(AppCompatResources.getColorStateList(chipDrawable.k0, i2));
        }
    }

    public void setCloseIconVisible(@BoolRes int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            MaterialShapeDrawable.b bVar = chipDrawable.f2333c;
            if (bVar.o != f2) {
                bVar.o = f2;
                chipDrawable.C();
            }
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f2146e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.I0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.n = z;
        d(this.p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i2) {
        if (i2 != 8388627) {
            return;
        }
        super.setGravity(i2);
    }

    public void setHideMotionSpec(@Nullable g gVar) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.b0 = gVar;
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.b0 = g.b(chipDrawable.k0, i2);
        }
    }

    public void setIconEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.m0(f2);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.m0(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    public void setIconStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.n0(f2);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.n0(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        if (this.f2146e == null) {
            return;
        }
        super.setLayoutDirection(i2);
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i2) {
        super.setMaxWidth(i2);
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.K0 = i2;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i2);
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f2150i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f2149h = onClickListener;
        h();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.o0(colorStateList);
        }
        if (this.f2146e.F0) {
            return;
        }
        i();
    }

    public void setRippleColorResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.o0(AppCompatResources.getColorStateList(chipDrawable.k0, i2));
            if (this.f2146e.F0) {
                return;
            }
            i();
        }
    }

    @Override // c.e.a.b.w.p
    public void setShapeAppearanceModel(@NonNull l lVar) {
        ChipDrawable chipDrawable = this.f2146e;
        chipDrawable.f2333c.a = lVar;
        chipDrawable.invalidateSelf();
    }

    public void setShowMotionSpec(@Nullable g gVar) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.a0 = gVar;
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.a0 = g.b(chipDrawable.k0, i2);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(chipDrawable.J0 ? null : charSequence, bufferType);
        ChipDrawable chipDrawable2 = this.f2146e;
        if (chipDrawable2 != null) {
            chipDrawable2.p0(charSequence);
        }
    }

    public void setTextAppearance(@Nullable c.e.a.b.t.b bVar) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.q0.b(bVar, chipDrawable.k0);
        }
        k();
    }

    public void setTextAppearanceResource(@StyleRes int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable == null || chipDrawable.g0 == f2) {
            return;
        }
        chipDrawable.g0 = f2;
        chipDrawable.invalidateSelf();
        chipDrawable.O();
    }

    public void setTextEndPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.q0(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    public void setTextStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable == null || chipDrawable.f0 == f2) {
            return;
        }
        chipDrawable.f0 = f2;
        chipDrawable.invalidateSelf();
        chipDrawable.O();
    }

    public void setTextStartPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.r0(chipDrawable.k0.getResources().getDimension(i2));
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.l0(z);
        }
        h();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i2) {
        int i3 = a;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.r = new Rect();
        this.s = new RectF();
        this.t = new a();
        Context context2 = getContext();
        if (attributeSet != null) {
            attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background");
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                            if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                                attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627);
                            } else {
                                throw new UnsupportedOperationException("Chip does not support multi-line text");
                            }
                        } else {
                            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                        }
                    } else {
                        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                    }
                } else {
                    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
                }
            } else {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
        }
        ChipDrawable chipDrawable = new ChipDrawable(context2, attributeSet, i2, i3);
        Context context3 = chipDrawable.k0;
        int[] iArr = R$styleable.Chip;
        TypedArray typedArrayD = c.e.a.b.q.g.d(context3, attributeSet, iArr, i2, i3, new int[0]);
        int i4 = R$styleable.Chip_shapeAppearance;
        chipDrawable.L0 = typedArrayD.hasValue(i4);
        ColorStateList colorStateListA2 = f.a2(chipDrawable.k0, typedArrayD, R$styleable.Chip_chipSurfaceColor);
        if (chipDrawable.A != colorStateListA2) {
            chipDrawable.A = colorStateListA2;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        chipDrawable.U(f.a2(chipDrawable.k0, typedArrayD, R$styleable.Chip_chipBackgroundColor));
        chipDrawable.b0(typedArrayD.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        int i5 = R$styleable.Chip_chipCornerRadius;
        if (typedArrayD.hasValue(i5)) {
            chipDrawable.V(typedArrayD.getDimension(i5, 0.0f));
        }
        chipDrawable.d0(f.a2(chipDrawable.k0, typedArrayD, R$styleable.Chip_chipStrokeColor));
        chipDrawable.e0(typedArrayD.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        chipDrawable.o0(f.a2(chipDrawable.k0, typedArrayD, R$styleable.Chip_rippleColor));
        chipDrawable.p0(typedArrayD.getText(R$styleable.Chip_android_text));
        c.e.a.b.t.b bVarY2 = f.Y2(chipDrawable.k0, typedArrayD, R$styleable.Chip_android_textAppearance);
        bVarY2.f1199k = typedArrayD.getDimension(R$styleable.Chip_android_textSize, bVarY2.f1199k);
        chipDrawable.q0.b(bVarY2, chipDrawable.k0);
        int i6 = typedArrayD.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i6 == 1) {
            chipDrawable.I0 = TextUtils.TruncateAt.START;
        } else if (i6 == 2) {
            chipDrawable.I0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i6 == 3) {
            chipDrawable.I0 = TextUtils.TruncateAt.END;
        }
        chipDrawable.a0(typedArrayD.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            chipDrawable.a0(typedArrayD.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        chipDrawable.X(f.n2(chipDrawable.k0, typedArrayD, R$styleable.Chip_chipIcon));
        int i7 = R$styleable.Chip_chipIconTint;
        if (typedArrayD.hasValue(i7)) {
            chipDrawable.Z(f.a2(chipDrawable.k0, typedArrayD, i7));
        }
        chipDrawable.Y(typedArrayD.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
        chipDrawable.l0(typedArrayD.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            chipDrawable.l0(typedArrayD.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        chipDrawable.f0(f.n2(chipDrawable.k0, typedArrayD, R$styleable.Chip_closeIcon));
        chipDrawable.k0(f.a2(chipDrawable.k0, typedArrayD, R$styleable.Chip_closeIconTint));
        chipDrawable.h0(typedArrayD.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        chipDrawable.Q(typedArrayD.getBoolean(R$styleable.Chip_android_checkable, false));
        chipDrawable.T(typedArrayD.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            chipDrawable.T(typedArrayD.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        chipDrawable.R(f.n2(chipDrawable.k0, typedArrayD, R$styleable.Chip_checkedIcon));
        int i8 = R$styleable.Chip_checkedIconTint;
        if (typedArrayD.hasValue(i8)) {
            chipDrawable.S(f.a2(chipDrawable.k0, typedArrayD, i8));
        }
        chipDrawable.a0 = g.a(chipDrawable.k0, typedArrayD, R$styleable.Chip_showMotionSpec);
        chipDrawable.b0 = g.a(chipDrawable.k0, typedArrayD, R$styleable.Chip_hideMotionSpec);
        chipDrawable.c0(typedArrayD.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        chipDrawable.n0(typedArrayD.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        chipDrawable.m0(typedArrayD.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        chipDrawable.r0(typedArrayD.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        chipDrawable.q0(typedArrayD.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        chipDrawable.i0(typedArrayD.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        chipDrawable.g0(typedArrayD.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        chipDrawable.W(typedArrayD.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        chipDrawable.K0 = typedArrayD.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE);
        typedArrayD.recycle();
        c.e.a.b.q.g.a(context2, attributeSet, i2, i3);
        c.e.a.b.q.g.b(context2, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.n = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
        this.p = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(f.w1(getContext(), 48))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(chipDrawable);
        chipDrawable.p(ViewCompat.getElevation(this));
        c.e.a.b.q.g.a(context2, attributeSet, i2, i3);
        c.e.a.b.q.g.b(context2, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(f.a2(context2, typedArrayObtainStyledAttributes2, R$styleable.Chip_android_textColor));
        }
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(i4);
        typedArrayObtainStyledAttributes2.recycle();
        this.q = new b(this);
        h();
        if (!zHasValue) {
            setOutlineProvider(new c.e.a.b.j.a(this));
        }
        setChecked(this.f2151j);
        setText(chipDrawable.H);
        setEllipsize(chipDrawable.I0);
        k();
        if (!this.f2146e.J0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        j();
        if (this.n) {
            setMinHeight(this.p);
        }
        this.o = ViewCompat.getLayoutDirection(this);
    }

    public void setCheckedIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.T(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.a0(z);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.q0.b(new c.e.a.b.t.b(chipDrawable.k0, i2), chipDrawable.k0);
        }
        k();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        ChipDrawable chipDrawable = this.f2146e;
        if (chipDrawable != null) {
            chipDrawable.q0.b(new c.e.a.b.t.b(chipDrawable.k0, i2), chipDrawable.k0);
        }
        k();
    }
}
