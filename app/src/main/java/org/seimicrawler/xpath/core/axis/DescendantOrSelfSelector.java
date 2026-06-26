package org.seimicrawler.xpath.core.axis;

import java.util.HashSet;
import java.util.Iterator;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.AxisSelector;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class DescendantOrSelfSelector implements AxisSelector {
    @Override // org.seimicrawler.xpath.core.AxisSelector
    public XValue apply(Elements elements) {
        HashSet hashSet = new HashSet();
        Elements elements2 = new Elements();
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().getAllElements());
        }
        elements2.addAll(hashSet);
        return XValue.create(elements2);
    }

    @Override // org.seimicrawler.xpath.core.AxisSelector
    public String name() {
        return "descendant-or-self";
    }
}
