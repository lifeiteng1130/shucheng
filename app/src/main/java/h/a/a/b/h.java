package h.a.a.b;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.ai;
import h.a.a.a.m;
import h.a.a.a.n;
import h.a.a.a.p;
import h.a.a.a.v;
import h.a.a.a.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.helper.DataUtil;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Attributes;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: NCXDocumentV3.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static final h.a.a.a.l a = m.a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6317b = h.class.getName();

    public static p a(h.a.a.a.d dVar) throws IOException {
        dVar.getMetadata().getIdentifiers();
        String title = dVar.getTitle();
        dVar.getMetadata().getAuthors();
        w tableOfContents = dVar.getTableOfContents();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XmlSerializer xmlSerializerA = d.a(byteArrayOutputStream);
        xmlSerializerA.startDocument(DataUtil.defaultCharset, Boolean.FALSE);
        xmlSerializerA.setPrefix("", "http://www.w3.org/1999/xhtml");
        xmlSerializerA.startTag("http://www.w3.org/1999/xhtml", "html");
        xmlSerializerA.attribute("", "xmlns:epub", "http://www.idpf.org/2007/ops");
        xmlSerializerA.attribute("", "xml:lang", n.DEFAULT_LANGUAGE);
        xmlSerializerA.attribute("", "lang", n.DEFAULT_LANGUAGE);
        xmlSerializerA.startTag("http://www.w3.org/1999/xhtml", "head");
        xmlSerializerA.startTag("http://www.w3.org/1999/xhtml", "title");
        xmlSerializerA.text(title == null ? "" : title);
        xmlSerializerA.endTag("http://www.w3.org/1999/xhtml", "title");
        xmlSerializerA.startTag("http://www.w3.org/1999/xhtml", "link");
        xmlSerializerA.attribute("", "rel", "stylesheet");
        xmlSerializerA.attribute("", "type", "text/css");
        xmlSerializerA.attribute("", "href", "css/style.css");
        xmlSerializerA.endTag("http://www.w3.org/1999/xhtml", "link");
        xmlSerializerA.startTag("http://www.w3.org/1999/xhtml", TTDownloadField.TT_META);
        xmlSerializerA.attribute("", "http-equiv", HttpConnection.CONTENT_TYPE);
        xmlSerializerA.attribute("", "content", "text/html; charset=utf-8");
        xmlSerializerA.endTag("http://www.w3.org/1999/xhtml", TTDownloadField.TT_META);
        xmlSerializerA.endTag("http://www.w3.org/1999/xhtml", "head");
        xmlSerializerA.startTag("http://www.w3.org/1999/xhtml", "body");
        xmlSerializerA.startTag("http://www.w3.org/1999/xhtml", "h1");
        xmlSerializerA.text(title);
        xmlSerializerA.endTag("http://www.w3.org/1999/xhtml", "h1");
        xmlSerializerA.startTag("http://www.w3.org/1999/xhtml", "nav");
        xmlSerializerA.attribute("", "epub:type", "toc");
        xmlSerializerA.attribute("", "id", "toc");
        xmlSerializerA.attribute("", "role", "doc-toc");
        xmlSerializerA.startTag("http://www.w3.org/1999/xhtml", "h2");
        xmlSerializerA.text("目录");
        xmlSerializerA.endTag("http://www.w3.org/1999/xhtml", "h2");
        c(tableOfContents.getTocReferences(), 1, xmlSerializerA);
        xmlSerializerA.endTag("http://www.w3.org/1999/xhtml", "nav");
        xmlSerializerA.endTag("http://www.w3.org/1999/xhtml", "body");
        xmlSerializerA.endTag("http://www.w3.org/1999/xhtml", "html");
        xmlSerializerA.endDocument();
        p pVar = new p("htmltoc", byteArrayOutputStream.toByteArray(), "toc.xhtml", a);
        pVar.setProperties("nav");
        return pVar;
    }

    public static v b(Element element, h.a.a.a.d dVar) {
        String strQ1;
        String textContent = c.b.a.m.f.t2(element, "", ai.at).getTextContent();
        if (!c.b.a.m.f.D3(textContent)) {
            textContent = c.b.a.m.f.t2(element, "", "span").getTextContent();
        }
        String strV5 = c.b.a.m.f.v5(dVar.getSpine().getTocResource().getHref(), Attributes.InternalPrefix);
        StringBuilder sbR = c.a.a.a.a.r(strV5.length() == dVar.getSpine().getTocResource().getHref().length() ? "" : c.a.a.a.a.i(strV5, w.DEFAULT_PATH_SEPARATOR));
        Element elementT2 = c.b.a.m.f.t2(element, "", ai.at);
        if (elementT2 == null) {
            strQ1 = null;
        } else {
            strQ1 = c.b.a.m.f.Q1(elementT2, "", "href");
            try {
                strQ1 = URLDecoder.decode(strQ1, DataUtil.defaultCharset);
            } catch (UnsupportedEncodingException e2) {
                e2.getMessage();
            }
        }
        sbR.append(strQ1);
        String strR0 = c.b.a.m.f.R0(sbR.toString());
        v vVar = new v(textContent, dVar.getResources().getByHref(c.b.a.m.f.u5(strR0, '#')), c.b.a.m.f.t5(strR0, '#'));
        ArrayList arrayList = new ArrayList();
        if (element.getNodeType() == 1) {
            NodeList elementsByTagName = element.getElementsByTagName("li");
            for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                arrayList.add(b((Element) elementsByTagName.item(i2), dVar));
            }
        }
        vVar.setChildren(arrayList);
        return vVar;
    }

    public static int c(List<v> list, int i2, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag("http://www.w3.org/1999/xhtml", "ol");
        for (v vVar : list) {
            if (vVar.getResource() == null) {
                i2 = c(vVar.getChildren(), i2, xmlSerializer);
            } else {
                xmlSerializer.startTag("http://www.w3.org/1999/xhtml", "li");
                String title = vVar.getTitle();
                String completeHref = vVar.getCompleteHref();
                if (c.b.a.m.f.D3(completeHref)) {
                    xmlSerializer.startTag("http://www.w3.org/1999/xhtml", ai.at);
                    xmlSerializer.attribute("", "href", completeHref);
                    xmlSerializer.text(title);
                    xmlSerializer.endTag("http://www.w3.org/1999/xhtml", ai.at);
                } else {
                    xmlSerializer.startTag("http://www.w3.org/1999/xhtml", "span");
                    xmlSerializer.text(title);
                    xmlSerializer.endTag("http://www.w3.org/1999/xhtml", "span");
                }
                i2++;
                if (!vVar.getChildren().isEmpty()) {
                    i2 = c(vVar.getChildren(), i2, xmlSerializer);
                }
                xmlSerializer.endTag("http://www.w3.org/1999/xhtml", "li");
            }
        }
        xmlSerializer.endTag("http://www.w3.org/1999/xhtml", "ol");
        return i2;
    }
}
