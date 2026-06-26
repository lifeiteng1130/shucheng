package k.a.a.a.n0;

import k.a.a.a.d0;

/* JADX INFO: compiled from: ErrorNodeImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends i implements b {
    public c(d0 d0Var) {
        super(d0Var);
    }

    @Override // k.a.a.a.n0.i, k.a.a.a.n0.d
    public <T> T accept(f<? extends T> fVar) {
        return fVar.visitErrorNode(this);
    }
}
