package e.a.a.g.m.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import f.c0.c.j;
import io.legado.app.ui.widget.anima.RotateLoading;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RotateLoading.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ RotateLoading a;

    public c(RotateLoading rotateLoading) {
        this.a = rotateLoading;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NotNull Animator animator) {
        j.e(animator, "animation");
        this.a.setVisibility(0);
    }
}
