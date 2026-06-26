package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.X;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class TraceFileHelper {

    /* JADX INFO: compiled from: BUGLY */
    public static class a {
        public long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f4142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f4143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String[]> f4144d;
    }

    /* JADX INFO: compiled from: BUGLY */
    public interface b {
        boolean a(long j2);

        boolean a(long j2, long j3, String str);

        boolean a(String str, int i2, String str2, String str3, boolean z);

        boolean a(String str, long j2, long j3);
    }

    public static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null) {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                for (Pattern pattern : patternArr) {
                    if (pattern.matcher(line).matches()) {
                        return new Object[]{pattern, line};
                    }
                }
            }
        }
        return null;
    }

    public static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 3; i2++) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, boolean z) throws Throwable {
        if (str == null) {
            X.b("path:%s", str);
            return null;
        }
        a aVar = new a();
        readTraceFile(str, new j(aVar, z));
        if (aVar.a > 0 && aVar.f4143c > 0 && aVar.f4142b != null) {
            return aVar;
        }
        X.b("first dump error %s", aVar.a + " " + aVar.f4143c + " " + aVar.f4142b);
        return null;
    }

    public static a readTargetDumpInfo(String str, String str2, boolean z) throws Throwable {
        if (str != null && str2 != null) {
            a aVar = new a();
            readTraceFile(str2, new i(aVar, str, z));
            if (aVar.a > 0 && aVar.f4143c > 0 && aVar.f4142b != null) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x014a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0150, code lost:
    
        if (com.tencent.bugly.proguard.X.b(r0) == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0152, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0155, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void readTraceFile(java.lang.String r18, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readTraceFile(java.lang.String, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b):void");
    }

    public static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }
}
