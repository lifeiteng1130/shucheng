package c.e.a.b.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f1282b;

    public c(BaseTransientBottomBar baseTransientBottomBar, int i2) {
        this.f1282b = baseTransientBottomBar;
        this.a = i2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1282b.d(this.a);
    }
}
