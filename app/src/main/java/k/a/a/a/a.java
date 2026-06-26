package k.a.a.a;

import java.util.BitSet;

/* JADX INFO: compiled from: ANTLRErrorListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a {
    void reportAmbiguity(w wVar, k.a.a.a.l0.b bVar, int i2, int i3, boolean z, BitSet bitSet, k.a.a.a.k0.c cVar);

    void reportAttemptingFullContext(w wVar, k.a.a.a.l0.b bVar, int i2, int i3, BitSet bitSet, k.a.a.a.k0.c cVar);

    void reportContextSensitivity(w wVar, k.a.a.a.l0.b bVar, int i2, int i3, int i4, k.a.a.a.k0.c cVar);

    void syntaxError(b0<?, ?> b0Var, Object obj, int i2, int i3, String str, a0 a0Var);
}
