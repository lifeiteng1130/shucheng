package org.mozilla.javascript.ast;

import c.a.a.a.a;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public class XmlMemberGet extends InfixExpression {
    public XmlMemberGet() {
        this.type = Token.DOTDOT;
    }

    private String dotsToString() {
        int type = getType();
        if (type == 109) {
            return ".";
        }
        if (type == 144) {
            return "..";
        }
        StringBuilder sbR = a.r("Invalid type of XmlMemberGet: ");
        sbR.append(getType());
        throw new IllegalArgumentException(sbR.toString());
    }

    public XmlRef getMemberRef() {
        return (XmlRef) getRight();
    }

    public AstNode getTarget() {
        return getLeft();
    }

    public void setProperty(XmlRef xmlRef) {
        setRight(xmlRef);
    }

    public void setTarget(AstNode astNode) {
        setLeft(astNode);
    }

    @Override // org.mozilla.javascript.ast.InfixExpression, org.mozilla.javascript.ast.AstNode
    public String toSource(int i2) {
        return makeIndent(i2) + getLeft().toSource(0) + dotsToString() + getRight().toSource(0);
    }

    public XmlMemberGet(int i2) {
        super(i2);
        this.type = Token.DOTDOT;
    }

    public XmlMemberGet(int i2, int i3) {
        super(i2, i3);
        this.type = Token.DOTDOT;
    }

    public XmlMemberGet(int i2, int i3, AstNode astNode, XmlRef xmlRef) {
        super(i2, i3, astNode, xmlRef);
        this.type = Token.DOTDOT;
    }

    public XmlMemberGet(AstNode astNode, XmlRef xmlRef) {
        super(astNode, xmlRef);
        this.type = Token.DOTDOT;
    }

    public XmlMemberGet(AstNode astNode, XmlRef xmlRef, int i2) {
        super(Token.DOTDOT, astNode, xmlRef, i2);
        this.type = Token.DOTDOT;
    }
}
