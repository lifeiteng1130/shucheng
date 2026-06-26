package k.a.a.a;

import java.io.PrintStream;
import java.util.Objects;
import k.a.a.a.k0.g1;

/* JADX INFO: compiled from: DefaultErrorStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class n implements b {
    public boolean errorRecoveryMode = false;
    public int lastErrorIndex = -1;
    public k.a.a.a.m0.i lastErrorStates;

    public void beginErrorCondition(w wVar) {
        this.errorRecoveryMode = true;
    }

    public void consumeUntil(w wVar, k.a.a.a.m0.i iVar) {
        int iB = wVar.getInputStream().b(1);
        while (iB != -1 && !iVar.d(iB)) {
            wVar.consume();
            iB = wVar.getInputStream().b(1);
        }
    }

    public void endErrorCondition(w wVar) {
        this.errorRecoveryMode = false;
        this.lastErrorStates = null;
        this.lastErrorIndex = -1;
    }

    public String escapeWSAndQuote(String str) {
        return c.a.a.a.a.k("'", str.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t"), "'");
    }

    public k.a.a.a.m0.i getErrorRecoverySet(w wVar) {
        k.a.a.a.k0.a aVar = wVar.getInterpreter().f8423b;
        k.a.a.a.m0.i iVar = new k.a.a.a.m0.i(new int[0]);
        for (c0 c0Var = wVar._ctx; c0Var != null; c0Var = c0Var.parent) {
            int i2 = c0Var.invokingState;
            if (i2 < 0) {
                break;
            }
            iVar.c(aVar.e(((g1) aVar.a.get(i2).d(0)).f8422d));
        }
        iVar.i(-2);
        return iVar;
    }

    public k.a.a.a.m0.i getExpectedTokens(w wVar) {
        return wVar.getExpectedTokens();
    }

    public d0 getMissingSymbol(w wVar) {
        String string;
        d0 currentToken = wVar.getCurrentToken();
        k.a.a.a.m0.i expectedTokens = getExpectedTokens(wVar);
        int iF = !expectedTokens.g() ? expectedTokens.f() : 0;
        if (iF == -1) {
            string = "<missing EOF>";
        } else {
            StringBuilder sbR = c.a.a.a.a.r("<missing ");
            sbR.append(((i0) wVar.getVocabulary()).a(iF));
            sbR.append(">");
            string = sbR.toString();
        }
        String str = string;
        d0 d0VarC = wVar.getInputStream().c(-1);
        if (currentToken.getType() == -1 && d0VarC != null) {
            currentToken = d0VarC;
        }
        return ((k) wVar.getTokenFactory()).a(new k.a.a.a.m0.k(currentToken.getTokenSource(), currentToken.getTokenSource().getInputStream()), iF, str, 0, -1, -1, currentToken.getLine(), currentToken.getCharPositionInLine());
    }

    public String getSymbolText(d0 d0Var) {
        return d0Var.getText();
    }

    public int getSymbolType(d0 d0Var) {
        return d0Var.getType();
    }

    public String getTokenErrorDisplay(d0 d0Var) {
        if (d0Var == null) {
            return "<no token>";
        }
        String symbolText = getSymbolText(d0Var);
        if (symbolText == null) {
            if (getSymbolType(d0Var) == -1) {
                symbolText = "<EOF>";
            } else {
                StringBuilder sbR = c.a.a.a.a.r("<");
                sbR.append(getSymbolType(d0Var));
                sbR.append(">");
                symbolText = sbR.toString();
            }
        }
        return escapeWSAndQuote(symbolText);
    }

    @Override // k.a.a.a.b
    public boolean inErrorRecoveryMode(w wVar) {
        return this.errorRecoveryMode;
    }

    @Override // k.a.a.a.b
    public void recover(w wVar, a0 a0Var) {
        k.a.a.a.m0.i iVar;
        if (this.lastErrorIndex == wVar.getInputStream().index() && (iVar = this.lastErrorStates) != null && iVar.d(wVar.getState())) {
            wVar.consume();
        }
        this.lastErrorIndex = wVar.getInputStream().index();
        if (this.lastErrorStates == null) {
            this.lastErrorStates = new k.a.a.a.m0.i(new int[0]);
        }
        this.lastErrorStates.a(wVar.getState());
        consumeUntil(wVar, getErrorRecoverySet(wVar));
    }

    @Override // k.a.a.a.b
    public d0 recoverInline(w wVar) {
        d0 d0VarSingleTokenDeletion = singleTokenDeletion(wVar);
        if (d0VarSingleTokenDeletion != null) {
            wVar.consume();
            return d0VarSingleTokenDeletion;
        }
        if (singleTokenInsertion(wVar)) {
            return getMissingSymbol(wVar);
        }
        throw new p(wVar);
    }

    @Override // k.a.a.a.b
    public void reportError(w wVar, a0 a0Var) {
        if (inErrorRecoveryMode(wVar)) {
            return;
        }
        beginErrorCondition(wVar);
        if (a0Var instanceof v) {
            reportNoViableAlternative(wVar, (v) a0Var);
            return;
        }
        if (a0Var instanceof p) {
            reportInputMismatch(wVar, (p) a0Var);
            return;
        }
        if (a0Var instanceof o) {
            reportFailedPredicate(wVar, (o) a0Var);
            return;
        }
        PrintStream printStream = System.err;
        StringBuilder sbR = c.a.a.a.a.r("unknown recognition error type: ");
        sbR.append(a0Var.getClass().getName());
        printStream.println(sbR.toString());
        wVar.notifyErrorListeners(a0Var.getOffendingToken(), a0Var.getMessage(), a0Var);
    }

    public void reportFailedPredicate(w wVar, o oVar) {
        StringBuilder sbU = c.a.a.a.a.u("rule ", wVar.getRuleNames()[wVar._ctx.getRuleIndex()], " ");
        sbU.append(oVar.getMessage());
        wVar.notifyErrorListeners(oVar.getOffendingToken(), sbU.toString(), oVar);
    }

    public void reportInputMismatch(w wVar, p pVar) {
        StringBuilder sbR = c.a.a.a.a.r("mismatched input ");
        sbR.append(getTokenErrorDisplay(pVar.getOffendingToken()));
        sbR.append(" expecting ");
        sbR.append(pVar.getExpectedTokens().m(wVar.getVocabulary()));
        wVar.notifyErrorListeners(pVar.getOffendingToken(), sbR.toString(), pVar);
    }

    @Override // k.a.a.a.b
    public void reportMatch(w wVar) {
        endErrorCondition(wVar);
    }

    public void reportMissingToken(w wVar) {
        if (inErrorRecoveryMode(wVar)) {
            return;
        }
        beginErrorCondition(wVar);
        d0 currentToken = wVar.getCurrentToken();
        k.a.a.a.m0.i expectedTokens = getExpectedTokens(wVar);
        StringBuilder sbR = c.a.a.a.a.r("missing ");
        sbR.append(expectedTokens.m(wVar.getVocabulary()));
        sbR.append(" at ");
        sbR.append(getTokenErrorDisplay(currentToken));
        wVar.notifyErrorListeners(currentToken, sbR.toString(), null);
    }

    public void reportNoViableAlternative(w wVar, v vVar) {
        g0 inputStream = wVar.getInputStream();
        String strE = inputStream != null ? vVar.getStartToken().getType() == -1 ? "<EOF>" : inputStream.e(vVar.getStartToken(), vVar.getOffendingToken()) : "<unknown input>";
        StringBuilder sbR = c.a.a.a.a.r("no viable alternative at input ");
        sbR.append(escapeWSAndQuote(strE));
        wVar.notifyErrorListeners(vVar.getOffendingToken(), sbR.toString(), vVar);
    }

    public void reportUnwantedToken(w wVar) {
        if (inErrorRecoveryMode(wVar)) {
            return;
        }
        beginErrorCondition(wVar);
        d0 currentToken = wVar.getCurrentToken();
        String tokenErrorDisplay = getTokenErrorDisplay(currentToken);
        k.a.a.a.m0.i expectedTokens = getExpectedTokens(wVar);
        StringBuilder sbU = c.a.a.a.a.u("extraneous input ", tokenErrorDisplay, " expecting ");
        sbU.append(expectedTokens.m(wVar.getVocabulary()));
        wVar.notifyErrorListeners(currentToken, sbU.toString(), null);
    }

    @Override // k.a.a.a.b
    public void reset(w wVar) {
        endErrorCondition(wVar);
    }

    public d0 singleTokenDeletion(w wVar) {
        if (!getExpectedTokens(wVar).d(wVar.getInputStream().b(2))) {
            return null;
        }
        reportUnwantedToken(wVar);
        wVar.consume();
        d0 currentToken = wVar.getCurrentToken();
        reportMatch(wVar);
        return currentToken;
    }

    public boolean singleTokenInsertion(w wVar) {
        if (!wVar.getInterpreter().f8423b.f(wVar.getInterpreter().f8423b.a.get(wVar.getState()).d(0).f8448b, wVar._ctx).d(wVar.getInputStream().b(1))) {
            return false;
        }
        reportMissingToken(wVar);
        return true;
    }

    @Override // k.a.a.a.b
    public void sync(w wVar) {
        k.a.a.a.k0.i iVar = wVar.getInterpreter().f8423b.a.get(wVar.getState());
        if (inErrorRecoveryMode(wVar)) {
            return;
        }
        int iB = wVar.getInputStream().b(1);
        k.a.a.a.m0.i iVarE = wVar.getATN().e(iVar);
        if (iVarE.d(-2) || iVarE.d(iB)) {
            return;
        }
        int iC = iVar.c();
        if (iC != 3 && iC != 4 && iC != 5) {
            switch (iC) {
                case 9:
                case 11:
                    reportUnwantedToken(wVar);
                    k.a.a.a.m0.i expectedTokens = wVar.getExpectedTokens();
                    k.a.a.a.m0.i errorRecoverySet = getErrorRecoverySet(wVar);
                    Objects.requireNonNull(expectedTokens);
                    k.a.a.a.m0.i iVar2 = new k.a.a.a.m0.i(new int[0]);
                    iVar2.c(expectedTokens);
                    iVar2.c(errorRecoverySet);
                    consumeUntil(wVar, iVar2);
                    return;
                case 10:
                    break;
                default:
                    return;
            }
        }
        if (singleTokenDeletion(wVar) == null) {
            throw new p(wVar);
        }
    }
}
