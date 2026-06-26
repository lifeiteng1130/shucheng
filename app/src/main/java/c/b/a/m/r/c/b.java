package c.b.a.m.r.c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: compiled from: BitmapDrawableEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements c.b.a.m.o<BitmapDrawable> {
    public final c.b.a.m.q.c0.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b.a.m.o<Bitmap> f505b;

    public b(c.b.a.m.q.c0.d dVar, c.b.a.m.o<Bitmap> oVar) {
        this.a = dVar;
        this.f505b = oVar;
    }

    @Override // c.b.a.m.o
    @NonNull
    public c.b.a.m.c a(@NonNull c.b.a.m.l lVar) {
        return this.f505b.a(lVar);
    }

    @Override // c.b.a.m.d
    public boolean encode(@NonNull Object obj, @NonNull File file, @NonNull c.b.a.m.l lVar) {
        return this.f505b.encode((Bitmap) new e(((BitmapDrawable) ((c.b.a.m.q.w) obj).get()).getBitmap(), this.a), file, lVar);
    }
}
