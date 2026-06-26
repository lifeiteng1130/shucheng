package org.seimicrawler.xpath;

import java.util.Date;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: loaded from: classes3.dex */
public class JXNode {
    private Object value;

    public JXNode(Object obj) {
        this.value = obj;
    }

    public static JXNode create(Object obj) {
        return new JXNode(obj);
    }

    public Boolean asBoolean() {
        return (Boolean) this.value;
    }

    public Date asDate() {
        return (Date) this.value;
    }

    public Double asDouble() {
        return (Double) this.value;
    }

    public Element asElement() {
        return (Element) this.value;
    }

    public String asString() {
        return (String) this.value;
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isDate() {
        return this.value instanceof Date;
    }

    public boolean isElement() {
        return this.value instanceof Element;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    public List<JXNode> sel(String str) {
        if (isElement()) {
            return new JXDocument(new Elements(asElement())).selN(str);
        }
        return null;
    }

    public JXNode selOne(String str) {
        List<JXNode> listSel = sel(str);
        if (listSel == null || listSel.size() <= 0) {
            return null;
        }
        return listSel.get(0);
    }

    public String toString() {
        return isElement() ? asElement().toString() : String.valueOf(this.value);
    }

    public Object value() {
        return isElement() ? asElement() : isBoolean() ? asBoolean() : isNumber() ? asDouble() : isDate() ? asDate() : asString();
    }
}
