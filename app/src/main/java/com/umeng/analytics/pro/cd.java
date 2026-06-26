package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TTransport.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class cd {
    public abstract int a(byte[] bArr, int i2, int i3);

    public void a(int i2) {
    }

    public abstract boolean a();

    public abstract void b();

    public void b(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i2, int i3);

    public abstract void c();

    public int d(byte[] bArr, int i2, int i3) throws ce {
        int i4 = 0;
        while (i4 < i3) {
            int iA = a(bArr, i2 + i4, i3 - i4);
            if (iA <= 0) {
                throw new ce("Cannot read. Remote side has closed. Tried to read " + i3 + " bytes, but only got " + i4 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i4 += iA;
        }
        return i4;
    }

    public void d() {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }
}
