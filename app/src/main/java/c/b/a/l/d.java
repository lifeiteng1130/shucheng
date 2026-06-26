package c.b.a.l;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* JADX INFO: compiled from: StandardGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements GifDecoder {
    public static final String a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @ColorInt
    public int[] f294b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GifDecoder.a f296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteBuffer f297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public short[] f299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @ColorInt
    public int[] f303k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f304l;
    public b m;
    public Bitmap n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;

    @Nullable
    public Boolean t;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @ColorInt
    public final int[] f295c = new int[256];

    @NonNull
    public Bitmap.Config u = Bitmap.Config.ARGB_8888;

    public d(@NonNull GifDecoder.a aVar, b bVar, ByteBuffer byteBuffer, int i2) {
        this.f296d = aVar;
        this.m = new b();
        synchronized (this) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
            }
            int iHighestOneBit = Integer.highestOneBit(i2);
            this.p = 0;
            this.m = bVar;
            this.f304l = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f297e = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.f297e.order(ByteOrder.LITTLE_ENDIAN);
            this.o = false;
            Iterator<a> it = bVar.f284e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f276g == 3) {
                    this.o = true;
                    break;
                }
            }
            this.q = iHighestOneBit;
            int i3 = bVar.f285f;
            this.s = i3 / iHighestOneBit;
            int i4 = bVar.f286g;
            this.r = i4 / iHighestOneBit;
            this.f302j = ((c.b.a.m.r.g.b) this.f296d).a(i3 * i4);
            GifDecoder.a aVar2 = this.f296d;
            int i5 = this.s * this.r;
            c.b.a.m.q.c0.b bVar2 = ((c.b.a.m.r.g.b) aVar2).f570b;
            this.f303k = bVar2 == null ? new int[i5] : (int[]) bVar2.e(i5, int[].class);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap a() {
        if (this.m.f282c <= 0 || this.f304l < 0) {
            if (Log.isLoggable(a, 3)) {
                int i2 = this.m.f282c;
            }
            this.p = 1;
        }
        int i3 = this.p;
        if (i3 != 1 && i3 != 2) {
            this.p = 0;
            if (this.f298f == null) {
                this.f298f = ((c.b.a.m.r.g.b) this.f296d).a(255);
            }
            a aVar = this.m.f284e.get(this.f304l);
            int i4 = this.f304l - 1;
            a aVar2 = i4 >= 0 ? this.m.f284e.get(i4) : null;
            int[] iArr = aVar.f280k;
            if (iArr == null) {
                iArr = this.m.a;
            }
            this.f294b = iArr;
            if (iArr == null) {
                Log.isLoggable(a, 3);
                this.p = 1;
                return null;
            }
            if (aVar.f275f) {
                System.arraycopy(iArr, 0, this.f295c, 0, iArr.length);
                int[] iArr2 = this.f295c;
                this.f294b = iArr2;
                iArr2[aVar.f277h] = 0;
                if (aVar.f276g == 2 && this.f304l == 0) {
                    this.t = Boolean.TRUE;
                }
            }
            return i(aVar, aVar2);
        }
        Log.isLoggable(a, 3);
        return null;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void b() {
        this.f304l = (this.f304l + 1) % this.m.f282c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int c() {
        return this.m.f282c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        c.b.a.m.q.c0.b bVar;
        c.b.a.m.q.c0.b bVar2;
        c.b.a.m.q.c0.b bVar3;
        this.m = null;
        byte[] bArr = this.f302j;
        if (bArr != null && (bVar3 = ((c.b.a.m.r.g.b) this.f296d).f570b) != null) {
            bVar3.d(bArr);
        }
        int[] iArr = this.f303k;
        if (iArr != null && (bVar2 = ((c.b.a.m.r.g.b) this.f296d).f570b) != null) {
            bVar2.d(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            ((c.b.a.m.r.g.b) this.f296d).a.d(bitmap);
        }
        this.n = null;
        this.f297e = null;
        this.t = null;
        byte[] bArr2 = this.f298f;
        if (bArr2 == null || (bVar = ((c.b.a.m.r.g.b) this.f296d).f570b) == null) {
            return;
        }
        bVar.d(bArr2);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int d() {
        int i2;
        b bVar = this.m;
        int i3 = bVar.f282c;
        if (i3 <= 0 || (i2 = this.f304l) < 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= i3) {
            return -1;
        }
        return bVar.f284e.get(i2).f278i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int e() {
        return this.f304l;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int f() {
        return (this.f303k.length * 4) + this.f297e.limit() + this.f302j.length;
    }

    public final Bitmap g() {
        Boolean bool = this.t;
        Bitmap.Config config = (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u;
        Bitmap bitmapC = ((c.b.a.m.r.g.b) this.f296d).a.c(this.s, this.r, config);
        bitmapC.setHasAlpha(true);
        return bitmapC;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.f297e;
    }

    public void h(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.u = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v30, types: [short] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap i(c.b.a.l.a r36, c.b.a.l.a r37) {
        /*
            Method dump skipped, instruction units count: 1085
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.l.d.i(c.b.a.l.a, c.b.a.l.a):android.graphics.Bitmap");
    }
}
