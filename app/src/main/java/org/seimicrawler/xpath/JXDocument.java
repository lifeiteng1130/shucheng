package org.seimicrawler.xpath;

import c.a.a.a.a;
import c.b.a.m.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import k.a.a.a.l;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.antlr.XpathLexer;
import org.seimicrawler.xpath.antlr.XpathParser;
import org.seimicrawler.xpath.core.XValue;
import org.seimicrawler.xpath.core.XpathProcessor;
import org.seimicrawler.xpath.exception.DoFailOnErrorHandler;
import org.seimicrawler.xpath.exception.XpathParserException;
import org.seimicrawler.xpath.exception.XpathSyntaxErrorException;

/* JADX INFO: loaded from: classes3.dex */
public class JXDocument {
    private Elements elements;

    public JXDocument(Elements elements) {
        this.elements = elements;
    }

    public static JXDocument create(Document document) {
        return new JXDocument(document.children());
    }

    public static JXDocument createByUrl(String str) {
        try {
            return new JXDocument(Jsoup.connect(str).get().children());
        } catch (Exception e2) {
            throw new XpathParserException("url资源获取失败", e2);
        }
    }

    public List<Object> sel(String str) {
        LinkedList linkedList = new LinkedList();
        for (JXNode jXNode : selN(str)) {
            if (jXNode.isElement()) {
                linkedList.add(jXNode.asElement());
            } else {
                linkedList.add(jXNode.toString());
            }
        }
        return linkedList;
    }

    public List<JXNode> selN(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            XpathParser xpathParser = new XpathParser(new l(new XpathLexer(f.J1(str))));
            xpathParser.setErrorHandler(new DoFailOnErrorHandler());
            XValue xValueVisit = new XpathProcessor(this.elements).visit(xpathParser.main());
            if (xValueVisit.isElements()) {
                Iterator<Element> it = xValueVisit.asElements().iterator();
                while (it.hasNext()) {
                    linkedList.add(JXNode.create(it.next()));
                }
                return linkedList;
            }
            if (xValueVisit.isList()) {
                Iterator<String> it2 = xValueVisit.asList().iterator();
                while (it2.hasNext()) {
                    linkedList.add(JXNode.create(it2.next()));
                }
                return linkedList;
            }
            if (xValueVisit.isString()) {
                linkedList.add(JXNode.create(xValueVisit.asString()));
                return linkedList;
            }
            if (xValueVisit.isNumber()) {
                linkedList.add(JXNode.create(xValueVisit.asDouble()));
                return linkedList;
            }
            if (xValueVisit.isBoolean()) {
                linkedList.add(JXNode.create(xValueVisit.asBoolean()));
                return linkedList;
            }
            if (xValueVisit.isDate()) {
                linkedList.add(JXNode.create(xValueVisit.asDate()));
                return linkedList;
            }
            linkedList.add(JXNode.create(xValueVisit.asString()));
            return linkedList;
        } catch (Exception e2) {
            StringBuilder sbR = a.r("Please check the syntax of your xpath expr or commit a ");
            sbR.append(k.b.a.a.h.a.a(e2));
            throw new XpathSyntaxErrorException(sbR.toString(), e2);
        }
    }

    public JXNode selNOne(String str) {
        List<JXNode> listSelN = selN(str);
        if (listSelN == null || listSelN.size() <= 0) {
            return null;
        }
        return listSelN.get(0);
    }

    public Object selOne(String str) {
        JXNode jXNodeSelNOne = selNOne(str);
        if (jXNodeSelNOne != null) {
            return jXNodeSelNOne.isElement() ? jXNodeSelNOne.asElement() : jXNodeSelNOne.toString();
        }
        return null;
    }

    public static JXDocument create(Elements elements) {
        return new JXDocument(elements);
    }

    public static JXDocument create(String str) {
        return new JXDocument(Jsoup.parse(str).children());
    }
}
