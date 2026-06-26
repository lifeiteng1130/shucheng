package c.e.a.b.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public d(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a.t.onAnimationStart(animator);
        FloatingActionButton floatingActionButtonH = this.a.h();
        if (floatingActionButtonH != null) {
            floatingActionButtonH.setTranslationX(this.a.getFabTranslationX());
        }
    }
}
