package org.mozilla.javascript.ast;

import c.a.a.a.a;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public class LetNode extends Scope {
    private AstNode body;
    private int lp;
    private int rp;
    private VariableDeclaration variables;

    public LetNode() {
        this.lp = -1;
        this.rp = -1;
        this.type = Token.LETEXPR;
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

    public VariableDeclaration getVariables() {
        return this.variables;
    }

    public void setBody(AstNode astNode) {
        this.body = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
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

    public void setVariables(VariableDeclaration variableDeclaration) {
        assertNotNull(variableDeclaration);
        this.variables = variableDeclaration;
        variableDeclaration.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i2) {
        StringBuilder sbT = a.t(makeIndent(i2), "let (");
        printList(this.variables.getVariables(), sbT);
        sbT.append(") ");
        AstNode astNode = this.body;
        if (astNode != null) {
            sbT.append(astNode.toSource(i2));
        }
        return sbT.toString();
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.variables.visit(nodeVisitor);
            AstNode astNode = this.body;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
        }
    }

    public LetNode(int i2) {
        super(i2);
        this.lp = -1;
        this.rp = -1;
        this.type = Token.LETEXPR;
    }

    public LetNode(int i2, int i3) {
        super(i2, i3);
        this.lp = -1;
        this.rp = -1;
        this.type = Token.LETEXPR;
    }
}
