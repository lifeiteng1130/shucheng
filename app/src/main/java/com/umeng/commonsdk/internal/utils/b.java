package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.common.ULog;

/* JADX INFO: compiled from: BaseStationUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5174b = "BaseStationUtils";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f5175c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f5176d;
    public PhoneStateListener a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TelephonyManager f5177e;

    /* JADX INFO: compiled from: BaseStationUtils.java */
    public static class a {
        private static final b a = new b(b.f5176d);

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) f5176d.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String simOperator = telephonyManager.getSimOperator();
            if (TextUtils.isEmpty(simOperator)) {
                return null;
            }
            if (!simOperator.equals("46000") && !simOperator.equals("46002")) {
                if (simOperator.equals("46001")) {
                    return "中国联通";
                }
                if (simOperator.equals("46003")) {
                    return "中国电信";
                }
                return null;
            }
            return "中国移动";
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized void c() {
        ULog.e(f5174b, "base station unRegisterListener");
        try {
            TelephonyManager telephonyManager = this.f5177e;
            if (telephonyManager != null) {
                telephonyManager.listen(this.a, 0);
            }
            f5175c = false;
        } catch (Throwable unused) {
        }
    }

    private b(Context context) {
        this.a = new PhoneStateListener() { // from class: com.umeng.commonsdk.internal.utils.b.1
            @Override // android.telephony.PhoneStateListener
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                String str;
                super.onSignalStrengthsChanged(signalStrength);
                ULog.e(b.f5174b, "base station onSignalStrengthsChanged");
                try {
                    b.this.f5177e = (TelephonyManager) b.f5176d.getSystemService("phone");
                    String[] strArrSplit = signalStrength.toString().split(" ");
                    String str2 = null;
                    if (b.this.f5177e != null && b.this.f5177e.getNetworkType() == 13) {
                        str = "" + Integer.parseInt(strArrSplit[9]);
                    } else if (b.this.f5177e == null || !(b.this.f5177e.getNetworkType() == 8 || b.this.f5177e.getNetworkType() == 10 || b.this.f5177e.getNetworkType() == 9 || b.this.f5177e.getNetworkType() == 3)) {
                        str = ((signalStrength.getGsmSignalStrength() * 2) - 113) + "";
                    } else {
                        String strE = b.this.e();
                        if (!TextUtils.isEmpty(strE) && strE.equals("中国移动")) {
                            str2 = "0";
                        } else if (!TextUtils.isEmpty(strE) && strE.equals("中国联通")) {
                            str2 = signalStrength.getCdmaDbm() + "";
                        } else if (!TextUtils.isEmpty(strE) && strE.equals("中国电信")) {
                            str2 = signalStrength.getEvdoDbm() + "";
                        }
                        str = str2;
                    }
                    ULog.e(b.f5174b, "stationStrength is " + str);
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            UMWorkDispatch.sendEvent(b.f5176d, com.umeng.commonsdk.internal.a.f5147i, com.umeng.commonsdk.internal.b.a(b.f5176d).a(), str);
                        } catch (Throwable unused) {
                        }
                    }
                    b.this.c();
                } catch (Exception unused2) {
                }
            }
        };
        if (context != null) {
            try {
                this.f5177e = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void b() {
        ULog.e(f5174b, "base station registerListener");
        try {
            TelephonyManager telephonyManager = this.f5177e;
            if (telephonyManager != null) {
                telephonyManager.listen(this.a, 256);
            }
            f5175c = true;
        } catch (Throwable unused) {
        }
    }

    public static b a(Context context) {
        if (f5176d == null && context != null) {
            f5176d = context.getApplicationContext();
        }
        return a.a;
    }

    public synchronized boolean a() {
        return f5175c;
    }
}
