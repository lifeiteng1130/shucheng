package c.e.c.x;

import androidx.exifinterface.media.ExifInterface;
import c.e.c.d;
import c.e.c.e;
import c.e.c.g;
import c.e.c.k;
import c.e.c.n;
import c.e.c.p;
import c.e.c.q;
import c.e.c.r;
import c.e.c.v.b;
import c.e.c.x.b.c;
import com.umeng.analytics.pro.bw;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Objects;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: MaxiCodeReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements n {
    public static final r[] a = new r[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f1443b = new c();

    @Override // c.e.c.n
    public p a(c.e.c.c cVar, Map<e, ?> map) throws k, g, d {
        byte[] bArr;
        String strValueOf;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            throw k.getNotFoundInstance();
        }
        b bVarA = cVar.a();
        int i2 = bVarA.a;
        int i3 = bVarA.f1376b;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < bVarA.f1376b; i6++) {
            int i7 = 0;
            while (true) {
                int i8 = bVarA.f1377c;
                if (i7 < i8) {
                    int i9 = bVarA.f1378d[(i8 * i6) + i7];
                    if (i9 != 0) {
                        if (i6 < i3) {
                            i3 = i6;
                        }
                        if (i6 > i5) {
                            i5 = i6;
                        }
                        int i10 = i7 << 5;
                        if (i10 < i2) {
                            int i11 = 0;
                            while ((i9 << (31 - i11)) == 0) {
                                i11++;
                            }
                            int i12 = i11 + i10;
                            if (i12 < i2) {
                                i2 = i12;
                            }
                        }
                        if (i10 + 31 > i4) {
                            int i13 = 31;
                            while ((i9 >>> i13) == 0) {
                                i13--;
                            }
                            int i14 = i10 + i13;
                            if (i14 > i4) {
                                i4 = i14;
                            }
                        }
                    }
                    i7++;
                }
            }
        }
        int[] iArr = (i4 < i2 || i5 < i3) ? null : new int[]{i2, i3, (i4 - i2) + 1, (i5 - i3) + 1};
        if (iArr == null) {
            throw k.getNotFoundInstance();
        }
        int i15 = iArr[0];
        int i16 = iArr[1];
        int i17 = iArr[2];
        int i18 = iArr[3];
        int i19 = (30 + 31) / 32;
        int[] iArr2 = new int[i19 * 33];
        for (int i20 = 0; i20 < 33; i20++) {
            int i21 = (((i18 / 2) + (i20 * i18)) / 33) + i16;
            for (int i22 = 0; i22 < 30; i22++) {
                if (bVarA.b((((((i20 & 1) * i17) / 2) + ((i17 / 2) + (i22 * i17))) / 30) + i15, i21)) {
                    int i23 = (i22 / 32) + (i20 * i19);
                    iArr2[i23] = (1 << (i22 & 31)) | iArr2[i23];
                }
            }
        }
        c cVar2 = this.f1443b;
        Objects.requireNonNull(cVar2);
        byte[] bArr2 = new byte[Token.DOTDOT];
        for (int i24 = 0; i24 < 33; i24++) {
            int[] iArr3 = c.e.c.x.b.a.a[i24];
            for (int i25 = 0; i25 < 30; i25++) {
                int i26 = iArr3[i25];
                if (i26 >= 0) {
                    if (((iArr2[(i25 / 32) + (i24 * i19)] >>> (i25 & 31)) & 1) != 0) {
                        int i27 = i26 / 6;
                        bArr2[i27] = (byte) (((byte) (1 << (5 - (i26 % 6)))) | bArr2[i27]);
                    }
                }
            }
        }
        cVar2.a(bArr2, 0, 10, 10, 0);
        int i28 = bArr2[0] & bw.m;
        if (i28 == 2 || i28 == 3 || i28 == 4) {
            cVar2.a(bArr2, 20, 84, 40, 1);
            cVar2.a(bArr2, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i28 != 5) {
                throw g.getFormatInstance();
            }
            cVar2.a(bArr2, 20, 68, 56, 1);
            cVar2.a(bArr2, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(bArr2, 0, bArr, 0, 10);
        System.arraycopy(bArr2, 20, bArr, 10, bArr.length - 10);
        StringBuilder sb = new StringBuilder(Token.DOTDOT);
        if (i28 == 2 || i28 == 3) {
            if (i28 == 2) {
                strValueOf = new DecimalFormat("0000000000".substring(0, c.e.c.x.b.b.a(bArr, new byte[]{39, 40, 41, ExifInterface.START_CODE, 31, 32}))).format(c.e.c.x.b.b.a(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, bw.f4789k, bw.f4790l, bw.m, bw.n, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2}));
            } else {
                String[] strArr = c.e.c.x.b.b.a;
                strValueOf = String.valueOf(new char[]{strArr[0].charAt(c.e.c.x.b.b.a(bArr, new byte[]{39, 40, 41, ExifInterface.START_CODE, 31, 32})), strArr[0].charAt(c.e.c.x.b.b.a(bArr, new byte[]{33, 34, 35, 36, 25, 26})), strArr[0].charAt(c.e.c.x.b.b.a(bArr, new byte[]{27, 28, 29, 30, 19, 20})), strArr[0].charAt(c.e.c.x.b.b.a(bArr, new byte[]{21, 22, 23, 24, bw.f4789k, bw.f4790l})), strArr[0].charAt(c.e.c.x.b.b.a(bArr, new byte[]{bw.m, bw.n, 17, 18, 7, 8})), strArr[0].charAt(c.e.c.x.b.b.a(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String str = decimalFormat.format(c.e.c.x.b.b.a(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38}));
            String str2 = decimalFormat.format(c.e.c.x.b.b.a(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52}));
            sb.append(c.e.c.x.b.b.b(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, strValueOf + (char) 29 + str + (char) 29 + str2 + (char) 29);
            } else {
                sb.insert(0, strValueOf + (char) 29 + str + (char) 29 + str2 + (char) 29);
            }
        } else if (i28 == 4) {
            sb.append(c.e.c.x.b.b.b(bArr, 1, 93));
        } else if (i28 == 5) {
            sb.append(c.e.c.x.b.b.b(bArr, 1, 77));
        }
        String string = sb.toString();
        String strValueOf2 = String.valueOf(i28);
        p pVar = new p(string, bArr, a, c.e.c.a.MAXICODE);
        if (strValueOf2 != null) {
            pVar.b(q.ERROR_CORRECTION_LEVEL, strValueOf2);
        }
        return pVar;
    }

    @Override // c.e.c.n
    public void b() {
    }
}
