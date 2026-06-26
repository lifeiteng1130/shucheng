package f;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g<A, B> implements Serializable {
    private final A first;
    private final B second;

    public g(A a, B b2) {
        this.first = a;
        this.second = b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ g copy$default(g gVar, Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = gVar.first;
        }
        if ((i2 & 2) != 0) {
            obj2 = gVar.second;
        }
        return gVar.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    @NotNull
    public final g<A, B> copy(A a, B b2) {
        return new g<>(a, b2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return f.c0.c.j.a(this.first, gVar.first) && f.c0.c.j.a(this.second, gVar.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a = this.first;
        int iHashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.second;
        return iHashCode + (b2 != null ? b2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sbQ = c.a.a.a.a.q('(');
        sbQ.append(this.first);
        sbQ.append(", ");
        sbQ.append(this.second);
        sbQ.append(')');
        return sbQ.toString();
    }
}
