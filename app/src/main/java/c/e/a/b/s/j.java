package c.e.a.b.s;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j extends Drawable implements Animatable2Compat {
    public static final Property<j, Float> a = new a(Float.class, "growFraction");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f1154c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f1156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f1157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<Animatable2Compat.AnimationCallback> f1158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f1160i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1162k;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f1161j = new Paint();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.e.a.b.s.a f1155d = new c.e.a.b.s.a();

    /* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
    public static class a extends Property<j, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(j jVar) {
            return Float.valueOf(jVar.c());
        }

        @Override // android.util.Property
        public void set(j jVar, Float f2) {
            j jVar2 = jVar;
            float fFloatValue = f2.floatValue();
            if (jVar2.f1160i != fFloatValue) {
                jVar2.f1160i = fFloatValue;
                jVar2.invalidateSelf();
            }
        }
    }

    public j(@NonNull Context context, @NonNull b bVar) {
        this.f1153b = context;
        this.f1154c = bVar;
        setAlpha(255);
    }

    public final void b(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z = this.f1159h;
        this.f1159h = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f1159h = z;
    }

    public float c() {
        b bVar = this.f1154c;
        if (!(bVar.f1135e != 0)) {
            if (!(bVar.f1136f != 0)) {
                return 1.0f;
            }
        }
        return this.f1160i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.f1158g.clear();
        this.f1158g = null;
    }

    public boolean d() {
        return g(false, false, false);
    }

    public boolean e() {
        ValueAnimator valueAnimator = this.f1157f;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean f() {
        ValueAnimator valueAnimator = this.f1156e;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean g(boolean z, boolean z2, boolean z3) {
        return h(z, z2, z3 && this.f1155d.a(this.f1153b.getContentResolver()) > 0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1162k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h(boolean z, boolean z2, boolean z3) {
        if (this.f1156e == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, a, 0.0f, 1.0f);
            this.f1156e = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.f1156e.setInterpolator(c.e.a.b.a.a.f839b);
            ValueAnimator valueAnimator = this.f1156e;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
            this.f1156e = valueAnimator;
            valueAnimator.addListener(new h(this));
        }
        if (this.f1157f == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, a, 1.0f, 0.0f);
            this.f1157f = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.f1157f.setInterpolator(c.e.a.b.a.a.f839b);
            ValueAnimator valueAnimator2 = this.f1157f;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
            this.f1157f = valueAnimator2;
            valueAnimator2.addListener(new i(this));
        }
        if (!isVisible() && !z) {
            return false;
        }
        ValueAnimator valueAnimator3 = z ? this.f1156e : this.f1157f;
        if (!z3) {
            if (valueAnimator3.isRunning()) {
                valueAnimator3.end();
            } else {
                b(valueAnimator3);
            }
            return super.setVisible(z, false);
        }
        if (z3 && valueAnimator3.isRunning()) {
            return false;
        }
        boolean z4 = !z || super.setVisible(z, false);
        if (!(!z ? this.f1154c.f1136f == 0 : this.f1154c.f1135e == 0)) {
            b(valueAnimator3);
            return z4;
        }
        if (z2 || !valueAnimator3.isPaused()) {
            valueAnimator3.start();
        } else {
            valueAnimator3.resume();
        }
        return z4;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return f() || e();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (this.f1158g == null) {
            this.f1158g = new ArrayList();
        }
        if (this.f1158g.contains(animationCallback)) {
            return;
        }
        this.f1158g.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1162k = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f1161j.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return g(z, z2, true);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        h(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        h(false, true, false);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f1158g;
        if (list == null || !list.contains(animationCallback)) {
            return false;
        }
        this.f1158g.remove(animationCallback);
        if (!this.f1158g.isEmpty()) {
            return true;
        }
        this.f1158g = null;
        return true;
    }
}
