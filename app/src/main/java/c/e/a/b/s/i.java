package c.e.a.b.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends AnimatorListenerAdapter {
    public final /* synthetic */ j a;

    public i(j jVar) {
        this.a = jVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        super/*android.graphics.drawable.Drawable*/.setVisible(false, false);
        j jVar = this.a;
        List<Animatable2Compat.AnimationCallback> list = jVar.f1158g;
        if (list == null || jVar.f1159h) {
            return;
        }
        Iterator<Animatable2Compat.AnimationCallback> it = list.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(jVar);
        }
    }
}
