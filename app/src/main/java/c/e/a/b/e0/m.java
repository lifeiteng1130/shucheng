package c.e.a.b.e0;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import c.e.a.b.w.l;

/* JADX INFO: compiled from: TransitionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class m implements l.c {
    public final /* synthetic */ RectF a;

    public m(RectF rectF) {
        this.a = rectF;
    }

    @Override // c.e.a.b.w.l.c
    @NonNull
    public c.e.a.b.w.c a(@NonNull c.e.a.b.w.c cVar) {
        return cVar instanceof c.e.a.b.w.j ? cVar : new c.e.a.b.w.j(cVar.a(this.a) / this.a.height());
    }
}
