package h.a.a.b;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.a.a.a.m;
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
import org.jsoup.nodes.Attributes;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: NCXDocumentV2.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static p a(h.a.a.a.d dVar) throws IOException {
        List<h.a.a.a.i> identifiers = dVar.getMetadata().getIdentifiers();
        String title = dVar.getTitle();
        List<h.a.a.a.b> authors = dVar.getMetadata().getAuthors();
        w tableOfContents = dVar.getTableOfContents();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XmlSerializer xmlSerializerA = d.a(byteArrayOutputStream);
        xmlSerializerA.startDocument(DataUtil.defaultCharset, Boolean.FALSE);
        xmlSerializerA.setPrefix("", "http://www.daisy.org/z3986/2005/ncx/");
        xmlSerializerA.startTag("http://www.daisy.org/z3986/2005/ncx/", "ncx");
        xmlSerializerA.attribute("", "version", "2005-1");
        xmlSerializerA.startTag("http://www.daisy.org/z3986/2005/ncx/", "head");
        for (h.a.a.a.i iVar : identifiers) {
            d(iVar.getScheme(), iVar.getValue(), xmlSerializerA);
        }
        d("generator", "Ag2S EpubLib", xmlSerializerA);
        d("depth", String.valueOf(tableOfContents.calculateDepth()), xmlSerializerA);
        d("totalPageCount", "0", xmlSerializerA);
        d("maxPageNumber", "0", xmlSerializerA);
        xmlSerializerA.endTag("http://www.daisy.org/z3986/2005/ncx/", "head");
        xmlSerializerA.startTag("http://www.daisy.org/z3986/2005/ncx/", "docTitle");
        xmlSerializerA.startTag("http://www.daisy.org/z3986/2005/ncx/", NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        if (title == null) {
            title = "";
        }
        xmlSerializerA.text(title);
        xmlSerializerA.endTag("http://www.daisy.org/z3986/2005/ncx/", NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        xmlSerializerA.endTag("http://www.daisy.org/z3986/2005/ncx/", "docTitle");
        for (h.a.a.a.b bVar : authors) {
            xmlSerializerA.startTag("http://www.daisy.org/z3986/2005/ncx/", "docAuthor");
            xmlSerializerA.startTag("http://www.daisy.org/z3986/2005/ncx/", NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            xmlSerializerA.text(bVar.getLastname() + ", " + bVar.getFirstname());
            xmlSerializerA.endTag("http://www.daisy.org/z3986/2005/ncx/", NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            xmlSerializerA.endTag("http://www.daisy.org/z3986/2005/ncx/", "docAuthor");
        }
        xmlSerializerA.startTag("http://www.daisy.org/z3986/2005/ncx/", "navMap");
        e(tableOfContents.getTocReferences(), 1, xmlSerializerA);
        xmlSerializerA.endTag("http://www.daisy.org/z3986/2005/ncx/", "navMap");
        xmlSerializerA.endTag("http://www.daisy.org/z3986/2005/ncx/", "ncx");
        xmlSerializerA.endDocument();
        return new p("ncx", byteArrayOutputStream.toByteArray(), "toc.ncx", m.f6306c);
    }

    public static p b(h.a.a.a.d dVar) {
        p pVar = null;
        if (dVar.getSpine().getTocResource() == null) {
            return null;
        }
        try {
            p tocResource = dVar.getSpine().getTocResource();
            if (tocResource == null) {
                return null;
            }
            try {
                tocResource.getHref();
                Element elementT2 = c.b.a.m.f.t2(c.b.a.m.f.P1(tocResource).getDocumentElement(), "http://www.daisy.org/z3986/2005/ncx/", "navMap");
                if (elementT2 == null) {
                    return null;
                }
                dVar.setTableOfContents(new w(c(elementT2.getChildNodes(), dVar)));
                return tocResource;
            } catch (Exception e2) {
                e = e2;
                pVar = tocResource;
                e.getMessage();
                return pVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static List<v> c(NodeList nodeList, h.a.a.a.d dVar) {
        String strQ1;
        if (nodeList == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(nodeList.getLength());
        for (int i2 = 0; i2 < nodeList.getLength(); i2++) {
            Node nodeItem = nodeList.item(i2);
            if (nodeItem.getNodeType() == 1 && nodeItem.getLocalName().equals("navPoint")) {
                Element element = (Element) nodeItem;
                String strZ2 = c.b.a.m.f.Z2(c.b.a.m.f.t2(c.b.a.m.f.t2(element, "http://www.daisy.org/z3986/2005/ncx/", "navLabel"), "http://www.daisy.org/z3986/2005/ncx/", NotificationCompat.MessagingStyle.Message.KEY_TEXT));
                String strV5 = c.b.a.m.f.v5(dVar.getSpine().getTocResource().getHref(), Attributes.InternalPrefix);
                StringBuilder sbR = c.a.a.a.a.r(strV5.length() == dVar.getSpine().getTocResource().getHref().length() ? "" : c.a.a.a.a.i(strV5, w.DEFAULT_PATH_SEPARATOR));
                Element elementT2 = c.b.a.m.f.t2(element, "http://www.daisy.org/z3986/2005/ncx/", "content");
                if (elementT2 == null) {
                    strQ1 = null;
                } else {
                    strQ1 = c.b.a.m.f.Q1(elementT2, "http://www.daisy.org/z3986/2005/ncx/", "src");
                    try {
                        strQ1 = URLDecoder.decode(strQ1, DataUtil.defaultCharset);
                    } catch (UnsupportedEncodingException e2) {
                        e2.getMessage();
                    }
                }
                sbR.append(strQ1);
                String strR0 = c.b.a.m.f.R0(sbR.toString());
                v vVar = new v(strZ2, dVar.getResources().getByHref(c.b.a.m.f.u5(strR0, '#')), c.b.a.m.f.t5(strR0, '#'));
                vVar.setChildren(c(element.getChildNodes(), dVar));
                arrayList.add(vVar);
            }
        }
        return arrayList;
    }

    public static void d(String str, String str2, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag("http://www.daisy.org/z3986/2005/ncx/", TTDownloadField.TT_META);
        xmlSerializer.attribute("", "name", "dtb:" + str);
        xmlSerializer.attribute("", "content", str2);
        xmlSerializer.endTag("http://www.daisy.org/z3986/2005/ncx/", TTDownloadField.TT_META);
    }

    public static int e(List<v> list, int i2, XmlSerializer xmlSerializer) throws IOException {
        for (v vVar : list) {
            if (vVar.getResource() == null) {
                i2 = e(vVar.getChildren(), i2, xmlSerializer);
            } else {
                xmlSerializer.startTag("http://www.daisy.org/z3986/2005/ncx/", "navPoint");
                xmlSerializer.attribute("", "id", "navPoint-" + i2);
                xmlSerializer.attribute("", "playOrder", String.valueOf(i2));
                xmlSerializer.attribute("", "class", "chapter");
                xmlSerializer.startTag("http://www.daisy.org/z3986/2005/ncx/", "navLabel");
                xmlSerializer.startTag("http://www.daisy.org/z3986/2005/ncx/", NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                xmlSerializer.text(vVar.getTitle());
                xmlSerializer.endTag("http://www.daisy.org/z3986/2005/ncx/", NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                xmlSerializer.endTag("http://www.daisy.org/z3986/2005/ncx/", "navLabel");
                xmlSerializer.startTag("http://www.daisy.org/z3986/2005/ncx/", "content");
                xmlSerializer.attribute("", "src", vVar.getCompleteHref());
                xmlSerializer.endTag("http://www.daisy.org/z3986/2005/ncx/", "content");
                i2++;
                if (!vVar.getChildren().isEmpty()) {
                    i2 = e(vVar.getChildren(), i2, xmlSerializer);
                }
                xmlSerializer.endTag("http://www.daisy.org/z3986/2005/ncx/", "navPoint");
            }
        }
        return i2;
    }
}
