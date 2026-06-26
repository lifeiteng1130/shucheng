package k.a.a.a.n0.k;

/* JADX INFO: compiled from: TagChunk.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8520b;

    public e(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("tag cannot be null or empty");
        }
        this.f8520b = str;
        this.a = str2;
    }

    public String toString() {
        if (this.f8520b == null) {
            return this.a;
        }
        return this.f8520b + ":" + this.a;
    }
}
