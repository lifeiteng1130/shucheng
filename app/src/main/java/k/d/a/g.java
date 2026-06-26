package k.d.a;

/* JADX INFO: compiled from: SuperBlock.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f8788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f8789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8791g;

    public g(int i2, int i3, int i4, int[] iArr) {
        this.a = i2;
        this.f8786b = i3;
        this.f8787c = i4;
        int[] iArr2 = new int[iArr.length];
        this.f8788d = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        this.f8789e = new int[0];
        this.f8790f = false;
        this.f8791g = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(int[] r10, int[] r11, int r12, k.d.a.d r13) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.d.a.g.c(int[], int[], int, k.d.a.d):boolean");
    }

    public int[] a() {
        int length = this.f8788d.length - 1;
        while (length >= 0) {
            int[] iArr = this.f8788d;
            if (iArr[length] != 0 || h.j(iArr[length - 1])) {
                break;
            }
            length--;
        }
        int i2 = length + 1;
        int i3 = 0;
        int i4 = i2;
        for (int i5 = 0; i5 < i2; i5++) {
            if (h.j(this.f8788d[i5])) {
                i4--;
            }
        }
        int[] iArr2 = new int[i4];
        int i6 = 0;
        while (i3 < i4) {
            int[] iArr3 = this.f8788d;
            iArr2[i3] = iArr3[i6];
            if (h.j(iArr3[i6])) {
                i6++;
            }
            i3++;
            i6++;
        }
        return iArr2;
    }

    public boolean b(int[] iArr, int i2, int[] iArr2, int i3, d dVar) {
        if (this.f8790f) {
            int[] iArr3 = this.f8788d;
            if (iArr3.length == i2 && this.f8789e.length == i3) {
                return c(iArr3, iArr, i2, dVar) || c(this.f8789e, iArr2, i3, dVar);
            }
            throw new IllegalArgumentException("bad merge attempt");
        }
        System.arraycopy(iArr, 0, this.f8788d, 0, i2);
        int[] iArr4 = new int[i3];
        this.f8789e = iArr4;
        System.arraycopy(iArr2, 0, iArr4, 0, i3);
        this.f8790f = true;
        return true;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("sb ");
        sbR.append(this.a);
        return sbR.toString();
    }
}
