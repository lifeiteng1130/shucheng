package c.e.c.u.c;

import androidx.exifinterface.media.ExifInterface;
import c.e.c.g;
import c.e.c.v.b;
import c.e.c.v.e;
import c.e.c.v.m.c;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.commonsdk.statistics.SdkVersion;
import h.a.a.a.w;
import java.util.Arrays;
import org.antlr.v4.runtime.tree.xpath.XPath;
import org.mozilla.javascript.optimizer.OptRuntime;
import org.slf4j.Marker;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final String[] a = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", OptRuntime.GeneratorState.resumptionPoint_TYPE, "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1363b = {"CTRL_PS", " ", ai.at, "b", ai.aD, "d", "e", "f", "g", "h", ai.aA, "j", "k", Constants.LANDSCAPE, "m", "n", "o", "p", "q", "r", ai.az, ai.aF, ai.aE, ai.aC, "w", "x", "y", ai.aB, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f1364c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f1365d = {"", "\r", "\r\n", ". ", ", ", ": ", XPath.NOT, "\"", "#", "$", "%", "&", "'", "(", ")", "*", Marker.ANY_NON_NULL_MARKER, ",", "-", ".", w.DEFAULT_PATH_SEPARATOR, ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f1366e = {"CTRL_PS", " ", "0", SdkVersion.MINI_VERSION, ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.e.c.u.a f1367f;

    /* JADX INFO: renamed from: c.e.c.u.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Decoder.java */
    public enum EnumC0050a {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static int b(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4 |= 1;
            }
        }
        return i4;
    }

    public e a(c.e.c.u.a aVar) throws g {
        int i2;
        c.e.c.v.m.a aVar2;
        String str;
        this.f1367f = aVar;
        b bVar = aVar.a;
        boolean z = aVar.f1360c;
        int i3 = aVar.f1362e;
        int i4 = (z ? 11 : 14) + (i3 << 2);
        int[] iArr = new int[i4];
        int i5 = ((z ? 88 : 112) + (i3 << 4)) * i3;
        boolean[] zArr = new boolean[i5];
        int i6 = 2;
        if (z) {
            for (int i7 = 0; i7 < i4; i7++) {
                iArr[i7] = i7;
            }
        } else {
            int i8 = i4 / 2;
            int i9 = ((((i8 - 1) / 15) * 2) + (i4 + 1)) / 2;
            for (int i10 = 0; i10 < i8; i10++) {
                iArr[(i8 - i10) - 1] = (i9 - r15) - 1;
                iArr[i8 + i10] = (i10 / 15) + i10 + i9 + 1;
            }
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= i3) {
                break;
            }
            int i13 = ((i3 - i11) << i6) + (z ? 9 : 12);
            int i14 = i11 << 1;
            int i15 = (i4 - 1) - i14;
            int i16 = 0;
            while (i16 < i13) {
                int i17 = i16 << 1;
                int i18 = 0;
                while (i18 < i6) {
                    int i19 = i14 + i18;
                    int i20 = i14 + i16;
                    zArr[i12 + i17 + i18] = bVar.b(iArr[i19], iArr[i20]);
                    int i21 = i15 - i18;
                    zArr[(i13 * 2) + i12 + i17 + i18] = bVar.b(iArr[i20], iArr[i21]);
                    int i22 = i15 - i16;
                    zArr[(i13 * 4) + i12 + i17 + i18] = bVar.b(iArr[i21], iArr[i22]);
                    zArr[(i13 * 6) + i12 + i17 + i18] = bVar.b(iArr[i22], iArr[i19]);
                    i18++;
                    z = z;
                    i3 = i3;
                    i6 = 2;
                }
                i16++;
                i6 = 2;
            }
            i12 += i13 << 3;
            i11++;
            i3 = i3;
            i6 = 2;
        }
        c.e.c.u.a aVar3 = this.f1367f;
        int i23 = aVar3.f1362e;
        int i24 = 8;
        if (i23 <= 2) {
            aVar2 = c.e.c.v.m.a.f1411c;
            i2 = 6;
        } else if (i23 <= 8) {
            aVar2 = c.e.c.v.m.a.f1415g;
            i2 = 8;
        } else if (i23 <= 22) {
            i2 = 10;
            aVar2 = c.e.c.v.m.a.f1410b;
        } else {
            aVar2 = c.e.c.v.m.a.a;
        }
        int i25 = aVar3.f1361d;
        int i26 = i5 / i2;
        if (i26 < i25) {
            throw g.getFormatInstance();
        }
        int i27 = i5 % i2;
        int[] iArr2 = new int[i26];
        int i28 = 0;
        while (i28 < i26) {
            iArr2[i28] = b(zArr, i27, i2);
            i28++;
            i27 += i2;
        }
        try {
            new c(aVar2).a(iArr2, i26 - i25);
            int i29 = 1;
            int i30 = (1 << i2) - 1;
            int i31 = 0;
            int i32 = 0;
            while (i31 < i25) {
                int i33 = iArr2[i31];
                if (i33 == 0 || i33 == i30) {
                    throw g.getFormatInstance();
                }
                if (i33 == i29 || i33 == i30 - 1) {
                    i32++;
                }
                i31++;
                i29 = 1;
            }
            int i34 = (i25 * i2) - i32;
            boolean[] zArr2 = new boolean[i34];
            int i35 = 0;
            for (int i36 = 0; i36 < i25; i36++) {
                int i37 = iArr2[i36];
                int i38 = 1;
                if (i37 == 1 || i37 == i30 - 1) {
                    Arrays.fill(zArr2, i35, (i35 + i2) - 1, i37 > 1);
                    i35 = (i2 - 1) + i35;
                } else {
                    int i39 = i2 - 1;
                    while (i39 >= 0) {
                        int i40 = i35 + 1;
                        zArr2[i35] = ((i38 << i39) & i37) != 0;
                        i39--;
                        i35 = i40;
                        i38 = 1;
                    }
                }
            }
            int i41 = (i34 + 7) / 8;
            byte[] bArr = new byte[i41];
            for (int i42 = 0; i42 < i41; i42++) {
                int i43 = i42 << 3;
                int i44 = i34 - i43;
                bArr[i42] = (byte) (i44 >= 8 ? b(zArr2, i43, 8) : b(zArr2, i43, i44) << (8 - i44));
            }
            EnumC0050a enumC0050a = EnumC0050a.UPPER;
            StringBuilder sb = new StringBuilder(20);
            EnumC0050a enumC0050a2 = enumC0050a;
            int i45 = 0;
            while (i45 < i34) {
                EnumC0050a enumC0050a3 = EnumC0050a.BINARY;
                if (enumC0050a != enumC0050a3) {
                    EnumC0050a enumC0050a4 = EnumC0050a.DIGIT;
                    int i46 = enumC0050a == enumC0050a4 ? 4 : 5;
                    if (i34 - i45 < i46) {
                        break;
                    }
                    int iB = b(zArr2, i45, i46);
                    i45 += i46;
                    int iOrdinal = enumC0050a.ordinal();
                    if (iOrdinal == 0) {
                        str = a[iB];
                    } else if (iOrdinal == 1) {
                        str = f1363b[iB];
                    } else if (iOrdinal == 2) {
                        str = f1364c[iB];
                    } else if (iOrdinal == 3) {
                        str = f1366e[iB];
                    } else {
                        if (iOrdinal != 4) {
                            throw new IllegalStateException("Bad table");
                        }
                        str = f1365d[iB];
                    }
                    if (str.startsWith("CTRL_")) {
                        char cCharAt = str.charAt(5);
                        enumC0050a2 = cCharAt != 'B' ? cCharAt != 'D' ? cCharAt != 'P' ? cCharAt != 'L' ? cCharAt != 'M' ? EnumC0050a.UPPER : EnumC0050a.MIXED : EnumC0050a.LOWER : EnumC0050a.PUNCT : enumC0050a4 : enumC0050a3;
                        if (str.charAt(6) != 'L') {
                            i24 = 8;
                            EnumC0050a enumC0050a5 = enumC0050a2;
                            enumC0050a2 = enumC0050a;
                            enumC0050a = enumC0050a5;
                        }
                    } else {
                        sb.append(str);
                    }
                    enumC0050a = enumC0050a2;
                    i24 = 8;
                } else {
                    if (i34 - i45 < 5) {
                        break;
                    }
                    int iB2 = b(zArr2, i45, 5);
                    i45 += 5;
                    if (iB2 == 0) {
                        if (i34 - i45 < 11) {
                            break;
                        }
                        iB2 = b(zArr2, i45, 11) + 31;
                        i45 += 11;
                    }
                    int i47 = 0;
                    while (true) {
                        if (i47 >= iB2) {
                            break;
                        }
                        if (i34 - i45 < i24) {
                            i45 = i34;
                            break;
                        }
                        sb.append((char) b(zArr2, i45, i24));
                        i45 += 8;
                        i47++;
                    }
                    enumC0050a = enumC0050a2;
                    i24 = 8;
                }
            }
            e eVar = new e(bArr, sb.toString(), null, null);
            eVar.f1383b = i34;
            return eVar;
        } catch (c.e.c.v.m.e e2) {
            throw g.getFormatInstance(e2);
        }
    }
}
