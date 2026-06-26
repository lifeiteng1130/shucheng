package c.b.a.m.r.e;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.l;
import c.b.a.m.n;
import c.b.a.m.q.w;

/* JADX INFO: compiled from: UnitDrawableDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements n<Drawable, Drawable> {
    @Override // c.b.a.m.n
    public /* bridge */ /* synthetic */ boolean a(@NonNull Drawable drawable, @NonNull l lVar) {
        return true;
    }

    @Override // c.b.a.m.n
    @Nullable
    public w<Drawable> b(@NonNull Drawable drawable, int i2, int i3, @NonNull l lVar) {
        Drawable drawable2 = drawable;
        if (drawable2 != null) {
            return new d(drawable2);
        }
        return null;
    }
}
