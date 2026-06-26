package io.legado.app.model.analyzeRule;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import f.c0.c.f;
import f.c0.c.j;
import f.h0.k;
import f.x.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.JXNode;

/* JADX INFO: compiled from: AnalyzeByJSoup.kt */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0016\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010!\u001a\u00020\u0001¢\u0006\u0004\b\"\u0010#J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u001f\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u000f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001d\u0010\u0012R\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeByJSoup;", "", "Lorg/jsoup/nodes/Element;", "temp", "", "rule", "Lorg/jsoup/select/Elements;", "getElements", "(Lorg/jsoup/nodes/Element;Ljava/lang/String;)Lorg/jsoup/select/Elements;", "elements", "", "rules", "filterElements", "(Lorg/jsoup/select/Elements;[Ljava/lang/String;)Lorg/jsoup/select/Elements;", "getElementsSingle", "ruleStr", "", "getResultList", "(Ljava/lang/String;)Ljava/util/List;", "lastRule", "getResultLast", "(Lorg/jsoup/select/Elements;Ljava/lang/String;)Ljava/util/List;", "getElements$app_adsRelease", "(Ljava/lang/String;)Lorg/jsoup/select/Elements;", "getString$app_adsRelease", "(Ljava/lang/String;)Ljava/lang/String;", "getString", "getString0$app_adsRelease", "getString0", "getStringList$app_adsRelease", "getStringList", "element", "Lorg/jsoup/nodes/Element;", "doc", "<init>", "(Ljava/lang/Object;)V", "Companion", "SourceRule", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AnalyzeByJSoup {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String[] validKeys = {"class", "id", "tag", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "children"};

    @NotNull
    private Element element;

    /* JADX INFO: compiled from: AnalyzeByJSoup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeByJSoup$Companion;", "", "doc", "Lorg/jsoup/nodes/Element;", "parse", "(Ljava/lang/Object;)Lorg/jsoup/nodes/Element;", "", "", "validKeys", "[Ljava/lang/String;", "getValidKeys", "()[Ljava/lang/String;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        @NotNull
        public final String[] getValidKeys() {
            return AnalyzeByJSoup.validKeys;
        }

        @NotNull
        public final Element parse(@NotNull Object doc) {
            j.e(doc, "doc");
            if (doc instanceof Element) {
                return (Element) doc;
            }
            if (!(doc instanceof JXNode)) {
                Document document = Jsoup.parse(doc.toString());
                j.d(document, "parse(doc.toString())");
                return document;
            }
            JXNode jXNode = (JXNode) doc;
            Element elementAsElement = jXNode.isElement() ? jXNode.asElement() : Jsoup.parse(doc.toString());
            j.d(elementAsElement, "if (doc.isElement) doc.asElement() else Jsoup.parse(doc.toString())");
            return elementAsElement;
        }
    }

    /* JADX INFO: compiled from: AnalyzeByJSoup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeByJSoup$SourceRule;", "", "", "elementsRule", "Ljava/lang/String;", "getElementsRule", "()Ljava/lang/String;", "setElementsRule", "(Ljava/lang/String;)V", "", "isCss", "Z", "()Z", "setCss", "(Z)V", "ruleStr", "<init>", "(Lio/legado/app/model/analyzeRule/AnalyzeByJSoup;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public final class SourceRule {

        @NotNull
        private String elementsRule;
        private boolean isCss;
        public final /* synthetic */ AnalyzeByJSoup this$0;

        public SourceRule(@NotNull AnalyzeByJSoup analyzeByJSoup, String str) {
            j.e(analyzeByJSoup, "this$0");
            j.e(str, "ruleStr");
            this.this$0 = analyzeByJSoup;
            if (!k.H(str, "@CSS:", true)) {
                this.elementsRule = str;
                return;
            }
            this.isCss = true;
            String strSubstring = str.substring(5);
            j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
            int length = strSubstring.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = j.g(strSubstring.charAt(!z ? i2 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i2++;
                } else {
                    z = true;
                }
            }
            this.elementsRule = strSubstring.subSequence(i2, length + 1).toString();
        }

        @NotNull
        public final String getElementsRule() {
            return this.elementsRule;
        }

        /* JADX INFO: renamed from: isCss, reason: from getter */
        public final boolean getIsCss() {
            return this.isCss;
        }

        public final void setCss(boolean z) {
            this.isCss = z;
        }

        public final void setElementsRule(@NotNull String str) {
            j.e(str, "<set-?>");
            this.elementsRule = str;
        }
    }

    public AnalyzeByJSoup(@NotNull Object obj) {
        j.e(obj, "doc");
        this.element = INSTANCE.parse(obj);
    }

    private final Elements filterElements(Elements elements, String[] rules) {
        if (rules == null || rules.length < 2) {
            return elements;
        }
        Elements elements2 = new Elements();
        for (Element element : elements) {
            boolean z = false;
            String str = rules[0];
            int iHashCode = str.hashCode();
            if (iHashCode == 3355 ? str.equals("id") && element.getElementById(rules[1]) != null : iHashCode == 114586 ? str.equals("tag") && element.getElementsByTag(rules[1]).size() > 0 : iHashCode == 3556653 ? str.equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT) && element.getElementsContainingOwnText(rules[1]).size() > 0 : iHashCode == 94742904 && str.equals("class") && element.getElementsByClass(rules[1]).size() > 0) {
                z = true;
            }
            if (z) {
                elements2.add(element);
            }
        }
        return elements2;
    }

    private final Elements getElements(Element temp, String rule) {
        String[] strArrN5;
        String str;
        Elements elements = new Elements();
        if (temp != null && !TextUtils.isEmpty(rule)) {
            SourceRule sourceRule = new SourceRule(this, rule);
            int i2 = 0;
            if (k.d(sourceRule.getElementsRule(), "&&", false, 2)) {
                strArrN5 = c.b.a.m.f.n5(sourceRule.getElementsRule(), "&&");
                str = "&";
            } else if (k.d(sourceRule.getElementsRule(), "%%", false, 2)) {
                strArrN5 = c.b.a.m.f.n5(sourceRule.getElementsRule(), "%%");
                str = "%";
            } else {
                strArrN5 = c.b.a.m.f.n5(sourceRule.getElementsRule(), "||");
                str = "|";
            }
            ArrayList<Elements> arrayList = new ArrayList();
            if (sourceRule.getIsCss()) {
                int length = strArrN5.length;
                int i3 = 0;
                while (i3 < length) {
                    String str2 = strArrN5[i3];
                    i3++;
                    Elements elementsSelect = temp.select(str2);
                    arrayList.add(elementsSelect);
                    if (elementsSelect.size() > 0 && j.a(str, "|")) {
                        break;
                    }
                }
            } else {
                int length2 = strArrN5.length;
                int i4 = 0;
                while (i4 < length2) {
                    String str3 = strArrN5[i4];
                    i4++;
                    Elements elementsSingle = getElementsSingle(temp, str3);
                    arrayList.add(elementsSingle);
                    if (elementsSingle.size() > 0 && j.a(str, "|")) {
                        break;
                    }
                }
            }
            if (arrayList.size() > 0) {
                if (j.a("%", str)) {
                    int size = ((Elements) arrayList.get(0)).size();
                    if (size > 0) {
                        while (true) {
                            int i5 = i2 + 1;
                            for (Elements elements2 : arrayList) {
                                if (i2 < elements2.size()) {
                                    elements.add(elements2.get(i2));
                                }
                            }
                            if (i5 >= size) {
                                break;
                            }
                            i2 = i5;
                        }
                    }
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        elements.addAll((Elements) it.next());
                    }
                }
            }
        }
        return elements;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:145:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final org.jsoup.select.Elements getElementsSingle(org.jsoup.nodes.Element r18, java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 1106
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.analyzeRule.AnalyzeByJSoup.getElementsSingle(org.jsoup.nodes.Element, java.lang.String):org.jsoup.select.Elements");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011b A[Catch: Exception -> 0x0135, TryCatch #0 {Exception -> 0x0135, blocks: (B:3:0x0005, B:4:0x0009, B:57:0x0111, B:58:0x0115, B:60:0x011b, B:62:0x012b, B:64:0x0131, B:6:0x000e, B:9:0x0018, B:10:0x001c, B:12:0x0022, B:13:0x0030, B:16:0x003a, B:17:0x0055, B:20:0x005f, B:21:0x0068, B:24:0x0072, B:25:0x0076, B:27:0x007c, B:28:0x008f, B:30:0x0095, B:35:0x00b4, B:42:0x00c9, B:45:0x00cf, B:46:0x00d2, B:48:0x00e2, B:49:0x00e6, B:50:0x00f0, B:53:0x00f9, B:54:0x00fd, B:56:0x0103), top: B:69:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x008f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<java.lang.String> getResultLast(org.jsoup.select.Elements r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.analyzeRule.AnalyzeByJSoup.getResultLast(org.jsoup.select.Elements, java.lang.String):java.util.List");
    }

    private final List<String> getResultList(String ruleStr) {
        Elements elements;
        if (TextUtils.isEmpty(ruleStr)) {
            return null;
        }
        Elements elements2 = new Elements();
        elements2.add(this.element);
        String[] strArrN5 = c.b.a.m.f.n5(ruleStr, "@");
        int i2 = 0;
        int length = strArrN5.length - 1;
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                elements = new Elements();
                for (Element element : elements2) {
                    j.d(element, "elt");
                    elements.addAll(getElementsSingle(element, strArrN5[i2]));
                }
                elements2.clear();
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
                elements2 = elements;
            }
            elements2 = elements;
        }
        if (elements2.isEmpty()) {
            return null;
        }
        return getResultLast(elements2, strArrN5[strArrN5.length - 1]);
    }

    @NotNull
    public final Elements getElements$app_adsRelease(@NotNull String rule) {
        j.e(rule, "rule");
        return getElements(this.element, rule);
    }

    @Nullable
    public final String getString$app_adsRelease(@NotNull String ruleStr) {
        j.e(ruleStr, "ruleStr");
        if (TextUtils.isEmpty(ruleStr)) {
            return null;
        }
        List<String> stringList$app_adsRelease = getStringList$app_adsRelease(ruleStr);
        if (stringList$app_adsRelease.isEmpty()) {
            return null;
        }
        return e.q(stringList$app_adsRelease, "\n", null, null, 0, null, null, 62);
    }

    @NotNull
    public final String getString0$app_adsRelease(@NotNull String ruleStr) {
        j.e(ruleStr, "ruleStr");
        List<String> stringList$app_adsRelease = getStringList$app_adsRelease(ruleStr);
        return stringList$app_adsRelease.isEmpty() ^ true ? stringList$app_adsRelease.get(0) : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v7 */
    @NotNull
    public final List<String> getStringList$app_adsRelease(@NotNull String ruleStr) {
        String str;
        Object[] objArrN5;
        List<String> resultList;
        j.e(ruleStr, "ruleStr");
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(ruleStr)) {
            return arrayList;
        }
        SourceRule sourceRule = new SourceRule(this, ruleStr);
        if (TextUtils.isEmpty(sourceRule.getElementsRule())) {
            String strData = this.element.data();
            if (strData == null) {
                strData = "";
            }
            arrayList.add(strData);
        } else {
            ?? r5 = 0;
            if (k.d(sourceRule.getElementsRule(), "&&", false, 2)) {
                str = "&";
                objArrN5 = c.b.a.m.f.n5(sourceRule.getElementsRule(), "&&");
            } else if (k.d(sourceRule.getElementsRule(), "%%", false, 2)) {
                str = "%";
                objArrN5 = c.b.a.m.f.n5(sourceRule.getElementsRule(), "%%");
            } else {
                str = "|";
                objArrN5 = c.b.a.m.f.n5(sourceRule.getElementsRule(), "||");
            }
            ArrayList<List> arrayList2 = new ArrayList();
            int length = objArrN5.length;
            int i2 = 0;
            while (i2 < length) {
                String str2 = objArrN5[i2];
                i2++;
                if (sourceRule.getIsCss()) {
                    int iT = k.t(str2, '@', r5, r5, 6);
                    Element element = this.element;
                    Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring = str2.substring(r5, iT);
                    j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Elements elementsSelect = element.select(strSubstring);
                    j.d(elementsSelect, "element.select(ruleStrX.substring(0, lastIndex))");
                    String strSubstring2 = str2.substring(iT + 1);
                    j.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                    resultList = getResultLast(elementsSelect, strSubstring2);
                } else {
                    resultList = getResultList(str2);
                }
                if (!(resultList == null || resultList.isEmpty())) {
                    arrayList2.add(resultList);
                    if ((!arrayList2.isEmpty()) && j.a(str, "|")) {
                        break;
                    }
                }
                r5 = 0;
            }
            if (arrayList2.size() > 0) {
                if (j.a("%", str)) {
                    int size = ((List) arrayList2.get(0)).size() - 1;
                    if (size >= 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            for (List list : arrayList2) {
                                if (i3 < list.size()) {
                                    arrayList.add(list.get(i3));
                                }
                            }
                            if (i4 > size) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                } else {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList.addAll((List) it.next());
                    }
                }
            }
        }
        return arrayList;
    }
}
