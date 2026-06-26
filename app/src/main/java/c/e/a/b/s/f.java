package c.e.a.b.s;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends l<ObjectAnimator> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1141d = {0, 1350, 2700, 4050};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f1142e = {667, 2017, 3367, 4717};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f1143f = {1000, 2350, 3700, 5050};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Property<f, Float> f1144g = new a(Float.class, "animationFraction");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Property<f, Float> f1145h = new b(Float.class, "completeEndFraction");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ObjectAnimator f1146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ObjectAnimator f1147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FastOutSlowInInterpolator f1148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c.e.a.b.s.b f1149l;
    public int m;
    public float n;
    public float o;
    public Animatable2Compat.AnimationCallback p;

    /* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
    public static class a extends Property<f, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(f fVar) {
            return Float.valueOf(fVar.n);
        }

        @Override // android.util.Property
        public void set(f fVar, Float f2) {
            f fVar2 = fVar;
            float fFloatValue = f2.floatValue();
            fVar2.n = fFloatValue;
            int i2 = (int) (5400.0f * fFloatValue);
            float[] fArr = fVar2.f1164b;
            float f3 = fFloatValue * 1520.0f;
            fArr[0] = (-20.0f) + f3;
            fArr[1] = f3;
            for (int i3 = 0; i3 < 4; i3++) {
                float fB = fVar2.b(i2, f.f1141d[i3], 667);
                float[] fArr2 = fVar2.f1164b;
                fArr2[1] = (fVar2.f1148k.getInterpolation(fB) * 250.0f) + fArr2[1];
                float fB2 = fVar2.b(i2, f.f1142e[i3], 667);
                float[] fArr3 = fVar2.f1164b;
                fArr3[0] = (fVar2.f1148k.getInterpolation(fB2) * 250.0f) + fArr3[0];
            }
            float[] fArr4 = fVar2.f1164b;
            fArr4[0] = ((fArr4[1] - fArr4[0]) * fVar2.o) + fArr4[0];
            fArr4[0] = fArr4[0] / 360.0f;
            fArr4[1] = fArr4[1] / 360.0f;
            int i4 = 0;
            while (true) {
                if (i4 >= 4) {
                    break;
                }
                float fB3 = fVar2.b(i2, f.f1143f[i4], 333);
                if (fB3 >= 0.0f && fB3 <= 1.0f) {
                    int i5 = i4 + fVar2.m;
                    int[] iArr = fVar2.f1149l.f1133c;
                    int length = i5 % iArr.length;
                    int length2 = (length + 1) % iArr.length;
                    int iW0 = c.b.a.m.f.W0(iArr[length], fVar2.a.f1162k);
                    int iW02 = c.b.a.m.f.W0(fVar2.f1149l.f1133c[length2], fVar2.a.f1162k);
                    fVar2.f1165c[0] = c.e.a.b.a.b.a.evaluate(fVar2.f1148k.getInterpolation(fB3), Integer.valueOf(iW0), Integer.valueOf(iW02)).intValue();
                    break;
                }
                i4++;
            }
            fVar2.a.invalidateSelf();
        }
    }

    /* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
    public static class b extends Property<f, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(f fVar) {
            return Float.valueOf(fVar.o);
        }

        @Override // android.util.Property
        public void set(f fVar, Float f2) {
            fVar.o = f2.floatValue();
        }
    }

    public f(@NonNull g gVar) {
        super(1);
        this.m = 0;
        this.p = null;
        this.f1149l = gVar;
        this.f1148k = new FastOutSlowInInterpolator();
    }

    @Override // c.e.a.b.s.l
    public void a() {
        ObjectAnimator objectAnimator = this.f1146i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // c.e.a.b.s.l
    public void c() {
        h();
    }

    @Override // c.e.a.b.s.l
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.p = animationCallback;
    }

    @Override // c.e.a.b.s.l
    public void e() {
        if (this.f1147j.isRunning()) {
            return;
        }
        if (this.a.isVisible()) {
            this.f1147j.start();
        } else {
            a();
        }
    }

    @Override // c.e.a.b.s.l
    public void f() {
        if (this.f1146i == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f1144g, 0.0f, 1.0f);
            this.f1146i = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.f1146i.setInterpolator(null);
            this.f1146i.setRepeatCount(-1);
            this.f1146i.addListener(new d(this));
        }
        if (this.f1147j == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f1145h, 0.0f, 1.0f);
            this.f1147j = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.f1147j.setInterpolator(this.f1148k);
            this.f1147j.addListener(new e(this));
        }
        h();
        this.f1146i.start();
    }

    @Override // c.e.a.b.s.l
    public void g() {
        this.p = null;
    }

    @VisibleForTesting
    public void h() {
        this.m = 0;
        this.f1165c[0] = c.b.a.m.f.W0(this.f1149l.f1133c[0], this.a.f1162k);
        this.o = 0.0f;
    }
}
