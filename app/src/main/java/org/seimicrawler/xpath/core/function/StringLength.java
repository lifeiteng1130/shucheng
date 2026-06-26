package org.seimicrawler.xpath.core.function;

import java.util.List;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class StringLength implements Function {
    @Override // org.seimicrawler.xpath.core.Function
    public XValue call(Scope scope, List<XValue> list) {
        return (list == null || list.size() == 0) ? XValue.create(0) : XValue.create(Integer.valueOf(list.get(0).asString().length()));
    }

    @Override // org.seimicrawler.xpath.core.Function
    public String name() {
        return "string-length";
    }
}
