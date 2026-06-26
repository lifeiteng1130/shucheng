package c.e.c.y.r;

import c.e.c.y.k;

/* JADX INFO: compiled from: AbstractRSSReader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1479b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f1482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f1483f;
    public final int[] a = new int[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f1480c = new float[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f1481d = new float[4];

    public a() {
        int[] iArr = new int[8];
        this.f1479b = iArr;
        this.f1482e = new int[iArr.length / 2];
        this.f1483f = new int[iArr.length / 2];
    }

    public static void h(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f2 = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] < f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    public static void i(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f2 = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] > f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    public static boolean j(int[] iArr) {
        float f2 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f2 >= 0.7916667f && f2 <= 0.89285713f) {
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            for (int i4 : iArr) {
                if (i4 > i3) {
                    i3 = i4;
                }
                if (i4 < i2) {
                    i2 = i4;
                }
            }
            if (i3 < i2 * 10) {
                return true;
            }
        }
        return false;
    }

    public static int k(int[] iArr, int[][] iArr2) throws c.e.c.k {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (k.e(iArr, iArr2[i2], 0.45f) < 0.2f) {
                return i2;
            }
        }
        throw c.e.c.k.getNotFoundInstance();
    }
}
