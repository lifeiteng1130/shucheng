package e.b.a.r.n.c;

/* JADX INFO: compiled from: ParseError.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6070b;

    public b(int i2, String str) {
        this.a = i2;
        this.f6070b = str;
    }

    public String toString() {
        return this.a + ": " + this.f6070b;
    }

    public b(int i2, String str, Object... objArr) {
        this.f6070b = String.format(str, objArr);
        this.a = i2;
    }
}
