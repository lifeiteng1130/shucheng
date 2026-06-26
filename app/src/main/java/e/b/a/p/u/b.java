package e.b.a.p.u;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import e.b.a.p.r;
import java.util.Objects;

/* JADX INFO: compiled from: BulletListItemSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements LeadingMarginSpan {
    public static final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f6011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f6012c = g.f6022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f6013d = g.f6021b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f6014e = g.a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6015f;

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = 24 == i2 || 25 == i2;
    }

    public b(@NonNull r rVar, @IntRange(from = 0) int i2) {
        this.f6011b = rVar;
        this.f6015f = i2;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        int iMin;
        int iMax;
        if (z && c.b.a.m.f.b5(i7, charSequence, this)) {
            this.f6012c.set(paint);
            r rVar = this.f6011b;
            Paint paint2 = this.f6012c;
            Objects.requireNonNull(rVar);
            paint2.setColor(paint2.getColor());
            int i9 = rVar.f6000e;
            if (i9 != 0) {
                paint2.setStrokeWidth(i9);
            }
            int iSave = canvas.save();
            try {
                int i10 = this.f6011b.f5998c;
                int iMin2 = Math.min(this.f6011b.f5998c, (int) ((this.f6012c.descent() - this.f6012c.ascent()) + 0.5f)) / 2;
                int i11 = (i10 - iMin2) / 2;
                if (a) {
                    int width = i3 < 0 ? i2 - (layout.getWidth() - (i10 * this.f6015f)) : (i10 * this.f6015f) - i2;
                    int i12 = (i11 * i3) + i2;
                    int i13 = (i3 * iMin2) + i12;
                    int i14 = i3 * width;
                    iMin = Math.min(i12, i13) + i14;
                    iMax = Math.max(i12, i13) + i14;
                } else {
                    if (i3 <= 0) {
                        i2 -= i10;
                    }
                    iMin = i2 + i11;
                    iMax = iMin + iMin2;
                }
                int iDescent = (i5 + ((int) (((this.f6012c.descent() + this.f6012c.ascent()) / 2.0f) + 0.5f))) - (iMin2 / 2);
                int i15 = iMin2 + iDescent;
                int i16 = this.f6015f;
                if (i16 == 0 || i16 == 1) {
                    this.f6013d.set(iMin, iDescent, iMax, i15);
                    this.f6012c.setStyle(this.f6015f == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                    canvas.drawOval(this.f6013d, this.f6012c);
                } else {
                    this.f6014e.set(iMin, iDescent, iMax, i15);
                    this.f6012c.setStyle(Paint.Style.FILL);
                    canvas.drawRect(this.f6014e, this.f6012c);
                }
            } finally {
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.f6011b.f5998c;
    }
}
