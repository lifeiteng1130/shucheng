package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.T;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {
    private static BuglyBroadcastReceiver a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f4127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4129e = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IntentFilter f4126b = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        if (a == null) {
            a = new BuglyBroadcastReceiver();
        }
        return a;
    }

    public synchronized void addFilter(String str) {
        if (!this.f4126b.hasAction(str)) {
            this.f4126b.addAction(str);
        }
        X.a("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(Context context) {
        this.f4127c = context;
        ca.a(new a(this, this));
    }

    public synchronized void unregister(Context context) {
        try {
            X.c(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f4127c = context;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
    }

    public final synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f4129e) {
                    this.f4129e = false;
                    return true;
                }
                String strC = com.tencent.bugly.crashreport.common.info.b.c(this.f4127c);
                X.a("is Connect BC " + strC, new Object[0]);
                X.c("network %s changed to %s", "" + this.f4128d, "" + strC);
                if (strC == null) {
                    this.f4128d = null;
                    return true;
                }
                String str = this.f4128d;
                this.f4128d = strC;
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.c cVarB = com.tencent.bugly.crashreport.common.strategy.c.b();
                T tA = T.a();
                com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (cVarB != null && tA != null && aVarA != null) {
                    if (!strC.equals(str) && jCurrentTimeMillis - tA.b(h.a) > 30000) {
                        X.c("try to upload crash on network changed.", new Object[0]);
                        h hVarG = h.g();
                        if (hVarG != null) {
                            hVarG.a(0L);
                        }
                        X.c("try to upload userinfo on network changed.", new Object[0]);
                        com.tencent.bugly.crashreport.biz.f.f4085i.b();
                    }
                    return true;
                }
                X.e("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
