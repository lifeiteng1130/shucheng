package e.a.a.g.d.i.s1.f;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Region;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import f.c0.c.j;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.page.ReadView;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SimulationPageDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends c {

    @NotNull
    public final PointF A;

    @NotNull
    public PointF B;
    public float C;
    public float D;
    public float E;
    public float F;

    @NotNull
    public ColorMatrixColorFilter G;

    @NotNull
    public final Matrix H;

    @NotNull
    public final float[] I;
    public boolean J;
    public float K;

    @NotNull
    public int[] L;

    @NotNull
    public int[] M;

    @NotNull
    public GradientDrawable N;

    @NotNull
    public GradientDrawable O;

    @NotNull
    public GradientDrawable P;

    @NotNull
    public GradientDrawable Q;

    @NotNull
    public GradientDrawable R;

    @NotNull
    public GradientDrawable S;

    @NotNull
    public GradientDrawable T;

    @NotNull
    public GradientDrawable U;

    @NotNull
    public final Paint V;
    public float o;
    public float p;
    public int q;
    public int r;

    @NotNull
    public final Path s;

    @NotNull
    public final Path t;

    @NotNull
    public final PointF u;

    @NotNull
    public final PointF v;

    @NotNull
    public final PointF w;

    @NotNull
    public PointF x;

    @NotNull
    public final PointF y;

    @NotNull
    public final PointF z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull ReadView readView) {
        super(readView);
        j.e(readView, "readView");
        this.o = 0.1f;
        this.p = 0.1f;
        this.q = 1;
        this.r = 1;
        this.s = new Path();
        this.t = new Path();
        this.u = new PointF();
        this.v = new PointF();
        this.w = new PointF();
        this.x = new PointF();
        this.y = new PointF();
        this.z = new PointF();
        this.A = new PointF();
        this.B = new PointF();
        this.G = new ColorMatrixColorFilter(new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        this.H = new Matrix();
        this.I = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.K = (float) Math.hypot(this.f5756c, this.f5757d);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        this.V = paint;
        int[] iArr = {3355443, -1338821837};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, iArr);
        this.Q = gradientDrawable;
        gradientDrawable.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        this.P = gradientDrawable2;
        gradientDrawable2.setGradientType(0);
        this.L = new int[]{-15658735, 1118481};
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, this.L);
        this.O = gradientDrawable3;
        gradientDrawable3.setGradientType(0);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.L);
        this.N = gradientDrawable4;
        gradientDrawable4.setGradientType(0);
        this.M = new int[]{-2146365167, 1118481};
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.M);
        this.T = gradientDrawable5;
        gradientDrawable5.setGradientType(0);
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, this.M);
        this.U = gradientDrawable6;
        gradientDrawable6.setGradientType(0);
        GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.M);
        this.S = gradientDrawable7;
        gradientDrawable7.setGradientType(0);
        GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.M);
        this.R = gradientDrawable8;
        gradientDrawable8.setGradientType(0);
    }

    public final void A(Canvas canvas) {
        double dAtan2;
        int i2;
        int i3;
        GradientDrawable gradientDrawable;
        int i4;
        int i5;
        GradientDrawable gradientDrawable2;
        if (this.J) {
            PointF pointF = this.v;
            dAtan2 = Math.atan2(pointF.y - this.p, this.o - pointF.x);
        } else {
            float f2 = this.p;
            PointF pointF2 = this.v;
            dAtan2 = Math.atan2(f2 - pointF2.y, this.o - pointF2.x);
        }
        double d2 = 0.7853981633974483d - ((double) ((float) dAtan2));
        double dCos = Math.cos(d2) * 35.35d;
        double dSin = Math.sin(d2) * 35.35d;
        float f3 = (float) (((double) this.o) + dCos);
        float f4 = (float) (this.J ? ((double) this.p) + dSin : ((double) this.p) - dSin);
        this.t.reset();
        this.t.moveTo(f3, f4);
        this.t.lineTo(this.o, this.p);
        Path path = this.t;
        PointF pointF3 = this.v;
        path.lineTo(pointF3.x, pointF3.y);
        Path path2 = this.t;
        PointF pointF4 = this.u;
        path2.lineTo(pointF4.x, pointF4.y);
        this.t.close();
        canvas.save();
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 26) {
            canvas.clipOutPath(this.s);
        } else {
            canvas.clipPath(this.s, Region.Op.XOR);
        }
        canvas.clipPath(this.t, Region.Op.INTERSECT);
        if (this.J) {
            float f5 = this.v.x;
            i2 = (int) f5;
            i3 = (int) (f5 + 25);
            gradientDrawable = this.T;
        } else {
            float f6 = this.v.x;
            i2 = (int) (f6 - 25);
            i3 = (int) (f6 + 1);
            gradientDrawable = this.U;
        }
        float f7 = this.o;
        PointF pointF5 = this.v;
        float degrees = (float) Math.toDegrees((float) Math.atan2(f7 - pointF5.x, pointF5.y - this.p));
        PointF pointF6 = this.v;
        canvas.rotate(degrees, pointF6.x, pointF6.y);
        float f8 = this.v.y;
        gradientDrawable.setBounds(i2, (int) (f8 - this.K), i3, (int) f8);
        gradientDrawable.draw(canvas);
        canvas.restore();
        this.t.reset();
        this.t.moveTo(f3, f4);
        this.t.lineTo(this.o, this.p);
        Path path3 = this.t;
        PointF pointF7 = this.z;
        path3.lineTo(pointF7.x, pointF7.y);
        Path path4 = this.t;
        PointF pointF8 = this.y;
        path4.lineTo(pointF8.x, pointF8.y);
        this.t.close();
        canvas.save();
        if (i6 >= 26) {
            canvas.clipOutPath(this.s);
        } else {
            canvas.clipPath(this.s, Region.Op.XOR);
        }
        canvas.clipPath(this.t);
        if (this.J) {
            float f9 = this.z.y;
            i4 = (int) f9;
            i5 = (int) (f9 + 25);
            gradientDrawable2 = this.S;
        } else {
            float f10 = this.z.y;
            i4 = (int) (f10 - 25);
            i5 = (int) (f10 + 1);
            gradientDrawable2 = this.R;
        }
        PointF pointF9 = this.z;
        float degrees2 = (float) Math.toDegrees((float) Math.atan2(pointF9.y - this.p, pointF9.x - this.o));
        PointF pointF10 = this.z;
        canvas.rotate(degrees2, pointF10.x, pointF10.y);
        float f11 = this.z.y;
        if (f11 < 0.0f) {
            f11 -= this.f5757d;
        }
        double dHypot = Math.hypot(r3.x, f11);
        float f12 = this.K;
        if (dHypot > f12) {
            float f13 = this.z.x;
            gradientDrawable2.setBounds((int) (((double) (f13 - 25)) - dHypot), i4, (int) (((double) (f13 + f12)) - dHypot), i5);
        } else {
            float f14 = this.z.x;
            gradientDrawable2.setBounds((int) (f14 - f12), i4, (int) f14, i5);
        }
        gradientDrawable2.draw(canvas);
        canvas.restore();
    }

    public final void B(Canvas canvas, Bitmap bitmap) {
        int i2;
        int i3;
        GradientDrawable gradientDrawable;
        if (bitmap == null) {
            return;
        }
        this.t.reset();
        Path path = this.t;
        PointF pointF = this.u;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.t;
        PointF pointF2 = this.w;
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.t;
        PointF pointF3 = this.A;
        path3.lineTo(pointF3.x, pointF3.y);
        Path path4 = this.t;
        PointF pointF4 = this.y;
        path4.lineTo(pointF4.x, pointF4.y);
        this.t.lineTo(this.q, this.r);
        this.t.close();
        this.E = (float) Math.toDegrees(Math.atan2(this.v.x - this.q, ((double) this.z.y) - ((double) this.r)));
        if (this.J) {
            float f2 = this.u.x;
            i2 = (int) f2;
            i3 = (int) ((this.F / 4) + f2);
            gradientDrawable = this.N;
        } else {
            float f3 = this.u.x;
            i2 = (int) (f3 - (this.F / 4));
            i3 = (int) f3;
            gradientDrawable = this.O;
        }
        canvas.save();
        canvas.clipPath(this.s);
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(this.t);
        } else {
            canvas.clipPath(this.t, Region.Op.INTERSECT);
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f4 = this.E;
        PointF pointF5 = this.u;
        canvas.rotate(f4, pointF5.x, pointF5.y);
        float f5 = this.u.y;
        gradientDrawable.setBounds(i2, (int) f5, i3, (int) (this.K + f5));
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    public final PointF C(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        PointF pointF5 = new PointF();
        float f2 = pointF2.y;
        float f3 = pointF.y;
        float f4 = pointF2.x;
        float f5 = pointF.x;
        float f6 = (f2 - f3) / (f4 - f5);
        float f7 = ((f2 * f5) - (f3 * f4)) / (f5 - f4);
        float f8 = pointF4.y;
        float f9 = pointF3.y;
        float f10 = pointF4.x;
        float f11 = pointF3.x;
        float f12 = ((((f8 * f11) - (f9 * f10)) / (f11 - f10)) - f7) / (f6 - ((f8 - f9) / (f10 - f11)));
        pointF5.x = f12;
        pointF5.y = (f6 * f12) + f7;
        return pointF5;
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void l(int i2) {
        float f2;
        float f3;
        float fG;
        float f4;
        if (this.f5762i) {
            f2 = (this.q <= 0 || this.f5761h != e.a.a.g.d.i.s1.g.a.NEXT) ? -f() : this.f5756c - f();
            if (this.f5761h != e.a.a.g.d.i.s1.g.a.NEXT) {
                f2 = -(f() + this.f5756c);
            }
            if (this.r <= 0) {
                f4 = -g();
                u((int) f(), (int) g(), (int) f2, (int) f4, i2);
            } else {
                f3 = this.f5757d;
                fG = g();
            }
        } else {
            f2 = (this.q <= 0 || this.f5761h != e.a.a.g.d.i.s1.g.a.NEXT) ? (this.f5756c - f()) + this.f5756c : -(f() + this.f5756c);
            if (this.r > 0) {
                f3 = this.f5757d;
                fG = g();
            } else {
                f3 = 1;
                fG = g();
            }
        }
        f4 = f3 - fG;
        u((int) f(), (int) g(), (int) f2, (int) f4, i2);
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void m() {
        if (this.f5762i) {
            return;
        }
        this.a.f(this.f5761h);
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void o(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
        if (this.f5763j) {
            int iOrdinal = this.f5761h.ordinal();
            if (iOrdinal == 1) {
                x();
                z(canvas, this.m);
                B(canvas, this.f5754l);
                A(canvas);
                y(canvas, this.m);
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            x();
            z(canvas, this.f5754l);
            B(canvas, this.n);
            A(canvas);
            y(canvas, this.f5754l);
        }
    }

    @Override // e.a.a.g.d.i.s1.f.c, e.a.a.g.d.i.s1.f.e
    public void q(@NotNull MotionEvent motionEvent) {
        j.e(motionEvent, NotificationCompat.CATEGORY_EVENT);
        super.q(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            w(motionEvent.getX(), motionEvent.getY());
            return;
        }
        if (action != 2) {
            return;
        }
        if ((e() > this.f5757d / 3 && e() < (this.f5757d * 2) / 3) || this.f5761h == e.a.a.g.d.i.s1.g.a.PREV) {
            this.a.setTouchY(this.f5757d);
        }
        if (e() <= this.f5757d / 3 || e() >= this.f5757d / 2 || this.f5761h != e.a.a.g.d.i.s1.g.a.NEXT) {
            return;
        }
        this.a.setTouchY(1.0f);
    }

    @Override // e.a.a.g.d.i.s1.f.c, e.a.a.g.d.i.s1.f.e
    public void s(@NotNull e.a.a.g.d.i.s1.g.a aVar) {
        j.e(aVar, "direction");
        super.s(aVar);
        int iOrdinal = aVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2 && this.f5756c / 2 > d()) {
                w(this.f5756c - d(), e());
                return;
            }
            return;
        }
        float fD = d();
        int i2 = this.f5756c;
        if (fD > i2 / 2) {
            w(d(), this.f5757d);
        } else {
            w(i2 - d(), this.f5757d);
        }
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void t(int i2, int i3) {
        this.f5756c = i2;
        this.f5757d = i3;
        this.K = (float) Math.hypot(i2, i3);
    }

    public final void w(float f2, float f3) {
        int i2 = this.f5756c;
        boolean z = false;
        int i3 = f2 <= ((float) (i2 / 2)) ? 0 : i2;
        this.q = i3;
        int i4 = this.f5757d;
        int i5 = f3 <= ((float) (i4 / 2)) ? 0 : i4;
        this.r = i5;
        if ((i3 == 0 && i5 == i4) || (i5 == 0 && i3 == i2)) {
            z = true;
        }
        this.J = z;
    }

    public final void x() {
        this.o = f();
        float fG = g();
        this.p = fG;
        float f2 = this.o;
        int i2 = this.q;
        float f3 = 2;
        float f4 = (i2 + f2) / f3;
        this.C = f4;
        int i3 = this.r;
        float f5 = (fG + i3) / f3;
        this.D = f5;
        PointF pointF = this.v;
        pointF.x = f4 - (((i3 - f5) * (i3 - f5)) / (i2 - f4));
        pointF.y = i3;
        PointF pointF2 = this.z;
        pointF2.x = i2;
        if (((float) i3) - f5 == 0.0f) {
            pointF2.y = f5 - (((i2 - f4) * (i2 - f4)) / 0.1f);
        } else {
            pointF2.y = f5 - (((i2 - f4) * (i2 - f4)) / (i3 - f5));
        }
        PointF pointF3 = this.u;
        float f6 = pointF.x;
        float f7 = f6 - ((i2 - f6) / f3);
        pointF3.x = f7;
        pointF3.y = i3;
        if (f2 > 0.0f) {
            int i4 = this.f5756c;
            if (f2 < i4 && (f7 < 0.0f || f7 > i4)) {
                if (f7 < 0.0f) {
                    pointF3.x = i4 - f7;
                }
                float fAbs = Math.abs(i2 - f2);
                float fAbs2 = Math.abs(this.q - ((this.f5756c * fAbs) / this.u.x));
                this.o = fAbs2;
                float fAbs3 = Math.abs(this.r - ((Math.abs(this.r - this.p) * Math.abs(this.q - fAbs2)) / fAbs));
                this.p = fAbs3;
                float f8 = this.o;
                int i5 = this.q;
                float f9 = (f8 + i5) / f3;
                this.C = f9;
                int i6 = this.r;
                float f10 = (fAbs3 + i6) / f3;
                this.D = f10;
                PointF pointF4 = this.v;
                pointF4.x = f9 - (((i6 - f10) * (i6 - f10)) / (i5 - f9));
                pointF4.y = i6;
                PointF pointF5 = this.z;
                pointF5.x = i5;
                if (((float) i6) - f10 == 0.0f) {
                    pointF5.y = f10 - (((i5 - f9) * (i5 - f9)) / 0.1f);
                } else {
                    pointF5.y = f10 - (((i5 - f9) * (i5 - f9)) / (i6 - f10));
                }
                PointF pointF6 = this.u;
                float f11 = pointF4.x;
                pointF6.x = f11 - ((i5 - f11) / f3);
            }
        }
        PointF pointF7 = this.y;
        pointF7.x = this.q;
        float f12 = this.z.y;
        pointF7.y = f12 - ((this.r - f12) / f3);
        this.F = (float) Math.hypot(this.o - r1, this.p - r3);
        this.x = C(new PointF(this.o, this.p), this.v, this.u, this.y);
        PointF pointFC = C(new PointF(this.o, this.p), this.z, this.u, this.y);
        this.B = pointFC;
        PointF pointF8 = this.w;
        PointF pointF9 = this.u;
        float f13 = pointF9.x;
        PointF pointF10 = this.v;
        float f14 = (pointF10.x * f3) + f13;
        PointF pointF11 = this.x;
        float f15 = 4;
        pointF8.x = (f14 + pointF11.x) / f15;
        pointF8.y = (((pointF10.y * f3) + pointF9.y) + pointF11.y) / f15;
        PointF pointF12 = this.A;
        PointF pointF13 = this.y;
        float f16 = pointF13.x;
        PointF pointF14 = this.z;
        pointF12.x = (((pointF14.x * f3) + f16) + pointFC.x) / f15;
        pointF12.y = (((f3 * pointF14.y) + pointF13.y) + pointFC.y) / f15;
    }

    public final void y(Canvas canvas, Bitmap bitmap) {
        int i2;
        int i3;
        GradientDrawable gradientDrawable;
        if (bitmap == null) {
            return;
        }
        float f2 = this.u.x;
        float f3 = 2;
        float fAbs = Math.abs(((int) ((f2 + r1) / f3)) - this.v.x);
        float f4 = this.y.y;
        float fMin = Math.min(fAbs, Math.abs(((int) ((f4 + r3) / f3)) - this.z.y));
        this.t.reset();
        Path path = this.t;
        PointF pointF = this.A;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.t;
        PointF pointF2 = this.w;
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.t;
        PointF pointF3 = this.x;
        path3.lineTo(pointF3.x, pointF3.y);
        this.t.lineTo(this.o, this.p);
        Path path4 = this.t;
        PointF pointF4 = this.B;
        path4.lineTo(pointF4.x, pointF4.y);
        this.t.close();
        if (this.J) {
            float f5 = this.u.x;
            float f6 = 1;
            i2 = (int) (f5 - f6);
            i3 = (int) (f5 + fMin + f6);
            gradientDrawable = this.P;
        } else {
            float f7 = this.u.x;
            float f8 = 1;
            i2 = (int) ((f7 - fMin) - f8);
            i3 = (int) (f7 + f8);
            gradientDrawable = this.Q;
        }
        canvas.save();
        canvas.clipPath(this.s);
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(this.t);
        } else {
            canvas.clipPath(this.t, Region.Op.INTERSECT);
        }
        this.V.setColorFilter(this.G);
        float fHypot = (float) Math.hypot(((double) this.q) - ((double) this.v.x), ((double) this.z.y) - ((double) this.r));
        float f9 = (this.q - this.v.x) / fHypot;
        float f10 = (this.z.y - this.r) / fHypot;
        float[] fArr = this.I;
        float f11 = 1;
        fArr[0] = f11 - ((f3 * f10) * f10);
        float f12 = f3 * f9;
        fArr[1] = f10 * f12;
        fArr[3] = fArr[1];
        fArr[4] = f11 - (f12 * f9);
        this.H.reset();
        this.H.setValues(this.I);
        Matrix matrix = this.H;
        PointF pointF5 = this.v;
        matrix.preTranslate(-pointF5.x, -pointF5.y);
        Matrix matrix2 = this.H;
        PointF pointF6 = this.v;
        matrix2.postTranslate(pointF6.x, pointF6.y);
        canvas.drawColor(ReadBookConfig.INSTANCE.getBgMeanColor());
        canvas.drawBitmap(bitmap, this.H, this.V);
        this.V.setColorFilter(null);
        float f13 = this.E;
        PointF pointF7 = this.u;
        canvas.rotate(f13, pointF7.x, pointF7.y);
        float f14 = this.u.y;
        gradientDrawable.setBounds(i2, (int) f14, i3, (int) (f14 + this.K));
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    public final void z(Canvas canvas, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.s.reset();
        Path path = this.s;
        PointF pointF = this.u;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.s;
        PointF pointF2 = this.v;
        float f2 = pointF2.x;
        float f3 = pointF2.y;
        PointF pointF3 = this.x;
        path2.quadTo(f2, f3, pointF3.x, pointF3.y);
        this.s.lineTo(this.o, this.p);
        Path path3 = this.s;
        PointF pointF4 = this.B;
        path3.lineTo(pointF4.x, pointF4.y);
        Path path4 = this.s;
        PointF pointF5 = this.z;
        float f4 = pointF5.x;
        float f5 = pointF5.y;
        PointF pointF6 = this.y;
        path4.quadTo(f4, f5, pointF6.x, pointF6.y);
        this.s.lineTo(this.q, this.r);
        this.s.close();
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutPath(this.s);
        } else {
            canvas.clipPath(this.s, Region.Op.XOR);
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }
}
