package c.e.c.y.r.f;

/* JADX INFO: compiled from: ExpandedPair.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final c.e.c.y.r.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.e.c.y.r.b f1495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.e.c.y.r.c f1496c;

    public a(c.e.c.y.r.b bVar, c.e.c.y.r.b bVar2, c.e.c.y.r.c cVar, boolean z) {
        this.a = bVar;
        this.f1495b = bVar2;
        this.f1496c = cVar;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a(this.a, aVar.a) && a(this.f1495b, aVar.f1495b) && a(this.f1496c, aVar.f1496c);
    }

    public int hashCode() {
        return (b(this.a) ^ b(this.f1495b)) ^ b(this.f1496c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.a);
        sb.append(" , ");
        sb.append(this.f1495b);
        sb.append(" : ");
        c.e.c.y.r.c cVar = this.f1496c;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.a));
        sb.append(" ]");
        return sb.toString();
    }
}
