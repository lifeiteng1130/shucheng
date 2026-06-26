package c.e.a.b.e0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: FadeProvider.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements o {
    public float a = 1.0f;

    /* JADX INFO: compiled from: FadeProvider.java */
    public static class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f959e;

        public a(View view, float f2, float f3, float f4, float f5) {
            this.a = view;
            this.f956b = f2;
            this.f957c = f3;
            this.f958d = f4;
            this.f959e = f5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.setAlpha(n.e(this.f956b, this.f957c, this.f958d, this.f959e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    /* JADX INFO: compiled from: FadeProvider.java */
    public static class b extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f960b;

        public b(View view, float f2) {
            this.a = view;
            this.f960b = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setAlpha(this.f960b);
        }
    }

    public static Animator c(View view, float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, float f6) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(view, f2, f3, f4, f5));
        valueAnimatorOfFloat.addListener(new b(view, f6));
        return valueAnimatorOfFloat;
    }

    @Override // c.e.a.b.e0.o
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, 0.0f, alpha, 0.0f, this.a, alpha);
    }

    @Override // c.e.a.b.e0.o
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, alpha, 0.0f, 0.0f, 1.0f, alpha);
    }
}
