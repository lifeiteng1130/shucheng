package c.b.a.m.r.c;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import c.b.a.m.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: compiled from: VideoDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class b0<T> implements c.b.a.m.n<T, Bitmap> {
    public static final c.b.a.m.k<Long> a = new c.b.a.m.k<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c.b.a.m.k<Integer> f506b = new c.b.a.m.k<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f507c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f<T> f508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c.b.a.m.q.c0.d f509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f510f;

    /* JADX INFO: compiled from: VideoDecoder.java */
    public class a implements k.b<Long> {
        public final ByteBuffer a = ByteBuffer.allocate(8);

        @Override // c.b.a.m.k.b
        public void a(@NonNull byte[] bArr, @NonNull Long l2, @NonNull MessageDigest messageDigest) {
            Long l3 = l2;
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l3.longValue()).array());
            }
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    public class b implements k.b<Integer> {
        public final ByteBuffer a = ByteBuffer.allocate(4);

        @Override // c.b.a.m.k.b
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            Integer num2 = num;
            if (num2 == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num2.intValue()).array());
            }
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    public static final class c implements f<AssetFileDescriptor> {
        public c(a aVar) {
        }

        @Override // c.b.a.m.r.c.b0.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            AssetFileDescriptor assetFileDescriptor2 = assetFileDescriptor;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    @RequiresApi(23)
    public static final class d implements f<ByteBuffer> {
        @Override // c.b.a.m.r.c.b0.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new c0(this, byteBuffer));
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    @VisibleForTesting
    public static class e {
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    @VisibleForTesting
    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    public static final class g implements f<ParcelFileDescriptor> {
        @Override // c.b.a.m.r.c.b0.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    public static final class h extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        public h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public b0(c.b.a.m.q.c0.d dVar, f<T> fVar) {
        e eVar = f507c;
        this.f509e = dVar;
        this.f508d = fVar;
        this.f510f = eVar;
    }

    @Nullable
    public static Bitmap c(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, l lVar) {
        Bitmap frameAtTime;
        if (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || lVar == l.f520d) {
            frameAtTime = null;
        } else {
            try {
                int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int i7 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (i7 == 90 || i7 == 270) {
                    i6 = i5;
                    i5 = i6;
                }
                float fB = lVar.b(i5, i6, i3, i4);
                frameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(i5 * fB), Math.round(fB * i6));
            } catch (Throwable unused) {
                Log.isLoggable("VideoDecoder", 3);
                frameAtTime = null;
            }
        }
        if (frameAtTime == null) {
            frameAtTime = mediaMetadataRetriever.getFrameAtTime(j2, i2);
        }
        if (frameAtTime != null) {
            return frameAtTime;
        }
        throw new h();
    }

    @Override // c.b.a.m.n
    public boolean a(@NonNull T t, @NonNull c.b.a.m.l lVar) {
        return true;
    }

    @Override // c.b.a.m.n
    public c.b.a.m.q.w<Bitmap> b(@NonNull T t, int i2, int i3, @NonNull c.b.a.m.l lVar) throws IOException {
        long jLongValue = ((Long) lVar.b(a)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException(c.a.a.a.a.f("Requested frame must be non-negative, or DEFAULT_FRAME, given: ", jLongValue));
        }
        Integer num = (Integer) lVar.b(f506b);
        if (num == null) {
            num = 2;
        }
        l lVar2 = (l) lVar.b(l.f522f);
        if (lVar2 == null) {
            lVar2 = l.f521e;
        }
        l lVar3 = lVar2;
        Objects.requireNonNull(this.f510f);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            this.f508d.a(mediaMetadataRetriever, t);
            Bitmap bitmapC = c(mediaMetadataRetriever, jLongValue, num.intValue(), i2, i3, lVar3);
            mediaMetadataRetriever.release();
            return c.b.a.m.r.c.e.b(bitmapC, this.f509e);
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }
}
