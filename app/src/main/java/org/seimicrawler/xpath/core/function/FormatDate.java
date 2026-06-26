package org.seimicrawler.xpath.core.function;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import k.b.a.a.j.b;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;
import org.seimicrawler.xpath.exception.XpathParserException;

/* JADX INFO: loaded from: classes3.dex */
public class FormatDate implements Function {
    @Override // org.seimicrawler.xpath.core.Function
    public XValue call(Scope scope, List<XValue> list) {
        String strAsString = list.get(0).asString();
        String strAsString2 = list.get(1).asString();
        try {
            return (list.size() <= 2 || list.get(2) == null) ? XValue.create(b.getInstance(strAsString2).parse(strAsString)) : XValue.create(new SimpleDateFormat(strAsString2, Locale.forLanguageTag(list.get(2).asString())).parse(strAsString));
        } catch (ParseException e2) {
            throw new XpathParserException("date format exception!", e2);
        }
    }

    @Override // org.seimicrawler.xpath.core.Function
    public String name() {
        return "format-date";
    }
}
