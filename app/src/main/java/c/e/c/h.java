package c.e.c;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: InvertedLuminanceSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f1344c;

    public h(i iVar) {
        super(iVar.a, iVar.f1345b);
        this.f1344c = iVar;
    }

    @Override // c.e.c.i
    public byte[] a() {
        byte[] bArrA = this.f1344c.a();
        int i2 = this.a * this.f1345b;
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) (255 - (bArrA[i3] & ExifInterface.MARKER));
        }
        return bArr;
    }

    @Override // c.e.c.i
    public byte[] b(int i2, byte[] bArr) {
        byte[] bArrB = this.f1344c.b(i2, bArr);
        int i3 = this.a;
        for (int i4 = 0; i4 < i3; i4++) {
            bArrB[i4] = (byte) (255 - (bArrB[i4] & ExifInterface.MARKER));
        }
        return bArrB;
    }

    @Override // c.e.c.i
    public boolean c() {
        return this.f1344c.c();
    }

    @Override // c.e.c.i
    public i d() {
        return new h(this.f1344c.d());
    }
}
