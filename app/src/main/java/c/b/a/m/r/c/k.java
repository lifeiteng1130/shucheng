package c.b.a.m.r.c;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Objects;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: DefaultImageHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements ImageHeaderParser {
    public static final byte[] a = "Exif\u0000\u0000".getBytes(Charset.forName(DataUtil.defaultCharset));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f517b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    public static final class a implements c {
        public final ByteBuffer a;

        public a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // c.b.a.m.r.c.k.c
        public int a() {
            return (c() << 8) | c();
        }

        @Override // c.b.a.m.r.c.k.c
        public int b(byte[] bArr, int i2) {
            int iMin = Math.min(i2, this.a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.a.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // c.b.a.m.r.c.k.c
        public short c() throws c.a {
            if (this.a.remaining() >= 1) {
                return (short) (this.a.get() & ExifInterface.MARKER);
            }
            throw new c.a();
        }

        @Override // c.b.a.m.r.c.k.c
        public long skip(long j2) {
            int iMin = (int) Math.min(this.a.remaining(), j2);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    public static final class b {
        public final ByteBuffer a;

        public b(byte[] bArr, int i2) {
            this.a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        public short a(int i2) {
            if (this.a.remaining() - i2 >= 2) {
                return this.a.getShort(i2);
            }
            return (short) -1;
        }

        public int b(int i2) {
            if (this.a.remaining() - i2 >= 4) {
                return this.a.getInt(i2);
            }
            return -1;
        }
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    public interface c {

        /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
        public static final class a extends IOException {
            private static final long serialVersionUID = 1;

            public a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a();

        int b(byte[] bArr, int i2);

        short c();

        long skip(long j2);
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    public static final class d implements c {
        public final InputStream a;

        public d(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // c.b.a.m.r.c.k.c
        public int a() {
            return (c() << 8) | c();
        }

        @Override // c.b.a.m.r.c.k.c
        public int b(byte[] bArr, int i2) throws c.a {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.a.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 == 0 && i4 == -1) {
                throw new c.a();
            }
            return i3;
        }

        @Override // c.b.a.m.r.c.k.c
        public short c() throws IOException {
            int i2 = this.a.read();
            if (i2 != -1) {
                return (short) i2;
            }
            throw new c.a();
        }

        @Override // c.b.a.m.r.c.k.c
        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j3 = j2;
            while (j3 > 0) {
                long jSkip = this.a.skip(j3);
                if (jSkip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j3 -= jSkip;
            }
            return j2 - j3;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) {
        Objects.requireNonNull(byteBuffer, "Argument must not be null");
        return d(new a(byteBuffer));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType b(@NonNull InputStream inputStream) {
        Objects.requireNonNull(inputStream, "Argument must not be null");
        return d(new d(inputStream));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int c(@NonNull InputStream inputStream, @NonNull c.b.a.m.q.c0.b bVar) throws IOException {
        int iA;
        Objects.requireNonNull(inputStream, "Argument must not be null");
        d dVar = new d(inputStream);
        Objects.requireNonNull(bVar, "Argument must not be null");
        try {
            int iA2 = dVar.a();
            if (!((iA2 & 65496) == 65496 || iA2 == 19789 || iA2 == 18761)) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            while (true) {
                if (dVar.c() == 255) {
                    short sC = dVar.c();
                    if (sC == 218) {
                        break;
                    }
                    if (sC != 217) {
                        iA = dVar.a() - 2;
                        if (sC == 225) {
                            break;
                        }
                        long j2 = iA;
                        if (dVar.skip(j2) != j2) {
                            Log.isLoggable("DfltImageHeaderParser", 3);
                            break;
                        }
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                        break;
                    }
                } else {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                    break;
                }
            }
            iA = -1;
            if (iA == -1) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            byte[] bArr = (byte[]) bVar.e(iA, byte[].class);
            try {
                int iE = e(dVar, bArr, iA);
                bVar.d(bArr);
                return iE;
            } catch (Throwable th) {
                bVar.d(bArr);
                throw th;
            }
        } catch (c.a unused) {
            return -1;
        }
    }

    @NonNull
    public final ImageHeaderParser.ImageType d(c cVar) {
        try {
            int iA = cVar.a();
            if (iA == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int iC = (iA << 8) | cVar.c();
            if (iC == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int iC2 = (iC << 8) | cVar.c();
            if (iC2 == -1991225785) {
                cVar.skip(21L);
                try {
                    return cVar.c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (iC2 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.skip(4L);
            if (((cVar.a() << 16) | cVar.a()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int iA2 = (cVar.a() << 16) | cVar.a();
            if ((iA2 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i2 = iA2 & 255;
            if (i2 == 88) {
                cVar.skip(4L);
                return (cVar.c() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i2 != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            }
            cVar.skip(4L);
            return (cVar.c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        } catch (c.a unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    public final int e(c cVar, byte[] bArr, int i2) {
        ByteOrder byteOrder;
        if (cVar.b(bArr, i2) != i2) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        boolean z = bArr != null && i2 > a.length;
        if (z) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = a;
                if (i3 >= bArr2.length) {
                    break;
                }
                if (bArr[i3] != bArr2[i3]) {
                    z = false;
                    break;
                }
                i3++;
            }
        }
        if (!z) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        b bVar = new b(bArr, i2);
        short sA = bVar.a(6);
        if (sA == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (sA != 19789) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.a.order(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i4 = 0; i4 < sA2; i4++) {
            int i5 = (i4 * 12) + iB + 2;
            if (bVar.a(i5) == 274) {
                short sA3 = bVar.a(i5 + 2);
                if (sA3 < 1 || sA3 > 12) {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                } else {
                    int iB2 = bVar.b(i5 + 4);
                    if (iB2 < 0) {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                        int i6 = iB2 + f517b[sA3];
                        if (i6 > 4) {
                            Log.isLoggable("DfltImageHeaderParser", 3);
                        } else {
                            int i7 = i5 + 8;
                            if (i7 < 0 || i7 > bVar.a.remaining()) {
                                Log.isLoggable("DfltImageHeaderParser", 3);
                            } else {
                                if (i6 >= 0 && i6 + i7 <= bVar.a.remaining()) {
                                    return bVar.a(i7);
                                }
                                Log.isLoggable("DfltImageHeaderParser", 3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
