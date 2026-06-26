package c.b.a.m.r.c;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: CenterCrop.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f515b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(c.b.a.m.j.a);

    @Override // c.b.a.m.r.c.f
    public Bitmap b(@NonNull c.b.a.m.q.c0.d dVar, @NonNull Bitmap bitmap, int i2, int i3) {
        float width;
        float height;
        Paint paint = z.a;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
            width = i3 / bitmap.getHeight();
            width2 = (i2 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i2 / bitmap.getWidth();
            height = (i3 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapE = dVar.e(i2, i3, z.c(bitmap));
        bitmapE.setHasAlpha(bitmap.hasAlpha());
        z.a(bitmap, bitmapE, matrix);
        return bitmapE;
    }

    @Override // c.b.a.m.j
    public boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // c.b.a.m.j
    public int hashCode() {
        return -599754482;
    }

    @Override // c.b.a.m.j
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f515b);
    }
}
