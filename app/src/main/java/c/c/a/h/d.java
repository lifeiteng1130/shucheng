package c.c.a.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public class d {

    public enum a {
        UNKNOWN(-1),
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);


        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f723h;

        a(int i2) {
            this.f723h = i2;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static a a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return a.WIFI;
                }
                if (type != 0) {
                    return a.MOBILE;
                }
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return a.MOBILE_3G;
                    case 4:
                    case 7:
                    case 11:
                    default:
                        return a.MOBILE;
                    case 13:
                        return a.MOBILE_4G;
                }
            }
            return a.NONE;
        } catch (Throwable unused) {
            return a.MOBILE;
        }
    }
}
