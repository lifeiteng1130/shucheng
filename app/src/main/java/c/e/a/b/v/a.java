package c.e.a.b.v;

import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ShadowRenderer.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public static final int[] a = new int[3];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f1214b = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1215c = new int[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[] f1216d = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final Paint f1218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final Paint f1219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f1223k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f1224l = new Paint();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final Paint f1217e = new Paint();

    public a() {
        a(ViewCompat.MEASURED_STATE_MASK);
        this.f1224l.setColor(0);
        Paint paint = new Paint(4);
        this.f1218f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1219g = new Paint(paint);
    }

    public void a(int i2) {
        this.f1220h = ColorUtils.setAlphaComponent(i2, 68);
        this.f1221i = ColorUtils.setAlphaComponent(i2, 20);
        this.f1222j = ColorUtils.setAlphaComponent(i2, 0);
        this.f1217e.setColor(this.f1220h);
    }
}
