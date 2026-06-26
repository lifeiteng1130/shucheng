package c.e.a.b.s;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import c.e.a.b.s.b;

/* JADX INFO: compiled from: DrawingDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class k<S extends b> {
    public S a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f1163b;

    public k(S s) {
        this.a = s;
    }

    public abstract void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f2);

    public abstract void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @ColorInt int i2);

    public abstract void c(@NonNull Canvas canvas, @NonNull Paint paint);

    public abstract int d();

    public abstract int e();
}
