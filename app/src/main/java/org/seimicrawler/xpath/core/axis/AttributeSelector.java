package org.seimicrawler.xpath.core.axis;

import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.AxisSelector;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class AttributeSelector implements AxisSelector {
    @Override // org.seimicrawler.xpath.core.AxisSelector
    public XValue apply(Elements elements) {
        return XValue.create(null).attr();
    }

    @Override // org.seimicrawler.xpath.core.AxisSelector
    public String name() {
        return "attribute";
    }
}
