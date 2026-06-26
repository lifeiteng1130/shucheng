package e.a.a.g.m.m.b;

import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.ImageView;
import f.c0.c.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Info.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    @NotNull
    public RectF a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public RectF f5926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public RectF f5927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public RectF f5928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public PointF f5929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f5930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public ImageView.ScaleType f5931g;

    public a(@NotNull RectF rectF, @NotNull RectF rectF2, @NotNull RectF rectF3, @NotNull RectF rectF4, @NotNull PointF pointF, float f2, float f3, @Nullable ImageView.ScaleType scaleType) {
        j.e(rectF, "rect");
        j.e(rectF2, "img");
        j.e(rectF3, "widget");
        j.e(rectF4, "base");
        j.e(pointF, "screenCenter");
        this.a = new RectF();
        this.f5926b = new RectF();
        this.f5927c = new RectF();
        this.f5928d = new RectF();
        this.f5929e = new PointF();
        this.a.set(rectF);
        this.f5926b.set(rectF2);
        this.f5927c.set(rectF3);
        this.f5931g = scaleType;
        this.f5930f = f3;
        this.f5928d.set(rectF4);
        this.f5929e.set(pointF);
    }
}
