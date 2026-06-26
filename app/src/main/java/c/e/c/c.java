package c.e.c;

/* JADX INFO: compiled from: BinaryBitmap.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.e.c.v.b f1343b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.a = bVar;
    }

    public c.e.c.v.b a() {
        if (this.f1343b == null) {
            this.f1343b = this.a.b();
        }
        return this.f1343b;
    }

    public String toString() {
        try {
            return a().toString();
        } catch (k unused) {
            return "";
        }
    }
}
