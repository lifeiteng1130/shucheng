package org.jsoup.nodes;

import c.a.a.a.a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.NodeFilter;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.QueryParser;
import org.jsoup.select.Selector;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class Element extends Node {
    private Attributes attributes;
    public List<Node> childNodes;
    private WeakReference<List<Element>> shadowChildrenRef;
    private Tag tag;
    private static final List<Node> EMPTY_NODES = Collections.emptyList();
    private static final Pattern classSplit = Pattern.compile("\\s+");
    private static final String baseUriKey = Attributes.internalKey("baseUri");

    public static final class NodeList extends ChangeNotifyingArrayList<Node> {
        private final Element owner;

        public NodeList(Element element, int i2) {
            super(i2);
            this.owner = element;
        }

        @Override // org.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.owner.nodelistChanged();
        }
    }

    public Element(String str) {
        this(Tag.valueOf(str), "", null);
    }

    private static void accumulateParents(Element element, Elements elements) {
        Element elementParent = element.parent();
        if (elementParent == null || elementParent.tagName().equals("#root")) {
            return;
        }
        elements.add(elementParent);
        accumulateParents(elementParent, elements);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendNormalisedText(StringBuilder sb, TextNode textNode) {
        String wholeText = textNode.getWholeText();
        if (preserveWhitespace(textNode.parentNode) || (textNode instanceof CDataNode)) {
            sb.append(wholeText);
        } else {
            StringUtil.appendNormalisedWhitespace(sb, wholeText, TextNode.lastCharIsWhitespace(sb));
        }
    }

    private static void appendWhitespaceIfBr(Element element, StringBuilder sb) {
        if (!element.tag.getName().equals("br") || TextNode.lastCharIsWhitespace(sb)) {
            return;
        }
        sb.append(" ");
    }

    private List<Element> childElementsList() {
        List<Element> list;
        WeakReference<List<Element>> weakReference = this.shadowChildrenRef;
        if (weakReference != null && (list = weakReference.get()) != null) {
            return list;
        }
        int size = this.childNodes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            Node node = this.childNodes.get(i2);
            if (node instanceof Element) {
                arrayList.add((Element) node);
            }
        }
        this.shadowChildrenRef = new WeakReference<>(arrayList);
        return arrayList;
    }

    private static <E extends Element> int indexInList(Element element, List<E> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) == element) {
                return i2;
            }
        }
        return 0;
    }

    private boolean isFormatAsBlock(Document.OutputSettings outputSettings) {
        return this.tag.formatAsBlock() || (parent() != null && parent().tag().formatAsBlock()) || outputSettings.outline();
    }

    private boolean isInlineable(Document.OutputSettings outputSettings) {
        return (!tag().isInline() || tag().isEmpty() || !parent().isBlock() || previousSibling() == null || outputSettings.outline()) ? false : true;
    }

    public static boolean preserveWhitespace(Node node) {
        if (node instanceof Element) {
            Element elementParent = (Element) node;
            int i2 = 0;
            while (!elementParent.tag.preserveWhitespace()) {
                elementParent = elementParent.parent();
                i2++;
                if (i2 >= 6 || elementParent == null) {
                }
            }
            return true;
        }
        return false;
    }

    private static String searchUpForAttribute(Element element, String str) {
        while (element != null) {
            if (element.hasAttributes() && element.attributes.hasKey(str)) {
                return element.attributes.get(str);
            }
            element = element.parent();
        }
        return "";
    }

    public Element addClass(String str) {
        Validate.notNull(str);
        Set<String> setClassNames = classNames();
        setClassNames.add(str);
        classNames(setClassNames);
        return this;
    }

    public Element append(String str) {
        Validate.notNull(str);
        addChildren((Node[]) NodeUtils.parser(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    public Element appendChild(Node node) {
        Validate.notNull(node);
        reparentChild(node);
        ensureChildNodes();
        this.childNodes.add(node);
        node.setSiblingIndex(this.childNodes.size() - 1);
        return this;
    }

    public Element appendElement(String str) {
        Element element = new Element(Tag.valueOf(str, NodeUtils.parser(this).settings()), baseUri());
        appendChild(element);
        return element;
    }

    public Element appendText(String str) {
        Validate.notNull(str);
        appendChild(new TextNode(str));
        return this;
    }

    public Element appendTo(Element element) {
        Validate.notNull(element);
        element.appendChild(this);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Attributes attributes() {
        if (!hasAttributes()) {
            this.attributes = new Attributes();
        }
        return this.attributes;
    }

    @Override // org.jsoup.nodes.Node
    public String baseUri() {
        return searchUpForAttribute(this, baseUriKey);
    }

    public Element child(int i2) {
        return childElementsList().get(i2);
    }

    @Override // org.jsoup.nodes.Node
    public int childNodeSize() {
        return this.childNodes.size();
    }

    public Elements children() {
        return new Elements(childElementsList());
    }

    public int childrenSize() {
        return childElementsList().size();
    }

    public String className() {
        return attr("class").trim();
    }

    public Set<String> classNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(classSplit.split(className())));
        linkedHashSet.remove("");
        return linkedHashSet;
    }

    public Element closest(String str) {
        return closest(QueryParser.parse(str));
    }

    public String cssSelector() {
        if (id().length() > 0) {
            StringBuilder sbR = a.r("#");
            sbR.append(id());
            return sbR.toString();
        }
        StringBuilder sb = new StringBuilder(tagName().replace(':', '|'));
        String strJoin = StringUtil.join(classNames(), ".");
        if (strJoin.length() > 0) {
            sb.append('.');
            sb.append(strJoin);
        }
        if (parent() == null || (parent() instanceof Document)) {
            return sb.toString();
        }
        sb.insert(0, " > ");
        if (parent().select(sb.toString()).size() > 1) {
            sb.append(String.format(":nth-child(%d)", Integer.valueOf(elementSiblingIndex() + 1)));
        }
        return parent().cssSelector() + sb.toString();
    }

    public String data() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        for (Node node : this.childNodes) {
            if (node instanceof DataNode) {
                sbBorrowBuilder.append(((DataNode) node).getWholeData());
            } else if (node instanceof Comment) {
                sbBorrowBuilder.append(((Comment) node).getData());
            } else if (node instanceof Element) {
                sbBorrowBuilder.append(((Element) node).data());
            } else if (node instanceof CDataNode) {
                sbBorrowBuilder.append(((CDataNode) node).getWholeText());
            }
        }
        return StringUtil.releaseBuilder(sbBorrowBuilder);
    }

    public List<DataNode> dataNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.childNodes) {
            if (node instanceof DataNode) {
                arrayList.add((DataNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Map<String, String> dataset() {
        return attributes().dataset();
    }

    @Override // org.jsoup.nodes.Node
    public void doSetBaseUri(String str) {
        attributes().put(baseUriKey, str);
    }

    public int elementSiblingIndex() {
        if (parent() == null) {
            return 0;
        }
        return indexInList(this, parent().childElementsList());
    }

    @Override // org.jsoup.nodes.Node
    public List<Node> ensureChildNodes() {
        if (this.childNodes == EMPTY_NODES) {
            this.childNodes = new NodeList(this, 4);
        }
        return this.childNodes;
    }

    public Element firstElementSibling() {
        List<Element> listChildElementsList = parent().childElementsList();
        if (listChildElementsList.size() > 1) {
            return listChildElementsList.get(0);
        }
        return null;
    }

    public Elements getAllElements() {
        return Collector.collect(new Evaluator.AllElements(), this);
    }

    public Element getElementById(String str) {
        Validate.notEmpty(str);
        Elements elementsCollect = Collector.collect(new Evaluator.Id(str), this);
        if (elementsCollect.size() > 0) {
            return elementsCollect.get(0);
        }
        return null;
    }

    public Elements getElementsByAttribute(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Attribute(str.trim()), this);
    }

    public Elements getElementsByAttributeStarting(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.AttributeStarting(str.trim()), this);
    }

    public Elements getElementsByAttributeValue(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValue(str, str2), this);
    }

    public Elements getElementsByAttributeValueContaining(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueContaining(str, str2), this);
    }

    public Elements getElementsByAttributeValueEnding(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueEnding(str, str2), this);
    }

    public Elements getElementsByAttributeValueMatching(String str, Pattern pattern) {
        return Collector.collect(new Evaluator.AttributeWithValueMatching(str, pattern), this);
    }

    public Elements getElementsByAttributeValueNot(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueNot(str, str2), this);
    }

    public Elements getElementsByAttributeValueStarting(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueStarting(str, str2), this);
    }

    public Elements getElementsByClass(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Class(str), this);
    }

    public Elements getElementsByIndexEquals(int i2) {
        return Collector.collect(new Evaluator.IndexEquals(i2), this);
    }

    public Elements getElementsByIndexGreaterThan(int i2) {
        return Collector.collect(new Evaluator.IndexGreaterThan(i2), this);
    }

    public Elements getElementsByIndexLessThan(int i2) {
        return Collector.collect(new Evaluator.IndexLessThan(i2), this);
    }

    public Elements getElementsByTag(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Tag(Normalizer.normalize(str)), this);
    }

    public Elements getElementsContainingOwnText(String str) {
        return Collector.collect(new Evaluator.ContainsOwnText(str), this);
    }

    public Elements getElementsContainingText(String str) {
        return Collector.collect(new Evaluator.ContainsText(str), this);
    }

    public Elements getElementsMatchingOwnText(Pattern pattern) {
        return Collector.collect(new Evaluator.MatchesOwn(pattern), this);
    }

    public Elements getElementsMatchingText(Pattern pattern) {
        return Collector.collect(new Evaluator.Matches(pattern), this);
    }

    @Override // org.jsoup.nodes.Node
    public boolean hasAttributes() {
        return this.attributes != null;
    }

    public boolean hasClass(String str) {
        if (!hasAttributes()) {
            return false;
        }
        String ignoreCase = this.attributes.getIgnoreCase("class");
        int length = ignoreCase.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(ignoreCase);
            }
            boolean z = false;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (Character.isWhitespace(ignoreCase.charAt(i3))) {
                    if (!z) {
                        continue;
                    } else {
                        if (i3 - i2 == length2 && ignoreCase.regionMatches(true, i2, str, 0, length2)) {
                            return true;
                        }
                        z = false;
                    }
                } else if (!z) {
                    i2 = i3;
                    z = true;
                }
            }
            if (z && length - i2 == length2) {
                return ignoreCase.regionMatches(true, i2, str, 0, length2);
            }
        }
        return false;
    }

    public boolean hasText() {
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                if (!((TextNode) node).isBlank()) {
                    return true;
                }
            } else if ((node instanceof Element) && ((Element) node).hasText()) {
                return true;
            }
        }
        return false;
    }

    public String html() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        html(sbBorrowBuilder);
        String strReleaseBuilder = StringUtil.releaseBuilder(sbBorrowBuilder);
        return NodeUtils.outputSettings(this).prettyPrint() ? strReleaseBuilder.trim() : strReleaseBuilder;
    }

    public String id() {
        return hasAttributes() ? this.attributes.getIgnoreCase("id") : "";
    }

    public Element insertChildren(int i2, Collection<? extends Node> collection) {
        Validate.notNull(collection, "Children collection to be inserted must not be null.");
        int iChildNodeSize = childNodeSize();
        if (i2 < 0) {
            i2 += iChildNodeSize + 1;
        }
        Validate.isTrue(i2 >= 0 && i2 <= iChildNodeSize, "Insert position out of bounds.");
        addChildren(i2, (Node[]) new ArrayList(collection).toArray(new Node[0]));
        return this;
    }

    public boolean is(String str) {
        return is(QueryParser.parse(str));
    }

    public boolean isBlock() {
        return this.tag.isBlock();
    }

    public Element lastElementSibling() {
        List<Element> listChildElementsList = parent().childElementsList();
        if (listChildElementsList.size() > 1) {
            return (Element) a.E(listChildElementsList, 1);
        }
        return null;
    }

    public Element nextElementSibling() {
        if (this.parentNode == null) {
            return null;
        }
        List<Element> listChildElementsList = parent().childElementsList();
        int iIndexInList = indexInList(this, listChildElementsList) + 1;
        if (listChildElementsList.size() > iIndexInList) {
            return listChildElementsList.get(iIndexInList);
        }
        return null;
    }

    public Elements nextElementSiblings() {
        return nextElementSiblings(true);
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return this.tag.getName();
    }

    @Override // org.jsoup.nodes.Node
    public void nodelistChanged() {
        super.nodelistChanged();
        this.shadowChildrenRef = null;
    }

    public String normalName() {
        return this.tag.normalName();
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.prettyPrint() && isFormatAsBlock(outputSettings) && !isInlineable(outputSettings) && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0)) {
            indent(appendable, i2, outputSettings);
        }
        appendable.append('<').append(tagName());
        Attributes attributes = this.attributes;
        if (attributes != null) {
            attributes.html(appendable, outputSettings);
        }
        if (!this.childNodes.isEmpty() || !this.tag.isSelfClosing()) {
            appendable.append('>');
        } else if (outputSettings.syntax() == Document.OutputSettings.Syntax.html && this.tag.isEmpty()) {
            appendable.append('>');
        } else {
            appendable.append(" />");
        }
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (this.childNodes.isEmpty() && this.tag.isSelfClosing()) {
            return;
        }
        if (outputSettings.prettyPrint() && !this.childNodes.isEmpty() && (this.tag.formatAsBlock() || (outputSettings.outline() && (this.childNodes.size() > 1 || (this.childNodes.size() == 1 && !(this.childNodes.get(0) instanceof TextNode)))))) {
            indent(appendable, i2, outputSettings);
        }
        appendable.append("</").append(tagName()).append('>');
    }

    public String ownText() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        ownText(sbBorrowBuilder);
        return StringUtil.releaseBuilder(sbBorrowBuilder).trim();
    }

    public Elements parents() {
        Elements elements = new Elements();
        accumulateParents(this, elements);
        return elements;
    }

    public Element prepend(String str) {
        Validate.notNull(str);
        addChildren(0, (Node[]) NodeUtils.parser(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    public Element prependChild(Node node) {
        Validate.notNull(node);
        addChildren(0, node);
        return this;
    }

    public Element prependElement(String str) {
        Element element = new Element(Tag.valueOf(str, NodeUtils.parser(this).settings()), baseUri());
        prependChild(element);
        return element;
    }

    public Element prependText(String str) {
        Validate.notNull(str);
        prependChild(new TextNode(str));
        return this;
    }

    public Element previousElementSibling() {
        List<Element> listChildElementsList;
        int iIndexInList;
        if (this.parentNode != null && (iIndexInList = indexInList(this, (listChildElementsList = parent().childElementsList()))) > 0) {
            return listChildElementsList.get(iIndexInList - 1);
        }
        return null;
    }

    public Elements previousElementSiblings() {
        return nextElementSiblings(false);
    }

    public Element removeClass(String str) {
        Validate.notNull(str);
        Set<String> setClassNames = classNames();
        setClassNames.remove(str);
        classNames(setClassNames);
        return this;
    }

    public Elements select(String str) {
        return Selector.select(str, this);
    }

    public Element selectFirst(String str) {
        return Selector.selectFirst(str, this);
    }

    public Elements siblingElements() {
        if (this.parentNode == null) {
            return new Elements(0);
        }
        List<Element> listChildElementsList = parent().childElementsList();
        Elements elements = new Elements(listChildElementsList.size() - 1);
        for (Element element : listChildElementsList) {
            if (element != this) {
                elements.add(element);
            }
        }
        return elements;
    }

    public Tag tag() {
        return this.tag;
    }

    public String tagName() {
        return this.tag.getName();
    }

    public String text() {
        final StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new NodeVisitor() { // from class: org.jsoup.nodes.Element.1
            @Override // org.jsoup.select.NodeVisitor
            public void head(Node node, int i2) {
                if (node instanceof TextNode) {
                    Element.appendNormalisedText(sbBorrowBuilder, (TextNode) node);
                } else if (node instanceof Element) {
                    Element element = (Element) node;
                    if (sbBorrowBuilder.length() > 0) {
                        if ((element.isBlock() || element.tag.getName().equals("br")) && !TextNode.lastCharIsWhitespace(sbBorrowBuilder)) {
                            sbBorrowBuilder.append(' ');
                        }
                    }
                }
            }

            @Override // org.jsoup.select.NodeVisitor
            public void tail(Node node, int i2) {
                if ((node instanceof Element) && ((Element) node).isBlock() && (node.nextSibling() instanceof TextNode) && !TextNode.lastCharIsWhitespace(sbBorrowBuilder)) {
                    sbBorrowBuilder.append(' ');
                }
            }
        }, this);
        return StringUtil.releaseBuilder(sbBorrowBuilder).trim();
    }

    public List<TextNode> textNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                arrayList.add((TextNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Element toggleClass(String str) {
        Validate.notNull(str);
        Set<String> setClassNames = classNames();
        if (setClassNames.contains(str)) {
            setClassNames.remove(str);
        } else {
            setClassNames.add(str);
        }
        classNames(setClassNames);
        return this;
    }

    public String val() {
        return normalName().equals("textarea") ? text() : attr(ES6Iterator.VALUE_PROPERTY);
    }

    public String wholeText() {
        final StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new NodeVisitor() { // from class: org.jsoup.nodes.Element.2
            @Override // org.jsoup.select.NodeVisitor
            public void head(Node node, int i2) {
                if (node instanceof TextNode) {
                    sbBorrowBuilder.append(((TextNode) node).getWholeText());
                }
            }

            @Override // org.jsoup.select.NodeVisitor
            public void tail(Node node, int i2) {
            }
        }, this);
        return StringUtil.releaseBuilder(sbBorrowBuilder);
    }

    public Element(Tag tag, String str, Attributes attributes) {
        Validate.notNull(tag);
        this.childNodes = EMPTY_NODES;
        this.attributes = attributes;
        this.tag = tag;
        if (str != null) {
            setBaseUri(str);
        }
    }

    private Elements nextElementSiblings(boolean z) {
        Elements elements = new Elements();
        if (this.parentNode == null) {
            return elements;
        }
        elements.add(this);
        return z ? elements.nextAll() : elements.prevAll();
    }

    @Override // org.jsoup.nodes.Node
    public Element attr(String str, String str2) {
        super.attr(str, str2);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element clearAttributes() {
        if (this.attributes != null) {
            super.clearAttributes();
            this.attributes = null;
        }
        return this;
    }

    public Element closest(Evaluator evaluator) {
        Validate.notNull(evaluator);
        Element elementRoot = root();
        Element elementParent = this;
        while (!evaluator.matches(elementRoot, elementParent)) {
            elementParent = elementParent.parent();
            if (elementParent == null) {
                return null;
            }
        }
        return elementParent;
    }

    @Override // org.jsoup.nodes.Node
    public Element doClone(Node node) {
        Element element = (Element) super.doClone(node);
        Attributes attributes = this.attributes;
        element.attributes = attributes != null ? attributes.clone() : null;
        NodeList nodeList = new NodeList(element, this.childNodes.size());
        element.childNodes = nodeList;
        nodeList.addAll(this.childNodes);
        element.setBaseUri(baseUri());
        return element;
    }

    @Override // org.jsoup.nodes.Node
    public Element empty() {
        this.childNodes.clear();
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element filter(NodeFilter nodeFilter) {
        return (Element) super.filter(nodeFilter);
    }

    public Elements getElementsByAttributeValueMatching(String str, String str2) {
        try {
            return getElementsByAttributeValueMatching(str, Pattern.compile(str2));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException(a.i("Pattern syntax error: ", str2), e2);
        }
    }

    public Elements getElementsMatchingOwnText(String str) {
        try {
            return getElementsMatchingOwnText(Pattern.compile(str));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException(a.i("Pattern syntax error: ", str), e2);
        }
    }

    public Elements getElementsMatchingText(String str) {
        try {
            return getElementsMatchingText(Pattern.compile(str));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException(a.i("Pattern syntax error: ", str), e2);
        }
    }

    public boolean is(Evaluator evaluator) {
        return evaluator.matches(root(), this);
    }

    @Override // org.jsoup.nodes.Node
    public final Element parent() {
        return (Element) this.parentNode;
    }

    @Override // org.jsoup.nodes.Node
    public Element removeAttr(String str) {
        return (Element) super.removeAttr(str);
    }

    @Override // org.jsoup.nodes.Node
    public Element root() {
        return (Element) super.root();
    }

    public Elements select(Evaluator evaluator) {
        return Selector.select(evaluator, this);
    }

    public Element selectFirst(Evaluator evaluator) {
        return Collector.findFirst(evaluator, this);
    }

    @Override // org.jsoup.nodes.Node
    public Element shallowClone() {
        Tag tag = this.tag;
        String strBaseUri = baseUri();
        Attributes attributes = this.attributes;
        return new Element(tag, strBaseUri, attributes == null ? null : attributes.clone());
    }

    public Element tagName(String str) {
        Validate.notEmpty(str, "Tag name must not be empty.");
        this.tag = Tag.valueOf(str, NodeUtils.parser(this).settings());
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element traverse(NodeVisitor nodeVisitor) {
        return (Element) super.traverse(nodeVisitor);
    }

    @Override // org.jsoup.nodes.Node
    public Element wrap(String str) {
        return (Element) super.wrap(str);
    }

    @Override // org.jsoup.nodes.Node
    public Element after(String str) {
        return (Element) super.after(str);
    }

    public Element attr(String str, boolean z) {
        attributes().put(str, z);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element before(String str) {
        return (Element) super.before(str);
    }

    @Override // org.jsoup.nodes.Node
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Element mo191clone() {
        return (Element) super.mo191clone();
    }

    private void ownText(StringBuilder sb) {
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                appendNormalisedText(sb, (TextNode) node);
            } else if (node instanceof Element) {
                appendWhitespaceIfBr((Element) node, sb);
            }
        }
    }

    @Override // org.jsoup.nodes.Node
    public Element after(Node node) {
        return (Element) super.after(node);
    }

    @Override // org.jsoup.nodes.Node
    public Element before(Node node) {
        return (Element) super.before(node);
    }

    public Element classNames(Set<String> set) {
        Validate.notNull(set);
        if (set.isEmpty()) {
            attributes().remove("class");
        } else {
            attributes().put("class", StringUtil.join(set, " "));
        }
        return this;
    }

    public Element text(String str) {
        Validate.notNull(str);
        empty();
        appendChild(new TextNode(str));
        return this;
    }

    public Element val(String str) {
        if (normalName().equals("textarea")) {
            text(str);
        } else {
            attr(ES6Iterator.VALUE_PROPERTY, str);
        }
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public <T extends Appendable> T html(T t) {
        int size = this.childNodes.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.childNodes.get(i2).outerHtml(t);
        }
        return t;
    }

    public Element html(String str) {
        empty();
        append(str);
        return this;
    }

    public Element insertChildren(int i2, Node... nodeArr) {
        Validate.notNull(nodeArr, "Children collection to be inserted must not be null.");
        int iChildNodeSize = childNodeSize();
        if (i2 < 0) {
            i2 += iChildNodeSize + 1;
        }
        Validate.isTrue(i2 >= 0 && i2 <= iChildNodeSize, "Insert position out of bounds.");
        addChildren(i2, nodeArr);
        return this;
    }

    public Element(Tag tag, String str) {
        this(tag, str, null);
    }
}
