package c.e.c.y;

import c.e.c.r;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;
import java.util.Map;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: Code39Reader.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends k {
    public static final int[] a = {52, 289, 97, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, Token.COLONCOLON, TinkerReport.KEY_LOADED_SUCC_COST_500_LESS, 208, Token.LOOP, 388, 196, 168, Token.COMMENT, Token.TYPEOFNAME, 42};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f1450c = new StringBuilder(20);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f1451d = new int[9];

    public c(boolean z) {
        this.f1449b = z;
    }

    public static int h(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if ((i11 << 1) >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i5 <= 3) {
                return -1;
            }
            i2 = i3;
        }
    }

    @Override // c.e.c.y.k
    public c.e.c.p c(int i2, c.e.c.v.a aVar, Map<c.e.c.e, ?> map) throws c.e.c.k, c.e.c.d {
        char cCharAt;
        int[] iArr = this.f1451d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f1450c;
        sb.setLength(0);
        int i3 = aVar.f1375b;
        int iF = aVar.f(0);
        int length = iArr.length;
        int i4 = iF;
        boolean z = false;
        int i5 = 0;
        while (iF < i3) {
            if (aVar.e(iF) != z) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else if (h(iArr) == 148 && aVar.i(Math.max(0, i4 - ((iF - i4) / 2)), i4, false)) {
                    int iF2 = aVar.f(new int[]{i4, iF}[1]);
                    int i6 = aVar.f1375b;
                    while (true) {
                        k.f(aVar, iF2, iArr);
                        int iH = h(iArr);
                        if (iH < 0) {
                            throw c.e.c.k.getNotFoundInstance();
                        }
                        int i7 = 0;
                        while (true) {
                            int[] iArr2 = a;
                            if (i7 < iArr2.length) {
                                if (iArr2[i7] == iH) {
                                    cCharAt = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i7);
                                    break;
                                }
                                i7++;
                            } else {
                                if (iH != 148) {
                                    throw c.e.c.k.getNotFoundInstance();
                                }
                                cCharAt = '*';
                            }
                        }
                        sb.append(cCharAt);
                        int i8 = iF2;
                        for (int i9 : iArr) {
                            i8 += i9;
                        }
                        int iF3 = aVar.f(i8);
                        if (cCharAt == '*') {
                            sb.setLength(sb.length() - 1);
                            int i10 = 0;
                            for (int i11 : iArr) {
                                i10 += i11;
                            }
                            int i12 = (iF3 - iF2) - i10;
                            if (iF3 != i6 && (i12 << 1) < i10) {
                                throw c.e.c.k.getNotFoundInstance();
                            }
                            if (this.f1449b) {
                                int length2 = sb.length() - 1;
                                int iIndexOf = 0;
                                for (int i13 = 0; i13 < length2; i13++) {
                                    iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f1450c.charAt(i13));
                                }
                                if (sb.charAt(length2) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                                    throw c.e.c.d.getChecksumInstance();
                                }
                                sb.setLength(length2);
                            }
                            if (sb.length() == 0) {
                                throw c.e.c.k.getNotFoundInstance();
                            }
                            float f2 = i2;
                            return new c.e.c.p(sb.toString(), null, new r[]{new r((r5[1] + r5[0]) / 2.0f, f2), new r((i10 / 2.0f) + iF2, f2)}, c.e.c.a.CODE_39);
                        }
                        iF2 = iF3;
                    }
                } else {
                    i4 += iArr[0] + iArr[1];
                    int i14 = i5 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i14);
                    iArr[i14] = 0;
                    iArr[i5] = 0;
                    i5 = i14;
                }
                iArr[i5] = 1;
                z = !z;
            }
            iF++;
        }
        throw c.e.c.k.getNotFoundInstance();
    }
}
