package com.efs.sdk.base.a.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static NetworkInfo a(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                d.a("efs.base", "get CONNECTIVITY_SERVICE is null", null);
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if ((activeNetworkInfo != null && activeNetworkInfo.isConnected()) || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
                return activeNetworkInfo;
            }
            for (int i2 = 0; i2 < allNetworkInfo.length; i2++) {
                if (allNetworkInfo[i2] != null && allNetworkInfo[i2].isConnected()) {
                    return allNetworkInfo[i2];
                }
            }
            return activeNetworkInfo;
        } catch (Throwable th) {
            d.b("efs.base", "get network info error", th);
            return null;
        }
    }

    public static String b(Context context) {
        if (d(context)) {
            return "denied";
        }
        NetworkInfo networkInfoA = a(context);
        if (networkInfoA == null) {
            return "disconnected";
        }
        if (networkInfoA.getType() == 1) {
            return "wifi";
        }
        int subtype = networkInfoA.getSubtype();
        if (subtype == 20) {
            return "5g";
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                String subtypeName = networkInfoA.getSubtypeName();
                return TextUtils.isEmpty(subtypeName) ? EnvironmentCompat.MEDIA_UNKNOWN : (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "3g" : subtypeName;
        }
    }

    private static boolean c(Context context) {
        return context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0;
    }

    private static boolean d(Context context) {
        return !c(context);
    }
}
