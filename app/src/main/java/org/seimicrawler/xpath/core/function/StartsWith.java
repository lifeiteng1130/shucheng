package org.seimicrawler.xpath.core.function;

import java.util.List;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class StartsWith implements Function {
    @Override // org.seimicrawler.xpath.core.Function
    public XValue call(Scope scope, List<XValue> list) {
        return XValue.create(Boolean.valueOf(list.get(0).asString().startsWith(list.get(1).asString())));
    }

    @Override // org.seimicrawler.xpath.core.Function
    public String name() {
        return "starts-with";
    }
}
