package c.b.a.m.r.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import c.b.a.m.l;
import c.b.a.m.n;
import c.b.a.m.q.w;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: compiled from: ByteBufferGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements n<ByteBuffer, GifDrawable> {
    public static final C0024a a = new C0024a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f564b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ImageHeaderParser> f566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0024a f568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c.b.a.m.r.g.b f569g;

    /* JADX INFO: renamed from: c.b.a.m.r.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    public static class C0024a {
    }

    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    public static class b {
        public final Queue<c.b.a.l.c> a;

        public b() {
            char[] cArr = c.b.a.s.i.a;
            this.a = new ArrayDeque(0);
        }

        public synchronized void a(c.b.a.l.c cVar) {
            cVar.f291b = null;
            cVar.f292c = null;
            this.a.offer(cVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, c.b.a.m.q.c0.d dVar, c.b.a.m.q.c0.b bVar) {
        b bVar2 = f564b;
        C0024a c0024a = a;
        this.f565c = context.getApplicationContext();
        this.f566d = list;
        this.f568f = c0024a;
        this.f569g = new c.b.a.m.r.g.b(dVar, bVar);
        this.f567e = bVar2;
    }

    @Override // c.b.a.m.n
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull l lVar) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (!((Boolean) lVar.b(h.f587b)).booleanValue()) {
            if ((byteBuffer2 == null ? ImageHeaderParser.ImageType.UNKNOWN : c.b.a.m.f.c3(this.f566d, new c.b.a.m.g(byteBuffer2))) == ImageHeaderParser.ImageType.GIF) {
                return true;
            }
        }
        return false;
    }

    @Override // c.b.a.m.n
    public w<GifDrawable> b(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull l lVar) {
        c.b.a.l.c cVar;
        ByteBuffer byteBuffer2 = byteBuffer;
        b bVar = this.f567e;
        synchronized (bVar) {
            c.b.a.l.c cVarPoll = bVar.a.poll();
            if (cVarPoll == null) {
                cVarPoll = new c.b.a.l.c();
            }
            cVar = cVarPoll;
            cVar.f291b = null;
            Arrays.fill(cVar.a, (byte) 0);
            cVar.f292c = new c.b.a.l.b();
            cVar.f293d = 0;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer2.asReadOnlyBuffer();
            cVar.f291b = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            cVar.f291b.order(ByteOrder.LITTLE_ENDIAN);
        }
        try {
            return c(byteBuffer2, i2, i3, cVar, lVar);
        } finally {
            this.f567e.a(cVar);
        }
    }

    @Nullable
    public final d c(ByteBuffer byteBuffer, int i2, int i3, c.b.a.l.c cVar, l lVar) {
        int i4 = c.b.a.s.e.f675b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            c.b.a.l.b bVarB = cVar.b();
            if (bVarB.f282c > 0 && bVarB.f281b == 0) {
                Bitmap.Config config = lVar.b(h.a) == c.b.a.m.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int iMin = Math.min(bVarB.f286g / i3, bVarB.f285f / i2);
                int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
                Log.isLoggable("BufferGifDecoder", 2);
                C0024a c0024a = this.f568f;
                c.b.a.m.r.g.b bVar = this.f569g;
                Objects.requireNonNull(c0024a);
                c.b.a.l.d dVar = new c.b.a.l.d(bVar, bVarB, byteBuffer, iMax);
                dVar.h(config);
                dVar.f304l = (dVar.f304l + 1) % dVar.m.f282c;
                Bitmap bitmapA = dVar.a();
                if (bitmapA == null) {
                    return null;
                }
                d dVar2 = new d(new GifDrawable(this.f565c, dVar, (c.b.a.m.r.b) c.b.a.m.r.b.f503b, i2, i3, bitmapA));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    c.b.a.s.e.a(jElapsedRealtimeNanos);
                }
                return dVar2;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                c.b.a.s.e.a(jElapsedRealtimeNanos);
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                c.b.a.s.e.a(jElapsedRealtimeNanos);
            }
        }
    }
}
