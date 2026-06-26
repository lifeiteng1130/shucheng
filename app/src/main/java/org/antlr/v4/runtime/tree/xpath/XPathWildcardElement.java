package org.antlr.v4.runtime.tree.xpath;

import c.b.a.m.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import k.a.a.a.n0.d;
import k.a.a.a.n0.j;

/* JADX INFO: loaded from: classes3.dex */
public class XPathWildcardElement extends XPathElement {
    public XPathWildcardElement() {
        super("*");
    }

    @Override // org.antlr.v4.runtime.tree.xpath.XPathElement
    public Collection<d> evaluate(d dVar) {
        if (this.invert) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) f.V1(dVar)).iterator();
        while (it.hasNext()) {
            arrayList.add((d) ((j) it.next()));
        }
        return arrayList;
    }
}
