package h.a.a.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: TableOfContents.java */
/* JADX INFO: loaded from: classes3.dex */
public class w implements Serializable {
    public static final String DEFAULT_PATH_SEPARATOR = "/";
    private static final long serialVersionUID = -3147391239966275152L;
    private List<v> tocReferences;

    public w() {
        this(new ArrayList());
    }

    public static void b(Set<String> set, List<p> list, List<v> list2) {
        for (v vVar : list2) {
            p resource = vVar.getResource();
            if (resource != null && !set.contains(resource.getHref())) {
                set.add(resource.getHref());
                list.add(resource);
            }
            b(set, list, vVar.getChildren());
        }
    }

    public static int c(Collection<v> collection) {
        int size = collection.size();
        Iterator<v> it = collection.iterator();
        while (it.hasNext()) {
            size += c(it.next().getChildren());
        }
        return size;
    }

    public final int a(List<v> list, int i2) {
        Iterator<v> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int iA = a(it.next().getChildren(), 1);
            if (iA > i3) {
                i3 = iA;
            }
        }
        return i2 + i3;
    }

    public v addSection(p pVar, String str) {
        return addSection(pVar, str, DEFAULT_PATH_SEPARATOR);
    }

    public v addTOCReference(v vVar) {
        if (this.tocReferences == null) {
            this.tocReferences = new ArrayList();
        }
        this.tocReferences.add(vVar);
        return vVar;
    }

    public int calculateDepth() {
        return a(this.tocReferences, 0);
    }

    public List<p> getAllUniqueResources() {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        b(hashSet, arrayList, this.tocReferences);
        return arrayList;
    }

    public List<v> getTocReferences() {
        return this.tocReferences;
    }

    public void setTocReferences(List<v> list) {
        this.tocReferences = list;
    }

    public int size() {
        return c(this.tocReferences);
    }

    public w(List<v> list) {
        this.tocReferences = list;
    }

    public v addSection(p pVar, String str, String str2) {
        return addSection(pVar, str.split(str2));
    }

    public v addSection(p pVar, String[] strArr) {
        v next;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<v> children = this.tocReferences;
        v vVar = null;
        for (String str : strArr) {
            Iterator<v> it = children.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (str.equals(next.getTitle())) {
                    break;
                }
            }
            if (next == null) {
                v vVar2 = new v(str, null);
                children.add(vVar2);
                vVar = vVar2;
            } else {
                vVar = next;
            }
            children = vVar.getChildren();
        }
        vVar.setResource(pVar);
        return vVar;
    }

    public v addSection(p pVar, int[] iArr, String str, String str2) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        List<v> children = this.tocReferences;
        v vVar = null;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            v vVar2 = (i3 <= 0 || i3 >= children.size() + (-1)) ? null : children.get(i3);
            if (vVar2 == null) {
                int size = children.size();
                while (size <= iArr[i2]) {
                    StringBuilder sb = new StringBuilder(str);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if (i4 > 0) {
                            sb.append(str2);
                        }
                        sb.append(iArr[i4] + 1);
                    }
                    if (i2 > 0) {
                        sb.append(str2);
                    }
                    size++;
                    sb.append(size);
                    children.add(new v(sb.toString(), null));
                }
                vVar = children.get(i3);
            } else {
                vVar = vVar2;
            }
            children = vVar.getChildren();
        }
        vVar.setResource(pVar);
        return vVar;
    }
}
