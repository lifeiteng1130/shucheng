package k.a.a.a;

/* JADX INFO: compiled from: BailErrorStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends n {
    @Override // k.a.a.a.n, k.a.a.a.b
    public void recover(w wVar, a0 a0Var) {
        for (y context = wVar.getContext(); context != null; context = context.mo33getParent()) {
            context.exception = a0Var;
        }
        throw new k.a.a.a.m0.l(a0Var);
    }

    @Override // k.a.a.a.n, k.a.a.a.b
    public d0 recoverInline(w wVar) {
        p pVar = new p(wVar);
        for (y context = wVar.getContext(); context != null; context = context.mo33getParent()) {
            context.exception = pVar;
        }
        throw new k.a.a.a.m0.l(pVar);
    }

    @Override // k.a.a.a.n, k.a.a.a.b
    public void sync(w wVar) {
    }
}
