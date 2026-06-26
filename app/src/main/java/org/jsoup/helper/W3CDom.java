package org.jsoup.helper;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes3.dex */
public class W3CDom {
    public DocumentBuilderFactory factory;

    public static class W3CBuilder implements NodeVisitor {
        private static final String xmlnsKey = "xmlns";
        private static final String xmlnsPrefix = "xmlns:";
        private Element dest;
        private final Document doc;
        private final Stack<HashMap<String, String>> namespacesStack;

        public W3CBuilder(Document document) {
            Stack<HashMap<String, String>> stack = new Stack<>();
            this.namespacesStack = stack;
            this.doc = document;
            stack.push(new HashMap<>());
        }

        private void copyAttributes(Node node, Element element) {
            for (Attribute attribute : node.attributes()) {
                String strReplaceAll = attribute.getKey().replaceAll("[^-a-zA-Z0-9_:.]", "");
                if (strReplaceAll.matches("[a-zA-Z_:][-a-zA-Z0-9_:.]*")) {
                    element.setAttribute(strReplaceAll, attribute.getValue());
                }
            }
        }

        private String updateNamespaces(org.jsoup.nodes.Element element) {
            Iterator<Attribute> it = element.attributes().iterator();
            while (true) {
                String strSubstring = "";
                if (!it.hasNext()) {
                    break;
                }
                Attribute next = it.next();
                String key = next.getKey();
                if (!key.equals(xmlnsKey)) {
                    if (key.startsWith(xmlnsPrefix)) {
                        strSubstring = key.substring(6);
                    }
                }
                this.namespacesStack.peek().put(strSubstring, next.getValue());
            }
            int iIndexOf = element.tagName().indexOf(":");
            return iIndexOf > 0 ? element.tagName().substring(0, iIndexOf) : "";
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i2) {
            this.namespacesStack.push(new HashMap<>(this.namespacesStack.peek()));
            if (!(node instanceof org.jsoup.nodes.Element)) {
                if (node instanceof TextNode) {
                    this.dest.appendChild(this.doc.createTextNode(((TextNode) node).getWholeText()));
                    return;
                } else if (node instanceof Comment) {
                    this.dest.appendChild(this.doc.createComment(((Comment) node).getData()));
                    return;
                } else {
                    if (node instanceof DataNode) {
                        this.dest.appendChild(this.doc.createTextNode(((DataNode) node).getWholeData()));
                        return;
                    }
                    return;
                }
            }
            org.jsoup.nodes.Element element = (org.jsoup.nodes.Element) node;
            String str = this.namespacesStack.peek().get(updateNamespaces(element));
            String strTagName = element.tagName();
            Element elementCreateElementNS = (str == null && strTagName.contains(":")) ? this.doc.createElementNS("", strTagName) : this.doc.createElementNS(str, strTagName);
            copyAttributes(element, elementCreateElementNS);
            Element element2 = this.dest;
            if (element2 == null) {
                this.doc.appendChild(elementCreateElementNS);
            } else {
                element2.appendChild(elementCreateElementNS);
            }
            this.dest = elementCreateElementNS;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i2) {
            if ((node instanceof org.jsoup.nodes.Element) && (this.dest.getParentNode() instanceof Element)) {
                this.dest = (Element) this.dest.getParentNode();
            }
            this.namespacesStack.pop();
        }
    }

    public W3CDom() {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        this.factory = documentBuilderFactoryNewInstance;
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
    }

    public static HashMap<String, String> OutputHtml() {
        return methodMap("html");
    }

    public static HashMap<String, String> OutputXml() {
        return methodMap("xml");
    }

    public static String asString(Document document, Map<String, String> map) {
        try {
            DOMSource dOMSource = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            if (map != null) {
                transformerNewTransformer.setOutputProperties(propertiesFromMap(map));
            }
            if (document.getDoctype() != null) {
                DocumentType doctype = document.getDoctype();
                if (!StringUtil.isBlank(doctype.getPublicId())) {
                    transformerNewTransformer.setOutputProperty("doctype-public", doctype.getPublicId());
                }
                if (!StringUtil.isBlank(doctype.getSystemId())) {
                    transformerNewTransformer.setOutputProperty("doctype-system", doctype.getSystemId());
                } else if (doctype.getName().equalsIgnoreCase("html") && StringUtil.isBlank(doctype.getPublicId()) && StringUtil.isBlank(doctype.getSystemId())) {
                    transformerNewTransformer.setOutputProperty("doctype-system", "about:legacy-compat");
                }
            }
            transformerNewTransformer.transform(dOMSource, streamResult);
            return stringWriter.toString();
        } catch (TransformerException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Document convert(org.jsoup.nodes.Document document) {
        return new W3CDom().fromJsoup(document);
    }

    private static HashMap<String, String> methodMap(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", str);
        return map;
    }

    public static Properties propertiesFromMap(Map<String, String> map) {
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    public Document fromJsoup(org.jsoup.nodes.Document document) {
        Validate.notNull(document);
        try {
            DocumentBuilder documentBuilderNewDocumentBuilder = this.factory.newDocumentBuilder();
            DOMImplementation dOMImplementation = documentBuilderNewDocumentBuilder.getDOMImplementation();
            Document documentNewDocument = documentBuilderNewDocumentBuilder.newDocument();
            org.jsoup.nodes.DocumentType documentType = document.documentType();
            if (documentType != null) {
                documentNewDocument.appendChild(dOMImplementation.createDocumentType(documentType.name(), documentType.publicId(), documentType.systemId()));
            }
            documentNewDocument.setXmlStandalone(true);
            convert(document, documentNewDocument);
            return documentNewDocument;
        } catch (ParserConfigurationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void convert(org.jsoup.nodes.Document document, Document document2) {
        if (!StringUtil.isBlank(document.location())) {
            document2.setDocumentURI(document.location());
        }
        NodeTraversor.traverse(new W3CBuilder(document2), document.child(0));
    }

    public String asString(Document document) {
        return asString(document, null);
    }
}
