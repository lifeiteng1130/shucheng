package c.c.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.c.a.i;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface g extends IInterface {

    public static abstract class a extends Binder implements g {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: c.c.a.g$a$a, reason: collision with other inner class name */
        public static class C0029a implements g {
            public IBinder a;

            public C0029a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // c.c.a.g
            public final boolean a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }

            @Override // c.c.a.g
            public final int b(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // c.c.a.g
            public final boolean c(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean zA = ((i.c) this).a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int iB = ((i.c) this).b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iB);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.bytedance.pangle.IPackageManager");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
            boolean zC = ((i.c) this).c(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(zC ? 1 : 0);
            return true;
        }
    }

    public final class b implements Runnable {
        public final /* synthetic */ InputStream a;

        public b(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a));
            while (true) {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            try {
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(line));
                    } finally {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (IOException e2) {
                    ZeusLogger.e(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e2)));
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException unused3) {
                        return;
                    }
                }
            }
        }
    }

    public final class c implements Closeable {
        public final FileInputStream a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b[] f698c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C0030c[] f699d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, C0030c> f700e = new HashMap();

        public static class a {
            public final byte[] a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f701b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f702c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final long f703d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final short f704e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final short f705f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final short f706g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final short f707h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final short f708i;

            public a(FileChannel fileChannel, byte b2) throws IOException {
                byte[] bArr = new byte[16];
                this.a = bArr;
                fileChannel.position(0L);
                fileChannel.read(ByteBuffer.wrap(bArr));
                if (bArr[0] != 127 || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
                    throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
                }
                c.a(bArr[4], 2, "bad elf class: " + ((int) bArr[4]));
                c.a(bArr[5], 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                byteBufferAllocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                c.b(fileChannel, byteBufferAllocate, "failed to read rest part of ehdr.");
                byteBufferAllocate.getShort();
                byteBufferAllocate.getShort();
                int i2 = byteBufferAllocate.getInt();
                this.f701b = i2;
                c.a(i2, 1, "bad elf version: " + i2);
                byte b3 = bArr[4];
                if (b3 == 1) {
                    byteBufferAllocate.getInt();
                    this.f702c = byteBufferAllocate.getInt();
                    this.f703d = byteBufferAllocate.getInt();
                } else {
                    if (b3 != 2) {
                        throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                    }
                    byteBufferAllocate.getLong();
                    this.f702c = byteBufferAllocate.getLong();
                    this.f703d = byteBufferAllocate.getLong();
                }
                byteBufferAllocate.getInt();
                byteBufferAllocate.getShort();
                this.f704e = byteBufferAllocate.getShort();
                this.f705f = byteBufferAllocate.getShort();
                this.f706g = byteBufferAllocate.getShort();
                this.f707h = byteBufferAllocate.getShort();
                this.f708i = byteBufferAllocate.getShort();
            }
        }

        public static class b {
            public b(ByteBuffer byteBuffer, int i2, byte b2) throws IOException {
                if (i2 == 1) {
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    return;
                }
                if (i2 != 2) {
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
                }
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getLong();
                byteBuffer.getLong();
                byteBuffer.getLong();
                byteBuffer.getLong();
                byteBuffer.getLong();
                byteBuffer.getLong();
            }
        }

        /* JADX INFO: renamed from: c.c.a.g$c$c, reason: collision with other inner class name */
        public static class C0030c {
            public final int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f709b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f710c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f711d;

            public C0030c(ByteBuffer byteBuffer, int i2, byte b2) throws IOException {
                if (i2 == 1) {
                    this.a = byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    this.f709b = byteBuffer.getInt();
                    this.f710c = byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                } else {
                    if (i2 != 2) {
                        throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
                    }
                    this.a = byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getLong();
                    byteBuffer.getLong();
                    this.f709b = byteBuffer.getLong();
                    this.f710c = byteBuffer.getLong();
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getLong();
                    byteBuffer.getLong();
                }
                this.f711d = null;
            }
        }

        public c(File file) throws IOException {
            C0030c[] c0030cArr;
            this.f697b = null;
            this.f698c = null;
            this.f699d = null;
            FileInputStream fileInputStream = new FileInputStream(file);
            this.a = fileInputStream;
            FileChannel channel = fileInputStream.getChannel();
            this.f697b = new a(channel, (byte) 0);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
            byteBufferAllocate.limit(this.f697b.f704e);
            byteBufferAllocate.order(this.f697b.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
            channel.position(this.f697b.f702c);
            this.f698c = new b[this.f697b.f705f];
            for (int i2 = 0; i2 < this.f698c.length; i2++) {
                b(channel, byteBufferAllocate, "failed to read phdr.");
                this.f698c[i2] = new b(byteBufferAllocate, this.f697b.a[4], (byte) 0);
            }
            channel.position(this.f697b.f703d);
            byteBufferAllocate.limit(this.f697b.f706g);
            this.f699d = new C0030c[this.f697b.f707h];
            int i3 = 0;
            while (true) {
                c0030cArr = this.f699d;
                if (i3 >= c0030cArr.length) {
                    break;
                }
                b(channel, byteBufferAllocate, "failed to read shdr.");
                this.f699d[i3] = new C0030c(byteBufferAllocate, this.f697b.a[4], (byte) 0);
                i3++;
            }
            short s = this.f697b.f708i;
            if (s > 0) {
                C0030c c0030c = c0030cArr[s];
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate((int) c0030c.f710c);
                this.a.getChannel().position(c0030c.f709b);
                b(this.a.getChannel(), byteBufferAllocate2, "failed to read section: " + c0030c.f711d);
                for (C0030c c0030c2 : this.f699d) {
                    byteBufferAllocate2.position(c0030c2.a);
                    byte[] bArrArray = byteBufferAllocate2.array();
                    int iPosition = byteBufferAllocate2.position();
                    while (byteBufferAllocate2.hasRemaining() && bArrArray[byteBufferAllocate2.position()] != 0) {
                        byteBufferAllocate2.position(byteBufferAllocate2.position() + 1);
                    }
                    byteBufferAllocate2.position(byteBufferAllocate2.position() + 1);
                    String str = new String(bArrArray, iPosition, (byteBufferAllocate2.position() - iPosition) - 1, Charset.forName("ASCII"));
                    c0030c2.f711d = str;
                    this.f700e.put(str, c0030c2);
                }
            }
        }

        public static /* synthetic */ void a(int i2, int i3, String str) throws IOException {
            if (i2 <= 0 || i2 > i3) {
                throw new IOException(str);
            }
        }

        public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
            byteBuffer.rewind();
            int i2 = fileChannel.read(byteBuffer);
            if (i2 == byteBuffer.limit()) {
                byteBuffer.flip();
                return;
            }
            StringBuilder sbT = c.a.a.a.a.t(str, " Rest bytes insufficient, expect to read ");
            sbT.append(byteBuffer.limit());
            sbT.append(" bytes but only ");
            sbT.append(i2);
            sbT.append(" bytes were read.");
            throw new IOException(sbT.toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            this.a.close();
            this.f700e.clear();
            this.f698c = null;
            this.f699d = null;
        }
    }

    boolean a(String str);

    int b(String str);

    boolean c(String str);
}
