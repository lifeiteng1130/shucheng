package e.a.a.g.m.i.d;

import android.animation.Animator;
import f.c0.c.j;
import io.legado.app.ui.widget.anima.explosion_field.ExplosionView;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExplosionView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements Animator.AnimatorListener {
    public final /* synthetic */ ExplosionView a;

    public c(ExplosionView explosionView) {
        this.a = explosionView;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator animator) {
        j.e(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animator) {
        j.e(animator, "animator");
        d dVar = this.a.mZAnimatorListener;
        if (dVar != null) {
            j.c(dVar);
            dVar.a(animator, this.a);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@NotNull Animator animator) {
        j.e(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NotNull Animator animator) {
        j.e(animator, "animator");
        ExplosionView explosionView = this.a;
        int i2 = ExplosionView.a;
        Objects.requireNonNull(explosionView);
    }
}
