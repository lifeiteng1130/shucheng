package okio;

import androidx.media.AudioAttributesCompat;
import c.a.a.a.a;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: Utf8.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0011\u001a'\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0080\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a;\u0010\u0013\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a;\u0010\u0016\u001a\u00020\u0011*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a;\u0010\u0019\u001a\u00020\u0011*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017\u001a;\u0010\u001a\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a;\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001b\u001a;\u0010\u001d\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001b\"\u0016\u0010\u001e\u001a\u00020\u00018\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\"\u0016\u0010 \u001a\u00020\u00018\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b \u0010\u001f\"\u0016\u0010!\u001a\u00020\u00188\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b!\u0010\"\"\u0016\u0010#\u001a\u00020\u00018\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b#\u0010\u001f\"\u0016\u0010$\u001a\u00020\u00018\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b$\u0010\u001f\"\u0016\u0010%\u001a\u00020\f8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b%\u0010&\"\u0016\u0010'\u001a\u00020\u00018\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b'\u0010\u001f\"\u0016\u0010(\u001a\u00020\u00018\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b(\u0010\u001f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"", "", "beginIndex", "endIndex", "", "size", "(Ljava/lang/String;II)J", "utf8Size", "codePoint", "", "isIsoControl", "(I)Z", "", "byte", "isUtf8Continuation", "(B)Z", "Lkotlin/Function1;", "Lf/v;", "yield", "processUtf8Bytes", "(Ljava/lang/String;IILf/c0/b/l;)V", "", "processUtf8CodePoints", "([BIILf/c0/b/l;)V", "", "processUtf16Chars", "process2Utf8Bytes", "([BIILf/c0/b/l;)I", "process3Utf8Bytes", "process4Utf8Bytes", "REPLACEMENT_CODE_POINT", OptRuntime.GeneratorState.resumptionPoint_TYPE, "MASK_3BYTES", "REPLACEMENT_CHARACTER", "C", "MASK_2BYTES", "LOG_SURROGATE_HEADER", "REPLACEMENT_BYTE", "B", "HIGH_SURROGATE_HEADER", "MASK_4BYTES", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "Utf8")
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i2) {
        return (i2 >= 0 && 31 >= i2) || (127 <= i2 && 159 >= i2);
    }

    public static final boolean isUtf8Continuation(byte b2) {
        return (b2 & 192) == 128;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] bArr, int i2, int i3, @NotNull l<? super Integer, v> lVar) {
        j.e(bArr, "$this$process2Utf8Bytes");
        j.e(lVar, "yield");
        int i4 = i2 + 1;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i3 <= i4) {
            lVar.invoke(numValueOf);
            return 1;
        }
        byte b2 = bArr[i2];
        byte b3 = bArr[i4];
        if (!((b3 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 1;
        }
        int i5 = (b3 ^ 3968) ^ (b2 << 6);
        if (i5 < 128) {
            lVar.invoke(numValueOf);
            return 2;
        }
        lVar.invoke(Integer.valueOf(i5));
        return 2;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] bArr, int i2, int i3, @NotNull l<? super Integer, v> lVar) {
        j.e(bArr, "$this$process3Utf8Bytes");
        j.e(lVar, "yield");
        int i4 = i2 + 2;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i3 <= i4) {
            lVar.invoke(numValueOf);
            int i5 = i2 + 1;
            if (i3 > i5) {
                if ((bArr[i5] & 192) == 128) {
                    return 2;
                }
            }
            return 1;
        }
        byte b2 = bArr[i2];
        byte b3 = bArr[i2 + 1];
        if (!((b3 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 1;
        }
        byte b4 = bArr[i4];
        if (!((b4 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 2;
        }
        int i6 = ((b4 ^ (-123008)) ^ (b3 << 6)) ^ (b2 << 12);
        if (i6 < 2048) {
            lVar.invoke(numValueOf);
            return 3;
        }
        if (55296 <= i6 && 57343 >= i6) {
            lVar.invoke(numValueOf);
            return 3;
        }
        lVar.invoke(Integer.valueOf(i6));
        return 3;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] bArr, int i2, int i3, @NotNull l<? super Integer, v> lVar) {
        j.e(bArr, "$this$process4Utf8Bytes");
        j.e(lVar, "yield");
        int i4 = i2 + 3;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i3 <= i4) {
            lVar.invoke(numValueOf);
            int i5 = i2 + 1;
            if (i3 > i5) {
                if ((bArr[i5] & 192) == 128) {
                    int i6 = i2 + 2;
                    if (i3 > i6) {
                        if ((bArr[i6] & 192) == 128) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b2 = bArr[i2];
        byte b3 = bArr[i2 + 1];
        if (!((b3 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 1;
        }
        byte b4 = bArr[i2 + 2];
        if (!((b4 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 2;
        }
        byte b5 = bArr[i4];
        if (!((b5 & 192) == 128)) {
            lVar.invoke(numValueOf);
            return 3;
        }
        int i7 = (((b5 ^ 3678080) ^ (b4 << 6)) ^ (b3 << 12)) ^ (b2 << 18);
        if (i7 > 1114111) {
            lVar.invoke(numValueOf);
            return 4;
        }
        if (55296 <= i7 && 57343 >= i7) {
            lVar.invoke(numValueOf);
            return 4;
        }
        if (i7 < 65536) {
            lVar.invoke(numValueOf);
            return 4;
        }
        lVar.invoke(Integer.valueOf(i7));
        return 4;
    }

    public static final void processUtf16Chars(@NotNull byte[] bArr, int i2, int i3, @NotNull l<? super Character, v> lVar) {
        int i4;
        j.e(bArr, "$this$processUtf16Chars");
        j.e(lVar, "yield");
        int i5 = i2;
        while (i5 < i3) {
            byte b2 = bArr[i5];
            if (b2 >= 0) {
                lVar.invoke(Character.valueOf((char) b2));
                i5++;
                while (i5 < i3 && bArr[i5] >= 0) {
                    lVar.invoke(Character.valueOf((char) bArr[i5]));
                    i5++;
                }
            } else {
                if ((b2 >> 5) == -2) {
                    int i6 = i5 + 1;
                    if (i3 > i6) {
                        byte b3 = bArr[i5];
                        byte b4 = bArr[i6];
                        if ((b4 & 192) == 128) {
                            int i7 = (b4 ^ 3968) ^ (b3 << 6);
                            lVar.invoke(Character.valueOf(i7 < 128 ? (char) REPLACEMENT_CODE_POINT : (char) i7));
                            i4 = 2;
                        }
                    }
                    lVar.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                    i4 = 1;
                } else if ((b2 >> 4) == -2) {
                    int i8 = i5 + 2;
                    if (i3 <= i8) {
                        lVar.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                        int i9 = i5 + 1;
                        if (i3 > i9) {
                            if ((bArr[i9] & 192) == 128) {
                                i4 = 2;
                            }
                        }
                        i4 = 1;
                    } else {
                        byte b5 = bArr[i5];
                        byte b6 = bArr[i5 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i8];
                            if ((b7 & 192) == 128) {
                                int i10 = ((b7 ^ (-123008)) ^ (b6 << 6)) ^ (b5 << 12);
                                lVar.invoke(Character.valueOf((i10 >= 2048 && (55296 > i10 || 57343 < i10)) ? (char) i10 : (char) REPLACEMENT_CODE_POINT));
                                i4 = 3;
                            } else {
                                lVar.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                i4 = 2;
                            }
                        } else {
                            lVar.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            i4 = 1;
                        }
                    }
                } else if ((b2 >> 3) == -2) {
                    int i11 = i5 + 3;
                    if (i3 <= i11) {
                        lVar.invoke((char) 65533);
                        int i12 = i5 + 1;
                        if (i3 > i12) {
                            if ((bArr[i12] & 192) == 128) {
                                int i13 = i5 + 2;
                                if (i3 > i13) {
                                    if ((bArr[i13] & 192) == 128) {
                                        i4 = 3;
                                    }
                                }
                                i4 = 2;
                            }
                        }
                        i4 = 1;
                    } else {
                        byte b8 = bArr[i5];
                        byte b9 = bArr[i5 + 1];
                        if ((b9 & 192) == 128) {
                            byte b10 = bArr[i5 + 2];
                            if ((b10 & 192) == 128) {
                                byte b11 = bArr[i11];
                                if ((b11 & 192) == 128) {
                                    int i14 = (((b11 ^ 3678080) ^ (b10 << 6)) ^ (b9 << 12)) ^ (b8 << 18);
                                    if (i14 <= 1114111 && ((55296 > i14 || 57343 < i14) && i14 >= 65536 && i14 != 65533)) {
                                        lVar.invoke(Character.valueOf((char) ((i14 >>> 10) + HIGH_SURROGATE_HEADER)));
                                        lVar.invoke(Character.valueOf((char) ((i14 & AudioAttributesCompat.FLAG_ALL) + LOG_SURROGATE_HEADER)));
                                    } else {
                                        lVar.invoke((char) 65533);
                                    }
                                    i4 = 4;
                                } else {
                                    lVar.invoke((char) 65533);
                                    i4 = 3;
                                }
                            } else {
                                lVar.invoke((char) 65533);
                                i4 = 2;
                            }
                        } else {
                            lVar.invoke((char) 65533);
                            i4 = 1;
                        }
                    }
                } else {
                    lVar.invoke((char) 65533);
                    i5++;
                }
                i5 += i4;
            }
        }
    }

    public static final void processUtf8Bytes(@NotNull String str, int i2, int i3, @NotNull l<? super Byte, v> lVar) {
        int i4;
        char cCharAt;
        j.e(str, "$this$processUtf8Bytes");
        j.e(lVar, "yield");
        while (i2 < i3) {
            char cCharAt2 = str.charAt(i2);
            if (j.g(cCharAt2, 128) < 0) {
                lVar.invoke(Byte.valueOf((byte) cCharAt2));
                i2++;
                while (i2 < i3 && j.g(str.charAt(i2), 128) < 0) {
                    lVar.invoke(Byte.valueOf((byte) str.charAt(i2)));
                    i2++;
                }
            } else {
                if (j.g(cCharAt2, 2048) < 0) {
                    lVar.invoke(Byte.valueOf((byte) ((cCharAt2 >> 6) | 192)));
                    lVar.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (55296 > cCharAt2 || 57343 < cCharAt2) {
                    lVar.invoke(Byte.valueOf((byte) ((cCharAt2 >> '\f') | 224)));
                    lVar.invoke(Byte.valueOf((byte) (((cCharAt2 >> 6) & 63) | 128)));
                    lVar.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (j.g(cCharAt2, 56319) > 0 || i3 <= (i4 = i2 + 1) || 56320 > (cCharAt = str.charAt(i4)) || 57343 < cCharAt) {
                    lVar.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int iCharAt = (str.charAt(i4) + (cCharAt2 << '\n')) - 56613888;
                    lVar.invoke(Byte.valueOf((byte) ((iCharAt >> 18) | 240)));
                    lVar.invoke(Byte.valueOf((byte) (((iCharAt >> 12) & 63) | 128)));
                    lVar.invoke(Byte.valueOf((byte) (((iCharAt >> 6) & 63) | 128)));
                    lVar.invoke(Byte.valueOf((byte) ((iCharAt & 63) | 128)));
                    i2 += 2;
                }
                i2++;
            }
        }
    }

    public static final void processUtf8CodePoints(@NotNull byte[] bArr, int i2, int i3, @NotNull l<? super Integer, v> lVar) {
        int i4;
        j.e(bArr, "$this$processUtf8CodePoints");
        j.e(lVar, "yield");
        int i5 = i2;
        while (i5 < i3) {
            byte b2 = bArr[i5];
            if (b2 >= 0) {
                lVar.invoke(Integer.valueOf(b2));
                i5++;
                while (i5 < i3 && bArr[i5] >= 0) {
                    lVar.invoke(Integer.valueOf(bArr[i5]));
                    i5++;
                }
            } else {
                if ((b2 >> 5) == -2) {
                    int i6 = i5 + 1;
                    if (i3 > i6) {
                        byte b3 = bArr[i5];
                        byte b4 = bArr[i6];
                        if ((b4 & 192) == 128) {
                            int i7 = (b4 ^ 3968) ^ (b3 << 6);
                            lVar.invoke(i7 < 128 ? Integer.valueOf(REPLACEMENT_CODE_POINT) : Integer.valueOf(i7));
                            i4 = 2;
                        }
                    }
                    lVar.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    i4 = 1;
                } else if ((b2 >> 4) == -2) {
                    int i8 = i5 + 2;
                    if (i3 <= i8) {
                        lVar.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        int i9 = i5 + 1;
                        if (i3 > i9) {
                            if ((bArr[i9] & 192) == 128) {
                                i4 = 2;
                            }
                        }
                        i4 = 1;
                    } else {
                        byte b5 = bArr[i5];
                        byte b6 = bArr[i5 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i8];
                            if ((b7 & 192) == 128) {
                                int i10 = ((b7 ^ (-123008)) ^ (b6 << 6)) ^ (b5 << 12);
                                lVar.invoke((i10 >= 2048 && (55296 > i10 || 57343 < i10)) ? Integer.valueOf(i10) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                                i4 = 3;
                            } else {
                                lVar.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                i4 = 2;
                            }
                        } else {
                            lVar.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            i4 = 1;
                        }
                    }
                } else if ((b2 >> 3) == -2) {
                    int i11 = i5 + 3;
                    if (i3 <= i11) {
                        lVar.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        int i12 = i5 + 1;
                        if (i3 > i12) {
                            if ((bArr[i12] & 192) == 128) {
                                int i13 = i5 + 2;
                                if (i3 > i13) {
                                    if ((bArr[i13] & 192) == 128) {
                                        i4 = 3;
                                    }
                                }
                                i4 = 2;
                            }
                        }
                        i4 = 1;
                    } else {
                        byte b8 = bArr[i5];
                        byte b9 = bArr[i5 + 1];
                        if ((b9 & 192) == 128) {
                            byte b10 = bArr[i5 + 2];
                            if ((b10 & 192) == 128) {
                                byte b11 = bArr[i11];
                                if ((b11 & 192) == 128) {
                                    int i14 = (((b11 ^ 3678080) ^ (b10 << 6)) ^ (b9 << 12)) ^ (b8 << 18);
                                    lVar.invoke((i14 <= 1114111 && (55296 > i14 || 57343 < i14) && i14 >= 65536) ? Integer.valueOf(i14) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    i4 = 4;
                                } else {
                                    lVar.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    i4 = 3;
                                }
                            } else {
                                lVar.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                i4 = 2;
                            }
                        } else {
                            lVar.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            i4 = 1;
                        }
                    }
                } else {
                    lVar.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    i5++;
                }
                i5 += i4;
            }
        }
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str) {
        return size$default(str, 0, 0, 3, null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i2) {
        return size$default(str, i2, 0, 2, null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i2, int i3) {
        int i4;
        j.e(str, "$this$utf8Size");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a.G("beginIndex < 0: ", i2).toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(a.e("endIndex < beginIndex: ", i3, " < ", i2).toString());
        }
        if (!(i3 <= str.length())) {
            StringBuilder sbS = a.s("endIndex > string.length: ", i3, " > ");
            sbS.append(str.length());
            throw new IllegalArgumentException(sbS.toString().toString());
        }
        long j2 = 0;
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                j2++;
            } else {
                if (cCharAt < 2048) {
                    i4 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i4 = 3;
                } else {
                    int i5 = i2 + 1;
                    char cCharAt2 = i5 < i3 ? str.charAt(i5) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j2++;
                        i2 = i5;
                    } else {
                        j2 += (long) 4;
                        i2 += 2;
                    }
                }
                j2 += (long) i4;
            }
            i2++;
        }
        return j2;
    }

    public static /* synthetic */ long size$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return size(str, i2, i3);
    }
}
