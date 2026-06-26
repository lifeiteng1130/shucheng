package k.a.a.a;

/* JADX INFO: compiled from: NoViableAltException.java */
/* JADX INFO: loaded from: classes3.dex */
public class v extends a0 {
    private final k.a.a.a.k0.c deadEndConfigs;
    private final d0 startToken;

    public v(w wVar) {
        this(wVar, wVar.getInputStream(), wVar.getCurrentToken(), wVar.getCurrentToken(), null, wVar._ctx);
    }

    public k.a.a.a.k0.c getDeadEndConfigs() {
        return this.deadEndConfigs;
    }

    public d0 getStartToken() {
        return this.startToken;
    }

    public v(w wVar, g0 g0Var, d0 d0Var, d0 d0Var2, k.a.a.a.k0.c cVar, y yVar) {
        super(wVar, g0Var, yVar);
        this.deadEndConfigs = cVar;
        this.startToken = d0Var;
        setOffendingToken(d0Var2);
    }
}
