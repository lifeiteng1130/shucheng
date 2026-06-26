package okio.internal;

import androidx.exifinterface.media.ExifInterface;
import c.a.a.a.a;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.bw;
import f.c0.c.j;
import f.h0.k;
import f.x.e;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0080\b¢\u0006\u0004\b\t\u0010\b\u001a$\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0016\u001a\u00020\u0015*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0015*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a4\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a4\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u001e\u0010 \u001a\u001c\u0010\"\u001a\u00020\u001d*\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010\"\u001a\u00020\u001d*\u00020\u00002\u0006\u0010!\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b\"\u0010$\u001a\u001c\u0010&\u001a\u00020\u001d*\u00020\u00002\u0006\u0010%\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b&\u0010#\u001a\u001c\u0010&\u001a\u00020\u001d*\u00020\u00002\u0006\u0010%\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b&\u0010$\u001a$\u0010(\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\nH\u0080\b¢\u0006\u0004\b(\u0010)\u001a$\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\nH\u0080\b¢\u0006\u0004\b*\u0010+\u001a$\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\nH\u0080\b¢\u0006\u0004\b*\u0010)\u001a\u001e\u0010-\u001a\u00020\u001d*\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010,H\u0080\b¢\u0006\u0004\b-\u0010.\u001a\u0014\u0010/\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b/\u0010\u0014\u001a\u001c\u00100\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b0\u00101\u001a\u0018\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b3\u00104\u001a$\u00105\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b5\u00106\u001a\u0014\u00107\u001a\u00020\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b7\u00108\u001a\u0016\u00109\u001a\u0004\u0018\u00010\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b9\u00108\u001a\u0014\u0010:\u001a\u00020\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b:\u00108\u001a+\u0010>\u001a\u00020=*\u00020\u00002\u0006\u0010<\u001a\u00020;2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0000¢\u0006\u0004\b>\u0010?\u001a\u0017\u0010B\u001a\u00020\n2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010C\u001a\u0014\u0010D\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\bD\u0010\u0003\u001a\u001f\u0010G\u001a\u00020\n2\u0006\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\nH\u0002¢\u0006\u0004\bG\u0010H\"\u001c\u0010J\u001a\u00020I8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M¨\u0006N"}, d2 = {"Lokio/ByteString;", "", "commonUtf8", "(Lokio/ByteString;)Ljava/lang/String;", "commonBase64", "commonBase64Url", "commonHex", "commonToAsciiLowercase", "(Lokio/ByteString;)Lokio/ByteString;", "commonToAsciiUppercase", "", "beginIndex", "endIndex", "commonSubstring", "(Lokio/ByteString;II)Lokio/ByteString;", "pos", "", "commonGetByte", "(Lokio/ByteString;I)B", "commonGetSize", "(Lokio/ByteString;)I", "", "commonToByteArray", "(Lokio/ByteString;)[B", "commonInternalArray", "offset", "other", "otherOffset", "byteCount", "", "commonRangeEquals", "(Lokio/ByteString;ILokio/ByteString;II)Z", "(Lokio/ByteString;I[BII)Z", "prefix", "commonStartsWith", "(Lokio/ByteString;Lokio/ByteString;)Z", "(Lokio/ByteString;[B)Z", "suffix", "commonEndsWith", "fromIndex", "commonIndexOf", "(Lokio/ByteString;[BI)I", "commonLastIndexOf", "(Lokio/ByteString;Lokio/ByteString;I)I", "", "commonEquals", "(Lokio/ByteString;Ljava/lang/Object;)Z", "commonHashCode", "commonCompareTo", "(Lokio/ByteString;Lokio/ByteString;)I", "data", "commonOf", "([B)Lokio/ByteString;", "commonToByteString", "([BII)Lokio/ByteString;", "commonEncodeUtf8", "(Ljava/lang/String;)Lokio/ByteString;", "commonDecodeBase64", "commonDecodeHex", "Lokio/Buffer;", "buffer", "Lf/v;", "commonWrite", "(Lokio/ByteString;Lokio/Buffer;II)V", "", ai.aD, "decodeHexDigit", "(C)I", "commonToString", ai.az, "codePointCount", "codePointIndexToCharIndex", "([BI)I", "", "HEX_DIGIT_CHARS", "[C", "getHEX_DIGIT_CHARS", "()[C", "okio"}, k = 2, mv = {1, 4, 0})
public final class ByteStringKt {

    @NotNull
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0068, code lost:
    
        return -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:138:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int codePointIndexToCharIndex(byte[] r19, int r20) {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }

    @NotNull
    public static final String commonBase64(@NotNull ByteString byteString) {
        j.e(byteString, "$this$commonBase64");
        return Base64.encodeBase64$default(byteString.getData(), null, 1, null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull ByteString byteString) {
        j.e(byteString, "$this$commonBase64Url");
        return Base64.encodeBase64(byteString.getData(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        j.e(byteString, "$this$commonCompareTo");
        j.e(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int iMin = Math.min(size, size2);
        for (int i2 = 0; i2 < iMin; i2++) {
            int i3 = byteString.getByte(i2) & ExifInterface.MARKER;
            int i4 = byteString2.getByte(i2) & ExifInterface.MARKER;
            if (i3 != i4) {
                return i3 < i4 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull String str) {
        j.e(str, "$this$commonDecodeBase64");
        byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (bArrDecodeBase64ToArray != null) {
            return new ByteString(bArrDecodeBase64ToArray);
        }
        return null;
    }

    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String str) {
        j.e(str, "$this$commonDecodeHex");
        if (!(str.length() % 2 == 0)) {
            throw new IllegalArgumentException(a.i("Unexpected hex string: ", str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (decodeHexDigit(str.charAt(i3 + 1)) + (decodeHexDigit(str.charAt(i3)) << 4));
        }
        return new ByteString(bArr);
    }

    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull String str) {
        j.e(str, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        j.e(byteString, "$this$commonEndsWith");
        j.e(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEquals(@NotNull ByteString byteString, @Nullable Object obj) {
        j.e(byteString, "$this$commonEquals");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData().length && byteString2.rangeEquals(0, byteString.getData(), 0, byteString.getData().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@NotNull ByteString byteString, int i2) {
        j.e(byteString, "$this$commonGetByte");
        return byteString.getData()[i2];
    }

    public static final int commonGetSize(@NotNull ByteString byteString) {
        j.e(byteString, "$this$commonGetSize");
        return byteString.getData().length;
    }

    public static final int commonHashCode(@NotNull ByteString byteString) {
        j.e(byteString, "$this$commonHashCode");
        int hashCode$okio = byteString.getHashCode();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int iHashCode = Arrays.hashCode(byteString.getData());
        byteString.setHashCode$okio(iHashCode);
        return iHashCode;
    }

    @NotNull
    public static final String commonHex(@NotNull ByteString byteString) {
        j.e(byteString, "$this$commonHex");
        char[] cArr = new char[byteString.getData().length * 2];
        int i2 = 0;
        for (byte b2 : byteString.getData()) {
            int i3 = i2 + 1;
            cArr[i2] = getHEX_DIGIT_CHARS()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = getHEX_DIGIT_CHARS()[b2 & bw.m];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(@NotNull ByteString byteString, @NotNull byte[] bArr, int i2) {
        j.e(byteString, "$this$commonIndexOf");
        j.e(bArr, "other");
        int length = byteString.getData().length - bArr.length;
        int iMax = Math.max(i2, 0);
        if (iMax > length) {
            return -1;
        }
        while (!Util.arrayRangeEquals(byteString.getData(), iMax, bArr, 0, bArr.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull ByteString byteString) {
        j.e(byteString, "$this$commonInternalArray");
        return byteString.getData();
    }

    public static final int commonLastIndexOf(@NotNull ByteString byteString, @NotNull ByteString byteString2, int i2) {
        j.e(byteString, "$this$commonLastIndexOf");
        j.e(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i2);
    }

    @NotNull
    public static final ByteString commonOf(@NotNull byte[] bArr) {
        j.e(bArr, "data");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(bArrCopyOf);
    }

    public static final boolean commonRangeEquals(@NotNull ByteString byteString, int i2, @NotNull ByteString byteString2, int i3, int i4) {
        j.e(byteString, "$this$commonRangeEquals");
        j.e(byteString2, "other");
        return byteString2.rangeEquals(i3, byteString.getData(), i2, i4);
    }

    public static final boolean commonStartsWith(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        j.e(byteString, "$this$commonStartsWith");
        j.e(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull ByteString byteString, int i2, int i3) {
        j.e(byteString, "$this$commonSubstring");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (!(i3 <= byteString.getData().length)) {
            throw new IllegalArgumentException(a.n(a.r("endIndex > length("), byteString.getData().length, ')').toString());
        }
        if (i3 - i2 >= 0) {
            return (i2 == 0 && i3 == byteString.getData().length) ? byteString : new ByteString(e.f(byteString.getData(), i2, i3));
        }
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    }

    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull ByteString byteString) {
        byte b2;
        j.e(byteString, "$this$commonToAsciiLowercase");
        for (int i2 = 0; i2 < byteString.getData().length; i2++) {
            byte b3 = byteString.getData()[i2];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] data$okio = byteString.getData();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i2] = (byte) (b3 + 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b5 = bArrCopyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        bArrCopyOf[i3] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull ByteString byteString) {
        byte b2;
        j.e(byteString, "$this$commonToAsciiUppercase");
        for (int i2 = 0; i2 < byteString.getData().length; i2++) {
            byte b3 = byteString.getData()[i2];
            byte b4 = (byte) 97;
            if (b3 >= b4 && b3 <= (b2 = (byte) 122)) {
                byte[] data$okio = byteString.getData();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i2] = (byte) (b3 - 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b5 = bArrCopyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        bArrCopyOf[i3] = (byte) (b5 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull ByteString byteString) {
        j.e(byteString, "$this$commonToByteArray");
        byte[] data$okio = byteString.getData();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    @NotNull
    public static final ByteString commonToByteString(@NotNull byte[] bArr, int i2, int i3) {
        j.e(bArr, "$this$commonToByteString");
        Util.checkOffsetAndCount(bArr.length, i2, i3);
        return new ByteString(e.f(bArr, i2, i3 + i2));
    }

    @NotNull
    public static final String commonToString(@NotNull ByteString byteString) {
        j.e(byteString, "$this$commonToString");
        if (byteString.getData().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData(), 64);
        if (iCodePointIndexToCharIndex == -1) {
            if (byteString.getData().length <= 64) {
                StringBuilder sbR = a.r("[hex=");
                sbR.append(byteString.hex());
                sbR.append(']');
                return sbR.toString();
            }
            StringBuilder sbR2 = a.r("[size=");
            sbR2.append(byteString.getData().length);
            sbR2.append(" hex=");
            if (!(64 <= byteString.getData().length)) {
                throw new IllegalArgumentException(a.n(a.r("endIndex > length("), byteString.getData().length, ')').toString());
            }
            if (64 != byteString.getData().length) {
                byteString = new ByteString(e.f(byteString.getData(), 0, 64));
            }
            sbR2.append(byteString.hex());
            sbR2.append("…]");
            return sbR2.toString();
        }
        String strUtf8 = byteString.utf8();
        Objects.requireNonNull(strUtf8, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strUtf8.substring(0, iCodePointIndexToCharIndex);
        j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strC = k.C(k.C(k.C(strSubstring, "\\", "\\\\", false, 4), "\n", "\\n", false, 4), "\r", "\\r", false, 4);
        if (iCodePointIndexToCharIndex >= strUtf8.length()) {
            return "[text=" + strC + ']';
        }
        StringBuilder sbR3 = a.r("[size=");
        sbR3.append(byteString.getData().length);
        sbR3.append(" text=");
        sbR3.append(strC);
        sbR3.append("…]");
        return sbR3.toString();
    }

    @NotNull
    public static final String commonUtf8(@NotNull ByteString byteString) {
        j.e(byteString, "$this$commonUtf8");
        String utf8$okio = byteString.getUtf8();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@NotNull ByteString byteString, @NotNull Buffer buffer, int i2, int i3) {
        j.e(byteString, "$this$commonWrite");
        j.e(buffer, "buffer");
        buffer.write(byteString.getData(), i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int decodeHexDigit(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(@NotNull ByteString byteString, @NotNull byte[] bArr) {
        j.e(byteString, "$this$commonEndsWith");
        j.e(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonLastIndexOf(@NotNull ByteString byteString, @NotNull byte[] bArr, int i2) {
        j.e(byteString, "$this$commonLastIndexOf");
        j.e(bArr, "other");
        for (int iMin = Math.min(i2, byteString.getData().length - bArr.length); iMin >= 0; iMin--) {
            if (Util.arrayRangeEquals(byteString.getData(), iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@NotNull ByteString byteString, int i2, @NotNull byte[] bArr, int i3, int i4) {
        j.e(byteString, "$this$commonRangeEquals");
        j.e(bArr, "other");
        return i2 >= 0 && i2 <= byteString.getData().length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && Util.arrayRangeEquals(byteString.getData(), i2, bArr, i3, i4);
    }

    public static final boolean commonStartsWith(@NotNull ByteString byteString, @NotNull byte[] bArr) {
        j.e(byteString, "$this$commonStartsWith");
        j.e(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }
}
