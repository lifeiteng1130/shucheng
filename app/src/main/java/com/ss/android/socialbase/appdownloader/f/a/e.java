package com.ss.android.socialbase.appdownloader.f.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PackageInfoUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
    
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
    
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.pm.PackageInfo a(@androidx.annotation.NonNull java.io.File r13) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.a.e.a(java.io.File):android.content.pm.PackageInfo");
    }

    private static String a(int i2) {
        return (i2 >>> 24) == 1 ? "android:" : "";
    }

    private static PackageInfo b(@NonNull Context context, @NonNull File file, int i2) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            a("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i2);
        } catch (Throwable th) {
            StringBuilder sbR = c.a.a.a.a.r("pm.getPackageArchiveInfo failed: ");
            sbR.append(th.getMessage());
            a("unzip_getpackagearchiveinfo", sbR.toString());
            return null;
        }
    }

    public static PackageInfo a(@NonNull Context context, @NonNull File file, int i2) {
        if (com.ss.android.socialbase.downloader.i.a.a(268435456) && Build.VERSION.SDK_INT < 26) {
            try {
                return a(file);
            } catch (Throwable th) {
                a("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                return b(context, file, i2);
            }
        }
        return b(context, file, i2);
    }

    private static void a(@NonNull String str, @NonNull String str2) {
        com.ss.android.socialbase.downloader.d.b bVarG = com.ss.android.socialbase.downloader.downloader.c.g();
        if (bVarG == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (JSONException unused) {
        }
        bVarG.a(str, jSONObject, null, null);
    }

    private static String a(a aVar, int i2) {
        int iB = aVar.b(i2);
        int iC = aVar.c(i2);
        if (iB == 3) {
            return aVar.d(i2);
        }
        return iB == 2 ? String.format("?%s%08X", a(iC), Integer.valueOf(iC)) : (iB < 16 || iB > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(iC), Integer.valueOf(iB)) : String.valueOf(iC);
    }

    public static String a(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e2) {
            a("getPackageInfo::fail_load_label", e2.getMessage());
            return null;
        }
    }
}
