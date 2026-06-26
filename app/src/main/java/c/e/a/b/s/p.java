package c.e.a.b.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends AnimatorListenerAdapter {
    public final /* synthetic */ q a;

    public p(q qVar) {
        this.a = qVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        q qVar = this.a;
        if (qVar.m) {
            qVar.f1179g.setRepeatCount(-1);
            q qVar2 = this.a;
            qVar2.n.onAnimationEnd(qVar2.a);
            this.a.m = false;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        q qVar = this.a;
        qVar.f1182j = (qVar.f1182j + 1) % qVar.f1181i.f1133c.length;
        qVar.f1183k = true;
    }
}
