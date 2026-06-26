package c.e.c.y.r.f;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ExpandedRow.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final List<a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1498c;

    public b(List<a> list, int i2, boolean z) {
        this.a = new ArrayList(list);
        this.f1497b = i2;
        this.f1498c = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.f1498c == bVar.f1498c;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.f1498c).hashCode();
    }

    public String toString() {
        return "{ " + this.a + " }";
    }
}
