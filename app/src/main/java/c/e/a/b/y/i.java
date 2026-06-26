package c.e.a.b.y;

import android.animation.ValueAnimator;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements ValueAnimator.AnimatorUpdateListener {
    public int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f1286b;

    public i(BaseTransientBottomBar baseTransientBottomBar) {
        this.f1286b = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        Handler handler = BaseTransientBottomBar.a;
        this.f1286b.f2378f.setTranslationY(iIntValue);
        this.a = iIntValue;
    }
}
