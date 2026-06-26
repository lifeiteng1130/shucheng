package com.king.zxing;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public class ViewfinderView extends View {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public a F;
    public Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextPaint f2621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f2628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f2629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f2631l;
    public int m;
    public int n;
    public int o;
    public int p;
    public b q;
    public int r;
    public int s;
    public Rect t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public enum a {
        CENTER(0),
        LEFT(1),
        TOP(2),
        RIGHT(3),
        BOTTOM(4);

        private int mValue;

        a(int i2) {
            this.mValue = i2;
        }

        public static a access$400(int i2) {
            a[] aVarArrValues = values();
            for (int i3 = 0; i3 < 5; i3++) {
                a aVar = aVarArrValues[i3];
                if (aVar.mValue == i2) {
                    return aVar;
                }
            }
            return CENTER;
        }
    }

    public enum b {
        NONE(0),
        LINE(1),
        GRID(2);

        private int mValue;

        b(int i2) {
            this.mValue = i2;
        }

        public static b access$200(int i2) {
            b[] bVarArrValues = values();
            for (int i3 = 0; i3 < 3; i3++) {
                b bVar = bVarArrValues[i3];
                if (bVar.mValue == i2) {
                    return bVar;
                }
            }
            return LINE;
        }
    }

    public enum c {
        TOP(0),
        BOTTOM(1);

        private int mValue;

        c(int i2) {
            this.mValue = i2;
        }

        public static c access$000(int i2) {
            c[] cVarArrValues = values();
            for (int i3 = 0; i3 < 2; i3++) {
                c cVar = cVarArrValues[i3];
                if (cVar.mValue == i2) {
                    return cVar;
                }
            }
            return TOP;
        }
    }

    public ViewfinderView(Context context) {
        this(context, null);
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public int a(int i2) {
        String hexString = Integer.toHexString(i2);
        StringBuilder sbR = c.a.a.a.a.r("01");
        sbR.append(hexString.substring(2));
        return Integer.valueOf(sbR.toString(), 16).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instruction units count: 850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.zxing.ViewfinderView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int iMin = (int) (Math.min(i2, i3) * this.A);
        int i6 = this.o;
        if (i6 <= 0 || i6 > i2) {
            this.o = iMin;
        }
        int i7 = this.p;
        if (i7 <= 0 || i7 > i3) {
            this.p = iMin;
        }
        if (this.f2627h <= 0) {
            this.f2627h = (i2 - getPaddingLeft()) - getPaddingRight();
        }
        float f2 = (((i2 - this.o) / 2) + this.B) - this.D;
        float f3 = (((i3 - this.p) / 2) + this.C) - this.E;
        int iOrdinal = this.F.ordinal();
        if (iOrdinal == 1) {
            f2 = this.B;
        } else if (iOrdinal == 2) {
            f3 = this.C;
        } else if (iOrdinal == 3) {
            f2 = (i2 - this.o) + this.D;
        } else if (iOrdinal == 4) {
            f3 = (i3 - this.p) + this.E;
        }
        int i8 = (int) f2;
        int i9 = (int) f3;
        this.t = new Rect(i8, i9, this.o + i8, this.p + i9);
    }

    public void setLabelText(String str) {
        this.f2629j = str;
    }

    public void setLabelTextColor(@ColorInt int i2) {
        this.f2630k = i2;
    }

    public void setLabelTextColorResource(@ColorRes int i2) {
        this.f2630k = ContextCompat.getColor(getContext(), i2);
    }

    public void setLabelTextSize(float f2) {
        this.f2631l = f2;
    }

    public void setLaserStyle(b bVar) {
        this.q = bVar;
    }

    public ViewfinderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewfinderView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = 0;
        this.n = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewfinderView);
        this.f2622c = typedArrayObtainStyledAttributes.getColor(R$styleable.ViewfinderView_maskColor, ContextCompat.getColor(context, R$color.viewfinder_mask));
        this.f2623d = typedArrayObtainStyledAttributes.getColor(R$styleable.ViewfinderView_frameColor, ContextCompat.getColor(context, R$color.viewfinder_frame));
        this.f2625f = typedArrayObtainStyledAttributes.getColor(R$styleable.ViewfinderView_cornerColor, ContextCompat.getColor(context, R$color.viewfinder_corner));
        this.f2624e = typedArrayObtainStyledAttributes.getColor(R$styleable.ViewfinderView_laserColor, ContextCompat.getColor(context, R$color.viewfinder_laser));
        this.f2629j = typedArrayObtainStyledAttributes.getString(R$styleable.ViewfinderView_labelText);
        this.f2630k = typedArrayObtainStyledAttributes.getColor(R$styleable.ViewfinderView_labelTextColor, ContextCompat.getColor(context, R$color.viewfinder_text_color));
        this.f2631l = typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_labelTextSize, TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        this.f2626g = typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_labelTextPadding, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.f2627h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ViewfinderView_labelTextWidth, 0);
        this.f2628i = c.access$000(typedArrayObtainStyledAttributes.getInt(R$styleable.ViewfinderView_labelTextLocation, 0));
        this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ViewfinderView_frameWidth, 0);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ViewfinderView_frameHeight, 0);
        this.q = b.access$200(typedArrayObtainStyledAttributes.getInt(R$styleable.ViewfinderView_laserStyle, b.LINE.mValue));
        this.r = typedArrayObtainStyledAttributes.getInt(R$styleable.ViewfinderView_gridColumn, 20);
        this.s = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_gridHeight, TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));
        this.u = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_cornerRectWidth, TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()));
        this.v = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_cornerRectHeight, TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics()));
        this.w = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_scannerLineMoveDistance, TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.x = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_scannerLineHeight, TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics()));
        this.y = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_frameLineWidth, TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.z = typedArrayObtainStyledAttributes.getInteger(R$styleable.ViewfinderView_scannerAnimationDelay, 20);
        this.A = typedArrayObtainStyledAttributes.getFloat(R$styleable.ViewfinderView_frameRatio, 0.625f);
        this.B = typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_framePaddingLeft, 0.0f);
        this.C = typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_framePaddingTop, 0.0f);
        this.D = typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_framePaddingRight, 0.0f);
        this.E = typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_framePaddingBottom, 0.0f);
        this.F = a.access$400(typedArrayObtainStyledAttributes.getInt(R$styleable.ViewfinderView_frameGravity, a.CENTER.mValue));
        typedArrayObtainStyledAttributes.recycle();
        TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
        this.a = new Paint(1);
        this.f2621b = new TextPaint(1);
    }
}
