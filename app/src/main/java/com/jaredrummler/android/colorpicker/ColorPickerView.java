package com.jaredrummler.android.colorpicker;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;

/* JADX INFO: loaded from: classes.dex */
public class ColorPickerView extends View {
    public Rect A;
    public Rect B;
    public Rect C;
    public Rect D;
    public Point E;
    public c.f.a.a.a F;
    public c G;
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f2596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f2597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f2598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f2599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f2600k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f2601l;
    public Shader m;
    public Shader n;
    public Shader o;
    public b p;
    public b q;
    public int r;
    public float s;
    public float t;
    public float u;
    public boolean v;
    public String w;
    public int x;
    public int y;
    public int z;

    public class b {
        public Canvas a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap f2602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2603c;

        public b(ColorPickerView colorPickerView, a aVar) {
        }
    }

    public interface c {
    }

    public ColorPickerView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        int iX1 = f.x1(getContext(), 200.0f);
        return this.v ? iX1 + this.f2592c + this.f2591b : iX1;
    }

    private int getPreferredWidth() {
        return f.x1(getContext(), 200.0f) + this.a + this.f2592c;
    }

    public final boolean a(MotionEvent motionEvent) {
        Point point = this.E;
        if (point == null) {
            return false;
        }
        int i2 = point.x;
        int i3 = point.y;
        if (this.C.contains(i2, i3)) {
            float y = motionEvent.getY();
            Rect rect = this.C;
            float fHeight = rect.height();
            float f2 = rect.top;
            this.s = 360.0f - (((y >= f2 ? y > ((float) rect.bottom) ? fHeight : y - f2 : 0.0f) * 360.0f) / fHeight);
        } else if (this.B.contains(i2, i3)) {
            float x = motionEvent.getX();
            float y2 = motionEvent.getY();
            Rect rect2 = this.B;
            float[] fArr = new float[2];
            float fWidth = rect2.width();
            float fHeight2 = rect2.height();
            float f3 = rect2.left;
            float f4 = x < f3 ? 0.0f : x > ((float) rect2.right) ? fWidth : x - f3;
            float f5 = rect2.top;
            float f6 = y2 >= f5 ? y2 > ((float) rect2.bottom) ? fHeight2 : y2 - f5 : 0.0f;
            fArr[0] = (1.0f / fWidth) * f4;
            fArr[1] = 1.0f - ((1.0f / fHeight2) * f6);
            this.t = fArr[0];
            this.u = fArr[1];
        } else {
            Rect rect3 = this.D;
            if (rect3 == null || !rect3.contains(i2, i3)) {
                return false;
            }
            int x2 = (int) motionEvent.getX();
            Rect rect4 = this.D;
            int iWidth = rect4.width();
            int i4 = rect4.left;
            this.r = 255 - (((x2 >= i4 ? x2 > rect4.right ? iWidth : x2 - i4 : 0) * 255) / iWidth);
        }
        return true;
    }

    public void b(int i2, boolean z) {
        c cVar;
        int iAlpha = Color.alpha(i2);
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
        this.r = iAlpha;
        float f2 = fArr[0];
        this.s = f2;
        float f3 = fArr[1];
        this.t = f3;
        float f4 = fArr[2];
        this.u = f4;
        if (z && (cVar = this.G) != null) {
            ((ColorPickerDialog) cVar).R(Color.HSVToColor(iAlpha, new float[]{f2, f3, f4}));
        }
        invalidate();
    }

    public String getAlphaSliderText() {
        return this.w;
    }

    public int getBorderColor() {
        return this.y;
    }

    public int getColor() {
        return Color.HSVToColor(this.r, new float[]{this.s, this.t, this.u});
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return Math.max(super.getPaddingBottom(), this.z);
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return Math.max(super.getPaddingLeft(), this.z);
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return Math.max(super.getPaddingRight(), this.z);
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return Math.max(super.getPaddingTop(), this.z);
    }

    public int getSliderTrackerColor() {
        return this.x;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        if (this.A.width() <= 0 || this.A.height() <= 0) {
            return;
        }
        Rect rect2 = this.B;
        this.f2601l.setColor(this.y);
        Rect rect3 = this.A;
        canvas.drawRect(rect3.left, rect3.top, rect2.right + 1, rect2.bottom + 1, this.f2601l);
        if (this.m == null) {
            float f2 = rect2.left;
            this.m = new LinearGradient(f2, rect2.top, f2, rect2.bottom, -1, ViewCompat.MEASURED_STATE_MASK, Shader.TileMode.CLAMP);
        }
        b bVar = this.p;
        if (bVar == null || bVar.f2603c != this.s) {
            if (bVar == null) {
                this.p = new b(this, null);
            }
            b bVar2 = this.p;
            if (bVar2.f2602b == null) {
                bVar2.f2602b = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
            }
            b bVar3 = this.p;
            if (bVar3.a == null) {
                bVar3.a = new Canvas(this.p.f2602b);
            }
            int iHSVToColor = Color.HSVToColor(new float[]{this.s, 1.0f, 1.0f});
            float f3 = rect2.left;
            float f4 = rect2.top;
            this.n = new LinearGradient(f3, f4, rect2.right, f4, -1, iHSVToColor, Shader.TileMode.CLAMP);
            this.f2596g.setShader(new ComposeShader(this.m, this.n, PorterDuff.Mode.MULTIPLY));
            this.p.a.drawRect(0.0f, 0.0f, r1.f2602b.getWidth(), this.p.f2602b.getHeight(), this.f2596g);
            this.p.f2603c = this.s;
        }
        canvas.drawBitmap(this.p.f2602b, (Rect) null, rect2, (Paint) null);
        float f5 = this.t;
        float f6 = this.u;
        Rect rect4 = this.B;
        float fHeight = rect4.height();
        float fWidth = rect4.width();
        Point point = new Point();
        point.x = (int) ((f5 * fWidth) + rect4.left);
        point.y = (int) (((1.0f - f6) * fHeight) + rect4.top);
        this.f2597h.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(point.x, point.y, this.f2593d - f.x1(getContext(), 1.0f), this.f2597h);
        this.f2597h.setColor(-2236963);
        canvas.drawCircle(point.x, point.y, this.f2593d, this.f2597h);
        Rect rect5 = this.C;
        this.f2601l.setColor(this.y);
        canvas.drawRect(rect5.left - 1, rect5.top - 1, rect5.right + 1, rect5.bottom + 1, this.f2601l);
        if (this.q == null) {
            b bVar4 = new b(this, null);
            this.q = bVar4;
            bVar4.f2602b = Bitmap.createBitmap(rect5.width(), rect5.height(), Bitmap.Config.ARGB_8888);
            this.q.a = new Canvas(this.q.f2602b);
            int iHeight = (int) (rect5.height() + 0.5f);
            int[] iArr = new int[iHeight];
            float f7 = 360.0f;
            for (int i2 = 0; i2 < iHeight; i2++) {
                iArr[i2] = Color.HSVToColor(new float[]{f7, 1.0f, 1.0f});
                f7 -= 360.0f / iHeight;
            }
            Paint paint = new Paint();
            paint.setStrokeWidth(0.0f);
            for (int i3 = 0; i3 < iHeight; i3++) {
                paint.setColor(iArr[i3]);
                float f8 = i3;
                this.q.a.drawLine(0.0f, f8, r6.f2602b.getWidth(), f8, paint);
            }
        }
        canvas.drawBitmap(this.q.f2602b, (Rect) null, rect5, (Paint) null);
        float f9 = this.s;
        Rect rect6 = this.C;
        float fHeight2 = rect6.height();
        Point point2 = new Point();
        point2.y = (int) ((fHeight2 - ((f9 * fHeight2) / 360.0f)) + rect6.top);
        point2.x = rect6.left;
        RectF rectF = new RectF();
        int i4 = rect5.left;
        int i5 = this.f2594e;
        rectF.left = i4 - i5;
        rectF.right = rect5.right + i5;
        int i6 = point2.y;
        int i7 = this.f2595f / 2;
        rectF.top = i6 - i7;
        rectF.bottom = i7 + i6;
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, this.f2600k);
        if (!this.v || (rect = this.D) == null || this.F == null) {
            return;
        }
        this.f2601l.setColor(this.y);
        canvas.drawRect(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1, this.f2601l);
        this.F.draw(canvas);
        float[] fArr = {this.s, this.t, this.u};
        int iHSVToColor2 = Color.HSVToColor(fArr);
        int iHSVToColor3 = Color.HSVToColor(0, fArr);
        float f10 = rect.left;
        float f11 = rect.top;
        LinearGradient linearGradient = new LinearGradient(f10, f11, rect.right, f11, iHSVToColor2, iHSVToColor3, Shader.TileMode.CLAMP);
        this.o = linearGradient;
        this.f2598i.setShader(linearGradient);
        canvas.drawRect(rect, this.f2598i);
        String str = this.w;
        if (str != null && !str.equals("")) {
            canvas.drawText(this.w, rect.centerX(), f.x1(getContext(), 4.0f) + rect.centerY(), this.f2599j);
        }
        int i8 = this.r;
        Rect rect7 = this.D;
        float fWidth2 = rect7.width();
        Point point3 = new Point();
        point3.x = (int) ((fWidth2 - ((i8 * fWidth2) / 255.0f)) + rect7.left);
        point3.y = rect7.top;
        RectF rectF2 = new RectF();
        int i9 = point3.x;
        int i10 = this.f2595f / 2;
        rectF2.left = i9 - i10;
        rectF2.right = i10 + i9;
        int i11 = rect.top;
        int i12 = this.f2594e;
        rectF2.top = i11 - i12;
        rectF2.bottom = rect.bottom + i12;
        canvas.drawRoundRect(rectF2, 2.0f, 2.0f, this.f2600k);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054 A[PHI: r1
  0x0054: PHI (r1v9 int) = (r1v3 int), (r1v12 int) binds: [B:38:0x0087, B:20:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r2 = r5.getPaddingLeft()
            int r6 = r6 - r2
            int r2 = r5.getPaddingRight()
            int r6 = r6 - r2
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r2 = r5.getPaddingBottom()
            int r7 = r7 - r2
            int r2 = r5.getPaddingTop()
            int r7 = r7 - r2
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L5c
            if (r1 != r2) goto L2b
            goto L5c
        L2b:
            int r0 = r5.f2592c
            int r1 = r7 + r0
            int r2 = r5.a
            int r1 = r1 + r2
            int r3 = r6 - r0
            int r3 = r3 - r2
            boolean r2 = r5.v
            if (r2 == 0) goto L40
            int r2 = r5.f2591b
            int r4 = r0 + r2
            int r1 = r1 - r4
            int r0 = r0 + r2
            int r3 = r3 + r0
        L40:
            r0 = 1
            r2 = 0
            if (r1 > r6) goto L46
            r4 = 1
            goto L47
        L46:
            r4 = 0
        L47:
            if (r3 > r7) goto L4a
            goto L4b
        L4a:
            r0 = 0
        L4b:
            if (r4 == 0) goto L50
            if (r0 == 0) goto L50
            goto L5a
        L50:
            if (r0 != 0) goto L56
            if (r4 == 0) goto L56
        L54:
            r6 = r1
            goto L89
        L56:
            if (r4 != 0) goto L89
            if (r0 == 0) goto L89
        L5a:
            r7 = r3
            goto L89
        L5c:
            if (r0 != r2) goto L74
            if (r1 == r2) goto L74
            int r0 = r5.f2592c
            int r1 = r6 - r0
            int r2 = r5.a
            int r1 = r1 - r2
            boolean r2 = r5.v
            if (r2 == 0) goto L6f
            int r2 = r5.f2591b
            int r0 = r0 + r2
            int r1 = r1 + r0
        L6f:
            if (r1 <= r7) goto L72
            goto L89
        L72:
            r7 = r1
            goto L89
        L74:
            if (r1 != r2) goto L89
            if (r0 == r2) goto L89
            int r0 = r5.f2592c
            int r1 = r7 + r0
            int r2 = r5.a
            int r1 = r1 + r2
            boolean r2 = r5.v
            if (r2 == 0) goto L87
            int r2 = r5.f2591b
            int r0 = r0 + r2
            int r1 = r1 - r0
        L87:
            if (r1 <= r6) goto L54
        L89:
            int r0 = r5.getPaddingLeft()
            int r0 = r0 + r6
            int r6 = r5.getPaddingRight()
            int r6 = r6 + r0
            int r0 = r5.getPaddingTop()
            int r0 = r0 + r7
            int r7 = r5.getPaddingBottom()
            int r7 = r7 + r0
            r5.setMeasuredDimension(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jaredrummler.android.colorpicker.ColorPickerView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.r = bundle.getInt(Key.ALPHA);
            this.s = bundle.getFloat("hue");
            this.t = bundle.getFloat("sat");
            this.u = bundle.getFloat("val");
            this.v = bundle.getBoolean("show_alpha");
            this.w = bundle.getString("alpha_text");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt(Key.ALPHA, this.r);
        bundle.putFloat("hue", this.s);
        bundle.putFloat("sat", this.t);
        bundle.putFloat("val", this.u);
        bundle.putBoolean("show_alpha", this.v);
        bundle.putString("alpha_text", this.w);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Rect rect = new Rect();
        this.A = rect;
        rect.left = getPaddingLeft();
        this.A.right = i2 - getPaddingRight();
        this.A.top = getPaddingTop();
        this.A.bottom = i3 - getPaddingBottom();
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        Rect rect2 = this.A;
        int i6 = rect2.left + 1;
        int i7 = rect2.top + 1;
        int i8 = rect2.bottom - 1;
        int i9 = rect2.right - 1;
        int i10 = this.f2592c;
        int i11 = (i9 - i10) - this.a;
        if (this.v) {
            i8 -= this.f2591b + i10;
        }
        this.B = new Rect(i6, i7, i11, i8);
        Rect rect3 = this.A;
        int i12 = rect3.right;
        this.C = new Rect((i12 - this.a) + 1, rect3.top + 1, i12 - 1, (rect3.bottom - 1) - (this.v ? this.f2592c + this.f2591b : 0));
        if (this.v) {
            Rect rect4 = this.A;
            int i13 = rect4.left + 1;
            int i14 = rect4.bottom;
            this.D = new Rect(i13, (i14 - this.f2591b) + 1, rect4.right - 1, i14 - 1);
            c.f.a.a.a aVar = new c.f.a.a.a(f.x1(getContext(), 4.0f));
            this.F = aVar;
            aVar.setBounds(Math.round(this.D.left), Math.round(this.D.top), Math.round(this.D.right), Math.round(this.D.bottom));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zA;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.E = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            zA = a(motionEvent);
        } else if (action != 1) {
            zA = action != 2 ? false : a(motionEvent);
        } else {
            this.E = null;
            zA = a(motionEvent);
        }
        if (!zA) {
            return super.onTouchEvent(motionEvent);
        }
        c cVar = this.G;
        if (cVar != null) {
            ((ColorPickerDialog) cVar).R(Color.HSVToColor(this.r, new float[]{this.s, this.t, this.u}));
        }
        invalidate();
        return true;
    }

    public void setAlphaSliderText(int i2) {
        setAlphaSliderText(getContext().getString(i2));
    }

    public void setAlphaSliderVisible(boolean z) {
        if (this.v != z) {
            this.v = z;
            this.m = null;
            this.n = null;
            this.o = null;
            this.q = null;
            this.p = null;
            requestLayout();
        }
    }

    public void setBorderColor(int i2) {
        this.y = i2;
        invalidate();
    }

    public void setColor(int i2) {
        b(i2, false);
    }

    public void setOnColorChangedListener(c cVar) {
        this.G = cVar;
    }

    public void setSliderTrackerColor(int i2) {
        this.x = i2;
        this.f2600k.setColor(i2);
        invalidate();
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.r = 255;
        this.s = 360.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = false;
        this.w = null;
        this.x = -4342339;
        this.y = -9539986;
        this.E = null;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ColorPickerView);
        this.v = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ColorPickerView_cpv_alphaChannelVisible, false);
        this.w = typedArrayObtainStyledAttributes.getString(R$styleable.ColorPickerView_cpv_alphaChannelText);
        this.x = typedArrayObtainStyledAttributes.getColor(R$styleable.ColorPickerView_cpv_sliderColor, -4342339);
        this.y = typedArrayObtainStyledAttributes.getColor(R$styleable.ColorPickerView_cpv_borderColor, -9539986);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.textColorSecondary});
        if (this.y == -9539986) {
            this.y = typedArrayObtainStyledAttributes2.getColor(0, -9539986);
        }
        if (this.x == -4342339) {
            this.x = typedArrayObtainStyledAttributes2.getColor(0, -4342339);
        }
        typedArrayObtainStyledAttributes2.recycle();
        this.a = f.x1(getContext(), 30.0f);
        this.f2591b = f.x1(getContext(), 20.0f);
        this.f2592c = f.x1(getContext(), 10.0f);
        this.f2593d = f.x1(getContext(), 5.0f);
        this.f2595f = f.x1(getContext(), 4.0f);
        this.f2594e = f.x1(getContext(), 2.0f);
        this.z = getResources().getDimensionPixelSize(R$dimen.cpv_required_padding);
        this.f2596g = new Paint();
        this.f2597h = new Paint();
        this.f2600k = new Paint();
        this.f2598i = new Paint();
        this.f2599j = new Paint();
        this.f2601l = new Paint();
        this.f2597h.setStyle(Paint.Style.STROKE);
        this.f2597h.setStrokeWidth(f.x1(getContext(), 2.0f));
        this.f2597h.setAntiAlias(true);
        this.f2600k.setColor(this.x);
        this.f2600k.setStyle(Paint.Style.STROKE);
        this.f2600k.setStrokeWidth(f.x1(getContext(), 2.0f));
        this.f2600k.setAntiAlias(true);
        this.f2599j.setColor(-14935012);
        this.f2599j.setTextSize(f.x1(getContext(), 14.0f));
        this.f2599j.setAntiAlias(true);
        this.f2599j.setTextAlign(Paint.Align.CENTER);
        this.f2599j.setFakeBoldText(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void setAlphaSliderText(String str) {
        this.w = str;
        invalidate();
    }
}
