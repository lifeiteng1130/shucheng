package k.e.a;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: classes3.dex */
public class n {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f8885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f8888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public n f8889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f8890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public n f8891k;

    public n a() {
        j jVar = this.f8888h;
        return jVar == null ? this : jVar.f8858b;
    }

    public final void b(int i2, int i3) {
        if (this.f8885e == null) {
            this.f8885e = new int[6];
        }
        int i4 = this.f8884d;
        int[] iArr = this.f8885e;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f8885e = iArr2;
        }
        int[] iArr3 = this.f8885e;
        int i5 = this.f8884d;
        int i6 = i5 + 1;
        this.f8884d = i6;
        iArr3[i5] = i2;
        this.f8884d = i6 + 1;
        iArr3[i6] = i3;
    }

    public void c(c cVar, int i2, boolean z) {
        if ((this.a & 2) != 0) {
            if (z) {
                cVar.g(this.f8883c - i2);
                return;
            } else {
                cVar.i(this.f8883c - i2);
                return;
            }
        }
        if (z) {
            b((-1) - i2, cVar.f8818b);
            cVar.g(-1);
        } else {
            b(i2, cVar.f8818b);
            cVar.i(-1);
        }
    }

    public boolean d(int i2, byte[] bArr) {
        this.a |= 2;
        this.f8883c = i2;
        int i3 = 0;
        boolean z = false;
        while (i3 < this.f8884d) {
            int[] iArr = this.f8885e;
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i5 >= 0) {
                int i8 = i2 - i5;
                if (i8 < -32768 || i8 > 32767) {
                    int i9 = i7 - 1;
                    int i10 = bArr[i9] & ExifInterface.MARKER;
                    if (i10 <= 168) {
                        bArr[i9] = (byte) (i10 + 49);
                    } else {
                        bArr[i9] = (byte) (i10 + 20);
                    }
                    z = true;
                }
                bArr[i7] = (byte) (i8 >>> 8);
                bArr[i7 + 1] = (byte) i8;
            } else {
                int i11 = i5 + i2 + 1;
                int i12 = i7 + 1;
                bArr[i7] = (byte) (i11 >>> 24);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (i11 >>> 16);
                bArr[i13] = (byte) (i11 >>> 8);
                bArr[i13 + 1] = (byte) i11;
            }
            i3 = i6;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(k.e.a.n r10, long r11, int r13) {
        /*
            r9 = this;
            r0 = r9
        L1:
            if (r0 == 0) goto La0
            k.e.a.n r1 = r0.f8891k
            r2 = 0
            r0.f8891k = r2
            r2 = 0
            r3 = 1
            if (r10 == 0) goto L52
            int r4 = r0.a
            r5 = r4 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L13
            goto L68
        L13:
            r4 = r4 | 2048(0x800, float:2.87E-42)
            r0.a = r4
            r5 = r4 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L84
            r4 = r4 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L3a
            int r4 = r10.a
            r4 = r4 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L26
            goto L3a
        L26:
            r4 = 0
        L27:
            int[] r5 = r0.f8885e
            int r6 = r5.length
            if (r4 >= r6) goto L3a
            r5 = r5[r4]
            int[] r6 = r10.f8885e
            r6 = r6[r4]
            r5 = r5 & r6
            if (r5 == 0) goto L37
            r2 = 1
            goto L3a
        L37:
            int r4 = r4 + 1
            goto L27
        L3a:
            if (r2 != 0) goto L84
            k.e.a.h r2 = new k.e.a.h
            r2.<init>()
            int r3 = r0.f8886f
            r2.a = r3
            k.e.a.h r3 = r10.f8890j
            k.e.a.n r3 = r3.f8845b
            r2.f8845b = r3
            k.e.a.h r3 = r0.f8890j
            r2.f8846c = r3
            r0.f8890j = r2
            goto L84
        L52:
            int r4 = r0.a
            r5 = r4 & 1024(0x400, float:1.435E-42)
            r6 = 32
            if (r5 == 0) goto L66
            int[] r5 = r0.f8885e
            long r7 = r11 >>> r6
            int r8 = (int) r7
            r5 = r5[r8]
            int r7 = (int) r11
            r5 = r5 & r7
            if (r5 == 0) goto L66
            r2 = 1
        L66:
            if (r2 == 0) goto L6a
        L68:
            r0 = r1
            goto L1
        L6a:
            r2 = r4 & 1024(0x400, float:1.435E-42)
            if (r2 != 0) goto L79
            r2 = r4 | 1024(0x400, float:1.435E-42)
            r0.a = r2
            int r2 = r13 / 32
            int r2 = r2 + r3
            int[] r2 = new int[r2]
            r0.f8885e = r2
        L79:
            int[] r2 = r0.f8885e
            long r3 = r11 >>> r6
            int r4 = (int) r3
            r3 = r2[r4]
            int r5 = (int) r11
            r3 = r3 | r5
            r2[r4] = r3
        L84:
            k.e.a.h r2 = r0.f8890j
        L86:
            if (r2 == 0) goto L68
            int r3 = r0.a
            r3 = r3 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L94
            k.e.a.h r3 = r0.f8890j
            k.e.a.h r3 = r3.f8846c
            if (r2 == r3) goto L9d
        L94:
            k.e.a.n r3 = r2.f8845b
            k.e.a.n r4 = r3.f8891k
            if (r4 != 0) goto L9d
            r3.f8891k = r1
            r1 = r3
        L9d:
            k.e.a.h r2 = r2.f8846c
            goto L86
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.n.e(k.e.a.n, long, int):void");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("L");
        stringBuffer.append(System.identityHashCode(this));
        return stringBuffer.toString();
    }
}
