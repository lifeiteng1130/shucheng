package c.e.a.b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: compiled from: StateListAnimator.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class c {
    public final ArrayList<b> a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public b f1105b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ValueAnimator f1106c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Animator.AnimatorListener f1107d = new a();

    /* JADX INFO: compiled from: StateListAnimator.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c cVar = c.this;
            if (cVar.f1106c == animator) {
                cVar.f1106c = null;
            }
        }
    }

    /* JADX INFO: compiled from: StateListAnimator.java */
    public static class b {
        public final int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ValueAnimator f1108b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.a = iArr;
            this.f1108b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f1107d);
        this.a.add(bVar);
    }
}
