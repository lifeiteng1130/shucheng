package org.mozilla.javascript.xmlimpl;

import androidx.core.app.NotificationCompat;
import c.a.a.a.a;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xml.XMLObject;
import org.mozilla.javascript.xmlimpl.XmlNode;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public class XML extends XMLObjectImpl {
    public static final long serialVersionUID = -630969919086449092L;
    private XmlNode node;

    public XML(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject, XmlNode xmlNode) {
        super(xMLLibImpl, scriptable, xMLObject);
        initialize(xmlNode);
    }

    private XmlNode.Namespace adapt(Namespace namespace) {
        return namespace.prefix() == null ? XmlNode.Namespace.create(namespace.uri()) : XmlNode.Namespace.create(namespace.prefix(), namespace.uri());
    }

    private void addInScopeNamespace(Namespace namespace) {
        if (isElement() && namespace.prefix() != null) {
            if (namespace.prefix().length() == 0 && namespace.uri().length() == 0) {
                return;
            }
            if (this.node.getQname().getNamespace().getPrefix().equals(namespace.prefix())) {
                this.node.invalidateNamespacePrefix();
            }
            this.node.declareNamespace(namespace.prefix(), namespace.uri());
        }
    }

    private String ecmaToString() {
        if (isAttribute() || isText()) {
            return ecmaValue();
        }
        if (!hasSimpleContent()) {
            return toXMLString();
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.node.getChildCount(); i2++) {
            XmlNode child = this.node.getChild(i2);
            if (!child.isProcessingInstructionType() && !child.isCommentType()) {
                sb.append(new XML(getLib(), getParentScope(), (XMLObject) getPrototype(), child).toString());
            }
        }
        return sb.toString();
    }

    private String ecmaValue() {
        return this.node.ecmaValue();
    }

    private int getChildIndexOf(XML xml) {
        for (int i2 = 0; i2 < this.node.getChildCount(); i2++) {
            if (this.node.getChild(i2).isSameNode(xml.node)) {
                return i2;
            }
        }
        return -1;
    }

    private XmlNode[] getNodesForInsert(Object obj) {
        if (obj instanceof XML) {
            return new XmlNode[]{((XML) obj).node};
        }
        if (!(obj instanceof XMLList)) {
            return new XmlNode[]{XmlNode.createText(getProcessor(), ScriptRuntime.toString(obj))};
        }
        XMLList xMLList = (XMLList) obj;
        XmlNode[] xmlNodeArr = new XmlNode[xMLList.length()];
        for (int i2 = 0; i2 < xMLList.length(); i2++) {
            xmlNodeArr[i2] = xMLList.item(i2).node;
        }
        return xmlNodeArr;
    }

    private XML toXML(XmlNode xmlNode) {
        if (xmlNode.getXml() == null) {
            xmlNode.setXml(newXML(xmlNode));
        }
        return xmlNode.getXml();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void addMatches(XMLList xMLList, XMLName xMLName) {
        xMLName.addMatches(xMLList, this);
    }

    public XML addNamespace(Namespace namespace) {
        addInScopeNamespace(namespace);
        return this;
    }

    public XML appendChild(Object obj) {
        if (this.node.isParentType()) {
            XmlNode[] nodesForInsert = getNodesForInsert(obj);
            XmlNode xmlNode = this.node;
            xmlNode.insertChildrenAt(xmlNode.getChildCount(), nodesForInsert);
        }
        return this;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList child(XMLName xMLName) {
        XMLList xMLListNewXMLList = newXMLList();
        XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.ELEMENT);
        for (int i2 = 0; i2 < matchingChildren.length; i2++) {
            if (xMLName.matchesElement(matchingChildren[i2].getQname())) {
                xMLListNewXMLList.addToList(toXML(matchingChildren[i2]));
            }
        }
        xMLListNewXMLList.setTargets(this, xMLName.toQname());
        return xMLListNewXMLList;
    }

    public int childIndex() {
        return this.node.getChildIndex();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList children() {
        XMLList xMLListNewXMLList = newXMLList();
        xMLListNewXMLList.setTargets(this, XMLName.formStar().toQname());
        for (XmlNode xmlNode : this.node.getMatchingChildren(XmlNode.Filter.TRUE)) {
            xMLListNewXMLList.addToList(toXML(xmlNode));
        }
        return xMLListNewXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList comments() {
        XMLList xMLListNewXMLList = newXMLList();
        this.node.addMatchingChildren(xMLListNewXMLList, XmlNode.Filter.COMMENT);
        return xMLListNewXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean contains(Object obj) {
        if (obj instanceof XML) {
            return equivalentXml(obj);
        }
        return false;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLObjectImpl copy() {
        return newXML(this.node.copy());
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i2) {
        if (i2 == 0) {
            remove();
        }
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void deleteXMLProperty(XMLName xMLName) {
        XMLList propertyList = getPropertyList(xMLName);
        for (int i2 = 0; i2 < propertyList.length(); i2++) {
            propertyList.item(i2).node.deleteMe();
        }
    }

    public final String ecmaClass() {
        if (this.node.isTextType()) {
            return NotificationCompat.MessagingStyle.Message.KEY_TEXT;
        }
        if (this.node.isAttributeType()) {
            return "attribute";
        }
        if (this.node.isCommentType()) {
            return "comment";
        }
        if (this.node.isProcessingInstructionType()) {
            return "processing-instruction";
        }
        if (this.node.isElementType()) {
            return "element";
        }
        StringBuilder sbR = a.r("Unrecognized type: ");
        sbR.append(this.node);
        throw new RuntimeException(sbR.toString());
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList elements(XMLName xMLName) {
        XMLList xMLListNewXMLList = newXMLList();
        xMLListNewXMLList.setTargets(this, xMLName.toQname());
        XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.ELEMENT);
        for (int i2 = 0; i2 < matchingChildren.length; i2++) {
            if (xMLName.matches(toXML(matchingChildren[i2]))) {
                xMLListNewXMLList.addToList(toXML(matchingChildren[i2]));
            }
        }
        return xMLListNewXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean equivalentXml(Object obj) {
        if (obj instanceof XML) {
            return this.node.toXmlString(getProcessor()).equals(((XML) obj).node.toXmlString(getProcessor()));
        }
        if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            if (xMLList.length() == 1) {
                return equivalentXml(xMLList.getXML());
            }
            return false;
        }
        if (!hasSimpleContent()) {
            return false;
        }
        return toString().equals(ScriptRuntime.toString(obj));
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i2, Scriptable scriptable) {
        return i2 == 0 ? this : Scriptable.NOT_FOUND;
    }

    public XmlNode getAnnotation() {
        return this.node;
    }

    public XML[] getAttributes() {
        XmlNode[] attributes = this.node.getAttributes();
        int length = attributes.length;
        XML[] xmlArr = new XML[length];
        for (int i2 = 0; i2 < length; i2++) {
            xmlArr[i2] = toXML(attributes[i2]);
        }
        return xmlArr;
    }

    public XML[] getChildren() {
        if (!isElement()) {
            return null;
        }
        XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.TRUE);
        int length = matchingChildren.length;
        XML[] xmlArr = new XML[length];
        for (int i2 = 0; i2 < length; i2++) {
            xmlArr[i2] = toXML(matchingChildren[i2]);
        }
        return xmlArr;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "XML";
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Scriptable getExtraMethodSource(Context context) {
        if (hasSimpleContent()) {
            return ScriptRuntime.toObjectOrNull(context, toString());
        }
        return null;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return isPrototype() ? new Object[0] : new Object[]{0};
    }

    public XML getLastXmlChild() {
        int childCount = this.node.getChildCount() - 1;
        if (childCount < 0) {
            return null;
        }
        return getXmlChild(childCount);
    }

    public XmlNode.QName getNodeQname() {
        return this.node.getQname();
    }

    public XMLList getPropertyList(XMLName xMLName) {
        return xMLName.getMyValueOn(this);
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public final XML getXML() {
        return this;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object getXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName);
    }

    public XML getXmlChild(int i2) {
        XmlNode child = this.node.getChild(i2);
        if (child.getXml() == null) {
            child.setXml(newXML(child));
        }
        return child.getXml();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i2, Scriptable scriptable) {
        return i2 == 0;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasComplexContent() {
        return !hasSimpleContent();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasOwnProperty(XMLName xMLName) {
        if (isPrototype()) {
            if (findPrototypeId(xMLName.localName()) != 0) {
                return true;
            }
        } else if (getPropertyList(xMLName).length() > 0) {
            return true;
        }
        return false;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasSimpleContent() {
        if (isComment() || isProcessingInstruction()) {
            return false;
        }
        if (isText() || this.node.isAttributeType()) {
            return true;
        }
        return !this.node.hasChildElement();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName).length() > 0;
    }

    public Namespace[] inScopeNamespaces() {
        return createNamespaces(this.node.getInScopeNamespaces());
    }

    public void initialize(XmlNode xmlNode) {
        this.node = xmlNode;
        xmlNode.setXml(this);
    }

    public XML insertChildAfter(XML xml, Object obj) {
        if (xml == null) {
            prependChild(obj);
        } else {
            XmlNode[] nodesForInsert = getNodesForInsert(obj);
            int childIndexOf = getChildIndexOf(xml);
            if (childIndexOf != -1) {
                this.node.insertChildrenAt(childIndexOf + 1, nodesForInsert);
            }
        }
        return this;
    }

    public XML insertChildBefore(XML xml, Object obj) {
        if (xml == null) {
            appendChild(obj);
        } else {
            XmlNode[] nodesForInsert = getNodesForInsert(obj);
            int childIndexOf = getChildIndexOf(xml);
            if (childIndexOf != -1) {
                this.node.insertChildrenAt(childIndexOf, nodesForInsert);
            }
        }
        return this;
    }

    public boolean is(XML xml) {
        return this.node.isSameNode(xml.node);
    }

    public final boolean isAttribute() {
        return this.node.isAttributeType();
    }

    public final boolean isComment() {
        return this.node.isCommentType();
    }

    public final boolean isElement() {
        return this.node.isElementType();
    }

    public final boolean isProcessingInstruction() {
        return this.node.isProcessingInstructionType();
    }

    public final boolean isText() {
        return this.node.isTextType();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object jsConstructor(Context context, boolean z, Object[] objArr) {
        if (objArr.length == 0 || objArr[0] == null || objArr[0] == Undefined.instance) {
            objArr = new Object[]{""};
        }
        XML xmlEcmaToXml = ecmaToXml(objArr[0]);
        return z ? xmlEcmaToXml.copy() : xmlEcmaToXml;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public int length() {
        return 1;
    }

    public String localName() {
        if (name() == null) {
            return null;
        }
        return name().localName();
    }

    public XML makeXmlFromString(XMLName xMLName, String str) {
        try {
            return newTextElementXML(this.node, xMLName.toQname(), str);
        } catch (Exception e2) {
            throw ScriptRuntime.typeError(e2.getMessage());
        }
    }

    public QName name() {
        if (isText() || isComment()) {
            return null;
        }
        return isProcessingInstruction() ? newQName("", this.node.getQname().getLocalName(), null) : newQName(this.node.getQname());
    }

    public Namespace namespace(String str) {
        return str == null ? createNamespace(this.node.getNamespaceDeclaration()) : createNamespace(this.node.getNamespaceDeclaration(str));
    }

    public Namespace[] namespaceDeclarations() {
        return createNamespaces(this.node.getNamespaceDeclarations());
    }

    public Object nodeKind() {
        return ecmaClass();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void normalize() {
        this.node.normalize();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object parent() {
        if (this.node.parent() == null) {
            return null;
        }
        return newXML(this.node.parent());
    }

    public XML prependChild(Object obj) {
        if (this.node.isParentType()) {
            this.node.insertChildrenAt(0, getNodesForInsert(obj));
        }
        return this;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList processingInstructions(XMLName xMLName) {
        XMLList xMLListNewXMLList = newXMLList();
        this.node.addMatchingChildren(xMLListNewXMLList, XmlNode.Filter.PROCESSING_INSTRUCTION(xMLName));
        return xMLListNewXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean propertyIsEnumerable(Object obj) {
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
        } else {
            if (!(obj instanceof Number)) {
                return ScriptRuntime.toString(obj).equals("0");
            }
            double dDoubleValue = ((Number) obj).doubleValue();
            if (dDoubleValue == 0.0d && 1.0d / dDoubleValue > 0.0d) {
                return true;
            }
        }
        return false;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i2, Scriptable scriptable, Object obj) {
        throw ScriptRuntime.typeError("Assignment to indexed XML is not allowed");
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void putXMLProperty(XMLName xMLName, Object obj) {
        if (isPrototype()) {
            return;
        }
        xMLName.setMyValueOn(this, obj);
    }

    public void remove() {
        this.node.deleteMe();
    }

    public void removeChild(int i2) {
        this.node.removeChild(i2);
    }

    public XML removeNamespace(Namespace namespace) {
        if (!isElement()) {
            return this;
        }
        this.node.removeNamespace(adapt(namespace));
        return this;
    }

    public XML replace(XMLName xMLName, Object obj) {
        putXMLProperty(xMLName, obj);
        return this;
    }

    public void replaceWith(XML xml) {
        if (this.node.parent() != null) {
            this.node.replaceWith(xml.node);
        } else {
            initialize(xml.node);
        }
    }

    public void setAttribute(XMLName xMLName, Object obj) {
        if (!isElement()) {
            throw new IllegalStateException("Can only set attributes on elements.");
        }
        if (xMLName.uri() == null && xMLName.localName().equals("*")) {
            throw ScriptRuntime.typeError("@* assignment not supported.");
        }
        this.node.setAttribute(xMLName.toQname(), ScriptRuntime.toString(obj));
    }

    public XML setChildren(Object obj) {
        if (!isElement()) {
            return this;
        }
        while (this.node.getChildCount() > 0) {
            this.node.removeChild(0);
        }
        this.node.insertChildrenAt(0, getNodesForInsert(obj));
        return this;
    }

    public void setLocalName(String str) {
        if (isText() || isComment()) {
            return;
        }
        this.node.setLocalName(str);
    }

    public void setName(QName qName) {
        if (isText() || isComment()) {
            return;
        }
        if (isProcessingInstruction()) {
            this.node.setLocalName(qName.localName());
        } else {
            this.node.renameNode(qName.getDelegate());
        }
    }

    public void setNamespace(Namespace namespace) {
        if (isText() || isComment() || isProcessingInstruction()) {
            return;
        }
        setName(newQName(namespace.uri(), localName(), namespace.prefix()));
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList text() {
        XMLList xMLListNewXMLList = newXMLList();
        this.node.addMatchingChildren(xMLListNewXMLList, XmlNode.Filter.TEXT);
        return xMLListNewXMLList;
    }

    public Node toDomNode() {
        return this.node.toDomNode();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toSource(int i2) {
        return toXMLString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toString() {
        return ecmaToString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toXMLString() {
        return this.node.ecmaToXMLString(getProcessor());
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object valueOf() {
        return this;
    }

    public XML replace(int i2, Object obj) {
        XMLList xMLListChild = child(i2);
        if (xMLListChild.length() > 0) {
            insertChildAfter(xMLListChild.item(0), obj);
            removeChild(i2);
        }
        return this;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList child(int i2) {
        XMLList xMLListNewXMLList = newXMLList();
        xMLListNewXMLList.setTargets(this, null);
        if (i2 >= 0 && i2 < this.node.getChildCount()) {
            xMLListNewXMLList.addToList(getXmlChild(i2));
        }
        return xMLListNewXMLList;
    }
}
