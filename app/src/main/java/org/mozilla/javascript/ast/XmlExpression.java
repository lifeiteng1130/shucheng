package org.mozilla.javascript.ast;

/* JADX INFO: loaded from: classes3.dex */
public class XmlExpression extends XmlFragment {
    private AstNode expression;
    private boolean isXmlAttribute;

    public XmlExpression() {
    }

    public AstNode getExpression() {
        return this.expression;
    }

    public boolean isXmlAttribute() {
        return this.isXmlAttribute;
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.expression = astNode;
        astNode.setParent(this);
    }

    public void setIsXmlAttribute(boolean z) {
        this.isXmlAttribute = z;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i2) {
        return makeIndent(i2) + "{" + this.expression.toSource(i2) + "}";
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.expression.visit(nodeVisitor);
        }
    }

    public XmlExpression(int i2) {
        super(i2);
    }

    public XmlExpression(int i2, int i3) {
        super(i2, i3);
    }

    public XmlExpression(int i2, AstNode astNode) {
        super(i2);
        setExpression(astNode);
    }
}
