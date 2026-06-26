package k.a.a.a;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import k.a.a.a.k0.a1;
import k.a.a.a.k0.e1;
import k.a.a.a.k0.g1;
import k.a.a.a.k0.t0;

/* JADX INFO: compiled from: ParserInterpreter.java */
/* JADX INFO: loaded from: classes3.dex */
public class x extends w {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k.a.a.a.k0.a f8524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k.a.a.a.l0.b[] f8525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a1 f8526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public final String[] f8527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f8528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h0 f8529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Deque<k.a.a.a.m0.k<y, Integer>> f8530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8534l;
    public r m;

    public x(String str, h0 h0Var, Collection<String> collection, k.a.a.a.k0.a aVar, g0 g0Var) {
        super(g0Var);
        this.f8526d = new a1();
        this.f8530h = new ArrayDeque();
        this.f8531i = -1;
        this.f8532j = -1;
        this.f8533k = -1;
        this.f8534l = false;
        this.a = str;
        this.f8524b = aVar;
        this.f8527e = new String[aVar.f8379f];
        int i2 = 0;
        while (true) {
            String[] strArr = this.f8527e;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = ((i0) h0Var).a(i2);
            i2++;
        }
        this.f8528f = (String[]) collection.toArray(new String[collection.size()]);
        this.f8529g = h0Var;
        int iD = aVar.d();
        this.f8525c = new k.a.a.a.l0.b[iD];
        for (int i3 = 0; i3 < iD; i3++) {
            this.f8525c[i3] = new k.a.a.a.l0.b(aVar.b(i3), i3);
        }
        setInterpreter(new t0(this, aVar, this.f8525c, this.f8526d));
    }

    public y a(int i2) {
        e1 e1Var = this.f8524b.f8376c[i2];
        r rVar = new r(null, -1, i2);
        this.m = rVar;
        if (e1Var.f8414h) {
            enterRecursionRule(rVar, e1Var.f8432b, i2, 0);
        } else {
            enterRule(rVar, e1Var.f8432b, i2);
        }
        while (true) {
            k.a.a.a.k0.i iVar = this.f8524b.a.get(getState());
            if (iVar.c() != 7) {
                try {
                    b(iVar);
                } catch (a0 e2) {
                    setState(this.f8524b.f8377d[iVar.f8433c].f8432b);
                    getContext().exception = e2;
                    getErrorHandler().reportError(this, e2);
                    int iIndex = this._input.index();
                    getErrorHandler().recover(this, e2);
                    if (this._input.index() == iIndex) {
                        if (e2 instanceof p) {
                            p pVar = (p) e2;
                            d0 offendingToken = e2.getOffendingToken();
                            d0 d0VarA = ((k) getTokenFactory()).a(new k.a.a.a.m0.k(offendingToken.getTokenSource(), offendingToken.getTokenSource().getInputStream()), !pVar.getExpectedTokens().g() ? pVar.getExpectedTokens().f() : 0, offendingToken.getText(), 0, -1, -1, offendingToken.getLine(), offendingToken.getCharPositionInLine());
                            y yVar = this._ctx;
                            yVar.addErrorNode(createErrorNode(yVar, d0VarA));
                        } else {
                            d0 offendingToken2 = e2.getOffendingToken();
                            d0 d0VarA2 = ((k) getTokenFactory()).a(new k.a.a.a.m0.k(offendingToken2.getTokenSource(), offendingToken2.getTokenSource().getInputStream()), 0, offendingToken2.getText(), 0, -1, -1, offendingToken2.getLine(), offendingToken2.getCharPositionInLine());
                            y yVar2 = this._ctx;
                            yVar2.addErrorNode(createErrorNode(yVar2, d0VarA2));
                        }
                    }
                }
            } else {
                if (this._ctx.isEmpty()) {
                    break;
                }
                if (this.f8524b.f8376c[iVar.f8433c].f8414h) {
                    k.a.a.a.m0.k<y, Integer> kVarPop = this.f8530h.pop();
                    unrollRecursionContexts(kVarPop.a);
                    setState(kVarPop.f8516b.intValue());
                } else {
                    exitRule();
                }
                setState(((g1) this.f8524b.a.get(getState()).d(0)).f8422d.f8432b);
            }
        }
        if (!e1Var.f8414h) {
            exitRule();
            return this.m;
        }
        y yVar3 = this._ctx;
        unrollRecursionContexts(this.f8530h.pop().a);
        return yVar3;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(k.a.a.a.k0.i r6) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.x.b(k.a.a.a.k0.i):void");
    }

    @Override // k.a.a.a.w
    public void enterRecursionRule(y yVar, int i2, int i3, int i4) {
        this.f8530h.push(new k.a.a.a.m0.k<>(this._ctx, Integer.valueOf(yVar.invokingState)));
        super.enterRecursionRule(yVar, i2, i3, i4);
    }

    @Override // k.a.a.a.b0
    public k.a.a.a.k0.a getATN() {
        return this.f8524b;
    }

    @Override // k.a.a.a.b0
    public String getGrammarFileName() {
        return this.a;
    }

    @Override // k.a.a.a.b0
    public String[] getRuleNames() {
        return this.f8528f;
    }

    @Override // k.a.a.a.b0
    @Deprecated
    public String[] getTokenNames() {
        return this.f8527e;
    }

    @Override // k.a.a.a.b0
    public h0 getVocabulary() {
        return this.f8529g;
    }

    @Override // k.a.a.a.w
    public void reset() {
        super.reset();
        this.f8534l = false;
    }
}
