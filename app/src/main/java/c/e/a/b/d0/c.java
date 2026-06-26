package c.e.a.b.d0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.e.a.b.k.b;
import com.google.android.material.transformation.FabTransformationBehavior;

/* JADX INFO: compiled from: FabTransformationBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ c.e.a.b.k.b a;

    public c(FabTransformationBehavior fabTransformationBehavior, c.e.a.b.k.b bVar) {
        this.a = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        b.e revealInfo = this.a.getRevealInfo();
        revealInfo.f1006c = Float.MAX_VALUE;
        this.a.setRevealInfo(revealInfo);
    }
}
