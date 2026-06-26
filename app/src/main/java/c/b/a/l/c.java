package c.b.a.l;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: GifHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f292c;
    public final byte[] a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f293d = 0;

    public final boolean a() {
        return this.f292c.f281b != 0;
    }

    @NonNull
    public b b() {
        if (this.f291b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (a()) {
            return this.f292c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) c());
        }
        if (sb.toString().startsWith("GIF")) {
            this.f292c.f285f = f();
            this.f292c.f286g = f();
            int iC = c();
            b bVar = this.f292c;
            bVar.f287h = (iC & 128) != 0;
            bVar.f288i = (int) Math.pow(2.0d, (iC & 7) + 1);
            this.f292c.f289j = c();
            b bVar2 = this.f292c;
            c();
            Objects.requireNonNull(bVar2);
            if (this.f292c.f287h && !a()) {
                b bVar3 = this.f292c;
                bVar3.a = e(bVar3.f288i);
                b bVar4 = this.f292c;
                bVar4.f290k = bVar4.a[bVar4.f289j];
            }
        } else {
            this.f292c.f281b = 1;
        }
        if (!a()) {
            boolean z = false;
            while (!z && !a() && this.f292c.f282c <= Integer.MAX_VALUE) {
                int iC2 = c();
                if (iC2 == 33) {
                    int iC3 = c();
                    if (iC3 == 1) {
                        g();
                    } else if (iC3 == 249) {
                        this.f292c.f283d = new a();
                        c();
                        int iC4 = c();
                        a aVar = this.f292c.f283d;
                        int i3 = (iC4 & 28) >> 2;
                        aVar.f276g = i3;
                        if (i3 == 0) {
                            aVar.f276g = 1;
                        }
                        aVar.f275f = (iC4 & 1) != 0;
                        int iF = f();
                        if (iF < 2) {
                            iF = 10;
                        }
                        a aVar2 = this.f292c.f283d;
                        aVar2.f278i = iF * 10;
                        aVar2.f277h = c();
                        c();
                    } else if (iC3 == 254) {
                        g();
                    } else if (iC3 != 255) {
                        g();
                    } else {
                        d();
                        StringBuilder sb2 = new StringBuilder();
                        for (int i4 = 0; i4 < 11; i4++) {
                            sb2.append((char) this.a[i4]);
                        }
                        if (sb2.toString().equals("NETSCAPE2.0")) {
                            do {
                                d();
                                byte[] bArr = this.a;
                                if (bArr[0] == 1) {
                                    byte b2 = bArr[1];
                                    byte b3 = bArr[2];
                                    Objects.requireNonNull(this.f292c);
                                }
                                if (this.f293d > 0) {
                                }
                            } while (!a());
                        } else {
                            g();
                        }
                    }
                } else if (iC2 == 44) {
                    b bVar5 = this.f292c;
                    if (bVar5.f283d == null) {
                        bVar5.f283d = new a();
                    }
                    bVar5.f283d.a = f();
                    this.f292c.f283d.f271b = f();
                    this.f292c.f283d.f272c = f();
                    this.f292c.f283d.f273d = f();
                    int iC5 = c();
                    boolean z2 = (iC5 & 128) != 0;
                    int iPow = (int) Math.pow(2.0d, (iC5 & 7) + 1);
                    a aVar3 = this.f292c.f283d;
                    aVar3.f274e = (iC5 & 64) != 0;
                    if (z2) {
                        aVar3.f280k = e(iPow);
                    } else {
                        aVar3.f280k = null;
                    }
                    this.f292c.f283d.f279j = this.f291b.position();
                    c();
                    g();
                    if (!a()) {
                        b bVar6 = this.f292c;
                        bVar6.f282c++;
                        bVar6.f284e.add(bVar6.f283d);
                    }
                } else if (iC2 != 59) {
                    this.f292c.f281b = 1;
                } else {
                    z = true;
                }
            }
            b bVar7 = this.f292c;
            if (bVar7.f282c < 0) {
                bVar7.f281b = 1;
            }
        }
        return this.f292c;
    }

    public final int c() {
        try {
            return this.f291b.get() & ExifInterface.MARKER;
        } catch (Exception unused) {
            this.f292c.f281b = 1;
            return 0;
        }
    }

    public final void d() {
        int iC = c();
        this.f293d = iC;
        if (iC <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            try {
                int i3 = this.f293d;
                if (i2 >= i3) {
                    return;
                }
                int i4 = i3 - i2;
                this.f291b.get(this.a, i2, i4);
                i2 += i4;
            } catch (Exception unused) {
                Log.isLoggable("GifHeaderParser", 3);
                this.f292c.f281b = 1;
                return;
            }
        }
    }

    @Nullable
    public final int[] e(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.f291b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = bArr[i4] & ExifInterface.MARKER;
                int i7 = i5 + 1;
                int i8 = bArr[i5] & ExifInterface.MARKER;
                int i9 = i7 + 1;
                int i10 = i3 + 1;
                iArr[i3] = (i6 << 16) | ViewCompat.MEASURED_STATE_MASK | (i8 << 8) | (bArr[i7] & ExifInterface.MARKER);
                i4 = i9;
                i3 = i10;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable("GifHeaderParser", 3);
            this.f292c.f281b = 1;
        }
        return iArr;
    }

    public final int f() {
        return this.f291b.getShort();
    }

    public final void g() {
        int iC;
        do {
            iC = c();
            this.f291b.position(Math.min(this.f291b.position() + iC, this.f291b.limit()));
        } while (iC > 0);
    }
}
