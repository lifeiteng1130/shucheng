package c.c.a.s;

import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.f;
import c.c.a.q;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusParam;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public static class a extends IOException {
        public a(String str, byte b2) {
            super(str);
        }

        public a(String str, Throwable th, byte b2) {
            super(str, th);
        }
    }

    public static void a(String str, int i2, @NonNull String str2, int i3, long j2, String str3, @Nullable Throwable th) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", f.t(Integer.valueOf(i2)));
            jSONObject.putOpt("plugin_package_name", f.t(str2));
            jSONObject.putOpt("version_code", f.t(Integer.valueOf(i3)));
            jSONObject3.putOpt("duration", f.t(Long.valueOf(j2)));
            jSONObject2.putOpt("throwable", f.u(th));
            jSONObject2.putOpt("timestamp", f.t(Long.valueOf(System.currentTimeMillis())));
            jSONObject2.putOpt("message", f.t(str3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c.c.a.d.b.a().b(str, jSONObject, jSONObject3, jSONObject2);
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0272 A[Catch: all -> 0x02d2, TryCatch #8 {all -> 0x02d2, blocks: (B:96:0x01e4, B:98:0x01f0, B:103:0x01f9, B:108:0x0226, B:110:0x022c, B:112:0x0234, B:115:0x023d, B:116:0x024d, B:117:0x0251, B:120:0x0268, B:126:0x0272, B:128:0x0282, B:129:0x0292, B:123:0x026e, B:119:0x0263), top: B:179:0x01e4, outer: #11, inners: #14 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(java.io.File r18, java.lang.String r19, int r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1013
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.s.b.b(java.io.File, java.lang.String, int):boolean");
    }

    public static void c(File file, String str, int i2) throws a {
        ZeusParam zeusParam = q.a().f779c;
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
            PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
            List listAsList = Arrays.asList(packageInfo.requestedPermissions);
            String[] strArr = packageArchiveInfo.requestedPermissions;
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str2 : packageArchiveInfo.requestedPermissions) {
                if (!listAsList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ZeusLogger.e("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
            if (zeusParam != null && zeusParam.checkPermission()) {
                throw new a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), (byte) 0);
            }
        } catch (Exception e2) {
            a("install_finish", 32002, str, i2, -1L, null, e2);
            throw new a("安装包权限校验失败", e2, (byte) 0);
        }
    }
}
