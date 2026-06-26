package k.e.a;

/* JADX INFO: loaded from: classes3.dex */
public class s {
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8920b;

    public s(byte[] bArr, int i2) {
        this.a = bArr;
        this.f8920b = i2;
    }

    public String toString() {
        char c2;
        byte b2 = this.a[this.f8920b];
        StringBuffer stringBuffer = new StringBuffer(b2 * 2);
        for (int i2 = 0; i2 < b2; i2++) {
            byte[] bArr = this.a;
            int i3 = this.f8920b;
            int i4 = i2 * 2;
            byte b3 = bArr[i4 + i3 + 1];
            if (b3 == 0) {
                c2 = '[';
            } else if (b3 == 1) {
                c2 = '.';
            } else if (b3 == 2) {
                c2 = '*';
            } else if (b3 != 3) {
                c2 = '_';
            } else {
                stringBuffer.append((int) bArr[i4 + i3 + 2]);
                c2 = ';';
            }
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}
