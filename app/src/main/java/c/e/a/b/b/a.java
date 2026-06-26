package c.e.a.b.b;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: compiled from: AppBarLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MaterialShapeDrawable a;

    public a(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable) {
        this.a = materialShapeDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.a.p(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
