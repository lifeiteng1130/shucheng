package k.a.a.a.n0.k;

import k.a.a.a.d0;
import k.a.a.a.f0;

/* JADX INFO: compiled from: RuleTagToken.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements d0 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8519c;

    public d(String str, int i2, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("ruleName cannot be null or empty.");
        }
        this.a = str;
        this.f8518b = i2;
        this.f8519c = str2;
    }

    @Override // k.a.a.a.d0
    public int getChannel() {
        return 0;
    }

    @Override // k.a.a.a.d0
    public int getCharPositionInLine() {
        return -1;
    }

    @Override // k.a.a.a.d0
    public k.a.a.a.g getInputStream() {
        return null;
    }

    @Override // k.a.a.a.d0
    public int getLine() {
        return 0;
    }

    @Override // k.a.a.a.d0
    public int getStartIndex() {
        return -1;
    }

    @Override // k.a.a.a.d0
    public int getStopIndex() {
        return -1;
    }

    @Override // k.a.a.a.d0
    public String getText() {
        if (this.f8519c == null) {
            return c.a.a.a.a.p(c.a.a.a.a.r("<"), this.a, ">");
        }
        StringBuilder sbR = c.a.a.a.a.r("<");
        sbR.append(this.f8519c);
        sbR.append(":");
        return c.a.a.a.a.p(sbR, this.a, ">");
    }

    @Override // k.a.a.a.d0
    public int getTokenIndex() {
        return -1;
    }

    @Override // k.a.a.a.d0
    public f0 getTokenSource() {
        return null;
    }

    @Override // k.a.a.a.d0
    public int getType() {
        return this.f8518b;
    }

    public String toString() {
        return this.a + ":" + this.f8518b;
    }
}
