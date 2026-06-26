package org.jsoup.nodes;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

/* JADX INFO: loaded from: classes3.dex */
public class Document extends Element {
    private String location;
    private OutputSettings outputSettings;
    private Parser parser;
    private QuirksMode quirksMode;
    private boolean updateMetaCharset;

    public static class OutputSettings implements Cloneable {
        private Charset charset;
        public Entities.CoreCharset coreCharset;
        private Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
        private ThreadLocal<CharsetEncoder> encoderThreadLocal = new ThreadLocal<>();
        private boolean prettyPrint = true;
        private boolean outline = false;
        private int indentAmount = 1;
        private Syntax syntax = Syntax.html;

        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            charset(Charset.forName("UTF8"));
        }

        public Charset charset() {
            return this.charset;
        }

        public CharsetEncoder encoder() {
            CharsetEncoder charsetEncoder = this.encoderThreadLocal.get();
            return charsetEncoder != null ? charsetEncoder : prepareEncoder();
        }

        public Entities.EscapeMode escapeMode() {
            return this.escapeMode;
        }

        public int indentAmount() {
            return this.indentAmount;
        }

        public boolean outline() {
            return this.outline;
        }

        public CharsetEncoder prepareEncoder() {
            CharsetEncoder charsetEncoderNewEncoder = this.charset.newEncoder();
            this.encoderThreadLocal.set(charsetEncoderNewEncoder);
            this.coreCharset = Entities.CoreCharset.byName(charsetEncoderNewEncoder.charset().name());
            return charsetEncoderNewEncoder;
        }

        public boolean prettyPrint() {
            return this.prettyPrint;
        }

        public Syntax syntax() {
            return this.syntax;
        }

        public OutputSettings charset(Charset charset) {
            this.charset = charset;
            return this;
        }

        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.charset(this.charset.name());
                outputSettings.escapeMode = Entities.EscapeMode.valueOf(this.escapeMode.name());
                return outputSettings;
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }

        public OutputSettings escapeMode(Entities.EscapeMode escapeMode) {
            this.escapeMode = escapeMode;
            return this;
        }

        public OutputSettings indentAmount(int i2) {
            Validate.isTrue(i2 >= 0);
            this.indentAmount = i2;
            return this;
        }

        public OutputSettings outline(boolean z) {
            this.outline = z;
            return this;
        }

        public OutputSettings prettyPrint(boolean z) {
            this.prettyPrint = z;
            return this;
        }

        public OutputSettings syntax(Syntax syntax) {
            this.syntax = syntax;
            return this;
        }

        public OutputSettings charset(String str) {
            charset(Charset.forName(str));
            return this;
        }
    }

    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(Tag.valueOf("#root", ParseSettings.htmlDefault), str);
        this.outputSettings = new OutputSettings();
        this.quirksMode = QuirksMode.noQuirks;
        this.updateMetaCharset = false;
        this.location = str;
    }

    public static Document createShell(String str) {
        Validate.notNull(str);
        Document document = new Document(str);
        document.parser = document.parser();
        Element elementAppendElement = document.appendElement("html");
        elementAppendElement.appendElement("head");
        elementAppendElement.appendElement("body");
        return document;
    }

    private void ensureMetaCharsetElement() {
        if (this.updateMetaCharset) {
            OutputSettings.Syntax syntax = outputSettings().syntax();
            if (syntax == OutputSettings.Syntax.html) {
                Element elementFirst = select("meta[charset]").first();
                if (elementFirst != null) {
                    elementFirst.attr("charset", charset().displayName());
                } else {
                    Element elementHead = head();
                    if (elementHead != null) {
                        elementHead.appendElement(TTDownloadField.TT_META).attr("charset", charset().displayName());
                    }
                }
                select("meta[name=charset]").remove();
                return;
            }
            if (syntax == OutputSettings.Syntax.xml) {
                Node node = childNodes().get(0);
                if (!(node instanceof XmlDeclaration)) {
                    XmlDeclaration xmlDeclaration = new XmlDeclaration("xml", false);
                    xmlDeclaration.attr("version", "1.0");
                    xmlDeclaration.attr("encoding", charset().displayName());
                    prependChild(xmlDeclaration);
                    return;
                }
                XmlDeclaration xmlDeclaration2 = (XmlDeclaration) node;
                if (xmlDeclaration2.name().equals("xml")) {
                    xmlDeclaration2.attr("encoding", charset().displayName());
                    if (xmlDeclaration2.attr("version") != null) {
                        xmlDeclaration2.attr("version", "1.0");
                        return;
                    }
                    return;
                }
                XmlDeclaration xmlDeclaration3 = new XmlDeclaration("xml", false);
                xmlDeclaration3.attr("version", "1.0");
                xmlDeclaration3.attr("encoding", charset().displayName());
                prependChild(xmlDeclaration3);
            }
        }
    }

    private Element findFirstElementByTagName(String str, Node node) {
        if (node.nodeName().equals(str)) {
            return (Element) node;
        }
        int iChildNodeSize = node.childNodeSize();
        for (int i2 = 0; i2 < iChildNodeSize; i2++) {
            Element elementFindFirstElementByTagName = findFirstElementByTagName(str, node.childNode(i2));
            if (elementFindFirstElementByTagName != null) {
                return elementFindFirstElementByTagName;
            }
        }
        return null;
    }

    private void normaliseStructure(String str, Element element) {
        Elements elementsByTag = getElementsByTag(str);
        Element elementFirst = elementsByTag.first();
        if (elementsByTag.size() > 1) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 1; i2 < elementsByTag.size(); i2++) {
                Element element2 = elementsByTag.get(i2);
                arrayList.addAll(element2.ensureChildNodes());
                element2.remove();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                elementFirst.appendChild((Node) it.next());
            }
        }
        if (elementFirst.parent().equals(element)) {
            return;
        }
        element.appendChild(elementFirst);
    }

    private void normaliseTextNodes(Element element) {
        ArrayList arrayList = new ArrayList();
        for (Node node : element.childNodes) {
            if (node instanceof TextNode) {
                TextNode textNode = (TextNode) node;
                if (!textNode.isBlank()) {
                    arrayList.add(textNode);
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Node node2 = (Node) arrayList.get(size);
            element.removeChild(node2);
            body().prependChild(new TextNode(" "));
            body().prependChild(node2);
        }
    }

    public Element body() {
        return findFirstElementByTagName("body", this);
    }

    public void charset(Charset charset) {
        updateMetaCharsetElement(true);
        this.outputSettings.charset(charset);
        ensureMetaCharsetElement();
    }

    public Element createElement(String str) {
        return new Element(Tag.valueOf(str, ParseSettings.preserveCase), baseUri());
    }

    public DocumentType documentType() {
        for (Node node : this.childNodes) {
            if (node instanceof DocumentType) {
                return (DocumentType) node;
            }
            if (!(node instanceof LeafNode)) {
                return null;
            }
        }
        return null;
    }

    public Element head() {
        return findFirstElementByTagName("head", this);
    }

    public String location() {
        return this.location;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public String nodeName() {
        return "#document";
    }

    public Document normalise() {
        Element elementFindFirstElementByTagName = findFirstElementByTagName("html", this);
        if (elementFindFirstElementByTagName == null) {
            elementFindFirstElementByTagName = appendElement("html");
        }
        if (head() == null) {
            elementFindFirstElementByTagName.prependElement("head");
        }
        if (body() == null) {
            elementFindFirstElementByTagName.appendElement("body");
        }
        normaliseTextNodes(head());
        normaliseTextNodes(elementFindFirstElementByTagName);
        normaliseTextNodes(this);
        normaliseStructure("head", elementFindFirstElementByTagName);
        normaliseStructure("body", elementFindFirstElementByTagName);
        ensureMetaCharsetElement();
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public String outerHtml() {
        return super.html();
    }

    public OutputSettings outputSettings() {
        return this.outputSettings;
    }

    public Parser parser() {
        return this.parser;
    }

    public QuirksMode quirksMode() {
        return this.quirksMode;
    }

    @Override // org.jsoup.nodes.Element
    public Element text(String str) {
        body().text(str);
        return this;
    }

    public String title() {
        Element elementFirst = getElementsByTag("title").first();
        return elementFirst != null ? StringUtil.normaliseWhitespace(elementFirst.text()).trim() : "";
    }

    public void updateMetaCharsetElement(boolean z) {
        this.updateMetaCharset = z;
    }

    public Document outputSettings(OutputSettings outputSettings) {
        Validate.notNull(outputSettings);
        this.outputSettings = outputSettings;
        return this;
    }

    public Document parser(Parser parser) {
        this.parser = parser;
        return this;
    }

    public Document quirksMode(QuirksMode quirksMode) {
        this.quirksMode = quirksMode;
        return this;
    }

    public boolean updateMetaCharsetElement() {
        return this.updateMetaCharset;
    }

    public void title(String str) {
        Validate.notNull(str);
        Element elementFirst = getElementsByTag("title").first();
        if (elementFirst == null) {
            head().appendElement("title").text(str);
        } else {
            elementFirst.text(str);
        }
    }

    public Charset charset() {
        return this.outputSettings.charset();
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    /* JADX INFO: renamed from: clone */
    public Document mo191clone() {
        Document document = (Document) super.mo191clone();
        document.outputSettings = this.outputSettings.clone();
        return document;
    }
}
