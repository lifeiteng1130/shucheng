package c.b.a.q.k;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import c.b.a.q.k.d;

/* JADX INFO: compiled from: DrawableCrossFadeTransition.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements d<Drawable> {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f664b;

    public b(int i2, boolean z) {
        this.a = i2;
        this.f664b = z;
    }

    @Override // c.b.a.q.k.d
    public boolean a(Drawable drawable, d.a aVar) {
        Drawable drawable2 = drawable;
        c.b.a.q.j.e eVar = (c.b.a.q.j.e) aVar;
        Drawable drawable3 = ((ImageView) eVar.f658b).getDrawable();
        if (drawable3 == null) {
            drawable3 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable3, drawable2});
        transitionDrawable.setCrossFadeEnabled(this.f664b);
        transitionDrawable.startTransition(this.a);
        ((ImageView) eVar.f658b).setImageDrawable(transitionDrawable);
        return true;
    }
}
