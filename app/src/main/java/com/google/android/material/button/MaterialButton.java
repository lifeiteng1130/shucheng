package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import c.b.a.m.f;
import c.e.a.b.q.g;
import c.e.a.b.w.l;
import c.e.a.b.w.p;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, p {
    public static final int[] a = {R.attr.state_checkable};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f2106b = {R.attr.state_checked};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f2107c = R$style.Widget_MaterialComponents_Button;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final c.e.a.b.h.a f2108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinkedHashSet<a> f2109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public b f2110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public PorterDuff.Mode f2111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public ColorStateList f2112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Drawable f2113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Px
    public int f2114j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Px
    public int f2115k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Px
    public int f2116l;

    @Px
    public int m;
    public boolean n;
    public boolean o;
    public int p;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean a;

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
            @NonNull
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
            parcel.writeInt(this.a ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            this.a = parcel.readInt() == 1;
        }
    }

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    public interface b {
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        return Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
    }

    public boolean a() {
        c.e.a.b.h.a aVar = this.f2108d;
        return aVar != null && aVar.q;
    }

    public void addOnCheckedChangeListener(@NonNull a aVar) {
        this.f2109e.add(aVar);
    }

    public final boolean b() {
        int i2 = this.p;
        return i2 == 3 || i2 == 4;
    }

    public final boolean c() {
        int i2 = this.p;
        return i2 == 1 || i2 == 2;
    }

    public final boolean d() {
        int i2 = this.p;
        return i2 == 16 || i2 == 32;
    }

    public final boolean e() {
        c.e.a.b.h.a aVar = this.f2108d;
        return (aVar == null || aVar.o) ? false : true;
    }

    public final void f() {
        if (c()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.f2113i, null, null, null);
        } else if (b()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.f2113i, null);
        } else if (d()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.f2113i, null, null);
        }
    }

    public final void g(boolean z) {
        Drawable drawable = this.f2113i;
        if (drawable != null) {
            Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
            this.f2113i = drawableMutate;
            DrawableCompat.setTintList(drawableMutate, this.f2112h);
            PorterDuff.Mode mode = this.f2111g;
            if (mode != null) {
                DrawableCompat.setTintMode(this.f2113i, mode);
            }
            int intrinsicWidth = this.f2114j;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f2113i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f2114j;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f2113i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f2113i;
            int i2 = this.f2115k;
            int i3 = this.f2116l;
            drawable2.setBounds(i2, i3, intrinsicWidth + i2, intrinsicHeight + i3);
        }
        if (z) {
            f();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        boolean z2 = false;
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((c() && drawable3 != this.f2113i) || ((b() && drawable5 != this.f2113i) || (d() && drawable4 != this.f2113i))) {
            z2 = true;
        }
        if (z2) {
            f();
        }
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (e()) {
            return this.f2108d.f987g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f2113i;
    }

    public int getIconGravity() {
        return this.p;
    }

    @Px
    public int getIconPadding() {
        return this.m;
    }

    @Px
    public int getIconSize() {
        return this.f2114j;
    }

    public ColorStateList getIconTint() {
        return this.f2112h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f2111g;
    }

    @Dimension
    public int getInsetBottom() {
        return this.f2108d.f986f;
    }

    @Dimension
    public int getInsetTop() {
        return this.f2108d.f985e;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f2108d.f992l;
        }
        return null;
    }

    @Override // c.e.a.b.w.p
    @NonNull
    public l getShapeAppearanceModel() {
        if (e()) {
            return this.f2108d.f982b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f2108d.f991k;
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (e()) {
            return this.f2108d.f988h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.f2108d.f990j : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.f2108d.f989i : super.getSupportBackgroundTintMode();
    }

    public final void h(int i2, int i3) {
        if (this.f2113i == null || getLayout() == null) {
            return;
        }
        if (!c() && !b()) {
            if (d()) {
                this.f2115k = 0;
                if (this.p == 16) {
                    this.f2116l = 0;
                    g(false);
                    return;
                }
                int intrinsicHeight = this.f2114j;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f2113i.getIntrinsicHeight();
                }
                int textHeight = (((((i3 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.m) - getPaddingBottom()) / 2;
                if (this.f2116l != textHeight) {
                    this.f2116l = textHeight;
                    g(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f2116l = 0;
        int i4 = this.p;
        if (i4 == 1 || i4 == 3) {
            this.f2115k = 0;
            g(false);
            return;
        }
        int intrinsicWidth = this.f2114j;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f2113i.getIntrinsicWidth();
        }
        int textWidth = (((((i2 - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - intrinsicWidth) - this.m) - ViewCompat.getPaddingStart(this)) / 2;
        if ((ViewCompat.getLayoutDirection(this) == 1) != (this.p == 4)) {
            textWidth = -textWidth;
        }
        if (this.f2115k != textWidth) {
            this.f2115k = textWidth;
            g(false);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.n;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            f.e5(this, this.f2108d.b());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (a()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, a);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, f2106b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        c.e.a.b.h.a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.f2108d) == null) {
            return;
        }
        int i6 = i5 - i3;
        int i7 = i4 - i2;
        Drawable drawable = aVar.m;
        if (drawable != null) {
            drawable.setBounds(aVar.f983c, aVar.f985e, i7 - aVar.f984d, i6 - aVar.f986f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.a);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.n;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        h(i2, i3);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void removeOnCheckedChangeListener(@NonNull a aVar) {
        this.f2109e.remove(aVar);
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        if (!e()) {
            super.setBackgroundColor(i2);
            return;
        }
        c.e.a.b.h.a aVar = this.f2108d;
        if (aVar.b() != null) {
            aVar.b().setTint(i2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!e()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        c.e.a.b.h.a aVar = this.f2108d;
        aVar.o = true;
        aVar.a.setSupportBackgroundTintList(aVar.f990j);
        aVar.a.setSupportBackgroundTintMode(aVar.f989i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        setBackgroundDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (e()) {
            this.f2108d.q = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.n != z) {
            this.n = z;
            refreshDrawableState();
            if (this.o) {
                return;
            }
            this.o = true;
            Iterator<a> it = this.f2109e.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.n);
            }
            this.o = false;
        }
    }

    public void setCornerRadius(@Px int i2) {
        if (e()) {
            c.e.a.b.h.a aVar = this.f2108d;
            if (aVar.p && aVar.f987g == i2) {
                return;
            }
            aVar.f987g = i2;
            aVar.p = true;
            aVar.e(aVar.f982b.f(i2));
        }
    }

    public void setCornerRadiusResource(@DimenRes int i2) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (e()) {
            MaterialShapeDrawable materialShapeDrawableB = this.f2108d.b();
            MaterialShapeDrawable.b bVar = materialShapeDrawableB.f2333c;
            if (bVar.o != f2) {
                bVar.o = f2;
                materialShapeDrawableB.C();
            }
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f2113i != drawable) {
            this.f2113i = drawable;
            g(true);
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.p != i2) {
            this.p = i2;
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i2) {
        if (this.m != i2) {
            this.m = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(@DrawableRes int i2) {
        setIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setIconSize(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f2114j != i2) {
            this.f2114j = i2;
            g(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f2112h != colorStateList) {
            this.f2112h = colorStateList;
            g(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f2111g != mode) {
            this.f2111g = mode;
            g(false);
        }
    }

    public void setIconTintResource(@ColorRes int i2) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setInsetBottom(@Dimension int i2) {
        c.e.a.b.h.a aVar = this.f2108d;
        aVar.f(aVar.f985e, i2);
    }

    public void setInsetTop(@Dimension int i2) {
        c.e.a.b.h.a aVar = this.f2108d;
        aVar.f(i2, aVar.f986f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable b bVar) {
        this.f2110f = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        b bVar = this.f2110f;
        if (bVar != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            c.e.a.b.h.a aVar = this.f2108d;
            if (aVar.f992l != colorStateList) {
                aVar.f992l = colorStateList;
                if (aVar.a.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) aVar.a.getBackground()).setColor(c.e.a.b.u.a.c(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        if (e()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    @Override // c.e.a.b.w.p
    public void setShapeAppearanceModel(@NonNull l lVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f2108d.e(lVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (e()) {
            c.e.a.b.h.a aVar = this.f2108d;
            aVar.n = z;
            aVar.h();
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            c.e.a.b.h.a aVar = this.f2108d;
            if (aVar.f991k != colorStateList) {
                aVar.f991k = colorStateList;
                aVar.h();
            }
        }
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        if (e()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setStrokeWidth(@Px int i2) {
        if (e()) {
            c.e.a.b.h.a aVar = this.f2108d;
            if (aVar.f988h != i2) {
                aVar.f988h = i2;
                aVar.h();
            }
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (!e()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        c.e.a.b.h.a aVar = this.f2108d;
        if (aVar.f990j != colorStateList) {
            aVar.f990j = colorStateList;
            if (aVar.b() != null) {
                DrawableCompat.setTintList(aVar.b(), aVar.f990j);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (!e()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        c.e.a.b.h.a aVar = this.f2108d;
        if (aVar.f989i != mode) {
            aVar.f989i = mode;
            if (aVar.b() == null || aVar.f989i == null) {
                return;
            }
            DrawableCompat.setTintMode(aVar.b(), aVar.f989i);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.n);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = f2107c;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f2109e = new LinkedHashSet<>();
        this.n = false;
        this.o = false;
        Context context2 = getContext();
        TypedArray typedArrayD = g.d(context2, attributeSet, R$styleable.MaterialButton, i2, i3, new int[0]);
        this.m = typedArrayD.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.f2111g = f.j4(typedArrayD.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f2112h = f.a2(getContext(), typedArrayD, R$styleable.MaterialButton_iconTint);
        this.f2113i = f.n2(getContext(), typedArrayD, R$styleable.MaterialButton_icon);
        this.p = typedArrayD.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.f2114j = typedArrayD.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        c.e.a.b.h.a aVar = new c.e.a.b.h.a(this, l.c(context2, attributeSet, i2, i3, new c.e.a.b.w.a(0)).a());
        this.f2108d = aVar;
        Objects.requireNonNull(aVar);
        aVar.f983c = typedArrayD.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        aVar.f984d = typedArrayD.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        aVar.f985e = typedArrayD.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        aVar.f986f = typedArrayD.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        int i4 = R$styleable.MaterialButton_cornerRadius;
        if (typedArrayD.hasValue(i4)) {
            int dimensionPixelSize = typedArrayD.getDimensionPixelSize(i4, -1);
            aVar.f987g = dimensionPixelSize;
            aVar.e(aVar.f982b.f(dimensionPixelSize));
            aVar.p = true;
        }
        aVar.f988h = typedArrayD.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        aVar.f989i = f.j4(typedArrayD.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        aVar.f990j = f.a2(getContext(), typedArrayD, R$styleable.MaterialButton_backgroundTint);
        aVar.f991k = f.a2(getContext(), typedArrayD, R$styleable.MaterialButton_strokeColor);
        aVar.f992l = f.a2(getContext(), typedArrayD, R$styleable.MaterialButton_rippleColor);
        aVar.q = typedArrayD.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        aVar.s = typedArrayD.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        int paddingStart = ViewCompat.getPaddingStart(this);
        int paddingTop = getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this);
        int paddingBottom = getPaddingBottom();
        if (typedArrayD.hasValue(R$styleable.MaterialButton_android_background)) {
            aVar.o = true;
            setSupportBackgroundTintList(aVar.f990j);
            setSupportBackgroundTintMode(aVar.f989i);
        } else {
            aVar.g();
        }
        ViewCompat.setPaddingRelative(this, paddingStart + aVar.f983c, paddingTop + aVar.f985e, paddingEnd + aVar.f984d, paddingBottom + aVar.f986f);
        typedArrayD.recycle();
        setCompoundDrawablePadding(this.m);
        g(this.f2113i != null);
    }
}
