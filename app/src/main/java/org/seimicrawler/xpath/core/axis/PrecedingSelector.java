package org.seimicrawler.xpath.core.axis;

import java.util.Iterator;
import java.util.LinkedList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.AxisSelector;
import org.seimicrawler.xpath.core.XValue;
import org.seimicrawler.xpath.util.CommonUtil;

/* JADX INFO: loaded from: classes3.dex */
public class PrecedingSelector implements AxisSelector {
    @Override // org.seimicrawler.xpath.core.AxisSelector
    public XValue apply(Elements elements) {
        Elements elements2 = new Elements();
        LinkedList linkedList = new LinkedList();
        for (Element element : elements) {
            Iterator<Element> it = element.parents().iterator();
            while (it.hasNext()) {
                Elements elementsPrecedingSibling = CommonUtil.precedingSibling(it.next());
                if (elementsPrecedingSibling != null) {
                    linkedList.addAll(elementsPrecedingSibling);
                }
            }
            Elements elementsPrecedingSibling2 = CommonUtil.precedingSibling(element);
            if (elementsPrecedingSibling2 != null) {
                linkedList.addAll(elementsPrecedingSibling2);
            }
        }
        elements2.addAll(linkedList);
        return XValue.create(elements2);
    }

    @Override // org.seimicrawler.xpath.core.AxisSelector
    public String name() {
        return "preceding";
    }
}
