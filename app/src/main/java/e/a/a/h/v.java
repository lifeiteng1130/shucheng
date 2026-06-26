package e.a.a.h;

import androidx.exifinterface.media.ExifInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MD5Utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    @NotNull
    public static final String a(@Nullable String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            f.c0.c.j.d(messageDigest, "getInstance(\"MD5\")");
            byte[] bytes = str.getBytes(f.h0.a.a);
            f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            f.c0.c.j.d(bArrDigest, "md5.digest(str.toByteArray())");
            StringBuilder sb = new StringBuilder();
            int length = bArrDigest.length;
            int i2 = 0;
            while (i2 < length) {
                byte b2 = bArrDigest[i2];
                i2++;
                int i3 = b2 & ExifInterface.MARKER;
                if (i3 < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i3));
            }
            String string = sb.toString();
            f.c0.c.j.d(string, "stringBuffer.toString()");
            return string;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @NotNull
    public static final String b(@NotNull String str) {
        f.c0.c.j.e(str, "str");
        String strSubstring = a(str).substring(8, 24);
        f.c0.c.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
