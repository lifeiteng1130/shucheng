package org.seimicrawler.xpath.core.axis;

import java.util.LinkedList;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.AxisSelector;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class AncestorOrSelfSelector implements AxisSelector {
    @Override // org.seimicrawler.xpath.core.AxisSelector
    public XValue apply(Elements elements) {
        LinkedList linkedList = new LinkedList();
        for (Element element : elements) {
            linkedList.addAll(element.parents());
            linkedList.add(element);
        }
        return XValue.create(new Elements((List<Element>) linkedList));
    }

    @Override // org.seimicrawler.xpath.core.AxisSelector
    public String name() {
        return "ancestor-or-self";
    }
}
