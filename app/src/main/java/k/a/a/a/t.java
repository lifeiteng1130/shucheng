package k.a.a.a;

import java.util.Locale;

/* JADX INFO: compiled from: LexerNoViableAltException.java */
/* JADX INFO: loaded from: classes3.dex */
public class t extends a0 {
    private final k.a.a.a.k0.c deadEndConfigs;
    private final int startIndex;

    public t(s sVar, g gVar, int i2, k.a.a.a.k0.c cVar) {
        super(sVar, gVar, null);
        this.startIndex = i2;
        this.deadEndConfigs = cVar;
    }

    public k.a.a.a.k0.c getDeadEndConfigs() {
        return this.deadEndConfigs;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    @Override // java.lang.Throwable
    public String toString() {
        String strE1;
        int i2 = this.startIndex;
        if (i2 < 0 || i2 >= getInputStream().size()) {
            strE1 = "";
        } else {
            g inputStream = getInputStream();
            int i3 = this.startIndex;
            strE1 = c.b.a.m.f.E1(inputStream.f(k.a.a.a.m0.h.c(i3, i3)), false);
        }
        return String.format(Locale.getDefault(), "%s('%s')", t.class.getSimpleName(), strE1);
    }

    @Override // k.a.a.a.a0
    public g getInputStream() {
        return (g) super.getInputStream();
    }
}
