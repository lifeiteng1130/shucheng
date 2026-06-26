package e.b.a.p.u;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import e.b.a.p.r;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: HeadingSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends MetricAffectingSpan implements LeadingMarginSpan {
    public final r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f6018b = g.a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f6019c = g.f6022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6020d;

    public f(@NonNull r rVar, @IntRange(from = 1, to = 6) int i2) {
        this.a = rVar;
        this.f6020d = i2;
    }

    public final void a(TextPaint textPaint) {
        r rVar = this.a;
        int i2 = this.f6020d;
        Objects.requireNonNull(rVar);
        textPaint.setFakeBoldText(true);
        float[] fArr = r.a;
        if (fArr.length < i2) {
            throw new IllegalStateException(String.format(Locale.US, "Supplied heading level: %d is invalid, where configured heading sizes are: `%s`", Integer.valueOf(i2), Arrays.toString(fArr)));
        }
        textPaint.setTextSize(textPaint.getTextSize() * fArr[i2 - 1]);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        int width;
        int i9 = this.f6020d;
        if (i9 == 1 || i9 == 2) {
            if ((charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanEnd(this) == i8) {
                this.f6019c.set(paint);
                r rVar = this.a;
                Paint paint2 = this.f6019c;
                Objects.requireNonNull(rVar);
                paint2.setColor(c.b.a.m.f.n0(paint2.getColor(), 75));
                paint2.setStyle(Paint.Style.FILL);
                int i10 = rVar.f6002g;
                if (i10 >= 0) {
                    paint2.setStrokeWidth(i10);
                }
                float strokeWidth = this.f6019c.getStrokeWidth();
                if (strokeWidth > 0.0f) {
                    int i11 = (int) ((i6 - strokeWidth) + 0.5f);
                    if (i3 > 0) {
                        width = canvas.getWidth();
                    } else {
                        width = i2;
                        i2 -= canvas.getWidth();
                    }
                    this.f6018b.set(i2, i11, width, i6);
                    canvas.drawRect(this.f6018b, this.f6019c);
                }
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return 0;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
