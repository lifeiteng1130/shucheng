package org.mozilla.javascript.ast;

import c.a.a.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class KeywordLiteral extends AstNode {
    public KeywordLiteral() {
    }

    public boolean isBooleanLiteral() {
        int i2 = this.type;
        return i2 == 45 || i2 == 44;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i2));
        int type = getType();
        if (type != 161) {
            switch (type) {
                case 42:
                    sb.append("null");
                    break;
                case 43:
                    sb.append("this");
                    break;
                case 44:
                    sb.append("false");
                    break;
                case 45:
                    sb.append("true");
                    break;
                default:
                    StringBuilder sbR = a.r("Invalid keyword literal type: ");
                    sbR.append(getType());
                    throw new IllegalStateException(sbR.toString());
            }
        } else {
            sb.append("debugger;\n");
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public KeywordLiteral(int i2) {
        super(i2);
    }

    @Override // org.mozilla.javascript.Node
    public KeywordLiteral setType(int i2) {
        if (i2 != 43 && i2 != 42 && i2 != 45 && i2 != 44 && i2 != 161) {
            throw new IllegalArgumentException(a.G("Invalid node type: ", i2));
        }
        this.type = i2;
        return this;
    }

    public KeywordLiteral(int i2, int i3) {
        super(i2, i3);
    }

    public KeywordLiteral(int i2, int i3, int i4) {
        super(i2, i3);
        setType(i4);
    }
}
