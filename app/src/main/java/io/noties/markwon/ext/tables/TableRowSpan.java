package io.noties.markwon.ext.tables;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.u.j;
import e.b.a.q.a.i;
import e.b.a.q.a.k;
import e.b.a.s.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes3.dex */
public class TableRowSpan extends ReplacementSpan {
    public final k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f7806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Layout> f7807c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f7809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f7810f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f7815k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f7811g = new Rect();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f7812h = new Paint(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextPaint f7808d = new TextPaint();

    @Retention(RetentionPolicy.SOURCE)
    public @interface Alignment {
    }

    public class a implements Runnable {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f7817c;

        public a(int i2, int i3, c cVar) {
            this.a = i2;
            this.f7816b = i3;
            this.f7817c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TableRowSpan tableRowSpan = TableRowSpan.this;
            d dVar = tableRowSpan.f7815k;
            if (dVar != null) {
                tableRowSpan.f7807c.remove(this.a);
                TableRowSpan.this.a(this.a, this.f7816b, this.f7817c);
                i iVar = (i) dVar;
                iVar.f6031b.removeCallbacks(iVar.a);
                iVar.f6031b.post(iVar.a);
            }
        }
    }

    public static abstract class b implements Drawable.Callback {
        public b(a aVar) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        }
    }

    public static class c {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f7819b;

        public c(int i2, CharSequence charSequence) {
            this.a = i2;
            this.f7819b = charSequence;
        }

        @NonNull
        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("Cell{alignment=");
            sbR.append(this.a);
            sbR.append(", text=");
            sbR.append((Object) this.f7819b);
            sbR.append(MessageFormatter.DELIM_STOP);
            return sbR.toString();
        }
    }

    public interface d {
    }

    public TableRowSpan(@NonNull k kVar, @NonNull List<c> list, boolean z, boolean z2) {
        this.a = kVar;
        this.f7806b = list;
        this.f7807c = new ArrayList(list.size());
        this.f7809e = z;
        this.f7810f = z2;
    }

    public final void a(int i2, int i3, @NonNull c cVar) {
        a aVar = new a(i2, i3, cVar);
        CharSequence charSequence = cVar.f7819b;
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(cVar.f7819b);
        TextPaint textPaint = this.f7808d;
        int i4 = cVar.a;
        StaticLayout staticLayout = new StaticLayout(spannableString, textPaint, i3, i4 != 1 ? i4 != 2 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        j[] jVarArr = (j[]) spannableString.getSpans(0, spannableString.length(), j.class);
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                spannableString.removeSpan(jVar);
            }
        }
        spannableString.setSpan(new j(staticLayout), 0, spannableString.length(), 18);
        g[] gVarArr = (g[]) spannableString.getSpans(0, spannableString.length(), g.class);
        if (gVarArr != null && gVarArr.length > 0) {
            for (g gVar : gVarArr) {
                e.b.a.s.a aVar2 = gVar.f6111b;
                if (!aVar2.c()) {
                    aVar2.d(new e.b.a.q.a.g(this, aVar));
                }
            }
        }
        this.f7807c.add(i2, staticLayout);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01cb  */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas r18, java.lang.CharSequence r19, @androidx.annotation.IntRange(from = 0) int r20, @androidx.annotation.IntRange(from = 0) int r21, float r22, int r23, int r24, int r25, @androidx.annotation.NonNull android.graphics.Paint r26) {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.noties.markwon.ext.tables.TableRowSpan.draw(android.graphics.Canvas, java.lang.CharSequence, int, int, float, int, int, int, android.graphics.Paint):void");
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        if (this.f7807c.size() > 0 && fontMetricsInt != null) {
            Iterator<Layout> it = this.f7807c.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                int height = it.next().getHeight();
                if (height > i4) {
                    i4 = height;
                }
            }
            this.f7814j = i4;
            int i5 = -((this.a.a * 2) + i4);
            fontMetricsInt.ascent = i5;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i5;
            fontMetricsInt.bottom = 0;
        }
        return this.f7813i;
    }
}
