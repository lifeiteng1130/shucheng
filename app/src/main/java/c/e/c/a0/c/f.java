package c.e.c.a0.c;

/* JADX INFO: compiled from: ErrorCorrectionLevel.java */
/* JADX INFO: loaded from: classes.dex */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);

    public static final f[] a;
    private final int bits;

    static {
        f fVar = L;
        f fVar2 = M;
        f fVar3 = Q;
        a = new f[]{fVar2, fVar, H, fVar3};
    }

    f(int i2) {
        this.bits = i2;
    }

    public static f forBits(int i2) {
        if (i2 >= 0) {
            f[] fVarArr = a;
            if (i2 < fVarArr.length) {
                return fVarArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }

    public int getBits() {
        return this.bits;
    }
}
