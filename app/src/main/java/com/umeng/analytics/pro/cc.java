package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMemoryInputTransport.java */
/* JADX INFO: loaded from: classes.dex */
public final class cc extends cd {
    private byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4804c;

    public cc() {
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.cd
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cd
    public void b() {
    }

    @Override // com.umeng.analytics.pro.cd
    public void b(byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.cd
    public void c() {
    }

    public void c(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.f4803b = i2;
        this.f4804c = i2 + i3;
    }

    public void e() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.cd
    public byte[] f() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.cd
    public int g() {
        return this.f4803b;
    }

    @Override // com.umeng.analytics.pro.cd
    public int h() {
        return this.f4804c - this.f4803b;
    }

    public cc(byte[] bArr) {
        a(bArr);
    }

    @Override // com.umeng.analytics.pro.cd
    public int a(byte[] bArr, int i2, int i3) {
        int iH = h();
        if (i3 > iH) {
            i3 = iH;
        }
        if (i3 > 0) {
            System.arraycopy(this.a, this.f4803b, bArr, i2, i3);
            a(i3);
        }
        return i3;
    }

    public cc(byte[] bArr, int i2, int i3) {
        c(bArr, i2, i3);
    }

    @Override // com.umeng.analytics.pro.cd
    public void a(int i2) {
        this.f4803b += i2;
    }
}
