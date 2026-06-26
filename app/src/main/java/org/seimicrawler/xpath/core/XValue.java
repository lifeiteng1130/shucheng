package org.seimicrawler.xpath.core;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import k.b.a.a.f;
import k.b.a.a.g.b;
import k.b.a.a.j.a;
import org.jsoup.select.Elements;
import org.mozilla.javascript.ES6Iterator;
import org.seimicrawler.xpath.exception.XpathParserException;

/* JADX INFO: loaded from: classes3.dex */
public class XValue implements Comparable<XValue> {
    private boolean isAttr = false;
    private boolean isExprStr = false;
    private Object value;

    public XValue(Object obj) {
        this.value = obj;
    }

    public static XValue create(Object obj) {
        return new XValue(obj);
    }

    public Boolean asBoolean() {
        Object obj = this.value;
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        return Boolean.valueOf((obj == null || f.d(asString())) ? false : true);
    }

    public Date asDate() {
        Object obj = this.value;
        if (obj instanceof String) {
            try {
                return a.f8570c.parse((String) obj);
            } catch (ParseException unused) {
                StringBuilder sbR = c.a.a.a.a.r("cast to date fail. vale = ");
                sbR.append(this.value);
                throw new XpathParserException(sbR.toString());
            }
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        StringBuilder sbR2 = c.a.a.a.a.r("cast to date fail. vale = ");
        sbR2.append(this.value);
        throw new XpathParserException(sbR2.toString());
    }

    public Double asDouble() {
        Object obj = this.value;
        if (obj instanceof String) {
            return Double.valueOf(new BigDecimal((String) this.value).doubleValue());
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        StringBuilder sbR = c.a.a.a.a.r("cast to number fail. vale = ");
        sbR.append(this.value);
        throw new XpathParserException(sbR.toString());
    }

    public Elements asElements() {
        return (Elements) this.value;
    }

    public List<String> asList() {
        return (List) this.value;
    }

    public Long asLong() {
        Object obj = this.value;
        if (obj instanceof String) {
            return Long.valueOf(new BigDecimal((String) this.value).setScale(0, 4).longValue());
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        StringBuilder sbR = c.a.a.a.a.r("cast to number fail. vale = ");
        sbR.append(this.value);
        throw new XpathParserException(sbR.toString());
    }

    public String asString() {
        Object obj = this.value;
        return obj instanceof List ? f.g((List) obj, ",") : String.valueOf(obj).trim();
    }

    public XValue attr() {
        this.isAttr = true;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.value, ((XValue) obj).value);
    }

    public XValue exprStr() {
        this.isExprStr = true;
        this.value = f.h(f.h(f.i(f.i(String.valueOf(this.value), "'"), "\""), "'"), "\"");
        return this;
    }

    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    public boolean isAttr() {
        return this.isAttr;
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isDate() {
        return this.value instanceof Date;
    }

    public boolean isElements() {
        return this.value instanceof Elements;
    }

    public boolean isExprStr() {
        return this.isExprStr;
    }

    public boolean isList() {
        return this.value instanceof List;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    public String toString() {
        b bVar = new b(this);
        bVar.f8548d.append(bVar.f8546b, ES6Iterator.VALUE_PROPERTY, this.value, (Boolean) null);
        bVar.f8548d.append(bVar.f8546b, "isAttr", this.isAttr);
        bVar.f8548d.append(bVar.f8546b, "isExprStr", this.isExprStr);
        return bVar.toString();
    }

    public Class valType() {
        Object obj = this.value;
        return obj == null ? Object.class : obj.getClass();
    }

    @Override // java.lang.Comparable
    public int compareTo(XValue xValue) {
        if (equals(xValue)) {
            return 0;
        }
        if (xValue == null || xValue.value == null) {
            return 1;
        }
        if (this.value == null) {
            return -1;
        }
        if (isString()) {
            return asString().compareTo(xValue.asString());
        }
        if (isNumber()) {
            return asDouble().compareTo(xValue.asDouble());
        }
        StringBuilder sbR = c.a.a.a.a.r("Unsupported comparable XValue = ");
        sbR.append(toString());
        throw new XpathParserException(sbR.toString());
    }
}
