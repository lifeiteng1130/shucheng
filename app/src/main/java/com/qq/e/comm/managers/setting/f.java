package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.util.Objects;
import org.jsoup.helper.DataUtil;

/* JADX INFO: loaded from: classes.dex */
public class f {

    public static class b<T> {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f2831b;

        private b(String str, T t) {
            this.a = str;
            this.f2831b = t;
        }

        public T a() {
            return this.f2831b;
        }

        public String b() {
            return this.a;
        }
    }

    private static Pair<String, String> a(Context context, String str) throws Throwable {
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
        if (!dir.exists()) {
            return null;
        }
        File file = new File(dir, c.a.a.a.a.i(str, ".sig"));
        File file2 = new File(dir, c.a.a.a.a.i(str, ".cfg"));
        if (file.exists() && file2.exists()) {
            try {
                String all = StringUtil.readAll(file);
                String all2 = StringUtil.readAll(file2);
                if (!TextUtils.isEmpty(all) && !TextUtils.isEmpty(all2)) {
                    com.qq.e.comm.util.a aVarA = com.qq.e.comm.util.a.a();
                    Objects.requireNonNull(aVarA);
                    if (aVarA.a(all, Md5Util.encode(all2))) {
                        return new Pair<>(all, new String(Base64.decode(all2, 0), DataUtil.defaultCharset));
                    }
                }
                GDTLogger.d("verify " + str + " setting fail");
            } catch (Exception unused) {
                GDTLogger.d("exception while loading local " + str);
            }
        }
        return null;
    }

    public static b<com.qq.e.comm.managers.setting.a> a(Context context) {
        Pair<String, String> pairA = a(context, "devCloudSetting");
        if (pairA == null) {
            return null;
        }
        return new b<>((String) pairA.first, new com.qq.e.comm.managers.setting.a((String) pairA.second));
    }

    public static boolean a(Context context, String str, String str2) {
        return a(context, "devCloudSetting", str, str2);
    }

    public static b<d> b(Context context) {
        Pair<String, String> pairA = a(context, "placementCloudSetting");
        if (pairA == null) {
            return null;
        }
        return new b<>((String) pairA.first, new d((String) pairA.second));
    }

    public static boolean b(Context context, String str, String str2) {
        return a(context, "placementCloudSetting", str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0071 A[Catch: Exception -> 0x0074, TRY_LEAVE, TryCatch #8 {Exception -> 0x0074, blocks: (B:29:0x006c, B:31:0x0071), top: B:41:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean b(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "e_qq_com_setting"
            java.lang.String r0 = com.qq.e.comm.util.SystemUtil.buildNewPathByProcessName(r0)
            r1 = 0
            java.io.File r5 = r5.getDir(r0, r1)
            boolean r0 = r5.exists()
            if (r0 != 0) goto L14
            r5.mkdirs()
        L14:
            java.io.File r0 = new java.io.File
            java.lang.String r2 = ".cfg"
            java.lang.String r2 = c.a.a.a.a.i(r6, r2)
            r0.<init>(r5, r2)
            java.io.File r2 = new java.io.File
            java.lang.String r3 = ".sig"
            java.lang.String r6 = c.a.a.a.a.i(r6, r3)
            r2.<init>(r5, r6)
            r5 = 0
            java.io.FileWriter r6 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            r6.write(r8)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4f
            java.io.FileWriter r8 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4f
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4f
            r8.write(r7)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            r5 = 1
            r6.close()     // Catch: java.lang.Exception -> L42
            r8.close()     // Catch: java.lang.Exception -> L42
        L42:
            return r5
        L43:
            r5 = move-exception
            r7 = r5
            r5 = r6
            r6 = r8
            goto L6a
        L48:
            r5 = r8
            goto L4f
        L4a:
            r7 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
            goto L6a
        L4f:
            r4 = r6
            r6 = r5
            r5 = r4
            goto L58
        L53:
            r6 = move-exception
            r7 = r6
            r6 = r5
            goto L6a
        L57:
            r6 = r5
        L58:
            r0.delete()     // Catch: java.lang.Throwable -> L69
            r2.delete()     // Catch: java.lang.Throwable -> L69
            if (r5 == 0) goto L63
            r5.close()     // Catch: java.lang.Exception -> L68
        L63:
            if (r6 == 0) goto L68
            r6.close()     // Catch: java.lang.Exception -> L68
        L68:
            return r1
        L69:
            r7 = move-exception
        L6a:
            if (r5 == 0) goto L6f
            r5.close()     // Catch: java.lang.Exception -> L74
        L6f:
            if (r6 == 0) goto L74
            r6.close()     // Catch: java.lang.Exception -> L74
        L74:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.setting.f.b(android.content.Context, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public static b<e> c(Context context) {
        Pair<String, String> pairA = a(context, "sdkCloudSetting");
        if (pairA == null) {
            return null;
        }
        return new b<>((String) pairA.first, new e((String) pairA.second));
    }

    public static boolean c(Context context, String str, String str2) {
        return a(context, "sdkCloudSetting", str, str2);
    }

    private static final boolean a(Context context, String str, String str2, String str3) {
        if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(str3)) {
            com.qq.e.comm.util.a aVarA = com.qq.e.comm.util.a.a();
            Objects.requireNonNull(aVarA);
            if (aVarA.a(str2, Md5Util.encode(str3))) {
                return b(context, str, str2, str3);
            }
            GDTLogger.d(String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", str, str2, str3));
            return false;
        }
        GDTLogger.d(String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", str, str2, str3));
        return false;
    }
}
