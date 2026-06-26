package e.b.a.p.u;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.annotation.NonNull;
import e.b.a.p.r;
import java.util.Objects;

/* JADX INFO: compiled from: OrderedListItemSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements LeadingMarginSpan {
    public final r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f6024c = g.f6022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6025d;

    public h(@NonNull r rVar, @NonNull String str) {
        this.a = rVar;
        this.f6023b = str;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        int i9;
        if (z && c.b.a.m.f.b5(i7, charSequence, this)) {
            this.f6024c.set(paint);
            r rVar = this.a;
            Paint paint2 = this.f6024c;
            Objects.requireNonNull(rVar);
            paint2.setColor(paint2.getColor());
            int i10 = rVar.f6000e;
            if (i10 != 0) {
                paint2.setStrokeWidth(i10);
            }
            int iMeasureText = (int) (this.f6024c.measureText(this.f6023b) + 0.5f);
            int i11 = this.a.f5998c;
            if (iMeasureText > i11) {
                this.f6025d = iMeasureText;
                i11 = iMeasureText;
            } else {
                this.f6025d = 0;
            }
            if (i3 > 0) {
                i9 = ((i11 * i3) + i2) - iMeasureText;
            } else {
                i9 = (i11 - iMeasureText) + (i3 * i11) + i2;
            }
            canvas.drawText(this.f6023b, i9, i5, this.f6024c);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return Math.max(this.f6025d, this.a.f5998c);
    }
}
