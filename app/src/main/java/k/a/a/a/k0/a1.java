package k.a.a.a.k0;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PredictionContextCache.java */
/* JADX INFO: loaded from: classes3.dex */
public class a1 {
    public final Map<z0, z0> a = new HashMap();

    public z0 a(z0 z0Var) {
        x xVar = z0.a;
        if (z0Var == xVar) {
            return xVar;
        }
        z0 z0Var2 = this.a.get(z0Var);
        if (z0Var2 != null) {
            return z0Var2;
        }
        this.a.put(z0Var, z0Var);
        return z0Var;
    }
}
