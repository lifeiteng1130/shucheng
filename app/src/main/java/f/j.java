package f;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public j(A a, B b2, C c2) {
        this.first = a;
        this.second = b2;
        this.third = c2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ j copy$default(j jVar, Object obj, Object obj2, Object obj3, int i2, Object obj4) {
        if ((i2 & 1) != 0) {
            obj = jVar.first;
        }
        if ((i2 & 2) != 0) {
            obj2 = jVar.second;
        }
        if ((i2 & 4) != 0) {
            obj3 = jVar.third;
        }
        return jVar.copy(obj, obj2, obj3);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    @NotNull
    public final j<A, B, C> copy(A a, B b2, C c2) {
        return new j<>(a, b2, c2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return f.c0.c.j.a(this.first, jVar.first) && f.c0.c.j.a(this.second, jVar.second) && f.c0.c.j.a(this.third, jVar.third);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a = this.first;
        int iHashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.second;
        int iHashCode2 = (iHashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c2 = this.third;
        return iHashCode2 + (c2 != null ? c2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sbQ = c.a.a.a.a.q('(');
        sbQ.append(this.first);
        sbQ.append(", ");
        sbQ.append(this.second);
        sbQ.append(", ");
        sbQ.append(this.third);
        sbQ.append(')');
        return sbQ.toString();
    }
}
