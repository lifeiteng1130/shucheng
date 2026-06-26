package h.a.a.a;

import java.io.Serializable;

/* JADX INFO: compiled from: SpineReference.java */
/* JADX INFO: loaded from: classes3.dex */
public class u extends r implements Serializable {
    private static final long serialVersionUID = -7921609197351510248L;
    private boolean linear;

    public u(p pVar) {
        this(pVar, true);
    }

    public boolean isLinear() {
        return this.linear;
    }

    public void setLinear(boolean z) {
        this.linear = z;
    }

    public u(p pVar, boolean z) {
        super(pVar);
        this.linear = z;
    }
}
