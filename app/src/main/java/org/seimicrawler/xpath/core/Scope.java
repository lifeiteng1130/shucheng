package org.seimicrawler.xpath.core;

import c.a.a.a.a;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.exception.XpathParserException;

/* JADX INFO: loaded from: classes3.dex */
public class Scope {
    private Elements context;
    private boolean isRecursion = false;
    private Scope parent;

    private Scope(Elements elements) {
        Elements elements2 = new Elements();
        this.context = elements2;
        elements2.addAll(elements);
    }

    public static Scope create(Elements elements) {
        return new Scope(elements);
    }

    public Elements context() {
        return this.context;
    }

    public Scope getParent() {
        return this.parent;
    }

    public boolean isRecursion() {
        return this.isRecursion;
    }

    public void notRecursion() {
        this.isRecursion = false;
    }

    public void recursion() {
        this.isRecursion = true;
    }

    public void setContext(Elements elements) {
        this.context = elements;
    }

    public Scope setParent(Scope scope) {
        this.parent = scope;
        return this;
    }

    public Element singleEl() {
        if (this.context.size() == 1) {
            return this.context.first();
        }
        StringBuilder sbR = a.r("current context is more than one el,total = ");
        sbR.append(this.context.size());
        throw new XpathParserException(sbR.toString());
    }

    public static Scope create(Element element) {
        return new Scope(element);
    }

    public static Scope create(Scope scope) {
        return new Scope(scope.context()).setParent(scope);
    }

    private Scope(Element element) {
        Elements elements = new Elements();
        this.context = elements;
        elements.add(element);
    }
}
