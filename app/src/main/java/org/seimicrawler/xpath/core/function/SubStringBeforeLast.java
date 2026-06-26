package org.seimicrawler.xpath.core.function;

import java.util.List;
import k.b.a.a.f;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class SubStringBeforeLast implements Function {
    @Override // org.seimicrawler.xpath.core.Function
    public XValue call(Scope scope, List<XValue> list) {
        int iLastIndexOf;
        String strAsString = list.get(0).asString();
        String strAsString2 = list.get(1).asString();
        if (!f.e(strAsString) && !f.e(strAsString2) && (iLastIndexOf = strAsString.lastIndexOf(strAsString2)) != -1) {
            strAsString = strAsString.substring(0, iLastIndexOf);
        }
        return XValue.create(strAsString);
    }

    @Override // org.seimicrawler.xpath.core.Function
    public String name() {
        return "substring-before-last";
    }
}
