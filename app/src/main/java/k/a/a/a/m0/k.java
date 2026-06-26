package k.a.a.a.m0;

import java.io.Serializable;

/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes3.dex */
public class k<A, B> implements Serializable {
    public final A a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f8516b;

    public k(A a, B b2) {
        this.a = a;
        this.f8516b = b2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        A a = this.a;
        A a2 = kVar.a;
        if (a == null ? a2 == null : a.equals(a2)) {
            B b2 = this.f8516b;
            B b3 = kVar.f8516b;
            if (b2 == null ? b3 == null : b2.equals(b3)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return c.b.a.m.f.I1(c.b.a.m.f.Y5(c.b.a.m.f.Y5(0, this.a), this.f8516b), 2);
    }

    public String toString() {
        return String.format("(%s, %s)", this.a, this.f8516b);
    }
}
