package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMessage.java */
/* JADX INFO: loaded from: classes.dex */
public final class bn {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f4766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4767c;

    public bn() {
        this("", (byte) 0, 0);
    }

    public boolean a(bn bnVar) {
        return this.a.equals(bnVar.a) && this.f4766b == bnVar.f4766b && this.f4767c == bnVar.f4767c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bn) {
            return a((bn) obj);
        }
        return false;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("<TMessage name:'");
        sbR.append(this.a);
        sbR.append("' type: ");
        sbR.append((int) this.f4766b);
        sbR.append(" seqid:");
        return c.a.a.a.a.o(sbR, this.f4767c, ">");
    }

    public bn(String str, byte b2, int i2) {
        this.a = str;
        this.f4766b = b2;
        this.f4767c = i2;
    }
}
