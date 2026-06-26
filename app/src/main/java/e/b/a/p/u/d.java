package e.b.a.p.u;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;
import e.b.a.p.r;
import java.util.Objects;

/* JADX INFO: compiled from: CodeSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends MetricAffectingSpan {
    public final r a;

    public d(@NonNull r rVar) {
        this.a = rVar;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Objects.requireNonNull(this.a);
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.setTextSize(textPaint.getTextSize() * 0.87f);
        Objects.requireNonNull(this.a);
        textPaint.bgColor = c.b.a.m.f.n0(textPaint.getColor(), 25);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Objects.requireNonNull(this.a);
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.setTextSize(textPaint.getTextSize() * 0.87f);
    }
}
