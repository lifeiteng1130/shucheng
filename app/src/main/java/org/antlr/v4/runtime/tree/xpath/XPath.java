package org.antlr.v4.runtime.tree.xpath;

import c.a.a.a.a;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k.a.a.a.c;
import k.a.a.a.d0;
import k.a.a.a.l;
import k.a.a.a.n0.d;
import k.a.a.a.t;
import k.a.a.a.w;
import k.a.a.a.y;

/* JADX INFO: loaded from: classes3.dex */
public class XPath {
    public static final String NOT = "!";
    public static final String WILDCARD = "*";
    public XPathElement[] elements;
    public w parser;
    public String path;

    public XPath(w wVar, String str) {
        this.parser = wVar;
        this.path = str;
        this.elements = split(str);
    }

    public static Collection<d> findAll(d dVar, String str, w wVar) {
        return new XPath(wVar, str).evaluate(dVar);
    }

    public Collection<d> evaluate(d dVar) {
        y yVar = new y();
        yVar.children = Collections.singletonList(dVar);
        Set<d> setSingleton = Collections.singleton(yVar);
        int i2 = 0;
        while (i2 < this.elements.length) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (d dVar2 : setSingleton) {
                if (dVar2.getChildCount() > 0) {
                    linkedHashSet.addAll(this.elements[i2].evaluate(dVar2));
                }
            }
            i2++;
            setSingleton = linkedHashSet;
        }
        return setSingleton;
    }

    public XPathElement getXPathElement(d0 d0Var, boolean z) {
        if (d0Var.getType() == -1) {
            throw new IllegalArgumentException("Missing path element at end of path");
        }
        String text = d0Var.getText();
        int tokenType = this.parser.getTokenType(text);
        int ruleIndex = this.parser.getRuleIndex(text);
        int type = d0Var.getType();
        if (type != 1) {
            if (type == 5) {
                return z ? new XPathWildcardAnywhereElement() : new XPathWildcardElement();
            }
            if (type != 8) {
                if (ruleIndex != -1) {
                    return z ? new XPathRuleAnywhereElement(text, ruleIndex) : new XPathRuleElement(text, ruleIndex);
                }
                StringBuilder sbT = a.t(text, " at index ");
                sbT.append(d0Var.getStartIndex());
                sbT.append(" isn't a valid rule name");
                throw new IllegalArgumentException(sbT.toString());
            }
        }
        if (tokenType != 0) {
            return z ? new XPathTokenAnywhereElement(text, tokenType) : new XPathTokenElement(text, tokenType);
        }
        StringBuilder sbT2 = a.t(text, " at index ");
        sbT2.append(d0Var.getStartIndex());
        sbT2.append(" isn't a valid token name");
        throw new IllegalArgumentException(sbT2.toString());
    }

    public XPathElement[] split(String str) {
        try {
            XPathLexer xPathLexer = new XPathLexer(new c(new StringReader(str))) { // from class: org.antlr.v4.runtime.tree.xpath.XPath.1
                @Override // k.a.a.a.s
                public void recover(t tVar) {
                    throw tVar;
                }
            };
            xPathLexer.removeErrorListeners();
            xPathLexer.addErrorListener(new XPathLexerErrorListener());
            l lVar = new l(xPathLexer);
            try {
                lVar.k();
                do {
                } while (lVar.j(1000) >= 1000);
                List<d0> list = lVar.f8356b;
                ArrayList arrayList = new ArrayList();
                int size = list.size();
                int i2 = 0;
                while (i2 < size) {
                    d0 d0Var = list.get(i2);
                    int type = d0Var.getType();
                    if (type == -1) {
                        break;
                    }
                    if (type != 1 && type != 2) {
                        if (type == 3 || type == 4) {
                            boolean z = d0Var.getType() == 3;
                            int i3 = i2 + 1;
                            d0 d0Var2 = list.get(i3);
                            boolean z2 = d0Var2.getType() == 6;
                            if (z2) {
                                i3++;
                                d0Var2 = list.get(i3);
                            }
                            XPathElement xPathElement = getXPathElement(d0Var2, z);
                            xPathElement.invert = z2;
                            arrayList.add(xPathElement);
                            i2 = i3 + 1;
                        } else if (type != 5) {
                            throw new IllegalArgumentException("Unknowth path element " + d0Var);
                        }
                    }
                    arrayList.add(getXPathElement(d0Var, false));
                    i2++;
                }
                return (XPathElement[]) arrayList.toArray(new XPathElement[0]);
            } catch (t e2) {
                throw new IllegalArgumentException("Invalid tokens or characters at index " + xPathLexer.getCharPositionInLine() + " in path '" + str + "'", e2);
            }
        } catch (IOException e3) {
            throw new IllegalArgumentException(a.i("Could not read path: ", str), e3);
        }
    }
}
