package org.seimicrawler.xpath.core.function;

import java.util.List;
import k.b.a.a.f;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class SubStringEx implements Function {
    @Override // org.seimicrawler.xpath.core.Function
    public XValue call(Scope scope, List<XValue> list) {
        String strAsString = list.get(0).asString();
        int iIntValue = list.get(1).asLong().intValue();
        return list.get(2) != null ? XValue.create(f.l(strAsString, iIntValue, list.get(2).asLong().intValue())) : XValue.create(f.k(strAsString, iIntValue));
    }

    @Override // org.seimicrawler.xpath.core.Function
    public String name() {
        return "substring-ex";
    }
}
