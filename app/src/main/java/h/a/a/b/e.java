package h.a.a.b;

import h.a.a.a.m;
import h.a.a.a.p;
import h.a.a.a.s;
import h.a.a.a.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: EpubReader.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public final c a;

    public e() {
        int i2 = c.a;
        this.a = a.f6316b;
    }

    public h.a.a.a.d a(ZipFile zipFile, String str) {
        int i2;
        String attribute;
        p pVarB;
        Exception e2;
        p tocResource;
        ArrayList arrayList;
        p jVar;
        List listAsList = Arrays.asList(m.s);
        h.a.a.a.e eVar = new h.a.a.a.e(zipFile.getName());
        s sVar = new s();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (true) {
            boolean z = true;
            if (!enumerationEntries.hasMoreElements()) {
                break;
            }
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (zipEntryNextElement != null && !zipEntryNextElement.isDirectory()) {
                String name = zipEntryNextElement.getName();
                if (listAsList != null && !listAsList.isEmpty()) {
                    z = false;
                }
                if (z ? false : listAsList.contains(m.a(name))) {
                    jVar = new h.a.a.a.j(eVar, zipEntryNextElement.getSize(), name);
                } else {
                    p pVar = new p(zipFile.getInputStream(zipEntryNextElement), zipEntryNextElement.getName());
                    if (name.endsWith("opf")) {
                        pVar.setData(new String(pVar.getData()).replace("smlns=\"", "xmlns=\"").getBytes());
                    }
                    jVar = pVar;
                }
                if (jVar.getMediaType() == m.a) {
                    jVar.setInputEncoding(str);
                }
                sVar.add(jVar);
            }
        }
        h.a.a.a.d dVar = new h.a.a.a.d();
        sVar.remove("mimetype");
        p pVarRemove = sVar.remove("META-INF/container.xml");
        String str2 = "OEBPS/content.opf";
        if (pVarRemove != null) {
            try {
                attribute = ((Element) ((Element) c.b.a.m.f.P1(pVarRemove).getDocumentElement().getElementsByTagName("rootfiles").item(0)).getElementsByTagName("rootfile").item(0)).getAttribute("full-path");
            } catch (Exception e3) {
                e3.getMessage();
                attribute = "OEBPS/content.opf";
            }
            if (!c.b.a.m.f.q3(attribute)) {
                str2 = attribute;
            }
        }
        p pVarRemove2 = sVar.remove(str2);
        try {
            k.a(pVarRemove2, this, dVar, sVar);
        } catch (Exception e4) {
            e4.getMessage();
        }
        dVar.setOpfResource(pVarRemove2);
        pVarRemove2.getHref();
        if (dVar.isEpub3()) {
            h.a.a.a.l lVar = h.a;
            pVarB = null;
            if (dVar.getSpine().getTocResource() != null) {
                try {
                    tocResource = dVar.getSpine().getTocResource();
                } catch (Exception e5) {
                    e2 = e5;
                    tocResource = null;
                }
                if (tocResource != null) {
                    try {
                    } catch (Exception e6) {
                        e2 = e6;
                        e2.getMessage();
                    }
                    if (tocResource.getHref().endsWith(".ncx")) {
                        pVarB = g.b(dVar);
                    } else {
                        tocResource.getHref();
                        Document documentP1 = c.b.a.m.f.P1(tocResource);
                        documentP1.getNodeName();
                        Element element = (Element) documentP1.getElementsByTagName("nav").item(0);
                        if (element == null) {
                            pVarB = g.b(dVar);
                        } else {
                            Element element2 = (Element) element.getElementsByTagName("ol").item(0);
                            element2.getTagName();
                            NodeList childNodes = element2.getChildNodes();
                            if (childNodes == null) {
                                arrayList = new ArrayList();
                            } else {
                                ArrayList arrayList2 = new ArrayList(childNodes.getLength());
                                for (i2 = 0; i2 < childNodes.getLength(); i2++) {
                                    Node nodeItem = childNodes.item(i2);
                                    if (nodeItem != null && nodeItem.getNodeType() == 1) {
                                        Element element3 = (Element) nodeItem;
                                        if (element3.getTagName().equals("li")) {
                                            arrayList2.add(h.b(element3, dVar));
                                        }
                                    }
                                }
                                arrayList = arrayList2;
                            }
                            w wVar = new w(arrayList);
                            wVar.toString();
                            dVar.setTableOfContents(wVar);
                            pVarB = tocResource;
                        }
                    }
                }
            }
        } else {
            pVarB = g.b(dVar);
        }
        dVar.setNcxResource(pVarB);
        c cVar = this.a;
        if (cVar != null) {
        }
        return dVar;
    }
}
