package com.umeng.analytics.pro;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.umeng.commonsdk.debug.UMLog;
import java.util.Objects;
import k.f.a.a.a.a;

/* JADX INFO: compiled from: OppoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class ad implements y {
    private boolean a = false;

    @Override // com.umeng.analytics.pro.y
    public String a(Context context) {
        PackageInfo packageInfo;
        try {
            if (!this.a) {
                a.b bVar = a.b.C0234b.a;
                Context applicationContext = context.getApplicationContext();
                Objects.requireNonNull(bVar);
                boolean z = false;
                try {
                    packageInfo = applicationContext.getPackageManager().getPackageInfo("com.heytap.openid", 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    if (packageInfo != null && packageInfo.getLongVersionCode() >= 1) {
                        z = true;
                    }
                    k.d.a.h.f8792b = z;
                    k.d.a.h.a = true;
                    this.a = true;
                } else {
                    if (packageInfo != null && packageInfo.versionCode >= 1) {
                        z = true;
                    }
                    k.d.a.h.f8792b = z;
                    k.d.a.h.a = true;
                    this.a = true;
                }
            }
            if (!k.d.a.h.a) {
                throw new RuntimeException("SDK Need Init First!");
            }
            if (k.d.a.h.f8792b) {
                return k.d.a.h.d(context);
            }
            UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            return null;
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
