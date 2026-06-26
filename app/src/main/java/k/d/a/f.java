package k.d.a;

/* JADX INFO: compiled from: FieldOrMethodRef.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8785d = -1;

    public f(String str, String str2, String str3) {
        this.a = str;
        this.f8783b = str2;
        this.f8784c = str3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a.equals(fVar.a) && this.f8783b.equals(fVar.f8783b) && this.f8784c.equals(fVar.f8784c);
    }

    public int hashCode() {
        if (this.f8785d == -1) {
            this.f8785d = (this.a.hashCode() ^ this.f8783b.hashCode()) ^ this.f8784c.hashCode();
        }
        return this.f8785d;
    }
}
