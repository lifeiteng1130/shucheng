package org.seimicrawler.xpath.core.function;

import java.util.List;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;
import org.seimicrawler.xpath.exception.XpathParserException;

/* JADX INFO: loaded from: classes3.dex */
public class Not implements Function {
    @Override // org.seimicrawler.xpath.core.Function
    public XValue call(Scope scope, List<XValue> list) {
        if (list.size() == 1) {
            return XValue.create(Boolean.valueOf(!list.get(0).asBoolean().booleanValue()));
        }
        throw new XpathParserException("error param in not(bool) function.Please check.");
    }

    @Override // org.seimicrawler.xpath.core.Function
    public String name() {
        return "not";
    }
}
