package c.e.c.z.d;

/* JADX INFO: compiled from: Codeword.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1539e = -1;

    public d(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.f1536b = i3;
        this.f1537c = i4;
        this.f1538d = i5;
    }

    public boolean a() {
        int i2 = this.f1539e;
        return i2 != -1 && this.f1537c == (i2 % 3) * 3;
    }

    public void b() {
        this.f1539e = (this.f1537c / 3) + ((this.f1538d / 30) * 3);
    }

    public String toString() {
        return this.f1539e + "|" + this.f1538d;
    }
}
