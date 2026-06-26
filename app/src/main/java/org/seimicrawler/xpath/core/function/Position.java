package org.seimicrawler.xpath.core.function;

import java.util.List;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;
import org.seimicrawler.xpath.util.CommonUtil;

/* JADX INFO: loaded from: classes3.dex */
public class Position implements Function {
    @Override // org.seimicrawler.xpath.core.Function
    public XValue call(Scope scope, List<XValue> list) {
        return XValue.create(Integer.valueOf(CommonUtil.getElIndexInSameTags(scope.singleEl(), scope.getParent())));
    }

    @Override // org.seimicrawler.xpath.core.Function
    public String name() {
        return "position";
    }
}
