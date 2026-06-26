package h.a.a.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: Guide.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements Serializable {
    public static final String DEFAULT_COVER_TITLE = "cover";
    private static final long serialVersionUID = -6256645339915751189L;
    private List<h> references = new ArrayList();
    private int coverPageIndex = -1;

    public r addReference(h hVar) {
        this.references.add(hVar);
        this.coverPageIndex = -2;
        return hVar;
    }

    public p getCoverPage() {
        h coverReference = getCoverReference();
        if (coverReference == null) {
            return null;
        }
        return coverReference.getResource();
    }

    public h getCoverReference() {
        if (this.coverPageIndex == -2) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.references.size()) {
                    i2 = -1;
                    break;
                }
                if (this.references.get(i2).getType().equals("cover")) {
                    break;
                }
                i2++;
            }
            this.coverPageIndex = i2;
        }
        int i3 = this.coverPageIndex;
        if (i3 >= 0) {
            return this.references.get(i3);
        }
        return null;
    }

    public List<h> getGuideReferencesByType(String str) {
        ArrayList arrayList = new ArrayList();
        for (h hVar : this.references) {
            if (str.equalsIgnoreCase(hVar.getType())) {
                arrayList.add(hVar);
            }
        }
        return arrayList;
    }

    public List<h> getReferences() {
        return this.references;
    }

    public void setCoverPage(p pVar) {
        setCoverReference(new h(pVar, "cover", "cover"));
    }

    public int setCoverReference(h hVar) {
        int i2 = this.coverPageIndex;
        if (i2 >= 0) {
            this.references.set(i2, hVar);
        } else {
            this.references.add(0, hVar);
            this.coverPageIndex = 0;
        }
        return this.coverPageIndex;
    }

    public void setReferences(List<h> list) {
        this.references = list;
        this.coverPageIndex = -2;
    }
}
