package com.qq.e.comm.managers.status;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import c.a.a.a.a;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import h.a.a.a.n;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class DeviceStatus {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f2839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f2841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AtomicInteger f2843k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f2844l;
    public final String model = Build.MODEL;

    public DeviceStatus(Context context) {
        this.f2844l = context.getApplicationContext();
        a(context);
    }

    private int a(float f2, int i2) {
        return (this.f2844l.getApplicationInfo().flags & 8192) != 0 ? (int) (i2 / f2) : i2;
    }

    private void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f2836d = getVersion() > 3 ? displayMetrics.densityDpi : 120;
        this.f2834b = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.widthPixels) : displayMetrics.widthPixels;
        this.f2835c = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.heightPixels) : displayMetrics.heightPixels;
    }

    public Carrier getCarrier() {
        String operator = getOperator();
        if (operator != null) {
            if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007") || operator.equals("46020")) {
                return Carrier.CMCC;
            }
            if (operator.equals("46001") || operator.equals("46006")) {
                return Carrier.UNICOM;
            }
            if (operator.equals("46003") || operator.equals("46005")) {
                return Carrier.TELECOM;
            }
        }
        return Carrier.UNKNOWN;
    }

    public String getDataNet() {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) this.f2844l.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        String str = type != 0 ? type != 1 ? "unknow" : "wi" : "ed";
        this.f2840h = str;
        return str;
    }

    public int getDeviceDensity() {
        return this.f2836d;
    }

    public int getDeviceHeight() {
        return this.f2835c;
    }

    public String getDeviceId() {
        String str = "";
        if (!GlobalSetting.isAgreePrivacyStrategy()) {
            return "";
        }
        String str2 = this.f2841i;
        if (str2 != null) {
            return str2;
        }
        if (GDTADManager.getInstance().getSM().getInteger("imeion", 1) != 1 || !hasReadPhoneStatePermission()) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f2844l.getSystemService("phone");
            String deviceId = telephonyManager == null ? null : telephonyManager.getDeviceId();
            this.f2841i = deviceId;
            if (deviceId != null) {
                str = deviceId;
            }
            this.f2841i = str;
        } catch (Exception e2) {
            StringBuilder sbR = a.r("Get imei encounter error: ");
            sbR.append(e2.getMessage());
            GDTLogger.d(sbR.toString());
        }
        return this.f2841i;
    }

    public String getDeviceIdMD5() {
        String deviceId = getDeviceId();
        return TextUtils.isEmpty(deviceId) ? "" : Md5Util.encode(deviceId.toLowerCase());
    }

    public int getDeviceWidth() {
        return this.f2834b;
    }

    public Map<String, String> getLacAndCeilId() {
        int i2;
        GsmCellLocation gsmCellLocation;
        int cid;
        int networkId;
        String operator = getOperator();
        HashMap map = new HashMap();
        if (GDTADManager.getInstance().getSM().getInteger("cellon", 1) == 1 && this.f2844l.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && !StringUtil.isEmpty(operator) && !"null".equalsIgnoreCase(operator)) {
            int i3 = 0;
            try {
                if (Integer.parseInt(operator.substring(0, 3)) == 460) {
                    TelephonyManager telephonyManager = (TelephonyManager) this.f2844l.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        networkId = cdmaCellLocation.getNetworkId();
                        cid = cdmaCellLocation.getBaseStationId();
                    } else if (!(cellLocation instanceof GsmCellLocation) || (gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation()) == null) {
                        i2 = 0;
                        map.put("lac", i3 + "");
                        map.put("cellid", "" + i2);
                    } else {
                        int lac = gsmCellLocation.getLac();
                        cid = gsmCellLocation.getCid();
                        networkId = lac;
                    }
                    int i4 = cid;
                    i3 = networkId;
                    i2 = i4;
                    map.put("lac", i3 + "");
                    map.put("cellid", "" + i2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return map;
    }

    public String getLanguage() {
        if (this.a == null) {
            String lowerCase = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            this.a = lowerCase;
            if (lowerCase.length() == 0) {
                this.a = n.DEFAULT_LANGUAGE;
            }
        }
        return this.a;
    }

    public NetworkType getNetworkType() {
        int i2;
        String dataNet = getDataNet();
        if (dataNet != null && dataNet.equals("wi")) {
            return NetworkType.WIFI;
        }
        try {
            i2 = Integer.parseInt(getPhoneNet());
        } catch (NumberFormatException unused) {
            i2 = 0;
        }
        switch (i2) {
            case 1:
            case 2:
            case 16:
                return NetworkType.NET_2G;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 17:
                return NetworkType.NET_3G;
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
                return NetworkType.NET_4G;
            default:
                return NetworkType.UNKNOWN;
        }
    }

    public String getOS() {
        return "android";
    }

    public String getOperator() {
        try {
            this.f2838f = ((TelephonyManager) this.f2844l.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
        }
        return this.f2838f;
    }

    public String getPhoneNet() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                int networkType = ((TelephonyManager) appContext.getSystemService("phone")).getNetworkType();
                if (networkType == 0) {
                    networkType = activeNetworkInfo.getSubtype();
                }
                this.f2839g = "" + networkType;
            }
        } catch (Exception unused) {
        }
        return this.f2839g;
    }

    public String getScreenOrientation() {
        this.f2837e = this.f2844l.getResources().getConfiguration().orientation == 2 ? Constants.LANDSCAPE : "p";
        return this.f2837e;
    }

    public int getVersion() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception unused) {
            return 3;
        }
    }

    public boolean hasReadPhoneStatePermission() {
        if (Build.VERSION.SDK_INT < 23) {
            this.f2842j = true;
            return true;
        }
        if (this.f2843k == null) {
            this.f2843k = new AtomicInteger(GDTADManager.getInstance().getSM().getInteger("rpspc", Integer.MAX_VALUE));
        }
        if (this.f2843k.getAndDecrement() > 0) {
            this.f2842j = this.f2844l.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
        }
        return this.f2842j;
    }
}
