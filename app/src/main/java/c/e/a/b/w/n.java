package c.e.a.b.w;

import android.graphics.Canvas;
import android.graphics.Matrix;
import c.e.a.b.w.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends o.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f1260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Matrix f1261c;

    public n(o oVar, List list, Matrix matrix) {
        this.f1260b = list;
        this.f1261c = matrix;
    }

    @Override // c.e.a.b.w.o.f
    public void a(Matrix matrix, c.e.a.b.v.a aVar, int i2, Canvas canvas) {
        Iterator it = this.f1260b.iterator();
        while (it.hasNext()) {
            ((o.f) it.next()).a(this.f1261c, aVar, i2, canvas);
        }
    }
}
