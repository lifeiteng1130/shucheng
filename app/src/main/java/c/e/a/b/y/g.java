package c.e.a.b.y;

import android.animation.ValueAnimator;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements ValueAnimator.AnimatorUpdateListener {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f1284c;

    public g(BaseTransientBottomBar baseTransientBottomBar, int i2) {
        this.f1284c = baseTransientBottomBar;
        this.f1283b = i2;
        this.a = i2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        Handler handler = BaseTransientBottomBar.a;
        this.f1284c.f2378f.setTranslationY(iIntValue);
        this.a = iIntValue;
    }
}
