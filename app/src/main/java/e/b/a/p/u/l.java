package e.b.a.p.u;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.annotation.NonNull;
import e.b.a.p.r;
import java.util.Objects;

/* JADX INFO: compiled from: ThematicBreakSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class l implements LeadingMarginSpan {
    public final r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f6026b = g.a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f6027c = g.f6022c;

    public l(@NonNull r rVar) {
        this.a = rVar;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        int width;
        int i9 = ((i6 - i4) / 2) + i4;
        this.f6027c.set(paint);
        r rVar = this.a;
        Paint paint2 = this.f6027c;
        Objects.requireNonNull(rVar);
        paint2.setColor(c.b.a.m.f.n0(paint2.getColor(), 25));
        paint2.setStyle(Paint.Style.FILL);
        int i10 = rVar.f6003h;
        if (i10 >= 0) {
            paint2.setStrokeWidth(i10);
        }
        int strokeWidth = (int) ((((int) (this.f6027c.getStrokeWidth() + 0.5f)) / 2.0f) + 0.5f);
        if (i3 > 0) {
            width = canvas.getWidth();
        } else {
            width = i2;
            i2 -= canvas.getWidth();
        }
        this.f6026b.set(i2, i9 - strokeWidth, width, i9 + strokeWidth);
        canvas.drawRect(this.f6026b, this.f6027c);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return 0;
    }
}
