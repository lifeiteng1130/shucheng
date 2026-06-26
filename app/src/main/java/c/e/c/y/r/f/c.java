package c.e.c.y.r.f;

import c.b.a.m.f;
import c.e.c.p;
import c.e.c.r;
import c.e.c.y.r.f.d.d;
import c.e.c.y.r.f.d.e;
import c.e.c.y.r.f.d.g;
import c.e.c.y.r.f.d.j;
import c.e.c.y.r.f.d.k;
import c.e.c.y.r.f.d.s;
import com.qq.e.ads.nativ.express2.MediaEventListener;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: RSSExpandedReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends c.e.c.y.r.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f1499g = {7, 5, 4, 3, 1};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f1500h = {4, 20, 52, 104, 204};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f1501i = {0, 348, 1388, 2948, 3988};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[][] f1502j = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[][] f1503k = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, Token.SET_REF_OP, 7, 21, 63}, new int[]{189, Token.COLONCOLON, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, Token.DOTQUERY, 19, 57, 171, 91}, new int[]{62, 186, Token.JSR, 197, 169, 85, 44, Token.TARGET}, new int[]{185, Token.LOOP, 188, Token.LOCAL_BLOCK, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, Token.TYPEOFNAME, 203, 187, Token.USE_STACK, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, Token.EMPTY, 176, 106, 107, 110, 119, Token.XML}, new int[]{16, 48, Token.DOTDOT, 10, 30, 90, 59, 177}, new int[]{109, 116, Token.SCRIPT, 200, 178, 112, Token.CATCH, Token.METHOD}, new int[]{70, MediaEventListener.EVENT_VIDEO_READY, 208, 202, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 130, 179, 115}, new int[]{Token.EXPR_VOID, 191, 151, 31, 93, 68, 204, 190}, new int[]{Token.XMLATTR, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, Token.COMMENT, 64, 192, 154, 40}, new int[]{120, Token.XMLEND, 25, 75, 14, 42, 126, Token.LAST_TOKEN}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, Token.LABEL, TinkerReport.KEY_APPLIED_DEX_EXTRACT, 124}, new int[]{Token.DEBUGGER, 61, TinkerReport.KEY_APPLIED_LIB_EXTRACT, 127, Context.VERSION_1_7, 88, 53, Token.LETEXPR}, new int[]{55, Token.ARROW, 73, 8, 24, 72, 5, 15}, new int[]{45, Token.EXPR_RESULT, 194, 160, 58, 174, 100, 89}};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[][] f1504l = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    public final List<a> m = new ArrayList(11);
    public final List<b> n = new ArrayList();
    public final int[] o = new int[2];
    public boolean p;

    public static p o(List<a> list) {
        j aVar;
        int size = (list.size() << 1) - 1;
        if (((a) c.a.a.a.a.E(list, 1)).f1495b == null) {
            size--;
        }
        c.e.c.v.a aVar2 = new c.e.c.v.a(size * 12);
        int i2 = list.get(0).f1495b.a;
        int i3 = 0;
        for (int i4 = 11; i4 >= 0; i4--) {
            if (((1 << i4) & i2) != 0) {
                aVar2.k(i3);
            }
            i3++;
        }
        for (int i5 = 1; i5 < list.size(); i5++) {
            a aVar3 = list.get(i5);
            int i6 = aVar3.a.a;
            for (int i7 = 11; i7 >= 0; i7--) {
                if (((1 << i7) & i6) != 0) {
                    aVar2.k(i3);
                }
                i3++;
            }
            c.e.c.y.r.b bVar = aVar3.f1495b;
            if (bVar != null) {
                int i8 = bVar.a;
                for (int i9 = 11; i9 >= 0; i9--) {
                    if (((1 << i9) & i8) != 0) {
                        aVar2.k(i3);
                    }
                    i3++;
                }
            }
        }
        if (aVar2.e(1)) {
            aVar = new g(aVar2);
        } else if (aVar2.e(2)) {
            int iD = s.d(aVar2, 1, 4);
            if (iD == 4) {
                aVar = new c.e.c.y.r.f.d.a(aVar2);
            } else if (iD != 5) {
                int iD2 = s.d(aVar2, 1, 5);
                if (iD2 == 12) {
                    aVar = new c.e.c.y.r.f.d.c(aVar2);
                } else if (iD2 != 13) {
                    switch (s.d(aVar2, 1, 7)) {
                        case 56:
                            aVar = new e(aVar2, "310", "11");
                            break;
                        case 57:
                            aVar = new e(aVar2, "320", "11");
                            break;
                        case 58:
                            aVar = new e(aVar2, "310", d.a.a.b.HEADER_WEBSOCKET_VERSION_VALUE);
                            break;
                        case 59:
                            aVar = new e(aVar2, "320", d.a.a.b.HEADER_WEBSOCKET_VERSION_VALUE);
                            break;
                        case 60:
                            aVar = new e(aVar2, "310", "15");
                            break;
                        case 61:
                            aVar = new e(aVar2, "320", "15");
                            break;
                        case 62:
                            aVar = new e(aVar2, "310", "17");
                            break;
                        case 63:
                            aVar = new e(aVar2, "320", "17");
                            break;
                        default:
                            throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar2)));
                    }
                } else {
                    aVar = new d(aVar2);
                }
            } else {
                aVar = new c.e.c.y.r.f.d.b(aVar2);
            }
        } else {
            aVar = new k(aVar2);
        }
        String strA = aVar.a();
        r[] rVarArr = list.get(0).f1496c.f1486c;
        r[] rVarArr2 = ((a) c.a.a.a.a.E(list, 1)).f1496c.f1486c;
        return new p(strA, null, new r[]{rVarArr[0], rVarArr[1], rVarArr2[0], rVarArr2[1]}, c.e.c.a.RSS_EXPANDED);
    }

    public static void s(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    @Override // c.e.c.y.k, c.e.c.n
    public void b() {
        this.m.clear();
        this.n.clear();
    }

    @Override // c.e.c.y.k
    public p c(int i2, c.e.c.v.a aVar, Map<c.e.c.e, ?> map) {
        this.m.clear();
        this.p = false;
        try {
            return o(q(i2, aVar));
        } catch (c.e.c.k unused) {
            this.m.clear();
            this.p = true;
            return o(q(i2, aVar));
        }
    }

    public final boolean l() {
        a aVar = this.m.get(0);
        c.e.c.y.r.b bVar = aVar.a;
        c.e.c.y.r.b bVar2 = aVar.f1495b;
        if (bVar2 == null) {
            return false;
        }
        int i2 = bVar2.f1484b;
        int i3 = 2;
        for (int i4 = 1; i4 < this.m.size(); i4++) {
            a aVar2 = this.m.get(i4);
            i2 += aVar2.a.f1484b;
            i3++;
            c.e.c.y.r.b bVar3 = aVar2.f1495b;
            if (bVar3 != null) {
                i2 += bVar3.f1484b;
                i3++;
            }
        }
        return ((i3 + (-4)) * 211) + (i2 % 211) == bVar.a;
    }

    public final List<a> m(List<b> list, int i2) throws c.e.c.k {
        boolean z;
        while (i2 < this.n.size()) {
            b bVar = this.n.get(i2);
            this.m.clear();
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                this.m.addAll(it.next().a);
            }
            this.m.addAll(bVar.a);
            List<a> list2 = this.m;
            int[][] iArr = f1504l;
            int length = iArr.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                int[] iArr2 = iArr[i3];
                if (list2.size() <= iArr2.length) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= list2.size()) {
                            z = true;
                            break;
                        }
                        if (list2.get(i4).f1496c.a != iArr2[i4]) {
                            z = false;
                            break;
                        }
                        i4++;
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
                i3++;
            }
            if (z2) {
                if (l()) {
                    return this.m;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(bVar);
                try {
                    return m(arrayList, i2 + 1);
                } catch (c.e.c.k unused) {
                    continue;
                }
            }
            i2++;
        }
        throw c.e.c.k.getNotFoundInstance();
    }

    public final List<a> n(boolean z) {
        List<a> listM = null;
        if (this.n.size() > 25) {
            this.n.clear();
            return null;
        }
        this.m.clear();
        if (z) {
            Collections.reverse(this.n);
        }
        try {
            listM = m(new ArrayList(), 0);
        } catch (c.e.c.k unused) {
        }
        if (z) {
            Collections.reverse(this.n);
        }
        return listM;
    }

    public c.e.c.y.r.b p(c.e.c.v.a aVar, c.e.c.y.r.c cVar, boolean z, boolean z2) throws c.e.c.k {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int[] iArr = this.f1479b;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
        if (z2) {
            c.e.c.y.k.g(aVar, cVar.f1485b[0], iArr);
        } else {
            c.e.c.y.k.f(aVar, cVar.f1485b[1], iArr);
            int i3 = 0;
            for (int length = iArr.length - 1; i3 < length; length--) {
                int i4 = iArr[i3];
                iArr[i3] = iArr[length];
                iArr[length] = i4;
                i3++;
            }
        }
        float fW5 = f.w5(iArr) / 17.0f;
        int[] iArr2 = cVar.f1485b;
        float f2 = (iArr2[1] - iArr2[0]) / 15.0f;
        if (Math.abs(fW5 - f2) / f2 > 0.3f) {
            throw c.e.c.k.getNotFoundInstance();
        }
        int[] iArr3 = this.f1482e;
        int[] iArr4 = this.f1483f;
        float[] fArr = this.f1480c;
        float[] fArr2 = this.f1481d;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f3 = (iArr[i5] * 1.0f) / fW5;
            int i6 = (int) (0.5f + f3);
            if (i6 <= 0) {
                if (f3 < 0.3f) {
                    throw c.e.c.k.getNotFoundInstance();
                }
                i6 = 1;
            } else if (i6 > 8) {
                if (f3 > 8.7f) {
                    throw c.e.c.k.getNotFoundInstance();
                }
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                iArr3[i7] = i6;
                fArr[i7] = f3 - i6;
            } else {
                iArr4[i7] = i6;
                fArr2[i7] = f3 - i6;
            }
        }
        int iW5 = f.w5(this.f1482e);
        int iW52 = f.w5(this.f1483f);
        if (iW5 > 13) {
            z3 = false;
            z4 = true;
        } else {
            z3 = iW5 < 4;
            z4 = false;
        }
        if (iW52 > 13) {
            z5 = false;
            z6 = true;
        } else {
            z5 = iW52 < 4;
            z6 = false;
        }
        int i8 = (iW5 + iW52) - 17;
        boolean z7 = (iW5 & 1) == 1;
        boolean z8 = (iW52 & 1) == 0;
        if (i8 == 1) {
            if (z7) {
                if (z8) {
                    throw c.e.c.k.getNotFoundInstance();
                }
                z4 = true;
            } else {
                if (!z8) {
                    throw c.e.c.k.getNotFoundInstance();
                }
                z6 = true;
            }
        } else if (i8 != -1) {
            if (i8 != 0) {
                throw c.e.c.k.getNotFoundInstance();
            }
            if (z7) {
                if (!z8) {
                    throw c.e.c.k.getNotFoundInstance();
                }
                if (iW5 < iW52) {
                    z3 = true;
                    z6 = true;
                } else {
                    z5 = true;
                    z4 = true;
                }
            } else if (z8) {
                throw c.e.c.k.getNotFoundInstance();
            }
        } else if (z7) {
            if (z8) {
                throw c.e.c.k.getNotFoundInstance();
            }
            z3 = true;
        } else {
            if (!z8) {
                throw c.e.c.k.getNotFoundInstance();
            }
            z5 = true;
        }
        if (z3) {
            if (z4) {
                throw c.e.c.k.getNotFoundInstance();
            }
            c.e.c.y.r.a.i(this.f1482e, this.f1480c);
        }
        if (z4) {
            c.e.c.y.r.a.h(this.f1482e, this.f1480c);
        }
        if (z5) {
            if (z6) {
                throw c.e.c.k.getNotFoundInstance();
            }
            c.e.c.y.r.a.i(this.f1483f, this.f1480c);
        }
        if (z6) {
            c.e.c.y.r.a.h(this.f1483f, this.f1481d);
        }
        int i9 = (((cVar.a * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i10 = 0;
        int i11 = 0;
        for (int length2 = iArr3.length - 1; length2 >= 0; length2--) {
            if ((cVar.a == 0 && z && z2) ? false : true) {
                i10 = (iArr3[length2] * f1503k[i9][length2 * 2]) + i10;
            }
            i11 += iArr3[length2];
        }
        int i12 = 0;
        for (int length3 = iArr4.length - 1; length3 >= 0; length3--) {
            if ((cVar.a == 0 && z && z2) ? false : true) {
                i12 = (iArr4[length3] * f1503k[i9][(length3 * 2) + 1]) + i12;
            }
        }
        int i13 = i10 + i12;
        if ((i11 & 1) != 0 || i11 > 13 || i11 < 4) {
            throw c.e.c.k.getNotFoundInstance();
        }
        int i14 = (13 - i11) / 2;
        int i15 = f1499g[i14];
        return new c.e.c.y.r.b(c.a.a.a.a.b(f.T2(iArr3, i15, true), f1500h[i14], f.T2(iArr4, 9 - i15, false), f1501i[i14]), i13);
    }

    public List<a> q(int i2, c.e.c.v.a aVar) throws c.e.c.k {
        boolean zEquals;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = false;
        while (!z6) {
            try {
                List<a> list = this.m;
                list.add(r(aVar, list, i2));
            } catch (c.e.c.k e2) {
                if (this.m.isEmpty()) {
                    throw e2;
                }
                z6 = true;
            }
        }
        if (l()) {
            return this.m;
        }
        boolean z7 = !this.n.isEmpty();
        int i3 = 0;
        boolean zEquals2 = false;
        while (true) {
            if (i3 >= this.n.size()) {
                zEquals = false;
                break;
            }
            b bVar = this.n.get(i3);
            if (bVar.f1497b > i2) {
                zEquals = bVar.a.equals(this.m);
                break;
            }
            zEquals2 = bVar.a.equals(this.m);
            i3++;
        }
        if (!zEquals && !zEquals2) {
            List<a> list2 = this.m;
            Iterator<T> it = this.n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                b bVar2 = (b) it.next();
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z4 = true;
                        break;
                    }
                    a aVar2 = (a) it2.next();
                    Iterator<a> it3 = bVar2.a.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z5 = false;
                            break;
                        }
                        if (aVar2.equals(it3.next())) {
                            z5 = true;
                            break;
                        }
                    }
                    if (!z5) {
                        z4 = false;
                        break;
                    }
                }
                if (z4) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.n.add(i3, new b(this.m, i2, false));
                List<a> list3 = this.m;
                Iterator<b> it4 = this.n.iterator();
                while (it4.hasNext()) {
                    b next = it4.next();
                    if (next.a.size() != list3.size()) {
                        Iterator<a> it5 = next.a.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                z2 = true;
                                break;
                            }
                            a next2 = it5.next();
                            Iterator<a> it6 = list3.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    z3 = false;
                                    break;
                                }
                                if (next2.equals(it6.next())) {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3) {
                                z2 = false;
                                break;
                            }
                        }
                        if (z2) {
                            it4.remove();
                        }
                    }
                }
            }
        }
        if (z7) {
            List<a> listN = n(false);
            if (listN != null) {
                return listN;
            }
            List<a> listN2 = n(true);
            if (listN2 != null) {
                return listN2;
            }
        }
        throw c.e.c.k.getNotFoundInstance();
    }

    public a r(c.e.c.v.a aVar, List<a> list, int i2) throws c.e.c.k {
        int i3;
        int i4;
        int i5;
        int i6;
        c.e.c.y.r.c cVar;
        int i7 = 2;
        int i8 = 0;
        boolean z = list.size() % 2 == 0;
        if (this.p) {
            z = !z;
        }
        int iF = -1;
        boolean z2 = true;
        while (true) {
            int[] iArr = this.a;
            iArr[i8] = i8;
            iArr[1] = i8;
            iArr[i7] = i8;
            iArr[3] = i8;
            int i9 = aVar.f1375b;
            int i10 = iF >= 0 ? iF : list.isEmpty() ? 0 : ((a) c.a.a.a.a.E(list, 1)).f1496c.f1485b[1];
            boolean z3 = list.size() % i7 != 0;
            if (this.p) {
                z3 = !z3;
            }
            boolean z4 = false;
            while (i10 < i9) {
                z4 = !aVar.e(i10);
                if (!z4) {
                    break;
                }
                i10++;
            }
            boolean z5 = z4;
            int i11 = 0;
            int i12 = i10;
            while (i10 < i9) {
                if (aVar.e(i10) != z5) {
                    iArr[i11] = iArr[i11] + 1;
                } else {
                    if (i11 == 3) {
                        if (z3) {
                            s(iArr);
                        }
                        if (c.e.c.y.r.a.j(iArr)) {
                            int[] iArr2 = this.o;
                            iArr2[0] = i12;
                            iArr2[1] = i10;
                            if (z) {
                                int i13 = iArr2[0] - 1;
                                while (i13 >= 0 && !aVar.e(i13)) {
                                    i13--;
                                }
                                int i14 = i13 + 1;
                                int[] iArr3 = this.o;
                                i3 = 0;
                                i4 = iArr3[0] - i14;
                                i6 = i14;
                                i5 = iArr3[1];
                            } else {
                                i3 = 0;
                                int i15 = iArr2[0];
                                int iG = aVar.g(iArr2[1] + 1);
                                i4 = iG - this.o[1];
                                i5 = iG;
                                i6 = i15;
                            }
                            int[] iArr4 = this.a;
                            System.arraycopy(iArr4, i3, iArr4, 1, iArr4.length - 1);
                            iArr4[i3] = i4;
                            c.e.c.y.r.b bVarP = null;
                            try {
                                int iK = c.e.c.y.r.a.k(iArr4, f1502j);
                                int[] iArr5 = new int[2];
                                iArr5[i3] = i6;
                                iArr5[1] = i5;
                                cVar = new c.e.c.y.r.c(iK, iArr5, i6, i5, i2);
                            } catch (c.e.c.k unused) {
                                cVar = null;
                            }
                            if (cVar == null) {
                                int i16 = this.o[0];
                                iF = aVar.e(i16) ? aVar.f(aVar.g(i16)) : aVar.g(aVar.f(i16));
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                c.e.c.y.r.b bVarP2 = p(aVar, cVar, z, true);
                                if (!list.isEmpty()) {
                                    if (((a) c.a.a.a.a.E(list, 1)).f1495b == null) {
                                        throw c.e.c.k.getNotFoundInstance();
                                    }
                                }
                                try {
                                    bVarP = p(aVar, cVar, z, false);
                                } catch (c.e.c.k unused2) {
                                }
                                return new a(bVarP2, bVarP, cVar, true);
                            }
                            i7 = 2;
                            i8 = 0;
                        } else {
                            if (z3) {
                                s(iArr);
                            }
                            i12 = iArr[0] + iArr[1] + i12;
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = 0;
                            iArr[3] = 0;
                            i11--;
                        }
                    } else {
                        i11++;
                    }
                    iArr[i11] = 1;
                    z5 = !z5;
                }
                i10++;
            }
            throw c.e.c.k.getNotFoundInstance();
        }
    }
}
