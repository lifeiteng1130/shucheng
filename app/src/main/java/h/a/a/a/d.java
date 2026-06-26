package h.a.a.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: EpubBook.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements Serializable {
    private static final long serialVersionUID = 2068355170895770100L;
    private p coverImage;
    private p ncxResource;
    private p opfResource;
    private s resources = new s();
    private n metadata = new n();
    private t spine = new t();
    private w tableOfContents = new w();
    private final g guide = new g();
    private String version = "2.0";

    public static void a(p pVar, Map<String, p> map) {
        if (pVar == null || map.containsKey(pVar.getHref())) {
            return;
        }
        map.put(pVar.getHref(), pVar);
    }

    public p addResource(p pVar) {
        return this.resources.add(pVar);
    }

    public v addSection(v vVar, String str, p pVar) {
        return addSection(vVar, str, pVar, null);
    }

    public void generateSpineFromTableOfContents() {
        t tVar = new t(this.tableOfContents);
        tVar.setTocResource(this.spine.getTocResource());
        this.spine = tVar;
    }

    public List<p> getContents() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a(getCoverPage(), linkedHashMap);
        Iterator<u> it = getSpine().getSpineReferences().iterator();
        while (it.hasNext()) {
            a(it.next().getResource(), linkedHashMap);
        }
        Iterator<p> it2 = getTableOfContents().getAllUniqueResources().iterator();
        while (it2.hasNext()) {
            a(it2.next(), linkedHashMap);
        }
        Iterator<h> it3 = getGuide().getReferences().iterator();
        while (it3.hasNext()) {
            a(it3.next().getResource(), linkedHashMap);
        }
        return new ArrayList(linkedHashMap.values());
    }

    public p getCoverImage() {
        return this.coverImage;
    }

    public p getCoverPage() {
        p coverPage = this.guide.getCoverPage();
        return coverPage == null ? this.spine.getResource(0) : coverPage;
    }

    public g getGuide() {
        return this.guide;
    }

    public n getMetadata() {
        return this.metadata;
    }

    public p getNcxResource() {
        return this.ncxResource;
    }

    public p getOpfResource() {
        return this.opfResource;
    }

    public s getResources() {
        return this.resources;
    }

    public t getSpine() {
        return this.spine;
    }

    public w getTableOfContents() {
        return this.tableOfContents;
    }

    public String getTitle() {
        return getMetadata().getFirstTitle();
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isEpub3() {
        return this.version.startsWith("3.");
    }

    public void setCoverImage(p pVar) {
        if (pVar == null) {
            return;
        }
        if (this.resources.notContainsByHref(pVar.getHref())) {
            this.resources.add(pVar);
        }
        this.coverImage = pVar;
    }

    public void setCoverPage(p pVar) {
        if (pVar == null) {
            return;
        }
        if (this.resources.notContainsByHref(pVar.getHref())) {
            this.resources.add(pVar);
        }
        this.guide.setCoverPage(pVar);
    }

    public void setMetadata(n nVar) {
        this.metadata = nVar;
    }

    public void setNcxResource(p pVar) {
        this.ncxResource = pVar;
    }

    public void setOpfResource(p pVar) {
        this.opfResource = pVar;
    }

    public void setResources(s sVar) {
        this.resources = sVar;
    }

    public void setSpine(t tVar) {
        this.spine = tVar;
    }

    public void setTableOfContents(w wVar) {
        this.tableOfContents = wVar;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public v addSection(v vVar, String str, p pVar, String str2) {
        getResources().add(pVar);
        if (this.spine.findFirstResourceById(pVar.getId()) < 0) {
            this.spine.addSpineReference(new u(pVar));
        }
        return vVar.addChildSection(new v(str, pVar, str2));
    }

    public v addSection(String str, p pVar) {
        return addSection(str, pVar, (String) null);
    }

    public v addSection(String str, p pVar, String str2) {
        getResources().add(pVar);
        v vVarAddTOCReference = this.tableOfContents.addTOCReference(new v(str, pVar, str2));
        if (this.spine.findFirstResourceById(pVar.getId()) < 0) {
            this.spine.addSpineReference(new u(pVar));
        }
        return vVarAddTOCReference;
    }
}
