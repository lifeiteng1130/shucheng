package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: UMSLNetWorkSenderHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private String a = "10.0.0.172";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5236b = 80;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f5237c;

    public c(Context context) {
        this.f5237c = context;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f5237c, "sl_domain_p", "");
        if (TextUtils.isEmpty(strImprintProperty)) {
            return;
        }
        a.f5222i = DataHelper.assembleStatelessURL(strImprintProperty);
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f5237c, "sl_domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f5237c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.f5221h = DataHelper.assembleStatelessURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            a.f5224k = DataHelper.assembleStatelessURL(strImprintProperty2);
        }
        a.f5222i = a.f5224k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f5242b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f5242b.startsWith("460") || com.umeng.commonsdk.statistics.b.f5242b.startsWith("461")) {
            a.f5222i = a.f5221h;
        }
    }

    private boolean c() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        Context context = this.f5237c;
        if (context == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f5237c.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f5237c.getSystemService("connectivity");
            if (DeviceConfig.checkPermission(this.f5237c, "android.permission.ACCESS_NETWORK_STATE") && connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                    if (extraInfo.equals("uniwap")) {
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f5237c, th);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0139 A[PHI: r2 r4 r13
  0x0139: PHI (r2v2 boolean) = (r2v0 boolean), (r2v0 boolean), (r2v3 boolean) binds: [B:37:0x0125, B:46:0x0136, B:24:0x010c] A[DONT_GENERATE, DONT_INLINE]
  0x0139: PHI (r4v7 java.io.OutputStream) = (r4v5 java.io.OutputStream), (r4v6 java.io.OutputStream), (r4v8 java.io.OutputStream) binds: [B:37:0x0125, B:46:0x0136, B:24:0x010c] A[DONT_GENERATE, DONT_INLINE]
  0x0139: PHI (r13v7 ??) = (r13v5 javax.net.ssl.HttpsURLConnection), (r13v6 javax.net.ssl.HttpsURLConnection), (r13v8 ??) binds: [B:37:0x0125, B:46:0x0136, B:24:0x010c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v13, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [javax.net.ssl.HttpsURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(byte[] r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
