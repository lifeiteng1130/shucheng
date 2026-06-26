package org.antlr.v4.runtime.tree.xpath;

import c.a.a.a.a;
import java.util.Collection;
import k.a.a.a.n0.d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class XPathElement {
    public boolean invert;
    public String nodeName;

    public XPathElement(String str) {
        this.nodeName = str;
    }

    public abstract Collection<d> evaluate(d dVar);

    public String toString() {
        String str = this.invert ? XPath.NOT : "";
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append(str);
        return a.p(sb, this.nodeName, "]");
    }
}
