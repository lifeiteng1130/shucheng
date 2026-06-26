package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.ss.android.socialbase.appdownloader.e.d;
import com.ss.android.socialbase.downloader.constants.e;
import com.ss.android.socialbase.downloader.downloader.c;

/* JADX INFO: compiled from: NotificationPermissionRequestFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Fragment {
    public static Intent d() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    private Context e() {
        Context contextN = c.N();
        return (contextN != null || getActivity() == null || getActivity().isFinishing()) ? contextN : getActivity().getApplicationContext();
    }

    private Intent f() {
        Context contextE = e();
        if (contextE == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = contextE.getPackageName();
        intent.putExtra(AbsServerManager.PACKAGE_QUERY_BINDER, packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i2 = contextE.getApplicationInfo().uid;
        intent.putExtra("uid", i2);
        intent.putExtra("app_uid", i2);
        return intent;
    }

    public void a() {
        try {
            try {
                try {
                    startActivityForResult(f(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(c(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(d(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(b(), 1000);
        }
    }

    public Intent b() {
        Context contextE = e();
        if (contextE == null) {
            return null;
        }
        String packageName = contextE.getPackageName();
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(e.f3504c)) {
                Intent intent = new Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
                return intent2;
            }
            if (lowerCase.contains("meizu") && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra("packageName", packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        StringBuilder sbR = c.a.a.a.a.r("package:");
        sbR.append(contextE.getPackageName());
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(sbR.toString()));
    }

    public Intent c() {
        Context contextE = e();
        if (contextE == null) {
            return null;
        }
        StringBuilder sbR = c.a.a.a.a.r("package:");
        sbR.append(contextE.getPackageName());
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(sbR.toString()));
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (d.a()) {
            d.a(true);
        } else {
            d.a(false);
        }
    }
}
