package c.e.a.b.e0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ScaleProvider.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements o {
    public float a = 0.8f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f978b = true;

    /* JADX INFO: compiled from: ScaleProvider.java */
    public static class a extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f980c;

        public a(View view, float f2, float f3) {
            this.a = view;
            this.f979b = f2;
            this.f980c = f3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setScaleX(this.f979b);
            this.a.setScaleY(this.f980c);
        }
    }

    public static Animator c(View view, float f2, float f3) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX * f2, scaleX * f3), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f2 * scaleY, f3 * scaleY));
        objectAnimatorOfPropertyValuesHolder.addListener(new a(view, scaleX, scaleY));
        return objectAnimatorOfPropertyValuesHolder;
    }

    @Override // c.e.a.b.e0.o
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return c(view, this.a, 1.0f);
    }

    @Override // c.e.a.b.e0.o
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.f978b) {
            return c(view, 1.0f, 1.1f);
        }
        return null;
    }
}
