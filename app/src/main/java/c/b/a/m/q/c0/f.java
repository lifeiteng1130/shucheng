package c.b.a.m.q.c0;

/* JADX INFO: compiled from: ByteArrayAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements a<byte[]> {
    @Override // c.b.a.m.q.c0.a
    public int a() {
        return 1;
    }

    @Override // c.b.a.m.q.c0.a
    public int b(byte[] bArr) {
        return bArr.length;
    }

    @Override // c.b.a.m.q.c0.a
    public String getTag() {
        return "ByteArrayPool";
    }

    @Override // c.b.a.m.q.c0.a
    public byte[] newArray(int i2) {
        return new byte[i2];
    }
}
