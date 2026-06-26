package c.b.a.m.q.c0;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: BitmapPoolAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements d {
    @Override // c.b.a.m.q.c0.d
    public void a(int i2) {
    }

    @Override // c.b.a.m.q.c0.d
    public void b() {
    }

    @Override // c.b.a.m.q.c0.d
    @NonNull
    public Bitmap c(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // c.b.a.m.q.c0.d
    public void d(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // c.b.a.m.q.c0.d
    @NonNull
    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }
}
