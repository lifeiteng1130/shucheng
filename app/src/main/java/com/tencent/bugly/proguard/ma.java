package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class ma extends AbstractC0320m implements Cloneable {
    public static byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f4392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f4394d;

    public ma() {
        this.f4392b = (byte) 0;
        this.f4393c = "";
        this.f4394d = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4392b, 0);
        c0319l.a(this.f4393c, 1);
        byte[] bArr = this.f4394d;
        if (bArr != null) {
            c0319l.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
    }

    public ma(byte b2, String str, byte[] bArr) {
        this.f4392b = (byte) 0;
        this.f4393c = "";
        this.f4394d = null;
        this.f4392b = b2;
        this.f4393c = str;
        this.f4394d = bArr;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4392b = c0318k.a(this.f4392b, 0, true);
        this.f4393c = c0318k.a(1, true);
        if (a == null) {
            a = new byte[]{0};
        }
        this.f4394d = c0318k.a(a, 2, false);
    }
}
