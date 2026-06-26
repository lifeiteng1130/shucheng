package okio.internal;

import androidx.media.AudioAttributesCompat;
import c.a.a.a.a;
import f.c0.c.j;
import java.util.Arrays;
import kotlin.Metadata;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: -Utf8.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "", "beginIndex", "endIndex", "", "commonToUtf8String", "([BII)Ljava/lang/String;", "commonAsUtf8ToByteArray", "(Ljava/lang/String;)[B", "okio"}, k = 2, mv = {1, 4, 0})
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String str) {
        int i2;
        int i3;
        char cCharAt;
        j.e(str, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            char cCharAt2 = str.charAt(i4);
            if (j.g(cCharAt2, 128) >= 0) {
                int length2 = str.length();
                int i5 = i4;
                while (i4 < length2) {
                    char cCharAt3 = str.charAt(i4);
                    if (j.g(cCharAt3, 128) < 0) {
                        int i6 = i5 + 1;
                        bArr[i5] = (byte) cCharAt3;
                        i4++;
                        while (i4 < length2 && j.g(str.charAt(i4), 128) < 0) {
                            bArr[i6] = (byte) str.charAt(i4);
                            i4++;
                            i6++;
                        }
                        i5 = i6;
                    } else {
                        if (j.g(cCharAt3, 2048) < 0) {
                            int i7 = i5 + 1;
                            bArr[i5] = (byte) ((cCharAt3 >> 6) | 192);
                            byte b2 = (byte) ((cCharAt3 & '?') | 128);
                            i2 = i7 + 1;
                            bArr[i7] = b2;
                        } else if (55296 > cCharAt3 || 57343 < cCharAt3) {
                            int i8 = i5 + 1;
                            bArr[i5] = (byte) ((cCharAt3 >> '\f') | 224);
                            int i9 = i8 + 1;
                            bArr[i8] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            byte b3 = (byte) ((cCharAt3 & '?') | 128);
                            i2 = i9 + 1;
                            bArr[i9] = b3;
                        } else if (j.g(cCharAt3, 56319) > 0 || length2 <= (i3 = i4 + 1) || 56320 > (cCharAt = str.charAt(i3)) || 57343 < cCharAt) {
                            i2 = i5 + 1;
                            bArr[i5] = Utf8.REPLACEMENT_BYTE;
                        } else {
                            int iCharAt = (str.charAt(i3) + (cCharAt3 << '\n')) - 56613888;
                            int i10 = i5 + 1;
                            bArr[i5] = (byte) ((iCharAt >> 18) | 240);
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((iCharAt >> 12) & 63) | 128);
                            int i12 = i11 + 1;
                            bArr[i11] = (byte) (((iCharAt >> 6) & 63) | 128);
                            i2 = i12 + 1;
                            bArr[i12] = (byte) ((iCharAt & 63) | 128);
                            i4 += 2;
                            i5 = i2;
                        }
                        i4++;
                        i5 = i2;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i5);
                j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i4] = (byte) cCharAt2;
            i4++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        j.d(bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    @NotNull
    public static final String commonToUtf8String(@NotNull byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        j.e(bArr, "$this$commonToUtf8String");
        if (i2 < 0 || i3 > bArr.length || i2 > i3) {
            StringBuilder sbR = a.r("size=");
            sbR.append(bArr.length);
            sbR.append(" beginIndex=");
            sbR.append(i2);
            sbR.append(" endIndex=");
            sbR.append(i3);
            throw new ArrayIndexOutOfBoundsException(sbR.toString());
        }
        char[] cArr = new char[i3 - i2];
        int i8 = 0;
        while (i2 < i3) {
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                i4 = i8 + 1;
                cArr[i8] = (char) b2;
                i2++;
                while (i2 < i3 && bArr[i2] >= 0) {
                    cArr[i4] = (char) bArr[i2];
                    i2++;
                    i4++;
                }
            } else {
                if ((b2 >> 5) == -2) {
                    int i9 = i2 + 1;
                    if (i3 <= i9) {
                        i4 = i8 + 1;
                        cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    } else {
                        byte b3 = bArr[i2];
                        byte b4 = bArr[i9];
                        if ((b4 & 192) == 128) {
                            int i10 = (b4 ^ 3968) ^ (b3 << 6);
                            if (i10 < 128) {
                                i4 = i8 + 1;
                                cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else {
                                i4 = i8 + 1;
                                cArr[i8] = (char) i10;
                            }
                            i5 = 2;
                        } else {
                            i4 = i8 + 1;
                            cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        }
                    }
                    i5 = 1;
                } else if ((b2 >> 4) == -2) {
                    int i11 = i2 + 2;
                    if (i3 <= i11) {
                        i4 = i8 + 1;
                        cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        int i12 = i2 + 1;
                        if (i3 > i12) {
                            if ((bArr[i12] & 192) == 128) {
                                i5 = 2;
                            }
                        }
                        i5 = 1;
                    } else {
                        byte b5 = bArr[i2];
                        byte b6 = bArr[i2 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i11];
                            if ((b7 & 192) == 128) {
                                int i13 = ((b7 ^ (-123008)) ^ (b6 << 6)) ^ (b5 << 12);
                                if (i13 < 2048) {
                                    i4 = i8 + 1;
                                    cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                } else if (55296 <= i13 && 57343 >= i13) {
                                    i4 = i8 + 1;
                                    cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                } else {
                                    i4 = i8 + 1;
                                    cArr[i8] = (char) i13;
                                }
                                i5 = 3;
                            } else {
                                i4 = i8 + 1;
                                cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                i5 = 2;
                            }
                        } else {
                            i4 = i8 + 1;
                            cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            i5 = 1;
                        }
                    }
                } else {
                    if ((b2 >> 3) == -2) {
                        int i14 = i2 + 3;
                        if (i3 <= i14) {
                            i6 = i8 + 1;
                            cArr[i8] = 65533;
                            int i15 = i2 + 1;
                            if (i3 > i15) {
                                if ((bArr[i15] & 192) == 128) {
                                    int i16 = i2 + 2;
                                    if (i3 > i16) {
                                        if ((bArr[i16] & 192) == 128) {
                                            i7 = 3;
                                        }
                                    }
                                    i7 = 2;
                                }
                            }
                            i7 = 1;
                        } else {
                            byte b8 = bArr[i2];
                            byte b9 = bArr[i2 + 1];
                            if ((b9 & 192) == 128) {
                                byte b10 = bArr[i2 + 2];
                                if ((b10 & 192) == 128) {
                                    byte b11 = bArr[i14];
                                    if ((b11 & 192) == 128) {
                                        int i17 = (((b11 ^ 3678080) ^ (b10 << 6)) ^ (b9 << 12)) ^ (b8 << 18);
                                        if (i17 > 1114111) {
                                            i6 = i8 + 1;
                                            cArr[i8] = 65533;
                                        } else if ((55296 <= i17 && 57343 >= i17) || i17 < 65536 || i17 == 65533) {
                                            i6 = i8 + 1;
                                            cArr[i8] = 65533;
                                        } else {
                                            int i18 = i8 + 1;
                                            cArr[i8] = (char) ((i17 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                            char c2 = (char) ((i17 & AudioAttributesCompat.FLAG_ALL) + Utf8.LOG_SURROGATE_HEADER);
                                            i6 = i18 + 1;
                                            cArr[i18] = c2;
                                        }
                                        i7 = 4;
                                    } else {
                                        i6 = i8 + 1;
                                        cArr[i8] = 65533;
                                        i7 = 3;
                                    }
                                } else {
                                    i6 = i8 + 1;
                                    cArr[i8] = 65533;
                                    i7 = 2;
                                }
                            } else {
                                i6 = i8 + 1;
                                cArr[i8] = 65533;
                                i7 = 1;
                            }
                        }
                        i2 += i7;
                    } else {
                        i6 = i8 + 1;
                        cArr[i8] = 65533;
                        i2++;
                    }
                    i8 = i6;
                }
                i2 += i5;
            }
            i8 = i4;
        }
        return new String(cArr, 0, i8);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        return commonToUtf8String(bArr, i2, i3);
    }
}
