package org.mozilla.javascript.ast;

import c.a.a.a.a;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public class InfixExpression extends AstNode {
    public AstNode left;
    public int operatorPosition;
    public AstNode right;

    public InfixExpression() {
        this.operatorPosition = -1;
    }

    public AstNode getLeft() {
        return this.left;
    }

    public int getOperator() {
        return getType();
    }

    public int getOperatorPosition() {
        return this.operatorPosition;
    }

    public AstNode getRight() {
        return this.right;
    }

    @Override // org.mozilla.javascript.ast.AstNode, org.mozilla.javascript.Node
    public boolean hasSideEffects() {
        int type = getType();
        if (type == 90) {
            AstNode astNode = this.right;
            return astNode != null && astNode.hasSideEffects();
        }
        if (type != 105 && type != 106) {
            return super.hasSideEffects();
        }
        AstNode astNode2 = this.left;
        if (astNode2 != null && astNode2.hasSideEffects()) {
            return true;
        }
        AstNode astNode3 = this.right;
        return astNode3 != null && astNode3.hasSideEffects();
    }

    public void setLeft(AstNode astNode) {
        assertNotNull(astNode);
        this.left = astNode;
        setLineno(astNode.getLineno());
        astNode.setParent(this);
    }

    public void setLeftAndRight(AstNode astNode, AstNode astNode2) {
        assertNotNull(astNode);
        assertNotNull(astNode2);
        setBounds(astNode.getPosition(), astNode2.getLength() + astNode2.getPosition());
        setLeft(astNode);
        setRight(astNode2);
    }

    public void setOperator(int i2) {
        if (!Token.isValidToken(i2)) {
            throw new IllegalArgumentException(a.G("Invalid token: ", i2));
        }
        setType(i2);
    }

    public void setOperatorPosition(int i2) {
        this.operatorPosition = i2;
    }

    public void setRight(AstNode astNode) {
        assertNotNull(astNode);
        this.right = astNode;
        astNode.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i2) {
        return makeIndent(i2) + this.left.toSource() + " " + AstNode.operatorToString(getType()) + " " + this.right.toSource();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.left.visit(nodeVisitor);
            this.right.visit(nodeVisitor);
        }
    }

    public InfixExpression(int i2) {
        super(i2);
        this.operatorPosition = -1;
    }

    public InfixExpression(int i2, int i3) {
        super(i2, i3);
        this.operatorPosition = -1;
    }

    public InfixExpression(int i2, int i3, AstNode astNode, AstNode astNode2) {
        super(i2, i3);
        this.operatorPosition = -1;
        setLeft(astNode);
        setRight(astNode2);
    }

    public InfixExpression(AstNode astNode, AstNode astNode2) {
        this.operatorPosition = -1;
        setLeftAndRight(astNode, astNode2);
    }

    public InfixExpression(int i2, AstNode astNode, AstNode astNode2, int i3) {
        this.operatorPosition = -1;
        setType(i2);
        setOperatorPosition(i3 - astNode.getPosition());
        setLeftAndRight(astNode, astNode2);
    }
}
