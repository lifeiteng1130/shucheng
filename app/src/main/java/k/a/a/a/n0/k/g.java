package k.a.a.a.n0.k;

import k.a.a.a.j;

/* JADX INFO: compiled from: TokenTagToken.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends j {
    private final String label;
    private final String tokenName;

    public g(String str, int i2) {
        this(str, i2, null);
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // k.a.a.a.j, k.a.a.a.d0
    public String getText() {
        if (this.label == null) {
            return c.a.a.a.a.p(c.a.a.a.a.r("<"), this.tokenName, ">");
        }
        StringBuilder sbR = c.a.a.a.a.r("<");
        sbR.append(this.label);
        sbR.append(":");
        return c.a.a.a.a.p(sbR, this.tokenName, ">");
    }

    public final String getTokenName() {
        return this.tokenName;
    }

    @Override // k.a.a.a.j
    public String toString() {
        return this.tokenName + ":" + this.type;
    }

    public g(String str, int i2, String str2) {
        super(i2);
        this.tokenName = str;
        this.label = str2;
    }
}
