package c.e.a.b.p;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: MotionStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public interface l {
    void a();

    @AnimatorRes
    int b();

    void c();

    boolean d();

    void e();

    AnimatorSet f();

    void g(@Nullable ExtendedFloatingActionButton.i iVar);

    void onAnimationStart(Animator animator);
}
