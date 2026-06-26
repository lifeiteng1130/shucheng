package h.a.a.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Resources.java */
/* JADX INFO: loaded from: classes3.dex */
public class s implements Serializable {
    private static final long serialVersionUID = 2450876953383871451L;
    private int lastId = 1;
    private Map<String, p> resources = new HashMap();

    public final String a(l lVar, int i2) {
        if (m.b(lVar)) {
            return "image_" + i2 + lVar.getDefaultExtension();
        }
        return "item_" + i2 + lVar.getDefaultExtension();
    }

    public p add(p pVar) {
        b(pVar);
        fixResourceId(pVar);
        this.resources.put(pVar.getHref(), pVar);
        return pVar;
    }

    public void addAll(Collection<p> collection) {
        for (p pVar : collection) {
            b(pVar);
            this.resources.put(pVar.getHref(), pVar);
        }
    }

    public final void b(p pVar) {
        if ((!c.b.a.m.f.D3(pVar.getHref()) || this.resources.containsKey(pVar.getHref())) && c.b.a.m.f.q3(pVar.getHref())) {
            if (pVar.getMediaType() == null) {
                throw new IllegalArgumentException("Resource must have either a MediaType or a href");
            }
            String strA = a(pVar.getMediaType(), 1);
            int i2 = 1;
            while (this.resources.containsKey(strA)) {
                i2++;
                strA = a(pVar.getMediaType(), i2);
            }
            pVar.setHref(strA);
        }
    }

    public boolean containsByHref(String str) {
        return !notContainsByHref(str);
    }

    public boolean containsId(String str) {
        if (c.b.a.m.f.q3(str)) {
            return false;
        }
        Iterator<p> it = this.resources.values().iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().getId())) {
                return true;
            }
        }
        return false;
    }

    public p findFirstResourceByMediaType(l lVar) {
        return findFirstResourceByMediaType(this.resources.values(), lVar);
    }

    public void fixResourceId(p pVar) {
        String id = pVar.getId();
        int i2 = 1;
        if (c.b.a.m.f.q3(pVar.getId())) {
            id = c.b.a.m.f.v5(pVar.getHref(), '.');
            if (!c.b.a.m.f.w3(id)) {
                int iLastIndexOf = id.lastIndexOf(47);
                id = iLastIndexOf < 0 ? "" : id.substring(iLastIndexOf + 1);
            }
        }
        if (c.b.a.m.f.D3(id) && !Character.isJavaIdentifierStart(id.charAt(0))) {
            id = c.a.a.a.a.p(new StringBuilder(), m.b(pVar.getMediaType()) ? "image_" : "item_", id);
        }
        if (c.b.a.m.f.q3(id) || containsId(id)) {
            int i3 = this.lastId;
            if (i3 != Integer.MAX_VALUE) {
                i2 = i3;
            } else if (this.resources.size() == Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Resources contains 2147483647 elements: no new elements can be added");
            }
            String str = m.b(pVar.getMediaType()) ? "image_" : "item_";
            id = c.a.a.a.a.G(str, i2);
            while (containsId(id)) {
                StringBuilder sbR = c.a.a.a.a.r(str);
                i2++;
                sbR.append(i2);
                id = sbR.toString();
            }
            this.lastId = i2;
        }
        pVar.setId(id);
    }

    public Collection<p> getAll() {
        return this.resources.values();
    }

    public Collection<String> getAllHrefs() {
        return this.resources.keySet();
    }

    public p getByHref(String str) {
        if (c.b.a.m.f.q3(str)) {
            return null;
        }
        return this.resources.get(c.b.a.m.f.u5(str, '#'));
    }

    public p getById(String str) {
        if (c.b.a.m.f.q3(str)) {
            return null;
        }
        for (p pVar : this.resources.values()) {
            if (str.equals(pVar.getId())) {
                return pVar;
            }
        }
        return null;
    }

    public p getByIdOrHref(String str) {
        p byId = getById(str);
        return byId == null ? getByHref(str) : byId;
    }

    public p getByProperties(String str) {
        if (c.b.a.m.f.q3(str)) {
            return null;
        }
        for (p pVar : this.resources.values()) {
            if (str.equals(pVar.getProperties())) {
                return pVar;
            }
        }
        return null;
    }

    public Map<String, p> getResourceMap() {
        return this.resources;
    }

    public List<p> getResourcesByMediaType(l lVar) {
        ArrayList arrayList = new ArrayList();
        if (lVar == null) {
            return arrayList;
        }
        for (p pVar : getAll()) {
            if (pVar.getMediaType() == lVar) {
                arrayList.add(pVar);
            }
        }
        return arrayList;
    }

    public List<p> getResourcesByMediaTypes(l[] lVarArr) {
        ArrayList arrayList = new ArrayList();
        if (lVarArr == null) {
            return arrayList;
        }
        List listAsList = Arrays.asList(lVarArr);
        for (p pVar : getAll()) {
            if (listAsList.contains(pVar.getMediaType())) {
                arrayList.add(pVar);
            }
        }
        return arrayList;
    }

    public boolean isEmpty() {
        return this.resources.isEmpty();
    }

    public boolean notContainsByHref(String str) {
        if (c.b.a.m.f.q3(str)) {
            return true;
        }
        return !this.resources.containsKey(c.b.a.m.f.u5(str, '#'));
    }

    public p remove(String str) {
        return this.resources.remove(str);
    }

    public void set(Collection<p> collection) {
        this.resources.clear();
        addAll(collection);
    }

    public int size() {
        return this.resources.size();
    }

    public static p findFirstResourceByMediaType(Collection<p> collection, l lVar) {
        for (p pVar : collection) {
            if (pVar.getMediaType() == lVar) {
                return pVar;
            }
        }
        return null;
    }

    public void set(Map<String, p> map) {
        this.resources = new HashMap(map);
    }
}
