package c.e.a.b.c0;

import android.view.ViewTreeObserver;
import com.google.android.material.timepicker.ClockFaceView;
import com.google.android.material.timepicker.ClockHandView;

/* JADX INFO: compiled from: ClockFaceView.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ClockFaceView a;

    public b(ClockFaceView clockFaceView) {
        this.a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (!this.a.isShown()) {
            return true;
        }
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = this.a.getHeight() / 2;
        ClockFaceView clockFaceView = this.a;
        int i2 = (height - clockFaceView.f2464d.f2480i) - clockFaceView.f2471k;
        if (i2 != clockFaceView.f918b) {
            clockFaceView.f918b = i2;
            clockFaceView.b();
            ClockHandView clockHandView = clockFaceView.f2464d;
            clockHandView.r = clockFaceView.f918b;
            clockHandView.invalidate();
        }
        return true;
    }
}
