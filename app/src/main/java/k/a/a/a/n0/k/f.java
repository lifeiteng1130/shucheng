package k.a.a.a.n0.k;

/* JADX INFO: compiled from: TextChunk.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends a {
    public final String a;

    public f(String str) {
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        this.a = str;
    }

    public String toString() {
        return c.a.a.a.a.p(c.a.a.a.a.r("'"), this.a, "'");
    }
}
