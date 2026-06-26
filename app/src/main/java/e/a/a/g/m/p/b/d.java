package e.a.a.g.m.p.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import f.c0.c.j;
import io.legado.app.ui.widget.recycler.scroller.FastScroller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FastScroller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ FastScroller a;

    public d(FastScroller fastScroller) {
        this.a = fastScroller;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator animator) {
        j.e(animator, "animation");
        super.onAnimationCancel(animator);
        TextView textView = this.a.mBubbleView;
        if (textView == null) {
            j.m("mBubbleView");
            throw null;
        }
        textView.setVisibility(4);
        this.a.mBubbleAnimator = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animator) {
        j.e(animator, "animation");
        super.onAnimationEnd(animator);
        TextView textView = this.a.mBubbleView;
        if (textView == null) {
            j.m("mBubbleView");
            throw null;
        }
        textView.setVisibility(4);
        this.a.mBubbleAnimator = null;
    }
}
