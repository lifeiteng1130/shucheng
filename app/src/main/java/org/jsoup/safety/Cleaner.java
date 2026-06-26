package org.jsoup.safety;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.ParseErrorList;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

/* JADX INFO: loaded from: classes3.dex */
public class Cleaner {
    private Whitelist whitelist;

    public final class CleaningVisitor implements NodeVisitor {
        private Element destination;
        private int numDiscarded;
        private final Element root;

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i2) {
            if (!(node instanceof Element)) {
                if (node instanceof TextNode) {
                    this.destination.appendChild(new TextNode(((TextNode) node).getWholeText()));
                    return;
                } else if (!(node instanceof DataNode) || !Cleaner.this.whitelist.isSafeTag(node.parent().nodeName())) {
                    this.numDiscarded++;
                    return;
                } else {
                    this.destination.appendChild(new DataNode(((DataNode) node).getWholeData()));
                    return;
                }
            }
            Element element = (Element) node;
            if (!Cleaner.this.whitelist.isSafeTag(element.normalName())) {
                if (node != this.root) {
                    this.numDiscarded++;
                }
            } else {
                ElementMeta elementMetaCreateSafeElement = Cleaner.this.createSafeElement(element);
                Element element2 = elementMetaCreateSafeElement.el;
                this.destination.appendChild(element2);
                this.numDiscarded += elementMetaCreateSafeElement.numAttribsDiscarded;
                this.destination = element2;
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i2) {
            if ((node instanceof Element) && Cleaner.this.whitelist.isSafeTag(node.nodeName())) {
                this.destination = this.destination.parent();
            }
        }

        private CleaningVisitor(Element element, Element element2) {
            this.numDiscarded = 0;
            this.root = element;
            this.destination = element2;
        }
    }

    public static class ElementMeta {
        public Element el;
        public int numAttribsDiscarded;

        public ElementMeta(Element element, int i2) {
            this.el = element;
            this.numAttribsDiscarded = i2;
        }
    }

    public Cleaner(Whitelist whitelist) {
        Validate.notNull(whitelist);
        this.whitelist = whitelist;
    }

    private int copySafeNodes(Element element, Element element2) {
        CleaningVisitor cleaningVisitor = new CleaningVisitor(element, element2);
        NodeTraversor.traverse(cleaningVisitor, element);
        return cleaningVisitor.numDiscarded;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ElementMeta createSafeElement(Element element) {
        String strTagName = element.tagName();
        Attributes attributes = new Attributes();
        Element element2 = new Element(Tag.valueOf(strTagName), element.baseUri(), attributes);
        int i2 = 0;
        for (Attribute attribute : element.attributes()) {
            if (this.whitelist.isSafeAttribute(strTagName, element, attribute)) {
                attributes.put(attribute);
            } else {
                i2++;
            }
        }
        attributes.addAll(this.whitelist.getEnforcedAttributes(strTagName));
        return new ElementMeta(element2, i2);
    }

    public Document clean(Document document) {
        Validate.notNull(document);
        Document documentCreateShell = Document.createShell(document.baseUri());
        if (document.body() != null) {
            copySafeNodes(document.body(), documentCreateShell.body());
        }
        return documentCreateShell;
    }

    public boolean isValid(Document document) {
        Validate.notNull(document);
        return copySafeNodes(document.body(), Document.createShell(document.baseUri()).body()) == 0 && document.head().childNodes().isEmpty();
    }

    public boolean isValidBodyHtml(String str) {
        Document documentCreateShell = Document.createShell("");
        Document documentCreateShell2 = Document.createShell("");
        ParseErrorList parseErrorListTracking = ParseErrorList.tracking(1);
        documentCreateShell2.body().insertChildren(0, Parser.parseFragment(str, documentCreateShell2.body(), "", parseErrorListTracking));
        return copySafeNodes(documentCreateShell2.body(), documentCreateShell.body()) == 0 && parseErrorListTracking.isEmpty();
    }
}
