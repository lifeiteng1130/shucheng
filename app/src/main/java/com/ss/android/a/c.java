package com.ss.android.a;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/* JADX INFO: compiled from: TTMd5.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: compiled from: TTMd5.java */
    public static class a {
        private int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f2872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f2873e;

        private a() {
        }
    }

    public static String a(File file) {
        return a(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    private static String b(File file, int i2, long j2) {
        return a(new com.ss.android.a.a(file), i2, j2);
    }

    public static String a(File file, int i2, long j2) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return b(file, i2, j2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    private static long b(String str) {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static int a(String str, File file) {
        return a(str, file, (b) null);
    }

    public static int a(String str, File file, b bVar) {
        String strB;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (bVar != null) {
                if (bVar.a() <= 0) {
                    try {
                        bVar.b();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            int i2 = -1;
            long j2 = -1;
            try {
                a aVarA = a(str);
                if (aVarA != null) {
                    if (aVarA.a > 1) {
                        return 3;
                    }
                    i2 = aVarA.f2871c;
                    j2 = aVarA.f2872d;
                }
                a aVarA2 = null;
                try {
                    if (bVar != null) {
                        strB = a(bVar, i2, j2);
                    } else {
                        strB = b(file, i2, j2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    strB = null;
                }
                if (strB != null && strB.length() != 0) {
                    if (aVarA != null && (aVarA.a != 1 || aVarA.f2870b != 1)) {
                        if (aVarA.f2873e != null) {
                            try {
                                aVarA2 = a(strB);
                            } catch (Throwable unused2) {
                            }
                            if (aVarA2 != null && aVarA.f2871c == aVarA2.f2871c && aVarA.f2872d == aVarA2.f2872d && aVarA.f2873e.equals(aVarA2.f2873e)) {
                                return 0;
                            }
                        }
                    } else if (strB.equals(str)) {
                        return 0;
                    }
                    return 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    private static String a(b bVar, int i2, long j2) throws NoSuchAlgorithmException {
        long j3;
        int i3 = i2;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long jA = bVar.a();
            if (i3 <= 0 || j2 <= 0 || ((long) i3) * j2 > (8 * jA) / 10) {
                j3 = jA;
                i3 = 1;
            } else {
                j3 = j2;
            }
            byte[] bArr = new byte[8192];
            long j4 = 0;
            a(bVar, messageDigest, bArr, 0L, j3);
            if (i3 > 2) {
                int i4 = i3 - 1;
                long j5 = (jA - (((long) i3) * j3)) / ((long) i4);
                int i5 = 1;
                while (i5 < i4) {
                    j4 += j3 + j5;
                    a(bVar, messageDigest, bArr, j4, j3);
                    i5++;
                    i4 = i4;
                }
            }
            if (i3 > 1) {
                a(bVar, messageDigest, bArr, jA - j3, j3);
            }
            String strA = a(messageDigest.digest());
            if (i3 == 1 && j3 == jA) {
                return strA;
            }
            String str = a(i3, j3) + ";" + strA;
            try {
                bVar.b();
            } catch (Throwable unused) {
            }
            return str;
        } finally {
            try {
                bVar.b();
            } catch (Throwable unused2) {
            }
        }
    }

    private static void a(b bVar, MessageDigest messageDigest, byte[] bArr, long j2, long j3) throws IOException {
        bVar.a(j2, j3);
        long j4 = 0;
        while (j4 < j3) {
            int iA = bVar.a(bArr, 0, (int) Math.min(j3 - j4, bArr.length));
            if (iA > 0) {
                messageDigest.update(bArr, 0, iA);
                j4 += (long) iA;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + iA + ", readTotalCount = " + j4 + ", sampleSize = " + j3);
            }
        }
    }

    private static String a(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        int length = bArr.length;
        int i2 = length * 2;
        char[] cArr = new char[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = bArr[i4 + 0] & ExifInterface.MARKER;
            int i6 = i3 + 1;
            char[] cArr2 = a;
            cArr[i3] = cArr2[i5 >> 4];
            i3 = i6 + 1;
            cArr[i6] = cArr2[i5 & 15];
        }
        return new String(cArr, 0, i2);
    }

    private static String a(int i2, long j2) {
        StringBuilder sbR = c.a.a.a.a.r("ttmd5:1:1:");
        sbR.append(a(i2));
        sbR.append("g");
        sbR.append(a(j2));
        return sbR.toString();
    }

    private static a a(String str) {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(";");
        String[] strArrSplit2 = strArrSplit[0].split(":");
        a aVar = new a();
        aVar.a = Integer.parseInt(strArrSplit2[1]);
        if (aVar.a > 1) {
            return aVar;
        }
        aVar.f2870b = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split("g");
        aVar.f2871c = (int) b(strArrSplit3[0]);
        aVar.f2872d = b(strArrSplit3[1]);
        aVar.f2873e = strArrSplit[1];
        return aVar;
    }

    private static String a(long j2) {
        return Long.toHexString((j2 << 4) + 31);
    }
}
