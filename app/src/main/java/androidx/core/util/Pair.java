package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public class Pair<F, S> {

    @Nullable
    public final F first;

    @Nullable
    public final S second;

    public Pair(@Nullable F f2, @Nullable S s) {
        this.first = f2;
        this.second = s;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(@Nullable A a, @Nullable B b2) {
        return new Pair<>(a, b2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
    }

    public int hashCode() {
        F f2 = this.first;
        int iHashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.second;
        return iHashCode ^ (s != null ? s.hashCode() : 0);
    }

    @NonNull
    public String toString() {
        StringBuilder sbR = a.r("Pair{");
        sbR.append(String.valueOf(this.first));
        sbR.append(" ");
        sbR.append(String.valueOf(this.second));
        sbR.append("}");
        return sbR.toString();
    }
}
