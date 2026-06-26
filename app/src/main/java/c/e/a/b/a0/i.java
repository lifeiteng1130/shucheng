package c.e.a.b.a0;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ h a;

    public i(h hVar) {
        this.a = hVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.a.f872c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
