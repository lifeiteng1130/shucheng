package e.b.a.s;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.r;

/* JADX INFO: compiled from: AsyncDrawableSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends ReplacementSpan {
    public final r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f6111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6113d;

    public g(@NonNull r rVar, @NonNull a aVar, int i2, boolean z) {
        this.a = rVar;
        this.f6111b = aVar;
        this.f6112c = i2;
        this.f6113d = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #0 {all -> 0x005d, blocks: (B:8:0x002e, B:10:0x0032, B:14:0x0048, B:15:0x0049, B:17:0x0054, B:13:0x0042), top: B:29:0x002e }] */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas r10, java.lang.CharSequence r11, @androidx.annotation.IntRange(from = 0) int r12, @androidx.annotation.IntRange(from = 0) int r13, float r14, int r15, int r16, int r17, @androidx.annotation.NonNull android.graphics.Paint r18) {
        /*
            r9 = this;
            r1 = r9
            r2 = r10
            r0 = r18
            e.b.a.s.a r3 = r1.f6111b
            int r4 = c.b.a.m.f.e6(r10, r11)
            float r5 = r18.getTextSize()
            r3.f6103h = r4
            r3.f6104i = r5
            boolean r4 = r3.f6105j
            if (r4 == 0) goto L19
            r3.b()
        L19:
            e.b.a.s.a r3 = r1.f6111b
            boolean r4 = r3.a()
            r5 = 2
            if (r4 == 0) goto L62
            android.graphics.Rect r4 = r3.getBounds()
            int r4 = r4.bottom
            int r4 = r17 - r4
            int r6 = r10.save()
            int r7 = r1.f6112c     // Catch: java.lang.Throwable -> L5d
            if (r5 != r7) goto L3f
            int r0 = r17 - r15
            android.graphics.Rect r7 = r3.getBounds()     // Catch: java.lang.Throwable -> L5d
            int r7 = r7.height()     // Catch: java.lang.Throwable -> L5d
            int r0 = r0 - r7
            int r0 = r0 / r5
            goto L48
        L3f:
            r5 = 1
            if (r5 != r7) goto L49
            android.graphics.Paint$FontMetricsInt r0 = r18.getFontMetricsInt()     // Catch: java.lang.Throwable -> L5d
            int r0 = r0.descent     // Catch: java.lang.Throwable -> L5d
        L48:
            int r4 = r4 - r0
        L49:
            float r0 = (float) r4     // Catch: java.lang.Throwable -> L5d
            r7 = r14
            r10.translate(r14, r0)     // Catch: java.lang.Throwable -> L5d
            boolean r0 = r3.a()     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L59
            android.graphics.drawable.Drawable r0 = r3.f6101f     // Catch: java.lang.Throwable -> L5d
            r0.draw(r10)     // Catch: java.lang.Throwable -> L5d
        L59:
            r10.restoreToCount(r6)
            goto L9c
        L5d:
            r0 = move-exception
            r10.restoreToCount(r6)
            throw r0
        L62:
            r7 = r14
            int r3 = r17 - r15
            int r3 = r3 / r5
            int r3 = r3 + r15
            float r3 = (float) r3
            float r4 = r18.descent()
            float r5 = r18.ascent()
            float r5 = r5 + r4
            r4 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r4
            r4 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 + r4
            float r3 = r3 - r5
            int r3 = (int) r3
            float r8 = (float) r3
            boolean r3 = r1.f6113d
            if (r3 == 0) goto L91
            e.b.a.p.r r3 = r1.a
            boolean r3 = r3.f5997b
            r0.setUnderlineText(r3)
            boolean r3 = r0 instanceof android.text.TextPaint
            if (r3 == 0) goto L91
            r3 = r0
            android.text.TextPaint r3 = (android.text.TextPaint) r3
            int r3 = r3.linkColor
            r0.setColor(r3)
        L91:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r8
            r8 = r18
            r2.drawText(r3, r4, r5, r6, r7, r8)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.s.g.draw(android.graphics.Canvas, java.lang.CharSequence, int, int, float, int, int, int, android.graphics.Paint):void");
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        if (!this.f6111b.a()) {
            if (this.f6113d) {
                paint.setUnderlineText(this.a.f5997b);
                if (paint instanceof TextPaint) {
                    paint.setColor(((TextPaint) paint).linkColor);
                }
            }
            return (int) (paint.measureText(charSequence, i2, i3) + 0.5f);
        }
        Rect bounds = this.f6111b.getBounds();
        if (fontMetricsInt != null) {
            int i4 = -bounds.bottom;
            fontMetricsInt.ascent = i4;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i4;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right;
    }
}
