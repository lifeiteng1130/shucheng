package e.a.a.g.m.i.d;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import f.c0.c.j;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExplosionAnimator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends ValueAnimator {

    @NotNull
    public static final a a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final AccelerateInterpolator f5900b = new AccelerateInterpolator(0.6f);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f5901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f5902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f5903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f5904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final View f5905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final Paint f5906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final C0164a[] f5907i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final Rect f5908j;

    /* JADX INFO: renamed from: e.a.a.g.m.i.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExplosionAnimator.kt */
    public final class C0164a {
        public float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f5910c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f5911d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f5912e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f5913f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f5914g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f5915h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f5916i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f5917j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f5918k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f5919l;
        public float m;
        public float n;

        public C0164a(a aVar) {
            j.e(aVar, "this$0");
        }
    }

    static {
        e eVar = e.a;
        f5901c = e.c(5);
        f5902d = e.c(20);
        f5903e = e.c(2);
        f5904f = e.c(1);
    }

    public a(@NotNull View view, @NotNull Bitmap bitmap, @NotNull Rect rect) {
        j.e(view, "mContainer");
        j.e(bitmap, "bitmap");
        j.e(rect, "bound");
        this.f5905g = view;
        this.f5906h = new Paint();
        this.f5908j = new Rect(rect);
        this.f5907i = new C0164a[225];
        Random random = new Random(System.currentTimeMillis());
        int width = bitmap.getWidth() / 17;
        int height = bitmap.getHeight() / 17;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                C0164a[] c0164aArr = this.f5907i;
                int i6 = (i2 * 15) + i4;
                int pixel = bitmap.getPixel(i5 * width, i3 * height);
                C0164a c0164a = new C0164a(this);
                c0164a.f5909b = pixel;
                float f2 = f5903e;
                c0164a.f5912e = f2;
                if (random.nextFloat() < 0.2f) {
                    c0164a.f5915h = (random.nextFloat() * (f5901c - f2)) + f2;
                } else {
                    float f3 = f5904f;
                    c0164a.f5915h = (random.nextFloat() * (f2 - f3)) + f3;
                }
                float fNextFloat = random.nextFloat();
                float fHeight = this.f5908j.height() * ((random.nextFloat() * 0.18f) + 0.2f);
                c0164a.f5916i = fHeight;
                c0164a.f5916i = fNextFloat >= 0.2f ? (random.nextFloat() * 0.2f * fHeight) + fHeight : fHeight;
                float fNextFloat2 = (random.nextFloat() - 0.5f) * this.f5908j.height() * 1.8f;
                c0164a.f5917j = fNextFloat2;
                if (fNextFloat >= 0.2f) {
                    fNextFloat2 *= fNextFloat < 0.8f ? 0.6f : 0.3f;
                }
                c0164a.f5917j = fNextFloat2;
                float f4 = (c0164a.f5916i * 4.0f) / fNextFloat2;
                c0164a.f5918k = f4;
                c0164a.f5919l = (-f4) / fNextFloat2;
                float fCenterX = this.f5908j.centerX();
                float f5 = f5902d;
                float fNextFloat3 = ((random.nextFloat() - 0.5f) * f5) + fCenterX;
                c0164a.f5913f = fNextFloat3;
                c0164a.f5910c = fNextFloat3;
                float fNextFloat4 = ((random.nextFloat() - 0.5f) * f5) + this.f5908j.centerY();
                c0164a.f5914g = fNextFloat4;
                c0164a.f5911d = fNextFloat4;
                c0164a.m = random.nextFloat() * 0.14f;
                c0164a.n = random.nextFloat() * 0.4f;
                c0164a.a = 1.0f;
                c0164aArr[i6] = c0164a;
                if (i5 >= 15) {
                    break;
                } else {
                    i4 = i5;
                }
            }
            if (i3 >= 15) {
                setFloatValues(0.0f, 1.4f);
                setInterpolator(f5900b);
                setDuration(1024L);
                return;
            }
            i2 = i3;
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void start() {
        super.start();
        this.f5905g.invalidate();
    }
}
