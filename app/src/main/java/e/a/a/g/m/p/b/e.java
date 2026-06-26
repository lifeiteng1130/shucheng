package e.a.a.g.m.p.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import f.c0.c.j;
import io.legado.app.ui.widget.recycler.scroller.FastScroller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FastScroller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ FastScroller a;

    public e(FastScroller fastScroller) {
        this.a = fastScroller;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator animator) {
        j.e(animator, "animation");
        super.onAnimationCancel(animator);
        View view = this.a.mScrollbar;
        if (view == null) {
            j.m("mScrollbar");
            throw null;
        }
        view.setVisibility(4);
        this.a.mScrollbarAnimator = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animator) {
        j.e(animator, "animation");
        super.onAnimationEnd(animator);
        View view = this.a.mScrollbar;
        if (view == null) {
            j.m("mScrollbar");
            throw null;
        }
        view.setVisibility(4);
        this.a.mScrollbarAnimator = null;
    }
}
