package e.a.a.g.d.i.s1.f;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.app.NotificationCompat;
import f.c0.c.j;
import io.legado.app.ui.book.read.page.PageView;
import io.legado.app.ui.book.read.page.ReadView;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ScrollPageDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f5765l;

    @NotNull
    public final VelocityTracker m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull ReadView readView) {
        super(readView);
        j.e(readView, "readView");
        this.f5765l = 1000;
        VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
        j.d(velocityTrackerObtain, "obtain()");
        this.m = velocityTrackerObtain;
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void k(int i2) {
        ReadView readView = this.a;
        if (readView.isAbortAnim) {
            return;
        }
        readView.h(0.0f, 0.0f, false);
        e.a.a.g.d.i.s1.h.a aVar = e.a.a.g.d.i.s1.h.a.a;
        u(0, 0, 0, -e.a.a.g.d.i.s1.h.a.f5793g, i2);
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void l(int i2) {
        int iG = (int) g();
        int yVelocity = (int) this.m.getYVelocity();
        int i3 = this.f5757d;
        b().fling(0, iG, 0, yVelocity, 0, 0, i3 * (-10), i3 * 10);
        this.f5763j = true;
        this.f5764k = true;
        this.a.invalidate();
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void m() {
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void n() {
        this.m.recycle();
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void o(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void p() {
        PageView pageViewA = a();
        pageViewA.binding.f6870f.d((int) (g() - this.a.getLastY()));
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void q(@NotNull MotionEvent motionEvent) {
        j.e(motionEvent, NotificationCompat.CATEGORY_EVENT);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5764k = false;
            this.f5760g = false;
            this.f5763j = false;
            if (b().isFinished()) {
                this.a.setAbortAnim(false);
            } else {
                this.a.setAbortAnim(true);
                b().abortAnimation();
            }
            this.m.clear();
            return;
        }
        if (action != 1) {
            if (action == 2) {
                this.m.addMovement(motionEvent);
                this.m.computeCurrentVelocity(this.f5765l);
                boolean z = (motionEvent.getAction() & 255) == 6;
                int actionIndex = z ? motionEvent.getActionIndex() : -1;
                int pointerCount = motionEvent.getPointerCount();
                float f2 = 0.0f;
                float y = 0.0f;
                if (pointerCount > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        if (actionIndex != i2) {
                            float x = motionEvent.getX(i2) + f2;
                            y = motionEvent.getY(i2) + y;
                            f2 = x;
                        }
                        if (i3 >= pointerCount) {
                            break;
                        } else {
                            i2 = i3;
                        }
                    }
                }
                if (z) {
                    pointerCount--;
                }
                float f3 = pointerCount;
                float f4 = f2 / f3;
                float f5 = y / f3;
                ReadView.i(this.a, f2, y, false, 4);
                if (!this.f5760g) {
                    int iD = (int) (f4 - d());
                    int iE = (int) (f5 - e());
                    this.f5760g = (iE * iE) + (iD * iD) > this.a.getSlopSquare();
                }
                if (this.f5760g) {
                    this.f5763j = true;
                    return;
                }
                return;
            }
            if (action != 3) {
                return;
            }
        }
        l(this.a.getDefaultAnimationSpeed());
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void r(int i2) {
        ReadView readView = this.a;
        if (readView.isAbortAnim) {
            return;
        }
        readView.h(0.0f, 0.0f, false);
        e.a.a.g.d.i.s1.h.a aVar = e.a.a.g.d.i.s1.h.a.a;
        u(0, 0, 0, e.a.a.g.d.i.s1.h.a.f5793g, i2);
    }
}
