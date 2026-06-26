package c.e.a.b.s;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: CircularDrawingDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends k<g> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f1140f;

    public c(@NonNull g gVar) {
        super(gVar);
        this.f1137c = 1;
    }

    @Override // c.e.a.b.s.k
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        S s = this.a;
        float f3 = (((g) s).f1150g / 2.0f) + ((g) s).f1151h;
        canvas.translate(f3, f3);
        canvas.rotate(-90.0f);
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        this.f1137c = ((g) this.a).f1152i == 0 ? 1 : -1;
        this.f1138d = ((g) r5).a * f2;
        this.f1139e = ((g) r5).f1132b * f2;
        this.f1140f = (((g) r5).f1150g - ((g) r5).a) / 2.0f;
        if ((this.f1163b.f() && ((g) this.a).f1135e == 2) || (this.f1163b.e() && ((g) this.a).f1136f == 1)) {
            this.f1140f = (((1.0f - f2) * ((g) this.a).a) / 2.0f) + this.f1140f;
        } else if ((this.f1163b.f() && ((g) this.a).f1135e == 1) || (this.f1163b.e() && ((g) this.a).f1136f == 2)) {
            this.f1140f -= ((1.0f - f2) * ((g) this.a).a) / 2.0f;
        }
    }

    @Override // c.e.a.b.s.k
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @ColorInt int i2) {
        if (f2 == f3) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i2);
        paint.setStrokeWidth(this.f1138d);
        float f4 = this.f1137c;
        float f5 = f2 * 360.0f * f4;
        if (f3 < f2) {
            f3 += 1.0f;
        }
        float f6 = (f3 - f2) * 360.0f * f4;
        float f7 = this.f1140f;
        float f8 = -f7;
        canvas.drawArc(new RectF(f8, f8, f7, f7), f5, f6, false, paint);
        if (this.f1139e <= 0.0f || Math.abs(f6) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        float f9 = this.f1139e;
        float f10 = -f9;
        RectF rectF = new RectF(f10, f10, f9, f9);
        f(canvas, paint, this.f1138d, this.f1139e, f5, true, rectF);
        f(canvas, paint, this.f1138d, this.f1139e, f5 + f6, false, rectF);
    }

    @Override // c.e.a.b.s.k
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int iW0 = c.b.a.m.f.W0(((g) this.a).f1134d, this.f1163b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(iW0);
        paint.setStrokeWidth(this.f1138d);
        float f2 = this.f1140f;
        float f3 = -f2;
        canvas.drawArc(new RectF(f3, f3, f2, f2), 0.0f, 360.0f, false, paint);
    }

    @Override // c.e.a.b.s.k
    public int d() {
        g gVar = (g) this.a;
        return (gVar.f1151h * 2) + gVar.f1150g;
    }

    @Override // c.e.a.b.s.k
    public int e() {
        g gVar = (g) this.a;
        return (gVar.f1151h * 2) + gVar.f1150g;
    }

    public final void f(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z, RectF rectF) {
        float f5 = z ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f4);
        float f6 = f2 / 2.0f;
        float f7 = f5 * f3;
        canvas.drawRect((this.f1140f - f6) + f3, Math.min(0.0f, this.f1137c * f7), (this.f1140f + f6) - f3, Math.max(0.0f, f7 * this.f1137c), paint);
        canvas.translate((this.f1140f - f6) + f3, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f5) * 90.0f * this.f1137c, true, paint);
        canvas.translate(f2 - (f3 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f5 * 90.0f * this.f1137c, true, paint);
        canvas.restore();
    }
}
