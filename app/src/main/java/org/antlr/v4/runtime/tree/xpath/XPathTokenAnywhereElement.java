package org.antlr.v4.runtime.tree.xpath;

import c.b.a.m.f;
import java.util.ArrayList;
import java.util.Collection;
import k.a.a.a.n0.d;

/* JADX INFO: loaded from: classes3.dex */
public class XPathTokenAnywhereElement extends XPathElement {
    public int tokenType;

    public XPathTokenAnywhereElement(String str, int i2) {
        super(str);
        this.tokenType = i2;
    }

    @Override // org.antlr.v4.runtime.tree.xpath.XPathElement
    public Collection<d> evaluate(d dVar) {
        int i2 = this.tokenType;
        ArrayList arrayList = new ArrayList();
        f.d(dVar, i2, true, arrayList);
        return arrayList;
    }
}
