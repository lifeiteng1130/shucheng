package e.a.a.g.m.i.d;

import android.animation.ValueAnimator;
import android.view.View;
import f.c0.c.j;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExplosionView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    @NotNull
    public Random a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f5920b;

    public b(View view) {
        this.f5920b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NotNull ValueAnimator valueAnimator) {
        j.e(valueAnimator, "animation");
        this.f5920b.setTranslationX((this.a.nextFloat() - 0.5f) * this.f5920b.getWidth() * 0.05f);
        this.f5920b.setTranslationY((this.a.nextFloat() - 0.5f) * this.f5920b.getHeight() * 0.05f);
    }
}
