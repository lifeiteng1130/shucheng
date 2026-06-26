package f.c0.c;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Lambda.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k<R> implements g<R>, Serializable {
    private final int arity;

    public k(int i2) {
        this.arity = i2;
    }

    @Override // f.c0.c.g
    public int getArity() {
        return this.arity;
    }

    @NotNull
    public String toString() {
        String strA = v.a.a(this);
        j.d(strA, "Reflection.renderLambdaToString(this)");
        return strA;
    }
}
