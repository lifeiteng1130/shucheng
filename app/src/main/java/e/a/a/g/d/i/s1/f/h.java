package e.a.a.g.d.i.s1.f;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import f.c0.c.j;
import io.legado.app.ui.book.read.page.ReadView;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SlidePageDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends c {

    @NotNull
    public final Matrix o;

    /* JADX INFO: compiled from: SlidePageDelegate.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            e.a.a.g.d.i.s1.g.a.valuesCustom();
            int[] iArr = new int[3];
            iArr[e.a.a.g.d.i.s1.g.a.NEXT.ordinal()] = 1;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull ReadView readView) {
        super(readView);
        j.e(readView, "readView");
        this.o = new Matrix();
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void l(int i2) {
        float f2;
        float f3;
        float f4;
        if (a.a[this.f5761h.ordinal()] == 1) {
            if (this.f5762i) {
                f3 = f() + (this.f5756c - d());
                int i3 = this.f5756c;
                if (f3 > i3) {
                    f3 = i3;
                }
                f2 = i3;
                f4 = f2 - f3;
            } else {
                f4 = -((this.f5756c - d()) + f());
            }
        } else if (this.f5762i) {
            f4 = -(f() - d());
        } else {
            f2 = this.f5756c;
            f3 = f() - d();
            f4 = f2 - f3;
        }
        u((int) f(), 0, (int) f4, 0, i2);
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void m() {
        if (this.f5762i) {
            return;
        }
        this.a.f(this.f5761h);
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void o(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
        float f2 = f() - d();
        e.a.a.g.d.i.s1.g.a aVar = this.f5761h;
        e.a.a.g.d.i.s1.g.a aVar2 = e.a.a.g.d.i.s1.g.a.NEXT;
        if (aVar != aVar2 || f2 <= 0.0f) {
            e.a.a.g.d.i.s1.g.a aVar3 = e.a.a.g.d.i.s1.g.a.PREV;
            if (aVar != aVar3 || f2 >= 0.0f) {
                float f3 = f2 > 0.0f ? f2 - this.f5756c : f2 + this.f5756c;
                if (this.f5763j) {
                    if (aVar == aVar3) {
                        this.o.setTranslate(this.f5756c + f3, 0.0f);
                        Bitmap bitmap = this.f5754l;
                        if (bitmap != null) {
                            canvas.drawBitmap(bitmap, this.o, null);
                        }
                        this.o.setTranslate(f3, 0.0f);
                        Bitmap bitmap2 = this.m;
                        if (bitmap2 == null) {
                            return;
                        }
                        canvas.drawBitmap(bitmap2, this.o, null);
                        return;
                    }
                    if (aVar == aVar2) {
                        this.o.setTranslate(f3, 0.0f);
                        Bitmap bitmap3 = this.n;
                        if (bitmap3 != null) {
                            canvas.drawBitmap(bitmap3, this.o, null);
                        }
                        this.o.setTranslate(f3 - this.f5756c, 0.0f);
                        Bitmap bitmap4 = this.f5754l;
                        if (bitmap4 == null) {
                            return;
                        }
                        canvas.drawBitmap(bitmap4, this.o, null);
                    }
                }
            }
        }
    }
}
