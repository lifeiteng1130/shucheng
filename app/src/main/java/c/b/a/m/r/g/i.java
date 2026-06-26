package c.b.a.m.r.g;

import androidx.annotation.NonNull;
import c.b.a.m.l;
import c.b.a.m.n;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: StreamGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements n<InputStream, GifDrawable> {
    public final List<ImageHeaderParser> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n<ByteBuffer, GifDrawable> f588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b.a.m.q.c0.b f589c;

    public i(List<ImageHeaderParser> list, n<ByteBuffer, GifDrawable> nVar, c.b.a.m.q.c0.b bVar) {
        this.a = list;
        this.f588b = nVar;
        this.f589c = bVar;
    }

    @Override // c.b.a.m.n
    public boolean a(@NonNull InputStream inputStream, @NonNull l lVar) {
        return !((Boolean) lVar.b(h.f587b)).booleanValue() && c.b.a.m.f.b3(this.a, inputStream, this.f589c) == ImageHeaderParser.ImageType.GIF;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // c.b.a.m.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c.b.a.m.q.w<com.bumptech.glide.load.resource.gif.GifDrawable> b(@androidx.annotation.NonNull java.io.InputStream r6, int r7, int r8, @androidx.annotation.NonNull c.b.a.m.l r9) {
        /*
            r5 = this;
            java.io.InputStream r6 = (java.io.InputStream) r6
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = 16384(0x4000, float:2.2959E-41)
            r0.<init>(r1)
            r2 = 0
            byte[] r1 = new byte[r1]     // Catch: java.io.IOException -> L20
        Lc:
            int r3 = r6.read(r1)     // Catch: java.io.IOException -> L20
            r4 = -1
            if (r3 == r4) goto L18
            r4 = 0
            r0.write(r1, r4, r3)     // Catch: java.io.IOException -> L20
            goto Lc
        L18:
            r0.flush()     // Catch: java.io.IOException -> L20
            byte[] r6 = r0.toByteArray()
            goto L27
        L20:
            r6 = 5
            java.lang.String r0 = "StreamGifDecoder"
            android.util.Log.isLoggable(r0, r6)
            r6 = r2
        L27:
            if (r6 != 0) goto L2a
            goto L34
        L2a:
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r6)
            c.b.a.m.n<java.nio.ByteBuffer, com.bumptech.glide.load.resource.gif.GifDrawable> r0 = r5.f588b
            c.b.a.m.q.w r2 = r0.b(r6, r7, r8, r9)
        L34:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.r.g.i.b(java.lang.Object, int, int, c.b.a.m.l):c.b.a.m.q.w");
    }
}
