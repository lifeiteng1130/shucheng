package k.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: ParserRuleContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class y extends c0 {
    public List<k.a.a.a.n0.d> children;
    public a0 exception;
    public d0 start;
    public d0 stop;

    public y() {
    }

    public <T extends k.a.a.a.n0.d> T addAnyChild(T t) {
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(t);
        return t;
    }

    public c0 addChild(c0 c0Var) {
        return (c0) addAnyChild(c0Var);
    }

    public k.a.a.a.n0.b addErrorNode(k.a.a.a.n0.b bVar) {
        bVar.setParent(this);
        return (k.a.a.a.n0.b) addAnyChild(bVar);
    }

    public void copyFrom(y yVar) {
        this.parent = yVar.parent;
        this.invokingState = yVar.invokingState;
        this.start = yVar.start;
        this.stop = yVar.stop;
        if (yVar.children != null) {
            this.children = new ArrayList();
            for (k.a.a.a.n0.d dVar : yVar.children) {
                if (dVar instanceof k.a.a.a.n0.b) {
                    addChild((k.a.a.a.n0.b) dVar);
                }
            }
        }
    }

    public void enterRule(k.a.a.a.n0.e eVar) {
    }

    public void exitRule(k.a.a.a.n0.e eVar) {
    }

    @Override // k.a.a.a.c0, k.a.a.a.n0.j
    public int getChildCount() {
        List<k.a.a.a.n0.d> list = this.children;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public <T extends y> T getRuleContext(Class<? extends T> cls, int i2) {
        return (T) getChild(cls, i2);
    }

    public <T extends y> List<T> getRuleContexts(Class<? extends T> cls) {
        List<k.a.a.a.n0.d> list = this.children;
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = null;
        for (k.a.a.a.n0.d dVar : list) {
            if (cls.isInstance(dVar)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(cls.cast(dVar));
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    @Override // k.a.a.a.c0
    public k.a.a.a.m0.h getSourceInterval() {
        if (this.start == null) {
            return k.a.a.a.m0.h.a;
        }
        d0 d0Var = this.stop;
        return (d0Var == null || d0Var.getTokenIndex() < this.start.getTokenIndex()) ? k.a.a.a.m0.h.c(this.start.getTokenIndex(), this.start.getTokenIndex() - 1) : k.a.a.a.m0.h.c(this.start.getTokenIndex(), this.stop.getTokenIndex());
    }

    public d0 getStart() {
        return this.start;
    }

    public d0 getStop() {
        return this.stop;
    }

    public k.a.a.a.n0.h getToken(int i2, int i3) {
        List<k.a.a.a.n0.d> list = this.children;
        if (list != null && i3 >= 0 && i3 < list.size()) {
            int i4 = -1;
            for (k.a.a.a.n0.d dVar : this.children) {
                if (dVar instanceof k.a.a.a.n0.h) {
                    k.a.a.a.n0.h hVar = (k.a.a.a.n0.h) dVar;
                    if (hVar.a().getType() == i2 && (i4 = i4 + 1) == i3) {
                        return hVar;
                    }
                }
            }
        }
        return null;
    }

    public List<k.a.a.a.n0.h> getTokens(int i2) {
        List<k.a.a.a.n0.d> list = this.children;
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = null;
        for (k.a.a.a.n0.d dVar : list) {
            if (dVar instanceof k.a.a.a.n0.h) {
                k.a.a.a.n0.h hVar = (k.a.a.a.n0.h) dVar;
                if (hVar.a().getType() == i2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(hVar);
                }
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    public void removeLastChild() {
        List<k.a.a.a.n0.d> list = this.children;
        if (list != null) {
            list.remove(list.size() - 1);
        }
    }

    public String toInfoString(w wVar) {
        List<String> ruleInvocationStack = wVar.getRuleInvocationStack(this);
        Collections.reverse(ruleInvocationStack);
        return "ParserRuleContext" + ruleInvocationStack + "{start=" + this.start + ", stop=" + this.stop + MessageFormatter.DELIM_STOP;
    }

    public y(y yVar, int i2) {
        super(yVar, i2);
    }

    public k.a.a.a.n0.h addChild(k.a.a.a.n0.h hVar) {
        hVar.setParent(this);
        return (k.a.a.a.n0.h) addAnyChild(hVar);
    }

    @Override // k.a.a.a.c0, k.a.a.a.n0.j
    public k.a.a.a.n0.d getChild(int i2) {
        List<k.a.a.a.n0.d> list = this.children;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return this.children.get(i2);
    }

    @Deprecated
    public k.a.a.a.n0.b addErrorNode(d0 d0Var) {
        k.a.a.a.n0.c cVar = new k.a.a.a.n0.c(d0Var);
        addAnyChild(cVar);
        return cVar;
    }

    public <T extends k.a.a.a.n0.d> T getChild(Class<? extends T> cls, int i2) {
        List<k.a.a.a.n0.d> list = this.children;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            int i3 = -1;
            for (k.a.a.a.n0.d dVar : this.children) {
                if (cls.isInstance(dVar) && (i3 = i3 + 1) == i2) {
                    return cls.cast(dVar);
                }
            }
        }
        return null;
    }

    @Deprecated
    public k.a.a.a.n0.h addChild(d0 d0Var) {
        k.a.a.a.n0.i iVar = new k.a.a.a.n0.i(d0Var);
        addAnyChild(iVar);
        return iVar;
    }

    @Override // k.a.a.a.c0
    /* JADX INFO: renamed from: getParent, reason: merged with bridge method [inline-methods] */
    public y mo33getParent() {
        return (y) super.mo33getParent();
    }
}
