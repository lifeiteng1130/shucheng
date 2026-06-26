package c.b.a.m.r.g;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import c.b.a.m.l;
import c.b.a.m.n;
import c.b.a.m.q.w;
import com.bumptech.glide.gifdecoder.GifDecoder;

/* JADX INFO: compiled from: GifFrameResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements n<GifDecoder, Bitmap> {
    public final c.b.a.m.q.c0.d a;

    public g(c.b.a.m.q.c0.d dVar) {
        this.a = dVar;
    }

    @Override // c.b.a.m.n
    public /* bridge */ /* synthetic */ boolean a(@NonNull GifDecoder gifDecoder, @NonNull l lVar) {
        return true;
    }

    @Override // c.b.a.m.n
    public w<Bitmap> b(@NonNull GifDecoder gifDecoder, int i2, int i3, @NonNull l lVar) {
        return c.b.a.m.r.c.e.b(gifDecoder.a(), this.a);
    }
}
