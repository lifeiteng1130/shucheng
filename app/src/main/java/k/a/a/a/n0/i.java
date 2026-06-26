package k.a.a.a.n0;

import k.a.a.a.c0;
import k.a.a.a.d0;

/* JADX INFO: compiled from: TerminalNodeImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements h {
    public d0 a;

    public i(d0 d0Var) {
        this.a = d0Var;
    }

    @Override // k.a.a.a.n0.h
    public d0 a() {
        return this.a;
    }

    @Override // k.a.a.a.n0.d
    public <T> T accept(f<? extends T> fVar) {
        return fVar.visitTerminal(this);
    }

    @Override // k.a.a.a.n0.d, k.a.a.a.n0.j
    public d getChild(int i2) {
        return null;
    }

    @Override // k.a.a.a.n0.j
    public /* bridge */ /* synthetic */ j getChild(int i2) {
        return null;
    }

    @Override // k.a.a.a.n0.j
    public int getChildCount() {
        return 0;
    }

    @Override // k.a.a.a.n0.j
    public Object getPayload() {
        return this.a;
    }

    @Override // k.a.a.a.n0.d
    public String getText() {
        return this.a.getText();
    }

    @Override // k.a.a.a.n0.d
    public void setParent(c0 c0Var) {
    }

    public String toString() {
        return this.a.getType() == -1 ? "<EOF>" : this.a.getText();
    }
}
