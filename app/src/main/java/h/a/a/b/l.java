package h.a.a.b;

import h.a.a.a.m;
import h.a.a.a.p;
import h.a.a.a.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: PackageDocumentWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends i {
    public static final /* synthetic */ int a = 0;

    public static void a(h.a.a.a.d dVar, f fVar, XmlSerializer xmlSerializer) {
        xmlSerializer.startTag("http://www.idpf.org/2007/opf", "guide");
        h.a.a.a.g guide = dVar.getGuide();
        if (guide.getGuideReferencesByType("cover").isEmpty() && guide.getCoverPage() != null) {
            b(new h.a.a.a.h(guide.getCoverPage(), "cover", "cover"), xmlSerializer);
        }
        Iterator<h.a.a.a.h> it = dVar.getGuide().getReferences().iterator();
        while (it.hasNext()) {
            b(it.next(), xmlSerializer);
        }
        xmlSerializer.endTag("http://www.idpf.org/2007/opf", "guide");
    }

    public static void b(h.a.a.a.h hVar, XmlSerializer xmlSerializer) throws IOException {
        if (hVar == null) {
            return;
        }
        xmlSerializer.startTag("http://www.idpf.org/2007/opf", "reference");
        xmlSerializer.attribute("", "type", hVar.getType());
        xmlSerializer.attribute("", "href", hVar.getCompleteHref());
        if (c.b.a.m.f.D3(hVar.getTitle())) {
            xmlSerializer.attribute("", "title", hVar.getTitle());
        }
        xmlSerializer.endTag("http://www.idpf.org/2007/opf", "reference");
    }

    public static void c(h.a.a.a.d dVar, f fVar, XmlSerializer xmlSerializer) {
        xmlSerializer.startTag("http://www.idpf.org/2007/opf", "manifest");
        xmlSerializer.startTag("http://www.idpf.org/2007/opf", "item");
        if (dVar.isEpub3()) {
            xmlSerializer.attribute("", "properties", "nav");
            xmlSerializer.attribute("", "id", "htmltoc");
            xmlSerializer.attribute("", "href", "toc.xhtml");
            xmlSerializer.attribute("", "media-type", h.a.getName());
        } else {
            Objects.requireNonNull(fVar);
            xmlSerializer.attribute("", "id", "ncx");
            xmlSerializer.attribute("", "href", "toc.ncx");
            xmlSerializer.attribute("", "media-type", m.f6306c.getName());
        }
        xmlSerializer.endTag("http://www.idpf.org/2007/opf", "item");
        ArrayList<p> arrayList = new ArrayList(dVar.getResources().getAll());
        Collections.sort(arrayList, b.a);
        for (p pVar : arrayList) {
            if (pVar != null && (pVar.getMediaType() != m.f6306c || dVar.getSpine().getTocResource() == null)) {
                if (c.b.a.m.f.q3(pVar.getId())) {
                    StringBuilder sbR = c.a.a.a.a.r("resource id must not be empty (href: ");
                    sbR.append(pVar.getHref());
                    sbR.append(", mediatype:");
                    sbR.append(pVar.getMediaType());
                    sbR.append(")");
                    sbR.toString();
                } else if (c.b.a.m.f.q3(pVar.getHref())) {
                    StringBuilder sbR2 = c.a.a.a.a.r("resource href must not be empty (id: ");
                    sbR2.append(pVar.getId());
                    sbR2.append(", mediatype:");
                    sbR2.append(pVar.getMediaType());
                    sbR2.append(")");
                    sbR2.toString();
                } else if (pVar.getMediaType() == null) {
                    pVar.getId();
                    pVar.getHref();
                } else {
                    xmlSerializer.startTag("http://www.idpf.org/2007/opf", "item");
                    xmlSerializer.attribute("", "id", pVar.getId());
                    xmlSerializer.attribute("", "href", pVar.getHref());
                    xmlSerializer.attribute("", "media-type", pVar.getMediaType().getName());
                    xmlSerializer.endTag("http://www.idpf.org/2007/opf", "item");
                }
            }
        }
        xmlSerializer.endTag("http://www.idpf.org/2007/opf", "manifest");
    }

    public static void d(h.a.a.a.d dVar, XmlSerializer xmlSerializer) {
        xmlSerializer.startTag("http://www.idpf.org/2007/opf", "spine");
        xmlSerializer.attribute("", "toc", dVar.getSpine().getTocResource().getId());
        if (dVar.getCoverPage() != null && dVar.getSpine().findFirstResourceById(dVar.getCoverPage().getId()) < 0) {
            xmlSerializer.startTag("http://www.idpf.org/2007/opf", "itemref");
            xmlSerializer.attribute("", "idref", dVar.getCoverPage().getId());
            xmlSerializer.attribute("", "linear", "no");
            xmlSerializer.endTag("http://www.idpf.org/2007/opf", "itemref");
        }
        for (u uVar : dVar.getSpine().getSpineReferences()) {
            xmlSerializer.startTag("http://www.idpf.org/2007/opf", "itemref");
            xmlSerializer.attribute("", "idref", uVar.getResourceId());
            if (!uVar.isLinear()) {
                xmlSerializer.attribute("", "linear", "no");
            }
            xmlSerializer.endTag("http://www.idpf.org/2007/opf", "itemref");
        }
        xmlSerializer.endTag("http://www.idpf.org/2007/opf", "spine");
    }
}
