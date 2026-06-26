package org.seimicrawler.xpath.core.axis;

import java.util.Iterator;
import java.util.LinkedList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.AxisSelector;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class ParentSelector implements AxisSelector {
    @Override // org.seimicrawler.xpath.core.AxisSelector
    public XValue apply(Elements elements) {
        LinkedList linkedList = new LinkedList();
        Elements elements2 = new Elements();
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().parent());
        }
        elements2.addAll(linkedList);
        return XValue.create(elements2);
    }

    @Override // org.seimicrawler.xpath.core.AxisSelector
    public String name() {
        return "parent";
    }
}
