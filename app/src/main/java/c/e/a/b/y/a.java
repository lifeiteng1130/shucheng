package c.e.a.b.y;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.Objects;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {
    public final /* synthetic */ BaseTransientBottomBar a;

    public a(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout = this.a.f2378f;
        if (snackbarBaseLayout == null) {
            return;
        }
        if (snackbarBaseLayout.getParent() != null) {
            this.a.f2378f.setVisibility(0);
        }
        if (this.a.f2378f.getAnimationMode() != 1) {
            BaseTransientBottomBar baseTransientBottomBar = this.a;
            int iC = baseTransientBottomBar.c();
            baseTransientBottomBar.f2378f.setTranslationY(iC);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(iC, 0);
            valueAnimator.setInterpolator(c.e.a.b.a.a.f839b);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new f(baseTransientBottomBar));
            valueAnimator.addUpdateListener(new g(baseTransientBottomBar, iC));
            valueAnimator.start();
            return;
        }
        BaseTransientBottomBar baseTransientBottomBar2 = this.a;
        Objects.requireNonNull(baseTransientBottomBar2);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(c.e.a.b.a.a.a);
        valueAnimatorOfFloat.addUpdateListener(new d(baseTransientBottomBar2));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(c.e.a.b.a.a.f841d);
        valueAnimatorOfFloat2.addUpdateListener(new e(baseTransientBottomBar2));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new b(baseTransientBottomBar2));
        animatorSet.start();
    }
}
