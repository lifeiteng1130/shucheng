package c.b.a.m.r.g;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import c.b.a.m.p;
import c.b.a.m.q.w;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: compiled from: GifDrawableTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements p<GifDrawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p<Bitmap> f571b;

    public e(p<Bitmap> pVar) {
        Objects.requireNonNull(pVar, "Argument must not be null");
        this.f571b = pVar;
    }

    @Override // c.b.a.m.p
    @NonNull
    public w<GifDrawable> a(@NonNull Context context, @NonNull w<GifDrawable> wVar, int i2, int i3) {
        GifDrawable gifDrawable = wVar.get();
        w<Bitmap> eVar = new c.b.a.m.r.c.e(gifDrawable.b(), c.b.a.b.b(context).f196c);
        w<Bitmap> wVarA = this.f571b.a(context, eVar, i2, i3);
        if (!eVar.equals(wVarA)) {
            eVar.recycle();
        }
        Bitmap bitmap = wVarA.get();
        gifDrawable.a.a.c(this.f571b, bitmap);
        return wVar;
    }

    @Override // c.b.a.m.j
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f571b.equals(((e) obj).f571b);
        }
        return false;
    }

    @Override // c.b.a.m.j
    public int hashCode() {
        return this.f571b.hashCode();
    }

    @Override // c.b.a.m.j
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f571b.updateDiskCacheKey(messageDigest);
    }
}
