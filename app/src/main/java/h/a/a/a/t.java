package h.a.a.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Spine.java */
/* JADX INFO: loaded from: classes3.dex */
public class t implements Serializable {
    private static final long serialVersionUID = 3878483958947357246L;
    private List<u> spineReferences;
    private p tocResource;

    public t() {
        this(new ArrayList());
    }

    public static List<u> createSpineReferences(Collection<p> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<p> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new u(it.next()));
        }
        return arrayList;
    }

    public u addResource(p pVar) {
        return addSpineReference(new u(pVar));
    }

    public u addSpineReference(u uVar) {
        if (this.spineReferences == null) {
            this.spineReferences = new ArrayList();
        }
        this.spineReferences.add(uVar);
        return uVar;
    }

    public int findFirstResourceById(String str) {
        if (c.b.a.m.f.q3(str)) {
            return -1;
        }
        for (int i2 = 0; i2 < this.spineReferences.size(); i2++) {
            if (str.equals(this.spineReferences.get(i2).getResourceId())) {
                return i2;
            }
        }
        return -1;
    }

    public p getResource(int i2) {
        if (i2 < 0 || i2 >= this.spineReferences.size()) {
            return null;
        }
        return this.spineReferences.get(i2).getResource();
    }

    public int getResourceIndex(p pVar) {
        if (pVar == null) {
            return -1;
        }
        return getResourceIndex(pVar.getHref());
    }

    public List<u> getSpineReferences() {
        return this.spineReferences;
    }

    public p getTocResource() {
        return this.tocResource;
    }

    public boolean isEmpty() {
        return this.spineReferences.isEmpty();
    }

    public void setSpineReferences(List<u> list) {
        this.spineReferences = list;
    }

    public void setTocResource(p pVar) {
        this.tocResource = pVar;
    }

    public int size() {
        return this.spineReferences.size();
    }

    public t(w wVar) {
        this.spineReferences = createSpineReferences(wVar.getAllUniqueResources());
    }

    public int getResourceIndex(String str) {
        if (c.b.a.m.f.q3(str)) {
            return -1;
        }
        for (int i2 = 0; i2 < this.spineReferences.size(); i2++) {
            if (str.equals(this.spineReferences.get(i2).getResource().getHref())) {
                return i2;
            }
        }
        return -1;
    }

    public t(List<u> list) {
        this.spineReferences = list;
    }
}
