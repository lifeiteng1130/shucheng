package c.b.a.q.k;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: DrawableCrossFadeFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e<Drawable> {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f663b;

    public a(int i2, boolean z) {
        this.a = i2;
    }

    @Override // c.b.a.q.k.e
    public d<Drawable> a(c.b.a.m.a aVar, boolean z) {
        if (aVar == c.b.a.m.a.MEMORY_CACHE) {
            return c.a;
        }
        if (this.f663b == null) {
            this.f663b = new b(this.a, false);
        }
        return this.f663b;
    }
}
