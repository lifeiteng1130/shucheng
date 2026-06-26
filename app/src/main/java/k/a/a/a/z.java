package k.a.a.a;

import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: ProxyErrorListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class z implements a {
    public final Collection<? extends a> a;

    public z(Collection<? extends a> collection) {
        Objects.requireNonNull(collection, "delegates");
        this.a = collection;
    }

    @Override // k.a.a.a.a
    public void reportAmbiguity(w wVar, k.a.a.a.l0.b bVar, int i2, int i3, boolean z, BitSet bitSet, k.a.a.a.k0.c cVar) {
        Iterator<? extends a> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().reportAmbiguity(wVar, bVar, i2, i3, z, bitSet, cVar);
        }
    }

    @Override // k.a.a.a.a
    public void reportAttemptingFullContext(w wVar, k.a.a.a.l0.b bVar, int i2, int i3, BitSet bitSet, k.a.a.a.k0.c cVar) {
        Iterator<? extends a> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().reportAttemptingFullContext(wVar, bVar, i2, i3, bitSet, cVar);
        }
    }

    @Override // k.a.a.a.a
    public void reportContextSensitivity(w wVar, k.a.a.a.l0.b bVar, int i2, int i3, int i4, k.a.a.a.k0.c cVar) {
        Iterator<? extends a> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().reportContextSensitivity(wVar, bVar, i2, i3, i4, cVar);
        }
    }

    @Override // k.a.a.a.a
    public void syntaxError(b0<?, ?> b0Var, Object obj, int i2, int i3, String str, a0 a0Var) {
        Iterator<? extends a> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().syntaxError(b0Var, obj, i2, i3, str, a0Var);
        }
    }
}
