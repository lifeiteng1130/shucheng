package h.a.a.a;

import java.io.Serializable;

/* JADX INFO: compiled from: ResourceReference.java */
/* JADX INFO: loaded from: classes3.dex */
public class r implements Serializable {
    private static final long serialVersionUID = 2596967243557743048L;
    public p resource;

    public r(p pVar) {
        this.resource = pVar;
    }

    public p getResource() {
        return this.resource;
    }

    public String getResourceId() {
        p pVar = this.resource;
        if (pVar != null) {
            return pVar.getId();
        }
        return null;
    }

    public void setResource(p pVar) {
        this.resource = pVar;
    }
}
