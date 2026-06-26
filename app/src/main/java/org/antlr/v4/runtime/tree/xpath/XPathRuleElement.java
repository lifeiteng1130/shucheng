package org.antlr.v4.runtime.tree.xpath;

import c.b.a.m.f;
import java.util.ArrayList;
import java.util.Collection;
import k.a.a.a.n0.d;
import k.a.a.a.n0.j;
import k.a.a.a.y;

/* JADX INFO: loaded from: classes3.dex */
public class XPathRuleElement extends XPathElement {
    public int ruleIndex;

    public XPathRuleElement(String str, int i2) {
        super(str);
        this.ruleIndex = i2;
    }

    @Override // org.antlr.v4.runtime.tree.xpath.XPathElement
    public Collection<d> evaluate(d dVar) {
        ArrayList arrayList = new ArrayList();
        for (j jVar : (ArrayList) f.V1(dVar)) {
            if (jVar instanceof y) {
                y yVar = (y) jVar;
                if ((yVar.getRuleIndex() == this.ruleIndex && !this.invert) || (yVar.getRuleIndex() != this.ruleIndex && this.invert)) {
                    arrayList.add(yVar);
                }
            }
        }
        return arrayList;
    }
}
