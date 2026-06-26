package c.e.c.y.r;

/* JADX INFO: compiled from: DataCharacter.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1484b;

    public b(int i2, int i3) {
        this.a = i2;
        this.f1484b = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.f1484b == bVar.f1484b;
    }

    public final int hashCode() {
        return this.a ^ this.f1484b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("(");
        return c.a.a.a.a.n(sb, this.f1484b, ')');
    }
}
