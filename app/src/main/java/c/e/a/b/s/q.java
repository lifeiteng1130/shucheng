package c.e.a.b.s;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R$animator;
import java.util.Arrays;

/* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public final class q extends l<ObjectAnimator> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1176d = {533, 567, 850, 750};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f1177e = {1267, 1000, 333, 0};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Property<q, Float> f1178f = new a(Float.class, "animationFraction");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ObjectAnimator f1179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Interpolator[] f1180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f1181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f1184l;
    public boolean m;
    public Animatable2Compat.AnimationCallback n;

    /* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
    public static class a extends Property<q, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(q qVar) {
            return Float.valueOf(qVar.f1184l);
        }

        @Override // android.util.Property
        public void set(q qVar, Float f2) {
            q qVar2 = qVar;
            float fFloatValue = f2.floatValue();
            qVar2.f1184l = fFloatValue;
            int i2 = (int) (fFloatValue * 1800.0f);
            for (int i3 = 0; i3 < 4; i3++) {
                qVar2.f1164b[i3] = Math.max(0.0f, Math.min(1.0f, qVar2.f1180h[i3].getInterpolation(qVar2.b(i2, q.f1177e[i3], q.f1176d[i3]))));
            }
            if (qVar2.f1183k) {
                Arrays.fill(qVar2.f1165c, c.b.a.m.f.W0(qVar2.f1181i.f1133c[qVar2.f1182j], qVar2.a.f1162k));
                qVar2.f1183k = false;
            }
            qVar2.a.invalidateSelf();
        }
    }

    public q(@NonNull Context context, @NonNull r rVar) {
        super(2);
        this.f1182j = 0;
        this.n = null;
        this.f1181i = rVar;
        this.f1180h = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line2_tail_interpolator)};
    }

    @Override // c.e.a.b.s.l
    public void a() {
        ObjectAnimator objectAnimator = this.f1179g;
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
        this.n = animationCallback;
    }

    @Override // c.e.a.b.s.l
    public void e() {
        if (this.a.isVisible()) {
            this.m = true;
            this.f1179g.setRepeatCount(0);
        } else {
            ObjectAnimator objectAnimator = this.f1179g;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
    }

    @Override // c.e.a.b.s.l
    public void f() {
        if (this.f1179g == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f1178f, 0.0f, 1.0f);
            this.f1179g = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.f1179g.setInterpolator(null);
            this.f1179g.setRepeatCount(-1);
            this.f1179g.addListener(new p(this));
        }
        h();
        this.f1179g.start();
    }

    @Override // c.e.a.b.s.l
    public void g() {
        this.n = null;
    }

    @VisibleForTesting
    public void h() {
        this.f1182j = 0;
        int iW0 = c.b.a.m.f.W0(this.f1181i.f1133c[0], this.a.f1162k);
        int[] iArr = this.f1165c;
        iArr[0] = iW0;
        iArr[1] = iW0;
    }
}
