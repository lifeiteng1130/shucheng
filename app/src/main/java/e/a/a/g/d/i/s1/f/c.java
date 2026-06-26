package e.a.a.g.d.i.s1.f;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import f.c0.c.j;
import io.legado.app.ui.book.read.page.ReadView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HorizontalPageDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public Bitmap f5754l;

    @Nullable
    public Bitmap m;

    @Nullable
    public Bitmap n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull ReadView readView) {
        super(readView);
        j.e(readView, "readView");
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void k(int i2) {
        v();
        if (h()) {
            s(e.a.a.g.d.i.s1.g.a.NEXT);
            this.a.h(this.f5756c, 0.0f, false);
            l(i2);
        }
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.m = null;
        Bitmap bitmap2 = this.f5754l;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.f5754l = null;
        Bitmap bitmap3 = this.n;
        if (bitmap3 != null) {
            bitmap3.recycle();
        }
        this.n = null;
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void q(@NotNull MotionEvent motionEvent) {
        float x;
        float y;
        j.e(motionEvent, NotificationCompat.CATEGORY_EVENT);
        int action = motionEvent.getAction();
        if (action == 0) {
            v();
            return;
        }
        if (action != 1) {
            if (action == 2) {
                boolean z = (motionEvent.getAction() & 255) == 6;
                int actionIndex = z ? motionEvent.getActionIndex() : -1;
                int pointerCount = motionEvent.getPointerCount();
                if (pointerCount > 0) {
                    int i2 = 0;
                    x = 0.0f;
                    y = 0.0f;
                    while (true) {
                        int i3 = i2 + 1;
                        if (actionIndex != i2) {
                            x += motionEvent.getX(i2);
                            y += motionEvent.getY(i2);
                        }
                        if (i3 >= pointerCount) {
                            break;
                        } else {
                            i2 = i3;
                        }
                    }
                } else {
                    x = 0.0f;
                    y = 0.0f;
                }
                if (z) {
                    pointerCount--;
                }
                float f2 = pointerCount;
                float f3 = x / f2;
                float f4 = y / f2;
                if (!this.f5760g) {
                    int iD = (int) (f3 - d());
                    int iE = (int) (f4 - e());
                    boolean z2 = (iE * iE) + (iD * iD) > this.a.getSlopSquare();
                    this.f5760g = z2;
                    if (z2) {
                        if (x - d() > 0.0f) {
                            if (!i()) {
                                return;
                            } else {
                                s(e.a.a.g.d.i.s1.g.a.PREV);
                            }
                        } else if (!h()) {
                            return;
                        } else {
                            s(e.a.a.g.d.i.s1.g.a.NEXT);
                        }
                    }
                }
                if (this.f5760g) {
                    this.f5762i = this.f5761h != e.a.a.g.d.i.s1.g.a.NEXT ? x < this.a.getLastX() : x > this.a.getLastX();
                    this.f5763j = true;
                    ReadView.i(this.a, x, y, false, 4);
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
        v();
        if (i()) {
            s(e.a.a.g.d.i.s1.g.a.PREV);
            this.a.h(0.0f, 0.0f, false);
            l(i2);
        }
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void s(@NotNull e.a.a.g.d.i.s1.g.a aVar) {
        j.e(aVar, "direction");
        j.e(aVar, "direction");
        this.f5761h = aVar;
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            Bitmap bitmap = this.m;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.m = c.b.a.m.f.Y4(this.a.getPrevPage());
            Bitmap bitmap2 = this.f5754l;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.f5754l = c.b.a.m.f.Y4(a());
            return;
        }
        if (iOrdinal != 2) {
            return;
        }
        Bitmap bitmap3 = this.n;
        if (bitmap3 != null) {
            bitmap3.recycle();
        }
        this.n = c.b.a.m.f.Y4(this.a.getNextPage());
        Bitmap bitmap4 = this.f5754l;
        if (bitmap4 != null) {
            bitmap4.recycle();
        }
        this.f5754l = c.b.a.m.f.Y4(a());
    }

    public void v() {
        this.f5764k = false;
        this.f5760g = false;
        this.f5763j = false;
        if (b().isFinished()) {
            this.a.setAbortAnim(false);
            return;
        }
        this.a.setAbortAnim(true);
        b().abortAnimation();
        if (this.f5762i) {
            return;
        }
        this.a.f(this.f5761h);
        this.a.invalidate();
    }
}
