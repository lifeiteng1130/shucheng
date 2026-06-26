package c.e.a.b.p;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ h a;

    public j(h hVar) {
        this.a = hVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        h hVar = this.a;
        float rotation = hVar.F.getRotation();
        if (hVar.y == rotation) {
            return true;
        }
        hVar.y = rotation;
        hVar.u();
        return true;
    }
}
