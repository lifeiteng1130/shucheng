package c.e.c.y;

/* JADX INFO: compiled from: UPCEReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class q extends p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f1476h = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[][] f1477i = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f1478j = new int[4];

    @Override // c.e.c.y.p
    public boolean h(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return super.h(sb.toString());
    }

    @Override // c.e.c.y.p
    public int[] j(c.e.c.v.a aVar, int i2) {
        int[] iArr = f1476h;
        return p.m(aVar, i2, true, iArr, new int[iArr.length]);
    }

    @Override // c.e.c.y.p
    public int k(c.e.c.v.a aVar, int[] iArr, StringBuilder sb) throws c.e.c.k {
        int[] iArr2 = this.f1478j;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = aVar.f1375b;
        int i3 = iArr[1];
        int i4 = 0;
        for (int i5 = 0; i5 < 6 && i3 < i2; i5++) {
            int i6 = p.i(aVar, iArr2, i3, p.f1472d);
            sb.append((char) ((i6 % 10) + 48));
            for (int i7 : iArr2) {
                i3 += i7;
            }
            if (i6 >= 10) {
                i4 |= 1 << (5 - i5);
            }
        }
        for (int i8 = 0; i8 <= 1; i8++) {
            for (int i9 = 0; i9 < 10; i9++) {
                if (i4 == f1477i[i8][i9]) {
                    sb.insert(0, (char) (i8 + 48));
                    sb.append((char) (i9 + 48));
                    return i3;
                }
            }
        }
        throw c.e.c.k.getNotFoundInstance();
    }

    @Override // c.e.c.y.p
    public c.e.c.a o() {
        return c.e.c.a.UPC_E;
    }
}
