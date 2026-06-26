package org.seimicrawler.xpath.core.node;

import java.util.Iterator;
import java.util.LinkedList;
import org.jsoup.nodes.Element;
import org.seimicrawler.xpath.core.NodeTest;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class Html implements NodeTest {
    @Override // org.seimicrawler.xpath.core.NodeTest
    public XValue call(Scope scope) {
        LinkedList linkedList = new LinkedList();
        Iterator<Element> it = scope.context().iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().html());
        }
        return XValue.create(linkedList);
    }

    @Override // org.seimicrawler.xpath.core.NodeTest
    public String name() {
        return "html";
    }
}
