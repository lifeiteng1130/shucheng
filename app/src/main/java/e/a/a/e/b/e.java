package e.a.a.e.b;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: CharsetRecog_Unicode.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends h {

    /* JADX INFO: compiled from: CharsetRecog_Unicode.java */
    public static class a extends e {
        @Override // e.a.a.e.b.h
        public String b() {
            return "UTF-16BE";
        }

        @Override // e.a.a.e.b.h
        public e.a.a.e.b.b c(e.a.a.e.b.a aVar) {
            byte[] bArr = aVar.f5605f;
            int iMin = Math.min(bArr.length, 30);
            int iD = 10;
            int i2 = 0;
            while (true) {
                if (i2 >= iMin - 1) {
                    break;
                }
                int i3 = ((bArr[i2] & ExifInterface.MARKER) << 8) | (bArr[i2 + 1] & ExifInterface.MARKER);
                if (i2 == 0 && i3 == 65279) {
                    iD = 100;
                    break;
                }
                iD = e.d(i3, iD);
                if (iD == 0 || iD == 100) {
                    break;
                }
                i2 += 2;
            }
            int i4 = (iMin >= 4 || iD >= 100) ? iD : 0;
            if (i4 > 0) {
                return new e.a.a.e.b.b(aVar, this, i4);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: CharsetRecog_Unicode.java */
    public static class b extends e {
        @Override // e.a.a.e.b.h
        public String b() {
            return "UTF-16LE";
        }

        @Override // e.a.a.e.b.h
        public e.a.a.e.b.b c(e.a.a.e.b.a aVar) {
            byte[] bArr = aVar.f5605f;
            int iMin = Math.min(bArr.length, 30);
            int iD = 10;
            int i2 = 0;
            while (true) {
                if (i2 >= iMin - 1) {
                    break;
                }
                int i3 = ((bArr[i2 + 1] & ExifInterface.MARKER) << 8) | (bArr[i2] & ExifInterface.MARKER);
                if (i2 == 0 && i3 == 65279) {
                    iD = 100;
                    break;
                }
                iD = e.d(i3, iD);
                if (iD == 0 || iD == 100) {
                    break;
                }
                i2 += 2;
            }
            int i4 = (iMin >= 4 || iD >= 100) ? iD : 0;
            if (i4 > 0) {
                return new e.a.a.e.b.b(aVar, this, i4);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: CharsetRecog_Unicode.java */
    public static abstract class c extends e {
        /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x004d  */
        @Override // e.a.a.e.b.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public e.a.a.e.b.b c(e.a.a.e.b.a r11) {
            /*
                r10 = this;
                byte[] r0 = r11.f5605f
                int r1 = r11.f5606g
                int r1 = r1 / 4
                int r1 = r1 * 4
                r2 = 0
                if (r1 != 0) goto Lc
                return r2
            Lc:
                r3 = 0
                int r4 = r10.e(r0, r3)
                r5 = 65279(0xfeff, float:9.1475E-41)
                if (r4 != r5) goto L18
                r4 = 1
                goto L19
            L18:
                r4 = 0
            L19:
                r5 = 0
                r6 = 0
                r7 = 0
            L1c:
                if (r5 >= r1) goto L3c
                int r8 = r10.e(r0, r5)
                if (r8 < 0) goto L37
                r9 = 1114111(0x10ffff, float:1.561202E-39)
                if (r8 >= r9) goto L37
                r9 = 55296(0xd800, float:7.7486E-41)
                if (r8 < r9) goto L34
                r9 = 57343(0xdfff, float:8.0355E-41)
                if (r8 > r9) goto L34
                goto L37
            L34:
                int r7 = r7 + 1
                goto L39
            L37:
                int r6 = r6 + 1
            L39:
                int r5 = r5 + 4
                goto L1c
            L3c:
                r0 = 80
                r1 = 100
                if (r4 == 0) goto L47
                if (r6 != 0) goto L47
            L44:
                r3 = 100
                goto L61
            L47:
                if (r4 == 0) goto L50
                int r4 = r6 * 10
                if (r7 <= r4) goto L50
            L4d:
                r3 = 80
                goto L61
            L50:
                r4 = 3
                if (r7 <= r4) goto L56
                if (r6 != 0) goto L56
                goto L44
            L56:
                if (r7 <= 0) goto L5b
                if (r6 != 0) goto L5b
                goto L4d
            L5b:
                int r6 = r6 * 10
                if (r7 <= r6) goto L61
                r3 = 25
            L61:
                if (r3 != 0) goto L64
                goto L69
            L64:
                e.a.a.e.b.b r2 = new e.a.a.e.b.b
                r2.<init>(r11, r10, r3)
            L69:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: e.a.a.e.b.e.c.c(e.a.a.e.b.a):e.a.a.e.b.b");
        }

        public abstract int e(byte[] bArr, int i2);
    }

    /* JADX INFO: compiled from: CharsetRecog_Unicode.java */
    public static class d extends c {
        @Override // e.a.a.e.b.h
        public String b() {
            return "UTF-32BE";
        }

        @Override // e.a.a.e.b.e.c
        public int e(byte[] bArr, int i2) {
            return (bArr[i2 + 3] & ExifInterface.MARKER) | ((bArr[i2 + 0] & ExifInterface.MARKER) << 24) | ((bArr[i2 + 1] & ExifInterface.MARKER) << 16) | ((bArr[i2 + 2] & ExifInterface.MARKER) << 8);
        }
    }

    /* JADX INFO: renamed from: e.a.a.e.b.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CharsetRecog_Unicode.java */
    public static class C0154e extends c {
        @Override // e.a.a.e.b.h
        public String b() {
            return "UTF-32LE";
        }

        @Override // e.a.a.e.b.e.c
        public int e(byte[] bArr, int i2) {
            return (bArr[i2 + 0] & ExifInterface.MARKER) | ((bArr[i2 + 3] & ExifInterface.MARKER) << 24) | ((bArr[i2 + 2] & ExifInterface.MARKER) << 16) | ((bArr[i2 + 1] & ExifInterface.MARKER) << 8);
        }
    }

    public static int d(int i2, int i3) {
        if (i2 == 0) {
            i3 -= 10;
        } else if ((i2 >= 32 && i2 <= 255) || i2 == 10) {
            i3 += 10;
        }
        if (i3 < 0) {
            return 0;
        }
        if (i3 > 100) {
            return 100;
        }
        return i3;
    }
}
