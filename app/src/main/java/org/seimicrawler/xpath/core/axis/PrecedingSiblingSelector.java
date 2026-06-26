package org.seimicrawler.xpath.core.axis;

import java.util.Iterator;
import java.util.LinkedList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.AxisSelector;
import org.seimicrawler.xpath.core.XValue;
import org.seimicrawler.xpath.util.CommonUtil;

/* JADX INFO: loaded from: classes3.dex */
public class PrecedingSiblingSelector implements AxisSelector {
    @Override // org.seimicrawler.xpath.core.AxisSelector
    public XValue apply(Elements elements) {
        LinkedList linkedList = new LinkedList();
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            Elements elementsPrecedingSibling = CommonUtil.precedingSibling(it.next());
            if (elementsPrecedingSibling != null) {
                linkedList.addAll(elementsPrecedingSibling);
            }
        }
        Elements elements2 = new Elements();
        elements2.addAll(linkedList);
        return XValue.create(elements2);
    }

    @Override // org.seimicrawler.xpath.core.AxisSelector
    public String name() {
        return "preceding-sibling";
    }
}
