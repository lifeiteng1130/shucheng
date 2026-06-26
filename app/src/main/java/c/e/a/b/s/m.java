package c.e.a.b.s;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: LinearDrawingDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public final class m extends k<r> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1168e;

    public m(@NonNull r rVar) {
        super(rVar);
        this.f1166c = 300.0f;
    }

    public static void f(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z, RectF rectF) {
        canvas.save();
        canvas.translate(f4, 0.0f);
        if (!z) {
            canvas.rotate(180.0f);
        }
        float f5 = ((-f2) / 2.0f) + f3;
        float f6 = (f2 / 2.0f) - f3;
        canvas.drawRect(-f3, f5, 0.0f, f6, paint);
        canvas.save();
        canvas.translate(0.0f, f5);
        canvas.drawArc(rectF, 180.0f, 90.0f, true, paint);
        canvas.restore();
        canvas.translate(0.0f, f6);
        canvas.drawArc(rectF, 180.0f, -90.0f, true, paint);
        canvas.restore();
    }

    @Override // c.e.a.b.s.k
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Rect clipBounds = canvas.getClipBounds();
        this.f1166c = clipBounds.width();
        float f3 = ((r) this.a).a;
        canvas.translate(clipBounds.width() / 2.0f, Math.max(0.0f, (clipBounds.height() - ((r) this.a).a) / 2.0f) + (clipBounds.height() / 2.0f));
        if (((r) this.a).f1187i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f1163b.f() && ((r) this.a).f1135e == 1) || (this.f1163b.e() && ((r) this.a).f1136f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f1163b.f() || this.f1163b.e()) {
            canvas.translate(0.0f, ((f2 - 1.0f) * ((r) this.a).a) / 2.0f);
        }
        float f4 = this.f1166c;
        canvas.clipRect((-f4) / 2.0f, (-f3) / 2.0f, f4 / 2.0f, f3 / 2.0f);
        S s = this.a;
        this.f1167d = ((r) s).a * f2;
        this.f1168e = ((r) s).f1132b * f2;
    }

    @Override // c.e.a.b.s.k
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @ColorInt int i2) {
        if (f2 == f3) {
            return;
        }
        float f4 = this.f1166c;
        float f5 = this.f1168e;
        float f6 = ((-f4) / 2.0f) + f5;
        float f7 = f4 - (f5 * 2.0f);
        float f8 = (f2 * f7) + f6;
        float f9 = (f7 * f3) + f6;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i2);
        float f10 = this.f1167d;
        canvas.drawRect(f8, (-f10) / 2.0f, f9, f10 / 2.0f, paint);
        float f11 = this.f1168e;
        float f12 = -f11;
        RectF rectF = new RectF(f12, f12, f11, f11);
        f(canvas, paint, this.f1167d, this.f1168e, f8, true, rectF);
        f(canvas, paint, this.f1167d, this.f1168e, f9, false, rectF);
    }

    @Override // c.e.a.b.s.k
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int iW0 = c.b.a.m.f.W0(((r) this.a).f1134d, this.f1163b.getAlpha());
        float f2 = ((-this.f1166c) / 2.0f) + this.f1168e;
        float f3 = -f2;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(iW0);
        float f4 = this.f1167d;
        canvas.drawRect(f2, (-f4) / 2.0f, f3, f4 / 2.0f, paint);
        float f5 = this.f1168e;
        float f6 = -f5;
        RectF rectF = new RectF(f6, f6, f5, f5);
        f(canvas, paint, this.f1167d, this.f1168e, f2, true, rectF);
        f(canvas, paint, this.f1167d, this.f1168e, f3, false, rectF);
    }

    @Override // c.e.a.b.s.k
    public int d() {
        return ((r) this.a).a;
    }

    @Override // c.e.a.b.s.k
    public int e() {
        return -1;
    }
}
