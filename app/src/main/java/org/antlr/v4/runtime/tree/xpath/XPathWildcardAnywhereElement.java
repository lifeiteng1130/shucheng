package org.antlr.v4.runtime.tree.xpath;

import c.b.a.m.f;
import java.util.ArrayList;
import java.util.Collection;
import k.a.a.a.n0.d;

/* JADX INFO: loaded from: classes3.dex */
public class XPathWildcardAnywhereElement extends XPathElement {
    public XPathWildcardAnywhereElement() {
        super("*");
    }

    @Override // org.antlr.v4.runtime.tree.xpath.XPathElement
    public Collection<d> evaluate(d dVar) {
        return this.invert ? new ArrayList() : f.k2(dVar);
    }
}
