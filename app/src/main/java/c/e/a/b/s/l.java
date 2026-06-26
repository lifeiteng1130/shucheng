package c.e.a.b.s;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.IndeterminateDrawable;

/* JADX INFO: compiled from: IndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l<T extends Animator> {
    public IndeterminateDrawable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f1164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f1165c;

    public l(int i2) {
        this.f1164b = new float[i2 * 2];
        this.f1165c = new int[i2];
    }

    public abstract void a();

    public float b(int i2, int i3, int i4) {
        return (i2 - i3) / i4;
    }

    public abstract void c();

    public abstract void d(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    public abstract void e();

    public abstract void f();

    public abstract void g();
}
