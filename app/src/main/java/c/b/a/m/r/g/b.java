package c.b.a.m.r.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;

/* JADX INFO: compiled from: GifBitmapProvider.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements GifDecoder.a {
    public final c.b.a.m.q.c0.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final c.b.a.m.q.c0.b f570b;

    public b(c.b.a.m.q.c0.d dVar, @Nullable c.b.a.m.q.c0.b bVar) {
        this.a = dVar;
        this.f570b = bVar;
    }

    @NonNull
    public byte[] a(int i2) {
        c.b.a.m.q.c0.b bVar = this.f570b;
        return bVar == null ? new byte[i2] : (byte[]) bVar.e(i2, byte[].class);
    }
}
