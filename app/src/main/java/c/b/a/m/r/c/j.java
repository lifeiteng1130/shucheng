package c.b.a.m.r.c;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: CenterInside.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f516b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(c.b.a.m.j.a);

    @Override // c.b.a.m.r.c.f
    public Bitmap b(@NonNull c.b.a.m.q.c0.d dVar, @NonNull Bitmap bitmap, int i2, int i3) {
        Paint paint = z.a;
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            Log.isLoggable("TransformationUtils", 2);
            return z.b(dVar, bitmap, i2, i3);
        }
        Log.isLoggable("TransformationUtils", 2);
        return bitmap;
    }

    @Override // c.b.a.m.j
    public boolean equals(Object obj) {
        return obj instanceof j;
    }

    @Override // c.b.a.m.j
    public int hashCode() {
        return -670243078;
    }

    @Override // c.b.a.m.j
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f516b);
    }
}
