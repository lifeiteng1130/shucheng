package e.a.a.g.d.i.s1.f;

import android.graphics.Canvas;
import f.c0.c.j;
import io.legado.app.ui.book.read.page.ReadView;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NoAnimPageDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull ReadView readView) {
        super(readView);
        j.e(readView, "readView");
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void l(int i2) {
        if (!this.f5762i) {
            this.a.f(this.f5761h);
        }
        this.f5764k = false;
        this.a.post(new a(this));
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void m() {
    }

    @Override // e.a.a.g.d.i.s1.f.e
    public void o(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
    }
}
