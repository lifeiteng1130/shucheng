package c.e.a.b.e0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: FadeThroughProvider.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements o {

    /* JADX INFO: compiled from: FadeThroughProvider.java */
    public static class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f963d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f964e;

        public a(View view, float f2, float f3, float f4, float f5) {
            this.a = view;
            this.f961b = f2;
            this.f962c = f3;
            this.f963d = f4;
            this.f964e = f5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.setAlpha(n.e(this.f961b, this.f962c, this.f963d, this.f964e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    /* JADX INFO: compiled from: FadeThroughProvider.java */
    public static class b extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f965b;

        public b(View view, float f2) {
            this.a = view;
            this.f965b = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setAlpha(this.f965b);
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
        return c(view, 0.0f, alpha, 0.35f, 1.0f, alpha);
    }

    @Override // c.e.a.b.e0.o
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, alpha, 0.0f, 0.0f, 0.35f, alpha);
    }
}
