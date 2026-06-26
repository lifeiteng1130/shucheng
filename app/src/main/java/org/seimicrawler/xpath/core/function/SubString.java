package org.seimicrawler.xpath.core.function;

import java.util.List;
import k.b.a.a.f;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class SubString implements Function {
    @Override // org.seimicrawler.xpath.core.Function
    public XValue call(Scope scope, List<XValue> list) {
        String strAsString = list.get(0).asString();
        int iMax = Math.max(list.get(1).asLong().intValue() - 1, 0);
        return list.get(2) != null ? XValue.create(f.l(strAsString, iMax, Math.max(Math.min(list.get(2).asLong().intValue() + iMax, strAsString.length()), 0))) : XValue.create(f.k(strAsString, iMax));
    }

    @Override // org.seimicrawler.xpath.core.Function
    public String name() {
        return "substring";
    }
}
