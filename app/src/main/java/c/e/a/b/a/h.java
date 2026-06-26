package c.e.a.b.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: MotionTiming.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public TimeInterpolator f848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f850e;

    public h(long j2, long j3) {
        this.a = 0L;
        this.f847b = 300L;
        this.f848c = null;
        this.f849d = 0;
        this.f850e = 1;
        this.a = j2;
        this.f847b = j3;
    }

    public void a(@NonNull Animator animator) {
        animator.setStartDelay(this.a);
        animator.setDuration(this.f847b);
        animator.setInterpolator(b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f849d);
            valueAnimator.setRepeatMode(this.f850e);
        }
    }

    @Nullable
    public TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f848c;
        return timeInterpolator != null ? timeInterpolator : a.f839b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.a == hVar.a && this.f847b == hVar.f847b && this.f849d == hVar.f849d && this.f850e == hVar.f850e) {
            return b().getClass().equals(hVar.b().getClass());
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.f847b;
        return ((((b().getClass().hashCode() + (((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31) + this.f849d) * 31) + this.f850e;
    }

    @NonNull
    public String toString() {
        StringBuilder sbQ = c.a.a.a.a.q('\n');
        sbQ.append(h.class.getName());
        sbQ.append(MessageFormatter.DELIM_START);
        sbQ.append(Integer.toHexString(System.identityHashCode(this)));
        sbQ.append(" delay: ");
        sbQ.append(this.a);
        sbQ.append(" duration: ");
        sbQ.append(this.f847b);
        sbQ.append(" interpolator: ");
        sbQ.append(b().getClass());
        sbQ.append(" repeatCount: ");
        sbQ.append(this.f849d);
        sbQ.append(" repeatMode: ");
        return c.a.a.a.a.o(sbQ, this.f850e, "}\n");
    }

    public h(long j2, long j3, @NonNull TimeInterpolator timeInterpolator) {
        this.a = 0L;
        this.f847b = 300L;
        this.f848c = null;
        this.f849d = 0;
        this.f850e = 1;
        this.a = j2;
        this.f847b = j3;
        this.f848c = timeInterpolator;
    }
}
