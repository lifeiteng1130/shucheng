package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeFilter;

/* JADX INFO: loaded from: classes3.dex */
public class NodeTraversor {
    public static NodeFilter.FilterResult filter(NodeFilter nodeFilter, Node node) {
        Node nodeChildNode = node;
        int i2 = 0;
        while (nodeChildNode != null) {
            NodeFilter.FilterResult filterResultHead = nodeFilter.head(nodeChildNode, i2);
            if (filterResultHead == NodeFilter.FilterResult.STOP) {
                return filterResultHead;
            }
            if (filterResultHead != NodeFilter.FilterResult.CONTINUE || nodeChildNode.childNodeSize() <= 0) {
                while (nodeChildNode.nextSibling() == null && i2 > 0) {
                    NodeFilter.FilterResult filterResult = NodeFilter.FilterResult.CONTINUE;
                    if ((filterResultHead == filterResult || filterResultHead == NodeFilter.FilterResult.SKIP_CHILDREN) && (filterResultHead = nodeFilter.tail(nodeChildNode, i2)) == NodeFilter.FilterResult.STOP) {
                        return filterResultHead;
                    }
                    Node nodeParentNode = nodeChildNode.parentNode();
                    i2--;
                    if (filterResultHead == NodeFilter.FilterResult.REMOVE) {
                        nodeChildNode.remove();
                    }
                    filterResultHead = filterResult;
                    nodeChildNode = nodeParentNode;
                }
                if ((filterResultHead == NodeFilter.FilterResult.CONTINUE || filterResultHead == NodeFilter.FilterResult.SKIP_CHILDREN) && (filterResultHead = nodeFilter.tail(nodeChildNode, i2)) == NodeFilter.FilterResult.STOP) {
                    return filterResultHead;
                }
                if (nodeChildNode == node) {
                    return filterResultHead;
                }
                Node nodeNextSibling = nodeChildNode.nextSibling();
                if (filterResultHead == NodeFilter.FilterResult.REMOVE) {
                    nodeChildNode.remove();
                }
                nodeChildNode = nodeNextSibling;
            } else {
                nodeChildNode = nodeChildNode.childNode(0);
                i2++;
            }
        }
        return NodeFilter.FilterResult.CONTINUE;
    }

    public static void traverse(NodeVisitor nodeVisitor, Node node) {
        Node nodeChildNode = node;
        int i2 = 0;
        while (nodeChildNode != null) {
            nodeVisitor.head(nodeChildNode, i2);
            if (nodeChildNode.childNodeSize() > 0) {
                nodeChildNode = nodeChildNode.childNode(0);
                i2++;
            } else {
                while (nodeChildNode.nextSibling() == null && i2 > 0) {
                    nodeVisitor.tail(nodeChildNode, i2);
                    nodeChildNode = nodeChildNode.parentNode();
                    i2--;
                }
                nodeVisitor.tail(nodeChildNode, i2);
                if (nodeChildNode == node) {
                    return;
                } else {
                    nodeChildNode = nodeChildNode.nextSibling();
                }
            }
        }
    }

    public static void traverse(NodeVisitor nodeVisitor, Elements elements) {
        Validate.notNull(nodeVisitor);
        Validate.notNull(elements);
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            traverse(nodeVisitor, it.next());
        }
    }

    public static void filter(NodeFilter nodeFilter, Elements elements) {
        Validate.notNull(nodeFilter);
        Validate.notNull(elements);
        Iterator<Element> it = elements.iterator();
        while (it.hasNext() && filter(nodeFilter, it.next()) != NodeFilter.FilterResult.STOP) {
        }
    }
}
