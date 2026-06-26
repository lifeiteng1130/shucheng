package k.a.a.a;

import java.util.List;

/* JADX INFO: compiled from: ListTokenSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class u implements f0 {
    public final List<? extends d0> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0 f8522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e0<?> f8523d = k.a;

    public u(List<? extends d0> list) {
        this.a = list;
    }

    @Override // k.a.a.a.f0
    public int getCharPositionInLine() {
        int iLastIndexOf;
        if (this.f8521b < this.a.size()) {
            return this.a.get(this.f8521b).getCharPositionInLine();
        }
        d0 d0Var = this.f8522c;
        if (d0Var != null) {
            return d0Var.getCharPositionInLine();
        }
        if (this.a.size() <= 0) {
            return 0;
        }
        d0 d0Var2 = this.a.get(r0.size() - 1);
        String text = d0Var2.getText();
        return (text == null || (iLastIndexOf = text.lastIndexOf(10)) < 0) ? ((d0Var2.getStopIndex() + d0Var2.getCharPositionInLine()) - d0Var2.getStartIndex()) + 1 : (text.length() - iLastIndexOf) - 1;
    }

    @Override // k.a.a.a.f0
    public g getInputStream() {
        if (this.f8521b < this.a.size()) {
            return this.a.get(this.f8521b).getInputStream();
        }
        d0 d0Var = this.f8522c;
        if (d0Var != null) {
            return d0Var.getInputStream();
        }
        if (this.a.size() <= 0) {
            return null;
        }
        return this.a.get(r0.size() - 1).getInputStream();
    }

    @Override // k.a.a.a.f0
    public int getLine() {
        if (this.f8521b < this.a.size()) {
            return this.a.get(this.f8521b).getLine();
        }
        d0 d0Var = this.f8522c;
        if (d0Var != null) {
            return d0Var.getLine();
        }
        int line = 1;
        if (this.a.size() > 0) {
            d0 d0Var2 = (d0) c.a.a.a.a.E(this.a, 1);
            line = d0Var2.getLine();
            String text = d0Var2.getText();
            if (text != null) {
                for (int i2 = 0; i2 < text.length(); i2++) {
                    if (text.charAt(i2) == '\n') {
                        line++;
                    }
                }
            }
        }
        return line;
    }

    @Override // k.a.a.a.f0
    public String getSourceName() {
        g inputStream = getInputStream();
        return inputStream != null ? inputStream.getSourceName() : "List";
    }

    @Override // k.a.a.a.f0
    public e0<?> getTokenFactory() {
        return this.f8523d;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    @Override // k.a.a.a.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k.a.a.a.d0 nextToken() {
        /*
            r12 = this;
            int r0 = r12.f8521b
            java.util.List<? extends k.a.a.a.d0> r1 = r12.a
            int r1 = r1.size()
            r2 = -1
            if (r0 < r1) goto L5a
            k.a.a.a.d0 r0 = r12.f8522c
            if (r0 != 0) goto L57
            java.util.List<? extends k.a.a.a.d0> r0 = r12.a
            int r0 = r0.size()
            if (r0 <= 0) goto L2f
            java.util.List<? extends k.a.a.a.d0> r0 = r12.a
            int r1 = r0.size()
            int r1 = r1 + (-1)
            java.lang.Object r0 = r0.get(r1)
            k.a.a.a.d0 r0 = (k.a.a.a.d0) r0
            int r0 = r0.getStopIndex()
            if (r0 == r2) goto L2f
            int r0 = r0 + 1
            r8 = r0
            goto L31
        L2f:
            r0 = -1
            r8 = -1
        L31:
            int r0 = r8 + (-1)
            int r9 = java.lang.Math.max(r2, r0)
            k.a.a.a.e0<?> r0 = r12.f8523d
            k.a.a.a.m0.k r4 = new k.a.a.a.m0.k
            k.a.a.a.g r1 = r12.getInputStream()
            r4.<init>(r12, r1)
            r5 = -1
            r7 = 0
            int r10 = r12.getLine()
            int r11 = r12.getCharPositionInLine()
            r3 = r0
            k.a.a.a.k r3 = (k.a.a.a.k) r3
            java.lang.String r6 = "EOF"
            k.a.a.a.d0 r0 = r3.a(r4, r5, r6, r7, r8, r9, r10, r11)
            r12.f8522c = r0
        L57:
            k.a.a.a.d0 r0 = r12.f8522c
            return r0
        L5a:
            java.util.List<? extends k.a.a.a.d0> r0 = r12.a
            int r1 = r12.f8521b
            java.lang.Object r0 = r0.get(r1)
            k.a.a.a.d0 r0 = (k.a.a.a.d0) r0
            int r1 = r12.f8521b
            java.util.List<? extends k.a.a.a.d0> r3 = r12.a
            int r3 = r3.size()
            int r3 = r3 + (-1)
            if (r1 != r3) goto L78
            int r1 = r0.getType()
            if (r1 != r2) goto L78
            r12.f8522c = r0
        L78:
            int r1 = r12.f8521b
            int r1 = r1 + 1
            r12.f8521b = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.u.nextToken():k.a.a.a.d0");
    }

    @Override // k.a.a.a.f0
    public void setTokenFactory(e0<?> e0Var) {
        this.f8523d = e0Var;
    }
}
