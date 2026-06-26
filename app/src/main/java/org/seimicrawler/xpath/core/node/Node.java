package org.seimicrawler.xpath.core.node;

import k.b.a.a.f;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.NodeTest;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class Node implements NodeTest {
    @Override // org.seimicrawler.xpath.core.NodeTest
    public XValue call(Scope scope) {
        Elements elements = new Elements();
        for (Element element : scope.context()) {
            elements.addAll(element.children());
            String strOwnText = element.ownText();
            if (f.f(strOwnText)) {
                Element element2 = new Element("");
                element2.appendText(strOwnText);
                elements.add(element2);
            }
        }
        return XValue.create(elements);
    }

    @Override // org.seimicrawler.xpath.core.NodeTest
    public String name() {
        return "node";
    }
}
