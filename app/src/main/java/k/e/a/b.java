package k.e.a;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f8816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f8817c;

    public b(String str) {
        this.a = str;
    }

    public final int a() {
        int i2 = 0;
        for (b bVar = this; bVar != null; bVar = bVar.f8817c) {
            i2++;
        }
        return i2;
    }

    public final int b(f fVar, byte[] bArr, int i2, int i3, int i4) {
        int length = 0;
        for (b bVar = this; bVar != null; bVar = bVar.f8817c) {
            fVar.v(bVar.a);
            length += bVar.f8816b.length + 6;
        }
        return length;
    }

    public final void c(f fVar, byte[] bArr, int i2, int i3, int i4, c cVar) {
        for (b bVar = this; bVar != null; bVar = bVar.f8817c) {
            byte[] bArr2 = bVar.f8816b;
            int length = bArr2.length;
            cVar.i(fVar.v(bVar.a));
            cVar.g(length);
            cVar.f(bArr2, 0, length);
        }
    }

    public b d(d dVar, int i2, int i3) {
        b bVar = new b(this.a);
        byte[] bArr = new byte[i3];
        bVar.f8816b = bArr;
        System.arraycopy(dVar.a, i2, bArr, 0, i3);
        return bVar;
    }
}
