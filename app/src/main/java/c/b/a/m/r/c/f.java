package c.b.a.m.r.c;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: BitmapTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f implements c.b.a.m.p<Bitmap> {
    @Override // c.b.a.m.p
    @NonNull
    public final c.b.a.m.q.w<Bitmap> a(@NonNull Context context, @NonNull c.b.a.m.q.w<Bitmap> wVar, int i2, int i3) {
        if (!c.b.a.s.i.j(i2, i3)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        c.b.a.m.q.c0.d dVar = c.b.a.b.b(context).f196c;
        Bitmap bitmap = wVar.get();
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getWidth();
        }
        if (i3 == Integer.MIN_VALUE) {
            i3 = bitmap.getHeight();
        }
        Bitmap bitmapB = b(dVar, bitmap, i2, i3);
        return bitmap.equals(bitmapB) ? wVar : e.b(bitmapB, dVar);
    }

    public abstract Bitmap b(@NonNull c.b.a.m.q.c0.d dVar, @NonNull Bitmap bitmap, int i2, int i3);
}
