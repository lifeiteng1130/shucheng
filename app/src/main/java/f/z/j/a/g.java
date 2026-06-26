package f.z.j.a;

import f.c0.c.j;
import f.c0.c.v;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
public abstract class g extends c implements f.c0.c.g<Object> {
    private final int arity;

    public g(int i2, @Nullable f.z.d<Object> dVar) {
        super(dVar);
        this.arity = i2;
    }

    @Override // f.c0.c.g
    public int getArity() {
        return this.arity;
    }

    @Override // f.z.j.a.a
    @NotNull
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strA = v.a.a(this);
        j.d(strA, "Reflection.renderLambdaToString(this)");
        return strA;
    }

    public g(int i2) {
        this(i2, null);
    }
}
