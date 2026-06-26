package k.e.a;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public class p extends o {
    public int[] A;
    public int[] B;
    public int C;
    public l D;
    public l E;
    public int F;
    public c G;
    public int H;
    public c I;
    public int J;
    public c K;
    public int L;
    public c M;
    public int N;
    public a O;
    public a P;
    public boolean Q;
    public int R;
    public final int S;
    public n T;
    public n U;
    public n V;
    public int W;
    public int X;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f8893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f8897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f8898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f8900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f8901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f8902l;
    public a m;
    public a n;
    public a o;
    public a[] p;
    public a[] q;
    public int r;
    public b s;
    public c t;
    public int u;
    public int v;
    public int w;
    public int x;
    public c y;
    public int z;

    public p(f fVar, int i2, String str, String str2, String str3, String[] strArr, boolean z, boolean z2) {
        super(327680);
        this.t = new c();
        if (fVar.I == null) {
            fVar.I = this;
        } else {
            fVar.J.f8892b = this;
        }
        fVar.J = this;
        this.f8893c = fVar;
        this.f8894d = i2;
        if ("<init>".equals(str)) {
            this.f8894d |= 524288;
        }
        this.f8895e = fVar.v(str);
        this.f8896f = fVar.v(str2);
        this.f8897g = str2;
        this.f8898h = str3;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.f8899i = length;
            this.f8900j = new int[length];
            for (int i3 = 0; i3 < this.f8899i; i3++) {
                this.f8900j[i3] = fVar.t(strArr[i3]);
            }
        }
        this.S = z2 ? 0 : z ? 1 : 2;
        if (z || z2) {
            int iD = r.d(this.f8897g) >> 2;
            iD = (i2 & 8) != 0 ? iD - 1 : iD;
            this.v = iD;
            this.w = iD;
            n nVar = new n();
            this.T = nVar;
            nVar.a |= 8;
            i(nVar);
        }
    }

    public static void D(int[] iArr, int[] iArr2, n nVar) {
        if ((nVar.a & 4) == 0) {
            nVar.f8883c = x(iArr, iArr2, 0, nVar.f8883c);
            nVar.a |= 4;
        }
    }

    public static int G(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & ExifInterface.MARKER) | ((bArr[i2] & ExifInterface.MARKER) << 8);
    }

    public static int w(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & ExifInterface.MARKER) | ((bArr[i2] & ExifInterface.MARKER) << 24) | ((bArr[i2 + 1] & ExifInterface.MARKER) << 16) | ((bArr[i2 + 2] & ExifInterface.MARKER) << 8);
    }

    public static int x(int[] iArr, int[] iArr2, int i2, int i3) {
        int i4 = i3 - i2;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (i2 < iArr[i5] && iArr[i5] <= i3) {
                i4 += iArr2[i5];
            } else if (i3 < iArr[i5] && iArr[i5] <= i2) {
                i4 -= iArr2[i5];
            }
        }
        return i4;
    }

    public final void A(Object obj) {
        c cVar;
        int iT;
        if (obj instanceof String) {
            cVar = this.y;
            cVar.e(7);
            iT = this.f8893c.t((String) obj);
        } else if (obj instanceof Integer) {
            this.y.e(((Integer) obj).intValue());
            return;
        } else {
            cVar = this.y;
            cVar.e(8);
            iT = ((n) obj).f8883c;
        }
        cVar.i(iT);
    }

    public final void B(c cVar) {
        int i2 = this.f8894d;
        cVar.i(i2 & (~(((i2 & 262144) / 64) | 917504)));
        cVar.i(this.f8895e);
        cVar.i(this.f8896f);
        int iA = this.t.f8818b > 0 ? 1 : 0;
        if (this.f8899i > 0) {
            iA++;
        }
        int i3 = this.f8894d;
        if ((i3 & 4096) != 0 && ((this.f8893c.f8823b & 65535) < 49 || (i3 & 262144) != 0)) {
            iA++;
        }
        if ((i3 & 131072) != 0) {
            iA++;
        }
        if (this.f8898h != null) {
            iA++;
        }
        if (this.G != null) {
            iA++;
        }
        if (this.f8901k != null) {
            iA++;
        }
        if (this.f8902l != null) {
            iA++;
        }
        if (this.m != null) {
            iA++;
        }
        if (this.n != null) {
            iA++;
        }
        if (this.o != null) {
            iA++;
        }
        if (this.p != null) {
            iA++;
        }
        if (this.q != null) {
            iA++;
        }
        b bVar = this.s;
        if (bVar != null) {
            iA += bVar.a();
        }
        cVar.i(iA);
        int i4 = this.t.f8818b;
        if (i4 > 0) {
            int iB = (this.C * 8) + i4 + 12;
            c cVar2 = this.I;
            if (cVar2 != null) {
                iB += cVar2.f8818b + 8;
            }
            c cVar3 = this.K;
            if (cVar3 != null) {
                iB += cVar3.f8818b + 8;
            }
            c cVar4 = this.M;
            if (cVar4 != null) {
                iB += cVar4.f8818b + 8;
            }
            c cVar5 = this.y;
            if (cVar5 != null) {
                iB += cVar5.f8818b + 8;
            }
            a aVar = this.O;
            if (aVar != null) {
                iB = c.a.a.a.a.B(aVar, 8, iB);
            }
            a aVar2 = this.P;
            if (aVar2 != null) {
                iB = c.a.a.a.a.B(aVar2, 8, iB);
            }
            cVar.i(this.f8893c.v("Code"));
            cVar.g(iB);
            cVar.i(this.u);
            cVar.i(this.v);
            cVar.g(this.t.f8818b);
            c cVar6 = this.t;
            cVar.f(cVar6.a, 0, cVar6.f8818b);
            cVar.i(this.C);
            if (this.C > 0) {
                for (l lVar = this.D; lVar != null; lVar = lVar.f8873f) {
                    cVar.i(lVar.a.f8883c);
                    cVar.i(lVar.f8869b.f8883c);
                    cVar.i(lVar.f8870c.f8883c);
                    cVar.i(lVar.f8872e);
                }
            }
            int i5 = this.I != null ? 1 : 0;
            if (this.K != null) {
                i5++;
            }
            if (this.M != null) {
                i5++;
            }
            if (this.y != null) {
                i5++;
            }
            if (this.O != null) {
                i5++;
            }
            if (this.P != null) {
                i5++;
            }
            cVar.i(i5);
            if (this.I != null) {
                cVar.i(this.f8893c.v("LocalVariableTable"));
                cVar.g(this.I.f8818b + 2);
                cVar.i(this.H);
                c cVar7 = this.I;
                cVar.f(cVar7.a, 0, cVar7.f8818b);
            }
            if (this.K != null) {
                cVar.i(this.f8893c.v("LocalVariableTypeTable"));
                cVar.g(this.K.f8818b + 2);
                cVar.i(this.J);
                c cVar8 = this.K;
                cVar.f(cVar8.a, 0, cVar8.f8818b);
            }
            if (this.M != null) {
                cVar.i(this.f8893c.v("LineNumberTable"));
                cVar.g(this.M.f8818b + 2);
                cVar.i(this.L);
                c cVar9 = this.M;
                cVar.f(cVar9.a, 0, cVar9.f8818b);
            }
            if (this.y != null) {
                f fVar = this.f8893c;
                cVar.i(fVar.v((fVar.f8823b & 65535) >= 50 ? "StackMapTable" : "StackMap"));
                cVar.g(this.y.f8818b + 2);
                cVar.i(this.x);
                c cVar10 = this.y;
                cVar.f(cVar10.a, 0, cVar10.f8818b);
            }
            if (this.O != null) {
                cVar.i(this.f8893c.v("RuntimeVisibleTypeAnnotations"));
                this.O.c(cVar);
            }
            if (this.P != null) {
                cVar.i(this.f8893c.v("RuntimeInvisibleTypeAnnotations"));
                this.P.c(cVar);
            }
        }
        if (this.f8899i > 0) {
            cVar.i(this.f8893c.v("Exceptions"));
            cVar.g((this.f8899i * 2) + 2);
            cVar.i(this.f8899i);
            for (int i6 = 0; i6 < this.f8899i; i6++) {
                cVar.i(this.f8900j[i6]);
            }
        }
        int i7 = this.f8894d;
        if ((i7 & 4096) != 0) {
            f fVar2 = this.f8893c;
            if ((65535 & fVar2.f8823b) < 49 || (i7 & 262144) != 0) {
                cVar.i(fVar2.v("Synthetic"));
                cVar.g(0);
            }
        }
        if ((this.f8894d & 131072) != 0) {
            cVar.i(this.f8893c.v("Deprecated"));
            cVar.g(0);
        }
        if (this.f8898h != null) {
            cVar.i(this.f8893c.v("Signature"));
            cVar.g(2);
            cVar.i(this.f8893c.v(this.f8898h));
        }
        if (this.G != null) {
            cVar.i(this.f8893c.v("MethodParameters"));
            cVar.g(this.G.f8818b + 1);
            cVar.e(this.F);
            c cVar11 = this.G;
            cVar.f(cVar11.a, 0, cVar11.f8818b);
        }
        if (this.f8901k != null) {
            cVar.i(this.f8893c.v("AnnotationDefault"));
            cVar.g(this.f8901k.f8818b);
            c cVar12 = this.f8901k;
            cVar.f(cVar12.a, 0, cVar12.f8818b);
        }
        if (this.f8902l != null) {
            cVar.i(this.f8893c.v("RuntimeVisibleAnnotations"));
            this.f8902l.c(cVar);
        }
        if (this.m != null) {
            cVar.i(this.f8893c.v("RuntimeInvisibleAnnotations"));
            this.m.c(cVar);
        }
        if (this.n != null) {
            cVar.i(this.f8893c.v("RuntimeVisibleTypeAnnotations"));
            this.n.c(cVar);
        }
        if (this.o != null) {
            cVar.i(this.f8893c.v("RuntimeInvisibleTypeAnnotations"));
            this.o.c(cVar);
        }
        if (this.p != null) {
            cVar.i(this.f8893c.v("RuntimeVisibleParameterAnnotations"));
            a.d(this.p, this.r, cVar);
        }
        if (this.q != null) {
            cVar.i(this.f8893c.v("RuntimeInvisibleParameterAnnotations"));
            a.d(this.q, this.r, cVar);
        }
        b bVar2 = this.s;
        if (bVar2 != null) {
            bVar2.c(this.f8893c, null, 0, -1, -1, cVar);
        }
    }

    public final void C(n nVar, n[] nVarArr) {
        n nVar2 = this.V;
        if (nVar2 != null) {
            if (this.S == 0) {
                nVar2.f8888h.e(171, 0, null, null);
                z(0, nVar);
                nVar.a().a |= 16;
                for (int i2 = 0; i2 < nVarArr.length; i2++) {
                    z(0, nVarArr[i2]);
                    nVarArr[i2].a().a |= 16;
                }
            } else {
                int i3 = this.W - 1;
                this.W = i3;
                z(i3, nVar);
                for (n nVar3 : nVarArr) {
                    z(this.W, nVar3);
                }
            }
            H();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.p.E():void");
    }

    public final void F(j jVar) {
        int[] iArr = jVar.f8859c;
        int[] iArr2 = jVar.f8860d;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < iArr.length) {
            int i6 = iArr[i3];
            i5++;
            if (i6 != 16777216) {
                i4 += i5;
                i5 = 0;
            }
            if (i6 == 16777220 || i6 == 16777219) {
                i3++;
            }
            i3++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < iArr2.length) {
            int i9 = iArr2[i7];
            i8++;
            if (i9 == 16777220 || i9 == 16777219) {
                i7++;
            }
            i7++;
        }
        v(jVar.f8858b.f8883c, i4, i8);
        int i10 = 3;
        int i11 = 0;
        while (i4 > 0) {
            int i12 = iArr[i11];
            int i13 = i10 + 1;
            this.B[i10] = i12;
            if (i12 == 16777220 || i12 == 16777219) {
                i11++;
            }
            i11++;
            i4--;
            i10 = i13;
        }
        while (i2 < iArr2.length) {
            int i14 = iArr2[i2];
            int i15 = i10 + 1;
            this.B[i10] = i14;
            if (i14 == 16777220 || i14 == 16777219) {
                i2++;
            }
            i2++;
            i10 = i15;
        }
        E();
    }

    public final void H() {
        if (this.S == 0) {
            n nVar = new n();
            j jVar = new j();
            nVar.f8888h = jVar;
            jVar.f8858b = nVar;
            c cVar = this.t;
            nVar.d(cVar.f8818b, cVar.a);
            this.U.f8889i = nVar;
            this.U = nVar;
        } else {
            this.V.f8887g = this.X;
        }
        this.V = null;
    }

    @Override // k.e.a.o
    public a a(String str, boolean z) {
        c cVar = new c();
        cVar.i(this.f8893c.v(str));
        cVar.i(0);
        a aVar = new a(this.f8893c, true, cVar, cVar, 2);
        if (z) {
            aVar.f8814g = this.f8902l;
            this.f8902l = aVar;
        } else {
            aVar.f8814g = this.m;
            this.m = aVar;
        }
        return aVar;
    }

    @Override // k.e.a.o
    public void b(int i2, String str, String str2, String str3) {
        int i3;
        int i4;
        this.N = this.t.f8818b;
        m mVarM = this.f8893c.m(str, str2, str3);
        n nVar = this.V;
        if (nVar != null) {
            if (this.S == 0) {
                nVar.f8888h.e(i2, 0, this.f8893c, mVarM);
            } else {
                char cCharAt = str3.charAt(0);
                int i5 = -2;
                switch (i2) {
                    case 178:
                        i3 = this.W + ((cCharAt == 'D' || cCharAt == 'J') ? 2 : 1);
                        break;
                    case 179:
                        i4 = this.W;
                        if (cCharAt != 'D' && cCharAt != 'J') {
                            i5 = -1;
                        }
                        i3 = i5 + i4;
                        break;
                    case 180:
                        i3 = this.W + ((cCharAt == 'D' || cCharAt == 'J') ? 1 : 0);
                        break;
                    default:
                        i4 = this.W;
                        if (cCharAt == 'D' || cCharAt == 'J') {
                            i5 = -3;
                        }
                        i3 = i5 + i4;
                        break;
                }
                if (i3 > this.X) {
                    this.X = i3;
                }
                this.W = i3;
            }
        }
        this.t.c(i2, mVarM.a);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x006d. Please report as an issue. */
    @Override // k.e.a.o
    public void c(int i2, int i3, Object[] objArr, int i4, Object[] objArr2) {
        int i5;
        c cVar;
        int i6;
        int i7;
        int i8;
        int i9;
        if (this.S == 0) {
            return;
        }
        int i10 = 3;
        int i11 = 0;
        if (i2 == -1) {
            if (this.A == null) {
                v(0, this.f8897g.length() + 1, 0);
                int i12 = this.f8894d;
                if ((i12 & 8) == 0) {
                    if ((i12 & 524288) == 0) {
                        int[] iArr = this.B;
                        f fVar = this.f8893c;
                        iArr[3] = fVar.r(fVar.o) | 24117248;
                    } else {
                        this.B[3] = 6;
                    }
                    i8 = 4;
                } else {
                    i8 = 3;
                }
                int i13 = 1;
                while (true) {
                    int i14 = i13 + 1;
                    char cCharAt = this.f8897g.charAt(i13);
                    if (cCharAt == 'F') {
                        i9 = i8 + 1;
                        this.B[i8] = 2;
                    } else if (cCharAt != 'L') {
                        if (cCharAt != 'S' && cCharAt != 'I') {
                            if (cCharAt == 'J') {
                                i9 = i8 + 1;
                                this.B[i8] = 4;
                            } else if (cCharAt != 'Z') {
                                if (cCharAt != '[') {
                                    switch (cCharAt) {
                                        case 'D':
                                            i9 = i8 + 1;
                                            this.B[i8] = 3;
                                            break;
                                    }
                                    this.B[1] = i8 - 3;
                                    E();
                                } else {
                                    while (this.f8897g.charAt(i14) == '[') {
                                        i14++;
                                    }
                                    if (this.f8897g.charAt(i14) == 'L') {
                                        do {
                                            i14++;
                                        } while (this.f8897g.charAt(i14) != ';');
                                    }
                                    int i15 = i14 + 1;
                                    this.B[i8] = this.f8893c.r(this.f8897g.substring(i13, i15)) | 24117248;
                                    i13 = i15;
                                    i8++;
                                }
                            }
                        }
                        i9 = i8 + 1;
                        this.B[i8] = 1;
                    } else {
                        int i16 = i14;
                        while (this.f8897g.charAt(i16) != ';') {
                            i16++;
                        }
                        this.B[i8] = this.f8893c.r(this.f8897g.substring(i14, i16)) | 24117248;
                        i8++;
                        i13 = i16 + 1;
                    }
                    i8 = i9;
                    i13 = i14;
                }
            }
            this.w = i3;
            v(this.t.f8818b, i3, i4);
            for (int i17 = 0; i17 < i3; i17++) {
                if (objArr[i17] instanceof String) {
                    i7 = i10 + 1;
                    this.B[i10] = this.f8893c.r((String) objArr[i17]) | 24117248;
                } else if (objArr[i17] instanceof Integer) {
                    i7 = i10 + 1;
                    this.B[i10] = ((Integer) objArr[i17]).intValue();
                } else {
                    this.B[i10] = this.f8893c.e("", ((n) objArr[i17]).f8883c) | 25165824;
                    i10++;
                }
                i10 = i7;
            }
            while (i11 < i4) {
                if (objArr2[i11] instanceof String) {
                    i6 = i10 + 1;
                    this.B[i10] = this.f8893c.r((String) objArr2[i11]) | 24117248;
                } else if (objArr2[i11] instanceof Integer) {
                    i6 = i10 + 1;
                    this.B[i10] = ((Integer) objArr2[i11]).intValue();
                } else {
                    i6 = i10 + 1;
                    this.B[i10] = this.f8893c.e("", ((n) objArr2[i11]).f8883c) | 25165824;
                }
                i10 = i6;
                i11++;
            }
            E();
        } else {
            if (this.y == null) {
                this.y = new c();
                i5 = this.t.f8818b;
            } else {
                i5 = (this.t.f8818b - this.z) - 1;
                if (i5 < 0) {
                    if (i2 != 3) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            }
            if (i2 == 0) {
                this.w = i3;
                c cVar2 = this.y;
                cVar2.e(255);
                cVar2.i(i5);
                cVar2.i(i3);
                for (int i18 = 0; i18 < i3; i18++) {
                    A(objArr[i18]);
                }
                this.y.i(i4);
                while (i11 < i4) {
                    A(objArr2[i11]);
                    i11++;
                }
            } else if (i2 != 1) {
                int i19 = TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION;
                if (i2 == 2) {
                    this.w -= i3;
                    cVar = this.y;
                    i19 = TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION - i3;
                } else if (i2 == 3) {
                    cVar = this.y;
                    if (i5 < 64) {
                        cVar.e(i5);
                    }
                } else if (i2 == 4) {
                    c cVar3 = this.y;
                    if (i5 < 64) {
                        cVar3.e(i5 + 64);
                    } else {
                        cVar3.e(247);
                        cVar3.i(i5);
                    }
                    A(objArr2[0]);
                }
                cVar.e(i19);
                cVar.i(i5);
            } else {
                this.w += i3;
                c cVar4 = this.y;
                cVar4.e(i3 + TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
                cVar4.i(i5);
                while (i11 < i3) {
                    A(objArr[i11]);
                    i11++;
                }
            }
            this.z = this.t.f8818b;
            this.x++;
        }
        this.u = Math.max(this.u, i4);
        this.v = Math.max(this.v, this.w);
    }

    @Override // k.e.a.o
    public void d(int i2, int i3) {
        int i4;
        this.N = this.t.f8818b;
        n nVar = this.V;
        if (nVar != null && this.S == 0) {
            nVar.f8888h.e(Token.TARGET, i2, null, null);
        }
        if (this.S != 2 && (i4 = i2 + 1) > this.v) {
            this.v = i4;
        }
        if (i2 <= 255 && i3 <= 127 && i3 >= -128) {
            c cVar = this.t;
            cVar.e(Token.TARGET);
            cVar.a(i2, i3);
        } else {
            c cVar2 = this.t;
            cVar2.e(196);
            cVar2.c(Token.TARGET, i2);
            cVar2.i(i3);
        }
    }

    @Override // k.e.a.o
    public void e(int i2) {
        c cVar = this.t;
        this.N = cVar.f8818b;
        cVar.e(i2);
        n nVar = this.V;
        if (nVar != null) {
            if (this.S == 0) {
                nVar.f8888h.e(i2, 0, null, null);
            } else {
                int i3 = this.W + j.a[i2];
                if (i3 > this.X) {
                    this.X = i3;
                }
                this.W = i3;
            }
            if ((i2 < 172 || i2 > 177) && i2 != 191) {
                return;
            }
            H();
        }
    }

    @Override // k.e.a.o
    public a f(int i2, s sVar, String str, boolean z) {
        c cVar = new c();
        a.b((i2 & (-16776961)) | (this.N << 8), sVar, cVar);
        cVar.i(this.f8893c.v(str));
        cVar.i(0);
        a aVar = new a(this.f8893c, true, cVar, cVar, cVar.f8818b - 2);
        if (z) {
            aVar.f8814g = this.O;
            this.O = aVar;
        } else {
            aVar.f8814g = this.P;
            this.P = aVar;
        }
        return aVar;
    }

    @Override // k.e.a.o
    public void g(int i2, int i3) {
        this.N = this.t.f8818b;
        n nVar = this.V;
        if (nVar != null) {
            if (this.S == 0) {
                nVar.f8888h.e(i2, i3, null, null);
            } else if (i2 != 188) {
                int i4 = this.W + 1;
                if (i4 > this.X) {
                    this.X = i4;
                }
                this.W = i4;
            }
        }
        if (i2 == 17) {
            this.t.c(i2, i3);
        } else {
            this.t.a(i2, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7  */
    @Override // k.e.a.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(int r9, k.e.a.n r10) {
        /*
            r8 = this;
            k.e.a.c r0 = r8.t
            int r0 = r0.f8818b
            r8.N = r0
            k.e.a.n r0 = r8.V
            r1 = 168(0xa8, float:2.35E-43)
            r2 = 167(0xa7, float:2.34E-43)
            r3 = 0
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L5e
            int r6 = r8.S
            if (r6 != 0) goto L2f
            k.e.a.j r0 = r0.f8888h
            r0.e(r9, r3, r4, r4)
            k.e.a.n r0 = r10.a()
            int r6 = r0.a
            r6 = r6 | 16
            r0.a = r6
            r8.z(r3, r10)
            if (r9 == r2) goto L5e
            k.e.a.n r4 = new k.e.a.n
            r4.<init>()
            goto L5e
        L2f:
            if (r9 != r1) goto L52
            int r4 = r10.a
            r6 = r4 & 512(0x200, float:7.175E-43)
            if (r6 != 0) goto L40
            r4 = r4 | 512(0x200, float:7.175E-43)
            r10.a = r4
            int r4 = r8.R
            int r4 = r4 + r5
            r8.R = r4
        L40:
            int r4 = r0.a
            r4 = r4 | 128(0x80, float:1.794E-43)
            r0.a = r4
            int r0 = r8.W
            int r0 = r0 + r5
            r8.z(r0, r10)
            k.e.a.n r4 = new k.e.a.n
            r4.<init>()
            goto L5e
        L52:
            int r0 = r8.W
            int[] r6 = k.e.a.j.a
            r6 = r6[r9]
            int r0 = r0 + r6
            r8.W = r0
            r8.z(r0, r10)
        L5e:
            int r0 = r10.a
            r0 = r0 & 2
            if (r0 == 0) goto La7
            int r0 = r10.f8883c
            k.e.a.c r6 = r8.t
            int r7 = r6.f8818b
            int r0 = r0 - r7
            r7 = -32768(0xffffffffffff8000, float:NaN)
            if (r0 >= r7) goto La7
            r0 = 200(0xc8, float:2.8E-43)
            if (r9 != r2) goto L77
        L73:
            r6.e(r0)
            goto L9e
        L77:
            if (r9 != r1) goto L7c
            r0 = 201(0xc9, float:2.82E-43)
            goto L73
        L7c:
            if (r4 == 0) goto L84
            int r1 = r4.a
            r1 = r1 | 16
            r4.a = r1
        L84:
            r1 = 166(0xa6, float:2.33E-43)
            if (r9 > r1) goto L8d
            int r1 = r9 + 1
            r1 = r1 ^ r5
            int r1 = r1 - r5
            goto L8f
        L8d:
            r1 = r9 ^ 1
        L8f:
            r6.e(r1)
            k.e.a.c r1 = r8.t
            r3 = 8
            r1.i(r3)
            k.e.a.c r1 = r8.t
            r1.e(r0)
        L9e:
            k.e.a.c r0 = r8.t
            int r1 = r0.f8818b
            int r1 = r1 - r5
            r10.c(r0, r1, r5)
            goto Lb4
        La7:
            k.e.a.c r0 = r8.t
            r0.e(r9)
            k.e.a.c r0 = r8.t
            int r1 = r0.f8818b
            int r1 = r1 - r5
            r10.c(r0, r1, r3)
        Lb4:
            k.e.a.n r10 = r8.V
            if (r10 == 0) goto Lc2
            if (r4 == 0) goto Lbd
            r8.i(r4)
        Lbd:
            if (r9 != r2) goto Lc2
            r8.H()
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.p.h(int, k.e.a.n):void");
    }

    @Override // k.e.a.o
    public void i(n nVar) {
        n nVar2;
        boolean z = this.Q;
        c cVar = this.t;
        this.Q = z | nVar.d(cVar.f8818b, cVar.a);
        int i2 = nVar.a;
        if ((i2 & 1) != 0) {
            return;
        }
        int i3 = this.S;
        if (i3 == 0) {
            n nVar3 = this.V;
            if (nVar3 != null) {
                if (nVar.f8883c == nVar3.f8883c) {
                    nVar3.a = (i2 & 16) | nVar3.a;
                    nVar.f8888h = nVar3.f8888h;
                    return;
                }
                z(0, nVar);
            }
            this.V = nVar;
            if (nVar.f8888h == null) {
                j jVar = new j();
                nVar.f8888h = jVar;
                jVar.f8858b = nVar;
            }
            nVar2 = this.U;
            if (nVar2 != null) {
                if (nVar.f8883c == nVar2.f8883c) {
                    nVar2.a |= nVar.a & 16;
                    nVar.f8888h = nVar2.f8888h;
                    this.V = nVar2;
                    return;
                }
                nVar2.f8889i = nVar;
            }
        } else {
            if (i3 != 1) {
                return;
            }
            n nVar4 = this.V;
            if (nVar4 != null) {
                nVar4.f8887g = this.X;
                z(this.W, nVar);
            }
            this.V = nVar;
            this.W = 0;
            this.X = 0;
            nVar2 = this.U;
            if (nVar2 != null) {
                nVar2.f8889i = nVar;
            }
        }
        this.U = nVar;
    }

    @Override // k.e.a.o
    public void j(Object obj) {
        c cVar;
        int i2;
        this.N = this.t.f8818b;
        m mVarK = this.f8893c.k(obj);
        n nVar = this.V;
        if (nVar != null) {
            if (this.S == 0) {
                nVar.f8888h.e(18, 0, this.f8893c, mVarK);
            } else {
                int i3 = mVarK.f8874b;
                int i4 = (i3 == 5 || i3 == 6) ? this.W + 2 : this.W + 1;
                if (i4 > this.X) {
                    this.X = i4;
                }
                this.W = i4;
            }
        }
        int i5 = mVarK.a;
        int i6 = mVarK.f8874b;
        if (i6 == 5 || i6 == 6) {
            cVar = this.t;
            i2 = 20;
        } else if (i5 < 256) {
            this.t.a(18, i5);
            return;
        } else {
            cVar = this.t;
            i2 = 19;
        }
        cVar.c(i2, i5);
    }

    @Override // k.e.a.o
    public void k(int i2, n nVar) {
        if (this.M == null) {
            this.M = new c();
        }
        this.L++;
        this.M.i(nVar.f8883c);
        this.M.i(i2);
    }

    @Override // k.e.a.o
    public void l(String str, String str2, String str3, n nVar, n nVar2, int i2) {
        if (str3 != null) {
            if (this.K == null) {
                this.K = new c();
            }
            this.J++;
            c cVar = this.K;
            cVar.i(nVar.f8883c);
            cVar.i(nVar2.f8883c - nVar.f8883c);
            cVar.i(this.f8893c.v(str));
            cVar.i(this.f8893c.v(str3));
            cVar.i(i2);
        }
        if (this.I == null) {
            this.I = new c();
        }
        this.H++;
        c cVar2 = this.I;
        cVar2.i(nVar.f8883c);
        cVar2.i(nVar2.f8883c - nVar.f8883c);
        cVar2.i(this.f8893c.v(str));
        cVar2.i(this.f8893c.v(str2));
        cVar2.i(i2);
        if (this.S != 2) {
            char cCharAt = str2.charAt(0);
            int i3 = i2 + ((cCharAt == 'J' || cCharAt == 'D') ? 2 : 1);
            if (i3 > this.v) {
                this.v = i3;
            }
        }
    }

    @Override // k.e.a.o
    public a m(int i2, s sVar, n[] nVarArr, n[] nVarArr2, int[] iArr, String str, boolean z) {
        c cVar = new c();
        cVar.e(i2 >>> 24);
        cVar.i(nVarArr.length);
        for (int i3 = 0; i3 < nVarArr.length; i3++) {
            cVar.i(nVarArr[i3].f8883c);
            cVar.i(nVarArr2[i3].f8883c - nVarArr[i3].f8883c);
            cVar.i(iArr[i3]);
        }
        if (sVar == null) {
            cVar.e(0);
        } else {
            byte[] bArr = sVar.a;
            int i4 = sVar.f8920b;
            cVar.f(bArr, i4, (bArr[i4] * 2) + 1);
        }
        cVar.i(this.f8893c.v(str));
        cVar.i(0);
        a aVar = new a(this.f8893c, true, cVar, cVar, cVar.f8818b - 2);
        if (z) {
            aVar.f8814g = this.O;
            this.O = aVar;
        } else {
            aVar.f8814g = this.P;
            this.P = aVar;
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:297:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0663  */
    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // k.e.a.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 1832
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.p.n(int, int):void");
    }

    @Override // k.e.a.o
    public void p(int i2, String str, String str2, String str3, boolean z) {
        this.N = this.t.f8818b;
        m mVarN = this.f8893c.n(str, str2, str3, z);
        int iD = mVarN.f8875c;
        n nVar = this.V;
        if (nVar != null) {
            if (this.S == 0) {
                nVar.f8888h.e(i2, 0, this.f8893c, mVarN);
            } else {
                if (iD == 0) {
                    iD = r.d(str3);
                    mVarN.f8875c = iD;
                }
                int i3 = i2 == 184 ? (this.W - (iD >> 2)) + (iD & 3) + 1 : (this.W - (iD >> 2)) + (iD & 3);
                if (i3 > this.X) {
                    this.X = i3;
                }
                this.W = i3;
            }
        }
        if (i2 != 185) {
            this.t.c(i2, mVarN.a);
            return;
        }
        if (iD == 0) {
            iD = r.d(str3);
            mVarN.f8875c = iD;
        }
        c cVar = this.t;
        cVar.c(185, mVarN.a);
        cVar.a(iD >> 2, 0);
    }

    @Override // k.e.a.o
    public a q(int i2, String str, boolean z) {
        c cVar = new c();
        if ("Ljava/lang/Synthetic;".equals(str)) {
            this.r = Math.max(this.r, i2 + 1);
            return new a(this.f8893c, false, cVar, null, 0);
        }
        cVar.i(this.f8893c.v(str));
        cVar.i(0);
        a aVar = new a(this.f8893c, true, cVar, cVar, 2);
        if (z) {
            if (this.p == null) {
                this.p = new a[r.c(this.f8897g).length];
            }
            a[] aVarArr = this.p;
            aVar.f8814g = aVarArr[i2];
            aVarArr[i2] = aVar;
        } else {
            if (this.q == null) {
                this.q = new a[r.c(this.f8897g).length];
            }
            a[] aVarArr2 = this.q;
            aVar.f8814g = aVarArr2[i2];
            aVarArr2[i2] = aVar;
        }
        return aVar;
    }

    @Override // k.e.a.o
    public void r(int i2, int i3, n nVar, n... nVarArr) {
        c cVar = this.t;
        int i4 = cVar.f8818b;
        this.N = i4;
        cVar.e(Context.VERSION_1_7);
        c cVar2 = this.t;
        cVar2.f(null, 0, (4 - (cVar2.f8818b % 4)) % 4);
        nVar.c(this.t, i4, true);
        c cVar3 = this.t;
        cVar3.g(i2);
        cVar3.g(i3);
        for (n nVar2 : nVarArr) {
            nVar2.c(this.t, i4, true);
        }
        C(nVar, nVarArr);
    }

    @Override // k.e.a.o
    public a s(int i2, s sVar, String str, boolean z) {
        c cVar = new c();
        a.b(i2, sVar, cVar);
        cVar.i(this.f8893c.v(str));
        cVar.i(0);
        a aVar = new a(this.f8893c, true, cVar, cVar, cVar.f8818b - 2);
        if (z) {
            aVar.f8814g = this.n;
            this.n = aVar;
        } else {
            aVar.f8814g = this.o;
            this.o = aVar;
        }
        return aVar;
    }

    @Override // k.e.a.o
    public void t(int i2, String str) {
        this.N = this.t.f8818b;
        m mVarL = this.f8893c.l(str);
        n nVar = this.V;
        if (nVar != null) {
            if (this.S == 0) {
                nVar.f8888h.e(i2, this.t.f8818b, this.f8893c, mVarL);
            } else if (i2 == 187) {
                int i3 = this.W + 1;
                if (i3 > this.X) {
                    this.X = i3;
                }
                this.W = i3;
            }
        }
        this.t.c(i2, mVarL.a);
    }

    @Override // k.e.a.o
    public void u(int i2, int i3) {
        this.N = this.t.f8818b;
        n nVar = this.V;
        if (nVar != null) {
            if (this.S == 0) {
                nVar.f8888h.e(i2, i3, null, null);
            } else if (i2 == 169) {
                nVar.a |= 256;
                nVar.f8886f = this.W;
                H();
            } else {
                int i4 = this.W + j.a[i2];
                if (i4 > this.X) {
                    this.X = i4;
                }
                this.W = i4;
            }
        }
        if (this.S != 2) {
            int i5 = (i2 == 22 || i2 == 24 || i2 == 55 || i2 == 57) ? i3 + 2 : i3 + 1;
            if (i5 > this.v) {
                this.v = i5;
            }
        }
        if (i3 >= 4 || i2 == 169) {
            c cVar = this.t;
            if (i3 >= 256) {
                cVar.e(196);
                cVar.c(i2, i3);
            } else {
                cVar.a(i2, i3);
            }
        } else {
            this.t.e((i2 < 54 ? ((i2 - 21) << 2) + 26 : ((i2 - 54) << 2) + 59) + i3);
        }
        if (i2 < 54 || this.S != 0 || this.C <= 0) {
            return;
        }
        i(new n());
    }

    public final int v(int i2, int i3, int i4) {
        int i5 = i3 + 3 + i4;
        int[] iArr = this.B;
        if (iArr == null || iArr.length < i5) {
            this.B = new int[i5];
        }
        int[] iArr2 = this.B;
        iArr2[0] = i2;
        iArr2[1] = i3;
        iArr2[2] = i4;
        return 3;
    }

    public final void y(int i2, int i3) {
        char c2;
        c cVar;
        int iT;
        while (i2 < i3) {
            int i4 = this.B[i2];
            int i5 = (-268435456) & i4;
            if (i5 == 0) {
                int i6 = i4 & 1048575;
                int i7 = i4 & 267386880;
                if (i7 == 24117248) {
                    cVar = this.y;
                    cVar.e(7);
                    f fVar = this.f8893c;
                    iT = fVar.t(fVar.f8832k[i6].f8877e);
                } else if (i7 != 25165824) {
                    this.y.e(i6);
                    i2++;
                } else {
                    cVar = this.y;
                    cVar.e(8);
                    iT = this.f8893c.f8832k[i6].f8875c;
                }
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                int i8 = i5 >> 28;
                while (true) {
                    int i9 = i8 - 1;
                    if (i8 > 0) {
                        stringBuffer.append('[');
                        i8 = i9;
                    } else {
                        if ((i4 & 267386880) == 24117248) {
                            stringBuffer.append('L');
                            stringBuffer.append(this.f8893c.f8832k[i4 & 1048575].f8877e);
                            c2 = ';';
                        } else {
                            int i10 = i4 & 15;
                            if (i10 == 1) {
                                c2 = 'I';
                            } else if (i10 == 2) {
                                c2 = 'F';
                            } else if (i10 != 3) {
                                switch (i10) {
                                    case 9:
                                        c2 = 'Z';
                                        break;
                                    case 10:
                                        c2 = 'B';
                                        break;
                                    case 11:
                                        c2 = 'C';
                                        break;
                                    case 12:
                                        c2 = 'S';
                                        break;
                                    default:
                                        c2 = 'J';
                                        break;
                                }
                            } else {
                                c2 = 'D';
                            }
                        }
                        stringBuffer.append(c2);
                        cVar = this.y;
                        cVar.e(7);
                        iT = this.f8893c.t(stringBuffer.toString());
                    }
                }
            }
            cVar.i(iT);
            i2++;
        }
    }

    public final void z(int i2, n nVar) {
        h hVar = new h();
        hVar.a = i2;
        hVar.f8845b = nVar;
        n nVar2 = this.V;
        hVar.f8846c = nVar2.f8890j;
        nVar2.f8890j = hVar;
    }
}
