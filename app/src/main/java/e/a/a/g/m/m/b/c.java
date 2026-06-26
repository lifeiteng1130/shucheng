package e.a.a.g.m.m.b;

import android.view.MotionEvent;
import f.c0.c.j;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RotateGestureDetector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    @NotNull
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f5933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f5934d;

    public c(@NotNull b bVar) {
        j.e(bVar, "mListener");
        this.a = bVar;
        this.f5932b = 120;
    }

    public final float a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0);
        return (motionEvent.getY(1) - motionEvent.getY(0)) / (motionEvent.getX(1) - x);
    }
}
