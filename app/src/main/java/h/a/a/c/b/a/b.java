package h.a.a.c.b.a;

import android.os.Build;
import j$.util.List;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BOMInputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends d {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f6319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f6320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f6321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6325i;

    public b(InputStream inputStream, boolean z, c... cVarArr) {
        super(inputStream);
        if ((cVarArr == null ? 0 : cVarArr.length) == 0) {
            throw new IllegalArgumentException("No BOMs specified");
        }
        this.f6318b = z;
        List<c> listAsList = Arrays.asList(cVarArr);
        if (Build.VERSION.SDK_INT >= 24) {
            List.EL.sort(listAsList, a.a);
        }
        this.f6319c = listAsList;
    }

    public c a() {
        c next;
        boolean z;
        if (this.f6321e == null) {
            this.f6322f = 0;
            this.f6321e = new int[this.f6319c.get(0).length()];
            int i2 = 0;
            while (true) {
                int[] iArr = this.f6321e;
                if (i2 >= iArr.length) {
                    break;
                }
                iArr[i2] = ((FilterInputStream) this).in.read();
                this.f6322f++;
                if (this.f6321e[i2] < 0) {
                    break;
                }
                i2++;
            }
            Iterator<c> it = this.f6319c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                int i3 = 0;
                while (true) {
                    if (i3 >= next.length()) {
                        z = true;
                        break;
                    }
                    if (next.get(i3) != this.f6321e[i3]) {
                        z = false;
                        break;
                    }
                    i3++;
                }
                if (z) {
                    break;
                }
            }
            this.f6320d = next;
            if (next != null && !this.f6318b) {
                if (next.length() < this.f6321e.length) {
                    this.f6323g = this.f6320d.length();
                } else {
                    this.f6322f = 0;
                }
            }
        }
        return this.f6320d;
    }

    public final int b() {
        a();
        int i2 = this.f6323g;
        if (i2 >= this.f6322f) {
            return -1;
        }
        int[] iArr = this.f6321e;
        this.f6323g = i2 + 1;
        return iArr[i2];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.f6324h = this.f6323g;
        this.f6325i = this.f6321e == null;
        ((FilterInputStream) this).in.mark(i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int iB = b();
        return iB >= 0 ? iB : ((FilterInputStream) this).in.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        this.f6323g = this.f6324h;
        if (this.f6325i) {
            this.f6321e = null;
        }
        ((FilterInputStream) this).in.reset();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) {
        long j3;
        int i2 = 0;
        while (true) {
            j3 = i2;
            if (j2 <= j3 || b() < 0) {
                break;
            }
            i2++;
        }
        return ((FilterInputStream) this).in.skip(j2 - j3) + j3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        int iB = 0;
        int i4 = 0;
        while (i3 > 0 && iB >= 0) {
            iB = b();
            if (iB >= 0) {
                bArr[i2] = (byte) (iB & 255);
                i3--;
                i4++;
                i2++;
            }
        }
        int i5 = ((FilterInputStream) this).in.read(bArr, i2, i3);
        if (i5 >= 0) {
            return i4 + i5;
        }
        if (i4 > 0) {
            return i4;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }
}
