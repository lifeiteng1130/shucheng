package org.seimicrawler.xpath.core.axis;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.AxisSelector;
import org.seimicrawler.xpath.core.XValue;
import org.seimicrawler.xpath.util.CommonUtil;

/* JADX INFO: loaded from: classes3.dex */
public class FollowingSelector implements AxisSelector {
    @Override // org.seimicrawler.xpath.core.AxisSelector
    public XValue apply(Elements elements) {
        LinkedList linkedList = new LinkedList();
        for (Element element : elements) {
            Iterator<Element> it = element.parents().iterator();
            while (it.hasNext()) {
                Elements elementsFollowingSibling = CommonUtil.followingSibling(it.next());
                if (elementsFollowingSibling != null) {
                    Iterator<Element> it2 = elementsFollowingSibling.iterator();
                    while (it2.hasNext()) {
                        linkedList.addAll(it2.next().getAllElements());
                    }
                }
            }
            Elements elementsFollowingSibling2 = CommonUtil.followingSibling(element);
            if (elementsFollowingSibling2 != null) {
                Iterator<Element> it3 = elementsFollowingSibling2.iterator();
                while (it3.hasNext()) {
                    linkedList.addAll(it3.next().getAllElements());
                }
            }
        }
        return XValue.create(new Elements((List<Element>) linkedList));
    }

    @Override // org.seimicrawler.xpath.core.AxisSelector
    public String name() {
        return "following";
    }
}
