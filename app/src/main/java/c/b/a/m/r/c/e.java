package c.b.a.m.r.c;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: BitmapResource.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements c.b.a.m.q.w<Bitmap>, c.b.a.m.q.s {
    public final Bitmap a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b.a.m.q.c0.d f514b;

    public e(@NonNull Bitmap bitmap, @NonNull c.b.a.m.q.c0.d dVar) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        this.a = bitmap;
        Objects.requireNonNull(dVar, "BitmapPool must not be null");
        this.f514b = dVar;
    }

    @Nullable
    public static e b(@Nullable Bitmap bitmap, @NonNull c.b.a.m.q.c0.d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, dVar);
    }

    @Override // c.b.a.m.q.s
    public void a() {
        this.a.prepareToDraw();
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public Bitmap get() {
        return this.a;
    }

    @Override // c.b.a.m.q.w
    public int getSize() {
        return c.b.a.s.i.d(this.a);
    }

    @Override // c.b.a.m.q.w
    public void recycle() {
        this.f514b.d(this.a);
    }
}
