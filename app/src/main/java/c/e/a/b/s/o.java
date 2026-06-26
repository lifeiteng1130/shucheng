package c.e.a.b.s;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.Arrays;

/* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public final class o extends l<ObjectAnimator> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Property<o, Float> f1169d = new a(Float.class, "animationFraction");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObjectAnimator f1170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FastOutSlowInInterpolator f1171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f1172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1175j;

    /* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
    public static class a extends Property<o, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(o oVar) {
            return Float.valueOf(oVar.f1175j);
        }

        @Override // android.util.Property
        public void set(o oVar, Float f2) {
            o oVar2 = oVar;
            float fFloatValue = f2.floatValue();
            oVar2.f1175j = fFloatValue;
            oVar2.f1164b[0] = 0.0f;
            float fB = oVar2.b((int) (fFloatValue * 333.0f), 0, 667);
            float[] fArr = oVar2.f1164b;
            float interpolation = oVar2.f1171f.getInterpolation(fB);
            fArr[2] = interpolation;
            fArr[1] = interpolation;
            float[] fArr2 = oVar2.f1164b;
            float interpolation2 = oVar2.f1171f.getInterpolation(fB + 0.49925038f);
            fArr2[4] = interpolation2;
            fArr2[3] = interpolation2;
            float[] fArr3 = oVar2.f1164b;
            fArr3[5] = 1.0f;
            if (oVar2.f1174i && fArr3[3] < 1.0f) {
                int[] iArr = oVar2.f1165c;
                iArr[2] = iArr[1];
                iArr[1] = iArr[0];
                iArr[0] = c.b.a.m.f.W0(oVar2.f1172g.f1133c[oVar2.f1173h], oVar2.a.f1162k);
                oVar2.f1174i = false;
            }
            oVar2.a.invalidateSelf();
        }
    }

    public o(@NonNull r rVar) {
        super(3);
        this.f1173h = 1;
        this.f1172g = rVar;
        this.f1171f = new FastOutSlowInInterpolator();
    }

    @Override // c.e.a.b.s.l
    public void a() {
        ObjectAnimator objectAnimator = this.f1170e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // c.e.a.b.s.l
    public void c() {
        h();
    }

    @Override // c.e.a.b.s.l
    public void d(@Nullable Animatable2Compat.AnimationCallback animationCallback) {
    }

    @Override // c.e.a.b.s.l
    public void e() {
    }

    @Override // c.e.a.b.s.l
    public void f() {
        if (this.f1170e == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f1169d, 0.0f, 1.0f);
            this.f1170e = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.f1170e.setInterpolator(null);
            this.f1170e.setRepeatCount(-1);
            this.f1170e.addListener(new n(this));
        }
        h();
        this.f1170e.start();
    }

    @Override // c.e.a.b.s.l
    public void g() {
    }

    @VisibleForTesting
    public void h() {
        this.f1174i = true;
        this.f1173h = 1;
        Arrays.fill(this.f1165c, c.b.a.m.f.W0(this.f1172g.f1133c[0], this.a.f1162k));
    }
}
