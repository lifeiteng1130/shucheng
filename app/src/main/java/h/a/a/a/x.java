package h.a.a.a;

import java.io.Serializable;

/* JADX INFO: compiled from: TitledResourceReference.java */
/* JADX INFO: loaded from: classes3.dex */
public class x extends r implements Serializable {
    private static final long serialVersionUID = 3918155020095190080L;
    private String fragmentId;
    private String title;

    @Deprecated
    public x(p pVar) {
        this(pVar, null);
    }

    public String getCompleteHref() {
        if (c.b.a.m.f.q3(this.fragmentId)) {
            return this.resource.getHref();
        }
        return this.resource.getHref() + '#' + this.fragmentId;
    }

    public String getFragmentId() {
        return this.fragmentId;
    }

    @Override // h.a.a.a.r
    public p getResource() {
        String str;
        p pVar = this.resource;
        if (pVar != null && (str = this.title) != null) {
            pVar.setTitle(str);
        }
        return this.resource;
    }

    public String getTitle() {
        return this.title;
    }

    public void setFragmentId(String str) {
        this.fragmentId = str;
    }

    public void setResource(p pVar, String str) {
        super.setResource(pVar);
        this.fragmentId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public x(p pVar, String str) {
        this(pVar, str, null);
    }

    public x(p pVar, String str, String str2) {
        super(pVar);
        this.title = str;
        this.fragmentId = str2;
    }

    @Override // h.a.a.a.r
    public void setResource(p pVar) {
        setResource(pVar, null);
    }
}
