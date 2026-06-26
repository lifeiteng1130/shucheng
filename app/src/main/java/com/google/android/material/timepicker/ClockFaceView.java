package com.google.android.material.timepicker;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import c.b.a.m.f;
import c.e.a.b.c0.b;
import c.e.a.b.c0.c;
import c.e.a.b.c0.e;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ClockFaceView extends e implements ClockHandView.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ClockHandView f2464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f2465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f2466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SparseArray<TextView> f2467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AccessibilityDelegateCompat f2468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f2469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f2470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f2471k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String[] f2472l;
    public float m;
    public final ColorStateList n;

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i2 = R$attr.materialClockStyle;
        super(context, attributeSet, i2);
        this.f2465e = new Rect();
        this.f2466f = new RectF();
        this.f2467g = new SparseArray<>();
        this.f2470j = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, i2, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA2 = f.a2(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockNumberTextColor);
        this.n = colorStateListA2;
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.f2464d = clockHandView;
        this.f2471k = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        int colorForState = colorStateListA2.getColorForState(new int[]{R.attr.state_selected}, colorStateListA2.getDefaultColor());
        this.f2469i = new int[]{colorForState, colorForState, colorStateListA2.getDefaultColor()};
        clockHandView.addOnRotateListener(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA22 = f.a2(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListA22 != null ? colorStateListA22.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f2468h = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        d(strArr, 0);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void a(float f2, boolean z) {
        if (Math.abs(this.m - f2) > 0.001f) {
            this.m = f2;
            c();
        }
    }

    public final void c() {
        RectF rectF = this.f2464d.f2483l;
        for (int i2 = 0; i2 < this.f2467g.size(); i2++) {
            TextView textView = this.f2467g.get(i2);
            if (textView != null) {
                textView.getDrawingRect(this.f2465e);
                this.f2465e.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.f2465e);
                this.f2466f.set(this.f2465e);
                textView.getPaint().setShader(!RectF.intersects(rectF, this.f2466f) ? null : new RadialGradient(rectF.centerX() - this.f2466f.left, rectF.centerY() - this.f2466f.top, 0.5f * rectF.width(), this.f2469i, this.f2470j, Shader.TileMode.CLAMP));
                textView.invalidate();
            }
        }
    }

    public void d(String[] strArr, @StringRes int i2) {
        this.f2472l = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.f2467g.size();
        for (int i3 = 0; i3 < Math.max(this.f2472l.length, size); i3++) {
            TextView textView = this.f2467g.get(i3);
            if (i3 >= this.f2472l.length) {
                removeView(textView);
                this.f2467g.remove(i3);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    this.f2467g.put(i3, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.f2472l[i3]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i3));
                ViewCompat.setAccessibilityDelegate(textView, this.f2468h);
                textView.setTextColor(this.n);
                if (i2 != 0) {
                    textView.setContentDescription(getResources().getString(i2, this.f2472l[i3]));
                }
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.f2472l.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        c();
    }
}
