package c.b.a.m.r.g;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import c.b.a.m.q.s;
import c.b.a.m.r.g.f;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* JADX INFO: compiled from: GifDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends c.b.a.m.r.e.b<GifDrawable> implements s {
    public d(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // c.b.a.m.r.e.b, c.b.a.m.q.s
    public void a() {
        ((GifDrawable) this.a).b().prepareToDraw();
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public Class<GifDrawable> c() {
        return GifDrawable.class;
    }

    @Override // c.b.a.m.q.w
    public int getSize() {
        f fVar = ((GifDrawable) this.a).a.a;
        return fVar.a.f() + fVar.p;
    }

    @Override // c.b.a.m.q.w
    public void recycle() {
        ((GifDrawable) this.a).stop();
        GifDrawable gifDrawable = (GifDrawable) this.a;
        gifDrawable.f1601d = true;
        f fVar = gifDrawable.a.a;
        fVar.f573c.clear();
        Bitmap bitmap = fVar.f582l;
        if (bitmap != null) {
            fVar.f575e.d(bitmap);
            fVar.f582l = null;
        }
        fVar.f576f = false;
        f.a aVar = fVar.f579i;
        if (aVar != null) {
            fVar.f574d.j(aVar);
            fVar.f579i = null;
        }
        f.a aVar2 = fVar.f581k;
        if (aVar2 != null) {
            fVar.f574d.j(aVar2);
            fVar.f581k = null;
        }
        f.a aVar3 = fVar.n;
        if (aVar3 != null) {
            fVar.f574d.j(aVar3);
            fVar.n = null;
        }
        fVar.a.clear();
        fVar.f580j = true;
    }
}
