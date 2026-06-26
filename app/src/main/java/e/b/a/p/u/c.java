package e.b.a.p.u;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;
import e.b.a.p.r;
import java.util.Objects;

/* JADX INFO: compiled from: CodeBlockSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends MetricAffectingSpan implements LeadingMarginSpan {
    public final r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f6016b = g.a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f6017c = g.f6022c;

    public c(@NonNull r rVar) {
        this.a = rVar;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        int width;
        this.f6017c.setStyle(Paint.Style.FILL);
        Paint paint2 = this.f6017c;
        Objects.requireNonNull(this.a);
        paint2.setColor(c.b.a.m.f.n0(paint.getColor(), 25));
        if (i3 > 0) {
            width = canvas.getWidth();
        } else {
            i2 -= canvas.getWidth();
            width = i2;
        }
        this.f6016b.set(i2, i4, width, i6);
        canvas.drawRect(this.f6016b, this.f6017c);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.a.f6001f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Objects.requireNonNull(this.a);
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.setTextSize(textPaint.getTextSize() * 0.87f);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Objects.requireNonNull(this.a);
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.setTextSize(textPaint.getTextSize() * 0.87f);
    }
}
