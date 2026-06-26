package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TField.java */
/* JADX INFO: loaded from: classes.dex */
public class bk {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f4761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f4762c;

    public bk() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(bk bkVar) {
        return this.f4761b == bkVar.f4761b && this.f4762c == bkVar.f4762c;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("<TField name:'");
        sbR.append(this.a);
        sbR.append("' type:");
        sbR.append((int) this.f4761b);
        sbR.append(" field-id:");
        return c.a.a.a.a.o(sbR, this.f4762c, ">");
    }

    public bk(String str, byte b2, short s) {
        this.a = str;
        this.f4761b = b2;
        this.f4762c = s;
    }
}
