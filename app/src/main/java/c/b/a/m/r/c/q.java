package c.b.a.m.r.c;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: FitCenter.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f537b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(c.b.a.m.j.a);

    @Override // c.b.a.m.r.c.f
    public Bitmap b(@NonNull c.b.a.m.q.c0.d dVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return z.b(dVar, bitmap, i2, i3);
    }

    @Override // c.b.a.m.j
    public boolean equals(Object obj) {
        return obj instanceof q;
    }

    @Override // c.b.a.m.j
    public int hashCode() {
        return 1572326941;
    }

    @Override // c.b.a.m.j
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f537b);
    }
}
