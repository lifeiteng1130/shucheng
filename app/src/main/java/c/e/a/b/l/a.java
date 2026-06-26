package c.e.a.b.l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: compiled from: CalendarItemStyle.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    @NonNull
    public final Rect a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f1007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f1008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ColorStateList f1009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c.e.a.b.w.l f1011f;

    public a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, c.e.a.b.w.l lVar, @NonNull Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.a = rect;
        this.f1007b = colorStateList2;
        this.f1008c = colorStateList;
        this.f1009d = colorStateList3;
        this.f1010e = i2;
        this.f1011f = lVar;
    }

    @NonNull
    public static a a(@NonNull Context context, @StyleRes int i2) {
        Preconditions.checkArgument(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA2 = c.b.a.m.f.a2(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA22 = c.b.a.m.f.a2(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA23 = c.b.a.m.f.a2(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        c.e.a.b.w.l lVarA = c.e.a.b.w.l.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new a(colorStateListA2, colorStateListA22, colorStateListA23, dimensionPixelSize, lVarA, rect);
    }

    public void b(@NonNull TextView textView) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.f1011f);
        materialShapeDrawable2.setShapeAppearanceModel(this.f1011f);
        materialShapeDrawable.q(this.f1008c);
        materialShapeDrawable.x(this.f1010e, this.f1009d);
        textView.setTextColor(this.f1007b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f1007b.withAlpha(30), materialShapeDrawable, materialShapeDrawable2);
        Rect rect = this.a;
        ViewCompat.setBackground(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
