package okio;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.bw;
import f.c0.c.j;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: okio.-Base64, reason: invalid class name */
/* JADX INFO: compiled from: -Base64.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\f\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u0000*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0007\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u001c\u0010\u000b\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"", "", "decodeBase64ToArray", "(Ljava/lang/String;)[B", "map", "encodeBase64", "([B[B)Ljava/lang/String;", "BASE64_URL_SAFE", "[B", "getBASE64_URL_SAFE", "()[B", "BASE64", "getBASE64", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-Base64")
public final class Base64 {

    @NotNull
    private static final byte[] BASE64;

    @NotNull
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    @Nullable
    public static final byte[] decodeBase64ToArray(@NotNull String str) {
        int i2;
        char cCharAt;
        j.e(str, "$this$decodeBase64ToArray");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i3 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt2 = str.charAt(i7);
            if ('A' <= cCharAt2 && 'Z' >= cCharAt2) {
                i2 = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && 'z' >= cCharAt2) {
                i2 = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && '9' >= cCharAt2) {
                i2 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i2 = 62;
            } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                i2 = 63;
            } else {
                if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i5 = (i5 << 6) | i2;
            i4++;
            if (i4 % 4 == 0) {
                int i8 = i6 + 1;
                bArr[i6] = (byte) (i5 >> 16);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (i5 >> 8);
                bArr[i9] = (byte) i5;
                i6 = i9 + 1;
            }
        }
        int i10 = i4 % 4;
        if (i10 == 1) {
            return null;
        }
        if (i10 == 2) {
            bArr[i6] = (byte) ((i5 << 12) >> 16);
            i6++;
        } else if (i10 == 3) {
            int i11 = i5 << 6;
            int i12 = i6 + 1;
            bArr[i6] = (byte) (i11 >> 16);
            i6 = i12 + 1;
            bArr[i12] = (byte) (i11 >> 8);
        }
        if (i6 == i3) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i6);
        j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf;
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        j.e(bArr, "$this$encodeBase64");
        j.e(bArr2, "map");
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            int i5 = i4 + 1;
            byte b3 = bArr[i4];
            int i6 = i5 + 1;
            byte b4 = bArr[i5];
            int i7 = i3 + 1;
            bArr3[i3] = bArr2[(b2 & ExifInterface.MARKER) >> 2];
            int i8 = i7 + 1;
            bArr3[i7] = bArr2[((b2 & 3) << 4) | ((b3 & ExifInterface.MARKER) >> 4)];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[((b3 & bw.m) << 2) | ((b4 & ExifInterface.MARKER) >> 6)];
            i3 = i9 + 1;
            bArr3[i9] = bArr2[b4 & Utf8.REPLACEMENT_BYTE];
            i2 = i6;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i2];
            int i10 = i3 + 1;
            bArr3[i3] = bArr2[(b5 & ExifInterface.MARKER) >> 2];
            int i11 = i10 + 1;
            bArr3[i10] = bArr2[(b5 & 3) << 4];
            byte b6 = (byte) 61;
            bArr3[i11] = b6;
            bArr3[i11 + 1] = b6;
        } else if (length2 == 2) {
            int i12 = i2 + 1;
            byte b7 = bArr[i2];
            byte b8 = bArr[i12];
            int i13 = i3 + 1;
            bArr3[i3] = bArr2[(b7 & ExifInterface.MARKER) >> 2];
            int i14 = i13 + 1;
            bArr3[i13] = bArr2[((b7 & 3) << 4) | ((b8 & ExifInterface.MARKER) >> 4)];
            bArr3[i14] = bArr2[(b8 & bw.m) << 2];
            bArr3[i14 + 1] = (byte) 61;
        }
        return Platform.toUtf8String(bArr3);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    @NotNull
    public static final byte[] getBASE64() {
        return BASE64;
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
