package h.a.a.b;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: PackageDocumentMetadataReader.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends i {
    public static final /* synthetic */ int a = 0;

    public static List<h.a.a.a.b> a(String str, Element element) {
        h.a.a.a.b bVar;
        NodeList elementsByTagNameNS = element.getElementsByTagNameNS("http://purl.org/dc/elements/1.1/", str);
        ArrayList arrayList = new ArrayList(elementsByTagNameNS.getLength());
        for (int i2 = 0; i2 < elementsByTagNameNS.getLength(); i2++) {
            Element element2 = (Element) elementsByTagNameNS.item(i2);
            String strZ2 = c.b.a.m.f.Z2(element2);
            if (c.b.a.m.f.q3(strZ2)) {
                bVar = null;
            } else {
                int iLastIndexOf = strZ2.lastIndexOf(32);
                h.a.a.a.b bVar2 = iLastIndexOf < 0 ? new h.a.a.a.b(strZ2) : new h.a.a.a.b(strZ2.substring(0, iLastIndexOf), strZ2.substring(iLastIndexOf + 1));
                bVar2.setRole(c.b.a.m.f.Q1(element2, "http://www.idpf.org/2007/opf", "role"));
                bVar = bVar2;
            }
            if (bVar != null) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }
}
