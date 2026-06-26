package org.mozilla.javascript.ast;

import c.a.a.a.a;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public class ObjectProperty extends InfixExpression {
    public ObjectProperty() {
        this.type = 104;
    }

    public boolean isGetterMethod() {
        return this.type == 152;
    }

    public boolean isMethod() {
        return isGetterMethod() || isSetterMethod() || isNormalMethod();
    }

    public boolean isNormalMethod() {
        return this.type == 164;
    }

    public boolean isSetterMethod() {
        return this.type == 153;
    }

    public void setIsGetterMethod() {
        this.type = 152;
    }

    public void setIsNormalMethod() {
        this.type = Token.METHOD;
    }

    public void setIsSetterMethod() {
        this.type = 153;
    }

    public void setNodeType(int i2) {
        if (i2 != 104 && i2 != 152 && i2 != 153 && i2 != 164) {
            throw new IllegalArgumentException(a.G("invalid node type: ", i2));
        }
        setType(i2);
    }

    @Override // org.mozilla.javascript.ast.InfixExpression, org.mozilla.javascript.ast.AstNode
    public String toSource(int i2) {
        StringBuilder sbR = a.r("\n");
        int i3 = i2 + 1;
        sbR.append(makeIndent(i3));
        if (isGetterMethod()) {
            sbR.append("get ");
        } else if (isSetterMethod()) {
            sbR.append("set ");
        }
        AstNode astNode = this.left;
        if (getType() == 104) {
            i2 = 0;
        }
        sbR.append(astNode.toSource(i2));
        if (this.type == 104) {
            sbR.append(": ");
        }
        AstNode astNode2 = this.right;
        if (getType() == 104) {
            i3 = 0;
        }
        sbR.append(astNode2.toSource(i3));
        return sbR.toString();
    }

    public ObjectProperty(int i2) {
        super(i2);
        this.type = 104;
    }

    public ObjectProperty(int i2, int i3) {
        super(i2, i3);
        this.type = 104;
    }
}
