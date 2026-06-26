package com.tencent.bugly.proguard;

import android.text.TextUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class Y {
    private static Proxy a;

    public static void a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            a = null;
        } else {
            a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        }
    }

    public static void a(InetAddress inetAddress, int i2) {
        if (inetAddress == null) {
            a = null;
        } else {
            a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i2));
        }
    }

    public static Proxy a() {
        return a;
    }
}
