package org.seimicrawler.xpath.core.node;

import java.util.LinkedList;
import org.jsoup.nodes.Element;
import org.seimicrawler.xpath.core.NodeTest;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class AllText implements NodeTest {
    @Override // org.seimicrawler.xpath.core.NodeTest
    public XValue call(Scope scope) {
        LinkedList linkedList = new LinkedList();
        for (Element element : scope.context()) {
            if ("script".equals(element.nodeName())) {
                linkedList.add(element.data());
            } else {
                linkedList.add(element.text());
            }
        }
        return XValue.create(linkedList);
    }

    @Override // org.seimicrawler.xpath.core.NodeTest
    public String name() {
        return "allText";
    }
}
