package org.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes3.dex */
public class ForInLoop extends Loop {
    public int eachPosition;
    public int inPosition;
    public boolean isForEach;
    public boolean isForOf;
    public AstNode iteratedObject;
    public AstNode iterator;

    public ForInLoop() {
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 120;
    }

    public int getEachPosition() {
        return this.eachPosition;
    }

    public int getInPosition() {
        return this.inPosition;
    }

    public AstNode getIteratedObject() {
        return this.iteratedObject;
    }

    public AstNode getIterator() {
        return this.iterator;
    }

    public boolean isForEach() {
        return this.isForEach;
    }

    public boolean isForOf() {
        return this.isForOf;
    }

    public void setEachPosition(int i2) {
        this.eachPosition = i2;
    }

    public void setInPosition(int i2) {
        this.inPosition = i2;
    }

    public void setIsForEach(boolean z) {
        this.isForEach = z;
    }

    public void setIsForOf(boolean z) {
        this.isForOf = z;
    }

    public void setIteratedObject(AstNode astNode) {
        assertNotNull(astNode);
        this.iteratedObject = astNode;
        astNode.setParent(this);
    }

    public void setIterator(AstNode astNode) {
        assertNotNull(astNode);
        this.iterator = astNode;
        astNode.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i2));
        sb.append("for ");
        if (isForEach()) {
            sb.append("each ");
        }
        sb.append("(");
        sb.append(this.iterator.toSource(0));
        if (this.isForOf) {
            sb.append(" of ");
        } else {
            sb.append(" in ");
        }
        sb.append(this.iteratedObject.toSource(0));
        sb.append(") ");
        if (this.body.getType() == 130) {
            sb.append(this.body.toSource(i2).trim());
            sb.append("\n");
        } else {
            sb.append("\n");
            sb.append(this.body.toSource(i2 + 1));
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.iterator.visit(nodeVisitor);
            this.iteratedObject.visit(nodeVisitor);
            this.body.visit(nodeVisitor);
        }
    }

    public ForInLoop(int i2) {
        super(i2);
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 120;
    }

    public ForInLoop(int i2, int i3) {
        super(i2, i3);
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 120;
    }
}
