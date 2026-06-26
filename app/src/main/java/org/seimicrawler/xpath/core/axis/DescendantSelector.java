package org.seimicrawler.xpath.core.axis;

import java.util.HashSet;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.AxisSelector;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class DescendantSelector implements AxisSelector {
    @Override // org.seimicrawler.xpath.core.AxisSelector
    public XValue apply(Elements elements) {
        HashSet hashSet = new HashSet();
        Elements elements2 = new Elements();
        for (Element element : elements) {
            Elements allElements = element.getAllElements();
            allElements.remove(element);
            hashSet.addAll(allElements);
        }
        elements2.addAll(hashSet);
        return XValue.create(elements2);
    }

    @Override // org.seimicrawler.xpath.core.AxisSelector
    public String name() {
        return "descendant";
    }
}
