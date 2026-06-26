package c.e.a.b.q;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class d {
    public static boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static Constructor<StaticLayout> f1109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public static Object f1110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f1111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextPaint f1112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1114g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1118k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Layout.Alignment f1115h = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1116i = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1117j = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public TextUtils.TruncateAt f1119l = null;

    /* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
    public static class a extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public a(Throwable th) {
            StringBuilder sbR = c.a.a.a.a.r("Error thrown initializing StaticLayout ");
            sbR.append(th.getMessage());
            super(sbR.toString(), th);
        }
    }

    public d(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f1111d = charSequence;
        this.f1112e = textPaint;
        this.f1113f = i2;
        this.f1114g = charSequence.length();
    }

    public StaticLayout a() throws a {
        if (this.f1111d == null) {
            this.f1111d = "";
        }
        int iMax = Math.max(0, this.f1113f);
        CharSequence charSequenceEllipsize = this.f1111d;
        if (this.f1116i == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f1112e, iMax, this.f1119l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f1114g);
        this.f1114g = iMin;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            if (this.f1118k) {
                this.f1115h = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, this.f1112e, iMax);
            builderObtain.setAlignment(this.f1115h);
            builderObtain.setIncludePad(this.f1117j);
            builderObtain.setTextDirection(this.f1118k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f1119l;
            if (truncateAt != null) {
                builderObtain.setEllipsize(truncateAt);
            }
            builderObtain.setMaxLines(this.f1116i);
            return builderObtain.build();
        }
        if (!a) {
            try {
                f1110c = this.f1118k && i2 >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                f1109b = declaredConstructor;
                declaredConstructor.setAccessible(true);
                a = true;
            } catch (Exception e2) {
                throw new a(e2);
            }
        }
        try {
            return (StaticLayout) ((Constructor) Preconditions.checkNotNull(f1109b)).newInstance(charSequenceEllipsize, 0, Integer.valueOf(this.f1114g), this.f1112e, Integer.valueOf(iMax), this.f1115h, Preconditions.checkNotNull(f1110c), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f1117j), null, Integer.valueOf(iMax), Integer.valueOf(this.f1116i));
        } catch (Exception e3) {
            throw new a(e3);
        }
    }
}
