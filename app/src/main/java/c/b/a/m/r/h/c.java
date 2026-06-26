package c.b.a.m.r.h;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.l;
import c.b.a.m.q.w;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* JADX INFO: compiled from: DrawableBytesTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {
    public final c.b.a.m.q.c0.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e<Bitmap, byte[]> f591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<GifDrawable, byte[]> f592c;

    public c(@NonNull c.b.a.m.q.c0.d dVar, @NonNull e<Bitmap, byte[]> eVar, @NonNull e<GifDrawable, byte[]> eVar2) {
        this.a = dVar;
        this.f591b = eVar;
        this.f592c = eVar2;
    }

    @Override // c.b.a.m.r.h.e
    @Nullable
    public w<byte[]> a(@NonNull w<Drawable> wVar, @NonNull l lVar) {
        Drawable drawable = wVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f591b.a(c.b.a.m.r.c.e.b(((BitmapDrawable) drawable).getBitmap(), this.a), lVar);
        }
        if (drawable instanceof GifDrawable) {
            return this.f592c.a(wVar, lVar);
        }
        return null;
    }
}
