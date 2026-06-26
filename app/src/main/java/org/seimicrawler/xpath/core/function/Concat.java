package org.seimicrawler.xpath.core.function;

import java.util.Iterator;
import java.util.List;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class Concat implements Function {
    @Override // org.seimicrawler.xpath.core.Function
    public XValue call(Scope scope, List<XValue> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<XValue> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().asString());
        }
        return XValue.create(sb.toString());
    }

    @Override // org.seimicrawler.xpath.core.Function
    public String name() {
        return "concat";
    }
}
