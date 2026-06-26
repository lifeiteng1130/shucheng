package c.c.a.i$b;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f755b;

    public static final int b(int[] iArr, int i2) {
        int i3 = iArr[i2 / 4];
        return (i2 % 4) / 2 == 0 ? i3 & 65535 : i3 >>> 16;
    }

    public final int a(String str) {
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 == iArr.length) {
                return -1;
            }
            int i3 = iArr[i2];
            int iB = b(this.f755b, i3);
            if (iB == str.length()) {
                int i4 = 0;
                while (i4 != iB) {
                    i3 += 2;
                    if (str.charAt(i4) != b(this.f755b, i3)) {
                        break;
                    }
                    i4++;
                }
                if (i4 == iB) {
                    return i2;
                }
            }
            i2++;
        }
    }

    public final String c(int i2) {
        int[] iArr;
        if (i2 < 0 || (iArr = this.a) == null || i2 >= iArr.length) {
            return null;
        }
        int i3 = iArr[i2];
        int iB = b(this.f755b, i3);
        StringBuilder sb = new StringBuilder(iB);
        while (iB != 0) {
            i3 += 2;
            sb.append((char) b(this.f755b, i3));
            iB--;
        }
        return sb.toString();
    }
}
