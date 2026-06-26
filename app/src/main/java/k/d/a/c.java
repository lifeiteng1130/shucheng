package k.d.a;

import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.UintMap;

/* JADX INFO: compiled from: ClassFileWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f8749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f8750c;
    public int A;
    public long[] B;
    public int C;
    public ObjArray D;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e[] f8755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f8757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8758k;
    public int m;
    public d n;
    public k.d.a.b o;
    public short p;
    public short q;
    public short r;
    public short v;
    public short w;
    public short x;
    public short y;
    public int[] z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f8751d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8752e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UintMap f8753f = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f8759l = new byte[256];
    public ObjArray s = new ObjArray();
    public ObjArray t = new ObjArray();
    public ObjArray u = new ObjArray();
    public char[] E = new char[64];

    /* JADX INFO: compiled from: ClassFileWriter.java */
    public static class a extends RuntimeException {
        private static final long serialVersionUID = 1263998431033790599L;

        public a(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: ClassFileWriter.java */
    public final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public g[] f8765g = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f8761c = null;
        public int[] a = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public g[] f8763e = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public byte[] f8766h = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8760b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8762d = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8764f = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8767i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f8768j = false;

        public b() {
        }

        public final void a(g gVar) {
            if (gVar.f8791g) {
                return;
            }
            gVar.f8791g = true;
            gVar.f8790f = true;
            int i2 = this.f8764f;
            g[] gVarArr = this.f8763e;
            if (i2 == gVarArr.length) {
                g[] gVarArr2 = new g[i2 * 2];
                System.arraycopy(gVarArr, 0, gVarArr2, 0, i2);
                this.f8763e = gVarArr2;
            }
            g[] gVarArr3 = this.f8763e;
            int i3 = this.f8764f;
            this.f8764f = i3 + 1;
            gVarArr3[i3] = gVar;
        }

        public final void b(int i2) {
            int i3 = i2 < this.f8760b ? this.a[i2] : 0;
            int i4 = i3 & 255;
            if (i4 != 7 && i4 != 6 && i4 != 8 && i4 != 5) {
                throw new IllegalStateException(c.a.a.a.a.e("bad local variable type: ", i3, " at index: ", i2));
            }
            i(i3);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:152:0x0420  */
        /* JADX WARN: Removed duplicated region for block: B:165:0x0445  */
        /* JADX WARN: Removed duplicated region for block: B:166:0x0448  */
        /* JADX WARN: Removed duplicated region for block: B:167:0x044b  */
        /* JADX WARN: Removed duplicated region for block: B:168:0x044e  */
        /* JADX WARN: Removed duplicated region for block: B:171:0x0454  */
        /* JADX WARN: Removed duplicated region for block: B:175:0x045e  */
        /* JADX WARN: Removed duplicated region for block: B:177:0x0463 A[FALL_THROUGH] */
        /* JADX WARN: Removed duplicated region for block: B:179:0x0466  */
        /* JADX WARN: Removed duplicated region for block: B:184:0x048a  */
        /* JADX WARN: Removed duplicated region for block: B:192:0x04cd  */
        /* JADX WARN: Removed duplicated region for block: B:215:0x053d  */
        /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
            java.lang.UnsupportedOperationException
            	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1067)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
            	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1092)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
            */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c() {
            /*
                Method dump skipped, instruction units count: 2254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: k.d.a.c.b.c():void");
        }

        public final void d(g gVar) {
            if (gVar.b(this.a, this.f8760b, this.f8761c, this.f8762d, c.this.n)) {
                a(gVar);
            }
        }

        public final int e(int i2, int i3) {
            if (i3 > 4) {
                throw new IllegalArgumentException("bad operand size");
            }
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                i4 = (i4 << 8) | (c.this.f8759l[i2 + i5] & ExifInterface.MARKER);
            }
            return i4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        
            throw new java.lang.IllegalArgumentException(c.a.a.a.a.G("bad offset: ", r4));
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final k.d.a.g f(int r4) {
            /*
                r3 = this;
                r0 = 0
            L1:
                k.d.a.g[] r1 = r3.f8765g
                int r2 = r1.length
                if (r0 >= r2) goto L16
                r1 = r1[r0]
                if (r1 == 0) goto L16
                int r2 = r1.f8786b
                if (r4 < r2) goto L13
                int r2 = r1.f8787c
                if (r4 >= r2) goto L13
                return r1
            L13:
                int r0 = r0 + 1
                goto L1
            L16:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "bad offset: "
                java.lang.String r4 = c.a.a.a.a.G(r1, r4)
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: k.d.a.c.b.f(int):k.d.a.g");
        }

        public final int g() {
            int[] iArr = this.f8761c;
            int i2 = this.f8762d - 1;
            this.f8762d = i2;
            return iArr[i2];
        }

        public final long h() {
            long jG = g();
            return h.j((int) jG) ? jG : (jG << 32) | ((long) (g() & ViewCompat.MEASURED_SIZE_MASK));
        }

        public final void i(int i2) {
            int i3 = this.f8762d;
            if (i3 == this.f8761c.length) {
                int[] iArr = new int[Math.max(i3 * 2, 4)];
                System.arraycopy(this.f8761c, 0, iArr, 0, this.f8762d);
                this.f8761c = iArr;
            }
            int[] iArr2 = this.f8761c;
            int i4 = this.f8762d;
            this.f8762d = i4 + 1;
            iArr2[i4] = i2;
        }

        public final void j(long j2) {
            i((int) (j2 & 16777215));
            long j3 = j2 >>> 32;
            if (j3 != 0) {
                i((int) (j3 & 16777215));
            }
        }

        public final void k(int i2, int i3) {
            int i4 = this.f8760b;
            if (i2 >= i4) {
                int i5 = i2 + 1;
                int[] iArr = new int[i5];
                System.arraycopy(this.a, 0, iArr, 0, i4);
                this.a = iArr;
                this.f8760b = i5;
            }
            this.a[i2] = i3;
        }

        public final void l(int[] iArr, int[] iArr2, int i2) {
            byte[] bArr = this.f8766h;
            int i3 = this.f8767i;
            int i4 = i3 + 1;
            this.f8767i = i4;
            bArr[i3] = -1;
            int iL = c.L(i2, bArr, i4);
            this.f8767i = iL;
            this.f8767i = c.L(iArr.length, this.f8766h, iL);
            int iN = n(iArr);
            this.f8767i = iN;
            this.f8767i = c.L(iArr2.length, this.f8766h, iN);
            this.f8767i = n(iArr2);
        }

        public final int m(int i2) {
            int i3 = i2 & 255;
            byte[] bArr = this.f8766h;
            int i4 = this.f8767i;
            int i5 = i4 + 1;
            this.f8767i = i5;
            bArr[i4] = (byte) i3;
            if (i3 == 7 || i3 == 8) {
                this.f8767i = c.L(i2 >>> 8, bArr, i5);
            }
            return this.f8767i;
        }

        public final int n(int[] iArr) {
            for (int i2 : iArr) {
                this.f8767i = m(i2);
            }
            return this.f8767i;
        }
    }

    static {
        int i2;
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = c.class.getResourceAsStream("ClassFileWriter.class");
            if (resourceAsStream == null) {
                resourceAsStream = ClassLoader.getSystemResourceAsStream("org/mozilla/classfile/ClassFileWriter.class");
            }
            byte[] bArr = new byte[8];
            int i3 = 0;
            while (i3 < 8) {
                int i4 = resourceAsStream.read(bArr, i3, 8 - i3);
                if (i4 < 0) {
                    throw new IOException();
                }
                i3 += i4;
            }
            i2 = (bArr[4] << 8) | (bArr[5] & ExifInterface.MARKER);
            try {
                int i5 = (bArr[7] & ExifInterface.MARKER) | (bArr[6] << 8);
                f8749b = i2;
                a = i5;
                f8750c = i5 >= 50;
                if (resourceAsStream == null) {
                    return;
                }
            } catch (Exception unused) {
                f8749b = i2;
                a = 48;
                f8750c = false;
                if (resourceAsStream == null) {
                    return;
                }
            } catch (Throwable th) {
                th = th;
                f8749b = i2;
                a = 48;
                f8750c = false;
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            i2 = 0;
        } catch (Throwable th2) {
            th = th2;
            i2 = 0;
        }
        try {
            resourceAsStream.close();
        } catch (IOException unused4) {
        }
    }

    public c(String str, String str2, String str3) {
        this.f8754g = str;
        d dVar = new d(this);
        this.n = dVar;
        this.w = dVar.a(str);
        this.x = this.n.a(str2);
        if (str3 != null) {
            this.y = this.n.c(str3);
        }
        this.v = (short) 33;
    }

    public static void D(int i2) {
        throw new IllegalStateException(i2 < 0 ? c.a.a.a.a.G("Stack underflow: ", i2) : c.a.a.a.a.G("Too big stack: ", i2));
    }

    public static String E(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            return str;
        }
        if (cCharAt == 'L') {
            return c.a.a.a.a.c(str, 1, 1);
        }
        if (cCharAt == 'S' || cCharAt == 'V' || cCharAt == 'I' || cCharAt == 'J' || cCharAt == 'Z' || cCharAt == '[') {
            return str;
        }
        switch (cCharAt) {
            case 'B':
            case 'C':
            case 'D':
                return str;
            default:
                throw new IllegalArgumentException(c.a.a.a.a.i("bad descriptor:", str));
        }
    }

    public static int L(int i2, byte[] bArr, int i3) {
        bArr[i3 + 0] = (byte) (i2 >>> 8);
        bArr[i3 + 1] = (byte) i2;
        return i3 + 2;
    }

    public static int M(int i2, byte[] bArr, int i3) {
        bArr[i3 + 0] = (byte) (i2 >>> 24);
        bArr[i3 + 1] = (byte) (i2 >>> 16);
        bArr[i3 + 2] = (byte) (i2 >>> 8);
        bArr[i3 + 3] = (byte) i2;
        return i3 + 4;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4 A[FALL_THROUGH, PHI: r5
  0x00a4: PHI (r5v3 int) = (r5v2 int), (r5v2 int), (r5v2 int), (r5v2 int), (r5v7 int), (r5v2 int), (r5v2 int), (r5v2 int) binds: [B:45:0x008c, B:46:0x008e, B:47:0x0090, B:50:0x0096, B:56:0x00a2, B:52:0x009a, B:53:0x009c, B:54:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int O(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.d.a.c.O(java.lang.String):int");
    }

    public static int P(int i2) {
        if (i2 == 254 || i2 == 255) {
            return 0;
        }
        switch (i2) {
            case 0:
            case 47:
            case 49:
            case 95:
            case 116:
            case 117:
            case 118:
            case 119:
            case Token.TARGET /* 132 */:
            case Token.EXPR_VOID /* 134 */:
            case Token.TYPEOFNAME /* 138 */:
            case Token.USE_STACK /* 139 */:
            case Token.SET_REF_OP /* 143 */:
            case Token.COLONCOLON /* 145 */:
            case Token.XML /* 146 */:
            case Token.DOTQUERY /* 147 */:
            case Token.LAST_TOKEN /* 167 */:
            case 169:
            case 177:
            case 178:
            case 179:
            case TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT /* 184 */:
            case 186:
            case 188:
            case 189:
            case 190:
            case 192:
            case 193:
            case 196:
            case 200:
            case 202:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 23:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 44:
            case 45:
            case 89:
            case 90:
            case 91:
            case Token.LOOP /* 133 */:
            case Token.EXPR_RESULT /* 135 */:
            case 140:
            case Token.SETELEM_OP /* 141 */:
            case 168:
            case 187:
            case 197:
            case 201:
                return 1;
            case 9:
            case 10:
            case 14:
            case 15:
            case 20:
            case 22:
            case 24:
            case 30:
            case 31:
            case 32:
            case 33:
            case 38:
            case 39:
            case 40:
            case 41:
            case 92:
            case 93:
            case 94:
                return 2;
            case 46:
            case 48:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 56:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 67:
            case 68:
            case 69:
            case 70:
            case 75:
            case 76:
            case 77:
            case 78:
            case 87:
            case 96:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 108:
            case 110:
            case 112:
            case 114:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case Token.CATCH /* 125 */:
            case 126:
            case 128:
            case 130:
            case Token.JSR /* 136 */:
            case Token.SCRIPT /* 137 */:
            case Token.LOCAL_BLOCK /* 142 */:
            case Token.DOTDOT /* 144 */:
            case Token.XMLEND /* 149 */:
            case 150:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case Context.VERSION_1_7 /* 170 */:
            case 171:
            case 172:
            case 174:
            case 176:
            case 180:
            case TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT /* 181 */:
            case TinkerReport.KEY_APPLIED_DEX_EXTRACT /* 182 */:
            case TinkerReport.KEY_APPLIED_LIB_EXTRACT /* 183 */:
            case 185:
            case 191:
            case 194:
            case 195:
            case 198:
            case 199:
                return -1;
            case 55:
            case 57:
            case 63:
            case 64:
            case 65:
            case 66:
            case 71:
            case 72:
            case 73:
            case 74:
            case 88:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 107:
            case 109:
            case 111:
            case 113:
            case 115:
            case 127:
            case Token.EMPTY /* 129 */:
            case Token.LABEL /* 131 */:
            case Token.LETEXPR /* 159 */:
            case 160:
            case Token.DEBUGGER /* 161 */:
            case Token.COMMENT /* 162 */:
            case Token.GENEXPR /* 163 */:
            case Token.METHOD /* 164 */:
            case Token.ARROW /* 165 */:
            case 166:
            case 173:
            case 175:
                return -2;
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
            case Token.XMLATTR /* 148 */:
            case 151:
            case 152:
                return -3;
            case 80:
            case 82:
                return -4;
            default:
                throw new IllegalArgumentException(c.a.a.a.a.G("Bad opcode: ", i2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] a(k.d.a.c r10) {
        /*
            short r0 = r10.r
            int[] r0 = new int[r0]
            k.d.a.b r1 = r10.o
            short r2 = r1.f8747e
            r2 = r2 & 8
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L26
            java.lang.String r1 = r1.a
            java.lang.String r2 = "<init>"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L1c
            r1 = 6
            r0[r3] = r1
            goto L24
        L1c:
            short r1 = r10.w
            int r1 = k.d.a.h.a(r1)
            r0[r3] = r1
        L24:
            r1 = 1
            goto L27
        L26:
            r1 = 0
        L27:
            k.d.a.b r2 = r10.o
            java.lang.String r2 = r2.f8744b
            r5 = 40
            int r5 = r2.indexOf(r5)
            r6 = 41
            int r6 = r2.indexOf(r6)
            if (r5 != 0) goto La6
            if (r6 < 0) goto La6
            int r5 = r5 + r4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
        L41:
            if (r5 >= r6) goto La5
            char r8 = r2.charAt(r5)
            r9 = 70
            if (r8 == r9) goto L7d
            r9 = 76
            if (r8 == r9) goto L6d
            r9 = 83
            if (r8 == r9) goto L7d
            r9 = 73
            if (r8 == r9) goto L7d
            r9 = 74
            if (r8 == r9) goto L7d
            r9 = 90
            if (r8 == r9) goto L7d
            r9 = 91
            if (r8 == r9) goto L67
            switch(r8) {
                case 66: goto L7d;
                case 67: goto L7d;
                case 68: goto L7d;
                default: goto L66;
            }
        L66:
            goto L86
        L67:
            r7.append(r9)
            int r5 = r5 + 1
            goto L41
        L6d:
            r8 = 59
            int r8 = r2.indexOf(r8, r5)
            int r8 = r8 + r4
            java.lang.String r5 = r2.substring(r5, r8)
            r7.append(r5)
            r5 = r8
            goto L86
        L7d:
            char r8 = r2.charAt(r5)
            r7.append(r8)
            int r5 = r5 + 1
        L86:
            java.lang.String r8 = r7.toString()
            java.lang.String r8 = E(r8)
            k.d.a.d r9 = r10.n
            int r8 = k.d.a.h.f(r8, r9)
            int r9 = r1 + 1
            r0[r1] = r8
            boolean r1 = k.d.a.h.j(r8)
            if (r1 == 0) goto La0
            int r9 = r9 + 1
        La0:
            r1 = r9
            r7.setLength(r3)
            goto L41
        La5:
            return r0
        La6:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "bad method type"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: k.d.a.c.a(k.d.a.c):int[]");
    }

    public final void A(int i2) {
        L(i2, this.f8759l, w(2));
    }

    public void B(String str, String str2, int i2, int i3) {
        int[] iArr = {this.n.c(str), this.n.c(str2), i2, i3};
        if (this.D == null) {
            this.D = new ObjArray();
        }
        this.D.add(iArr);
    }

    public void C(int i2) {
        int i3 = this.p + i2;
        if (i3 < 0 || 32767 < i3) {
            D(i3);
            throw null;
        }
        short s = (short) i3;
        this.p = s;
        if (i3 > this.q) {
            this.q = s;
        }
    }

    public int F(int i2) {
        if (i2 >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i3 = i2 & Integer.MAX_VALUE;
        if (i3 < this.A) {
            return this.z[i3];
        }
        throw new IllegalArgumentException("Bad label");
    }

    public void G(int i2) {
        this.p = (short) 1;
        H(i2);
    }

    public void H(int i2) {
        if (i2 >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i3 = i2 & Integer.MAX_VALUE;
        if (i3 > this.A) {
            throw new IllegalArgumentException("Bad label");
        }
        int[] iArr = this.z;
        if (iArr[i3] != -1) {
            throw new IllegalStateException("Can only mark label once");
        }
        iArr[i3] = this.m;
    }

    public final void I(int i2, int i3) {
        x(this.m);
        this.f8753f.put(this.m, i2);
        N(i2, i3, this.m);
    }

    public final void J(int i2, int i3, int i4) {
        if (i4 < 0 || i4 > this.q) {
            throw new IllegalArgumentException(c.a.a.a.a.G("Bad stack index: ", i4));
        }
        this.p = (short) i4;
        x(this.m);
        this.f8753f.put(this.m, i2);
        N(i2, i3, this.m);
    }

    public final void K(int i2) {
        x(this.m);
        this.f8753f.put(this.m, i2);
        N(i2, -1, this.m);
    }

    public void N(int i2, int i3, int i4) {
        int i5;
        if (i4 < 0 || (i5 = this.m) < i4) {
            throw new IllegalArgumentException(c.a.a.a.a.G("Bad jump target: ", i4));
        }
        if (i3 < -1) {
            throw new IllegalArgumentException(c.a.a.a.a.G("Bad case index: ", i3));
        }
        int i6 = i2 + 1 + ((~i2) & 3);
        if (i3 >= 0) {
            i6 += (i3 + 3) * 4;
        }
        if (i2 < 0 || ((i5 - 16) - r1) - 1 < i2) {
            throw new IllegalArgumentException(i2 + " is outside a possible range of tableswitch in already generated code");
        }
        byte[] bArr = this.f8759l;
        if ((bArr[i2] & ExifInterface.MARKER) != 170) {
            throw new IllegalArgumentException(i2 + " is not offset of tableswitch statement");
        }
        if (i6 < 0 || i5 < i6 + 4) {
            throw new a(c.a.a.a.a.G("Too big case index: ", i3));
        }
        M(i4 - i2, bArr, i6);
    }

    public void Q(String str, String str2, short s) {
        this.o = new k.d.a.b(str, this.n.c(str), str2, this.n.c(str2), s);
        this.f8753f = new UintMap();
        this.s.add(this.o);
        x(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x02de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void R(short r17) {
        /*
            Method dump skipped, instruction units count: 1139
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.d.a.c.R(short):void");
    }

    public byte[] S() {
        short sC;
        int i2;
        if (this.y != 0) {
            sC = this.n.c("SourceFile");
            i2 = 1;
        } else {
            sC = 0;
            i2 = 0;
        }
        if (this.y != 0) {
            this.n.c("SourceFile");
        }
        int size = (this.u.size() * 2) + this.n.f8775g + 2 + 8 + 2 + 2 + 2 + 2 + 2;
        for (int i3 = 0; i3 < this.t.size(); i3++) {
            Objects.requireNonNull((k.d.a.a) this.t.get(i3));
            size += 8;
        }
        int length = size + 2;
        for (int i4 = 0; i4 < this.s.size(); i4++) {
            length += ((k.d.a.b) this.s.get(i4)).f8748f.length + 8;
        }
        int i5 = length + 2;
        if (this.y != 0) {
            i5 = i5 + 2 + 4 + 2;
        }
        byte[] bArr = new byte[i5];
        int iL = L(a, bArr, L(f8749b, bArr, M(-889275714, bArr, 0)));
        d dVar = this.n;
        int iL2 = L((short) dVar.f8776h, bArr, iL);
        System.arraycopy(dVar.f8779k, 0, bArr, iL2, dVar.f8775g);
        int iL3 = L(this.u.size(), bArr, L(this.x, bArr, L(this.w, bArr, L(this.v, bArr, iL2 + dVar.f8775g))));
        for (int i6 = 0; i6 < this.u.size(); i6++) {
            iL3 = L(((Short) this.u.get(i6)).shortValue(), bArr, iL3);
        }
        int iL4 = L(this.t.size(), bArr, iL3);
        for (int i7 = 0; i7 < this.t.size(); i7++) {
            k.d.a.a aVar = (k.d.a.a) this.t.get(i7);
            iL4 = L(0, bArr, L(aVar.f8742b, bArr, L(aVar.a, bArr, L(aVar.f8743c, bArr, iL4))));
        }
        int iL5 = L(this.s.size(), bArr, iL4);
        for (int i8 = 0; i8 < this.s.size(); i8++) {
            k.d.a.b bVar = (k.d.a.b) this.s.get(i8);
            int iL6 = L(1, bArr, L(bVar.f8746d, bArr, L(bVar.f8745c, bArr, L(bVar.f8747e, bArr, iL5))));
            byte[] bArr2 = bVar.f8748f;
            System.arraycopy(bArr2, 0, bArr, iL6, bArr2.length);
            iL5 = iL6 + bVar.f8748f.length;
        }
        int iL7 = L(i2, bArr, iL5);
        if (this.y != 0) {
            iL7 = L(this.y, bArr, M(2, bArr, L(sC, bArr, iL7)));
        }
        if (iL7 == i5) {
            return bArr;
        }
        throw new RuntimeException();
    }

    public final void T(int i2, int i3, int i4) {
        if (i4 == 0) {
            c(i2);
            return;
        }
        if (i4 == 1) {
            c(i2 + 1);
            return;
        }
        if (i4 == 2) {
            c(i2 + 2);
        } else if (i4 != 3) {
            d(i3, i4);
        } else {
            c(i2 + 3);
        }
    }

    public int b() {
        int i2 = this.A;
        int[] iArr = this.z;
        if (iArr == null || i2 == iArr.length) {
            if (iArr == null) {
                this.z = new int[32];
            } else {
                int[] iArr2 = new int[iArr.length * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.z = iArr2;
            }
        }
        this.A = i2 + 1;
        this.z[i2] = -1;
        return i2 | Integer.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(int r5) {
        /*
            Method dump skipped, instruction units count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.d.a.c.c(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fb A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.d.a.c.d(int, int):void");
    }

    public void e(int i2, String str) {
        int iP = P(i2) + this.p;
        if (iP < 0 || 32767 < iP) {
            D(iP);
            throw null;
        }
        if (i2 != 187 && i2 != 189 && i2 != 192 && i2 != 193) {
            throw new IllegalArgumentException("bad opcode for class reference");
        }
        short sA = this.n.a(str);
        this.f8759l[w(1)] = (byte) i2;
        A(sA);
        short s = (short) iP;
        this.p = s;
        if (iP > this.q) {
            this.q = s;
        }
    }

    public void f(int i2, String str, String str2, String str3) {
        int i3;
        int iP = P(i2) + this.p;
        char cCharAt = str3.charAt(0);
        int i4 = (cCharAt == 'J' || cCharAt == 'D') ? 2 : 1;
        switch (i2) {
            case 178:
            case 180:
                i3 = iP + i4;
                break;
            case 179:
            case TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT /* 181 */:
                i3 = iP - i4;
                break;
            default:
                throw new IllegalArgumentException("bad opcode for field reference");
        }
        if (i3 < 0 || 32767 < i3) {
            D(i3);
            throw null;
        }
        d dVar = this.n;
        f fVar = new f(str, str2, str3);
        int i5 = dVar.f8772d.get(fVar, -1);
        if (i5 == -1) {
            short sB = dVar.b(str2, str3);
            short sA = dVar.a(str);
            dVar.d(5);
            byte[] bArr = dVar.f8779k;
            int i6 = dVar.f8775g;
            int i7 = i6 + 1;
            dVar.f8775g = i7;
            bArr[i6] = 9;
            int iL = L(sA, bArr, i7);
            dVar.f8775g = iL;
            dVar.f8775g = L(sB, dVar.f8779k, iL);
            i5 = dVar.f8776h;
            dVar.f8776h = i5 + 1;
            dVar.f8772d.put(fVar, i5);
        }
        dVar.f8777i.put(i5, fVar);
        dVar.f8778j.put(i5, 9);
        this.f8759l[w(1)] = (byte) i2;
        A((short) i5);
        short s = (short) i3;
        this.p = s;
        if (i3 > this.q) {
            this.q = s;
        }
    }

    public void g(int i2) {
        T(42, 25, i2);
    }

    public void h(int i2) {
        T(75, 58, i2);
    }

    public void i(int i2) {
        T(38, 24, i2);
    }

    public void j(int i2) {
        T(71, 57, i2);
    }

    public void k(int i2, int i3, int i4, String str) {
        if ((i2 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad startLabel");
        }
        if ((i3 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad endLabel");
        }
        if ((i4 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad handlerLabel");
        }
        e eVar = new e(i2, i3, i4, str == null ? (short) 0 : this.n.a(str));
        int i5 = this.f8756i;
        if (i5 == 0) {
            this.f8755h = new e[4];
        } else {
            e[] eVarArr = this.f8755h;
            if (i5 == eVarArr.length) {
                e[] eVarArr2 = new e[i5 * 2];
                System.arraycopy(eVarArr, 0, eVarArr2, 0, i5);
                this.f8755h = eVarArr2;
            }
        }
        this.f8755h[i5] = eVar;
        this.f8756i = i5 + 1;
    }

    public void l(String str, String str2, short s) {
        this.t.add(new k.d.a.a(this.n.c(str), this.n.c(str2), s));
    }

    public void m(int i2) {
        T(26, 21, i2);
    }

    public void n(int i2) {
        T(59, 54, i2);
    }

    public void o(int i2, String str, String str2, String str3) {
        int iO = O(str3);
        int i3 = iO >>> 16;
        int iP = P(i2) + this.p + ((short) iO);
        if (iP < 0 || 32767 < iP) {
            D(iP);
            throw null;
        }
        switch (i2) {
            case TinkerReport.KEY_APPLIED_DEX_EXTRACT /* 182 */:
            case TinkerReport.KEY_APPLIED_LIB_EXTRACT /* 183 */:
            case TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT /* 184 */:
            case 185:
                this.f8759l[w(1)] = (byte) i2;
                if (i2 == 185) {
                    d dVar = this.n;
                    short sB = dVar.b(str2, str3);
                    short sA = dVar.a(str);
                    dVar.d(5);
                    byte[] bArr = dVar.f8779k;
                    int i4 = dVar.f8775g;
                    int i5 = i4 + 1;
                    dVar.f8775g = i5;
                    bArr[i4] = 11;
                    int iL = L(sA, bArr, i5);
                    dVar.f8775g = iL;
                    dVar.f8775g = L(sB, dVar.f8779k, iL);
                    f fVar = new f(str, str2, str3);
                    dVar.f8777i.put(dVar.f8776h, fVar);
                    dVar.f8778j.put(dVar.f8776h, 11);
                    int i6 = dVar.f8776h;
                    dVar.f8776h = i6 + 1;
                    A((short) i6);
                    z(i3 + 1);
                    z(0);
                } else {
                    d dVar2 = this.n;
                    f fVar2 = new f(str, str2, str3);
                    int i7 = dVar2.f8773e.get(fVar2, -1);
                    if (i7 == -1) {
                        short sB2 = dVar2.b(str2, str3);
                        short sA2 = dVar2.a(str);
                        dVar2.d(5);
                        byte[] bArr2 = dVar2.f8779k;
                        int i8 = dVar2.f8775g;
                        int i9 = i8 + 1;
                        dVar2.f8775g = i9;
                        bArr2[i8] = 10;
                        int iL2 = L(sA2, bArr2, i9);
                        dVar2.f8775g = iL2;
                        dVar2.f8775g = L(sB2, dVar2.f8779k, iL2);
                        i7 = dVar2.f8776h;
                        dVar2.f8776h = i7 + 1;
                        dVar2.f8773e.put(fVar2, i7);
                    }
                    dVar2.f8777i.put(i7, fVar2);
                    dVar2.f8778j.put(i7, 10);
                    A((short) i7);
                }
                short s = (short) iP;
                this.p = s;
                if (iP > this.q) {
                    this.q = s;
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException("bad opcode for method reference");
        }
    }

    public void p(short s) {
        if (this.o == null) {
            throw new IllegalArgumentException("No method to stop");
        }
        int i2 = this.f8758k;
        if (i2 == 0) {
            this.f8757j = new int[16];
        } else {
            int[] iArr = this.f8757j;
            if (i2 == iArr.length) {
                int[] iArr2 = new int[i2 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.f8757j = iArr2;
            }
        }
        this.f8757j[i2] = (this.m << 16) + s;
        this.f8758k = i2 + 1;
    }

    public void q(int i2) {
        if (i2 == 0) {
            c(3);
            return;
        }
        if (i2 == 1) {
            c(4);
            return;
        }
        if (i2 == 2) {
            c(5);
            return;
        }
        if (i2 == 3) {
            c(6);
            return;
        }
        if (i2 == 4) {
            c(7);
            return;
        }
        if (i2 == 5) {
            c(8);
            return;
        }
        d dVar = this.n;
        dVar.d(5);
        byte[] bArr = dVar.f8779k;
        int i3 = dVar.f8775g;
        int i4 = i3 + 1;
        dVar.f8775g = i4;
        bArr[i3] = 3;
        dVar.f8775g = M(i2, bArr, i4);
        dVar.f8778j.put(dVar.f8776h, 3);
        int i5 = dVar.f8776h;
        dVar.f8776h = i5 + 1;
        d(18, (short) i5);
    }

    public void r(String str) {
        d dVar = this.n;
        int iC = dVar.c(str) & 65535;
        int i2 = dVar.f8770b.getInt(iC, -1);
        if (i2 == -1) {
            i2 = dVar.f8776h;
            dVar.f8776h = i2 + 1;
            dVar.d(3);
            byte[] bArr = dVar.f8779k;
            int i3 = dVar.f8775g;
            int i4 = i3 + 1;
            dVar.f8775g = i4;
            bArr[i3] = 8;
            dVar.f8775g = L(iC, bArr, i4);
            dVar.f8770b.put(iC, i2);
        }
        dVar.f8778j.put(i2, 8);
        d(18, i2);
    }

    public void s(double d2) {
        if (d2 == 0.0d) {
            c(14);
            if (1.0d / d2 < 0.0d) {
                c(119);
                return;
            }
            return;
        }
        if (d2 == 1.0d || d2 == -1.0d) {
            c(15);
            if (d2 < 0.0d) {
                c(119);
                return;
            }
            return;
        }
        d dVar = this.n;
        dVar.d(9);
        byte[] bArr = dVar.f8779k;
        int i2 = dVar.f8775g;
        dVar.f8775g = i2 + 1;
        bArr[i2] = 6;
        long jDoubleToLongBits = Double.doubleToLongBits(d2);
        byte[] bArr2 = dVar.f8779k;
        int i3 = (int) jDoubleToLongBits;
        dVar.f8775g = M(i3, bArr2, M((int) (jDoubleToLongBits >>> 32), bArr2, dVar.f8775g));
        int i4 = dVar.f8776h;
        dVar.f8776h = i4 + 2;
        dVar.f8778j.put(i4, 6);
        d(20, i4);
    }

    public void t(int i2) {
        byte b2 = (byte) i2;
        if (b2 != i2) {
            short s = (short) i2;
            if (s == i2) {
                d(17, s);
                return;
            } else {
                q(i2);
                return;
            }
        }
        if (i2 == -1) {
            c(2);
        } else if (i2 < 0 || i2 > 5) {
            d(16, b2);
        } else {
            c((byte) (i2 + 3));
        }
    }

    public void u(String str) {
        int length = str.length();
        int i2 = 0;
        int iF = this.n.f(str, 0, length);
        if (iF == length) {
            r(str);
            return;
        }
        e(187, "java/lang/StringBuilder");
        c(89);
        t(length);
        o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, "java/lang/StringBuilder", "<init>", "(I)V");
        while (true) {
            c(89);
            r(str.substring(i2, iF));
            o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            c(87);
            if (iF == length) {
                o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
                return;
            } else {
                i2 = iF;
                iF = this.n.f(str, iF, length);
            }
        }
    }

    public void v(boolean z) {
        c(z ? 4 : 3);
    }

    public final int w(int i2) {
        if (this.o == null) {
            throw new IllegalArgumentException("No method to add to");
        }
        int i3 = this.m;
        int i4 = i2 + i3;
        byte[] bArr = this.f8759l;
        if (i4 > bArr.length) {
            int length = bArr.length * 2;
            if (i4 > length) {
                length = i4;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            this.f8759l = bArr2;
        }
        this.m = i4;
        return i3;
    }

    public final void x(int i2) {
        if (f8750c) {
            int[] iArr = this.f8751d;
            if (iArr == null) {
                this.f8751d = new int[4];
            } else {
                int length = iArr.length;
                int i3 = this.f8752e;
                if (length == i3) {
                    int[] iArr2 = new int[i3 * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i3);
                    this.f8751d = iArr2;
                }
            }
            int[] iArr3 = this.f8751d;
            int i4 = this.f8752e;
            this.f8752e = i4 + 1;
            iArr3[i4] = i2;
        }
    }

    public int y(int i2, int i3) {
        if (i2 > i3) {
            throw new a("Bad bounds: " + i2 + ' ' + i3);
        }
        int iP = P(Context.VERSION_1_7) + this.p;
        if (iP < 0 || 32767 < iP) {
            D(iP);
            throw null;
        }
        int i4 = (~this.m) & 3;
        int iW = w((((i3 - i2) + 1 + 3) * 4) + i4 + 1);
        int i5 = iW + 1;
        this.f8759l[iW] = -86;
        while (i4 != 0) {
            this.f8759l[i5] = 0;
            i4--;
            i5++;
        }
        M(i3, this.f8759l, M(i2, this.f8759l, i5 + 4));
        short s = (short) iP;
        this.p = s;
        if (iP > this.q) {
            this.q = s;
        }
        return iW;
    }

    public final void z(int i2) {
        this.f8759l[w(1)] = (byte) i2;
    }
}
