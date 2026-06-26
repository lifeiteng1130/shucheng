package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static List<File> a = new ArrayList();

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit == null || strArrSplit.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static String b(String str, String str2) {
        BufferedReader bufferedReaderA = ca.a(str, "map_record.txt");
        if (bufferedReaderA == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = bufferedReaderA.readLine();
            if (line != null && line.startsWith(str2)) {
                while (true) {
                    String line2 = bufferedReaderA.readLine();
                    if (line2 == null) {
                        break;
                    }
                    sb.append("  ");
                    sb.append(line2);
                    sb.append("\n");
                }
                return sb.toString();
            }
            try {
                bufferedReaderA.close();
            } catch (Exception e2) {
                X.b(e2);
            }
            return null;
        } catch (Throwable th) {
            try {
                X.b(th);
                try {
                    bufferedReaderA.close();
                } catch (Exception e3) {
                    X.b(e3);
                }
                return null;
            } finally {
                try {
                    bufferedReaderA.close();
                } catch (Exception e4) {
                    X.b(e4);
                }
            }
        }
    }

    private static String c(String str, String str2) {
        BufferedReader bufferedReaderA = ca.a(str, "reg_record.txt");
        if (bufferedReaderA == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = bufferedReaderA.readLine();
            if (line == null || !line.startsWith(str2)) {
                try {
                    bufferedReaderA.close();
                } catch (Exception e2) {
                    X.b(e2);
                }
                return null;
            }
            int i2 = 18;
            int i3 = 0;
            int length = 0;
            while (true) {
                String line2 = bufferedReaderA.readLine();
                if (line2 == null) {
                    break;
                }
                if (i3 % 4 == 0) {
                    if (i3 > 0) {
                        sb.append("\n");
                    }
                    sb.append("  ");
                } else {
                    if (line2.length() > 16) {
                        i2 = 28;
                    }
                    sb.append("                ".substring(0, i2 - length));
                }
                length = line2.length();
                sb.append(line2);
                i3++;
            }
            sb.append("\n");
            return sb.toString();
        } catch (Throwable th) {
            try {
                X.b(th);
                try {
                    bufferedReaderA.close();
                } catch (Exception e3) {
                    X.b(e3);
                }
                return null;
            } finally {
                try {
                    bufferedReaderA.close();
                } catch (Exception e4) {
                    X.b(e4);
                }
            }
        }
    }

    public static Map<String, Integer> d(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            for (String str2 : str.split(",")) {
                String[] strArrSplit = str2.split(":");
                if (strArrSplit.length != 2) {
                    X.b("error format at %s", str2);
                    return null;
                }
                map.put(strArrSplit[0], Integer.valueOf(Integer.parseInt(strArrSplit[1])));
            }
            return map;
        } catch (Exception e2) {
            X.b("error format intStateStr %s", str);
            e2.printStackTrace();
            return null;
        }
    }

    public static CrashDetailBean a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        Map<String, String> map2;
        if (map == null) {
            return null;
        }
        if (com.tencent.bugly.crashreport.common.info.a.a(context) == null) {
            X.b("abnormal com info not created", new Object[0]);
            return null;
        }
        String str3 = map.get("intStateStr");
        if (str3 != null && str3.trim().length() > 0) {
            Map<String, Integer> mapD = d(str3);
            if (mapD == null) {
                X.b("parse intSateMap fail", Integer.valueOf(map.size()));
                return null;
            }
            try {
                mapD.get("sino").intValue();
                mapD.get("sud").intValue();
                String str4 = map.get("soVersion");
                if (TextUtils.isEmpty(str4)) {
                    X.b("error format at version", new Object[0]);
                    return null;
                }
                String str5 = map.get("errorAddr");
                String str6 = EnvironmentCompat.MEDIA_UNKNOWN;
                String str7 = str5 == null ? EnvironmentCompat.MEDIA_UNKNOWN : str5;
                String str8 = map.get("codeMsg");
                if (str8 == null) {
                    str8 = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                String str9 = map.get("tombPath");
                String str10 = str9 == null ? EnvironmentCompat.MEDIA_UNKNOWN : str9;
                String str11 = map.get("signalName");
                if (str11 == null) {
                    str11 = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                map.get("errnoMsg");
                String string = map.get("stack");
                if (string == null) {
                    string = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                String str12 = map.get("jstack");
                if (str12 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append("java:\n");
                    sb.append(str12);
                    string = sb.toString();
                }
                Integer num = mapD.get("sico");
                if (num == null || num.intValue() <= 0) {
                    str = str8;
                    str2 = str11;
                } else {
                    str2 = str11 + "(" + str8 + ")";
                    str = "KERNEL";
                }
                String str13 = map.get("nativeLog");
                byte[] bArrA = (str13 == null || str13.isEmpty()) ? null : ca.a((File) null, str13, "BuglyNativeLog.txt");
                String str14 = map.get("sendingProcess");
                if (str14 == null) {
                    str14 = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                Integer num2 = mapD.get("spd");
                if (num2 != null) {
                    str14 = str14 + "(" + num2 + ")";
                }
                String str15 = str14;
                String str16 = map.get("threadName");
                if (str16 == null) {
                    str16 = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                Integer num3 = mapD.get("et");
                if (num3 != null) {
                    str16 = str16 + "(" + num3 + ")";
                }
                String str17 = str16;
                String str18 = map.get("processName");
                if (str18 != null) {
                    str6 = str18;
                }
                Integer num4 = mapD.get("ep");
                if (num4 != null) {
                    str6 = str6 + "(" + num4 + ")";
                }
                String str19 = str6;
                String str20 = map.get("key-value");
                if (str20 != null) {
                    HashMap map3 = new HashMap();
                    for (String str21 : str20.split("\n")) {
                        String[] strArrSplit = str21.split("=");
                        if (strArrSplit.length == 2) {
                            map3.put(strArrSplit[0], strArrSplit[1]);
                        }
                    }
                    map2 = map3;
                } else {
                    map2 = null;
                }
                CrashDetailBean crashDetailBeanPackageCrashDatas = nativeExceptionHandler.packageCrashDatas(str19, str17, (((long) mapD.get("etms").intValue()) / 1000) + (((long) mapD.get("ets").intValue()) * 1000), str2, str7, a(string), str, str15, str10, map.get("sysLogPath"), map.get("jniLogPath"), str4, bArrA, map2, false, false);
                if (crashDetailBeanPackageCrashDatas != null) {
                    String str22 = map.get("userId");
                    if (str22 != null) {
                        X.a("[Native record info] userId: %s", str22);
                        crashDetailBeanPackageCrashDatas.m = str22;
                    }
                    String str23 = map.get("sysLog");
                    if (str23 != null) {
                        crashDetailBeanPackageCrashDatas.w = str23;
                    }
                    String str24 = map.get("appVersion");
                    if (str24 != null) {
                        X.a("[Native record info] appVersion: %s", str24);
                        crashDetailBeanPackageCrashDatas.f4134f = str24;
                    }
                    String str25 = map.get("isAppForeground");
                    if (str25 != null) {
                        X.a("[Native record info] isAppForeground: %s", str25);
                        crashDetailBeanPackageCrashDatas.O = str25.equalsIgnoreCase("true");
                    }
                    String str26 = map.get("launchTime");
                    if (str26 != null) {
                        X.a("[Native record info] launchTime: %s", str26);
                        try {
                            crashDetailBeanPackageCrashDatas.N = Long.parseLong(str26);
                        } catch (NumberFormatException e2) {
                            if (!X.b(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    crashDetailBeanPackageCrashDatas.z = null;
                    crashDetailBeanPackageCrashDatas.f4139k = true;
                }
                return crashDetailBeanPackageCrashDatas;
            } catch (Throwable th) {
                X.b("error format", new Object[0]);
                th.printStackTrace();
                return null;
            }
        }
        X.b("no intStateStr", new Object[0]);
        return null;
    }

    public static void b(String str) {
        File[] fileArrListFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        X.a("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            X.b(th);
        }
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static String a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int i2 = bufferedInputStream.read();
                    if (i2 == -1) {
                        break;
                    }
                    if (i2 == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    }
                    byteArrayOutputStream.write(i2);
                } catch (Throwable th) {
                    th = th;
                    try {
                        X.b(th);
                        return null;
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) throws Throwable {
        BufferedInputStream bufferedInputStream;
        String str2;
        String strA;
        ?? r1 = 0;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                ?? CanRead = file.canRead();
                try {
                    if (CanRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                            try {
                                String strA2 = a(bufferedInputStream);
                                if (strA2 != null && strA2.equals("NATIVE_RQD_REPORT")) {
                                    HashMap map = new HashMap();
                                    loop0: while (true) {
                                        str2 = null;
                                        while (true) {
                                            strA = a(bufferedInputStream);
                                            if (strA == null) {
                                                break loop0;
                                            }
                                            if (str2 == null) {
                                                str2 = strA;
                                            }
                                        }
                                        map.put(str2, strA);
                                    }
                                    if (str2 != null) {
                                        X.b("record not pair! drop! %s", str2);
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                        return null;
                                    }
                                    CrashDetailBean crashDetailBeanA = a(context, map, nativeExceptionHandler);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                    return crashDetailBeanA;
                                }
                                X.b("record read fail! %s", strA2);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                return null;
                            } catch (IOException e5) {
                                e = e5;
                                e.printStackTrace();
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                return null;
                            }
                        } catch (IOException e7) {
                            e = e7;
                            bufferedInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (r1 != 0) {
                                try {
                                    r1.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r1 = CanRead;
                }
            }
            return null;
        }
        X.b("get eup record file args error", new Object[0]);
        return null;
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String strC = c(str, str2);
        if (strC != null && !strC.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(strC);
        }
        String strB = b(str, str2);
        if (strB != null && !strB.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(strB);
        }
        return sb.toString();
    }

    public static void a(boolean z, String str) {
        if (str != null) {
            a.add(new File(str, "rqd_record.eup"));
            a.add(new File(str, "reg_record.txt"));
            a.add(new File(str, "map_record.txt"));
            a.add(new File(str, "backup_record.txt"));
            if (z) {
                b(str);
            }
        }
        List<File> list = a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                X.a("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    public static String a(String str, int i2, String str2, boolean z) {
        BufferedReader bufferedReader = null;
        if (str != null && i2 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                X.c("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                a.add(file);
                X.a("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return ca.a(new File(str), i2, z);
                }
                String sb = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str2);
                                sb2.append("[ ]*:");
                                if (Pattern.compile(sb2.toString()).matcher(line).find()) {
                                    sb.append(line);
                                    sb.append("\n");
                                }
                                if (i2 > 0 && sb.length() > i2) {
                                    if (z) {
                                        sb.delete(i2, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i2);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    X.b(th);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("\n[error:");
                                    sb3.append(th.toString());
                                    sb3.append("]");
                                    sb.append(sb3.toString());
                                    String string = sb.toString();
                                    if (bufferedReader == null) {
                                        return string;
                                    }
                                    bufferedReader.close();
                                    sb = string;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e2) {
                                            X.b(e2);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String string2 = sb.toString();
                        bufferedReader2.close();
                        sb = string2;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    return sb;
                } catch (Exception e3) {
                    X.b(e3);
                    return sb;
                }
            }
        }
        return null;
    }
}
