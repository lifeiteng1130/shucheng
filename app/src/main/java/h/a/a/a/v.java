package h.a.a.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: TOCReference.java */
/* JADX INFO: loaded from: classes3.dex */
public class v extends x implements Serializable {
    public static final /* synthetic */ int a = 0;
    private static final long serialVersionUID = 5787958246077042456L;
    private List<v> children;

    @Deprecated
    public v() {
        this(null, null, null);
    }

    public static Comparator<v> getComparatorByTitleIgnoreCase() {
        return a.a;
    }

    public v addChildSection(v vVar) {
        this.children.add(vVar);
        return vVar;
    }

    public List<v> getChildren() {
        return this.children;
    }

    public void setChildren(List<v> list) {
        this.children = list;
    }

    public v(String str, p pVar) {
        this(str, pVar, null);
    }

    public v(String str, p pVar, String str2) {
        this(str, pVar, str2, new ArrayList());
    }

    public v(String str, p pVar, String str2, List<v> list) {
        super(pVar, str, str2);
        this.children = list;
    }
}
