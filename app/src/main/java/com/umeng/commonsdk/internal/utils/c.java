package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONObject;

/* JADX INFO: compiled from: BatteryUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static final String a = "BatteryUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5178b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f5179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f5180d;

    /* JADX INFO: compiled from: BatteryUtils.java */
    public static class a {
        private static final c a = new c();

        private a() {
        }
    }

    public static c a(Context context) {
        if (f5179c == null && context != null) {
            f5179c = context.getApplicationContext();
        }
        return a.a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f5179c.registerReceiver(this.f5180d, intentFilter);
            f5178b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f5179c, th);
        }
    }

    public synchronized void c() {
        try {
            f5179c.unregisterReceiver(this.f5180d);
            f5178b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f5179c, th);
        }
    }

    private c() {
        this.f5180d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("le", intent.getIntExtra("level", 0));
                        } catch (Exception unused) {
                        }
                        try {
                            jSONObject.put("vol", intent.getIntExtra("voltage", 0));
                        } catch (Exception unused2) {
                        }
                        try {
                            jSONObject.put("temp", intent.getIntExtra("temperature", 0));
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused3) {
                        }
                        int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0);
                        int i2 = -1;
                        int i3 = 2;
                        if (intExtra != 1) {
                            if (intExtra == 2) {
                                i2 = 1;
                            } else if (intExtra == 4) {
                                i2 = 0;
                            } else if (intExtra == 5) {
                                i2 = 2;
                            }
                        }
                        try {
                            jSONObject.put("st", i2);
                        } catch (Exception unused4) {
                        }
                        int intExtra2 = intent.getIntExtra("plugged", 0);
                        if (intExtra2 == 1) {
                            i3 = 1;
                        } else if (intExtra2 != 2) {
                            i3 = 0;
                        }
                        try {
                            jSONObject.put("ct", i3);
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused5) {
                        }
                        ULog.i(c.a, jSONObject.toString());
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f5146h, com.umeng.commonsdk.internal.b.a(c.f5179c).a(), jSONObject.toString());
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.f5179c, th);
                }
            }
        };
    }

    public synchronized boolean a() {
        return f5178b;
    }
}
