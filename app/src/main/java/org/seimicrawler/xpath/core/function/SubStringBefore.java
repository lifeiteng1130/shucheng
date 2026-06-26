package org.seimicrawler.xpath.core.function;

import java.util.List;
import k.b.a.a.f;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;

/* JADX INFO: loaded from: classes3.dex */
public class SubStringBefore implements Function {
    @Override // org.seimicrawler.xpath.core.Function
    public XValue call(Scope scope, List<XValue> list) {
        String strAsString = list.get(0).asString();
        String strAsString2 = list.get(1).asString();
        if (!f.e(strAsString) && strAsString2 != null) {
            if (strAsString2.isEmpty()) {
                strAsString = "";
            } else {
                int iIndexOf = strAsString.indexOf(strAsString2);
                if (iIndexOf != -1) {
                    strAsString = strAsString.substring(0, iIndexOf);
                }
            }
        }
        return XValue.create(strAsString);
    }

    @Override // org.seimicrawler.xpath.core.Function
    public String name() {
        return "substring-before";
    }
}
