package com.tencent.bugly.beta.utils;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f4058d = null;

    public d(String str, long j2, long j3) {
        this.a = null;
        this.f4056b = 0L;
        this.f4057c = 0L;
        this.a = str;
        this.f4056b = j2;
        this.f4057c = j3;
    }

    private boolean b() {
        return (this.f4056b == 0 || this.f4057c == 0) ? false : true;
    }

    private synchronized boolean c() {
        if (!b()) {
            return false;
        }
        if (this.f4058d == null) {
            try {
                this.f4058d = new a(this.a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public synchronized void a() {
        a aVar = this.f4058d;
        if (aVar == null) {
            return;
        }
        aVar.a();
        this.f4058d = null;
    }

    private synchronized String b(long j2) {
        if (this.f4058d == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            this.f4058d.b(this.f4056b);
            this.f4058d.b(j2);
        } catch (Exception e2) {
            this.f4058d = null;
            e2.printStackTrace();
        }
        while (true) {
            byte b2 = this.f4058d.b();
            if (b2 == 0) {
                break;
            }
            stringBuffer.append((char) b2);
            return stringBuffer.toString();
        }
        this.f4058d.a();
        this.f4058d = new a(this.a);
        return stringBuffer.toString();
    }

    public synchronized String a(long j2) {
        if (j2 >= 0) {
            if (j2 < this.f4057c) {
                if (this.f4058d == null && !c()) {
                    return null;
                }
                return b(j2);
            }
        }
        return null;
    }
}
