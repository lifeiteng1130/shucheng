package org.mozilla.javascript;

import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.v;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mozilla.javascript.ast.Comment;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.NumberLiteral;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;

/* JADX INFO: loaded from: classes3.dex */
public class Node implements Iterable<Node>, Iterable {
    public static final int ARROW_FUNCTION_PROP = 27;
    public static final int ATTRIBUTE_FLAG = 2;
    public static final int BOTH = 0;
    public static final int CASEARRAY_PROP = 5;
    public static final int CATCH_SCOPE_PROP = 14;
    public static final int CONTROL_BLOCK_PROP = 18;
    public static final int DECR_FLAG = 1;
    public static final int DESCENDANTS_FLAG = 4;
    public static final int DESTRUCTURING_ARRAY_LENGTH = 21;
    public static final int DESTRUCTURING_NAMES = 22;
    public static final int DESTRUCTURING_PARAMS = 23;
    public static final int DESTRUCTURING_SHORTHAND = 26;
    public static final int DIRECTCALL_PROP = 9;
    public static final int END_DROPS_OFF = 1;
    public static final int END_RETURNS = 2;
    public static final int END_RETURNS_VALUE = 4;
    public static final int END_UNREACHED = 0;
    public static final int END_YIELDS = 8;
    public static final int EXPRESSION_CLOSURE_PROP = 25;
    public static final int FUNCTION_PROP = 1;
    public static final int GENERATOR_END_PROP = 20;
    public static final int INCRDECR_PROP = 13;
    public static final int ISNUMBER_PROP = 8;
    public static final int JSDOC_PROP = 24;
    public static final int LABEL_ID_PROP = 15;
    public static final int LAST_PROP = 27;
    public static final int LEFT = 1;
    public static final int LOCAL_BLOCK_PROP = 3;
    public static final int LOCAL_PROP = 2;
    public static final int MEMBER_TYPE_PROP = 16;
    public static final int NAME_PROP = 17;
    public static final int NON_SPECIALCALL = 0;
    private static final Node NOT_SET = new Node(-1);
    public static final int OBJECT_IDS_PROP = 12;
    public static final int PARENTHESIZED_PROP = 19;
    public static final int POST_FLAG = 2;
    public static final int PROPERTY_FLAG = 1;
    public static final int REGEXP_PROP = 4;
    public static final int RIGHT = 2;
    public static final int SKIP_INDEXES_PROP = 11;
    public static final int SPECIALCALL_EVAL = 1;
    public static final int SPECIALCALL_PROP = 10;
    public static final int SPECIALCALL_WITH = 2;
    public static final int TARGETBLOCK_PROP = 6;
    public static final int VARIABLE_PROP = 7;
    public Node first;
    public Node last;
    public int lineno;
    public Node next;
    public PropListItem propListHead;
    public int type;

    public class NodeIterator implements Iterator<Node>, j$.util.Iterator {
        private Node cursor;
        private Node prev2;
        private Node prev = Node.NOT_SET;
        private boolean removed = false;

        public NodeIterator() {
            this.cursor = Node.this.first;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.cursor != null;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            if (this.prev == Node.NOT_SET) {
                throw new IllegalStateException("next() has not been called");
            }
            if (this.removed) {
                throw new IllegalStateException("remove() already called for current element");
            }
            Node node = this.prev;
            Node node2 = Node.this;
            if (node == node2.first) {
                node2.first = node.next;
                return;
            }
            if (node != node2.last) {
                this.prev2.next = this.cursor;
            } else {
                Node node3 = this.prev2;
                node3.next = null;
                node2.last = node3;
            }
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Node next() {
            Node node = this.cursor;
            if (node == null) {
                throw new NoSuchElementException();
            }
            this.removed = false;
            this.prev2 = this.prev;
            this.prev = node;
            this.cursor = node.next;
            return node;
        }
    }

    public static class PropListItem {
        public int intValue;
        public PropListItem next;
        public Object objectValue;
        public int type;

        private PropListItem() {
        }
    }

    public Node(int i2) {
        this.type = -1;
        this.lineno = -1;
        this.type = i2;
    }

    private static void appendPrintId(Node node, ObjToIntMap objToIntMap, StringBuilder sb) {
    }

    private int endCheck() {
        int i2 = this.type;
        if (i2 == 4) {
            return this.first != null ? 4 : 2;
        }
        if (i2 == 50) {
            return 0;
        }
        if (i2 == 73) {
            return 8;
        }
        if (i2 == 130 || i2 == 142) {
            Node node = this.first;
            if (node == null) {
                return 1;
            }
            int i3 = node.type;
            return i3 != 7 ? i3 != 82 ? i3 != 115 ? i3 != 131 ? endCheckBlock() : node.endCheckLabel() : node.endCheckSwitch() : node.endCheckTry() : node.endCheckIf();
        }
        if (i2 == 166) {
            return 8;
        }
        if (i2 == 121) {
            return endCheckBreak();
        }
        if (i2 == 122) {
            return 0;
        }
        switch (i2) {
            case Token.TARGET /* 132 */:
                Node node2 = this.next;
                if (node2 != null) {
                    return node2.endCheck();
                }
                return 1;
            case Token.LOOP /* 133 */:
                return endCheckLoop();
            case Token.EXPR_VOID /* 134 */:
                Node node3 = this.first;
                if (node3 != null) {
                    return node3.endCheck();
                }
                return 1;
            default:
                return 1;
        }
    }

    private int endCheckBlock() {
        int iEndCheck = 1;
        for (Node node = this.first; (iEndCheck & 1) != 0 && node != null; node = node.next) {
            iEndCheck = (iEndCheck & (-2)) | node.endCheck();
        }
        return iEndCheck;
    }

    private int endCheckBreak() {
        ((Jump) this).getJumpStatement().putIntProp(18, 1);
        return 0;
    }

    private int endCheckIf() {
        Node node = this.next;
        Node node2 = ((Jump) this).target;
        int iEndCheck = node.endCheck();
        return node2 != null ? iEndCheck | node2.endCheck() : iEndCheck | 1;
    }

    private int endCheckLabel() {
        return this.next.endCheck() | getIntProp(18, 0);
    }

    private int endCheckLoop() {
        Node node = this.first;
        while (true) {
            Node node2 = node.next;
            if (node2 == this.last) {
                break;
            }
            node = node2;
        }
        if (node.type != 6) {
            return 1;
        }
        int iEndCheck = ((Jump) node).target.next.endCheck();
        if (node.first.type == 45) {
            iEndCheck &= -2;
        }
        return getIntProp(18, 0) | iEndCheck;
    }

    private int endCheckSwitch() {
        return 0;
    }

    private int endCheckTry() {
        return 0;
    }

    private PropListItem ensureProperty(int i2) {
        PropListItem propListItemLookupProperty = lookupProperty(i2);
        if (propListItemLookupProperty != null) {
            return propListItemLookupProperty;
        }
        PropListItem propListItem = new PropListItem();
        propListItem.type = i2;
        propListItem.next = this.propListHead;
        this.propListHead = propListItem;
        return propListItem;
    }

    private static void generatePrintIds(Node node, ObjToIntMap objToIntMap) {
    }

    private PropListItem lookupProperty(int i2) {
        PropListItem propListItem = this.propListHead;
        while (propListItem != null && i2 != propListItem.type) {
            propListItem = propListItem.next;
        }
        return propListItem;
    }

    public static Node newNumber(double d2) {
        NumberLiteral numberLiteral = new NumberLiteral();
        numberLiteral.setNumber(d2);
        return numberLiteral;
    }

    public static Node newString(String str) {
        return newString(41, str);
    }

    public static Node newTarget() {
        return new Node(Token.TARGET);
    }

    private static final String propToString(int i2) {
        return null;
    }

    private void resetTargets_r() {
        int i2 = this.type;
        if (i2 == 132 || i2 == 73 || i2 == 166) {
            labelId(-1);
        }
        for (Node node = this.first; node != null; node = node.next) {
            node.resetTargets_r();
        }
    }

    private void toString(ObjToIntMap objToIntMap, StringBuilder sb) {
    }

    private static void toStringTreeHelper(ScriptNode scriptNode, Node node, ObjToIntMap objToIntMap, int i2, StringBuilder sb) {
    }

    public void addChildAfter(Node node, Node node2) {
        if (node.next != null) {
            throw new RuntimeException("newChild had siblings in addChildAfter");
        }
        node.next = node2.next;
        node2.next = node;
        if (this.last == node2) {
            this.last = node;
        }
    }

    public void addChildBefore(Node node, Node node2) {
        if (node.next != null) {
            throw new RuntimeException("newChild had siblings in addChildBefore");
        }
        Node node3 = this.first;
        if (node3 != node2) {
            addChildAfter(node, getChildBefore(node2));
        } else {
            node.next = node3;
            this.first = node;
        }
    }

    public void addChildToBack(Node node) {
        node.next = null;
        Node node2 = this.last;
        if (node2 == null) {
            this.last = node;
            this.first = node;
        } else {
            node2.next = node;
            this.last = node;
        }
    }

    public void addChildToFront(Node node) {
        node.next = this.first;
        this.first = node;
        if (this.last == null) {
            this.last = node;
        }
    }

    public void addChildrenToBack(Node node) {
        Node node2 = this.last;
        if (node2 != null) {
            node2.next = node;
        }
        this.last = node.getLastSibling();
        if (this.first == null) {
            this.first = node;
        }
    }

    public void addChildrenToFront(Node node) {
        Node lastSibling = node.getLastSibling();
        lastSibling.next = this.first;
        this.first = node;
        if (this.last == null) {
            this.last = lastSibling;
        }
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public Node getChildBefore(Node node) {
        Node node2 = this.first;
        if (node == node2) {
            return null;
        }
        while (true) {
            Node node3 = node2.next;
            if (node3 == node) {
                return node2;
            }
            if (node3 == null) {
                throw new RuntimeException("node is not a child");
            }
            node2 = node3;
        }
    }

    public final double getDouble() {
        return ((NumberLiteral) this).getNumber();
    }

    public int getExistingIntProp(int i2) {
        PropListItem propListItemLookupProperty = lookupProperty(i2);
        if (propListItemLookupProperty == null) {
            Kit.codeBug();
        }
        return propListItemLookupProperty.intValue;
    }

    public Node getFirstChild() {
        return this.first;
    }

    public int getIntProp(int i2, int i3) {
        PropListItem propListItemLookupProperty = lookupProperty(i2);
        return propListItemLookupProperty == null ? i3 : propListItemLookupProperty.intValue;
    }

    public String getJsDoc() {
        Comment jsDocNode = getJsDocNode();
        if (jsDocNode != null) {
            return jsDocNode.getValue();
        }
        return null;
    }

    public Comment getJsDocNode() {
        return (Comment) getProp(24);
    }

    public Node getLastChild() {
        return this.last;
    }

    public Node getLastSibling() {
        Node node = this;
        while (true) {
            Node node2 = node.next;
            if (node2 == null) {
                return node;
            }
            node = node2;
        }
    }

    public int getLineno() {
        return this.lineno;
    }

    public Node getNext() {
        return this.next;
    }

    public Object getProp(int i2) {
        PropListItem propListItemLookupProperty = lookupProperty(i2);
        if (propListItemLookupProperty == null) {
            return null;
        }
        return propListItemLookupProperty.objectValue;
    }

    public Scope getScope() {
        return ((Name) this).getScope();
    }

    public final String getString() {
        return ((Name) this).getIdentifier();
    }

    public int getType() {
        return this.type;
    }

    public boolean hasChildren() {
        return this.first != null;
    }

    public boolean hasConsistentReturnUsage() {
        int iEndCheck = endCheck();
        return (iEndCheck & 4) == 0 || (iEndCheck & 11) == 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:59:0x008b A[FALL_THROUGH, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean hasSideEffects() {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Node.hasSideEffects():boolean");
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public java.util.Iterator<Node> iterator() {
        return new NodeIterator();
    }

    public final int labelId() {
        int i2 = this.type;
        if (i2 != 132 && i2 != 73 && i2 != 166) {
            Kit.codeBug();
        }
        return getIntProp(15, -1);
    }

    public void putIntProp(int i2, int i3) {
        ensureProperty(i2).intValue = i3;
    }

    public void putProp(int i2, Object obj) {
        if (obj == null) {
            removeProp(i2);
        } else {
            ensureProperty(i2).objectValue = obj;
        }
    }

    public void removeChild(Node node) {
        Node childBefore = getChildBefore(node);
        if (childBefore == null) {
            this.first = this.first.next;
        } else {
            childBefore.next = node.next;
        }
        if (node == this.last) {
            this.last = childBefore;
        }
        node.next = null;
    }

    public void removeChildren() {
        this.last = null;
        this.first = null;
    }

    public void removeProp(int i2) {
        PropListItem propListItem = this.propListHead;
        if (propListItem != null) {
            PropListItem propListItem2 = null;
            while (propListItem.type != i2) {
                PropListItem propListItem3 = propListItem.next;
                if (propListItem3 == null) {
                    return;
                }
                propListItem2 = propListItem;
                propListItem = propListItem3;
            }
            if (propListItem2 == null) {
                this.propListHead = propListItem.next;
            } else {
                propListItem2.next = propListItem.next;
            }
        }
    }

    public void replaceChild(Node node, Node node2) {
        node2.next = node.next;
        if (node == this.first) {
            this.first = node2;
        } else {
            getChildBefore(node).next = node2;
        }
        if (node == this.last) {
            this.last = node2;
        }
        node.next = null;
    }

    public void replaceChildAfter(Node node, Node node2) {
        Node node3 = node.next;
        node2.next = node3.next;
        node.next = node2;
        if (node3 == this.last) {
            this.last = node2;
        }
        node3.next = null;
    }

    public void resetTargets() {
        if (this.type == 126) {
            resetTargets_r();
        } else {
            Kit.codeBug();
        }
    }

    public final void setDouble(double d2) {
        ((NumberLiteral) this).setNumber(d2);
    }

    public void setJsDocNode(Comment comment) {
        putProp(24, comment);
    }

    public void setLineno(int i2) {
        this.lineno = i2;
    }

    public void setScope(Scope scope) {
        if (scope == null) {
            Kit.codeBug();
        }
        if (!(this instanceof Name)) {
            throw Kit.codeBug();
        }
        ((Name) this).setScope(scope);
    }

    public final void setString(String str) {
        if (str == null) {
            Kit.codeBug();
        }
        ((Name) this).setIdentifier(str);
    }

    public Node setType(int i2) {
        this.type = i2;
        return this;
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return v.o(iterator(), 0);
    }

    public String toString() {
        return String.valueOf(this.type);
    }

    public String toStringTree(ScriptNode scriptNode) {
        return null;
    }

    public static Node newString(int i2, String str) {
        Name name = new Name();
        name.setIdentifier(str);
        name.setType(i2);
        return name;
    }

    public void labelId(int i2) {
        int i3 = this.type;
        if (i3 != 132 && i3 != 73 && i3 != 166) {
            Kit.codeBug();
        }
        putIntProp(15, i2);
    }

    public Node(int i2, Node node) {
        this.type = -1;
        this.lineno = -1;
        this.type = i2;
        this.last = node;
        this.first = node;
        node.next = null;
    }

    public Node(int i2, Node node, Node node2) {
        this.type = -1;
        this.lineno = -1;
        this.type = i2;
        this.first = node;
        this.last = node2;
        node.next = node2;
        node2.next = null;
    }

    public Node(int i2, Node node, Node node2, Node node3) {
        this.type = -1;
        this.lineno = -1;
        this.type = i2;
        this.first = node;
        this.last = node3;
        node.next = node2;
        node2.next = node3;
        node3.next = null;
    }

    public Node(int i2, int i3) {
        this.type = -1;
        this.lineno = -1;
        this.type = i2;
        this.lineno = i3;
    }

    public Node(int i2, Node node, int i3) {
        this(i2, node);
        this.lineno = i3;
    }

    public Node(int i2, Node node, Node node2, int i3) {
        this(i2, node, node2);
        this.lineno = i3;
    }

    public Node(int i2, Node node, Node node2, Node node3, int i3) {
        this(i2, node, node2, node3);
        this.lineno = i3;
    }
}
