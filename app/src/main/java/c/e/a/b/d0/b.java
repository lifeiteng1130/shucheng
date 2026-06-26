package c.e.a.b.d0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.google.android.material.transformation.FabTransformationBehavior;

/* JADX INFO: compiled from: FabTransformationBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends AnimatorListenerAdapter {
    public final /* synthetic */ c.e.a.b.k.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Drawable f939b;

    public b(FabTransformationBehavior fabTransformationBehavior, c.e.a.b.k.b bVar, Drawable drawable) {
        this.a = bVar;
        this.f939b = drawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.setCircularRevealOverlayDrawable(null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a.setCircularRevealOverlayDrawable(this.f939b);
    }
}
