package cn.wanghaomiao.xpath.model;

import java.util.LinkedList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class JXDocument {
    private org.seimicrawler.xpath.JXDocument jxDoc;

    public JXDocument(Document document) {
        this.jxDoc = org.seimicrawler.xpath.JXDocument.create(document);
    }

    public List<Object> sel(String str) {
        return this.jxDoc.sel(str);
    }

    public List<JXNode> selN(String str) {
        LinkedList linkedList = new LinkedList();
        for (org.seimicrawler.xpath.JXNode jXNode : this.jxDoc.selN(str)) {
            if (jXNode.isString()) {
                linkedList.add(JXNode.t(jXNode.asString()));
            } else {
                linkedList.add(JXNode.e(jXNode.asElement()));
            }
        }
        return linkedList;
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
            return jXNodeSelNOne.isText() ? jXNodeSelNOne.getTextVal() : jXNodeSelNOne.getElement();
        }
        return null;
    }

    public JXDocument(String str) {
        this.jxDoc = org.seimicrawler.xpath.JXDocument.create(str);
    }

    public JXDocument(Elements elements) {
        this.jxDoc = org.seimicrawler.xpath.JXDocument.create(elements);
    }
}
