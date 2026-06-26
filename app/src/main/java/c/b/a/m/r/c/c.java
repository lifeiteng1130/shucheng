package c.b.a.m.r.c;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: BitmapEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements c.b.a.m.o<Bitmap> {
    public static final c.b.a.m.k<Integer> a = c.b.a.m.k.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c.b.a.m.k<Bitmap.CompressFormat> f511b = new c.b.a.m.k<>("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, c.b.a.m.k.a);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final c.b.a.m.q.c0.b f512c;

    public c(@NonNull c.b.a.m.q.c0.b bVar) {
        this.f512c = bVar;
    }

    @Override // c.b.a.m.o
    @NonNull
    public c.b.a.m.c a(@NonNull c.b.a.m.l lVar) {
        return c.b.a.m.c.TRANSFORMED;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|2|(2:5|(1:7)(1:8))|9|43|10|11|(2:48|12)|(5:50|13|(2:15|16)(1:17)|18|19)|46|28|29|30|(1:32)|33|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b A[Catch: all -> 0x00b5, TRY_LEAVE, TryCatch #2 {, blocks: (B:10:0x0026, B:28:0x0061, B:30:0x0065, B:32:0x006b, B:36:0x00b1, B:37:0x00b4), top: B:43:0x0026 }] */
    @Override // c.b.a.m.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean encode(@androidx.annotation.NonNull java.lang.Object r9, @androidx.annotation.NonNull java.io.File r10, @androidx.annotation.NonNull c.b.a.m.l r11) {
        /*
            r8 = this;
            c.b.a.m.q.w r9 = (c.b.a.m.q.w) r9
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            c.b.a.m.k<android.graphics.Bitmap$CompressFormat> r1 = c.b.a.m.r.c.c.f511b
            java.lang.Object r1 = r11.b(r1)
            android.graphics.Bitmap$CompressFormat r1 = (android.graphics.Bitmap.CompressFormat) r1
            if (r1 == 0) goto L15
            goto L20
        L15:
            boolean r1 = r9.hasAlpha()
            if (r1 == 0) goto L1e
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG
            goto L20
        L1e:
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
        L20:
            r9.getWidth()
            r9.getHeight()
            int r2 = c.b.a.s.e.f675b     // Catch: java.lang.Throwable -> Lb5
            long r2 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> Lb5
            c.b.a.m.k<java.lang.Integer> r4 = c.b.a.m.r.c.c.a     // Catch: java.lang.Throwable -> Lb5
            java.lang.Object r4 = r11.b(r4)     // Catch: java.lang.Throwable -> Lb5
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lb5
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lb5
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            c.b.a.m.q.c0.b r10 = r8.f512c     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            if (r10 == 0) goto L4c
            com.bumptech.glide.load.data.BufferedOutputStream r10 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            c.b.a.m.q.c0.b r6 = r8.f512c     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r10.<init>(r7, r6)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r6 = r10
            goto L4d
        L4c:
            r6 = r7
        L4d:
            r9.compress(r1, r4, r6)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r6.close()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r5 = 1
            goto L61
        L55:
            r9 = move-exception
            goto Laf
        L57:
            r6 = r7
            goto L5b
        L59:
            r9 = move-exception
            goto Lae
        L5b:
            r10 = 3
            android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> L59
            if (r6 == 0) goto L64
        L61:
            r6.close()     // Catch: java.io.IOException -> L64 java.lang.Throwable -> Lb5
        L64:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> Lb5
            if (r10 == 0) goto Lad
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5
            r10.<init>()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = "Compressed with type: "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb5
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = " of size "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb5
            int r0 = c.b.a.s.i.d(r9)     // Catch: java.lang.Throwable -> Lb5
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = " in "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb5
            double r0 = c.b.a.s.e.a(r2)     // Catch: java.lang.Throwable -> Lb5
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = ", options format: "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb5
            c.b.a.m.k<android.graphics.Bitmap$CompressFormat> r0 = c.b.a.m.r.c.c.f511b     // Catch: java.lang.Throwable -> Lb5
            java.lang.Object r11 = r11.b(r0)     // Catch: java.lang.Throwable -> Lb5
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb5
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Lb5
            r10.append(r9)     // Catch: java.lang.Throwable -> Lb5
            r10.toString()     // Catch: java.lang.Throwable -> Lb5
        Lad:
            return r5
        Lae:
            r7 = r6
        Laf:
            if (r7 == 0) goto Lb4
            r7.close()     // Catch: java.io.IOException -> Lb4 java.lang.Throwable -> Lb5
        Lb4:
            throw r9     // Catch: java.lang.Throwable -> Lb5
        Lb5:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.r.c.c.encode(java.lang.Object, java.io.File, c.b.a.m.l):boolean");
    }
}
