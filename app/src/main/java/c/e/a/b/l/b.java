package c.e.a.b.l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.datepicker.MaterialCalendar;

/* JADX INFO: compiled from: CalendarStyle.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    @NonNull
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final a f1012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final a f1013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final a f1014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final a f1015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final a f1016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final a f1017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final Paint f1018h;

    public b(@NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(c.b.a.m.f.N4(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R$styleable.MaterialCalendar);
        this.a = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayStyle, 0));
        this.f1017g = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f1012b = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f1013c = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListA2 = c.b.a.m.f.a2(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendar_rangeFillColor);
        this.f1014d = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearStyle, 0));
        this.f1015e = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f1016f = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f1018h = paint;
        paint.setColor(colorStateListA2.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
