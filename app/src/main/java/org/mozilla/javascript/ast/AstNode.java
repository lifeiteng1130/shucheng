package org.mozilla.javascript.ast;

import c.a.a.a.a;
import h.a.a.a.w;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.xpath.XPath;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AstNode extends Node implements Comparable<AstNode> {
    private static Map<Integer, String> operatorNames;
    public AstNode inlineComment;
    public int length;
    public AstNode parent;
    public int position;

    public static class DebugPrintVisitor implements NodeVisitor {
        private static final int DEBUG_INDENT = 2;
        private StringBuilder buffer;

        public DebugPrintVisitor(StringBuilder sb) {
            this.buffer = sb;
        }

        private static String makeIndent(int i2) {
            int i3 = i2 * 2;
            StringBuilder sb = new StringBuilder(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        public String toString() {
            return this.buffer.toString();
        }

        @Override // org.mozilla.javascript.ast.NodeVisitor
        public boolean visit(AstNode astNode) {
            int type = astNode.getType();
            String strTypeToName = Token.typeToName(type);
            StringBuilder sb = this.buffer;
            sb.append(astNode.getAbsolutePosition());
            sb.append("\t");
            this.buffer.append(makeIndent(astNode.depth()));
            StringBuilder sb2 = this.buffer;
            sb2.append(strTypeToName);
            sb2.append(" ");
            StringBuilder sb3 = this.buffer;
            sb3.append(astNode.getPosition());
            sb3.append(" ");
            this.buffer.append(astNode.getLength());
            if (type == 39) {
                StringBuilder sb4 = this.buffer;
                sb4.append(" ");
                sb4.append(((Name) astNode).getIdentifier());
            } else if (type == 41) {
                StringBuilder sb5 = this.buffer;
                sb5.append(" ");
                sb5.append(((StringLiteral) astNode).getValue(true));
            }
            this.buffer.append("\n");
            return true;
        }
    }

    public static class PositionComparator implements Comparator<AstNode>, Serializable, j$.util.Comparator {
        private static final long serialVersionUID = 1;

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(AstNode astNode, AstNode astNode2) {
            return astNode.position - astNode2.position;
        }
    }

    static {
        HashMap map = new HashMap();
        operatorNames = map;
        map.put(52, "in");
        operatorNames.put(32, "typeof");
        operatorNames.put(53, "instanceof");
        operatorNames.put(31, "delete");
        operatorNames.put(90, ",");
        operatorNames.put(104, ":");
        operatorNames.put(105, "||");
        operatorNames.put(106, "&&");
        operatorNames.put(107, "++");
        operatorNames.put(108, "--");
        operatorNames.put(9, "|");
        operatorNames.put(10, "^");
        operatorNames.put(11, "&");
        operatorNames.put(12, "==");
        operatorNames.put(13, "!=");
        operatorNames.put(14, "<");
        operatorNames.put(16, ">");
        operatorNames.put(15, "<=");
        operatorNames.put(17, ">=");
        operatorNames.put(18, "<<");
        operatorNames.put(19, ">>");
        operatorNames.put(20, ">>>");
        operatorNames.put(21, Marker.ANY_NON_NULL_MARKER);
        operatorNames.put(22, "-");
        operatorNames.put(23, "*");
        operatorNames.put(24, w.DEFAULT_PATH_SEPARATOR);
        operatorNames.put(25, "%");
        operatorNames.put(26, XPath.NOT);
        operatorNames.put(27, "~");
        operatorNames.put(28, Marker.ANY_NON_NULL_MARKER);
        operatorNames.put(29, "-");
        operatorNames.put(46, "===");
        operatorNames.put(47, "!==");
        operatorNames.put(91, "=");
        operatorNames.put(92, "|=");
        operatorNames.put(94, "&=");
        operatorNames.put(95, "<<=");
        operatorNames.put(96, ">>=");
        operatorNames.put(97, ">>>=");
        operatorNames.put(98, "+=");
        operatorNames.put(99, "-=");
        operatorNames.put(100, "*=");
        operatorNames.put(101, "/=");
        operatorNames.put(102, "%=");
        operatorNames.put(93, "^=");
        operatorNames.put(127, "void");
    }

    public AstNode() {
        super(-1);
        this.position = -1;
        this.length = 1;
    }

    public static RuntimeException codeBug() {
        throw Kit.codeBug();
    }

    public static String operatorToString(int i2) {
        String str = operatorNames.get(Integer.valueOf(i2));
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException(a.G("Invalid operator: ", i2));
    }

    public void addChild(AstNode astNode) {
        assertNotNull(astNode);
        setLength((astNode.getLength() + astNode.getPosition()) - getPosition());
        addChildToBack(astNode);
        astNode.setParent(this);
    }

    public void assertNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("arg cannot be null");
        }
    }

    public String debugPrint() {
        DebugPrintVisitor debugPrintVisitor = new DebugPrintVisitor(new StringBuilder(1000));
        visit(debugPrintVisitor);
        return debugPrintVisitor.toString();
    }

    public int depth() {
        AstNode astNode = this.parent;
        if (astNode == null) {
            return 0;
        }
        return astNode.depth() + 1;
    }

    public int getAbsolutePosition() {
        int position = this.position;
        for (AstNode parent = this.parent; parent != null; parent = parent.getParent()) {
            position += parent.getPosition();
        }
        return position;
    }

    public AstRoot getAstRoot() {
        AstNode parent = this;
        while (parent != null && !(parent instanceof AstRoot)) {
            parent = parent.getParent();
        }
        return (AstRoot) parent;
    }

    public FunctionNode getEnclosingFunction() {
        AstNode parent = getParent();
        while (parent != null && !(parent instanceof FunctionNode)) {
            parent = parent.getParent();
        }
        return (FunctionNode) parent;
    }

    public Scope getEnclosingScope() {
        AstNode parent = getParent();
        while (parent != null && !(parent instanceof Scope)) {
            parent = parent.getParent();
        }
        return (Scope) parent;
    }

    public AstNode getInlineComment() {
        return this.inlineComment;
    }

    public int getLength() {
        return this.length;
    }

    @Override // org.mozilla.javascript.Node
    public int getLineno() {
        int i2 = this.lineno;
        if (i2 != -1) {
            return i2;
        }
        AstNode astNode = this.parent;
        if (astNode != null) {
            return astNode.getLineno();
        }
        return -1;
    }

    public AstNode getParent() {
        return this.parent;
    }

    public int getPosition() {
        return this.position;
    }

    @Override // org.mozilla.javascript.Node
    public boolean hasSideEffects() {
        int type = getType();
        if (type == 30 || type == 31 || type == 37 || type == 38 || type == 50 || type == 51 || type == 56 || type == 57 || type == 82 || type == 83 || type == 107 || type == 108) {
            return true;
        }
        switch (type) {
            case -1:
            case 35:
            case 65:
            case 73:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case Token.CATCH /* 125 */:
            case 126:
            case 130:
            case Token.LABEL /* 131 */:
            case Token.TARGET /* 132 */:
            case Token.LOOP /* 133 */:
            case Token.EXPR_RESULT /* 135 */:
            case Token.JSR /* 136 */:
            case 140:
            case Token.SETELEM_OP /* 141 */:
            case Token.LOCAL_BLOCK /* 142 */:
            case Token.SET_REF_OP /* 143 */:
            case 154:
            case 155:
            case Token.LETEXPR /* 159 */:
            case 160:
            case 166:
                return true;
            default:
                switch (type) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        return true;
                    default:
                        switch (type) {
                            case 69:
                            case 70:
                            case 71:
                                return true;
                            default:
                                switch (type) {
                                    case 110:
                                    case 111:
                                    case 112:
                                    case 113:
                                    case 114:
                                    case 115:
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public String makeIndent(int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    public <T extends AstNode> void printList(List<T> list, StringBuilder sb) {
        int size = list.size();
        int i2 = 0;
        for (T t : list) {
            sb.append(t.toSource(0));
            int i3 = i2 + 1;
            if (i2 < size - 1) {
                sb.append(", ");
            } else if (t instanceof EmptyExpression) {
                sb.append(",");
            }
            i2 = i3;
        }
    }

    public void setBounds(int i2, int i3) {
        setPosition(i2);
        setLength(i3 - i2);
    }

    public void setInlineComment(AstNode astNode) {
        this.inlineComment = astNode;
    }

    public void setLength(int i2) {
        this.length = i2;
    }

    public void setParent(AstNode astNode) {
        AstNode astNode2 = this.parent;
        if (astNode == astNode2) {
            return;
        }
        if (astNode2 != null) {
            setRelative(-astNode2.getAbsolutePosition());
        }
        this.parent = astNode;
        if (astNode != null) {
            setRelative(astNode.getAbsolutePosition());
        }
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public void setRelative(int i2) {
        this.position -= i2;
    }

    public String shortName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }

    public String toSource() {
        return toSource(0);
    }

    public abstract String toSource(int i2);

    public abstract void visit(NodeVisitor nodeVisitor);

    @Override // java.lang.Comparable
    public int compareTo(AstNode astNode) {
        if (equals(astNode)) {
            return 0;
        }
        int absolutePosition = getAbsolutePosition();
        int absolutePosition2 = astNode.getAbsolutePosition();
        if (absolutePosition < absolutePosition2) {
            return -1;
        }
        if (absolutePosition2 < absolutePosition) {
            return 1;
        }
        int length = getLength();
        int length2 = astNode.getLength();
        if (length < length2) {
            return -1;
        }
        if (length2 < length) {
            return 1;
        }
        return hashCode() - astNode.hashCode();
    }

    public AstNode(int i2) {
        this();
        this.position = i2;
    }

    public AstNode(int i2, int i3) {
        this();
        this.position = i2;
        this.length = i3;
    }
}
