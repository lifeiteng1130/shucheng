package j$.util.stream;

/* JADX INFO: renamed from: j$.util.stream.j1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC0436j1 {
    protected final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f8218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f8219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long[] f8220d;

    protected AbstractC0436j1() {
        this.a = 4;
    }

    protected AbstractC0436j1(int i2) {
        if (i2 >= 0) {
            this.a = Math.max(4, 32 - Integer.numberOfLeadingZeros(i2 - 1));
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i2);
    }

    public abstract void clear();

    public long count() {
        int i2 = this.f8219c;
        return i2 == 0 ? this.f8218b : this.f8220d[i2] + ((long) this.f8218b);
    }

    protected int r(int i2) {
        return 1 << ((i2 == 0 || i2 == 1) ? this.a : Math.min((this.a + i2) - 1, 30));
    }
}
