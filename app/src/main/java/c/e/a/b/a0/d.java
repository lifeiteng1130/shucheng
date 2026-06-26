package c.e.a.b.a0;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;

    public d(a aVar) {
        this.a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.a.f872c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
