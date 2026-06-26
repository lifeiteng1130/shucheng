package k.a.a.a;

/* JADX INFO: compiled from: ANTLRErrorStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public interface b {
    boolean inErrorRecoveryMode(w wVar);

    void recover(w wVar, a0 a0Var);

    d0 recoverInline(w wVar);

    void reportError(w wVar, a0 a0Var);

    void reportMatch(w wVar);

    void reset(w wVar);

    void sync(w wVar);
}
