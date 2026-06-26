package e.b.a.p.u;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.annotation.NonNull;
import e.b.a.p.r;
import java.util.Objects;

/* JADX INFO: compiled from: BlockQuoteSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements LeadingMarginSpan {
    public final r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f6009b = g.a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f6010c = g.f6022c;

    public a(@NonNull r rVar) {
        this.a = rVar;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        int i9 = this.a.f5999d;
        if (i9 == 0) {
            i9 = (int) ((r6.f5998c * 0.25f) + 0.5f);
        }
        this.f6010c.set(paint);
        r rVar = this.a;
        Paint paint2 = this.f6010c;
        Objects.requireNonNull(rVar);
        int iN0 = c.b.a.m.f.n0(paint2.getColor(), 25);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(iN0);
        int i10 = i3 * i9;
        int i11 = i2 + i10;
        int i12 = i10 + i11;
        this.f6009b.set(Math.min(i11, i12), i4, Math.max(i11, i12), i6);
        canvas.drawRect(this.f6009b, this.f6010c);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.a.f5998c;
    }
}
