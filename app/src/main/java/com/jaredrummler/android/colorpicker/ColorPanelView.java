package com.jaredrummler.android.colorpicker;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;
import c.f.a.a.a;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ColorPanelView extends View {
    public Drawable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f2556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f2557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f2558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f2559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Rect f2560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f2561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f2562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2564j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2565k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2566l;
    public int m;

    public ColorPanelView(Context context) {
        this(context, null);
    }

    public void a() {
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i2 = (height / 2) + iArr[1];
        int i3 = (width / 2) + iArr[0];
        if (ViewCompat.getLayoutDirection(this) == 0) {
            i3 = context.getResources().getDisplayMetrics().widthPixels - i3;
        }
        StringBuilder sb = new StringBuilder("#");
        if (Color.alpha(this.f2566l) != 255) {
            sb.append(Integer.toHexString(this.f2566l).toUpperCase(Locale.ENGLISH));
        } else {
            sb.append(String.format("%06X", Integer.valueOf(16777215 & this.f2566l)).toUpperCase(Locale.ENGLISH));
        }
        Toast toastMakeText = Toast.makeText(context, sb.toString(), 0);
        if (i2 < rect.height()) {
            toastMakeText.setGravity(8388661, i3, (iArr[1] + height) - rect.top);
        } else {
            toastMakeText.setGravity(81, 0, height);
        }
        toastMakeText.show();
    }

    public int getBorderColor() {
        return this.f2565k;
    }

    public int getColor() {
        return this.f2566l;
    }

    @ColorShape
    public int getShape() {
        return this.m;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f2556b.setColor(this.f2565k);
        this.f2557c.setColor(this.f2566l);
        int i2 = this.m;
        if (i2 == 0) {
            if (this.f2564j > 0) {
                canvas.drawRect(this.f2560f, this.f2556b);
            }
            Drawable drawable = this.a;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            canvas.drawRect(this.f2561g, this.f2557c);
            return;
        }
        if (i2 == 1) {
            int measuredWidth = getMeasuredWidth() / 2;
            if (this.f2564j > 0) {
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, this.f2556b);
            }
            if (Color.alpha(this.f2566l) < 255) {
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth - this.f2564j, this.f2558d);
            }
            if (!this.f2563i) {
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth - this.f2564j, this.f2557c);
            } else {
                canvas.drawArc(this.f2562h, 90.0f, 180.0f, true, this.f2559e);
                canvas.drawArc(this.f2562h, 270.0f, 180.0f, true, this.f2557c);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.m;
        if (i4 == 0) {
            setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        } else if (i4 != 1) {
            super.onMeasure(i2, i3);
        } else {
            super.onMeasure(i2, i2);
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f2566l = bundle.getInt("color");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("color", this.f2566l);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.m == 0 || this.f2563i) {
            Rect rect = new Rect();
            this.f2560f = rect;
            rect.left = getPaddingLeft();
            this.f2560f.right = i2 - getPaddingRight();
            this.f2560f.top = getPaddingTop();
            this.f2560f.bottom = i3 - getPaddingBottom();
            if (this.f2563i) {
                int i6 = this.f2560f.left;
                int i7 = this.f2564j;
                this.f2562h = new RectF(i6 + i7, r2.top + i7, r2.right - i7, r2.bottom - i7);
                return;
            }
            Rect rect2 = this.f2560f;
            int i8 = rect2.left;
            int i9 = this.f2564j;
            this.f2561g = new Rect(i8 + i9, rect2.top + i9, rect2.right - i9, rect2.bottom - i9);
            a aVar = new a(f.x1(getContext(), 4.0f));
            this.a = aVar;
            aVar.setBounds(Math.round(this.f2561g.left), Math.round(this.f2561g.top), Math.round(this.f2561g.right), Math.round(this.f2561g.bottom));
        }
    }

    public void setBorderColor(int i2) {
        this.f2565k = i2;
        invalidate();
    }

    public void setColor(int i2) {
        this.f2566l = i2;
        invalidate();
    }

    public void setOriginalColor(@ColorInt int i2) {
        Paint paint = this.f2559e;
        if (paint != null) {
            paint.setColor(i2);
        }
    }

    public void setShape(@ColorShape int i2) {
        this.m = i2;
        invalidate();
    }

    public ColorPanelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPanelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2562h = new RectF();
        this.f2565k = -9539986;
        this.f2566l = ViewCompat.MEASURED_STATE_MASK;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ColorPanelView);
        this.m = typedArrayObtainStyledAttributes.getInt(R$styleable.ColorPanelView_cpv_colorShape, 1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ColorPanelView_cpv_showOldColor, false);
        this.f2563i = z;
        if (z && this.m != 1) {
            throw new IllegalStateException("Color preview is only available in circle mode");
        }
        this.f2565k = typedArrayObtainStyledAttributes.getColor(R$styleable.ColorPanelView_cpv_borderColor, -9539986);
        typedArrayObtainStyledAttributes.recycle();
        if (this.f2565k == -9539986) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.textColorSecondary});
            this.f2565k = typedArrayObtainStyledAttributes2.getColor(0, this.f2565k);
            typedArrayObtainStyledAttributes2.recycle();
        }
        this.f2564j = f.x1(context, 1.0f);
        Paint paint = new Paint();
        this.f2556b = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f2557c = paint2;
        paint2.setAntiAlias(true);
        if (this.f2563i) {
            this.f2559e = new Paint();
        }
        if (this.m == 1) {
            Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(R$drawable.cpv_alpha)).getBitmap();
            Paint paint3 = new Paint();
            this.f2558d = paint3;
            paint3.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.f2558d.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        }
    }
}
