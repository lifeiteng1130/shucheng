package c.b.a.m.r.c;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: UnitBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements c.b.a.m.n<Bitmap, Bitmap> {

    /* JADX INFO: compiled from: UnitBitmapDecoder.java */
    public static final class a implements c.b.a.m.q.w<Bitmap> {
        public final Bitmap a;

        public a(@NonNull Bitmap bitmap) {
            this.a = bitmap;
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
        }
    }

    @Override // c.b.a.m.n
    public /* bridge */ /* synthetic */ boolean a(@NonNull Bitmap bitmap, @NonNull c.b.a.m.l lVar) {
        return true;
    }

    @Override // c.b.a.m.n
    public c.b.a.m.q.w<Bitmap> b(@NonNull Bitmap bitmap, int i2, int i3, @NonNull c.b.a.m.l lVar) {
        return new a(bitmap);
    }
}
