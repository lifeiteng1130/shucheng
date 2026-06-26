package io.legado.app.model.analyzeRule;

import android.text.TextUtils;
import androidx.annotation.Keep;
import c.b.a.m.f;
import f.c0.c.j;
import f.h0.k;
import f.x.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

/* JADX INFO: compiled from: AnalyzeByXPath.kt */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000f\u0010\u000eJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0011\u0010\u000eJ\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeByXPath;", "", "doc", "parse", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "html", "Lorg/seimicrawler/xpath/JXDocument;", "strToJXDocument", "(Ljava/lang/String;)Lorg/seimicrawler/xpath/JXDocument;", "xPath", "", "Lorg/seimicrawler/xpath/JXNode;", "getResult", "(Ljava/lang/String;)Ljava/util/List;", "getElements$app_adsRelease", "getElements", "getStringList$app_adsRelease", "getStringList", "rule", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "jxNode", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AnalyzeByXPath {

    @NotNull
    private Object jxNode;

    public AnalyzeByXPath(@NotNull Object obj) {
        j.e(obj, "doc");
        this.jxNode = parse(obj);
    }

    private final List<JXNode> getResult(String xPath) {
        Object obj = this.jxNode;
        return obj instanceof JXNode ? ((JXNode) obj).sel(xPath) : ((JXDocument) obj).selN(xPath);
    }

    private final Object parse(Object doc) {
        if (doc instanceof JXNode) {
            return ((JXNode) doc).isElement() ? doc : strToJXDocument(doc.toString());
        }
        if (doc instanceof Document) {
            JXDocument jXDocumentCreate = JXDocument.create((Document) doc);
            j.d(jXDocumentCreate, "create(doc)");
            return jXDocumentCreate;
        }
        if (doc instanceof Element) {
            JXDocument jXDocumentCreate2 = JXDocument.create(new Elements((Element) doc));
            j.d(jXDocumentCreate2, "create(Elements(doc))");
            return jXDocumentCreate2;
        }
        if (!(doc instanceof Elements)) {
            return strToJXDocument(doc.toString());
        }
        JXDocument jXDocumentCreate3 = JXDocument.create((Elements) doc);
        j.d(jXDocumentCreate3, "create(doc)");
        return jXDocumentCreate3;
    }

    private final JXDocument strToJXDocument(String html) {
        if (k.h(html, "</td>", false, 2)) {
            html = String.format("<tr>%s</tr>", Arrays.copyOf(new Object[]{html}, 1));
            j.d(html, "java.lang.String.format(format, *args)");
        }
        if (k.h(html, "</tr>", false, 2) || k.h(html, "</tbody>", false, 2)) {
            html = String.format("<table>%s</table>", Arrays.copyOf(new Object[]{html}, 1));
            j.d(html, "java.lang.String.format(format, *args)");
        }
        JXDocument jXDocumentCreate = JXDocument.create(html);
        j.d(jXDocumentCreate, "create(html1)");
        return jXDocumentCreate;
    }

    @Nullable
    public final List<JXNode> getElements$app_adsRelease(@NotNull String xPath) {
        String[] strArrN5;
        String str;
        j.e(xPath, "xPath");
        if (TextUtils.isEmpty(xPath)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (k.d(xPath, "&&", false, 2)) {
            strArrN5 = f.n5(xPath, "&&");
            str = "&";
        } else if (k.d(xPath, "%%", false, 2)) {
            strArrN5 = f.n5(xPath, "%%");
            str = "%";
        } else {
            strArrN5 = f.n5(xPath, "||");
            str = "|";
        }
        if (strArrN5.length == 1) {
            return getResult(strArrN5[0]);
        }
        ArrayList<List> arrayList2 = new ArrayList();
        int length = strArrN5.length;
        int i3 = 0;
        while (i3 < length) {
            String str2 = strArrN5[i3];
            i3++;
            List<JXNode> elements$app_adsRelease = getElements$app_adsRelease(str2);
            if (elements$app_adsRelease != null && (!elements$app_adsRelease.isEmpty())) {
                arrayList2.add(elements$app_adsRelease);
                if ((!elements$app_adsRelease.isEmpty()) && j.a(str, "|")) {
                    break;
                }
            }
        }
        if (arrayList2.size() > 0) {
            if (j.a("%", str)) {
                int size = ((List) arrayList2.get(0)).size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i4 = i2 + 1;
                        for (List list : arrayList2) {
                            if (i2 < list.size()) {
                                arrayList.add(list.get(i2));
                            }
                        }
                        if (i4 > size) {
                            break;
                        }
                        i2 = i4;
                    }
                }
            } else {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.addAll((List) it.next());
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final String getString(@NotNull String rule) {
        String[] strArrN5;
        String str;
        j.e(rule, "rule");
        if (k.d(rule, "&&", false, 2)) {
            strArrN5 = f.n5(rule, "&&");
            str = "&";
        } else {
            strArrN5 = f.n5(rule, "||");
            str = "|";
        }
        if (strArrN5.length == 1) {
            List<JXNode> result = getResult(rule);
            if (result == null) {
                return null;
            }
            return TextUtils.join("\n", result);
        }
        ArrayList arrayList = new ArrayList();
        int length = strArrN5.length;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArrN5[i2];
            i2++;
            String string = getString(str2);
            if (!(string == null || string.length() == 0)) {
                arrayList.add(string);
                if (j.a(str, "|")) {
                    break;
                }
            }
        }
        return e.q(arrayList, "\n", null, null, 0, null, null, 62);
    }

    @NotNull
    public final List<String> getStringList$app_adsRelease(@NotNull String xPath) {
        String[] strArrN5;
        String str;
        j.e(xPath, "xPath");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (k.d(xPath, "&&", false, 2)) {
            strArrN5 = f.n5(xPath, "&&");
            str = "&";
        } else if (k.d(xPath, "%%", false, 2)) {
            strArrN5 = f.n5(xPath, "%%");
            str = "%";
        } else {
            strArrN5 = f.n5(xPath, "||");
            str = "|";
        }
        if (strArrN5.length == 1) {
            List<JXNode> result = getResult(xPath);
            if (result != null) {
                ArrayList arrayList2 = new ArrayList(f.S0(result, 10));
                Iterator<T> it = result.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Boolean.valueOf(arrayList.add(((JXNode) it.next()).asString())));
                }
            }
            return arrayList;
        }
        ArrayList<List> arrayList3 = new ArrayList();
        int length = strArrN5.length;
        int i3 = 0;
        while (i3 < length) {
            String str2 = strArrN5[i3];
            i3++;
            List<String> stringList$app_adsRelease = getStringList$app_adsRelease(str2);
            if (!stringList$app_adsRelease.isEmpty()) {
                arrayList3.add(stringList$app_adsRelease);
                if ((!stringList$app_adsRelease.isEmpty()) && j.a(str, "|")) {
                    break;
                }
            }
        }
        if (arrayList3.size() > 0) {
            if (j.a("%", str)) {
                int size = ((List) arrayList3.get(0)).size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i4 = i2 + 1;
                        for (List list : arrayList3) {
                            if (i2 < list.size()) {
                                arrayList.add(list.get(i2));
                            }
                        }
                        if (i4 > size) {
                            break;
                        }
                        i2 = i4;
                    }
                }
            } else {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    arrayList.addAll((List) it2.next());
                }
            }
        }
        return arrayList;
    }
}
