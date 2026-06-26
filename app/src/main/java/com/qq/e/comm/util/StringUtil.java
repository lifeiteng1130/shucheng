package com.qq.e.comm.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class StringUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String join(String str, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (str != null && i2 != 0) {
                    stringBuffer.append(str);
                }
                stringBuffer.append(strArr[i2]);
            }
        }
        return stringBuffer.toString();
    }

    public static float parseFloat(String str, float f2) {
        try {
            return Float.parseFloat(str);
        } catch (Throwable unused) {
            return f2;
        }
    }

    public static int parseInteger(String str, int i2) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String readAll(java.io.File r4) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Exception while close bufferreader"
            r1 = 0
            if (r4 == 0) goto L48
            boolean r2 = r4.exists()
            if (r2 != 0) goto Lc
            goto L48
        Lc:
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L3a
            r1.<init>()     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L3a
        L1b:
            java.lang.String r2 = r4.readLine()     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L3a
            if (r2 == 0) goto L25
            r1.append(r2)     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L3a
            goto L1b
        L25:
            java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L3a
            r4.close()     // Catch: java.lang.Exception -> L2d
            goto L30
        L2d:
            com.qq.e.comm.util.GDTLogger.d(r0)
        L30:
            return r1
        L31:
            r1 = move-exception
            goto L39
        L33:
            r4 = move-exception
            goto L3e
        L35:
            r4 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
        L39:
            throw r1     // Catch: java.lang.Throwable -> L3a
        L3a:
            r1 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
        L3e:
            if (r1 == 0) goto L47
            r1.close()     // Catch: java.lang.Exception -> L44
            goto L47
        L44:
            com.qq.e.comm.util.GDTLogger.d(r0)
        L47:
            throw r4
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.StringUtil.readAll(java.io.File):java.lang.String");
    }

    public static void writeTo(String str, File file) throws IOException {
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(str);
        fileWriter.close();
    }
}
