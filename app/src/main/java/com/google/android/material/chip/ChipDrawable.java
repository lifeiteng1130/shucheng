package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import c.b.a.m.f;
import c.e.a.b.a.g;
import c.e.a.b.q.e;
import c.e.a.b.t.b;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, e.b {
    public static final int[] y = {R.attr.state_enabled};
    public static final ShapeDrawable z = new ShapeDrawable(new OvalShape());

    @Nullable
    public ColorStateList A;

    @Nullable
    public ColorFilter A0;

    @Nullable
    public ColorStateList B;

    @Nullable
    public PorterDuffColorFilter B0;
    public float C;

    @Nullable
    public ColorStateList C0;
    public float D;

    @Nullable
    public PorterDuff.Mode D0;

    @Nullable
    public ColorStateList E;
    public int[] E0;
    public float F;
    public boolean F0;

    @Nullable
    public ColorStateList G;

    @Nullable
    public ColorStateList G0;

    @Nullable
    public CharSequence H;

    @NonNull
    public WeakReference<a> H0;
    public boolean I;
    public TextUtils.TruncateAt I0;

    @Nullable
    public Drawable J;
    public boolean J0;

    @Nullable
    public ColorStateList K;
    public int K0;
    public boolean L0;
    public float O;
    public boolean P;
    public boolean Q;

    @Nullable
    public Drawable R;

    @Nullable
    public Drawable S;

    @Nullable
    public ColorStateList T;
    public float U;

    @Nullable
    public CharSequence V;
    public boolean W;
    public boolean X;

    @Nullable
    public Drawable Y;

    @Nullable
    public ColorStateList Z;

    @Nullable
    public g a0;

    @Nullable
    public g b0;
    public float c0;
    public float d0;
    public float e0;
    public float f0;
    public float g0;
    public float h0;
    public float i0;
    public float j0;

    @NonNull
    public final Context k0;
    public final Paint l0;
    public final Paint.FontMetrics m0;
    public final RectF n0;
    public final PointF o0;
    public final Path p0;

    @NonNull
    public final e q0;

    @ColorInt
    public int r0;

    @ColorInt
    public int s0;

    @ColorInt
    public int t0;

    @ColorInt
    public int u0;

    @ColorInt
    public int v0;

    @ColorInt
    public int w0;
    public boolean x0;

    @ColorInt
    public int y0;
    public int z0;

    public interface a {
        void a();
    }

    public ChipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        this.D = -1.0f;
        this.l0 = new Paint(1);
        this.m0 = new Paint.FontMetrics();
        this.n0 = new RectF();
        this.o0 = new PointF();
        this.p0 = new Path();
        this.z0 = 255;
        this.D0 = PorterDuff.Mode.SRC_IN;
        this.H0 = new WeakReference<>(null);
        this.f2333c.f2343b = new c.e.a.b.n.a(context);
        C();
        this.k0 = context;
        e eVar = new e(this);
        this.q0 = eVar;
        this.H = "";
        eVar.a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = y;
        setState(iArr);
        j0(iArr);
        this.J0 = true;
        int[] iArr2 = c.e.a.b.u.a.a;
        z.setTint(-1);
    }

    public static boolean M(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean N(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void D(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.R) {
            if (drawable.isStateful()) {
                drawable.setState(this.E0);
            }
            DrawableCompat.setTintList(drawable, this.T);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.J;
        if (drawable == drawable2 && this.P) {
            DrawableCompat.setTintList(drawable2, this.K);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060 A[PHI: r1
  0x0060: PHI (r1v3 float) = (r1v2 float), (r1v2 float), (r1v10 float) binds: [B:15:0x003f, B:16:0x0041, B:18:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(@androidx.annotation.NonNull android.graphics.Rect r4, @androidx.annotation.NonNull android.graphics.RectF r5) {
        /*
            r3 = this;
            r5.setEmpty()
            boolean r0 = r3.u0()
            if (r0 != 0) goto Lf
            boolean r0 = r3.t0()
            if (r0 == 0) goto L6f
        Lf:
            float r0 = r3.c0
            float r1 = r3.d0
            float r0 = r0 + r1
            float r1 = r3.L()
            int r2 = androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(r3)
            if (r2 != 0) goto L28
            int r2 = r4.left
            float r2 = (float) r2
            float r2 = r2 + r0
            r5.left = r2
            float r2 = r2 + r1
            r5.right = r2
            goto L31
        L28:
            int r2 = r4.right
            float r2 = (float) r2
            float r2 = r2 - r0
            r5.right = r2
            float r2 = r2 - r1
            r5.left = r2
        L31:
            boolean r0 = r3.x0
            if (r0 == 0) goto L38
            android.graphics.drawable.Drawable r0 = r3.Y
            goto L3a
        L38:
            android.graphics.drawable.Drawable r0 = r3.J
        L3a:
            float r1 = r3.O
            r2 = 0
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 > 0) goto L60
            if (r0 == 0) goto L60
            android.content.Context r1 = r3.k0
            r2 = 24
            float r1 = c.b.a.m.f.w1(r1, r2)
            double r1 = (double) r1
            double r1 = java.lang.Math.ceil(r1)
            float r1 = (float) r1
            int r2 = r0.getIntrinsicHeight()
            float r2 = (float) r2
            int r2 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r2 > 0) goto L60
            int r0 = r0.getIntrinsicHeight()
            float r0 = (float) r0
            goto L61
        L60:
            r0 = r1
        L61:
            float r4 = r4.exactCenterY()
            r1 = 1073741824(0x40000000, float:2.0)
            float r1 = r0 / r1
            float r4 = r4 - r1
            r5.top = r4
            float r4 = r4 + r0
            r5.bottom = r4
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.E(android.graphics.Rect, android.graphics.RectF):void");
    }

    public float F() {
        if (!u0() && !t0()) {
            return 0.0f;
        }
        return L() + this.d0 + this.e0;
    }

    public final void G(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (v0()) {
            float f2 = this.j0 + this.i0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.right - f2;
                rectF.right = f3;
                rectF.left = f3 - this.U;
            } else {
                float f4 = rect.left + f2;
                rectF.left = f4;
                rectF.right = f4 + this.U;
            }
            float fExactCenterY = rect.exactCenterY();
            float f5 = this.U;
            float f6 = fExactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    public final void H(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (v0()) {
            float f2 = this.j0 + this.i0 + this.U + this.h0 + this.g0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i2 = rect.left;
                rectF.left = i2;
                rectF.right = i2 + f2;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public float I() {
        if (v0()) {
            return this.h0 + this.U + this.i0;
        }
        return 0.0f;
    }

    public float J() {
        return this.L0 ? l() : this.D;
    }

    @Nullable
    public Drawable K() {
        Drawable drawable = this.R;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public final float L() {
        Drawable drawable = this.x0 ? this.Y : this.J;
        float f2 = this.O;
        return (f2 > 0.0f || drawable == null) ? f2 : drawable.getIntrinsicWidth();
    }

    public void O() {
        a aVar = this.H0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    public final boolean P(@NonNull int[] iArr, @NonNull int[] iArr2) {
        boolean z2;
        boolean z3;
        ColorStateList colorStateList;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.A;
        int iE = e(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.r0) : 0);
        boolean state = true;
        if (this.r0 != iE) {
            this.r0 = iE;
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.B;
        int iE2 = e(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.s0) : 0);
        if (this.s0 != iE2) {
            this.s0 = iE2;
            zOnStateChange = true;
        }
        int iCompositeColors = ColorUtils.compositeColors(iE2, iE);
        if ((this.t0 != iCompositeColors) | (this.f2333c.f2345d == null)) {
            this.t0 = iCompositeColors;
            q(ColorStateList.valueOf(iCompositeColors));
            zOnStateChange = true;
        }
        ColorStateList colorStateList4 = this.E;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.u0) : 0;
        if (this.u0 != colorForState) {
            this.u0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.G0 == null || !c.e.a.b.u.a.d(iArr)) ? 0 : this.G0.getColorForState(iArr, this.v0);
        if (this.v0 != colorForState2) {
            this.v0 = colorForState2;
            if (this.F0) {
                zOnStateChange = true;
            }
        }
        b bVar = this.q0.f1124f;
        int colorForState3 = (bVar == null || (colorStateList = bVar.a) == null) ? 0 : colorStateList.getColorForState(iArr, this.w0);
        if (this.w0 != colorForState3) {
            this.w0 = colorForState3;
            zOnStateChange = true;
        }
        int[] state2 = getState();
        if (state2 == null) {
            z2 = false;
        } else {
            for (int i2 : state2) {
                if (i2 == 16842912) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        boolean z4 = z2 && this.W;
        if (this.x0 == z4 || this.Y == null) {
            z3 = false;
        } else {
            float F = F();
            this.x0 = z4;
            if (F != F()) {
                zOnStateChange = true;
                z3 = true;
            } else {
                zOnStateChange = true;
                z3 = false;
            }
        }
        ColorStateList colorStateList5 = this.C0;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.y0) : 0;
        if (this.y0 != colorForState4) {
            this.y0 = colorForState4;
            this.B0 = f.Z5(this, this.C0, this.D0);
        } else {
            state = zOnStateChange;
        }
        if (N(this.J)) {
            state |= this.J.setState(iArr);
        }
        if (N(this.Y)) {
            state |= this.Y.setState(iArr);
        }
        if (N(this.R)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.R.setState(iArr3);
        }
        int[] iArr4 = c.e.a.b.u.a.a;
        if (N(this.S)) {
            state |= this.S.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z3) {
            O();
        }
        return state;
    }

    public void Q(boolean z2) {
        if (this.W != z2) {
            this.W = z2;
            float F = F();
            if (!z2 && this.x0) {
                this.x0 = false;
            }
            float F2 = F();
            invalidateSelf();
            if (F != F2) {
                O();
            }
        }
    }

    public void R(@Nullable Drawable drawable) {
        if (this.Y != drawable) {
            float F = F();
            this.Y = drawable;
            float F2 = F();
            w0(this.Y);
            D(this.Y);
            invalidateSelf();
            if (F != F2) {
                O();
            }
        }
    }

    public void S(@Nullable ColorStateList colorStateList) {
        if (this.Z != colorStateList) {
            this.Z = colorStateList;
            if (this.X && this.Y != null && this.W) {
                DrawableCompat.setTintList(this.Y, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void T(boolean z2) {
        if (this.X != z2) {
            boolean zT0 = t0();
            this.X = z2;
            boolean zT02 = t0();
            if (zT0 != zT02) {
                if (zT02) {
                    D(this.Y);
                } else {
                    w0(this.Y);
                }
                invalidateSelf();
                O();
            }
        }
    }

    public void U(@Nullable ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            onStateChange(getState());
        }
    }

    @Deprecated
    public void V(float f2) {
        if (this.D != f2) {
            this.D = f2;
            this.f2333c.a = this.f2333c.a.f(f2);
            invalidateSelf();
        }
    }

    public void W(float f2) {
        if (this.j0 != f2) {
            this.j0 = f2;
            invalidateSelf();
            O();
        }
    }

    public void X(@Nullable Drawable drawable) {
        Drawable drawable2 = this.J;
        Drawable drawableUnwrap = drawable2 != null ? DrawableCompat.unwrap(drawable2) : null;
        if (drawableUnwrap != drawable) {
            float F = F();
            this.J = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float F2 = F();
            w0(drawableUnwrap);
            if (u0()) {
                D(this.J);
            }
            invalidateSelf();
            if (F != F2) {
                O();
            }
        }
    }

    public void Y(float f2) {
        if (this.O != f2) {
            float F = F();
            this.O = f2;
            float F2 = F();
            invalidateSelf();
            if (F != F2) {
                O();
            }
        }
    }

    public void Z(@Nullable ColorStateList colorStateList) {
        this.P = true;
        if (this.K != colorStateList) {
            this.K = colorStateList;
            if (u0()) {
                DrawableCompat.setTintList(this.J, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // c.e.a.b.q.e.b
    public void a() {
        O();
        invalidateSelf();
    }

    public void a0(boolean z2) {
        if (this.I != z2) {
            boolean zU0 = u0();
            this.I = z2;
            boolean zU02 = u0();
            if (zU0 != zU02) {
                if (zU02) {
                    D(this.J);
                } else {
                    w0(this.J);
                }
                invalidateSelf();
                O();
            }
        }
    }

    public void b0(float f2) {
        if (this.C != f2) {
            this.C = f2;
            invalidateSelf();
            O();
        }
    }

    public void c0(float f2) {
        if (this.c0 != f2) {
            this.c0 = f2;
            invalidateSelf();
            O();
        }
    }

    public void d0(@Nullable ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            if (this.L0) {
                y(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int iSaveLayerAlpha;
        int i2;
        int i3;
        int i4;
        int i5;
        int iSave;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i6 = this.z0;
        if (i6 < 255) {
            float f2 = bounds.left;
            float f3 = bounds.top;
            float f4 = bounds.right;
            float f5 = bounds.bottom;
            iSaveLayerAlpha = Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f2, f3, f4, f5, i6) : canvas.saveLayerAlpha(f2, f3, f4, f5, i6, 31);
        } else {
            iSaveLayerAlpha = 0;
        }
        if (!this.L0) {
            this.l0.setColor(this.r0);
            this.l0.setStyle(Paint.Style.FILL);
            this.n0.set(bounds);
            canvas.drawRoundRect(this.n0, J(), J(), this.l0);
        }
        if (!this.L0) {
            this.l0.setColor(this.s0);
            this.l0.setStyle(Paint.Style.FILL);
            Paint paint = this.l0;
            ColorFilter colorFilter = this.A0;
            if (colorFilter == null) {
                colorFilter = this.B0;
            }
            paint.setColorFilter(colorFilter);
            this.n0.set(bounds);
            canvas.drawRoundRect(this.n0, J(), J(), this.l0);
        }
        if (this.L0) {
            super.draw(canvas);
        }
        if (this.F > 0.0f && !this.L0) {
            this.l0.setColor(this.u0);
            this.l0.setStyle(Paint.Style.STROKE);
            if (!this.L0) {
                Paint paint2 = this.l0;
                ColorFilter colorFilter2 = this.A0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.B0;
                }
                paint2.setColorFilter(colorFilter2);
            }
            RectF rectF = this.n0;
            float f6 = bounds.left;
            float f7 = this.F / 2.0f;
            rectF.set(f6 + f7, bounds.top + f7, bounds.right - f7, bounds.bottom - f7);
            float f8 = this.D - (this.F / 2.0f);
            canvas.drawRoundRect(this.n0, f8, f8, this.l0);
        }
        this.l0.setColor(this.v0);
        this.l0.setStyle(Paint.Style.FILL);
        this.n0.set(bounds);
        if (this.L0) {
            c(new RectF(bounds), this.p0);
            i2 = 0;
            g(canvas, this.l0, this.p0, this.f2333c.a, h());
        } else {
            canvas.drawRoundRect(this.n0, J(), J(), this.l0);
            i2 = 0;
        }
        if (u0()) {
            E(bounds, this.n0);
            RectF rectF2 = this.n0;
            float f9 = rectF2.left;
            float f10 = rectF2.top;
            canvas.translate(f9, f10);
            this.J.setBounds(i2, i2, (int) this.n0.width(), (int) this.n0.height());
            this.J.draw(canvas);
            canvas.translate(-f9, -f10);
        }
        if (t0()) {
            E(bounds, this.n0);
            RectF rectF3 = this.n0;
            float f11 = rectF3.left;
            float f12 = rectF3.top;
            canvas.translate(f11, f12);
            this.Y.setBounds(i2, i2, (int) this.n0.width(), (int) this.n0.height());
            this.Y.draw(canvas);
            canvas.translate(-f11, -f12);
        }
        if (!this.J0 || this.H == null) {
            i3 = iSaveLayerAlpha;
            i4 = 255;
            i5 = 0;
        } else {
            PointF pointF = this.o0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            if (this.H != null) {
                float F = F() + this.c0 + this.f0;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    pointF.x = bounds.left + F;
                    align = Paint.Align.LEFT;
                } else {
                    pointF.x = bounds.right - F;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                this.q0.a.getFontMetrics(this.m0);
                Paint.FontMetrics fontMetrics = this.m0;
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            RectF rectF4 = this.n0;
            rectF4.setEmpty();
            if (this.H != null) {
                float F2 = F() + this.c0 + this.f0;
                float fI = I() + this.j0 + this.g0;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    rectF4.left = bounds.left + F2;
                    rectF4.right = bounds.right - fI;
                } else {
                    rectF4.left = bounds.left + fI;
                    rectF4.right = bounds.right - F2;
                }
                rectF4.top = bounds.top;
                rectF4.bottom = bounds.bottom;
            }
            e eVar = this.q0;
            if (eVar.f1124f != null) {
                eVar.a.drawableState = getState();
                e eVar2 = this.q0;
                eVar2.f1124f.c(this.k0, eVar2.a, eVar2.f1120b);
            }
            this.q0.a.setTextAlign(align);
            boolean z2 = Math.round(this.q0.a(this.H.toString())) > Math.round(this.n0.width());
            if (z2) {
                iSave = canvas.save();
                canvas.clipRect(this.n0);
            } else {
                iSave = 0;
            }
            CharSequence charSequenceEllipsize = this.H;
            if (z2 && this.I0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.q0.a, this.n0.width(), this.I0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF2 = this.o0;
            i5 = 0;
            i4 = 255;
            i3 = iSaveLayerAlpha;
            canvas.drawText(charSequence, 0, length, pointF2.x, pointF2.y, this.q0.a);
            if (z2) {
                canvas.restoreToCount(iSave);
            }
        }
        if (v0()) {
            G(bounds, this.n0);
            RectF rectF5 = this.n0;
            float f13 = rectF5.left;
            float f14 = rectF5.top;
            canvas.translate(f13, f14);
            this.R.setBounds(i5, i5, (int) this.n0.width(), (int) this.n0.height());
            int[] iArr = c.e.a.b.u.a.a;
            this.S.setBounds(this.R.getBounds());
            this.S.jumpToCurrentState();
            this.S.draw(canvas);
            canvas.translate(-f13, -f14);
        }
        if (this.z0 < i4) {
            canvas.restoreToCount(i3);
        }
    }

    public void e0(float f2) {
        if (this.F != f2) {
            this.F = f2;
            this.l0.setStrokeWidth(f2);
            if (this.L0) {
                this.f2333c.f2353l = f2;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public void f0(@Nullable Drawable drawable) {
        Drawable drawableK = K();
        if (drawableK != drawable) {
            float fI = I();
            this.R = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            int[] iArr = c.e.a.b.u.a.a;
            this.S = new RippleDrawable(c.e.a.b.u.a.c(this.G), this.R, z);
            float fI2 = I();
            w0(drawableK);
            if (v0()) {
                D(this.R);
            }
            invalidateSelf();
            if (fI != fI2) {
                O();
            }
        }
    }

    public void g0(float f2) {
        if (this.i0 != f2) {
            this.i0 = f2;
            invalidateSelf();
            if (v0()) {
                O();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.z0;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.A0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(I() + this.q0.a(this.H.toString()) + F() + this.c0 + this.f0 + this.g0 + this.j0), this.K0);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.L0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.D);
        } else {
            outline.setRoundRect(bounds, this.D);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public void h0(float f2) {
        if (this.U != f2) {
            this.U = f2;
            invalidateSelf();
            if (v0()) {
                O();
            }
        }
    }

    public void i0(float f2) {
        if (this.h0 != f2) {
            this.h0 = f2;
            invalidateSelf();
            if (v0()) {
                O();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (M(this.A) || M(this.B) || M(this.E)) {
            return true;
        }
        if (this.F0 && M(this.G0)) {
            return true;
        }
        b bVar = this.q0.f1124f;
        if ((bVar == null || (colorStateList = bVar.a) == null || !colorStateList.isStateful()) ? false : true) {
            return true;
        }
        return (this.X && this.Y != null && this.W) || N(this.J) || N(this.Y) || M(this.C0);
    }

    public boolean j0(@NonNull int[] iArr) {
        if (Arrays.equals(this.E0, iArr)) {
            return false;
        }
        this.E0 = iArr;
        if (v0()) {
            return P(getState(), iArr);
        }
        return false;
    }

    public void k0(@Nullable ColorStateList colorStateList) {
        if (this.T != colorStateList) {
            this.T = colorStateList;
            if (v0()) {
                DrawableCompat.setTintList(this.R, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void l0(boolean z2) {
        if (this.Q != z2) {
            boolean zV0 = v0();
            this.Q = z2;
            boolean zV02 = v0();
            if (zV0 != zV02) {
                if (zV02) {
                    D(this.R);
                } else {
                    w0(this.R);
                }
                invalidateSelf();
                O();
            }
        }
    }

    public void m0(float f2) {
        if (this.e0 != f2) {
            float F = F();
            this.e0 = f2;
            float F2 = F();
            invalidateSelf();
            if (F != F2) {
                O();
            }
        }
    }

    public void n0(float f2) {
        if (this.d0 != f2) {
            float F = F();
            this.d0 = f2;
            float F2 = F();
            invalidateSelf();
            if (F != F2) {
                O();
            }
        }
    }

    public void o0(@Nullable ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            this.G0 = this.F0 ? c.e.a.b.u.a.c(colorStateList) : null;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (u0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.J, i2);
        }
        if (t0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.Y, i2);
        }
        if (v0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.R, i2);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        boolean zOnLevelChange = super.onLevelChange(i2);
        if (u0()) {
            zOnLevelChange |= this.J.setLevel(i2);
        }
        if (t0()) {
            zOnLevelChange |= this.Y.setLevel(i2);
        }
        if (v0()) {
            zOnLevelChange |= this.R.setLevel(i2);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, c.e.a.b.q.e.b
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.L0) {
            super.onStateChange(iArr);
        }
        return P(iArr, this.E0);
    }

    public void p0(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.H, charSequence)) {
            return;
        }
        this.H = charSequence;
        this.q0.f1122d = true;
        invalidateSelf();
        O();
    }

    public void q0(float f2) {
        if (this.g0 != f2) {
            this.g0 = f2;
            invalidateSelf();
            O();
        }
    }

    public void r0(float f2) {
        if (this.f0 != f2) {
            this.f0 = f2;
            invalidateSelf();
            O();
        }
    }

    public void s0(boolean z2) {
        if (this.F0 != z2) {
            this.F0 = z2;
            this.G0 = z2 ? c.e.a.b.u.a.c(this.G) : null;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.z0 != i2) {
            this.z0 = i2;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.A0 != colorFilter) {
            this.A0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.C0 != colorStateList) {
            this.C0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.D0 != mode) {
            this.D0 = mode;
            this.B0 = f.Z5(this, this.C0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (u0()) {
            visible |= this.J.setVisible(z2, z3);
        }
        if (t0()) {
            visible |= this.Y.setVisible(z2, z3);
        }
        if (v0()) {
            visible |= this.R.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final boolean t0() {
        return this.X && this.Y != null && this.x0;
    }

    public final boolean u0() {
        return this.I && this.J != null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final boolean v0() {
        return this.Q && this.R != null;
    }

    public final void w0(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }
}
