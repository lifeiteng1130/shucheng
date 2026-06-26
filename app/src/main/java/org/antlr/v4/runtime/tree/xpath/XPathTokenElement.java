package org.antlr.v4.runtime.tree.xpath;

import c.b.a.m.f;
import java.util.ArrayList;
import java.util.Collection;
import k.a.a.a.n0.d;
import k.a.a.a.n0.h;
import k.a.a.a.n0.j;

/* JADX INFO: loaded from: classes3.dex */
public class XPathTokenElement extends XPathElement {
    public int tokenType;

    public XPathTokenElement(String str, int i2) {
        super(str);
        this.tokenType = i2;
    }

    @Override // org.antlr.v4.runtime.tree.xpath.XPathElement
    public Collection<d> evaluate(d dVar) {
        ArrayList arrayList = new ArrayList();
        for (j jVar : (ArrayList) f.V1(dVar)) {
            if (jVar instanceof h) {
                h hVar = (h) jVar;
                if ((hVar.a().getType() == this.tokenType && !this.invert) || (hVar.a().getType() != this.tokenType && this.invert)) {
                    arrayList.add(hVar);
                }
            }
        }
        return arrayList;
    }
}
