package c.b.a.m.r.e;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: NonOwnedDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends b<Drawable> {
    public d(Drawable drawable) {
        super(drawable);
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public Class<Drawable> c() {
        return this.a.getClass();
    }

    @Override // c.b.a.m.q.w
    public int getSize() {
        return Math.max(1, this.a.getIntrinsicHeight() * this.a.getIntrinsicWidth() * 4);
    }

    @Override // c.b.a.m.q.w
    public void recycle() {
    }
}
