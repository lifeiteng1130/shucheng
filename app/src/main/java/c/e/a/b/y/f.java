package c.e.a.b.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseTransientBottomBar a;

    public f(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.e();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) this.a.f2379g;
        snackbarContentLayout.a.setAlpha(0.0f);
        long j2 = 180;
        long j3 = 70;
        snackbarContentLayout.a.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        if (snackbarContentLayout.f2394b.getVisibility() == 0) {
            snackbarContentLayout.f2394b.setAlpha(0.0f);
            snackbarContentLayout.f2394b.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }
}
