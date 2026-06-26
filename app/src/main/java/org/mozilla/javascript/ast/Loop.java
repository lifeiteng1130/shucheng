package org.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Loop extends Scope {
    public AstNode body;
    public int lp;
    public int rp;

    public Loop() {
        this.lp = -1;
        this.rp = -1;
    }

    public AstNode getBody() {
        return this.body;
    }

    public int getLp() {
        return this.lp;
    }

    public int getRp() {
        return this.rp;
    }

    public void setBody(AstNode astNode) {
        this.body = astNode;
        setLength((astNode.getLength() + astNode.getPosition()) - getPosition());
        astNode.setParent(this);
    }

    public void setLp(int i2) {
        this.lp = i2;
    }

    public void setParens(int i2, int i3) {
        this.lp = i2;
        this.rp = i3;
    }

    public void setRp(int i2) {
        this.rp = i2;
    }

    public Loop(int i2) {
        super(i2);
        this.lp = -1;
        this.rp = -1;
    }

    public Loop(int i2, int i3) {
        super(i2, i3);
        this.lp = -1;
        this.rp = -1;
    }
}
