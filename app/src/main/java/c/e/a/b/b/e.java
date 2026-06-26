package c.e.a.b.b;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* JADX INFO: compiled from: CollapsingToolbarLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CollapsingToolbarLayout a;

    public e(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.a = collapsingToolbarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.a.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
