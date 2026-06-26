package k.a.a.a;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import k.a.a.a.k0.b1;
import k.a.a.a.k0.c1;
import k.a.a.a.k0.g1;
import k.a.a.a.k0.s0;
import k.a.a.a.k0.t0;
import k.a.a.a.n0.k.c;

/* JADX INFO: compiled from: Parser.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w extends b0<d0, t0> {
    private static final Map<String, k.a.a.a.k0.a> bypassAltsAtnCache = new WeakHashMap();
    public boolean _buildParseTrees;
    public y _ctx;
    public k.a.a.a.b _errHandler = new n();
    public g0 _input;
    public List<k.a.a.a.n0.e> _parseListeners;
    public final k.a.a.a.m0.g _precedenceStack;
    public int _syntaxErrors;
    private a _tracer;
    public boolean matchedEOF;

    /* JADX INFO: compiled from: Parser.java */
    public class a implements k.a.a.a.n0.e {
        public a() {
        }

        @Override // k.a.a.a.n0.e
        public void enterEveryRule(y yVar) {
            PrintStream printStream = System.out;
            StringBuilder sbR = c.a.a.a.a.r("enter   ");
            sbR.append(w.this.getRuleNames()[yVar.getRuleIndex()]);
            sbR.append(", LT(1)=");
            sbR.append(w.this._input.c(1).getText());
            printStream.println(sbR.toString());
        }

        @Override // k.a.a.a.n0.e
        public void exitEveryRule(y yVar) {
            PrintStream printStream = System.out;
            StringBuilder sbR = c.a.a.a.a.r("exit    ");
            sbR.append(w.this.getRuleNames()[yVar.getRuleIndex()]);
            sbR.append(", LT(1)=");
            sbR.append(w.this._input.c(1).getText());
            printStream.println(sbR.toString());
        }

        @Override // k.a.a.a.n0.e
        public void visitErrorNode(k.a.a.a.n0.b bVar) {
        }

        @Override // k.a.a.a.n0.e
        public void visitTerminal(k.a.a.a.n0.h hVar) {
            PrintStream printStream = System.out;
            StringBuilder sbR = c.a.a.a.a.r("consume ");
            sbR.append(hVar.a());
            sbR.append(" rule ");
            sbR.append(w.this.getRuleNames()[w.this._ctx.getRuleIndex()]);
            printStream.println(sbR.toString());
        }
    }

    /* JADX INFO: compiled from: Parser.java */
    public static class b implements k.a.a.a.n0.e {
        public static final b a = new b();

        @Override // k.a.a.a.n0.e
        public void enterEveryRule(y yVar) {
        }

        @Override // k.a.a.a.n0.e
        public void exitEveryRule(y yVar) {
            List<k.a.a.a.n0.d> list = yVar.children;
            if (list instanceof ArrayList) {
                ((ArrayList) list).trimToSize();
            }
        }

        @Override // k.a.a.a.n0.e
        public void visitErrorNode(k.a.a.a.n0.b bVar) {
        }

        @Override // k.a.a.a.n0.e
        public void visitTerminal(k.a.a.a.n0.h hVar) {
        }
    }

    public w(g0 g0Var) {
        k.a.a.a.m0.g gVar = new k.a.a.a.m0.g();
        this._precedenceStack = gVar;
        gVar.b(0);
        this._buildParseTrees = true;
        setInputStream(g0Var);
    }

    public void addContextToParseTree() {
        y yVar = this._ctx;
        y yVar2 = (y) yVar.parent;
        if (yVar2 != null) {
            yVar2.addChild(yVar);
        }
    }

    public void addParseListener(k.a.a.a.n0.e eVar) {
        Objects.requireNonNull(eVar, "listener");
        if (this._parseListeners == null) {
            this._parseListeners = new ArrayList();
        }
        this._parseListeners.add(eVar);
    }

    public k.a.a.a.n0.k.b compileParseTreePattern(String str, int i2) {
        if (getTokenStream() != null) {
            f0 tokenSource = getTokenStream().getTokenSource();
            if (tokenSource instanceof s) {
                return compileParseTreePattern(str, i2, (s) tokenSource);
            }
        }
        throw new UnsupportedOperationException("Parser can't discover a lexer to use");
    }

    public d0 consume() {
        d0 currentToken = getCurrentToken();
        if (currentToken.getType() != -1) {
            getInputStream().g();
        }
        List<k.a.a.a.n0.e> list = this._parseListeners;
        boolean z = (list == null || list.isEmpty()) ? false : true;
        if (this._buildParseTrees || z) {
            if (this._errHandler.inErrorRecoveryMode(this)) {
                y yVar = this._ctx;
                k.a.a.a.n0.b bVarAddErrorNode = yVar.addErrorNode(createErrorNode(yVar, currentToken));
                List<k.a.a.a.n0.e> list2 = this._parseListeners;
                if (list2 != null) {
                    Iterator<k.a.a.a.n0.e> it = list2.iterator();
                    while (it.hasNext()) {
                        it.next().visitErrorNode(bVarAddErrorNode);
                    }
                }
            } else {
                y yVar2 = this._ctx;
                k.a.a.a.n0.h hVarAddChild = yVar2.addChild(createTerminalNode(yVar2, currentToken));
                List<k.a.a.a.n0.e> list3 = this._parseListeners;
                if (list3 != null) {
                    Iterator<k.a.a.a.n0.e> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        it2.next().visitTerminal(hVarAddChild);
                    }
                }
            }
        }
        return currentToken;
    }

    public k.a.a.a.n0.b createErrorNode(y yVar, d0 d0Var) {
        return new k.a.a.a.n0.c(d0Var);
    }

    public k.a.a.a.n0.h createTerminalNode(y yVar, d0 d0Var) {
        return new k.a.a.a.n0.i(d0Var);
    }

    public void dumpDFA() {
        synchronized (((t0) this._interp).f8454f) {
            int i2 = 0;
            boolean z = false;
            while (true) {
                ATNInterpreter atninterpreter = this._interp;
                if (i2 < ((t0) atninterpreter).f8454f.length) {
                    k.a.a.a.l0.b bVar = ((t0) atninterpreter).f8454f[i2];
                    if (!bVar.a.isEmpty()) {
                        if (z) {
                            System.out.println();
                        }
                        System.out.println("Decision " + bVar.f8483c + ":");
                        System.out.print(bVar.b(getVocabulary()));
                        z = true;
                    }
                    i2++;
                }
            }
        }
    }

    public void enterOuterAlt(y yVar, int i2) {
        y yVar2;
        y yVar3;
        yVar.setAltNumber(i2);
        if (this._buildParseTrees && (yVar2 = this._ctx) != yVar && (yVar3 = (y) yVar2.parent) != null) {
            yVar3.removeLastChild();
            yVar3.addChild(yVar);
        }
        this._ctx = yVar;
    }

    @Deprecated
    public void enterRecursionRule(y yVar, int i2) {
        enterRecursionRule(yVar, getATN().f8376c[i2].f8432b, i2, 0);
    }

    public void enterRule(y yVar, int i2, int i3) {
        setState(i2);
        this._ctx = yVar;
        yVar.start = this._input.c(1);
        if (this._buildParseTrees) {
            addContextToParseTree();
        }
        if (this._parseListeners != null) {
            triggerEnterRuleEvent();
        }
    }

    public void exitRule() {
        if (this.matchedEOF) {
            this._ctx.stop = this._input.c(1);
        } else {
            this._ctx.stop = this._input.c(-1);
        }
        if (this._parseListeners != null) {
            triggerExitRuleEvent();
        }
        setState(this._ctx.invokingState);
        this._ctx = (y) this._ctx.parent;
    }

    public k.a.a.a.k0.a getATNWithBypassAlts() {
        k.a.a.a.k0.a aVarB;
        String serializedATN = getSerializedATN();
        if (serializedATN == null) {
            throw new UnsupportedOperationException("The current parser does not support an ATN with bypass alternatives.");
        }
        Map<String, k.a.a.a.k0.a> map = bypassAltsAtnCache;
        synchronized (map) {
            aVarB = map.get(serializedATN);
            if (aVarB == null) {
                k.a.a.a.k0.d dVar = new k.a.a.a.k0.d();
                if (dVar.f8408b) {
                    throw new IllegalStateException("The object is read only.");
                }
                dVar.f8409c = true;
                aVarB = new k.a.a.a.k0.g(dVar).b(serializedATN.toCharArray());
                map.put(serializedATN, aVarB);
            }
        }
        return aVarB;
    }

    public boolean getBuildParseTree() {
        return this._buildParseTrees;
    }

    public y getContext() {
        return this._ctx;
    }

    public d0 getCurrentToken() {
        return this._input.c(1);
    }

    public List<String> getDFAStrings() {
        ArrayList arrayList;
        synchronized (((t0) this._interp).f8454f) {
            arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                ATNInterpreter atninterpreter = this._interp;
                if (i2 < ((t0) atninterpreter).f8454f.length) {
                    arrayList.add(((t0) atninterpreter).f8454f[i2].b(getVocabulary()));
                    i2++;
                }
            }
        }
        return arrayList;
    }

    public k.a.a.a.b getErrorHandler() {
        return this._errHandler;
    }

    public k.a.a.a.m0.i getExpectedTokens() {
        return getATN().c(getState(), getContext());
    }

    public k.a.a.a.m0.i getExpectedTokensWithinCurrentRule() {
        k.a.a.a.k0.a aVar = getInterpreter().f8423b;
        return aVar.e(aVar.a.get(getState()));
    }

    public y getInvokingContext(int i2) {
        for (y yVar = this._ctx; yVar != null; yVar = (y) yVar.parent) {
            if (yVar.getRuleIndex() == i2) {
                return yVar;
            }
        }
        return null;
    }

    public int getNumberOfSyntaxErrors() {
        return this._syntaxErrors;
    }

    @Override // k.a.a.a.b0
    public s0 getParseInfo() {
        t0 interpreter = getInterpreter();
        if (interpreter instanceof c1) {
            return new s0((c1) interpreter);
        }
        return null;
    }

    public List<k.a.a.a.n0.e> getParseListeners() {
        List<k.a.a.a.n0.e> list = this._parseListeners;
        return list == null ? Collections.emptyList() : list;
    }

    public final int getPrecedence() {
        k.a.a.a.m0.g gVar = this._precedenceStack;
        int i2 = gVar.f8509c;
        if (i2 == 0) {
            return -1;
        }
        int i3 = i2 - 1;
        if (i3 < 0 || i3 >= i2) {
            throw new IndexOutOfBoundsException();
        }
        return gVar.f8508b[i3];
    }

    public y getRuleContext() {
        return this._ctx;
    }

    public int getRuleIndex(String str) {
        Integer num = getRuleIndexMap().get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public List<String> getRuleInvocationStack() {
        return getRuleInvocationStack(this._ctx);
    }

    public String getSourceName() {
        return this._input.getSourceName();
    }

    @Override // k.a.a.a.b0, k.a.a.a.f0
    public e0<?> getTokenFactory() {
        return this._input.getTokenSource().getTokenFactory();
    }

    public g0 getTokenStream() {
        return this._input;
    }

    public boolean getTrimParseTree() {
        return getParseListeners().contains(b.a);
    }

    public boolean inContext(String str) {
        return false;
    }

    public boolean isExpectedToken(int i2) {
        k.a.a.a.k0.a aVar = getInterpreter().f8423b;
        k.a.a.a.m0.i iVarE = aVar.e(aVar.a.get(getState()));
        if (iVarE.d(i2)) {
            return true;
        }
        if (!iVarE.d(-2)) {
            return false;
        }
        for (y yVar = this._ctx; yVar != null && yVar.invokingState >= 0 && iVarE.d(-2); yVar = (y) yVar.parent) {
            iVarE = aVar.e(((g1) aVar.a.get(yVar.invokingState).d(0)).f8422d);
            if (iVarE.d(i2)) {
                return true;
            }
        }
        return iVarE.d(-2) && i2 == -1;
    }

    public boolean isMatchedEOF() {
        return this.matchedEOF;
    }

    public boolean isTrace() {
        return this._tracer != null;
    }

    public d0 match(int i2) {
        d0 currentToken = getCurrentToken();
        if (currentToken.getType() == i2) {
            if (i2 == -1) {
                this.matchedEOF = true;
            }
            this._errHandler.reportMatch(this);
            consume();
        } else {
            currentToken = this._errHandler.recoverInline(this);
            if (this._buildParseTrees && currentToken.getTokenIndex() == -1) {
                y yVar = this._ctx;
                yVar.addErrorNode(createErrorNode(yVar, currentToken));
            }
        }
        return currentToken;
    }

    public d0 matchWildcard() {
        d0 currentToken = getCurrentToken();
        if (currentToken.getType() > 0) {
            this._errHandler.reportMatch(this);
            consume();
        } else {
            currentToken = this._errHandler.recoverInline(this);
            if (this._buildParseTrees && currentToken.getTokenIndex() == -1) {
                y yVar = this._ctx;
                yVar.addErrorNode(createErrorNode(yVar, currentToken));
            }
        }
        return currentToken;
    }

    public final void notifyErrorListeners(String str) {
        notifyErrorListeners(getCurrentToken(), str, null);
    }

    @Override // k.a.a.a.b0
    public boolean precpred(c0 c0Var, int i2) {
        k.a.a.a.m0.g gVar = this._precedenceStack;
        int i3 = gVar.f8509c;
        int i4 = i3 - 1;
        if (i4 < 0 || i4 >= i3) {
            throw new IndexOutOfBoundsException();
        }
        return i2 >= gVar.f8508b[i4];
    }

    public void pushNewRecursionContext(y yVar, int i2, int i3) {
        y yVar2 = this._ctx;
        yVar2.parent = yVar;
        yVar2.invokingState = i2;
        yVar2.stop = this._input.c(-1);
        this._ctx = yVar;
        yVar.start = yVar2.start;
        if (this._buildParseTrees) {
            yVar.addChild(yVar2);
        }
        if (this._parseListeners != null) {
            triggerEnterRuleEvent();
        }
    }

    public void removeParseListener(k.a.a.a.n0.e eVar) {
        List<k.a.a.a.n0.e> list = this._parseListeners;
        if (list != null && list.remove(eVar) && this._parseListeners.isEmpty()) {
            this._parseListeners = null;
        }
    }

    public void removeParseListeners() {
        this._parseListeners = null;
    }

    public void reset() {
        if (getInputStream() != null) {
            getInputStream().a(0);
        }
        this._errHandler.reset(this);
        this._ctx = null;
        this._syntaxErrors = 0;
        this.matchedEOF = false;
        setTrace(false);
        k.a.a.a.m0.g gVar = this._precedenceStack;
        Arrays.fill(gVar.f8508b, 0, gVar.f8509c, 0);
        gVar.f8509c = 0;
        this._precedenceStack.b(0);
        t0 interpreter = getInterpreter();
        if (interpreter != null) {
            interpreter.a();
        }
    }

    public void setBuildParseTree(boolean z) {
        this._buildParseTrees = z;
    }

    public void setContext(y yVar) {
        this._ctx = yVar;
    }

    public void setErrorHandler(k.a.a.a.b bVar) {
        this._errHandler = bVar;
    }

    @Override // k.a.a.a.b0
    public final void setInputStream(q qVar) {
        setTokenStream((g0) qVar);
    }

    public void setProfile(boolean z) {
        t0 interpreter = getInterpreter();
        b1 b1Var = interpreter.f8455g;
        if (z) {
            if (!(interpreter instanceof c1)) {
                setInterpreter(new c1(this));
            }
        } else if (interpreter instanceof c1) {
            setInterpreter(new t0(this, getATN(), interpreter.f8454f, interpreter.f8424c));
        }
        getInterpreter().f8455g = b1Var;
    }

    @Override // k.a.a.a.b0, k.a.a.a.f0
    public void setTokenFactory(e0<?> e0Var) {
        this._input.getTokenSource().setTokenFactory(e0Var);
    }

    public void setTokenStream(g0 g0Var) {
        this._input = null;
        reset();
        this._input = g0Var;
    }

    public void setTrace(boolean z) {
        if (!z) {
            removeParseListener(this._tracer);
            this._tracer = null;
            return;
        }
        a aVar = this._tracer;
        if (aVar != null) {
            removeParseListener(aVar);
        } else {
            this._tracer = new a();
        }
        addParseListener(this._tracer);
    }

    public void setTrimParseTree(boolean z) {
        if (!z) {
            removeParseListener(b.a);
        } else {
            if (getTrimParseTree()) {
                return;
            }
            addParseListener(b.a);
        }
    }

    public void triggerEnterRuleEvent() {
        for (k.a.a.a.n0.e eVar : this._parseListeners) {
            eVar.enterEveryRule(this._ctx);
            this._ctx.enterRule(eVar);
        }
    }

    public void triggerExitRuleEvent() {
        for (int size = this._parseListeners.size() - 1; size >= 0; size--) {
            k.a.a.a.n0.e eVar = this._parseListeners.get(size);
            this._ctx.exitRule(eVar);
            eVar.exitEveryRule(this._ctx);
        }
    }

    public void unrollRecursionContexts(y yVar) {
        this._precedenceStack.a();
        this._ctx.stop = this._input.c(-1);
        y yVar2 = this._ctx;
        if (this._parseListeners != null) {
            while (this._ctx != yVar) {
                triggerExitRuleEvent();
                this._ctx = (y) this._ctx.parent;
            }
        } else {
            this._ctx = yVar;
        }
        yVar2.parent = yVar;
        if (!this._buildParseTrees || yVar == null) {
            return;
        }
        yVar.addChild(yVar2);
    }

    public void enterRecursionRule(y yVar, int i2, int i3, int i4) {
        setState(i2);
        this._precedenceStack.b(i4);
        this._ctx = yVar;
        yVar.start = this._input.c(1);
        if (this._parseListeners != null) {
            triggerEnterRuleEvent();
        }
    }

    @Override // k.a.a.a.b0, k.a.a.a.f0
    public g0 getInputStream() {
        return getTokenStream();
    }

    public List<String> getRuleInvocationStack(c0 c0Var) {
        String[] ruleNames = getRuleNames();
        ArrayList arrayList = new ArrayList();
        while (c0Var != null) {
            int ruleIndex = c0Var.getRuleIndex();
            if (ruleIndex < 0) {
                arrayList.add("n/a");
            } else {
                arrayList.add(ruleNames[ruleIndex]);
            }
            c0Var = c0Var.parent;
        }
        return arrayList;
    }

    public void notifyErrorListeners(d0 d0Var, String str, a0 a0Var) {
        this._syntaxErrors++;
        getErrorListenerDispatch().syntaxError(this, d0Var, d0Var.getLine(), d0Var.getCharPositionInLine(), str, a0Var);
    }

    public k.a.a.a.n0.k.b compileParseTreePattern(String str, int i2, s sVar) {
        int iIntValue;
        k.a.a.a.n0.k.c cVar = new k.a.a.a.n0.k.c(sVar, this);
        int length = str.length();
        ArrayList<k.a.a.a.n0.k.a> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i3 = 0;
        while (i3 < length) {
            if (i3 == str.indexOf("\\<", i3) || i3 == str.indexOf("\\>", i3)) {
                i3 += 2;
            } else {
                if (i3 == str.indexOf("<", i3)) {
                    arrayList2.add(Integer.valueOf(i3));
                } else if (i3 == str.indexOf(">", i3)) {
                    arrayList3.add(Integer.valueOf(i3));
                }
                i3++;
            }
        }
        if (arrayList2.size() <= arrayList3.size()) {
            if (arrayList2.size() >= arrayList3.size()) {
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    if (((Integer) arrayList2.get(i4)).intValue() >= ((Integer) arrayList3.get(i4)).intValue()) {
                        throw new IllegalArgumentException(c.a.a.a.a.i("tag delimiters out of order in pattern: ", str));
                    }
                }
                if (size == 0) {
                    arrayList.add(new k.a.a.a.n0.k.f(str.substring(0, length)));
                }
                if (size > 0 && ((Integer) arrayList2.get(0)).intValue() > 0) {
                    arrayList.add(new k.a.a.a.n0.k.f(str.substring(0, ((Integer) arrayList2.get(0)).intValue())));
                }
                int i5 = 0;
                while (i5 < size) {
                    String strSubstring = str.substring(((Integer) arrayList2.get(i5)).intValue() + 1, ((Integer) arrayList3.get(i5)).intValue());
                    String strSubstring2 = null;
                    int iIndexOf = strSubstring.indexOf(58);
                    if (iIndexOf >= 0) {
                        strSubstring2 = strSubstring.substring(0, iIndexOf);
                        strSubstring = strSubstring.substring(iIndexOf + 1, strSubstring.length());
                    }
                    arrayList.add(new k.a.a.a.n0.k.e(strSubstring2, strSubstring));
                    int i6 = i5 + 1;
                    if (i6 < size) {
                        arrayList.add(new k.a.a.a.n0.k.f(str.substring(((Integer) arrayList3.get(i5)).intValue() + 1, ((Integer) arrayList2.get(i6)).intValue())));
                    }
                    i5 = i6;
                }
                if (size > 0 && (iIntValue = ((Integer) arrayList3.get(size - 1)).intValue() + 1) < length) {
                    arrayList.add(new k.a.a.a.n0.k.f(str.substring(iIntValue, length)));
                }
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    k.a.a.a.n0.k.a aVar = (k.a.a.a.n0.k.a) arrayList.get(i7);
                    if (aVar instanceof k.a.a.a.n0.k.f) {
                        k.a.a.a.n0.k.f fVar = (k.a.a.a.n0.k.f) aVar;
                        String strReplace = fVar.a.replace("\\", "");
                        if (strReplace.length() < fVar.a.length()) {
                            arrayList.set(i7, new k.a.a.a.n0.k.f(strReplace));
                        }
                    }
                }
                ArrayList arrayList4 = new ArrayList();
                for (k.a.a.a.n0.k.a aVar2 : arrayList) {
                    if (aVar2 instanceof k.a.a.a.n0.k.e) {
                        k.a.a.a.n0.k.e eVar = (k.a.a.a.n0.k.e) aVar2;
                        if (Character.isUpperCase(eVar.a.charAt(0))) {
                            Integer numValueOf = Integer.valueOf(cVar.f8517b.getTokenType(eVar.a));
                            if (numValueOf.intValue() != 0) {
                                arrayList4.add(new k.a.a.a.n0.k.g(eVar.a, numValueOf.intValue(), eVar.f8520b));
                            } else {
                                StringBuilder sbR = c.a.a.a.a.r("Unknown token ");
                                sbR.append(eVar.a);
                                sbR.append(" in pattern: ");
                                sbR.append(str);
                                throw new IllegalArgumentException(sbR.toString());
                            }
                        } else if (Character.isLowerCase(eVar.a.charAt(0))) {
                            int ruleIndex = cVar.f8517b.getRuleIndex(eVar.a);
                            if (ruleIndex != -1) {
                                arrayList4.add(new k.a.a.a.n0.k.d(eVar.a, cVar.f8517b.getATNWithBypassAlts().f8380g[ruleIndex], eVar.f8520b));
                            } else {
                                StringBuilder sbR2 = c.a.a.a.a.r("Unknown rule ");
                                sbR2.append(eVar.a);
                                sbR2.append(" in pattern: ");
                                sbR2.append(str);
                                throw new IllegalArgumentException(sbR2.toString());
                            }
                        } else {
                            StringBuilder sbR3 = c.a.a.a.a.r("invalid tag: ");
                            sbR3.append(eVar.a);
                            sbR3.append(" in pattern: ");
                            sbR3.append(str);
                            throw new IllegalArgumentException(sbR3.toString());
                        }
                    } else {
                        cVar.a.setInputStream(new c(((k.a.a.a.n0.k.f) aVar2).a));
                        for (d0 d0VarNextToken = cVar.a.nextToken(); d0VarNextToken.getType() != -1; d0VarNextToken = cVar.a.nextToken()) {
                            arrayList4.add(d0VarNextToken);
                        }
                    }
                }
                l lVar = new l(new u(arrayList4));
                x xVar = new x(cVar.f8517b.getGrammarFileName(), cVar.f8517b.getVocabulary(), Arrays.asList(cVar.f8517b.getRuleNames()), cVar.f8517b.getATNWithBypassAlts(), lVar);
                try {
                    xVar.setErrorHandler(new d());
                    y yVarA = xVar.a(i2);
                    if (lVar.b(1) == -1) {
                        return new k.a.a.a.n0.k.b(cVar, str, i2, yVarA);
                    }
                    throw new c.b();
                } catch (a0 e2) {
                    throw e2;
                } catch (k.a.a.a.m0.l e3) {
                    throw ((a0) e3.getCause());
                } catch (Exception e4) {
                    throw new c.a(e4);
                }
            }
            throw new IllegalArgumentException(c.a.a.a.a.i("missing start tag in pattern: ", str));
        }
        throw new IllegalArgumentException(c.a.a.a.a.i("unterminated tag in pattern: ", str));
    }
}
