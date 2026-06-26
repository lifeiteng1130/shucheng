package c.e.a.b.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends AnimatorListenerAdapter {
    public final /* synthetic */ o a;

    public n(o oVar) {
        this.a = oVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        o oVar = this.a;
        oVar.f1173h = (oVar.f1173h + 1) % oVar.f1172g.f1133c.length;
        oVar.f1174i = true;
    }
}
