package com.tencent.bugly.beta.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static long a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f4017b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f4018c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f4019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f4020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f4021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f4022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BufferedInputStream f4024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f4025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f4026k;

    public a(String str) {
        this.f4019d = new byte[2];
        this.f4020e = new byte[4];
        this.f4021f = new byte[8];
        this.f4022g = f4018c;
        this.f4023h = null;
        this.f4024i = null;
        this.f4025j = 0L;
        this.f4026k = 0L;
        this.f4023h = str;
        this.f4024i = new BufferedInputStream(new FileInputStream(this.f4023h));
        this.f4025j = 0L;
        this.f4026k = 0L;
    }

    public synchronized void a(long j2) {
        this.f4022g = j2;
    }

    public synchronized boolean b(long j2) {
        if (this.f4024i == null) {
            return false;
        }
        if (j2 == 0) {
            return true;
        }
        long jSkip = j2;
        while (jSkip > 0) {
            try {
                jSkip -= this.f4024i.skip(jSkip);
            } catch (IOException unused) {
                return false;
            }
        }
        this.f4025j += j2;
        return true;
    }

    public synchronized int c() {
        BufferedInputStream bufferedInputStream = this.f4024i;
        if (bufferedInputStream == null) {
            return 0;
        }
        bufferedInputStream.read(this.f4020e);
        int iA = a(this.f4020e, this.f4022g);
        this.f4025j += 4;
        this.f4026k += 4;
        return iA;
    }

    public synchronized long d() {
        BufferedInputStream bufferedInputStream = this.f4024i;
        if (bufferedInputStream == null) {
            return 0L;
        }
        bufferedInputStream.read(this.f4021f);
        long jB = b(this.f4021f, this.f4022g);
        this.f4025j += 8;
        this.f4026k += 8;
        return jB;
    }

    public synchronized short e() {
        BufferedInputStream bufferedInputStream = this.f4024i;
        if (bufferedInputStream == null) {
            return (short) 0;
        }
        bufferedInputStream.read(this.f4019d);
        short sC = c(this.f4019d, this.f4022g);
        this.f4025j += 2;
        this.f4026k += 2;
        return sC;
    }

    public synchronized long f() {
        return ((long) b()) & 255;
    }

    public synchronized long g() {
        return ((long) c()) & 4294967295L;
    }

    public synchronized long h() {
        return d();
    }

    public synchronized long i() {
        return ((long) e()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    private static short f(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) b(bArr);
    }

    private static short g(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) c(bArr);
    }

    public synchronized boolean a() {
        try {
            BufferedInputStream bufferedInputStream = this.f4024i;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            this.f4024i = null;
            this.f4023h = null;
            this.f4025j = 0L;
            this.f4026k = 0L;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    public synchronized byte b() {
        BufferedInputStream bufferedInputStream = this.f4024i;
        if (bufferedInputStream == null) {
            return (byte) 0;
        }
        byte b2 = (byte) bufferedInputStream.read();
        this.f4025j++;
        this.f4026k++;
        return b2;
    }

    private static int c(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) e(bArr);
    }

    private static long d(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j2 = 0;
        for (byte b2 : bArr) {
            j2 = (j2 << 8) | (((long) b2) & 255);
        }
        return j2;
    }

    private static long e(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j2 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            j2 = (j2 << 8) | (((long) bArr[length]) & 255);
        }
        return j2;
    }

    public static short c(byte[] bArr, long j2) {
        if (j2 == f4018c) {
            return g(bArr);
        }
        return f(bArr);
    }

    public synchronized boolean a(byte[] bArr) {
        try {
            this.f4024i.read(bArr);
            this.f4025j += (long) bArr.length;
            this.f4026k += (long) bArr.length;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    private static int b(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) d(bArr);
    }

    public static int a(byte[] bArr, long j2) {
        if (j2 == f4018c) {
            return c(bArr);
        }
        return b(bArr);
    }

    public static long b(byte[] bArr, long j2) {
        if (j2 == f4018c) {
            return e(bArr);
        }
        return d(bArr);
    }

    public a(String str, long j2) {
        this.f4019d = new byte[2];
        this.f4020e = new byte[4];
        this.f4021f = new byte[8];
        this.f4022g = f4018c;
        this.f4023h = null;
        this.f4024i = null;
        this.f4025j = 0L;
        this.f4026k = 0L;
        this.f4023h = str;
        this.f4022g = j2;
        this.f4024i = new BufferedInputStream(new FileInputStream(this.f4023h));
        this.f4025j = 0L;
        this.f4026k = 0L;
    }
}
