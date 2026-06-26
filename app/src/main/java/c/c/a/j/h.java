package c.c.a.j;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static final byte[] a = new byte[8];

    public static class a {
        public final byte[] a;

        public a(ByteBuffer byteBuffer, byte[] bArr) {
            this.a = bArr;
        }
    }

    public static class b implements k {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteBuffer f759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MessageDigest f760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f761d = new byte[32];

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f762e;

        public b(byte[] bArr, ByteBuffer byteBuffer, byte b2) throws NoSuchAlgorithmException {
            this.f762e = bArr;
            this.f759b = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.f760c = messageDigest;
            messageDigest.update(bArr);
            this.a = 0;
        }

        @Override // c.c.a.j.k
        public final void a(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            while (iRemaining > 0) {
                int iMin = Math.min(iRemaining, 4096 - this.a);
                byteBuffer.limit(byteBuffer.position() + iMin);
                this.f760c.update(byteBuffer);
                iRemaining -= iMin;
                int i2 = this.a + iMin;
                this.a = i2;
                if (i2 == 4096) {
                    MessageDigest messageDigest = this.f760c;
                    byte[] bArr = this.f761d;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.f759b.put(this.f761d);
                    this.f760c.update(this.f762e);
                    this.a = 0;
                }
            }
        }

        public final void b() {
            if (this.a == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.a);
        }

        public final void c() {
            int iPosition = this.f759b.position() % 4096;
            if (iPosition == 0) {
                return;
            }
            this.f759b.put(ByteBuffer.allocate(4096 - iPosition));
        }
    }

    public static a a(RandomAccessFile randomAccessFile, n nVar, j jVar) throws NoSuchAlgorithmException, DigestException, IOException {
        long j2;
        int i2;
        int i3;
        int[] iArrD = d(randomAccessFile.length() - (nVar.f767c - nVar.f766b));
        int i4 = iArrD[iArrD.length - 1];
        int i5 = i4 + 4096;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i5);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBufferAllocate.order(byteOrder);
        ByteBuffer byteBufferB = b(byteBufferAllocate, 0, i4);
        int i6 = i4 + 64;
        ByteBuffer byteBufferB2 = b(byteBufferAllocate, i4, i6);
        ByteBuffer byteBufferB3 = b(byteBufferAllocate, i6, i5);
        byte[] bArr = new byte[32];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(byteOrder);
        long j3 = nVar.f766b;
        if (j3 % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + nVar.f766b);
        }
        long j4 = nVar.f767c - j3;
        if (j4 % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (nVar.f767c - nVar.f766b));
        }
        int[] iArrD2 = d(randomAccessFile.length() - j4);
        if (byteBufferB != null) {
            byte[] bArr2 = a;
            b bVar = new b(bArr2, b(byteBufferB, iArrD2[iArrD2.length - 2], iArrD2[iArrD2.length - 1]), (byte) 0);
            c(bVar, new m(randomAccessFile.getFD(), 0L, nVar.f766b), 1048576);
            long j5 = nVar.f768d + 16;
            FileDescriptor fd = randomAccessFile.getFD();
            j2 = j4;
            long j6 = nVar.f767c;
            c(bVar, new m(fd, j6, j5 - j6), 1048576);
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(byteOrder);
            byteBufferOrder.putInt(e(nVar.f766b));
            byteBufferOrder.flip();
            bVar.a(byteBufferOrder);
            long j7 = j5 + 4;
            c(bVar, new m(randomAccessFile.getFD(), j7, randomAccessFile.length() - j7), 1048576);
            int length = (int) (randomAccessFile.length() % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            if (length != 0) {
                bVar.a(ByteBuffer.allocate(4096 - length));
            }
            bVar.b();
            bVar.c();
            for (int length2 = iArrD2.length - 3; length2 >= 0; length2--) {
                int i7 = length2 + 1;
                ByteBuffer byteBufferB4 = b(byteBufferB, iArrD2[i7], iArrD2[length2 + 2]);
                ByteBuffer byteBufferB5 = b(byteBufferB, iArrD2[length2], iArrD2[i7]);
                i iVar = new i(byteBufferB4);
                b bVar2 = new b(bArr2, byteBufferB5, (byte) 0);
                c(bVar2, iVar, 4096);
                bVar2.b();
                bVar2.c();
            }
            byte[] bArr3 = new byte[32];
            byte[] bArr4 = new byte[32];
            ByteBuffer byteBufferSlice = ByteBuffer.wrap(bArr3).slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr2);
            ByteBuffer byteBufferB6 = b(byteBufferB, 0, 4096);
            byteBufferB6.position();
            int iRemaining = byteBufferB6.remaining();
            loop1: while (true) {
                i3 = 0;
                while (iRemaining > 0) {
                    int iMin = Math.min(iRemaining, 4096 - i3);
                    byteBufferB6.limit(byteBufferB6.position() + iMin);
                    messageDigest.update(byteBufferB6);
                    iRemaining -= iMin;
                    i3 += iMin;
                    if (i3 == 4096) {
                        break;
                    }
                }
                messageDigest.digest(bArr4, 0, 32);
                byteBufferSlice.put(bArr4);
                messageDigest.update(bArr2);
            }
            if (i3 != 0) {
                throw new IllegalStateException("Buffer is not empty: " + i3);
            }
            byteBufferWrap.put(bArr3);
            byteBufferWrap.flip();
        } else {
            j2 = j4;
        }
        if (byteBufferB2 != null) {
            byteBufferB2.order(ByteOrder.LITTLE_ENDIAN);
            long length3 = randomAccessFile.length();
            byte[] bArr5 = a;
            if (bArr5.length != 8) {
                throw new IllegalArgumentException("salt is not 8 bytes long");
            }
            byteBufferB2.put("TrueBrew".getBytes());
            byteBufferB2.put((byte) 1);
            byteBufferB2.put((byte) 0);
            byteBufferB2.put((byte) 12);
            byteBufferB2.put((byte) 7);
            byteBufferB2.putShort((short) 1);
            byteBufferB2.putShort((short) 1);
            byteBufferB2.putInt(0);
            byteBufferB2.putInt(0);
            byteBufferB2.putLong(length3);
            byteBufferB2.put((byte) 2);
            byteBufferB2.put((byte) 0);
            byteBufferB2.put(bArr5);
            byteBufferB2.position(byteBufferB2.position() + 22);
            byteBufferB2.flip();
        }
        if (byteBufferB3 != null) {
            byteBufferB3.order(ByteOrder.LITTLE_ENDIAN);
            long j8 = nVar.f766b;
            long j9 = nVar.f768d;
            byteBufferB3.putInt(24);
            byteBufferB3.putShort((short) 1);
            byteBufferB3.position(byteBufferB3.position() + 2);
            byteBufferB3.putLong(j8);
            byteBufferB3.putLong(j2);
            byteBufferB3.putInt(20);
            byteBufferB3.putShort((short) 2);
            byteBufferB3.position(byteBufferB3.position() + 2);
            byteBufferB3.putLong(j9 + 16);
            byteBufferB3.putInt(e(j8));
            i2 = 4;
            byteBufferB3.position(byteBufferB3.position() + 4);
            byteBufferB3.flip();
        } else {
            i2 = 4;
        }
        byteBufferAllocate.position(byteBufferB3.limit() + i6);
        byteBufferAllocate.putInt(byteBufferB3.limit() + 64 + i2);
        byteBufferAllocate.flip();
        return new a(byteBufferAllocate, bArr);
    }

    public static ByteBuffer b(ByteBuffer byteBuffer, int i2, int i3) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(i3);
        byteBufferDuplicate.position(i2);
        return byteBufferDuplicate.slice();
    }

    public static void c(k kVar, l lVar, int i2) {
        long jA = lVar.a();
        long j2 = 0;
        while (jA > 0) {
            int iMin = (int) Math.min(jA, i2);
            lVar.a(kVar, j2, iMin);
            long j3 = iMin;
            j2 += j3;
            jA -= j3;
        }
    }

    public static int[] d(long j2) {
        ArrayList arrayList = new ArrayList();
        do {
            j2 = (((j2 + PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) - 1) / PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) * 32;
            arrayList.add(Long.valueOf((((j2 + PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) - 1) / PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) * PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        } while (j2 > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        int[] iArr = new int[arrayList.size() + 1];
        int i2 = 0;
        iArr[0] = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            iArr[i3] = e(((Long) arrayList.get((arrayList.size() - i2) - 1)).longValue()) + iArr[i2];
            i2 = i3;
        }
        return iArr;
    }

    public static int e(long j2) {
        int i2 = (int) j2;
        if (i2 == j2) {
            return i2;
        }
        throw new ArithmeticException("integer overflow");
    }
}
