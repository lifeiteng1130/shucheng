package org.seimicrawler.xpath.core.function;

import java.util.List;
import k.b.a.a.f;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class SubStringAfter implements Function {
    @Override // org.seimicrawler.xpath.core.Function
    public XValue call(Scope scope, List<XValue> list) {
        int iIndexOf;
        String strAsString = list.get(0).asString();
        String strAsString2 = list.get(1).asString();
        if (!f.e(strAsString)) {
            strAsString = (strAsString2 == null || (iIndexOf = strAsString.indexOf(strAsString2)) == -1) ? "" : strAsString.substring(strAsString2.length() + iIndexOf);
        }
        return XValue.create(strAsString);
    }

    @Override // org.seimicrawler.xpath.core.Function
    public String name() {
        return "substring-after";
    }
}
