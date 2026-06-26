package org.mozilla.javascript.ast;

import c.a.a.a.a;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public class UnaryExpression extends AstNode {
    private boolean isPostfix;
    private AstNode operand;

    public UnaryExpression() {
    }

    public AstNode getOperand() {
        return this.operand;
    }

    public int getOperator() {
        return this.type;
    }

    public boolean isPostfix() {
        return this.isPostfix;
    }

    public boolean isPrefix() {
        return !this.isPostfix;
    }

    public void setIsPostfix(boolean z) {
        this.isPostfix = z;
    }

    public void setOperand(AstNode astNode) {
        assertNotNull(astNode);
        this.operand = astNode;
        astNode.setParent(this);
    }

    public void setOperator(int i2) {
        if (!Token.isValidToken(i2)) {
            throw new IllegalArgumentException(a.G("Invalid token: ", i2));
        }
        setType(i2);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i2));
        int type = getType();
        if (!this.isPostfix) {
            sb.append(AstNode.operatorToString(type));
            if (type == 32 || type == 31 || type == 127) {
                sb.append(" ");
            }
        }
        sb.append(this.operand.toSource());
        if (this.isPostfix) {
            sb.append(AstNode.operatorToString(type));
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.operand.visit(nodeVisitor);
        }
    }

    public UnaryExpression(int i2) {
        super(i2);
    }

    public UnaryExpression(int i2, int i3) {
        super(i2, i3);
    }

    public UnaryExpression(int i2, int i3, AstNode astNode) {
        this(i2, i3, astNode, false);
    }

    public UnaryExpression(int i2, int i3, AstNode astNode, boolean z) {
        assertNotNull(astNode);
        setBounds(z ? astNode.getPosition() : i3, z ? i3 + 2 : astNode.getPosition() + astNode.getLength());
        setOperator(i2);
        setOperand(astNode);
        this.isPostfix = z;
    }
}
