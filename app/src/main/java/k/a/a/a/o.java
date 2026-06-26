package k.a.a.a;

import java.util.Locale;
import k.a.a.a.k0.y0;

/* JADX INFO: compiled from: FailedPredicateException.java */
/* JADX INFO: loaded from: classes3.dex */
public class o extends a0 {
    private final String predicate;
    private final int predicateIndex;
    private final int ruleIndex;

    public o(w wVar) {
        this(wVar, null);
    }

    public int getPredIndex() {
        return this.predicateIndex;
    }

    public String getPredicate() {
        return this.predicate;
    }

    public int getRuleIndex() {
        return this.ruleIndex;
    }

    public o(w wVar, String str) {
        this(wVar, str, null);
    }

    public o(w wVar, String str, String str2) {
        super(str2 == null ? String.format(Locale.getDefault(), "failed predicate: {%s}?", str) : str2, wVar, wVar.getInputStream(), wVar._ctx);
        k.a.a.a.k0.k kVar = (k.a.a.a.k0.k) wVar.getInterpreter().f8423b.a.get(wVar.getState()).d(0);
        if (kVar instanceof y0) {
            y0 y0Var = (y0) kVar;
            this.ruleIndex = y0Var.f8477c;
            this.predicateIndex = y0Var.f8478d;
        } else {
            this.ruleIndex = 0;
            this.predicateIndex = 0;
        }
        this.predicate = str;
        setOffendingToken(wVar.getCurrentToken());
    }
}
