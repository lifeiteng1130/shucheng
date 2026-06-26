package g.b;

import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MainCoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o1 extends y {
    @NotNull
    public abstract o1 n();

    @InternalCoroutinesApi
    @Nullable
    public final String o() {
        o1 o1VarN;
        y yVar = k0.a;
        o1 o1Var = g.b.g2.m.f6207b;
        if (this == o1Var) {
            return "Dispatchers.Main";
        }
        try {
            o1VarN = o1Var.n();
        } catch (UnsupportedOperationException unused) {
            o1VarN = null;
        }
        if (this == o1VarN) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // g.b.y
    @NotNull
    public String toString() {
        String strO = o();
        if (strO != null) {
            return strO;
        }
        return getClass().getSimpleName() + '@' + c.b.a.m.f.v2(this);
    }
}
