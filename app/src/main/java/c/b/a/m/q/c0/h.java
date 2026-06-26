package c.b.a.m.q.c0;

/* JADX INFO: compiled from: IntegerArrayAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class h implements a<int[]> {
    @Override // c.b.a.m.q.c0.a
    public int a() {
        return 4;
    }

    @Override // c.b.a.m.q.c0.a
    public int b(int[] iArr) {
        return iArr.length;
    }

    @Override // c.b.a.m.q.c0.a
    public String getTag() {
        return "IntegerArrayPool";
    }

    @Override // c.b.a.m.q.c0.a
    public int[] newArray(int i2) {
        return new int[i2];
    }
}
