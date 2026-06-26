package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;
import c.e.a.b.q.e;
import c.e.a.b.q.g;
import c.e.a.b.t.b;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes.dex */
public class BadgeDrawable extends Drawable implements e.b {

    @StyleRes
    public static final int a = R$style.Widget_MaterialComponents_Badge;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @AttrRes
    public static final int f1995b = R$attr.badgeStyle;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final WeakReference<Context> f1996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final MaterialShapeDrawable f1997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final e f1998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final Rect f1999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f2000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f2001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f2002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final SavedState f2003j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f2004k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f2005l;
    public int m;
    public float n;
    public float o;
    public float p;

    @Nullable
    public WeakReference<View> q;

    @Nullable
    public WeakReference<FrameLayout> r;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    public BadgeDrawable(@NonNull Context context) {
        b bVar;
        Context context2;
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.f1996c = weakReference;
        g.c(context, g.f1125b, "Theme.MaterialComponents");
        Resources resources = context.getResources();
        this.f1999f = new Rect();
        this.f1997d = new MaterialShapeDrawable();
        this.f2000g = resources.getDimensionPixelSize(R$dimen.mtrl_badge_radius);
        this.f2002i = resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding);
        this.f2001h = resources.getDimensionPixelSize(R$dimen.mtrl_badge_with_text_radius);
        e eVar = new e(this);
        this.f1998e = eVar;
        eVar.a.setTextAlign(Paint.Align.CENTER);
        this.f2003j = new SavedState(context);
        int i2 = R$style.TextAppearance_MaterialComponents_Badge;
        Context context3 = weakReference.get();
        if (context3 == null || eVar.f1124f == (bVar = new b(context3, i2)) || (context2 = weakReference.get()) == null) {
            return;
        }
        eVar.b(bVar, context2);
        m();
    }

    @Override // c.e.a.b.q.e.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a() {
        invalidateSelf();
    }

    @NonNull
    public final String b() {
        if (e() <= this.m) {
            return NumberFormat.getInstance().format(e());
        }
        Context context = this.f1996c.get();
        return context == null ? "" : context.getString(R$string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.m), Marker.ANY_NON_NULL_MARKER);
    }

    @Nullable
    public CharSequence c() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!f()) {
            return this.f2003j.f2010f;
        }
        if (this.f2003j.f2011g <= 0 || (context = this.f1996c.get()) == null) {
            return null;
        }
        int iE = e();
        int i2 = this.m;
        return iE <= i2 ? context.getResources().getQuantityString(this.f2003j.f2011g, e(), Integer.valueOf(e())) : context.getString(this.f2003j.f2012h, Integer.valueOf(i2));
    }

    @Nullable
    public FrameLayout d() {
        WeakReference<FrameLayout> weakReference = this.r;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (getBounds().isEmpty() || this.f2003j.f2007c == 0 || !isVisible()) {
            return;
        }
        this.f1997d.draw(canvas);
        if (f()) {
            Rect rect = new Rect();
            String strB = b();
            this.f1998e.a.getTextBounds(strB, 0, strB.length(), rect);
            canvas.drawText(strB, this.f2004k, this.f2005l + (rect.height() / 2), this.f1998e.a);
        }
    }

    public int e() {
        if (f()) {
            return this.f2003j.f2008d;
        }
        return 0;
    }

    public boolean f() {
        return this.f2003j.f2008d != -1;
    }

    public void g(@ColorInt int i2) {
        this.f2003j.a = i2;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i2);
        MaterialShapeDrawable materialShapeDrawable = this.f1997d;
        if (materialShapeDrawable.f2333c.f2345d != colorStateListValueOf) {
            materialShapeDrawable.q(colorStateListValueOf);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2003j.f2007c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1999f.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1999f.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(int i2) {
        SavedState savedState = this.f2003j;
        if (savedState.f2013i != i2) {
            savedState.f2013i = i2;
            WeakReference<View> weakReference = this.q;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.q.get();
            WeakReference<FrameLayout> weakReference2 = this.r;
            l(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    public void i(@ColorInt int i2) {
        this.f2003j.f2006b = i2;
        if (this.f1998e.a.getColor() != i2) {
            this.f1998e.a.setColor(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public void j(int i2) {
        SavedState savedState = this.f2003j;
        if (savedState.f2009e != i2) {
            savedState.f2009e = i2;
            this.m = ((int) Math.pow(10.0d, ((double) i2) - 1.0d)) - 1;
            this.f1998e.f1122d = true;
            m();
            invalidateSelf();
        }
    }

    public void k(int i2) {
        int iMax = Math.max(0, i2);
        SavedState savedState = this.f2003j;
        if (savedState.f2008d != iMax) {
            savedState.f2008d = iMax;
            this.f1998e.f1122d = true;
            m();
            invalidateSelf();
        }
    }

    public void l(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.q = new WeakReference<>(view);
        this.r = new WeakReference<>(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        m();
        invalidateSelf();
    }

    public final void m() {
        Context context = this.f1996c.get();
        WeakReference<View> weakReference = this.q;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f1999f);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.r;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        int i2 = this.f2003j.f2013i;
        if (i2 == 8388691 || i2 == 8388693) {
            this.f2005l = rect2.bottom - r2.f2016l;
        } else {
            this.f2005l = rect2.top + r2.f2016l;
        }
        if (e() <= 9) {
            float f2 = !f() ? this.f2000g : this.f2001h;
            this.n = f2;
            this.p = f2;
            this.o = f2;
        } else {
            float f3 = this.f2001h;
            this.n = f3;
            this.p = f3;
            this.o = (this.f1998e.a(b()) / 2.0f) + this.f2002i;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(f() ? R$dimen.mtrl_badge_text_horizontal_edge_offset : R$dimen.mtrl_badge_horizontal_edge_offset);
        int i3 = this.f2003j.f2013i;
        if (i3 == 8388659 || i3 == 8388691) {
            this.f2004k = ViewCompat.getLayoutDirection(view) == 0 ? (rect2.left - this.o) + dimensionPixelSize + this.f2003j.f2015k : ((rect2.right + this.o) - dimensionPixelSize) - this.f2003j.f2015k;
        } else {
            this.f2004k = ViewCompat.getLayoutDirection(view) == 0 ? ((rect2.right + this.o) - dimensionPixelSize) - this.f2003j.f2015k : (rect2.left - this.o) + dimensionPixelSize + this.f2003j.f2015k;
        }
        Rect rect3 = this.f1999f;
        float f4 = this.f2004k;
        float f5 = this.f2005l;
        float f6 = this.o;
        float f7 = this.p;
        rect3.set((int) (f4 - f6), (int) (f5 - f7), (int) (f4 + f6), (int) (f5 + f7));
        MaterialShapeDrawable materialShapeDrawable = this.f1997d;
        materialShapeDrawable.f2333c.a = materialShapeDrawable.f2333c.a.f(this.n);
        materialShapeDrawable.invalidateSelf();
        if (rect.equals(this.f1999f)) {
            return;
        }
        this.f1997d.setBounds(this.f1999f);
    }

    @Override // android.graphics.drawable.Drawable, c.e.a.b.q.e.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f2003j.f2007c = i2;
        this.f1998e.a.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        @ColorInt
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @ColorInt
        public int f2006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2008d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2009e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public CharSequence f2010f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @PluralsRes
        public int f2011g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @StringRes
        public int f2012h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f2013i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f2014j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Dimension(unit = 1)
        public int f2015k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Dimension(unit = 1)
        public int f2016l;

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

        public SavedState(@NonNull Context context) {
            this.f2007c = 255;
            this.f2008d = -1;
            int i2 = R$style.TextAppearance_MaterialComponents_Badge;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.TextAppearance);
            typedArrayObtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
            ColorStateList colorStateListA2 = f.a2(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
            f.a2(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
            f.a2(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
            typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
            typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
            int i3 = R$styleable.TextAppearance_fontFamily;
            i3 = typedArrayObtainStyledAttributes.hasValue(i3) ? i3 : R$styleable.TextAppearance_android_fontFamily;
            typedArrayObtainStyledAttributes.getResourceId(i3, 0);
            typedArrayObtainStyledAttributes.getString(i3);
            typedArrayObtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
            f.a2(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
            typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i2, R$styleable.MaterialTextAppearance);
            int i4 = R$styleable.MaterialTextAppearance_android_letterSpacing;
            typedArrayObtainStyledAttributes2.hasValue(i4);
            typedArrayObtainStyledAttributes2.getFloat(i4, 0.0f);
            typedArrayObtainStyledAttributes2.recycle();
            this.f2006b = colorStateListA2.getDefaultColor();
            this.f2010f = context.getString(R$string.mtrl_badge_numberless_content_description);
            this.f2011g = R$plurals.mtrl_badge_content_description;
            this.f2012h = R$string.mtrl_exceed_max_badge_number_content_description;
            this.f2014j = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.f2006b);
            parcel.writeInt(this.f2007c);
            parcel.writeInt(this.f2008d);
            parcel.writeInt(this.f2009e);
            parcel.writeString(this.f2010f.toString());
            parcel.writeInt(this.f2011g);
            parcel.writeInt(this.f2013i);
            parcel.writeInt(this.f2015k);
            parcel.writeInt(this.f2016l);
            parcel.writeInt(this.f2014j ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel) {
            this.f2007c = 255;
            this.f2008d = -1;
            this.a = parcel.readInt();
            this.f2006b = parcel.readInt();
            this.f2007c = parcel.readInt();
            this.f2008d = parcel.readInt();
            this.f2009e = parcel.readInt();
            this.f2010f = parcel.readString();
            this.f2011g = parcel.readInt();
            this.f2013i = parcel.readInt();
            this.f2015k = parcel.readInt();
            this.f2016l = parcel.readInt();
            this.f2014j = parcel.readInt() != 0;
        }
    }
}
