package e.a.a.e.b;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: CharsetRecog_2022.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends h {

    /* JADX INFO: compiled from: CharsetRecog_2022.java */
    public static class a extends c {
        public byte[][] a = {new byte[]{27, 36, 41, 65}, new byte[]{27, 36, 41, 71}, new byte[]{27, 36, ExifInterface.START_CODE, 72}, new byte[]{27, 36, 41, 69}, new byte[]{27, 36, 43, 73}, new byte[]{27, 36, 43, 74}, new byte[]{27, 36, 43, 75}, new byte[]{27, 36, 43, 76}, new byte[]{27, 36, 43, 77}, new byte[]{27, 78}, new byte[]{27, 79}};

        @Override // e.a.a.e.b.h
        public String b() {
            return "ISO-2022-CN";
        }

        @Override // e.a.a.e.b.h
        public e.a.a.e.b.b c(e.a.a.e.b.a aVar) {
            int iD = d(aVar.f5601b, aVar.f5602c, this.a);
            if (iD == 0) {
                return null;
            }
            return new e.a.a.e.b.b(aVar, this, iD);
        }
    }

    /* JADX INFO: compiled from: CharsetRecog_2022.java */
    public static class b extends c {
        public byte[][] a = {new byte[]{27, 36, 40, 67}, new byte[]{27, 36, 40, 68}, new byte[]{27, 36, 64}, new byte[]{27, 36, 65}, new byte[]{27, 36, 66}, new byte[]{27, 38, 64}, new byte[]{27, 40, 66}, new byte[]{27, 40, 72}, new byte[]{27, 40, 73}, new byte[]{27, 40, 74}, new byte[]{27, 46, 65}, new byte[]{27, 46, 70}};

        @Override // e.a.a.e.b.h
        public String b() {
            return "ISO-2022-JP";
        }

        @Override // e.a.a.e.b.h
        public e.a.a.e.b.b c(e.a.a.e.b.a aVar) {
            int iD = d(aVar.f5601b, aVar.f5602c, this.a);
            if (iD == 0) {
                return null;
            }
            return new e.a.a.e.b.b(aVar, this, iD);
        }
    }

    /* JADX INFO: renamed from: e.a.a.e.b.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CharsetRecog_2022.java */
    public static class C0153c extends c {
        public byte[][] a = {new byte[]{27, 36, 41, 67}};

        @Override // e.a.a.e.b.h
        public String b() {
            return "ISO-2022-KR";
        }

        @Override // e.a.a.e.b.h
        public e.a.a.e.b.b c(e.a.a.e.b.a aVar) {
            int iD = d(aVar.f5601b, aVar.f5602c, this.a);
            if (iD == 0) {
                return null;
            }
            return new e.a.a.e.b.b(aVar, this, iD);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int d(byte[] r12, int r13, byte[][] r14) {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
        L5:
            if (r1 >= r13) goto L44
            r5 = r12[r1]
            r6 = 27
            r7 = 1
            if (r5 != r6) goto L34
            r5 = 0
        Lf:
            int r6 = r14.length
            if (r5 >= r6) goto L32
            r6 = r14[r5]
            int r8 = r13 - r1
            int r9 = r6.length
            if (r8 >= r9) goto L1a
            goto L26
        L1a:
            r8 = 1
        L1b:
            int r9 = r6.length
            if (r8 >= r9) goto L2c
            r9 = r6[r8]
            int r10 = r1 + r8
            r10 = r12[r10]
            if (r9 == r10) goto L29
        L26:
            int r5 = r5 + 1
            goto Lf
        L29:
            int r8 = r8 + 1
            goto L1b
        L2c:
            int r2 = r2 + 1
            int r5 = r6.length
            int r5 = r5 - r7
            int r1 = r1 + r5
            goto L42
        L32:
            int r3 = r3 + 1
        L34:
            r5 = r12[r1]
            r6 = 14
            if (r5 == r6) goto L40
            r5 = r12[r1]
            r6 = 15
            if (r5 != r6) goto L42
        L40:
            int r4 = r4 + 1
        L42:
            int r1 = r1 + r7
            goto L5
        L44:
            if (r2 != 0) goto L47
            return r0
        L47:
            int r12 = r2 * 100
            int r13 = r3 * 100
            int r12 = r12 - r13
            int r3 = r3 + r2
            int r12 = r12 / r3
            int r2 = r2 + r4
            r13 = 5
            if (r2 >= r13) goto L56
            int r13 = r13 - r2
            int r13 = r13 * 10
            int r12 = r12 - r13
        L56:
            if (r12 >= 0) goto L59
            goto L5a
        L59:
            r0 = r12
        L5a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.e.b.c.d(byte[], int, byte[][]):int");
    }
}
