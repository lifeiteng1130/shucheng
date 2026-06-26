package k.a.a.a;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import k.a.a.a.k0.h;
import k.a.a.a.k0.s0;

/* JADX INFO: compiled from: Recognizer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b0<Symbol, ATNInterpreter extends k.a.a.a.k0.h> {
    public static final int EOF = -1;
    public ATNInterpreter _interp;
    private List<k.a.a.a.a> _listeners = new a();
    private int _stateNumber = -1;
    private static final Map<h0, Map<String, Integer>> tokenTypeMapCache = new WeakHashMap();
    private static final Map<String[], Map<String, Integer>> ruleIndexMapCache = new WeakHashMap();

    /* JADX INFO: compiled from: Recognizer.java */
    public class a extends CopyOnWriteArrayList<k.a.a.a.a> implements j$.util.List {
        public a() {
            add(m.a);
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Q1.v(j$.time.a.A(this), true);
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // j$.util.List
        public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
            List.CC.$default$replaceAll(this, unaryOperator);
        }

        @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, j$.util.List
        public /* synthetic */ void sort(Comparator comparator) {
            List.CC.$default$sort(this, comparator);
        }

        @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return List.CC.$default$spliterator(this);
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Q1.v(j$.time.a.A(this), false);
        }
    }

    public void action(c0 c0Var, int i2, int i3) {
    }

    public void addErrorListener(k.a.a.a.a aVar) {
        Objects.requireNonNull(aVar, "listener cannot be null.");
        this._listeners.add(aVar);
    }

    public abstract k.a.a.a.k0.a getATN();

    public String getErrorHeader(a0 a0Var) {
        return c.a.a.a.a.e("line ", a0Var.getOffendingToken().getLine(), ":", a0Var.getOffendingToken().getCharPositionInLine());
    }

    public k.a.a.a.a getErrorListenerDispatch() {
        return new z(getErrorListeners());
    }

    public java.util.List<? extends k.a.a.a.a> getErrorListeners() {
        return this._listeners;
    }

    public abstract String getGrammarFileName();

    public abstract q getInputStream();

    public ATNInterpreter getInterpreter() {
        return this._interp;
    }

    public s0 getParseInfo() {
        return null;
    }

    public Map<String, Integer> getRuleIndexMap() {
        Map<String, Integer> mapUnmodifiableMap;
        String[] ruleNames = getRuleNames();
        if (ruleNames == null) {
            throw new UnsupportedOperationException("The current recognizer does not provide a list of rule names.");
        }
        Map<String[], Map<String, Integer>> map = ruleIndexMapCache;
        synchronized (map) {
            mapUnmodifiableMap = map.get(ruleNames);
            if (mapUnmodifiableMap == null) {
                HashMap map2 = new HashMap();
                for (int i2 = 0; i2 < ruleNames.length; i2++) {
                    map2.put(ruleNames[i2], Integer.valueOf(i2));
                }
                mapUnmodifiableMap = Collections.unmodifiableMap(map2);
                ruleIndexMapCache.put(ruleNames, mapUnmodifiableMap);
            }
        }
        return mapUnmodifiableMap;
    }

    public abstract String[] getRuleNames();

    public String getSerializedATN() {
        throw new UnsupportedOperationException("there is no serialized ATN");
    }

    public final int getState() {
        return this._stateNumber;
    }

    @Deprecated
    public String getTokenErrorDisplay(d0 d0Var) {
        if (d0Var == null) {
            return "<no token>";
        }
        String text = d0Var.getText();
        if (text == null) {
            if (d0Var.getType() == -1) {
                text = "<EOF>";
            } else {
                StringBuilder sbR = c.a.a.a.a.r("<");
                sbR.append(d0Var.getType());
                sbR.append(">");
                text = sbR.toString();
            }
        }
        return c.a.a.a.a.k("'", text.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t"), "'");
    }

    public abstract e0<?> getTokenFactory();

    @Deprecated
    public abstract String[] getTokenNames();

    public int getTokenType(String str) {
        Integer num = getTokenTypeMap().get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public Map<String, Integer> getTokenTypeMap() {
        Map<String, Integer> mapUnmodifiableMap;
        h0 vocabulary = getVocabulary();
        Map<h0, Map<String, Integer>> map = tokenTypeMapCache;
        synchronized (map) {
            mapUnmodifiableMap = map.get(vocabulary);
            if (mapUnmodifiableMap == null) {
                HashMap map2 = new HashMap();
                for (int i2 = 0; i2 <= getATN().f8379f; i2++) {
                    i0 i0Var = (i0) vocabulary;
                    String strB = i0Var.b(i2);
                    if (strB != null) {
                        map2.put(strB, Integer.valueOf(i2));
                    }
                    String strC = i0Var.c(i2);
                    if (strC != null) {
                        map2.put(strC, Integer.valueOf(i2));
                    }
                }
                map2.put("EOF", -1);
                mapUnmodifiableMap = Collections.unmodifiableMap(map2);
                tokenTypeMapCache.put(vocabulary, mapUnmodifiableMap);
            }
        }
        return mapUnmodifiableMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k.a.a.a.h0 getVocabulary() {
        /*
            r8 = this;
            java.lang.String[] r0 = r8.getTokenNames()
            java.lang.String[] r1 = k.a.a.a.i0.a
            if (r0 == 0) goto L4c
            int r1 = r0.length
            if (r1 != 0) goto Lc
            goto L4c
        Lc:
            int r1 = r0.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r0, r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r2 = r0.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r0, r2)
            java.lang.String[] r2 = (java.lang.String[]) r2
            r3 = 0
            r4 = 0
        L1c:
            int r5 = r0.length
            if (r4 >= r5) goto L46
            r5 = r0[r4]
            if (r5 != 0) goto L24
            goto L43
        L24:
            boolean r6 = r5.isEmpty()
            r7 = 0
            if (r6 != 0) goto L3f
            char r5 = r5.charAt(r3)
            r6 = 39
            if (r5 != r6) goto L36
            r2[r4] = r7
            goto L43
        L36:
            boolean r5 = java.lang.Character.isUpperCase(r5)
            if (r5 == 0) goto L3f
            r1[r4] = r7
            goto L43
        L3f:
            r1[r4] = r7
            r2[r4] = r7
        L43:
            int r4 = r4 + 1
            goto L1c
        L46:
            k.a.a.a.i0 r3 = new k.a.a.a.i0
            r3.<init>(r1, r2, r0)
            goto L4e
        L4c:
            k.a.a.a.i0 r3 = k.a.a.a.i0.f8371b
        L4e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.b0.getVocabulary():k.a.a.a.h0");
    }

    public boolean precpred(c0 c0Var, int i2) {
        return true;
    }

    public void removeErrorListener(k.a.a.a.a aVar) {
        this._listeners.remove(aVar);
    }

    public void removeErrorListeners() {
        this._listeners.clear();
    }

    public boolean sempred(c0 c0Var, int i2, int i3) {
        return true;
    }

    public abstract void setInputStream(q qVar);

    public void setInterpreter(ATNInterpreter atninterpreter) {
        this._interp = atninterpreter;
    }

    public final void setState(int i2) {
        this._stateNumber = i2;
    }

    public abstract void setTokenFactory(e0<?> e0Var);
}
