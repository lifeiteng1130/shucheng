package org.seimicrawler.xpath.core.axis;

import java.util.LinkedList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.AxisSelector;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class FollowingSiblingOneSelector implements AxisSelector {
    @Override // org.seimicrawler.xpath.core.AxisSelector
    public XValue apply(Elements elements) {
        LinkedList linkedList = new LinkedList();
        for (Element element : elements) {
            if (element.nextElementSibling() != null) {
                linkedList.add(element.nextElementSibling());
            }
        }
        Elements elements2 = new Elements();
        elements2.addAll(linkedList);
        return XValue.create(elements2);
    }

    @Override // org.seimicrawler.xpath.core.AxisSelector
    public String name() {
        return "following-sibling-one";
    }
}
