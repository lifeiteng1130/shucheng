package org.seimicrawler.xpath.core.node;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.b.a.a.f;
import org.seimicrawler.xpath.core.NodeTest;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;
import org.seimicrawler.xpath.util.Scanner;

/* JADX INFO: loaded from: classes3.dex */
public class Num implements NodeTest {
    private static Pattern numExt = Pattern.compile("\\d*\\.?\\d+");

    @Override // org.seimicrawler.xpath.core.NodeTest
    public XValue call(Scope scope) {
        Matcher matcher = numExt.matcher(f.g(Scanner.findNodeTestByName("allText").call(scope).asList(), ""));
        return matcher.find() ? XValue.create(Double.valueOf(new BigDecimal(matcher.group()).doubleValue())) : XValue.create(null);
    }

    @Override // org.seimicrawler.xpath.core.NodeTest
    public String name() {
        return "num";
    }
}
