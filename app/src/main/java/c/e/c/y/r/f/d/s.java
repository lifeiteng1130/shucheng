package c.e.c.y.r.f.d;

/* JADX INFO: compiled from: GeneralAppIdDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class s {
    public final c.e.c.v.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f1520b = new m();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f1521c = new StringBuilder();

    public s(c.e.c.v.a aVar) {
        this.a = aVar;
    }

    public static int d(c.e.c.v.a aVar, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (aVar.e(i2 + i5)) {
                i4 |= 1 << ((i3 - i5) - 1);
            }
        }
        return i4;
    }

    public String a(StringBuilder sb, int i2) throws c.e.c.k, c.e.c.g {
        String str = null;
        while (true) {
            o oVarB = b(i2, str);
            String strA = r.a(oVarB.f1511b);
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = oVarB.f1513d ? String.valueOf(oVarB.f1512c) : null;
            int i3 = oVarB.a;
            if (i2 == i3) {
                return sb.toString();
            }
            i2 = i3;
            str = strValueOf;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x029a, code lost:
    
        r1 = r3.f1508b;
     */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0255 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x036b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c.e.c.y.r.f.d.o b(int r17, java.lang.String r18) throws c.e.c.g {
        /*
            Method dump skipped, instruction units count: 1048
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.y.r.f.d.s.b(int, java.lang.String):c.e.c.y.r.f.d.o");
    }

    public int c(int i2, int i3) {
        return d(this.a, i2, i3);
    }

    public final boolean e(int i2) {
        int i3 = i2 + 3;
        if (i3 > this.a.f1375b) {
            return false;
        }
        while (i2 < i3) {
            if (this.a.e(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public final boolean f(int i2) {
        if (i2 + 1 > this.a.f1375b) {
            return false;
        }
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = i3 + i2;
            c.e.c.v.a aVar = this.a;
            if (i4 >= aVar.f1375b) {
                return true;
            }
            if (i3 == 2) {
                if (!aVar.e(i2 + 2)) {
                    return false;
                }
            } else if (aVar.e(i4)) {
                return false;
            }
        }
        return true;
    }
}
