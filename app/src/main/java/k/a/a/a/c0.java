package k.a.a.a;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: RuleContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0 implements k.a.a.a.n0.g {
    public static final y EMPTY = new y();
    public int invokingState;
    public c0 parent;

    public c0() {
        this.invokingState = -1;
    }

    @Override // k.a.a.a.n0.d
    public <T> T accept(k.a.a.a.n0.f<? extends T> fVar) {
        return fVar.visitChildren(this);
    }

    public int depth() {
        int i2 = 0;
        c0 c0Var = this;
        while (c0Var != null) {
            c0Var = c0Var.parent;
            i2++;
        }
        return i2;
    }

    public int getAltNumber() {
        return 0;
    }

    @Override // k.a.a.a.n0.j
    public k.a.a.a.n0.d getChild(int i2) {
        return null;
    }

    @Override // k.a.a.a.n0.j
    public int getChildCount() {
        return 0;
    }

    @Override // k.a.a.a.n0.j
    public c0 getPayload() {
        return this;
    }

    public c0 getRuleContext() {
        return this;
    }

    public int getRuleIndex() {
        return -1;
    }

    public k.a.a.a.m0.h getSourceInterval() {
        return k.a.a.a.m0.h.a;
    }

    @Override // k.a.a.a.n0.d
    public String getText() {
        if (getChildCount() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            sb.append(getChild(i2).getText());
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return this.invokingState == -1;
    }

    public void setAltNumber(int i2) {
    }

    @Override // k.a.a.a.n0.d
    public void setParent(c0 c0Var) {
        this.parent = c0Var;
    }

    public String toString() {
        return toString((List<String>) null, (c0) null);
    }

    public String toStringTree(w wVar) {
        String[] ruleNames = wVar != null ? wVar.getRuleNames() : null;
        return c.b.a.m.f.P5(this, ruleNames != null ? Arrays.asList(ruleNames) : null);
    }

    public final String toString(b0<?, ?> b0Var) {
        return toString(b0Var, EMPTY);
    }

    public c0(c0 c0Var, int i2) {
        this.invokingState = -1;
        this.parent = c0Var;
        this.invokingState = i2;
    }

    @Override // 
    /* JADX INFO: renamed from: getParent, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c0 mo33getParent() {
        return this.parent;
    }

    public final String toString(List<String> list) {
        return toString(list, (c0) null);
    }

    public String toString(b0<?, ?> b0Var, c0 c0Var) {
        String[] ruleNames = b0Var != null ? b0Var.getRuleNames() : null;
        return toString(ruleNames != null ? Arrays.asList(ruleNames) : null, c0Var);
    }

    public String toStringTree(List<String> list) {
        return c.b.a.m.f.P5(this, list);
    }

    public String toStringTree() {
        return toStringTree((List<String>) null);
    }

    public String toString(List<String> list, c0 c0Var) {
        StringBuilder sbR = c.a.a.a.a.r("[");
        for (c0 c0Var2 = this; c0Var2 != null && c0Var2 != c0Var; c0Var2 = c0Var2.parent) {
            if (list == null) {
                if (!c0Var2.isEmpty()) {
                    sbR.append(c0Var2.invokingState);
                }
            } else {
                int ruleIndex = c0Var2.getRuleIndex();
                sbR.append((ruleIndex < 0 || ruleIndex >= list.size()) ? Integer.toString(ruleIndex) : list.get(ruleIndex));
            }
            c0 c0Var3 = c0Var2.parent;
            if (c0Var3 != null && (list != null || !c0Var3.isEmpty())) {
                sbR.append(" ");
            }
        }
        sbR.append("]");
        return sbR.toString();
    }
}
