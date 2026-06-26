package org.mozilla.javascript.ast;

import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public class EmptyExpression extends AstNode {
    public EmptyExpression() {
        this.type = Token.EMPTY;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i2) {
        return makeIndent(i2);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public EmptyExpression(int i2) {
        super(i2);
        this.type = Token.EMPTY;
    }

    public EmptyExpression(int i2, int i3) {
        super(i2, i3);
        this.type = Token.EMPTY;
    }
}
