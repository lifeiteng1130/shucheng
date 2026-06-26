package com.umeng.analytics.pro;

/* JADX INFO: compiled from: ShortStack.java */
/* JADX INFO: loaded from: classes.dex */
public class ao {
    private short[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4702b = -1;

    public ao(int i2) {
        this.a = new short[i2];
    }

    private void d() {
        short[] sArr = this.a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.a = sArr2;
    }

    public short a() {
        short[] sArr = this.a;
        int i2 = this.f4702b;
        this.f4702b = i2 - 1;
        return sArr[i2];
    }

    public short b() {
        return this.a[this.f4702b];
    }

    public void c() {
        this.f4702b = -1;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("<ShortStack vector:[");
        for (int i2 = 0; i2 < this.a.length; i2++) {
            if (i2 != 0) {
                sbR.append(" ");
            }
            if (i2 == this.f4702b) {
                sbR.append(">>");
            }
            sbR.append((int) this.a[i2]);
            if (i2 == this.f4702b) {
                sbR.append("<<");
            }
        }
        sbR.append("]>");
        return sbR.toString();
    }

    public void a(short s) {
        if (this.a.length == this.f4702b + 1) {
            d();
        }
        short[] sArr = this.a;
        int i2 = this.f4702b + 1;
        this.f4702b = i2;
        sArr[i2] = s;
    }
}
